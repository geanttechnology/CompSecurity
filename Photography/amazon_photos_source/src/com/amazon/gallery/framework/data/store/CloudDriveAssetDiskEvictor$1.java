// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;


// Referenced classes of package com.amazon.gallery.framework.data.store:
//            CloudDriveAssetDiskEvictor

class this._cls0
    implements Runnable
{

    final CloudDriveAssetDiskEvictor this$0;

    public void run()
    {
        cleanUpSynchronous(CloudDriveAssetDiskEvictor.access$000(CloudDriveAssetDiskEvictor.this));
    }

    ()
    {
        this$0 = CloudDriveAssetDiskEvictor.this;
        super();
    }
}
