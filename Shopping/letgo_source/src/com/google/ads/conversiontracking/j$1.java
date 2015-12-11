// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.ads.conversiontracking:
//            j

static final class d
    implements Runnable
{

    final SharedPreferences a;
    final List b;
    final ommit c;
    final String d;

    public void run()
    {
        android.content.edPreferences.Editor editor = a.edit();
        for (Iterator iterator = b.iterator(); iterator.hasNext(); editor.remove((String)iterator.next())) { }
        editor.putString(a(c), d);
        editor.commit();
    }

    or(SharedPreferences sharedpreferences, List list, or or, String s)
    {
        a = sharedpreferences;
        b = list;
        c = or;
        d = s;
        super();
    }
}
