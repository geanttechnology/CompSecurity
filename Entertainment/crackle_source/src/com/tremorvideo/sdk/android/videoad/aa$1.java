// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;


// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aa, ad

static final class b
    implements Runnable
{

    final String a;
    final String b;

    public void run()
    {
        try
        {
            (new <init>(b, a)).execute(new String[0]);
            return;
        }
        catch (Exception exception)
        {
            ad.a("Error sending response: ", exception);
        }
    }

    (String s, String s1)
    {
        a = s;
        b = s1;
        super();
    }
}
