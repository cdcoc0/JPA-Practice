var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            giftName: $('#giftName').val(),
            giftBrand: $('#giftBrand').val(),
            giftCategory: $('#giftCategory').val(),
            giftPrice: $('#giftPrice').val(),
            giftContent: $('#giftContent').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/gift',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
	}
	
};

main.init();