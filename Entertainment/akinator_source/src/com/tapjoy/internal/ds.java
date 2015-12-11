// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.Serializable;

// Referenced classes of package com.tapjoy.internal:
//            dl, do

public abstract class ds extends dl
    implements Serializable
{
    public static abstract class a extends dl.a
    {

        public do a;

        public dl.a a()
        {
            return b();
        }

        public a b()
        {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public final do c()
        {
            return a;
        }

        public Object clone()
        {
            return b();
        }

        public a()
        {
            a = do.a;
        }
    }


    public ds()
    {
    }

    public ds(byte byte0)
    {
    }
}
