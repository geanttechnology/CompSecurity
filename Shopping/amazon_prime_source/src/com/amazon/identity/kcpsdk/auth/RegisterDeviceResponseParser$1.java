// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.kcpsdk.common.FIRSErrorType;
import com.amazon.identity.kcpsdk.common.KindleWebserviceErrorType;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            RegisterDeviceResponseParser

static class 
{

    static final int $SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType[];
    static final int $SwitchMap$com$amazon$identity$kcpsdk$common$KindleWebserviceErrorType[];

    static 
    {
        $SwitchMap$com$amazon$identity$kcpsdk$common$KindleWebserviceErrorType = new int[KindleWebserviceErrorType.values().length];
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$common$KindleWebserviceErrorType[KindleWebserviceErrorType.KindleWebserviceErrorTypeDeviceAlreadyRegistered.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$common$KindleWebserviceErrorType[KindleWebserviceErrorType.KindleWebserviceErrorTypeDuplicateDeviceName.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$common$KindleWebserviceErrorType[KindleWebserviceErrorType.KindleWebserviceErrorTypeInternalError.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        $SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType = new int[FIRSErrorType.values().length];
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType[FIRSErrorType.FIRSErrorTypeCustomerNotFound.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType[FIRSErrorType.FIRSErrorTypeDeviceAlreadyRegistered.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType[FIRSErrorType.FIRSErrorTypeDuplicateAccountName.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType[FIRSErrorType.FIRSErrorTypeInternalError.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType[FIRSErrorType.FIRSErrorTypeInvalidAccountFound.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
