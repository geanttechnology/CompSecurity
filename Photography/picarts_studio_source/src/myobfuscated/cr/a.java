// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cr;

import com.socialin.android.adapter.RecyclerViewAdapter;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.request.ParamWithPageLimit;
import java.util.List;
import java.util.UUID;
import junit.framework.Assert;

// Referenced classes of package myobfuscated.cr:
//            d, b, e

public final class a
{

    final String a = UUID.randomUUID().toString();
    final RecyclerViewAdapter b;
    final BaseSocialinApiRequestController c;
    public e d;
    d e;
    int f;
    boolean g;
    public b h;
    public int i;

    private a(BaseSocialinApiRequestController basesocialinapirequestcontroller, RecyclerViewAdapter recyclerviewadapter)
    {
        i = 0x7fffffff;
        Assert.assertNotNull("Provided request controller must have it's request parameters initialized.", basesocialinapirequestcontroller.getRequestParams());
        b = recyclerviewadapter;
        c = basesocialinapirequestcontroller;
    }

    public static a a(BaseSocialinApiRequestController basesocialinapirequestcontroller, RecyclerViewAdapter recyclerviewadapter)
    {
        return new a(basesocialinapirequestcontroller, recyclerviewadapter);
    }

    public final void a()
    {
        c.setRequestCompleteListener(null);
    }

    public final void a(List list)
    {
        b.setItems(list);
        int j;
        if (list == null)
        {
            j = 0;
        } else
        {
            j = list.size();
        }
        f = j;
        if (e != null)
        {
            e.a();
        }
    }

    public final boolean b()
    {
        return (int)Math.ceil((float)b.getItemCount() / (float)c()) >= i || f < c();
    }

    final int c()
    {
        ParamWithPageLimit paramwithpagelimit = (ParamWithPageLimit)c.getRequestParams();
        if (h != null)
        {
            if (paramwithpagelimit.offset <= 0)
            {
                return h.a;
            } else
            {
                return h.b;
            }
        }
        if (paramwithpagelimit.limit > 0)
        {
            return paramwithpagelimit.limit;
        } else
        {
            return 40;
        }
    }
}
