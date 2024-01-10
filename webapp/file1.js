/**
 * 
 */

 let ele1 = document.getElementById('bank-name');
 
 function create(){
	 let h1 = document.createElement('h1');
	 h1.innerText =`Welcome to Developer's Bank of JSpi`
	 h1.style.height = `200px`
	 h1.style.width = `200px`
	 h1.style.backgroundColor = `red`
	 ele1.appendChild(h1)
 }
 