// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

public class VineChannel
    implements Parcelable, Comparable
{

    public String backgroundColor;
    public String channel;
    public long channelId;
    public long created;
    public String fontColor;
    public String iconFullUrl;
    public boolean isLast;
    public long lastUsedTimestamp;
    public String retinaIconFullUrl;

    public VineChannel()
    {
    }

    public VineChannel(Parcel parcel)
    {
        boolean flag = true;
        super();
        channelId = parcel.readLong();
        created = parcel.readLong();
        lastUsedTimestamp = parcel.readLong();
        channel = parcel.readString();
        backgroundColor = parcel.readString();
        fontColor = parcel.readString();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        isLast = flag;
        iconFullUrl = parcel.readString();
        retinaIconFullUrl = parcel.readString();
    }

    public static VineChannel from(Cursor cursor)
    {
        boolean flag = true;
        VineChannel vinechannel = new VineChannel();
        vinechannel.channelId = cursor.getLong(1);
        vinechannel.created = cursor.getLong(3);
        vinechannel.lastUsedTimestamp = cursor.getLong(6);
        vinechannel.channel = cursor.getString(2);
        vinechannel.backgroundColor = cursor.getString(4);
        vinechannel.fontColor = cursor.getString(5);
        if (cursor.getInt(7) != 1)
        {
            flag = false;
        }
        vinechannel.isLast = flag;
        vinechannel.iconFullUrl = cursor.getString(8);
        vinechannel.retinaIconFullUrl = cursor.getString(9);
        return vinechannel;
    }

    public int compareTo(VineChannel vinechannel)
    {
        return Long.valueOf(vinechannel.channelId).compareTo(Long.valueOf(channelId));
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((VineChannel)obj);
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
            obj = (VineChannel)obj;
            if (isLast != ((VineChannel) (obj)).isLast)
            {
                return false;
            }
            if (channelId != ((VineChannel) (obj)).channelId)
            {
                return false;
            }
            if (created != ((VineChannel) (obj)).created)
            {
                return false;
            }
            if (lastUsedTimestamp != ((VineChannel) (obj)).lastUsedTimestamp)
            {
                return false;
            }
            if (channel == null ? ((VineChannel) (obj)).channel != null : !channel.equals(((VineChannel) (obj)).channel))
            {
                return false;
            }
            if (iconFullUrl == null ? ((VineChannel) (obj)).iconFullUrl != null : !iconFullUrl.equals(((VineChannel) (obj)).iconFullUrl))
            {
                return false;
            }
            if (retinaIconFullUrl == null ? ((VineChannel) (obj)).retinaIconFullUrl != null : !retinaIconFullUrl.equals(((VineChannel) (obj)).retinaIconFullUrl))
            {
                return false;
            }
            if (backgroundColor == null ? ((VineChannel) (obj)).backgroundColor != null : !backgroundColor.equals(((VineChannel) (obj)).backgroundColor))
            {
                return false;
            }
            if (fontColor == null ? ((VineChannel) (obj)).fontColor != null : !fontColor.equals(((VineChannel) (obj)).fontColor))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j1 = 0;
        int k1 = (int)(channelId ^ channelId >>> 32);
        int l1 = (int)(created ^ created >>> 32);
        int i2 = (int)(lastUsedTimestamp ^ lastUsedTimestamp >>> 32);
        int i;
        int j;
        int k;
        int l;
        int i1;
        if (isLast)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (channel != null)
        {
            j = channel.hashCode();
        } else
        {
            j = 0;
        }
        if (iconFullUrl != null)
        {
            k = iconFullUrl.hashCode();
        } else
        {
            k = 0;
        }
        if (retinaIconFullUrl != null)
        {
            l = retinaIconFullUrl.hashCode();
        } else
        {
            l = 0;
        }
        if (backgroundColor != null)
        {
            i1 = backgroundColor.hashCode();
        } else
        {
            i1 = 0;
        }
        if (fontColor != null)
        {
            j1 = fontColor.hashCode();
        }
        return (((((((k1 * 31 + l1) * 31 + i2) * 31 + i) * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(channelId);
        parcel.writeLong(created);
        parcel.writeLong(lastUsedTimestamp);
        parcel.writeString(channel);
        parcel.writeString(backgroundColor);
        parcel.writeString(fontColor);
        if (isLast)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(iconFullUrl);
        parcel.writeString(retinaIconFullUrl);
    }
}
