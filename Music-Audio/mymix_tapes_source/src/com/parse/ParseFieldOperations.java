// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseDecoder, ParseFieldOperation, ParseDeleteOperation, ParseIncrementOperation, 
//            ParseAddOperation, ParseAddUniqueOperation, ParseRemoveOperation, ParseRelationOperation

final class ParseFieldOperations
{
    private static interface ParseFieldOperationFactory
    {

        public abstract ParseFieldOperation decode(JSONObject jsonobject, ParseDecoder parsedecoder)
            throws JSONException;
    }


    private static Map opDecoderMap = new HashMap();

    private ParseFieldOperations()
    {
    }

    static ParseFieldOperation decode(JSONObject jsonobject, ParseDecoder parsedecoder)
        throws JSONException
    {
        String s = jsonobject.optString("__op");
        ParseFieldOperationFactory parsefieldoperationfactory = (ParseFieldOperationFactory)opDecoderMap.get(s);
        if (parsefieldoperationfactory == null)
        {
            throw new RuntimeException((new StringBuilder()).append("Unable to decode operation of type ").append(s).toString());
        } else
        {
            return parsefieldoperationfactory.decode(jsonobject, parsedecoder);
        }
    }

    static ArrayList jsonArrayAsArrayList(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList(jsonarray.length());
        int i = 0;
        while (i < jsonarray.length()) 
        {
            try
            {
                arraylist.add(jsonarray.get(i));
            }
            // Misplaced declaration of an exception variable
            catch (JSONArray jsonarray)
            {
                throw new RuntimeException(jsonarray);
            }
            i++;
        }
        return arraylist;
    }

    private static void registerDecoder(String s, ParseFieldOperationFactory parsefieldoperationfactory)
    {
        opDecoderMap.put(s, parsefieldoperationfactory);
    }

    static void registerDefaultDecoders()
    {
        registerDecoder("Batch", new ParseFieldOperationFactory() {

            public ParseFieldOperation decode(JSONObject jsonobject, ParseDecoder parsedecoder)
                throws JSONException
            {
                Object obj = null;
                JSONArray jsonarray = jsonobject.getJSONArray("ops");
                int i = 0;
                jsonobject = obj;
                for (; i < jsonarray.length(); i++)
                {
                    jsonobject = ParseFieldOperations.decode(jsonarray.getJSONObject(i), parsedecoder).mergeWithPrevious(jsonobject);
                }

                return jsonobject;
            }

        });
        registerDecoder("Delete", new ParseFieldOperationFactory() {

            public ParseFieldOperation decode(JSONObject jsonobject, ParseDecoder parsedecoder)
                throws JSONException
            {
                return ParseDeleteOperation.getInstance();
            }

        });
        registerDecoder("Increment", new ParseFieldOperationFactory() {

            public ParseFieldOperation decode(JSONObject jsonobject, ParseDecoder parsedecoder)
                throws JSONException
            {
                return new ParseIncrementOperation((Number)jsonobject.opt("amount"));
            }

        });
        registerDecoder("Add", new ParseFieldOperationFactory() {

            public ParseFieldOperation decode(JSONObject jsonobject, ParseDecoder parsedecoder)
                throws JSONException
            {
                return new ParseAddOperation(jsonobject.opt("objects"));
            }

        });
        registerDecoder("AddUnique", new ParseFieldOperationFactory() {

            public ParseFieldOperation decode(JSONObject jsonobject, ParseDecoder parsedecoder)
                throws JSONException
            {
                return new ParseAddUniqueOperation(parsedecoder.decode(jsonobject.opt("objects")));
            }

        });
        registerDecoder("Remove", new ParseFieldOperationFactory() {

            public ParseFieldOperation decode(JSONObject jsonobject, ParseDecoder parsedecoder)
                throws JSONException
            {
                return new ParseRemoveOperation(jsonobject.opt("objects"));
            }

        });
        registerDecoder("AddRelation", new ParseFieldOperationFactory() {

            public ParseFieldOperation decode(JSONObject jsonobject, ParseDecoder parsedecoder)
                throws JSONException
            {
                return new ParseRelationOperation(new HashSet((List)parsedecoder.decode(jsonobject.optJSONArray("objects"))), null);
            }

        });
        registerDecoder("RemoveRelation", new ParseFieldOperationFactory() {

            public ParseFieldOperation decode(JSONObject jsonobject, ParseDecoder parsedecoder)
                throws JSONException
            {
                return new ParseRelationOperation(null, new HashSet((List)parsedecoder.decode(jsonobject.optJSONArray("objects"))));
            }

        });
    }

}
