$(document).ready(function() {
	$('input[type=checkbox]').on('click', function() {
		var hasCheckboxChecked = $('input:checked').length;
		if (hasCheckboxChecked) {
			$('button').prop('disabled', false);
		} else {
			$('button').prop('disabled', true);
		}
	});

});