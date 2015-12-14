// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.youcammakeup.widgetpool.common.FixedAspectRatioFrameLayout;

public class m extends FrameLayout
{

    DownloadGridItem.LayoutTypeInfo.LayoutType a;
    private TextView b;
    private LinearLayout c;

    public m(Context context, DownloadGridItem.LayoutTypeInfo.LayoutType layouttype)
    {
        super(context);
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(a(layouttype), this);
        a = layouttype;
        b = (TextView)findViewById(0x7f0c0874);
        c = (LinearLayout)findViewById(0x7f0c0875);
    }

    private int a(DownloadGridItem.LayoutTypeInfo.LayoutType layouttype)
    {
        return layouttype != DownloadGridItem.LayoutTypeInfo.LayoutType.a ? 0x7f0301e2 : 0x7f0301e5;
    }

    static LinearLayout a(m m1)
    {
        return m1.c;
    }

    private void b()
    {
        a(18, 228, null, null, false);
    }

    public void a()
    {
        c.removeAllViews();
    }

    public void a(int i, int j, String s)
    {
        if (c.getChildCount() > 0 && i > 0 && j > 0 && s != null)
        {
            b();
        }
        a(i, j, s, null, false);
    }

    public void a(int i, int j, String s, String s1, boolean flag)
    {
        FixedAspectRatioFrameLayout fixedaspectratioframelayout;
        if (a == DownloadGridItem.LayoutTypeInfo.LayoutType.a)
        {
            fixedaspectratioframelayout = (FixedAspectRatioFrameLayout)LayoutInflater.from(getContext()).inflate(0x7f0301e6, c, false);
        } else
        {
            fixedaspectratioframelayout = new FixedAspectRatioFrameLayout(getContext());
            fixedaspectratioframelayout.a(i, j);
            fixedaspectratioframelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(0, -1));
        }
        (new AsyncTask(s, fixedaspectratioframelayout, s1, flag) {

            final String a;
            final FixedAspectRatioFrameLayout b;
            final String c;
            final boolean d;
            final m e;

            protected transient Bitmap a(Void avoid[])
            {
                if (a == null)
                {
                    return null;
                } else
                {
                    return BitmapFactory.decodeFile(a);
                }
            }

            protected void a(Bitmap bitmap)
            {
                if (bitmap != null)
                {
                    if (e.a == DownloadGridItem.LayoutTypeInfo.LayoutType.a)
                    {
                        ImageView imageview = (ImageView)b.findViewById(0x7f0c0878);
                        imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                        imageview.setImageBitmap(bitmap);
                        bitmap = (TextView)b.findViewById(0x7f0c087b);
                        if (c != null)
                        {
                            bitmap.setText(c);
                        }
                        if (d)
                        {
                            b.findViewById(0x7f0c0879).setVisibility(4);
                        }
                    } else
                    {
                        ImageView imageview1 = new ImageView(e.getContext());
                        imageview1.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
                        imageview1.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                        imageview1.setImageBitmap(bitmap);
                        b.setBackgroundResource(0x7f0208b1);
                        b.addView(imageview1);
                    }
                }
                m.a(e).addView(b);
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Bitmap)obj);
            }

            
            {
                e = m.this;
                a = s;
                b = fixedaspectratioframelayout;
                c = s1;
                d = flag;
                super();
            }
        }).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    public void setTitle(String s)
    {
        b.setText(s);
    }
}
