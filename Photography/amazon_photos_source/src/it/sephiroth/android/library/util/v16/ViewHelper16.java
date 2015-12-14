// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.util.v16;

import android.view.View;
import it.sephiroth.android.library.util.v14.ViewHelper14;

public class ViewHelper16 extends ViewHelper14
{

    public ViewHelper16(View view)
    {
        super(view);
    }

    public void postOnAnimation(Runnable runnable)
    {
        view.postOnAnimation(runnable);
    }
}
