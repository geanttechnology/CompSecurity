// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.facebook.share.model:
//            ShareMedia

public final class SharePhoto extends ShareMedia
{
    public static final class a extends ShareMedia.a
    {

        private Bitmap a;
        private Uri b;
        private boolean c;
        private String d;

        static Bitmap a(a a1)
        {
            return a1.a;
        }

        public static void a(Parcel parcel, List list)
        {
            ArrayList arraylist = new ArrayList();
            for (list = list.iterator(); list.hasNext(); arraylist.add((SharePhoto)list.next())) { }
            parcel.writeTypedList(arraylist);
        }

        static Uri b(a a1)
        {
            return a1.b;
        }

        public static List b(Parcel parcel)
        {
            ArrayList arraylist = new ArrayList();
            parcel.readTypedList(arraylist, SharePhoto.CREATOR);
            return arraylist;
        }

        static boolean c(a a1)
        {
            return a1.c;
        }

        static String d(a a1)
        {
            return a1.d;
        }

        Uri a()
        {
            return b;
        }

        public volatile ShareMedia.a a(ShareMedia sharemedia)
        {
            return a((SharePhoto)sharemedia);
        }

        public a a(Bitmap bitmap)
        {
            a = bitmap;
            return this;
        }

        public a a(Uri uri)
        {
            b = uri;
            return this;
        }

        public a a(Parcel parcel)
        {
            return a((SharePhoto)parcel.readParcelable(com/facebook/share/model/SharePhoto.getClassLoader()));
        }

        public a a(SharePhoto sharephoto)
        {
            if (sharephoto == null)
            {
                return this;
            } else
            {
                return ((a)super.a(sharephoto)).a(sharephoto.b()).a(sharephoto.c()).a(sharephoto.d()).a(sharephoto.e());
            }
        }

        public a a(String s)
        {
            d = s;
            return this;
        }

        public a a(boolean flag)
        {
            c = flag;
            return this;
        }

        Bitmap b()
        {
            return a;
        }

        public SharePhoto c()
        {
            return new SharePhoto(this);
        }

        public a()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SharePhoto a(Parcel parcel)
        {
            return new SharePhoto(parcel);
        }

        public SharePhoto[] a(int i)
        {
            return new SharePhoto[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private final Bitmap a;
    private final Uri b;
    private final boolean c;
    private final String d;

    SharePhoto(Parcel parcel)
    {
        super(parcel);
        a = (Bitmap)parcel.readParcelable(android/graphics/Bitmap.getClassLoader());
        b = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
        d = parcel.readString();
    }

    private SharePhoto(a a1)
    {
        super(a1);
        a = a.a(a1);
        b = a.b(a1);
        c = a.c(a1);
        d = a.d(a1);
    }


    public Bitmap b()
    {
        return a;
    }

    public Uri c()
    {
        return b;
    }

    public boolean d()
    {
        return c;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return d;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = false;
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(a, 0);
        parcel.writeParcelable(b, 0);
        i = ((flag) ? 1 : 0);
        if (c)
        {
            i = 1;
        }
        parcel.writeByte((byte)i);
        parcel.writeString(d);
    }

}
