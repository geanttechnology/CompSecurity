// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.contextualundo;

import android.os.Handler;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.contextualundo:
//            ContextualUndoAdapter, ContextualUndoView

private class <init>
    implements Runnable
{

    final ContextualUndoAdapter this$0;

    public void run()
    {
        long l = (long)ContextualUndoAdapter.access$200(ContextualUndoAdapter.this) - (System.currentTimeMillis() - ContextualUndoAdapter.access$300(ContextualUndoAdapter.this));
        if (ContextualUndoAdapter.access$400(ContextualUndoAdapter.this) != null)
        {
            ContextualUndoAdapter.access$500(ContextualUndoAdapter.this).updateCountDownTimer(ContextualUndoAdapter.access$400(ContextualUndoAdapter.this).getCountDownString(l));
        }
        if (l <= 0L)
        {
            ContextualUndoAdapter.access$600(ContextualUndoAdapter.this);
            return;
        } else
        {
            ContextualUndoAdapter.access$700(ContextualUndoAdapter.this).postDelayed(this, Math.min(l, 1000L));
            return;
        }
    }

    private ()
    {
        this$0 = ContextualUndoAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
