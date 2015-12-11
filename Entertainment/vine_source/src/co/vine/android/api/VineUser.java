// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class VineUser
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineUser createFromParcel(Parcel parcel)
        {
            return new VineUser(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineUser[] newArray(int i)
        {
            return new VineUser[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int FOLLOW_STATUS_APPROVAL_PENDING = 1;
    public static final int FOLLOW_STATUS_REQUESTED = 2;
    public static final int VERIFIED_EMAIL = 1;
    public static final int VERIFIED_PHONE = 2;
    public boolean acceptsOutOfNetworkConversations;
    public int authoredPostCount;
    public String avatarUrl;
    public int blocked;
    public int blocking;
    public String description;
    public boolean disableAddressBook;
    public String edition;
    public String email;
    public int explicit;
    public int followStatus;
    public int followerCount;
    public int following;
    public int followingCount;
    public long friendIndex;
    public boolean hiddenEmail;
    public boolean hiddenPhoneNumber;
    public long id;
    public int includePromoted;
    public int likeCount;
    public String location;
    public long loopCount;
    public long orderId;
    public String phoneNumber;
    public int postCount;
    public int privateAccount;
    public int profileBackground;
    public int repostsEnabled;
    public int sectionId;
    public String sectionTitle;
    public int twitterConnected;
    public long userId;
    public String username;
    public int verified;
    public int verifiedInformation;

    public VineUser()
    {
    }

    public VineUser(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        username = parcel.readString();
        avatarUrl = parcel.readString();
        description = parcel.readString();
        location = parcel.readString();
        email = parcel.readString();
        phoneNumber = parcel.readString();
        userId = parcel.readLong();
        orderId = parcel.readLong();
        blocked = parcel.readInt();
        blocking = parcel.readInt();
        explicit = parcel.readInt();
        followerCount = parcel.readInt();
        followingCount = parcel.readInt();
        following = parcel.readInt();
        likeCount = parcel.readInt();
        postCount = parcel.readInt();
        verified = parcel.readInt();
        twitterConnected = parcel.readInt();
        includePromoted = parcel.readInt();
        privateAccount = parcel.readInt();
        followStatus = parcel.readInt();
        repostsEnabled = parcel.readInt();
        edition = parcel.readString();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        acceptsOutOfNetworkConversations = flag;
        profileBackground = parcel.readInt();
        authoredPostCount = parcel.readInt();
        verifiedInformation = parcel.readInt();
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        disableAddressBook = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hiddenEmail = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        hiddenPhoneNumber = flag;
        loopCount = parcel.readLong();
    }

    public VineUser(String s, String s1, String s2, String s3, long l, long l1, int i, int j, int k, int i1, int j1, int k1, 
            int i2, int j2, int k2, String s4, String s5, int l2, int i3, 
            int j3, int k3, String s6, boolean flag, int l3, int i4, String s7, 
            boolean flag1, boolean flag2, boolean flag3, long l4)
    {
        String s8;
        s8 = s;
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        if (TextUtils.isEmpty(s5)) goto _L4; else goto _L3
_L3:
        s8 = s5;
_L2:
        username = s8;
        avatarUrl = s1;
        description = s2;
        location = s3;
        userId = l;
        orderId = l1;
        blocked = i;
        blocking = j;
        explicit = k;
        followerCount = i1;
        followingCount = j1;
        following = k1;
        likeCount = i2;
        postCount = j2;
        verified = k2;
        email = s4;
        phoneNumber = s5;
        twitterConnected = l2;
        includePromoted = i3;
        privateAccount = j3;
        repostsEnabled = k3;
        edition = s6;
        acceptsOutOfNetworkConversations = flag;
        profileBackground = l3;
        authoredPostCount = i4;
        sectionTitle = s7;
        disableAddressBook = flag1;
        hiddenEmail = flag2;
        hiddenPhoneNumber = flag3;
        loopCount = l4;
        return;
_L4:
        s8 = s;
        if (!TextUtils.isEmpty(s4))
        {
            s8 = s4;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public boolean acceptsOutOfNetworkConversations()
    {
        return acceptsOutOfNetworkConversations;
    }

    public boolean areRepostsEnabled()
    {
        return repostsEnabled == 1;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (VineUser)obj;
            if (blocked != ((VineUser) (obj)).blocked)
            {
                return false;
            }
            if (blocking != ((VineUser) (obj)).blocking)
            {
                return false;
            }
            if (explicit != ((VineUser) (obj)).explicit)
            {
                return false;
            }
            if (followerCount != ((VineUser) (obj)).followerCount)
            {
                return false;
            }
            if (following != ((VineUser) (obj)).following)
            {
                return false;
            }
            if (followingCount != ((VineUser) (obj)).followingCount)
            {
                return false;
            }
            if (likeCount != ((VineUser) (obj)).likeCount)
            {
                return false;
            }
            if (orderId != ((VineUser) (obj)).orderId)
            {
                return false;
            }
            if (postCount != ((VineUser) (obj)).postCount)
            {
                return false;
            }
            if (twitterConnected != ((VineUser) (obj)).twitterConnected)
            {
                return false;
            }
            if (includePromoted != ((VineUser) (obj)).includePromoted)
            {
                return false;
            }
            if (userId != ((VineUser) (obj)).userId)
            {
                return false;
            }
            if (verified != ((VineUser) (obj)).verified)
            {
                return false;
            }
            if (privateAccount != ((VineUser) (obj)).privateAccount)
            {
                return false;
            }
            if (followStatus != ((VineUser) (obj)).followStatus)
            {
                return false;
            }
            if (avatarUrl == null ? ((VineUser) (obj)).avatarUrl != null : !avatarUrl.equals(((VineUser) (obj)).avatarUrl))
            {
                return false;
            }
            if (description == null ? ((VineUser) (obj)).description != null : !description.equals(((VineUser) (obj)).description))
            {
                return false;
            }
            if (email == null ? ((VineUser) (obj)).email != null : !email.equals(((VineUser) (obj)).email))
            {
                return false;
            }
            if (location == null ? ((VineUser) (obj)).location != null : !location.equals(((VineUser) (obj)).location))
            {
                return false;
            }
            if (phoneNumber == null ? ((VineUser) (obj)).phoneNumber != null : !phoneNumber.equals(((VineUser) (obj)).phoneNumber))
            {
                return false;
            }
            if (username == null ? ((VineUser) (obj)).username != null : !username.equals(((VineUser) (obj)).username))
            {
                return false;
            }
            if (repostsEnabled != ((VineUser) (obj)).repostsEnabled)
            {
                return false;
            }
            if (edition == null ? ((VineUser) (obj)).edition != null : !edition.equals(((VineUser) (obj)).edition))
            {
                return false;
            }
            if (acceptsOutOfNetworkConversations != ((VineUser) (obj)).acceptsOutOfNetworkConversations)
            {
                return false;
            }
            if (profileBackground != ((VineUser) (obj)).profileBackground)
            {
                return false;
            }
            if (authoredPostCount != ((VineUser) (obj)).authoredPostCount)
            {
                return false;
            }
            if (verifiedInformation != ((VineUser) (obj)).verifiedInformation)
            {
                return false;
            }
            if (disableAddressBook != ((VineUser) (obj)).disableAddressBook)
            {
                return false;
            }
            if (hiddenEmail != ((VineUser) (obj)).hiddenEmail)
            {
                return false;
            }
            if (hiddenPhoneNumber != ((VineUser) (obj)).hiddenPhoneNumber)
            {
                return false;
            }
            if (loopCount != ((VineUser) (obj)).loopCount)
            {
                return false;
            }
        }
        return true;
    }

    public int getProfileBackgroundForShowing()
    {
        return profileBackground | 0xff000000;
    }

    public boolean hasFollowApprovalPending()
    {
        return (followStatus & 1) != 0;
    }

    public boolean hasFollowRequested()
    {
        return (followStatus & 2) != 0;
    }

    public int hashCode()
    {
        int l1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        int j5;
        int k5;
        int l5;
        int i6;
        if (username != null)
        {
            i = username.hashCode();
        } else
        {
            i = 0;
        }
        if (edition != null)
        {
            j = edition.hashCode();
        } else
        {
            j = 0;
        }
        if (avatarUrl != null)
        {
            k = avatarUrl.hashCode();
        } else
        {
            k = 0;
        }
        if (description != null)
        {
            l = description.hashCode();
        } else
        {
            l = 0;
        }
        if (location != null)
        {
            i1 = location.hashCode();
        } else
        {
            i1 = 0;
        }
        if (phoneNumber != null)
        {
            j1 = phoneNumber.hashCode();
        } else
        {
            j1 = 0;
        }
        if (email != null)
        {
            k1 = email.hashCode();
        } else
        {
            k1 = 0;
        }
        i2 = (int)(userId ^ userId >>> 32);
        j2 = (int)(orderId ^ orderId >>> 32);
        k2 = (int)(loopCount ^ loopCount >>> 32);
        l2 = blocked;
        i3 = blocking;
        j3 = explicit;
        k3 = followerCount;
        l3 = followingCount;
        i4 = following;
        j4 = likeCount;
        k4 = postCount;
        l4 = verified;
        i5 = twitterConnected;
        j5 = includePromoted;
        k5 = privateAccount;
        l5 = followStatus;
        i6 = repostsEnabled;
        if (acceptsOutOfNetworkConversations)
        {
            l1 = 1;
        }
        return (((((((((((((((((((((((((i * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + i2) * 31 + j2) * 31 + k2) * 31 + l2) * 31 + i3) * 31 + j3) * 31 + k3) * 31 + l3) * 31 + i4) * 31 + j4) * 31 + k4) * 31 + l4) * 31 + i5) * 31 + j5) * 31 + k5) * 31 + l5) * 31 + i6) * 31 + l1) * 31 + profileBackground) * 31 + verifiedInformation;
    }

    public boolean isBlocked()
    {
        return blocked == 1;
    }

    public boolean isEmailVerified()
    {
        return (verifiedInformation & 1) != 0;
    }

    public boolean isFollowing()
    {
        return following == 1;
    }

    public boolean isPhoneVerified()
    {
        return (verifiedInformation & 2) != 0;
    }

    public boolean isPrivate()
    {
        return privateAccount == 1;
    }

    public boolean isPrivateLocked()
    {
        return isPrivate() && (!isFollowing() || hasFollowRequested());
    }

    public boolean isVerified()
    {
        return verified == 1;
    }

    public void setApprovalPending()
    {
        followStatus = followStatus | 1;
    }

    public void setEmailVerified()
    {
        verifiedInformation = verifiedInformation | 1;
    }

    public void setFollowRequested()
    {
        followStatus = followStatus | 2;
    }

    public void setPhoneVerified()
    {
        verifiedInformation = verifiedInformation | 2;
    }

    public void unsetEmailVerified()
    {
        verifiedInformation = verifiedInformation & -2;
    }

    public void unsetPhoneVerified()
    {
        verifiedInformation = verifiedInformation & -3;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(username);
        parcel.writeString(avatarUrl);
        parcel.writeString(description);
        parcel.writeString(location);
        parcel.writeString(email);
        parcel.writeString(phoneNumber);
        parcel.writeLong(userId);
        parcel.writeLong(orderId);
        parcel.writeInt(blocked);
        parcel.writeInt(blocking);
        parcel.writeInt(explicit);
        parcel.writeInt(followerCount);
        parcel.writeInt(followingCount);
        parcel.writeInt(following);
        parcel.writeInt(likeCount);
        parcel.writeInt(postCount);
        parcel.writeInt(verified);
        parcel.writeInt(twitterConnected);
        parcel.writeInt(includePromoted);
        parcel.writeInt(privateAccount);
        parcel.writeInt(followStatus);
        parcel.writeInt(repostsEnabled);
        parcel.writeString(edition);
        if (acceptsOutOfNetworkConversations)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(profileBackground);
        parcel.writeInt(authoredPostCount);
        parcel.writeInt(verifiedInformation);
        if (disableAddressBook)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (hiddenEmail)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (hiddenPhoneNumber)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeLong(loopCount);
    }

}
