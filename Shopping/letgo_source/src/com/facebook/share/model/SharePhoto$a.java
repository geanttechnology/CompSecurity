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
//            SharePhoto, ShareMedia

public static final class  extends 
{

    private Bitmap a;
    private Uri b;
    private boolean c;
    private String d;

    static Bitmap a( )
    {
        return .a;
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

    static boolean c(EATOR eator)
    {
        return eator.c;
    }

    static String d(c c1)
    {
        return c1.d;
    }

    Uri a()
    {
        return b;
    }

    public volatile b a(ShareMedia sharemedia)
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

    public b a(Parcel parcel)
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

    public d a(boolean flag)
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
        return new SharePhoto(this, null);
    }

    public ()
    {
    }
}
