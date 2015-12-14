// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;

public class dj
    implements android.view.View.OnClickListener
{

    final ScrollingTabContainerView a;

    private dj(ScrollingTabContainerView scrollingtabcontainerview)
    {
        a = scrollingtabcontainerview;
        super();
    }

    public dj(ScrollingTabContainerView scrollingtabcontainerview, dh dh)
    {
        this(scrollingtabcontainerview);
    }

    public void onClick(View view)
    {
        ((dk)view).b().d();
        int j = ScrollingTabContainerView.access$200(a).getChildCount();
        int i = 0;
        while (i < j) 
        {
            View view1 = ScrollingTabContainerView.access$200(a).getChildAt(i);
            boolean flag;
            if (view1 == view)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view1.setSelected(flag);
            i++;
        }
    }
}
