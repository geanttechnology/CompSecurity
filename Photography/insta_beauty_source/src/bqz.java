// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.view.scroll.NewTShareScrollView;

public class bqz
    implements android.view.View.OnClickListener
{

    final NewTShareScrollView a;

    public bqz(NewTShareScrollView newtsharescrollview)
    {
        a = newtsharescrollview;
        super();
    }

    public void onClick(View view)
    {
        if (NewTShareScrollView.access$000(a) != view)
        {
            if (NewTShareScrollView.access$000(a) != null)
            {
                NewTShareScrollView.access$000(a).setSelected(false);
            }
            NewTShareScrollView.access$002(a, view);
        }
        view.setSelected(true);
        if (NewTShareScrollView.access$100(a) != null)
        {
            NewTShareScrollView.access$100(a).a((String)view.getTag(), this);
        }
    }
}
