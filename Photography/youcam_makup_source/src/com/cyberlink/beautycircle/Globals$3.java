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

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected Void a(Void void1)
    {
        Globals.D().edit().putInt("NumOfLaunch", Globals.F()).apply();
        return null;
    }

    tor()
    {
    }
}
