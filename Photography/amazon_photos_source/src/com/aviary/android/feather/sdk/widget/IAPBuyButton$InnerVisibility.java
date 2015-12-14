// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.os.Handler;
import android.widget.TextView;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            IAPBuyButton

private class newTextVisibility
{

    private boolean newEnableStatus;
    private int newProgressVisibility;
    private int newTextVisibility;
    private final com.aviary.android.feather.cds.bility.newEnableStatus option;
    final IAPBuyButton this$0;

    public int getNewProgressVisibility()
    {
        return newProgressVisibility;
    }

    public int getNewTextVisibility()
    {
        return newTextVisibility;
    }

    public newTextVisibility invoke()
    {
        .aviary.android.feather.cds.CdsUtils.PackOption[option.option.option()];
        JVM INSTR tableswitch 1 11: default 72
    //                   1 74
    //                   2 89
    //                   3 144
    //                   4 164
    //                   5 179
    //                   6 194
    //                   7 209
    //                   8 224
    //                   9 244
    //                   10 301
    //                   11 318;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        return this;
_L2:
        mTextView.setText(com.aviary.android.feather.sdk.);
        return this;
_L3:
        mTextView.setVisibility(0);
        if (option.price != null)
        {
            mTextView.setText(option.price);
            return this;
        } else
        {
            mTextView.setText(com.aviary.android.feather.sdk.ble);
            return this;
        }
_L4:
        mTextView.setText(com.aviary.android.feather.sdk.);
        newEnableStatus = false;
        return this;
_L5:
        mTextView.setText(com.aviary.android.feather.sdk.l);
        return this;
_L6:
        mTextView.setText(com.aviary.android.feather.sdk.);
        return this;
_L7:
        mTextView.setText(com.aviary.android.feather.sdk.);
        return this;
_L8:
        mTextView.setText(com.aviary.android.feather.sdk.);
        return this;
_L9:
        mTextView.setText(com.aviary.android.feather.sdk.ng);
        newEnableStatus = false;
        return this;
_L10:
        newProgressVisibility = 0;
        newTextVisibility = 4;
        newEnableStatus = false;
        if (getHandler() != null)
        {
            getHandler().postDelayed(checkDownloadStatus, (long)(Math.random() * 100D + 900D));
            return this;
        }
          goto _L1
_L11:
        newProgressVisibility = 0;
        newTextVisibility = 4;
        newEnableStatus = false;
        return this;
_L12:
        mTextView.setText(com.aviary.android.feather.sdk.);
        return this;
    }

    public boolean isNewEnableStatus()
    {
        return newEnableStatus;
    }




    public (com.aviary.android.feather.cds.bility bility, boolean flag, int i, int j)
    {
        this$0 = IAPBuyButton.this;
        super();
        option = bility;
        newEnableStatus = flag;
        newProgressVisibility = i;
        newTextVisibility = j;
    }
}
