// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;

// Referenced classes of package android.support.v4.view:
//            ViewCompat, ViewCompatApi21, OnApplyWindowInsetsListener

static class  extends 
{

    public void requestApplyInsets(View view)
    {
        ViewCompatApi21.requestApplyInsets(view);
    }

    public void setElevation(View view, float f)
    {
        ViewCompatApi21.setElevation(view, f);
    }

    public void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onapplywindowinsetslistener)
    {
        ViewCompatApi21.setOnApplyWindowInsetsListener(view, onapplywindowinsetslistener);
    }

    ()
    {
    }
}
