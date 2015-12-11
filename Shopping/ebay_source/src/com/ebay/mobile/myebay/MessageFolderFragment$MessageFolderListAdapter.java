// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.widget.UserThumbnail;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.data.MessageFolder;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessageFolderFragment, MessagesFilterType

final class refilter extends ArrayAdapter
    implements android.view.stAdapter, Filterable
{
    private final class DateViewHolder
    {

        TextView text;
        final MessageFolderFragment.MessageFolderListAdapter this$1;

        private DateViewHolder()
        {
            this$1 = MessageFolderFragment.MessageFolderListAdapter.this;
            super();
        }

        DateViewHolder(MessageFolderFragment._cls1 _pcls1)
        {
            this();
        }
    }

    private class MessageFolderFilter extends Filter
    {

        boolean filtering;
        final MessageFolderFragment.MessageFolderListAdapter this$1;

        protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
        {
            filtering = true;
            ArrayList arraylist = new ArrayList();
            charsequence = null;
            Iterator iterator = MessageFolderFragment.access$900(this$0).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                MessageFolderFragment.MsgListItem msglistitem = (MessageFolderFragment.MsgListItem)iterator.next();
                if (msglistitem instanceof MessageFolderFragment.MsgListSeparator)
                {
                    charsequence = (MessageFolderFragment.MsgListSeparator)msglistitem;
                } else
                if (msglistitem instanceof MessageFolderFragment.MsgListMessage)
                {
                    EbayMessage ebaymessage = ((MessageFolderFragment.MsgListMessage)msglistitem).message;
                    if (MessagesFilterType.doesMessageMatchFilter(filterType, ebaymessage))
                    {
                        CharSequence charsequence1 = charsequence;
                        if (charsequence != null)
                        {
                            arraylist.add(charsequence);
                            charsequence1 = null;
                        }
                        arraylist.add(msglistitem);
                        charsequence = charsequence1;
                    }
                }
            } while (true);
            charsequence = new android.widget.Filter.FilterResults();
            charsequence.count = arraylist.size();
            charsequence.values = arraylist;
            return charsequence;
        }

        protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
        {
            filtering = false;
            filteredItems = (List)filterresults.values;
            notifyDataSetChanged();
        }

        private MessageFolderFilter()
        {
            this$1 = MessageFolderFragment.MessageFolderListAdapter.this;
            super();
            filtering = false;
        }

        MessageFolderFilter(MessageFolderFragment._cls1 _pcls1)
        {
            this();
        }
    }

    private final class MessageViewHolder
    {

        TextView dateTime;
  