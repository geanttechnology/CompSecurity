// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKTemplateStoreTypeClicksEvent extends BaseEvent
{

    public YMKTemplateStoreTypeClicksEvent(TypeName typename)
    {
        super("YMK_TemplateStore_Type_Clicks");
        HashMap hashmap = new HashMap();
        hashmap.put("TypeName", typename.a());
        a(hashmap);
    }

    private class TypeName extends Enum
    {

        public static final TypeName a;
        public static final TypeName b;
        public static final TypeName c;
        public static final TypeName d;
        public static final TypeName e;
        public static final TypeName f;
        public static final TypeName g;
        private static final TypeName h[];

        public static TypeName valueOf(String s)
        {
            return (TypeName)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKTemplateStoreTypeClicksEvent$TypeName, s);
        }

        public static TypeName[] values()
        {
            return (TypeName[])h.clone();
        }

        public abstract String a();

        static 
        {
            a = new TypeName("NaturalLooks", 0) {

                public String a()
                {
                    return "Natural Looks";
                }

            };
            b = new TypeName("CostumeLooks", 1) {

                public String a()
                {
                    return "Costume Looks";
                }

            };
            c = new TypeName("EyeShadow", 2) {

                public String a()
                {
                    return "Eye Shadow";
                }

            };
            d = new TypeName("EyeLiner", 3) {

                public String a()
                {
                    return "Eye Liner";
                }

            };
            e = new TypeName("EyeLashes", 4) {

                public String a()
                {
                    return "Eye Lashes";
                }

            };
            f = new TypeName("EyeWear", 5) {

                public String a()
                {
                    return "Eye Wear";
                }

            };
            g = new TypeName("Accessory", 6) {

                public String a()
                {
                    return "Accessory";
                }

            };
            h = (new TypeName[] {
                a, b, c, d, e, f, g
            });
        }

        private TypeName(String s, int i)
        {
            super(s, i);
        }

    }

}
