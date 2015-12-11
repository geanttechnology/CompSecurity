// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.widget.Toast;
import com.groupon.activity.IntentFactory;
import com.groupon.service.countryanddivision.CurrentCountryManager;

// Referenced classes of package com.groupon.util:
//            Function1, AbstractRetryAsyncTask, CountryUtil

class this._cls0
    implements Function1
{

    final AbstractRetryAsyncTask this$0;

    public void execute(Exception exception)
    {
        Toast.makeText(AbstractRetryAsyncTask.access$000(AbstractRetryAsyncTask.this).getApplicationContext(), String.format(AbstractRetryAsyncTask.access$100(AbstractRetryAsyncTask.this).getString(0x7f08017d), new Object[] {
            countryUtil.getDisplayNameByIsoName(AbstractRetryAsyncTask.access$200(AbstractRetryAsyncTask.this).getCurrentCountry())
        }), 1).show();
        AbstractRetryAsyncTask.access$400(AbstractRetryAsyncTask.this).startActivity(intentFactory.newLoginIntentWithBackNavigationToCarousel(AbstractRetryAsyncTask.access$300(AbstractRetryAsyncTask.this), intentFactory.newCarouselIntent()));
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Exception)obj);
    }

    rentCountryManager()
    {
        this$0 = AbstractRetryAsyncTask.this;
        super();
    }
}
