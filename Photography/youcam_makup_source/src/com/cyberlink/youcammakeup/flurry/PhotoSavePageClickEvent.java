// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class PhotoSavePageClickEvent extends BaseEvent
{

    public PhotoSavePageClickEvent(ButtonName buttonname)
    {
        super("YMK_Clicks_Photo_SavePage");
        HashMap hashmap = new HashMap();
        hashmap.put("ButtonName", buttonname.a());
        a(hashmap);
    }

    private class ButtonName extends Enum
    {

        public static final ButtonName a;
        public static final ButtonName b;
        public static final ButtonName c;
        public static final ButtonName d;
        public static final ButtonName e;
        public static final ButtonName f;
        public static final ButtonName g;
        public static final ButtonName h;
        public static final ButtonName i;
        public static final ButtonName j;
        public static final ButtonName k;
        public static final ButtonName l;
        public static final ButtonName m;
        public static final ButtonName n;
        public static final ButtonName o;
        public static final ButtonName p;
        private static final ButtonName q[];

        public static ButtonName valueOf(String s)
        {
            return (ButtonName)Enum.valueOf(com/cyberlink/youcammakeup/flurry/PhotoSavePageClickEvent$ButtonName, s);
        }

        public static ButtonName[] values()
        {
            return (ButtonName[])q.clone();
        }

        public abstract String a();

        static 
        {
            a = new ButtonName("Back", 0) {

                public String a()
                {
                    return "Back";
                }

            };
            b = new ButtonName("Home", 1) {

                public String a()
                {
                    return "Home";
                }

            };
            c = new ButtonName("MakeupCam", 2) {

                public String a()
                {
                    return "Makeup Cam";
                }

            };
            d = new ButtonName("Library", 3) {

                public String a()
                {
                    return "Library";
                }

            };
            e = new ButtonName("BeforeAndAfter", 4) {

                public String a()
                {
                    return "Before And After";
                }

            };
            f = new ButtonName("PhotoEdit", 5) {

                public String a()
                {
                    return "Photo Edit";
                }

            };
            g = new ButtonName("Collage", 6) {

                public String a()
                {
                    return "Collage";
                }

            };
            h = new ButtonName("BeautyCircle", 7) {

                public String a()
                {
                    return "Beauty Circle";
                }

            };
            i = new ButtonName("U", 8) {

                public String a()
                {
                    return "U";
                }

            };
            j = new ButtonName("Facebook", 9) {

                public String a()
                {
                    return "Facebook";
                }

            };
            k = new ButtonName("WhatsApp", 10) {

                public String a()
                {
                    return "What's App";
                }

            };
            l = new ButtonName("Instagram", 11) {

                public String a()
                {
                    return "Instagram";
                }

            };
            m = new ButtonName("WeChat", 12) {

                public String a()
                {
                    return "WeChat";
                }

            };
            n = new ButtonName("WeChatMoment", 13) {

                public String a()
                {
                    return "WeChatMoment";
                }

            };
            o = new ButtonName("Line", 14) {

                public String a()
                {
                    return "Line";
                }

            };
            p = new ButtonName("More", 15) {

                public String a()
                {
                    return "More";
                }

            };
            q = (new ButtonName[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p
            });
        }

        private ButtonName(String s, int i1)
        {
            super(s, i1);
        }

    }

}
