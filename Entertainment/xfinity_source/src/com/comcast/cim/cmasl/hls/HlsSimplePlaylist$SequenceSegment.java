// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hls;


// Referenced classes of package com.comcast.cim.cmasl.hls:
//            HlsSimplePlaylist

public static class sequenceLength
{

    private String path;
    private String sequenceInfo;
    private double sequenceLength;

    public String getPath()
    {
        return path;
    }

    public String getSequenceInfo()
    {
        return sequenceInfo;
    }

    public double getSequenceLength()
    {
        return sequenceLength;
    }

    public void setPath(String s)
    {
        path = s;
    }



    public A(String s, String s1, double d)
    {
        path = s;
        sequenceInfo = s1;
        sequenceLength = d;
    }
}
