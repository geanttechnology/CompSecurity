// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public abstract class ye
{

    public ye()
    {
    }

    public static ye a(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            return new yg(context);
        } else
        {
            return new yf(context);
        }
    }

    public abstract void a(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2);

    public abstract void a(boolean flag);

    public abstract boolean a();

    public abstract int b();

    public abstract int c();
}
