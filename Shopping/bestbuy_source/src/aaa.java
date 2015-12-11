// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.gu;

public final class aaa
{

    public static abn a(Context context, ahi ahi, abe abe1, gu gu, wd wd, aab aab)
    {
        if (abe1.b.t)
        {
            context = new aaq(context, ahi, new st(), abe1, aab);
        } else
        {
            context = new aac(context, abe1, gu, wd, aab);
        }
        context.e();
        return context;
    }
}
