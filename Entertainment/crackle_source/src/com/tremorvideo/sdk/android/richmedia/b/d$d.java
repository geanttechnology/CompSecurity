// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.b;


// Referenced classes of package com.tremorvideo.sdk.android.richmedia.b:
//            d

public class a
    implements Runnable
{

    String a;
    final d b;

    public void run()
    {
        b.loadUrl((new StringBuilder()).append("javascript:").append(a).toString());
    }

    public (d d1, String s)
    {
        b = d1;
        super();
        a = s;
    }
}
