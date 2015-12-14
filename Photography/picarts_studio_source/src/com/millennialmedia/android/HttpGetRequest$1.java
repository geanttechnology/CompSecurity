// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            HttpGetRequest, MMLog

final class a
    implements Runnable
{

    private String a[];

    public final void run()
    {
        String as[] = a;
        int j = as.length;
        int i = 0;
        while (i < j) 
        {
            String s = as[i];
            MMLog.a("HttpGetRequest", String.format("Logging event to: %s", new Object[] {
                s
            }));
            try
            {
                (new HttpGetRequest()).a(s);
            }
            catch (Exception exception)
            {
                MMLog.a("HttpGetRequest", "Logging request failed.", exception);
            }
            i++;
        }
    }

    (String as[])
    {
        a = as;
        super();
    }
}
