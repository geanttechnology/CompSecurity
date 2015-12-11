// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Referenced classes of package com.target.ui.fragment.common:
//            SimpleDialogFragment

private class title
{

    Button button;
    TextView content;
    final SimpleDialogFragment this$0;
    TextView title;

    public (View view)
    {
        this$0 = SimpleDialogFragment.this;
        super();
        button = (Button)view.findViewById(0x7f100069);
        content = (TextView)view.findViewById(0x7f10021a);
        title = (TextView)view.findViewById(0x7f100080);
    }
}
