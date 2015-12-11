// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.util:
//            MediaUtil

public static class mMimeType
    implements android.media.nerConnectionClient
{

    public MediaScannerConnection connection;
    private final String mMimeType;
    private final String mPath;

    public void onMediaScannerConnected()
    {
        connection.scanFile(mPath, mMimeType);
        connection.disconnect();
    }

    public void onScanCompleted(String s, Uri uri)
    {
        SLog.d("Scan completed: {}, {}.", s, uri);
    }

    public ectionClient(String s, String s1)
    {
        mPath = s;
        mMimeType = s1;
    }
}
