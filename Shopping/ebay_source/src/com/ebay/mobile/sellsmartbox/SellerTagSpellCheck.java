// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sellsmartbox;

import android.net.Uri;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.IResponseDataHandler;
import com.ebay.nautilus.kernel.net.IResponseHeaderHandler;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class SellerTagSpellCheck
{
    private static final class SpellCheckRequest extends Request
    {

        private final EbayCountry country;
        private final String query;

        public URL getRequestUrl()
        {
            URL url;
            try
            {
                url = new URL(Uri.parse((new StringBuilder("http://cgi5.")).append(country.getSiteDomain()).append("/").append("ws/eBayISAPI.dll?MfcISAPICommand=Syi3GetSellerTags").toString()).buildUpon().appendQueryParameter("siteId", (new StringBuilder()).append("").append(country.getSiteId()).toString()).appendQueryParameter("catId", "0").appendQueryParameter("actionId", "4").appendQueryParameter("originalValue", query).build().toString());
            }
            catch (MalformedURLException malformedurlexception)
            {
                return null;
            }
            return url;
        }

        public SpellCheckResponse getResponse()
        {
            return new SpellCheckResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public String getUserAgent()
        {
            return EbayAppCredentials.get(getEbayContext()).userAgent;
        }

        public SpellCheckRequest(EbayCountry ebaycountry, String s)
        {
            query = s;
            country = ebaycountry;
        }
    }

    private static final class SpellCheckResponse extends Response
        implements IResponseDataHandler
    {

        public int responseCode;
        public String suggestion;

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

        public IResponseHeaderHandler getHeaderHandler()
        {
            return null;
        }

        public boolean hasSuccessResponseCode()
        {
            return responseCode == 200;
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            try
            {
                inputstream = StreamUtil.jsonObjectFromStream(inputstream);
                if (!inputstream.has("SugVal"))
                {
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException(inputstream);
            }
            suggestion = (String)inputstream.get("SugVal");
            return;
        }

        public void setRequestTime(long l)
        {
        }

        public void setResponseCode(int i, String s)
        {
            responseCode = i;
        }

        private SpellCheckResponse()
        {
            responseCode = -1;
        }

    }


    private static final String SELLER_TAG_PATH = "ws/eBayISAPI.dll?MfcISAPICommand=Syi3GetSellerTags";

    public SellerTagSpellCheck()
    {
    }

    public static String execute(EbayContext ebaycontext, EbayCountry ebaycountry, String s)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        if (NautilusKernel.isQaMode())
        {
            return null;
        } else
        {
            return ((SpellCheckResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(ebaycontext, new SpellCheckRequest(ebaycountry, s))).suggestion;
        }
    }
}
