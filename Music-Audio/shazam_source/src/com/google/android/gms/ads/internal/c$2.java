// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.be;
import com.google.android.gms.d.bf;
import com.google.android.gms.d.bi;
import com.google.android.gms.d.fb;
import com.google.android.gms.d.gm;
import com.google.android.gms.d.he;

// Referenced classes of package com.google.android.gms.ads.internal:
//            c, q, p, e

final class b
    implements Runnable
{

    final com.google.android.gms.d. a;
    final be b;
    final c c;

    public final void run()
    {
        if (a.b.s && c.c.x != null)
        {
            Object obj = null;
            if (a.b.b != null)
            {
                p.e();
                obj = gm.a(a.b.b);
            }
            obj = new bf(c, ((String) (obj)), a.b.c);
            c.c.C = 1;
            try
            {
                c.c.x.a(((com.google.android.gms.d.bh) (obj)));
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
            }
        }
        Object obj1 = new e();
        he he1 = c.a(a, ((e) (obj1)));
        obj1.a = new <init>(a, he1);
        he1.setOnTouchListener(new android.view.View.OnTouchListener(((e) (obj1))) {

            final e a;
            final c._cls2 b;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                a.b = true;
                return false;
            }

            
            {
                b = c._cls2.this;
                a = e1;
                super();
            }
        });
        he1.setOnClickListener(new android.view.View.OnClickListener(((e) (obj1))) {

            final e a;
            final c._cls2 b;

            public final void onClick(View view)
            {
                a.b = true;
            }

            
            {
                b = c._cls2.this;
                a = e1;
                super();
            }
        });
        c.c.C = 0;
        obj1 = c.c;
        p.d();
        obj1.h = fb.a(c.c.c, c, a, c.c.d, he1, c.g, c, b);
    }

    _cls2.a(c c1, com.google.android.gms.d. , be be)
    {
        c = c1;
        a = ;
        b = be;
        super();
    }
}
