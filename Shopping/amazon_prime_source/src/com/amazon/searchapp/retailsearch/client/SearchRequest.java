// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            DeviceInformation

public final class SearchRequest
{
    public static class Builder
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
            return new SearchRequest(dataSet, alias, keywords, refinements, merchant, sort, page, pageSize, parameters, refTag, dataUrl, imageResolution, imageCrop, deviceInformation, searchMethod);
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

        public Builder setAlias(String s)
        {
            alias = s;
            return this;
        }

        public Builder setDataSet(String s)
        {
            dataSet = s;
            return this;
        }

        public Builder setDataUrl(String s)
        {
            dataUrl = s;
            return this;
        }

        public Builder setDeviceInformation(DeviceInformation deviceinformation)
        {
            deviceInformation = deviceinformation;
            return this;
        }

        public Builder setImageCrop(boolean flag)
        {
            imageCrop = flag;
            return this;
        }

        public Builder setImageResolution(Integer integer)
        {
            imageResolution = integer;
            return this;
        }

        public Builder setKeywords(String s)
        {
            keywords = s;
            return this;
        }

        public Builder setMerchant(String s)
        {
            merchant = s;
            return this;
        }

        public Builder setPage(int i)
        {
            page = i;
            return this;
        }

        public Builder setPageSize(int i)
        {
            pageSize = i;
            return this;
        }

        public Builder setParameters(Map map)
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

        public Builder setRefTag(String s)
        {
            refTag = s;
            return this;
        }

        public Builder setRefinements(String s)
        {
            refinements = s;
            return this;
        }

        public Builder setSearchMethod(String s)
        {
            searchMethod = s;
            return this;
        }

        public Builder setSort(String s)
        {
            sort = s;
            return this;
        }

        public Builder()
        {
            pageSize = -1;
            imageResolution = null;
        }

        public Builder(String s)
        {
            pageSize = -1;
            imageResolution = null;
            keywords = s;
            alias = "aps";
        }

        public Builder(String s, String s1)
        {
            pageSize = -1;
            imageResolution = null;
            keywords = s;
            alias = s1;
        }
    }


    private final String alias;
    private final String dataSet;
    private final String dataUrl;
    private final DeviceInformation deviceInformation;
    private final boolean imageCrop;
    private final Integer imageResolution;
    private final String keywords;
    private final String merchant;
    private final int page;
    private final int pageSize;
    private final Map parameters;
    private final String refTag;
    private final String refinements;
    private final String searchMethod;
    private final String sort;

    private SearchRequest(String s, String s1, String s2, String s3, String s4, String s5, int i, 
            int j, Map map, String s6, String s7, Integer integer, boolean flag, DeviceInformation deviceinformation, 
            String s8)
    {
        dataSet = s;
        alias = s1;
        keywords = s2;
        refinements = s3;
        merchant = s4;
        sort = s5;
        page = i;
        pageSize = j;
        parameters = map;
        refTag = s6;
        dataUrl = s7;
        imageResolution = integer;
        imageCrop = flag;
        deviceInformation = deviceinformation;
        searchMethod = s8;
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
}
