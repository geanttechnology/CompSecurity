// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

final class cdi
    implements bhv
{

    private bhv a;
    private cdh b;

    cdi(cdh cdh1, bhv bhv1)
    {
        b = cdh1;
        a = bhv1;
        super();
    }

    public final void a(Object obj, Exception exception)
    {
        obj = (bzi)obj;
        a.a(obj, exception);
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (bzi)obj;
        obj1 = (ced)obj1;
        if (!((ced) (obj1)).n && !((ced) (obj1)).o)
        {
            cdh cdh1 = b;
            Object obj2 = ((ced) (obj1)).a;
            if (!((Set) (obj2)).isEmpty())
            {
                Object obj3 = (String)((bzi) (obj)).a.getPathSegments().get(3);
                bzl bzl1 = cdh1.b;
                b.a(((String) (obj3)));
                obj3 = bzi.a(bzl1.a.b().buildUpon().path("feeds/player/videos").appendQueryParameter("make", Build.MANUFACTURER).appendQueryParameter("model", Build.MODEL).build().buildUpon().appendPath(((String) (obj3))).build());
                obj2 = new ArrayList(((java.util.Collection) (obj2)));
                cdh1.a.a(obj3, new cnz(obj2, cdh1.c.a()));
            }
        }
        a.a(obj, obj1);
    }
}
