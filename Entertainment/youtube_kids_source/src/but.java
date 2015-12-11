// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class but
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new buu();
    final amy a;
    private List b;

    but(amy amy1)
    {
        boolean flag1 = true;
        super();
        a = (amy)b.a(amy1);
        b.a(amy1.b);
        boolean flag;
        if (buy.a(amy1.d) != buy.c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        if (amy1.c.length > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        b.b(flag);
    }

    private buy a()
    {
        return buy.a(a.d);
    }

    private List b()
    {
        int ai[] = a.j;
        ArrayList arraylist = new ArrayList();
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            arraylist.add(Integer.valueOf(ai[i]));
        }

        return Collections.unmodifiableList(arraylist);
    }

    private List c()
    {
        return Collections.unmodifiableList(Arrays.asList(a.c));
    }

    private List d()
    {
        b = new ArrayList();
        String as[] = a.f;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            b.add(Uri.parse(s));
        }

        return Collections.unmodifiableList(b);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != null && getClass().equals(obj.getClass()))
        {
            obj = (but)obj;
            if (b.a(Integer.valueOf(a.i), Integer.valueOf(((but) (obj)).a.i)) && b.a(a(), ((but) (obj)).a()) && b.a(b(), ((but) (obj)).b()) && b.a(a.b, ((but) (obj)).a.b) && b.a(c(), ((but) (obj)).c()) && b.a(d(), ((but) (obj)).d()) && b.a(a.g, ((but) (obj)).a.g) && b.a(Integer.valueOf(a.h), Integer.valueOf(((but) (obj)).a.h)))
            {
                return true;
            }
        }
        return false;
    }

    public final String toString()
    {
        String s = String.valueOf(a());
        String s1 = a.b;
        String s2 = String.valueOf(c());
        return (new StringBuilder(String.valueOf(s).length() + 38 + String.valueOf(s1).length() + String.valueOf(s2).length())).append("Question [type: ").append(s).append("question:\"").append(s1).append("\" answers: ").append(s2).append("]").toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        a.a(parcel, a);
    }

}
