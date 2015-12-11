// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            SearchRequest, DeviceInformation

public static class alias
{

    public static final String APS = "aps";
    private String alias;
    private String dataSet;
    private String dataUrl;
    private DeviceInformation deviceInformation;
    private boolean imageCrop;
    private Integer imageResolution;
    private String keywords;
    private String merchant;
    private int page;
    private int pageSize;
    private Map parameters;
    private String refTag;
    private String refinements;
    private String searchMethod;
    private String sort;

    public SearchRequest build()
    {
        return new SearchRequest(dataSet, alias, keywords, refinements, merchant, sort, page, pageSize, parameters, refTag, dataUrl, imageResolution, imageCrop, deviceInformation, searchMethod, null);
    }

    public String getAlias()
    {
        return alias;
    }

    public String getDataSet()
    {
        return dataSet;
    }

    public String getDataUrl()
    {
        return dataUrl;
    }

    public DeviceInformation getDeviceInformation()
    {
        return deviceInformation;
    }

    public boolean getImageCrop()
    {
        return imageCrop;
    }

    public Integer getImageResolution()
    {
        return imageResolution;
    }

    public String getKeywords()
    {
        return keywords;
    }

    public String getMerchant()
    {
        return merchant;
    }

    public int getPage()
    {
        return page;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public Map getParameters()
    {
        return parameters;
    }

    public String getRefTag()
    {
        return refTag;
    }

    public String getRefinements()
    {
        return refinements;
    }

    public String getSearchMethod()
    {
        return searchMethod;
    }

    public String getSort()
    {
        return sort;
    }

    public sort setAlias(String s)
    {
        alias = s;
        return this;
    }

    public alias setDataSet(String s)
    {
        dataSet = s;
        return this;
    }

    public dataSet setDataUrl(String s)
    {
        dataUrl = s;
        return this;
    }

    public dataUrl setDeviceInformation(DeviceInformation deviceinformation)
    {
        deviceInformation = deviceinformation;
        return this;
    }

    public deviceInformation setImageCrop(boolean flag)
    {
        imageCrop = flag;
        return this;
    }

    public imageCrop setImageResolution(Integer integer)
    {
        imageResolution = integer;
        return this;
    }

    public imageResolution setKeywords(String s)
    {
        keywords = s;
        return this;
    }

    public keywords setMerchant(String s)
    {
        merchant = s;
        return this;
    }

    public merchant setPage(int i)
    {
        page = i;
        return this;
    }

    public page setPageSize(int i)
    {
        pageSize = i;
        return this;
    }

    public pageSize setParameters(Map map)
    {
        if (map == null)
        {
            map = null;
        } else
        {
            map = Collections.unmodifiableMap(new ConcurrentHashMap(map));
        }
        parameters = map;
        return this;
    }

    public parameters setRefTag(String s)
    {
        refTag = s;
        return this;
    }

    public refTag setRefinements(String s)
    {
        refinements = s;
        return this;
    }

    public refinements setSearchMethod(String s)
    {
        searchMethod = s;
        return this;
    }

    public searchMethod setSort(String s)
    {
        sort = s;
        return this;
    }

    public ()
    {
        pageSize = -1;
        imageResolution = null;
    }

    public imageResolution(String s)
    {
        pageSize = -1;
        imageResolution = null;
        keywords = s;
        alias = "aps";
    }

    public alias(String s, String s1)
    {
        pageSize = -1;
        imageResolution = null;
        keywords = s;
        alias = s1;
    }
}
