// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.content.SharedPreferences;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle:
//            Globals

final class tor extends j
{

    protected Boolean a(Void void1)
    {
        boolean flag = false;
        void1 = Globals.G();
        Globals.D().edit().putString("BC_Server_Mode", void1).commit();
        Globals.d(Globals.G());
        flag = true;
_L2:
        return Boolean.valueOf(flag);
        void1;
        void1.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    tor()
    {
    }
}
