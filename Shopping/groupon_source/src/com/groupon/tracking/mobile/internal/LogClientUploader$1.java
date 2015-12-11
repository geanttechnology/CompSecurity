// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.internal;


// Referenced classes of package com.groupon.tracking.mobile.internal:
//            LogClientUploader

class this._cls0
    implements Runnable
{

    final LogClientUploader this$0;

    public void run()
    {
        uploadFilesSynchronously();
    }

    ()
    {
        this$0 = LogClientUploader.this;
        super();
    }
}
