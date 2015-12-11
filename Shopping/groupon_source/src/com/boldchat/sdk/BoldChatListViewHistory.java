// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.boldchat.sdk.utils.DrawableReadyListener;
import com.boldchat.sdk.utils.ExternalLinkAction;
import com.boldchat.sdk.utils.ImageCache;
import com.boldchat.sdk.utils.RichTextUtils;
import com.boldchat.sdk.utils.SpanImageFetcher;
import com.boldchat.visitor.api.PersonType;
import java.util.Collection;
import java.util.LinkedHashMap;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatHistory

public class BoldChatListViewHistory extends ListView
    implements BoldChatHistory
{
    private class HistoryAdapter extends BaseAdapter
    {

        LinkedHashMap messages;
        HistoryMessage messagesArray[];
        HistoryMessage status;
        final BoldChatListViewHistory this$0;

        public void addItem(HistoryMessage historymessage)
        {
            messages.put(Long.valueOf(historymessage.messageID), historymessage);
            updateArray();
            notifyDataSetChanged();
            scrollToBottom();
        }

        public boolean areAllItemsEnabled()
        {
            return false;
        }

        public void clearHistory()
        {
            messages.clear();
            updateArray();
        }

        public int getCount()
        {
            int j = messages.size();
            int i;
            if (status != null)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            return i + j;
        }

        public Object getItem(int i)
        {
            if (i >= messages.size())
            {
                return status;
            } else
            {
                return messagesArray[i];
            }
        }

        public long getItemId(int i)
        {
            if (i >= messages.size())
            {
                return 0L;
            } else
            {
                return messagesArray[i].messageID;
            }
        }

        public int getItemViewType(int i)
        {
            if (i >= messages.size())
            {
                return status.senderType.ordinal();
            } else
            {
                return messagesArray[i].senderType.ordinal();
            }
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            HistoryMessage historymessage = (HistoryMessage)getItem(i);
            if (view != null) goto _L2; else goto _L1
_L1:
            view = (LayoutInflater)getContext().getSystemService("layout_inflater");
            static class _cls5
            {

                static final int $SwitchMap$com$boldchat$visitor$api$PersonType[];

                static 
                {
                    $SwitchMap$com$boldchat$visitor$api$PersonType = new int[PersonType.values().length];
                    try
                    {
                        $SwitchMap$com$boldchat$visitor$api$PersonType[PersonType.Operator.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$boldchat$visitor$api$PersonType[PersonType.Visitor.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls5..SwitchMap.com.boldchat.visitor.api.PersonType[historymessage.senderType.ordinal()];
            JVM INSTR tableswitch 1 2: default 64
        //                       1 477
        //                       2 493;
               goto _L3 _L4 _L5
_L3:
            view = view.inflate(mSystemRes, null);
_L9:
            viewgroup = new Holder();
            viewgroup.bubble = (ViewGroup)view.findViewById(R.id.bc_history_bubble);
            viewgroup.avatar = (ImageView)view.findViewById(R.id.bc_avatar);
            viewgroup.time = (TextView)view.findViewById(R.id.bc_time);
            viewgroup.sender = (TextView)view.findViewById(R.id.bc_sender);
            viewgroup.text = (TextView)view.findViewById(R.id.bc_text);
            view.setTag(viewgroup);
_L7:
            viewgroup;
            JVM INSTR monitorenter ;
            final Object tag;
            if (((Holder) (viewgroup)).avatar == null || TextUtils.isEmpty(historymessage.senderAvatar))
            {
                break MISSING_BLOCK_LABEL_261;
            }
            viewgroup.avatarURL = historymessage.senderAvatar;
            tag = new Object();
            ((Holder) (viewgroup)).avatar.setTag(tag);
            tag = ImageCache.getImage(((Holder) (viewgroup)).avatarURL, viewgroup. new DrawableReadyListener() {

                final HistoryAdapter this$1;
                final Holder val$h2;
                final Object val$tag;

                public void onDrawableLoadFailed(String s)
                {
                    h2.avatar.setVisibility(8);
                }

                public void onDrawableReady(String s, Drawable drawable)
                {
                    if (tag == h2.avatar.getTag())
                    {
                        h2.avatar.setVisibility(0);
                        h2.avatar.setImageDrawable(drawable);
                    }
                }

            
            {
                this$1 = final_historyadapter;
                tag = obj;
                h2 = Holder.this;
                super();
            }
            }, getContext());
            if (tag == null)
            {
                break MISSING_BLOCK_LABEL_261;
            }
            ((Holder) (viewgroup)).avatar.setVisibility(0);
            ((Holder) (viewgroup)).avatar.setImageDrawable(((Drawable) (tag)));
            viewgroup;
            JVM INSTR monitorexit ;
            if (((Holder) (viewgroup)).time != null)
            {
                if (!TextUtils.isEmpty(historymessage.time))
                {
                    ((Holder) (viewgroup)).time.setVisibility(0);
                    ((Holder) (viewgroup)).time.setText(historymessage.time);
                } else
                {
                    ((Holder) (viewgroup)).time.setVisibility(8);
                }
            }
            if (((Holder) (viewgroup)).sender != null)
            {
                if (!TextUtils.isEmpty(historymessage.time))
                {
                    ((Holder) (viewgroup)).sender.setVisibility(0);
                    ((Holder) (viewgroup)).sender.setText(historymessage.senderName);
                } else
                {
                    ((Holder) (viewgroup)).sender.setVisibility(8);
                }
            }
            if (((Holder) (viewgroup)).bubble != null && ((Holder) (viewgroup)).text != null)
            {
                Object obj = ((Holder) (viewgroup)).bubble.getLayoutParams();
                obj.width = -2;
                ((Holder) (viewgroup)).bubble.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                obj = ((Holder) (viewgroup)).text.getLayoutParams();
                obj.width = -2;
                ((Holder) (viewgroup)).text.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                ((Holder) (viewgroup)).text.setTag(new Object());
                obj = new SpanImageFetcher(((Holder) (viewgroup)).bubble, ((Holder) (viewgroup)).text);
                ((Holder) (viewgroup)).text.setText(RichTextUtils.replaceAll(Html.fromHtml(historymessage.messageText, ((android.text.Html.ImageGetter) (obj)), null), android/text/style/URLSpan, new ExternalLinkAction(getContext()), ((Holder) (viewgroup)).text));
            }
            return view;
_L4:
            view = view.inflate(mOperatorRes, null);
            continue; /* Loop/switch isn't completed */
_L5:
            view = view.inflate(mVisitorRes, null);
            continue; /* Loop/switch isn't completed */
_L2:
            viewgroup = (Holder)view.getTag();
            if (true) goto _L7; else goto _L6
_L6:
            view;
            viewgroup;
            JVM INSTR monitorexit ;
            throw view;
            if (true) goto _L9; else goto _L8
_L8:
        }

        public int getViewTypeCount()
        {
            return PersonType.values().length;
        }

        public boolean isEnabled(int i)
        {
            return false;
        }

        public void setStatus(String s)
        {
            if (!TextUtils.isEmpty(s))
            {
                status = new HistoryMessage(s, PersonType.System, 0L, null, null, null);
            } else
            {
                status = null;
            }
            notifyDataSetChanged();
            scrollToBottom();
        }

        public void updateArray()
        {
            if (messages.size() > 0)
            {
                messagesArray = (HistoryMessage[])messages.values().toArray(new HistoryMessage[0]);
                return;
            } else
            {
                messagesArray = new HistoryMessage[0];
                return;
            }
        }

        private HistoryAdapter()
        {
            this$0 = BoldChatListViewHistory.this;
            super();
            messages = new LinkedHashMap();
            status = null;
        }

    }

    private class HistoryMessage
    {

        final long messageID;
        final String messageText;
        final String senderAvatar;
        final String senderName;
        final PersonType senderType;
        final BoldChatListViewHistory this$0;
        final String time;

        private HistoryMessage(String s, PersonType persontype, long l, String s1, String s2, 
                String s3)
        {
            this$0 = BoldChatListViewHistory.this;
            super();
            messageText = s;
            senderType = persontype;
            messageID = l;
            time = s1;
            senderName = s2;
            senderAvatar = s3;
        }

        HistoryMessage(String s, PersonType persontype, long l, String s1, String s2, 
                String s3, _cls1 _pcls1)
        {
            this(s, persontype, l, s1, s2, s3);
        }
    }

    private class Holder
    {

        ImageView avatar;
        String avatarURL;
        ViewGroup bubble;
        TextView sender;
        TextView text;
        final BoldChatListViewHistory this$0;
        TextView time;

        private Holder()
        {
            this$0 = BoldChatListViewHistory.this;
            super();
        }

    }


    private boolean bestGuessKeyboardOpen;
    private HistoryAdapter mHistoryAdapter;
    private int mOperatorRes;
    private int mSystemRes;
    private int mVisitorRes;

    public BoldChatListViewHistory(Context context)
    {
        super(context);
        mOperatorRes = R.layout.bc_bubble_operator;
        mVisitorRes = R.layout.bc_bubble_visitor;
        mSystemRes = R.layout.bc_bubble_system;
        bestGuessKeyboardOpen = false;
        initView();
    }

    public BoldChatListViewHistory(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mOperatorRes = R.layout.bc_bubble_operator;
        mVisitorRes = R.layout.bc_bubble_visitor;
        mSystemRes = R.layout.bc_bubble_system;
        bestGuessKeyboardOpen = false;
        initView();
    }

    public BoldChatListViewHistory(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mOperatorRes = R.layout.bc_bubble_operator;
        mVisitorRes = R.layout.bc_bubble_visitor;
        mSystemRes = R.layout.bc_bubble_system;
        bestGuessKeyboardOpen = false;
        initView();
    }

    private void initView()
    {
        mHistoryAdapter = new HistoryAdapter();
        setAdapter(mHistoryAdapter);
        setDivider(getResources().getDrawable(0x106000d));
    }

    public void addMessage(final String messageText, final PersonType senderType, final long messageID, final String time, final String senderName, final String senderAvatar)
    {
        runMain(new Runnable() {

            final BoldChatListViewHistory this$0;
            final long val$messageID;
            final String val$messageText;
            final String val$senderAvatar;
            final String val$senderName;
            final PersonType val$senderType;
            final String val$time;

            public void run()
            {
                mHistoryAdapter.addItem(new HistoryMessage(messageText, senderType, messageID, time, senderName, senderAvatar));
            }

            
            {
                this$0 = BoldChatListViewHistory.this;
                messageText = s;
                senderType = persontype;
                messageID = l;
                time = s1;
                senderName = s2;
                senderAvatar = s3;
                super();
            }
        });
    }

    public void clearChatHistory()
    {
        runMain(new Runnable() {

            final BoldChatListViewHistory this$0;

            public void run()
            {
                mHistoryAdapter.clearHistory();
            }

            
            {
                this$0 = BoldChatListViewHistory.this;
                super();
            }
        });
    }

    protected void onMeasure(int i, int j)
    {
        int k;
        super.onMeasure(i, j);
        k = android.view.View.MeasureSpec.getSize(j);
        if (getHeight() <= k) goto _L2; else goto _L1
_L1:
        if (!bestGuessKeyboardOpen)
        {
            scrollToBottom();
            bestGuessKeyboardOpen = true;
        }
_L4:
        super.onMeasure(i, j);
        return;
_L2:
        if (bestGuessKeyboardOpen)
        {
            bestGuessKeyboardOpen = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void runMain(Runnable runnable)
    {
        (new Handler(getContext().getMainLooper())).post(runnable);
    }

    public void scrollToBottom()
    {
        runMain(new Runnable() {

            final BoldChatListViewHistory this$0;

            public void run()
            {
                smoothScrollToPosition(mHistoryAdapter.getCount() - 1);
            }

            
            {
                this$0 = BoldChatListViewHistory.this;
                super();
            }
        });
    }

    public void setOperatorBubbleLayout(int i)
    {
        mOperatorRes = i;
    }

    public void setStatus(final String status)
    {
        runMain(new Runnable() {

            final BoldChatListViewHistory this$0;
            final String val$status;

            public void run()
            {
                mHistoryAdapter.setStatus(status);
            }

            
            {
                this$0 = BoldChatListViewHistory.this;
                status = s;
                super();
            }
        });
    }

    public void setSystemBubbleLayout(int i)
    {
        mSystemRes = i;
    }

    public void setVisitorBubbleLayout(int i)
    {
        mVisitorRes = i;
    }




}
