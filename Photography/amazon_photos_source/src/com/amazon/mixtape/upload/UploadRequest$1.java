// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.upload;

import android.net.Uri;
import android.os.Parcel;

// Referenced classes of package com.amazon.mixtape.upload:
//            UploadRequest

static final class 
    implements android.os.or
{

    public UploadRequest createFromParcel(Parcel parcel)
    {
        String s1 = parcel.readString();
        String s2 = parcel.readString();
        Uri uri = Uri.parse(parcel.readString());
        long l = parcel.readLong();
        int i = parcel.readInt();
        String s;
        boolean flag;
        boolean flag1;
        if (parcel.readByte() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (parcel.readByte() > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (parcel.readByte() > 0)
        {
            s = parcel.readString();
        } else
        {
            s = null;
        }
        if (parcel.readByte() > 0)
        {
            parcel = parcel.readString();
        } else
        {
            parcel = null;
        }
        return new UploadRequest(-1, s1, s2, parcel, uri, l, s, null, flag, flag1, i, 0, 0, UploadRequest.NO_BLOCKERS, null, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public UploadRequest[] newArray(int i)
    {
        return new UploadRequest[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
