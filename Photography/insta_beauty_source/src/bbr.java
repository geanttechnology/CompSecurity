// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.fotoable.comlib.ui.RecyclingImageView;
import com.instabeauty.application.InstaBeautyApplication;
import com.instamag.activity.lib.MagLibCellItemView;
import com.instamag.activity.library.activity.MainDownloadActivity;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.activity.photoselector.InstaPhotoSelectorActivity;
import java.io.PrintStream;

public class bbr
    implements android.view.View.OnClickListener
{

    RecyclingImageView a;
    final MagLibCellItemView b;

    public bbr(MagLibCellItemView maglibcellitemview, RecyclingImageView recyclingimageview)
    {
        b = maglibcellitemview;
        super();
        a = recyclingimageview;
    }

    public void onClick(View view)
    {
label0:
        {
            Intent intent3;
label1:
            {
                if (a != null && a.getTag() != null && (a.getTag() instanceof TPhotoComposeInfo))
                {
                    view = (TPhotoComposeInfo)a.getTag();
                    if (((TPhotoComposeInfo) (view)).resId != -200)
                    {
                        break label0;
                    }
                    android.content.pm.PackageInfo packageinfo;
                    if (axw.a())
                    {
                        view = "http://ad.apps.fm/o8zDbaai6J05LpNvUfVSCK5px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9ER6-WkP-ouqWNfIfX0kSz2rJsp2IeBZo-kKlAgwsBVTs";
                    } else
                    {
                        view = "http://ad.apps.fm/Mw0_AEWVz_AAarl38KMgya5px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9EzFmeSFyAbMPhAJijcji8Mi8SRC01jE-yi7f6BFW6W4I";
                    }
                    intent3 = new Intent("android.intent.action.VIEW");
                    intent3.setData(Uri.parse(view));
                    try
                    {
                        packageinfo = b.mContext.getPackageManager().getPackageInfo("com.android.browser", 0);
                    }
                    catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
                    {
                        namenotfoundexception.printStackTrace();
                        namenotfoundexception = null;
                    }
                    if (packageinfo != null)
                    {
                        break label1;
                    }
                    System.out.println("\u6CA1\u6709\u5B89\u88C5");
                    view = Intent.createChooser(intent3, null);
                    b.getContext().startActivity(view);
                }
                return;
            }
            Intent intent;
            try
            {
                intent3.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                b.getContext().startActivity(intent3);
                return;
            }
            catch (Exception exception)
            {
                intent = new Intent("android.intent.action.VIEW");
            }
            intent.setData(Uri.parse(view));
            view = Intent.createChooser(intent, null);
            b.getContext().startActivity(view);
            return;
        }
        Log.v("MagLibCellItemView", (new StringBuilder()).append("MagLibCellItemView MagItemView Clicked res id:").append(((TPhotoComposeInfo)a.getTag()).resId).toString());
        if (((TPhotoComposeInfo) (view)).isDirectDownload)
        {
            InstaBeautyApplication.e.resId = ((TPhotoComposeInfo) (view)).resId;
            InstaBeautyApplication.e.version = ((TPhotoComposeInfo) (view)).version;
            InstaBeautyApplication.e.name = ((TPhotoComposeInfo) (view)).name;
            InstaBeautyApplication.e.icon = ((TPhotoComposeInfo) (view)).icon;
            InstaBeautyApplication.e.previewUrl = ((TPhotoComposeInfo) (view)).previewUrl;
            InstaBeautyApplication.e.imageCount = ((TPhotoComposeInfo) (view)).imageCount;
            InstaBeautyApplication.e.otherAppStoreId = ((TPhotoComposeInfo) (view)).otherAppStoreId;
            InstaBeautyApplication.e.needReviewing = ((TPhotoComposeInfo) (view)).needReviewing;
            if (((TPhotoComposeInfo) (view)).needSharing)
            {
                InstaBeautyApplication.e.wxdlShareInfo = ((TPhotoComposeInfo) (view)).wxdlShareInfo;
                InstaBeautyApplication.e.sinadlShareInfo = ((TPhotoComposeInfo) (view)).sinadlShareInfo;
            }
            InstaBeautyApplication.e.needSharing = ((TPhotoComposeInfo) (view)).needSharing;
            Intent intent1 = new Intent(b.mContext, com/instamag/activity/library/activity/MainDownloadActivity);
            intent1.putExtra("SelectedComposeInfoResId", ((TPhotoComposeInfo) (view)).resId);
            b.mContext.startActivity(intent1);
            return;
        } else
        {
            Intent intent2 = new Intent(b.mContext, com/wantu/activity/photoselector/InstaPhotoSelectorActivity);
            intent2.putExtra("SelectedComposeInfoResId", ((TPhotoComposeInfo) (view)).resId);
            intent2.putExtra("SelectedComposeInfoImageCount", ((TPhotoComposeInfo) (view)).imageCount);
            b.mContext.startActivity(intent2);
            return;
        }
    }
}
