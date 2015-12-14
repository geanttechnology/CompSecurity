// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditFilterActivity;
import java.util.List;
import java.util.Map;

public class afz
    implements Runnable
{

    final List a;
    final Map b;
    final List c;
    final ProEditFilterActivity d;

    public afz(ProEditFilterActivity proeditfilteractivity, List list, Map map, List list1)
    {
        d = proeditfilteractivity;
        a = list;
        b = map;
        c = list1;
        super();
    }

    public void run()
    {
        ProEditFilterActivity.a(d, yo.a(d.i, yp.a(d, 52F), yp.a(d, 52F)));
        d.runOnUiThread(new aga(this));
    }
}
