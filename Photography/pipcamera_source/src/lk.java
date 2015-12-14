// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.comlib.util.AsyncTask;
import com.fotoable.photocollage.activity.photoselector.MultiPhotoSelectorActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lk extends AsyncTask
{

    public List a;
    public List b;
    final MultiPhotoSelectorActivity c;

    private lk(MultiPhotoSelectorActivity multiphotoselectoractivity)
    {
        c = multiphotoselectoractivity;
        super();
        b = new ArrayList();
    }

    public lk(MultiPhotoSelectorActivity multiphotoselectoractivity, com.fotoable.photocollage.activity.photoselector.MultiPhotoSelectorActivity._cls1 _pcls1)
    {
        this(multiphotoselectoractivity);
    }

    protected transient Boolean a(Void avoid[])
    {
        int i;
        Bitmap bitmap;
        Bitmap bitmap1;
        String s;
        int j;
        try
        {
            avoid = a.iterator();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
            return Boolean.valueOf(false);
        }
        i = 0;
_L2:
        if (!avoid.hasNext())
        {
            break MISSING_BLOCK_LABEL_119;
        }
        j = ((Integer)avoid.next()).intValue();
        bitmap = yh.a(c, j);
        bitmap1 = ev.a(bitmap, 200, 200);
        s = String.format("src%d", new Object[] {
            Integer.valueOf(i)
        });
        b.add(s);
        yg.a().a(s, bitmap1);
        bitmap1.recycle();
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        if (bitmap.isRecycled())
        {
            bitmap.recycle();
        }
        break MISSING_BLOCK_LABEL_134;
        return Boolean.valueOf(true);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void a(Boolean boolean1)
    {
        c.b();
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    protected void onPreExecute()
    {
        c.a();
    }
}
