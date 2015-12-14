// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations;

import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpGetMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import com.amazon.gallery.framework.network.http.senna.model.ContactInfo;
import java.net.URI;
import org.json.JSONObject;

public class GetContactInfoOperation extends AbstractHttpGetMessage
{

    private static final String TAG = com/amazon/gallery/framework/network/http/senna/operations/GetContactInfoOperation.getName();

    public GetContactInfoOperation(HttpFactory httpfactory)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.GetContactInfo);
    }

    public ContactInfo buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        if (jsonobject != null)
        {
            ContactInfo contactinfo = new ContactInfo();
            contactinfo.setName(jsonobject.optString("name", null));
            contactinfo.setEmail(jsonobject.optString("email", null));
            contactinfo.setTextPhoneNumber(jsonobject.optString("textPhoneNumber", null));
            contactinfo.setSmsAllowed(jsonobject.optBoolean("smsServiceAvailable", true));
            return contactinfo;
        } else
        {
            return null;
        }
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    protected URI getURI(String s)
    {
        return URI.create((new StringBuilder()).append(s).append("account/contactinfo/CUSTOMER_ID").toString());
    }

}
