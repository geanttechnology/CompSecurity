// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Typeface;
import java.util.HashMap;
import java.util.Map;

public final class agi extends Enum
{

    public static final agi a;
    public static final agi b;
    public static final agi c;
    public static final agi d;
    private static final Map e = new HashMap();
    private static final agi g[];
    private final String f;

    private agi(String s, int i, String s1)
    {
        super(s, i);
        f = s1;
    }

    public static agi valueOf(String s)
    {
        return (agi)Enum.valueOf(agi, s);
    }

    public static agi[] values()
    {
        return (agi[])g.clone();
    }

    public final Typeface a(Context context)
    {
        b.a();
        if (!e.containsKey(f))
        {
            try
            {
                context = Typeface.createFromAsset(context.getAssets(), f);
                e.put(f, context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                e.put(f, null);
            }
        }
        return (Typeface)e.get(f);
    }

    static 
    {
        a = new agi("ROBOTO_LIGHT", 0, "Roboto2DRAFT-Light.ttf");
        b = new agi("ROBOTO_REGULAR", 1, "Roboto2DRAFT-Regular.ttf");
        c = new agi("ROBOTO_MEDIUM", 2, "Roboto2DRAFT-Medium.ttf");
        d = new agi("ROBOTO_BOLD", 3, "Roboto2DRAFT-Bold.ttf");
        g = (new agi[] {
            a, b, c, d
        });
    }
}
