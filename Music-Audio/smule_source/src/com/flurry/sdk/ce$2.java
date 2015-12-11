// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import android.widget.Toast;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            ce, gk, gd, fp, 
//            cd, cv

class it>
    implements it>
{

    final cd a;
    final ce b;

    public volatile void a(gk gk1, Object obj)
    {
        a(gk1, (Void)obj);
    }

    public void a(gk gk1, Void void1)
    {
        gd.a(3, ce.a(), (new StringBuilder()).append("AsyncReportInfo request: HTTP status code is:").append(gk1.e()).toString());
        int i = gk1.e();
        if (i >= 200 && i < 300)
        {
            gd.a(3, ce.a(), (new StringBuilder()).append("Send report successful to url: ").append(gk1.a()).toString());
            ce.a(b, a);
            if (gd.c() <= 3 && gd.d())
            {
                fp.a().a(new Runnable(gk1) {

                    final gk a;
                    final ce._cls2 b;

                    public void run()
                    {
                        Toast.makeText(fp.a().c(), (new StringBuilder()).append("ADS AR HTTP Response Code: ").append(a.e()).append(" for url: ").append(a.a()).toString(), 1).show();
                    }

            
            {
                b = ce._cls2.this;
                a = gk1;
                super();
            }
                });
            }
            ce.a(b, a, i);
        } else
        {
            if (i >= 300 && i < 400)
            {
                Object obj = null;
                List list = gk1.b("Location");
                void1 = obj;
                if (list != null)
                {
                    void1 = obj;
                    if (list.size() > 0)
                    {
                        void1 = cv.b((String)list.get(0), a.h());
                    }
                }
                if (TextUtils.isEmpty(void1))
                {
                    gd.a(3, ce.a(), (new StringBuilder()).append("Send report successful to url: ").append(gk1.a()).toString());
                    ce.b(b, a);
                    if (gd.c() <= 3 && gd.d())
                    {
                        fp.a().a(new Runnable(gk1) {

                            final gk a;
                            final ce._cls2 b;

                            public void run()
                            {
                                Toast.makeText(fp.a().c(), (new StringBuilder()).append("ADS AR HTTP Response Code: ").append(a.e()).append(" for url: ").append(a.a()).toString(), 1).show();
                            }

            
            {
                b = ce._cls2.this;
                a = gk1;
                super();
            }
                        });
                    }
                    ce.a(b, a, i);
                    return;
                } else
                {
                    gd.a(3, ce.a(), (new StringBuilder()).append("Send report redirecting to url: ").append(void1).toString());
                    a.c(void1);
                    b.a(a);
                    return;
                }
            }
            gd.a(3, ce.a(), (new StringBuilder()).append("Send report failed to url: ").append(gk1.a()).toString());
            ce.c(b, a);
            if (a.f() == 0)
            {
                ce.a(b, a, i);
                return;
            }
        }
    }

    it>(ce ce1, cd cd1)
    {
        b = ce1;
        a = cd1;
        super();
    }
}
