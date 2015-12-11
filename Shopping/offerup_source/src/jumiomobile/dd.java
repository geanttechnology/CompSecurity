// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.DialogInterface;
import android.view.MenuItem;
import com.jumio.netswipe.sdk.activity.ScanCardActivity;

// Referenced classes of package jumiomobile:
//            dm, ab

public class dd
    implements android.content.DialogInterface.OnClickListener
{

    final ScanCardActivity a;

    public dd(ScanCardActivity scancardactivity)
    {
        a = scancardactivity;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            ScanCardActivity.f(a).h();
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            ab.a(dialoginterface);
        }
        ScanCardActivity.h(a);
        a.hideBlurView();
        a.showInfoTextContainer(false);
        if (ScanCardActivity.i(a) != null)
        {
            ScanCardActivity.i(a).setVisible(ScanCardActivity.j(a));
        }
        ScanCardActivity.a(a, null);
    }
}
