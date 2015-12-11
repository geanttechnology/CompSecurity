// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


public class CaptionCue
{

    private static String lineSep = System.getProperty("line.separator");
    private static String timeSep = "-->";
    private int column;
    private String content;
    private String endTime;
    private int indent;
    private String rawContent;
    private int row;
    private String startTime;

    public CaptionCue(String s, String s1, String s2, int i, int j, int k)
    {
        startTime = s1;
        endTime = s2;
        row = i;
        column = j;
        indent = k;
        content = s;
    }

    protected String getHeader()
    {
        return (new StringBuilder()).append("WEBVTT").append(lineSep).append(lineSep).toString();
    }

    public String getWebVTT()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(startTime).append(timeSep).append(endTime).append(" ").append("line:").append(row).append(" ").append("position:").append(column).append(lineSep);
        stringbuffer.append(content).append(lineSep);
        return stringbuffer.toString();
    }

    protected void setRawText(String s)
    {
        rawContent = s;
    }

}
