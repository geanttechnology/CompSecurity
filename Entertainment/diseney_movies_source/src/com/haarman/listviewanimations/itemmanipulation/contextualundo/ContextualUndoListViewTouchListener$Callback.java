// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.haarman.listviewanimations.itemmanipulation.contextualundo;

import android.view.View;

// Referenced classes of package com.haarman.listviewanimations.itemmanipulation.contextualundo:
//            ContextualUndoListViewTouchListener

public static interface q
{

    public abstract void onListScrolled();

    public abstract void onViewSwiped(View view, int i);
}
