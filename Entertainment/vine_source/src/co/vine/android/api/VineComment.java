// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import co.vine.android.util.Util;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.api:
//            VineUser

public class VineComment
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineComment createFromParcel(Parcel parcel)
        {
            return new VineComment(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineComment[] newArray(int i)
        {
            return new VineComment[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String avatarUrl;
    public String comment;
    public long commentId;
    public SpannableStringBuilder commentSb;
    public ArrayList entities;
    public boolean isLast;
    public String location;
    public long postId;
    public long timestamp;
    public ArrayList transientEntities;
    public VineUser user;
    public long userId;
    public String username;
    public boolean verified;

    public VineComment(long l, String s, String s1, VineUser vineuser, long l1, 
            String s2, long l2, String s3, boolean flag, long l3, 
            ArrayList arraylist, boolean flag1)
    {
        commentId = l;
        avatarUrl = s1;
        comment = s;
        user = vineuser;
        timestamp = l1;
        location = s2;
        userId = l2;
        username = s3;
        verified = flag;
        postId = l3;
        entities = arraylist;
        isLast = flag1;
    }

    public VineComment(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        commentId = parcel.readLong();
        comment = parcel.readString();
        avatarUrl = parcel.readString();
        user = (VineUser)parcel.readParcelable(ClassLoader.getSystemClassLoader());
        timestamp = parcel.readLong();
        location = parcel.readString();
        userId = parcel.readLong();
        username = parcel.readString();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        verified = flag;
        postId = parcel.readLong();
        entities = (ArrayList)parcel.readSerializable();
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isLast = flag;
    }

    public static VineComment from(Cursor cursor)
    {
        long l = cursor.getLong(34);
        String s = cursor.getString(35);
        String s1 = cursor.getString(36);
        long l1 = cursor.getLong(38);
        String s2 = cursor.getString(39);
        long l2 = cursor.getLong(37);
        String s3 = cursor.getString(40);
        ArrayList arraylist;
        long l3;
        boolean flag;
        boolean flag1;
        if (cursor.getInt(41) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l3 = cursor.getLong(1);
        arraylist = (ArrayList)Util.fromByteArray(cursor.getBlob(43));
        if (cursor.getInt(42) == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return new VineComment(l, s, s1, null, l1, s2, l2, s3, flag, l3, arraylist, flag1);
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
            obj = (VineComment)obj;
            if (commentId != ((VineComment) (obj)).commentId)
            {
                return false;
            }
            if (postId != ((VineComment) (obj)).postId)
            {
                return false;
            }
            if (timestamp != ((VineComment) (obj)).timestamp)
            {
                return false;
            }
            if (userId != ((VineComment) (obj)).userId)
            {
                return false;
            }
            if (verified != ((VineComment) (obj)).verified)
            {
                return false;
            }
            if (avatarUrl == null ? ((VineComment) (obj)).avatarUrl != null : !avatarUrl.equals(((VineComment) (obj)).avatarUrl))
            {
                return false;
            }
            if (comment == null ? ((VineComment) (obj)).comment != null : !comment.equals(((VineComment) (obj)).comment))
            {
                return false;
            }
            if (entities == null ? ((VineComment) (obj)).entities != null : !entities.equals(((VineComment) (obj)).entities))
            {
                return false;
            }
            if (location == null ? ((VineComment) (obj)).location != null : !location.equals(((VineComment) (obj)).location))
            {
                return false;
            }
            if (user == null ? ((VineComment) (obj)).user != null : !user.equals(((VineComment) (obj)).user))
            {
                return false;
            }
            if (username == null ? ((VineComment) (obj)).username != null : !username.equals(((VineComment) (obj)).username))
            {
                return false;
            }
            if (isLast != ((VineComment) (obj)).isLast)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int l1 = 1;
        int i2 = (int)(commentId ^ commentId >>> 32);
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int j2;
        int k2;
        int l2;
        if (comment != null)
        {
            i = comment.hashCode();
        } else
        {
            i = 0;
        }
        if (avatarUrl != null)
        {
            j = avatarUrl.hashCode();
        } else
        {
            j = 0;
        }
        if (user != null)
        {
            k = user.hashCode();
        } else
        {
            k = 0;
        }
        j2 = (int)(timestamp ^ timestamp >>> 32);
        if (location != null)
        {
            l = location.hashCode();
        } else
        {
            l = 0;
        }
        k2 = (int)(userId ^ userId >>> 32);
        if (username != null)
        {
            i1 = username.hashCode();
        } else
        {
            i1 = 0;
        }
        if (verified)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        l2 = (int)(postId ^ postId >>> 32);
        if (entities != null)
        {
            k1 = entities.hashCode();
        } else
        {
            k1 = 0;
        }
        if (!verified)
        {
            l1 = 0;
        }
        return ((((((((((i2 * 31 + i) * 31 + j) * 31 + k) * 31 + j2) * 31 + l) * 31 + k2) * 31 + i1) * 31 + j1) * 31 + l2) * 31 + k1) * 31 + l1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(commentId);
        parcel.writeString(comment);
        parcel.writeString(avatarUrl);
        parcel.writeParcelable(user, i);
        parcel.writeLong(timestamp);
        parcel.writeString(location);
        parcel.writeLong(userId);
        parcel.writeString(username);
        long l;
        if (verified)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeLong(postId);
        parcel.writeSerializable(entities);
        if (isLast)
        {
            l = 1L;
        } else
        {
            l = 0L;
        }
        parcel.writeLong(l);
    }

}
