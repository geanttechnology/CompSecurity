// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;

// Referenced classes of package android.support.v4.view:
//            ViewCompat, ViewCompatKitKat, ViewCompatJB

static class  extends 
{

    public boolean isLaidOut(View view)
    {
        return ViewCompatKitKat.isLaidOut(view);
    }

    public void setImportantForAccessibility(View view, int i)
    {
        ViewCompatJB.setImportantForAccessibility(view, i);
    }

    ()
    {
    }
}
