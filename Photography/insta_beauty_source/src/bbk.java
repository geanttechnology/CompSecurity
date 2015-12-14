// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.crashlytics.android.Crashlytics;
import com.instabeauty.application.InstaBeautyApplication;
import com.instamag.activity.compose.MainOnlineLibActivity;
import com.instamag.activity.compose.NetMaterialDownloadFragment;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

public class bbk
    implements android.view.View.OnClickListener
{

    final NetMaterialDownloadFragment a;

    public bbk(NetMaterialDownloadFragment netmaterialdownloadfragment)
    {
        a = netmaterialdownloadfragment;
        super();
    }

    public void onClick(View view)
    {
        if (NetMaterialDownloadFragment.a(a) != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        view = InstaBeautyApplication.a().b().getPackageManager().getPackageInfo("com.fotoable.fotobeauty", 0).versionName;
        if (NetMaterialDownloadFragment.a(a).version != null && NetMaterialDownloadFragment.a(a).version.length() > 0 && view != null)
        {
            try
            {
                Log.v(NetMaterialDownloadFragment.a(), (new StringBuilder()).append(NetMaterialDownloadFragment.a()).append(" downloadResInfo version:").append(NetMaterialDownloadFragment.a(a).version).toString());
                Log.v(NetMaterialDownloadFragment.a(), (new StringBuilder()).append(NetMaterialDownloadFragment.a()).append(" client version:").append(view).toString());
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
                Crashlytics.logException(view);
            }
        }
        if (NetMaterialDownloadFragment.a(a).otherAppStoreId != null && NetMaterialDownloadFragment.a(a).otherAppStoreId.length() > 0 && !NetMaterialDownloadFragment.a(NetMaterialDownloadFragment.b(a), NetMaterialDownloadFragment.a(a).otherAppStoreId))
        {
            Log.v(NetMaterialDownloadFragment.a(), (new StringBuilder()).append(NetMaterialDownloadFragment.a()).append(" google play stroe package name:").append("com.android.vending").toString());
            if ("com.android.vending" != null && NetMaterialDownloadFragment.a(NetMaterialDownloadFragment.b(a), "com.android.vending") || NetMaterialDownloadFragment.a(NetMaterialDownloadFragment.b(a), "com.qihoo.appstore"))
            {
                Log.v(NetMaterialDownloadFragment.a(), (new StringBuilder()).append(NetMaterialDownloadFragment.a()).append(" installed google play store , down other App").toString());
                view = new android.app.AlertDialog.Builder(NetMaterialDownloadFragment.b(a));
                view.setTitle(NetMaterialDownloadFragment.b(a).getResources().getString(0x7f0602ae));
                view.setMessage(NetMaterialDownloadFragment.b(a).getResources().getString(0x7f0600e5));
                view.setPositiveButton(NetMaterialDownloadFragment.b(a).getResources().getString(0x7f0600e8), new bbl(this));
                view.setNegativeButton(NetMaterialDownloadFragment.b(a).getResources().getString(0x7f06018e), new bbm(this));
                view.create().show();
                return;
            }
            Log.v(NetMaterialDownloadFragment.a(), (new StringBuilder()).append(NetMaterialDownloadFragment.a()).append(" not installed  google play store or 360").toString());
        }
        if (NetMaterialDownloadFragment.b(a).a().a() != null && NetMaterialDownloadFragment.a(a) != null)
        {
            if (NetMaterialDownloadFragment.b(a) != null)
            {
                NetMaterialDownloadFragment.b(a).a(NetMaterialDownloadFragment.b(a).getResources().getString(0x7f0600e9));
            }
            NetMaterialDownloadFragment.b(a).a().a().downloadRes(NetMaterialDownloadFragment.a(a));
            NetMaterialDownloadFragment.c(a).setEnabled(false);
            NetMaterialDownloadFragment.c(a).setVisibility(4);
            NetMaterialDownloadFragment.d(a).setVisibility(0);
            NetMaterialDownloadFragment.e(a).setBackgroundColor(0x106000b);
            NetMaterialDownloadFragment.f(a).setVisibility(4);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
