// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hls;

import com.comcast.cim.cmasl.utils.exceptions.CimException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// Referenced classes of package com.comcast.cim.cmasl.hls:
//            HlsParser, HlsSimplePlaylist, HlsPlaylist

public class HlsSimplePlaylistParser extends HlsParser
{

    public HlsSimplePlaylistParser()
    {
    }

    public volatile HlsPlaylist parseStream(InputStream inputstream)
        throws IOException
    {
        return parseStream(inputstream);
    }

    public HlsSimplePlaylist parseStream(InputStream inputstream)
        throws IOException
    {
        HlsSimplePlaylist hlssimpleplaylist = new HlsSimplePlaylist();
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
        boolean flag = false;
        do
        {
            String s = inputstream.readLine();
            if (s == null)
            {
                break;
            }
            if (s.startsWith("#EXT"))
            {
                if (!flag)
                {
                    if (s.startsWith("#EXTM3U"))
                    {
                        flag = true;
                    } else
                    {
                        throw new CimException("Failed to properly parse the M3U8 File! No Start Tag!");
                    }
                } else
                if (s.startsWith("#EXT-X-MEDIA-SEQUENCE:"))
                {
                    hlssimpleplaylist.mediaSequence = Integer.valueOf(Integer.parseInt(s.replace("#EXT-X-MEDIA-SEQUENCE:", "")));
                } else
                if (s.startsWith("#EXTINF:"))
                {
                    s = s.replace("#EXTINF:", "");
                    hlssimpleplaylist.addSequenceSegment(new HlsSimplePlaylist.SequenceSegment(inputstream.readLine(), s, Double.parseDouble(s.substring(0, s.indexOf(",")))));
                } else
                if (!s.startsWith("#EXT-X-ENDLIST"))
                {
                    processBaseItem(hlssimpleplaylist, s);
                }
            }
        } while (true);
        return hlssimpleplaylist;
    }
}
