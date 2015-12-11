// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat
    implements Parcelable
{
    public static final class CustomAction
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new CustomAction(parcel, (byte)0);
            }

            public final volatile Object[] newArray(int l)
            {
                return new CustomAction[l];
            }

        };
        final String a;
        final CharSequence b;
        final int c;
        final Bundle d;
        Object e;

        public final int describeContents()
        {
            return 0;
        }

        public final String toString()
        {
            return (new StringBuilder("Action:mName='")).append(b).append(", mIcon=").append(c).append(", mExtras=").append(d).toString();
        }

        public final void writeToParcel(Parcel parcel, int l)
        {
            parcel.writeString(a);
            TextUtils.writeToParcel(b, parcel, l);
            parcel.writeInt(c);
            parcel.writeBundle(d);
        }


        private CustomAction(Parcel parcel)
        {
            a = parcel.readString();
            b = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            c = parcel.readInt();
            d = parcel.readBundle();
        }

        CustomAction(Parcel parcel, byte byte0)
        {
            this(parcel);
        }
    }

    public static final class a
    {

        public long a;
        private final List b;
        private int c;
        private long d;
        private long e;
        private float f;
        private CharSequence g;
        private long h;
        private long i;
        private Bundle j;

        public final a a(int l)
        {
            return a(l, -1L, 0.0F, SystemClock.elapsedRealtime());
        }

        public final a a(int l, long l1, float f1, long l2)
        {
            c = l;
            d = l1;
            h = l2;
            f = f1;
            return this;
        }

        public final PlaybackStateCompat a()
        {
            return new PlaybackStateCompat(c, d, e, f, a, g, h, b, i, j, (byte)0);
        }

        public a()
        {
            b = new ArrayList();
            i = -1L;
        }

        public a(PlaybackStateCompat playbackstatecompat)
        {
            b = new ArrayList();
            i = -1L;
            c = PlaybackStateCompat.a(playbackstatecompat);
            d = PlaybackStateCompat.b(playbackstatecompat);
            f = PlaybackStateCompat.c(playbackstatecompat);
            h = PlaybackStateCompat.d(playbackstatecompat);
            e = PlaybackStateCompat.e(playbackstatecompat);
            a = PlaybackStateCompat.f(playbackstatecompat);
            g = PlaybackStateCompat.g(playbackstatecompat);
            if (PlaybackStateCompat.h(playbackstatecompat) != null)
            {
                b.addAll(PlaybackStateCompat.h(playbackstatecompat));
            }
            i = PlaybackStateCompat.i(playbackstatecompat);
            j = PlaybackStateCompat.j(playbackstatecompat);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new PlaybackStateCompat(parcel, (byte)0);
        }

        public final volatile Object[] newArray(int l)
        {
            return new PlaybackStateCompat[l];
        }

    };
    final int a;
    final long b;
    final long c;
    final float d;
    final long e;
    final CharSequence f;
    final long g;
    List h;
    final long i;
    final Bundle j;
    Object k;

    private PlaybackStateCompat(int l, long l1, long l2, float f1, long l3, CharSequence charsequence, long l4, List list, long l5, 
            Bundle bundle)
    {
        a = l;
        b = l1;
        c = l2;
        d = f1;
        e = l3;
        f = charsequence;
        g = l4;
        h = new ArrayList(list);
        i = l5;
        j = bundle;
    }

    PlaybackStateCompat(int l, long l1, long l2, float f1, long l3, CharSequence charsequence, long l4, List list, long l5, 
            Bundle bundle, byte byte0)
    {
        this(l, l1, l2, f1, l3, charsequence, l4, list, l5, bundle);
    }

    private PlaybackStateCompat(Parcel parcel)
    {
        a = parcel.readInt();
        b = parcel.readLong();
        d = parcel.readFloat();
        g = parcel.readLong();
        c = parcel.readLong();
        e = parcel.readLong();
        f = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        h = parcel.createTypedArrayList(CustomAction.CREATOR);
        i = parcel.readLong();
        j = parcel.readBundle();
    }

    PlaybackStateCompat(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    static int a(PlaybackStateCompat playbackstatecompat)
    {
        return playbackstatecompat.a;
    }

    static long b(PlaybackStateCompat playbackstatecompat)
    {
        return playbackstatecompat.b;
    }

    static float c(PlaybackStateCompat playbackstatecompat)
    {
        return playbackstatecompat.d;
    }

    static long d(PlaybackStateCompat playbackstatecompat)
    {
        return playbackstatecompat.g;
    }

    static long e(PlaybackStateCompat playbackstatecompat)
    {
        return playbackstatecompat.c;
    }

    static long f(PlaybackStateCompat playbackstatecompat)
    {
        return playbackstatecompat.e;
    }

    static CharSequence g(PlaybackStateCompat playbackstatecompat)
    {
        return playbackstatecompat.f;
    }

    static List h(PlaybackStateCompat playbackstatecompat)
    {
        return playbackstatecompat.h;
    }

    static long i(PlaybackStateCompat playbackstatecompat)
    {
        return playbackstatecompat.i;
    }

    static Bundle j(PlaybackStateCompat playbackstatecompat)
    {
        return playbackstatecompat.j;
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
        stringbuilder.append(", custom actions=").append(h);
        stringbuilder.append(", active item id=").append(i);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int l)
    {
        parcel.writeInt(a);
        parcel.writeLong(b);
        parcel.writeFloat(d);
        parcel.writeLong(g);
        parcel.writeLong(c);
        parcel.writeLong(e);
        TextUtils.writeToParcel(f, parcel, l);
        parcel.writeTypedList(h);
        parcel.writeLong(i);
        parcel.writeBundle(j);
    }

}
