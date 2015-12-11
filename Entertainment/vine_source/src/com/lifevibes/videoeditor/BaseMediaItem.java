// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.videoeditor;

import java.io.File;
import java.io.IOException;

// Referenced classes of package com.lifevibes.videoeditor:
//            VideoEditorImpl, MediaArtistNativeHelper, VideoEditor

public abstract class BaseMediaItem
{

    protected final String mFilename;
    protected final MediaArtistNativeHelper mMANativeHelper;
    protected final String mUniqueId;

    protected BaseMediaItem(VideoEditor videoeditor, String s, String s1)
        throws IOException
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("MediaItem : filename is null");
        }
        if (!(new File(s1)).exists())
        {
            throw new IOException((new StringBuilder()).append(s1).append(" not found ! ").toString());
        } else
        {
            mUniqueId = s;
            mFilename = s1;
            mMANativeHelper = ((VideoEditorImpl)videoeditor).getNativeContext();
            return;
        }
    }

    public abstract long getDuration();

    public abstract int getFileType();

    public String getFilename()
    {
        return mFilename;
    }

    public String getId()
    {
        return mUniqueId;
    }

    MediaArtistNativeHelper getNativeContext()
    {
        return mMANativeHelper;
    }

    public abstract long getTimelineDuration();
}
