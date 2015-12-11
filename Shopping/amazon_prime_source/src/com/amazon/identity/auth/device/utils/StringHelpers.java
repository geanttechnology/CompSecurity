// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class StringHelpers
{

    public static String join(String s, Collection collection)
    {
        if (collection == null)
        {
            return null;
        } else
        {
            return TextUtils.join(s, collection);
        }
    }

    public static Set splitToSet(String s, String s1)
    {
        if (TextUtils.isEmpty(s))
        {
            s = new String[0];
        } else
        {
            s = TextUtils.split(s, s1);
        }
        return new HashSet(Arrays.asList(s));
    }
}
