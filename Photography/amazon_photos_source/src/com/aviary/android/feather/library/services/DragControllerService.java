// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import com.aviary.android.feather.library.services.drag.DropTarget;

// Referenced classes of package com.aviary.android.feather.library.services:
//            BaseContextService, DragController, IAviaryController

public class DragControllerService extends BaseContextService
{
    public static interface DragListener
    {

        public abstract boolean onDragEnd();

        public abstract void onDragStart(DragSource dragsource, Object obj, int i);
    }

    public static interface DragSource
    {

        public abstract DragController getDragController();

        public abstract void onDropCompleted(DropTarget droptarget, boolean flag);

        public abstract void setDragController(DragController dragcontroller);
    }


    public static final int DRAG_ACTION_COPY = 1;
    public static final int DRAG_ACTION_MOVE = 0;
    private DragController mInstance;

    public DragControllerService(IAviaryController iaviarycontroller)
    {
        super(iaviarycontroller);
        mInstance = new DragController(iaviarycontroller.getBaseContext(), iaviarycontroller.getDragLayer());
    }

    public void activate()
    {
        mInstance.activate();
    }

    public boolean active()
    {
        return mInstance.active();
    }

    public void addDropTarget(DropTarget droptarget)
    {
        mInstance.addDropTarget(droptarget);
    }

    public void deactivate()
    {
        mInstance.deactivate();
    }

    public void dispose()
    {
        mInstance.dispose();
    }

    public DragController getInstance()
    {
        return mInstance;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return mInstance.onTouchEvent(motionevent);
    }

    public void removeDropTarget(DropTarget droptarget)
    {
        mInstance.removeDropTarget(droptarget);
    }

    public void setDragListener(DragListener draglistener)
    {
        mInstance.setDragListener(draglistener);
    }

    public void setMoveTarget(View view)
    {
        mInstance.setMoveTarget(view);
    }

    public boolean startDrag(View view, Bitmap bitmap, int i, int j, DragSource dragsource, Object obj, int k, 
            boolean flag)
    {
        return mInstance.startDrag(view, bitmap, i, j, dragsource, obj, k, flag);
    }

    public boolean startDrag(View view, DragSource dragsource, Object obj, int i, boolean flag)
    {
        return mInstance.startDrag(view, dragsource, obj, i, flag);
    }
}
