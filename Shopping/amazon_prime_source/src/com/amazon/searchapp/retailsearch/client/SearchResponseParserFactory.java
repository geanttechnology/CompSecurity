// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.util.ClassUtil;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            SearchResponseParser

public class SearchResponseParserFactory
{

    private static String PARSER_CLASS = (new StringBuilder()).append(com/amazon/searchapp/retailsearch/client/SearchResponseParserFactory.getPackage().getName()).append(".jackson.SearchParser").toString();
    private static String VALIDATING_PARSER_CLASS = (new StringBuilder()).append(com/amazon/searchapp/retailsearch/client/SearchResponseParserFactory.getPackage().getName()).append(".jackson.ValidatingSearchParser").toString();
    private static volatile SearchResponseParser parser;
    private static volatile SearchResponseParser validatingParser;

    public SearchResponseParserFactory()
    {
    }

    public static SearchResponseParser getParser()
    {
        com/amazon/searchapp/retailsearch/client/SearchResponseParserFactory;
        JVM INSTR monitorenter ;
        SearchResponseParser searchresponseparser;
        if (parser == null)
        {
            parser = (SearchResponseParser)ClassUtil.createInstance(PARSER_CLASS);
        }
        searchresponseparser = parser;
        com/amazon/searchapp/retailsearch/client/SearchResponseParserFactory;
        JVM INSTR monitorexit ;
        return searchresponseparser;
        Exception exception;
        exception;
        throw exception;
    }

    public static SearchResponseParser getParser(boolean flag)
    {
        if (flag)
        {
            return getValidatingParser();
        } else
        {
            return getParser();
        }
    }

    public static SearchResponseParser getValidatingParser()
    {
        com/amazon/searchapp/retailsearch/client/SearchResponseParserFactory;
        JVM INSTR monitorenter ;
        SearchResponseParser searchresponseparser;
        if (validatingParser == null)
        {
            validatingParser = (SearchResponseParser)ClassUtil.createInstance(VALIDATING_PARSER_CLASS);
        }
        searchresponseparser = validatingParser;
        com/amazon/searchapp/retailsearch/client/SearchResponseParserFactory;
        JVM INSTR monitorexit ;
        return searchresponseparser;
        Exception exception;
        exception;
        throw exception;
    }

}
