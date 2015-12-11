// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hls;


// Referenced classes of package com.comcast.cim.cmasl.hls:
//            HlsVariantPlaylist

public static class height
{

    private String audio;
    private int bandwidth;
    private int height;
    private String relativePath;
    private String streamInfo;
    private int width;

    public String getAudio()
    {
        return audio;
    }

    public int getBandwidth()
    {
        return bandwidth;
    }

    public int getHeight()
    {
        return height;
    }

    public String getRelativePath()
    {
        return relativePath;
    }

    public String getStreamInfo()
    {
        return streamInfo;
    }

    public int getWidth()
    {
        return width;
    }

    public void setRelativePath(String s)
    {
        relativePath = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("[").append("relativePath=").append(relativePath).append(",bandwidth=").append(bandwidth).append(",streamInfo=").append(streamInfo).append(",audio=").append(audio).append(",width=").append(width).append(",height=").append(height).append("]").toString();
    }

    public (String s, int i, String s1, String s2, int j, int k)
    {
        relativePath = s;
        bandwidth = i;
        streamInfo = s1;
        audio = s2;
        width = j;
        height = k;
    }
}
