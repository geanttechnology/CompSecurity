// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;

import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMILResource
{
    public static final class AdsType extends Enum
    {

        private static final AdsType $VALUES[];
        public static final AdsType AUDITUDE_ADS;
        public static final AdsType C3_ADS;
        public static final AdsType NO_ADS;

        public static AdsType valueOf(String s)
        {
            return (AdsType)Enum.valueOf(com/xfinity/playerlib/authorization/SMILResource$AdsType, s);
        }

        public static AdsType[] values()
        {
            return (AdsType[])$VALUES.clone();
        }

        static 
        {
            NO_ADS = new AdsType("NO_ADS", 0);
            AUDITUDE_ADS = new AdsType("AUDITUDE_ADS", 1);
            C3_ADS = new AdsType("C3_ADS", 2);
            $VALUES = (new AdsType[] {
                NO_ADS, AUDITUDE_ADS, C3_ADS
            });
        }

        private AdsType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/authorization/SMILResource);
    private final List adsBreakStartTimes = new ArrayList();
    private AdsType adsType;
    private final List c3Blocks = new ArrayList();
    private final String signedManifestUrl;

    public SMILResource(String s)
    {
        signedManifestUrl = s;
    }

    public void addAdsBreakStartTime(int i)
    {
        adsBreakStartTimes.add(Integer.valueOf(i));
    }

    public void addC3Block(VideoAdBreak videoadbreak)
    {
        c3Blocks.add(videoadbreak);
    }

    public List getAdsBreakStartTimes()
    {
        return Collections.unmodifiableList(adsBreakStartTimes);
    }

    public AdsType getAdsType()
    {
        return adsType;
    }

    public List getC3Blocks()
    {
        return Collections.unmodifiableList(c3Blocks);
    }

    public String getSignedManifestUrl()
    {
        return signedManifestUrl;
    }

    public void setAdsType(AdsType adstype)
    {
        adsType = adstype;
    }

}
