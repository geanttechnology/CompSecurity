// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

public abstract class android.support.v7.app.a
{
    public static class a extends android.view.ViewGroup.MarginLayoutParams
    {

        public int a;

        public a(int i, int j)
        {
            super(i, j);
            a = 0;
            a = 0x800013;
        }

        public a(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            a = 0;
            context = context.obtainStyledAttributes(attributeset, android.support.v7.a.k.ActionBarLayout);
            a = context.getInt(android.support.v7.a.k.ActionBarLayout_android_layout_gravity, 0);
            context.recycle();
        }

        public a(a a1)
        {
            super(a1);
            a = 0;
            a = a1.a;
        }

        public a(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            a = 0;
        }
    }

    public static interface b
    {

        public abstract void a(boolean flag);
    }

    public static abstract class c
    {

        public abstract Drawable a();

        public abstract CharSequence b();

        public abstract View c();

        public abstract void d();

        public abstract CharSequence e();

        public c()
        {
        }
    }


    public android.support.v7.app.a()
    {
    }

    public abstract int a();

    public android.support.v7.d.a a(android.support.v7.d.a a1)
    {
        return null;
    }

    public void a(float f1)
    {
        if (f1 != 0.0F)
        {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        } else
        {
            return;
        }
    }

    public void a(int i)
    {
    }

    public void a(Configuration configuration)
    {
    }

    public void a(Drawable drawable)
    {
    }

    public abstract void a(CharSequence charsequence);

    public abstract void a(boolean flag);

    public boolean a(int i, KeyEvent keyevent)
    {
        return false;
    }

    public Context b()
    {
        return null;
    }

    public void b(CharSequence charsequence)
    {
    }

    public void b(boolean flag)
    {
    }

    public void c(boolean flag)
    {
        if (flag)
        {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        } else
        {
            return;
        }
    }

    public boolean c()
    {
        return false;
    }

    public void d(boolean flag)
    {
    }

    public boolean d()
    {
        return false;
    }

    public void e(boolean flag)
    {
    }

    public void f(boolean flag)
    {
    }
}
