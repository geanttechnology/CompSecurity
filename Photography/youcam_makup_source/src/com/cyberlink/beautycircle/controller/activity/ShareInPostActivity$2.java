// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInPostActivity

class a extends m
{

    final ShareInPostActivity a;

    protected void a(CircleBasic circlebasic)
    {
        if (circlebasic != null && ShareInPostActivity.b(a) != null)
        {
            ShareInPostActivity.b(a).setVisibility(0);
            ShareInPostActivity.b(a).setOnClickListener(new android.view.View.OnClickListener(circlebasic) {

                final CircleBasic a;
                final ShareInPostActivity._cls2 b;

                public void onClick(View view)
                {
                    c.a(b.a, a.circleCreatorId, a.id);
                }

            
            {
                b = ShareInPostActivity._cls2.this;
                a = circlebasic;
                super();
            }
            });
        }
    }

    protected void b(Object obj)
    {
        a((CircleBasic)obj);
    }

    _cls1.a(ShareInPostActivity shareinpostactivity)
    {
        a = shareinpostactivity;
        super();
    }
}
