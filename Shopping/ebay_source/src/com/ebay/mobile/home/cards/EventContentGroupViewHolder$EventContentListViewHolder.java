// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.res.Resources;
import android.view.View;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.events.EventViewHolder;
import com.ebay.mobile.events.EventViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            EventContentGroupViewHolder, ListOfEventsViewModel

public class setFullSpan extends ViewHolder
{

    private final int eventCollectionSeparatorIds[] = {
        0x7f10023e, 0x7f10023f
    };
    public final List eventCollectionSeparators = new ArrayList();
    public final List eventViews = new ArrayList();
    private final int groupIdx;
    private final View separator;
    final EventContentGroupViewHolder this$0;

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (!(viewmodel instanceof ListOfEventsViewModel)) goto _L2; else goto _L1
_L1:
        viewmodel = (ListOfEventsViewModel)viewmodel;
        for (Iterator iterator = eventViews.iterator(); iterator.hasNext(); ((EventViewHolder)iterator.next()).itemView.setVisibility(8)) { }
        int i1 = eventViews.size();
        int i2 = ((ListOfEventsViewModel) (viewmodel)).events.size();
        int j2 = Math.min(i1, i2);
        int i = 0;
        int j = 0;
        if (EventContentGroupViewHolder.isTablet)
        {
            Object obj;
            EventViewHolder eventviewholder;
            int l;
            int k1;
            int l1;
            if (i2 < i1 && i2 % 2 == 0)
            {
                j = 0 + 1;
                l = 8;
            } else
            {
                l = 0;
            }
            i = j;
            if (i1 > 0)
            {
                ((EventViewHolder)eventViews.get(0)).itemView.setVisibility(l);
                i = j;
            }
        }
        if (separator == null) goto _L4; else goto _L3
_L3:
        obj = separator;
        int k;
        if (i2 >= i1)
        {
            k = 0;
        } else
        {
            k = 8;
        }
        ((View) (obj)).setVisibility(k);
_L5:
        k = 0;
label0:
        do
        {
            int j1;
label1:
            {
                if (k >= j2)
                {
                    break label0;
                }
                obj = (EventViewModel)((ListOfEventsViewModel) (viewmodel)).events.get(k);
                eventviewholder = (EventViewHolder)eventViews.get(i);
                eventviewholder.itemView.setVisibility(0);
                if (!EventContentGroupViewHolder.isTablet)
                {
                    l = k - 1;
                    if (l >= 0 && l < eventCollectionSeparators.size())
                    {
                        ((View)eventCollectionSeparators.get(l)).setVisibility(0);
                    }
                }
                j1 = eventviewholder.itemView.getPaddingLeft();
                k1 = eventviewholder.itemView.getPaddingRight();
                l1 = eventviewholder.itemView.getPaddingTop();
                l = l1;
                if (groupIdx != 0)
                {
                    break label1;
                }
                if (k != 0)
                {
                    l = l1;
                    if (!EventContentGroupViewHolder.isTablet)
                    {
                        break label1;
                    }
                    l = l1;
                    if (i2 >= EventContentGroupViewHolder.access$100())
                    {
                        break label1;
                    }
                }
                l = 0;
                eventviewholder.itemView.setPadding(j1, 0, k1, 0);
            }
            if (EventContentGroupViewHolder.isTablet && (k > 0 || i2 < EventContentGroupViewHolder.access$100()))
            {
                Iterator iterator1;
                if ((i2 - k) % 2 == 0)
                {
                    k1 /= 2;
                } else
                {
                    j1 /= 2;
                }
                eventviewholder.itemView.setPadding(j1, l, k1, 0);
                eventviewholder.imageView.getLayoutParams().groupIdx = EventContentGroupViewHolder.access$200(EventContentGroupViewHolder.this).getDimensionPixelSize(0x7f09002e);
            }
            eventviewholder.bind(((ViewModel) (obj)));
            k++;
            i++;
        } while (true);
        break; /* Loop/switch isn't completed */
_L4:
        if (eventCollectionSeparators.size() > 0)
        {
            iterator1 = eventCollectionSeparators.iterator();
            while (iterator1.hasNext()) 
            {
                ((View)iterator1.next()).setVisibility(8);
            }
        }
        if (true) goto _L5; else goto _L2
_L2:
    }

    public (View view, int i)
    {
        this$0 = EventContentGroupViewHolder.this;
        super(view);
        groupIdx = i;
        eventcontentgroupviewholder = EventContentGroupViewHolder.access$000();
        int j = EventContentGroupViewHolder.this.length;
        for (i = 0; i < j; i++)
        {
            int k = EventContentGroupViewHolder.this[i];
            View view1 = itemView.findViewById(k);
            if (view1 != null)
            {
                eventViews.add(new EventViewHolder(view1));
            }
        }

        eventcontentgroupviewholder = eventCollectionSeparatorIds;
        j = EventContentGroupViewHolder.this.length;
        for (i = 0; i < j; i++)
        {
            int l = EventContentGroupViewHolder.this[i];
            View view2 = itemView.findViewById(l);
            if (view2 != null)
            {
                eventCollectionSeparators.add(view2);
            }
        }

        separator = view.findViewById(0x7f100240);
        setFullSpan(true);
    }
}
