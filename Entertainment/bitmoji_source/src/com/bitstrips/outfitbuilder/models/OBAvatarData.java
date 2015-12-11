// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class OBAvatarData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OBAvatarData createFromParcel(Parcel parcel)
        {
            return new OBAvatarData(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public OBAvatarData[] newArray(int i)
        {
            return new OBAvatarData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final String DEFAULT_FEMALE_AVATAR = "122369401_1-s4";
    private static final String DEFAULT_MALE_AVATAR = "122369389_1-s4";
    public static int FEMALE = 2;
    public static int MALE = 1;
    private String avatarId;
    private int bodyType;
    private int breastType;
    private int gender;
    private int skinTone;

    protected OBAvatarData(Parcel parcel)
    {
        avatarId = parcel.readString();
        gender = parcel.readInt();
        bodyType = parcel.readInt();
        breastType = parcel.readInt();
        skinTone = parcel.readInt();
    }

    public OBAvatarData(String s, int i, int j, int k, int l)
    {
        avatarId = s;
        gender = i;
        bodyType = j;
        breastType = k;
        skinTone = l;
    }

    private String encodeJson(JSONObject jsonobject)
    {
        try
        {
            jsonobject = URLEncoder.encode(jsonobject.toString(), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return null;
        }
        return jsonobject;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getBodyJSONString()
    {
        Object obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).put("body_type", bodyType);
            ((JSONObject) (obj)).put("breast_type", breastType);
            obj = encodeJson(((JSONObject) (obj)));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return null;
        }
        return ((String) (obj));
    }

    public String getColourJSONString()
    {
        Object obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).put("ffcc99", skinTone);
            obj = encodeJson(((JSONObject) (obj)));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return null;
        }
        return ((String) (obj));
    }

    public String getDefaultAvatar()
    {
        if (gender == FEMALE)
        {
            return "122369401_1-s4";
        } else
        {
            return "122369389_1-s4";
        }
    }

    public int getGender()
    {
        return gender;
    }

    public String getId()
    {
        return avatarId;
    }

    public String getSaveAvatarPayload(int i)
    {
        Object obj;
        try
        {
            obj = new JSONObject();
            ((JSONObject) (obj)).put("avatar_id", getShortId());
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("outfit", Integer.toString(i));
            jsonobject.put("style", getStyle());
            ((JSONObject) (obj)).put("char_data", jsonobject);
            obj = ((JSONObject) (obj)).toString();
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return null;
        }
        return ((String) (obj));
    }

    public String getShortId()
    {
        return (String)Arrays.asList(avatarId.split("_")).get(0);
    }

    public String getStyle()
    {
        return (String)Arrays.asList(avatarId.split("-s")).get(1);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(avatarId);
        parcel.writeInt(gender);
        parcel.writeInt(bodyType);
        parcel.writeInt(breastType);
        parcel.writeInt(skinTone);
    }

}
