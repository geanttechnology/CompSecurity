// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations;

import android.util.Log;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.account.AccountDetails;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpGetMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;

public class GetAccountDetailsOperation extends AbstractHttpGetMessage
{

    public GetAccountDetailsOperation(HttpFactory httpfactory)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.GetAccountDetails);
    }

    public AccountDetails buildResponse(JSONObject jsonobject)
    {
        Log.v("GetAccountDetailsOperation", "Senna get account details Succeeded");
        try
        {
            jsonobject = new AccountDetails(jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            GLogger.wx("GetAccountDetailsOperation", "error parsing account details", jsonobject);
            return null;
        }
        return jsonobject;
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    protected URI getURI(String s)
    {
        return URI.create((new StringBuilder()).append(s).append("account/details/CUSTOMER_ID").toString());
    }
}
