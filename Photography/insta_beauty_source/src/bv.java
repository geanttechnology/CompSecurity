// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.widget.AbsActionBarView;

public class bv
    implements Runnable
{

    final AbsActionBarView a;

    public bv(AbsActionBarView absactionbarview)
    {
        a = absactionbarview;
        super();
    }

    public void run()
    {
        a.showOverflowMenu();
    }
}
