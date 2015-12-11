// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.util;

import android.util.Log;
import android.view.View;

// Referenced classes of package it.sephiroth.android.library.util:
//            ViewHelperFactory

public static class  extends 
{

    public boolean isHardwareAccelerated()
    {
        return false;
    }

    public void postOnAnimation(Runnable runnable)
    {
        view.post(runnable);
    }

    public void setScrollX(int i)
    {
        Log.d("ViewHelper", (new StringBuilder()).append("setScrollX: ").append(i).toString());
        view.scrollTo(i, view.getScrollY());
    }

    public (View view)
    {
        super(view);
    }
}
