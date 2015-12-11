// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.view.View;
import java.util.Collection;
import java.util.List;

public final class jg
{

    private final a a;
    private final View b;

    public jg(String s, Collection collection, int i, View view, String s1)
    {
        a = new a(s, collection, i, s1);
        b = view;
    }

    public String a()
    {
        return a.a();
    }

    public List b()
    {
        return a.d();
    }

    private class a
        implements SafeParcelable
    {

        public static final adx CREATOR = new adx();
        private final int a;
        private final String b;
        private final List c;
        private final int d;
        private final String e;

        public String a()
        {
            return b;
        }

        public int b()
        {
            return d;
        }

        public String c()
        {
            return e;
        }

        public List d()
        {
            return new ArrayList(c);
        }

        public int describeContents()
        {
            return 0;
        }

        public int e()
        {
            return a;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            adx.a(this, parcel, i);
        }


        public a(int i, String s, List list, int j, String s1)
        {
            c = new ArrayList();
            a = i;
            b = s;
            c.addAll(list);
            d = j;
            e = s1;
        }

        public a(String s, Collection collection, int i, String s1)
        {
            this(3, s, ((List) (new ArrayList(collection))), i, s1);
        }
    }

}
