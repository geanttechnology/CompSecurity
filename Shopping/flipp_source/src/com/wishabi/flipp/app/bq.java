// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.ContentResolver;
import android.content.Context;
import com.wishabi.flipp.b.am;

// Referenced classes of package com.wishabi.flipp.app:
//            bo

final class bq extends am
{

    final bo a;

    bq(bo bo1, ContentResolver contentresolver, String s, String s1, Context context)
    {
        a = bo1;
        super(contentresolver, s, s1, context);
    }

    protected final void onPostExecute(Object obj)
    {
        bo.a(a);
        bo.b(a);
        a.c();
    }
}
