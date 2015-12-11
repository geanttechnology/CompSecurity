// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.b.f;
import com.rdio.android.api.models.Ad;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.api.models.BaseStation;
import com.rdio.android.api.models.CoreUser;
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
        JVM INSTR lookupswitch 21: default 184
    //                   97: 313
    //                   99: 592
    //                   101: 577
    //                   104: 562
    //                   108: 607
    //                   112: 502
    //                   114: 341
    //                   115: 369
    //                   116: 355
    //                   3107: 327
    //                   3119: 547
    //                   3121: 487
    //                   3307: 427
    //                   3462: 517
    //                   3586: 397
    //                   3648: 383
    //                   3679: 472
    //                   3708: 412
    //                   3710: 532
    //                   100235: 457
    //                   115047: 442;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22
_L1:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_607;
_L23:
        switch (byte0)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("API type: ")).append(s).append(" is not supported").toString());

        case 0: // '\0'
            return com/rdio/android/api/models/generated/BaseAlbum;

        case 1: // '\001'
            return com/rdio/android/api/models/Ad;

        case 2: // '\002'
            return com/rdio/android/api/models/generated/BaseArtist;

        case 3: // '\003'
            return com/rdio/android/api/models/generated/BaseTrack;

        case 4: // '\004'
            return com/rdio/android/api/models/CoreUser;

        case 5: // '\005'
            return com/rdio/android/api/models/generated/BaseArtistStation;

        case 6: // '\006'
            return com/rdio/android/api/models/generated/BasePlaylistStation;

        case 7: // '\007'
            return com/rdio/android/api/models/generated/BaseTasteProfileStation;

        case 8: // '\b'
            return com/rdio/android/api/models/generated/BaseGenreStation;

        case 9: // '\t'
            return com/rdio/android/api/models/generated/BaseCategory;

        case 10: // '\n'
            return com/rdio/android/api/models/generated/BaseEditorialCollectionItem;

        case 11: // '\013'
            return com/rdio/android/api/models/generated/BaseSongStation;

        case 12: // '\f'
            return com/rdio/android/api/models/generated/BaseAlbumStation;

        case 13: // '\r'
            return com/rdio/android/api/models/generated/BasePlaylist;

        case 14: // '\016'
            return com/rdio/android/api/models/generated/BaseLabelStation;

        case 15: // '\017'
            return com/rdio/android/api/models/generated/BaseArtistTopSongsStation;

        case 16: // '\020'
            return com/rdio/android/api/models/generated/BaseAutoplayStation;

        case 17: // '\021'
            return com/rdio/android/api/models/generated/BaseHeavyRotationStation;

        case 18: // '\022'
            return com/rdio/android/api/models/generated/BaseHeavyRotationUserStation;

        case 19: // '\023'
            return com/rdio/android/api/models/generated/BaseUserCollectionStation;

        case 20: // '\024'
            return com/rdio/android/api/models/generated/BaseLabel;
        }
_L2:
        if (s.equals("a"))
        {
            byte0 = 0;
        }
          goto _L23
_L11:
        if (s.equals("ad"))
        {
            byte0 = 1;
        }
          goto _L23
_L8:
        if (s.equals("r"))
        {
            byte0 = 2;
        }
          goto _L23
_L10:
        if (s.equals("t"))
        {
            byte0 = 3;
        }
          goto _L23
_L9:
        if (s.equals("s"))
        {
            byte0 = 4;
        }
          goto _L23
_L17:
        if (s.equals("rr"))
        {
            byte0 = 5;
        }
          goto _L23
_L16:
        if (s.equals("pr"))
        {
            byte0 = 6;
        }
          goto _L23
_L19:
        if (s.equals("tp"))
        {
            byte0 = 7;
        }
          goto _L23
_L14:
        if (s.equals("gr"))
        {
            byte0 = 8;
        }
          goto _L23
_L22:
        if (s.equals("tpc"))
        {
            byte0 = 9;
        }
          goto _L23
_L21:
        if (s.equals("eci"))
        {
            byte0 = 10;
        }
          goto _L23
_L18:
        if (s.equals("sr"))
        {
            byte0 = 11;
        }
          goto _L23
_L13:
        if (s.equals("ar"))
        {
            byte0 = 12;
        }
          goto _L23
_L7:
        if (s.equals("p"))
        {
            byte0 = 13;
        }
          goto _L23
_L15:
        if (s.equals("lr"))
        {
            byte0 = 14;
        }
          goto _L23
_L20:
        if (s.equals("tr"))
        {
            byte0 = 15;
        }
          goto _L23
_L12:
        if (s.equals("ap"))
        {
            byte0 = 16;
        }
          goto _L23
_L5:
        if (s.equals("h"))
        {
            byte0 = 17;
        }
          goto _L23
_L4:
        if (s.equals("e"))
        {
            byte0 = 18;
        }
          goto _L23
_L3:
        if (s.equals("c"))
        {
            byte0 = 19;
        }
          goto _L23
        if (s.equals("l"))
        {
            byte0 = 20;
        }
          goto _L23
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

    private static Object extractFieldFromStation(BaseStation basestation, String s, Class class1)
    {
        class1 = basestation.getClass();
        try
        {
            basestation = ((BaseStation) (class1.getField(s).get(basestation)));
        }
        // Misplaced declaration of an exception variable
        catch (BaseStation basestation)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (BaseStation basestation)
        {
            return null;
        }
        return basestation;
    }

    public static String getUserAgentString(Context context)
    {
        try
        {
            String s = context.getPackageName();
            context = context.getPackageManager().getPackageInfo(s, 0);
            String s1 = ((PackageInfo) (context)).versionName;
            context = (new StringBuilder()).append("Rdio Android SDK; ").append(s).append("/").append(s1).append("; build ").append(((PackageInfo) (context)).versionCode).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("RdioUtils", (new StringBuilder("There was an error building the user agent string ")).append(context).toString());
            return "Rdio Android SDK; ";
        }
        return context;
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
