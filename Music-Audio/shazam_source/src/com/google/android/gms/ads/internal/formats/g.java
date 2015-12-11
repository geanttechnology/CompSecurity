// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import com.google.android.gms.ads.internal.n;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ab;
import com.google.android.gms.d.o;
import org.json.JSONObject;

public class g
{
    public static interface a
    {

        public abstract void a(g g1);

        public abstract String j();

        public abstract String k();
    }


    final n a;
    final JSONObject b;
    final ab c;
    final a d;
    boolean e;
    private final Object f = new Object();
    private final Context g;
    private final o h;
    private final VersionInfoParcel i;

    public g(Context context, n n1, ab ab, o o, JSONObject jsonobject, a a1, VersionInfoParcel versioninfoparcel)
    {
        g = context;
        a = n1;
        c = ab;
        h = o;
        b = jsonobject;
        d = a1;
        i = versioninfoparcel;
    }

    public void a()
    {
        w.b("recordImpression must be called on the main UI thread.");
        e = true;
        a.h();
    }
}
