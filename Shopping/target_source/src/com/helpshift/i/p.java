// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.text.TextUtils;
import com.helpshift.g.b.a;
import com.helpshift.l;
import com.helpshift.s;
import java.util.Map;

public final class p
{

    public static boolean a(l l1)
    {
        if (l1.a.L().booleanValue()) goto _L2; else goto _L1
_L1:
        String s1;
        String s2;
        Boolean boolean1;
        s1 = l1.C();
        s2 = l1.D();
        boolean1 = l1.a.O();
        if (!((Boolean)a.b.get("rne")).booleanValue()) goto _L4; else goto _L3
_L3:
        if (!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2)) goto _L6; else goto _L5
_L5:
        return true;
_L6:
        boolean flag;
        if (!boolean1.booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
_L4:
        if (!((Boolean)a.b.get("pfe")).booleanValue())
        {
            return false;
        }
        if (boolean1.booleanValue() && (!l1.a.K().booleanValue() || !TextUtils.isEmpty(s2)) && !TextUtils.isEmpty(s1))
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!((Boolean)a.b.get("pfe")).booleanValue())
        {
            return false;
        }
        if (true) goto _L5; else goto _L7
_L7:
    }

    public static boolean a(s s1)
    {
        return ((Boolean)a.b.get("pfe")).booleanValue();
    }

    public static boolean b(s s1)
    {
        return !s1.L().booleanValue() && (((Boolean)a.b.get("rne")).booleanValue() || ((Boolean)a.b.get("pfe")).booleanValue() && s1.K().booleanValue());
    }
}
