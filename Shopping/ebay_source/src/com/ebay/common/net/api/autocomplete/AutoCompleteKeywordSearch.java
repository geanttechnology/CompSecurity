// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.autocomplete;

import com.ebay.common.model.KeywordSuggestion;
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

// Referenced classes of package com.ebay.common.net.api.autocomplete:
//            AutoCompleteApi

public class AutoCompleteKeywordSearch
{
    private static final class SearchRequest extends Request
    {

        private static final String FETCH_SIZE = "20";
        private final String dictionaryName;
        private final String query;
        private boolean useChildSite;

        public URL getRequestUrl()
        {
            URL url;
            try
            {
                url = new URL(EbaySettings.getAutoCompleteQuery("20", dictionaryName, query, false, useChildSite));
            }
            catch (MalformedURLException malformedurlexception)
            {
                return null;
            }
            return url;
        }

        public SearchResponse getResponse()
        {
            return new SearchResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public String getUserAgent()
        {
            return EbayAppCredentials.get(getEbayContext()).userAgent;
        }

        public SearchRequest(int i, String s)
        {
            useChildSite = false;
            query = s;
            dictionaryName = AutoCompleteApi.getKeywordDictionaryForSiteId(i);
            useChildSite = AutoCompleteApi.useChildSiteForSiteId(i);
            setServiceName("AutoCompleteQueryService");
            setOperationName("KeywordSearch");
        }
    }

    private static final class SearchResponse extends Response
        implements IResponseDataHandler
    {

        public ArrayList results;

        private int indexOfString(JSONArray jsonarray, String s)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
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
                    throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException(jsonarray);
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
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
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
                throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException(inputstream);
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

        private SearchResponse()
        {
            results = new ArrayList();
        }

    }


    public AutoCompleteKeywordSearch()
    {
    }

    public static ArrayList execute(EbayContext ebaycontext, EbayCountry ebaycountry, String s)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return ((SearchResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(ebaycontext, new SearchRequest(ebaycountry.getSiteId(), s))).results;
    }
}
