// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.gs;

public final class aae
{

    public static abn a(Context context, fh fh1, aaf aaf)
    {
        if (fh1.k.e)
        {
            return b(context, fh1, aaf);
        } else
        {
            return c(context, fh1, aaf);
        }
    }

    private static abn b(Context context, fh fh1, aaf aaf)
    {
        acb.a("Fetching ad response from local ad request service.");
        context = new aah(context, fh1, aaf);
        context.e();
        return context;
    }

    private static abn c(Context context, fh fh1, aaf aaf)
    {
        acb.a("Fetching ad response from remote ad request service.");
        if (pu.a(context) != 0)
        {
            acb.e("Failed to connect to remote ad request service.");
            return null;
        } else
        {
            return new aai(context, fh1, aaf);
        }
    }
}
