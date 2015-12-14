// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            BannerAwareAdapter, GalleryBaseAdapter, DividerAdapter

public class BannerAwareDividerAdapter extends BannerAwareAdapter
{

    private MediaItemDao mediaItemDao;
    private final int numGridColumns;

    public BannerAwareDividerAdapter(DividerAdapter divideradapter, int i)
    {
        super(divideradapter);
        numGridColumns = i;
    }

    public List cursorToBannerMetadata(Cursor cursor)
    {
        return SQLiteDaoUtil.cursorToMediaItemsList(cursor, mediaItemDao);
    }

    public int getGridItemIndexForLayoutFocus(int i)
    {
        boolean flag = false;
        int j = numGridColumns - 1;
        do
        {
label0:
            {
                int k = ((flag) ? 1 : 0);
                if (j >= 0)
                {
                    k = getMediaItemIndex(j + 1);
                    if (k < 0)
                    {
                        break label0;
                    }
                }
                if (i >= 0 && i <= k)
                {
                    return 0;
                } else
                {
                    return delegateAdapter.getGridItemIndexForLayoutFocus(i) + 1;
                }
            }
            j--;
        } while (true);
    }

    public int getMediaItemIndex(int i)
    {
        if (i == 0)
        {
            return -1;
        } else
        {
            return delegateAdapter.getMediaItemIndex(i - 1);
        }
    }

    public void onTimelineChanged(List list)
    {
        delegateAdapter.onTimelineChanged(list);
    }

    public void setMediaItemDao(MediaItemDao mediaitemdao)
    {
        mediaItemDao = mediaitemdao;
    }
}
