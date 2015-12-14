// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.youcammakeup.database.more.types.a;

public class i extends LinearLayout
    implements Checkable
{

    private ViewGroup a;
    private View b;
    private TextView c;
    private ImageView d;
    private View e;
    private int f;
    private long g;

    public i(Context context, int j, a a1)
    {
        super(context);
        a(context, j, a1);
    }

    private int a(a a1)
    {
        return 0x7f0208a2;
    }

    private void a(Context context, int j, a a1)
    {
        a = (ViewGroup)((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f0301dd, this);
        b = a.findViewById(0x7f0c0868);
        c = (TextView)a.findViewById(0x7f0c0867);
        d = (ImageView)a.findViewById(0x7f0c0864);
        e = a.findViewById(0x7f0c0865);
        f = a(a1);
    }

    private void setTumbnailError(boolean flag)
    {
        if (!flag);
    }

    public void a()
    {
        setTumbnailError(false);
        d.setImageResource(f);
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
        b.setVisibility(j);
    }

    public long getFilmId()
    {
        return g;
    }

    public boolean isChecked()
    {
        return false;
    }

    public void setChecked(boolean flag)
    {
        setSelected(flag);
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
        s = BitmapFactory.decodeFile(s);
        if (s != null)
        {
            d.setImageBitmap(s);
            return;
        } else
        {
            setTumbnailError(true);
            return;
        }
    }

    public void toggle()
    {
    }
}
