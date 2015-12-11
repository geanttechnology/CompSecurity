// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j.internal.json;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.Place;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.UserMentionEntity;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.logging.Logger;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

// Referenced classes of package twitter4j.internal.json:
//            TwitterResponseImpl, DataObjectFactoryUtil, ResponseListImpl, z_T4JInternalParseUtil, 
//            UserJSONImpl, z_T4JInternalJSONImplFactory, PlaceJSONImpl, UserMentionEntityJSONImpl, 
//            URLEntityJSONImpl, HashtagEntityJSONImpl, MediaEntityJSONImpl, HTMLEntity

final class StatusJSONImpl extends TwitterResponseImpl
    implements Status, Serializable
{

    private static final Logger logger = Logger.getLogger(twitter4j/internal/json/StatusJSONImpl);
    private static final long serialVersionUID = 0x68c214e4e0c8cc29L;
    private long contributorsIDs[];
    private Date createdAt;
    private long currentUserRetweetId;
    private GeoLocation geoLocation;
    private HashtagEntity hashtagEntities[];
    private long id;
    private String inReplyToScreenName;
    private long inReplyToStatusId;
    private long inReplyToUserId;
    private boolean isFavorited;
    private boolean isPossiblySensitive;
    private boolean isTruncated;
    private MediaEntity mediaEntities[];
    private Place place;
    private long retweetCount;
    private Status retweetedStatus;
    private String source;
    private String text;
    private URLEntity urlEntities[];
    private User user;
    private UserMentionEntity userMentionEntities[];

    StatusJSONImpl()
    {
        geoLocation = null;
        place = null;
        currentUserRetweetId = -1L;
        user = null;
    }

    StatusJSONImpl(HttpResponse httpresponse, Configuration configuration)
        throws TwitterException
    {
        super(httpresponse);
        geoLocation = null;
        place = null;
        currentUserRetweetId = -1L;
        user = null;
        httpresponse = httpresponse.asJSONObject();
        init(httpresponse);
        if (configuration.isJSONStoreEnabled())
        {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, httpresponse);
        }
    }

    StatusJSONImpl(JSONObject jsonobject)
        throws TwitterException
    {
        geoLocation = null;
        place = null;
        currentUserRetweetId = -1L;
        user = null;
        init(jsonobject);
    }

    StatusJSONImpl(JSONObject jsonobject, Configuration configuration)
        throws TwitterException
    {
        geoLocation = null;
        place = null;
        currentUserRetweetId = -1L;
        user = null;
        init(jsonobject);
        if (configuration.isJSONStoreEnabled())
        {
            DataObjectFactoryUtil.registerJSONObject(this, jsonobject);
        }
    }

    static ResponseList createStatusList(HttpResponse httpresponse, Configuration configuration)
        throws TwitterException
    {
        JSONArray jsonarray;
        JSONObject jsonobject;
        StatusJSONImpl statusjsonimpl;
        int i;
        int j;
        try
        {
            if (configuration.isJSONStoreEnabled())
            {
                DataObjectFactoryUtil.clearThreadLocalMap();
            }
            jsonarray = httpresponse.asJSONArray();
            j = jsonarray.length();
            httpresponse = new ResponseListImpl(j, httpresponse);
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            throw new TwitterException(httpresponse);
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject = jsonarray.getJSONObject(i);
        statusjsonimpl = new StatusJSONImpl(jsonobject);
        if (configuration.isJSONStoreEnabled())
        {
            DataObjectFactoryUtil.registerJSONObject(statusjsonimpl, jsonobject);
        }
        httpresponse.add(statusjsonimpl);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_37;
_L1:
        if (configuration.isJSONStoreEnabled())
        {
            DataObjectFactoryUtil.registerJSONObject(httpresponse, jsonarray);
        }
        return httpresponse;
    }

    private void init(JSONObject jsonobject)
        throws TwitterException
    {
        id = z_T4JInternalParseUtil.getLong("id", jsonobject);
        source = z_T4JInternalParseUtil.getUnescapedString("source", jsonobject);
        createdAt = z_T4JInternalParseUtil.getDate("created_at", jsonobject);
        isTruncated = z_T4JInternalParseUtil.getBoolean("truncated", jsonobject);
        inReplyToStatusId = z_T4JInternalParseUtil.getLong("in_reply_to_status_id", jsonobject);
        inReplyToUserId = z_T4JInternalParseUtil.getLong("in_reply_to_user_id", jsonobject);
        isFavorited = z_T4JInternalParseUtil.getBoolean("favorited", jsonobject);
        inReplyToScreenName = z_T4JInternalParseUtil.getUnescapedString("in_reply_to_screen_name", jsonobject);
        retweetCount = z_T4JInternalParseUtil.getLong("retweet_count", jsonobject);
        isPossiblySensitive = z_T4JInternalParseUtil.getBoolean("possibly_sensitive", jsonobject);
        Object obj;
        if (!jsonobject.isNull("user"))
        {
            user = new UserJSONImpl(jsonobject.getJSONObject("user"));
        }
        geoLocation = z_T4JInternalJSONImplFactory.createGeoLocation(jsonobject);
        if (!jsonobject.isNull("place"))
        {
            place = new PlaceJSONImpl(jsonobject.getJSONObject("place"));
        }
        if (!jsonobject.isNull("retweeted_status"))
        {
            retweetedStatus = new StatusJSONImpl(jsonobject.getJSONObject("retweeted_status"));
        }
        if (jsonobject.isNull("contributors"))
        {
            break MISSING_BLOCK_LABEL_249;
        }
        obj = jsonobject.getJSONArray("contributors");
        contributorsIDs = new long[((JSONArray) (obj)).length()];
        int i = 0;
        do
        {
            Object aobj[];
            JSONArray jsonarray;
            int j;
            try
            {
                if (i >= ((JSONArray) (obj)).length())
                {
                    break;
                }
                contributorsIDs[i] = Long.parseLong(((JSONArray) (obj)).getString(i));
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                throw new TwitterException(jsonobject);
            }
            i++;
        } while (true);
        break MISSING_BLOCK_LABEL_256;
        contributorsIDs = new long[0];
        if (jsonobject.isNull("entities")) goto _L2; else goto _L1
_L1:
        obj = jsonobject.getJSONObject("entities");
        if (((JSONObject) (obj)).isNull("user_mentions")) goto _L4; else goto _L3
_L3:
        jsonarray = ((JSONObject) (obj)).getJSONArray("user_mentions");
        j = jsonarray.length();
        userMentionEntities = new UserMentionEntity[j];
        i = 0;
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        userMentionEntities[i] = new UserMentionEntityJSONImpl(jsonarray.getJSONObject(i));
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        if (((JSONObject) (obj)).isNull("urls")) goto _L7; else goto _L6
_L6:
        jsonarray = ((JSONObject) (obj)).getJSONArray("urls");
        j = jsonarray.length();
        urlEntities = new URLEntity[j];
        i = 0;
_L8:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        urlEntities[i] = new URLEntityJSONImpl(jsonarray.getJSONObject(i));
        i++;
        if (true) goto _L8; else goto _L7
_L7:
        if (((JSONObject) (obj)).isNull("hashtags")) goto _L10; else goto _L9
_L9:
        jsonarray = ((JSONObject) (obj)).getJSONArray("hashtags");
        j = jsonarray.length();
        hashtagEntities = new HashtagEntity[j];
        i = 0;
_L11:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        hashtagEntities[i] = new HashtagEntityJSONImpl(jsonarray.getJSONObject(i));
        i++;
        if (true) goto _L11; else goto _L10
_L10:
        if (((JSONObject) (obj)).isNull("media")) goto _L2; else goto _L12
_L12:
        obj = ((JSONObject) (obj)).getJSONArray("media");
        j = ((JSONArray) (obj)).length();
        mediaEntities = new MediaEntity[j];
        i = 0;
_L13:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        mediaEntities[i] = new MediaEntityJSONImpl(((JSONArray) (obj)).getJSONObject(i));
        i++;
        if (true) goto _L13; else goto _L2
_L2:
        if (userMentionEntities != null) goto _L15; else goto _L14
_L14:
        aobj = new UserMentionEntity[0];
_L27:
        userMentionEntities = ((UserMentionEntity []) (aobj));
        if (urlEntities != null) goto _L17; else goto _L16
_L16:
        aobj = new URLEntity[0];
_L23:
        urlEntities = ((URLEntity []) (aobj));
        if (hashtagEntities != null) goto _L19; else goto _L18
_L18:
        aobj = new HashtagEntity[0];
_L24:
        hashtagEntities = ((HashtagEntity []) (aobj));
        if (mediaEntities != null) goto _L21; else goto _L20
_L20:
        aobj = new MediaEntity[0];
_L25:
        mediaEntities = ((MediaEntity []) (aobj));
        text = HTMLEntity.unescapeAndSlideEntityIncdices(jsonobject.getString("text"), userMentionEntities, urlEntities, hashtagEntities, mediaEntities);
        if (!jsonobject.isNull("current_user_retweet"))
        {
            currentUserRetweetId = jsonobject.getJSONObject("current_user_retweet").getLong("id");
            return;
        }
          goto _L22
_L15:
        aobj = userMentionEntities;
        continue; /* Loop/switch isn't completed */
_L17:
        aobj = urlEntities;
          goto _L23
_L19:
        aobj = hashtagEntities;
          goto _L24
_L21:
        aobj = mediaEntities;
          goto _L25
_L22:
        return;
        if (true) goto _L27; else goto _L26
_L26:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Status)obj);
    }

    public int compareTo(Status status)
    {
        long l = id - status.getId();
        if (l < 0xffffffff80000000L)
        {
            return 0x80000000;
        }
        if (l > 0x7fffffffL)
        {
            return 0x7fffffff;
        } else
        {
            return (int)l;
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = true;
        if (obj != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (this == obj) goto _L4; else goto _L3
_L3:
        if (!(obj instanceof Status))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((Status)obj).getId() == id) goto _L4; else goto _L5
_L5:
        return false;
    }

    public long[] getContributors()
    {
        return contributorsIDs;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public long getCurrentUserRetweetId()
    {
        return currentUserRetweetId;
    }

    public GeoLocation getGeoLocation()
    {
        return geoLocation;
    }

    public HashtagEntity[] getHashtagEntities()
    {
        return hashtagEntities;
    }

    public long getId()
    {
        return id;
    }

    public String getInReplyToScreenName()
    {
        return inReplyToScreenName;
    }

    public long getInReplyToStatusId()
    {
        return inReplyToStatusId;
    }

    public long getInReplyToUserId()
    {
        return inReplyToUserId;
    }

    public MediaEntity[] getMediaEntities()
    {
        return mediaEntities;
    }

    public Place getPlace()
    {
        return place;
    }

    public long getRetweetCount()
    {
        return retweetCount;
    }

    public Status getRetweetedStatus()
    {
        return retweetedStatus;
    }

    public String getSource()
    {
        return source;
    }

    public String getText()
    {
        return text;
    }

    public URLEntity[] getURLEntities()
    {
        return urlEntities;
    }

    public User getUser()
    {
        return user;
    }

    public UserMentionEntity[] getUserMentionEntities()
    {
        return userMentionEntities;
    }

    public int hashCode()
    {
        return (int)id;
    }

    public boolean isFavorited()
    {
        return isFavorited;
    }

    public boolean isPossiblySensitive()
    {
        return isPossiblySensitive;
    }

    public boolean isRetweet()
    {
        return retweetedStatus != null;
    }

    public boolean isRetweetedByMe()
    {
        return currentUserRetweetId != -1L;
    }

    public boolean isTruncated()
    {
        return isTruncated;
    }

    public String toString()
    {
        Object obj = null;
        StringBuilder stringbuilder = (new StringBuilder()).append("StatusJSONImpl{createdAt=").append(createdAt).append(", id=").append(id).append(", text='").append(text).append('\'').append(", source='").append(source).append('\'').append(", isTruncated=").append(isTruncated).append(", inReplyToStatusId=").append(inReplyToStatusId).append(", inReplyToUserId=").append(inReplyToUserId).append(", isFavorited=").append(isFavorited).append(", inReplyToScreenName='").append(inReplyToScreenName).append('\'').append(", geoLocation=").append(geoLocation).append(", place=").append(place).append(", retweetCount=").append(retweetCount).append(", isPossiblySensitive=").append(isPossiblySensitive).append(", contributorsIDs=").append(contributorsIDs).append(", retweetedStatus=").append(retweetedStatus).append(", userMentionEntities=");
        java.util.List list;
        if (userMentionEntities == null)
        {
            list = null;
        } else
        {
            list = Arrays.asList(userMentionEntities);
        }
        stringbuilder = stringbuilder.append(list).append(", urlEntities=");
        if (urlEntities == null)
        {
            list = null;
        } else
        {
            list = Arrays.asList(urlEntities);
        }
        stringbuilder = stringbuilder.append(list).append(", hashtagEntities=");
        if (hashtagEntities == null)
        {
            list = null;
        } else
        {
            list = Arrays.asList(hashtagEntities);
        }
        stringbuilder = stringbuilder.append(list).append(", mediaEntities=");
        if (mediaEntities == null)
        {
            list = obj;
        } else
        {
            list = Arrays.asList(mediaEntities);
        }
        return stringbuilder.append(list).append(", currentUserRetweetId=").append(currentUserRetweetId).append(", user=").append(user).append('}').toString();
    }

}
