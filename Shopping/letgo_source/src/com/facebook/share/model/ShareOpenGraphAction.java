// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Parcel;

// Referenced classes of package com.facebook.share.model:
//            ShareOpenGraphValueContainer

public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer
{
    public static final class a extends ShareOpenGraphValueContainer.a
    {

        public a a(Parcel parcel)
        {
            return a((ShareOpenGraphAction)parcel.readParcelable(com/facebook/share/model/ShareOpenGraphAction.getClassLoader()));
        }

        public a a(ShareOpenGraphAction shareopengraphaction)
        {
            if (shareopengraphaction == null)
            {
                return this;
            } else
            {
                return ((a)super.a(shareopengraphaction)).a(shareopengraphaction.a());
            }
        }

        public a a(String s)
        {
            a("og:type", s);
            return this;
        }

        public ShareOpenGraphAction a()
        {
            return new ShareOpenGraphAction(this);
        }

        public volatile ShareOpenGraphValueContainer.a a(ShareOpenGraphValueContainer shareopengraphvaluecontainer)
        {
            return a((ShareOpenGraphAction)shareopengraphvaluecontainer);
        }

        public a()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShareOpenGraphAction a(Parcel parcel)
        {
            return new ShareOpenGraphAction(parcel);
        }

        public ShareOpenGraphAction[] a(int i)
        {
            return new ShareOpenGraphAction[i];
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

    ShareOpenGraphAction(Parcel parcel)
    {
        super(parcel);
    }

    private ShareOpenGraphAction(a a1)
    {
        super(a1);
    }


    public String a()
    {
        return b("og:type");
    }

}
