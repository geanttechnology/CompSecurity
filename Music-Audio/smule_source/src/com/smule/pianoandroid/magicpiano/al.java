// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.AsyncTask;
import android.widget.ImageView;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.data.model.ScoreInfo;
import com.smule.pianoandroid.data.model.SongProgress;
import com.smule.pianoandroid.magicpiano.a.g;
import com.smule.pianoandroid.magicpiano.a.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListItem

class al extends AsyncTask
{

    int a;
    int b;
    int c;
    String d;
    final ProductListItem e;

    public al(ProductListItem productlistitem)
    {
        e = productlistitem;
        super();
        d = ProductListItem.c(productlistitem).songId;
    }

    protected transient Void a(Void avoid[])
    {
        avoid = ProductListItem.c(e);
        a = 0x7f0200d1;
        b = 0x7f020130;
        c = 0x7f0200d9;
        List list = g.a().a(((SongV2) (avoid)).songId);
        avoid = list;
        if (list == null)
        {
            avoid = new ArrayList();
        }
        if (!avoid.isEmpty())
        {
            avoid = (ScoreInfo)avoid.get(0);
            if (((ScoreInfo) (avoid)).progress == null)
            {
                return null;
            }
            avoid = ((ScoreInfo) (avoid)).progress.iterator();
            do
            {
                if (!avoid.hasNext())
                {
                    break;
                }
                SongProgress songprogress = (SongProgress)avoid.next();
                if (songprogress.difficulty == k.b.ordinal())
                {
                    int i;
                    if (songprogress.stars == 1)
                    {
                        i = 0x7f0200d2;
                    } else
                    if (songprogress.stars == 2)
                    {
                        i = 0x7f0200d3;
                    } else
                    if (songprogress.stars >= 3)
                    {
                        i = 0x7f0200d4;
                    } else
                    {
                        i = 0x7f0200d1;
                    }
                    a = i;
                } else
                if (songprogress.difficulty == k.c.ordinal())
                {
                    int j;
                    if (songprogress.stars == 1)
                    {
                        j = 0x7f020131;
                    } else
                    if (songprogress.stars == 2)
                    {
                        j = 0x7f020132;
                    } else
                    if (songprogress.stars >= 3)
                    {
                        j = 0x7f020133;
                    } else
                    {
                        j = 0x7f020130;
                    }
                    b = j;
                } else
                if (songprogress.difficulty == k.d.ordinal())
                {
                    int l;
                    if (songprogress.stars == 1)
                    {
                        l = 0x7f0200da;
                    } else
                    if (songprogress.stars == 2)
                    {
                        l = 0x7f0200db;
                    } else
                    if (songprogress.stars >= 3)
                    {
                        l = 0x7f0200dc;
                    } else
                    {
                        l = 0x7f0200d9;
                    }
                    c = l;
                }
            } while (true);
        }
        return null;
    }

    protected void a(Void void1)
    {
        ProductListItem.d(e).setBackgroundResource(a);
        ProductListItem.e(e).setBackgroundResource(b);
        ProductListItem.f(e).setBackgroundResource(c);
        e.setTag(null);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onCancelled()
    {
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }
}
