define(
    function (require) {

        var computeBoundingBox = require('../tool/computeBoundingBox');
        var Base = require('./Base');

        var renderCount = 0, animationFlag = true;
        var Cellular = function (options) {
            this.brushTypeOnly = 'stroke';
            Base.call(this, options);
        };

        Cellular.prototype = {
            type: 'cellular',

            buildPath: function (ctx, style) {
                renderCount++;
                //animationFlag = (renderCount % 2 != 0);
                animationFlag = true;
                var i, j;
                var x = style.x;
                var y = style.y;
                var startAngle = style.startAngle;
                var endAngle = style.endAngle;
                var lineWidth = 1;
                var count = style.count;
                var colorStyle = style.colorStyle;
                var radius = 10;

                for (i = 1; i <= count; i++) {
                    switch (i) {
                        case 1:
                            radius = 10;
                            lineWidth = 1;
                            break;
                        case 2:
                            radius = 15;
                            lineWidth = 2;
                            break;
                        case 3:
                            radius = 21;
                            lineWidth = 3;
                            break;
                        case 4:
                            radius = 28;
                            lineWidth = 3;
                            break;
                        case 5:
                            radius = 35;
                            lineWidth = 4;
                            break;
                    }
                    for (j = 0; j < lineWidth; j++) {
                        setTimeout(function (r) {
                            return function () {
                                ctx.beginPath();
                                ctx.arc(x, y, r, startAngle, endAngle, true);
                                ctx.strokeStyle = colorStyle;
                                ctx.stroke();
                            };
                        }(radius + j), animationFlag ? i * 100 : 0);
                    }
                }
            },
            getRect: function (style) {
                if (style.__rect) {
                    return style.__rect;
                }
                return {
                    x: style.x,
                    y: style.y,
                    width: style.x + style.radius * style.count,
                    height: style.y
                }
            }
        };
        require('../tool/util').inherits(Cellular, Base);
        return Cellular;
    }
);
