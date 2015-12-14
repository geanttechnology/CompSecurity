// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

// Referenced classes of package com.aviary.android.feather.cds:
//            MessageContentColumn

public static final class messageId extends messageId
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

    public static messageId create(Cursor cursor)
    {
        boolean flag1 = true;
        if (messageId(cursor))
        {
            messageId messageid = new <init>(cursor.getLong(cursor.getColumnIndex("msgcnt_id")), cursor.getLong(cursor.getColumnIndex("msgcnt_messageId")));
            int i = cursor.getColumnIndex("msgcnt_contentIdentifier");
            if (i > -1)
            {
                messageid.contentIdentifier = cursor.getString(i);
            }
            i = cursor.getColumnIndex("msgcnt_beginDate");
            if (i > -1)
            {
                messageid.beginDate = cursor.getString(i);
            }
            i = cursor.getColumnIndex("msgcnt_endDate");
            if (i > -1)
            {
                messageid.endDate = cursor.getString(i);
            }
            i = cursor.getColumnIndex("msgcnt_title");
            if (i > -1)
            {
                messageid.title = cursor.getString(i);
            }
            i = cursor.getColumnIndex("msgcnt_paragraph");
            if (i > -1)
            {
                messageid.paragraph = cursor.getString(i);
            }
            i = cursor.getColumnIndex("msgcnt_dismissButton");
            if (i > -1)
            {
                messageid.dismissButtonText = cursor.getString(i);
            }
            i = cursor.getColumnIndex("msgcnt_actionButton");
            if (i > -1)
            {
                messageid.actionButtonText = cursor.getString(i);
            }
            i = cursor.getColumnIndex("msgcnt_contentURL");
            if (i > -1)
            {
                messageid.contentURL = cursor.getString(i);
            }
            i = cursor.getColumnIndex("msgcnt_layoutStyle");
            if (i > -1)
            {
                messageid.layoutStyle = cursor.getString(i);
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
                messageid.showNewBanner = flag;
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
                messageid.visited = flag;
            }
            i = cursor.getColumnIndex("msgcnt_contentPath");
            if (i > -1)
            {
                messageid.contentPath = cursor.getString(i);
            }
            return messageid;
        } else
        {
            return null;
        }
    }

    public Object clone()
    {
        contentPath contentpath = new <init>(id, messageId);
        contentpath.contentIdentifier = contentIdentifier;
        contentpath.beginDate = beginDate;
        contentpath.endDate = endDate;
        contentpath.title = title;
        contentpath.paragraph = paragraph;
        contentpath.dismissButtonText = dismissButtonText;
        contentpath.actionButtonText = actionButtonText;
        contentpath.contentURL = contentURL;
        contentpath.layoutStyle = layoutStyle;
        contentpath.showNewBanner = showNewBanner;
        contentpath.contentPath = contentPath;
        contentpath.visited = visited;
        return contentpath;
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

    public (long l, long l1)
    {
        super(l);
        messageId = l1;
    }
}
