// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.view.View;
import java.util.Collection;

public final class ClientSettings
{

    public final ParcelableClientSettings a;

    public ClientSettings(String s, Collection collection, int i, View view, String s1)
    {
        a = new ParcelableClientSettings(s, collection, i, s1);
    }

    private class ParcelableClientSettings
        implements SafeParcelable
    {

        public static final axf CREATOR = new axf();
        public final int a;
        public final String b;
        public final int c;
        public final String d;
        private final List e;

        public final List a()
        {
            return new ArrayList(e);
        }

        public final int describeContents()
        {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i)
        {
            axf.a(this, parcel);
        }


        public ParcelableClientSettings(int i, String s, List list, int j, String s1)
        {
            e = new ArrayList();
            a = i;
            b = s;
            e.addAll(list);
            c = j;
            d = s1;
        }

        public ParcelableClientSettings(String s, Collection collection, int i, String s1)
        {
            this(3, s, ((List) (new ArrayList(collection))), i, s1);
        }
    }

}
