// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;

import android.app.Activity;
import java.util.Iterator;

// Referenced classes of package org.chromium.base:
//            WindowCallbackWrapper, BaseChromiumApplication, ObserverList

class  extends WindowCallbackWrapper
{

    private Activity a;
    private a b;

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        for (Iterator iterator = BaseChromiumApplication.a(b.b).iterator(); iterator.hasNext(); ((owFocusChangedListener)iterator.next()).a(a, flag)) { }
    }

    owFocusChangedListener(owFocusChangedListener owfocuschangedlistener, android.view.._cls1 _pcls1, Activity activity)
    {
        b = owfocuschangedlistener;
        a = activity;
        super(_pcls1);
    }
}
