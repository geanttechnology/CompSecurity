// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.gs;
import java.util.List;

public final class aak
{

    public final Bundle a;
    public final av b;
    public final ay c;
    public final String d;
    public final ApplicationInfo e;
    public final PackageInfo f;
    public final String g;
    public final String h;
    public final Bundle i;
    public final gs j;
    public final int k;
    public final List l;
    public final Bundle m;
    public final boolean n;

    public aak(Bundle bundle, av av, ay ay, String s, ApplicationInfo applicationinfo, PackageInfo packageinfo, String s1, 
            String s2, gs gs, Bundle bundle1, List list, Bundle bundle2, boolean flag)
    {
        a = bundle;
        b = av;
        c = ay;
        d = s;
        e = applicationinfo;
        f = packageinfo;
        g = s1;
        h = s2;
        j = gs;
        i = bundle1;
        n = flag;
        if (list != null && list.size() > 0)
        {
            k = 2;
            l = list;
        } else
        {
            k = 0;
            l = null;
        }
        m = bundle2;
    }
}
