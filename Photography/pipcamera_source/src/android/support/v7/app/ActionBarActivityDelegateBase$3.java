// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.graphics.Rect;
import bu;

// Referenced classes of package android.support.v7.app:
//            ActionBarActivityDelegateBase

class a
    implements bu
{

    final ActionBarActivityDelegateBase a;

    public void a(Rect rect)
    {
        rect.top = ActionBarActivityDelegateBase.c(a, rect.top);
    }

    (ActionBarActivityDelegateBase actionbaractivitydelegatebase)
    {
        a = actionbaractivitydelegatebase;
        super();
    }
}
