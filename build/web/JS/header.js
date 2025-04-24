/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const avatarOnClick = () =>{
    const menu = document.getElementById("menu");
    const styles = window.getComputedStyle(menu);
    if(styles.display === "none"){
        menu.style.display = "block";
    }else{
        menu.style.display = "none";
    }
};
