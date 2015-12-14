// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.cyberlink.you.friends.s;
import com.cyberlink.you.pages.photoimport.a.a;
import java.io.File;
import java.lang.ref.WeakReference;

// Referenced classes of package com.cyberlink.you.utility:
//            LoadImageUtils

class c extends AsyncTask
{

    public String a;
    private WeakReference b;
    private boolean c;

    public transient Bitmap a(Object aobj[])
    {
        Thread.currentThread().setName("LoadBitmapTask AsyncTask");
        if (a == null || !(new File(a)).exists())
        {
            aobj = null;
        } else
        {
            Bitmap bitmap = LoadImageUtils.b().a(a);
            aobj = bitmap;
            if (bitmap == null)
            {
                boolean flag;
                if (!c)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return com.cyberlink.you.pages.photoimport.a.a.a(a, flag, -1);
            }
        }
        return ((Bitmap) (aobj));
    }

    protected void a(Bitmap bitmap)
    {
        if (isCancelled())
        {
            bitmap = null;
        }
        while (bitmap == null || b == null) 
        {
            return;
        }
        ImageView imageview = (ImageView)b.get();
        if (this == LoadImageUtils.b(imageview) && imageview != null)
        {
            imageview.setImageBitmap(bitmap);
        }
        LoadImageUtils.b().a(a, bitmap);
    }

    public Object doInBackground(Object aobj[])
    {
        return a(aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Bitmap)obj);
    }

    public SrcType(String s1, String s2, ImageView imageview, SrcType srctype, boolean flag, boolean flag1)
    {
        a = s2;
        b = new WeakReference(imageview);
        c = flag1;
    }
}
