// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;


// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DistributedDataStorage, RemoteAmazonDataStorage

private static interface 
{

    public abstract String getName();

    public abstract boolean performAction(RemoteAmazonDataStorage remoteamazondatastorage);

    public abstract void setActionPerformed();
}
