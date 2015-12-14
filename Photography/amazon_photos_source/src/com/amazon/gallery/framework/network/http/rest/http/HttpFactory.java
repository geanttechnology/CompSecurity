// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.http;

import android.content.Context;
import com.amazon.clouddrive.internal.BasicSourceInfo;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public interface HttpFactory
    extends AccountChangeListener
{

    public abstract HttpClient getHttpClient(Context context);

    public abstract HttpGet getHttpGetRequest()
        throws InvalidParameterException;

    public abstract HttpPost getHttpPostRequest()
        throws InvalidParameterException;

    public abstract BasicSourceInfo getSourceInfo();
}
