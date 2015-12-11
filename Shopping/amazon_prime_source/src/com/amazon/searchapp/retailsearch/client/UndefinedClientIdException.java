// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.web.ServiceException;

public class UndefinedClientIdException extends ServiceException
{

    public UndefinedClientIdException()
    {
        super("Client ID is required. See https://w.amazon.com/index.php/SearchExperience/Search_Rendering_Data_Service/RequestClientId. Define your application's client ID using the RetailSearchClient.Builder.setClientId method.");
    }
}
