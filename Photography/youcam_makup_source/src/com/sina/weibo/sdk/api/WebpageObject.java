// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.sina.weibo.sdk.api:
//            BaseMediaObject

public class WebpageObject extends BaseMediaObject
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WebpageObject createFromParcel(Parcel parcel)
        {
            return new WebpageObject(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public WebpageObject[] newArray(int i)
        {
            return new WebpageObject[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String EXTRA_KEY_DEFAULTTEXT = "extra_key_defaulttext";
    public String defaultText;

    public WebpageObject()
    {
    }

    public WebpageObject(Parcel parcel)
    {
        super(parcel);
    }

    public boolean checkArgs()
    {
        return super.checkArgs();
    }

    public int getObjType()
    {
        return 5;
    }

    protected BaseMediaObject toExtraMediaObject(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            try
            {
                defaultText = (new JSONObject(s)).optString("extra_key_defaulttext");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return this;
            }
        }
        return this;
    }

    protected String toExtraMediaString()
    {
        Object obj;
        try
        {
            obj = new JSONObject();
            if (!TextUtils.isEmpty(defaultText))
            {
                ((JSONObject) (obj)).put("extra_key_defaulttext", defaultText);
            }
            obj = ((JSONObject) (obj)).toString();
        }
        catch (JSONException jsonexception)
        {
            return "";
        }
        return ((String) (obj));
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
    }

}
