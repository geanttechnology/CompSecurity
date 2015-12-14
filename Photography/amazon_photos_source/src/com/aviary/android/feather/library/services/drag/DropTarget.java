// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services.drag;

import android.graphics.Rect;

// Referenced classes of package com.aviary.android.feather.library.services.drag:
//            DragView

public interface DropTarget
{
    public static interface DropTargetListener
    {

        public abstract boolean acceptDrop(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj);

        public abstract void onDrop(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj);
    }


    public abstract boolean acceptDrop(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj);

    public abstract Rect estimateDropLocation(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj, 
            Rect rect);

    public abstract void getHitRect(Rect rect);

    public abstract int getLeft();

    public abstract void getLocationOnScreen(int ai[]);

    public abstract int getTop();

    public abstract void onDragEnter(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj);

    public abstract void onDragExit(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj);

    public abstract void onDragOver(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj);

    public abstract void onDragViewDropAnimationFinished(Object obj, DragView dragview);

    public abstract void onDrop(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj);
}
