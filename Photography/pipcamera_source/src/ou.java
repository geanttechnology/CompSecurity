// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.fotoable.sketch.view.TTieZhiCollectionView;
import com.fotoable.sketch.view.TTieZhiSafeImageView;

public class ou extends FrameLayout
{

    int a;
    TTieZhiSafeImageView b;
    View c;
    ImageView d;
    TTieZhiInfo e;
    final TTieZhiCollectionView f;

    public ou(TTieZhiCollectionView ttiezhicollectionview, Context context)
    {
        f = ttiezhicollectionview;
        super(context);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030091, this, true);
        b = (TTieZhiSafeImageView)findViewById(0x7f0c010f);
        d = (ImageView)findViewById(0x7f0c0049);
        c = findViewById(0x7f0c0252);
        setOnClickListener(new android.view.View.OnClickListener(ttiezhicollectionview) {

            final TTieZhiCollectionView a;
            final ou b;

            public void onClick(View view)
            {
                TTieZhiCollectionView.access$200(b.f, b.e, (ou)view);
            }

            
            {
                b = ou.this;
                a = ttiezhicollectionview;
                super();
            }
        });
    }

    public void a()
    {
        if (e != null)
        {
            TTieZhiCollectionView.access$300(f, d, e);
        }
    }

    public void a(TTieZhiInfo ttiezhiinfo, int i)
    {
        e = ttiezhiinfo;
        a = i;
        TTieZhiCollectionView.access$300(f, d, ttiezhiinfo);
        if (f.mImageWorker != null)
        {
            f.mImageWorker.a(ttiezhiinfo, b);
        }
    }

    public int b()
    {
        return a;
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            c.setVisibility(0);
            return;
        } else
        {
            c.setVisibility(4);
            return;
        }
    }
}
