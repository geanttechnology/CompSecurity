// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.models.api:
//            Analytics

public class AdBreak
    implements Serializable
{

    private boolean adEventStarted;
    private ArrayList adgroup;
    private Analytics analytics;
    private float end;
    private String num;
    private float start;
    private String type;
    private boolean watched;

    public AdBreak()
    {
        type = null;
        num = null;
        analytics = null;
        start = 0.0F;
        end = 0.0F;
        adgroup = null;
        watched = false;
        adEventStarted = false;
    }

    public ArrayList getAdgroup()
    {
        return adgroup;
    }

    public float getEnd()
    {
        return end;
    }

    public String getNum()
    {
        return num;
    }

    public float getStart()
    {
        return start;
    }

    public boolean isAdEventStarted()
    {
        return adEventStarted;
    }

    public boolean isWatched()
    {
        return watched;
    }

    public void setAdEventStarted(boolean flag)
    {
        adEventStarted = flag;
    }

    public void setWatched(boolean flag)
    {
        watched = flag;
    }
}
