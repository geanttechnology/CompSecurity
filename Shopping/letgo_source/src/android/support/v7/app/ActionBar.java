// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.cj;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

public abstract class ActionBar
{
    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams
    {

        public int gravity;

        public LayoutParams(int i)
        {
            this(-2, -1, i);
        }

        public LayoutParams(int i, int j)
        {
            super(i, j);
            gravity = 0;
            gravity = 0x800013;
        }

        public LayoutParams(int i, int j, int k)
        {
            super(i, j);
            gravity = 0;
            gravity = k;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            gravity = 0;
            context = context.obtainStyledAttributes(attributeset, android.support.v7.br.k.ActionBarLayout);
            gravity = context.getInt(android.support.v7.br.k.ActionBarLayout_android_layout_gravity, 0);
            context.recycle();
        }

        public LayoutParams(LayoutParams layoutparams)
        {
            super(layoutparams);
            gravity = 0;
            gravity = layoutparams.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            gravity = 0;
        }
    }

    public static interface a
    {

        public abstract void a(boolean flag);
    }

    public static abstract class b
    {

        public abstract Drawable a();

        public abstract CharSequence b();

        public abstract View c();

        public abstract void d();

        public abstract CharSequence e();

        public b()
        {
        }
    }


    public ActionBar()
    {
    }

    public cj a(android.support.v7.cj.a a1)
    {
        return null;
    }

    public abstract View a();

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

    public abstract void a(View view, LayoutParams layoutparams);

    public abstract void a(CharSequence charsequence);

    public abstract void a(boolean flag);

    public boolean a(int i, KeyEvent keyevent)
    {
        return false;
    }

    public abstract int b();

    public void b(CharSequence charsequence)
    {
    }

    public abstract void b(boolean flag);

    public Context c()
    {
        return null;
    }

    public abstract void c(boolean flag);

    public void d(boolean flag)
    {
    }

    public boolean d()
    {
        return false;
    }

    public void e(boolean flag)
    {
        if (flag)
        {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        } else
        {
            return;
        }
    }

    public boolean e()
    {
        return false;
    }

    public void f(boolean flag)
    {
    }

    public void g(boolean flag)
    {
    }

    public void h(boolean flag)
    {
    }
}
