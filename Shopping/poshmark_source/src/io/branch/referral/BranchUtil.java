// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class BranchUtil
{

    BranchUtil()
    {
    }

    public static JSONObject filterOutBadCharacters(JSONObject jsonobject)
    {
        JSONObject jsonobject1 = new JSONObject();
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = jsonobject.keys();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        String s = (String)iterator.next();
        if (jsonobject.has(s) && jsonobject.get(s).getClass().equals(java/lang/String))
        {
            jsonobject1.put(s, jsonobject.getString(s).replace("\n", "\\n").replace("\r", "\\r").replace("\"", "\\\""));
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            if (jsonobject.has(s))
            {
                jsonobject1.put(s, jsonobject.get(s));
            }
        }
        catch (JSONException jsonexception) { }
        continue; /* Loop/switch isn't completed */
_L2:
        return jsonobject1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static String formatAndStringifyLinkParam(JSONObject jsonobject)
    {
        return stringifyAndAddSource(filterOutBadCharacters(jsonobject));
    }

    public static Drawable getDrawable(Context context, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return context.getResources().getDrawable(i, context.getTheme());
        } else
        {
            return context.getResources().getDrawable(i);
        }
    }

    public static boolean isTestModeEnabled(Context context)
    {
        boolean flag = false;
        try
        {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (((ApplicationInfo) (context)).metaData != null)
            {
                flag = ((ApplicationInfo) (context)).metaData.getBoolean("io.branch.sdk.TestMode", false);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return flag;
    }

    public static String stringifyAndAddSource(JSONObject jsonobject)
    {
        JSONObject jsonobject1 = jsonobject;
        if (jsonobject == null)
        {
            jsonobject1 = new JSONObject();
        }
        try
        {
            jsonobject1.put("source", "android");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
        if (!(jsonobject1 instanceof JSONObject))
        {
            return jsonobject1.toString();
        } else
        {
            return JSONObjectInstrumentation.toString((JSONObject)jsonobject1);
        }
    }
}
