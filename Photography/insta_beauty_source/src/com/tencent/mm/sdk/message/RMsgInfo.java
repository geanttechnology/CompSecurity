// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.message;

import com.tencent.mm.sdk.storage.MAutoDBItem;
import java.lang.reflect.Field;

public class RMsgInfo extends MAutoDBItem
{

    public static final String COLUMNS[];
    public static final String COL_CONTENT = "content";
    public static final String COL_CREATE_TIME = "createTime";
    public static final String COL_ID = "msgId";
    public static final String COL_ID_SVR = "msgSvrId";
    public static final String COL_IMG_PATH = "imgPath";
    public static final String COL_IS_SEND = "isSend";
    public static final String COL_IS_SHOWTIMER = "isShowTimer";
    public static final String COL_LVBUFFER = "lvbuffer";
    public static final String COL_RESERVED = "reserved";
    public static final String COL_STATUS = "status";
    public static final String COL_TALKER = "talker";
    public static final String COL_TYPE = "type";
    protected static Field p[];
    public String commentUrl;
    public String field_content;
    public long field_createTime;
    public String field_imgPath;
    public int field_isSend;
    public int field_isShowTimer;
    public byte field_lvBuffer[];
    public long field_msgId;
    public int field_msgSvrId;
    public String field_reserved;
    public int field_status;
    public String field_talker;
    public int field_type;

    public RMsgInfo()
    {
        field_type = 0;
        field_status = 0;
        field_talker = "";
        field_content = "";
        field_imgPath = "";
        field_reserved = "";
        commentUrl = "";
    }

    public RMsgInfo(long l)
    {
        field_type = 0;
        field_status = 0;
        field_talker = "";
        field_content = "";
        field_imgPath = "";
        field_reserved = "";
        commentUrl = "";
        field_msgId = l;
    }

    public RMsgInfo(String s)
    {
        field_type = 0;
        field_status = 0;
        field_talker = "";
        field_content = "";
        field_imgPath = "";
        field_reserved = "";
        commentUrl = "";
        field_talker = s;
    }

    public Field[] fields()
    {
        return p;
    }

    static 
    {
        Field afield[] = MAutoDBItem.getValidFields(com/tencent/mm/sdk/message/RMsgInfo);
        p = afield;
        COLUMNS = MAutoDBItem.getFullColumns(afield);
    }
}
