$("#addGenero").click(function () {
	$('#genreForm').clone().appendTo('#novoGenero');
});

$('#limparGenero').click(function () {
	$('#novoGenero').empty();
});

$("#addDiretor").click(function () {
	$('#directorForm').clone().appendTo('#novoDiretor');
});

$('#limparDiretor').click(function () {
	$('#novoDiretor').empty();
});