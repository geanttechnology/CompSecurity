// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.view.ui.scroll.TProEditTagTypeScrollView;
import com.fotoable.fotoproedit.view.ui.scroll.TagItemView;

public class anh
    implements android.view.View.OnClickListener
{

    final TProEditTagTypeScrollView a;

    public anh(TProEditTagTypeScrollView tproedittagtypescrollview)
    {
        a = tproedittagtypescrollview;
        super();
    }

    public void onClick(View view)
    {
        if (TProEditTagTypeScrollView.access$000(a) != (TagItemView)view)
        {
            if (TProEditTagTypeScrollView.access$000(a) != null)
            {
                TProEditTagTypeScrollView.access$000(a).setSelected(false);
            }
            TProEditTagTypeScrollView.access$002(a, (TagItemView)view);
        }
        view.setSelected(true);
        if (TProEditTagTypeScrollView.access$100(a) != null)
        {
            TProEditTagTypeScrollView.access$100(a).a((String)view.getTag(), a);
        }
    }
}
