// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class sf extends rw
{

    private Fragment a;

    private sf(Fragment fragment)
    {
        a = fragment;
    }

    public static sf a(Fragment fragment)
    {
        if (fragment != null)
        {
            return new sf(fragment);
        } else
        {
            return null;
        }
    }

    public ry a()
    {
        return sb.a(a.getActivity());
    }

    public void a(Intent intent)
    {
        a.startActivity(intent);
    }

    public void a(Intent intent, int i1)
    {
        a.startActivityForResult(intent, i1);
    }

    public void a(ry ry)
    {
        ry = (View)sb.a(ry);
        a.registerForContextMenu(ry);
    }

    public void a(boolean flag)
    {
        a.setHasOptionsMenu(flag);
    }

    public Bundle b()
    {
        return a.getArguments();
    }

    public void b(ry ry)
    {
        ry = (View)sb.a(ry);
        a.unregisterForContextMenu(ry);
    }

    public void b(boolean flag)
    {
        a.setMenuVisibility(flag);
    }

    public int c()
    {
        return a.getId();
    }

    public void c(boolean flag)
    {
        a.setRetainInstance(flag);
    }

    public rv d()
    {
        return a(a.getParentFragment());
    }

    public void d(boolean flag)
    {
        a.setUserVisibleHint(flag);
    }

    public ry e()
    {
        return sb.a(a.getResources());
    }

    public boolean f()
    {
        return a.getRetainInstance();
    }

    public String g()
    {
        return a.getTag();
    }

    public rv h()
    {
        return a(a.getTargetFragment());
    }

    public int i()
    {
        return a.getTargetRequestCode();
    }

    public boolean j()
    {
        return a.getUserVisibleHint();
    }

    public ry k()
    {
        return sb.a(a.getView());
    }

    public boolean l()
    {
        return a.isAdded();
    }

    public boolean m()
    {
        return a.isDetached();
    }

    public boolean n()
    {
        return a.isHidden();
    }

    public boolean o()
    {
        return a.isInLayout();
    }

    public boolean p()
    {
        return a.isRemoving();
    }

    public boolean q()
    {
        return a.isResumed();
    }

    public boolean r()
    {
        return a.isVisible();
    }
}
