// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.NewFilterScrollView;
import com.fotoable.beautyui.filterItemView;

public class iw
    implements android.view.View.OnClickListener
{

    final NewFilterScrollView a;

    public iw(NewFilterScrollView newfilterscrollview)
    {
        a = newfilterscrollview;
        super();
    }

    public void onClick(View view)
    {
        if (NewFilterScrollView.access$000(a) != view && (view instanceof filterItemView))
        {
            if (NewFilterScrollView.access$000(a) != null)
            {
                NewFilterScrollView.access$000(a).setSelected(false);
            }
            view.setSelected(true);
            NewFilterScrollView.access$002(a, view);
            if (NewFilterScrollView.access$100(a) != null)
            {
                NewFilterScrollView.access$100(a).a(((Integer)view.getTag()).intValue(), a, ((filterItemView)view).getText());
                return;
            }
        }
    }
}
