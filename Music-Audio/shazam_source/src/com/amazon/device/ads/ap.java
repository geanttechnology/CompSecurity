// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Locale;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            z, ce, ea, co, 
//            f, cn, h, ah, 
//            du, de, dd, cd

class ap
    implements z
{
    private static final class a
        implements de
    {

        private final ap a;

        public final void a(dd dd1, f f1)
        {
            if (dd1.a.equals(dd.a.i))
            {
                ap.a(a);
            }
        }

        public a(ap ap1)
        {
            a = ap1;
        }
    }

    private static final class b extends ce.b
    {

        private final ap b;

        public final JSONObject a()
        {
            ap.a(b, cd.a(null, "enable", true));
            return null;
        }

        public b(ap ap1)
        {
            super("EnableCloseButton");
            b = ap1;
        }
    }

    private static final class c extends ce.b
    {

        private final ap b;

        public final JSONObject a()
        {
            ap.a(b, cd.a(null, "url", null));
            return null;
        }

        public c(ap ap1)
        {
            super("OpenInExternalBrowser");
            b = ap1;
        }
    }

    private static final class d extends ce.b
    {

        private final ap b;

        public final JSONObject a()
        {
            ap.b(b, cd.a(null, "override", false));
            return null;
        }

        public d(ap ap1)
        {
            super("OverrideBackButton");
            b = ap1;
        }
    }

    private static final class e extends ce.b
    {

        private final ap b;

        public final JSONObject a()
        {
            JSONObject jsonobject = new JSONObject();
            cd.b(jsonobject, "sdkVersion", ap.e());
            return jsonobject;
        }

        protected e(ap ap1)
        {
            super("GetSDKVersion");
            b = ap1;
        }
    }


    private static final String a = com/amazon/device/ads/ap.getSimpleName();
    private static final String b = (new StringBuilder("(function (window, console){\n    var version = '1.0',\n    debug = function(msg) {\n        console.log(\"Amazon Javascript log: \" + msg);\n    },\n    is_array = function (obj) {\n        return Object.prototype.toString.call(obj) === '[object Array]';\n    },\n    forEach = function (array, fn) {\n        var i;\n        for (i = 0; i < array.length; i++) {\n            if (i in array) {\n                fn.call(null, array[i], i);\n            }\n        }\n    },\n    listeners = [],\n    events = {\n        backButton: 'backButton'\n    },\n    invokeListeners = function(event, args) {\n        var eventListeners = listeners[event] || [];\n        // fire all the listeners\n        forEach(eventListeners, function(listener){\n            try {\n                listener.apply(null, args);\n            }catch(e){\n                debug(\"Error executing \" + event + \" listener\");\n                debug(e);\n            }\n        });\n    },\n    backButtonEvent = function() {\n        invokeListeners(\"backButton\");\n    };\n    window.amazonBridge = {\n        backButton : backButtonEvent\n    };\n    window.amazon = {\n        // Command Flow\n        addEventListener : function(event, listener){\n            var eventListeners = listeners[event] || [],\n            alreadyRegistered = false;\n            \n            //verify the event is one that will actually occur\n            if (!events.hasOwnProperty(event)){\n                return;\n            }\n            \n            //register first set of listeners for this event\n            if (!is_array(listeners[event])) {\n                listeners[event] = eventListeners;\n            }\n            \n            forEach(eventListeners, function(l){ \n                // Listener already registered, so no need to add it.\n                    if (listener === l){\n                        alreadyRegistered = true;\n                    }\n                }\n            );\n            if (!alreadyRegistered){\n                listeners[event].push(listener);\n            }\n        },\n        removeEventListener : function(event, listener){\n            if (listeners.hasOwnProperty(event)) {\n                var eventListeners = listeners[event];\n                if (eventListeners) {\n                    var idx = eventListeners.indexOf(listener);\n                    if (idx !== -1) {\n                        eventListeners.splice(idx, 1);\n                    }\n                }\n            }\n        },\n        enableCloseButton: function(enable){\n            amazonObject.")).append(ce.a()).append("(\"EnableCloseButton\", JSON.stringify({\"enable\": enable}));\n        },\n        overrideBackButton: function(override){\n            amazonObject.").append(ce.a()).append("(\"OverrideBackButton\", JSON.stringify({\"override\": override}));\n        },\n        openInExternalBrowser: function(url){\n            amazonObject.").append(ce.a()).append("(\"OpenInExternalBrowser\", JSON.stringify({\"url\": url}));\n        },\n        getSDKVersion: function(){\n            var json = JSON.parse(amazonObject.").append(ce.a()).append("(\"GetSDKVersion\", null));\n            return json.sdkVersion;\n        },\n        getVersion: function(){\n            return version;\n        },\n    };\n})(window, console);").toString();
    private final ce c;
    private final f d;
    private final a e;
    private final ea f;
    private final cn g;

    public ap(f f1, ce ce1)
    {
        ea ea1 = new ea();
        new co();
        this(f1, ce1, ea1);
    }

    private ap(f f1, ce ce1, ea ea1)
    {
        e = new a(this);
        d = f1;
        c = ce1;
        f = ea1;
        g = co.a(a);
        c.a(new b(this));
        c.a(new d(this));
        c.a(new c(this));
        c.a(new e(this));
    }

    static void a(ap ap1)
    {
        ap1.d.a("amazonBridge.backButton();");
    }

    static void a(ap ap1, String s)
    {
        if (!ap1.d.c())
        {
            ap1.a("Unable to open a URL while the ad is not visible", "open");
            return;
        }
        ap1.g.b((new StringBuilder("Opening URL ")).append(s).toString(), null);
        if (ea.a(s))
        {
            ap1.d.a.i.a(s);
            return;
        } else
        {
            s = (new StringBuilder("URL ")).append(s).append(" is not a valid URL").toString();
            ap1.g.b(s, null);
            ap1.a(s, "open");
            return;
        }
    }

    static void a(ap ap1, boolean flag)
    {
label0:
        {
            if (ap1.d.d())
            {
                if (!flag)
                {
                    break label0;
                }
                ap1.d.a(true, null);
            }
            return;
        }
        ap1.d.a();
    }

    private void a(String s, String s1)
    {
        d.a(String.format(Locale.US, "amazonBridge.error('%s', '%s');", new Object[] {
            s, s1
        }));
    }

    static void b(ap ap1, boolean flag)
    {
        ap1.d.a.E = flag;
    }

    static String e()
    {
        return du.a();
    }

    public final ce.a a()
    {
        return c.a;
    }

    public final String b()
    {
        return "amazonObject";
    }

    public final String c()
    {
        return b;
    }

    public final de d()
    {
        return e;
    }

}
