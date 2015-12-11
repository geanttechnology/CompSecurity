// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.app;

import android.os.Bundle;
import android.support.v4.app.f;
import android.view.KeyEvent;
import android.view.MenuInflater;

// Referenced classes of package com.helpshift.app:
//            b, ActionBarHelperBase

public abstract class a extends f
{

    private b a;

    public a()
    {
        a = b.a(this);
    }

    public void a(int j)
    {
        a.a(j);
    }

    public void d(boolean flag)
    {
        a.b(flag);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        int j = keyevent.getKeyCode();
        int k = keyevent.getAction();
        if (j == 82 && k == 1)
        {
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    public MenuInflater getMenuInflater()
    {
        return a.a(super.getMenuInflater());
    }

    public b i()
    {
        return a;
    }

    public void onBackPressed()
    {
        if ((a instanceof ActionBarHelperBase) && ((ActionBarHelperBase)a).b())
        {
            a.a(null);
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a.a(bundle);
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        a.b(bundle);
    }
}
