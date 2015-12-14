// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.storage;


// Referenced classes of package com.tencent.mm.sdk.storage:
//            MStorageEvent

class bT
    implements Runnable
{

    final Object bS;
    final Object bT;
    final MStorageEvent bU;

    public void run()
    {
        bU.processEvent(bS, bT);
    }

    (MStorageEvent mstorageevent, Object obj, Object obj1)
    {
        bU = mstorageevent;
        bS = obj;
        bT = obj1;
        super();
    }
}
