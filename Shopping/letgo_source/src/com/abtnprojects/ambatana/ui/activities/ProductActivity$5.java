// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.content.res.Resources;
import android.support.v7.akj;
import android.support.v7.aqo;
import android.widget.ImageView;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            ProductActivity

class a
    implements akj
{

    final String a;
    final ProductActivity b;

    public void a()
    {
        aqo.a("Profile Image loaded success", new Object[0]);
    }

    public void b()
    {
        aqo.d("Profile Image loaded error %s", new Object[] {
            a
        });
        b.ivProductOwnerAvatar.setImageDrawable(b.getResources().getDrawable(0x7f02010f));
    }

    (ProductActivity productactivity, String s)
    {
        b = productactivity;
        a = s;
        super();
    }
}
