// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;

// Referenced classes of package u.aly:
//            a, bi

public class g extends a
{

    private static final String a = "mac";
    private Context b;

    public g(Context context)
    {
        super("mac");
        b = context;
    }

    public String f()
    {
        String s;
        try
        {
            s = bi.p(b);
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }
}
