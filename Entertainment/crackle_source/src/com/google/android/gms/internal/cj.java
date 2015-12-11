// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            cw, at, bc, aw, 
//            v, au, x

public final class cj
{

    public final int errorCode;
    public final List fK;
    public final List fL;
    public final long fO;
    public final cw gJ;
    public final at gb;
    public final bc gc;
    public final String gd;
    public final aw ge;
    public final List hA;
    public final v hr;
    public final String hu;
    public final long hx;
    public final boolean hy;
    public final long hz;
    public final au is;
    public final x it;
    public final int orientation;

    public cj(v v, cw cw, List list, int i, List list1, List list2, int j, 
            long l, String s, boolean flag, at at, bc bc, String s1, 
            au au, aw aw, long l1, x x, long l2)
    {
        hr = v;
        gJ = cw;
        if (list != null)
        {
            v = Collections.unmodifiableList(list);
        } else
        {
            v = null;
        }
        fK = v;
        errorCode = i;
        if (list1 != null)
        {
            v = Collections.unmodifiableList(list1);
        } else
        {
            v = null;
        }
        fL = v;
        if (list2 != null)
        {
            v = Collections.unmodifiableList(list2);
        } else
        {
            v = null;
        }
        hA = v;
        orientation = j;
        fO = l;
        hu = s;
        hy = flag;
        gb = at;
        gc = bc;
        gd = s1;
        is = au;
        ge = aw;
        hz = l1;
        it = x;
        hx = l2;
    }
}
