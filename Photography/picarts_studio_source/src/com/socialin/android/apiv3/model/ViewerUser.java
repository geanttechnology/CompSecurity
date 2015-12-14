// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.card.CardData;
import com.socialin.android.c;
import com.socialin.android.util.b;
import com.socialin.gson.Gson;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.apiv3.model:
//            Response, Settings, Adress

public class ViewerUser extends Response
    implements Parcelable, CardData
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final ViewerUser createFromParcel(Parcel parcel)
        {
            return new ViewerUser(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final ViewerUser[] newArray(int i)
        {
            return new ViewerUser[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String EMPTY_AVATAR = " ";
    public static final String EMPTY_STATUS = " ";
    public Adress address;
    public int balance;
    public String cover;
    public int designsCount;
    public String fbId;
    public int followersCount;
    public int followingsCount;
    public long id;
    public boolean isBlocked;
    public boolean isOwnerFollowing;
    public boolean isValidated;
    public String name;
    public String photo;
    public ArrayList photos;
    public int photosCount;
    private final String prefixThumb;
    public String profileStatus;
    public int streamsCount;
    public int tagsCount;
    public String username;

    public ViewerUser()
    {
        prefixThumb = "?c120x120";
        id = -1L;
        isValidated = false;
        fbId = "";
        name = "";
        username = "";
        photo = "";
        cover = "";
        profileStatus = "";
        isOwnerFollowing = false;
        isBlocked = false;
    }

    public ViewerUser(Parcel parcel)
    {
        prefixThumb = "?c120x120";
        id = -1L;
        isValidated = false;
        fbId = "";
        name = "";
        username = "";
        photo = "";
        cover = "";
        profileStatus = "";
        isOwnerFollowing = false;
        isBlocked = false;
        readFromParcel(parcel);
    }

    private void readFromParcel(Parcel parcel)
    {
        id = parcel.readLong();
        name = parcel.readString();
        username = parcel.readString();
        photo = parcel.readString();
        cover = parcel.readString();
        profileStatus = parcel.readString();
        followingsCount = parcel.readInt();
        followersCount = parcel.readInt();
        photosCount = parcel.readInt();
        streamsCount = parcel.readInt();
        designsCount = parcel.readInt();
        if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
        {
            b.a(SocialinV3.getInstance().getContext()).a("# of Friends Following User", followersCount);
        }
        String s;
        fbId = parcel.readString();
        s = parcel.readString();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        if (!s.equals(""))
        {
            address = (Adress)c.a().fromJson(s, com/socialin/android/apiv3/model/Adress);
        }
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isOwnerFollowing = flag;
        profileStatus = parcel.readString();
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            isValidated = flag;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            parcel.printStackTrace();
        }
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getDesignsCount()
    {
        return designsCount;
    }

    public int getFollowersCount()
    {
        if (followersCount < 0)
        {
            return 0;
        } else
        {
            return followersCount;
        }
    }

    public int getFollowingsCount()
    {
        if (followingsCount < 0)
        {
            return 0;
        } else
        {
            return followingsCount;
        }
    }

    public String getPhoto()
    {
        if (photo != null && !photo.equals(""))
        {
            if (!photo.contains("picsart.com") || photo.contains("?c120x120"))
            {
                return photo;
            } else
            {
                return (new StringBuilder()).append(photo).append("?c120x120").toString();
            }
        } else
        {
            return "";
        }
    }

    public String getPhotoSmall()
    {
        if (photo != null && !photo.equals(""))
        {
            if (!photo.contains("picsart.com") || photo.contains("?r240x240") || photo.contains("?c120x120"))
            {
                return photo;
            } else
            {
                return (new StringBuilder()).append(photo).append("?r240x240").toString();
            }
        } else
        {
            return "";
        }
    }

    public int getPhotosCount()
    {
        if (photosCount < 0)
        {
            return 0;
        } else
        {
            return photosCount;
        }
    }

    public int getStreamsCount()
    {
        if (streamsCount < 0)
        {
            return 0;
        } else
        {
            return streamsCount;
        }
    }

    public void setPhoto(String s)
    {
        photo = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeLong(id);
        String s;
        if (name == null)
        {
            s = "";
        } else
        {
            s = name;
        }
        parcel.writeString(s);
        if (username == null)
        {
            s = "";
        } else
        {
            s = username;
        }
        parcel.writeString(s);
        if (photo == null)
        {
            s = "";
        } else
        {
            s = photo;
        }
        parcel.writeString(s);
        if (cover == null)
        {
            s = "";
        } else
        {
            s = cover;
        }
        parcel.writeString(s);
        if (profileStatus == null)
        {
            s = "";
        } else
        {
            s = profileStatus;
        }
        parcel.writeString(s);
        parcel.writeInt(followingsCount);
        parcel.writeInt(followersCount);
        parcel.writeInt(photosCount);
        parcel.writeInt(streamsCount);
        parcel.writeInt(designsCount);
        parcel.writeString(fbId);
        if (address != null)
        {
            s = c.a().toJson(address);
        } else
        {
            s = "";
        }
        parcel.writeString(s);
        if (isOwnerFollowing)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (profileStatus == null)
        {
            s = "";
        } else
        {
            s = profileStatus;
        }
        parcel.writeString(s);
        if (isValidated)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

}
