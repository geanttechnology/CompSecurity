// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class FeatureUtil
{

    private static Map featureMap = new HashMap();

    public FeatureUtil()
    {
    }

    private static String getFeatureName(String s)
    {
        return (new StringBuilder()).append("feature_").append(s).toString();
    }

    public static boolean isFeatureEnabled(String s)
    {
        boolean flag = false;
        s = getFeatureName(s);
        if (featureMap.containsKey(s))
        {
            flag = ((Boolean)featureMap.get(s)).booleanValue();
        }
        return flag;
    }

    public static void loadFromRawFile(Context context)
    {
        int i;
        String s = context.getPackageName();
        i = context.getResources().getIdentifier("feature_settings", "raw", s);
        if (i == 0) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = XmlPullParserFactory.newInstance();
        ((XmlPullParserFactory) (obj)).setNamespaceAware(true);
        obj = ((XmlPullParserFactory) (obj)).newPullParser();
        ((XmlPullParser) (obj)).setInput(new InputStreamReader(context.getResources().openRawResource(i)));
        i = ((XmlPullParser) (obj)).getEventType();
          goto _L3
_L5:
        i = ((XmlPullParser) (obj)).next();
          goto _L3
_L6:
        if (i != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!"feature".equals(((XmlPullParser) (obj)).getName()))
        {
            break; /* Loop/switch isn't completed */
        }
        context = ((XmlPullParser) (obj)).getAttributeValue(null, "name");
        boolean flag;
        if (((XmlPullParser) (obj)).getAttributeValue(null, "value").equals("true"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            setFeatureEnabled(context, flag);
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("FeatureUtil", "Exception when initializing XML parser.");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("FeatureUtil", "Exception when parsing XML.");
            return;
        }
_L2:
        return;
_L3:
        if (i == 1) goto _L2; else goto _L4
_L4:
        if (i != 0) goto _L6; else goto _L5
    }

    public static void setFeatureEnabled(String s, boolean flag)
    {
        s = getFeatureName(s);
        if (featureMap.containsKey(s))
        {
            featureMap.remove(s);
        }
        featureMap.put(s, Boolean.valueOf(flag));
    }

}
