// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.vast;

import android.graphics.Bitmap;
import java.util.ArrayList;

// Referenced classes of package com.mdotm.android.vast:
//            BaseVastAd

public class Companion extends BaseVastAd
{

    protected static ArrayList companionCreativeViewList = new ArrayList();
    protected static Bitmap companionImage;
    protected static String companionStaticImageClickThrough;
    protected static ArrayList companionStaticImageClickTracking = new ArrayList();
    public static String htmlResource;
    private static final long serialVersionUID = 1L;
    protected String closeBtnLocation;
    public String closeBtnSize;
    protected String height;
    protected String skipOffset;
    protected String staticResource;
    protected ArrayList vastHtmlClickTracking;
    protected String width;

    public Companion()
    {
        vastHtmlClickTracking = new ArrayList();
    }

    public String getCloseLoc()
    {
        return closeBtnLocation;
    }

    public String getHTMLResource()
    {
        return htmlResource;
    }

    public String getSkipOffset()
    {
        return skipOffset;
    }

    public ArrayList vastHtmlClickTrack()
    {
        return vastHtmlClickTracking;
    }

}
