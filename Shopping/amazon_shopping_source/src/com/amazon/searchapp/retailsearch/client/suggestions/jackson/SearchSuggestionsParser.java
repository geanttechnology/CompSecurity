// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.suggestions.jackson;

import com.amazon.searchapp.retailsearch.client.jackson.StandardParser;
import com.amazon.searchapp.retailsearch.client.suggestions.SearchSuggestionsListener;
import com.amazon.searchapp.retailsearch.entity.SearchSuggestionsEntity;
import com.amazon.searchapp.retailsearch.entity.SuggestionEntity;
import com.amazon.searchapp.retailsearch.model.SearchSuggestions;
import com.amazon.searchapp.retailsearch.model.Suggestion;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsParser
    implements com.amazon.searchapp.retailsearch.client.suggestions.SearchSuggestionsServiceCall.ResponseParser
{

    public SearchSuggestionsParser()
    {
    }

    private static ObjectMapper getMapper()
    {
        return StandardParser.getMapper();
    }

    private void parseInfo(JsonParser jsonparser, SearchSuggestionsEntity searchsuggestionsentity)
        throws IOException
    {
        if (!JsonToken.START_ARRAY.equals(jsonparser.nextToken()))
        {
            throw new IOException();
        }
        searchsuggestionsentity = searchsuggestionsentity.getSuggestions();
        int i = 0;
        while (!JsonToken.END_ARRAY.equals(jsonparser.nextToken())) 
        {
            if (searchsuggestionsentity == null || i >= searchsuggestionsentity.size())
            {
                jsonparser.skipChildren();
            } else
            {
                Suggestion suggestion = (Suggestion)searchsuggestionsentity.get(i);
                do
                {
                    if (JsonToken.END_OBJECT.equals(jsonparser.nextToken()))
                    {
                        break;
                    }
                    String s = jsonparser.getCurrentName();
                    if ("nodes".equals(s))
                    {
                        jsonparser.nextValue();
                        suggestion.setDepartments((List)jsonparser.readValueAs(new TypeReference() {

                            final SearchSuggestionsParser this$0;

            
            {
                this$0 = SearchSuggestionsParser.this;
                super();
            }
                        }));
                    } else
                    if ("conf".equals(s))
                    {
                        jsonparser.nextValue();
                        suggestion.setConfidence(jsonparser.getValueAsInt());
                    } else
                    if ("sc".equals(s))
                    {
                        jsonparser.nextValue();
                        suggestion.setSpellCorrected(jsonparser.getValueAsInt());
                    } else
                    if ("source".equals(s))
                    {
                        jsonparser.nextValue();
                        suggestion.setSource((List)jsonparser.readValueAs(new TypeReference() {

                            final SearchSuggestionsParser this$0;

            
            {
                this$0 = SearchSuggestionsParser.this;
                super();
            }
                        }));
                    }
                } while (true);
                i++;
            }
        }
    }

    private void parseSuggestions(JsonParser jsonparser, SearchSuggestionsEntity searchsuggestionsentity, SearchSuggestionsListener searchsuggestionslistener)
        throws IOException
    {
        if (!JsonToken.START_ARRAY.equals(jsonparser.nextToken()))
        {
            throw new IOException();
        }
        ArrayList arraylist = new ArrayList();
        do
        {
            if (JsonToken.END_ARRAY.equals(jsonparser.nextToken()))
            {
                break;
            }
            SuggestionEntity suggestionentity = new SuggestionEntity();
            suggestionentity.setSuggestion((String)jsonparser.readValueAs(java/lang/String));
            arraylist.add(suggestionentity);
            if (searchsuggestionslistener != null)
            {
                searchsuggestionslistener.suggestion(suggestionentity);
            }
        } while (true);
        searchsuggestionsentity.setSuggestions(arraylist);
        if (searchsuggestionslistener != null)
        {
            searchsuggestionslistener.suggestionList(arraylist);
        }
    }

    public SearchSuggestions parse(InputStream inputstream, SearchSuggestionsListener searchsuggestionslistener)
        throws IOException
    {
        SearchSuggestionsEntity searchsuggestionsentity = new SearchSuggestionsEntity();
        inputstream = getMapper().getFactory().createParser(inputstream);
        if (JsonToken.START_ARRAY.equals(inputstream.nextToken()))
        {
            inputstream.nextToken();
            searchsuggestionsentity.setQuery(inputstream.getValueAsString());
            parseSuggestions(inputstream, searchsuggestionsentity, searchsuggestionslistener);
            parseInfo(inputstream, searchsuggestionsentity);
        }
        return searchsuggestionsentity;
    }
}
