// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.d.iq;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.PlusSession;
import com.google.android.gms.plus.internal.d;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus:
//            d

static final class i.a.b extends com.google.android.gms.common.api..h
{

    public final int a()
    {
        return 2;
    }

    public final com.google.android.gms.common.api..h a(Context context, Looper looper, h h1, Object obj, com.google.android.gms.common.api..h h2, com.google.android.gms.common.api..h h3)
    {
        Object obj1 = (i.ession)obj;
        obj = obj1;
        if (obj1 == null)
        {
            obj = new <init>((byte)0);
        }
        obj1 = h1.a().name;
        String as[] = iq.a(h1.c);
        obj = (String[])((ternal.h.c) (obj)).b.toArray(new String[0]);
        String s = context.getPackageName();
        String s1 = context.getPackageName();
        PlusCommonExtras pluscommonextras = new PlusCommonExtras();
        return new d(context, looper, h1, new PlusSession(((String) (obj1)), as, ((String []) (obj)), new String[0], s, s1, pluscommonextras), h2, h3);
    }

    i.a.b()
    {
    }
}
