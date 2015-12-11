// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter.view;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.model.Configuration;
import com.apptentive.android.sdk.model.Message;
import com.apptentive.android.sdk.module.messagecenter.MessageManager;
import com.apptentive.android.sdk.util.Util;
import java.util.List;

// Referenced classes of package com.apptentive.android.sdk.module.messagecenter.view:
//            AttachmentPreviewDialog, MessageAdapter

public class MessageCenterView extends FrameLayout
    implements com.apptentive.android.sdk.module.messagecenter.MessageManager.OnSentMessageListener
{

    private static CharSequence message;
    static OnSendMessageListener onSendMessageListener;
    Activity context;
    MessageAdapter messageAdapter;
    EditText messageEditText;
    ListView messageListView;

    public MessageCenterView(Activity activity, OnSendMessageListener onsendmessagelistener)
    {
        super(activity);
        context = activity;
        onSendMessageListener = onsendmessagelistener;
        setId(com.apptentive.android.sdk.R.id.apptentive_message_center_view);
        setup();
    }

    public static void showAttachmentDialog(Context context1, final Uri data)
    {
        if (data == null)
        {
            Log.d("No attachment found.", new Object[0]);
            return;
        } else
        {
            context1 = new AttachmentPreviewDialog(context1);
            context1.setImage(data);
            context1.setOnAttachmentAcceptedListener(new _cls7());
            context1.show();
            return;
        }
    }

    public void addMessage(Message message1)
    {
        if (message1.isHidden())
        {
            return;
        } else
        {
            messageAdapter.add(message1);
            messageListView.post(new _cls6());
            return;
        }
    }

    public void onSentMessage(Message message1)
    {
        this;
        JVM INSTR monitorenter ;
        setMessages(MessageManager.getMessages(context));
        this;
        JVM INSTR monitorexit ;
        return;
        message1;
        throw message1;
    }

    public void scrollMessageListViewToBottom()
    {
        messageListView.post(new _cls8());
    }

    public void setMessages(final List messages)
    {
        messageListView.post(new _cls5());
    }

    protected void setup()
    {
        context.getLayoutInflater().inflate(com.apptentive.android.sdk.R.layout.apptentive_message_center, this);
        Object obj = findViewById(com.apptentive.android.sdk.R.id.apptentive_branding_view);
        String s;
        boolean flag;
        if (obj != null)
        {
            if (Configuration.load(context).isHideBranding(context))
            {
                ((View) (obj)).setVisibility(8);
            } else
            {
                ((View) (obj)).setOnClickListener(new _cls1());
            }
        }
        obj = (TextView)findViewById(com.apptentive.android.sdk.R.id.apptentive_message_center_header_title);
        s = Configuration.load(context).getMessageCenterTitle();
        if (s != null)
        {
            ((TextView) (obj)).setText(s);
        }
        messageListView = (ListView)findViewById(com.apptentive.android.sdk.R.id.apptentive_message_center_list);
        messageListView.setTranscriptMode(2);
        messageEditText = (EditText)findViewById(com.apptentive.android.sdk.R.id.apptentive_message_center_message);
        if (message != null)
        {
            messageEditText.setText(message);
            messageEditText.setSelection(message.length());
        }
        messageEditText.addTextChangedListener(new _cls2());
        findViewById(com.apptentive.android.sdk.R.id.apptentive_message_center_send).setOnClickListener(new _cls3());
        obj = findViewById(com.apptentive.android.sdk.R.id.apptentive_message_center_attach_button);
        if (Util.getMajorOsVersion().intValue() >= 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ((View) (obj)).setOnClickListener(new _cls4());
        } else
        {
            ((View) (obj)).setVisibility(8);
        }
        messageAdapter = new MessageAdapter(context);
        messageListView.setAdapter(messageAdapter);
    }


/*
    static CharSequence access$002(CharSequence charsequence)
    {
        message = charsequence;
        return charsequence;
    }

*/

    private class _cls7
        implements AttachmentPreviewDialog.OnAttachmentAcceptedListener
    {

        final Uri val$data;

        public final void onAttachmentAccepted()
        {
            MessageCenterView.onSendMessageListener.onSendFileMessage(data);
        }

        _cls7()
        {
            data = uri;
            super();
        }

        private class OnSendMessageListener
        {

            public abstract void onSendFileMessage(Uri uri);

            public abstract void onSendTextMessage(String s);
        }

    }


    private class _cls6
        implements Runnable
    {

        final MessageCenterView this$0;

        public void run()
        {
            scrollMessageListViewToBottom();
        }

        _cls6()
        {
            this$0 = MessageCenterView.this;
            super();
        }
    }


    private class _cls8
        implements Runnable
    {

        final MessageCenterView this$0;

        public void run()
        {
            messageListView.setSelection(messageAdapter.getCount() - 1);
        }

        _cls8()
        {
            this$0 = MessageCenterView.this;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final MessageCenterView this$0;
        final List val$messages;

        public void run()
        {
            messageAdapter.clear();
            Message message1;
            for (Iterator iterator = messages.iterator(); iterator.hasNext(); addMessage(message1))
            {
                message1 = (Message)iterator.next();
            }

        }

        _cls5()
        {
            this$0 = MessageCenterView.this;
            messages = list;
            super();
        }
    }


    private class _cls2
        implements TextWatcher
    {

        final MessageCenterView this$0;

        public void afterTextChanged(Editable editable)
        {
            MessageCenterView.message = editable.toString();
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        _cls2()
        {
            this$0 = MessageCenterView.this;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final MessageCenterView this$0;

        public void onClick(View view)
        {
            String s = messageEditText.getText().toString().trim();
            if (s.length() == 0)
            {
                return;
            } else
            {
                messageEditText.setText("");
                MessageCenterView.onSendMessageListener.onSendTextMessage(s);
                MessageCenterView.message = null;
                Util.hideSoftKeyboard(context, view);
                return;
            }
        }

        _cls3()
        {
            this$0 = MessageCenterView.this;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final MessageCenterView this$0;

        public void onClick(View view)
        {
            MetricModule.sendMetric(context, com.apptentive.android.sdk.model.Event.EventLabel.message_center__attach);
            view = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            view.setType("image/*");
            context.startActivityForResult(view, 1000);
        }

        _cls4()
        {
            this$0 = MessageCenterView.this;
            super();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final MessageCenterView this$0;

        public void onClick(View view)
        {
            AboutModule.getInstance().show(context);
        }

        _cls1()
        {
            this$0 = MessageCenterView.this;
            super();
        }
    }

}
