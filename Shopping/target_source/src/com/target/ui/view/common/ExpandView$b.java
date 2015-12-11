// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.target.ui.view.common:
//            ExpandView

private class childContainer
{

    final ViewGroup childContainer;
    final ImageView dropDownBtn;
    final ViewGroup headerLayout;
    boolean isAnimating;
    boolean isExpanded;
    final ExpandView this$0;
    final TextView title;

    public void a(boolean flag)
    {
        isAnimating = flag;
    }

    public boolean a()
    {
        return isAnimating;
    }

    public void b(boolean flag)
    {
        isExpanded = flag;
    }

    public boolean b()
    {
        return isExpanded;
    }

    public (View view)
    {
        this$0 = ExpandView.this;
        super();
        isAnimating = false;
        isExpanded = false;
        title = (TextView)view.findViewById(0x7f10043e);
        dropDownBtn = (ImageView)view.findViewById(0x7f10043f);
        headerLayout = (ViewGroup)view.findViewById(0x7f10043d);
        childContainer = (ViewGroup)view.findViewById(0x7f100440);
    }
}
