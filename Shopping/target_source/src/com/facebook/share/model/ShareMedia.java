// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;

// Referenced classes of package com.facebook.share.model:
//            ShareModel

public abstract class ShareMedia
    implements ShareModel
{
    public static abstract class a
    {

        private Bundle a;

        static Bundle a(a a1)
        {
            return a1.a;
        }

        public a a(Bundle bundle)
        {
            a.putAll(bundle);
            return this;
        }

        public a a(ShareMedia sharemedia)
        {
            if (sharemedia == null)
            {
                return this;
            } else
            {
                return a(sharemedia.a());
            }
        }

        public a()
        {
            a = new Bundle();
        }
    }


    private final Bundle a;

    ShareMedia(Parcel parcel)
    {
        a = parcel.readBundle();
    }

    protected ShareMedia(a a1)
    {
        a = new Bundle(a.a(a1));
    }

    public Bundle a()
    {
        return new Bundle(a);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeBundle(a);
    }
}
