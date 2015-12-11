// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.data_model.models.ActorBrand;
import com.poshmark.data_model.models.ActorUser;
import com.poshmark.data_model.models.Feed;
import com.poshmark.data_model.models.FeedItem;
import com.poshmark.data_model.models.FeedItemContentType;
import com.poshmark.data_model.models.FeedItemImageLayout;
import com.poshmark.data_model.models.inner_models.FeedItemStoryType;
import java.lang.reflect.Type;
import java.util.List;

public class FeedDeserializer
    implements JsonDeserializer
{

    public FeedDeserializer()
    {
    }

    private void createActor(String s, JsonElement jsonelement, FeedItem feeditem, Gson gson)
    {
        if (s != null)
        {
            if (s.equals("user"))
            {
                if (!(gson instanceof Gson))
                {
                    s = ((String) (gson.fromJson(jsonelement, com/poshmark/data_model/models/ActorUser)));
                } else
                {
                    s = ((String) (GsonInstrumentation.fromJson((Gson)gson, jsonelement, com/poshmark/data_model/models/ActorUser)));
                }
                feeditem.setActor((ActorUser)s);
            } else
            if (!s.equals("post") && s.equals("brand"))
            {
                if (!(gson instanceof Gson))
                {
                    s = ((String) (gson.fromJson(jsonelement, com/poshmark/data_model/models/ActorBrand)));
                } else
                {
                    s = ((String) (GsonInstrumentation.fromJson((Gson)gson, jsonelement, com/poshmark/data_model/models/ActorBrand)));
                }
                feeditem.setActor((ActorBrand)s);
                return;
            }
        }
    }

    private void createContent(JsonElement jsonelement, FeedItem feeditem, Gson gson)
    {
        Object obj = new FeedItemContentType(jsonelement.getAsJsonObject().get("type").getAsString());
        feeditem.contentType = ((FeedItemContentType) (obj));
        feeditem.contentTotalCount = jsonelement.getAsJsonObject().get("count").getAsInt();
        jsonelement = jsonelement.getAsJsonObject().get("data");
        if (((FeedItemContentType) (obj)).type == com.poshmark.data_model.models.FeedItemContentType.ContentType.Post)
        {
            obj = (new TypeToken() {

                final FeedDeserializer this$0;

            
            {
                this$0 = FeedDeserializer.this;
                super();
            }
            }).getType();
            if (!(gson instanceof Gson))
            {
                jsonelement = ((JsonElement) (gson.fromJson(jsonelement, ((Type) (obj)))));
            } else
            {
                jsonelement = ((JsonElement) (GsonInstrumentation.fromJson((Gson)gson, jsonelement, ((Type) (obj)))));
            }
            feeditem.contentArray = (List)jsonelement;
        } else
        {
            if (((FeedItemContentType) (obj)).type == com.poshmark.data_model.models.FeedItemContentType.ContentType.User)
            {
                obj = (new TypeToken() {

                    final FeedDeserializer this$0;

            
            {
                this$0 = FeedDeserializer.this;
                super();
            }
                }).getType();
                if (!(gson instanceof Gson))
                {
                    jsonelement = ((JsonElement) (gson.fromJson(jsonelement, ((Type) (obj)))));
                } else
                {
                    jsonelement = ((JsonElement) (GsonInstrumentation.fromJson((Gson)gson, jsonelement, ((Type) (obj)))));
                }
                feeditem.contentArray = (List)jsonelement;
                return;
            }
            if (((FeedItemContentType) (obj)).type == com.poshmark.data_model.models.FeedItemContentType.ContentType.Brand)
            {
                obj = (new TypeToken() {

                    final FeedDeserializer this$0;

            
            {
                this$0 = FeedDeserializer.this;
                super();
            }
                }).getType();
                if (!(gson instanceof Gson))
                {
                    jsonelement = ((JsonElement) (gson.fromJson(jsonelement, ((Type) (obj)))));
                } else
                {
                    jsonelement = ((JsonElement) (GsonInstrumentation.fromJson((Gson)gson, jsonelement, ((Type) (obj)))));
                }
                feeditem.contentArray = (List)jsonelement;
                return;
            }
            if (((FeedItemContentType) (obj)).type == com.poshmark.data_model.models.FeedItemContentType.ContentType.PoshmarkPost)
            {
                Type type = (new TypeToken() {

                    final FeedDeserializer this$0;

            
            {
                this$0 = FeedDeserializer.this;
                super();
            }
                }).getType();
                if (!(gson instanceof Gson))
                {
                    jsonelement = ((JsonElement) (gson.fromJson(jsonelement, type)));
                } else
                {
                    jsonelement = ((JsonElement) (GsonInstrumentation.fromJson((Gson)gson, jsonelement, type)));
                }
                feeditem.contentArray = (List)jsonelement;
                return;
            }
        }
    }

    private String getStringValue(JsonObject jsonobject, String s)
    {
        jsonobject = jsonobject.get(s);
        if (jsonobject != null)
        {
            return jsonobject.getAsString();
        } else
        {
            return null;
        }
    }

    public Feed deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        jsondeserializationcontext = (new GsonBuilder()).create();
        type = new Feed();
        jsonelement = jsonelement.getAsJsonObject();
        JsonArray jsonarray = jsonelement.get("data").getAsJsonArray();
        int j = jsonarray.size();
        for (int i = 0; i < j; i++)
        {
            FeedItem feeditem = new FeedItem();
            Object obj = jsonarray.get(i).getAsJsonObject();
            feeditem.storyType = new FeedItemStoryType(getStringValue(((JsonObject) (obj)), "story_type"));
            feeditem.action = getStringValue(((JsonObject) (obj)), "action");
            feeditem.header = getStringValue(((JsonObject) (obj)), "header");
            feeditem.footer = getStringValue(((JsonObject) (obj)), "footer");
            feeditem.createdAt = getStringValue(((JsonObject) (obj)), "created_at");
            Object obj1 = ((JsonObject) (obj)).get("view");
            if (obj1 != null)
            {
                FeedItemImageLayout feeditemimagelayout = new FeedItemImageLayout(((JsonElement) (obj1)).getAsJsonObject().get("layout").getAsString());
                if (feeditemimagelayout.isLayoutValid())
                {
                    feeditem.imageLayout = feeditemimagelayout;
                }
                obj1 = ((JsonElement) (obj1)).getAsJsonObject().getAsJsonObject("header_icon");
                if (obj1 != null)
                {
                    feeditem.setHeaderIconUrl(((JsonObject) (obj1)).get("url").getAsString());
                }
            }
            obj1 = ((JsonObject) (obj)).get("from");
            if (obj1 != null)
            {
                createActor(((JsonElement) (obj1)).getAsJsonObject().get("type").getAsString(), ((JsonElement) (obj1)), feeditem, jsondeserializationcontext);
            }
            obj = ((JsonObject) (obj)).get("content");
            if (obj != null)
            {
                createContent(((JsonElement) (obj)), feeditem, jsondeserializationcontext);
            }
            feeditem.computeFeedItemLayout();
            if (feeditem.validate())
            {
                ((Feed) (type)).data.add(feeditem);
            }
        }

        jsonelement = jsonelement.get("more");
        if (jsonelement != null)
        {
            if (!(jsondeserializationcontext instanceof Gson))
            {
                jsonelement = ((JsonElement) (jsondeserializationcontext.fromJson(jsonelement, com/poshmark/data_model/models/PMData$NextMaxID)));
            } else
            {
                jsonelement = ((JsonElement) (GsonInstrumentation.fromJson((Gson)jsondeserializationcontext, jsonelement, com/poshmark/data_model/models/PMData$NextMaxID)));
            }
            type.more = (com.poshmark.data_model.models.PMData.NextMaxID)jsonelement;
        }
        return type;
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }
}
