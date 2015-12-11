// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

// Referenced classes of package com.shazam.android.k:
//            j, b

public abstract class k
{

    public final Uri a;
    Bundle b;
    boolean c;
    j d;
    final BroadcastReceiver e = new BroadcastReceiver() {

        final k a;

        public final void onReceive(Context context, Intent intent)
        {
            (new StringBuilder("Error loading resource Uri: ")).append(a.a.toString());
            (new StringBuilder("Error intent: ")).append(intent.toUri(1));
            a.b = intent.getExtras();
            if (a.d != null)
            {
                a.d.r = false;
                a.d.i();
            }
        }

            
            {
                a = k.this;
                super();
            }
    };

    public k(Uri uri)
    {
        a = uri;
        c = false;
    }

    public abstract b a(Context context);

    public void a(j j)
    {
        d = j;
    }

    public boolean a()
    {
        return b != null;
    }

    public String toString()
    {
        return (new StringBuilder("ResourceRetriever{resourceUri=")).append(a).append('}').toString();
    }
}
