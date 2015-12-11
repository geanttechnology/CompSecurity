// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal.sequencing;

import com.google.b.f;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.api.models.ExcludeFromSerialization;
import com.rdio.android.api.models.generated.BaseAlbum;
import com.rdio.android.api.models.generated.BaseAlbumStation;
import com.rdio.android.api.models.generated.BaseArtist;
import com.rdio.android.api.models.generated.BaseArtistStation;
import com.rdio.android.api.models.generated.BaseArtistTopSongsStation;
import com.rdio.android.api.models.generated.BaseAutoplayStation;
import com.rdio.android.api.models.generated.BaseCategory;
import com.rdio.android.api.models.generated.BaseEditorialCollectionItem;
import com.rdio.android.api.models.generated.BaseGenreStation;
import com.rdio.android.api.models.generated.BaseHeavyRotationStation;
import com.rdio.android.api.models.generated.BaseHeavyRotationUserStation;
import com.rdio.android.api.models.generated.BaseLabel;
import com.rdio.android.api.models.generated.BaseLabelStation;
import com.rdio.android.api.models.generated.BasePlaylist;
import com.rdio.android.api.models.generated.BasePlaylistStation;
import com.rdio.android.api.models.generated.BaseSongStation;
import com.rdio.android.api.models.generated.BaseTasteProfileStation;
import com.rdio.android.api.models.generated.BaseTrack;
import com.rdio.android.api.models.generated.BaseUser;
import com.rdio.android.api.models.generated.BaseUserCollectionStation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class Utils
{

    public Utils()
    {
    }

    public static Class apiTypeToJavaType(String s)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 20: default 176
    //                   97: 301
    //                   99: 565
    //                   101: 550
    //                   104: 535
    //                   108: 580
    //                   112: 475
    //                   114: 315
    //                   115: 343
    //                   116: 329
    //                   3119: 520
    //                   3121: 460
    //                   3307: 400
    //                   3462: 490
    //                   3586: 371
    //                   3648: 357
    //                   3679: 445
    //                   3708: 385
    //                   3710: 505
    //                   100235: 430
    //                   115047: 415;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L1:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_580;
_L22:
        switch (byte0)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("API type: ")).append(s).append(" is not supported").toString());

        case 0: // '\0'
            return com/rdio/android/api/models/generated/BaseAlbum;

        case 1: // '\001'
            return com/rdio/android/api/models/generated/BaseArtist;

        case 2: // '\002'
            return com/rdio/android/api/models/generated/BaseTrack;

        case 3: // '\003'
            return com/rdio/android/api/models/generated/BaseUser;

        case 4: // '\004'
            return com/rdio/android/api/models/generated/BaseArtistStation;

        case 5: // '\005'
            return com/rdio/android/api/models/generated/BasePlaylistStation;

        case 6: // '\006'
            return com/rdio/android/api/models/generated/BaseTasteProfileStation;

        case 7: // '\007'
            return com/rdio/android/api/models/generated/BaseGenreStation;

        case 8: // '\b'
            return com/rdio/android/api/models/generated/BaseCategory;

        case 9: // '\t'
            return com/rdio/android/api/models/generated/BaseEditorialCollectionItem;

        case 10: // '\n'
            return com/rdio/android/api/models/generated/BaseSongStation;

        case 11: // '\013'
            return com/rdio/android/api/models/generated/BaseAlbumStation;

        case 12: // '\f'
            return com/rdio/android/api/models/generated/BasePlaylist;

        case 13: // '\r'
            return com/rdio/android/api/models/generated/BaseLabelStation;

        case 14: // '\016'
            return com/rdio/android/api/models/generated/BaseArtistTopSongsStation;

        case 15: // '\017'
            return com/rdio/android/api/models/generated/BaseAutoplayStation;

        case 16: // '\020'
            return com/rdio/android/api/models/generated/BaseHeavyRotationStation;

        case 17: // '\021'
            return com/rdio/android/api/models/generated/BaseHeavyRotationUserStation;

        case 18: // '\022'
            return com/rdio/android/api/models/generated/BaseUserCollectionStation;

        case 19: // '\023'
            return com/rdio/android/api/models/generated/BaseLabel;
        }
_L2:
        if (s.equals("a"))
        {
            byte0 = 0;
        }
          goto _L22
_L8:
        if (s.equals("r"))
        {
            byte0 = 1;
        }
          goto _L22
_L10:
        if (s.equals("t"))
        {
            byte0 = 2;
        }
          goto _L22
_L9:
        if (s.equals("s"))
        {
            byte0 = 3;
        }
          goto _L22
_L16:
        if (s.equals("rr"))
        {
            byte0 = 4;
        }
          goto _L22
_L15:
        if (s.equals("pr"))
        {
            byte0 = 5;
        }
          goto _L22
_L18:
        if (s.equals("tp"))
        {
            byte0 = 6;
        }
          goto _L22
_L13:
        if (s.equals("gr"))
        {
            byte0 = 7;
        }
          goto _L22
_L21:
        if (s.equals("tpc"))
        {
            byte0 = 8;
        }
          goto _L22
_L20:
        if (s.equals("eci"))
        {
            byte0 = 9;
        }
          goto _L22
_L17:
        if (s.equals("sr"))
        {
            byte0 = 10;
        }
          goto _L22
_L12:
        if (s.equals("ar"))
        {
            byte0 = 11;
        }
          goto _L22
_L7:
        if (s.equals("p"))
        {
            byte0 = 12;
        }
          goto _L22
_L14:
        if (s.equals("lr"))
        {
            byte0 = 13;
        }
          goto _L22
_L19:
        if (s.equals("tr"))
        {
            byte0 = 14;
        }
          goto _L22
_L11:
        if (s.equals("ap"))
        {
            byte0 = 15;
        }
          goto _L22
_L5:
        if (s.equals("h"))
        {
            byte0 = 16;
        }
          goto _L22
_L4:
        if (s.equals("e"))
        {
            byte0 = 17;
        }
          goto _L22
_L3:
        if (s.equals("c"))
        {
            byte0 = 18;
        }
          goto _L22
        if (s.equals("l"))
        {
            byte0 = 19;
        }
          goto _L22
    }

    public static ApiModel createNewModel(f f1, String s, JSONObject jsonobject)
    {
        prepareJson(jsonobject);
        ApiModel apimodel = (ApiModel)f1.a(jsonobject.toString(), apiTypeToJavaType(jsonobject.getString("type")));
        Field afield[];
        int j;
        afield = apimodel.getClass().getFields();
        j = afield.length;
        int i = 0;
_L3:
        if (i >= j) goto _L2; else goto _L1
_L1:
        Field field = afield[i];
        Object obj;
        if (!field.isAnnotationPresent(com/rdio/android/api/models/ExcludeFromSerialization) || !jsonobject.has(field.getName()))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = jsonobject.get(field.getName());
        if (!(obj instanceof JSONObject) || !isJsonAModel((JSONObject)obj))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (JSONObject)obj;
        try
        {
            field.set(apimodel, createNewModel(f1, ((JSONObject) (obj)).getString("key"), ((JSONObject) (obj))));
        }
        catch (IllegalAccessException illegalaccessexception) { }
        i++;
          goto _L3
_L2:
        apimodel.loadedFields = new ArrayList();
        jsonobject = jsonobject.keys();
_L5:
        f1 = apimodel;
        if (!jsonobject.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        apimodel.loadedFields.add((String)jsonobject.next());
        if (true) goto _L5; else goto _L4
        f1;
        f1 = apimodel;
_L7:
        (new StringBuilder("processModel: Error parsing JSON, model: ")).append(s).append(" not processed!");
_L4:
        return f1;
        f1;
        f1 = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static boolean isJsonAModel(JSONObject jsonobject)
    {
        while (!jsonobject.has("key") || !jsonobject.has("type") || apiTypeToJavaType(jsonobject.getString("type")) == null) 
        {
            return false;
        }
        return true;
    }

    public static void prepareJson(JSONObject jsonobject)
    {
        Iterator iterator = jsonobject.keys();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            try
            {
                if (jsonobject.get(s) instanceof JSONObject)
                {
                    JSONObject jsonobject1 = jsonobject.getJSONObject(s);
                    if (jsonobject1.has("type") && jsonobject1.has("items"))
                    {
                        jsonobject.put(s, jsonobject1.getJSONArray("items"));
                    }
                }
            }
            catch (JSONException jsonexception) { }
        } while (true);
    }
}
