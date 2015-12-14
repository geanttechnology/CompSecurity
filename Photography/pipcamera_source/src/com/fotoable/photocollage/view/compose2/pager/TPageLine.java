// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2.pager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.fotoable.photocollage.model.res.collage.TPhotoCollageComposeInfo;
import com.fotoable.photocollage.view.compose2.StatusImageView;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TFrameItemInfo;
import com.wantu.model.res.TPhotoFreeComposeStyleInfo;
import com.wantu.model.res.TPhotoFreeFrameLayoutInfo;
import com.wantu.model.res.TResInfo;
import ew;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mi;
import mr;

public class TPageLine extends LinearLayout
{

    List itemViewList;
    mi listener;
    HashMap viewMapBitmap;

    public TPageLine(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        itemViewList = new ArrayList();
        viewMapBitmap = new HashMap();
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300a8, this, false);
    }

    public static mr calcLineItem(int i, int j, int k, float f)
    {
        j = (int)((float)(i - ((int)((float)i / ((float)j * f)) + 1) * k) / ((float)j * f));
        i = (i - (j + 1) * k) / j;
        int l = (int)((float)i / f);
        mr mr1 = new mr();
        mr1.d(j);
        mr1.a(i);
        mr1.b(l);
        mr1.c(k);
        return mr1;
    }

    public static mr calcLineItem(Context context, int i, int j)
    {
        int k = ew.a(context);
        i = (k - (k / i + 1) * j) / i;
        j = (k - (i + 1) * j) / i;
        context = new mr();
        context.d(i);
        context.a(j);
        context.b(j);
        return context;
    }

    public static mr calcLineItem(Context context, int i, int j, float f)
    {
        int k = ew.a(context);
        i = (k - (k / i + 1) * j) / i;
        j = (k - (i + 1) * j) / i;
        k = (int)((float)j * f);
        context = new mr();
        context.d(i);
        context.a(k);
        context.b(j);
        return context;
    }

    private void itemWithData(StatusImageView statusimageview, TResInfo tresinfo, boolean flag)
    {
        float f;
        f = 0.75F;
        statusimageview.setTag(tresinfo);
        if (!(tresinfo instanceof TFrameItemInfo)) goto _L2; else goto _L1
_L1:
        TFrameItemInfo tframeiteminfo = (TFrameItemInfo)tresinfo;
        if (tframeiteminfo.icon == null)
        {
            statusimageview.setBackgroundColor(tframeiteminfo.getBgColor());
        } else
        {
            clearItem(statusimageview);
            Bitmap bitmap = tresinfo.getIconBitmap();
            statusimageview.setImageBitmap(bitmap);
            viewMapBitmap.put(statusimageview, bitmap);
        }
_L4:
        statusimageview.setIsSelected(flag);
        statusimageview.setTag(tresinfo);
        statusimageview.setVisibility(0);
        return;
_L2:
        if (tresinfo instanceof TPhotoCollageComposeInfo)
        {
            TPhotoCollageComposeInfo tphotocollagecomposeinfo = (TPhotoCollageComposeInfo)tresinfo;
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)statusimageview.getLayoutParams();
            float f1 = layoutparams.height;
            if (tphotocollagecomposeinfo.getAspectRatio() <= 1.0F)
            {
                f = 1.0F;
            }
            layoutparams.width = (int)(f * f1);
            layoutparams.gravity = 17;
            if (tphotocollagecomposeinfo.icon != null)
            {
                clearItem(statusimageview);
                Bitmap bitmap1 = tresinfo.getIconBitmap();
                statusimageview.setImageBitmap(bitmap1);
                statusimageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                viewMapBitmap.put(statusimageview, bitmap1);
            }
        } else
        if (tresinfo instanceof TPhotoFreeFrameLayoutInfo)
        {
            TPhotoFreeFrameLayoutInfo tphotofreeframelayoutinfo = (TPhotoFreeFrameLayoutInfo)tresinfo;
            android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)statusimageview.getLayoutParams();
            float f2 = layoutparams1.height;
            if (!tphotofreeframelayoutinfo.isRect)
            {
                f = 1.0F;
            }
            layoutparams1.width = (int)(f * f2);
            layoutparams1.gravity = 17;
            if (tphotofreeframelayoutinfo.icon != null)
            {
                clearItem(statusimageview);
                Bitmap bitmap2 = tresinfo.getIconBitmap();
                statusimageview.setImageBitmap(bitmap2);
                viewMapBitmap.put(statusimageview, bitmap2);
            }
        } else
        {
            clearItem(statusimageview);
            Bitmap bitmap3 = tresinfo.getIconBitmap();
            statusimageview.setImageBitmap(bitmap3);
            if ((tresinfo instanceof TPhotoFreeComposeStyleInfo) && tresinfo.getResType() == EResType.ONLINE)
            {
                statusimageview.setOnline(true);
                statusimageview.setOnlineIconBitmap(BitmapFactory.decodeResource(getResources(), 0x7f02018c));
            } else
            {
                statusimageview.setOnline(false);
            }
            viewMapBitmap.put(statusimageview, bitmap3);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void clear()
    {
        for (Iterator iterator = itemViewList.iterator(); iterator.hasNext(); clearItem((StatusImageView)iterator.next())) { }
    }

    protected void clearItem(StatusImageView statusimageview)
    {
        Bitmap bitmap = (Bitmap)viewMapBitmap.get(statusimageview);
        if (bitmap != null)
        {
            statusimageview.setImageBitmap(null);
            viewMapBitmap.remove(statusimageview);
            bitmap.recycle();
        }
    }

    public void setItemData(int i, TResInfo tresinfo, boolean flag)
    {
        StatusImageView statusimageview = (StatusImageView)itemViewList.get(i);
        try
        {
            itemWithData(statusimageview, tresinfo, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TResInfo tresinfo)
        {
            tresinfo.printStackTrace();
        }
    }

    public void setItemSelect(TResInfo tresinfo, boolean flag)
    {
        for (Iterator iterator = itemViewList.iterator(); iterator.hasNext(); setItemSelecte((StatusImageView)iterator.next(), tresinfo, flag)) { }
    }

    public void setItemSelectListener(mi mi)
    {
        listener = mi;
    }

    protected void setItemSelecte(StatusImageView statusimageview, TResInfo tresinfo, boolean flag)
    {
        if (statusimageview.getTag() == null) goto _L2; else goto _L1
_L1:
        Object obj = (TResInfo)statusimageview.getTag();
        if (((TResInfo) (obj)).name != null && tresinfo.name != null) goto _L4; else goto _L3
_L3:
        if (!(obj instanceof TPhotoFreeComposeStyleInfo) || !(tresinfo instanceof TPhotoFreeComposeStyleInfo)) goto _L6; else goto _L5
_L5:
        obj = (TPhotoFreeComposeStyleInfo)obj;
        tresinfo = (TPhotoFreeComposeStyleInfo)tresinfo;
        if (((TPhotoFreeComposeStyleInfo) (obj)).uid == ((TPhotoFreeComposeStyleInfo) (tresinfo)).uid)
        {
            statusimageview.setIsSelected(flag);
        }
_L2:
        return;
_L6:
        if (!(obj instanceof TPhotoFreeFrameLayoutInfo) || !(tresinfo instanceof TPhotoFreeFrameLayoutInfo))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (TPhotoFreeFrameLayoutInfo)obj;
        tresinfo = (TPhotoFreeFrameLayoutInfo)tresinfo;
        if (((TPhotoFreeFrameLayoutInfo) (obj)).name.compareTo(((TPhotoFreeFrameLayoutInfo) (tresinfo)).name) == 0)
        {
            statusimageview.setIsSelected(flag);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (!(obj instanceof TFrameItemInfo) || !(tresinfo instanceof TFrameItemInfo)) goto _L2; else goto _L7
_L7:
        Log.v("TAG", "TFrameItemInfo");
        return;
_L4:
        if (((TResInfo) (obj)).name.compareTo(tresinfo.getName()) == 0)
        {
            statusimageview.setIsSelected(flag);
            return;
        }
        if (true) goto _L2; else goto _L8
_L8:
    }

    public void setView(int i, int j, float f, boolean flag)
    {
        mr mr1 = calcLineItem(getContext(), i, j, f);
        for (i = 0; i < mr1.c(); i++)
        {
            Object obj1 = new FrameLayout(getContext());
            Object obj = new android.widget.LinearLayout.LayoutParams(-1, 3);
            obj.weight = 1.0F;
            obj.height = ew.a(getContext(), mr1.b());
            addView(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj)));
            obj = new FrameLayout(getContext());
            Object obj2 = new android.widget.LinearLayout.LayoutParams(-1, 3);
            obj2.width = -1;
            obj2.height = -1;
            ((FrameLayout) (obj1)).addView(((View) (obj)), ((android.view.ViewGroup.LayoutParams) (obj2)));
            obj1 = new StatusImageView(getContext(), null);
            obj2 = new android.widget.FrameLayout.LayoutParams(-1, 17);
            obj2.height = ew.a(getContext(), mr1.b());
            obj2.width = ew.a(getContext(), mr1.a());
            obj2.gravity = 17;
            if (flag)
            {
                ((StatusImageView) (obj1)).setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                ((StatusImageView) (obj1)).setFix(true);
            }
            ((FrameLayout) (obj)).addView(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj2)));
            obj2 = new ProgressBar(getContext(), null, 0x1010079);
            ((ProgressBar) (obj2)).setVisibility(4);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, 17);
            layoutparams.height = ew.a(getContext(), mr1.b() / 2);
            layoutparams.width = ew.a(getContext(), mr1.a() / 2);
            layoutparams.gravity = 17;
            ((FrameLayout) (obj)).addView(((View) (obj2)), layoutparams);
            ((StatusImageView) (obj1)).setVisibility(4);
            itemViewList.add(obj1);
            ((StatusImageView) (obj1)).setOnClickListener(new android.view.View.OnClickListener(((ProgressBar) (obj2)), ((StatusImageView) (obj1))) {

                final ProgressBar a;
                final StatusImageView b;
                final TPageLine c;

                public void onClick(View view)
                {
                    view = ((View) (view.getTag()));
                    if (view != null)
                    {
                        view = (TResInfo)view;
                        if (c.listener != null)
                        {
                            if ((view instanceof TPhotoFreeComposeStyleInfo) && view.getResType() == EResType.ONLINE)
                            {
                                a.setVisibility(0);
                                b.setEnabled(false);
                            }
                            c.listener.resItemSelected(view);
                        }
                    }
                }

            
            {
                c = TPageLine.this;
                a = progressbar;
                b = statusimageview;
                super();
            }
            });
        }

    }

    public void setView(int i, int j, int k, float f, boolean flag)
    {
        mr mr1 = calcLineItem(i, j, k, f);
        for (i = 0; i < mr1.c(); i++)
        {
            Object obj1 = new FrameLayout(getContext());
            Object obj = new android.widget.LinearLayout.LayoutParams(-1, 3);
            obj.weight = 1.0F;
            obj.height = ew.a(getContext(), mr1.b());
            addView(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj)));
            obj = new FrameLayout(getContext());
            Object obj2 = new android.widget.LinearLayout.LayoutParams(-1, 3);
            obj2.width = -1;
            obj2.height = -1;
            ((FrameLayout) (obj1)).addView(((View) (obj)), ((android.view.ViewGroup.LayoutParams) (obj2)));
            obj1 = new StatusImageView(getContext(), null);
            obj2 = new android.widget.FrameLayout.LayoutParams(-1, 17);
            obj2.height = ew.a(getContext(), mr1.b());
            obj2.width = ew.a(getContext(), mr1.a());
            obj2.gravity = 17;
            if (flag)
            {
                ((StatusImageView) (obj1)).setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                ((StatusImageView) (obj1)).setFix(true);
            }
            ((FrameLayout) (obj)).addView(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj2)));
            obj2 = new ProgressBar(getContext(), null, 0x1010079);
            ((ProgressBar) (obj2)).setVisibility(4);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, 17);
            layoutparams.height = ew.a(getContext(), mr1.b() / 2);
            layoutparams.width = ew.a(getContext(), mr1.a() / 2);
            layoutparams.gravity = 17;
            ((FrameLayout) (obj)).addView(((View) (obj2)), layoutparams);
            ((StatusImageView) (obj1)).setVisibility(4);
            itemViewList.add(obj1);
            ((StatusImageView) (obj1)).setOnClickListener(new android.view.View.OnClickListener(((ProgressBar) (obj2)), ((StatusImageView) (obj1))) {

                final ProgressBar a;
                final StatusImageView b;
                final TPageLine c;

                public void onClick(View view)
                {
                    view = ((View) (view.getTag()));
                    if (view != null)
                    {
                        view = (TResInfo)view;
                        if (c.listener != null)
                        {
                            if ((view instanceof TPhotoFreeComposeStyleInfo) && view.getResType() == EResType.ONLINE)
                            {
                                a.setVisibility(0);
                                b.setEnabled(false);
                            }
                            c.listener.resItemSelected(view);
                        }
                    }
                }

            
            {
                c = TPageLine.this;
                a = progressbar;
                b = statusimageview;
                super();
            }
            });
        }

    }
}
