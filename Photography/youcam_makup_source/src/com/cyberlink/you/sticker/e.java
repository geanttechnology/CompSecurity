// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.l;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment, StickerObj, h

class e extends AsyncTask
{

    final StickerFragment a;
    private h b;
    private StickerPackObj c;
    private List d;

    public e(StickerFragment stickerfragment, StickerPackObj stickerpackobj, h h1)
    {
        a = stickerfragment;
        super();
        c = stickerpackobj;
        b = h1;
    }

    private List a()
    {
        Object obj = a.getActivity();
        if (obj == null)
        {
            return null;
        } else
        {
            ArrayList arraylist = new ArrayList();
            obj = ((Activity) (obj)).getLayoutInflater().inflate(p.u_view_item_sticker_download, null);
            View view = ((View) (obj)).findViewById(o.download);
            view.setTag(c);
            view.setOnClickListener(StickerFragment.v(a));
            ((View) (obj)).setTag(StickerFragment.PageType.a);
            arraylist.add(obj);
            return arraylist;
        }
    }

    private List b(List list)
    {
        android.support.v4.app.FragmentActivity fragmentactivity = a.getActivity();
        if (fragmentactivity == null)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        int i = 0;
        View view = null;
        while (i < list.size()) 
        {
            if (i % 8 == 0)
            {
                if (view != null)
                {
                    view.setTag(StickerFragment.PageType.b);
                    arraylist.add(view);
                }
                view = fragmentactivity.getLayoutInflater().inflate(p.u_view_item_sticker_preview, null);
            }
            Pair pair = (Pair)list.get(i);
            if (a.isAdded())
            {
                ImageView imageview = (ImageView)view.findViewById(fragmentactivity.getResources().getIdentifier((new StringBuilder()).append("stickerView").append(String.valueOf(i % 8)).toString(), "id", fragmentactivity.getPackageName()));
                if (imageview != null)
                {
                    imageview.setImageBitmap(null);
                    imageview.setTag(pair.first);
                    imageview.setOnClickListener(StickerFragment.w(a));
                } else
                {
                    Log.d("StickerFragment", "no view");
                }
            }
            i++;
        }
        if (view != null)
        {
            view.setTag(StickerFragment.PageType.b);
            arraylist.add(view);
        }
        return arraylist;
    }

    public transient List a(String as[])
    {
        Thread.currentThread().setName("LoadStickerTask AsyncTask");
        if (StickerFragment.i(a))
        {
            Log.d("StickerFragment", "load sticker cancelled !!!");
            return null;
        }
        Log.d("StickerFragment", (new StringBuilder()).append("load sticker ").append(c.f()).toString());
        if (c.j() == com.cyberlink.you.database.StickerPackObj.Status.a)
        {
            d = null;
        } else
        {
            d = com.cyberlink.you.e.h().b(c.b());
        }
        if (d == null)
        {
            return null;
        }
        as = new ArrayList();
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            StickerObj stickerobj = (StickerObj)iterator.next();
            if (StickerFragment.i(a))
            {
                return null;
            }
            try
            {
                as.add(Pair.create(stickerobj, (Bitmap)null));
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        return as;
    }

    protected void a(List list)
    {
        if (StickerFragment.i(a))
        {
            d = null;
            return;
        }
        if (list != null)
        {
            list = b(list);
        } else
        {
            list = a();
        }
        d = null;
        b.a(list);
    }

    public Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((List)obj);
    }
}
