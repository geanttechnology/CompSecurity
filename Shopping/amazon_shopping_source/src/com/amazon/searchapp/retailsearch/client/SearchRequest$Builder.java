// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            SearchRequest, DeviceInformation

public static class imageResolution
{

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

    public searchMethod setAlias(String s)
    {
        alias = s;
        return this;
    }

    public alias setDataUrl(String s)
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

    public keywords setParameters(Map map)
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

    public parameters setRefinements(String s)
    {
        refinements = s;
        return this;
    }

    public refinements setSearchMethod(String s)
    {
        searchMethod = s;
        return this;
    }

    public ()
    {
        pageSize = -1;
        imageResolution = null;
    }
}
