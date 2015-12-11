// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;

// Referenced classes of package android.support.v4.app:
//            p

public abstract class o
{
    public static interface a
    {

        public abstract android.support.v7.o a(int i, Bundle bundle);

        public abstract void a(android.support.v7.o o1);

        public abstract void a(android.support.v7.o o1, Object obj);
    }


    public o()
    {
    }

    public static void a(boolean flag)
    {
        p.a = flag;
    }

    public abstract android.support.v7.o a(int i, Bundle bundle, a a1);

    public abstract void a(int i);

    public boolean a()
    {
        return false;
    }

    public abstract android.support.v7.o b(int i);

    public abstract android.support.v7.o b(int i, Bundle bundle, a a1);
}
