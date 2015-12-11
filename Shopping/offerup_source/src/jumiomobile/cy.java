// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netswipe.sdk.activity.ScanCardActivity;

// Referenced classes of package jumiomobile:
//            bq

public class cy
    implements Runnable
{

    final ScanCardActivity a;

    public cy(ScanCardActivity scancardactivity)
    {
        a = scancardactivity;
        super();
    }

    public void run()
    {
        ScanCardActivity.a(a).performClick();
    }
}
