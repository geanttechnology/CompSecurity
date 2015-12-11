// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.adapter;

import android.content.Context;
import android.os.Handler;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.exacttarget.etpushsdk.data.Message;
import com.exacttarget.etpushsdk.database.e;
import com.exacttarget.etpushsdk.event.CloudPagesChangedEvent;
import com.exacttarget.etpushsdk.event.CloudPagesChangedEventListener;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.m;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.exacttarget.etpushsdk.adapter:
//            a

public abstract class CloudPageListAdapter extends BaseAdapter
    implements ListAdapter, CloudPagesChangedEventListener
{

    public static final int DISPLAY_ALL = 0;
    public static final int DISPLAY_READ = 2;
    public static final int DISPLAY_UNREAD = 1;
    private static final String TAG = "~!CloudPageListAdapter";
    private List allMessages;
    private Context applicationContext;
    private int display;
    private List readMessages;
    private Handler uiHandler;
    private List unreadMessages;

    public CloudPageListAdapter(Context context)
    {
        allMessages = new ArrayList();
        unreadMessages = new ArrayList();
        readMessages = new ArrayList();
        applicationContext = context;
        uiHandler = new Handler();
        EventBus.getInstance().register(this);
        reloadData();
    }

    private void reloadData()
    {
        allMessages.clear();
        unreadMessages.clear();
        readMessages.clear();
        Date date;
        Object obj;
        obj = e.a("message_type = ? AND content_type = ? AND message_deleted = ?", new String[] {
            String.valueOf(Message.b), String.valueOf(Message.i), "0"
        }, null, null, "start_date DESC ");
        m.a("~!CloudPageListAdapter", (new StringBuilder()).append("CloudPage Messages retrieved: ").append(((List) (obj)).size()).toString());
        allMessages.addAll(((java.util.Collection) (obj)));
        date = new Date();
_L2:
        Message message;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            message = (Message)((Iterator) (obj)).next();
            if (Message.b.equals(message.getMessageType()) && Message.i.equals(message.getContentType()) && (message.getEndDate() == null || message.getEndDate().after(date)))
            {
                if (!message.getRead().booleanValue())
                {
                    break MISSING_BLOCK_LABEL_248;
                }
                m.a("~!CloudPageListAdapter", (new StringBuilder()).append("Adding read CloudPage message: ").append(message.getSubject()).toString());
                readMessages.add(message);
            }
        }

          goto _L1
        Exception exception;
        exception;
        m.c("~!CloudPageListAdapter", exception.getMessage(), exception);
_L1:
        return;
        m.a("~!CloudPageListAdapter", (new StringBuilder()).append("Adding unread CloudPage message: ").append(message.getSubject()).toString());
        unreadMessages.add(message);
          goto _L2
    }

    public void deleteMessage(Message message)
    {
        try
        {
            message.setMessageDeleted(Boolean.TRUE);
            e.c(message);
            notifyDataSetChanged();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            m.c("~!CloudPageListAdapter", message.getMessage(), message);
        }
    }

    protected void finalize()
    {
        EventBus.getInstance().unregister(this);
        super.finalize();
    }

    public int getCount()
    {
        switch (display)
        {
        default:
            return 0;

        case 0: // '\0'
            return allMessages.size();

        case 1: // '\001'
            return unreadMessages.size();

        case 2: // '\002'
            return readMessages.size();
        }
    }

    public int getDisplay()
    {
        return display;
    }

    public Object getItem(int i)
    {
        switch (display)
        {
        default:
            return null;

        case 0: // '\0'
            return (Message)allMessages.get(i);

        case 1: // '\001'
            return (Message)unreadMessages.get(i);

        case 2: // '\002'
            return (Message)readMessages.get(i);
        }
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public void notifyDataSetChanged()
    {
        reloadData();
        super.notifyDataSetChanged();
    }

    public void onEvent(CloudPagesChangedEvent cloudpageschangedevent)
    {
        m.a("~!CloudPageListAdapter", "CloudPage Messages reset adapter");
        uiHandler.post(new a(this));
    }

    public void setDisplay(int i)
    {
        m.a("~!CloudPageListAdapter", String.format("CloudPage changing display from %d to %d: ", new Object[] {
            Integer.valueOf(display), Integer.valueOf(i)
        }));
        if (display != i)
        {
            display = i;
            notifyDataSetChanged();
        }
    }

    public void setMessageRead(Message message)
    {
        message.setRead(Boolean.TRUE);
        try
        {
            e.c(message);
            notifyDataSetChanged();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            m.c("~!CloudPageListAdapter", message.getMessage(), message);
        }
    }

    public void setMessageUnread(Message message)
    {
        message.setRead(Boolean.FALSE);
        try
        {
            e.c(message);
            notifyDataSetChanged();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            m.c("~!CloudPageListAdapter", message.getMessage(), message);
        }
    }
}
