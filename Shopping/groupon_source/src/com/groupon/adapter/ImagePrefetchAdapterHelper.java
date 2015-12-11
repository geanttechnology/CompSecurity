// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.widget.ListAdapter;
import com.groupon.models.HasLargeImageUrl;
import com.groupon.util.ImageUrl;
import com.groupon.view.HasImageView;
import com.groupon.view.UrlImageView;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class ImagePrefetchAdapterHelper
{

    public ImagePrefetchAdapterHelper()
    {
    }

    public void prefetchNextImage(ListAdapter listadapter, int i, HasImageView hasimageview)
    {
label0:
        {
            if (i + 1 < listadapter.getCount())
            {
                listadapter = ((ListAdapter) (listadapter.getItem(i + 1)));
                if (!(listadapter instanceof HasLargeImageUrl))
                {
                    break label0;
                }
                listadapter = ((HasLargeImageUrl)listadapter).getImageUrl();
                if (Strings.notEmpty(listadapter.getUrl()) && hasimageview != null)
                {
                    hasimageview.getImageView().prefetch(listadapter);
                }
            }
            return;
        }
        Ln.d("Prefetching doesn't work with pojos like %s as it does not implement com.groupon.models.HasImageUrl", new Object[] {
            listadapter
        });
    }
}
