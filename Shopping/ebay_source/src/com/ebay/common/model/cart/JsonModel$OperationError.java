// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.text.TextUtils;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            JsonModel

public static final class ebayItemId
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    public final String category;
    public final String domain;
    public final String ebayItemId;
    public final String errorId;
    public final String exceptionId;
    public final String message;
    public final List parameters;
    public final String severity;
    public final String subdomain;

    public String get(String s)
    {
        Object obj1 = null;
        Iterator iterator = parameters.iterator();
        Object obj;
        do
        {
            obj = obj1;
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (parameters)iterator.next();
            if (((parameters) (obj)).parameters == null || !((parameters) (obj)).parameters.equalsIgnoreCase(s))
            {
                continue;
            }
            obj = ((parameters) (obj)).parameters;
            break;
        } while (true);
        return ((String) (obj));
    }

    public String getErrorCode()
    {
        return get("nativeErrorCode");
    }

    public String getMessage()
    {
        return get("nativeErrorMsg");
    }

    public boolean isError()
    {
        boolean flag = false;
        if (severity != null)
        {
            flag = severity.equalsIgnoreCase("error");
        }
        return flag;
    }

    public boolean isWarning()
    {
        boolean flag = false;
        if (severity != null)
        {
            flag = severity.equalsIgnoreCase("warning");
        }
        return flag;
    }

    public e(EbayContext ebaycontext, com.ebay.nautilus.kernel.content. )
    {
        errorId = Integer.toString(.d());
        domain = .omain();
        subdomain = null;
        category = .ategory();
        message = .hortMessage(ebaycontext);
        severity = .everity().e();
        exceptionId = null;
        parameters = null;
        ebayItemId = null;
    }

    public ebayItemId(JSONObject jsonobject)
        throws JSONException
    {
        errorId = JsonModel.getString(jsonobject, "errorId");
        domain = JsonModel.getString(jsonobject, "domain");
        subdomain = JsonModel.getString(jsonobject, "subdomain");
        severity = JsonModel.getString(jsonobject, "severity");
        category = JsonModel.getString(jsonobject, "category");
        message = JsonModel.getString(jsonobject, "message");
        exceptionId = JsonModel.getString(jsonobject, "exceptionId");
        Object obj = null;
        Object obj1 = null;
        parameters = new ArrayList();
        if (jsonobject.has("parameter"))
        {
            JSONArray jsonarray = jsonobject.getJSONArray("parameter");
            int i = 0;
            jsonobject = obj1;
            do
            {
                obj = jsonobject;
                if (i >= jsonarray.length())
                {
                    break;
                }
                ebayItemId ebayitemid = new parameters(jsonarray.getJSONObject(i));
                if ("baseIdentifier".equals(ebayitemid.parameters))
                {
                    obj = jsonobject;
                    if (!TextUtils.isEmpty(ebayitemid.parameters))
                    {
                        obj = jsonobject;
                        if (ebayitemid.parameters.startsWith("ItemId="))
                        {
                            obj = ebayitemid.parameters.substring("ItemId=".length());
                        }
                    }
                } else
                {
                    parameters.add(ebayitemid);
                    obj = jsonobject;
                }
                i++;
                jsonobject = ((JSONObject) (obj));
            } while (true);
        }
        ebayItemId = ((String) (obj));
    }
}
