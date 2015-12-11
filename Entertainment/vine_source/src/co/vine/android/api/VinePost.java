// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import co.vine.android.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android.api:
//            VinePagedData, VineUser, VineVenue, VineRepost, 
//            VineTag

public class VinePost
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VinePost createFromParcel(Parcel parcel)
        {
            return new VinePost(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VinePost[] newArray(int i)
        {
            return new VinePost[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int FLAG_EXPLICIT = 4;
    public static final int FLAG_LIKED = 8;
    public static final int FLAG_POST_VERIFIED = 32;
    public static final int FLAG_PRIVATE = 64;
    public static final int FLAG_PROMOTED = 2;
    public static final int FLAG_REVINED = 16;
    public static final int FLAG_VERIFIED = 1;
    public String avatarUrl;
    public VinePagedData comments;
    public int commentsCount;
    public long created;
    public String description;
    public SpannableStringBuilder descriptionSb;
    public ArrayList entities;
    public String foursquareVenueId;
    public boolean isLast;
    public long lastRefresh;
    public VinePagedData likes;
    public int likesCount;
    public String location;
    public long loops;
    public int metadataFlags;
    public long myRepostId;
    public boolean onFire;
    public String orderId;
    public int postFlags;
    public long postId;
    public VineRepost repost;
    public int revinersCount;
    public String shareUrl;
    public SpannableStringBuilder sharedVmSb;
    public String tag;
    public ArrayList tags;
    public String thumbnailUrl;
    public ArrayList transientEntities;
    public VineUser user;
    public int userBackgroundColor;
    public long userId;
    public String username;
    public double velocity;
    public VineVenue venueData;
    public String videoLowURL;
    public String videoUrl;
    public String videoWebmURL;

    public VinePost()
    {
    }

    public VinePost(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        ClassLoader classloader = getClass().getClassLoader();
        created = parcel.readLong();
        metadataFlags = parcel.readInt();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isLast = flag;
        postFlags = parcel.readInt();
        likesCount = parcel.readInt();
        revinersCount = parcel.readInt();
        commentsCount = parcel.readInt();
        userId = parcel.readLong();
        postId = parcel.readLong();
        myRepostId = parcel.readLong();
        orderId = parcel.readString();
        tag = parcel.readString();
        foursquareVenueId = parcel.readString();
        description = parcel.readString();
        avatarUrl = parcel.readString();
        location = parcel.readString();
        videoLowURL = parcel.readString();
        videoUrl = parcel.readString();
        username = parcel.readString();
        shareUrl = parcel.readString();
        thumbnailUrl = parcel.readString();
        comments = (VinePagedData)parcel.readParcelable(classloader);
        likes = (VinePagedData)parcel.readParcelable(classloader);
        user = (VineUser)parcel.readParcelable(classloader);
        venueData = (VineVenue)parcel.readSerializable();
        entities = (ArrayList)parcel.readSerializable();
        repost = (VineRepost)parcel.readSerializable();
        userBackgroundColor = parcel.readInt();
        loops = parcel.readLong();
        velocity = parcel.readLong();
        lastRefresh = parcel.readLong();
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        onFire = flag;
    }

    public static VinePost from(Cursor cursor)
    {
        boolean flag1 = true;
        VinePost vinepost = new VinePost();
        vinepost.postId = cursor.getLong(1);
        vinepost.orderId = cursor.getString(49);
        vinepost.tag = cursor.getString(13);
        vinepost.myRepostId = cursor.getLong(2);
        vinepost.shareUrl = cursor.getString(5);
        vinepost.videoUrl = cursor.getString(7);
        vinepost.videoLowURL = cursor.getString(6);
        vinepost.description = cursor.getString(8);
        vinepost.foursquareVenueId = cursor.getString(9);
        vinepost.metadataFlags = cursor.getInt(10);
        boolean flag;
        if (cursor.getInt(14) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        vinepost.isLast = flag;
        vinepost.postFlags = cursor.getInt(11);
        vinepost.likesCount = cursor.getInt(24);
        vinepost.revinersCount = cursor.getInt(25);
        vinepost.commentsCount = cursor.getInt(26);
        vinepost.userId = cursor.getLong(16);
        vinepost.created = cursor.getLong(17);
        vinepost.avatarUrl = cursor.getString(15);
        vinepost.location = cursor.getString(18);
        vinepost.username = cursor.getString(19);
        vinepost.thumbnailUrl = cursor.getString(4);
        vinepost.userBackgroundColor = cursor.getInt(44);
        vinepost.comments = new VinePagedData();
        vinepost.likes = new VinePagedData();
        vinepost.venueData = (VineVenue)Util.fromByteArray(cursor.getBlob(20));
        vinepost.entities = (ArrayList)Util.fromByteArray(cursor.getBlob(21));
        vinepost.repost = (VineRepost)Util.fromByteArray(cursor.getBlob(22));
        vinepost.loops = cursor.getLong(45);
        vinepost.velocity = cursor.getLong(46);
        vinepost.lastRefresh = cursor.getLong(48);
        if (cursor.getInt(47) == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        vinepost.onFire = flag;
        return vinepost;
    }

    public static VinePost fromExplore(Cursor cursor)
    {
        boolean flag1 = true;
        VinePost vinepost = new VinePost();
        vinepost.postId = cursor.getLong(1);
        vinepost.orderId = cursor.getString(32);
        vinepost.tag = cursor.getString(13);
        vinepost.myRepostId = cursor.getLong(2);
        vinepost.shareUrl = cursor.getString(5);
        vinepost.videoUrl = cursor.getString(7);
        vinepost.videoLowURL = cursor.getString(6);
        vinepost.description = cursor.getString(8);
        vinepost.foursquareVenueId = cursor.getString(9);
        vinepost.metadataFlags = cursor.getInt(10);
        boolean flag;
        if (cursor.getInt(14) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        vinepost.isLast = flag;
        vinepost.postFlags = cursor.getInt(11);
        vinepost.likesCount = cursor.getInt(24);
        vinepost.revinersCount = cursor.getInt(25);
        vinepost.commentsCount = cursor.getInt(26);
        vinepost.userId = cursor.getLong(16);
        vinepost.created = cursor.getLong(17);
        vinepost.avatarUrl = cursor.getString(15);
        vinepost.location = cursor.getString(18);
        vinepost.username = cursor.getString(19);
        vinepost.thumbnailUrl = cursor.getString(4);
        vinepost.comments = new VinePagedData();
        vinepost.likes = new VinePagedData();
        vinepost.venueData = (VineVenue)Util.fromByteArray(cursor.getBlob(20));
        vinepost.entities = (ArrayList)Util.fromByteArray(cursor.getBlob(21));
        vinepost.repost = (VineRepost)Util.fromByteArray(cursor.getBlob(22));
        vinepost.userBackgroundColor = cursor.getInt(27);
        vinepost.loops = cursor.getLong(28);
        vinepost.velocity = cursor.getLong(29);
        vinepost.lastRefresh = cursor.getLong(31);
        if (cursor.getInt(30) == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        vinepost.onFire = flag;
        return vinepost;
    }

    public static byte[] getBytesFromTags(VinePost vinepost)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ObjectOutputStream objectoutputstream = new ObjectOutputStream(bytearrayoutputstream);
        if (vinepost.tags != null)
        {
            VineTag vinetag;
            for (vinepost = vinepost.tags.iterator(); vinepost.hasNext(); objectoutputstream.writeObject(vinetag.tagName))
            {
                vinetag = (VineTag)vinepost.next();
                objectoutputstream.writeLong(vinetag.tagId);
            }

        }
        objectoutputstream.flush();
        objectoutputstream.close();
        bytearrayoutputstream.close();
        return bytearrayoutputstream.toByteArray();
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
            obj = (VinePost)obj;
            if (postId != ((VinePost) (obj)).postId)
            {
                return false;
            }
            if (myRepostId != ((VinePost) (obj)).myRepostId)
            {
                return false;
            }
            if (commentsCount != ((VinePost) (obj)).commentsCount)
            {
                return false;
            }
            if (created != ((VinePost) (obj)).created)
            {
                return false;
            }
            if (metadataFlags != ((VinePost) (obj)).metadataFlags)
            {
                return false;
            }
            if (isLast != ((VinePost) (obj)).isLast)
            {
                return false;
            }
            if (likesCount != ((VinePost) (obj)).likesCount)
            {
                return false;
            }
            if (revinersCount != ((VinePost) (obj)).revinersCount)
            {
                return false;
            }
            if (postFlags != ((VinePost) (obj)).postFlags)
            {
                return false;
            }
            if (userId != ((VinePost) (obj)).userId)
            {
                return false;
            }
            if (avatarUrl == null ? ((VinePost) (obj)).avatarUrl != null : !avatarUrl.equals(((VinePost) (obj)).avatarUrl))
            {
                return false;
            }
            if (comments == null ? ((VinePost) (obj)).comments != null : !comments.equals(((VinePost) (obj)).comments))
            {
                return false;
            }
            if (description == null ? ((VinePost) (obj)).description != null : !description.equals(((VinePost) (obj)).description))
            {
                return false;
            }
            if (entities == null ? ((VinePost) (obj)).entities != null : !entities.equals(((VinePost) (obj)).entities))
            {
                return false;
            }
            if (foursquareVenueId == null ? ((VinePost) (obj)).foursquareVenueId != null : !foursquareVenueId.equals(((VinePost) (obj)).foursquareVenueId))
            {
                return false;
            }
            if (likes == null ? ((VinePost) (obj)).likes != null : !likes.equals(((VinePost) (obj)).likes))
            {
                return false;
            }
            if (location == null ? ((VinePost) (obj)).location != null : !location.equals(((VinePost) (obj)).location))
            {
                return false;
            }
            if (orderId == null ? ((VinePost) (obj)).orderId != null : !orderId.equals(((VinePost) (obj)).orderId))
            {
                return false;
            }
            if (tag == null ? ((VinePost) (obj)).tag != null : !tag.equals(((VinePost) (obj)).tag))
            {
                return false;
            }
            if (shareUrl == null ? ((VinePost) (obj)).shareUrl != null : !shareUrl.equals(((VinePost) (obj)).shareUrl))
            {
                return false;
            }
            if (tags == null ? ((VinePost) (obj)).tags != null : !tags.equals(((VinePost) (obj)).tags))
            {
                return false;
            }
            if (thumbnailUrl == null ? ((VinePost) (obj)).thumbnailUrl != null : !thumbnailUrl.equals(((VinePost) (obj)).thumbnailUrl))
            {
                return false;
            }
            if (user == null ? ((VinePost) (obj)).user != null : !user.equals(((VinePost) (obj)).user))
            {
                return false;
            }
            if (username == null ? ((VinePost) (obj)).username != null : !username.equals(((VinePost) (obj)).username))
            {
                return false;
            }
            if (venueData == null ? ((VinePost) (obj)).venueData != null : !venueData.equals(((VinePost) (obj)).venueData))
            {
                return false;
            }
            if (videoLowURL == null ? ((VinePost) (obj)).videoLowURL != null : !videoLowURL.equals(((VinePost) (obj)).videoLowURL))
            {
                return false;
            }
            if (videoUrl == null ? ((VinePost) (obj)).videoUrl != null : !videoUrl.equals(((VinePost) (obj)).videoUrl))
            {
                return false;
            }
            if (repost == null ? ((VinePost) (obj)).repost != null : !repost.equals(((VinePost) (obj)).repost))
            {
                return false;
            }
            if (userBackgroundColor != ((VinePost) (obj)).userBackgroundColor)
            {
                return false;
            }
            if (loops != ((VinePost) (obj)).loops)
            {
                return false;
            }
            if (velocity != ((VinePost) (obj)).velocity)
            {
                return false;
            }
            if (lastRefresh != ((VinePost) (obj)).lastRefresh)
            {
                return false;
            }
            if (onFire != ((VinePost) (obj)).onFire)
            {
                return false;
            }
        }
        return true;
    }

    public String getVideoHighUrl()
    {
        if (videoUrl == null)
        {
            return videoWebmURL;
        } else
        {
            return videoUrl;
        }
    }

    public int hashCode()
    {
        int l4 = 1;
        int i5 = (int)(created ^ created >>> 32);
        int j5 = metadataFlags;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
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
        int k5;
        int l5;
        int i6;
        int j6;
        int k6;
        int l6;
        int i7;
        int j7;
        int k7;
        int l7;
        int i8;
        if (isLast)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        k5 = postFlags;
        l5 = (int)(userId ^ userId >>> 32);
        i6 = (int)(postId ^ postId >>> 32);
        j6 = (int)(myRepostId ^ myRepostId >>> 32);
        k6 = likesCount;
        l6 = revinersCount;
        i7 = commentsCount;
        if (orderId != null)
        {
            j = orderId.hashCode();
        } else
        {
            j = 0;
        }
        if (tag != null)
        {
            k = tag.hashCode();
        } else
        {
            k = 0;
        }
        if (foursquareVenueId != null)
        {
            l = foursquareVenueId.hashCode();
        } else
        {
            l = 0;
        }
        if (description != null)
        {
            i1 = description.hashCode();
        } else
        {
            i1 = 0;
        }
        if (avatarUrl != null)
        {
            j1 = avatarUrl.hashCode();
        } else
        {
            j1 = 0;
        }
        if (location != null)
        {
            k1 = location.hashCode();
        } else
        {
            k1 = 0;
        }
        if (videoLowURL != null)
        {
            l1 = videoLowURL.hashCode();
        } else
        {
            l1 = 0;
        }
        if (videoUrl != null)
        {
            i2 = videoUrl.hashCode();
        } else
        {
            i2 = 0;
        }
        if (username != null)
        {
            j2 = username.hashCode();
        } else
        {
            j2 = 0;
        }
        if (shareUrl != null)
        {
            k2 = shareUrl.hashCode();
        } else
        {
            k2 = 0;
        }
        if (thumbnailUrl != null)
        {
            l2 = thumbnailUrl.hashCode();
        } else
        {
            l2 = 0;
        }
        if (tags != null)
        {
            i3 = tags.hashCode();
        } else
        {
            i3 = 0;
        }
        if (entities != null)
        {
            j3 = entities.hashCode();
        } else
        {
            j3 = 0;
        }
        if (comments != null)
        {
            k3 = comments.hashCode();
        } else
        {
            k3 = 0;
        }
        if (likes != null)
        {
            l3 = likes.hashCode();
        } else
        {
            l3 = 0;
        }
        if (user != null)
        {
            i4 = user.hashCode();
        } else
        {
            i4 = 0;
        }
        if (venueData != null)
        {
            j4 = venueData.hashCode();
        } else
        {
            j4 = 0;
        }
        if (repost != null)
        {
            k4 = repost.hashCode();
        } else
        {
            k4 = 0;
        }
        j7 = userBackgroundColor;
        k7 = (int)(loops ^ loops >>> 32);
        l7 = (int)(velocity * 3600D);
        i8 = (int)(lastRefresh ^ lastRefresh >>> 32);
        if (!onFire)
        {
            l4 = 0;
        }
        return (((((((((((((((((((((((((((((((i5 * 31 + j5) * 31 + i) * 31 + k5) * 31 + l5) * 31 + i6) * 31 + j6) * 31 + k6) * 31 + l6) * 31 + i7) * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k2) * 31 + l2) * 31 + i3) * 31 + j3) * 31 + k3) * 31 + l3) * 31 + i4) * 31 + j4) * 31 + k4) * 31 + j7) * 31 + k7) * 31 + l7) * 31 + i8) * 31 + l4;
    }

    public boolean isExplicit()
    {
        return (metadataFlags & 4) != 0;
    }

    public boolean isLiked()
    {
        return (metadataFlags & 8) != 0;
    }

    public boolean isPrivate()
    {
        return (metadataFlags & 0x40) != 0;
    }

    public boolean isPromoted()
    {
        return (metadataFlags & 2) != 0;
    }

    public boolean isRevined()
    {
        return (metadataFlags & 0x10) != 0;
    }

    public boolean isShareable()
    {
        return shareUrl != null;
    }

    public boolean isVerified()
    {
        return (metadataFlags & 1) != 0;
    }

    public void setFlagExplicit(boolean flag)
    {
        if (flag)
        {
            metadataFlags = metadataFlags | 4;
            return;
        } else
        {
            metadataFlags = metadataFlags & -5;
            return;
        }
    }

    public void setFlagLiked(boolean flag)
    {
        if (flag)
        {
            metadataFlags = metadataFlags | 8;
            return;
        } else
        {
            metadataFlags = metadataFlags & -9;
            return;
        }
    }

    public void setFlagPostVerified(boolean flag)
    {
        if (flag)
        {
            metadataFlags = metadataFlags | 0x20;
            return;
        } else
        {
            metadataFlags = metadataFlags & 0xffffffdf;
            return;
        }
    }

    public void setFlagPrivate(boolean flag)
    {
        if (flag)
        {
            metadataFlags = metadataFlags | 0x40;
            return;
        } else
        {
            metadataFlags = metadataFlags & 0xffffffbf;
            return;
        }
    }

    public void setFlagPromoted(boolean flag)
    {
        if (flag)
        {
            metadataFlags = metadataFlags | 2;
            return;
        } else
        {
            metadataFlags = metadataFlags & -3;
            return;
        }
    }

    public void setFlagRevined(boolean flag)
    {
        if (flag)
        {
            metadataFlags = metadataFlags | 0x10;
            return;
        } else
        {
            metadataFlags = metadataFlags & 0xffffffef;
            return;
        }
    }

    public void setFlagVerified(boolean flag)
    {
        if (flag)
        {
            metadataFlags = metadataFlags | 1;
            return;
        } else
        {
            metadataFlags = metadataFlags & -2;
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeLong(created);
        parcel.writeInt(metadataFlags);
        int j;
        if (isLast)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeInt(postFlags);
        parcel.writeInt(likesCount);
        parcel.writeInt(revinersCount);
        parcel.writeInt(commentsCount);
        parcel.writeLong(userId);
        parcel.writeLong(postId);
        parcel.writeLong(myRepostId);
        parcel.writeString(orderId);
        parcel.writeString(tag);
        parcel.writeString(foursquareVenueId);
        parcel.writeString(description);
        parcel.writeString(avatarUrl);
        parcel.writeString(location);
        parcel.writeString(videoLowURL);
        parcel.writeString(videoUrl);
        parcel.writeString(username);
        parcel.writeString(shareUrl);
        parcel.writeString(thumbnailUrl);
        parcel.writeParcelable(comments, i);
        parcel.writeParcelable(likes, i);
        parcel.writeParcelable(user, i);
        parcel.writeSerializable(venueData);
        parcel.writeSerializable(entities);
        parcel.writeSerializable(repost);
        parcel.writeInt(userBackgroundColor);
        parcel.writeLong(loops);
        parcel.writeDouble(velocity);
        parcel.writeLong(lastRefresh);
        if (onFire)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

}
