//En la página https://sweetalert.js.org/guides/ encontramos
//métodos para programar, en este caso un método de confirmación
//para eliminación:

/*
swal({
  title: "Are you sure?",
  text: "Once deleted, you will not be able to recover this imaginary file!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((willDelete) => {
  if (willDelete) {
    swal("Poof! Your imaginary file has been deleted!", {
      icon: "success",
    });
  } else {
    swal("Your imaginary file is safe!");
  }
});
*/

//Lo editamos en una función:

function eliminar(id) {
    swal({
          title: "Está seguro de eliminar?",
          text: "Once deleted, you will not be able to recover this imaginary file!",
          icon: "warning",
          buttons: true,
          dangerMode: true,
        })
        .then((OK) => {
          if (OK) {
            $.ajax({
                url:"/eliminar/"+id,
                success: function(respuesta) {
                    console.log(respuesta);
                },
            });
            swal("Poof! Your imaginary file has been deleted!", {
              icon: "success",
            }).then((ok)=>{
                if(ok){
                    location.href="/listar";
                }
            });
          } else {
            swal("Your imaginary file is safe!");
          }
        });
}
