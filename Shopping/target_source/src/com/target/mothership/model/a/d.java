// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.a;

import com.target.mothership.model.a.c.a;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.a:
//            a

public class d
    implements com.target.mothership.model.a.a
{

    public d()
    {
    }

    public void a(com.target.mothership.model.d d1)
    {
        ArrayList arraylist = new ArrayList();
        a a1 = new a() {

            final d this$0;

            public int a()
            {
                return 101;
            }

            public String b()
            {
                return "babies";
            }

            public String c()
            {
                return "babies";
            }

            
            {
                this$0 = d.this;
                super();
            }
        };
        a a2 = new a() {

            final d this$0;

            public int a()
            {
                return 201;
            }

            public String b()
            {
                return "electronics";
            }

            public String c()
            {
                return "electronics";
            }

            
            {
                this$0 = d.this;
                super();
            }
        };
        a a3 = new a() {

            final d this$0;

            public int a()
            {
                return 301;
            }

            public String b()
            {
                return "furniture";
            }

            public String c()
            {
                return "furniture";
            }

            
            {
                this$0 = d.this;
                super();
            }
        };
        arraylist.add(a1);
        arraylist.add(a2);
        arraylist.add(a3);
        d1.a(arraylist);
    }
}
