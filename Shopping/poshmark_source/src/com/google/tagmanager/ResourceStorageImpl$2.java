// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            ResourceStorageImpl

class eWithMetadata
    implements Runnable
{

    final ResourceStorageImpl this$0;
    final com.google.tagmanager.proto.etadata val$resource;

    public void run()
    {
        saveResourceToDisk(val$resource);
    }

    eWithMetadata()
    {
        this$0 = final_resourcestorageimpl;
        val$resource = com.google.tagmanager.proto.etadata.this;
        super();
    }
}
