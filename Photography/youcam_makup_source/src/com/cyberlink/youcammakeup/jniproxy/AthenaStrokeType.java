// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            b

public final class AthenaStrokeType extends Enum
{

    public static final AthenaStrokeType a;
    public static final AthenaStrokeType b;
    public static final AthenaStrokeType c;
    private static final AthenaStrokeType d[];
    private final int swigValue;

    private AthenaStrokeType(String s, int i)
    {
        super(s, i);
        swigValue = com.cyberlink.youcammakeup.jniproxy.b.a();
    }

    private AthenaStrokeType(String s, int i, int j)
    {
        super(s, i);
        swigValue = j;
        com.cyberlink.youcammakeup.jniproxy.b.a(j + 1);
    }

    public static AthenaStrokeType valueOf(String s)
    {
        return (AthenaStrokeType)Enum.valueOf(com/cyberlink/youcammakeup/jniproxy/AthenaStrokeType, s);
    }

    public static AthenaStrokeType[] values()
    {
        return (AthenaStrokeType[])d.clone();
    }

    public final int a()
    {
        return swigValue;
    }

    static 
    {
        a = new AthenaStrokeType("ATN_FOREGROUND", 0, 0);
        b = new AthenaStrokeType("ATN_BACKGROUND", 1);
        c = new AthenaStrokeType("ATN_ERASER", 2);
        d = (new AthenaStrokeType[] {
            a, b, c
        });
    }
}
