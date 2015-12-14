// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.frame;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.picsart.studio.PicsartContext;

// Referenced classes of package com.socialin.android.photo.frame:
//            a, SelectSvgFrameActivity

public final class c extends BaseAdapter
{

    private SelectSvgFrameActivity a;

    public c(SelectSvgFrameActivity selectsvgframeactivity)
    {
        a = selectsvgframeactivity;
        super();
    }

    public final int getCount()
    {
        return a.e.length;
    }

    public final Object getItem(int i)
    {
        return Integer.valueOf(a.e[i]);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = null;
        ImageView imageview;
        if (view == null)
        {
            view = LayoutInflater.from(a).inflate(0x7f030121, null);
        }
        if (PicsartContext.a == com.picsart.studio.PicsartContext.MemoryType.LOW)
        {
            SelectSvgFrameActivity.a(a).inSampleSize = 2;
        }
        imageview = (ImageView)view.findViewById(0x7f100282);
        try
        {
            imageview.setImageResource(a.e[i]);
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inSampleSize = 2;
            while (viewgroup == null && options.inSampleSize <= 4) 
            {
                viewgroup = com.socialin.android.util.c.a(a.getResources(), a.e[i], options, a.a);
                imageview.setImageBitmap(viewgroup);
                options.inSampleSize = options.inSampleSize + 1;
            }
        }
        return view;
    }
}
