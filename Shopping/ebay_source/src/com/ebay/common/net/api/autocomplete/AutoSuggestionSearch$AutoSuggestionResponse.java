// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.autocomplete;

import com.ebay.common.model.AutoFillSuggestion;
import com.ebay.nautilus.kernel.net.IResponseDataHandler;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.autocomplete:
//            AutoSuggestionSearch

private static final class <init> extends Response
    implements IResponseDataHandler
{

    public ArrayList results;

    public IResponseDataHandler getDataHandler()
    {
        if (hasSuccessResponseCode())
        {
            return this;
        } else
        {
            return null;
        }
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.esponse
    {
        String s;
        JSONArray jsonarray;
        int i;
        int j;
        int k;
        try
        {
            inputstream = StreamUtil.jsonObjectFromStream(inputstream);
            if (!inputstream.has("prefix"))
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new com.ebay.nautilus.kernel.net.esponse(inputstream);
        }
        if (!inputstream.has("res"))
        {
            break MISSING_BLOCK_LABEL_220;
        }
        inputstream = inputstream.getJSONObject("res");
        i = 0;
        if (!inputstream.has("categories")) goto _L2; else goto _L1
_L1:
        s = inputstream.getJSONArray("sug").getString(0);
        jsonarray = inputstream.getJSONArray("categories");
        k = 0 + 1;
        j = 0;
_L3:
        i = k;
        if (j >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONArray jsonarray1 = (JSONArray)jsonarray.get(j);
        AutoFillSuggestion autofillsuggestion1 = new AutoFillSuggestion();
        autofillsuggestion1.categoryId = jsonarray1.getString(0);
        autofillsuggestion1.categoryName = jsonarray1.getString(1);
        autofillsuggestion1.title = s;
        results.add(autofillsuggestion1);
        j++;
        if (true) goto _L3; else goto _L2
_L2:
        if (!inputstream.has("sug"))
        {
            break MISSING_BLOCK_LABEL_220;
        }
        inputstream = inputstream.getJSONArray("sug");
_L4:
        if (i >= inputstream.length())
        {
            break MISSING_BLOCK_LABEL_220;
        }
        AutoFillSuggestion autofillsuggestion = new AutoFillSuggestion();
        autofillsuggestion.title = inputstream.getString(i);
        results.add(autofillsuggestion);
        i++;
          goto _L4
    }

    private ()
    {
        results = new ArrayList();
    }

    results(results results1)
    {
        this();
    }
}
