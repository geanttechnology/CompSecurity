// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.conversation;

import com.tencent.mm.sdk.storage.MAutoDBItem;
import java.lang.reflect.Field;

public class RConversation extends MAutoDBItem
{

    public static final String COLUMNS[];
    public static final String COL_CHATMODE = "chatmode";
    public static final String COL_CONTENT = "content";
    public static final String COL_CONVERSATION_TIME = "conversationTime";
    public static final String COL_FLAG = "flag";
    public static final String COL_IS_SEND = "isSend";
    public static final String COL_MSGTYPE = "msgType";
    public static final String COL_STATUS = "status";
    public static final String COL_UNREAD_COUNT = "unReadCount";
    public static final int COL_UNREAD_COUNT_INVALID_VALUE = -1;
    public static final String COL_USERNAME = "username";
    public static final int FLAG_NORMAL = 0;
    public static final int HAS_SHOWN_TIPS = 1;
    public static final int INDEX_CONTENT = 5;
    public static final int INDEX_CONVERSATION_TIME = 3;
    public static final int INDEX_FLAG = 7;
    public static final int INDEX_IS_SEND = 2;
    public static final int INDEX_MSGTYPE = 6;
    public static final int INDEX_STATUE = 1;
    public static final int INDEX_UNREAD_COUNT = 0;
    public static final int INDEX_USERNAME = 4;
    public static final long MAX_TIME = 0x7fffffffffffffffL;
    public static final int NOT_SHOWN_TIPS = 0;
    public static final String OLD_BOTTLE_TABLE = "bottleconversation";
    public static final String OLD_TABLE = "conversation";
    public static final int ROOM_MUTE_OFF = 1;
    public static final int ROOM_MUTE_ON = 0;
    protected static Field p[];
    public int field_chatmode;
    public String field_content;
    public long field_conversationTime;
    public String field_customNotify;
    public long field_flag;
    public int field_isSend;
    public String field_msgType;
    public int field_showTips;
    public int field_status;
    public int field_unReadCount;
    public String field_username;

    public RConversation()
    {
    }

    public RConversation(String s)
    {
        field_username = s;
    }

    public static Field[] getFields()
    {
        return p;
    }

    public Field[] fields()
    {
        return p;
    }

    public int getChatmode()
    {
        return field_chatmode;
    }

    public String getContent()
    {
        return field_content;
    }

    public long getConversationTime()
    {
        return field_conversationTime;
    }

    public String getCustomNotify()
    {
        return field_customNotify;
    }

    public long getFlag()
    {
        return field_flag;
    }

    public int getIsSend()
    {
        return field_isSend;
    }

    public String getMsgType()
    {
        return field_msgType;
    }

    public int getShowTips()
    {
        return field_showTips;
    }

    public int getStatus()
    {
        return field_status;
    }

    public int getUnReadCount()
    {
        return field_unReadCount;
    }

    public String getUsername()
    {
        return field_username;
    }

    public void setChatmode(int i)
    {
        field_chatmode = i;
    }

    public void setContent(String s)
    {
        field_content = s;
    }

    public void setConversationTime(long l)
    {
        field_conversationTime = l;
    }

    public void setCustomNotify(String s)
    {
        field_customNotify = s;
    }

    public void setFlag(long l)
    {
        field_flag = l;
    }

    public void setIsSend(int i)
    {
        field_isSend = i;
    }

    public void setMsgType(String s)
    {
        field_msgType = s;
    }

    public void setShowTips(int i)
    {
        field_showTips = i;
    }

    public void setStatus(int i)
    {
        field_status = i;
    }

    public void setUnReadCount(int i)
    {
        field_unReadCount = i;
    }

    public void setUsername(String s)
    {
        field_username = s;
    }

    static 
    {
        Field afield[] = MAutoDBItem.getValidFields(com/tencent/mm/sdk/conversation/RConversation);
        p = afield;
        COLUMNS = MAutoDBItem.getFullColumns(afield);
    }
}
