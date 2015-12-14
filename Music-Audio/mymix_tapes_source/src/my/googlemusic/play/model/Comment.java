// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.model;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package my.googlemusic.play.model:
//            User

public class Comment
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public static int STATUS_FAILED = 1;
    public static int STATUS_FINISHED = 3;
    public static int STATUS_PREPARED = 2;
    long albumId;
    long commentId;
    String date;
    String message;
    int replyCount;
    int status;
    String time;
    User user;

    private Comment(Parcel parcel)
    {
        user = (User)parcel.readParcelable(my/googlemusic/play/model/User.getClassLoader());
        status = parcel.readInt();
        time = parcel.readString();
        date = parcel.readString();
        albumId = parcel.readLong();
        message = parcel.readString();
        commentId = parcel.readLong();
        replyCount = parcel.readInt();
    }

    Comment(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public Comment(User user1, String s, String s1, String s2, long l, long l1, int i, int j)
    {
        user = user1;
        time = s1;
        date = s2;
        albumId = l1;
        message = s;
        commentId = l;
        replyCount = i;
        status = j;
    }

    public int describeContents()
    {
        return 0;
    }

    public long getAlbumId()
    {
        return albumId;
    }

    public long getCommentId()
    {
        return commentId;
    }

    public String getDate()
    {
        return date;
    }

    public String getMessage()
    {
        return message;
    }

    public int getReplyCount()
    {
        return replyCount;
    }

    public int getStatus()
    {
        return status;
    }

    public String getTime()
    {
        return time;
    }

    public User getUser()
    {
        return user;
    }

    public void setCommentId(long l)
    {
        commentId = l;
    }

    public void setStatus(int i)
    {
        status = i;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(user, i);
        parcel.writeInt(status);
        parcel.writeString(time);
        parcel.writeString(date);
        parcel.writeLong(albumId);
        parcel.writeString(message);
        parcel.writeLong(commentId);
        parcel.writeInt(replyCount);
    }


    /* member class not found */
    class _cls1 {}

}
