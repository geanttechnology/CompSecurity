// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest;

import android.content.Context;
import com.amazon.clouddrive.internal.BasicSourceInfo;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.MediaItemIdErrorHandlerFactory;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.HttpConfig;
import com.amazon.gallery.framework.network.http.rest.account.UserManager;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.framework.network.http.rest:
//            RestClient

public class DummyRestClient extends RestClient
{

    public DummyRestClient(Context context, DeviceAttributeStore deviceattributestore)
    {
        super(context, new HttpConfig() {

            public Endpoint getDefaultEndpoint(String s, int i)
            {
                return new Endpoint("DummyClient", false);
            }

            public boolean isDefaultEndpointSticky()
            {
                return false;
            }

        }, new NetworkConnectivity(context), new UserManager() {

            public Endpoint getStoredEndpointFromSharedPreferences(String s)
            {
                return null;
            }

            public void removeEndpointSharedPreferences(String s)
            {
            }

            public void storeEndpointInSharedPreferences(String s, Endpoint endpoint)
            {
            }

        }, new AuthenticationManager() {

            public String getAccountId()
            {
                return null;
            }

            public String getPFM()
            {
                return null;
            }

            public boolean hasActiveAccount()
            {
                return false;
            }

        }, new HttpFactory() {

            public HttpClient getHttpClient(Context context1)
            {
                return null;
            }

            public HttpGet getHttpGetRequest()
                throws InvalidParameterException
            {
                return null;
            }

            public HttpPost getHttpPostRequest()
                throws InvalidParameterException
            {
                return null;
            }

            public BasicSourceInfo getSourceInfo()
            {
                return null;
            }

            public void onAccountDeregistered()
            {
            }

            public void onAccountRegistered()
            {
            }

        }, new HttpFactory() {

            public HttpClient getHttpClient(Context context1)
            {
                return null;
            }

            public HttpGet getHttpGetRequest()
                throws InvalidParameterException
            {
                return null;
            }

            public HttpPost getHttpPostRequest()
                throws InvalidParameterException
            {
                return null;
            }

            public BasicSourceInfo getSourceInfo()
            {
                return null;
            }

            public void onAccountDeregistered()
            {
            }

            public void onAccountRegistered()
            {
            }

        }, new MediaItemIdErrorHandlerFactory(null) {

        }, null, null, null);
    }

    public JSONObject executeOperation(AbstractHttpMessage abstracthttpmessage)
        throws TerminalException, TransientException
    {
        throw new TerminalException("Dummy Rest Client Doesn't Make Calls");
    }
}
