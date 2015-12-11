// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hls;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.comcast.cim.cmasl.hls:
//            HlsPlaylist

public abstract class HlsParser
{

    public HlsParser()
    {
    }

    public abstract HlsPlaylist parseStream(InputStream inputstream)
        throws IOException;

    protected void processBaseItem(HlsPlaylist hlsplaylist, String s)
    {
        if (s.startsWith("#EXT-X-VERSION:"))
        {
            hlsplaylist.version = s.replace("#EXT-X-VERSION:", "");
            return;
        } else
        {
            hlsplaylist.addUnknownTag(s);
            return;
        }
    }
}
