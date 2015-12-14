// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.content.Context;
import android.content.res.AssetManager;
import myobfuscated.q.b;
import myobfuscated.q.i;

// Referenced classes of package myobfuscated.v:
//            ag, b, a, am, 
//            ae

public final class c
    implements ag, myobfuscated.v.b
{

    public c()
    {
    }

    public final b a(AssetManager assetmanager, String s)
    {
        return new i(assetmanager, s);
    }

    public final ae build(Context context, am am)
    {
        return new a(context.getAssets(), this);
    }
}
