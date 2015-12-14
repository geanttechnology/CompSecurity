// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.ui;

import com.targetspot.android.sdk.TSContentSize;

// Referenced classes of package com.targetspot.android.sdk.ui:
//            AdPopup

static class 
{

    static final int $SwitchMap$com$targetspot$android$sdk$TSContentSize[];

    static 
    {
        $SwitchMap$com$targetspot$android$sdk$TSContentSize = new int[TSContentSize.values().length];
        try
        {
            $SwitchMap$com$targetspot$android$sdk$TSContentSize[TSContentSize.TSContentSizeLarge.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$targetspot$android$sdk$TSContentSize[TSContentSize.TSContentSizeMedium.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$targetspot$android$sdk$TSContentSize[TSContentSize.TSContentSizeSmall.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
