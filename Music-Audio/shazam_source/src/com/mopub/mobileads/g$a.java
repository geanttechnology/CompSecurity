// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            g

static final class c extends Enum
{

    public static final b a;
    public static final b b;
    private static final b d[];
    String c;

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/mopub/mobileads/g$a, s);
    }

    public static c[] values()
    {
        return (c[])d.clone();
    }

    protected final String a()
    {
        return (new StringBuilder("javascript:")).append(c).toString();
    }

    static 
    {
        a = new <init>("WEB_VIEW_DID_APPEAR", 0, "webviewDidAppear();");
        b = new <init>("WEB_VIEW_DID_CLOSE", 1, "webviewDidClose();");
        d = (new d[] {
            a, b
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        c = s1;
    }
}
