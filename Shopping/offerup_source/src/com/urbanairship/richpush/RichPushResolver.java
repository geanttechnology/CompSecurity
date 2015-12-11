// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.richpush;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.urbanairship.Logger;
import com.urbanairship.UrbanAirshipProvider;
import com.urbanairship.UrbanAirshipResolver;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.urbanairship.richpush:
//            RichPushMessage

class RichPushResolver extends UrbanAirshipResolver
{

    private static final String FALSE_VALUE = "0";
    private static final String TRUE_VALUE = "1";
    private static final String WHERE_CLAUSE_CHANGED = "unread <> unread_orig";
    private static final String WHERE_CLAUSE_MESSAGE_ID = "message_id = ?";
    private static final String WHERE_CLAUSE_READ = "unread = ?";

    RichPushResolver(Context context)
    {
        super(context);
    }

    private Set getMessageIdsFromCursor(Cursor cursor)
    {
        if (cursor == null)
        {
            return new HashSet();
        }
        HashSet hashset = new HashSet(cursor.getCount());
        int j;
        for (int i = -1; cursor.moveToNext(); i = j)
        {
            j = i;
            if (i == -1)
            {
                j = cursor.getColumnIndex("message_id");
            }
            hashset.add(cursor.getString(j));
        }

        cursor.close();
        return hashset;
    }

    private ContentValues parseMessageContentValues(JsonValue jsonvalue)
    {
        Object obj = null;
        if (jsonvalue == null || !jsonvalue.isJsonMap())
        {
            Logger.error((new StringBuilder("RichPushResolver - Unexpected message: ")).append(jsonvalue).toString());
            jsonvalue = obj;
        } else
        {
            JsonMap jsonmap = jsonvalue.getMap();
            if (UAStringUtil.isEmpty(jsonmap.opt("message_id").getString()))
            {
                Logger.error((new StringBuilder("RichPushResolver - Message is missing an ID: ")).append(jsonvalue).toString());
                return null;
            }
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("timestamp", jsonmap.opt("message_sent").getString());
            contentvalues.put("message_id", jsonmap.opt("message_id").getString());
            contentvalues.put("message_url", jsonmap.opt("message_url").getString());
            contentvalues.put("message_body_url", jsonmap.opt("message_body_url").getString());
            contentvalues.put("message_read_url", jsonmap.opt("message_read_url").getString());
            contentvalues.put("title", jsonmap.opt("title").getString());
            contentvalues.put("unread_orig", Boolean.valueOf(jsonmap.opt("unread").getBoolean(true)));
            contentvalues.put("extra", jsonmap.opt("extra").toString());
            contentvalues.put("raw_message_object", jsonmap.toString());
            jsonvalue = contentvalues;
            if (jsonmap.containsKey("message_expiry"))
            {
                contentvalues.put("expiration_timestamp", jsonmap.opt("message_expiry").getString());
                return contentvalues;
            }
        }
        return jsonvalue;
    }

    private int updateMessages(Set set, ContentValues contentvalues)
    {
        return update(Uri.withAppendedPath(UrbanAirshipProvider.getRichPushContentUri(), UAStringUtil.join(set, "|")), contentvalues, (new StringBuilder("message_id IN ( ")).append(UAStringUtil.repeat("?", set.size(), ", ")).append(" )").toString(), (String[])set.toArray(new String[set.size()]));
    }

    int deleteMessages(Set set)
    {
        return delete(Uri.withAppendedPath(UrbanAirshipProvider.getRichPushContentUri(), UAStringUtil.join(set, "|")), (new StringBuilder("message_id IN ( ")).append(UAStringUtil.repeat("?", set.size(), ", ")).append(" )").toString(), (String[])set.toArray(new String[set.size()]));
    }

    Set getDeletedMessageIds()
    {
        return getMessageIdsFromCursor(query(UrbanAirshipProvider.getRichPushContentUri(), null, "deleted = ?", new String[] {
            "1"
        }, null));
    }

    Set getMessageIds()
    {
        return getMessageIdsFromCursor(query(UrbanAirshipProvider.getRichPushContentUri(), null, null, null, null));
    }

    List getMessages()
    {
        ArrayList arraylist;
        Cursor cursor;
        arraylist = new ArrayList();
        cursor = query(UrbanAirshipProvider.getRichPushContentUri(), null, null, null, null);
        if (cursor == null)
        {
            return arraylist;
        }
_L2:
        if (!cursor.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = cursor.getString(cursor.getColumnIndex("raw_message_object"));
        boolean flag;
        boolean flag1;
        if (cursor.getInt(cursor.getColumnIndex("unread")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (cursor.getInt(cursor.getColumnIndex("deleted")) == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj = RichPushMessage.create(JsonValue.parseString(((String) (obj))), flag, flag1);
        if (obj != null)
        {
            try
            {
                arraylist.add(obj);
            }
            catch (JsonException jsonexception)
            {
                Logger.error("RichPushResolver - Failed to parse message from the database.", jsonexception);
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        cursor.close();
        return arraylist;
    }

    Set getReadUpdatedMessageIds()
    {
        return getMessageIdsFromCursor(query(UrbanAirshipProvider.getRichPushContentUri(), null, "unread = ? AND unread <> unread_orig", new String[] {
            "0"
        }, null));
    }

    int insertMessages(List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            ContentValues contentvalues = parseMessageContentValues((JsonValue)list.next());
            contentvalues.put("unread", contentvalues.getAsBoolean("unread_orig"));
            if (contentvalues != null)
            {
                arraylist.add(contentvalues);
            }
        } while (true);
        if (arraylist.isEmpty())
        {
            return -1;
        } else
        {
            return bulkInsert(UrbanAirshipProvider.getRichPushContentUri(), (ContentValues[])arraylist.toArray(new ContentValues[arraylist.size()]));
        }
    }

    int markMessagesDeleted(Set set)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("deleted", Boolean.valueOf(true));
        return updateMessages(set, contentvalues);
    }

    int markMessagesRead(Set set)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("unread", Boolean.valueOf(false));
        return updateMessages(set, contentvalues);
    }

    int markMessagesReadOrigin(Set set)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("unread_orig", Boolean.valueOf(false));
        return updateMessages(set, contentvalues);
    }

    int markMessagesUnread(Set set)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("unread", Boolean.valueOf(true));
        return updateMessages(set, contentvalues);
    }

    int updateMessage(String s, JsonValue jsonvalue)
    {
        jsonvalue = parseMessageContentValues(jsonvalue);
        if (jsonvalue == null)
        {
            return -1;
        } else
        {
            return update(Uri.withAppendedPath(UrbanAirshipProvider.getRichPushContentUri(), s), jsonvalue, "message_id = ?", new String[] {
                s
            });
        }
    }
}
