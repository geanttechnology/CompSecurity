// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.jackson;

import com.amazon.searchapp.retailsearch.client.SearchListener;
import com.amazon.searchapp.retailsearch.entity.BreadcrumbEntity;
import com.amazon.searchapp.retailsearch.entity.CategoryCorrectedEntity;
import com.amazon.searchapp.retailsearch.entity.DidYouMeanEntity;
import com.amazon.searchapp.retailsearch.entity.DisplaySettingsEntity;
import com.amazon.searchapp.retailsearch.entity.FKMREntity;
import com.amazon.searchapp.retailsearch.entity.NoResultsSetEntity;
import com.amazon.searchapp.retailsearch.entity.PaginationEntity;
import com.amazon.searchapp.retailsearch.entity.PreloadImagesEntity;
import com.amazon.searchapp.retailsearch.entity.ProductEntity;
import com.amazon.searchapp.retailsearch.entity.ProductSectionEntity;
import com.amazon.searchapp.retailsearch.entity.ProductSectionSetEntity;
import com.amazon.searchapp.retailsearch.entity.RefinementsEntity;
import com.amazon.searchapp.retailsearch.entity.RelatedSearchesEntity;
import com.amazon.searchapp.retailsearch.entity.ResultsMetadataEntity;
import com.amazon.searchapp.retailsearch.entity.SearchResourcesEntity;
import com.amazon.searchapp.retailsearch.entity.SearchResultDataItemEntity;
import com.amazon.searchapp.retailsearch.entity.SearchResultEntity;
import com.amazon.searchapp.retailsearch.entity.SortEntity;
import com.amazon.searchapp.retailsearch.entity.SpellCorrectedEntity;
import com.amazon.searchapp.retailsearch.entity.TrackingInfoEntity;
import com.amazon.searchapp.retailsearch.model.DisplaySettings;
import com.amazon.searchapp.retailsearch.model.NoResultsSet;
import com.amazon.searchapp.retailsearch.model.PreloadImages;
import com.amazon.searchapp.retailsearch.model.ResultsMetadata;
import com.amazon.searchapp.retailsearch.model.SearchResources;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.jackson:
//            StandardParser

public class SearchParser
    implements com.amazon.searchapp.retailsearch.client.SearchServiceCall.ResponseParser
{

    private static final Map fieldMap;

    public SearchParser()
    {
    }

    private static ObjectMapper getMapper()
    {
        return StandardParser.getMapper();
    }

    private void processFkmr(String s, JsonParser jsonparser, List list, SearchResultEntity searchresultentity, SearchListener searchlistener)
        throws JsonParseException, IOException
    {
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (s != null)
        {
            i = ((flag) ? 1 : 0);
            if (s.length() > "fkmrResults".length())
            {
                i = Integer.parseInt(s.substring("fkmrResults".length()));
            }
        }
        jsonparser.nextToken();
        s = (FKMREntity)jsonparser.readValueAs(com/amazon/searchapp/retailsearch/entity/FKMREntity);
        if (s != null)
        {
            s.setIndex(i);
            list.add(s);
            if (searchlistener != null)
            {
                searchlistener.fkmr(s);
            }
        }
    }

    private void processItems(JsonParser jsonparser, ProductSectionEntity productsectionentity, SearchListener searchlistener)
        throws JsonParseException, IOException
    {
        if (!JsonToken.START_ARRAY.equals(jsonparser.nextToken()))
        {
            throw new IOException();
        }
        ArrayList arraylist = new ArrayList(20);
        for (int i = 0; !JsonToken.END_ARRAY.equals(jsonparser.nextToken()); i++)
        {
            ProductEntity productentity = (ProductEntity)jsonparser.readValueAs(com/amazon/searchapp/retailsearch/entity/ProductEntity);
            productentity.setPosition(i);
            arraylist.add(productentity);
            if (searchlistener != null)
            {
                searchlistener.product(productentity);
            }
        }

        productsectionentity.setItems(Collections.unmodifiableList(Collections.synchronizedList(arraylist)));
    }

    private ProductSectionEntity processProductSection(JsonParser jsonparser, SearchResultEntity searchresultentity, SearchListener searchlistener)
        throws JsonParseException, IOException
    {
        if (!JsonToken.VALUE_NULL.equals(jsonparser.getCurrentToken())) goto _L2; else goto _L1
_L1:
        searchresultentity = null;
_L4:
        return searchresultentity;
_L2:
        if (!JsonToken.START_OBJECT.equals(jsonparser.getCurrentToken()))
        {
            throw new IOException();
        }
        ProductSectionEntity productsectionentity = new ProductSectionEntity();
        do
        {
            searchresultentity = productsectionentity;
            if (JsonToken.END_OBJECT.equals(jsonparser.nextToken()))
            {
                continue;
            }
            searchresultentity = jsonparser.getCurrentName();
            if ("items".equals(searchresultentity))
            {
                processItems(jsonparser, productsectionentity, searchlistener);
            } else
            if ("section".equals(searchresultentity))
            {
                jsonparser.nextToken();
                productsectionentity.setSection(jsonparser.getIntValue());
            } else
            if ("numSections".equals(searchresultentity))
            {
                jsonparser.nextToken();
                productsectionentity.setNumSections(jsonparser.getIntValue());
            } else
            if ("page".equals(searchresultentity))
            {
                jsonparser.nextToken();
                productsectionentity.setPage(jsonparser.getIntValue());
            } else
            {
                jsonparser.nextValue();
                jsonparser.skipChildren();
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void processResults(JsonParser jsonparser, SearchResultEntity searchresultentity, SearchListener searchlistener)
        throws JsonParseException, IOException
    {
        if (!JsonToken.START_OBJECT.equals(jsonparser.nextToken()))
        {
            throw new IOException();
        }
        ProductSectionSetEntity productsectionsetentity = new ProductSectionSetEntity();
        searchresultentity.setResults(productsectionsetentity);
        ArrayList arraylist = new ArrayList(2);
        productsectionsetentity.setSections(arraylist);
        while (!JsonToken.END_OBJECT.equals(jsonparser.nextToken())) 
        {
            if ("sections".equals(jsonparser.getCurrentName()))
            {
                if (!JsonToken.START_ARRAY.equals(jsonparser.nextToken()))
                {
                    throw new IOException();
                }
                while (!JsonToken.END_ARRAY.equals(jsonparser.nextToken())) 
                {
                    arraylist.add(processProductSection(jsonparser, searchresultentity, searchlistener));
                }
            } else
            {
                jsonparser.nextValue();
                jsonparser.skipChildren();
            }
        }
        productsectionsetentity.setSections(Collections.unmodifiableList(Collections.synchronizedList(productsectionsetentity.getSections())));
    }

    public SearchResult parse(InputStream inputstream, SearchListener searchlistener)
        throws IOException
    {
        SearchResultEntity searchresultentity;
        JsonParser jsonparser;
        searchresultentity = new SearchResultEntity();
        if (searchlistener != null)
        {
            searchlistener.startParse(searchresultentity);
        }
        Object obj = null;
        jsonparser = getMapper().getFactory().createParser(inputstream);
        inputstream = obj;
        if (!JsonToken.START_OBJECT.equals(jsonparser.nextToken()))
        {
            throw new IOException();
        }
_L8:
        if (JsonToken.END_OBJECT.equals(jsonparser.nextToken())) goto _L2; else goto _L1
_L1:
        Object obj2;
        String s;
        boolean flag;
        s = jsonparser.getCurrentName();
        if ("results".equals(s))
        {
            processResults(jsonparser, searchresultentity, searchlistener);
            continue; /* Loop/switch isn't completed */
        }
        if (s.startsWith("fkmrResults"))
        {
            Object obj1 = inputstream;
            if (inputstream == null)
            {
                obj1 = new ArrayList(4);
                searchresultentity.setFkmr(((List) (obj1)));
            }
            processFkmr(s, jsonparser, ((List) (obj1)), searchresultentity, searchlistener);
            inputstream = ((InputStream) (obj1));
            continue; /* Loop/switch isn't completed */
        }
        jsonparser.nextToken();
        flag = false;
        obj2 = (Class)fieldMap.get(s);
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        boolean flag1 = true;
        if (!com/amazon/searchapp/retailsearch/entity/RefinementsEntity.equals(obj2)) goto _L6; else goto _L5
_L5:
        searchresultentity.setRefinements((RefinementsEntity)jsonparser.readValueAs(((Class) (obj2))));
        flag = flag1;
        if (searchlistener != null)
        {
            searchlistener.refinements(searchresultentity.getRefinements());
            flag = flag1;
        }
_L4:
        if (!flag)
        {
            obj2 = (JsonNode)jsonparser.readValueAsTree();
            if (searchlistener != null)
            {
                SearchResultDataItemEntity searchresultdataitementity = new SearchResultDataItemEntity();
                searchresultdataitementity.setName(s);
                searchresultdataitementity.setValue(((JsonNode) (obj2)).toString());
                searchlistener.dataItem(searchresultdataitementity);
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (com/amazon/searchapp/retailsearch/entity/TrackingInfoEntity.equals(obj2))
        {
            searchresultentity.setTrackingInfo((TrackingInfoEntity)jsonparser.readValueAs(((Class) (obj2))));
            flag = flag1;
            if (searchlistener != null)
            {
                searchlistener.trackingInfo(searchresultentity.getTrackingInfo());
                flag = flag1;
            }
        } else
        if (com/amazon/searchapp/retailsearch/entity/PaginationEntity.equals(obj2))
        {
            searchresultentity.setPagination((PaginationEntity)jsonparser.readValueAs(((Class) (obj2))));
            flag = flag1;
            if (searchlistener != null)
            {
                searchlistener.pagination(searchresultentity.getPagination());
                flag = flag1;
            }
        } else
        if (com/amazon/searchapp/retailsearch/entity/SortEntity.equals(obj2))
        {
            searchresultentity.setSort((SortEntity)jsonparser.readValueAs(((Class) (obj2))));
            flag = flag1;
            if (searchlistener != null)
            {
                searchlistener.sort(searchresultentity.getSort());
                flag = flag1;
            }
        } else
        if (com/amazon/searchapp/retailsearch/entity/BreadcrumbEntity.equals(obj2))
        {
            searchresultentity.setBreadcrumb((BreadcrumbEntity)jsonparser.readValueAs(((Class) (obj2))));
            flag = flag1;
            if (searchlistener != null)
            {
                searchlistener.breadcrumb(searchresultentity.getBreadcrumb());
                flag = flag1;
            }
        } else
        if (com/amazon/searchapp/retailsearch/entity/DidYouMeanEntity.equals(obj2))
        {
            searchresultentity.setDidYouMean((DidYouMeanEntity)jsonparser.readValueAs(((Class) (obj2))));
            flag = flag1;
            if (searchlistener != null)
            {
                searchlistener.didYouMean(searchresultentity.getDidYouMean());
                flag = flag1;
            }
        } else
        if (com/amazon/searchapp/retailsearch/entity/RelatedSearchesEntity.equals(obj2))
        {
            searchresultentity.setRelatedSearches((RelatedSearchesEntity)jsonparser.readValueAs(((Class) (obj2))));
            flag = flag1;
            if (searchlistener != null)
            {
                searchlistener.relatedSearches(searchresultentity.getRelatedSearches());
                flag = flag1;
            }
        } else
        if (com/amazon/searchapp/retailsearch/entity/ResultsMetadataEntity.equals(obj2))
        {
            searchresultentity.setResultsMetadata((ResultsMetadata)jsonparser.readValueAs(((Class) (obj2))));
            flag = flag1;
            if (searchlistener != null)
            {
                searchlistener.resultMetadata(searchresultentity.getResultsMetadata());
                flag = flag1;
            }
        } else
        if (com/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity.equals(obj2))
        {
            searchresultentity.setSpellCorrectedResults((SpellCorrectedEntity)jsonparser.readValueAs(((Class) (obj2))));
            flag = flag1;
            if (searchlistener != null)
            {
                searchlistener.spellCorrected(searchresultentity.getSpellCorrectedResults());
                flag = flag1;
            }
        } else
        if (com/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity.equals(obj2))
        {
            searchresultentity.setCorrectedCategoryResults((CategoryCorrectedEntity)jsonparser.readValueAs(((Class) (obj2))));
            flag = flag1;
            if (searchlistener != null)
            {
                searchlistener.categoryCorrected(searchresultentity.getCorrectedCategoryResults());
                flag = flag1;
            }
        } else
        if (com/amazon/searchapp/retailsearch/entity/PreloadImagesEntity.equals(obj2))
        {
            searchresultentity.setPreloadImages((PreloadImages)jsonparser.readValueAs(((Class) (obj2))));
            flag = flag1;
            if (searchlistener != null)
            {
                searchlistener.preloadImages(searchresultentity.getPreloadImages());
                flag = flag1;
            }
        } else
        if (com/amazon/searchapp/retailsearch/entity/NoResultsSetEntity.equals(obj2))
        {
            searchresultentity.setNoResults((NoResultsSet)jsonparser.readValueAs(((Class) (obj2))));
            flag = flag1;
            if (searchlistener != null)
            {
                searchlistener.noResultsSet(searchresultentity.getNoResults());
                flag = flag1;
            }
        } else
        if (com/amazon/searchapp/retailsearch/entity/DisplaySettingsEntity.equals(obj2))
        {
            searchresultentity.setDisplaySettings((DisplaySettings)jsonparser.readValueAs(((Class) (obj2))));
            flag = flag1;
            if (searchlistener != null)
            {
                searchlistener.displaySettings(searchresultentity.getDisplaySettings());
                flag = flag1;
            }
        } else
        if (com/amazon/searchapp/retailsearch/entity/SearchResourcesEntity.equals(obj2))
        {
            searchresultentity.setResources((SearchResources)jsonparser.readValueAs(((Class) (obj2))));
            flag = flag1;
            if (searchlistener != null)
            {
                searchlistener.resources(searchresultentity.getResources());
                flag = flag1;
            }
        } else
        {
            flag = false;
        }
        if (true) goto _L4; else goto _L2
_L2:
        if (inputstream != null)
        {
            searchresultentity.setFkmr(Collections.unmodifiableList(Collections.synchronizedList(inputstream)));
        }
        if (searchlistener != null)
        {
            searchlistener.endParse(searchresultentity);
        }
        return searchresultentity;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static 
    {
        HashMap hashmap = new HashMap(32);
        hashmap.put("trackingInfo", com/amazon/searchapp/retailsearch/entity/TrackingInfoEntity);
        hashmap.put("spellCorrectedResults", com/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity);
        hashmap.put("wordSplitterCorrectedResults", com/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity);
        hashmap.put("correctedCategoryResults", com/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity);
        hashmap.put("refinements", com/amazon/searchapp/retailsearch/entity/RefinementsEntity);
        hashmap.put("pagination", com/amazon/searchapp/retailsearch/entity/PaginationEntity);
        hashmap.put("sort", com/amazon/searchapp/retailsearch/entity/SortEntity);
        hashmap.put("breadcrumb", com/amazon/searchapp/retailsearch/entity/BreadcrumbEntity);
        hashmap.put("didYouMean", com/amazon/searchapp/retailsearch/entity/DidYouMeanEntity);
        hashmap.put("relatedSearches", com/amazon/searchapp/retailsearch/entity/RelatedSearchesEntity);
        hashmap.put("resultsMetadata", com/amazon/searchapp/retailsearch/entity/ResultsMetadataEntity);
        hashmap.put("preloadImages", com/amazon/searchapp/retailsearch/entity/PreloadImagesEntity);
        hashmap.put("noResults", com/amazon/searchapp/retailsearch/entity/NoResultsSetEntity);
        hashmap.put("displaySettings", com/amazon/searchapp/retailsearch/entity/DisplaySettingsEntity);
        hashmap.put("resources", com/amazon/searchapp/retailsearch/model/SearchResources);
        fieldMap = Collections.unmodifiableMap(hashmap);
    }
}
