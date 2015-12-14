// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.content.SharedPreferences;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle:
//            Globals

class a extends j
{

    final Globals a;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected Void a(Void void1)
    {
        void1 = Globals.D();
        if (Globals.r())
        {
            Globals.d("DEMO1");
        } else
        {
            String s = void1.getString("BC_Server_Mode", "PRODUCTION");
            if (s == null)
            {
                Globals.d("PRODUCTION");
            } else
            {
                Globals.d(s);
            }
        }
        Globals.n = Boolean.valueOf(void1.getBoolean("IsFirstTime", true));
        Globals.o = void1.getBoolean("ViewedHowTo", false);
        Globals.c(void1.getInt("NumOfLaunch", 1));
        return null;
    }

    (Globals globals)
    {
        a = globals;
        super();
    }
}
