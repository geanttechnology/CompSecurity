// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.autocomplete;

import com.ebay.common.model.AutoFillSuggestion;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.IResponseDataHandler;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AutoSuggestionSearch
{
    private static final class AutoSuggestionRequest extends Request
    {

        private final String query;
        private final int siteId;

        private static String cleanQuery(String s)
        {
            return s.replace("\"", "").replace("\\", "");
        }

        public URL getRequestUrl()
        {
            URL url;
            try
            {
                url = new URL(EbaySettings.getAutoSuggestionQuery(siteId, query));
            }
            catch (MalformedURLException malformedurlexception)
            {
                malformedurlexception.printStackTrace();
                return null;
            }
            return url;
        }

        public AutoSuggestionResponse getResponse()
        {
            return new AutoSuggestionResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public String getUserAgent()
        {
            return EbayAppCredentials.get(getEbayContext()).userAgent;
        }

        public AutoSuggestionRequest(int i, String s)
        {
            query = cleanQuery(s);
            siteId = i;
            setServiceName("SearchAutoSuggestionService");
            setOperationName("autoSuggestion");
        }
    }

    private static final class AutoSuggestionResponse extends Response
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
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
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
                throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException(inputstream);
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

        private AutoSuggestionResponse()
        {
            results = new ArrayList();
        }

    }


    public AutoSuggestionSearch()
    {
    }

    public static ArrayList execute(EbayContext ebaycontext, EbayCountry ebaycountry, String s)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return ((AutoSuggestionResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(ebaycontext, new AutoSuggestionRequest(ebaycountry.getSiteId(), s))).results;
    }
}
