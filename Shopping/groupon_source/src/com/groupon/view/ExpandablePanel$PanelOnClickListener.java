// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;

// Referenced classes of package com.groupon.view:
//            ExpandablePanel

private class <init>
    implements android.view.ner
{

    final ExpandablePanel this$0;

    public void onClick(View view)
    {
        view = ExpandablePanel.this;
        boolean flag;
        if (!ExpandablePanel.access$100(ExpandablePanel.this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.updatePanelState(flag, true);
    }

    private ()
    {
        this$0 = ExpandablePanel.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
