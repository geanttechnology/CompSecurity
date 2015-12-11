// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.gs;
import java.util.HashSet;
import java.util.List;

class ahk
{

    public final ahj a;
    public final String b;
    public final Context c;
    public final aea d = new aea(new ahp(this));
    public final gs e;
    public tn f;
    public abn g;
    public abn h;
    public ay i;
    public abd j;
    public abe k;
    public abf l;
    public tw m;
    public yv n;
    public yj o;
    public uy p;
    public uz q;
    public um r;
    public List s;
    public ye t;
    public abl u;
    public View v;
    public int w;
    public boolean x;
    public boolean y;
    private HashSet z;

    public ahk(Context context, ay ay1, String s1, gs gs)
    {
        u = null;
        v = null;
        w = 0;
        x = false;
        y = false;
        z = null;
        if (ay1.e)
        {
            a = null;
        } else
        {
            a = new ahj(context);
            a.setMinimumWidth(ay1.g);
            a.setMinimumHeight(ay1.d);
            a.setVisibility(4);
        }
        i = ay1;
        b = s1;
        c = context;
        e = gs;
    }

    public HashSet a()
    {
        return z;
    }

    public void a(HashSet hashset)
    {
        z = hashset;
    }
}
