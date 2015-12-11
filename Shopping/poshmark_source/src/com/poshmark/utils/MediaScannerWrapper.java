// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;

public class MediaScannerWrapper
    implements android.media.MediaScannerConnection.MediaScannerConnectionClient
{

    private MediaScannerConnection mConnection;
    private String mMimeType;
    private String mPath;

    public MediaScannerWrapper(Context context, String s, String s1)
    {
        mPath = s;
        mMimeType = s1;
        mConnection = new MediaScannerConnection(context, this);
    }

    public void onMediaScannerConnected()
    {
        mConnection.scanFile(mPath, mMimeType);
    }

    public void onScanCompleted(String s, Uri uri)
    {
    }

    public void scan()
    {
        mConnection.connect();
    }
}
