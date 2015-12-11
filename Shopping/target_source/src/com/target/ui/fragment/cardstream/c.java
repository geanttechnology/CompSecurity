// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.b.h;
import com.target.ui.fragment.cardstream.c.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class c extends com.target.ui.fragment.cardstream.c.a
{
    private class a
    {

        private static final int FIRST_LOAD_POLLING_COUNT = 10;
        private boolean hasFirstLoadCompleted;
        private boolean shouldBlock;
        final c this$0;

        private void a(long l)
        {
            try
            {
                com.target.a.a.b.d("CardDataSource", "Blocking card stream load...");
                Thread.sleep(l);
                com.target.a.a.b.d("CardDataSource", "...card stream load unblocked.");
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                com.target.a.a.b.b("CardDataSource", "Interrupted while sleeping: ", interruptedexception);
            }
        }

        private void c()
        {
            hasFirstLoadCompleted = true;
            shouldBlock = true;
            com.target.a.a.b.c("CardDataSource", (new StringBuilder()).append("onFirstCardLoad() running with an interval of ").append(200L).append("ms").toString());
            int i = 0;
            do
            {
                if (i > 10 || e())
                {
                    return;
                }
                a(200L);
                i++;
            } while (true);
        }

        private void d()
        {
            com.target.a.a.b.c("CardDataSource", "onSubsequentLoad() running");
            if (!shouldBlock)
            {
                shouldBlock = true;
                return;
            } else
            {
                a(2000L);
                return;
            }
        }

        private boolean e()
        {
            boolean flag = false;
            Iterator iterator = a(c.this).iterator();
            int i;
            int j;
            for (i = 0; iterator.hasNext(); i = j)
            {
                com.target.ui.fragment.cardstream.c.a a1 = (com.target.ui.fragment.cardstream.c.a)iterator.next();
                boolean flag1 = a1.g();
                j = i;
                if (flag1)
                {
                    j = i + 1;
                }
                com.target.a.a.b.d("CardDataSource", (new StringBuilder()).append("Checking dataSource ").append(a1).append(", isLoaded:").append(flag1).toString());
            }

            if (i == a(c.this).size())
            {
                flag = true;
            }
            return flag;
        }

        void a()
        {
            this;
            JVM INSTR monitorenter ;
            if (hasFirstLoadCompleted) goto _L2; else goto _L1
_L1:
            c();
_L4:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            d();
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        void b()
        {
            shouldBlock = false;
        }

        private a()
        {
            this$0 = c.this;
            super();
            hasFirstLoadCompleted = false;
            shouldBlock = true;
        }

    }

    public static interface b
        extends com.target.ui.fragment.cardstream.c.a.a
    {

        public abstract void c();
    }


    private static final long DELAY_BETWEEN_STREAM_RELOADS;
    private static final String LOG_TAG = "CardDataSource";
    private static final long REFRESHING_INTERVAL_MS = 2000L;
    private final com.google.a.a.b mCardDataPipeline;
    private final a mDataLoadingDelayBlocker = new a();
    private final List mDataSources;
    private final com.target.b.a mGuestContextProvider;
    private final b mListener;

    public c(com.target.ui.fragment.cardstream.c.j.c c1, b b1, List list, com.target.b.a a1, com.google.a.a.b b2)
    {
        super(c1, b1, "CardDataSource");
        mGuestContextProvider = a1;
        mCardDataPipeline = b2;
        mDataSources = list;
        mListener = b1;
    }

    static List a(c c1)
    {
        return c1.mDataSources;
    }

    public void a()
    {
        mDataLoadingDelayBlocker.b();
        k();
    }

    protected void a(com.target.ui.fragment.cardstream.c.a.a a1)
    {
        mDataLoadingDelayBlocker.a();
        h h1 = (h)mCardDataPipeline.a(mGuestContextProvider.b());
        if (h1 != null && h1.isEmpty())
        {
            com.target.a.a.b.b("CardDataSource", "No card data produced by pipeline!");
        }
        a1.a(com.google.a.a.e.c(h1));
    }

    protected boolean a(h h1)
    {
        return !h1.isEmpty();
    }

    protected volatile boolean a(Object obj)
    {
        return a((h)obj);
    }

    public long b()
    {
        return DELAY_BETWEEN_STREAM_RELOADS;
    }

    protected void c()
    {
        for (Iterator iterator = mDataSources.iterator(); iterator.hasNext(); ((com.target.ui.fragment.cardstream.c.a)iterator.next()).i()) { }
    }

    protected void d()
    {
        for (Iterator iterator = mDataSources.iterator(); iterator.hasNext(); ((com.target.ui.fragment.cardstream.c.a)iterator.next()).j()) { }
    }

    protected void e()
    {
        mListener.c();
    }

    static 
    {
        DELAY_BETWEEN_STREAM_RELOADS = TimeUnit.SECONDS.toMillis(10L);
    }
}
