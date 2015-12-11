// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import java.util.Set;

// Referenced classes of package com.facebook.share.model:
//            ShareModel

public abstract class ShareOpenGraphValueContainer
    implements ShareModel
{
    public static abstract class a
    {

        private Bundle a;

        static Bundle a(a a1)
        {
            return a1.a;
        }

        public a a(ShareOpenGraphValueContainer shareopengraphvaluecontainer)
        {
            if (shareopengraphvaluecontainer != null)
            {
                a.putAll(shareopengraphvaluecontainer.b());
            }
            return this;
        }

        public a a(String s, String s1)
        {
            a.putString(s, s1);
            return this;
        }

        public a()
        {
            a = new Bundle();
        }
    }


    private final Bundle a;

    ShareOpenGraphValueContainer(Parcel parcel)
    {
        a = parcel.readBundle(com/facebook/share/model/ShareOpenGraphValueContainer$a.getClassLoader());
    }

    protected ShareOpenGraphValueContainer(a a1)
    {
        a = (Bundle)a.a(a1).clone();
    }

    public Object a(String s)
    {
        return a.get(s);
    }

    public Bundle b()
    {
        return (Bundle)a.clone();
    }

    public String b(String s)
    {
        return a.getString(s);
    }

    public Set c()
    {
        return a.keySet();
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
