// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

final class MessageColumns
{
    public static final class MessageCursorWrapper extends VersionColumns.BaseCursorWrapper
    {

        String identifier;
        String messageType;
        String versionKey;

        public static MessageCursorWrapper create(Cursor cursor)
        {
            if (VersionColumns.BaseCursorWrapper.isValid(cursor))
            {
                MessageCursorWrapper messagecursorwrapper = new MessageCursorWrapper(cursor.getLong(cursor.getColumnIndex("msg_id")));
                int i = cursor.getColumnIndex("msg_type");
                if (i > -1)
                {
                    messagecursorwrapper.messageType = cursor.getString(i);
                }
                i = cursor.getColumnIndex("msg_versionKey");
                if (i > -1)
                {
                    messagecursorwrapper.versionKey = cursor.getString(i);
                }
                i = cursor.getColumnIndex("msg_identifier");
                if (i > -1)
                {
                    messagecursorwrapper.identifier = cursor.getString(i);
                }
                return messagecursorwrapper;
            } else
            {
                return null;
            }
        }

        public Object clone()
        {
            MessageCursorWrapper messagecursorwrapper = new MessageCursorWrapper(id);
            messagecursorwrapper.messageType = messageType;
            messagecursorwrapper.versionKey = versionKey;
            messagecursorwrapper.identifier = identifier;
            return messagecursorwrapper;
        }

        public String getIdentifier()
        {
            return identifier;
        }

        public String getMessageType()
        {
            return messageType;
        }

        public String getVersionKey()
        {
            return versionKey;
        }

        public MessageCursorWrapper(long l)
        {
            super(l);
        }
    }


    public static final String IDENTIFIER = "msg_identifier";
    public static final String MESSAGE_TYPE = "msg_type";
    public static final String TABLE_NAME = "messages_table";
    public static final String VERSION_KEY = "msg_versionKey";
    public static final String _ID = "msg_id";

    private MessageColumns()
    {
    }
}
