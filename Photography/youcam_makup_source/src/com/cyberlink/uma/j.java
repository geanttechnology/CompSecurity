// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma;

import android.content.Context;
import android.content.SharedPreferences;

// Referenced classes of package com.cyberlink.uma:
//            k

class j
    implements k
{

    private final Context a;

    j(Context context)
    {
        a = context;
    }

    public String a()
    {
        return b().getString("ID", "");
    }

    public void a(String s)
    {
        android.content.SharedPreferences.Editor editor = b().edit();
        editor.putString("ID", s);
        editor.apply();
    }

    SharedPreferences b()
    {
        return a.getSharedPreferences("UMA_ID", 0);
    }
}
