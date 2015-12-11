// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.e;

import android.view.Menu;
import android.view.MenuInflater;
import com.google.a.a.e;
import com.google.a.b.h;
import com.target.a.a.b;
import com.target.ui.fragment.cardstream.c;
import com.target.ui.fragment.cardstream.d;
import java.util.concurrent.atomic.AtomicReference;

public class a
    implements com.target.ui.fragment.cardstream.c.b, com.target.ui.g.a
{

    private static final String LOG_TAG = "CardStreamPresenter";
    private final c mCardDataSource;
    private final d mCardDataSourceFactory;
    private com.target.ui.fragment.cardstream.d.a mPresentation;

    a(d d1)
    {
        mCardDataSourceFactory = d1;
        mCardDataSource = mCardDataSourceFactory.b();
    }

    public static a a(com.target.a.a.a a1)
    {
        AtomicReference atomicreference = new AtomicReference();
        a1 = new a(new d(a1.a(), new com.target.ui.fragment.cardstream.c.b(atomicreference) {

            final AtomicReference val$listenerReference;

            public void a(e e1)
            {
                ((com.target.ui.fragment.cardstream.c.b)listenerReference.get()).a(e1);
            }

            public void c()
            {
                ((com.target.ui.fragment.cardstream.c.b)listenerReference.get()).c();
            }

            
            {
                listenerReference = atomicreference;
                super();
            }
        }));
        atomicreference.set(a1);
        return a1;
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(e e1)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("New card stream data loaded: ");
        Object obj;
        if (e1.b())
        {
            obj = e1;
        } else
        {
            obj = "Optional.absent()";
        }
        b.d("CardStreamPresenter", stringbuilder.append(obj).toString());
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.a(false);
        boolean flag;
        boolean flag1;
        if (e1.b() && !((h)e1.c()).isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            e1 = (h)e1.c();
            flag1 = false;
        } else
        {
            e1 = h.f();
            flag1 = true;
        }
        mPresentation.a(e1);
        mPresentation.c(flag1);
    }

    public void a(com.target.ui.fragment.cardstream.d.a a1)
    {
        mPresentation = a1;
        mPresentation.c(false);
        mPresentation.a(mCardDataSourceFactory);
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.cardstream.d.a)obj);
    }

    public void c()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(true);
            return;
        }
    }

    public void d()
    {
        mCardDataSource.i();
        if (mCardDataSource.g())
        {
            a(mCardDataSource.f());
        }
    }

    public void e()
    {
        mCardDataSource.j();
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(false);
            return;
        }
    }

    public void f()
    {
        mCardDataSource.k();
    }

    public void v_()
    {
    }

    public void z_()
    {
        mPresentation = null;
    }
}
