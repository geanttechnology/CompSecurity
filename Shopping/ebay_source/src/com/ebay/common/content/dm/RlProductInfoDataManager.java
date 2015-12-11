// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.LruCache;
import com.ebay.common.net.util.RequestSigningUtil;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.IResponseDataHandler;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RlProductInfoDataManager extends DataManager
{
    private static final class GetRlProductInfoRequest extends EbayRequest
    {

        private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logRlProductInfo = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(com/ebay/common/content/dm/RlProductInfoDataManager$GetRlProductInfoRequest.getSimpleName(), 3, "Log RlProductInfo");
        private final AtomicInteger sequenceNumber = new AtomicInteger();
        private URL url;

        public URL getRequestUrl()
        {
            return url;
        }

        public GetRlProductInfoResponse getResponse()
        {
            return new GetRlProductInfoResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }


        public GetRlProductInfoRequest(EbaySite ebaysite, String s, String s1)
        {
            url = null;
            try
            {
                url = new URL(Uri.parse(ApiSettings.get(ApiSettings.rlForEbaySvcUrl)).buildUpon().appendPath("prodinfo").appendQueryParameter("barcode", s).appendQueryParameter("btype", s1).appendQueryParameter("key", "com.ebay.core").appendQueryParameter("platform", "android").appendQueryParameter("locale", (new StringBuilder()).append(ebaysite.localeLanguage).append("_").append(ebaysite.localeCountry).toString()).appendQueryParameter("siteid", ebaysite.id).appendQueryParameter("X-M", Integer.toString(sequenceNumber.getAndIncrement())).appendQueryParameter("X-K", "2").build().toString());
                url = RequestSigningUtil.signUrl(getHttpMethod(), url, null, RlProductInfoDataManager.rl4ebay_hmac_key);
                if (logRlProductInfo.isLoggable)
                {
                    logRlProductInfo.log(url.toString());
                }
                return;
            }
            // Misplaced declaration of an exception variable
            catch (EbaySite ebaysite)
            {
                ebaysite.printStackTrace();
            }
        }
    }

    private static final class GetRlProductInfoResponse extends EbayResponse
        implements IResponseDataHandler
    {

        protected JSONObject body;
        protected RlProductInfo result;

        public RlProductInfo getRlProductInfo()
        {
            return result;
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            body = StreamUtil.jsonObjectFromStream(inputstream);
            result = new RlProductInfo();
            if (body.has("ean"))
            {
                result.ean = body.getString("ean");
            }
            if (!body.has("keywords"))
            {
                break MISSING_BLOCK_LABEL_121;
            }
            inputstream = body.getJSONArray("keywords");
            if (inputstream.length() <= 0)
            {
                break MISSING_BLOCK_LABEL_121;
            }
            result.keywords = new String[inputstream.length()];
            int i = 0;
            do
            {
                try
                {
                    if (i >= inputstream.length())
                    {
                        break;
                    }
                    result.keywords[i] = inputstream.getString(i);
                }
                // Misplaced declaration of an exception variable
                catch (InputStream inputstream)
                {
                    throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
                }
                i++;
            } while (true);
            if (body.has("voyager_query"))
            {
                result.voyagerQuery = body.getString("voyager_query");
            }
            return;
        }

        private GetRlProductInfoResponse()
        {
            result = null;
        }

    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return new KeyParams(parcel.readString());
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public final String uniquifier;

        public RlProductInfoDataManager createManager(EbayContext ebaycontext)
        {
            return new RlProductInfoDataManager(ebaycontext, com/ebay/common/content/dm/RlProductInfoDataManager$Observer);
        }

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj == null || obj.getClass() != getClass())
            {
                return false;
            } else
            {
                obj = (KeyParams)obj;
                return uniquifier.equals(((KeyParams) (obj)).uniquifier);
            }
        }

        public int hashCode()
        {
            return super.hashCode() * 31 + uniquifier.hashCode();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(uniquifier);
        }


        public KeyParams()
        {
            this(UUID.randomUUID().toString());
        }

        protected KeyParams(String s)
        {
            uniquifier = s;
        }
    }

    public static interface Observer
    {

        public abstract void onProdInfoQueryStarted(ProdInfoQuery prodinfoquery);

        public abstract void onProductInfoRetrieved(ProdInfoQuery prodinfoquery, RlProductInfo rlproductinfo);
    }

    public final class ProdInfoLoadTask extends AsyncTask
    {

        private ProdInfoQuery param;
        final RlProductInfoDataManager this$0;

        protected transient RlProductInfo doInBackground(ProdInfoQuery aprodinfoquery[])
        {
            Object obj = null;
            if (isCancelled())
            {
                return null;
            }
            if (aprodinfoquery.length != 1 || aprodinfoquery[0] == null)
            {
                throw new InvalidParameterException("ProdInfoLoadTask expects a single param");
            }
            param = aprodinfoquery[0];
            try
            {
                aprodinfoquery = new GetRlProductInfoRequest(param.site, param.barcode, param.barcodeType);
                aprodinfoquery = ((GetRlProductInfoResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(getEbayContext(), aprodinfoquery)).getRlProductInfo();
            }
            // Misplaced declaration of an exception variable
            catch (ProdInfoQuery aprodinfoquery[])
            {
                aprodinfoquery.printStackTrace();
                aprodinfoquery = obj;
            }
            // Misplaced declaration of an exception variable
            catch (ProdInfoQuery aprodinfoquery[])
            {
                aprodinfoquery.printStackTrace();
                aprodinfoquery = obj;
            }
            // Misplaced declaration of an exception variable
            catch (ProdInfoQuery aprodinfoquery[])
            {
                aprodinfoquery.printStackTrace();
                aprodinfoquery = obj;
            }
            // Misplaced declaration of an exception variable
            catch (ProdInfoQuery aprodinfoquery[])
            {
                aprodinfoquery.printStackTrace();
                aprodinfoquery = obj;
            }
            // Misplaced declaration of an exception variable
            catch (ProdInfoQuery aprodinfoquery[])
            {
                aprodinfoquery.printStackTrace();
                aprodinfoquery = obj;
            }
            return aprodinfoquery;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((ProdInfoQuery[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleProdInfoLoaded(param, null);
        }

        protected void onPostExecute(RlProductInfo rlproductinfo)
        {
            super.onPostExecute(rlproductinfo);
            handleProdInfoLoaded(param, rlproductinfo);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((RlProductInfo)obj);
        }

        public ProdInfoLoadTask()
        {
            this$0 = RlProductInfoDataManager.this;
            super();
            param = null;
        }
    }

    public static class ProdInfoQuery
    {

        public String barcode;
        public String barcodeType;
        public EbaySite site;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (ProdInfoQuery)obj;
                if (!barcode.equals(((ProdInfoQuery) (obj)).barcode) || !barcodeType.equals(((ProdInfoQuery) (obj)).barcodeType) || !site.equals(((ProdInfoQuery) (obj)).site))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return ((barcode.hashCode() + 31) * 31 + barcodeType.hashCode()) * 31 + site.hashCode();
        }

        public ProdInfoQuery(EbaySite ebaysite, String s, String s1)
        {
            site = ebaysite;
            barcode = s;
            barcodeType = s1;
        }
    }

    public static final class RlProductInfo
    {

        private static char INVALID_KEYWORD_CHARACTERS[] = {
            '\''
        };
        public String ean;
        public String keywords[];
        public String voyagerQuery;

        public String getKeywordQueryString()
        {
            if (keywords != null) goto _L2; else goto _L1
_L1:
            Object obj1 = "";
_L4:
            return ((String) (obj1));
_L2:
            Object obj = new StringBuilder();
            boolean flag = true;
            obj1 = keywords;
            int l = obj1.length;
            for (int i = 0; i < l; i++)
            {
                String s = obj1[i];
                if (!flag)
                {
                    ((StringBuilder) (obj)).append(" ");
                }
                flag = false;
                ((StringBuilder) (obj)).append(s);
            }

            obj = ((StringBuilder) (obj)).toString();
            char ac[] = INVALID_KEYWORD_CHARACTERS;
            int k = ac.length;
            int j = 0;
            do
            {
                obj1 = obj;
                if (j >= k)
                {
                    continue;
                }
                char c = ac[j];
                obj1 = obj;
                if (((String) (obj)).indexOf(c) >= 0)
                {
                    obj1 = ((String) (obj)).replace(c, ' ');
                }
                j++;
                obj = obj1;
            } while (true);
            if (true) goto _L4; else goto _L3
_L3:
        }

        public String toString()
        {
            return String.format("EAN: %s, KEYWORDS: (%s), QUERY: (%s)", new Object[] {
                ean, getKeywordQueryString(), voyagerQuery
            });
        }


        public RlProductInfo()
        {
        }
    }


    public static final KeyParams KEY = new KeyParams();
    private static byte rl4ebay_hmac_key[] = {
        9, 90, 125, -42, 122, -41, -2, 27, -46, -61, 
        61, 107, -5, 19, -24, 56, -61, 67, -70, 97, 
        11, 7, -64, 10, -25, -127, 36, 117, 30, 116, 
        44, 34
    };
    private final LruCache resultCache = new LruCache(25);

    protected RlProductInfoDataManager(EbayContext ebaycontext, Class class1)
    {
        super(ebaycontext, class1);
    }

    public static String getRLKeywordsSynchronous(EbayContext ebaycontext, EbaySite ebaysite, String s, String s1)
    {
        Object obj = null;
        try
        {
            ebaysite = new GetRlProductInfoRequest(ebaysite, s, s1);
            ebaysite = (GetRlProductInfoResponse)ebaycontext.getConnector().sendRequest(ebaysite);
        }
        // Misplaced declaration of an exception variable
        catch (EbayContext ebaycontext)
        {
            return null;
        }
        if (ebaysite == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        if (ebaysite.getResultStatus() == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        ebaycontext = obj;
        if (ebaysite.getResultStatus().hasError())
        {
            break MISSING_BLOCK_LABEL_69;
        }
        ebaysite = ebaysite.getRlProductInfo();
        ebaycontext = obj;
        if (ebaysite == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        ebaycontext = ebaysite.getKeywordQueryString();
        return ebaycontext;
    }

    private void handleProdInfoLoaded(ProdInfoQuery prodinfoquery, RlProductInfo rlproductinfo)
    {
        if (rlproductinfo != null)
        {
            resultCache.put(prodinfoquery, rlproductinfo);
        }
        ((Observer)dispatcher).onProductInfoRetrieved(prodinfoquery, rlproductinfo);
    }

    public Object getParams()
    {
        return KEY;
    }

    public ProdInfoQuery getProductInfo(ProdInfoQuery prodinfoquery, Observer observer)
    {
        RlProductInfo rlproductinfo = (RlProductInfo)resultCache.get(prodinfoquery);
        if (rlproductinfo != null)
        {
            observer.onProductInfoRetrieved(prodinfoquery, rlproductinfo);
            return null;
        }
        executeOnThreadPool(new ProdInfoLoadTask(), new ProdInfoQuery[] {
            prodinfoquery
        });
        if (observer != null)
        {
            observer.onProdInfoQueryStarted(prodinfoquery);
        }
        ((Observer)dispatcher).onProdInfoQueryStarted(prodinfoquery);
        return prodinfoquery;
    }

    public ProdInfoQuery getProductInfo(EbaySite ebaysite, String s, String s1, Observer observer)
    {
        return getProductInfo(new ProdInfoQuery(ebaysite, s, s1), observer);
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }



}
