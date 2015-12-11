// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.a;

import com.smule.android.console.n;
import com.smule.android.console.o;
import com.smule.pianoandroid.e.e;

public class d
    implements n
{

    public d()
    {
    }

    public String a()
    {
        return "level";
    }

    public String a(String as[])
    {
        e e1 = e.a();
        if (as != null && as.length > 1)
        {
            if (as[1].equals("xp"))
            {
                int i = 10;
                Integer integer = null;
                if (as.length == 3)
                {
                    integer = Integer.valueOf(Integer.parseInt(as[2]));
                }
                if (integer != null)
                {
                    i = integer.intValue();
                }
                e1.b(i);
                return (new StringBuilder()).append("Earned ").append(i).append(" XP, current level: ").append(e1.f()).append(", XP: ").append(e1.e()).toString();
            }
            if (as[1].equals("reset"))
            {
                e.a().d();
                return (new StringBuilder()).append("Reset level and xp. Current level: ").append(e1.f()).append(", XP: ").append(e1.e()).toString();
            } else
            {
                return o.a(this);
            }
        } else
        {
            return (new StringBuilder()).append("Current level: ").append(e1.f()).append(", XP: ").append(e1.e()).toString();
        }
    }
}
