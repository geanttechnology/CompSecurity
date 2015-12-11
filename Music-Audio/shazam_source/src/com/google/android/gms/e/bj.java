// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.e;
import com.google.android.gms.d.f;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// Referenced classes of package com.google.android.gms.e:
//            cc, cj

final class bj extends cc
{

    private static final String b;
    private static final String c;

    public bj()
    {
        super(b);
    }

    protected final boolean a(String s, String s1, Map map)
    {
        byte byte0;
        boolean flag;
        if (cj.d((com.google.android.gms.d.h.a)map.get(c)).booleanValue())
        {
            byte0 = 66;
        } else
        {
            byte0 = 64;
        }
        try
        {
            flag = Pattern.compile(s1, byte0).matcher(s).find();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return flag;
    }

    static 
    {
        b = e.Z.toString();
        c = f.bh.toString();
    }
}
