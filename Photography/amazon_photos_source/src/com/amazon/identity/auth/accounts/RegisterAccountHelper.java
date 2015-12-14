// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.framework.DeviceInfoHolder;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.StringUtil;
import com.amazon.identity.platform.util.PlatformUtils;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AmazonAccountManager

public class RegisterAccountHelper
{

    private static final String TAG = com/amazon/identity/auth/accounts/RegisterAccountHelper.getName();
    private final AmazonAccountManager mAmznAcctMan;
    private final Context mContext;
    private final MAPAccountManager mMapAcctMan;

    public RegisterAccountHelper(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mAmznAcctMan = (AmazonAccountManager)mContext.getSystemService("dcp_amazon_account_man");
        mMapAcctMan = new MAPAccountManager(mContext);
    }

    public static boolean canRegisterWithDeviceSecret(Context context)
    {
        String s = DeviceInfoHolder.getInstance(context).getDeviceSecret();
        return PlatformUtils.isAmazonDevice(context) && !StringUtil.isEmptyOrWhitespace(s);
    }

}
