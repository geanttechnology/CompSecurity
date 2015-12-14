// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;

public class MediaStoreScanHelper
{
    public static interface OnCompleteCallback
    {

        public abstract void onComplete(String s, Uri uri);
    }


    private int size;

    public MediaStoreScanHelper()
    {
    }

    public void scan(Context context, String as[], final OnCompleteCallback onCompleteCallback)
    {
        size = as.length;
        MediaScannerConnection.scanFile(context, as, null, new android.media.MediaScannerConnection.OnScanCompletedListener() {

            final MediaStoreScanHelper this$0;
            final OnCompleteCallback val$onCompleteCallback;

            public void onScanCompleted(String s, Uri uri)
            {
                if (int i = ((val.onCompleteCallback) (this)).onCompleteCallback - 1 == 0)
                {
                    onCompleteCallback.onComplete(s, uri);
                }
            }

            
            {
                this$0 = MediaStoreScanHelper.this;
                onCompleteCallback = oncompletecallback;
                super();
            }
        });
    }


/*
    static int access$006(MediaStoreScanHelper mediastorescanhelper)
    {
        int i = mediastorescanhelper.size - 1;
        mediastorescanhelper.size = i;
        return i;
    }

*/
}
