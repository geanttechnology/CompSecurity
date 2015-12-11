// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.dragsort;


// Referenced classes of package co.vine.android.dragsort:
//            DragSortWidget

public static interface 
{

    public abstract boolean canPickUpFloatView();

    public abstract boolean floatViewDropped(int i);

    public abstract void floatViewLanded(int i);

    public abstract void floatViewMoved();

    public abstract void floatViewPickedUp(int i);
}
