// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Typeface;
import java.util.HashMap;
import java.util.Map;

public final class bmc extends Enum
{

    public static final bmc a;
    public static final bmc b;
    public static final bmc c;
    private static final Map d = new HashMap();
    private static final bmc f[];
    private final String e;

    private bmc(String s, int i, String s1)
    {
        super(s, i);
        e = s1;
    }

    public static bmc valueOf(String s)
    {
        return (bmc)Enum.valueOf(bmc, s);
    }

    public static bmc[] values()
    {
        return (bmc[])f.clone();
    }

    public final Typeface a(Context context)
    {
        b.a();
        if (!d.containsKey(e))
        {
            try
            {
                context = Typeface.createFromAsset(context.getAssets(), e);
                d.put(e, context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                d.put(e, null);
            }
        }
        return (Typeface)d.get(e);
    }

    static 
    {
        a = new bmc("ROBOTO_LIGHT", 0, "Roboto-Light.ttf");
        b = new bmc("ROBOTO_REGULAR", 1, "Roboto-Regular.ttf");
        c = new bmc("ROBOTO_MEDIUM", 2, "Roboto-Medium.ttf");
        f = (new bmc[] {
            a, b, c
        });
    }
}
