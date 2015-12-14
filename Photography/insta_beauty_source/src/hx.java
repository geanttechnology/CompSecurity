// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import android.util.Log;
import com.flurry.android.FlurryAgent;
import com.fotoable.alertad.FotoAlert;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class hx
    implements android.content.DialogInterface.OnClickListener
{

    final String a;
    final FotoAlert b;
    final String c;
    final hu d;

    hx(hu hu1, String s, FotoAlert fotoalert, String s1)
    {
        d = hu1;
        a = s;
        b = fotoalert;
        c = s1;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (a.startsWith("market://"))
        {
            ie.a(hu.c(d), a);
        } else
        if (hu.d(d) != null)
        {
            dialoginterface = new HashMap();
            dialoginterface.put("alertId", (new StringBuilder()).append("alert_").append(b.a).toString());
            FlurryAgent.logEvent("FotoAlertClicked", dialoginterface);
            dialoginterface = (hz)hu.d(d).get();
            if (b.h == com.fotoable.alertad.FotoAlert.FotoAlertType.FotoAlertUpdate)
            {
                dialoginterface.a(a);
            } else
            if (b.h == com.fotoable.alertad.FotoAlert.FotoAlertType.FotoAlertApp)
            {
                dialoginterface.a(a);
            } else
            if (b.h == com.fotoable.alertad.FotoAlert.FotoAlertType.FotoAlertFun)
            {
                dialoginterface.b(c);
            } else
            {
                Log.i("FotoAlertFactory", "unknow alert type");
            }
        } else
        {
            Log.i("fotoAlertFactory", "fotoAlertShowLisener is null!");
        }
        hu.b(d).dismiss();
        hu.a(d, null);
    }
}
