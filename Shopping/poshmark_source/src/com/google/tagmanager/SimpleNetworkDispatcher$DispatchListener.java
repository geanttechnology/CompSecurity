// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            SimpleNetworkDispatcher, Hit

public static interface 
{

    public abstract void onHitDispatched(Hit hit);

    public abstract void onHitPermanentDispatchFailure(Hit hit);

    public abstract void onHitTransientDispatchFailure(Hit hit);
}
