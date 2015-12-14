// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;


public abstract class MakeupMode extends Enum
{

    public static final MakeupMode a;
    public static final MakeupMode b;
    public static final MakeupMode c;
    public static final MakeupMode d;
    public static final MakeupMode e;
    public static final MakeupMode f;
    public static final MakeupMode g;
    private static final MakeupMode h[];

    private MakeupMode(String s, int i)
    {
        super(s, i);
    }


    public static MakeupMode valueOf(String s)
    {
        return (MakeupMode)Enum.valueOf(com/cyberlink/youcammakeup/utility/MakeupMode, s);
    }

    public static MakeupMode[] values()
    {
        return (MakeupMode[])h.clone();
    }

    public abstract String a();

    static 
    {
        a = new MakeupMode("LOOKS", 0) {

            public String a()
            {
                return "Looks";
            }

        };
        b = new MakeupMode("WIG", 1) {

            public String a()
            {
                return "Hair";
            }

        };
        c = new MakeupMode("FACE", 2) {

            public String a()
            {
                return "Face";
            }

        };
        d = new MakeupMode("EYE", 3) {

            public String a()
            {
                return "Eye";
            }

        };
        e = new MakeupMode("MOUTH", 4) {

            public String a()
            {
                return "Mouth";
            }

        };
        f = new MakeupMode("ACCESSORY", 5) {

            public String a()
            {
                return "Accessories";
            }

        };
        g = new MakeupMode("UNDEFINED", 6) {

            public String a()
            {
                return "";
            }

        };
        h = (new MakeupMode[] {
            a, b, c, d, e, f, g
        });
    }
}
