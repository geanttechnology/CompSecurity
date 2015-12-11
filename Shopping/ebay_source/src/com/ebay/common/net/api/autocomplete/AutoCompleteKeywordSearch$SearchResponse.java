// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.autocomplete;

import com.ebay.common.model.KeywordSuggestion;
import com.ebay.nautilus.kernel.net.IResponseDataHandler;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.autocomplete:
//            AutoCompleteKeywordSearch

private static final class <init> extends Response
    implements IResponseDataHandler
{

    public ArrayList results;

    private int indexOfString(JSONArray jsonarray, String s)
        throws com.ebay.nautilus.kernel.net.esponse
    {
        int i = 0;
        do
        {
            boolean flag;
            try
            {
                if (i >= jsonarray.length())
                {
                    break;
                }
                flag = jsonarray.getString(i).equals(s);
            }
            // Misplaced declaration of an exception variable
            catch (JSONArray jsonarray)
            {
                throw new com.ebay.nautilus.kernel.net.t>(jsonarray);
            }
            if (flag)
            {
                return i;
            }
            i++;
        } while (true);
        return -1;
    }

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
        JSONArray jsonarray;
        int i;
        int j;
        int k;
        int l;
        try
        {
            inputstream = StreamUtil.jsonObjectFromStream(inputstream);
            if (!inputstream.has("queryDictionaryResponse"))
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new com.ebay.nautilus.kernel.net.t>(inputstream);
        }
        inputstream = inputstream.getJSONObject("queryDictionaryResponse");
        if (!inputstream.has("result") || !inputstream.has("format"))
        {
            break MISSING_BLOCK_LABEL_171;
        }
        jsonarray = inputstream.getJSONObject("format").getJSONArray("name");
        j = indexOfString(jsonarray, "RANK");
        k = indexOfString(jsonarray, "TITLE");
        inputstream = inputstream.getJSONArray("result");
        l = inputstream.length();
        i = 0;
_L3:
        if (i >= l) goto _L2; else goto _L1
_L1:
        jsonarray = inputstream.getJSONObject(i).getJSONArray("value");
        if (jsonarray == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        KeywordSuggestion keywordsuggestion = new KeywordSuggestion();
        keywordsuggestion.rank = (String)jsonarray.get(j);
        keywordsuggestion.title = (String)jsonarray.get(k);
        results.add(keywordsuggestion);
        i++;
          goto _L3
_L2:
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
