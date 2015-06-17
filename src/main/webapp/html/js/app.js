/**
 * jiangyukun on 2015/6/5.
 */


requirejs.config({
    baseUrl: 'res/js',
    paths: {
        chosen: 'chosen.jquery',
        test: 'myTest'
    },
    shim: {
        bootstrap: {
            deps: ['jquery']
        },
        chosen: {
            deps: ['jquery']
        }
    }
});

requirejs(['jquery', 'underscore', 'bootstrap', 'jstree'], function ($, _) {
    _.templateSettings = {
        interpolate: /{{(.+?)}}/g
    };
    var _template = _.template($('#dropdown-result').text());
    var inputStr = _.template($('#dropdown-input').text())();
    //console.log($.jstree);
    var $jstree = $('#jstree');
    $jstree.jstree({
        "core": {
            "animation": 200,
            "check_callback": true,
            "themes": {"stripes": true},
            'data': {
                'url': function (node) {
                    return  'html/json/1.json';
                },
                'data': function (node) {
                    return {'id': node.id};
                }
            }
        }
    });
    $jstree.on("changed.jstree", function (e, data) {
        var flag = false;
        //console.log(data);
        var liHtml = _template({
            text: data.node.text,
            id: data.node.id
        });
        $resultNodes.find('span').each(function (index, ele) {
            var value = $(ele).data('val');
            if (value == data.node.id) {
                flag = true;
            }
        });
        if (!flag) {
            $resultNodes.append(liHtml);
            $('#dropdown-result-input').remove();
            $resultNodes.append(inputStr);
        }
    });
    $jstree.hide();

    var $html = $('html');
    var $resultNodes = $('#resultNodes');
    var $treeContainer = $('#treeContainer');
    $resultNodes.append(inputStr);

    $treeContainer.click(function () {
        $('#selectNodes').focus();
        return false;
    });
    $resultNodes.delegate('#selectNodes', 'focus', function () {
        $jstree.show();
    });
    $html.click(function () {
        $jstree.hide();
    });

    $resultNodes.delegate('.close_icon', 'click', function () {
        $(this).parent().remove();
    });
});
