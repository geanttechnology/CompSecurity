// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;

public class x
{

    public static int a(Context context)
    {
        int j = a(context, "AndroidManifest.xml", "application", "logo");
        int i = j;
        if (j == 0)
        {
            i = context.getApplicationInfo().icon;
        }
        return i;
    }

    private static int a(Context context, String s, String s1, String s2)
    {
        int i;
        int j;
        i = 0;
        j = i;
        context = context.createPackageContext(context.getApplicationInfo().packageName, 0).getAssets().openXmlResourceParser(s);
        j = i;
        int k = context.getEventType();
        i = 0;
        j = k;
_L12:
        k = i;
        if (j == 1) goto _L2; else goto _L1
_L1:
        if (j != 2) goto _L4; else goto _L3
_L3:
        if (!s1.equals(context.getName())) goto _L4; else goto _L5
_L5:
        j = context.getAttributeCount() - 1;
_L8:
        if (j < 0) goto _L4; else goto _L6
_L6:
        if (!s2.equals(context.getAttributeName(j)))
        {
            break MISSING_BLOCK_LABEL_139;
        }
        j = context.getAttributeResourceValue(j, 0);
        i = j;
_L4:
        j = i;
        k = context.nextToken();
        j = k;
        continue; /* Loop/switch isn't completed */
        j--;
        if (true) goto _L8; else goto _L7
_L7:
        context;
        i = j;
_L10:
        context.printStackTrace();
        k = i;
_L2:
        return k;
        context;
        if (true) goto _L10; else goto _L9
_L9:
        if (true) goto _L12; else goto _L11
_L11:
    }
}
