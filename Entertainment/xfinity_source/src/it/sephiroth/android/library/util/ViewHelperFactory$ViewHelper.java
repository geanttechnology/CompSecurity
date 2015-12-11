// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.util;

import android.view.View;

// Referenced classes of package it.sephiroth.android.library.util:
//            ViewHelperFactory

public static abstract class view
{

    protected View view;

    public abstract boolean isHardwareAccelerated();

    public abstract void postOnAnimation(Runnable runnable);

    public abstract void setScrollX(int i);

    protected (View view1)
    {
        view = view1;
    }
}
