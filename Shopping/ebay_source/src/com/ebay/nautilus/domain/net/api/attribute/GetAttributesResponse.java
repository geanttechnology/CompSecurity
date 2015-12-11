// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.attribute;

import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class GetAttributesResponse extends EbayResponse
{
    public class Attribute
    {

        final GetAttributesResponse this$0;
        public String type;
        public final ArrayList values = new ArrayList();

        public Attribute()
        {
            this$0 = GetAttributesResponse.this;
            super();
        }
    }


    public final ArrayList attributes = new ArrayList();

    public GetAttributesResponse()
    {
    }

    private Attribute getExistingAttribute(String s)
    {
        for (Iterator iterator = attributes.iterator(); iterator.hasNext();)
        {
            Attribute attribute = (Attribute)iterator.next();
            if (attribute.type.equals(s))
            {
                return attribute;
            }
        }

        return null;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        inputstream = StreamUtil.jsonObjectFromStream(inputstream);
        if (!inputstream.has("responseStatus") || inputstream.getString("responseStatus") == null || inputstream.getString("responseStatus").equals("SUCCESS"))
        {
            break MISSING_BLOCK_LABEL_52;
        }
        ackCode = -1;
_L1:
        if (!inputstream.has("attributes"))
        {
            return;
        }
        break MISSING_BLOCK_LABEL_70;
        try
        {
            ackCode = 1;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException(inputstream);
        }
          goto _L1
        JSONArray jsonarray;
        int j;
        jsonarray = inputstream.getJSONArray("attributes");
        j = jsonarray.length();
        int i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        Attribute attribute;
        String s;
        String s1;
        inputstream = jsonarray.getJSONObject(i).getJSONObject("attribute");
        s = inputstream.getString("attributeType");
        s1 = inputstream.getString("attributeValue");
        attribute = getExistingAttribute(s);
        inputstream = attribute;
        if (attribute != null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        inputstream = new Attribute();
        attributes.add(inputstream);
        inputstream.type = s;
        ((Attribute) (inputstream)).values.add(s1);
        i++;
        if (true) goto _L3; else goto _L2
_L2:
    }
}
