// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            HttpGetRequest, MMLog

final class a
    implements Runnable
{

    private String a;

    public final void run()
    {
        HttpGetRequest httpgetrequest = new HttpGetRequest();
        try
        {
            httpgetrequest.a(a);
            return;
        }
        catch (Exception exception)
        {
            MMLog.a(a, "Error logging event: ", exception);
        }
    }

    (String s)
    {
        a = s;
        super();
    }
}
