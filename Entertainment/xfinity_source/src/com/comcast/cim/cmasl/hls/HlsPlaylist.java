// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class HlsPlaylist
{

    List unknownTags;
    String urlPathPrefix;
    String version;

    public HlsPlaylist()
    {
        version = "1";
        unknownTags = new ArrayList();
    }

    public void addUnknownTag(String s)
    {
        unknownTags.add(s);
    }

    protected String getAllUnknownTags()
    {
        String s = "";
        for (Iterator iterator = unknownTags.iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            if (s.length() == 0)
            {
                s = s1;
            } else
            {
                s = (new StringBuilder()).append(s).append("\n").append(s1).toString();
            }
        }

        return s;
    }

    protected String getStartAndVersionString()
    {
        return (new StringBuilder()).append("#EXTM3U\n#EXT-X-VERSION:").append(version).toString();
    }

    public List getUnknownTags()
    {
        return unknownTags;
    }

    public String getUrlPathPrefix()
    {
        return urlPathPrefix;
    }

    public String getVersion()
    {
        return version;
    }

    public void setUrlPathPrefix(String s)
    {
        urlPathPrefix = s;
    }

    public void setVersion(String s)
    {
        version = s;
    }
}
