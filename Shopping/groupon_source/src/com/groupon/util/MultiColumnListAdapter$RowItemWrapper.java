// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package com.groupon.util:
//            MultiColumnListAdapter

public class setOnClickListener extends FrameLayout
    implements android.view.per
{

    private int position;
    final MultiColumnListAdapter this$0;

    public View getWrappedView()
    {
        return getChildAt(0);
    }

    public void onClick(View view)
    {
        MultiColumnListAdapter.this.onClick(position, view);
    }

    public void setPosition(int i)
    {
        position = i;
    }

    public void wrap(View view)
    {
        if (getChildCount() > 0)
        {
            removeViewAt(0);
        }
        addView(view);
    }

    public (Context context)
    {
        this$0 = MultiColumnListAdapter.this;
        super(context);
        multicolumnlistadapter = new android.widget.r.this._cls0(0, -2, 1.0F);
        _fld0 = 80;
        setLayoutParams(MultiColumnListAdapter.this);
        setBackgroundResource(0x7f02024e);
        setOnClickListener(this);
    }
}
