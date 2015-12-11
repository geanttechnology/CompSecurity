// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral.util;

import android.os.Parcel;
import android.os.Parcelable;
import io.branch.referral.Branch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class LinkProperties
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LinkProperties createFromParcel(Parcel parcel)
        {
            return new LinkProperties(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public LinkProperties[] newArray(int i)
        {
            return new LinkProperties[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private String alias_;
    private String channel_;
    private final HashMap controlParams_;
    private String feature_;
    private int matchDuration_;
    private String stage_;
    private final ArrayList tags_;

    public LinkProperties()
    {
        tags_ = new ArrayList();
        feature_ = "Share";
        controlParams_ = new HashMap();
        alias_ = "";
        stage_ = "";
        matchDuration_ = 0;
        channel_ = "";
    }

    private LinkProperties(Parcel parcel)
    {
        this();
        feature_ = parcel.readString();
        alias_ = parcel.readString();
        stage_ = parcel.readString();
        channel_ = parcel.readString();
        matchDuration_ = parcel.readInt();
        ArrayList arraylist = (ArrayList)parcel.readSerializable();
        tags_.addAll(arraylist);
        int j = parcel.readInt();
        for (int i = 0; i < j; i++)
        {
            controlParams_.put(parcel.readString(), parcel.readString());
        }

    }


    public static LinkProperties getReferredLinkProperties()
    {
        Object obj;
        Object obj1 = null;
        Object obj2 = Branch.getInstance();
        obj = obj1;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        obj = obj1;
        if (((Branch) (obj2)).getLatestReferringParams() == null)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        obj2 = ((Branch) (obj2)).getLatestReferringParams();
        obj = obj1;
        Exception exception;
        String s;
        int i;
        try
        {
            if (!((JSONObject) (obj2)).has("+clicked_branch_link"))
            {
                break MISSING_BLOCK_LABEL_252;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        obj = obj1;
        if (!((JSONObject) (obj2)).getBoolean("+clicked_branch_link"))
        {
            break MISSING_BLOCK_LABEL_252;
        }
        obj = new LinkProperties();
        if (((JSONObject) (obj2)).has("~channel"))
        {
            ((LinkProperties) (obj)).setChannel(((JSONObject) (obj2)).getString("~channel"));
        }
        if (((JSONObject) (obj2)).has("~feature"))
        {
            ((LinkProperties) (obj)).setFeature(((JSONObject) (obj2)).getString("~feature"));
        }
        if (((JSONObject) (obj2)).has("~stage"))
        {
            ((LinkProperties) (obj)).setStage(((JSONObject) (obj2)).getString("~stage"));
        }
        if (((JSONObject) (obj2)).has("~duration"))
        {
            ((LinkProperties) (obj)).setDuration(((JSONObject) (obj2)).getInt("~duration"));
        }
        if (((JSONObject) (obj2)).has("$match_duration"))
        {
            ((LinkProperties) (obj)).setDuration(((JSONObject) (obj2)).getInt("$match_duration"));
        }
        if (!((JSONObject) (obj2)).has("~tags")) goto _L2; else goto _L1
_L1:
        obj1 = ((JSONObject) (obj2)).getJSONArray("~tags");
        i = 0;
_L3:
        if (i >= ((JSONArray) (obj1)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        ((LinkProperties) (obj)).addTag(((JSONArray) (obj1)).getString(i));
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        try
        {
            obj1 = ((JSONObject) (obj2)).keys();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                s = (String)((Iterator) (obj1)).next();
                if (s.startsWith("$"))
                {
                    ((LinkProperties) (obj)).addControlParameter(s, ((JSONObject) (obj2)).getString(s));
                }
            } while (true);
            break MISSING_BLOCK_LABEL_257;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception) { }
        return ((LinkProperties) (obj));
        return ((LinkProperties) (obj));
    }

    public LinkProperties addControlParameter(String s, String s1)
    {
        controlParams_.put(s, s1);
        return this;
    }

    public LinkProperties addTag(String s)
    {
        tags_.add(s);
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAlias()
    {
        return alias_;
    }

    public String getChannel()
    {
        return channel_;
    }

    public HashMap getControlParams()
    {
        return controlParams_;
    }

    public String getFeature()
    {
        return feature_;
    }

    public int getMatchDuration()
    {
        return matchDuration_;
    }

    public String getStage()
    {
        return stage_;
    }

    public ArrayList getTags()
    {
        return tags_;
    }

    public LinkProperties setAlias(String s)
    {
        alias_ = s;
        return this;
    }

    public LinkProperties setChannel(String s)
    {
        channel_ = s;
        return this;
    }

    public LinkProperties setDuration(int i)
    {
        matchDuration_ = i;
        return this;
    }

    public LinkProperties setFeature(String s)
    {
        feature_ = s;
        return this;
    }

    public LinkProperties setStage(String s)
    {
        stage_ = s;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(feature_);
        parcel.writeString(alias_);
        parcel.writeString(stage_);
        parcel.writeString(channel_);
        parcel.writeInt(matchDuration_);
        parcel.writeSerializable(tags_);
        parcel.writeInt(controlParams_.size());
        java.util.Map.Entry entry;
        for (Iterator iterator = controlParams_.entrySet().iterator(); iterator.hasNext(); parcel.writeString((String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
            parcel.writeString((String)entry.getKey());
        }

    }

}
