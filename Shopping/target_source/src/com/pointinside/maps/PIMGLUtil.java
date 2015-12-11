// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.pointinside.internal.utils.AndroidUtils;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.maps.model.TextHeadingStyle;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class PIMGLUtil
{

    private static final String LOG_TAG = com/pointinside/maps/PIMGLUtil.getSimpleName();

    PIMGLUtil()
    {
    }

    static String errorIntToString(int i)
    {
        switch (i)
        {
        default:
            return "Unknown error type";

        case 0: // '\0'
            return "None";

        case 1: // '\001'
            return "Invalid";

        case 2: // '\002'
            return "MissingContext";

        case 3: // '\003'
            return "MissingLuaMethod";

        case 4: // '\004'
            return "NoSuchFeature";

        case 5: // '\005'
            return "NoSuchFile";

        case 6: // '\006'
            return "SVGParserError";

        case 7: // '\007'
            return "UnexpectedParam";

        case 8: // '\b'
            return "TesselationError";

        case 9: // '\t'
            return "TesselationWarning";
        }
    }

    static String getRawAssetsPath(Context context)
    {
        try
        {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            if (AndroidUtils.isJellyBean())
            {
                return ((ApplicationInfo) (context)).sourceDir;
            }
            context = ((ApplicationInfo) (context)).publicSourceDir;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            LogUtils.logE("PIMapsAccessor", Log.getStackTraceString(context));
            return null;
        }
        return context;
    }

    static Map getTextHeadingToStyleMap()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("h1", new TextHeadingStyle());
        hashmap.put("h2", new TextHeadingStyle());
        hashmap.put("h3", (new TextHeadingStyle()).setSize(9F));
        hashmap.put("h4", (new TextHeadingStyle()).setSize(5.5F));
        return hashmap;
    }

    static boolean validate(int i)
    {
        if (i != 0)
        {
            LogUtils.logE(LOG_TAG, (new StringBuilder()).append("PIMGL error occured - ").append(errorIntToString(i)).toString());
            String s = Arrays.toString(Thread.currentThread().getStackTrace());
            LogUtils.logE(LOG_TAG, s);
            return false;
        } else
        {
            return true;
        }
    }

}
