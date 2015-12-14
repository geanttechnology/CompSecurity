// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.socialin.android.util.c;
import java.util.HashMap;

// Referenced classes of package com.socialin.android.multiselect:
//            e

final class b extends AsyncTask
{

    private String a;
    private ImageView b;
    private e c;

    protected final Object doInBackground(Object aobj[])
    {
        aobj = com.socialin.android.util.c.a(a);
        e.g(c).put(a, ((Object) (aobj)));
        return ((Object) (aobj));
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Bitmap)obj;
        super.onPostExecute(obj);
        b.setLayoutParams(new android.widget.tiveLayout.LayoutParams(100, 100));
        b.setScaleType(android.widget.eView.ScaleType.CENTER_CROP);
        b.setImageBitmap(((Bitmap) (obj)));
    }

    arams(e e1, String s, ImageView imageview)
    {
        c = e1;
        a = s;
        b = imageview;
        super();
    }
}
