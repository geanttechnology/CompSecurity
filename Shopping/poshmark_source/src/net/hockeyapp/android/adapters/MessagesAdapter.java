// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import net.hockeyapp.android.objects.FeedbackMessage;
import net.hockeyapp.android.views.FeedbackMessageView;

public class MessagesAdapter extends BaseAdapter
{

    private TextView authorTextView;
    private Context context;
    private Date date;
    private TextView dateTextView;
    private SimpleDateFormat format;
    private SimpleDateFormat formatNew;
    private TextView messageTextView;
    private ArrayList messagesList;

    public MessagesAdapter(Context context1, ArrayList arraylist)
    {
        context = context1;
        messagesList = arraylist;
        format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        formatNew = new SimpleDateFormat("d MMM h:mm a");
    }

    public void add(FeedbackMessage feedbackmessage)
    {
        if (feedbackmessage != null && messagesList != null)
        {
            messagesList.add(feedbackmessage);
        }
    }

    public void clear()
    {
        if (messagesList != null)
        {
            messagesList.clear();
        }
    }

    public int getCount()
    {
        return messagesList.size();
    }

    public Object getItem(int i)
    {
        return messagesList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = (FeedbackMessage)messagesList.get(i);
        if (view == null)
        {
            view = new FeedbackMessageView(context);
        } else
        {
            view = (FeedbackMessageView)view;
        }
        if (viewgroup != null)
        {
            authorTextView = (TextView)view.findViewById(12289);
            dateTextView = (TextView)view.findViewById(12290);
            messageTextView = (TextView)view.findViewById(12291);
            try
            {
                date = format.parse(viewgroup.getCreatedAt());
                dateTextView.setText(formatNew.format(date));
            }
            catch (ParseException parseexception)
            {
                parseexception.printStackTrace();
            }
            authorTextView.setText(viewgroup.getName());
            messageTextView.setText(viewgroup.getText());
        }
        if (i % 2 == 0)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        view.setFeedbackMessageViewBgAndTextColor(i);
        return view;
    }
}
