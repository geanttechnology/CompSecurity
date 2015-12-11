// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.net.Uri;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.MetaItem;
import java.io.File;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class StringUtils
{
    public static class ListingDetailsDeserializer
        implements JsonDeserializer
    {

        public ListingDetails deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            if (jsonelement.isJsonObject())
            {
                ((JsonObject)jsonelement).get("path");
            }
            return null;
        }

        public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type, jsondeserializationcontext);
        }

        public ListingDetailsDeserializer()
        {
        }
    }

    public static class ListingDetailsSerializer
        implements JsonSerializer
    {

        public JsonElement serialize(ListingDetails listingdetails, Type type, JsonSerializationContext jsonserializationcontext)
        {
            return new JsonObject();
        }

        public volatile JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonserializationcontext)
        {
            return serialize((ListingDetails)obj, type, jsonserializationcontext);
        }

        public ListingDetailsSerializer()
        {
        }
    }

    public static class UriDeserializer
        implements JsonDeserializer
    {

        public Uri deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            if (jsonelement.isJsonObject())
            {
                return Uri.fromFile(new File(((JsonObject)jsonelement).get("path").getAsString()));
            } else
            {
                return null;
            }
        }

        public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type, jsondeserializationcontext);
        }

        public UriDeserializer()
        {
        }
    }

    public static class UriSerializer
        implements JsonSerializer
    {

        public JsonElement serialize(Uri uri, Type type, JsonSerializationContext jsonserializationcontext)
        {
            type = new JsonObject();
            type.addProperty("path", uri.getPath());
            return type;
        }

        public volatile JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonserializationcontext)
        {
            return serialize((Uri)obj, type, jsonserializationcontext);
        }

        public UriSerializer()
        {
        }
    }


    private static final String NON_THIN = "[^iIl1\\.,']";

    public StringUtils()
    {
    }

    public static String abbreviatedStringRepresentationOfNumber(int i)
    {
        if (i <= 0)
        {
            return "0";
        }
        float f = (float)i / 1000F;
        String s;
        if (f >= 10F && f < 1000F)
        {
            s = String.format("%dk", new Object[] {
                Integer.valueOf((int)f)
            });
        } else
        if (f >= 1000F)
        {
            f = ((f / 1000F) * 10F) / 10F;
            if (f - (float)(int)f != 0.0F)
            {
                s = String.format("%.1fm", new Object[] {
                    Float.valueOf(f)
                });
            } else
            {
                s = String.format("%dm", new Object[] {
                    Integer.valueOf((int)f)
                });
            }
        } else
        {
            s = String.format("%d", new Object[] {
                Integer.valueOf(i)
            });
        }
        return s;
    }

    public static String ellipsize(String s, int i)
    {
        if (textWidth(s) <= i)
        {
            return s;
        }
        int k = s.lastIndexOf(' ', i - 3);
        if (k == -1)
        {
            return (new StringBuilder()).append(s.substring(0, i - 3)).append("...").toString();
        }
        int j;
        int l;
        do
        {
            l = k;
            k = s.indexOf(' ', l + 1);
            j = k;
            if (k == -1)
            {
                j = s.length();
            }
            k = j;
        } while (textWidth((new StringBuilder()).append(s.substring(0, j)).append("...").toString()) < i);
        return (new StringBuilder()).append(s.substring(0, l)).append("...").toString();
    }

    public static Object fromJson(String s, TypeToken typetoken)
    {
        Gson gson = new Gson();
        typetoken = typetoken.getType();
        if (!(gson instanceof Gson))
        {
            return gson.fromJson(s, typetoken);
        } else
        {
            return GsonInstrumentation.fromJson((Gson)gson, s, typetoken);
        }
    }

    public static Object fromJson(String s, Class class1)
    {
        Gson gson = new Gson();
        if (!(gson instanceof Gson))
        {
            return gson.fromJson(s, class1);
        } else
        {
            return GsonInstrumentation.fromJson((Gson)gson, s, class1);
        }
    }

    public static List imageListFromJson(String s, TypeToken typetoken)
    {
        Gson gson = (new GsonBuilder()).registerTypeAdapter(android/net/Uri, new UriDeserializer()).create();
        typetoken = typetoken.getType();
        if (!(gson instanceof Gson))
        {
            s = ((String) (gson.fromJson(s, typetoken)));
        } else
        {
            s = ((String) (GsonInstrumentation.fromJson((Gson)gson, s, typetoken)));
        }
        return (List)s;
    }

    public static String imageListToJson(List list, Type type)
    {
        Gson gson = (new GsonBuilder()).registerTypeAdapter(android/net/Uri, new UriSerializer()).create();
        if (!(gson instanceof Gson))
        {
            return gson.toJson(list, type);
        } else
        {
            return GsonInstrumentation.toJson((Gson)gson, list, type);
        }
    }

    public static String join(List list, String s)
    {
        return org.apache.commons.lang3.StringUtils.join(list, s);
    }

    public static List listingDetailsFromJson(String s, TypeToken typetoken)
    {
        Gson gson = (new GsonBuilder()).registerTypeAdapter(android/net/Uri, new UriDeserializer()).create();
        typetoken = typetoken.getType();
        if (!(gson instanceof Gson))
        {
            s = ((String) (gson.fromJson(s, typetoken)));
        } else
        {
            s = ((String) (GsonInstrumentation.fromJson((Gson)gson, s, typetoken)));
        }
        return (List)s;
    }

    public static String listingDetailsToJson(ListingDetails listingdetails, Type type)
    {
        type = (new GsonBuilder()).registerTypeAdapter(android/net/Uri, new UriSerializer()).create();
        if (!(type instanceof Gson))
        {
            return type.toJson(listingdetails, com/poshmark/data_model/models/ListingDetails);
        } else
        {
            return GsonInstrumentation.toJson((Gson)type, listingdetails, com/poshmark/data_model/models/ListingDetails);
        }
    }

    private static int textWidth(String s)
    {
        return s.length() - s.replaceAll("[^iIl1\\.,']", "").length() / 2;
    }

    public static String toJson(MetaItem metaitem, Type type)
    {
        Gson gson = new Gson();
        if (!(gson instanceof Gson))
        {
            return gson.toJson(metaitem, type);
        } else
        {
            return GsonInstrumentation.toJson((Gson)gson, metaitem, type);
        }
    }

    public static String toJson(Object obj)
    {
        Gson gson = new Gson();
        if (!(gson instanceof Gson))
        {
            return gson.toJson(obj);
        } else
        {
            return GsonInstrumentation.toJson((Gson)gson, obj);
        }
    }

    public static String toJson(List list, Type type)
    {
        Gson gson = new Gson();
        if (!(gson instanceof Gson))
        {
            return gson.toJson(list, type);
        } else
        {
            return GsonInstrumentation.toJson((Gson)gson, list, type);
        }
    }

    public static String toJson(Map map, Type type)
    {
        Gson gson = new Gson();
        if (!(gson instanceof Gson))
        {
            return gson.toJson(map, type);
        } else
        {
            return GsonInstrumentation.toJson((Gson)gson, map, type);
        }
    }

    public static String urlEncode(String s)
    {
        try
        {
            s = URLEncoder.encode(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.wtf("", "UTF-8 should always be supported", s);
            return "";
        }
        return s;
    }
}
