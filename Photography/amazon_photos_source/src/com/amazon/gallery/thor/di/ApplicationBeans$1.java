// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.di;

import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.network.http.rest.account.KindleProdHttpConfig;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.OneBoxHttpConfig;

// Referenced classes of package com.amazon.gallery.thor.di:
//            ApplicationBeans

static final class val.authManager
    implements com.amazon.gallery.framework.kindle.widget.lback
{

    final AuthenticationManager val$authManager;
    final RestClient val$restClient;

    public volatile void run(String s, Object obj)
    {
        run(s, (String)obj);
    }

    public void run(String s, String s1)
    {
        if (s1.contentEquals("1box"))
        {
            val$restClient.setConfig(new OneBoxHttpConfig());
        } else
        if (s1.contentEquals("prod"))
        {
            val$restClient.setConfig(new KindleProdHttpConfig(val$authManager));
            return;
        }
    }

    nticationManager(RestClient restclient, AuthenticationManager authenticationmanager)
    {
        val$restClient = restclient;
        val$authManager = authenticationmanager;
        super();
    }
}
