const BASE_URL ="https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies";

const dropdown = document.querySelectorAll(".dropdown select");

// for(let code in countryList){
//     console.log(code, countryList[code]);
// }

for(let select of dropdown ){
    for(let currencycode in countryList){
        let newOption = document.createElement("option");
        newOption.innerHTML=currencycode;
        newOption.value=currencycode;
        select.append(newOption);
    }
    select.addEventListener("change", (evt)=>{
        updateFlag(evt.target);
    });
}


const updateFlag=(element)=>{
    
    let currCode = element.value;

    let countryCode = countryList[currCode];

    let newSRC=`https://flagsapi.com/${countryCode}/flat/64.png`;
    let img =element.parentElement.querySelector("img");
    img.src=newSRC;
};

