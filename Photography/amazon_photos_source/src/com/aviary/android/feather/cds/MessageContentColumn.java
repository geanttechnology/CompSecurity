// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

public final class MessageContentColumn
{
    public static final class MessageContentCursorWrapper extends VersionColumns.BaseCursorWrapper
    {

        private String actionButtonText;
        private String beginDate;
        private String contentIdentifier;
        private String contentPath;
        private String contentURL;
        private String dismissButtonText;
        private String endDate;
        private String layoutStyle;
        private long messageId;
        private String paragraph;
        private boolean showNewBanner;
        private String title;
        private boolean visited;

        public static MessageContentCursorWrapper create(Cursor cursor)
        {
            boolean flag1 = true;
            if (VersionColumns.VersionCursorWrapper.isValid(cursor))
            {
                MessageContentCursorWrapper messagecontentcursorwrapper = new MessageContentCursorWrapper(cursor.getLong(cursor.getColumnIndex("msgcnt_id")), cursor.getLong(cursor.getColumnIndex("msgcnt_messageId")));
                int i = cursor.getColumnIndex("msgcnt_contentIdentifier");
                if (i > -1)
                {
                    messagecontentcursorwrapper.contentIdentifier = cursor.getString(i);
                }
                i = cursor.getColumnIndex("msgcnt_beginDate");
                if (i > -1)
                {
                    messagecontentcursorwrapper.beginDate = cursor.getString(i);
                }
                i = cursor.getColumnIndex("msgcnt_endDate");
                if (i > -1)
                {
                    messagecontentcursorwrapper.endDate = cursor.getString(i);
                }
                i = cursor.getColumnIndex("msgcnt_title");
                if (i > -1)
                {
                    messagecontentcursorwrapper.title = cursor.getString(i);
                }
                i = cursor.getColumnIndex("msgcnt_paragraph");
                if (i > -1)
                {
                    messagecontentcursorwrapper.paragraph = cursor.getString(i);
                }
                i = cursor.getColumnIndex("msgcnt_dismissButton");
                if (i > -1)
                {
                    messagecontentcursorwrapper.dismissButtonText = cursor.getString(i);
                }
                i = cursor.getColumnIndex("msgcnt_actionButton");
                if (i > -1)
                {
                    messagecontentcursorwrapper.actionButtonText = cursor.getString(i);
                }
                i = cursor.getColumnIndex("msgcnt_contentURL");
                if (i > -1)
                {
                    messagecontentcursorwrapper.contentURL = cursor.getString(i);
                }
                i = cursor.getColumnIndex("msgcnt_layoutStyle");
                if (i > -1)
                {
                    messagecontentcursorwrapper.layoutStyle = cursor.getString(i);
                }
                i = cursor.getColumnIndex("msgcnt_showNewBanner");
                boolean flag;
                if (i > -1)
                {
                    if (cursor.getInt(i) == 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    messagecontentcursorwrapper.showNewBanner = flag;
                }
                i = cursor.getColumnIndex("msgcnt_visited");
                if (i > -1)
                {
                    if (cursor.getInt(i) == 1)
                    {
                        flag = flag1;
                    } else
                    {
                        flag = false;
                    }
                    messagecontentcursorwrapper.visited = flag;
                }
                i = cursor.getColumnIndex("msgcnt_contentPath");
                if (i > -1)
                {
                    messagecontentcursorwrapper.contentPath = cursor.getString(i);
                }
                return messagecontentcursorwrapper;
            } else
            {
                return null;
            }
        }

        public Object clone()
        {
            MessageContentCursorWrapper messagecontentcursorwrapper = new MessageContentCursorWrapper(id, messageId);
            messagecontentcursorwrapper.contentIdentifier = contentIdentifier;
            messagecontentcursorwrapper.beginDate = beginDate;
            messagecontentcursorwrapper.endDate = endDate;
            messagecontentcursorwrapper.title = title;
            messagecontentcursorwrapper.paragraph = paragraph;
            messagecontentcursorwrapper.dismissButtonText = dismissButtonText;
            messagecontentcursorwrapper.actionButtonText = actionButtonText;
            messagecontentcursorwrapper.contentURL = contentURL;
            messagecontentcursorwrapper.layoutStyle = layoutStyle;
            messagecontentcursorwrapper.showNewBanner = showNewBanner;
            messagecontentcursorwrapper.contentPath = contentPath;
            messagecontentcursorwrapper.visited = visited;
            return messagecontentcursorwrapper;
        }

        public String getActionButtonText()
        {
            return actionButtonText;
        }

        public String getBeginDate()
        {
            return beginDate;
        }

        public String getContentIdentifier()
        {
            return contentIdentifier;
        }

        public String getContentPath()
        {
            return contentPath;
        }

        public String getContentURL()
        {
            return contentURL;
        }

        public String getDismissButtonText()
        {
            return dismissButtonText;
        }

        public String getEndDate()
        {
            return endDate;
        }

        public String getLayoutStyle()
        {
            return layoutStyle;
        }

        public long getMessageId()
        {
            return messageId;
        }

        public String getParagraph()
        {
            return paragraph;
        }

        public String getTitle()
        {
            return title;
        }

        public boolean isShowNewBanner()
        {
            return showNewBanner;
        }

        public boolean isVisited()
        {
            return visited;
        }

        public MessageContentCursorWrapper(long l, long l1)
        {
            super(l);
            messageId = l1;
        }
    }


    public static final String ACTION_BUTTON = "msgcnt_actionButton";
    public static final String BEGIN_DATE = "msgcnt_beginDate";
    public static final String CONTENT_IDENTIFIER = "msgcnt_contentIdentifier";
    public static final String CONTENT_PATH = "msgcnt_contentPath";
    public static final String CONTENT_URL = "msgcnt_contentURL";
    public static final String DISMISS_BUTTON = "msgcnt_dismissButton";
    public static final String END_DATE = "msgcnt_endDate";
    public static final String LAYOUT_STYLE = "msgcnt_layoutStyle";
    public static final String MESSAGE_ID = "msgcnt_messageId";
    public static final String PARAGRAPH = "msgcnt_paragraph";
    public static final String SHOW_NEW_BANNER = "msgcnt_showNewBanner";
    public static final String TABLE_NAME = "messages_content_table";
    public static final String TITLE = "msgcnt_title";
    public static final String VISITED = "msgcnt_visited";
    public static final String _ID = "msgcnt_id";

    private MessageContentColumn()
    {
    }
}
