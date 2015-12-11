// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.util.Set;

// Referenced classes of package com.millennialmedia.android:
//            a, r

static final class <init> extends <init>
{

    final Context a;
    final Set b;

    final boolean a(r r1)
    {
        if (r1.b != null && r1.c() == 1 && r1.c(a))
        {
            b.add(r1.b);
        }
        return true;
    }

    (Context context, Set set)
    {
        a = context;
        b = set;
        super();
    }
}
