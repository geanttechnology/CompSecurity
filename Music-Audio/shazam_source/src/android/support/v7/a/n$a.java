// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.content.Context;

// Referenced classes of package android.support.v7.a:
//            n

public static final class nit> extends android.support.v4.app.t>
{

    protected final android.support.v4.app.t> c()
    {
        if (android.os.d.VERSION.SDK_INT >= 21)
        {
            return new <init>((byte)0);
        }
        if (android.os.d.VERSION.SDK_INT >= 16)
        {
            return new <init>((byte)0);
        }
        if (android.os.d.VERSION.SDK_INT >= 14)
        {
            return new <init>((byte)0);
        } else
        {
            return super.c();
        }
    }

    public e(Context context)
    {
        super(context);
    }
}
