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

class val.position
    implements android.view.er
{

    final is._cls0 this$1;
    final int val$position;

    public void onClick(View view)
    {
        ((Activity)DealImageView.access$100(_fld0)).startActivityForResult(DealImageView.access$600(_fld0).newDealImageCarouselIntent((ArrayList)DealImageView.access$200(_fld0), val$position, DealImageView.access$300(_fld0), DealImageView.access$400(_fld0), DealImageView.access$500(_fld0)), 10149);
    }

    r()
    {
        this$1 = final_r;
        val$position = I.this;
        super();
    }

    // Unreferenced inner class com/groupon/view/DealImageView$1

/* anonymous class */
    class DealImageView._cls1 extends PagerAdapter
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

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            UrlImageView urlimageview = new UrlImageView(DealImageView.access$100(DealImageView.this));
            urlimageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            ImageUrl imageurl = (ImageUrl)DealImageView.access$200(DealImageView.this).get(i);
            Ln.d("PAGER: instantiate %s: %s", new Object[] {
                Integer.valueOf(i), urlimageview
            });
            if (callback != null)
            {
                urlimageview.setCallback(callback);
            }
            urlimageview.setImageUrl(imageurl);
            urlimageview.setOnClickListener(i. new DealImageView._cls1._cls1());
            urlimageview.setOnTouchListener(new DealImageView.OnDealImageViewTouchListener(DealImageView.this, null));
            viewgroup.addView(urlimageview, 0);
            return urlimageview;
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            return view == obj;
        }

            
            {
                this$0 = final_dealimageview;
                callback = Callback.this;
                super();
            }
    }

}
