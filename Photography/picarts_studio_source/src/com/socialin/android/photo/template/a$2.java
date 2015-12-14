// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import com.picsart.shop.a;
import com.socialin.android.dialog.g;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;
import java.io.File;
import java.util.List;
import myobfuscated.cb.c;

// Referenced classes of package com.socialin.android.photo.template:
//            a, Template

final class k extends ModernAsyncTask
{

    private int a;
    private com.socialin.android.photo.template.a b;

    private transient Template a()
    {
        Object obj;
        Template template;
        template = (Template)((c)com.socialin.android.photo.template.a.a(b).get(a)).a;
        template.p = ((c)com.socialin.android.photo.template.a.a(b).get(a)).j;
        obj = null;
        java.io.ByteArrayInputStream bytearrayinputstream = com.picsart.shop.a.a(b.getActivity()).a(template.p, template.h);
        obj = bytearrayinputstream;
_L2:
        obj = BitmapFactory.decodeStream(((java.io.InputStream) (obj)));
        String s = (new StringBuilder()).append(b.getActivity().getApplicationContext().getExternalCacheDir().getPath()).append("/frameTemp").toString();
        w.a(b.getActivity().getApplicationContext().getExternalCacheDir().getPath(), "frameTemp", ((android.graphics.Bitmap) (obj)), b.getActivity(), android.graphics.ap.CompressFormat.PNG, true);
        template.g = s;
        return template;
        Exception exception;
        exception;
        exception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Template)obj;
        super.onPostExecute(obj);
        if (com.socialin.android.photo.template.a.b(b) != null)
        {
            com.socialin.android.photo.template.a.b(b).dismiss();
        }
        com.socialin.android.photo.template.a.a(b, ((Template) (obj)));
    }

    late(com.socialin.android.photo.template.a a1, int i)
    {
        b = a1;
        a = i;
        super();
    }
}
