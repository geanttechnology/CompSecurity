// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Collections;
import java.util.List;

final class cbd
    implements bhv
{

    private final bhv a;

    public cbd(bhv bhv1)
    {
        a = (bhv)b.a(bhv1);
    }

    public final void a(Object obj, Exception exception)
    {
        obj = (bzi)obj;
        a.a(obj, exception);
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (bzi)obj;
        obj1 = (List)obj1;
        int i = Integer.parseInt(((bzi) (obj)).a.getQueryParameter("start-index")) - 1;
        int j = Integer.parseInt(((bzi) (obj)).a.getQueryParameter("max-results"));
        cpw cpw1 = new cpw();
        cpw1.c = i + 1;
        cpw1.b = j;
        cpw1.a = ((List) (obj1)).size();
        if (i > 0)
        {
            cpw1.d = cba.a(((bzi) (obj)).a, Math.max(0, (i - j) + 1), j);
        }
        if (i + j < ((List) (obj1)).size())
        {
            cpw1.e = cba.a(((bzi) (obj)).a, i + j + 1, j);
        }
        Collections.reverse(((List) (obj1)));
        try
        {
            cpw1.a(((List) (obj1)).subList(i, Math.min(j + i, ((List) (obj1)).size())));
            a.a(obj, cpw1.a());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            a.a(obj, ((Exception) (obj1)));
        }
    }
}
