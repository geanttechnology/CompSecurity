// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.account;

import android.content.Context;
import com.amazon.mixtape.database.AccountsDatabaseHelper;
import com.amazon.mixtape.utils.LazyWithParam;

// Referenced classes of package com.amazon.mixtape.account:
//            AccountContextFactory

public static class Q extends LazyWithParam
{

    protected AccountsDatabaseHelper instantiateItem(Context context)
    {
        return new AccountsDatabaseHelper(context.getApplicationContext());
    }

    protected volatile Object instantiateItem(Object obj)
    {
        return instantiateItem((Context)obj);
    }

    public Q()
    {
    }
}
