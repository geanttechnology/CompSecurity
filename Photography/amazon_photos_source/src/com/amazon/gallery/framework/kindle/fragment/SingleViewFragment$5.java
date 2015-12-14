// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.view.android.SingleViewMediaPlayerManager;
import com.amazon.gallery.framework.gallery.widget.MediaItemCursorAdapter;
import com.amazon.gallery.framework.gallery.widget.ThumbnailSizeLookUp;
import com.amazon.gallery.framework.glide.GlideWrapper;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.thor.albums.AlbumPageTracker;
import com.amazon.gallery.thor.albums.ListChildrenTask;
import uk.co.senab.photoview.PhotoView;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SingleViewFragment

class finished extends android.support.v4.view.eChangeListener
{

    private boolean finished;
    final SingleViewFragment this$0;
    private final int visibleThreshold = 10;

    public void onPageScrollStateChanged(int i)
    {
        if (!SingleViewFragment.access$300(SingleViewFragment.this)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            MediaItem mediaitem = mMediaItemCursorAdapter.getItem(SingleViewFragment.access$000(SingleViewFragment.this).getCurrentItem());
            if (SingleViewFragment.access$1400(SingleViewFragment.this, mediaitem) && MediaType.VIDEO != mediaitem.getType())
            {
                SingleViewFragment.access$100(SingleViewFragment.this).onFocusedGained(mediaitem);
            }
            if (!isInFullScreen())
            {
                enterFullScreen();
                return;
            }
            break;

        case 1: // '\001'
            SingleViewFragment.access$100(SingleViewFragment.this).onFocusedLost();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onPageSelected(final int position)
    {
        ViewDescriptor viewdescriptor = contentConfiguration.toViewDescriptor();
        int i = viewdescriptor.getFocusedIndex();
        final MediaItem mediaItem = SingleViewFragment.access$800(SingleViewFragment.this, i);
        if (mediaItem != null)
        {
            mediaItem.setScale(1.0F);
        }
        mediaItem = mMediaItemCursorAdapter.getItem(position);
        viewdescriptor.setFocusedIndex(position);
        viewdescriptor.setMediaItem(mediaItem.getObjectId());
        if (viewdescriptor.getCollectionType() == com.amazon.gallery.framework.gallery.view.tionType.DYNAMIC_ALBUM)
        {
            com.amazon.gallery.framework.model.tags.Tag tag = viewdescriptor.getTag();
            if (tag != null)
            {
                AlbumPageTracker albumpagetracker = AlbumPageTracker.getInstance();
                if (!finished && !albumpagetracker.isLoading() && position + 10 > SingleViewFragment.access$900(SingleViewFragment.this).getCount())
                {
                    viewdescriptor.setCollectionSize(albumpagetracker.getTotalItems());
                    if (albumpagetracker.getCurrentItems() < albumpagetracker.getTotalItems())
                    {
                        ListChildrenTask.executeWithOffset(tag, albumpagetracker.getCurrentItems());
                    } else
                    {
                        finished = true;
                    }
                }
            }
        } else
        {
            viewdescriptor.setCollectionSize(SingleViewFragment.access$900(SingleViewFragment.this).getCount());
        }
        SingleViewFragment.access$1000(SingleViewFragment.this, mediaItem);
        updateHeaderOptions(mediaItem);
        SingleViewFragment.access$1102(SingleViewFragment.this, 1.0F);
        SingleViewFragment.access$1200(SingleViewFragment.this).removeCallbacksAndMessages(null);
        SingleViewFragment.access$1200(SingleViewFragment.this).postDelayed(new Runnable() {

            final SingleViewFragment._cls5 this$1;
            final MediaItem val$mediaItem;
            final int val$position;

            public void run()
            {
                PhotoView photoview = SingleViewFragment.access$800(this$0, position);
                if (photoview != null)
                {
                    android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
                    if (fragmentactivity != null)
                    {
                        GlideWrapper.loadFullQualityImage(fragmentactivity, mediaItem, photoview, SingleViewFragment.access$1300(this$0).getWidth(position), SingleViewFragment.access$1300(this$0).getHeight(position));
                    }
                }
            }

            
            {
                this$1 = SingleViewFragment._cls5.this;
                position = i;
                mediaItem = mediaitem;
                super();
            }
        }, 750L);
    }

    _cls1.val.mediaItem()
    {
        this$0 = SingleViewFragment.this;
        super();
        finished = false;
    }
}
