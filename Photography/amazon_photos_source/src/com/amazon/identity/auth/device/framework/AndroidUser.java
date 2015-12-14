// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.app.ActivityManager;
import android.os.UserHandle;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ReflectionHelper;

public final class AndroidUser
{

    private static final Integer OWNER_ID;
    private static final String TAG = com/amazon/identity/auth/device/framework/AndroidUser.getName();
    public static final Class USER_HANDLE_CLASS;
    private final UserHandle mAndroidUserHandle;
    private final int mFlags;
    private final int mUserHandleId;

    AndroidUser(int i, int j, Object obj)
    {
        mUserHandleId = i;
        mFlags = j;
        mAndroidUserHandle = (UserHandle)obj;
    }

    public static AndroidUser convertFromUserInfo(Object obj)
    {
        if (obj == null || !"android.content.pm.UserInfo".equals(obj.getClass().getName()))
        {
            MAPLog.e(TAG, "Given Object is not a valid UserInfo class");
            return null;
        }
        try
        {
            ReflectionHelper reflectionhelper = new ReflectionHelper();
            obj = new AndroidUser(((Integer)reflectionhelper.getField(obj, "id")).intValue(), ((Integer)reflectionhelper.getField(obj, "flags")).intValue(), reflectionhelper.invoke("getUserHandle", obj, new Class[0], new Object[0]));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MAPLog.e(TAG, "Cannot construct Android User from User Info", ((Throwable) (obj)));
            return null;
        }
        return ((AndroidUser) (obj));
    }

    public static int getCallingUserId()
    {
        if (USER_HANDLE_CLASS == null)
        {
            return 0;
        }
        int i;
        try
        {
            i = ((Integer)(new ReflectionHelper()).invokeStatic("getCallingUserId", "android.os.UserHandle", new Class[0], new Object[0])).intValue();
        }
        catch (com.amazon.identity.auth.device.utils.ReflectionHelper.CannotCallMethodException cannotcallmethodexception)
        {
            MAPLog.formattedError(TAG, "Cannot get getCallingUserId static field. Error: %s", new Object[] {
                cannotcallmethodexception.getMessage()
            });
            return 0;
        }
        return i;
    }

    public static int getCurrentUserId()
    {
        int i;
        try
        {
            i = ((Integer)(new ReflectionHelper()).invokeStatic("getCurrentUser", android/app/ActivityManager, new Class[0], new Object[0])).intValue();
        }
        catch (com.amazon.identity.auth.device.utils.ReflectionHelper.CannotCallMethodException cannotcallmethodexception)
        {
            String s = TAG;
            return 0;
        }
        return i;
    }

    public static int getMyUserId()
    {
        if (USER_HANDLE_CLASS == null)
        {
            return 0;
        }
        int i;
        try
        {
            i = ((Integer)(new ReflectionHelper()).invokeStatic("myUserId", "android.os.UserHandle", new Class[0], new Object[0])).intValue();
        }
        catch (com.amazon.identity.auth.device.utils.ReflectionHelper.CannotCallMethodException cannotcallmethodexception)
        {
            MAPLog.formattedError(TAG, "Cannot get myUserId static field. Error: %s", new Object[] {
                cannotcallmethodexception.getMessage()
            });
            return 0;
        }
        return i;
    }

    public static int getOwnerId()
    {
        if (OWNER_ID == null)
        {
            return 0;
        } else
        {
            return OWNER_ID.intValue();
        }
    }

    private static Integer getOwnerId(Class class1)
    {
        if (USER_HANDLE_CLASS == null)
        {
            class1 = TAG;
            return null;
        }
        try
        {
            class1 = (Integer)(new ReflectionHelper()).getStaticField(class1, "USER_OWNER");
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            MAPLog.formattedError(TAG, "Cannot get USER_OWNER static field. Error: %s", new Object[] {
                class1.getMessage()
            });
            return null;
        }
        return class1;
    }

    private static Class getUserHandleClass()
    {
        Class class1;
        try
        {
            class1 = Class.forName("android.os.UserHandle");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            String s = TAG;
            return null;
        }
        return class1;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof AndroidUser))
        {
            if (mUserHandleId == ((AndroidUser) (obj = (AndroidUser)obj)).mUserHandleId)
            {
                return true;
            }
        }
        return false;
    }

    public UserHandle getUserHandle()
    {
        return mAndroidUserHandle;
    }

    public int getUserId()
    {
        return mUserHandleId;
    }

    public int hashCode()
    {
        return mUserHandleId + 31;
    }

    static 
    {
        USER_HANDLE_CLASS = getUserHandleClass();
        OWNER_ID = getOwnerId(USER_HANDLE_CLASS);
    }
}
