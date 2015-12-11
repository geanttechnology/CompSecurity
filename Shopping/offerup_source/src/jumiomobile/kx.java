// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.AlertDialog;
import android.widget.Button;
import com.jumio.mobile.sdk.environment.Environment;

// Referenced classes of package jumiomobile:
//            kt, mk, lg, cv, 
//            ce

class kx
    implements Runnable
{

    final kt a;

    kx(kt kt1)
    {
        a = kt1;
        super();
    }

    public void run()
    {
        android.app.Activity activity = a.getActivity();
        Object obj;
        if (Environment.isLollipop())
        {
            obj = new android.app.AlertDialog.Builder(activity, 5);
        } else
        {
            obj = new android.app.AlertDialog.Builder(activity);
        }
        ((android.app.AlertDialog.Builder) (obj)).setTitle(mk.a(activity, "require_us_address_title"));
        ((android.app.AlertDialog.Builder) (obj)).setMessage(mk.a(activity, "require_us_address_message"));
        ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(mk.a(activity, "require_us_address_button"), new lg(a, null));
        ((android.app.AlertDialog.Builder) (obj)).setCancelable(false);
        obj = ((android.app.AlertDialog.Builder) (obj)).show();
        a.i = true;
        ((AlertDialog) (obj)).getButton(-1).setTextColor(ce.b(activity, cv.a(activity, "netverify_dialogPositiveButtonTextColor", "attr"), 0xff97be0d));
    }
}
