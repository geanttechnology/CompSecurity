// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.co;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.b;
import com.bumptech.glide.k;
import com.bumptech.glide.request.e;
import com.picsart.studio.d;
import com.socialin.android.adapter.RecyclerViewAdapter;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.picsart.profile.util.GalleryUtils;

// Referenced classes of package myobfuscated.co:
//            b

public final class a extends RecyclerViewAdapter
{

    private d a;

    public a(Context context, com.socialin.android.adapter.a a1)
    {
        super(context, a1);
        a = new d(context.getApplicationContext());
    }

    static Context a(a a1)
    {
        return a1.context;
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        viewholder = (myobfuscated.co.b)viewholder;
        super.onBindViewHolder(viewholder, i);
        ImageItem imageitem = (ImageItem)getItem(i);
        b.b(a.a).a(((myobfuscated.co.b) (viewholder)).a);
        a.a(imageitem.getThumbUrl(), ((myobfuscated.co.b) (viewholder)).a, e.c(a.a), null);
        ((myobfuscated.co.b) (viewholder)).b.setOnClickListener(new android.view.View.OnClickListener(viewholder) {

            private myobfuscated.co.b a;
            private a b;

            public final void onClick(View view)
            {
                GalleryUtils.a((Activity)a.a(b), b.getItems(), a.getPosition());
            }

            
            {
                b = a.this;
                a = b1;
                super();
            }
        });
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return new myobfuscated.co.b(LayoutInflater.from(context).inflate(0x7f030128, viewgroup, false));
    }
}
