// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services.drag;


// Referenced classes of package com.aviary.android.feather.library.services.drag:
//            DropTarget, DragView

public static interface 
{

    public abstract boolean acceptDrop(com.aviary.android.feather.library.services.ce ce, int i, int j, int k, int l, DragView dragview, Object obj);

    public abstract void onDrop(com.aviary.android.feather.library.services.ce ce, int i, int j, int k, int l, DragView dragview, Object obj);
}
