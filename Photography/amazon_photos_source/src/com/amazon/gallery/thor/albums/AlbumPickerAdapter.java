// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.app.Dialog;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.glide.GlideWrapper;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.mixtape.utils.IdUtils;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AddToAlbumTask

public class AlbumPickerAdapter extends ArrayAdapter
{
    private class TagLabelFilter extends Filter
    {

        final AlbumPickerAdapter this$0;

        protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
        {
            android.widget.Filter.FilterResults filterresults;
            List list;
            ArrayList arraylist;
            int i;
            int k;
            filterresults = new android.widget.Filter.FilterResults();
            if (charsequence == null || charsequence.length() == 0)
            {
                charsequence = new ArrayList(originalList);
                filterresults.values = charsequence;
                filterresults.count = charsequence.size();
                return filterresults;
            }
            charsequence = charsequence.toString().toLowerCase();
            list = originalList;
            k = list.size();
            arraylist = new ArrayList(k);
            i = 0;
_L2:
            Tag tag;
            String s;
            if (i >= k)
            {
                break MISSING_BLOCK_LABEL_220;
            }
            tag = (Tag)list.get(i);
            s = tag.getLabel().toLowerCase();
            if (!s.equals(charsequence) && !s.startsWith(charsequence))
            {
                break; /* Loop/switch isn't completed */
            }
            arraylist.add(tag);
_L3:
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            String as[];
            int j;
            int l;
            as = s.split(" ");
            l = as.length;
            j = 0;
_L4:
            if (j < l)
            {
label0:
                {
                    if (!as[j].startsWith(charsequence))
                    {
                        break label0;
                    }
                    arraylist.add(tag);
                }
            }
              goto _L3
            j++;
              goto _L4
            filterresults.values = arraylist;
            filterresults.count = arraylist.size();
            return filterresults;
              goto _L3
        }

        protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
        {
            charsequence = (List)filterresults.values;
            clear();
            for (charsequence = charsequence.iterator(); charsequence.hasNext(); add(filterresults))
            {
                filterresults = (Tag)charsequence.next();
            }

            notifyDataSetChanged();
            notifyDataSetInvalidated();
        }

        private TagLabelFilter()
        {
            this$0 = AlbumPickerAdapter.this;
            super();
        }

    }


    private static final String TAG = com/amazon/gallery/thor/albums/AlbumPickerAdapter.getName();
    private Activity activity;
    private Multimap albumMap;
    private List albums;
    private Dialog dialog;
    private Filter filter;
    private String filterText;
    private List mediaItemIdsToAdd;
    private List originalList;
    private final ComponentProfiler profiler;

    public AlbumPickerAdapter(Activity activity1, List list, List list1, Dialog dialog1, ComponentProfiler componentprofiler)
    {
        super(activity1, 0, list);
        activity = activity1;
        dialog = dialog1;
        albums = list;
        originalList = new LinkedList(list);
        mediaItemIdsToAdd = list1;
        profiler = componentprofiler;
        albumMap = ArrayListMultimap.create();
        for (activity1 = list.iterator(); activity1.hasNext(); albumMap.put(list.getLabel().toLowerCase(), list))
        {
            list = (Tag)activity1.next();
        }

    }

    private boolean isUniqueTagName(String s)
    {
        s = albumMap.get(s.toLowerCase());
        return s != null && s.size() == 1;
    }

    private void loadCoverPhoto(Tag tag, ImageView imageview, boolean flag, int i)
    {
        Activity activity1 = GlideWrapper.getActivityForView(imageview);
        if (activity1.isFinishing() || Api.isAtLeastJellyBeanMR1() && activity1.isDestroyed())
        {
            GLogger.d(TAG, "Activity was finishing or destroyed, don't load with glide", new Object[0]);
            return;
        } else
        {
            GlideWrapper.loadImage(tag, imageview, null, null, false, i, null);
            return;
        }
    }

    public void cleanUp()
    {
        activity = null;
    }

    public Filter getFilter()
    {
        if (filter == null)
        {
            filter = new TagLabelFilter();
        }
        return filter;
    }

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        boolean flag1 = false;
        View view1 = view;
        if (view == null)
        {
            view1 = LayoutInflater.from(getContext()).inflate(0x7f03001d, viewgroup, false);
        }
        view = (Tag)albums.get(position);
        viewgroup = (TextView)view1.findViewById(0x7f0c0093);
        viewgroup.setText(view.getLabel());
        viewgroup.setShadowLayer(8F, 2.0F, 2.0F, 0xff000000);
        ImageView imageview = (ImageView)view1.findViewById(0x7f0c0092);
        boolean flag;
        int i;
        boolean flag2;
        boolean flag3;
        if (view.getCustomCoverId() == null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        loadCoverPhoto(view, imageview, flag3, position);
        flag2 = false;
        flag = flag2;
        if (filterText != null)
        {
            flag = flag2;
            if (filterText.length() > 0)
            {
                flag = flag2;
                if (viewgroup.getText().toString().equalsIgnoreCase(filterText))
                {
                    flag = flag2;
                    if (albumMap.get(filterText) != null)
                    {
                        flag = flag2;
                        if (isUniqueTagName(filterText))
                        {
                            flag = true;
                        }
                    }
                }
            }
        }
        view = view1.findViewById(0x7f0c0094);
        if (flag)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view1.setOnClickListener(new android.view.View.OnClickListener() {

            final AlbumPickerAdapter this$0;
            final int val$position;

            public void onClick(View view2)
            {
                view2 = (Tag)getItem(position);
                view2 = IdUtils.objectIdToNodeId(view2.getObjectId().getMostSignificantBits(), view2.getObjectId().getLeastSignificantBits());
                if (view2 != null)
                {
                    (new AddToAlbumTask(activity, mediaItemIdsToAdd, view2, profiler)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                }
                GlobalMessagingBus.post(new ActionCompleteEvent());
                dialog.dismiss();
            }

            
            {
                this$0 = AlbumPickerAdapter.this;
                position = i;
                super();
            }
        });
        return view1;
    }

    public void setFilterText(String s)
    {
        filterText = s.toLowerCase();
    }






}
