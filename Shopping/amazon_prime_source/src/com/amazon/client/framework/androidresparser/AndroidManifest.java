// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.androidresparser;

import android.os.Bundle;

public class AndroidManifest
{

    public static final String ANDROID_MANIFEST_FILENAME = "AndroidManifest.xml";
    public static final String ANDROID_NAMESPACE_URI = "http://schemas.android.com/apk/res/android";
    private final Bundle mMetaData;
    private final String mPackageName;
    private final Integer mVersionCode;

    AndroidManifest(String s, Integer integer, Bundle bundle)
    {
        mPackageName = s;
        mVersionCode = integer;
        mMetaData = bundle;
    }

    static String validateName(String s, boolean flag)
    {
        int i;
        boolean flag2;
        boolean flag4;
        int j;
        j = s.length();
        flag2 = false;
        flag4 = true;
        i = 0;
_L2:
        char c;
        boolean flag1;
        boolean flag3;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        c = s.charAt(i);
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = false;
        flag3 = flag2;
_L7:
        i++;
        flag4 = flag1;
        flag2 = flag3;
        if (true) goto _L2; else goto _L1
_L1:
        if (flag4) goto _L4; else goto _L3
_L3:
        if (c < '0') goto _L6; else goto _L5
_L5:
        flag1 = flag4;
        flag3 = flag2;
        if (c <= '9') goto _L7; else goto _L6
_L6:
        flag1 = flag4;
        flag3 = flag2;
        if (c == '_') goto _L7; else goto _L4
_L4:
        if (c == '.')
        {
            flag3 = true;
            flag1 = true;
        } else
        {
            return (new StringBuilder()).append("bad character '").append(c).append("'").toString();
        }
          goto _L7
        if (flag2 || !flag)
        {
            return null;
        } else
        {
            return "must have at least one '.' separator";
        }
    }

    public Bundle getMetaData()
    {
        return mMetaData;
    }

    public String getPackageName()
    {
        return mPackageName;
    }

    public Integer getVersionCode()
    {
        return mVersionCode;
    }

    public int getVersionCodeOrDefault(int i)
    {
        if (mVersionCode == null)
        {
            return i;
        } else
        {
            return mVersionCode.intValue();
        }
    }
}
