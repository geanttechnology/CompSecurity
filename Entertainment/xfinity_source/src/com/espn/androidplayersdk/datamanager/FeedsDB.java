// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.espn.androidplayersdk.utilities.Utils;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            EPSport

class FeedsDB extends SQLiteOpenHelper
{

    public static final String CHANNELS_CODE = "code";
    public static final String CHANNELS_ID = "id";
    public static final String CHANNELS_IMAGE_SMALL = "ImageSmall";
    public static final String CHANNELS_ISACTIVE = "isActive";
    public static final String CHANNELS_NAME = "channelName";
    public static final String CHANNELS_RESOURCEID = "resourceId";
    public static final String CHANNELS_SLATE_LARGE = "slateImageLarge";
    public static final String CHANNELS_SLATE_MED = "slateImageMedium";
    public static final String CHANNELS_SLATE_SMALL = "slateImageSmall";
    public static final String CHANNELS_TABLE = "channel";
    public static final String CHANNELS_TYPE = "type";
    public static final String CONFIG_ABOUT_URL = "aboutUrl";
    public static final String CONFIG_AFFILIATE_IMG_URL = "affiliateImgUrl";
    public static final String CONFIG_AUTH_POST_SIGNIN_URL = "authPostSignInURL";
    public static final String CONFIG_BASE_URL = "baseURL";
    public static final String CONFIG_CHANNEL_IMAGE_URL = "channelImgUrl";
    public static final String CONFIG_EVENT_IMAGE_URLL = "eventImgUrl";
    public static final String CONFIG_EVENT_POLING_INTERVAL = "eventPollingInterval";
    public static final String CONFIG_EVENT_POLLING_URL = "eventPollingUrl";
    public static final String CONFIG_FAQ_URL = "faqURL";
    public static final String CONFIG_GRACE_PERIOD = "gracePeriod";
    public static final String CONFIG_OMNITURE_JSON = "omnitureJson";
    public static final String CONFIG_PLAYER_URL = "playerURL";
    public static final String CONFIG_PRIVACY_POLICY = "privacyPolicy";
    public static final String CONFIG_SEND_FEEDBACK_URL = "sendFeedbackURL";
    public static final String CONFIG_SETINGS_URL = "settingsURL";
    public static final String CONFIG_SETUP_URL = "setupURL";
    public static final String CONFIG_SIGNIN_URL = "signInURL";
    public static final String CONFIG_TABLE = "config";
    public static final String CONFIG_TERMS_OF_USE = "termsOfUse";
    public static final String CONFIG_TTL = "TTL";
    public static final String CONFIG_WELCOME_URL = "welcomeURL";
    private static final String DB_NAME = "feeds.db";
    private static final int DB_VERSION = 9;
    public static final String EVENTS_BLACKOUT_JSON = "blackoutsJason";
    public static final String EVENTS_BROADCAST_START_TIME = "broadcastStartTime";
    public static final String EVENTS_COVERAGETYPE = "coverageType";
    public static final String EVENTS_DESCRIPTION = "description";
    public static final String EVENTS_END_TIME = "endTime";
    public static final String EVENTS_EVENTID = "eventId";
    public static final String EVENTS_EVENT_NAME = "eventName";
    public static final String EVENTS_EVENT_TYPE = "eventType";
    public static final String EVENTS_GUID = "guid";
    public static final String EVENTS_IMAGE_LARGE = "imageLarge";
    public static final String EVENTS_IMAGE_MED = "imageMed";
    public static final String EVENTS_IMAGE_SMALL = "imageSmall";
    public static final String EVENTS_LEAGUE = "league";
    public static final String EVENTS_LEAGUE_NAME = "leagueName";
    public static final String EVENTS_METAEVENT_RELATION_ID = "metaEventRelationId";
    public static final String EVENTS_NETWORKID = "networkId";
    public static final String EVENTS_NETWORKRESOURCEID = "networkResourceId";
    public static final String EVENTS_NETWORK_CODE = "networkCode";
    public static final String EVENTS_NETWORK_NAME = "networkName";
    public static final String EVENTS_OMNITURE_JSON = "omnitureJson";
    public static final String EVENTS_PARENTAL_RATING = "parentalRating";
    public static final String EVENTS_PROGRAMMINGCODE = "programingCode";
    public static final String EVENTS_SEEKINSEC = "seekInSeconds";
    public static final String EVENTS_SHOW_NAME = "showName";
    public static final String EVENTS_SIMULCASTAIRINGID = "simulcastAiringId";
    public static final String EVENTS_SPORT = "SPORT";
    public static final String EVENTS_SPORTCODE = "sportCode";
    public static final String EVENTS_SPORTID = "sportId";
    public static final String EVENTS_START_TIME = "startTime";
    public static final String EVENTS_TABLE = "events";
    public static final String EVENTS_VIDEOURLDEFAULT = "videoURLDefault";
    public static final String EVENTS_VIDEOURLHD = "videoURLHD";
    public static final String EVENTS_VIDEOURLLARGE = "videoURLLarge";
    public static final String EVENTS_VIDEOURLMED = "videoURLMed";
    public static final String EVENTS_VIDEOURLSMALL = "videoURLSmall";
    public static final String EVENT_RELATION_EVENTBYID = "6";
    public static final String EVENT_RELATION_EVENTSBYCHANNEL = "3";
    public static final String EVENT_RELATION_EVENTSBYCHANNELLEAGUE = "8";
    public static final String EVENT_RELATION_EVENTSBYSPORTLEAGUE = "7";
    public static final String EVENT_RELATION_EVENTSBYSPORTS = "4";
    public static final String EVENT_RELATION_LIVEEVENTS = "1";
    public static final String EVENT_RELATION_SEARCH = "5";
    public static final String FEATURED_CATEGORIES_ABBRE = "abbre";
    public static final String FEATURED_CATEGORIES_CATEGORYID = "categoryId";
    public static final String FEATURED_CATEGORIES_IMAGEURL = "imageUrl";
    public static final String FEATURED_CATEGORIES_LISTINGSURL = "listingUrl";
    public static final String FEATURED_CATEGORIES_NAME = "name";
    public static final String FEATURED_CATEGORIES_SHORTNAME = "shortName";
    public static final String FEATURED_CATEGORIES_TABLE = "featuredCategories";
    public static final String FEATURED_CATEGORIES_TYPE = "type";
    public static final String FEATURED_CATEGORIES_VODURL = "vodUrl";
    public static final String FEATURED_EVENTS_TABLE = "featuredEvents";
    public static final String METACHANNELS_OMNITURE_JSON = "omnitureJason";
    public static final String METACHANNELS_TTL = "TTL";
    public static final String METACHANNEL_TABLE = "metaChannel";
    public static final String METAEVENTS_COUNT = "count";
    public static final String METAEVENTS_EVENTTYPE = "eventsType";
    public static final String METAEVENTS_EVENT_RELATION_ID = "eventRelationId";
    public static final String METAEVENTS_NETWORKID = "networkId";
    public static final String METAEVENTS_OMNITUREJSON = "omnitureJson";
    public static final String METAEVENTS_SPORTID = "sportId";
    public static final String METAEVENTS_TABLE = "metaEvents";
    public static final String METAEVENTS_TTL = "ttl";
    public static final String METASPORTS_OMNITURE_JSON = "omnitureJason";
    public static final String METASPORTS_SPORT_RELATION_ID = "sportrelationId";
    public static final String METASPORTS_TABLE = "metaSport";
    public static final String METASPORTS_TTL = "TTL";
    public static final String SPORTS_ABBRE = "sportAbbre";
    public static final String SPORTS_ID = "soprtId";
    public static final String SPORTS_LEAGUEID = "sportLeagueId";
    public static final String SPORTS_LISTINGURL = "sportListingUrl";
    public static final String SPORTS_METASPORT_RELATION_ID = "sportMetaSportRelation";
    public static final String SPORTS_NAME = "sportName";
    public static final String SPORTS_SHORTNAME = "sportShortName";
    public static final String SPORTS_TABLE = "sport";
    public static final String SPORTS_TOPLISTINGURL = "sportListingtop";
    public static final String SPORTS_TYPE = "sportType";
    public static final String SPORTS_VODURL = "sportVodUrl";
    public static final String SPORT_METASPORT_RELATION = "101";
    public static final String TOPSPORT_METASPORT_RELATION = "102";
    public static final String USER_DATA_AFFILIATE_NAME = "affiliateName";
    public static final String USER_DATA_AUTHENTICATED = "authenticated";
    public static final String USER_DATA_GRACE_TIME_LEFT = "graceTimeLeft";
    public static final String USER_DATA_IMAGE = "image";
    public static final String USER_DATA_ISLOGGEDIN = "isLoggedIn";
    public static final String USER_DATA_NAME = "name";
    public static final String USER_DATA_OMNISWID = "omniSwid";
    public static final String USER_DATA_SWID = "swid";
    public static final String USER_DATA_TABLE = "userdata";
    public static final String USER_DATA_UDID = "udid";
    public static final String USER_DATA_USER_NAME = "username";
    SQLiteDatabase db;

    FeedsDB(Context context)
    {
        super(context, "feeds.db", null, 9);
        if (!isConnectionOpen())
        {
            openConnection();
        }
    }

    protected void cleanEventsTable()
    {
        db.delete("events", "metaEventRelationId=?", new String[] {
            "6"
        });
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (db != null)
        {
            releaseMemory();
            db.close();
            super.close();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void closeConnection()
    {
        try
        {
            db.close();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    protected void delAllRows(String s, String s1, String as[])
    {
        try
        {
            if (!isConnectionOpen())
            {
                openConnection();
            }
            db.delete(s, s1, as);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error", 5, s);
        }
    }

    protected Cursor getAllChannels()
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        return db.query(true, "channel", null, null, null, null, null, null, null);
    }

    protected Cursor getAllSports(String s)
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        return db.query(true, "sport", null, "sportMetaSportRelation= ?", new String[] {
            s
        }, null, null, null, null);
    }

    protected Cursor getConfig()
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        return db.query(true, "config", null, null, null, null, null, null, null);
    }

    protected Cursor getEventById(String s)
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        s = (new StringBuilder("Select * from events where eventId=")).append(s).toString();
        return db.rawQuery(s, null);
    }

    protected Cursor getEventsForChannel(String s, String s1)
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        String s2 = (new StringBuilder("Select * from events where metaEventRelationId = '3' and networkId = '")).append(s).append("'").toString();
        s = s2;
        if (s1 != null)
        {
            s = (new StringBuilder(String.valueOf(s2))).append(" and eventType = '").append(s1).append("'").toString();
        }
        return db.rawQuery(s, null);
    }

    protected Cursor getEventsForChannelByLeague(String s, String s1)
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        String s2 = (new StringBuilder("Select * from events where metaEventRelationId = '8' and networkCode = '")).append(s).append("'").toString();
        s = s2;
        if (s1 != null)
        {
            s = (new StringBuilder(String.valueOf(s2))).append(" and eventType = '").append(s1).append("'").toString();
        }
        return db.rawQuery(s, null);
    }

    protected Cursor getEventsForFeaturedCategories(int i, String s, String s1)
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        String s3 = (new StringBuilder("Select * from featuredEvents where metaEventRelationId = '")).append(i).toString();
        String s2 = s3;
        if (s != null)
        {
            s2 = (new StringBuilder(String.valueOf(s3))).append("' and eventType= '").append(s).append("'").toString();
        }
        s = s2;
        if (s1 != null)
        {
            s = (new StringBuilder(String.valueOf(s2))).append(" and sportId = '").append(s1).append("'").toString();
        }
        return db.rawQuery(s, null);
    }

    protected Cursor getEventsForSport(String s, String s1)
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        String s2 = (new StringBuilder("Select * from events where metaEventRelationId = '4' and sportId = '")).append(s).append("'").toString();
        s = s2;
        if (s1 != null)
        {
            s = (new StringBuilder(String.valueOf(s2))).append(" and eventType = '").append(s1).append("'").toString();
        }
        return db.rawQuery(s, null);
    }

    protected Cursor getEventsForSportByLeague(String s, String s1)
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        String s2 = (new StringBuilder("Select * from events where metaEventRelationId = '7' and sportId = '")).append(s).append("'").toString();
        s = s2;
        if (s1 != null)
        {
            s = (new StringBuilder(String.valueOf(s2))).append(" and eventType = '").append(s1).append("'").toString();
        }
        return db.rawQuery(s, null);
    }

    protected Cursor getFeaturedCategories()
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        return db.rawQuery("Select * from featuredCategories", null);
    }

    protected Cursor getFeaturedEventById(String s)
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        s = (new StringBuilder("Select * from featuredEvents where eventId=")).append(s).toString();
        return db.rawQuery(s, null);
    }

    protected Cursor getFeaturedEvents(int i, EPSport epsport)
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        String s1 = (new StringBuilder("Select * from featuredEvents where metaEventRelationId = '")).append(i).append("'").toString();
        String s = s1;
        if (epsport != null)
        {
            s = (new StringBuilder(String.valueOf(s1))).append(" and sportId = '").append(epsport.getId()).append("'").toString();
        }
        return db.rawQuery(s, null);
    }

    protected Cursor getLiveEvents()
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        return db.rawQuery("Select * from events where metaEventRelationId = '1'", null);
    }

    protected Cursor getMeta(String s, String s1, String as[])
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        return db.query(true, s, null, s1, as, null, null, null, null);
    }

    protected Cursor getTableRows(String s, String s1, String s2)
    {
        if (!isConnectionOpen())
        {
            openConnection();
        }
        String s3 = (new StringBuilder("Select * from ")).append(s).toString();
        s = s3;
        if (s2 != null)
        {
            s = (new StringBuilder(String.valueOf(s3))).append(" where ").append(s2).toString();
        }
        s2 = s;
        if (s1 != null)
        {
            s2 = (new StringBuilder(String.valueOf(s))).append(" limit ").append(s1).toString();
        }
        return db.rawQuery(s2, null);
    }

    public String getVODUrl(String s, String s1)
    {
        Object obj = null;
        if (!isConnectionOpen())
        {
            openConnection();
        }
        s = (new StringBuilder("Select ")).append(s1).append(" from ").append("featuredEvents").append(" where ").append("eventId").append("=").append(s).toString();
        s1 = db.rawQuery(s, null);
        s = obj;
        if (s1.getCount() > 0)
        {
            s = obj;
            if (s1.moveToFirst())
            {
                s = s1.getString(0);
            }
        }
        return s;
    }

    public String[] getVideoInfo(String s, String s1, String s2)
    {
        Object obj;
        if (!isConnectionOpen())
        {
            openConnection();
        }
        obj = null;
        Object obj1 = (new StringBuilder("Select ")).append(s1).append(",").append("eventType").append(",").append("type").append(" from ").append(s2).append(",").append("channel").append(" where ").append("eventId").append("=").append(s).append(" and ").append("networkCode").append("=").append("code").toString();
        obj1 = db.rawQuery(((String) (obj1)), null);
        if (((Cursor) (obj1)).getCount() <= 0 || !((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_239;
        }
        while (!((Cursor) (obj1)).getString(1).equalsIgnoreCase("live") && ((Cursor) (obj1)).moveToNext()) ;
        if (((Cursor) (obj1)).isAfterLast())
        {
            ((Cursor) (obj1)).moveToPrevious();
        }
        s = new String[3];
        s[0] = ((Cursor) (obj1)).getString(0);
        s[1] = ((Cursor) (obj1)).getString(1);
        s[2] = ((Cursor) (obj1)).getString(2);
_L2:
        return s;
        s = (new StringBuilder("Select ")).append(s1).append(",").append("eventType").append(" from ").append(s2).append(" where ").append("eventId").append("=").append(s).append(";").toString();
        s1 = db.rawQuery(s, null);
        s = obj;
        if (s1.getCount() > 0)
        {
            s = obj;
            if (s1.moveToFirst())
            {
                return (new String[] {
                    s1.getString(0), s1.getString(1), ""
                });
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void insertIntoChannelsTable(ContentValues contentvalues)
    {
        try
        {
            if (!isConnectionOpen())
            {
                openConnection();
            }
            db.insertWithOnConflict("channel", null, contentvalues, 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ContentValues contentvalues)
        {
            Utils.sdkLog("Error", 5, contentvalues);
        }
    }

    protected void insertIntoConfigsTable(ContentValues contentvalues)
    {
        try
        {
            if (!isConnectionOpen())
            {
                openConnection();
            }
            db.insertWithOnConflict("config", null, contentvalues, 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ContentValues contentvalues)
        {
            Utils.sdkLog("Error", 5, contentvalues);
        }
    }

    protected void insertIntoEventsTable(ContentValues contentvalues)
    {
        try
        {
            if (!isConnectionOpen())
            {
                openConnection();
            }
            db.insertWithOnConflict("events", null, contentvalues, 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ContentValues contentvalues)
        {
            Utils.sdkLog("Error", 5, contentvalues);
        }
    }

    protected void insertIntoFeaturedCategoriesTable(ContentValues contentvalues)
    {
        try
        {
            if (!isConnectionOpen())
            {
                openConnection();
            }
            db.insertWithOnConflict("featuredCategories", null, contentvalues, 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ContentValues contentvalues)
        {
            Utils.sdkLog("Error", 5, contentvalues);
        }
    }

    protected void insertIntoFeaturedEventsTable(ContentValues contentvalues)
    {
        try
        {
            if (!isConnectionOpen())
            {
                openConnection();
            }
            db.insertWithOnConflict("featuredEvents", null, contentvalues, 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ContentValues contentvalues)
        {
            Utils.sdkLog("Error", 5, contentvalues);
        }
    }

    protected void insertIntoMetaEventsTable(ContentValues contentvalues)
    {
        try
        {
            if (!isConnectionOpen())
            {
                openConnection();
            }
            db.insertWithOnConflict("metaEvents", null, contentvalues, 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ContentValues contentvalues)
        {
            Utils.sdkLog("Error", 5, contentvalues);
        }
    }

    protected void insertIntoSportsTable(ContentValues contentvalues)
    {
        try
        {
            if (!isConnectionOpen())
            {
                openConnection();
            }
            db.insertWithOnConflict("sport", null, contentvalues, 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ContentValues contentvalues)
        {
            Utils.sdkLog("Error", 5, contentvalues);
        }
    }

    protected void insertIntoUserDataTable(ContentValues contentvalues)
    {
        try
        {
            if (!isConnectionOpen())
            {
                openConnection();
            }
            db.insertWithOnConflict("userdata", null, contentvalues, 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ContentValues contentvalues)
        {
            Utils.sdkLog("Error", 5, contentvalues);
        }
    }

    protected void insertOrUpdateMetaChannelTable(ContentValues contentvalues)
    {
        try
        {
            if (!isConnectionOpen())
            {
                openConnection();
            }
            if (db.updateWithOnConflict("metaChannel", contentvalues, null, null, 1) < 1)
            {
                db.insertWithOnConflict("metaChannel", null, contentvalues, 1);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ContentValues contentvalues)
        {
            Utils.sdkLog("Error", 5, contentvalues);
        }
    }

    protected void insertOrUpdateMetaEventsTable(ContentValues contentvalues)
    {
        String s;
        String as[];
        String s1;
        String as1[];
        int i;
        try
        {
            if (!isConnectionOpen())
            {
                openConnection();
            }
        }
        // Misplaced declaration of an exception variable
        catch (ContentValues contentvalues)
        {
            Utils.sdkLog("Error", 5, contentvalues);
            return;
        }
        s = "eventRelationId = ?";
        i = contentvalues.getAsInteger("eventRelationId").intValue();
          goto _L1
_L12:
        if (i != 16) goto _L3; else goto _L2
_L2:
        as = new String[2];
        as[1] = contentvalues.getAsString("sportId");
        s = (new StringBuilder(String.valueOf("eventRelationId = ?"))).append(" and sportId = ? ").toString();
_L5:
        as[0] = contentvalues.getAsString("eventRelationId");
        as1 = as;
_L8:
        if (db.updateWithOnConflict("metaEvents", contentvalues, s, as1, 1) < 1)
        {
            db.insertWithOnConflict("metaEvents", null, contentvalues, 1);
            return;
        }
          goto _L4
_L3:
        as = new String[1];
          goto _L5
_L13:
        if (!contentvalues.containsKey("eventsType") || Utils.isEmpty(contentvalues.getAsString("eventsType"))) goto _L7; else goto _L6
_L6:
        as = new String[3];
        s1 = (new StringBuilder(String.valueOf("eventRelationId = ?"))).append(" and eventsType = ?").toString();
        as[1] = contentvalues.getAsString("eventsType");
_L9:
        as[0] = contentvalues.getAsString("eventRelationId");
        if (!contentvalues.containsKey("sportId") || Utils.isEmpty(contentvalues.getAsString("sportId")))
        {
            break MISSING_BLOCK_LABEL_300;
        }
        s = (new StringBuilder(String.valueOf(s1))).append(" and sportId = ?").toString();
        as[2] = contentvalues.getAsString("sportId");
        as1 = as;
          goto _L8
_L7:
        as = new String[2];
        s1 = s;
          goto _L9
        s = s1;
        as1 = as;
        if (!contentvalues.containsKey("networkId")) goto _L8; else goto _L10
_L10:
        s = s1;
        as1 = as;
        if (Utils.isEmpty(contentvalues.getAsString("networkId"))) goto _L8; else goto _L11
_L11:
        s = (new StringBuilder(String.valueOf(s1))).append(" and networkId = ?").toString();
        as[2] = contentvalues.getAsString("networkId");
        as1 = as;
          goto _L8
_L1:
        if (i != 1 && (i <= 10 || i >= 18) && i != 30) goto _L13; else goto _L12
_L4:
    }

    protected void insertOrUpdateMetaSportTable(ContentValues contentvalues)
    {
        try
        {
            if (!isConnectionOpen())
            {
                openConnection();
            }
            if (db.updateWithOnConflict("metaSport", contentvalues, "sportrelationId= ?", new String[] {
    contentvalues.getAsString("sportrelationId")
}, 1) < 1)
            {
                db.insertWithOnConflict("metaSport", null, contentvalues, 1);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ContentValues contentvalues)
        {
            Utils.sdkLog("Error", 5, contentvalues);
        }
    }

    protected boolean isConnectionOpen()
    {
        while (db == null || !db.isOpen()) 
        {
            return false;
        }
        return true;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        try
        {
            Utils.sdkLog("FeedsDB- onCreate(): Config", 2, null);
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS config(_id integer PRIMARY KEY AUTOINCREMENT,aboutUrl text,affiliateImgUrl text,authPostSignInURL text,baseURL text,termsOfUse text,privacyPolicy text,channelImgUrl text, eventImgUrl text, eventPollingInterval text, eventPollingUrl text, faqURL text, gracePeriod text, playerURL text, sendFeedbackURL text, settingsURL text, setupURL text, TTL text, welcomeURL text, signInURL text, omnitureJson text)");
            Utils.sdkLog("FeedsDB- onCreate(): UserData", 2, null);
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS userdata(_id integer PRIMARY KEY AUTOINCREMENT,udid text,username text,affiliateName text,swid text,omniSwid text,isLoggedIn text,name text, image text, graceTimeLeft text, authenticated text)");
            Utils.sdkLog("FeedsDB- onCreate(): Channel", 2, null);
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS channel(_id integer PRIMARY KEY AUTOINCREMENT,channelName text,ImageSmall text,slateImageSmall text,slateImageMedium text,slateImageLarge text,resourceId text,isActive text,type text,id text,code text)");
            Utils.sdkLog("FeedsDB- onCreate(): MetaChannel", 2, null);
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS metaChannel(_id integer PRIMARY KEY AUTOINCREMENT,TTL text,omnitureJason text)");
            Utils.sdkLog("FeedsDB- onCreate(): Sport", 2, null);
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS sport(_id integer PRIMARY KEY AUTOINCREMENT,soprtId text,sportAbbre text,sportLeagueId text,sportShortName text,sportType text,sportVodUrl text,sportListingUrl text,sportListingtop text,sportName text, text,sportMetaSportRelation text)");
            Utils.sdkLog("FeedsDB- onCreate(): MetaSport", 2, null);
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS metaSport(_id integer PRIMARY KEY AUTOINCREMENT,TTL text,sportrelationId text,omnitureJason text)");
            Utils.sdkLog("FeedsDB- onCreate(): Events", 2, null);
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS events(_id integer PRIMARY KEY AUTOINCREMENT,broadcastStartTime text,blackoutsJason text,SPORT text,sportId text,eventType text,endTime text,league text,leagueName text,networkCode text, networkName text, networkId text, guid text, startTime text, eventId text, showName text, simulcastAiringId text, seekInSeconds text, parentalRating text, omnitureJson text, imageSmall text, imageMed text, imageLarge text, eventName text, videoURLDefault text, videoURLSmall text, videoURLMed text, videoURLLarge text, videoURLHD text, description text, programingCode text, sportCode text, coverageType text, networkResourceId text, metaEventRelationId text)");
            Utils.sdkLog("FeedsDB- onCreate(): Events", 2, null);
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS featuredEvents(_id integer PRIMARY KEY AUTOINCREMENT,broadcastStartTime text,blackoutsJason text,SPORT text,sportId text,eventType text,endTime text,league text,leagueName text,networkCode text, networkName text, networkId text, guid text, startTime text, eventId text, showName text, simulcastAiringId text, seekInSeconds text, parentalRating text, omnitureJson text, imageSmall text, imageMed text, imageLarge text, eventName text, videoURLDefault text, videoURLSmall text, videoURLMed text, videoURLLarge text, videoURLHD text, description text, programingCode text, coverageType text, networkResourceId text, sportCode text, metaEventRelationId text)");
            Utils.sdkLog("FeedsDB- onCreate(): MetaEvents", 2, null);
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS metaEvents(_id integer PRIMARY KEY AUTOINCREMENT,count text,omnitureJson text,eventsType text,ttl text,sportId text,networkId text,eventRelationId text)");
            Utils.sdkLog("FeedsDB- onCreate(): FeaturedCategoryEvents", 2, null);
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS featuredCategories(_id integer PRIMARY KEY AUTOINCREMENT,categoryId text,name text,abbre text,shortName text,type text,imageUrl text,vodUrl text,listingUrl text )");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            Utils.sdkLog("FeedsDB- onCreate():", 5, sqlitedatabase);
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (i != 1 || j != 9)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        upgradeV1toV2(sqlitedatabase);
        upgradeV2toV3(sqlitedatabase);
        upgradeV3toV4(sqlitedatabase);
        upgradeV4toV5(sqlitedatabase);
        upgradeV5toV6(sqlitedatabase);
        upgradeV6toV7(sqlitedatabase);
        upgradeV7toV8(sqlitedatabase);
        upgradeV8toV9(sqlitedatabase);
_L1:
        return;
        sqlitedatabase;
        Utils.sdkLog("FeedsDB- onUpgrade():", 5, sqlitedatabase);
        return;
        if (i == 2 && j == 9)
        {
            try
            {
                upgradeV2toV3(sqlitedatabase);
                upgradeV3toV4(sqlitedatabase);
                upgradeV4toV5(sqlitedatabase);
                upgradeV5toV6(sqlitedatabase);
                upgradeV6toV7(sqlitedatabase);
                upgradeV7toV8(sqlitedatabase);
                upgradeV8toV9(sqlitedatabase);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                Utils.sdkLog("FeedsDB- onUpgrade():", 5, sqlitedatabase);
            }
            return;
        }
        if (i == 3 && j == 9)
        {
            try
            {
                upgradeV3toV4(sqlitedatabase);
                upgradeV4toV5(sqlitedatabase);
                upgradeV5toV6(sqlitedatabase);
                upgradeV6toV7(sqlitedatabase);
                upgradeV7toV8(sqlitedatabase);
                upgradeV8toV9(sqlitedatabase);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                Utils.sdkLog("FeedsDB- onUpgrade():", 5, sqlitedatabase);
            }
            return;
        }
        if (i == 4 && j == 9)
        {
            try
            {
                upgradeV4toV5(sqlitedatabase);
                upgradeV5toV6(sqlitedatabase);
                upgradeV6toV7(sqlitedatabase);
                upgradeV7toV8(sqlitedatabase);
                upgradeV8toV9(sqlitedatabase);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                Utils.sdkLog("FeedsDB- onUpgrade():", 5, sqlitedatabase);
            }
            return;
        }
        if (i == 5 && j == 9)
        {
            try
            {
                upgradeV5toV6(sqlitedatabase);
                upgradeV6toV7(sqlitedatabase);
                upgradeV7toV8(sqlitedatabase);
                upgradeV8toV9(sqlitedatabase);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                Utils.sdkLog("FeedsDB- onUpgrade():", 5, sqlitedatabase);
            }
            return;
        }
        if (i == 6 && j == 9)
        {
            try
            {
                upgradeV6toV7(sqlitedatabase);
                upgradeV7toV8(sqlitedatabase);
                upgradeV8toV9(sqlitedatabase);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                Utils.sdkLog("FeedsDB- onUpgrade():", 5, sqlitedatabase);
            }
            return;
        }
        if (i == 7 && j == 9)
        {
            try
            {
                upgradeV7toV8(sqlitedatabase);
                upgradeV8toV9(sqlitedatabase);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                Utils.sdkLog("FeedsDB- onUpgrade():", 5, sqlitedatabase);
            }
            return;
        }
        if (i == 8 && j == 9)
        {
            try
            {
                upgradeV8toV9(sqlitedatabase);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                Utils.sdkLog("FeedsDB- onUpgrade():", 5, sqlitedatabase);
            }
            return;
        }
          goto _L1
    }

    protected void openConnection()
    {
        db = getWritableDatabase();
    }

    public void releaseMemory()
    {
        if (isConnectionOpen())
        {
            SQLiteDatabase.releaseMemory();
        }
    }

    protected void tempUpdateExpTimeForEvents(String s, String s1, String as[], ContentValues contentvalues)
    {
        ContentValues contentvalues1;
        contentvalues1 = contentvalues;
        if (contentvalues != null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        contentvalues1 = new ContentValues();
        contentvalues1.put("ttl", Utils.getExpiryTime(60));
        if (!isConnectionOpen())
        {
            openConnection();
        }
        if (db.updateWithOnConflict(s, contentvalues1, s1, as, 1) < 1)
        {
            contentvalues1.put("eventRelationId", as[0]);
            db.insertWithOnConflict(s, null, contentvalues1, 1);
        }
        return;
        s;
        Utils.sdkLog("Error", 5, s);
        return;
    }

    protected transient void tempUpdateExpTimeForMisc(String s, String s1, String as[], String as1[])
    {
        try
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put(as1[0], Utils.getExpiryTime(60));
            if (as1.length > 1)
            {
                contentvalues.put(as1[1], as[0]);
            }
            if (!isConnectionOpen())
            {
                openConnection();
            }
            if (db.updateWithOnConflict(s, contentvalues, s1, as, 1) < 1)
            {
                db.insertWithOnConflict(s, null, contentvalues, 1);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error", 5, s);
        }
    }

    void upgradeV1toV2(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("ALTER TABLE events Add programingCode text");
        sqlitedatabase.execSQL("ALTER TABLE events Add sportCode text");
        sqlitedatabase.execSQL("ALTER TABLE featuredEvents Add programingCode text");
        sqlitedatabase.execSQL("ALTER TABLE featuredEvents Add sportCode text");
    }

    void upgradeV2toV3(SQLiteDatabase sqlitedatabase)
    {
        Utils.sdkLog("FeedsDB- onUpgrade(): FeaturedCategoryEvents", 2, null);
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS featuredCategories(_id integer PRIMARY KEY AUTOINCREMENT,categoryId text,name text,abbre text,shortName text,type text,imageUrl text,vodUrl text,listingUrl text )");
    }

    void upgradeV3toV4(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("ALTER TABLE sport Add sportLeagueId text");
        sqlitedatabase.execSQL("ALTER TABLE sport Add sportListingUrl text");
        sqlitedatabase.execSQL("ALTER TABLE sport Add sportShortName text");
        sqlitedatabase.execSQL("ALTER TABLE sport Add sportType text");
        sqlitedatabase.execSQL("ALTER TABLE sport Add sportVodUrl text");
        sqlitedatabase.execSQL("ALTER TABLE sport Add sportMetaSportRelation text");
        sqlitedatabase.execSQL("ALTER TABLE metaSport Add sportrelationId text");
    }

    void upgradeV4toV5(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("ALTER TABLE events Add coverageType text");
        sqlitedatabase.execSQL("ALTER TABLE featuredEvents Add coverageType text");
    }

    void upgradeV5toV6(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("ALTER TABLE sport Add sportListingtop text");
    }

    void upgradeV6toV7(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("ALTER TABLE events Add videoURLHD text");
        sqlitedatabase.execSQL("ALTER TABLE featuredEvents Add videoURLHD text");
    }

    void upgradeV7toV8(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("ALTER TABLE events Add videoURLDefault text");
        sqlitedatabase.execSQL("ALTER TABLE featuredEvents Add videoURLDefault text");
    }

    void upgradeV8toV9(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("ALTER TABLE channel Add resourceId text");
        sqlitedatabase.execSQL("ALTER TABLE events Add networkResourceId text");
        sqlitedatabase.execSQL("ALTER TABLE featuredEvents Add networkResourceId text");
    }
}
