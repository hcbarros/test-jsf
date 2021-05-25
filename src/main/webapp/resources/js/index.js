

function mascara(id) {
    var campo = document.getElementById(id);        
    campo.value = campo.value.replace( /[^\d]/g, '' );	                                         
}