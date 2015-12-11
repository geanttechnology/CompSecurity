// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

public final class axh
    implements android.content.DialogInterface.OnClickListener
{

    private final Activity a;
    private final j b;
    private final Intent c;
    private final int d;

    public axh(Activity activity, Intent intent, int i)
    {
        a = activity;
        b = null;
        c = intent;
        d = i;
    }

    public axh(j j1, Intent intent, int i)
    {
        a = null;
        b = j1;
        c = intent;
        d = i;
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        j j1;
        Intent intent;
        try
        {
            if (c != null && b != null)
            {
                j1 = b;
                intent = c;
                i = d;
                if (j1.w == null)
                {
                    throw new IllegalStateException((new StringBuilder("Fragment ")).append(j1).append(" not attached to Activity").toString());
                }
                break MISSING_BLOCK_LABEL_76;
            }
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
            return;
        }
          goto _L1
        j1.w.a(j1, intent, i);
_L3:
        dialoginterface.dismiss();
        return;
_L1:
        if (c != null)
        {
            a.startActivityForResult(c, d);
        }
        if (true) goto _L3; else goto _L2
_L2:
    }
}
