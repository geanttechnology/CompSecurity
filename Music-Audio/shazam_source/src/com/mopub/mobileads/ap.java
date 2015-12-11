// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.os.Handler;
import android.view.View;
import com.mopub.c.p;
import com.mopub.common.c.a;
import com.mopub.common.m;
import com.mopub.mobileads.b.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.mopub.mobileads:
//            v, an, am, ak, 
//            ah, ae, ac, i, 
//            aa

public final class ap extends v
{

    private final an c;
    private final ah d;

    public ap(an an1, ah ah1, Handler handler)
    {
        super(handler);
        m.a(an1);
        m.a(ah1);
        c = an1;
        d = ah1;
    }

    public final void a()
    {
        int j = c.e.getDuration();
        int k = c.e.getCurrentPosition();
        Object obj = c;
        ak ak1 = ((an) (obj)).i;
        int l = ((an) (obj)).e.getCurrentPosition();
        obj = ak1.a;
        if (l >= ((e) (obj)).d)
        {
            obj.c = l;
            obj.d = l;
        } else
        if (l != 0)
        {
            com.mopub.common.c.a.b(String.format("Progress not monotonically increasing: last = %d, current = %d", new Object[] {
                Integer.valueOf(((e) (obj)).d), Integer.valueOf(l)
            }));
            obj.c = ((e) (obj)).a;
        }
        ((e) (obj)).invalidateSelf();
        if (j > 0)
        {
            Object obj1 = d.a(k, j);
            if (!((List) (obj1)).isEmpty())
            {
                obj = new ArrayList();
                for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
                {
                    ae ae1 = (ae)((Iterator) (obj1)).next();
                    ((List) (obj)).add(ae1.a());
                    ae1.b = true;
                }

                p.a((new ac(((List) (obj)))).a(c.j()).a(Integer.valueOf(k)).a(), ((i) (c)).a);
            }
            obj = c;
            if (((an) (obj)).o != null && k >= ((an) (obj)).o.c)
            {
                ((an) (obj)).p.setVisibility(0);
                aa aa1 = ((an) (obj)).o;
                android.content.Context context = ((i) (obj)).a;
                String s = ((an) (obj)).j();
                m.a(context);
                m.a(s);
                p.a(aa1.g, null, Integer.valueOf(k), s, context);
                if (((an) (obj)).o.d != null && k >= ((an) (obj)).o.c + ((an) (obj)).o.d.intValue())
                {
                    ((an) (obj)).p.setVisibility(8);
                    return;
                }
            }
        }
    }
}
