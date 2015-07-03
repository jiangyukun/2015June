define(
    function (require) {

        var math = require('../tool/math');
        var computeBoundingBox = require('../tool/computeBoundingBox');
        var vec2 = require('../tool/vector');
        var Base = require('./Base');

        var min0 = vec2.create();
        var min1 = vec2.create();
        var max0 = vec2.create();
        var max1 = vec2.create();

        var Cellular = function (options) {
            this.brushTypeOnly = 'stroke';
            Base.call(this, options);
        };

        Cellular.prototype = {
            type: 'cellular',

            buildPath: function (ctx, style) {
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
                        ctx.beginPath();
                        ctx.arc(x, y, radius + j, startAngle, endAngle, true);
                        ctx.strokeStyle = colorStyle;
                        ctx.stroke();
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
