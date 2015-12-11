// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.videoeditor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

// Referenced classes of package com.lifevibes.videoeditor:
//            VideoEditorImpl, VideoEditor

public class VideoEditorFactory
{

    public VideoEditorFactory()
    {
    }

    public static VideoEditor create(String s)
        throws IOException
    {
        File file = new File(s);
        if (!file.exists())
        {
            if (!file.mkdirs())
            {
                throw new FileNotFoundException((new StringBuilder()).append("Cannot create project path: ").append(s).toString());
            }
            if (!(new File(file, ".nomedia")).createNewFile())
            {
                throw new FileNotFoundException("Cannot create file .nomedia");
            }
        }
        return new VideoEditorImpl(s);
    }

    public static VideoEditor create(String s, String s1)
        throws IOException
    {
        File file = new File(s);
        if (!file.exists())
        {
            if (!file.mkdirs())
            {
                throw new FileNotFoundException((new StringBuilder()).append("Cannot create project path: ").append(s).toString());
            }
            if (!(new File(file, ".nomedia")).createNewFile())
            {
                throw new FileNotFoundException("Cannot create file .nomedia");
            }
        }
        return new VideoEditorImpl(s, s1);
    }
}
