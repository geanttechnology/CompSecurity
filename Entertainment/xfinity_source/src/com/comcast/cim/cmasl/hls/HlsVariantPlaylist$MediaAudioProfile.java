// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hls;


// Referenced classes of package com.comcast.cim.cmasl.hls:
//            HlsVariantPlaylist

public static class mediaInfo
{

    private String groupId;
    private String language;
    private String mediaInfo;
    private String uriString;

    public String getGroupId()
    {
        return groupId;
    }

    public String getLanguage()
    {
        return language;
    }

    public String getMediaInfo()
    {
        return mediaInfo;
    }

    public String getUriString()
    {
        return uriString;
    }

    public void setUriString(String s)
    {
        String s1 = mediaInfo.substring(0, mediaInfo.indexOf("URI") + "URI".length() + 1);
        s1 = (new StringBuilder()).append(s1).append(s).toString();
        if (mediaInfo.indexOf(uriString) != mediaInfo.length() - uriString.length())
        {
            s1 = mediaInfo.substring(mediaInfo.indexOf("URI") + "URI".length() + 1 + uriString.length());
        }
        mediaInfo = s1;
        uriString = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("[").append("uriString=").append(uriString).append(",language=").append(language).append(",groupId=").append(groupId).append(",mediaInfo=").append(mediaInfo).append("]").toString();
    }

    public (String s, String s1, String s2, String s3)
    {
        uriString = s;
        language = s1;
        groupId = s2;
        mediaInfo = s3;
    }
}
