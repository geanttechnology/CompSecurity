// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.internal.g;
import java.util.regex.Pattern;

public class vv
{

    private static final Pattern a = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean a(String s)
    {
        return s == null || g.a.b(s);
    }

}
