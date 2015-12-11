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
//            HlsParser, HlsVariantPlaylist, HlsPlaylist

public class HlsVariantPlaylistParser extends HlsParser
{

    public HlsVariantPlaylistParser()
    {
    }

    private String getSubTagValueFromLine(String s, String s1)
    {
        if (s.contains(s1))
        {
            s1 = s.substring(s.indexOf(s1) + s1.length() + 1);
            s = s1;
            if (s1.contains(","))
            {
                s = s1.substring(0, s1.indexOf(","));
            }
            return s;
        } else
        {
            return null;
        }
    }

    public volatile HlsPlaylist parseStream(InputStream inputstream)
        throws IOException
    {
        return parseStream(inputstream);
    }

    public HlsVariantPlaylist parseStream(InputStream inputstream)
        throws IOException
    {
        HlsVariantPlaylist hlsvariantplaylist = new HlsVariantPlaylist();
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
        boolean flag = false;
label0:
        do
        {
            do
            {
                String s = inputstream.readLine();
                if (s != null)
                {
                    if (!s.trim().isEmpty())
                    {
                        if (!s.startsWith("#EXT"))
                        {
                            continue label0;
                        }
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
                        if (s.startsWith("#EXT-X-STREAM-INF:"))
                        {
                            String s1 = s.replace("#EXT-X-STREAM-INF:", "");
                            int k = Integer.parseInt(getSubTagValueFromLine(s, "BANDWIDTH"));
                            String s3 = inputstream.readLine();
                            boolean flag1 = false;
                            boolean flag2 = false;
                            String s5 = getSubTagValueFromLine(s, "RESOLUTION");
                            int j = ((flag1) ? 1 : 0);
                            int i = ((flag2) ? 1 : 0);
                            if (s5 != null)
                            {
                                String as[] = s5.split("x");
                                j = ((flag1) ? 1 : 0);
                                i = ((flag2) ? 1 : 0);
                                if (as.length == 2)
                                {
                                    j = Integer.valueOf(as[0]).intValue();
                                    i = Integer.valueOf(as[1]).intValue();
                                }
                            }
                            s = getSubTagValueFromLine(s, "AUDIO");
                            hlsvariantplaylist.addMediaProfile(new HlsVariantPlaylist.MediaProfile(s3, Integer.valueOf(k).intValue(), s1, s, j, i));
                        } else
                        if (s.startsWith("#EXT-X-MEDIA:"))
                        {
                            String s2 = s.replace("#EXT-X-MEDIA:", "");
                            String s4 = getSubTagValueFromLine(s, "TYPE");
                            String s6 = getSubTagValueFromLine(s, "URI");
                            String s7 = getSubTagValueFromLine(s, "LANGUAGE");
                            if (s7 != null)
                            {
                                s7.replace("\"", "");
                            }
                            String s8 = getSubTagValueFromLine(s, "GROUP-ID");
                            if (s4.equals("AUDIO"))
                            {
                                hlsvariantplaylist.addMediaAudioProfile(new HlsVariantPlaylist.MediaAudioProfile(s6, s7, s8, s2));
                            } else
                            {
                                processBaseItem(hlsvariantplaylist, s);
                            }
                        } else
                        {
                            processBaseItem(hlsvariantplaylist, s);
                        }
                    }
                } else
                {
                    return hlsvariantplaylist;
                }
            } while (true);
        } while (s.startsWith("#"));
        throw new CimException((new StringBuilder()).append("Failed to properly parse the M3U8 File! Unknown Line: ").append(s).toString());
    }
}
