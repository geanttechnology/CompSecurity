// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawer

private class <init>
    implements android.support.v4.widget.er
{

    final GNODrawer this$0;

    public void onDrawerClosed(View view)
    {
        for (view = GNODrawer.access$300(GNODrawer.this).iterator(); view.hasNext(); ((er)view.next()).onDrawerClosed(GNODrawer.this)) { }
    }

    public void onDrawerOpened(View view)
    {
        for (view = GNODrawer.access$300(GNODrawer.this).iterator(); view.hasNext(); ((er)view.next()).onDrawerOpened(GNODrawer.this)) { }
    }

    public void onDrawerSlide(View view, float f)
    {
        for (view = GNODrawer.access$300(GNODrawer.this).iterator(); view.hasNext(); ((er)view.next()).onDrawerSlide(GNODrawer.this, f)) { }
    }

    public void onDrawerStateChanged(int i)
    {
        i;
        JVM INSTR tableswitch 1 2: default 24
    //                   1 25
    //                   2 25;
           goto _L1 _L2 _L2
_L1:
        AmazonActivity amazonactivity;
        return;
_L2:
        if ((amazonactivity = AmazonActivity.getTopMostBaseActivity()) != null)
        {
            amazonactivity.closeSoftKeyboard();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private er()
    {
        this$0 = GNODrawer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
