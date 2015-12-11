// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.b;

import android.content.res.Resources;
import java.util.Scanner;

public final class k
{

    public static boolean a(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean a(StringBuilder stringbuilder, Resources resources, int i)
    {
        resources = (new Scanner(resources.openRawResource(i), "UTF-8")).useDelimiter("\\A");
        if (resources.hasNext())
        {
            stringbuilder.append(resources.next());
            resources.close();
            return true;
        } else
        {
            resources.close();
            return false;
        }
    }
}
