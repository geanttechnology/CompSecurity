// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.view.ui.scroll.TProEditCropScrollView;

public class amw
    implements android.view.View.OnClickListener
{

    final TProEditCropScrollView a;

    public amw(TProEditCropScrollView tproeditcropscrollview)
    {
        a = tproeditcropscrollview;
        super();
    }

    public void onClick(View view)
    {
        if (TProEditCropScrollView.access$000(a) != view)
        {
            if (TProEditCropScrollView.access$000(a) != null)
            {
                TProEditCropScrollView.access$000(a).setSelected(false);
            }
            TProEditCropScrollView.access$002(a, view);
        }
        view.setSelected(true);
        if (TProEditCropScrollView.access$100(a) != null)
        {
            TProEditCropScrollView.access$100(a).a((String)view.getTag(), a);
        }
    }
}
