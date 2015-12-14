// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.albums.CreateAlbumHelper;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

public class NoAlbumsFragment extends Fragment
{

    public NoAlbumsFragment()
    {
    }

    private void loadImage(int i, int j, View view)
    {
        view = (ImageView)view.findViewById(i);
        Glide.with(this).load(Integer.valueOf(j)).into(view);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (viewgroup == null)
        {
            return null;
        } else
        {
            layoutinflater = layoutinflater.inflate(0x7f0300b3, viewgroup, false);
            viewgroup = (RelativeLayout)layoutinflater.findViewById(0x7f0c0150);
            ((TextView)layoutinflater.findViewById(0x7f0c0153)).setVisibility(0);
            viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

                final NoAlbumsFragment this$0;

                public void onClick(View view)
                {
                    startActivity(IntentUtil.getCollectionListIntent(TagType.FOLDER));
                }

            
            {
                this$0 = NoAlbumsFragment.this;
                super();
            }
            });
            ((Button)layoutinflater.findViewById(0x7f0c0196)).setOnClickListener(new android.view.View.OnClickListener() {

                final NoAlbumsFragment this$0;

                public void onClick(View view)
                {
                    view = new ComponentProfiler((Profiler)ThorGalleryApplication.getBean(Keys.PROFILER), "AlbumsMetrics");
                    (new CreateAlbumHelper((BeanAwareActivity)getActivity(), view)).execute();
                }

            
            {
                this$0 = NoAlbumsFragment.this;
                super();
            }
            });
            loadImage(0x7f0c0192, 0x7f0201d2, layoutinflater);
            loadImage(0x7f0c0194, 0x7f0201d3, layoutinflater);
            loadImage(0x7f0c0195, 0x7f0201d4, layoutinflater);
            return layoutinflater;
        }
    }
}
