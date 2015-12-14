// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import com.targetspot.android.sdk.TSContentSize;
import com.targetspot.android.sdk.TSLocationType;

// Referenced classes of package com.targetspot.android.sdk.service:
//            WebService

static class 
{

    static final int $SwitchMap$com$targetspot$android$sdk$TSContentSize[];
    static final int $SwitchMap$com$targetspot$android$sdk$TSLocationType[];

    static 
    {
        $SwitchMap$com$targetspot$android$sdk$TSContentSize = new int[TSContentSize.values().length];
        try
        {
            $SwitchMap$com$targetspot$android$sdk$TSContentSize[TSContentSize.TSContentSizeLarge.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$targetspot$android$sdk$TSContentSize[TSContentSize.TSContentSizeMedium.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$targetspot$android$sdk$TSContentSize[TSContentSize.TSContentSizeSmall.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        $SwitchMap$com$targetspot$android$sdk$TSLocationType = new int[TSLocationType.values().length];
        try
        {
            $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationBestAvailable.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationUseNetowrk.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationLastKnown.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationPostalCode.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationUnknown.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
