// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import com.google.a.a.e;
import com.target.b.a;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;

public class g
{
    public static class a
    {

        public final boolean isInStore;

        public a(boolean flag)
        {
            isInStore = flag;
        }
    }


    private final com.target.b.a mCurrentStoreProvider;

    public g(com.target.b.a a1)
    {
        mCurrentStoreProvider = a1;
    }

    public a a()
    {
        e e1 = (e)mCurrentStoreProvider.b();
        boolean flag;
        if (e1.b())
        {
            flag = ((RelevantStoreSummary)e1.c()).a();
        } else
        {
            flag = false;
        }
        return new a(flag);
    }

    public com.target.b.a b()
    {
        return new com.target.b.a() {

            final g this$0;

            public a a()
            {
                return g.this.a();
            }

            public Object b()
            {
                return a();
            }

            
            {
                this$0 = g.this;
                super();
            }
        };
    }
}
