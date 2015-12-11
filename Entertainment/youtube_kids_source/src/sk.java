// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.net.Uri;

final class sk
    implements bhv
{

    private sj a;

    sk(sj sj1)
    {
        a = sj1;
        super();
    }

    public final void a(Object obj, Exception exception)
    {
        obj = String.valueOf((Uri)obj);
        bmo.a((new StringBuilder(String.valueOf(obj).length() + 39)).append("Couldn't retrieve thumbnail from [uri=").append(((String) (obj))).append("]").toString(), exception);
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (Bitmap)obj1;
        a.a.a(((Bitmap) (obj)));
    }
}
