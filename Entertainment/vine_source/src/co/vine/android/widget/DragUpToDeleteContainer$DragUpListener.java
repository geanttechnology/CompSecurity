// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;


// Referenced classes of package co.vine.android.widget:
//            DragUpToDeleteContainer

public static interface 
{

    public abstract boolean prepareForPickup();

    public abstract void viewDestroyFinished();

    public abstract boolean viewDropped(int i);

    public abstract void viewLanded();

    public abstract boolean viewMoved(int i);

    public abstract void viewPickedUp();
}
