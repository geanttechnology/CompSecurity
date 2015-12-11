// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import android.os.AsyncTask;
import android.os.Bundle;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.OAuthLoginFragment;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            TwitterHelper

class activity extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    private PMActivity activity;
    final TwitterHelper this$0;

    public void _nr_setTrace(Trace trace)
    {
        try
        {
            _nr_trace = trace;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Trace trace)
        {
            return;
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "TwitterHelper$TwitterAsyncGetVerifierTask#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "TwitterHelper$TwitterAsyncGetVerifierTask#doInBackground", null);
          goto _L1
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            TwitterHelper.access$002(TwitterHelper.this, (new TwitterFactory()).getInstance());
            TwitterHelper.access$000(TwitterHelper.this).setOAuthConsumer(TwitterConsumerKey, TwitterConsumerSecret);
            TwitterHelper.access$102(TwitterHelper.this, TwitterHelper.access$000(TwitterHelper.this).getOAuthRequestToken("http://localhost"));
            avoid = new Bundle();
            avoid.putString("URL", TwitterHelper.access$100(TwitterHelper.this).getAuthenticationURL());
            avoid.putString("ANALYTICS_PAGE_NAME", "twitter_login_screen");
            activity.launchFragment(avoid, com/poshmark/ui/fragments/OAuthLoginFragment, null);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
            return null;
        }
        return null;
    }

    public (PMActivity pmactivity)
    {
        this$0 = TwitterHelper.this;
        super();
        activity = pmactivity;
    }
}
