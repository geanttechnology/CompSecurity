// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.auth.mapr5;

import android.content.Context;
import com.amazon.clouddrive.internal.BasicSourceInfo;
import com.amazon.gallery.framework.data.dao.remotestorage.RemoteStorageDao;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.MediaItemIdErrorHandlerFactory;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.HttpConfig;
import com.amazon.gallery.framework.network.http.rest.account.UserManager;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public class MapRestClient extends RestClient
{
    private static class AuthenticationAwareHttpFactory
        implements HttpFactory
    {

        private final HttpFactory _flddelegate;

        public HttpClient getHttpClient(Context context)
        {
            return _flddelegate.getHttpClient(context);
        }

        public HttpGet getHttpGetRequest()
            throws InvalidParameterException
        {
            return _flddelegate.getHttpGetRequest();
        }

        public HttpPost getHttpPostRequest()
            throws InvalidParameterException
        {
            return _flddelegate.getHttpPostRequest();
        }

        public BasicSourceInfo getSourceInfo()
        {
            return _flddelegate.getSourceInfo();
        }

        public void onAccountDeregistered()
        {
            _flddelegate.onAccountDeregistered();
        }

        public void onAccountRegistered()
        {
            _flddelegate.onAccountRegistered();
        }

        private AuthenticationAwareHttpFactory(HttpFactory httpfactory)
        {
            _flddelegate = httpfactory;
        }

    }


    public MapRestClient(Context context, HttpConfig httpconfig, NetworkConnectivity networkconnectivity, UserManager usermanager, AuthenticationManager authenticationmanager, HttpFactory httpfactory, MediaItemIdErrorHandlerFactory mediaitemiderrorhandlerfactory, 
            DeviceAttributeStore deviceattributestore, CloudDriveServiceClientManager clouddriveserviceclientmanager, RemoteStorageDao remotestoragedao)
    {
        super(context, httpconfig, networkconnectivity, usermanager, authenticationmanager, new AuthenticationAwareHttpFactory(httpfactory), httpfactory, mediaitemiderrorhandlerfactory, deviceattributestore, clouddriveserviceclientmanager, remotestoragedao);
    }
}
