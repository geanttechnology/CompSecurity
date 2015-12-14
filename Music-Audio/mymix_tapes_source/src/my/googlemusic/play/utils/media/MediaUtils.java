// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.media;

import android.content.Context;
import android.media.MediaScannerConnection;

public class MediaUtils
{

    public MediaUtils()
    {
    }

    public static void scanFile(Context context, String s)
    {
        scanFile(context, s, null);
    }

    public static void scanFile(Context context, String s, String s1)
    {
    /* block-local class not found */
    class Client {}

        s = new Client(s, s1);
        context = new MediaScannerConnection(context, s);
        s.connection = context;
        context.connect();
    }
}
