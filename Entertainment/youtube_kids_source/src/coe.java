// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.net.Uri;
import android.util.SparseArray;

public class coe
    implements coh, cok
{

    final SharedPreferences a;
    final SparseArray b;
    final cok c;

    public coe(cok cok1, SharedPreferences sharedpreferences, SparseArray sparsearray)
    {
        c = (cok)b.a(cok1);
        a = (SharedPreferences)b.a(sharedpreferences);
        b = (SparseArray)b.a(sparsearray);
    }

    public boolean a()
    {
        return c.a();
    }

    public boolean b()
    {
        return c.b();
    }

    public String c()
    {
        return coj.a(a).b;
    }

    public String d()
    {
        return "deviceregistration/v1/devices";
    }

    public Uri e()
    {
        Object obj = cof.a(a);
        SharedPreferences sharedpreferences = a;
        Uri uri = ((cof) (obj)).e;
        obj = uri;
        if (uri.toString().equals("http://127.0.0.1:8787"))
        {
            obj = Uri.parse(sharedpreferences.getString("PPGHost", "http://127.0.0.1:8787"));
        }
        return ((Uri) (obj));
    }

    public byte[] f()
    {
        Object obj = cof.a(a);
        switch (con.a[((cof) (obj)).ordinal()])
        {
        default:
            obj = String.valueOf(obj);
            throw new IllegalArgumentException((new StringBuilder(String.valueOf(obj).length() + 16)).append("Unhandled case: ").append(((String) (obj))).toString());

        case 1: // '\001'
        case 2: // '\002'
            return (byte[])b.get(0);

        case 3: // '\003'
            return (byte[])b.get(1);

        case 4: // '\004'
            return null;
        }
    }

    public boolean g()
    {
        return cof.a(a) == cof.d;
    }
}
