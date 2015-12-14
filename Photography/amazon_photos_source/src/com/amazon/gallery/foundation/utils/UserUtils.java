// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils;

import android.os.Process;
import android.os.UserHandle;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserUtils
{

    private static final String TAG = com/amazon/gallery/foundation/utils/UserUtils.getName();

    public UserUtils()
    {
    }

    public static int getCurrentUserId()
    {
        UserHandle userhandle = Process.myUserHandle();
        int i = ((Integer)android/os/UserHandle.getMethod("getIdentifier", new Class[0]).invoke(userhandle, new Object[0])).intValue();
        return i;
        Object obj;
        obj;
_L2:
        GLogger.ex(TAG, "Failed to find method UserManager#getUserHandle", ((Throwable) (obj)));
        throw new RuntimeException(((Throwable) (obj)));
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
