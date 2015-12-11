// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            an, r, al

static final class init> extends init>
{

    final Context a;

    final boolean a(r r1)
    {
        String s1 = r1.d();
        String s2 = r1.a;
        String s;
        if (r1.c(a))
        {
            s = "";
        } else
        {
            s = "not ";
        }
        if (r1.a())
        {
            r1 = "";
        } else
        {
            r1 = "not ";
        }
        String.format("%s %s is %son disk. Is %sexpired.", new Object[] {
            s1, s2, s, r1
        });
        al.c();
        return true;
    }

    (Context context)
    {
        a = context;
        super();
    }
}
