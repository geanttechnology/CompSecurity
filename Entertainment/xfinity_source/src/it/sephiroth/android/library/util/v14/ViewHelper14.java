// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.util.v14;

import android.view.View;

public class ViewHelper14 extends it.sephiroth.android.library.util.ViewHelperFactory.ViewHelperDefault
{

    public ViewHelper14(View view)
    {
        super(view);
    }

    public boolean isHardwareAccelerated()
    {
        return view.isHardwareAccelerated();
    }

    public void setScrollX(int i)
    {
        view.setScrollX(i);
    }
}
