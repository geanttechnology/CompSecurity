// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;


// Referenced classes of package com.ebay.nautilus.domain.content:
//            AsyncLoadTasks

public interface AsyncLoadTask
{

    public abstract void dispatchOnCanceled(AsyncLoadTasks asyncloadtasks, Object obj);

    public abstract void dispatchOnLoadComplete(AsyncLoadTasks asyncloadtasks, Object obj);

    public abstract Object loadInBackground();
}
