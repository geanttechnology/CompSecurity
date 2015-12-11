// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;

// Referenced classes of package com.facebook.share.model:
//            ShareModel

public abstract class ShareOpenGraphValueContainer
    implements ShareModel
{
    public static abstract class Builder
    {

        private Bundle bundle;

        public Builder putString(String s, String s1)
        {
            bundle.putString(s, s1);
            return this;
        }

        public Builder readFrom(ShareOpenGraphValueContainer shareopengraphvaluecontainer)
        {
            if (shareopengraphvaluecontainer != null)
            {
                bundle.putAll(shareopengraphvaluecontainer.getBundle());
            }
            return this;
        }


        public Builder()
        {
            bundle = new Bundle();
        }
    }


    private final Bundle bundle;

    ShareOpenGraphValueContainer(Parcel parcel)
    {
        bundle = parcel.readBundle(com/facebook/share/model/ShareOpenGraphValueContainer$Builder.getClassLoader());
    }

    protected ShareOpenGraphValueContainer(Builder builder)
    {
        bundle = (Bundle)builder.bundle.clone();
    }

    public int describeContents()
    {
        return 0;
    }

    public Bundle getBundle()
    {
        return (Bundle)bundle.clone();
    }

    public String getString(String s)
    {
        return bundle.getString(s);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeBundle(bundle);
    }
}
