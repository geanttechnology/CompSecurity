// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.ae;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.picsart.collages:
//            CollageCellSelectorView, j

public final class i extends ArrayAdapter
{

    private int a;
    private int b;
    private String c;
    private File d;
    private LayoutInflater e;
    private HashMap f;

    public i(Context context, int j, int k, String s)
    {
        super(context, 0);
        d = null;
        e = null;
        f = null;
        a = j;
        b = k;
        c = ae.b(s);
        d = context.getExternalCacheDir();
        if (d == null)
        {
            d = context.getCacheDir();
        }
        if (d == null)
        {
            d = new File(Environment.getExternalStorageDirectory(), "PicsArt/.cache/collages");
            if (!d.exists())
            {
                d.mkdirs();
                d.mkdir();
            }
        }
        e = LayoutInflater.from(context);
        f = new HashMap();
    }

    static int a(i j)
    {
        return j.a;
    }

    static int b(i j)
    {
        return j.b;
    }

    static String c(i j)
    {
        return j.c;
    }

    static HashMap d(i j)
    {
        return j.f;
    }

    public final void a()
    {
        Iterator iterator = f.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Bitmap bitmap = (Bitmap)f.get(iterator.next());
            if (bitmap != null)
            {
                bitmap.recycle();
            }
        } while (true);
    }

    public final View getView(int j, View view, ViewGroup viewgroup)
    {
        new File(d, (new StringBuilder()).append(c).append(j).toString());
        if (view == null)
        {
            view = e.inflate(0x7f03006e, viewgroup, false);
        }
        ((ImageView)view).setImageBitmap(null);
        if (!f.containsKey((new StringBuilder()).append(c).append(j).toString()) || f.get((new StringBuilder()).append(c).append(j).toString()) == null || ((Bitmap)f.get((new StringBuilder()).append(c).append(j).toString())).isRecycled())
        {
            (new ModernAsyncTask(j) {

                private int a;
                private i b;

                protected final Object doInBackground(Object aobj[])
                {
                    aobj = (ImageView[])aobj;
                    Object obj = new CollageCellSelectorView(b.getContext());
                    j j1 = (j)b.getItem(a);
                    ((CollageCellSelectorView) (obj)).setCollageCellsArray(j1.a, j1.b, j1.c);
                    ((CollageCellSelectorView) (obj)).setLayoutParams(new android.widget.AbsListView.LayoutParams(i.a(b), i.b(b)));
                    obj = ((CollageCellSelectorView) (obj)).a(i.a(b), i.b(b));
                    i.d(b).put((new StringBuilder()).append(i.c(b)).append(a).toString(), obj);
                    return aobj[0];
                }

                protected final void onPostExecute(Object obj)
                {
                    obj = (ImageView)obj;
                    super.onPostExecute(obj);
                    if (obj != null)
                    {
                        ((ImageView) (obj)).setImageBitmap((Bitmap)i.d(b).get((new StringBuilder()).append(i.c(b)).append(a).toString()));
                    }
                }

            
            {
                b = i.this;
                a = l;
                super();
            }
            }).execute(new ImageView[] {
                (ImageView)view
            });
            return view;
        } else
        {
            ((ImageView)view).setImageBitmap((Bitmap)f.get((new StringBuilder()).append(c).append(j).toString()));
            return view;
        }
    }
}
