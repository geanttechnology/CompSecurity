// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class an extends ActionMode
{

    final Context a;
    final ee b;

    public an(Context context, ee ee1)
    {
        a = context;
        b = ee1;
    }

    public void finish()
    {
        b.c();
    }

    public View getCustomView()
    {
        return b.i();
    }

    public Menu getMenu()
    {
        return bs.a(a, (SupportMenu)b.b());
    }

    public MenuInflater getMenuInflater()
    {
        return b.a();
    }

    public CharSequence getSubtitle()
    {
        return b.g();
    }

    public Object getTag()
    {
        return b.j();
    }

    public CharSequence getTitle()
    {
        return b.f();
    }

    public boolean getTitleOptionalHint()
    {
        return b.k();
    }

    public void invalidate()
    {
        b.d();
    }

    public boolean isTitleOptional()
    {
        return b.h();
    }

    public void setCustomView(View view)
    {
        b.a(view);
    }

    public void setSubtitle(int i)
    {
        b.b(i);
    }

    public void setSubtitle(CharSequence charsequence)
    {
        b.a(charsequence);
    }

    public void setTag(Object obj)
    {
        b.a(obj);
    }

    public void setTitle(int i)
    {
        b.a(i);
    }

    public void setTitle(CharSequence charsequence)
    {
        b.b(charsequence);
    }

    public void setTitleOptionalHint(boolean flag)
    {
        b.a(flag);
    }
}
