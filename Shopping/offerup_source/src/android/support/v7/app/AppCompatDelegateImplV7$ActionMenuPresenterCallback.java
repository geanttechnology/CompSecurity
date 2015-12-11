// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.y;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegateImplV7

final class <init>
    implements y
{

    final AppCompatDelegateImplV7 this$0;

    public final void onCloseMenu(i i, boolean flag)
    {
        AppCompatDelegateImplV7.access$1000(AppCompatDelegateImplV7.this, i);
    }

    public final boolean onOpenSubMenu(i i)
    {
        android.view.rCallback rcallback = getWindowCallback();
        if (rcallback != null)
        {
            rcallback.rCallback(108, i);
        }
        return true;
    }

    private ()
    {
        this$0 = AppCompatDelegateImplV7.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
