/**
 * jiangyukun on 2015/6/5.
 */

require.config({
    baseUrl: '/res/js/zrender',
    paths: {
        //Circle: 'shape/Circle'
    }
});

require(['zrender'], function (zrender) {
    var zr = zrender.init(document.getElementById('main'));
    var CircleShape = require(['shape/Circle']);
    console.log(CircleShape);
    zr.addShape(
        new CircleShape({
            style : {
                x : 100,
                y : 100,
                r : 50,
                color : 'rgba(220, 20, 60, 0.8)'
            }
        })
    );
    zr.render();
});
