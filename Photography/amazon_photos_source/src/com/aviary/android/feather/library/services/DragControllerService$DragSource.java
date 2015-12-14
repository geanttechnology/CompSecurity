// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import com.aviary.android.feather.library.services.drag.DropTarget;

// Referenced classes of package com.aviary.android.feather.library.services:
//            DragControllerService, DragController

public static interface 
{

    public abstract DragController getDragController();

    public abstract void onDropCompleted(DropTarget droptarget, boolean flag);

    public abstract void setDragController(DragController dragcontroller);
}
