// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;

// Referenced classes of package android.support.v4.view:
//            ViewCompat, ViewCompatLollipop

static class  extends 
{

    public float getElevation(View view)
    {
        return ViewCompatLollipop.getElevation(view);
    }

    public boolean isNestedScrollingEnabled(View view)
    {
        return ViewCompatLollipop.isNestedScrollingEnabled(view);
    }

    public void setElevation(View view, float f)
    {
        ViewCompatLollipop.setElevation(view, f);
    }

    public void stopNestedScroll(View view)
    {
        ViewCompatLollipop.stopNestedScroll(view);
    }

    ()
    {
    }
}
