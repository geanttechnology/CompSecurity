// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.f;

import android.content.Intent;

// Referenced classes of package com.shazam.android.k.f:
//            i

public class j
{

    private static final String a = (new StringBuilder()).append(com/shazam/android/k/f/j.getSimpleName()).append("_PARAM_LAUNCHING_EXTRAS").toString();

    public j()
    {
    }

    public static i a(Intent intent)
    {
        intent = (i)intent.getSerializableExtra(a);
        if (intent != null)
        {
            return intent;
        } else
        {
            return (new i.a()).a();
        }
    }

    public static void a(i k, Intent intent)
    {
        intent.putExtra(a, k);
    }

}
