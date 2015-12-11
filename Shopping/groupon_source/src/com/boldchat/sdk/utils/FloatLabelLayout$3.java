// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk.utils;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

// Referenced classes of package com.boldchat.sdk.utils:
//            FloatLabelLayout

class this._cls0
    implements android.widget.electedListener
{

    final FloatLabelLayout this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (i == 0 || TextUtils.isEmpty(FloatLabelLayout.access$000(FloatLabelLayout.this).getText()))
        {
            hideLabel();
            return;
        } else
        {
            showLabel();
            return;
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    istener()
    {
        this$0 = FloatLabelLayout.this;
        super();
    }
}
