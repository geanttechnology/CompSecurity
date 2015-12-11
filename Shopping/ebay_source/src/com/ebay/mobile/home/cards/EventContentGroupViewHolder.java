// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.events.EventViewHolder;
import com.ebay.mobile.events.EventViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.ebay.mobile.home.cards:
//            ListOfEventGroupsViewModel, ListOfEventsViewModel

public class EventContentGroupViewHolder extends ViewHolder
{
    public class EventContentListViewHolder extends ViewHolder
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
                        if (i2 >= EventContentGroupViewHolder.MAX_EVENTS_IN_GROUP)
                        {
                            break label1;
                        }
                    }
                    l = 0;
                    eventviewholder.itemView.setPadding(j1, 0, k1, 0);
                }
                if (EventContentGroupViewHolder.isTablet && (k > 0 || i2 < EventContentGroupViewHolder.MAX_EVENTS_IN_GROUP))
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
                    eventviewholder.imageView.getLayoutParams().height = resources.getDimensionPixelSize(0x7f09002e);
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

        public EventContentListViewHolder(View view, int i)
        {
            this$0 = EventContentGroupViewHolder.this;
            super(view);
            groupIdx = i;
            eventcontentgroupviewholder = EventContentGroupViewHolder.eventIds;
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


    private static int MAX_EVENTS_IN_GROUP = 3;
    private static final int eventGroups[] = {
        0x7f100239, 0x7f10023b, 0x7f10023d
    };
    private static final int eventIds[] = {
        0x7f1000fd, 0x7f1000fe, 0x7f1000ff
    };
    private static final int eventSeparators[] = {
        0x7f10023a, 0x7f10023c
    };
    protected static boolean isTablet;
    public final List eventGroupViews = new ArrayList();
    public final List eventSeparatorViews = new ArrayList();
    public final TextView groupTitle;
    private final Resources resources;
    private final Button showMoreButton;

    public EventContentGroupViewHolder(View view)
    {
        super(view);
        resources = view.getContext().getResources();
        isTablet = resources.getBoolean(0x7f0b0006);
        groupTitle = (TextView)view.findViewById(0x7f10005f);
        int ai[] = eventGroups;
        int k1 = ai.length;
        int k = 0;
        int i = 0;
        for (; k < k1; k++)
        {
            int l = ai[k];
            View view1 = itemView.findViewById(l);
            if (view1 != null)
            {
                List list = eventGroupViews;
                int i1 = i + 1;
                list.add(new EventContentListViewHolder(view1, i));
                i = i1;
            }
        }

        ai = eventSeparators;
        k = ai.length;
        for (int j = 0; j < k; j++)
        {
            int j1 = ai[j];
            View view2 = itemView.findViewById(j1);
            if (view2 != null)
            {
                view2.setVisibility(8);
                eventSeparatorViews.add(view2);
            }
        }

        showMoreButton = (Button)view.findViewById(0x7f10029c);
        showMoreButton.setText(0x7f0701eb);
        showMoreButton.setOnClickListener(this);
    }

    public static boolean isValidModel(List list, boolean flag, boolean flag1)
    {
        list = list.iterator();
        ListOfEventGroupsViewModel listofeventgroupsviewmodel;
label0:
        do
        {
            if (list.hasNext())
            {
                listofeventgroupsviewmodel = (ListOfEventGroupsViewModel)list.next();
                if (listofeventgroupsviewmodel == null)
                {
                    return false;
                }
                Iterator iterator = listofeventgroupsviewmodel.eventGroups.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    ListIterator listiterator = ((ListOfEventsViewModel)iterator.next()).events.listIterator();
                    while (listiterator.hasNext()) 
                    {
                        if (TextUtils.isEmpty(((EventViewModel)listiterator.next()).title))
                        {
                            listiterator.remove();
                        }
                    }
                } while (true);
            } else
            {
                return true;
            }
        } while (listofeventgroupsviewmodel.eventGroups.size() >= 0);
        return false;
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (viewmodel instanceof ListOfEventGroupsViewModel)
        {
            ListOfEventGroupsViewModel listofeventgroupsviewmodel = (ListOfEventGroupsViewModel)viewmodel;
            groupTitle.setText(((ListOfEventGroupsViewModel)viewmodel).eventsTitle);
            for (viewmodel = eventGroupViews.iterator(); viewmodel.hasNext(); ((EventContentListViewHolder)viewmodel.next()).itemView.setVisibility(8)) { }
            int j = Math.min(eventGroupViews.size(), listofeventgroupsviewmodel.eventGroups.size());
            for (int i = 0; i < j; i++)
            {
                viewmodel = (ListOfEventsViewModel)listofeventgroupsviewmodel.eventGroups.get(i);
                EventContentListViewHolder eventcontentlistviewholder = (EventContentListViewHolder)eventGroupViews.get(i);
                eventcontentlistviewholder.itemView.setVisibility(0);
                if (i > 0)
                {
                    ((View)eventSeparatorViews.get(i - 1)).setVisibility(0);
                }
                eventcontentlistviewholder.bind(viewmodel);
            }

        }
    }




}
