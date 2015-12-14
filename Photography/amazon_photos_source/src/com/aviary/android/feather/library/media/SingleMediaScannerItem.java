// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.media;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.util.Log;
import java.io.File;

public class SingleMediaScannerItem
    implements android.media.MediaScannerConnection.MediaScannerConnectionClient
{
    public static interface OnScanErrorListener
    {

        public abstract void onScanError();
    }


    private static final String LOG_TAG = "single-media-scanner";
    private MediaScannerConnection mConn;
    private File mFile;
    private android.media.MediaScannerConnection.OnScanCompletedListener mScanCompletedListener;
    private OnScanErrorListener mScaneErrorListener;

    public SingleMediaScannerItem(Context context, File file, android.media.MediaScannerConnection.OnScanCompletedListener onscancompletedlistener, OnScanErrorListener onscanerrorlistener)
    {
        mFile = file;
        mScanCompletedListener = onscancompletedlistener;
        mScaneErrorListener = onscanerrorlistener;
        mConn = new MediaScannerConnection(context, this);
    }

    public void onMediaScannerConnected()
    {
        Log.i("single-media-scanner", "onMediaScannerConnected");
        mConn.scanFile(mFile.getAbsolutePath(), null);
_L1:
        return;
        Throwable throwable;
        throwable;
        if (mScaneErrorListener != null)
        {
            mScaneErrorListener.onScanError();
            return;
        }
          goto _L1
    }

    public void onScanCompleted(String s, Uri uri)
    {
        Log.i("single-media-scanner", (new StringBuilder()).append("onMediaScannerCompleted: ").append(s).append("(").append(uri).append(")").toString());
        mConn.disconnect();
        if (mScanCompletedListener != null)
        {
            mScanCompletedListener.onScanCompleted(s, uri);
        }
    }

    public void run()
    {
        mConn.connect();
    }
}
