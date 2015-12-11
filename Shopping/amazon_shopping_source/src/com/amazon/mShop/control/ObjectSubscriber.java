// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control;


// Referenced classes of package com.amazon.mShop.control:
//            GenericSubscriber

public interface ObjectSubscriber
    extends GenericSubscriber
{

    public abstract void onAvailableCountReceived(int i);

    public abstract void onCancelled();

    public abstract void onObjectReceived(Object obj, int i);

    public abstract void onObjectsReceived();

    public abstract void onPageComplete();
}
