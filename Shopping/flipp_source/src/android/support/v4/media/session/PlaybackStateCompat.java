// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

// Referenced classes of package android.support.v4.media.session:
//            b

public final class PlaybackStateCompat
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new b();
    private final int a;
    private final long b;
    private final long c;
    private final float d;
    private final long e;
    private final CharSequence f;
    private final long g;

    private PlaybackStateCompat(Parcel parcel)
    {
        a = parcel.readInt();
        b = parcel.readLong();
        d = parcel.readFloat();
        g = parcel.readLong();
        c = parcel.readLong();
        e = parcel.readLong();
        f = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    PlaybackStateCompat(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("PlaybackState {");
        stringbuilder.append("state=").append(a);
        stringbuilder.append(", position=").append(b);
        stringbuilder.append(", buffered position=").append(c);
        stringbuilder.append(", speed=").append(d);
        stringbuilder.append(", updated=").append(g);
        stringbuilder.append(", actions=").append(e);
        stringbuilder.append(", error=").append(f);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(a);
        parcel.writeLong(b);
        parcel.writeFloat(d);
        parcel.writeLong(g);
        parcel.writeLong(c);
        parcel.writeLong(e);
        TextUtils.writeToParcel(f, parcel, i);
    }

}
