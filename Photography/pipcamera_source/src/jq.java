// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import com.fotoable.geocoderlib.enums.GeocodingLanguage;
import com.fotoable.geocoderlib.enums.GeocodingTypes;
import java.util.ArrayList;

public class jq
{

    static final boolean a;
    private jn b;
    private String c;
    private String d;
    private jm e;
    private boolean f;
    private final Context g;
    private ProgressDialog h;
    private boolean i;
    private ArrayList j;

    public jq(Context context, jm jm1)
    {
        f = false;
        i = false;
        j = new ArrayList();
        g = context;
        e = jm1;
    }

    static ProgressDialog a(jq jq1, ProgressDialog progressdialog)
    {
        jq1.h = progressdialog;
        return progressdialog;
    }

    static String a(jq jq1)
    {
        return jq1.c;
    }

    static boolean a(jq jq1, boolean flag)
    {
        jq1.i = flag;
        return flag;
    }

    static jn b(jq jq1)
    {
        return jq1.b;
    }

    static jm c(jq jq1)
    {
        return jq1.e;
    }

    static ArrayList d(jq jq1)
    {
        return jq1.j;
    }

    static String e(jq jq1)
    {
        return jq1.d;
    }

    static boolean f(jq jq1)
    {
        return jq1.f;
    }

    static Context g(jq jq1)
    {
        return jq1.g;
    }

    static ProgressDialog h(jq jq1)
    {
        return jq1.h;
    }

    static boolean i(jq jq1)
    {
        return jq1.i;
    }

    public void a(double d1, double d2)
    {
        if (!a && e == null)
        {
            throw new AssertionError();
        }
        if (d1 == 0.0D || d2 == 0.0D)
        {
            e.a("Address is empty.");
            return;
        }
        if (f && g == null)
        {
            e.a("Context not set.");
            return;
        }
        if (b == null)
        {
            b = new jn();
            b.a(GeocodingLanguage.EN);
            b.a(GeocodingTypes.STREET_NUMBER);
            b.a(GeocodingTypes.STREET_ADDRESS);
        }
        c = jk.a(b).replace("{address_or_latlng}", (new StringBuilder()).append(d1).append(",").append(d2).toString()).replace(" ", "+");
        Log.d("url", c);
        (new jr(this)).execute(new Void[0]);
    }

    public void a(jn jn1)
    {
        b = jn1;
    }

    static 
    {
        boolean flag;
        if (!jq.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
