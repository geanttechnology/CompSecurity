// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.exception;


// Referenced classes of package com.socialin.android.apiv3.exception:
//            ExceptionReportService

final class f extends Thread
{

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public final void run()
    {
        ExceptionReportService.sendStackTrace("http://t27.socialin.com/services/exception.php", "SocialInGames2011", a, b, c, d, e, true, f);
        try
        {
            Thread.sleep(1000L);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
    }

    (String s, String s1, String s2, String s3, String s4, String s5)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = s5;
        super();
    }
}
