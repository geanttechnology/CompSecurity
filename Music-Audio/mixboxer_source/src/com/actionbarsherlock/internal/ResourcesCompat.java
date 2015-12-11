// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.DisplayMetrics;

// Referenced classes of package com.actionbarsherlock.internal:
//            ActionBarSherlockCompat

public final class ResourcesCompat
{

    private static final String TAG = "ResourcesCompat";

    private ResourcesCompat()
    {
    }

    public static boolean getResources_getBoolean(Context context, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            return context.getResources().getBoolean(i);
        }
        context = context.getResources().getDisplayMetrics();
        float f1 = (float)((DisplayMetrics) (context)).widthPixels / ((DisplayMetrics) (context)).density;
        float f2 = (float)((DisplayMetrics) (context)).heightPixels / ((DisplayMetrics) (context)).density;
        float f = f2;
        if (f1 < f2)
        {
            f = f1;
        }
        if (i == com.actionbarsherlock.R.bool.abs__action_bar_embed_tabs)
        {
            return f1 >= 480F;
        }
        if (i == com.actionbarsherlock.R.bool.abs__split_action_bar_is_narrow)
        {
            return f1 < 480F;
        }
        if (i == com.actionbarsherlock.R.bool.abs__action_bar_expanded_action_views_exclusive)
        {
            return f < 600F;
        }
        if (i == com.actionbarsherlock.R.bool.abs__config_allowActionMenuItemTextWithIcon)
        {
            return f1 >= 480F;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown boolean resource ID ").append(i).toString());
        }
    }

    public static int getResources_getInteger(Context context, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            return context.getResources().getInteger(i);
        }
        context = context.getResources().getDisplayMetrics();
        float f = (float)((DisplayMetrics) (context)).widthPixels / ((DisplayMetrics) (context)).density;
        if (i == com.actionbarsherlock.R.integer.abs__max_action_buttons)
        {
            if (f >= 600F)
            {
                return 5;
            }
            if (f >= 500F)
            {
                return 4;
            }
            return f < 360F ? 2 : 3;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown integer resource ID ").append(i).toString());
        }
    }

    public static int loadLogoFromManifest(Activity activity)
    {
        String s1;
        String s2;
        XmlResourceParser xmlresourceparser;
        int l;
        s1 = activity.getClass().getName();
        (new StringBuilder()).append("Parsing AndroidManifest.xml for ").append(s1).toString();
        s2 = activity.getApplicationInfo().packageName;
        xmlresourceparser = activity.createPackageContext(s2, 0).getAssets().openXmlResourceParser("AndroidManifest.xml");
        l = xmlresourceparser.getEventType();
        int i = 0;
_L11:
        int j = i;
        if (l == 1) goto _L2; else goto _L1
_L1:
        int k = i;
        if (l != 2) goto _L4; else goto _L3
_L3:
        Object obj;
        boolean flag;
        boolean flag1;
        j = i;
        String s;
        String s3;
        boolean flag2;
        try
        {
            activity = xmlresourceparser.getName();
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            i = j;
            continue; /* Loop/switch isn't completed */
        }
        j = i;
        if (!"application".equals(activity)) goto _L6; else goto _L5
_L5:
        j = i;
        k = xmlresourceparser.getAttributeCount() - 1;
_L12:
        if (k < 0) goto _L8; else goto _L7
_L7:
        j = i;
        (new StringBuilder()).append(xmlresourceparser.getAttributeName(k)).append(": ").append(xmlresourceparser.getAttributeValue(k)).toString();
        j = i;
        if (!"logo".equals(xmlresourceparser.getAttributeName(k))) goto _L10; else goto _L9
_L9:
        j = i;
        i = xmlresourceparser.getAttributeResourceValue(k, 0);
_L8:
        l = xmlresourceparser.nextToken();
          goto _L11
_L10:
        k--;
          goto _L12
_L6:
        k = i;
        j = i;
        if (!"activity".equals(activity)) goto _L4; else goto _L13
_L13:
        j = i;
        k = xmlresourceparser.getAttributeCount() - 1;
        flag = false;
        s = null;
        activity = null;
_L22:
        if (k < 0) goto _L15; else goto _L14
_L14:
        j = i;
        (new StringBuilder()).append(xmlresourceparser.getAttributeName(k)).append(": ").append(xmlresourceparser.getAttributeValue(k)).toString();
        j = i;
        s3 = xmlresourceparser.getAttributeName(k);
        j = i;
        if (!"logo".equals(s3)) goto _L17; else goto _L16
_L16:
        j = i;
        obj = Integer.valueOf(xmlresourceparser.getAttributeResourceValue(k, 0));
        flag1 = flag;
_L18:
        j = i;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_542;
        }
        j = i;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_542;
        }
        j = i;
        i = ((Integer) (obj)).intValue();
        j = i;
        break MISSING_BLOCK_LABEL_542;
_L17:
        flag1 = flag;
        obj = activity;
        j = i;
        if (!"name".equals(s3))
        {
            continue; /* Loop/switch isn't completed */
        }
        j = i;
        s = ActionBarSherlockCompat.cleanActivityName(s2, xmlresourceparser.getAttributeValue(k));
        j = i;
        flag2 = s1.equals(s);
        if (!flag2)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = true;
        obj = activity;
        if (true) goto _L18; else goto _L15
_L15:
        j = i;
        if (flag) goto _L2; else goto _L19
_L19:
        k = i;
_L4:
        i = k;
          goto _L8
        activity;
        i = 0;
_L21:
        activity.printStackTrace();
        j = i;
_L2:
        (new StringBuilder()).append("Returning ").append(Integer.toHexString(j)).toString();
        return j;
        activity;
        if (true) goto _L21; else goto _L20
_L20:
        k--;
        i = j;
        flag = flag1;
        activity = ((Activity) (obj));
          goto _L22
    }
}
