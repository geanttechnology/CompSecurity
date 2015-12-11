// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import android.app.PendingIntent;
import android.content.DialogInterface;

// Referenced classes of package com.amazon.geo.mapsv2.pvt:
//            MapsErrorDialogUtil

static final class val.intent
    implements android.content.kListener
{

    final PendingIntent val$intent;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        try
        {
            val$intent.send();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            return;
        }
    }

    (PendingIntent pendingintent)
    {
        val$intent = pendingintent;
        super();
    }
}
