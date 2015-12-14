// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import com.fotoable.geocoderlib.enums.GeocodingLanguage;
import com.fotoable.geocoderlib.enums.GeocodingTypes;
import java.util.ArrayList;

public class aov
{

    static final boolean a;
    private aos b;
    private String c;
    private String d;
    private aor e;
    private boolean f;
    private final Context g;
    private ProgressDialog h;
    private boolean i;
    private ArrayList j;

    public aov(Context context, aor aor1)
    {
        f = false;
        i = false;
        j = new ArrayList();
        g = context;
        e = aor1;
    }

    static ProgressDialog a(aov aov1, ProgressDialog progressdialog)
    {
        aov1.h = progressdialog;
        return progressdialog;
    }

    static String a(aov aov1)
    {
        return aov1.c;
    }

    static boolean a(aov aov1, boolean flag)
    {
        aov1.i = flag;
        return flag;
    }

    static aos b(aov aov1)
    {
        return aov1.b;
    }

    static aor c(aov aov1)
    {
        return aov1.e;
    }

    static ArrayList d(aov aov1)
    {
        return aov1.j;
    }

    static String e(aov aov1)
    {
        return aov1.d;
    }

    static boolean f(aov aov1)
    {
        return aov1.f;
    }

    static Context g(aov aov1)
    {
        return aov1.g;
    }

    static ProgressDialog h(aov aov1)
    {
        return aov1.h;
    }

    static boolean i(aov aov1)
    {
        return aov1.i;
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
            b = new aos();
            b.a(GeocodingLanguage.EN);
            b.a(GeocodingTypes.STREET_NUMBER);
            b.a(GeocodingTypes.STREET_ADDRESS);
        }
        c = aop.a(b).replace("{address_or_latlng}", (new StringBuilder()).append(d1).append(",").append(d2).toString()).replace(" ", "+");
        Log.d("url", c);
        (new aox(this, null)).execute(new Void[0]);
    }

    public void a(aos aos1)
    {
        b = aos1;
    }

    static 
    {
        boolean flag;
        if (!aov.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
