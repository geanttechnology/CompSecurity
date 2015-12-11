// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netswipe.sdk.activity.ScanCardActivity;

// Referenced classes of package jumiomobile:
//            bt, bq, dm, cy

public class dh
    implements bt
{

    final ScanCardActivity a;

    private dh(ScanCardActivity scancardactivity)
    {
        a = scancardactivity;
        super();
    }

    public dh(ScanCardActivity scancardactivity, cy cy)
    {
        this(scancardactivity);
    }

    public void a(bq bq1)
    {
        bq1.setEnabled(false);
    }

    public void b(bq bq1)
    {
        ScanCardActivity.f(a).n();
    }
}
