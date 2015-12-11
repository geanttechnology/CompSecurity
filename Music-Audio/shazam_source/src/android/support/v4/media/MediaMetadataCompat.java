// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.f.a;

// Referenced classes of package android.support.v4.media:
//            RatingCompat

public final class MediaMetadataCompat
    implements Parcelable
{
    public static final class a
    {

        public final Bundle a = new Bundle();

        public final a a(String s, Bitmap bitmap)
        {
            if (android.support.v4.media.MediaMetadataCompat.a().containsKey(s) && ((Integer)android.support.v4.media.MediaMetadataCompat.a().get(s)).intValue() != 2)
            {
                throw new IllegalArgumentException((new StringBuilder("The ")).append(s).append(" key cannot be used to put a Bitmap").toString());
            } else
            {
                a.putParcelable(s, bitmap);
                return this;
            }
        }

        public final a a(String s, String s1)
        {
            if (android.support.v4.media.MediaMetadataCompat.a().containsKey(s) && ((Integer)android.support.v4.media.MediaMetadataCompat.a().get(s)).intValue() != 1)
            {
                throw new IllegalArgumentException((new StringBuilder("The ")).append(s).append(" key cannot be used to put a String").toString());
            } else
            {
                a.putCharSequence(s, s1);
                return this;
            }
        }

        public a()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new MediaMetadataCompat(parcel, (byte)0);
        }

        public final volatile Object[] newArray(int i)
        {
            return new MediaMetadataCompat[i];
        }

    };
    public static final android.support.v4.f.a a;
    private static final String d[] = {
        "android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"
    };
    private static final String e[] = {
        "android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"
    };
    private static final String f[] = {
        "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"
    };
    public final Bundle b;
    public Object c;

    private MediaMetadataCompat(Bundle bundle)
    {
        b = new Bundle(bundle);
    }

    public MediaMetadataCompat(Bundle bundle, byte byte0)
    {
        this(bundle);
    }

    private MediaMetadataCompat(Parcel parcel)
    {
        b = parcel.readBundle();
    }

    MediaMetadataCompat(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    static android.support.v4.f.a a()
    {
        return a;
    }

    public final long a(String s)
    {
        return b.getLong(s, 0L);
    }

    public final RatingCompat b(String s)
    {
        try
        {
            s = (RatingCompat)b.getParcelable(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public final Bitmap c(String s)
    {
        try
        {
            s = (Bitmap)b.getParcelable(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeBundle(b);
    }

    static 
    {
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a = a1;
        a1.put("android.media.metadata.TITLE", Integer.valueOf(1));
        a.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        a.put("android.media.metadata.DURATION", Integer.valueOf(0));
        a.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        a.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        a.put("android.media.metadata.WRITER", Integer.valueOf(1));
        a.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        a.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        a.put("android.media.metadata.DATE", Integer.valueOf(1));
        a.put("android.media.metadata.YEAR", Integer.valueOf(0));
        a.put("android.media.metadata.GENRE", Integer.valueOf(1));
        a.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        a.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        a.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        a.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        a.put("android.media.metadata.ART", Integer.valueOf(2));
        a.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        a.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        a.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        a.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        a.put("android.media.metadata.RATING", Integer.valueOf(3));
        a.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        a.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        a.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        a.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        a.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        a.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
    }
}
