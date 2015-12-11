// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.pager.JazzyViewPager;
import com.aio.downloader.pager.OutlineContainer;
import com.aio.downloader.views.LImageButton;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.activity:
//            FunImagePagerActivity

private class ter extends PagerAdapter
{

    static final boolean $assertionsDisabled;
    private AdView adView;
    ArrayList list;
    final FunImagePagerActivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView(FunImagePagerActivity.access$2(FunImagePagerActivity.this).findViewFromObject(i));
    }

    public int getCount()
    {
        if (list == null || list.size() == 0)
        {
            return list.size();
        } else
        {
            return list.size();
        }
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        View view = FunImagePagerActivity.access$3(FunImagePagerActivity.this).inflate(0x7f030059, viewgroup, false);
        if (!$assertionsDisabled && view == null)
        {
            throw new AssertionError();
        } else
        {
            Log.e("qwer", "fdfdfdf");
            ImageView imageview = (ImageView)view.findViewById(0x7f070245);
            FunImagePagerActivity.access$4(FunImagePagerActivity.this, (LinearLayout)view.findViewById(0x7f070246));
            adView = new AdView(FunImagePagerActivity.this, AdSize.SMART_BANNER, "ca-app-pub-2192624499353475/1272210540");
            FunImagePagerActivity.access$5(FunImagePagerActivity.this).addView(adView);
            adView.loadAd(new AdRequest());
            Log.e("qwer", (new StringBuilder("adView=")).append(adView).toString());
            imageview.setOnClickListener(new android.view.View.OnClickListener() {

                final FunImagePagerActivity.MyPageAdapter this$1;

                public void onClick(View view1)
                {
                    if (FunImagePagerActivity.access$6(this$0).getVisibility() == 0)
                    {
                        FunImagePagerActivity.access$6(this$0).setVisibility(8);
                        FunImagePagerActivity.access$7(this$0).setVisibility(8);
                        FunImagePagerActivity.access$8(this$0).setVisibility(8);
                        FunImagePagerActivity.access$9(this$0).setVisibility(8);
                        FunImagePagerActivity.access$5(this$0).setVisibility(8);
                        return;
                    } else
                    {
                        FunImagePagerActivity.access$6(this$0).setVisibility(0);
                        FunImagePagerActivity.access$7(this$0).setVisibility(0);
                        FunImagePagerActivity.access$8(this$0).setVisibility(0);
                        FunImagePagerActivity.access$9(this$0).setVisibility(0);
                        FunImagePagerActivity.access$5(this$0).setVisibility(0);
                        return;
                    }
                }

            
            {
                this$1 = FunImagePagerActivity.MyPageAdapter.this;
                super();
            }
            });
            Log.e("picture", (new StringBuilder("++++++list.get(position)=")).append((String)list.get(i)).toString());
            FunImagePagerActivity.access$10(FunImagePagerActivity.this).asyncLoadImage1((String)list.get(i), imageview);
            ((JazzyViewPager)viewgroup).addView(view, -1, -1);
            FunImagePagerActivity.access$2(FunImagePagerActivity.this).setObjectForPosition(view, i);
            return view;
        }
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        if (!(view instanceof OutlineContainer)) goto _L2; else goto _L1
_L1:
        if (((OutlineContainer)view).getChildAt(0) != obj) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (view != obj)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    static 
    {
        boolean flag;
        if (!com/aio/downloader/activity/FunImagePagerActivity.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }


    public _cls1.this._cls1(ArrayList arraylist)
    {
        this$0 = FunImagePagerActivity.this;
        super();
        list = arraylist;
        FunImagePagerActivity.access$1(FunImagePagerActivity.this, getLayoutInflater());
    }
}
