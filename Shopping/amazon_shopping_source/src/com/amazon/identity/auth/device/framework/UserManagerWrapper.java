// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.auth.device.utils.CentralApkUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ReflectionHelper;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            ServiceWrappingContext, PlatformWrapper, AndroidUser

public class UserManagerWrapper
{

    private static final String TAG = com/amazon/identity/auth/device/framework/UserManagerWrapper.getName();
    private final ServiceWrappingContext mContext;
    private final PlatformWrapper mPlatform;
    private final ReflectionHelper mRefHelper = new ReflectionHelper();
    private final Object mUserManager;

    public UserManagerWrapper(ServiceWrappingContext servicewrappingcontext)
    {
        mContext = servicewrappingcontext;
        mUserManager = mContext.getSystemService("user");
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
    }

    private void checkIsUserManagerSupportedOnThisPlatform()
    {
        if (!isSupportedOnThisPlatform())
        {
            MAPLog.e(TAG, "checkIsUserManagerSupportedOnThisPlatform failed. IMP is going to crash. This issue is tracked in SSO-150 and FWK-10172");
            throw new IllegalStateException("This platform does not support UserManager");
        } else
        {
            return;
        }
    }

    private Integer getMyUserId()
    {
        Integer integer;
        try
        {
            integer = (Integer)mRefHelper.invokeStatic("myUserId", "android.os.UserHandle", new Class[0], new Object[0]);
        }
        catch (com.amazon.identity.auth.device.utils.ReflectionHelper.CannotCallMethodException cannotcallmethodexception)
        {
            MAPLog.e(TAG, "Cannot get my user id", cannotcallmethodexception);
            return null;
        }
        return integer;
    }

    public AndroidUser getAndroidUserFromUserId(int i)
    {
        AndroidUser androiduser;
        try
        {
            androiduser = AndroidUser.convertFromUserInfo(mRefHelper.invoke("getUserInfo", mUserManager, new Class[] {
                Integer.TYPE
            }, new Object[] {
                Integer.valueOf(i)
            }));
        }
        catch (com.amazon.identity.auth.device.utils.ReflectionHelper.CannotCallMethodException cannotcallmethodexception)
        {
            MAPLog.e(TAG, "Cannot get user info for my user id", cannotcallmethodexception);
            return null;
        }
        return androiduser;
    }

    public AndroidUser getCurrentUser()
    {
        checkIsUserManagerSupportedOnThisPlatform();
        return getAndroidUserFromUserId(AndroidUser.getCurrentUserId());
    }

    public AndroidUser getMainUser()
    {
        checkIsUserManagerSupportedOnThisPlatform();
        return getAndroidUserFromUserId(AndroidUser.getOwnerId());
    }

    public AndroidUser getMyUser()
    {
        checkIsUserManagerSupportedOnThisPlatform();
        Integer integer = getMyUserId();
        if (integer == null)
        {
            MAPLog.e(TAG, "No Current user");
            return null;
        } else
        {
            return getAndroidUserFromUserId(integer.intValue());
        }
    }

    public boolean isSupportedOnThisPlatform()
    {
        boolean flag = mPlatform.doesPlatformSupportsMultipleProfiles();
        boolean flag1 = CentralApkUtils.isRunningInCentralAPK(mContext);
        return flag && flag1;
    }

}
