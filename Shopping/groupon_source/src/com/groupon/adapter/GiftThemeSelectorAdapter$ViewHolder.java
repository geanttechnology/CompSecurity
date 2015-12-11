// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.groupon.adapter:
//            GiftThemeSelectorAdapter

public static class themesHolder extends android.support.v7.widget.Holder
{

    public TextView mTextView;
    public LinearLayout themesHolder;

    public (LinearLayout linearlayout)
    {
        super(linearlayout);
        mTextView = (TextView)linearlayout.findViewById(0x7f10007a);
        themesHolder = (LinearLayout)linearlayout.findViewById(0x7f1002f7);
    }
}
