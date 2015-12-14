// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import ee;
import ef;

public abstract class ActionBar
{

    public ActionBar()
    {
    }

    public abstract int a();

    public ee a(ef ef)
    {
        return null;
    }

    public void a(float f)
    {
        if (f != 0.0F)
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

    public void a(CharSequence charsequence)
    {
    }

    public void a(boolean flag)
    {
    }

    public Context b()
    {
        return null;
    }

    public void b(boolean flag)
    {
        if (flag)
        {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        } else
        {
            return;
        }
    }

    public void c(boolean flag)
    {
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
}
