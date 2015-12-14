// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.activity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.crashlytics.android.Crashlytics;
import com.wantu.model.res.TResInfo;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.activity:
//            MaterialDownloadFragment, MainResourceActivity

class a
    implements android.content.ener
{

    final MaterialDownloadFragment a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            MaterialDownloadFragment.b(a).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(MaterialDownloadFragment.c(a).otherAppStoreId).toString())));
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
    }

    I(MaterialDownloadFragment materialdownloadfragment)
    {
        a = materialdownloadfragment;
        super();
    }
}
