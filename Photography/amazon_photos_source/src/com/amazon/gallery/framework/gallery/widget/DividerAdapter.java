// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.metrics.LaunchTimeMetrics;
import com.amazon.gallery.framework.kindle.widget.DividerViewFactory;
import com.amazon.gallery.framework.model.TimelineEntry;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            GalleryBaseAdapter, MediaItemCursorAdapter

public class DividerAdapter extends GalleryBaseAdapter
    implements com.amazon.gallery.framework.data.model.TimelineModel.ChangeListener
{

    private static final String TAG = com/amazon/gallery/framework/gallery/widget/DividerAdapter.getName();
    protected static final int TYPE_COUNT = GalleryBaseAdapter.ItemViewType.values().length;
    protected final Activity activity;
    protected DividerViewFactory dividerFactory;
    protected int highlightedDividerIndex;
    protected LaunchTimeMetrics launchTimeMetrics;
    protected MediaItemCursorAdapter mediaItemCursorAdapter;
    protected List timelineEntries;

    public DividerAdapter(Activity activity1)
    {
        timelineEntries = Collections.emptyList();
        highlightedDividerIndex = -1;
        activity = activity1;
    }

    private int getMediaItemIndex(int i, List list)
    {
        if (list.isEmpty())
        {
            return i;
        }
        int k = 0;
        for (int j = 0; j < list.size(); j++)
        {
            k = ((TimelineEntry)list.get(j)).getCount() + k + 1;
            if (i < k || j == list.size() - 1)
            {
                return i - (j + 1);
            }
        }

        return -1;
    }

    private TimelineEntry getTimelineEntry(int i, List list)
    {
        if (i == 0 && !list.isEmpty())
        {
            return (TimelineEntry)list.get(0);
        }
        int k = 0;
        for (int j = 0; j < list.size() - 1; j++)
        {
            k = ((TimelineEntry)list.get(j)).getCount() + k + 1;
            if (k > i)
            {
                return null;
            }
            if (k == i)
            {
                return (TimelineEntry)list.get(j + 1);
            }
        }

        return null;
    }

    public int getCount()
    {
        if (mediaItemCursorAdapter.isEmpty())
        {
            return 0;
        }
        int i;
        if (timelineEntries.size() > mediaItemCursorAdapter.getCount())
        {
            i = mediaItemCursorAdapter.getCount();
        } else
        {
            i = timelineEntries.size();
        }
        return mediaItemCursorAdapter.getCount() + i;
    }

    public int getGridItemIndex(int i)
    {
        this;
        JVM INSTR monitorenter ;
        int j;
        int k;
        int i1;
        k = 0;
        i1 = i + 1;
        j = 0;
_L2:
        int l = i1;
        if (j >= timelineEntries.size())
        {
            break MISSING_BLOCK_LABEL_68;
        }
        l = ((TimelineEntry)timelineEntries.get(j)).getCount();
        k += l;
        if (k <= i)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        l = i1 + j;
        this;
        JVM INSTR monitorexit ;
        return l;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public int getGridItemIndexForLayoutFocus(int i)
    {
        return getGridItemIndex(i);
    }

    public Object getItem(int i)
    {
        TimelineEntry timelineentry = getTimelineEntry(i);
        if (timelineentry != null)
        {
            return timelineentry;
        }
        i = getMediaItemIndex(i);
        if (i >= 0)
        {
            return mediaItemCursorAdapter.getItem(i);
        } else
        {
            return null;
        }
    }

    public long getItemId(int i)
    {
        TimelineEntry timelineentry = getTimelineEntry(i);
        if (timelineentry != null)
        {
            return (long)timelineentry.getId();
        } else
        {
            i = getMediaItemIndex(i);
            return mediaItemCursorAdapter.getItemId(i);
        }
    }

    public int getItemViewType(int i)
    {
        if (getTimelineEntry(i) != null)
        {
            return GalleryBaseAdapter.ItemViewType.DIVIDER.ordinal();
        } else
        {
            return GalleryBaseAdapter.ItemViewType.MEDIA_ITEM.ordinal();
        }
    }

    public int getMediaItemIndex(int i)
    {
        this;
        JVM INSTR monitorenter ;
        i = getMediaItemIndex(i, timelineEntries);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    protected TimelineEntry getTimelineEntry(int i)
    {
        this;
        JVM INSTR monitorenter ;
        TimelineEntry timelineentry = getTimelineEntry(i, timelineEntries);
        this;
        JVM INSTR monitorexit ;
        return timelineentry;
        Exception exception;
        exception;
        throw exception;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj;
        GalleryBaseAdapter.ItemViewType itemviewtype;
        List list;
label0:
        {
            GalleryBaseAdapter.ItemViewType itemviewtype1 = GalleryBaseAdapter.ItemViewType.MEDIA_ITEM;
            list = timelineEntries;
            obj = null;
            if (view != null)
            {
                itemviewtype = itemviewtype1;
                if (view.getTag(0x7f0c000e) != GalleryBaseAdapter.ItemViewType.DIVIDER)
                {
                    break label0;
                }
            }
            TimelineEntry timelineentry = getTimelineEntry(i, list);
            obj = timelineentry;
            itemviewtype = itemviewtype1;
            if (timelineentry != null)
            {
                itemviewtype = GalleryBaseAdapter.ItemViewType.DIVIDER;
                obj = timelineentry;
            }
        }
        static class _cls2
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$widget$GalleryBaseAdapter$ItemViewType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$widget$GalleryBaseAdapter$ItemViewType = new int[GalleryBaseAdapter.ItemViewType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$widget$GalleryBaseAdapter$ItemViewType[GalleryBaseAdapter.ItemViewType.MEDIA_ITEM.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$widget$GalleryBaseAdapter$ItemViewType[GalleryBaseAdapter.ItemViewType.DIVIDER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.amazon.gallery.framework.gallery.widget.GalleryBaseAdapter.ItemViewType[itemviewtype.ordinal()];
        JVM INSTR tableswitch 1 2: default 96
    //                   1 108
    //                   2 190;
           goto _L1 _L2 _L3
_L1:
        view.setTag(0x7f0c000d, Integer.valueOf(i));
        return view;
_L2:
        int j = getMediaItemIndex(i, list);
        if (j < 0 || j >= mediaItemCursorAdapter.getCount())
        {
            GLogger.w(TAG, "cursorAdapter count is invalid for request of view %s, cursor may be invalid", new Object[] {
                Integer.valueOf(i)
            });
            obj = view;
            if (view == null)
            {
                obj = mediaItemCursorAdapter.newView(null, null, viewgroup);
            }
            return ((View) (obj));
        }
        view = mediaItemCursorAdapter.getView(j, view, viewgroup);
        continue; /* Loop/switch isn't completed */
_L3:
        viewgroup = dividerFactory.getView(i, ((TimelineEntry) (obj)), view);
        view = viewgroup;
        if (launchTimeMetrics != null)
        {
            launchTimeMetrics.thumbnailLoaded();
            view = viewgroup;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public int getViewTypeCount()
    {
        return TYPE_COUNT;
    }

    public void onTimelineChanged(final List timelineEntries)
    {
        activity.runOnUiThread(new Runnable() {

            final DividerAdapter this$0;
            final List val$timelineEntries;

            public void run()
            {
                DividerAdapter divideradapter = DividerAdapter.this;
                divideradapter;
                JVM INSTR monitorenter ;
                if (timelineEntries != null)
                {
                    break MISSING_BLOCK_LABEL_35;
                }
                DividerAdapter.this.timelineEntries = Collections.emptyList();
_L2:
                highlightedDividerIndex = -1;
                return;
                DividerAdapter.this.timelineEntries = timelineEntries;
                if (true) goto _L2; else goto _L1
_L1:
                Exception exception;
                exception;
                divideradapter;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = DividerAdapter.this;
                timelineEntries = list;
                super();
            }
        });
    }

    public void setDividerFactory(DividerViewFactory dividerviewfactory)
    {
        dividerFactory = dividerviewfactory;
    }

    public void setMediaItemCursorAdapter(MediaItemCursorAdapter mediaitemcursoradapter)
    {
        mediaItemCursorAdapter = mediaitemcursoradapter;
    }

}
