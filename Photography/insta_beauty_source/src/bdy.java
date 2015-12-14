// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.instamag.activity.library.view.MaglibItemView;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.activity.link.model.TPhotoLinkComposeInfo;

public class bdy
    implements android.view.View.OnClickListener
{

    final MaglibItemView a;

    private bdy(MaglibItemView maglibitemview)
    {
        a = maglibitemview;
        super();
    }

    public bdy(MaglibItemView maglibitemview, bds bds)
    {
        this(maglibitemview);
    }

    public void onClick(View view)
    {
        while (MaglibItemView.access$100(a) == null || a.isEditMode) 
        {
            return;
        }
        if (MaglibItemView.access$100(a) instanceof TPhotoLinkComposeInfo)
        {
            MaglibItemView.access$600(a, MaglibItemView.access$100(a));
            return;
        }
        if (apq.c().d().isExistedByResId(MaglibItemView.access$100(a).resId))
        {
            MaglibItemView.access$600(a, MaglibItemView.access$100(a));
            return;
        } else
        {
            MaglibItemView.access$700(a, MaglibItemView.access$100(a));
            return;
        }
    }
}
