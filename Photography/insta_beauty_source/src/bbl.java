// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.crashlytics.android.Crashlytics;
import com.instamag.activity.compose.MainOnlineLibActivity;
import com.instamag.activity.compose.NetMaterialDownloadFragment;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

class bbl
    implements android.content.DialogInterface.OnClickListener
{

    final bbk a;

    bbl(bbk bbk1)
    {
        a = bbk1;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            NetMaterialDownloadFragment.b(a.a).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(NetMaterialDownloadFragment.a(a.a).otherAppStoreId).toString())));
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
}
