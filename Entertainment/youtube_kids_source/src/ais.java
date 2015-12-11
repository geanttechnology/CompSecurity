// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ais extends ail
{

    private final ajb n;
    private final chq o;

    public ais(Context context, bje bje, ajb ajb1, ami ami, amq amq, amd amd, chq chq1)
    {
        super(context, bje, bje, ami, amd, amq, chq1);
        n = (ajb)b.a(ajb1);
        o = (chq)b.a(chq1);
    }

    public static boolean a(iz iz1)
    {
        for (iz1 = iz1.g.iterator(); iz1.hasNext();)
        {
            if (((IntentFilter)iz1.next()).hasCategory("MDX_MEDIA_ROUTE_CONTROL_CATEGORY"))
            {
                return true;
            }
        }

        return false;
    }

    protected final Bundle a(ame ame1)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("screen", ame1);
        return bundle;
    }

    public final im a(String s)
    {
        s = (ame)super.i.get(s);
        if (s == null)
        {
            return null;
        } else
        {
            return new ait(n, s, k, o);
        }
    }

    protected final String a()
    {
        return "MDX_MEDIA_ROUTE_CONTROL_CATEGORY";
    }
}
