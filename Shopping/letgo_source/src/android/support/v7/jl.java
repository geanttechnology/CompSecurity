// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            p, jg

public class jl extends BroadcastReceiver
{

    private static jl a;
    private Context b;

    private jl(Context context)
    {
        b = context.getApplicationContext();
    }

    public static jl a(Context context)
    {
        if (a != null)
        {
            return a;
        } else
        {
            a = new jl(context);
            a.a();
            return a;
        }
    }

    private void a()
    {
        p.a(b).a(this, new IntentFilter("com.parse.bolts.measurement_event"));
    }

    private void b()
    {
        p.a(b).a(this);
    }

    protected void finalize()
        throws Throwable
    {
        b();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public void onReceive(Context context, Intent intent)
    {
        context = jg.b(context);
        String s = (new StringBuilder()).append("bf_").append(intent.getStringExtra("event_name")).toString();
        intent = intent.getBundleExtra("event_args");
        Bundle bundle = new Bundle();
        String s1;
        for (Iterator iterator = intent.keySet().iterator(); iterator.hasNext(); bundle.putString(s1.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String)intent.get(s1)))
        {
            s1 = (String)iterator.next();
        }

        context.a(s, bundle);
    }
}
