// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.camerasettings;


public class Parameters
{

    public static final int DEFAULT_HEIGHT = 720;
    public static final int DEFAULT_WIDTH = 1280;
    private String height;
    private String limited;
    private String postProcessing;
    private String settings;
    private String width;

    public Parameters()
    {
    }

    public String getCameraSettings()
    {
        return settings;
    }

    public String getHeight()
    {
        return height;
    }

    public int getHeightInt()
    {
        int i;
        try
        {
            i = Integer.parseInt(height);
        }
        catch (Exception exception)
        {
            return 720;
        }
        return i;
    }

    public String getLimited()
    {
        return limited;
    }

    public String getPostProcessing()
    {
        return postProcessing;
    }

    public String getWidth()
    {
        return width;
    }

    public int getWidthInt()
    {
        int i;
        try
        {
            i = Integer.parseInt(width);
        }
        catch (Exception exception)
        {
            return 1280;
        }
        return i;
    }

    public void setCameraCorrections(String s)
    {
        settings = s;
    }

    public void setHeight(String s)
    {
        height = s;
    }

    public void setPostProcessing(String s)
    {
        postProcessing = s;
    }

    public void setWidth(String s)
    {
        width = s;
    }

    public void setlimited(String s)
    {
        limited = s;
    }
}
