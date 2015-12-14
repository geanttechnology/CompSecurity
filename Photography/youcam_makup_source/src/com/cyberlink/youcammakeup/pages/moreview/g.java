// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyberlink.youcammakeup.database.more.types.a;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            h

public class g extends RelativeLayout
{

    private View a;
    private View b;
    private TextView c;
    private ImageView d;
    private View e;
    private int f;
    private long g;

    public g(Context context, int i, a a1)
    {
        super(context);
        a(context, i, a1);
    }

    private int a(a a1)
    {
        return 0x7f0208a2;
    }

    static long a(g g1)
    {
        return g1.g;
    }

    private void a(Context context, int i, a a1)
    {
        a = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f0301dc, this);
        b = a.findViewById(0x7f0c0868);
        c = (TextView)a.findViewById(0x7f0c0867);
        d = (ImageView)a.findViewById(0x7f0c0864);
        e = a.findViewById(0x7f0c0865);
        f = a(a1);
    }

    static void a(g g1, boolean flag)
    {
        g1.setTumbnailError(flag);
    }

    static ImageView b(g g1)
    {
        return g1.d;
    }

    private void setTumbnailError(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        e.setVisibility(i);
    }

    public void a()
    {
        setTumbnailError(false);
        d.setImageResource(f);
    }

    public void a(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        b.setVisibility(i);
    }

    public void b()
    {
        if (c != null)
        {
            c.setText(0x7f0700ab);
        }
    }

    public long getFilmId()
    {
        return g;
    }

    public void setDescription(CharSequence charsequence)
    {
        if (c != null)
        {
            c.setText(charsequence);
        }
    }

    public void setFilmId(long l)
    {
        g = l;
    }

    public void setTumbnail(String s)
    {
        setTumbnailError(false);
        h h1 = new h(this);
        h1.a = g;
        h1.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new String[] {
            s
        });
    }
}
