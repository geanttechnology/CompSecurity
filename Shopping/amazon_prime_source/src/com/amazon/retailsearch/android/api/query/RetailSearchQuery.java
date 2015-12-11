// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.query;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.deviceinfo.DeviceInfoLoader;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.client.SearchMethod;
import com.amazon.searchapp.retailsearch.client.SearchRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.api.query:
//            Query, QuerySource

public class RetailSearchQuery
    implements Parcelable, Query, Cloneable
{

    private static final String ADDRESS = "ad";
    private static final String ALIAS_REFINEMENT = "i";
    public static final String APS_ALIAS = "aps";
    private static final String BBN = "bbn";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RetailSearchQuery createFromParcel(Parcel parcel)
        {
            return new RetailSearchQuery(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public RetailSearchQuery[] newArray(int i)
        {
            return new RetailSearchQuery[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String INTENT_EXTRA_KEY = com/amazon/retailsearch/android/api/query/RetailSearchQuery.getName();
    private static final String KEYWORDS_REFINEMENT = "k";
    public static final String MERCHANT_ID = "field-enc-merchantbin";
    private static final String NODE_REFINEMENT = "n";
    private static final int PRIME = 29;
    private static final String REFINEMENT_SEPERATOR = ",";
    private static final String REFINEMENT_VALUE_SEPARATOR = ":";
    private static final String STORE_DISCIMINATOR = "p_95";
    private String address;
    private String alias;
    private String asins;
    private String asrRequestId;
    private String bbnId;
    FeatureConfiguration featureConfig;
    private int interpretationNum;
    private boolean isPrefetching;
    private boolean isPrefetchingAccepted;
    private Map issEngagementData;
    private String keywords;
    private String merchantId;
    private long node;
    private String rawUserInput;
    private String refTag;
    private String rrid;
    private SearchMethod searchMethod;
    private String searchUrl;
    private QuerySource source;
    private String storeDiscriminator;
    private String utteranceId;

    private RetailSearchQuery()
    {
        RetailSearchDaggerGraphController.inject(this);
    }

    public RetailSearchQuery(Uri uri)
    {
        this();
        searchUrl = uri.toString();
    }

    public RetailSearchQuery(Parcel parcel)
    {
        this();
        readFromParcel(parcel);
    }

    public RetailSearchQuery(String s)
    {
        this(null, s);
    }

    public RetailSearchQuery(String s, String s1)
    {
        this(s, s1, null);
    }

    public RetailSearchQuery(String s, String s1, String s2)
    {
        this(s, s1, s2, null);
    }

    public RetailSearchQuery(String s, String s1, String s2, Map map)
    {
        this();
        String s3 = s;
        if (s == null)
        {
            s3 = "aps";
        }
        alias = s3;
        keywords = s1;
        rawUserInput = s2;
        issEngagementData = map;
    }

    private void addRefinementItem(StringBuilder stringbuilder, String s, String s1)
    {
        if (stringbuilder.length() > 0)
        {
            stringbuilder.append(",");
        }
        stringbuilder.append(s).append(":").append(s1);
    }

    public static RetailSearchQuery fromAsins(String s)
    {
        RetailSearchQuery retailsearchquery = new RetailSearchQuery();
        retailsearchquery.alias = "aps";
        retailsearchquery.asins = s;
        return retailsearchquery;
    }

    public static RetailSearchQuery fromUrl(String s)
    {
        RetailSearchQuery retailsearchquery = new RetailSearchQuery();
        retailsearchquery.setSearchUrl(s);
        return retailsearchquery;
    }

    private void readFromParcel(Parcel parcel)
    {
        boolean flag1 = true;
        rawUserInput = parcel.readString();
        alias = parcel.readString();
        keywords = parcel.readString();
        refTag = parcel.readString();
        node = parcel.readLong();
        source = (QuerySource)parcel.readParcelable(com/amazon/retailsearch/android/api/query/QuerySource.getClassLoader());
        searchMethod = SearchMethod.find(parcel.readString());
        searchUrl = parcel.readString();
        asrRequestId = parcel.readString();
        utteranceId = parcel.readString();
        interpretationNum = parcel.readInt();
        int j = parcel.readInt();
        if (j > 0)
        {
            issEngagementData = new HashMap();
            for (int i = 0; i < j; i++)
            {
                String s = parcel.readString();
                String s1 = parcel.readString();
                issEngagementData.put(s, s1);
            }

        }
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isPrefetching = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isPrefetchingAccepted = flag;
        rrid = parcel.readString();
        address = parcel.readString();
        merchantId = parcel.readString();
        storeDiscriminator = parcel.readString();
        asins = parcel.readString();
        bbnId = parcel.readString();
    }

    public RetailSearchQuery clone()
        throws CloneNotSupportedException
    {
        return (RetailSearchQuery)super.clone();
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAddress()
    {
        return address;
    }

    public String getAlias()
    {
        return alias;
    }

    public String getAsins()
    {
        return asins;
    }

    public String getAsrRequestId()
    {
        return asrRequestId;
    }

    public String getBbnId()
    {
        return bbnId;
    }

    public int getCachingKey()
    {
        int i2 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int j2;
        if (alias == null)
        {
            i = 0;
        } else
        {
            i = alias.hashCode();
        }
        if (keywords == null)
        {
            j = 0;
        } else
        {
            j = keywords.hashCode();
        }
        j2 = (int)node;
        if (TextUtils.isEmpty(searchUrl))
        {
            k = 0;
        } else
        {
            k = searchUrl.hashCode();
        }
        if (searchMethod == null)
        {
            l = 0;
        } else
        {
            l = searchMethod.hashCode();
        }
        if (address == null)
        {
            i1 = 0;
        } else
        {
            i1 = address.hashCode();
        }
        if (merchantId == null)
        {
            j1 = 0;
        } else
        {
            j1 = merchantId.hashCode();
        }
        if (storeDiscriminator == null)
        {
            k1 = 0;
        } else
        {
            k1 = storeDiscriminator.hashCode();
        }
        if (asins == null)
        {
            l1 = 0;
        } else
        {
            l1 = asins.hashCode();
        }
        if (bbnId != null)
        {
            i2 = bbnId.hashCode();
        }
        return (((((((((i + 29) * 29 + j) * 29 + j2) * 29 + k) * 29 + l) * 29 + i1) * 29 + j1) * 29 + k1) * 29 + l1) * 29 + i2;
    }

    public int getInterpretationNum()
    {
        return interpretationNum;
    }

    public Map getIssEngagementData()
    {
        return issEngagementData;
    }

    public String getKeywords()
    {
        return keywords;
    }

    public String getMerchantId()
    {
        return merchantId;
    }

    public long getNode()
    {
        return node;
    }

    public String getRawUserInput()
    {
        return rawUserInput;
    }

    public String getRefTag()
    {
        return refTag;
    }

    public String getRefinementsString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (!TextUtils.isEmpty(alias))
        {
            addRefinementItem(stringbuilder, "i", alias);
        }
        if (node != 0L)
        {
            addRefinementItem(stringbuilder, "n", String.valueOf(node));
        }
        if (!TextUtils.isEmpty(keywords))
        {
            addRefinementItem(stringbuilder, "k", keywords);
        }
        return stringbuilder.toString();
    }

    public String getRrid()
    {
        return rrid;
    }

    public SearchMethod getSearchMethod()
    {
        return searchMethod;
    }

    public String getSearchUrl()
    {
        return searchUrl;
    }

    public QuerySource getSource()
    {
        return source;
    }

    public String getStoreDiscriminator()
    {
        return storeDiscriminator;
    }

    public String getUtteranceId()
    {
        return utteranceId;
    }

    public boolean isAps()
    {
        return "aps".equals(alias);
    }

    public boolean isEmptyKeywords()
    {
        return TextUtils.isEmpty(keywords);
    }

    public boolean isPrefetching()
    {
        return isPrefetching;
    }

    public boolean isPrefetchingAccepted()
    {
        return isPrefetchingAccepted;
    }

    public void removePrefetchingFlags()
    {
        isPrefetching = false;
        isPrefetchingAccepted = false;
        rrid = null;
    }

    public void setAddress(String s)
    {
        address = s;
    }

    public void setAlias(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "aps";
        }
        alias = s1;
    }

    public void setAsrRequestId(String s)
    {
        asrRequestId = s;
    }

    public void setBbnId(String s)
    {
        bbnId = s;
    }

    public void setInterpretationNum(int i)
    {
        interpretationNum = i;
    }

    public void setIssEngagementData(Map map)
    {
        issEngagementData = map;
    }

    public void setKeyword(String s)
    {
        keywords = s;
    }

    public void setMerchantId(String s)
    {
        merchantId = s;
    }

    public void setNode(long l)
    {
        node = l;
    }

    public void setPrefetching(boolean flag)
    {
        isPrefetching = flag;
    }

    public void setPrefetchingAccepted(boolean flag)
    {
        isPrefetchingAccepted = flag;
    }

    public void setRawUserInput(String s)
    {
        rawUserInput = s;
    }

    public void setRefTag(String s)
    {
        refTag = s;
    }

    public void setRrid(String s)
    {
        rrid = s;
    }

    public void setSearchMethod(SearchMethod searchmethod)
    {
        searchMethod = searchmethod;
    }

    public void setSearchUrl(String s)
    {
        searchUrl = s;
    }

    public void setSource(QuerySource querysource)
    {
        source = querysource;
    }

    public void setStoreDiscriminator(String s)
    {
        storeDiscriminator = s;
    }

    public void setUtteranceId(String s)
    {
        utteranceId = s;
    }

    public SearchRequest toSearchRequest()
    {
        Object obj;
        com.amazon.searchapp.retailsearch.client.SearchRequest.Builder builder = (new com.amazon.searchapp.retailsearch.client.SearchRequest.Builder()).setImageCrop(true).setImageResolution(Integer.valueOf(0));
        if (!TextUtils.isEmpty(searchUrl))
        {
            if (featureConfig.isFeatureActivated("SX_mShop_Android_Hidden_Keyword"))
            {
                searchUrl = searchUrl.replace("|", "%7C");
            }
            builder.setDataUrl(searchUrl);
            builder.setKeywords(getKeywords());
        } else
        {
            if (!TextUtils.isEmpty(refTag))
            {
                builder.setRefTag(refTag);
            }
            builder.setKeywords(getKeywords());
            obj = getRefinementsString();
            if (obj == null)
            {
                builder.setAlias("aps");
            } else
            {
                builder.setRefinements(((String) (obj)));
                builder.setAlias(null);
            }
        }
        if (searchMethod != null)
        {
            builder.setSearchMethod(searchMethod.getName());
        }
        obj = new HashMap();
        if (!TextUtils.isEmpty(asrRequestId))
        {
            ((HashMap) (obj)).put("asrRequestId", asrRequestId);
        }
        if (!TextUtils.isEmpty(utteranceId))
        {
            ((HashMap) (obj)).put("utteranceId", utteranceId);
        }
        if (interpretationNum > 0)
        {
            ((HashMap) (obj)).put("interpretationNum", String.valueOf(interpretationNum));
        }
        if (!isPrefetching) goto _L2; else goto _L1
_L1:
        ((HashMap) (obj)).put("prefetch", "1");
_L4:
        if (!TextUtils.isEmpty(address))
        {
            ((HashMap) (obj)).put("ad", address);
        }
        if (!TextUtils.isEmpty(merchantId))
        {
            ((HashMap) (obj)).put("field-enc-merchantbin", merchantId);
        }
        if (!TextUtils.isEmpty(storeDiscriminator))
        {
            ((HashMap) (obj)).put("p_95", storeDiscriminator);
        }
        if (!TextUtils.isEmpty(asins))
        {
            ((HashMap) (obj)).put("hidden-keywords", asins);
            ((HashMap) (obj)).put("field-asin", asins);
        }
        if (!TextUtils.isEmpty(bbnId))
        {
            ((HashMap) (obj)).put("bbn", bbnId);
        }
        if (!((HashMap) (obj)).isEmpty())
        {
            builder.setParameters(((Map) (obj)));
        }
        builder.setDeviceInformation(DeviceInfoLoader.getInstance().getDeviceInfo());
        return builder.build();
_L2:
        if (isPrefetchingAccepted)
        {
            ((HashMap) (obj)).put("requestType", "prefetch-accept");
            ((HashMap) (obj)).put("pageAssemblyType", "cacheImpression");
            ((HashMap) (obj)).put("rrid", rrid);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(rawUserInput);
        parcel.writeString(alias);
        parcel.writeString(keywords);
        parcel.writeString(refTag);
        parcel.writeLong(node);
        parcel.writeParcelable(source, 0);
        Object obj;
        if (searchMethod != null)
        {
            obj = searchMethod.getName();
        } else
        {
            obj = "";
        }
        parcel.writeString(((String) (obj)));
        parcel.writeString(searchUrl);
        if (asrRequestId != null)
        {
            obj = asrRequestId;
        } else
        {
            obj = "";
        }
        parcel.writeString(((String) (obj)));
        if (utteranceId != null)
        {
            obj = utteranceId;
        } else
        {
            obj = "";
        }
        parcel.writeString(((String) (obj)));
        parcel.writeInt(interpretationNum);
        if (issEngagementData == null)
        {
            i = 0;
        } else
        {
            i = issEngagementData.size();
        }
        parcel.writeInt(i);
        if (issEngagementData != null)
        {
            String s;
            for (obj = issEngagementData.keySet().iterator(); ((Iterator) (obj)).hasNext(); parcel.writeString((String)issEngagementData.get(s)))
            {
                s = (String)((Iterator) (obj)).next();
                parcel.writeString(s);
            }

        }
        if (isPrefetching)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (isPrefetchingAccepted)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (rrid != null)
        {
            obj = rrid;
        } else
        {
            obj = "";
        }
        parcel.writeString(((String) (obj)));
        if (address != null)
        {
            obj = address;
        } else
        {
            obj = "";
        }
        parcel.writeString(((String) (obj)));
        if (merchantId != null)
        {
            obj = merchantId;
        } else
        {
            obj = "";
        }
        parcel.writeString(((String) (obj)));
        if (storeDiscriminator != null)
        {
            obj = storeDiscriminator;
        } else
        {
            obj = "";
        }
        parcel.writeString(((String) (obj)));
        if (asins != null)
        {
            obj = asins;
        } else
        {
            obj = "";
        }
        parcel.writeString(((String) (obj)));
        if (bbnId != null)
        {
            obj = bbnId;
        } else
        {
            obj = "";
        }
        parcel.writeString(((String) (obj)));
    }

}
