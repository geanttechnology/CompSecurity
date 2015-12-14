// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.Context;
import android.content.SharedPreferences;

// Referenced classes of package com.socialin.android.util:
//            a

public final class a extends Thread
{

    private a a;

    public final void run()
    {
        Object obj = a;
        int i = ((a) (obj)).a.getSharedPreferences(((a) (obj)).b, 0).getInt("visitsCount", 0);
        obj = a.a.getSharedPreferences(a.b, 0).edit();
        ((android.content.edPreferences.Editor) (obj)).putInt("visitsCount", i + 1);
        ((android.content.edPreferences.Editor) (obj)).commit();
    }

    public ces.Editor(a a1)
    {
        a = a1;
        super();
    }
}
