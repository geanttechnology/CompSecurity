// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.graphics.Point;
import android.view.View;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

public static interface 
{

    public abstract View onCreateFloatView(int i);

    public abstract void onDestroyFloatView(View view);

    public abstract void onDragFloatView(View view, Point point, Point point1);
}
