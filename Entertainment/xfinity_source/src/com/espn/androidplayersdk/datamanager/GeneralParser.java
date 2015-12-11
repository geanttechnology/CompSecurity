// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            ConfigParser, ChannelsParser, FeaturedEventParser, FeaturedEventsParserII, 
//            LiveEventsParser, SportsParser, TopSportParser, EventsByLeagueParser, 
//            EventBySportParser, EventsByChannelParser, TrendingEventsParser, FeaturedCategoryParser, 
//            FeaturedCategoryEventsParser, TopSportEventParser, JSONParserInterface

class GeneralParser
{

    String mType;
    JSONParserInterface parser;

    public GeneralParser(String s)
    {
        mType = s;
    }

    public void instantiateJSONParser()
    {
        try
        {
            if (mType.contains("configs/sdk"))
            {
                parser = new ConfigParser();
                return;
            }
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Error", 5, exception);
            return;
        }
        if (mType.contains("/networks"))
        {
            parser = new ChannelsParser();
            return;
        }
        if (mType.contains("listings/top"))
        {
            parser = new FeaturedEventParser();
            return;
        }
        if (mType.contains("video/channels"))
        {
            parser = new FeaturedEventsParserII();
            return;
        }
        if (mType.contains("listings?types=live"))
        {
            parser = new LiveEventsParser();
            return;
        }
        if (mType.contains("/categories?"))
        {
            parser = new SportsParser();
            return;
        }
        if (mType.contains("/categories/top?"))
        {
            parser = new TopSportParser();
            return;
        }
        if (mType.contains("/categories/"))
        {
            parser = new EventsByLeagueParser();
            return;
        }
        if (mType.contains("categories/listings?"))
        {
            parser = new EventsByLeagueParser();
            return;
        }
        if (mType.contains("listings?categories"))
        {
            parser = new EventBySportParser();
            return;
        }
        if (mType.contains("listings?network"))
        {
            parser = new EventsByChannelParser();
            return;
        }
        if (mType.contains("listings?network"))
        {
            parser = new EventsByChannelParser();
            return;
        }
        if (mType.contains("watch/trending?"))
        {
            parser = new TrendingEventsParser();
            return;
        }
        if (mType.contains("watch/features?"))
        {
            parser = new FeaturedCategoryParser();
            return;
        }
        if (mType.contains("featuredCategoryEvent"))
        {
            parser = new FeaturedCategoryEventsParser();
            return;
        }
        if (mType.contains("featuredTopSportEvent"))
        {
            parser = new TopSportEventParser();
        }
        return;
    }

    public void instantiateXMLParser()
    {
        try
        {
            mType.contains("XML");
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Error", 5, exception);
        }
    }

    public void parse(JSONObject jsonobject, HashMap hashmap)
    {
label0:
        {
            if (parser != null)
            {
                if (jsonobject == null)
                {
                    break label0;
                }
                parser.parse(jsonobject, hashmap);
            }
            return;
        }
        parser.errorHandler(1);
    }

    public void parseXML(HttpEntity httpentity)
    {
    }
}
