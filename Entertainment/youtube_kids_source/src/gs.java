// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class gs
    implements gy
{

    public Context a;
    public gt b;

    public View a(gv gv, View view, ViewGroup viewgroup)
    {
        if (view instanceof ha)
        {
            view = (ha)view;
            a(gv, ((ha) (view)));
            return (View)view;
        } else
        {
            throw new NullPointerException();
        }
    }

    public void a(Context context, gt gt)
    {
        a = context;
        LayoutInflater.from(a);
        b = gt;
    }

    public void a(gt gt, boolean flag)
    {
    }

    public abstract void a(gv gv, ha ha1);

    public void a(boolean flag)
    {
    }

    public boolean a()
    {
        return false;
    }

    public final boolean a(gv gv)
    {
        return false;
    }

    public boolean a(hb hb)
    {
        return false;
    }

    public final boolean b(gv gv)
    {
        return false;
    }
}
