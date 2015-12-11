// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import android.widget.Toast;
import com.groupon.activity.IntentFactory;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CountryUtil;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.manager:
//            ExceptionManager

protected class this._cls0
    implements Function1
{

    final ExceptionManager this$0;

    public void execute(Exception exception)
    {
        Toast.makeText(ExceptionManager.access$100(ExceptionManager.this).getApplicationContext(), String.format(ExceptionManager.access$100(ExceptionManager.this).getString(0x7f08017d), new Object[] {
            ExceptionManager.access$300(ExceptionManager.this).getDisplayNameByIsoName(ExceptionManager.access$200(ExceptionManager.this).getCurrentCountry())
        }), 1).show();
        ExceptionManager.access$100(ExceptionManager.this).startActivity(ExceptionManager.access$400(ExceptionManager.this).newLoginIntent(ExceptionManager.access$100(ExceptionManager.this), ExceptionManager.access$400(ExceptionManager.this).newCarouselIntent()));
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Exception)obj);
    }

    protected ()
    {
        this$0 = ExceptionManager.this;
        super();
    }
}
