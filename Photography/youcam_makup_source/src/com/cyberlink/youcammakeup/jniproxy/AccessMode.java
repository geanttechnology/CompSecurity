// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            a

public final class AccessMode extends Enum
{

    public static final AccessMode a;
    public static final AccessMode b;
    private static final AccessMode c[];
    private final int swigValue;

    private AccessMode(String s, int i)
    {
        super(s, i);
        swigValue = com.cyberlink.youcammakeup.jniproxy.a.a();
    }

    private AccessMode(String s, int i, int j)
    {
        super(s, i);
        swigValue = j;
        com.cyberlink.youcammakeup.jniproxy.a.a(j + 1);
    }

    public static AccessMode valueOf(String s)
    {
        return (AccessMode)Enum.valueOf(com/cyberlink/youcammakeup/jniproxy/AccessMode, s);
    }

    public static AccessMode[] values()
    {
        return (AccessMode[])c.clone();
    }

    public final int a()
    {
        return swigValue;
    }

    static 
    {
        a = new AccessMode("ReadOnly", 0, 0);
        b = new AccessMode("ReadWrite", 1);
        c = (new AccessMode[] {
            a, b
        });
    }
}
