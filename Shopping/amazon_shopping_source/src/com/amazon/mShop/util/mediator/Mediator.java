// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util.mediator;


// Referenced classes of package com.amazon.mShop.util.mediator:
//            Task

public interface Mediator
{

    public abstract void addDependency(Task task, String s);

    public abstract void onFailed(String s);

    public abstract void onReady(String s);

    public abstract void register(Task task);
}
