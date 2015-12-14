// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.d;
import com.bumptech.glide.request.e;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio:
//            ImagePickerActivity, g

public final class f extends android.support.v7.widget.RecyclerView.Adapter
    implements com.bumptech.glide.f
{

    final ImagePickerActivity a;
    private j b;
    private k c;

    public f(ImagePickerActivity imagepickeractivity)
    {
        a = imagepickeractivity;
        super();
    }

    public final volatile j a(Object obj)
    {
        obj = (HashMap)obj;
        return c.a(obj);
    }

    public final List a(int i)
    {
        return new ArrayList(com.picsart.studio.ImagePickerActivity.l(a).subList(i, i + 1));
    }

    public final int getItemCount()
    {
        return ImagePickerActivity.a(a).size();
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        android.graphics.Bitmap bitmap = null;
        g g1 = (g)viewholder;
        g1.c.setOnClickListener(new android.view.View.OnClickListener(i) {

            private int a;
            private f b;

            public final void onClick(View view)
            {
                AnalyticUtils.getInstance(b.a).trackLocalAction("first:imgFromRecent");
                view = (new File((String)ImagePickerActivity.a(b.a).get(a))).getParentFile().getName();
                view = x.a().a(new File(x.d(), view));
                if (com.picsart.studio.ImagePickerActivity.l(b.a).size() >= a + 1 && ImagePickerActivity.a(b.a).size() >= a + 1)
                {
                    ImagePickerActivity.a(b.a, (String)ImagePickerActivity.a(b.a).get(a), m.d((String)ImagePickerActivity.a(b.a).get(a)), 2, (HashMap)com.picsart.studio.ImagePickerActivity.l(b.a).get(a), "", view);
                }
            }

            
            {
                b = f.this;
                a = i;
                super();
            }
        });
        viewholder = (String)ImagePickerActivity.a(a).get(i);
        if (viewholder.contains("_w") && viewholder.contains("_h"))
        {
            viewholder = new ImagePickerActivity.RecentPhotoAdapter._cls2();
        } else
        {
            viewholder = null;
        }
        com.picsart.studio.ImagePickerActivity.l(a).add(viewholder);
        ImagePickerActivity.a(a, (int)Utils.a(70F, a));
        if (viewholder != null)
        {
            bitmap = w.b(viewholder, com.picsart.studio.ImagePickerActivity.m(a) + 20, com.picsart.studio.ImagePickerActivity.m(a) + 20, 0);
        }
        if (bitmap != null)
        {
            g1.b.setVisibility(8);
            g1.a.setVisibility(0);
            g1.a.setImageBitmap(bitmap);
            return;
        } else
        {
            g1.a.setVisibility(4);
            g1.b.setVisibility(0);
            viewholder = (new StringBuilder("file://")).append((String)ImagePickerActivity.a(a).get(i)).toString();
            viewholder = c.g().a(viewholder).a(e.b(l.e));
            viewholder.a = new d(g1) {

                private g a;

                public final boolean a(Object obj)
                {
                    a.b.setVisibility(8);
                    a.a.setVisibility(0);
                    return false;
                }

            
            {
                a = g1;
                super();
            }
            };
            viewholder.a(g1.a);
            return;
        }
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        View view = a.getLayoutInflater().inflate(0x7f03018e, viewgroup, false);
        b = com.bumptech.glide.b.b(viewgroup.getContext()).g().a(0.1F);
        c = com.bumptech.glide.b.b(viewgroup.getContext());
        c.g().b = b;
        return new g(view);
    }

    // Unreferenced inner class com/picsart/studio/ImagePickerActivity$RecentPhotoAdapter$2

/* anonymous class */
    class ImagePickerActivity.RecentPhotoAdapter._cls2 extends HashMap
    {

        final f this$1;
        final int val$height;
        final String val$path;
        final int val$width;

            
            {
                this$1 = f.this;
                width = i;
                height = i1;
                path = s;
                super();
                put("width", Integer.valueOf(width));
                put("height", Integer.valueOf(height));
                put("path", path);
            }
    }

}
