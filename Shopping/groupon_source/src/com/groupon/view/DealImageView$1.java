// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.groupon.activity.IntentFactory;
import com.groupon.util.ImageUrl;
import com.squareup.picasso.Callback;
import java.util.ArrayList;
import java.util.List;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.view:
//            DealImageView, UrlImageView

class ter extends PagerAdapter
{

    final DealImageView this$0;
    final Callback val$callback;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        obj = (View)obj;
        Ln.d("PAGER: destroy %s: %s", new Object[] {
            Integer.valueOf(i), obj
        });
        ((UrlImageView)obj).clearImage();
        viewgroup.removeView(((View) (obj)));
    }

    public int getCount()
    {
        return DealImageView.access$000(DealImageView.this);
    }

    public Object instantiateItem(ViewGroup viewgroup, final int position)
    {
        UrlImageView urlimageview = new UrlImageView(DealImageView.access$100(DealImageView.this));
        urlimageview.setScaleType(android.widget.ype.CENTER_CROP);
        ImageUrl imageurl = (ImageUrl)DealImageView.access$200(DealImageView.this).get(position);
        Ln.d("PAGER: instantiate %s: %s", new Object[] {
            Integer.valueOf(position), urlimageview
        });
        if (val$callback != null)
        {
            urlimageview.setCallback(val$callback);
        }
        urlimageview.setImageUrl(imageurl);
        urlimageview.setOnClickListener(new android.view.View.OnClickListener() {

            final DealImageView._cls1 this$1;
            final int val$position;

            public void onClick(View view)
            {
                ((Activity)DealImageView.access$100(this$0)).startActivityForResult(DealImageView.access$600(this$0).newDealImageCarouselIntent((ArrayList)DealImageView.access$200(this$0), position, DealImageView.access$300(this$0), DealImageView.access$400(this$0), DealImageView.access$500(this$0)), 10149);
            }

            
            {
                this$1 = DealImageView._cls1.this;
                position = i;
                super();
            }
        });
        urlimageview.setOnTouchListener(new DealImageViewTouchListener(DealImageView.this, null));
        viewgroup.addView(urlimageview, 0);
        return urlimageview;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }

    _cls1.val.position()
    {
        this$0 = final_dealimageview;
        val$callback = Callback.this;
        super();
    }
}
