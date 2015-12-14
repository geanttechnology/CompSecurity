// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.socialin.android.c;
import com.socialin.gson.Gson;
import java.util.ArrayList;
import java.util.Date;

// Referenced classes of package com.socialin.android.apiv3.model:
//            ImageItem, ViewerUser

public class ContestItem
    implements Parcelable
{

    public static final String CATEGORY_EDITOR = "editor";
    public static final String CATEGORY_TRENDING = "trending";
    public static final String CATEGORY_WINNER = "winner";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final ContestItem createFromParcel(Parcel parcel)
        {
            return new ContestItem(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final ContestItem[] newArray(int i)
        {
            return new ContestItem[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String STATUS_ACCEPTED = "accepted";
    public static final String STATUS_REJECTED = "rejected";
    public static final String STATUS_UNDER_MODERATION = "reviewing";
    public ArrayList categories;
    public Date createdAt;
    public ImageItem photo;
    public int placePos;
    public String rejectReason;
    public String status;
    public ViewerUser user;
    public int voteCount;
    public boolean voted;
    private boolean voting;

    public ContestItem(Parcel parcel)
    {
        placePos = -1;
        status = "reviewing";
        readFromParcel(parcel);
    }

    public ContestItem(ContestItem contestitem)
    {
        placePos = -1;
        status = "reviewing";
        photo = contestitem.photo;
        user = contestitem.user;
        voteCount = contestitem.voteCount;
        voted = contestitem.voted;
        placePos = contestitem.placePos;
        status = contestitem.status;
        rejectReason = contestitem.rejectReason;
        createdAt = contestitem.createdAt;
        categories = contestitem.categories;
    }

    private void readFromParcel(Parcel parcel)
    {
        photo = (ImageItem)parcel.readParcelable(com/socialin/android/apiv3/model/ImageItem.getClassLoader());
        user = (ViewerUser)parcel.readParcelable(com/socialin/android/apiv3/model/ViewerUser.getClassLoader());
        voteCount = parcel.readInt();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            voted = flag;
            placePos = parcel.readInt();
            status = parcel.readString();
            rejectReason = parcel.readString();
            photo.user = user;
            parcel = parcel.readString();
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            parcel.printStackTrace();
            return;
        }
        if (parcel == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        if (!parcel.equals(""))
        {
            createdAt = (Date)c.a().fromJson(parcel, java/util/Date);
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean isEditor()
    {
        if (categories != null && !categories.isEmpty())
        {
            String s = (String)categories.get(0);
            if (!TextUtils.isEmpty(s) && s.equals("editor"))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isVoting()
    {
        return voting;
    }

    public void setVoting(boolean flag)
    {
        voting = flag;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(photo, i);
        parcel.writeParcelable(user, i);
        parcel.writeInt(voteCount);
        String s;
        if (voted)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(placePos);
        if (status == null)
        {
            s = "";
        } else
        {
            s = status;
        }
        parcel.writeString(s);
        if (rejectReason == null)
        {
            s = "";
        } else
        {
            s = rejectReason;
        }
        parcel.writeString(s);
        if (createdAt == null)
        {
            s = "";
        } else
        {
            s = c.a().toJson(createdAt);
        }
        parcel.writeString(s);
    }

}
