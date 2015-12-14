// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.widget.DividerViewFactory;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            GalleryBaseAdapter, DividerAdapter, BannerAwareDividerAdapter, ViewFactory, 
//            MediaItemCursorAdapter

public class MediaItemProxyAdapter extends GalleryBaseAdapter
{

    private final BannerAwareDividerAdapter bannerDividerAdapter;
    private final DividerAdapter dividerAdapter;
    private boolean hasBannerSupport;

    public MediaItemProxyAdapter(BeanAwareActivity beanawareactivity)
    {
        dividerAdapter = new DividerAdapter(beanawareactivity);
        bannerDividerAdapter = new BannerAwareDividerAdapter(dividerAdapter, beanawareactivity.getResources().getInteger(0x7f0d0001));
        bannerDividerAdapter.setMediaItemDao((MediaItemDao)beanawareactivity.getApplicationBean(Keys.MEDIA_ITEM_DAO));
    }

    public int getCount()
    {
        if (hasBannerSupport)
        {
            return bannerDividerAdapter.getCount();
        } else
        {
            return dividerAdapter.getCount();
        }
    }

    public int getGridItemIndexForLayoutFocus(int i)
    {
        if (hasBannerSupport)
        {
            return bannerDividerAdapter.getGridItemIndexForLayoutFocus(i);
        } else
        {
            return dividerAdapter.getGridItemIndexForLayoutFocus(i);
        }
    }

    public Object getItem(int i)
    {
        if (hasBannerSupport)
        {
            return bannerDividerAdapter.getItem(i);
        } else
        {
            return dividerAdapter.getItem(i);
        }
    }

    public long getItemId(int i)
    {
        if (hasBannerSupport)
        {
            return bannerDividerAdapter.getItemId(i);
        } else
        {
            return dividerAdapter.getItemId(i);
        }
    }

    public int getItemViewType(int i)
    {
        if (hasBannerSupport)
        {
            return bannerDividerAdapter.getItemViewType(i);
        } else
        {
            return dividerAdapter.getItemViewType(i);
        }
    }

    public int getMediaItemIndex(int i)
    {
        if (hasBannerSupport)
        {
            return bannerDividerAdapter.getMediaItemIndex(i);
        } else
        {
            return dividerAdapter.getMediaItemIndex(i);
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (hasBannerSupport)
        {
            return bannerDividerAdapter.getView(i, view, viewgroup);
        } else
        {
            return dividerAdapter.getView(i, view, viewgroup);
        }
    }

    public void notifyDataSetChanged()
    {
        if (hasBannerSupport)
        {
            bannerDividerAdapter.notifyDataSetChanged();
            return;
        } else
        {
            dividerAdapter.notifyDataSetChanged();
            return;
        }
    }

    public void onBannerMetadataChanged(Cursor cursor)
    {
        if (!hasBannerSupport)
        {
            return;
        } else
        {
            bannerDividerAdapter.setBannerMetadata(bannerDividerAdapter.cursorToBannerMetadata(cursor));
            return;
        }
    }

    public void onTimelineChanged(List list)
    {
        if (hasBannerSupport)
        {
            bannerDividerAdapter.onTimelineChanged(list);
            return;
        } else
        {
            dividerAdapter.onTimelineChanged(list);
            return;
        }
    }

    public void setBannerViewFactory(ViewFactory viewfactory)
    {
        bannerDividerAdapter.setBannerViewFactory(viewfactory);
    }

    public void setGridItemCursorAdapter(MediaItemCursorAdapter mediaitemcursoradapter)
    {
        dividerAdapter.setMediaItemCursorAdapter(mediaitemcursoradapter);
    }

    public void setGridItemViewFactory(DividerViewFactory dividerviewfactory)
    {
        dividerAdapter.setDividerFactory(dividerviewfactory);
    }

    public void setHasBannerSupport(boolean flag)
    {
        hasBannerSupport = flag;
    }
}
