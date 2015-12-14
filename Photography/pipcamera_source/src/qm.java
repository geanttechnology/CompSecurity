// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.fotoable.comlib.ui.RecyclingImageView;
import com.instamag.activity.lib.InstaPhotoSelectorActivity;
import com.instamag.activity.lib.MagLibCellItemView;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;

public class qm
    implements android.view.View.OnClickListener
{

    RecyclingImageView a;
    final MagLibCellItemView b;

    public qm(MagLibCellItemView maglibcellitemview, RecyclingImageView recyclingimageview)
    {
        b = maglibcellitemview;
        super();
        a = recyclingimageview;
    }

    public void onClick(View view)
    {
label0:
        {
            if (a != null && a.getTag() != null && (a.getTag() instanceof TPhotoComposeInfo))
            {
                view = (TPhotoComposeInfo)a.getTag();
                if (((TPhotoComposeInfo) (view)).resId >= TPhotoMagComposeManager.KMAXADRESID)
                {
                    break label0;
                }
                MagLibCellItemView.access$000(b, ((TPhotoComposeInfo) (view)).resId);
            }
            return;
        }
        Intent intent = new Intent(b.mContext, com/instamag/activity/lib/InstaPhotoSelectorActivity);
        intent.putExtra("SelectedComposeInfoResId", ((TPhotoComposeInfo) (view)).resId);
        intent.putExtra("SelectedComposeInfoImageCount", ((TPhotoComposeInfo) (view)).imageCount);
        b.mContext.startActivity(intent);
    }
}
