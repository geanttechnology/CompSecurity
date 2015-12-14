// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.x;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegateImplV7

final class <init>
    implements x
{

    final AppCompatDelegateImplV7 this$0;

    public final void onCloseMenu(i j, boolean flag)
    {
label0:
        {
            i k = j.q();
            AppCompatDelegateImplV7 appcompatdelegateimplv7;
            boolean flag1;
            if (k != j)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            appcompatdelegateimplv7 = AppCompatDelegateImplV7.this;
            if (flag1)
            {
                j = k;
            }
            j = AppCompatDelegateImplV7.access$600(appcompatdelegateimplv7, j);
            if (j != null)
            {
                if (!flag1)
                {
                    break label0;
                }
                AppCompatDelegateImplV7.access$700(AppCompatDelegateImplV7.this, ((this._cls0) (j))., j, k);
                AppCompatDelegateImplV7.access$800(AppCompatDelegateImplV7.this, j, true);
            }
            return;
        }
        AppCompatDelegateImplV7.access$800(AppCompatDelegateImplV7.this, j, flag);
    }

    public final boolean onOpenSubMenu(i j)
    {
        if (j == null && mHasActionBar)
        {
            android.view.rCallback rcallback = getWindowCallback();
            if (rcallback != null && !isDestroyed())
            {
                rcallback.(8, j);
            }
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
