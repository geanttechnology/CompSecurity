// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.MenuItem;
import com.jumio.netswipe.sdk.activity.ScanCardActivity;

// Referenced classes of package jumiomobile:
//            bq, dm

public class df
    implements Runnable
{

    final ScanCardActivity a;

    public df(ScanCardActivity scancardactivity)
    {
        a = scancardactivity;
        super();
    }

    public void run()
    {
        boolean flag = true;
        a.showInfoTextContainer(true);
        ScanCardActivity.a(a).setEnabled(false);
        ScanCardActivity.k(a).setEnabled(false);
        a.showProcessView();
        if (ScanCardActivity.i(a) != null)
        {
            ScanCardActivity.i(a).setVisible(false);
        }
        ScanCardActivity scancardactivity = a;
        if (ScanCardActivity.f(a).x())
        {
            flag = false;
        }
        scancardactivity.prepareBlurView(flag);
    }
}
