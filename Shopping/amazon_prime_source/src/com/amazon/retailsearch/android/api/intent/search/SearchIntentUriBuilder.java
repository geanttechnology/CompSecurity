// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.intent.search;

import android.net.Uri;
import android.text.TextUtils;
import com.amazon.retailsearch.util.UrlUtils;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.client.SearchMethod;
import java.util.Iterator;
import java.util.List;

public class SearchIntentUriBuilder
{

    public static final String SEARCH_PARAM_ASINS = "paramAsins";
    public static final String SEARCH_PARAM_ASR_REQUEST_ID = "paramAsrRequestId";
    public static final String SEARCH_PARAM_DATA_URL = "paramDataUrl";
    public static final String SEARCH_PARAM_DEPARTMENT_FILTER = "paramDepartmentFilter";
    public static final String SEARCH_PARAM_DEPARTMENT_NAME = "paramDepartmentName";
    public static final String SEARCH_PARAM_INTERPRETATION_NUM = "paramInterpretationNum";
    public static final String SEARCH_PARAM_METHOD = "paramMethod";
    public static final String SEARCH_PARAM_QUERY_TEXT = "paramQueryText";
    public static final String SEARCH_PARAM_REF_TAG = "paramRefTag";
    public static final String SEARCH_PARAM_UTTERANCE_ID = "paramUtteranceId";
    private List asins;
    private String asrRequestId;
    private String categoryName;
    private String dataUrl;
    private String filter;
    private int interpretationNum;
    private String query;
    private String refTag;
    private SearchMethod searchMethod;
    private String utteranceId;

    public SearchIntentUriBuilder()
    {
        query = null;
        filter = null;
        categoryName = null;
        dataUrl = null;
        searchMethod = null;
        asrRequestId = null;
        utteranceId = null;
        interpretationNum = 0;
        refTag = null;
        asins = null;
    }

    public SearchIntentUriBuilder asins(List list)
    {
        asins = list;
        return this;
    }

    public SearchIntentUriBuilder asrRequestId(String s)
    {
        asrRequestId = s;
        return this;
    }

    public Uri build()
    {
        if (query == null && filter == null && dataUrl == null && Utils.isEmpty(asins))
        {
            return null;
        }
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        if (!TextUtils.isEmpty(query))
        {
            builder.appendQueryParameter("paramQueryText", query);
        } else
        if (!TextUtils.isEmpty(dataUrl))
        {
            obj = UrlUtils.getKeywords(dataUrl);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                builder.appendQueryParameter("paramQueryText", ((String) (obj)));
            }
        }
        if (!TextUtils.isEmpty(filter))
        {
            builder.appendQueryParameter("paramDepartmentFilter", filter);
        }
        if (!TextUtils.isEmpty(categoryName))
        {
            builder.appendQueryParameter("paramDepartmentName", categoryName);
        }
        if (!TextUtils.isEmpty(dataUrl))
        {
            builder.appendQueryParameter("paramDataUrl", dataUrl);
        }
        if (searchMethod != null)
        {
            builder.appendQueryParameter("paramMethod", searchMethod.getName());
        }
        if (!TextUtils.isEmpty(asrRequestId))
        {
            builder.appendQueryParameter("paramAsrRequestId", asrRequestId);
        }
        if (!TextUtils.isEmpty(utteranceId))
        {
            builder.appendQueryParameter("paramUtteranceId", utteranceId);
        }
        if (interpretationNum > 0)
        {
            builder.appendQueryParameter("paramInterpretationNum", String.valueOf(interpretationNum));
        }
        if (!TextUtils.isEmpty(refTag))
        {
            builder.appendQueryParameter("paramRefTag", refTag);
        }
        if (!Utils.isEmpty(asins))
        {
            Object obj = new StringBuilder();
            String s;
            for (Iterator iterator = asins.iterator(); iterator.hasNext(); ((StringBuilder) (obj)).append(s))
            {
                s = (String)iterator.next();
                if (((StringBuilder) (obj)).length() != 0)
                {
                    ((StringBuilder) (obj)).append('|');
                }
            }

            builder.appendQueryParameter("paramAsins", ((StringBuilder) (obj)).toString());
        }
        return builder.build();
    }

    public SearchIntentUriBuilder categoryName(String s)
    {
        categoryName = s;
        return this;
    }

    public SearchIntentUriBuilder dataUrl(String s)
    {
        dataUrl = s;
        return this;
    }

    public SearchIntentUriBuilder filter(String s)
    {
        filter = s;
        return this;
    }

    public SearchIntentUriBuilder interpretationNum(int i)
    {
        interpretationNum = i;
        return this;
    }

    public SearchIntentUriBuilder query(String s)
    {
        query = s;
        return this;
    }

    public SearchIntentUriBuilder refTag(String s)
    {
        refTag = s;
        return this;
    }

    public SearchIntentUriBuilder searchMethod(SearchMethod searchmethod)
    {
        searchMethod = searchmethod;
        return this;
    }

    public SearchIntentUriBuilder utteranceId(String s)
    {
        utteranceId = s;
        return this;
    }
}
