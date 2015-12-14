// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.crashlytics.android.Crashlytics;
import com.fotoable.adbuttonlib.TWebBrowActivity;
import com.wantu.model.res.TResInfo;

class awp
    implements android.content.DialogInterface.OnClickListener
{

    final TResInfo a;
    final awm b;

    awp(awm awm1, TResInfo tresinfo)
    {
        b = awm1;
        a = tresinfo;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (a.dlUrl != null && !a.dlUrl.equalsIgnoreCase(""))
        {
            dialoginterface = new Intent(awm.a(b), com/fotoable/adbuttonlib/TWebBrowActivity);
            dialoginterface.putExtra("webUriString", a.dlUrl);
            awm.a(b).startActivity(dialoginterface);
            return;
        }
        try
        {
            awm.a(b).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(a.otherAppStoreId).toString())));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            Crashlytics.logException(dialoginterface);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            Crashlytics.logException(dialoginterface);
        }
        return;
    }
}
