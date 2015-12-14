// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photopage;

import android.app.FragmentManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivity;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.n;
import com.cyberlink.youcammakeup.pages.librarypicker.ItemView;
import com.cyberlink.youcammakeup.pages.librarypicker.LibraryViewFragment;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.PhotoZoomFragment;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photopage:
//            a

public class b extends ItemView
{

    protected a e;
    protected View f;
    protected View g;
    android.view.View.OnClickListener h;
    private Context i;

    public b(Context context, a a1)
    {
        super(context);
        h = new android.view.View.OnClickListener() {

            final b a;

            public void onClick(View view)
            {
                view = (LibraryPickerActivity)b.a(a);
                ((PhotoZoomFragment)view.getFragmentManager().findFragmentById(0x7f0c05b7)).a(c.e().a(a.e.a()).longValue(), a.e.b());
                ((LibraryViewFragment)view.getFragmentManager().findFragmentById(0x7f0c0158)).a(c.e().a(a.e.a()).longValue(), a.e.b());
            }

            
            {
                a = b.this;
                super();
            }
        };
        e = a1;
        i = context;
        context = ((LayoutInflater)i.getSystemService("layout_inflater")).inflate(0x7f0301ff, this);
        d = (ImageView)context.findViewById(0x7f0c06b1);
        f = context.findViewById(0x7f0c08cf);
        if (f != null)
        {
            f.setOnClickListener(h);
        }
        g = context.findViewById(0x7f0c08ce);
    }

    static Context a(b b1)
    {
        return b1.i;
    }

    public void a(a a1)
    {
        a();
        e = a1;
    }

    public void a(boolean flag)
    {
        int j;
        if (flag)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        if (g != null)
        {
            g.setVisibility(j);
        }
    }

    public volatile com.cyberlink.youcammakeup.pages.librarypicker.b getItem()
    {
        return getItem();
    }

    public a getItem()
    {
        return e;
    }

    protected void onMeasure(int j, int k)
    {
        j = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(j), 0x40000000);
        super.onMeasure(j, j);
    }
}
