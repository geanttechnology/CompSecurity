// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.extractors;

import android.media.MediaFormat;
import java.nio.ByteBuffer;

// Referenced classes of package com.rdio.android.audioplayer.extractors:
//            MediaFormat

public class AndroidMediaFormat
    implements com.rdio.android.audioplayer.extractors.MediaFormat
{

    private String esdsString;
    private MediaFormat format;

    public AndroidMediaFormat()
    {
    }

    public MediaFormat getMediaFormat()
    {
        return format;
    }

    public void setAAC(int i, int j, byte abyte0[])
    {
        esdsString = new String(abyte0);
        format = MediaFormat.createAudioFormat("audio/mp4a-latm", i, j);
        abyte0 = ByteBuffer.wrap(abyte0);
        format.setByteBuffer("csd-0", abyte0);
    }

    public void setMP3(int i, int j)
    {
        esdsString = null;
        format = MediaFormat.createAudioFormat("audio/mpeg", i, j);
    }

    public String toString()
    {
        if (format == null)
        {
            return "Uninitialized AndroidMediaFormat";
        }
        if (esdsString == null)
        {
            return format.toString();
        } else
        {
            return String.format("%s, esds is %s", new Object[] {
                format.toString(), esdsString
            });
        }
    }
}
