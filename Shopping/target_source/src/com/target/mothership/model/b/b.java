// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.b;

import com.target.mothership.common.params.GoogleNowSendCardParams;
import com.target.mothership.common.params.NowShoppingListParams;
import com.target.mothership.common.params.NowShoppingProdParams;
import com.target.mothership.model.e;
import com.target.mothership.model.g;
import com.target.mothership.model.h;
import com.target.mothership.services.e.c.b.a;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.b:
//            a

public class b
    implements com.target.mothership.model.b.a
{

    private final a mServices = new a();

    public b()
    {
    }

    private com.target.mothership.services.e.c.a.a a(GoogleNowSendCardParams googlenowsendcardparams)
    {
        com.target.mothership.services.e.c.a.a a1 = new com.target.mothership.services.e.c.a.a(googlenowsendcardparams.c());
        a1.a(googlenowsendcardparams.a(), googlenowsendcardparams.b());
        a1.a(googlenowsendcardparams.d().a());
        NowShoppingProdParams nowshoppingprodparams;
        for (googlenowsendcardparams = googlenowsendcardparams.d().b().iterator(); googlenowsendcardparams.hasNext(); a1.a(nowshoppingprodparams.a(), nowshoppingprodparams.b(), nowshoppingprodparams.c(), nowshoppingprodparams.d()))
        {
            nowshoppingprodparams = (NowShoppingProdParams)googlenowsendcardparams.next();
        }

        return a1;
    }

    public void a(GoogleNowSendCardParams googlenowsendcardparams, h h)
    {
        h = new e(new g(h));
        googlenowsendcardparams = a(googlenowsendcardparams);
        mServices.a(googlenowsendcardparams, h);
    }

    public void a(GoogleNowSendCardParams googlenowsendcardparams, String s, h h)
    {
        h = new e(new g(h));
        googlenowsendcardparams = a(googlenowsendcardparams);
        mServices.a(googlenowsendcardparams, s, h);
    }

    public void a(String s, h h)
    {
        h = new e(new g(h));
        mServices.a(s, h);
    }
}
