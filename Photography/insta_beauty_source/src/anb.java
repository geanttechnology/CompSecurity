// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.view.ui.scroll.ColorItemView;
import com.fotoable.fotoproedit.view.ui.scroll.TProEditStretchBottomBar;

public class anb
    implements android.view.View.OnClickListener
{

    final TProEditStretchBottomBar a;

    public anb(TProEditStretchBottomBar tproeditstretchbottombar)
    {
        a = tproeditstretchbottombar;
        super();
    }

    public void onClick(View view)
    {
        if (a.curColorItemView != view)
        {
            if (a.curColorItemView != null)
            {
                a.curColorItemView.setSelected(false);
            }
            a.curColorItemView = (ColorItemView)view;
        }
        view.setSelected(true);
        if (a.listener != null)
        {
            a.listener.a((String)view.getTag(), null);
        }
    }
}
