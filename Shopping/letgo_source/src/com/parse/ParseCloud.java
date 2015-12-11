// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseException, ParseTaskUtils, ParseUser, ParseCorePlugins, 
//            FunctionCallback, ParseCloudCodeController

public final class ParseCloud
{

    private ParseCloud()
    {
    }

    public static Object callFunction(String s, Map map)
        throws ParseException
    {
        return ParseTaskUtils.wait(callFunctionInBackground(s, map));
    }

    public static cu callFunctionInBackground(String s, Map map)
    {
        return ParseUser.getCurrentSessionTokenAsync().d(new ct(s, map) {

            final String val$name;
            final Map val$params;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (String)cu1.e();
                return ParseCloud.getCloudCodeController().callFunctionInBackground(name, params, cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                name = s;
                params = map;
                super();
            }
        });
    }

    public static void callFunctionInBackground(String s, Map map, FunctionCallback functioncallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(callFunctionInBackground(s, map), functioncallback);
    }

    static ParseCloudCodeController getCloudCodeController()
    {
        return ParseCorePlugins.getInstance().getCloudCodeController();
    }
}
