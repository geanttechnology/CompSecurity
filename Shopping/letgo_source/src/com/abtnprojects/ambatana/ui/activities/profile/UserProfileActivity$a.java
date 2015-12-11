// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.l;
import com.abtnprojects.ambatana.ui.fragments.i;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.profile:
//            UserProfileActivity

private static class <init> extends l
{

    private final String a;
    private final Context b;

    public Fragment a(int j)
    {
        return i.a(values()[j], a);
    }

    public int b()
    {
        return 3;
    }

    public CharSequence c(int j)
    {
        switch (j)
        {
        default:
            throw new IllegalArgumentException("Invalid tab position max is 2");

        case 0: // '\0'
            return b.getString(0x7f0901c3);

        case 1: // '\001'
            return b.getString(0x7f0901c4);

        case 2: // '\002'
            return b.getString(0x7f0901c2);
        }
    }

    private (android.support.v4.app.i j, String s, Context context)
    {
        super(j);
        a = s;
        b = context;
    }

    b(android.support.v4.app.i j, String s, Context context, b b1)
    {
        this(j, s, context);
    }
}
