// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.u;

import android.content.Context;
import com.facebook.GraphRequest;
import com.facebook.p;
import com.shazam.android.persistence.n.b;
import com.shazam.b.e.a;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
    implements com.facebook.GraphRequest.b
{

    final Context a;
    public final ExecutorService b;
    public final Runnable c = new Runnable() {

        final c a;

        public final void run()
        {
            GraphRequest.a(a.a, a).a();
        }

            
            {
                a = c.this;
                super();
            }
    };
    private final b d;

    public c(Context context, b b1, ExecutorService executorservice)
    {
        a = context;
        d = b1;
        b = executorservice;
    }

    public final String a()
    {
        return d.h("pk_facebook_app_id");
    }

    public final void a(p p1)
    {
        if (p1 == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        try
        {
            p1 = p1.a;
        }
        // Misplaced declaration of an exception variable
        catch (p p1)
        {
            return;
        }
        if (p1 == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        p1 = p1.getString("custom_audience_third_party_id");
        if (com.shazam.b.e.a.c(p1))
        {
            d.b("pk_facebook_app_id", p1);
        }
    }
}
