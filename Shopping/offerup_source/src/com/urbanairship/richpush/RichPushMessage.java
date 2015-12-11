// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.richpush;

import android.os.Bundle;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.DateUtils;
import com.urbanairship.util.UAStringUtil;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.richpush:
//            RichPushManager, RichPushInbox

public class RichPushMessage
    implements Comparable
{

    static final String EXTRA_KEY = "extra";
    static final String MESSAGE_BODY_URL_KEY = "message_body_url";
    static final String MESSAGE_EXPIRY_KEY = "message_expiry";
    static final String MESSAGE_ID_KEY = "message_id";
    static final String MESSAGE_READ_URL_KEY = "message_read_url";
    static final String MESSAGE_SENT_KEY = "message_sent";
    static final String MESSAGE_URL_KEY = "message_url";
    static final String TITLE_KEY = "title";
    static final String UNREAD_KEY = "unread";
    boolean deleted;
    private Long expirationMS;
    private Bundle extras;
    private String messageBodyUrl;
    private String messageId;
    private String messageReadUrl;
    private String messageUrl;
    private JsonValue rawJson;
    private long sentMS;
    private String title;
    boolean unreadClient;
    private boolean unreadOrigin;

    private RichPushMessage()
    {
        deleted = false;
    }

    static RichPushMessage create(JsonValue jsonvalue, boolean flag, boolean flag1)
    {
        JsonMap jsonmap = jsonvalue.getMap();
        if (jsonmap == null)
        {
            return null;
        }
        RichPushMessage richpushmessage = new RichPushMessage();
        richpushmessage.messageId = jsonmap.opt("message_id").getString();
        richpushmessage.messageUrl = jsonmap.opt("message_url").getString();
        richpushmessage.messageBodyUrl = jsonmap.opt("message_body_url").getString();
        richpushmessage.messageReadUrl = jsonmap.opt("message_read_url").getString();
        richpushmessage.title = jsonmap.opt("title").getString();
        richpushmessage.unreadOrigin = jsonmap.opt("unread").getBoolean(true);
        richpushmessage.rawJson = jsonvalue;
        jsonvalue = jsonmap.opt("message_sent").getString();
        if (UAStringUtil.isEmpty(jsonvalue))
        {
            richpushmessage.sentMS = System.currentTimeMillis();
        } else
        {
            richpushmessage.sentMS = DateUtils.parseIso8601(jsonvalue, System.currentTimeMillis());
        }
        jsonvalue = jsonmap.opt("message_expiry").getString();
        if (!UAStringUtil.isEmpty(jsonvalue))
        {
            richpushmessage.expirationMS = Long.valueOf(DateUtils.parseIso8601(jsonvalue, 0x7fffffffffffffffL));
        }
        richpushmessage.extras = new Bundle();
        jsonvalue = jsonmap.opt("extra").getMap();
        if (jsonvalue != null)
        {
            for (jsonvalue = jsonvalue.iterator(); jsonvalue.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)jsonvalue.next();
                if (((JsonValue)entry.getValue()).isString())
                {
                    richpushmessage.extras.putString((String)entry.getKey(), ((JsonValue)entry.getValue()).getString());
                } else
                {
                    richpushmessage.extras.putString((String)entry.getKey(), ((JsonValue)entry.getValue()).toString());
                }
            }

        }
        richpushmessage.deleted = flag1;
        richpushmessage.unreadClient = flag;
        return richpushmessage;
    }

    public int compareTo(RichPushMessage richpushmessage)
    {
        return getMessageId().compareTo(richpushmessage.getMessageId());
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((RichPushMessage)obj);
    }

    public void delete()
    {
        if (!deleted)
        {
            deleted = true;
            HashSet hashset = new HashSet();
            hashset.add(messageId);
            UAirship.shared().getRichPushManager().getRichPushInbox().deleteMessages(hashset);
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = true;
        if (obj != null && (obj instanceof RichPushMessage)) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        obj = (RichPushMessage)obj;
        flag = flag1;
        if (this == obj) goto _L4; else goto _L3
_L3:
        if ((messageId != null ? messageId.equals(((RichPushMessage) (obj)).messageId) : ((RichPushMessage) (obj)).messageId == null) && (messageBodyUrl != null ? messageBodyUrl.equals(((RichPushMessage) (obj)).messageBodyUrl) : ((RichPushMessage) (obj)).messageBodyUrl == null) && (messageReadUrl != null ? messageReadUrl.equals(((RichPushMessage) (obj)).messageReadUrl) : ((RichPushMessage) (obj)).messageReadUrl == null) && (messageUrl != null ? messageUrl.equals(((RichPushMessage) (obj)).messageUrl) : ((RichPushMessage) (obj)).messageUrl == null) && (extras != null ? extras.equals(((RichPushMessage) (obj)).extras) : ((RichPushMessage) (obj)).extras == null) && (unreadClient == ((RichPushMessage) (obj)).unreadClient && unreadOrigin == ((RichPushMessage) (obj)).unreadOrigin && deleted == ((RichPushMessage) (obj)).deleted))
        {
            break MISSING_BLOCK_LABEL_132;
        } else
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (sentMS == ((RichPushMessage) (obj)).sentMS) goto _L4; else goto _L5
_L5:
        return false;
    }

    public Date getExpirationDate()
    {
        if (expirationMS != null)
        {
            return new Date(expirationMS.longValue());
        } else
        {
            return null;
        }
    }

    public Long getExpirationDateMS()
    {
        return expirationMS;
    }

    public Bundle getExtras()
    {
        return extras;
    }

    public String getMessageBodyUrl()
    {
        return messageBodyUrl;
    }

    public String getMessageId()
    {
        return messageId;
    }

    public String getMessageReadUrl()
    {
        return messageReadUrl;
    }

    public String getMessageUrl()
    {
        return messageUrl;
    }

    public JSONObject getRawMessageJSON()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject(rawJson.toString());
        }
        catch (JSONException jsonexception)
        {
            return new JSONObject();
        }
        return jsonobject;
    }

    public JsonValue getRawMessageJson()
    {
        return rawJson;
    }

    public Date getSentDate()
    {
        return new Date(sentMS);
    }

    public long getSentDateMS()
    {
        return sentMS;
    }

    public String getTitle()
    {
        return title;
    }

    public int hashCode()
    {
        int l1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if (messageId == null)
        {
            i = 0;
        } else
        {
            i = messageId.hashCode();
        }
        if (messageBodyUrl == null)
        {
            j = 0;
        } else
        {
            j = messageBodyUrl.hashCode();
        }
        if (messageReadUrl == null)
        {
            k = 0;
        } else
        {
            k = messageReadUrl.hashCode();
        }
        if (messageUrl == null)
        {
            l = 0;
        } else
        {
            l = messageUrl.hashCode();
        }
        if (extras == null)
        {
            i1 = 0;
        } else
        {
            i1 = extras.hashCode();
        }
        if (unreadClient)
        {
            j1 = 0;
        } else
        {
            j1 = 1;
        }
        if (unreadOrigin)
        {
            k1 = 0;
        } else
        {
            k1 = 1;
        }
        if (!deleted)
        {
            l1 = 1;
        }
        return ((k1 + (j1 + (i1 + (l + (k + (j + (i + 629) * 37) * 37) * 37) * 37) * 37) * 37) * 37 + l1) * 37 + Long.valueOf(sentMS).hashCode();
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public boolean isExpired()
    {
        return expirationMS != null && System.currentTimeMillis() >= expirationMS.longValue();
    }

    public boolean isRead()
    {
        return !unreadClient;
    }

    public void markRead()
    {
        if (unreadClient)
        {
            unreadClient = false;
            HashSet hashset = new HashSet();
            hashset.add(messageId);
            UAirship.shared().getRichPushManager().getRichPushInbox().markMessagesRead(hashset);
        }
    }

    public void markUnread()
    {
        if (!unreadClient)
        {
            unreadClient = true;
            HashSet hashset = new HashSet();
            hashset.add(messageId);
            UAirship.shared().getRichPushManager().getRichPushInbox().markMessagesUnread(hashset);
        }
    }
}
