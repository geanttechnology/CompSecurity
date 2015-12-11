// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import java.io.FileNotFoundException;

// Referenced classes of package co.vine.android.util:
//            MediaUtil

public static class thumbnailPath
    implements Runnable
{

    private final long duration;
    private final String lastFramePath;
    private final String thumbnailPath;
    private final String videoPath;

    public void run()
    {
        try
        {
            MediaUtil.generateThumbnails(duration, videoPath, thumbnailPath, lastFramePath);
            return;
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            throw new RuntimeException(filenotfoundexception);
        }
    }

    public (long l, String s, String s1, String s2)
    {
        duration = l;
        lastFramePath = s2;
        videoPath = s;
        thumbnailPath = s1;
    }
}
