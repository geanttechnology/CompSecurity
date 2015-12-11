// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j.internal.json;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import twitter4j.DirectMessage;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.UserMentionEntity;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

// Referenced classes of package twitter4j.internal.json:
//            TwitterResponseImpl, DataObjectFactoryUtil, ResponseListImpl, z_T4JInternalParseUtil, 
//            UserJSONImpl, UserMentionEntityJSONImpl, URLEntityJSONImpl, HashtagEntityJSONImpl, 
//            MediaEntityJSONImpl, HTMLEntity

final class DirectMessageJSONImpl extends TwitterResponseImpl
    implements DirectMessage, Serializable
{

    private static final long serialVersionUID = 0x9d68b11f622cb5f7L;
    private Date createdAt;
    private HashtagEntity hashtagEntities[];
    private long id;
    private MediaEntity mediaEntities[];
    private User recipient;
    private long recipientId;
    private String recipientScreenName;
    private User sender;
    private long senderId;
    private String senderScreenName;
    private String text;
    private URLEntity urlEntities[];
    private UserMentionEntity userMentionEntities[];

    DirectMessageJSONImpl(HttpResponse httpresponse, Configuration configuration)
        throws TwitterException
    {
        super(httpresponse);
        httpresponse = httpresponse.asJSONObject();
        init(httpresponse);
        if (configuration.isJSONStoreEnabled())
        {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, httpresponse);
        }
    }

    DirectMessageJSONImpl(JSONObject jsonobject)
        throws TwitterException
    {
        init(jsonobject);
    }

    static ResponseList createDirectMessageList(HttpResponse httpresponse, Configuration configuration)
        throws TwitterException
    {
        int i;
        JSONArray jsonarray;
        JSONObject jsonobject;
        DirectMessageJSONImpl directmessagejsonimpl;
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
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            throw httpresponse;
        }
        i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        jsonobject = jsonarray.getJSONObject(i);
        directmessagejsonimpl = new DirectMessageJSONImpl(jsonobject);
        httpresponse.add(directmessagejsonimpl);
        if (configuration.isJSONStoreEnabled())
        {
            DataObjectFactoryUtil.registerJSONObject(directmessagejsonimpl, jsonobject);
        }
        break MISSING_BLOCK_LABEL_119;
        if (configuration.isJSONStoreEnabled())
        {
            DataObjectFactoryUtil.registerJSONObject(httpresponse, jsonarray);
        }
        return httpresponse;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void init(JSONObject jsonobject)
        throws TwitterException
    {
        id = z_T4JInternalParseUtil.getLong("id", jsonobject);
        senderId = z_T4JInternalParseUtil.getLong("sender_id", jsonobject);
        recipientId = z_T4JInternalParseUtil.getLong("recipient_id", jsonobject);
        createdAt = z_T4JInternalParseUtil.getDate("created_at", jsonobject);
        senderScreenName = z_T4JInternalParseUtil.getUnescapedString("sender_screen_name", jsonobject);
        recipientScreenName = z_T4JInternalParseUtil.getUnescapedString("recipient_screen_name", jsonobject);
        sender = new UserJSONImpl(jsonobject.getJSONObject("sender"));
        recipient = new UserJSONImpl(jsonobject.getJSONObject("recipient"));
        if (jsonobject.isNull("entities")) goto _L2; else goto _L1
_L1:
        Object obj = jsonobject.getJSONObject("entities");
        if (((JSONObject) (obj)).isNull("user_mentions")) goto _L4; else goto _L3
_L3:
        JSONArray jsonarray;
        int j;
        jsonarray = ((JSONObject) (obj)).getJSONArray("user_mentions");
        j = jsonarray.length();
        userMentionEntities = new UserMentionEntity[j];
        int i = 0;
        while (i < j) 
        {
            Object aobj[];
            int k;
            try
            {
                userMentionEntities[i] = new UserMentionEntityJSONImpl(jsonarray.getJSONObject(i));
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                throw new TwitterException(jsonobject);
            }
            i++;
        }
_L4:
        if (((JSONObject) (obj)).isNull("urls")) goto _L6; else goto _L5
_L5:
        jsonarray = ((JSONObject) (obj)).getJSONArray("urls");
        k = jsonarray.length();
        urlEntities = new URLEntity[k];
        i = 0;
_L7:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        urlEntities[i] = new URLEntityJSONImpl(jsonarray.getJSONObject(i));
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        if (((JSONObject) (obj)).isNull("hashtags")) goto _L9; else goto _L8
_L8:
        jsonarray = ((JSONObject) (obj)).getJSONArray("hashtags");
        k = jsonarray.length();
        hashtagEntities = new HashtagEntity[k];
        i = 0;
_L10:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        hashtagEntities[i] = new HashtagEntityJSONImpl(jsonarray.getJSONObject(i));
        i++;
        if (true) goto _L10; else goto _L9
_L9:
        if (((JSONObject) (obj)).isNull("media")) goto _L2; else goto _L11
_L11:
        obj = ((JSONObject) (obj)).getJSONArray("media");
        k = ((JSONArray) (obj)).length();
        mediaEntities = new MediaEntity[k];
        i = 0;
_L12:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        mediaEntities[i] = new MediaEntityJSONImpl(((JSONArray) (obj)).getJSONObject(i));
        i++;
        if (true) goto _L12; else goto _L2
_L2:
        if (userMentionEntities != null) goto _L14; else goto _L13
_L13:
        aobj = new UserMentionEntity[0];
_L19:
        userMentionEntities = ((UserMentionEntity []) (aobj));
        if (urlEntities != null) goto _L16; else goto _L15
_L15:
        aobj = new URLEntity[0];
_L20:
        urlEntities = ((URLEntity []) (aobj));
        if (hashtagEntities != null) goto _L18; else goto _L17
_L17:
        aobj = new HashtagEntity[0];
_L21:
        hashtagEntities = ((HashtagEntity []) (aobj));
        if (mediaEntities != null)
        {
            break MISSING_BLOCK_LABEL_512;
        }
        aobj = new MediaEntity[0];
_L22:
        mediaEntities = ((MediaEntity []) (aobj));
        text = HTMLEntity.unescapeAndSlideEntityIncdices(jsonobject.getString("text"), userMentionEntities, urlEntities, hashtagEntities, mediaEntities);
        return;
_L14:
        aobj = userMentionEntities;
          goto _L19
_L16:
        aobj = urlEntities;
          goto _L20
_L18:
        aobj = hashtagEntities;
          goto _L21
        aobj = mediaEntities;
          goto _L22
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
        if (!(obj instanceof DirectMessage))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((DirectMessage)obj).getId() == id) goto _L4; else goto _L5
_L5:
        return false;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public HashtagEntity[] getHashtagEntities()
    {
        return hashtagEntities;
    }

    public long getId()
    {
        return id;
    }

    public MediaEntity[] getMediaEntities()
    {
        return mediaEntities;
    }

    public User getRecipient()
    {
        return recipient;
    }

    public long getRecipientId()
    {
        return recipientId;
    }

    public String getRecipientScreenName()
    {
        return recipientScreenName;
    }

    public User getSender()
    {
        return sender;
    }

    public long getSenderId()
    {
        return senderId;
    }

    public String getSenderScreenName()
    {
        return senderScreenName;
    }

    public String getText()
    {
        return text;
    }

    public URLEntity[] getURLEntities()
    {
        return urlEntities;
    }

    public UserMentionEntity[] getUserMentionEntities()
    {
        return userMentionEntities;
    }

    public int hashCode()
    {
        return (int)id;
    }

    public String toString()
    {
        Object obj = null;
        StringBuilder stringbuilder = (new StringBuilder()).append("DirectMessageJSONImpl{id=").append(id).append(", text='").append(text).append('\'').append(", sender_id=").append(senderId).append(", recipient_id=").append(recipientId).append(", created_at=").append(createdAt).append(", userMentionEntities=");
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
        stringbuilder = stringbuilder.append(list).append(", sender_screen_name='").append(senderScreenName).append('\'').append(", recipient_screen_name='").append(recipientScreenName).append('\'').append(", sender=").append(sender).append(", recipient=").append(recipient).append(", userMentionEntities=");
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
            list = obj;
        } else
        {
            list = Arrays.asList(hashtagEntities);
        }
        return stringbuilder.append(list).append('}').toString();
    }
}
