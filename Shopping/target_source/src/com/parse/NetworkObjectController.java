// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObjectController, ParseObjectCoder, ParseRESTObjectCommand, ParseRESTObjectBatchCommand, 
//            ParseRESTCommand, PointerEncoder, ParseOperationSet, ParseDecoder, 
//            ParseHttpClient

class NetworkObjectController
    implements ParseObjectController
{

    private ParseHttpClient client;
    private ParseObjectCoder coder;

    public NetworkObjectController(ParseHttpClient parsehttpclient)
    {
        client = parsehttpclient;
        coder = ParseObjectCoder.get();
    }

    public List deleteAllAsync(List list, String s)
    {
        boolean flag = false;
        int l = list.size();
        ArrayList arraylist = new ArrayList(l);
        for (int i = 0; i < l; i++)
        {
            ParseRESTObjectCommand parserestobjectcommand = ParseRESTObjectCommand.deleteObjectCommand((ParseObject.State)list.get(i), s);
            parserestobjectcommand.enableRetrying();
            arraylist.add(parserestobjectcommand);
        }

        list = ParseRESTObjectBatchCommand.executeBatch(client, arraylist, s);
        s = new ArrayList(l);
        for (int k = ((flag) ? 1 : 0); k < l; k++)
        {
            s.add(((j)list.get(k)).j());
        }

        return s;
    }

    public j deleteAsync(ParseObject.State state, String s)
    {
        state = ParseRESTObjectCommand.deleteObjectCommand(state, s);
        state.enableRetrying();
        return state.executeAsync(client).j();
    }

    public j fetchAsync(final ParseObject.State state, String s, final ParseDecoder decoder)
    {
        s = ParseRESTObjectCommand.getObjectCommand(state.objectId(), state.className(), s);
        s.enableRetrying();
        return s.executeAsync(client).c(new i() {

            final NetworkObjectController this$0;
            final ParseDecoder val$decoder;
            final ParseObject.State val$state;

            public ParseObject.State then(j j1)
                throws Exception
            {
                j1 = (JSONObject)j1.e();
                ParseObject.State.Init init = state.newBuilder().clear();
                return coder.decode(init, j1, decoder).isComplete(true).build();
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
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
        int l = list.size();
        ArrayList arraylist = new ArrayList(l);
        PointerEncoder pointerencoder = PointerEncoder.get();
        for (int i = 0; i < l; i++)
        {
            ParseObject.State state1 = (ParseObject.State)list.get(i);
            ParseOperationSet parseoperationset = (ParseOperationSet)list1.get(i);
            arraylist.add(ParseRESTObjectCommand.saveObjectCommand(state1, coder.encode(state1, parseoperationset, pointerencoder), s));
        }

        list1 = ParseRESTObjectBatchCommand.executeBatch(client, arraylist, s);
        s = new ArrayList(l);
        for (int k = 0; k < l; k++)
        {
            final ParseObject.State state = (ParseObject.State)list.get(k);
            final ParseDecoder decoder = (ParseDecoder)list2.get(k);
            s.add(((j)list1.get(k)).c(new i() {

                final NetworkObjectController this$0;
                final ParseDecoder val$decoder;
                final ParseObject.State val$state;

                public ParseObject.State then(j j1)
                    throws Exception
                {
                    j1 = (JSONObject)j1.e();
                    ParseObject.State.Init init = state.newBuilder().clear();
                    return coder.decode(init, j1, decoder).isComplete(false).build();
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
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

    public j saveAsync(final ParseObject.State state, ParseOperationSet parseoperationset, String s, final ParseDecoder decoder)
    {
        parseoperationset = ParseRESTObjectCommand.saveObjectCommand(state, coder.encode(state, parseoperationset, PointerEncoder.get()), s);
        parseoperationset.enableRetrying();
        return parseoperationset.executeAsync(client).c(new i() {

            final NetworkObjectController this$0;
            final ParseDecoder val$decoder;
            final ParseObject.State val$state;

            public ParseObject.State then(j j1)
                throws Exception
            {
                j1 = (JSONObject)j1.e();
                ParseObject.State.Init init = state.newBuilder().clear();
                return coder.decode(init, j1, decoder).isComplete(false).build();
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = NetworkObjectController.this;
                state = state1;
                decoder = parsedecoder;
                super();
            }
        });
    }

}
