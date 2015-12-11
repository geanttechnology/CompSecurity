// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.AssetManager;

public class nc
{

    private String a;

    public nc()
    {
    }

    public String a(Context context, String s, String s1)
    {
        if (s1 != null)
        {
            if (s1.compareTo(nb.d[0]) == 0)
            {
                a = ni.a(context.getAssets().open("sidemenucards.json"));
                return a;
            }
            if (s1.compareTo(nb.d[1]) == 0)
            {
                a = ni.a(context.getAssets().open("homecards.json"));
                return a;
            }
            if (s1.compareTo(nb.d[2]) == 0)
            {
                a = ni.a(context.getAssets().open("dealscards.json"));
                return a;
            }
            if (s1.compareTo(nb.d[3]) == 0)
            {
                a = ni.a(context.getAssets().open("StoresOutletItems.json"));
                return a;
            }
        }
        return a;
    }
}
