// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.os.Handler;
import android.widget.TextView;
import com.j.a.e.j;
import com.j.a.f.b;
import com.j.a.f.d;
import com.j.a.g.w;
import org.json.JSONObject;

// Referenced classes of package com.j.a.d:
//            r, p, ag, u

class t
    implements j
{

    final r a;

    t(r r1)
    {
        a = r1;
        super();
    }

    public void a(Exception exception)
    {
        com.j.a.d.ag.b(a.f.a, false);
        a.d.setText("There has been an error uploading your view.");
        a.a.setText("Please try again.");
        exception = new u(this);
        a.e.postDelayed(exception, 1700L);
    }

    public void a(JSONObject jsonobject)
    {
        w.a("Sent view to server.");
        a.d.setText(b.a(com.j.a.d.ag.d(a.f.a)));
        a.a.setText(b.b(com.j.a.d.ag.d(a.f.a)));
        ag.e(a.f.a).a();
        ag.a(a.f.a, false);
        com.j.a.d.ag.b(a.f.a, false);
    }
}
