// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.app.Activity;
import com.f.a.a.a;
import com.f.a.f;
import com.google.a.a.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class g
{
    private class a
    {

        private final List mSnackBars = Collections.synchronizedList(new ArrayList());
        final g this$0;

        public void a()
        {
            List list = mSnackBars;
            list;
            JVM INSTR monitorenter ;
            Iterator iterator = mSnackBars.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                f f1 = (f)iterator.next();
                if (!f1.c())
                {
                    f1.a();
                }
            } while (true);
            break MISSING_BLOCK_LABEL_55;
            Exception exception;
            exception;
            list;
            JVM INSTR monitorexit ;
            throw exception;
            mSnackBars.clear();
            list;
            JVM INSTR monitorexit ;
        }

        public void a(f f1)
        {
            synchronized (mSnackBars)
            {
                mSnackBars.add(f1);
            }
            return;
            f1;
            list;
            JVM INSTR monitorexit ;
            throw f1;
        }

        public a()
        {
            this$0 = g.this;
            super();
        }
    }


    private final WeakReference mActivityReference;
    private final a mSnackBarCollection = new a();

    public g(Activity activity)
    {
        mActivityReference = new WeakReference(activity);
    }

    protected e a(String s)
    {
        Object obj = (Activity)mActivityReference.get();
        if (obj == null)
        {
            return e.e();
        } else
        {
            obj = f.a(((android.content.Context) (obj)));
            mSnackBarCollection.a(((f) (obj)));
            ((f) (obj)).a(com.f.a.a.a.b);
            ((f) (obj)).a(s);
            return e.b(obj);
        }
    }

    public void a()
    {
        mSnackBarCollection.a();
    }

    public e b()
    {
        return e.c(mActivityReference.get());
    }
}
