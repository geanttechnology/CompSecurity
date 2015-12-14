// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.network.h;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WritePostActivity

class a extends m
{

    final h a;
    final WritePostActivity b;

    private void e()
    {
        if (WritePostActivity.B(b) == this)
        {
            WritePostActivity.c(b, null);
        }
    }

    public void a()
    {
        com.perfectcorp.utility.e.b(new Object[] {
            "uploadCoverOri cancelled"
        });
        e();
    }

    public void a(int i)
    {
        com.perfectcorp.utility.e.e(new Object[] {
            "uploadCoverOri error: ", Integer.valueOf(i)
        });
        e();
    }

    protected void a(com.cyberlink.beautycircle.model.network.leResult leresult)
    {
        if (leresult == null || leresult.fileId == null)
        {
            b(0x80000001);
            return;
        } else
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "uploadCoverOri done"
            });
            WritePostActivity.b(b, new com.cyberlink.beautycircle.model.entFile());
            WritePostActivity.A(b).fileId = leresult.fileId;
            WritePostActivity.A(b).metadata = a.f.toString();
            WritePostActivity.s(b);
            e();
            return;
        }
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.leResult)obj);
    }

    lt(WritePostActivity writepostactivity, h h1)
    {
        b = writepostactivity;
        a = h1;
        super();
    }
}
