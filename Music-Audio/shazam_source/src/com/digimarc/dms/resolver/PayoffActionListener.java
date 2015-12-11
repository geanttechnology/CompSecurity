// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.digimarc.dms.resolver:
//            ResolverService, ResolveResult

public abstract class PayoffActionListener
{

    protected Context mContext;
    protected ResolverService mResolver;

    public PayoffActionListener(Context context)
    {
        mContext = context;
    }

    public void onRedirectAction(ResolveResult resolveresult, String s, String s1)
    {
        mResolver.reportAction(s1);
        resolveresult = new Intent("android.intent.action.VIEW");
        resolveresult.setData(Uri.parse(s));
        mContext.startActivity(resolveresult);
    }

    public void onStandardPayoffResolved(ResolveResult resolveresult)
    {
    }
}
