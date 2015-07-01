/**
 * jiangyukun on 2015/6/5.
 */

require.config({
    packages: [
        {
            name: 'zrender',
            location: '../res/js/zrender',
            main: 'zrender'
        }
    ]
});

require(['zrender', 'zrender/shape/Circle'], function (zrender) {
    zr = zrender.init(document.getElementById('main'));
    var color = require('zrender/tool/color');
    var colorIdx = 0;
    var width = Math.ceil(zr.getWidth());
    var height = Math.ceil(zr.getHeight());

    var i;
    var n = 50;
    var shapeList = [];
    var CircleShape = require('zrender/shape/Circle');
// 动画元素
    for (i = 0; i < n; i++) {
        shapeList[i] = new CircleShape({
            style: {
                x: Math.ceil(Math.random() * width),
                y: Math.ceil(Math.random() * height),
                r: Math.ceil(Math.random() * 40),
                brushType: Math.ceil(Math.random() * 100) % 3 >= 1 ? 'both' : 'stroke',
                color: 'rgba('
                + Math.round(Math.random() * 256) + ','
                + Math.round(Math.random() * 256) + ','
                + Math.round(Math.random() * 256) + ', 0.5)',
                strokeColor: 'rgba('
                + Math.round(Math.random() * 256) + ','
                + Math.round(Math.random() * 256) + ','
                + Math.round(Math.random() * 256) + ', 0.3)',
                lineWidth: 3
            },
            _animationX: Math.ceil(Math.random() * 20),
            _animationY: Math.ceil(Math.random() * 20),
            hoverable: false
        });
        if (shapeList[i].style.x < 100 || shapeList[i].style.x > (width - 100)) {
            shapeList[i].style.x = width / 2;
        }
        if (shapeList[i].style.y < 100 || shapeList[i].style.y > (height - 100)) {
            shapeList[i].style.y = height / 2;
        }
        zr.addShape(shapeList[i]);
    }

// 绘画，利用render的callback可以在绘画完成后马上开始动画
    zr.render(function () {
        animationTicket = setInterval(
            function () {
                var style;
                for (i = 0; i < n; i++) {
                    // 可以跳过
                    style = shapeList[i].style;
                    if (style.brushType == 'both') {
                        if (style.x + style.r + shapeList[i]._animationX >= width
                            || style.x - style.r + shapeList[i]._animationX <= 0
                        ) {
                            shapeList[i]._animationX = -shapeList[i]._animationX;
                        }
                        shapeList[i].style.x += shapeList[i]._animationX;
                    }

                    if (style.brushType == 'both') {
                        if (style.y + style.r + shapeList[i]._animationY >= height ||
                            style.y - style.r + shapeList[i]._animationY <= 0) {
                            shapeList[i]._animationY = -shapeList[i]._animationY;
                        }
                        shapeList[i].style.y += shapeList[i]._animationY;
                    }
                    else {
                        if (style.y - shapeList[i]._animationY + style.r <= 0) {
                            shapeList[i].style.y = height + style.r;
                            shapeList[i].style.x = Math.ceil(Math.random() * width);
                        }
                        shapeList[i].style.y -= shapeList[i]._animationY;
                    }


                    // 就看这句就行
                    zr.modShape(shapeList[i].id, shapeList[i]);
                }
                zr.refresh();
            },
            50
        )
    });
});
