// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// Referenced classes of package android.support.v7:
//            adh, ls, lt, ado

class aco extends adh
{

    private static final String a;
    private static final String b;

    public aco()
    {
        super(a);
    }

    protected boolean a(String s, String s1, Map map)
    {
        byte byte0;
        boolean flag;
        if (ado.d((lv.a)map.get(b)).booleanValue())
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
        a = ls.Z.toString();
        b = lt.bh.toString();
    }
}
