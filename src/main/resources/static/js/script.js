console.log("Script Loaded!");

let currentTheme = getTheme();

changeTheme(currentTheme);

function changeTheme(){
    // Set to Webpage
    document.querySelector('html').classList.add(currentTheme);

    // Set the listener to change theme button
    const changeThemeBtn = document.querySelector("#change_theme_btn");
    changeThemeBtn.querySelector("span").textContent = currentTheme=="light" ? "Dark" : "Light";
    changeThemeBtn.addEventListener('click', () => {
        const oldTheme = currentTheme;
        if(currentTheme === "dark"){
            currentTheme = "light";
        }
        else{
            currentTheme = "dark";
        }
        setTheme(currentTheme);
        document.querySelector('html').classList.remove(oldTheme);
        document.querySelector('html').classList.add(currentTheme);
        changeThemeBtn.querySelector("span").textContent = currentTheme=="light" ? "Dark" : "Light";
    })
}

// Set Theme to Local Storage
function setTheme(theme){
    localStorage.setItem("theme",theme)
}

// Get Theme from Local Storage
function getTheme(){
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}