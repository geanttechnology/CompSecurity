// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.crashlytics.android.Crashlytics;

class bco
    implements android.content.DialogInterface.OnClickListener
{

    final bcn a;

    bco(bcn bcn1)
    {
        a = bcn1;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            dialoginterface = bcn.a(a).getPackageName();
            bcn.a(a).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(dialoginterface).toString())));
            acm.b();
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
        acm.a();
    }
}
