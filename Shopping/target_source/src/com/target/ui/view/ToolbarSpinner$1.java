// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.target.ui.view:
//            ToolbarSpinner

class this._cls0
    implements android.widget.mSelectedListener
{

    final ToolbarSpinner this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (ToolbarSpinner.a(ToolbarSpinner.this) != null)
        {
            ToolbarSpinner.a(ToolbarSpinner.this).a(i);
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    ectedListener()
    {
        this$0 = ToolbarSpinner.this;
        super();
    }
}
