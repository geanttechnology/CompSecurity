// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

class ak extends FrameLayout
    implements cp
{

    final CollapsibleActionView a;

    ak(View view)
    {
        super(view.getContext());
        a = (CollapsibleActionView)view;
        addView(view);
    }

    View a()
    {
        return (View)a;
    }

    public void onActionViewCollapsed()
    {
        a.onActionViewCollapsed();
    }

    public void onActionViewExpanded()
    {
        a.onActionViewExpanded();
    }
}
