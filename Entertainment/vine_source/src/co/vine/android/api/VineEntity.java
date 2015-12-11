// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.style.ForegroundColorSpan;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VineEntity
    implements Externalizable, Comparable, Parcelable
{
    public static class Range
    {

        public VineEntity entity;
        public ForegroundColorSpan span;
        public int upper;

        public Range(int i, VineEntity vineentity, ForegroundColorSpan foregroundcolorspan)
        {
            upper = i;
            entity = vineentity;
            span = foregroundcolorspan;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineEntity createFromParcel(Parcel parcel)
        {
            return new VineEntity(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineEntity[] newArray(int i)
        {
            return new VineEntity[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String TYPE_COMMENT_LIST = "commentList";
    public static final String TYPE_MENTION = "mention";
    public static final String TYPE_POST = "post";
    public static final String TYPE_TAG = "tag";
    public static final String TYPE_USER = "user";
    public static final String TYPE_USER_LIST = "userList";
    private static final long serialVersionUID = 0xc83ffb63e30f0735L;
    public boolean adjusted;
    public int end;
    public long id;
    public String link;
    public int start;
    public String title;
    public String type;

    public VineEntity()
    {
        adjusted = false;
    }

    public VineEntity(Parcel parcel)
    {
        boolean flag = true;
        super();
        adjusted = false;
        type = parcel.readString();
        title = parcel.readString();
        link = parcel.readString();
        start = parcel.readInt();
        end = parcel.readInt();
        id = parcel.readLong();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        adjusted = flag;
    }

    public VineEntity(VineEntity vineentity)
    {
        this(vineentity.type, vineentity.title, vineentity.link, vineentity.start, vineentity.end, vineentity.id);
    }

    public VineEntity(String s, String s1, String s2, int i, int j, long l)
    {
        adjusted = false;
        type = s;
        title = s1;
        link = s2;
        start = i;
        end = j;
        id = l;
        adjusted = false;
    }

    public int compareTo(VineEntity vineentity)
    {
        return Integer.valueOf(end).compareTo(Integer.valueOf(vineentity.end));
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((VineEntity)obj);
    }

    public int describeContents()
    {
        return 0;
    }

    public VineEntity duplicate()
    {
        return new VineEntity(type, title, link, start, end, id);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (VineEntity)obj;
            if (adjusted != ((VineEntity) (obj)).adjusted)
            {
                return false;
            }
            if (end != ((VineEntity) (obj)).end)
            {
                return false;
            }
            if (id != ((VineEntity) (obj)).id)
            {
                return false;
            }
            if (start != ((VineEntity) (obj)).start)
            {
                return false;
            }
            if (link == null ? ((VineEntity) (obj)).link != null : !link.equals(((VineEntity) (obj)).link))
            {
                return false;
            }
            if (title == null ? ((VineEntity) (obj)).title != null : !title.equals(((VineEntity) (obj)).title))
            {
                return false;
            }
            if (type == null ? ((VineEntity) (obj)).type != null : !type.equals(((VineEntity) (obj)).type))
            {
                return false;
            }
        }
        return true;
    }

    public long getPostId()
    {
        return Long.parseLong((String)Uri.parse(link).getPathSegments().get(0));
    }

    public int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        int i1;
        int j1;
        int k1;
        if (type != null)
        {
            i = type.hashCode();
        } else
        {
            i = 0;
        }
        if (title != null)
        {
            j = title.hashCode();
        } else
        {
            j = 0;
        }
        if (link != null)
        {
            k = link.hashCode();
        } else
        {
            k = 0;
        }
        i1 = start;
        j1 = end;
        k1 = (int)(id ^ id >>> 32);
        if (adjusted)
        {
            l = 1;
        }
        return (((((i * 31 + j) * 31 + k) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + l;
    }

    public boolean isCommentListType()
    {
        return "commentList".equals(type);
    }

    public boolean isTagType()
    {
        return "tag".equals(type);
    }

    public boolean isUserListType()
    {
        return "userList".equals(type);
    }

    public boolean isUserType()
    {
        return "user".equals(type) || "mention".equals(type) || "post".equals(type);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        type = (String)objectinput.readObject();
        title = (String)objectinput.readObject();
        link = (String)objectinput.readObject();
        start = objectinput.readInt();
        end = objectinput.readInt();
        id = objectinput.readLong();
        adjusted = objectinput.readBoolean();
    }

    public HashMap toMap()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("id", Long.valueOf(id));
        hashmap.put("type", type);
        hashmap.put("text", title);
        ArrayList arraylist = new ArrayList();
        arraylist.add(Integer.valueOf(start));
        arraylist.add(Integer.valueOf(end));
        hashmap.put("range", arraylist);
        return hashmap;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(type);
        objectoutput.writeObject(title);
        objectoutput.writeObject(link);
        objectoutput.writeInt(start);
        objectoutput.writeInt(end);
        objectoutput.writeLong(id);
        objectoutput.writeBoolean(adjusted);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(type);
        parcel.writeString(title);
        parcel.writeString(link);
        parcel.writeInt(start);
        parcel.writeInt(end);
        parcel.writeLong(id);
        if (adjusted)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

}
