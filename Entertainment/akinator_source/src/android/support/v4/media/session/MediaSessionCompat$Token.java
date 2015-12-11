// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.support.v4.media.session:
//            MediaSessionCompat, MediaSessionCompatApi21

public static final class mInner
    implements Parcelable
{

    public static final android.os.iaSessionCompat.Token.mInner CREATOR = new _cls1();
    private final Object mInner;

    public static mInner fromToken(Object obj)
    {
        if (obj == null || android.os.iaSessionCompat.Token < 21)
        {
            return null;
        } else
        {
            return new <init>(MediaSessionCompatApi21.verifyToken(obj));
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public Object getToken()
    {
        return mInner;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (android.os.iaSessionCompat.Token >= 21)
        {
            parcel.writeParcelable((Parcelable)mInner, i);
            return;
        } else
        {
            parcel.writeStrongBinder((IBinder)mInner);
            return;
        }
    }


    _cls1(Object obj)
    {
        mInner = obj;
    }

    /* block-local class not found */
    class _cls1 {}

}
