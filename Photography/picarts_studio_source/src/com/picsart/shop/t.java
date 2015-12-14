// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.request.d;
import com.picsart.studio.utils.DynamicHeightImageView;
import java.util.List;

// Referenced classes of package com.picsart.shop:
//            ShopRecyclerViewBaseAdapter, u

public final class t extends ShopRecyclerViewBaseAdapter
{

    private boolean a;
    private int h;

    public t(Context context, int i, boolean flag)
    {
        super(context);
        a = false;
        h = 0;
        a = flag;
        h = i;
        e = b.b(context).i().a(0.1F);
        f = b.b(context);
        f.i().b = e;
    }

    public final volatile j a(Object obj)
    {
        obj = (String)obj;
        return f.a(obj);
    }

    public final List a(int i)
    {
        return g.subList(i, i + 1);
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        viewholder = (u)viewholder;
        super.onBindViewHolder(viewholder, i);
        Object obj = (String)b(i);
        ((u) (viewholder)).a.setImageDrawable(null);
        ((u) (viewholder)).itemView.setBackgroundColor(h);
        f.a(((u) (viewholder)).a);
        if (!a)
        {
            ((u) (viewholder)).a.setHeightRatio(1.0D);
            obj = f.i().a(obj);
            obj.b = e;
            ((j) (obj)).a(((u) (viewholder)).a);
            return;
        } else
        {
            obj = f.a(obj);
            obj.b = e;
            obj.a = new d(viewholder) {

                private u a;

                public final boolean a(Object obj1)
                {
                    Object obj2 = (Drawable)obj1;
                    DynamicHeightImageView dynamicheightimageview = null;
                    obj1 = dynamicheightimageview;
                    if (obj2 instanceof BitmapDrawable)
                    {
                        obj2 = (BitmapDrawable)obj2;
                        obj1 = dynamicheightimageview;
                        if (((BitmapDrawable) (obj2)).getBitmap() != null)
                        {
                            obj1 = ((BitmapDrawable) (obj2)).getBitmap();
                        }
                    }
                    dynamicheightimageview = a.a;
                    double d1;
                    if (obj1 == null)
                    {
                        d1 = 1.0D;
                    } else
                    {
                        d1 = (float)((Bitmap) (obj1)).getHeight() / (float)((Bitmap) (obj1)).getWidth();
                    }
                    dynamicheightimageview.setHeightRatio(d1);
                    return false;
                }

            
            {
                a = u1;
                super();
            }
            };
            ((j) (obj)).a(((u) (viewholder)).a);
            return;
        }
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return new u(LayoutInflater.from(b).inflate(0x7f0301dd, viewgroup, false));
    }
}
