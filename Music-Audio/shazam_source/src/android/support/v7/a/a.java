// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

public abstract class android.support.v7.a.a
{
    public static class a extends android.view.ViewGroup.MarginLayoutParams
    {

        public int a;

        public a()
        {
            super(-2, -2);
            a = 0;
            a = 0x800013;
        }

        public a(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            a = 0;
            context = context.obtainStyledAttributes(attributeset, android.support.v7.b.k.ActionBarLayout);
            a = context.getInt(android.support.v7.b.k.ActionBarLayout_android_layout_gravity, 0);
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

    public static abstract class b
    {

        public abstract Drawable a();

        public abstract CharSequence b();

        public abstract View c();

        public abstract CharSequence d();

        public b()
        {
        }
    }


    public android.support.v7.a.a()
    {
    }

    public abstract int a();

    public android.support.v7.e.a a(android.support.v7.e.a a1)
    {
        return null;
    }

    public void a(Configuration configuration)
    {
    }

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

    public abstract void c();

    public void c(boolean flag)
    {
    }

    public abstract void d();

    public void d(boolean flag)
    {
    }

    public void e(boolean flag)
    {
    }

    public abstract boolean e();

    public Context f()
    {
        return null;
    }

    public boolean g()
    {
        return false;
    }

    public boolean h()
    {
        return false;
    }
}
