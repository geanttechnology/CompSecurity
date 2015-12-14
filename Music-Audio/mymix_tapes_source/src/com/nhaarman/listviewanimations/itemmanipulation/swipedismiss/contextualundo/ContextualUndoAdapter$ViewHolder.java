// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.contextualundo;

import android.view.View;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.contextualundo:
//            ContextualUndoAdapter, ContextualUndoView

private static class mContextualUndoView
{

    final ContextualUndoView mContextualUndoView;
    long mItemId;

    static mContextualUndoView getViewHolder(View view)
    {
        return (mContextualUndoView)view.getTag();
    }

    (ContextualUndoView contextualundoview)
    {
        mContextualUndoView = contextualundoview;
        mContextualUndoView.setTag(this);
    }
}
