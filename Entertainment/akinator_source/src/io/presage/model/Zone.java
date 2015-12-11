// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.model;

import java.util.List;

public class Zone
{
    public static class Margins
    {

        public int bottom;
        public int left;
        public int right;
        public int top;

        public Margins()
        {
        }
    }

    public static class Position
    {

        public int x;
        public int y;

        public Position()
        {
        }
    }

    public static class Size
    {

        public int height;
        public int width;

        public Size()
        {
        }
    }


    private String background;
    private List gravity;
    private Margins margins;
    private String name;
    private Position position;
    private Size size;
    private boolean trackHistory;
    private boolean trackLanding;
    private String type;
    private String url;
    private boolean videoAutoPlay;
    private boolean videoMuted;

    public Zone()
    {
    }

    public String getBackground()
    {
        return background;
    }

    public List getGravity()
    {
        return gravity;
    }

    public Margins getMargins()
    {
        return margins;
    }

    public String getName()
    {
        return name;
    }

    public Position getPosition()
    {
        return position;
    }

    public Size getSize()
    {
        return size;
    }

    public String getType()
    {
        return type;
    }

    public String getUrl()
    {
        return url;
    }

    public boolean isTrackHistory()
    {
        return trackHistory;
    }

    public boolean isTrackLanding()
    {
        return trackLanding;
    }

    public boolean isVideo()
    {
        return type != null && type.equals("video");
    }

    public boolean isVideoAutoPlay()
    {
        return videoAutoPlay;
    }

    public boolean isVideoMuted()
    {
        return videoMuted;
    }
}
