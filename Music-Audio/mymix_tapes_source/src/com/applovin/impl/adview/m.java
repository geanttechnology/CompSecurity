// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.util.AttributeSet;
import com.applovin.sdk.AppLovinAdSize;

class m
{

    static AppLovinAdSize a(AttributeSet attributeset)
    {
        if (attributeset != null)
        {
            if ((attributeset = attributeset.getAttributeValue("http://schemas.applovin.com/android/1.0", "size")) != null)
            {
                return AppLovinAdSize.fromString(attributeset);
            }
        }
        return null;
    }

    static boolean b(AttributeSet attributeset)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (attributeset != null)
        {
            flag = flag1;
            if (attributeset.getAttributeBooleanValue("http://schemas.applovin.com/android/1.0", "loadAdOnCreate", false))
            {
                flag = true;
            }
        }
        return flag;
    }
}
