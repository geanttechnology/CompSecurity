// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.query;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amazon.retailsearch.deviceinfo.DeviceInfoLoader;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.client.SearchMethod;
import com.amazon.searchapp.retailsearch.client.SearchRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.api.query:
//            Query, QuerySource

public class RetailSearchQuery
    implements Parcelable, Query
{

    private static final String ALIAS_REFINEMENT = "i";
    private static final String APS_ALIAS = "aps";
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
    private static final String NODE_REFINEMENT = "n";
    private static final String REFINEMENT_SEPERATOR = ",";
    private static final String REFINEMENT_VALUE_SEPARATOR = ":";
    private String alias;
    private String asrRequestId;
    private int interpretationNum;
    private Map issEngagementData;
    private String keywords;
    private long node;
    private String rawUserInput;
    private SearchMethod searchMethod;
    private String searchUrl;
    private QuerySource source;
    private String utteranceId;

    private RetailSearchQuery()
    {
    }

    public RetailSearchQuery(Uri uri)
    {
        searchUrl = uri.toString();
    }

    public RetailSearchQuery(Parcel parcel)
    {
        readFromParcel(parcel);
    }

    public RetailSearchQuery(String s)
    {
        alias = "aps";
        keywords = s;
    }

    public RetailSearchQuery(String s, String s1)
    {
        alias = s;
        keywords = s1;
    }

    public RetailSearchQuery(String s, String s1, String s2)
    {
        alias = s;
        keywords = s1;
        rawUserInput = s2;
    }

    public RetailSearchQuery(String s, String s1, String s2, Map map)
    {
        alias = s;
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

    public static RetailSearchQuery fromUrl(String s)
    {
        RetailSearchQuery retailsearchquery = new RetailSearchQuery();
        retailsearchquery.setSearchUrl(s);
        return retailsearchquery;
    }

    private void readFromParcel(Parcel parcel)
    {
        rawUserInput = parcel.readString();
        alias = parcel.readString();
        keywords = parcel.readString();
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
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag = true;
        if (obj != null)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj instanceof RetailSearchQuery)
            {
                obj = (RetailSearchQuery)obj;
                if (!Utils.isEqual(alias, ((RetailSearchQuery) (obj)).alias) || !Utils.isEqual(keywords, ((RetailSearchQuery) (obj)).keywords) || !Utils.isEqual(Long.valueOf(node), Long.valueOf(((RetailSearchQuery) (obj)).node)) || !Utils.isEqual(searchUrl, ((RetailSearchQuery) (obj)).searchUrl) || !Utils.isEqual(searchMethod, ((RetailSearchQuery) (obj)).searchMethod))
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    public String getAlias()
    {
        return alias;
    }

    public String getAsrRequestId()
    {
        return asrRequestId;
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

    public long getNode()
    {
        return node;
    }

    public String getRawUserInput()
    {
        return rawUserInput;
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

    public String getUtteranceId()
    {
        return utteranceId;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        int k;
        if ((new StringBuilder()).append(29).append(alias).toString() == null)
        {
            i = 0;
        } else
        {
            i = alias.hashCode();
        }
        if ((new StringBuilder()).append(i * 29).append(keywords).toString() == null)
        {
            i = 0;
        } else
        {
            i = keywords.hashCode();
        }
        k = (int)node;
        if ((new StringBuilder()).append((i * 29 + k) * 29).append(searchUrl).toString() == null)
        {
            i = 0;
        } else
        {
            i = searchUrl.hashCode();
        }
        if (searchMethod != null)
        {
            j = searchMethod.hashCode();
        }
        return i * 29 + j;
    }

    public boolean isAps()
    {
        return "aps".equals(alias);
    }

    public boolean isEmptyKeywords()
    {
        return TextUtils.isEmpty(keywords);
    }

    public void setAlias(String s)
    {
        alias = s;
    }

    public void setAsrRequestId(String s)
    {
        asrRequestId = s;
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

    public void setNode(long l)
    {
        node = l;
    }

    public void setRawUserInput(String s)
    {
        rawUserInput = s;
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

    public void setUtteranceId(String s)
    {
        utteranceId = s;
    }

    public SearchRequest toSearchRequest()
    {
        com.amazon.searchapp.retailsearch.client.SearchRequest.Builder builder = (new com.amazon.searchapp.retailsearch.client.SearchRequest.Builder()).setImageCrop(true).setImageResolution(Integer.valueOf(0));
        HashMap hashmap;
        if (!TextUtils.isEmpty(searchUrl))
        {
            builder.setDataUrl(searchUrl);
            builder.setKeywords(getKeywords());
        } else
        {
            builder.setKeywords(getKeywords());
            String s = getRefinementsString();
            if (s == null)
            {
                builder.setAlias("aps");
            } else
            {
                builder.setRefinements(s);
                builder.setAlias(null);
            }
        }
        if (searchMethod != null)
        {
            builder.setSearchMethod(searchMethod.getName());
        }
        hashmap = new HashMap();
        if (!TextUtils.isEmpty(asrRequestId))
        {
            hashmap.put("asrRequestId", asrRequestId);
        }
        if (!TextUtils.isEmpty(utteranceId))
        {
            hashmap.put("utteranceId", utteranceId);
        }
        if (interpretationNum > 0)
        {
            hashmap.put("interpretationNum", String.valueOf(interpretationNum));
        }
        if (!hashmap.isEmpty())
        {
            builder.setParameters(hashmap);
        }
        builder.setDeviceInformation(DeviceInfoLoader.getInstance().getDeviceInfo());
        return builder.build();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(rawUserInput);
        parcel.writeString(alias);
        parcel.writeString(keywords);
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
    }

}
