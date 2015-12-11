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
    public static abstract class Builder
    {

        private Bundle params;

        public Builder readFrom(ShareMedia sharemedia)
        {
            if (sharemedia == null)
            {
                return this;
            } else
            {
                return setParameters(sharemedia.getParameters());
            }
        }

        public Builder setParameters(Bundle bundle)
        {
            params.putAll(bundle);
            return this;
        }


        public Builder()
        {
            params = new Bundle();
        }
    }


    private final Bundle params;

    ShareMedia(Parcel parcel)
    {
        params = parcel.readBundle();
    }

    protected ShareMedia(Builder builder)
    {
        params = new Bundle(builder.params);
    }

    public int describeContents()
    {
        return 0;
    }

    public Bundle getParameters()
    {
        return new Bundle(params);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeBundle(params);
    }
}
