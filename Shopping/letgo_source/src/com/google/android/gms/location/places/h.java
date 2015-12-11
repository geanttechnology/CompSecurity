// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.location.places.internal.j;

// Referenced classes of package com.google.android.gms.location.places:
//            m, g

public class h extends com.google.android.gms.common.data.a
    implements g
{
    public static class a
    {

        static int a(int i)
        {
            switch (i)
            {
            default:
                throw new IllegalArgumentException((new StringBuilder()).append("invalid source: ").append(i).toString());

            case 100: // 'd'
            case 101: // 'e'
            case 102: // 'f'
            case 103: // 'g'
            case 104: // 'h'
            case 105: // 'i'
                return i;
            }
        }
    }


    private final String b;
    private final Context c;
    private final int d;
    private final Status e;

    public h(DataHolder dataholder, int i, Context context)
    {
        super(dataholder);
        c = context;
        e = m.c(dataholder.e());
        d = com.google.android.gms.location.places.a.a(i);
        if (dataholder != null && dataholder.f() != null)
        {
            b = dataholder.f().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
            return;
        } else
        {
            b = null;
            return;
        }
    }

    public Status a()
    {
        return e;
    }

    public Object a(int i)
    {
        return b(i);
    }

    public com.google.android.gms.location.places.g b(int i)
    {
        return new j(a, i, c);
    }

    public String toString()
    {
        return w.a(this).a("status", a()).a("attributions", b).toString();
    }
}
