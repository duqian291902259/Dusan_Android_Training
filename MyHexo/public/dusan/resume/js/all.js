var NemoCV = {
    random: function(a, b) {
        return Math.floor((Math.random() * (b - a + 1)) + a)
    },
    drawSkillsArc: function() {
        var d = Raphael("skillsArc", 830, 500),
        q = 73,
        g = "Skills",
        m = 250;
        d.circle(250, 250, 5).attr({
            stroke: "none",
            fill: "#193340"
        }).animate({
            r: 85
        },
        1000, ">");
        var s = d.text(250, 250, g).attr({
            font: "20px Hiragino Sans GB, Microsoft YaHei, sans-serif",
            fill: "#fff"
        }).toFront();
        var a = "Hiragino Sans GB, Microsoft YaHei, sans-serif";
        d.customAttributes.arc = function(B, t, u) {
            var C = 3.6 * B,
            r = C == 360 ? 359.99 : C,
            z = (90 - r) * Math.PI / 180,
            A = 250 + u * Math.cos(z),
            w = 250 - u * Math.sin(z),
            D = [["M", 250, 250 - u], ["A", u, u, 0, +(r > 180), 1, A, w]];
            return {
                path: D,
                stroke: t
            }
        };
        function c(t, r) {
            r.node["on" + t] = function() {
                for (var v = 0,
                u = r.events.length; v < u; v++) {
                    if (r.events[v].name == t) {
                        r.events[v].f.call(r)
                    }
                }
            }
        }
        var h = d.circle(702, 20, 5).attr({
            stroke: "none",
            fill: "#228fbd"
        });
        var o = d.path("M 702 20 L 702 20").attr({
            fill: "none",
            stroke: "#228fbd",
            "stroke-width": 1
        }).animate({
            "path": "M702 20 L 702 180"
        },
        1000, ">", p);
        var b = d.set();
        b.push(h);
        b.push(o);
        function p() {
            var t = {
                fill: "#228fbd",
                stroke: "none",
                transform: "t615 180"
            };
            var r = d.path("M86.112,80.5 86.892,81.191 87.847,80.774 88.374,81.673 89.411,81.572 89.635,82.589 90.653,82.813 90.551,83.851 91.45,84.378 91.033,85.333 91.725,86.112 91.033,86.892 91.45,87.847 90.551,88.374 90.653,89.411 89.635,89.635 89.411,90.653 88.374,90.551 87.847,91.45 86.892,91.033 86.112,91.725 85.333,91.033 84.378,91.45 83.851,90.551 82.813,90.653 82.589,89.635 81.572,89.411 81.673,88.374 80.774,87.847 81.191,86.892 80.5,86.112 81.191,85.333 80.774,84.378 81.673,83.851 81.572,82.813 82.589,82.589 82.813,81.572 83.851,81.673 84.378,80.774 85.333,81.191 z").attr(t).animate({
                path: "M86.112,0 98.071,10.609 112.723,4.214 120.818,18 136.728,16.446 140.167,32.057 155.778,35.497 154.224,51.406 168.011,59.501 161.616,74.154 172.225,86.112 161.616,98.071 168.011,112.723 154.224,120.818 155.778,136.728 140.167,140.167 136.728,155.778 120.818,154.224 112.723,168.011 98.071,161.616 86.112,172.225 74.154,161.616 59.501,168.011 51.406,154.224 35.497,155.778 32.057,140.167 16.446,136.728 18,120.818 4.214,112.723 10.609,98.071 0,86.112 10.609,74.154 4.214,59.501 18,51.406 16.446,35.497 32.057,32.057 35.497,16.446 51.406,18 59.501,4.214 74.154,10.609 z"
            },
            2000, "bounce").hover(function() {
                this.animate({
                    fill: "#005687",
                    path: "M86.112,-16 100.293,-3.42 117.667,-11.003 127.267,5.345 146.132,3.502 150.211,22.014 168.723,26.093 166.879,44.958 183.228,54.557 175.645,71.932 188.225,86.112 175.645,100.293 183.228,117.667 166.879,127.267 168.723,146.132 150.211,150.211 146.132,168.723 127.267,166.879 117.667,183.228 100.293,175.645 86.112,188.225 71.932,175.645 54.557,183.228 44.958,166.879 26.093,168.723 22.014,150.211 3.502,146.132 5.345,127.267 -11.003,117.667 -3.42,100.293 -16,86.112 -3.42,71.932 -11.003,54.557 5.345,44.958 3.502,26.093 22.014,22.014 26.093,3.502 44.958,5.345 54.557,-11.003 71.932,-3.42"
                },
                1000, "bounce")
            },
            function() {
                this.animate({
                    fill: "#228fbd",
                    path: "M86.112,0 98.071,10.609 112.723,4.214 120.818,18 136.728,16.446 140.167,32.057 155.778,35.497 154.224,51.406 168.011,59.501 161.616,74.154 172.225,86.112 161.616,98.071 168.011,112.723 154.224,120.818 155.778,136.728 140.167,140.167 136.728,155.778 120.818,154.224 112.723,168.011 98.071,161.616 86.112,172.225 74.154,161.616 59.501,168.011 51.406,154.224 35.497,155.778 32.057,140.167 16.446,136.728 18,120.818 4.214,112.723 10.609,98.071 0,86.112 10.609,74.154 4.214,59.501 18,51.406 16.446,35.497 32.057,32.057 35.497,16.446 51.406,18 59.501,4.214 74.154,10.609 z"
                },
                1000, "bounce")
            });
            b.push(r);
            setTimeout(function() {
                var u = d.text(703, 250, "3年以上\n项目开发经验").attr({
                    "font-size": 22,
                    fill: "#fff",
                    "font-family": a
                });
                b.push(u)
            },
            1000)
        }
        var j = [
        {
            "kind": "Java",
            "score": "85",
            "color": "#97be0d"
        },
        {
            "kind": "Android",
            "score": "88",
            "color": "#d84f5f"
        },
        {
            "kind": "Web",
            "score": "82",
            "color": "#bedbe9"
        },
        {
            "kind": "JSP",
            "score": "75",
            "color": "#88b8e6"
        },
        {
            "kind": "Others",
            "score": "70",
            "color": "#edebee"
        }];
        var e = d.set();
        var l = {
            "arc-java": [[200, "Java"], [100, "C"]],
            "arc-android": [[260, "Android"],[200, "自定义控件"],[150, "NDK"]],
            "arc-web": [[200, "HTML/HTML5"],[200, "CSS/CSS3"],[250, "Javascript/jQuery"],[150, "Ajax"]],
            "arc-jsp": [[120, "JSP"], [100, "PHP"],[100, "MySQL"]],
            "arc-others": [[200, "Mac&Linux"], [150, "jQuery"],[180, "SQL"], [100, "PS"]]
        };
        var i = 30,
        n = 550,
        k = 150,
        f = n + 10;
        setTimeout(function() {
            for (var u = 0; u < j.length; u++) {
                var r = j[u],
                t = r["color"],
                v = r["score"],
                x = r["kind"],
                y = "arc-" + x.toLowerCase().replace("&", "_");
                q += 30;
                var w = d.path().attr({
                    arc: [v, t, q],
                    "stroke-width": 26
                });
                w.node.id = y; (function(z, A, B) {
                    c("mouseover", w);
                    c("mouseout", w);
                    w.mouseover(function() {
                        this.animate({
                            "stroke-width": 50,
                            opacity: 0.75
                        },
                        1000, "elastic");
                        if (Raphael.type != "VML") {
                            this.toFront()
                        }
                        s.stop().animate({
                            opacity: 0
                        },
                        m, ">",
                        function() {
                            this.attr({
                                text: B + "\n" + A + "%"
                            }).animate({
                                opacity: 1
                            },
                            m, "<")
                        });
                        var H = this.node.id;
                        for (var C = 0,
                        F = l[H]; C < F.length; C++) {
                            var D = i + 10;
                            var E = d.rect(n, k + D * C, 1, i).attr({
                                fill: z,
                                stroke: "none"
                            }).animate({
                                width: F[C][0]
                            },
                            2000 * Math.random(), "bounce");
                            var G = d.text(f, D * C + k + i / 2, F[C][1]).attr({
                                "font-size": 20,
                                fill: "#fff",
                                "font-family": a,
                                "text-anchor": "start"
                            });
                            e.push(E);
                            e.push(G)
                        }
                        b.forEach(function(J) {
                            var I = Raphael.animation({
                                "opacity": 0
                            },
                            500, ">");
                            J.stop().animate(I)
                        })
                    }).mouseout(function() {
                        this.stop().animate({
                            "stroke-width": 26,
                            opacity: 1
                        },
                        m * 4, "elastic");
                        s.stop().animate({
                            opacity: 0
                        },
                        m, ">",
                        function() {
                            s.attr({
                                text: g
                            }).animate({
                                opacity: 1
                            },
                            m, "<")
                        });
                        console.log(e.length);
                        if (e.length > 0) {
                            e.forEach(function(C) {
                                C.remove()
                            });
                            e.clear()
                        }
                        b.forEach(function(D) {
                            var C = Raphael.animation({
                                "opacity": 1
                            },
                            1000, ">");
                            D.stop().animate(C)
                        })
                    })
                })(t, v, x)
            }
        },
        1500)
    },
    drawIcons: function() {
        var g = {
            fill: "#285AA9",
            "stroke-width": 0,
            opacity: 0.5
        };
        var b = "t-240,-240s0.07";
        var c = Raphael("icon_mobile", 35, 35),
        f = "M22.065,18.53c-0.467-0.29-1.167-0.21-1.556,0.179l-3.093,3.092c-0.389,0.389-1.025,0.389-1.414,0L9.05,14.848c-0.389-0.389-0.389-1.025,0-1.414l2.913-2.912c0.389-0.389,0.447-1.075,0.131-1.524L6.792,1.485C6.476,1.036,5.863,0.948,5.433,1.29c0,0-4.134,3.281-4.134,6.295c0,12.335,10,22.334,22.334,22.334c3.015,0,5.948-5.533,5.948-5.533c0.258-0.486,0.087-1.122-0.38-1.412L22.065,18.53z";
        c.path(f).attr(g);
        var h = Raphael("icon_email", 35, 35),
        e = "M28.516,7.167H3.482l12.517,7.108L28.516,7.167zM16.74,17.303C16.51,17.434,16.255,17.5,16,17.5s-0.51-0.066-0.741-0.197L2.5,10.06v14.773h27V10.06L16.74,17.303z";
        h.path(e).attr(g);
        var d = Raphael("icon_weibo", 35, 35),
        a = "M231.37,290.319c-2.825-1.122-6.355,0.234-8.011,3.012c-1.607,2.793-0.721,5.971,2.109,7.135c2.879,1.186,6.553-0.182,8.214-3.022C235.269,294.581,234.238,291.366,231.37,290.319zM219.894,240.975c-47.513,4.699-83.544,33.788-80.457,64.981c3.086,31.197,44.105,52.677,91.624,47.987c47.523-4.699,83.538-33.793,80.457-65.002C308.437,257.754,267.417,236.275,219.894,240.975z M261.586,314.548c-9.698,21.933-37.591,33.629-61.254,25.997c-22.846-7.375-32.517-29.933-22.515-50.253c9.821-19.924,35.379-31.192,57.99-25.308C259.209,271.03,271.151,293.106,261.586,314.548zM213.235,297.838c-7.359-3.087-16.87,0.086-21.409,7.204c-4.598,7.151-2.441,15.669,4.865,18.996c7.413,3.386,17.254,0.171,21.853-7.162C223.055,309.47,220.679,301.011,213.235,297.838zM256.417,50c-113.771,0-206,92.229-206,206c0,113.771,92.229,206,206,206c113.771,0,205.999-92.229,205.999-206C462.416,142.229,370.188,50,256.417,50zM230.901,370.958c-59.55,0-120.419-28.859-120.419-76.324c0-24.816,15.722-53.515,42.797-80.596c36.154-36.144,78.316-52.608,94.171-36.742c6.997,6.985,7.674,19.091,3.178,33.542c-2.344,7.279,6.831,3.247,6.831,3.263c29.222-12.234,54.717-12.955,64.035,0.358c4.973,7.097,4.497,17.046-0.085,28.576c-2.12,5.314,0.651,6.136,4.694,7.348c16.464,5.105,34.792,17.452,34.792,39.209C360.895,325.603,308.965,370.958,230.901,370.958zM338.705,220.029c1.928-5.949,0.722-12.731-3.771-17.708c-4.485-4.967-11.112-6.852-17.228-5.56v-0.011c-5.1,1.111-10.125-2.163-11.22-7.257c-1.095-5.116,2.163-10.147,7.273-11.236c12.507-2.66,26.056,1.207,35.23,11.385c9.195,10.179,11.652,24.042,7.722,36.208c-1.603,4.978-6.937,7.69-11.909,6.099c-4.972-1.613-7.689-6.953-6.088-11.92H338.705zM393.839,237.834c-0.006,0.011-0.006,0.032-0.006,0.043c-1.868,5.768-8.068,8.929-13.836,7.06c-5.789-1.869-8.951-8.053-7.082-13.837l-0.005-0.005c5.735-17.751,2.099-38.002-11.289-52.848c-13.404-14.846-33.164-20.518-51.423-16.641c-5.938,1.266-11.78-2.526-13.046-8.459c-1.271-5.928,2.516-11.771,8.454-13.041h0.01c25.666-5.458,53.473,2.51,72.324,23.412C396.798,184.399,401.887,212.863,393.839,237.834z";
        d.path(a).transform(b).attr(g)
    },
    drawExperienceTimeLine: function() {
        var c = new Raphael("experienceTimeLine", 900, 680);
        var e = [[200, 25, "#97BE0D", "2010 - 2014，南昌", "大学本科 华东交通大学", "电子商务，辅修计算机科学与技术"], [300, 20, "#88B8E6", "2013", "百度江西体验中心，华邦", "实习，设计师，程序员"], [400, 20, "#88B8E6", "2014 - 2015", "北京，中关村软件园", "Java Web，Android Development"], [500, 20, "#88B8E6", "2015 - 至今", "广州，OAIR", "Android开发工程师，智能硬件Android客户端开发"], [600, 20, "#989898", "Next", "?", ""]];
        var d = [["#97BE0D", 400, "学习"], ["#88B8E6", 530, "工作经历"]];
        var b = "Hiragino Sans GB, Microsoft YaHei, sans-serif";
        function a() {
            c.path("M300 130 L 300 130").attr({
                fill: "none",
                "stroke-dasharray": "- ",
                stroke: "#000",
                "stroke-width": 1
            }).animate({
                path: "M300 130 L 300 600 l 300 600"
            },
            1000, "backOut");
            for (var g = 0; g < e.length; g++) {
                var f = e[g][1]; (function(h) {
                    c.circle(300, 1500, h).attr({
                        stroke: "none",
                        fill: e[g][2]
                    }).animate({
                        cy: e[g][0]
                    },
                    1000 + 1000 * Math.random(), "backOut").hover(function() {
                        this.animate({
                            "r": h * 1.5
                        },
                        500, "bounce")
                    },
                    function() {
                        this.animate({
                            "r": h
                        },
                        500, "bounce")
                    })
                })(f);
                c.text(360, 1500, e[g][3]).attr({
                    "font-size": 14,
                    fill: "#649996",
                    "font-family": b,
                    "text-anchor": "start"
                }).animate(Raphael.animation({
                    y: e[g][0]
                },
                1000, "backOut").delay(1000));
                c.text(360, 1500, e[g][4]).attr({
                    "font-size": 16,
                    fill: "#898989",
                    "font-family": b,
                    "text-anchor": "start"
                }).animate(Raphael.animation({
                    y: e[g][0] + 25
                },
                1000, "backOut").delay(1000));
                c.text(360, 1500, e[g][5]).attr({
                    "font-size": 14,
                    fill: "#898989",
                    "font-family": b,
                    "text-anchor": "start"
                }).animate(Raphael.animation({
                    y: e[g][0] + 50
                },
                1000, "backOut").delay(1000))
            }
        }
        c.text(0, 95, "1991年01月，出生").attr({
            "font-size": 16,
            fill: "#898989",
            "font-family": b,
            "text-anchor": "start"
        });
        c.path("M 130 95 L 170 95 176 95 182 95 188 95 260 95 300 95 385 95").attr({
            fill: "none",
            "stroke-dasharray": "- ",
            stroke: "#000",
            "stroke-width": 1
        }).animate({
            path: "M 130 95 L 170 95 176 88 182 105 188 95 260 95 300 130 385 45"
        },
        1000, "bounce", a);
        for (icategory = 0; icategory < d.length; icategory++) {
            c.circle(d[icategory][1], 30, 10).attr({
                stroke: "none",
                fill: d[icategory][0]
            });
            c.text(d[icategory][1] + 25, 30, d[icategory][2]).attr({
                "font-size": 16,
                fill: "#898989",
                "font-family": b,
                "text-anchor": "start"
            })
        }
    },
    drawProjectsGallery: function() {
        var b = "M28.936,2.099H2.046c-0.506,0-0.919,0.414-0.919,0.92v21.097c0,0.506,0.413,0.919,0.919,0.919h17.062v-0.003h9.828c0.506,0,0.92-0.413,0.92-0.921V3.019C29.854,2.513,29.439,2.099,28.936,2.099zM28.562,20.062c0,0.412-0.338,0.75-0.75,0.75H3.062c-0.413,0-0.75-0.338-0.75-0.75v-16c0-0.413,0.337-0.75,0.75-0.75h24.75c0.412,0,0.75,0.337,0.75,0.75V20.062zM20.518,28.4c-0.033-0.035-0.062-0.055-0.068-0.062l-0.01-0.004l-0.008-0.004c0,0-0.046-0.021-0.119-0.062c-0.108-0.056-0.283-0.144-0.445-0.237c-0.162-0.097-0.32-0.199-0.393-0.271c-0.008-0.014-0.035-0.079-0.058-0.17c-0.083-0.32-0.161-0.95-0.22-1.539h-7.5c-0.023,0.23-0.048,0.467-0.076,0.691c-0.035,0.272-0.073,0.524-0.113,0.716c-0.02,0.096-0.039,0.175-0.059,0.23c-0.009,0.025-0.018,0.05-0.024,0.062c-0.003,0.006-0.005,0.01-0.007,0.013c-0.094,0.096-0.34,0.246-0.553,0.36c-0.107,0.062-0.209,0.11-0.283,0.146c-0.074,0.037-0.119,0.062-0.119,0.062l-0.007,0.004l-0.008,0.004c-0.01,0.009-0.038,0.022-0.07,0.062c-0.031,0.037-0.067,0.103-0.067,0.185c0.002,0.002-0.004,0.037-0.006,0.088c0,0.043,0.007,0.118,0.068,0.185c0.061,0.062,0.143,0.08,0.217,0.08h9.716c0.073,0,0.153-0.021,0.215-0.08c0.062-0.063,0.068-0.142,0.068-0.185c-0.001-0.051-0.008-0.086-0.007-0.088C20.583,28.503,20.548,28.439,20.518,28.4z";
        var a = ["#005687", "#7bbfea", "#646993", "#88B8E6", "#BEDBE9", "#566A76", "#8CAFB8"];
        var j = {
            fill: "#005687",
            "stroke-width": 0
        };
        var h = new Raphael("projectsGallery", 980, 605);
        var e = ["oair.png", "ocloud.png", "bluetooth.png", "web_jinchui.png"];
        var g = [737, 919, 1111, 332, 609, 558];
        var i = "img/projects/";
        var d = h.image(i + e[0], 278, 26, 473, 315).attr({
            "clip-rect": "278, 26, 473, 315",
            "opacity": 1
        });
        var f = 0;
        var l = h.path(b).attr(j).translate(500, 230).scale(18);
        if (Raphael.type == "VML") {
            l.translate(1.4, 1.4)
        }
        var k = h.path("M6.73,45.2 0,38.47 15.868,22.601 0,6.731 6.73,0 29.332,22.601 z").attr({
            cursor: "pointer",
            fill: "#005687",
            "opacity": 0,
            stroke: "none"
        }).transform("t900 300").animate({
            "opacity": 1
        },
        500, "bouce");
        var c = h.path("M22.702,0 29.332,6.73 13.464,22.6 29.332,38.469 22.702,45.2 0,22.6 z").attr({
            cursor: "pointer",
            fill: "#005687",
            "opacity": 0,
            stroke: "none",
            "zIndex": 999
        }).transform("t0 300").animate({
            "opacity": 1
        },
        500, "bouce");
        c.translate(40, 200);
        k.translate(40, 200);
        k.click(function() {
            $("#projectIntro table").eq(f).fadeOut(1000);
            f++;
            if (f > e.length - 1) {
                f = 0
            }
            var m = a[(f) % a.length];
            var n = a[(f + 1) % a.length];
            l.animate({
                fill: m
            },
            1000, "bouce");
            k.animate({
                fill: m
            },
            1000, "bouce");
            c.animate({
                fill: m
            },
            1000, "bouce");
            d.animate({
                "opacity": 0
            },
            3000, "bouce").attr({
                "src": i + e[f],
                "opacity": 0
            }).animate({
                "opacity": 1
            },
            3000, "bouce");
            $("#projectIntro table").eq(f).fadeIn(1000);
            $("#galleryCursor .cursor").text(f + 1).css({
                color: m
            });
            $("#galleryCursor .total").css({
                color: n
            })
        });
        c.click(function() {
            $("#projectIntro table").eq(f).fadeOut(1000);
            f--;
            if (f < 0) {
                f = e.length - 1
            }
            var m = a[(f) % a.length];
            var n = a[(f + 1) % a.length];
            l.animate({
                fill: m
            },
            1000, "bouce");
            k.animate({
                fill: m
            },
            1000, "bouce");
            c.animate({
                fill: m
            },
            1000, "bouce");
            d.animate({
                "opacity": 0
            },
            3000, "bouce").attr({
                "src": i + e[f],
                "opacity": 0
            }).animate({
                "opacity": 1
            },
            3000, "bouce");
            $("#projectIntro table").eq(f).fadeIn(1000);
            $("#galleryCursor .cursor").text(f + 1).css({
                color: m
            });
            $("#galleryCursor .total").css({
                color: n
            })
        });
        $("#galleryCursor .cursor").text(1).css({
            color: a[0]
        });
        $("#galleryCursor .total").text(e.length).css({
            color: a[1]
        });
        $("#galleryCursor").fadeIn(2000)
    }
};
$(function() {
    var g = ["intro", "skills", "experiences", "projects", "final"];
    var a = [false, false, false, false, false];
    var c = [];
    var e = 0;
    var f = $(window).height();
    for (var b = 0; b < g.length; b++) {
        c[b] = $("#" + g[b]).offset().top
    }
    var d = [];
    d[0] = function() {
        if ($.browser.msie) {
            $("#" + g[0] + " h2").animate({
                "opacity": 1
            },
            2000)
        }
        NemoCV.drawIcons();
        $(".leftBracket").animate({
            left: "-50",
            opacity: 1
        },
        1500);
        $(".rightBracket").animate({
            right: "-50",
            opacity: 1
        },
        1500);
        $("#intro .text, #intro .contact").fadeIn(2000);
        $("#intro .down").queue(function(h) {
            $(this).animate({
                "top": "30px",
                "opacity": 0.7
            },
            800).delay(500).animate({
                "top": "0px",
                "opacity": 1
            },
            800);
            $(this).queue(arguments.callee);
            h()
        }).click(function() {
            e++;
            $("html, body").stop().animate({
                scrollTop: c[e] + 100
            },
            2000, "easeOutBack")
        });
        $("#sideNav .down").queue(function(h) {
            $(this).animate({
                "marginTop": "35px",
                "opacity": 0.7
            },
            800).delay(500).animate({
                "marginTop": "10px",
                "opacity": 1
            },
            800);
            $(this).queue(arguments.callee);
            h()
        }).click(function() {
            e++;
            $("html, body").stop().animate({
                scrollTop: c[e] + 200
            },
            1000, "easeOutBack")
        });
        $("#sideNav .up").click(function() {
            e--;
            var h = e == 0 ? 0 : c[e] + 150;
            $("html, body").stop().animate({
                scrollTop: h
            },
            1000, "easeOutBack")
        })
    };
    d[1] = function() {
        $(".legend h3").addClass("fadeInUp");
        $(".skillsList li").each(function(h) {
            var i = $(this);
            setTimeout(function() {
                i.addClass("fadeInLeftBig")
            },
            h * 200)
        });
        $(".skillsList li").hover(function() {
            var h = "arc-" + $(this).text().toLowerCase();
            h = h.replace(/&/, "_");
            $("#" + h).trigger("mouseover")
        },
        function() {
            var h = "arc-" + $(this).text().toLowerCase();
            h = h.replace(/&/, "_");
            $("#" + h).trigger("mouseout")
        });
        NemoCV.drawSkillsArc()
    };
    d[2] = function() {
        NemoCV.drawExperienceTimeLine()
    };
    d[3] = function() {
        NemoCV.drawProjectsGallery();
        $("#projectsGallery").addClass("bounceInDown");
        $("#projectIntro table").eq(0).fadeIn(2000)
    };
    d[4] = function() {
        $("#final .text").animate({
            "opacity": 1
        },
        2000);
        $("#final .backTop").click(function() {
            $("html, body").stop().animate({
                scrollTop: 0
            },
            2000, "easeOutBack")
        })
    };
    $(window).scroll(function() {
        var j = $(this).scrollTop();
        for (var h = g.length; h > 0; h--) {
            if (j > c[h] - f + 300) {
                if (!a[h]) {
                    $("#" + g[h] + " h2").addClass("fadeInLeftBig");
                    if ($.browser.msie) {
                        $("#" + g[h] + " h2").animate({
                            "opacity": 1
                        },
                        2000)
                    }
                    d[h]();
                    a[h] = true
                }
                break
            }
        }
        e = h;
        if (j > c[1] - 100) {
            $("#sideNav").fadeIn(1000)
        } else {
            $("#sideNav").fadeOut(1000);
            e = 0
        }
    });
    d[0]();
    a[0] = true
});