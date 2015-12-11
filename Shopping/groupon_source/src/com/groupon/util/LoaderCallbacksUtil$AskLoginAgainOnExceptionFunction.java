// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.widget.Toast;
import com.groupon.activity.IntentFactory;
import com.groupon.models.country.Country;

// Referenced classes of package com.groupon.util:
//            Function1, LoaderCallbacksUtil, CountryUtil

protected static class intentFactory
    implements Function1
{

    protected final Context context;
    private final Country country;
    private final CountryUtil countryUtil;
    protected final IntentFactory intentFactory;

    public void execute(Exception exception)
    {
        Toast.makeText(context.getApplicationContext(), String.format(context.getString(0x7f08017d), new Object[] {
            countryUtil.getDisplayNameByIsoName(country)
        }), 1).show();
        context.startActivity(intentFactory.newLoginIntentWithBackNavigationToCarousel(context, intentFactory.newCarouselIntent()));
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Exception)obj);
    }

    public (Context context1, CountryUtil countryutil, Country country1, IntentFactory intentfactory)
    {
        context = context1;
        countryUtil = countryutil;
        country = country1;
        intentFactory = intentfactory;
    }
}
