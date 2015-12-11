// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.View;
import android.view.ViewOutlineProvider;

// Referenced classes of package android.support.design.widget:
//            cc

final class ce
    implements cc
{

    private ce()
    {
    }

    ce(byte byte0)
    {
        this();
    }

    public final void a(View view)
    {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }
}
