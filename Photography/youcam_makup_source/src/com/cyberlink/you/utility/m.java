// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.ImageView;
import com.cyberlink.you.friends.s;
import com.cyberlink.you.g;
import com.cyberlink.you.sticker.StickerObj;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.utility:
//            LoadImageUtils

class m extends AsyncTask
{

    public StickerObj a;
    private String b;
    private String c;
    private WeakReference d;
    private boolean e;
    private int f;

    public m(StickerObj stickerobj, String s1, String s2, ImageView imageview, boolean flag)
    {
        this(stickerobj, s1, s2, imageview, flag, 3);
    }

    public m(StickerObj stickerobj, String s1, String s2, ImageView imageview, boolean flag, int i)
    {
        a = stickerobj;
        b = (new StringBuilder()).append(s1).append(File.separator).toString();
        c = s2;
        d = new WeakReference(imageview);
        e = flag;
        f = i;
    }

    public transient Pair a(Object aobj[])
    {
        AnimationDrawable animationdrawable;
        Object obj;
        boolean flag;
        Thread.currentThread().setName("loadAnimPNGTask AsyncTask");
        a.l();
        obj = a.n();
        if (obj == null || ((List) (obj)).isEmpty())
        {
            return Pair.create(Boolean.valueOf(false), null);
        }
        g.a();
        aobj = g.I().getApplicationContext();
        animationdrawable = new AnimationDrawable();
        animationdrawable.setOneShot(false);
        obj = ((List) (obj)).iterator();
        flag = false;
_L2:
        String s1;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = (String)((Iterator) (obj)).next();
        android.graphics.Bitmap bitmap = BitmapFactory.decodeFile((new StringBuilder()).append(b).append(File.separator).append(s1).toString());
        if (bitmap != null)
        {
            try
            {
                animationdrawable.addFrame(new BitmapDrawable(((Context) (aobj)).getResources(), bitmap), a.o());
                LoadImageUtils.b().a((new StringBuilder()).append(b).append(s1).toString(), bitmap);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            catch (OutOfMemoryError outofmemoryerror)
            {
                outofmemoryerror.printStackTrace();
            }
        } else
        {
            flag = true;
        }
        if (true) goto _L2; else goto _L1
_L1:
        return Pair.create(Boolean.valueOf(flag), animationdrawable);
    }

    protected void a(Pair pair)
    {
        AnimationDrawable animationdrawable;
        animationdrawable = (AnimationDrawable)pair.second;
        break MISSING_BLOCK_LABEL_8;
        if (animationdrawable != null && d != null)
        {
            ImageView imageview = (ImageView)d.get();
            if (f > 0 && ((Boolean)pair.first).booleanValue())
            {
                g.a();
                LoadImageUtils.a(g.I().getApplicationContext(), a, b, c, imageview, e, f - 1);
                return;
            }
            if (this == LoadImageUtils.a(imageview) && imageview != null)
            {
                imageview.setImageDrawable(animationdrawable);
                animationdrawable.start();
                return;
            }
        }
        return;
    }

    public Object doInBackground(Object aobj[])
    {
        return a(aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Pair)obj);
    }
}
