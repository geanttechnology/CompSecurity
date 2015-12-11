// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.wishabi.flipp.content:
//            ba

public class SimpleSearchResult
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ba();
    public final ArrayList a;
    public final ArrayList b;
    public long c;

    public SimpleSearchResult(Parcel parcel)
    {
        c = -1L;
        a = new ArrayList();
        b = new ArrayList();
        parcel.readList(a, java/util/ArrayList.getClassLoader());
        parcel.readList(b, java/util/ArrayList.getClassLoader());
        c = parcel.readLong();
    }

    private SimpleSearchResult(ArrayList arraylist, ArrayList arraylist1)
    {
        c = -1L;
        a = arraylist;
        b = arraylist1;
    }

    public static SimpleSearchResult a()
    {
        return new SimpleSearchResult(new ArrayList(), new ArrayList());
    }

    public static SimpleSearchResult a(JSONObject jsonobject)
    {
        int i;
        boolean flag = false;
        ArrayList arraylist;
        ArrayList arraylist1;
        Object obj;
        try
        {
            arraylist = new ArrayList();
            arraylist1 = new ArrayList();
            obj = jsonobject.getJSONArray("flyer_item_ids");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.toString();
            return null;
        }
        i = 0;
        if (i >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(Long.valueOf(((JSONArray) (obj)).getLong(i)));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_29;
_L1:
        jsonobject = jsonobject.getJSONArray("preview_thumbnails");
        i = ((flag) ? 1 : 0);
_L4:
        if (i >= jsonobject.length())
        {
            break MISSING_BLOCK_LABEL_124;
        }
        obj = jsonobject.getString(i);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        if (!((String) (obj)).equals("") && !((String) (obj)).equals("null"))
        {
            arraylist1.add(jsonobject.getString(i));
        }
        break MISSING_BLOCK_LABEL_144;
        jsonobject = new SimpleSearchResult(arraylist, arraylist1);
        return jsonobject;
        i++;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(a);
        parcel.writeList(b);
        parcel.writeLong(c);
    }

}
