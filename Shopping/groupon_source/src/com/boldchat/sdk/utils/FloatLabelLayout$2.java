// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk.utils;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.boldchat.sdk.utils:
//            FloatLabelLayout

class this._cls0
    implements android.view.istener
{

    final FloatLabelLayout this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (android.os.NT >= 16)
        {
            FloatLabelLayout.access$000(FloatLabelLayout.this).setActivated(flag);
        }
    }

    ()
    {
        this$0 = FloatLabelLayout.this;
        super();
    }
}
