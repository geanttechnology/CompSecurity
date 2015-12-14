// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2.pager;

import android.view.View;
import android.widget.ProgressBar;
import com.fotoable.photocollage.view.compose2.StatusImageView;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TPhotoFreeComposeStyleInfo;
import com.wantu.model.res.TResInfo;
import mi;

// Referenced classes of package com.fotoable.photocollage.view.compose2.pager:
//            TPageLine

class b
    implements android.view.Listener
{

    final ProgressBar a;
    final StatusImageView b;
    final TPageLine c;

    public void onClick(View view)
    {
        view = ((View) (view.getTag()));
        if (view != null)
        {
            view = (TResInfo)view;
            if (c.listener != null)
            {
                if ((view instanceof TPhotoFreeComposeStyleInfo) && view.getResType() == EResType.ONLINE)
                {
                    a.setVisibility(0);
                    b.setEnabled(false);
                }
                c.listener.resItemSelected(view);
            }
        }
    }

    (TPageLine tpageline, ProgressBar progressbar, StatusImageView statusimageview)
    {
        c = tpageline;
        a = progressbar;
        b = statusimageview;
        super();
    }
}
