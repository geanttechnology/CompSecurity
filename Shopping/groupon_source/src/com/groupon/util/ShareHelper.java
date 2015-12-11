// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import com.groupon.models.country.Country;
import com.groupon.service.ShortUrlService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedProvider;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            Tracking, ArraySharedPreferences, Function0, Function1

public class ShareHelper
{

    private static final String ANONYMOUS_UTM_SOURCE = "anonymous";
    private static final String DEFAULT_UTM_CAMPAIGN = "UserReferral_ma";
    private static final String UTM_CAMPAIGN = "utm_campaign";
    private static final String UTM_SOURCE = "utm_source";
    private Context context;
    private CurrentCountryManager currentCountryManager;
    private ContextScopedProvider loggerContextScopedProvider;
    private ArraySharedPreferences loginPrefs;
    private ShortUrlService shortUrlService;
    private String title;
    private Tracking tracking;
    private String url;

    public ShareHelper(Context context1, String s, String s1)
    {
        context = context1;
        title = s;
        url = s1;
        RoboGuice.getInjector(context1).injectMembers(this);
    }

    public void shareAndLog(String s, String s1)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain").putExtra("android.intent.extra.SUBJECT", s).putExtra("android.intent.extra.TEXT", s1);
        ((Logger)loggerContextScopedProvider.get(context)).logShare(context.getClass().getSimpleName(), "", Logger.NULL_NST_FIELD);
        context.startActivity(Intent.createChooser(intent, context.getResources().getString(0x7f080370)));
        tracking.trackPageView((new StringBuilder()).append("ShareFrom").append(context.getClass().getSimpleName()).toString());
    }

    public void shareDeal()
    {
        final ProgressDialog dialog = new ProgressDialog(context);
        String s1 = loginPrefs.getString("referralCode", "");
        Uri uri = Uri.parse(url);
        com.groupon.http.Uris.Builder builder = new com.groupon.http.Uris.Builder(url);
        String s = s1;
        if (Strings.isEmpty(s1))
        {
            s = "anonymous";
        }
        builder.appendQueryParameter("utm_source", s);
        if (uri.getQueryParameter("utm_campaign") == null)
        {
            builder.appendQueryParameter("utm_campaign", "UserReferral_ma");
        }
        url = builder.build().toString();
        dialog.setInverseBackgroundForced(true);
        dialog.setMessage(context.getString(0x7f0802f0));
        shortUrlService.getShortUrl(url, null, new Function0() {

            final ShareHelper this$0;
            final ProgressDialog val$dialog;

            public void execute()
            {
                dialog.show();
            }

            
            {
                this$0 = ShareHelper.this;
                dialog = progressdialog;
                super();
            }
        }, new Function1() {

            final ShareHelper this$0;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((String)obj);
            }

            public void execute(String s2)
            {
                Object obj = context;
                int i;
                if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
                {
                    i = 0x7f0803b6;
                } else
                {
                    i = 0x7f080373;
                }
                obj = ((Context) (obj)).getString(i);
                if (Strings.notEmpty(title))
                {
                    s2 = String.format("%s\n\n%s", new Object[] {
                        title, s2
                    });
                }
                shareAndLog(((String) (obj)), s2);
            }

            
            {
                this$0 = ShareHelper.this;
                super();
            }
        }, null, new Function0() {

            final ShareHelper this$0;
            final ProgressDialog val$dialog;

            public void execute()
            {
                dialog.hide();
            }

            
            {
                this$0 = ShareHelper.this;
                dialog = progressdialog;
                super();
            }
        });
    }



}
