// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import android.net.Uri;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediastore:
//            MediaStoreScanHelper

class CompleteCallback
    implements android.media.OnScanCompletedListener
{

    final MediaStoreScanHelper this$0;
    final CompleteCallback val$onCompleteCallback;

    public void onScanCompleted(String s, Uri uri)
    {
        if (MediaStoreScanHelper.access$006(MediaStoreScanHelper.this) == 0)
        {
            val$onCompleteCallback.onComplete(s, uri);
        }
    }

    CompleteCallback()
    {
        this$0 = final_mediastorescanhelper;
        val$onCompleteCallback = CompleteCallback.this;
        super();
    }
}
