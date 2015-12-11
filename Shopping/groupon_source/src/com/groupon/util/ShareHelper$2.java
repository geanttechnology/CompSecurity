// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            Function1, ShareHelper

class this._cls0
    implements Function1
{

    final ShareHelper this$0;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((String)obj);
    }

    public void execute(String s)
    {
        Object obj = ShareHelper.access$100(ShareHelper.this);
        int i;
        if (ShareHelper.access$000(ShareHelper.this).getCurrentCountry().isSellerOfRecordCountry())
        {
            i = 0x7f0803b6;
        } else
        {
            i = 0x7f080373;
        }
        obj = ((Context) (obj)).getString(i);
        if (Strings.notEmpty(ShareHelper.access$200(ShareHelper.this)))
        {
            s = String.format("%s\n\n%s", new Object[] {
                ShareHelper.access$200(ShareHelper.this), s
            });
        }
        shareAndLog(((String) (obj)), s);
    }

    try()
    {
        this$0 = ShareHelper.this;
        super();
    }
}
