// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.support.v7.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

class m extends FrameLayout
    implements CollapsibleActionView
{

    final android.view.CollapsibleActionView a;

    m(View view)
    {
        super(view.getContext());
        a = (android.view.CollapsibleActionView)view;
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
