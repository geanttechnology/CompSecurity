// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.content.res.Resources;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class ResourceHelper
{
    public static class ResourceNotFoundException extends RuntimeException
    {

        public ResourceNotFoundException(String s)
        {
            super(s);
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/utils/ResourceHelper.getName();

    private ResourceHelper()
    {
    }

    public static int getAnimId(Context context, String s)
    {
        return getResourceId(context, "anim", s);
    }

    public static int getId(Context context, String s)
    {
        return getResourceId(context, "id", s);
    }

    public static int getLayoutId(Context context, String s)
    {
        return getResourceId(context, "layout", s);
    }

    public static int getResourceId(Context context, String s, String s1)
    {
        int i = context.getResources().getIdentifier(s1, s, context.getPackageName());
        if (i == 0)
        {
            MAPLog.w(TAG, String.format("The %s resource %s has not been found", new Object[] {
                s, s1
            }));
            throw new ResourceNotFoundException(String.format("%s Resource %s not found", new Object[] {
                s, s1
            }));
        } else
        {
            return i;
        }
    }

    public static String getString(Context context, String s)
    {
        Resources resources = context.getResources();
        int i = resources.getIdentifier(s, "string", context.getPackageName());
        if (i == 0)
        {
            MAPLog.w(TAG, String.format("The String resource %s has not been found", new Object[] {
                s
            }));
            throw new ResourceNotFoundException(String.format("String Resource %s not found", new Object[] {
                s
            }));
        } else
        {
            return resources.getString(i);
        }
    }

    public static String getStringOrDefault(Context context, String s, String s1)
    {
        try
        {
            context = getString(context, s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return s1;
        }
        return context;
    }

}
