// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

// Referenced classes of package com.target.ui.view.common:
//            CheckableFormItem

private class text
{

    CheckBox checkbox;
    TextView text;
    final CheckableFormItem this$0;

    (View view)
    {
        this$0 = CheckableFormItem.this;
        super();
        checkbox = (CheckBox)view.findViewById(0x7f10035a);
        text = (TextView)view.findViewById(0x7f10035b);
    }
}
