// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

// Referenced classes of package com.ebay.android.widget:
//            ExpandablePanel

private class <init>
    implements android.view.nelToggler
{

    final ExpandablePanel this$0;

    public void onClick(View view)
    {
        boolean flag1 = true;
        boolean flag;
        if (view.getId() == ExpandablePanel.access$200(ExpandablePanel.this).getId())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            return;
        }
        if (ExpandablePanel.access$300(ExpandablePanel.this))
        {
            view = new on(ExpandablePanel.this, ExpandablePanel.access$400(ExpandablePanel.this), ExpandablePanel.access$500(ExpandablePanel.this));
            ExpandablePanel.access$700(ExpandablePanel.this).onCollapse(ExpandablePanel.access$200(ExpandablePanel.this), ExpandablePanel.access$600(ExpandablePanel.this));
            ExpandablePanel.access$200(ExpandablePanel.this).setImageResource(0x7f020252);
        } else
        {
            view = new on(ExpandablePanel.this, ExpandablePanel.access$500(ExpandablePanel.this), ExpandablePanel.access$400(ExpandablePanel.this));
            ExpandablePanel.access$700(ExpandablePanel.this).onExpand(ExpandablePanel.access$200(ExpandablePanel.this), ExpandablePanel.access$600(ExpandablePanel.this));
            ExpandablePanel.access$200(ExpandablePanel.this).setImageResource(0x7f020256);
        }
        if (view != null)
        {
            view.setDuration(ExpandablePanel.access$800(ExpandablePanel.this));
            ExpandablePanel.access$600(ExpandablePanel.this).startAnimation(view);
        }
        view = ExpandablePanel.this;
        if (ExpandablePanel.access$300(ExpandablePanel.this))
        {
            flag1 = false;
        }
        ExpandablePanel.access$302(view, flag1);
    }

    private ner()
    {
        this$0 = ExpandablePanel.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
