// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObjectController, ParseRESTObjectCommand, ParseRESTObjectBatchCommand, ParseRESTCommand, 
//            PointerEncoder, ParseOperationSet, ParseDecoder, ParseDateFormat, 
//            ParseACL, ParseFieldOperation, ParseEncoder, ParseHttpClient

class NetworkObjectController
    implements ParseObjectController
{

    private static final String KEY_ACL = "ACL";
    private static final String KEY_CLASS_NAME = "className";
    private static final String KEY_CREATED_AT = "createdAt";
    private static final String KEY_OBJECT_ID = "objectId";
    private static final String KEY_UPDATED_AT = "updatedAt";
    private ParseHttpClient client;

    public NetworkObjectController(ParseHttpClient parsehttpclient)
    {
        client = parsehttpclient;
    }

    public List deleteAllAsync(List list, String s)
    {
        boolean flag = false;
        int k = list.size();
        ArrayList arraylist = new ArrayList(k);
        for (int i = 0; i < k; i++)
        {
            ParseRESTObjectCommand parserestobjectcommand = ParseRESTObjectCommand.deleteObjectCommand((ParseObject.State)list.get(i), s);
            parserestobjectcommand.enableRetrying();
            arraylist.add(parserestobjectcommand);
        }

        list = ParseRESTObjectBatchCommand.executeBatch(client, arraylist, s);
        s = new ArrayList(k);
        for (int j = ((flag) ? 1 : 0); j < k; j++)
        {
            s.add(((cu)list.get(j)).j());
        }

        return s;
    }

    public cu deleteAsync(ParseObject.State state, String s)
    {
        state = ParseRESTObjectCommand.deleteObjectCommand(state, s);
        state.enableRetrying();
        return state.executeAsync(client).j();
    }

    public cu fetchAsync(final ParseObject.State state, String s, final ParseDecoder decoder)
    {
        s = ParseRESTObjectCommand.getObjectCommand(state.objectId(), state.className(), s);
        s.enableRetrying();
        return s.executeAsync(client).c(new ct() {

            final NetworkObjectController this$0;
            final ParseDecoder val$decoder;
            final ParseObject.State val$state;

            public ParseObject.State then(cu cu1)
                throws Exception
            {
                cu1 = (JSONObject)cu1.e();
                return stateFromJSON(state, cu1, decoder, true);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = NetworkObjectController.this;
                state = state1;
                decoder = parsedecoder;
                super();
            }
        });
    }

    public List saveAllAsync(List list, List list1, String s, List list2)
    {
        int k = list.size();
        ArrayList arraylist = new ArrayList(k);
        PointerEncoder pointerencoder = PointerEncoder.get();
        for (int i = 0; i < k; i++)
        {
            ParseObject.State state1 = (ParseObject.State)list.get(i);
            arraylist.add(ParseRESTObjectCommand.saveObjectCommand(state1, stateToJSONObject(state1, (ParseOperationSet)list1.get(i), pointerencoder), s));
        }

        list1 = ParseRESTObjectBatchCommand.executeBatch(client, arraylist, s);
        s = new ArrayList(k);
        for (int j = 0; j < k; j++)
        {
            final ParseObject.State state = (ParseObject.State)list.get(j);
            final ParseDecoder decoder = (ParseDecoder)list2.get(j);
            s.add(((cu)list1.get(j)).c(new ct() {

                final NetworkObjectController this$0;
                final ParseDecoder val$decoder;
                final ParseObject.State val$state;

                public ParseObject.State then(cu cu1)
                    throws Exception
                {
                    cu1 = (JSONObject)cu1.e();
                    return stateFromJSON(state, cu1, decoder, false);
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = NetworkObjectController.this;
                state = state1;
                decoder = parsedecoder;
                super();
            }
            }));
        }

        return s;
    }

    public cu saveAsync(final ParseObject.State state, ParseOperationSet parseoperationset, String s, final ParseDecoder decoder)
    {
        parseoperationset = ParseRESTObjectCommand.saveObjectCommand(state, stateToJSONObject(state, parseoperationset, PointerEncoder.get()), s);
        parseoperationset.enableRetrying();
        return parseoperationset.executeAsync(client).c(new ct() {

            final NetworkObjectController this$0;
            final ParseDecoder val$decoder;
            final ParseObject.State val$state;

            public ParseObject.State then(cu cu1)
                throws Exception
            {
                cu1 = (JSONObject)cu1.e();
                return stateFromJSON(state, cu1, decoder, false);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = NetworkObjectController.this;
                state = state1;
                decoder = parsedecoder;
                super();
            }
        });
    }

    public ParseObject.State stateFromJSON(ParseObject.State state, JSONObject jsonobject, ParseDecoder parsedecoder, boolean flag)
    {
        Iterator iterator;
        state = state.newBuilder().clear();
        state.isComplete(flag);
        iterator = jsonobject.keys();
_L3:
        String s;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_207;
            }
            s = (String)iterator.next();
        } while (s.equals("__type") || s.equals("className"));
        if (!s.equals("objectId")) goto _L2; else goto _L1
_L1:
        state.objectId(jsonobject.getString(s));
          goto _L3
_L2:
label0:
        {
            if (!s.equals("createdAt"))
            {
                break label0;
            }
            state.createdAt(ParseDateFormat.getInstance().parse(jsonobject.getString(s)));
        }
          goto _L3
label1:
        {
            if (!s.equals("updatedAt"))
            {
                break label1;
            }
            state.updatedAt(ParseDateFormat.getInstance().parse(jsonobject.getString(s)));
        }
          goto _L3
label2:
        {
            if (!s.equals("ACL"))
            {
                break label2;
            }
            state.put("ACL", ParseACL.createACLFromJSONObject(jsonobject.getJSONObject(s), parsedecoder));
        }
          goto _L3
        try
        {
            state.put(s, parsedecoder.decode(jsonobject.get(s)));
        }
        // Misplaced declaration of an exception variable
        catch (ParseObject.State state)
        {
            throw new RuntimeException(state);
        }
          goto _L3
        state = state.build();
        return state;
    }

    JSONObject stateToJSONObject(ParseObject.State state, ParseOperationSet parseoperationset, ParseEncoder parseencoder)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        try
        {
            String s;
            for (Iterator iterator = parseoperationset.keySet().iterator(); iterator.hasNext(); jsonobject.put(s, parseencoder.encode((ParseFieldOperation)parseoperationset.get(s))))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (ParseObject.State state)
        {
            throw new RuntimeException("could not serialize object to JSON");
        }
        if (state.objectId() != null)
        {
            jsonobject.put("objectId", state.objectId());
        }
        return jsonobject;
    }
}
