document.addEventListener('DOMContentLoaded', () => {

    // 로그인 및 회원가입 동작
    const authForm = document.getElementById('auth-form');
    const loginBtn = document.getElementById('login-btn');
    const registerBtn = document.getElementById('register-btn');

    authForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        if (e.submitter.id === 'login-btn') {
            // 로그인 동작
            const response = await fetch('/api/auth/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ username, password })
            });

            const result = await response.json();
            if (result) {
                alert('로그인 성공!');
            } else {
                alert('로그인 실패!');
            }
        } else if (e.submitter.id === 'register-btn') {
            // 회원가입 동작
            const response = await fetch('/api/auth/register', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ username, password, email: `${username}@example.com` })
            });

            const result = await response.json();
            if (result.id) {
                alert('회원가입 성공!');
            } else {
                alert('회원가입 실패!');
            }
        }
    });

    // 질문 처리
    const questionForm = document.getElementById('question-form');
    questionForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const question = document.getElementById('question').value;

        const response = await fetch('/api/question/ask', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(question)
        });

        const answer = await response.text();
        document.getElementById('answer').innerText = answer;
    });

    // 일기 작성 처리
    const diaryForm = document.getElementById('diary-form');
    diaryForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const diaryContent = document.getElementById('diary').value;

        const response = await fetch('/api/diary/write', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ content: diaryContent })
        });

        const diary = await response.json();
        document.getElementById('sentiment').innerText = `감정 분석 결과: ${diary.sentiment}`;
    });
});
