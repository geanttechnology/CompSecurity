// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.c;
import com.socialin.android.util.b;
import com.socialin.gson.Gson;

// Referenced classes of package com.socialin.android.apiv3.model:
//            ViewerUser, Adress, Settings

public class User extends ViewerUser
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final User createFromParcel(Parcel parcel)
        {
            return new User(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final User[] newArray(int i)
        {
            return new User[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final User emptyUser;
    public UserConnections connections;
    public String email;
    public String key;
    public boolean mature;
    private boolean notificationComment;
    private boolean notificationFacebook;
    private boolean notificationFollow;
    private boolean notificationFollowMe;
    private boolean notificationFriendLike;
    private boolean notificationLike;
    private boolean notificationMention;
    private boolean notificationPublish;
    private boolean notificationRepost;
    private boolean notificationTwitter;
    private boolean notificationUserRepost;
    public String provider;
    public boolean registered;
    public boolean usernameChanged;

    public User()
    {
        usernameChanged = false;
    }

    public User(Parcel parcel)
    {
        usernameChanged = false;
        readFromParcel(parcel);
    }

    private void readFromParcel(Parcel parcel)
    {
        key = parcel.readString();
        id = parcel.readLong();
        name = parcel.readString();
        username = parcel.readString();
        setPhoto(parcel.readString());
        cover = parcel.readString();
        profileStatus = parcel.readString();
        email = parcel.readString();
        provider = parcel.readString();
        registered = Boolean.valueOf(parcel.readString()).booleanValue();
        followingsCount = parcel.readInt();
        followersCount = parcel.readInt();
        photosCount = parcel.readInt();
        streamsCount = parcel.readInt();
        if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
        {
            b.a(SocialinV3.getInstance().getContext()).a("# of Friends Following User", followersCount);
        }
        String s;
        boolean flag;
        try
        {
            s = parcel.readString();
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            parcel.printStackTrace();
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        if (!s.equals(""))
        {
            address = (Adress)c.a().fromJson(s, com/socialin/android/apiv3/model/Adress);
        }
        s = parcel.readString();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        if (!s.equals(""))
        {
            connections = (UserConnections)c.a().fromJson(s, com/socialin/android/apiv3/model/User$UserConnections);
        }
        balance = parcel.readInt();
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isOwnerFollowing = flag;
        parcel = parcel.readString();
        if (parcel == null)
        {
            break MISSING_BLOCK_LABEL_268;
        }
        if (!parcel.equals(""))
        {
            usernameChanged = Boolean.valueOf(parcel).booleanValue();
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public String getProvider()
    {
        return provider;
    }

    public boolean isNotificationComment()
    {
        return notificationComment;
    }

    public boolean isNotificationFacebook()
    {
        return notificationFacebook;
    }

    public boolean isNotificationFollow()
    {
        return notificationFollow;
    }

    public boolean isNotificationFollowMe()
    {
        return notificationFollowMe;
    }

    public boolean isNotificationFriendLike()
    {
        return notificationFriendLike;
    }

    public boolean isNotificationLike()
    {
        return notificationLike;
    }

    public boolean isNotificationMention()
    {
        return notificationMention;
    }

    public boolean isNotificationPublish()
    {
        return notificationPublish;
    }

    public boolean isNotificationRepost()
    {
        return notificationRepost;
    }

    public boolean isNotificationTwitter()
    {
        return notificationTwitter;
    }

    public boolean isNotificationUserRepost()
    {
        return notificationUserRepost;
    }

    public boolean isRegistered()
    {
        return registered;
    }

    public void setProvider(String s)
    {
        provider = s;
    }

    public void setRegistered(boolean flag)
    {
        registered = flag;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(key);
        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeString(username);
        parcel.writeString(getPhoto());
        parcel.writeString(cover);
        parcel.writeString(profileStatus);
        parcel.writeString(email);
        parcel.writeString(provider);
        parcel.writeString(String.valueOf(registered));
        parcel.writeInt(followingsCount);
        parcel.writeInt(followersCount);
        parcel.writeInt(photosCount);
        parcel.writeInt(streamsCount);
        String s;
        if (address != null)
        {
            s = c.a().toJson(address);
        } else
        {
            s = "";
        }
        parcel.writeString(s);
        if (connections != null)
        {
            s = c.a().toJson(connections);
        } else
        {
            s = "";
        }
        parcel.writeString(s);
        parcel.writeInt(balance);
        if (isOwnerFollowing)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(String.valueOf(usernameChanged));
    }

    static 
    {
        User user = new User();
        emptyUser = user;
        user.key = "";
        emptyUser.address = new Adress();
        emptyUser.email = "";
        emptyUser.id = 1L;
        emptyUser.message = "empty user";
        emptyUser.name = "empty user";
        emptyUser.setPhoto("");
        emptyUser.provider = "";
        emptyUser.registered = false;
        emptyUser.status = "empty user";
        emptyUser.username = "emptyuser";
        emptyUser.connections = new UserConnections();
    }

    private class UserConnections
    {

        private static final FbConnection emptyFbConnection = new FbConnection();
        private static final InstagramConnection emptyInstagramConnection = new InstagramConnection();
        private static final TwitterConnection emptyTwitterConnection = new TwitterConnection();
        private FbConnection fbConnection;
        private InstagramConnection instagramConnection;
        private TwitterConnection twitterConnection;

        public void connectToFb(FbConnection fbconnection)
        {
            if (fbconnection == null)
            {
                fbConnection = emptyFbConnection;
                return;
            } else
            {
                fbConnection = fbconnection;
                return;
            }
        }

        public void connectToInstagram(InstagramConnection instagramconnection)
        {
            if (instagramconnection == null)
            {
                instagramConnection = emptyInstagramConnection;
                return;
            } else
            {
                instagramConnection = instagramconnection;
                return;
            }
        }

        public void connectToTwitter(TwitterConnection twitterconnection)
        {
            if (twitterconnection == null)
            {
                twitterConnection = emptyTwitterConnection;
                return;
            } else
            {
                twitterConnection = twitterconnection;
                return;
            }
        }

        public void disconnectFb()
        {
            fbConnection = emptyFbConnection;
        }

        public void disconnectInstagram()
        {
            instagramConnection = emptyInstagramConnection;
        }

        public void disconnectTwitter()
        {
            twitterConnection = emptyTwitterConnection;
        }

        public FbConnection getFbConnection()
        {
            return fbConnection;
        }

        public InstagramConnection getInstagramConnection()
        {
            if (instagramConnection == null)
            {
                return emptyInstagramConnection;
            } else
            {
                return instagramConnection;
            }
        }

        public TwitterConnection getTwitterConnection()
        {
            if (twitterConnection == null)
            {
                return emptyTwitterConnection;
            } else
            {
                return twitterConnection;
            }
        }

        public boolean isEmptyFb()
        {
            return fbConnection == null || fbConnection == emptyFbConnection || TextUtils.isEmpty(fbConnection.token);
        }

        public boolean isEmptyInstagram()
        {
            return instagramConnection == null || instagramConnection == emptyInstagramConnection || TextUtils.isEmpty(instagramConnection.token);
        }

        public boolean isEmptyTwitter()
        {
            return twitterConnection == null || twitterConnection == emptyTwitterConnection;
        }


        public UserConnections()
        {
        }
    }

}
