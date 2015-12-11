// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;


// Referenced classes of package com.medialets.advertising:
//            JSBridge

private final class a
    implements Runnable
{

    private String a;
    private JSBridge b;

    public final void run()
    {
        JSBridge.a(b, a, true);
    }

    public (JSBridge jsbridge, String s)
    {
        b = jsbridge;
        super();
        a = s;
    }
}
