// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPMedia;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYButton;
import com.bestbuy.android.bbyobjects.ProductImageGallery;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import km;

public class PDPImageGalleryFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, km
{

    private Activity a;
    private OverviewResponse b;
    private View c;
    private FrameLayout g;
    private FrameLayout h;
    private BBYButton i;
    private BBYButton j;
    private LinearLayout k;
    private ArrayList l;

    public PDPImageGalleryFragment()
    {
    }

    public PDPImageGalleryFragment(OverviewResponse overviewresponse)
    {
        b = overviewresponse;
    }

    private void b()
    {
        Object obj = new LinkedHashSet();
        if (b == null || b.getMedia() == null) goto _L2; else goto _L1
_L1:
        if (b.getMedia().getPrimaryImage() == null) goto _L4; else goto _L3
_L3:
        if (b.getMedia().getPrimaryImage().getUrl() == null || b.getMedia().getPrimaryImage().getUrl().isEmpty()) goto _L6; else goto _L5
_L5:
        ((Set) (obj)).add(b.getMedia().getPrimaryImage().getUrl());
_L4:
        if (b.getMedia().getGalleryImages() != null && b.getMedia().getGalleryImages().size() > 0)
        {
            int i1 = 0;
            do
            {
                if (i1 >= b.getMedia().getGalleryImages().size())
                {
                    break;
                }
                if (((MediaImage)b.getMedia().getGalleryImages().get(i1)).getUrl() != null && !((MediaImage)b.getMedia().getGalleryImages().get(i1)).getUrl().isEmpty())
                {
                    ((Set) (obj)).add(((MediaImage)b.getMedia().getGalleryImages().get(i1)).getUrl());
                } else
                if (((MediaImage)b.getMedia().getGalleryImages().get(i1)).getPath() != null && !((MediaImage)b.getMedia().getGalleryImages().get(i1)).getPath().isEmpty())
                {
                    ((Set) (obj)).add((new StringBuilder()).append("http://pisces.bbystatic.com/image2/").append(((MediaImage)b.getMedia().getGalleryImages().get(i1)).getPath()).append(";canvasHeight=").append(500).append(";canvasWidth=").append(500).toString());
                }
                i1++;
            } while (true);
        }
          goto _L2
_L6:
        if (b.getMedia().getPrimaryImage().getPath() != null && !b.getMedia().getPrimaryImage().getPath().isEmpty())
        {
            ((Set) (obj)).add((new StringBuilder()).append("http://pisces.bbystatic.com/image2/").append(b.getMedia().getPrimaryImage().getPath()).append(";canvasHeight=").append(500).append(";canvasWidth=").append(500).toString());
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (obj != null && !((Set) (obj)).isEmpty())
        {
            ProductImageGallery productimagegallery = (ProductImageGallery)c.findViewById(0x7f0c022a);
            obj = new ArrayList(((java.util.Collection) (obj)));
            productimagegallery.a(a, ((List) (obj)), null);
            return;
        }
        c.findViewById(0x7f0c022a).setVisibility(8);
        ImageView imageview = (ImageView)c.findViewById(0x7f0c022b);
        imageview.setVisibility(0);
        imageview.setImageResource(0x7f020130);
        return;
        if (true) goto _L4; else goto _L7
_L7:
    }

    public void a(int i1)
    {
        if (l != null && !l.isEmpty())
        {
            Uri uri = Uri.parse(((com.bestbuy.android.api.lib.models.product.Product.Video)((com.bestbuy.android.api.lib.models.product.Product.ProductVideos)l.get(i1)).getVideos().get(0)).getUrl());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uri, "video/*");
            a.startActivity(intent);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
    }

    public void onClick(View view)
    {
        if (view == j)
        {
            h.setVisibility(0);
            g.setVisibility(8);
        } else
        if (view == i)
        {
            g.setVisibility(0);
            h.setVisibility(8);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        c = layoutinflater.inflate(0x7f03008f, viewgroup, false);
        i = (BBYButton)c.findViewById(0x7f0c0227);
        j = (BBYButton)c.findViewById(0x7f0c0228);
        g = (FrameLayout)c.findViewById(0x7f0c0229);
        h = (FrameLayout)c.findViewById(0x7f0c022c);
        k = (LinearLayout)c.findViewById(0x7f0c0226);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        b();
        return c;
    }

    public void onResume()
    {
        super.onResume();
    }
}
