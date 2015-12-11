// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import co.vine.android.util.Util;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.api:
//            VinePost

public class VinePrivateMessage
    implements Externalizable, Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VinePrivateMessage createFromParcel(Parcel parcel)
        {
            return new VinePrivateMessage(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VinePrivateMessage[] newArray(int i)
        {
            return new VinePrivateMessage[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int NO_LOOP_LIMIT = 0x7fffffff;
    public String avatarUrl;
    public long conversationId;
    public long conversationRowId;
    public long created;
    public boolean ephemeral;
    public int errorCode;
    public String errorReason;
    public boolean hasVideo;
    public boolean isInNetwork;
    public boolean isLast;
    public long localStartTime;
    public int maxLoops;
    public String message;
    public long messageId;
    public long messageRowId;
    public int networkType;
    public VinePost post;
    public long postId;
    public String thumbnailUrl;
    public String uploadPath;
    public long userId;
    public boolean vanished;
    public long vanishedDate;
    public SpannableStringBuilder vanishedViewedSb;
    public String videoUrl;

    public VinePrivateMessage()
    {
        maxLoops = 0;
    }

    public VinePrivateMessage(long l, long l1, long l2, long l3, long l4, String s, String s1, String s2, int i, 
            boolean flag, boolean flag1, int j, long l5, boolean flag2, long l6, long l7, int k, String s3)
    {
        this(l, l1, l2, l3, l4, s, s1, s2, i, flag, flag1, j, l5, flag2, l6, l7, k, s3, null);
    }

    public VinePrivateMessage(long l, long l1, long l2, long l3, long l4, String s, String s1, String s2, int i, 
            boolean flag, boolean flag1, int j, long l5, boolean flag2, long l6, long l7, int k, String s3, String s4)
    {
        maxLoops = 0;
        messageRowId = l;
        conversationId = l1;
        messageId = l2;
        userId = l3;
        created = l4;
        message = s;
        videoUrl = s1;
        thumbnailUrl = s2;
        networkType = i;
        boolean flag3;
        if (!TextUtils.isEmpty(s1))
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        hasVideo = flag3;
        if (i == 1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        isInNetwork = flag3;
        isLast = flag;
        vanished = flag1;
        maxLoops = j;
        vanishedDate = l5;
        ephemeral = flag2;
        localStartTime = l6;
        postId = l7;
        errorCode = k;
        errorReason = s3;
        uploadPath = s4;
    }

    public VinePrivateMessage(long l, long l1, long l2, long l3, long l4, String s, String s1, String s2, int i, 
            boolean flag, boolean flag1, int j, long l5, boolean flag2, long l6, VinePost vinepost, int k, String s3)
    {
        long l7;
        if (vinepost != null)
        {
            l7 = vinepost.postId;
        } else
        {
            l7 = 0L;
        }
        this(l, l1, l2, l3, l4, s, s1, s2, i, flag, flag1, j, l5, flag2, l6, l7, k, s3);
        post = vinepost;
    }

    public VinePrivateMessage(Cursor cursor)
    {
        boolean flag1 = true;
        super();
        maxLoops = 0;
        messageRowId = cursor.getLong(0);
        conversationId = cursor.getLong(19);
        conversationRowId = cursor.getLong(1);
        messageId = cursor.getLong(2);
        message = cursor.getString(5);
        userId = cursor.getLong(3);
        created = cursor.getLong(4);
        videoUrl = cursor.getString(6);
        thumbnailUrl = cursor.getString(7);
        avatarUrl = cursor.getString(24);
        networkType = cursor.getInt(20);
        boolean flag;
        if (!TextUtils.isEmpty(videoUrl))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasVideo = flag;
        if (networkType == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isInNetwork = flag;
        if (cursor.getInt(8) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isLast = flag;
        if (cursor.getInt(9) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        vanished = flag;
        maxLoops = cursor.getInt(10);
        vanishedDate = cursor.getLong(11);
        if (cursor.getInt(12) == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ephemeral = flag;
        localStartTime = cursor.getLong(13);
        postId = cursor.getLong(15);
        errorCode = cursor.getInt(17);
        errorReason = cursor.getString(18);
        uploadPath = cursor.getString(16);
        if (postId > 0L)
        {
            post = new VinePost();
            post.postId = postId;
            post.userId = cursor.getLong(26);
            post.username = cursor.getString(27);
            post.avatarUrl = cursor.getString(28);
            post.entities = (ArrayList)Util.fromByteArray(cursor.getBlob(29));
            post.description = cursor.getString(30);
            post.shareUrl = cursor.getString(31);
        }
    }

    public VinePrivateMessage(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        maxLoops = 0;
        messageRowId = parcel.readLong();
        conversationId = parcel.readLong();
        messageId = parcel.readLong();
        userId = parcel.readLong();
        created = parcel.readLong();
        message = parcel.readString();
        videoUrl = parcel.readString();
        avatarUrl = parcel.readString();
        thumbnailUrl = parcel.readString();
        networkType = parcel.readInt();
        boolean flag;
        if (!TextUtils.isEmpty(videoUrl))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasVideo = flag;
        if (networkType == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isInNetwork = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isLast = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        vanished = flag;
        maxLoops = parcel.readInt();
        vanishedDate = parcel.readLong();
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ephemeral = flag;
        localStartTime = parcel.readLong();
        postId = parcel.readLong();
        errorCode = parcel.readInt();
        errorReason = parcel.readString();
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
            obj = (VinePrivateMessage)obj;
            if (conversationId != ((VinePrivateMessage) (obj)).conversationId)
            {
                return false;
            }
            if (messageId != ((VinePrivateMessage) (obj)).messageId)
            {
                return false;
            }
            if (userId != ((VinePrivateMessage) (obj)).userId)
            {
                return false;
            }
            if (created != ((VinePrivateMessage) (obj)).created)
            {
                return false;
            }
            if (message == null ? ((VinePrivateMessage) (obj)).message != null : !message.equals(((VinePrivateMessage) (obj)).message))
            {
                return false;
            }
            if (videoUrl == null ? ((VinePrivateMessage) (obj)).videoUrl != null : !videoUrl.equals(((VinePrivateMessage) (obj)).videoUrl))
            {
                return false;
            }
            if (avatarUrl == null ? ((VinePrivateMessage) (obj)).avatarUrl != null : !avatarUrl.equals(((VinePrivateMessage) (obj)).avatarUrl))
            {
                return false;
            }
            if (thumbnailUrl == null ? ((VinePrivateMessage) (obj)).thumbnailUrl != null : !thumbnailUrl.equals(((VinePrivateMessage) (obj)).thumbnailUrl))
            {
                return false;
            }
            if (networkType != ((VinePrivateMessage) (obj)).networkType)
            {
                return false;
            }
            if (ephemeral != ((VinePrivateMessage) (obj)).ephemeral)
            {
                return false;
            }
            if (isLast != ((VinePrivateMessage) (obj)).isLast)
            {
                return false;
            }
            if (vanished != ((VinePrivateMessage) (obj)).vanished)
            {
                return false;
            }
            if (maxLoops != ((VinePrivateMessage) (obj)).maxLoops)
            {
                return false;
            }
            if (vanishedDate != ((VinePrivateMessage) (obj)).vanishedDate)
            {
                return false;
            }
            if (localStartTime != ((VinePrivateMessage) (obj)).localStartTime)
            {
                return false;
            }
            if (postId != ((VinePrivateMessage) (obj)).postId)
            {
                return false;
            }
            if (errorCode != ((VinePrivateMessage) (obj)).errorCode)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j1 = 1;
        int k1 = (int)(conversationId ^ conversationId >>> 32);
        int l1 = (int)(messageId ^ messageId >>> 32);
        int i2 = (int)(userId ^ userId >>> 32);
        int j2 = (int)(created ^ created >>> 32);
        int k2 = networkType;
        int i;
        int j;
        int k;
        int l;
        int i1;
        if (message != null)
        {
            i = message.hashCode();
        } else
        {
            i = 0;
        }
        if (videoUrl != null)
        {
            j = videoUrl.hashCode();
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
        if (thumbnailUrl != null)
        {
            l = thumbnailUrl.hashCode();
        } else
        {
            l = 0;
        }
        if (isLast)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (!vanished)
        {
            j1 = 0;
        }
        return ((((((((((((((k1 * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k2) * 31 + i) * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + maxLoops) * 31 + (int)(vanishedDate ^ vanishedDate >>> 32)) * 31 + (int)(localStartTime ^ localStartTime >>> 32)) * 31 + (int)(postId ^ postId >>> 32)) * 31 + (errorCode ^ errorCode >>> 32);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        boolean flag1 = true;
        messageRowId = objectinput.readLong();
        conversationId = objectinput.readLong();
        messageId = objectinput.readLong();
        userId = objectinput.readLong();
        created = objectinput.readLong();
        message = (String)objectinput.readObject();
        videoUrl = (String)objectinput.readObject();
        avatarUrl = (String)objectinput.readObject();
        thumbnailUrl = (String)objectinput.readObject();
        networkType = objectinput.readInt();
        boolean flag;
        if (!TextUtils.isEmpty(videoUrl))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasVideo = flag;
        if (networkType == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isInNetwork = flag;
        if (objectinput.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isLast = flag;
        if (objectinput.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        vanished = flag;
        maxLoops = objectinput.readInt();
        vanishedDate = objectinput.readLong();
        if (objectinput.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ephemeral = flag;
        localStartTime = objectinput.readLong();
        postId = objectinput.readLong();
        errorCode = objectinput.readInt();
        errorReason = objectinput.readLine();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        boolean flag = true;
        objectoutput.writeLong(messageRowId);
        objectoutput.writeLong(conversationId);
        objectoutput.writeLong(messageId);
        objectoutput.writeLong(userId);
        objectoutput.writeLong(created);
        objectoutput.writeObject(message);
        objectoutput.writeObject(videoUrl);
        objectoutput.writeObject(avatarUrl);
        objectoutput.writeObject(thumbnailUrl);
        objectoutput.writeInt(networkType);
        int i;
        if (isLast)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        objectoutput.writeInt(i);
        if (vanished)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        objectoutput.writeInt(i);
        objectoutput.writeInt(maxLoops);
        objectoutput.writeLong(vanishedDate);
        if (ephemeral)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        objectoutput.writeInt(i);
        objectoutput.writeLong(localStartTime);
        objectoutput.writeLong(postId);
        objectoutput.writeInt(errorCode);
        objectoutput.writeChars(errorReason);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeLong(messageRowId);
        parcel.writeLong(conversationId);
        parcel.writeLong(messageId);
        parcel.writeLong(userId);
        parcel.writeLong(created);
        parcel.writeString(message);
        parcel.writeString(videoUrl);
        parcel.writeString(avatarUrl);
        parcel.writeString(thumbnailUrl);
        parcel.writeInt(networkType);
        if (isLast)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (vanished)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(maxLoops);
        parcel.writeLong(vanishedDate);
        if (ephemeral)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeLong(localStartTime);
        parcel.writeLong(postId);
        parcel.writeInt(errorCode);
        parcel.writeString(errorReason);
    }

}
