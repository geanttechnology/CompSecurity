// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
//            BoldChatListViewHistory

private class <init> extends BaseAdapter
{

    LinkedHashMap messages;
    messagesArray messagesArray[];
    messagesArray status;
    final BoldChatListViewHistory this$0;

    public void addItem(<init> <init>1)
    {
        messages.put(Long.valueOf(<init>1.messageID), <init>1);
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

    public View getView(int i, View view, final ViewGroup h2)
    {
        senderType sendertype = (senderType)getItem(i);
        if (view != null) goto _L2; else goto _L1
_L1:
        view = (LayoutInflater)getContext().getSystemService("layout_inflater");
        m.boldchat.visitor.api.PersonType[sendertype.senderType.ordinal()];
        JVM INSTR tableswitch 1 2: default 64
    //                   1 477
    //                   2 493;
           goto _L3 _L4 _L5
_L3:
        view = view.inflate(BoldChatListViewHistory.access$500(BoldChatListViewHistory.this), null);
_L9:
        h2 = new this._cls0(BoldChatListViewHistory.this, null);
        h2._fld0 = (ViewGroup)view.findViewById(this._fld0);
        h2._fld0 = (ImageView)view.findViewById(this._fld0);
        h2._fld0 = (TextView)view.findViewById(this._fld0);
        h2._fld0 = (TextView)view.findViewById(this._fld0);
        h2._fld0 = (TextView)view.findViewById(this._fld0);
        view.setTag(h2);
_L7:
        h2;
        JVM INSTR monitorenter ;
        final Object tag;
        if (((this._cls0) (h2))._fld0 == null || TextUtils.isEmpty(sendertype.senderAvatar))
        {
            break MISSING_BLOCK_LABEL_261;
        }
        h2.L = sendertype.senderAvatar;
        tag = new Object();
        ((senderAvatar) (h2)).senderAvatar.setTag(tag);
        tag = ImageCache.getImage(((senderAvatar) (h2)).L, new DrawableReadyListener() {

            final BoldChatListViewHistory.HistoryAdapter this$1;
            final BoldChatListViewHistory.Holder val$h2;
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
                this$1 = BoldChatListViewHistory.HistoryAdapter.this;
                tag = obj;
                h2 = holder;
                super();
            }
        }, getContext());
        if (tag == null)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        ((_cls1.val.h2) (h2)).h2.setVisibility(0);
        ((_cls1.val.h2) (h2)).h2.setImageDrawable(((Drawable) (tag)));
        h2;
        JVM INSTR monitorexit ;
        if (((_cls1.val.h2) (h2)).h2 != null)
        {
            if (!TextUtils.isEmpty(sendertype.time))
            {
                ((time) (h2)).time.setVisibility(0);
                ((time) (h2)).time.setText(sendertype.time);
            } else
            {
                ((time) (h2)).time.setVisibility(8);
            }
        }
        if (((time) (h2)).time != null)
        {
            if (!TextUtils.isEmpty(sendertype.time))
            {
                ((time) (h2)).time.setVisibility(0);
                ((time) (h2)).time.setText(sendertype.senderName);
            } else
            {
                ((senderName) (h2)).senderName.setVisibility(8);
            }
        }
        if (((senderName) (h2)).senderName != null && ((senderName) (h2)).senderName != null)
        {
            Object obj = ((senderName) (h2)).senderName.getLayoutParams();
            obj.le = -2;
            ((senderName) (h2)).senderName.setLayoutParams(((android.view.le) (obj)));
            obj = ((senderName) (h2)).senderName.getLayoutParams();
            obj. = -2;
            ((senderName) (h2)).senderName.setLayoutParams(((android.view.) (obj)));
            ((senderName) (h2)).senderName.setTag(new Object());
            obj = new SpanImageFetcher(((senderName) (h2)).senderName, ((senderName) (h2)).senderName);
            ((senderName) (h2)).senderName.setText(RichTextUtils.replaceAll(Html.fromHtml(sendertype.messageText, ((android.text.age.messageText) (obj)), null), android/text/style/URLSpan, new ExternalLinkAction(getContext()), ((messageText) (h2)).messageText));
        }
        return view;
_L4:
        view = view.inflate(BoldChatListViewHistory.access$300(BoldChatListViewHistory.this), null);
        continue; /* Loop/switch isn't completed */
_L5:
        view = view.inflate(BoldChatListViewHistory.access$400(BoldChatListViewHistory.this), null);
        continue; /* Loop/switch isn't completed */
_L2:
        h2 = (this._cls0)view.getTag();
        if (true) goto _L7; else goto _L6
_L6:
        view;
        h2;
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
            status = new <init>(BoldChatListViewHistory.this, s, PersonType.System, 0L, null, null, null, null);
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
            messagesArray = (messagesArray[])messages.values().toArray(new messages[0]);
            return;
        } else
        {
            messagesArray = new messagesArray[0];
            return;
        }
    }

    private _cls1.val.h2()
    {
        this$0 = BoldChatListViewHistory.this;
        super();
        messages = new LinkedHashMap();
        status = null;
    }

    status(status status1)
    {
        this();
    }
}
