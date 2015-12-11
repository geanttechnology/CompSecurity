// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics;

import com.newrelic.agent.android.NewRelic;
import com.target.a.a.b;
import com.target.mothership.services.j;
import com.target.mothership.services.u;
import com.target.mothership.services.v;
import com.target.mothership.services.x;

// Referenced classes of package com.target.ui.analytics:
//            g

class e
{
    private class a
        implements j
    {

        final e this$0;

        public com.target.mothership.services.f.a.b.b a(com.target.mothership.services.f.a.b.b b1)
            throws u
        {
            return b1;
        }

        public v a(v v, com.target.mothership.services.f.a.b.b b1)
            throws u
        {
            return v;
        }

        public x a(x x, com.target.mothership.services.f.a.b.b b1)
            throws u
        {
            e.a(e.this, x);
            return x;
        }

        private a()
        {
            this$0 = e.this;
            super();
        }

    }


    private static final String CUSTOM_HTTP_ERROR_EVENT_NAME = "TGT_EVENT_HTTP_ERROR";
    private static final String LOG_TAG = com/target/ui/analytics/e.getSimpleName();
    private final g mErrorAdapter;
    private final a mInterceptor = new a();

    private e(g g1)
    {
        mErrorAdapter = g1;
    }

    private j a()
    {
        return mInterceptor;
    }

    static j a(g g1)
    {
        return (new e(g1)).a();
    }

    private void a(x x)
    {
        try
        {
            NewRelic.recordEvent("TGT_EVENT_HTTP_ERROR", mErrorAdapter.a(x));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (x x)
        {
            b.b(LOG_TAG, "Error reporting HTTP error: ", x);
        }
    }

    static void a(e e1, x x)
    {
        e1.a(x);
    }

}
