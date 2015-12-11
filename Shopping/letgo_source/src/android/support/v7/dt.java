// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;

public abstract class dt
{

    final Context a;

    public dt(Context context)
    {
        a = context;
    }

    public abstract CountryCurrencyInfo a(String s);

    public abstract void a();
}
