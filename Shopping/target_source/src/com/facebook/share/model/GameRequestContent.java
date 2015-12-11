// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Parcel;
import java.util.List;

// Referenced classes of package com.facebook.share.model:
//            ShareModel

public final class GameRequestContent
    implements ShareModel
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/facebook/share/model/GameRequestContent$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("SEND", 0);
            b = new a("ASKFOR", 1);
            c = new a("TURN", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        private static final b c[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/facebook/share/model/GameRequestContent$b, s);
        }

        public static b[] values()
        {
            return (b[])c.clone();
        }

        static 
        {
            a = new b("APP_USERS", 0);
            b = new b("APP_NON_USERS", 1);
            c = (new b[] {
                a, b
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public GameRequestContent a(Parcel parcel)
        {
            return new GameRequestContent(parcel);
        }

        public GameRequestContent[] a(int i)
        {
            return new GameRequestContent[i];
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
    private final String a;
    private final List b;
    private final String c;
    private final String d;
    private final a e;
    private final String f;
    private final b g;
    private final List h;

    GameRequestContent(Parcel parcel)
    {
        a = parcel.readString();
        b = parcel.createStringArrayList();
        c = parcel.readString();
        d = parcel.readString();
        e = (a)parcel.readSerializable();
        f = parcel.readString();
        g = (b)parcel.readSerializable();
        h = parcel.createStringArrayList();
        parcel.readStringList(h);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
        parcel.writeStringList(b);
        parcel.writeString(c);
        parcel.writeString(d);
        parcel.writeSerializable(e);
        parcel.writeString(f);
        parcel.writeSerializable(g);
        parcel.writeStringList(h);
    }

}
