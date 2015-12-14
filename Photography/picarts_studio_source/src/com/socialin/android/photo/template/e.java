// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import com.picsart.collages.CollageCategoryItem;
import com.picsart.collages.i;
import com.picsart.collages.j;
import com.socialin.android.util.ModernAsyncTask;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.template:
//            d

final class e extends ModernAsyncTask
{

    private List a;
    private String b;
    private d c;

    private e(d d1, String s, List list)
    {
        c = d1;
        super();
        a = null;
        b = "";
        a = list;
        b = s;
    }

    e(d d1, String s, List list, byte byte0)
    {
        this(d1, s, list);
    }

    protected final Object doInBackground(Object aobj[])
    {
        int l = d.a(c).c.size();
        for (int k = 0; k < l && !isCancelled(); k++)
        {
            publishProgress(new j[] {
                d.a(c, (new StringBuilder()).append(b).append("/").append(((com.picsart.collages.CollageCategoryItem.CollagePreviewItem)a.get(k)).b).toString())
            });
        }

        return null;
    }

    protected final void onProgressUpdate(Object aobj[])
    {
        aobj = (j[])aobj;
        super.onProgressUpdate(aobj);
        if (!isCancelled() && aobj[0] != null)
        {
            d.b(c).add(aobj[0]);
        }
    }
}
