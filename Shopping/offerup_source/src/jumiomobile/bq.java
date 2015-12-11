// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.ArrayList;

// Referenced classes of package jumiomobile:
//            br, bt

public class bq extends RelativeLayout
    implements android.view.View.OnClickListener
{

    private ImageView a[];
    private ArrayList b;
    private int c;
    private int d;
    private bt e;

    public bq(Context context)
    {
        super(context);
        a = new ImageView[2];
        c = 0;
        d = 0;
        a(context);
    }

    private Runnable a(ImageView imageview, ImageView imageview1, int i, bq bq1)
    {
        return new br(this, imageview, i, imageview1, bq1);
    }

    static bt a(bq bq1)
    {
        return bq1.e;
    }

    private void a()
    {
        boolean flag = false;
        Object obj = a[d];
        ImageView imageview;
        Bitmap bitmap;
        int i;
        if (c < b.size() - 1)
        {
            i = c + 1;
        } else
        {
            i = 0;
        }
        c = i;
        i = ((flag) ? 1 : 0);
        if (d <= 0)
        {
            i = d + 1;
        }
        d = i;
        imageview = a[d];
        bitmap = (Bitmap)b.get(c);
        i = (int)Math.floor(bitmap.getHeight());
        imageview.setImageBitmap(bitmap);
        obj = a(((ImageView) (obj)), imageview, i, this);
        (new Handler(Looper.getMainLooper())).post(((Runnable) (obj)));
    }

    private void a(Context context)
    {
        setOnClickListener(this);
    }

    public void a(int i)
    {
        if (i >= b.size())
        {
            return;
        } else
        {
            c = i;
            a[d].setImageBitmap((Bitmap)b.get(c));
            return;
        }
    }

    public void a(ArrayList arraylist)
    {
        b = arraylist;
        c = 0;
        d = 0;
        arraylist = (Bitmap)arraylist.get(c);
        int j = arraylist.getHeight() / 2;
        for (int i = 0; i < 2; i++)
        {
            ImageView imageview = new ImageView(getContext());
            imageview.setPadding(0, j, 0, j);
            addView(imageview);
            a[i] = imageview;
        }

        a[d].setImageBitmap(arraylist);
    }

    public void onClick(View view)
    {
        e.a(this);
        a();
    }

    public void setOnImageSwitchedListener(bt bt1)
    {
        e = bt1;
    }
}
