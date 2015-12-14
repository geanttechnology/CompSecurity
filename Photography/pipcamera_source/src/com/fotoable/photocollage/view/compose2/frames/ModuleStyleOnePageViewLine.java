// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2.frames;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.fotoable.photocollage.view.compose2.StatusImageView;
import com.wantu.model.res.TFrameItemInfo;
import com.wantu.model.res.TResInfo;
import ew;
import java.util.HashMap;
import mi;

public class ModuleStyleOnePageViewLine extends LinearLayout
{

    StatusImageView img_item1;
    StatusImageView img_item2;
    StatusImageView img_item3;
    StatusImageView img_item4;
    StatusImageView img_item5;
    StatusImageView img_item6;
    mi listener;
    HashMap viewMapBitmap;

    public ModuleStyleOnePageViewLine(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        viewMapBitmap = new HashMap();
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300a7, this, true);
        float f = (float)ew.a(getContext()) / 320F;
        img_item1 = (StatusImageView)findViewById(0x7f0c028e);
        img_item2 = (StatusImageView)findViewById(0x7f0c0291);
        img_item3 = (StatusImageView)findViewById(0x7f0c0294);
        img_item4 = (StatusImageView)findViewById(0x7f0c0297);
        img_item5 = (StatusImageView)findViewById(0x7f0c029a);
        img_item6 = (StatusImageView)findViewById(0x7f0c029d);
        itemS(img_item1, f);
        itemS(img_item2, f);
        itemS(img_item3, f);
        itemS(img_item4, f);
        itemS(img_item5, f);
        itemS(img_item6, f);
    }

    private void itemWithData(StatusImageView statusimageview, TResInfo tresinfo, boolean flag)
    {
        statusimageview.setTag(tresinfo);
        if (tresinfo instanceof TFrameItemInfo)
        {
            TFrameItemInfo tframeiteminfo = (TFrameItemInfo)tresinfo;
            if (tframeiteminfo.icon == null)
            {
                statusimageview.setBackgroundColor(tframeiteminfo.getBgColor());
            } else
            {
                clearItem(statusimageview);
                tresinfo = tresinfo.getIconBitmap();
                statusimageview.setImageBitmap(tresinfo);
                viewMapBitmap.put(statusimageview, tresinfo);
            }
        } else
        {
            clearItem(statusimageview);
            tresinfo = tresinfo.getIconBitmap();
            statusimageview.setImageBitmap(tresinfo);
            viewMapBitmap.put(statusimageview, tresinfo);
        }
        statusimageview.setIsSelected(flag);
        statusimageview.setVisibility(0);
    }

    public void clear()
    {
        clearItem(img_item1);
        clearItem(img_item2);
        clearItem(img_item3);
        clearItem(img_item4);
        clearItem(img_item5);
        clearItem(img_item6);
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

    protected void itemS(StatusImageView statusimageview, float f)
    {
        android.view.ViewGroup.LayoutParams layoutparams = statusimageview.getLayoutParams();
        layoutparams.width = (int)((float)layoutparams.width * f);
        statusimageview.setOnClickListener(new android.view.View.OnClickListener(statusimageview) {

            final StatusImageView a;
            final ModuleStyleOnePageViewLine b;

            public void onClick(View view)
            {
                view = ((View) (a.getTag()));
                if (view != null)
                {
                    view = (TResInfo)view;
                    if (b.listener != null)
                    {
                        b.listener.resItemSelected(view);
                    }
                }
            }

            
            {
                b = ModuleStyleOnePageViewLine.this;
                a = statusimageview;
                super();
            }
        });
    }

    public void setItemData(int i, TResInfo tresinfo, boolean flag)
    {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 41
    //                   1 52
    //                   2 63
    //                   3 74
    //                   4 85
    //                   5 96;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return;
_L2:
        try
        {
            itemWithData(img_item1, tresinfo, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TResInfo tresinfo)
        {
            return;
        }
_L3:
        itemWithData(img_item2, tresinfo, flag);
        return;
_L4:
        itemWithData(img_item3, tresinfo, flag);
        return;
_L5:
        itemWithData(img_item4, tresinfo, flag);
        return;
_L6:
        itemWithData(img_item5, tresinfo, flag);
        return;
_L7:
        itemWithData(img_item6, tresinfo, flag);
        return;
    }

    public void setItemSelect(TResInfo tresinfo, boolean flag)
    {
        setItemSelecte(img_item1, tresinfo, flag);
        setItemSelecte(img_item2, tresinfo, flag);
        setItemSelecte(img_item3, tresinfo, flag);
        setItemSelecte(img_item4, tresinfo, flag);
        setItemSelecte(img_item5, tresinfo, flag);
        setItemSelecte(img_item6, tresinfo, flag);
    }

    public void setItemSelectListener(mi mi)
    {
        listener = mi;
    }

    protected void setItemSelecte(StatusImageView statusimageview, TResInfo tresinfo, boolean flag)
    {
        TResInfo tresinfo1;
        if (statusimageview.getTag() != null)
        {
            tresinfo1 = (TResInfo)statusimageview.getTag();
            break MISSING_BLOCK_LABEL_16;
        }
        do
        {
            return;
        } while (tresinfo1.name == null || tresinfo1.name.compareTo(tresinfo.getName()) != 0);
        statusimageview.setIsSelected(flag);
    }
}
