// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AdUnitsState
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AdUnitsState createFromParcel(Parcel parcel)
        {
            return new AdUnitsState(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public AdUnitsState[] newArray(int i)
        {
            return new AdUnitsState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private int mDisplayedProduct;
    private String mInterstitialAppKey;
    private Map mInterstitialExtraParams;
    private boolean mInterstitialInitSuccess;
    private boolean mInterstitialReportInit;
    private String mInterstitialUserId;
    private String mRewardedVideoAppKey;
    private Map mRewardedVideoExtraParams;
    private boolean mRewardedVideoInitSuccess;
    private String mRewardedVideoUserId;
    private boolean mShouldRestore;

    public AdUnitsState()
    {
        initialize();
    }

    private AdUnitsState(Parcel parcel)
    {
        boolean flag1;
        flag1 = true;
        super();
        initialize();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShouldRestore = flag;
        mDisplayedProduct = parcel.readInt();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mRewardedVideoInitSuccess = flag;
        mRewardedVideoAppKey = parcel.readString();
        mRewardedVideoUserId = parcel.readString();
        mRewardedVideoExtraParams = getMapFromJsonString(parcel.readString());
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mInterstitialReportInit = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        try
        {
            mInterstitialInitSuccess = flag;
            mInterstitialAppKey = parcel.readString();
            mInterstitialUserId = parcel.readString();
            mInterstitialExtraParams = getMapFromJsonString(parcel.readString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            initialize();
        }
        return;
    }


    private Map getMapFromJsonString(String s)
    {
        HashMap hashmap = new HashMap();
        try
        {
            s = new JSONObject(s);
            String s1;
            for (Iterator iterator = s.keys(); iterator.hasNext(); hashmap.put(s1, s.getString(s1)))
            {
                s1 = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return hashmap;
        }
        return hashmap;
    }

    private void initialize()
    {
        mShouldRestore = false;
        mDisplayedProduct = -1;
        mInterstitialReportInit = true;
        mInterstitialInitSuccess = false;
        mRewardedVideoInitSuccess = false;
        mInterstitialUserId = "";
        mInterstitialAppKey = "";
        mRewardedVideoUserId = "";
        mRewardedVideoAppKey = "";
        mRewardedVideoExtraParams = new HashMap();
        mInterstitialExtraParams = new HashMap();
    }

    public void adClosed()
    {
        mDisplayedProduct = -1;
    }

    public void adOpened(int i)
    {
        mDisplayedProduct = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getDisplayedProduct()
    {
        return mDisplayedProduct;
    }

    public String getInterstitialAppKey()
    {
        return mInterstitialAppKey;
    }

    public Map getInterstitialExtraParams()
    {
        return mInterstitialExtraParams;
    }

    public String getInterstitialUserId()
    {
        return mInterstitialUserId;
    }

    public String getRewardedVideoAppKey()
    {
        return mRewardedVideoAppKey;
    }

    public Map getRewardedVideoExtraParams()
    {
        return mRewardedVideoExtraParams;
    }

    public String getRewardedVideoUserId()
    {
        return mRewardedVideoUserId;
    }

    public boolean isInterstitialInitSuccess()
    {
        return mInterstitialInitSuccess;
    }

    public boolean isRewardedVideoInitSuccess()
    {
        return mRewardedVideoInitSuccess;
    }

    public boolean reportInitInterstitial()
    {
        return mInterstitialReportInit;
    }

    public void setInterstitialAppKey(String s)
    {
        mInterstitialAppKey = s;
    }

    public void setInterstitialExtraParams(Map map)
    {
        mInterstitialExtraParams = map;
    }

    public void setInterstitialInitSuccess(boolean flag)
    {
        mInterstitialInitSuccess = flag;
    }

    public void setInterstitialUserId(String s)
    {
        mInterstitialUserId = s;
    }

    public void setReportInitInterstitial(boolean flag)
    {
        mInterstitialReportInit = flag;
    }

    public void setRewardedVideoAppKey(String s)
    {
        mRewardedVideoAppKey = s;
    }

    public void setRewardedVideoExtraParams(Map map)
    {
        mRewardedVideoExtraParams = map;
    }

    public void setRewardedVideoInitSuccess(boolean flag)
    {
        mRewardedVideoInitSuccess = flag;
    }

    public void setRewardedVideoUserId(String s)
    {
        mRewardedVideoUserId = s;
    }

    public void setShouldRestore(boolean flag)
    {
        mShouldRestore = flag;
    }

    public boolean shouldRestore()
    {
        return mShouldRestore;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        try
        {
            stringbuilder.append("shouldRestore:").append(mShouldRestore).append(", ");
            stringbuilder.append("displayedProduct:").append(mDisplayedProduct).append(", ");
            stringbuilder.append("RVInitSuccess:").append(mRewardedVideoInitSuccess).append(", ");
            stringbuilder.append("RVAppKey").append(mRewardedVideoAppKey).append(", ");
            stringbuilder.append("RVUserId").append(mRewardedVideoUserId).append(", ");
            stringbuilder.append("RVExtraParams").append(mRewardedVideoExtraParams).append(", ");
            stringbuilder.append("ISReportInit:").append(mInterstitialReportInit).append(", ");
            stringbuilder.append("ISInitSuccess:").append(mInterstitialInitSuccess).append(", ");
            stringbuilder.append("ISAppKey").append(mInterstitialAppKey).append(", ");
            stringbuilder.append("ISUserId").append(mInterstitialUserId).append(", ");
            stringbuilder.append("ISExtraParams").append(mInterstitialExtraParams).append(", ");
        }
        catch (Throwable throwable) { }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        if (mShouldRestore)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeInt(mDisplayedProduct);
        if (mRewardedVideoInitSuccess)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeString(mRewardedVideoAppKey);
        parcel.writeString(mRewardedVideoUserId);
        parcel.writeString((new JSONObject(mRewardedVideoExtraParams)).toString());
        if (mInterstitialReportInit)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mInterstitialInitSuccess)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        try
        {
            parcel.writeByte((byte)i);
            parcel.writeString(mInterstitialAppKey);
            parcel.writeString(mInterstitialUserId);
            parcel.writeString((new JSONObject(mInterstitialExtraParams)).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            return;
        }
    }

}
