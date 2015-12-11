// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.content.Context;

// Referenced classes of package com.smule.pianoandroid.utils:
//            l

public class k
{

    private static final String a = com/smule/pianoandroid/utils/k.getName();

    public k()
    {
    }

    public static l a(Context context)
    {
        return l.valueOf(context.getApplicationContext().getString(0x7f0c017d).toUpperCase());
    }

}
