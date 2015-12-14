// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.fotoable.sketch.info.TTieZhiInfo;
import ew;
import java.util.List;
import kf;
import la;
import of;
import ol;
import om;
import on;
import oo;
import ou;
import oy;
import sb;
import ub;

public class TTieZhiCollectionView extends FrameLayout
{

    private oy lisener;
    Context mContext;
    public on mImageWorker;
    private LayoutInflater mInflater;
    private LinearLayout mLayout;
    List mListInfos;
    private HorizontalScrollView mScrollView;
    int mSelectIndex;
    ou mSelectedView;

    public TTieZhiCollectionView(Context context)
    {
        super(context);
        mContext = context;
        init();
    }

    public TTieZhiCollectionView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mContext = context;
        init();
    }

    public TTieZhiCollectionView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mContext = context;
        init();
    }

    private void downloadInfo(TTieZhiInfo ttiezhiinfo)
    {
        if (ttiezhiinfo == null)
        {
            return;
        } else
        {
            ol.a().a(ttiezhiinfo, new om() {

                final TTieZhiCollectionView a;

                public void a(TTieZhiInfo ttiezhiinfo1)
                {
                    if (a.lisener != null)
                    {
                        a.lisener.a();
                    }
                }

                public void a(TTieZhiInfo ttiezhiinfo1, float f)
                {
                }

                public void b(TTieZhiInfo ttiezhiinfo1)
                {
                    if (ttiezhiinfo1 != null)
                    {
                        oo.a().b(ttiezhiinfo1);
                        a.reloadData();
                        if (a.lisener != null)
                        {
                            oo.a().a(ttiezhiinfo1.resId);
                            a.lisener.a(ttiezhiinfo1, false);
                        }
                    }
                }

                public void c(TTieZhiInfo ttiezhiinfo1)
                {
                    if (a.lisener != null)
                    {
                        a.lisener.b(false);
                    }
                }

            
            {
                a = TTieZhiCollectionView.this;
                super();
            }
            });
            return;
        }
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030093, this, true);
        mInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
        mScrollView = (HorizontalScrollView)findViewById(0x7f0c0256);
        mScrollView.setHorizontalScrollBarEnabled(false);
        mScrollView.setVisibility(0);
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        mScrollView.addView(mLayout);
    }

    private void onItemViewCliked(TTieZhiInfo ttiezhiinfo, ou ou1)
    {
        if (mSelectedView != ou1)
        {
            if (mSelectedView != null)
            {
                mSelectedView.setSelected(false);
            }
            mSelectedView = ou1;
            mSelectedView.setSelected(true);
            mSelectIndex = mSelectedView.b();
        }
        scrollToVisableByIndex(getIndexByInfo(ttiezhiinfo));
        if (oo.a().b(ttiezhiinfo.resId))
        {
            ttiezhiinfo = oo.a().c(ttiezhiinfo.resId);
            if (lisener != null)
            {
                oo.a().a(ttiezhiinfo.resId);
                lisener.a(ttiezhiinfo, false);
            }
        } else
        if (mContext == null || !(new ub(mContext, ttiezhiinfo)).a())
        {
            downloadInfo(ttiezhiinfo);
            return;
        }
    }

    private void scrollBy(int i)
    {
        (new Handler()).postDelayed(new Runnable(i) {

            final int a;
            final TTieZhiCollectionView b;

            public void run()
            {
                b.mScrollView.scrollTo(a, 0);
            }

            
            {
                b = TTieZhiCollectionView.this;
                a = i;
                super();
            }
        }, 10L);
    }

    private void setShareTagByInfo(ImageView imageview, TTieZhiInfo ttiezhiinfo)
    {
        imageview.setVisibility(4);
        imageview.setImageResource(0x7f020262);
        imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        if (!oo.a().b(ttiezhiinfo.resId))
        {
            boolean flag;
            if (ttiezhiinfo.otherAppStoreId != null && !ttiezhiinfo.otherAppStoreId.equalsIgnoreCase("null") && ttiezhiinfo.otherAppStoreId.length() > 4 && !kf.a(getContext(), ttiezhiinfo.otherAppStoreId))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_START);
            imageview.setImageResource(0x7f02018c);
            imageview.setVisibility(0);
            if (ttiezhiinfo.needSharing && (new of(getContext())).b() && !la.a(ttiezhiinfo))
            {
                imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                imageview.setImageResource(0x7f020262);
                imageview.setVisibility(0);
            }
            if (ttiezhiinfo.needReviewing && !sb.c())
            {
                imageview.setVisibility(0);
                imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                imageview.setImageResource(0x7f020190);
            }
            if (flag)
            {
                imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                imageview.setImageResource(0x7f020045);
                imageview.setVisibility(0);
            }
        }
    }

    public int getIndexByInfo(TTieZhiInfo ttiezhiinfo)
    {
        if (ttiezhiinfo != null && mListInfos != null)
        {
            for (int i = 0; i < mListInfos.size(); i++)
            {
                TTieZhiInfo ttiezhiinfo1 = (TTieZhiInfo)mListInfos.get(i);
                if (ttiezhiinfo.resId == ttiezhiinfo1.resId)
                {
                    return i;
                }
            }

        }
        return 0;
    }

    public void reloadData()
    {
        int i = 0;
        do
        {
            try
            {
                if (i >= mListInfos.size())
                {
                    break;
                }
                ou ou1 = (ou)mLayout.getChildAt(i);
                ou1.a();
                if (i == mSelectIndex)
                {
                    if (mSelectedView != null)
                    {
                        mSelectedView.setSelected(false);
                    }
                    mSelectedView = ou1;
                    mSelectedView.setSelected(true);
                }
            }
            catch (Exception exception)
            {
                break;
            }
            i++;
        } while (true);
    }

    public void scrollToVisableByIndex(int i)
    {
        int j;
        int k;
        int l;
        int i1;
        int j1;
        if (i < 0)
        {
            return;
        }
        k = mScrollView.getScrollX();
        i1 = ew.a(getContext(), 56F);
        l = i1 * i;
        j = l + i1;
        j1 = mScrollView.getWidth();
        if (l > k) goto _L2; else goto _L1
_L1:
        j = l;
        if (i > 0)
        {
            j = l - i1;
        }
        mScrollView.scrollTo(j, 0);
_L4:
        scrollBy(j);
        return;
_L2:
        if (j >= k + j1)
        {
            k = j - j1;
            j = k;
            if (i < mListInfos.size() - 1)
            {
                j = k + i1;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (i > 0 && i < mListInfos.size() - 1)
        {
            i = l - i1;
            l = i1 + j;
            j = i;
            if (i < k)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (l > k + j1)
            {
                j = l - j1;
                continue; /* Loop/switch isn't completed */
            }
        }
        j = k;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setDataList(List list, int i)
    {
        if (list != null && i < list.size())
        {
            mListInfos = list;
            mLayout.removeAllViews();
            mSelectIndex = i;
            int j = 0;
            while (j < mListInfos.size()) 
            {
                list = new ou(this, getContext());
                list.a((TTieZhiInfo)mListInfos.get(j), j);
                if (j == mSelectIndex)
                {
                    list.setSelected(true);
                    mSelectedView = list;
                } else
                {
                    list.setSelected(false);
                }
                mLayout.addView(list);
                j++;
            }
            scrollToVisableByIndex(i);
        }
    }

    public void setImageWorker(on on)
    {
        mImageWorker = on;
    }

    public void setItemClickLisener(oy oy1)
    {
        lisener = oy1;
    }

    public void setSelectedIndex(int i)
    {
        if (i >= mListInfos.size() || mSelectIndex == i)
        {
            return;
        } else
        {
            mSelectIndex = i;
            reloadData();
            scrollToVisableByIndex(i);
            return;
        }
    }




}
