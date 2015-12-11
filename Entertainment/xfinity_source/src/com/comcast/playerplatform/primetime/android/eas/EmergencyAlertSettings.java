// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import android.graphics.Color;

public class EmergencyAlertSettings
{

    private int alertPollingInterval;
    private int alertRepeatCount;
    private int backgroundColor;
    private boolean hasBackground;
    private int textColor;
    private int textSize;

    public EmergencyAlertSettings()
    {
        hasBackground = true;
        textColor = -1;
        backgroundColor = 0xff000000;
        alertPollingInterval = 15000;
        alertRepeatCount = 1;
        textSize = 22;
    }

    public int getAlertPollingInterval()
    {
        return alertPollingInterval;
    }

    public int getAlertRepeatCount()
    {
        return alertRepeatCount;
    }

    public int getBackgroundColor()
    {
        return backgroundColor;
    }

    public boolean getHasBackground()
    {
        return hasBackground;
    }

    public int getTextColor()
    {
        return textColor;
    }

    public float getTextSize()
    {
        return (float)textSize;
    }

    public void setAlertPollingInterval(int i)
    {
        alertPollingInterval = i;
    }

    public void setAlertRepeatCount(int i)
    {
        if (i >= 0)
        {
            alertRepeatCount = i;
        }
    }

    public void setBackgroundColor(String s)
    {
        try
        {
            backgroundColor = Color.parseColor(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void setHasBackground(boolean flag)
    {
        hasBackground = flag;
    }

    public void setTextColor(String s)
    {
        try
        {
            Color.parseColor(s);
            textColor = Color.parseColor(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void setTextSize(int i)
    {
        textSize = i;
    }
}
