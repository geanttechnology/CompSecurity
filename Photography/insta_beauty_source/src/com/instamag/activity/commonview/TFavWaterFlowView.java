// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import azp;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import zt;

public class TFavWaterFlowView extends ScrollView
    implements android.view.View.OnTouchListener
{

    private static Handler handler = new azp();
    private static int lastScrollY = -1;
    private static View scrollLayout;
    private static int scrollViewHeight;
    private String TAG;
    private int columnWidth;
    private List favItems;
    private LinearLayout firstColumn;
    private int firstColumnHeight;
    private List imageViewList;
    private zt imgWorker;
    private boolean loadOnce;
    private LinearLayout secondColumn;
    private int secondColumnHeight;

    public TFavWaterFlowView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TAG = "TFavWaterFlowView";
        imageViewList = new ArrayList();
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030130, this, true);
        firstColumn = (LinearLayout)findViewById(0x7f0d045f);
        secondColumn = (LinearLayout)findViewById(0x7f0d0460);
        scrollViewHeight = getHeight();
        scrollLayout = getChildAt(0);
        columnWidth = firstColumn.getWidth();
        Log.d(TAG, (new StringBuilder()).append(TAG).append(" scrollViewHeight:").append(scrollViewHeight).toString());
        Log.d(TAG, (new StringBuilder()).append(TAG).append(" scrollLayout height:").append(scrollLayout.getHeight()).toString());
        Log.d(TAG, (new StringBuilder()).append(TAG).append(" columnWidth:").append(columnWidth).toString());
        setOnTouchListener(this);
    }

    private void addImage(ImageView imageview, int i, int j)
    {
        LinearLayout linearlayout = findColumnToAdd(imageview, j);
        if (linearlayout != null)
        {
            linearlayout.addView(imageview);
            imageViewList.add(imageview);
        }
    }

    private LinearLayout findColumnToAdd(ImageView imageview, int i)
    {
        if (firstColumnHeight <= secondColumnHeight)
        {
            imageview.setTag(0x7f060096, Integer.valueOf(firstColumnHeight));
            firstColumnHeight = firstColumnHeight + i;
            imageview.setTag(0x7f060095, Integer.valueOf(firstColumnHeight));
            return firstColumn;
        } else
        {
            imageview.setTag(0x7f060096, Integer.valueOf(secondColumnHeight));
            secondColumnHeight = secondColumnHeight + i;
            imageview.setTag(0x7f060095, Integer.valueOf(secondColumnHeight));
            return secondColumn;
        }
    }

    private List randomList(List list)
    {
        if (list == null)
        {
            return list;
        }
        ArrayList arraylist = new ArrayList(list.size());
        Random random = new Random();
        int i;
        for (; list.size() > 0; list.remove(i))
        {
            i = random.nextInt(list.size());
            arraylist.add(list.get(i));
        }

        return arraylist;
    }

    public void checkVisibility()
    {
        int i = 0;
        while (i < imageViewList.size()) 
        {
            ImageView imageview = (ImageView)imageViewList.get(i);
            int j = ((Integer)imageview.getTag(0x7f060096)).intValue();
            if (((Integer)imageview.getTag(0x7f060095)).intValue() > getScrollY() && j < getScrollY() + scrollViewHeight)
            {
                if (imgWorker != null)
                {
                    Object obj = (Integer)imageview.getTag();
                    obj = (TResInfo)favItems.get(((Integer) (obj)).intValue());
                    imgWorker.a(obj, imageview);
                }
            } else
            {
                imageview.setImageBitmap(null);
            }
            i++;
        }
    }

    public int getImageViewHeightByType(InstaMagType instamagtype)
    {
        int j = getImgaeViewWidth();
        int i;
        if (instamagtype == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            i = (int)(((float)j / 2.0F) * 3F);
        } else
        {
            if (instamagtype == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
            {
                return (int)(((float)j / 320F) * 214F);
            }
            i = j;
            if (instamagtype != InstaMagType.SQ_LIB_SIZE_TYPE)
            {
                if (instamagtype == InstaMagType.LINK_LIB_SIZE_TYPE)
                {
                    return (int)(((float)j / 2.0F) * 3F);
                } else
                {
                    return 0;
                }
            }
        }
        return i;
    }

    public int getImgaeViewWidth()
    {
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        return (int)((float)displaymetrics.widthPixels - displaymetrics.density * 90F) / 2;
    }

    public void loadFavItems(List list)
    {
        favItems = randomList(list);
        for (int i = 0; i < favItems.size(); i++)
        {
            list = (TResInfo)favItems.get(i);
            InstaMagType instamagtype = TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)list);
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(getImgaeViewWidth(), getImageViewHeightByType(instamagtype));
            layoutparams.gravity = 17;
            ImageView imageview = new ImageView(getContext());
            imageview.setLayoutParams(layoutparams);
            imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            imageview.setTag(Integer.valueOf(i));
            if (imgWorker != null)
            {
                imgWorker.a(list, imageview);
            }
            addImage(imageview, getImgaeViewWidth(), getImageViewHeightByType(instamagtype));
        }

    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        scrollViewHeight = getHeight();
        scrollLayout = getChildAt(0);
        columnWidth = firstColumn.getWidth();
        Log.d(TAG, (new StringBuilder()).append(TAG).append(" 2scrollViewHeight:").append(scrollViewHeight).toString());
        Log.d(TAG, (new StringBuilder()).append(TAG).append(" 2scrollLayout height:").append(scrollLayout.getHeight()).toString());
        Log.d(TAG, (new StringBuilder()).append(TAG).append(" 2columnWidth:").append(columnWidth).toString());
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            view = new Message();
            view.obj = this;
            handler.sendMessageDelayed(view, 5L);
        }
        return false;
    }

    public void setImageWorker(zt zt1)
    {
        imgWorker = zt1;
    }




/*
    public static int access$002(int i)
    {
        lastScrollY = i;
        return i;
    }

*/

}
