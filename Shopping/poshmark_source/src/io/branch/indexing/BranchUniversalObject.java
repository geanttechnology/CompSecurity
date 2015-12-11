// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.indexing;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.BranchShortLinkBuilder;
import io.branch.referral.util.LinkProperties;
import io.branch.referral.util.ShareSheetStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BranchUniversalObject
    implements Parcelable
{
    public static final class CONTENT_INDEX_MODE extends Enum
    {

        private static final CONTENT_INDEX_MODE $VALUES[];
        public static final CONTENT_INDEX_MODE PRIVATE;
        public static final CONTENT_INDEX_MODE PUBLIC;

        public static CONTENT_INDEX_MODE valueOf(String s)
        {
            return (CONTENT_INDEX_MODE)Enum.valueOf(io/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE, s);
        }

        public static CONTENT_INDEX_MODE[] values()
        {
            return (CONTENT_INDEX_MODE[])$VALUES.clone();
        }

        static 
        {
            PUBLIC = new CONTENT_INDEX_MODE("PUBLIC", 0);
            PRIVATE = new CONTENT_INDEX_MODE("PRIVATE", 1);
            $VALUES = (new CONTENT_INDEX_MODE[] {
                PUBLIC, PRIVATE
            });
        }

        private CONTENT_INDEX_MODE(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface RegisterViewStatusListener
    {

        public abstract void onRegisterViewFinished(boolean flag, BranchError brancherror);
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public BranchUniversalObject createFromParcel(Parcel parcel)
        {
            return new BranchUniversalObject(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public BranchUniversalObject[] newArray(int i)
        {
            return new BranchUniversalObject[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private String canonicalIdentifier_;
    private String description_;
    private long expirationInMilliSec_;
    private String imageUrl_;
    private CONTENT_INDEX_MODE indexMode_;
    private final ArrayList keywords_;
    private final HashMap metadata_;
    private String title_;
    private String type_;

    public BranchUniversalObject()
    {
        metadata_ = new HashMap();
        keywords_ = new ArrayList();
        canonicalIdentifier_ = "";
        title_ = "";
        description_ = "";
        type_ = "";
        indexMode_ = CONTENT_INDEX_MODE.PUBLIC;
        expirationInMilliSec_ = 0L;
    }

    private BranchUniversalObject(Parcel parcel)
    {
        this();
        canonicalIdentifier_ = parcel.readString();
        title_ = parcel.readString();
        description_ = parcel.readString();
        imageUrl_ = parcel.readString();
        type_ = parcel.readString();
        expirationInMilliSec_ = parcel.readLong();
        indexMode_ = CONTENT_INDEX_MODE.values()[parcel.readInt()];
        ArrayList arraylist = (ArrayList)parcel.readSerializable();
        keywords_.addAll(arraylist);
        int j = parcel.readInt();
        for (int i = 0; i < j; i++)
        {
            metadata_.put(parcel.readString(), parcel.readString());
        }

    }


    private BranchShortLinkBuilder getLinkBuilder(Context context, LinkProperties linkproperties)
    {
        context = new BranchShortLinkBuilder(context);
        if (linkproperties.getTags() != null)
        {
            context.addTags(linkproperties.getTags());
        }
        if (linkproperties.getFeature() != null)
        {
            context.setFeature(linkproperties.getFeature());
        }
        if (linkproperties.getAlias() != null)
        {
            context.setAlias(linkproperties.getAlias());
        }
        if (linkproperties.getChannel() != null)
        {
            context.setChannel(linkproperties.getChannel());
        }
        if (linkproperties.getStage() != null)
        {
            context.setStage(linkproperties.getStage());
        }
        if (linkproperties.getMatchDuration() > 0)
        {
            context.setDuration(linkproperties.getMatchDuration());
        }
        context.addParameters(io.branch.referral.Defines.Jsonkey.ContentTitle.getKey(), title_);
        context.addParameters(io.branch.referral.Defines.Jsonkey.CanonicalIdentifier.getKey(), canonicalIdentifier_);
        context.addParameters(io.branch.referral.Defines.Jsonkey.ContentKeyWords.getKey(), getKeywordsJsonArray());
        context.addParameters(io.branch.referral.Defines.Jsonkey.ContentDesc.getKey(), description_);
        context.addParameters(io.branch.referral.Defines.Jsonkey.ContentImgUrl.getKey(), imageUrl_);
        context.addParameters(io.branch.referral.Defines.Jsonkey.ContentType.getKey(), type_);
        context.addParameters(io.branch.referral.Defines.Jsonkey.ContentExpiryTime.getKey(), (new StringBuilder()).append("").append(expirationInMilliSec_).toString());
        String s;
        for (Iterator iterator = metadata_.keySet().iterator(); iterator.hasNext(); context.addParameters(s, (String)metadata_.get(s)))
        {
            s = (String)iterator.next();
        }

        linkproperties = linkproperties.getControlParams();
        String s1;
        for (Iterator iterator1 = linkproperties.keySet().iterator(); iterator1.hasNext(); context.addParameters(s1, (String)linkproperties.get(s1)))
        {
            s1 = (String)iterator1.next();
        }

        return context;
    }

    public static BranchUniversalObject getReferredBranchUniversalObject()
    {
        Object obj;
        Object obj1 = null;
        Object obj2 = Branch.getInstance();
        obj = obj1;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        obj = obj1;
        if (((Branch) (obj2)).getLatestReferringParams() == null)
        {
            break MISSING_BLOCK_LABEL_319;
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
                break MISSING_BLOCK_LABEL_319;
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
            break MISSING_BLOCK_LABEL_319;
        }
        obj = new BranchUniversalObject();
        if (((JSONObject) (obj2)).has(io.branch.referral.Defines.Jsonkey.ContentTitle.getKey()))
        {
            obj.title_ = ((JSONObject) (obj2)).getString(io.branch.referral.Defines.Jsonkey.ContentTitle.getKey());
        }
        if (((JSONObject) (obj2)).has(io.branch.referral.Defines.Jsonkey.CanonicalIdentifier.getKey()))
        {
            obj.canonicalIdentifier_ = ((JSONObject) (obj2)).getString(io.branch.referral.Defines.Jsonkey.CanonicalIdentifier.getKey());
        }
        if (!((JSONObject) (obj2)).has(io.branch.referral.Defines.Jsonkey.ContentKeyWords.getKey())) goto _L2; else goto _L1
_L1:
        obj1 = ((JSONObject) (obj2)).getJSONArray(io.branch.referral.Defines.Jsonkey.ContentKeyWords.getKey());
        i = 0;
_L3:
        if (i >= ((JSONArray) (obj1)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        ((BranchUniversalObject) (obj)).keywords_.add((String)((JSONArray) (obj1)).get(i));
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        try
        {
            if (((JSONObject) (obj2)).has(io.branch.referral.Defines.Jsonkey.ContentDesc.getKey()))
            {
                obj.description_ = ((JSONObject) (obj2)).getString(io.branch.referral.Defines.Jsonkey.ContentDesc.getKey());
            }
            if (((JSONObject) (obj2)).has(io.branch.referral.Defines.Jsonkey.ContentImgUrl.getKey()))
            {
                obj.imageUrl_ = ((JSONObject) (obj2)).getString(io.branch.referral.Defines.Jsonkey.ContentImgUrl.getKey());
            }
            if (((JSONObject) (obj2)).has(io.branch.referral.Defines.Jsonkey.ContentType.getKey()))
            {
                obj.type_ = ((JSONObject) (obj2)).getString(io.branch.referral.Defines.Jsonkey.ContentType.getKey());
            }
            if (((JSONObject) (obj2)).has(io.branch.referral.Defines.Jsonkey.ContentExpiryTime.getKey()))
            {
                obj.expirationInMilliSec_ = ((JSONObject) (obj2)).getLong(io.branch.referral.Defines.Jsonkey.ContentExpiryTime.getKey());
            }
            for (obj1 = ((JSONObject) (obj2)).keys(); ((Iterator) (obj1)).hasNext(); ((BranchUniversalObject) (obj)).addContentMetadata(s, ((JSONObject) (obj2)).getString(s)))
            {
                s = (String)((Iterator) (obj1)).next();
            }

            break MISSING_BLOCK_LABEL_324;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception) { }
        return ((BranchUniversalObject) (obj));
        return ((BranchUniversalObject) (obj));
    }

    public BranchUniversalObject addContentMetadata(String s, String s1)
    {
        metadata_.put(s, s1);
        return this;
    }

    public BranchUniversalObject addContentMetadata(HashMap hashmap)
    {
        metadata_.putAll(hashmap);
        return this;
    }

    public BranchUniversalObject addKeyWord(String s)
    {
        keywords_.add(s);
        return this;
    }

    public BranchUniversalObject addKeyWords(ArrayList arraylist)
    {
        keywords_.addAll(arraylist);
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public void generateShortUrl(Context context, LinkProperties linkproperties, io.branch.referral.Branch.BranchLinkCreateListener branchlinkcreatelistener)
    {
        getLinkBuilder(context, linkproperties).generateShortUrl(branchlinkcreatelistener);
    }

    public String getCanonicalIdentifier()
    {
        return canonicalIdentifier_;
    }

    public String getDescription()
    {
        return description_;
    }

    public long getExpirationTime()
    {
        return expirationInMilliSec_;
    }

    public String getImageUrl()
    {
        return imageUrl_;
    }

    public ArrayList getKeywords()
    {
        return keywords_;
    }

    public JSONArray getKeywordsJsonArray()
    {
        JSONArray jsonarray = new JSONArray();
        for (Iterator iterator = keywords_.iterator(); iterator.hasNext(); jsonarray.put((String)iterator.next())) { }
        return jsonarray;
    }

    public HashMap getMetadata()
    {
        return metadata_;
    }

    public String getShortUrl(Context context, LinkProperties linkproperties)
    {
        return getLinkBuilder(context, linkproperties).getShortUrl();
    }

    public String getTitle()
    {
        return title_;
    }

    public String getType()
    {
        return type_;
    }

    public boolean isPublicallyIndexable()
    {
        return indexMode_ == CONTENT_INDEX_MODE.PUBLIC;
    }

    public void registerView()
    {
        registerView(null);
    }

    public void registerView(RegisterViewStatusListener registerviewstatuslistener)
    {
        if (Branch.getInstance() != null)
        {
            Branch.getInstance().registerView(this, registerviewstatuslistener);
        } else
        if (registerviewstatuslistener != null)
        {
            registerviewstatuslistener.onRegisterViewFinished(false, new BranchError("Register view error", -109));
            return;
        }
    }

    public BranchUniversalObject setCanonicalIdentifier(String s)
    {
        canonicalIdentifier_ = s;
        return this;
    }

    public BranchUniversalObject setContentDescription(String s)
    {
        description_ = s;
        return this;
    }

    public BranchUniversalObject setContentExpiration(Date date)
    {
        expirationInMilliSec_ = date.getTime();
        return this;
    }

    public BranchUniversalObject setContentImageUrl(String s)
    {
        imageUrl_ = s;
        return this;
    }

    public BranchUniversalObject setContentIndexingMode(CONTENT_INDEX_MODE content_index_mode)
    {
        indexMode_ = content_index_mode;
        return this;
    }

    public BranchUniversalObject setContentType(String s)
    {
        type_ = s;
        return this;
    }

    public BranchUniversalObject setTitle(String s)
    {
        title_ = s;
        return this;
    }

    public void showShareSheet(Activity activity, LinkProperties linkproperties, ShareSheetStyle sharesheetstyle, io.branch.referral.Branch.BranchLinkShareListener branchlinksharelistener)
    {
        Object obj;
        if (Branch.getInstance() == null)
        {
            if (branchlinksharelistener != null)
            {
                branchlinksharelistener.onLinkShareResponse(null, null, new BranchError("Trouble sharing link. ", -109));
                return;
            } else
            {
                Log.e("BranchSDK", "Sharing error. Branch instance is not created yet. Make sure you have initialised Branch.");
                return;
            }
        }
        obj = new JSONObject();
        String s;
        for (Iterator iterator = metadata_.keySet().iterator(); iterator.hasNext(); ((JSONObject) (obj)).put(s, metadata_.get(s)))
        {
            s = (String)iterator.next();
        }

          goto _L1
_L3:
        activity = (new io.branch.referral.Branch.ShareLinkBuilder(activity, getLinkBuilder(activity, linkproperties))).setCallback(branchlinksharelistener).setSubject(sharesheetstyle.getMessageTitle()).setMessage(sharesheetstyle.getMessageBody());
        if (sharesheetstyle.getCopyUrlIcon() != null)
        {
            activity.setCopyUrlStyle(sharesheetstyle.getCopyUrlIcon(), sharesheetstyle.getCopyURlText(), sharesheetstyle.getUrlCopiedMessage());
        }
        if (sharesheetstyle.getMoreOptionIcon() != null)
        {
            activity.setMoreOptionStyle(sharesheetstyle.getMoreOptionIcon(), sharesheetstyle.getMoreOptionText());
        }
        if (sharesheetstyle.getDefaultURL() != null)
        {
            activity.setDefaultURL(sharesheetstyle.getDefaultURL());
        }
        if (sharesheetstyle.getPreferredOptions().size() > 0)
        {
            activity.addPreferredSharingOptions(sharesheetstyle.getPreferredOptions());
        }
        activity.shareLink();
        return;
_L1:
        try
        {
            HashMap hashmap = linkproperties.getControlParams();
            Iterator iterator1 = hashmap.keySet().iterator();
            while (iterator1.hasNext()) 
            {
                String s1 = (String)iterator1.next();
                ((JSONObject) (obj)).put(s1, hashmap.get(s1));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        if (true) goto _L3; else goto _L2
_L2:
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(canonicalIdentifier_);
        parcel.writeString(title_);
        parcel.writeString(description_);
        parcel.writeString(imageUrl_);
        parcel.writeString(type_);
        parcel.writeLong(expirationInMilliSec_);
        parcel.writeInt(indexMode_.ordinal());
        parcel.writeSerializable(keywords_);
        parcel.writeInt(metadata_.size());
        java.util.Map.Entry entry;
        for (Iterator iterator = metadata_.entrySet().iterator(); iterator.hasNext(); parcel.writeString((String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
            parcel.writeString((String)entry.getKey());
        }

    }

}
