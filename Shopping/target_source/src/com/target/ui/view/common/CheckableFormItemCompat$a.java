// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.target.ui.view.common:
//            CheckableFormItemCompat

private class text
{

    ImageView checkMark;
    TextView text;
    final CheckableFormItemCompat this$0;

    _cls9(View view)
    {
        this$0 = CheckableFormItemCompat.this;
        super();
        checkMark = (ImageView)view.findViewById(0x7f10035a);
        text = (TextView)view.findViewById(0x7f10035b);
    }
}
