// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.View;
import com.fotoable.comlib.ui.RecyclingImageView;
import com.instamag.activity.lib.MagOnlineLibCellItemView;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

public class qo
    implements android.view.View.OnClickListener
{

    RecyclingImageView a;
    final MagOnlineLibCellItemView b;

    public qo(MagOnlineLibCellItemView magonlinelibcellitemview, RecyclingImageView recyclingimageview)
    {
        b = magonlinelibcellitemview;
        super();
        a = recyclingimageview;
    }

    public void onClick(View view)
    {
        if (a != null && a.getTag() != null && (a.getTag() instanceof TPhotoComposeInfo))
        {
            view = (TPhotoComposeInfo)a.getTag();
            Log.v("MagLibCellItemView", (new StringBuilder()).append("MagLibCellItemView MagItemView Clicked res id:").append(((TPhotoComposeInfo)a.getTag()).resId).toString());
            if (MagOnlineLibCellItemView.access$000(b) != null)
            {
                MagOnlineLibCellItemView.access$000(b).a(a, view);
            }
        }
    }
}
