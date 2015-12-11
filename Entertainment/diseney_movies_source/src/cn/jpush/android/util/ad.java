// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import org.json.JSONArray;

// Referenced classes of package cn.jpush.android.util:
//            ac

final class ad
    implements Runnable
{

    Context a;
    JSONArray b;

    public ad(Context context, JSONArray jsonarray)
    {
        a = context;
        b = jsonarray;
    }

    public final void run()
    {
        ac.b(a, b);
    }
}
