// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.widget.TextView;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.CircleType;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.m;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            CircleEditorActivity

class a extends m
{

    final CircleEditorActivity a;

    protected void a(d d1)
    {
        if (d1 != null && d1.b != null && !d1.b.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j = d1.b.size();
        int i = 0;
        do
        {
            if (i < j)
            {
label0:
                {
                    CircleType circletype = (CircleType)d1.b.get(i);
                    if (circletype == null || !CircleEditorActivity.a(a).circleTypeId.equals(circletype.id) || circletype.defaultType.equals("HOW-TO"))
                    {
                        break label0;
                    }
                    CircleEditorActivity.b(a).circleTypeName = circletype.circleTypeName;
                    CircleEditorActivity.b(a).id = circletype.id;
                    if (CircleEditorActivity.c(a) != null && CircleEditorActivity.b(a) != null)
                    {
                        CircleEditorActivity.c(a).setText(CircleEditorActivity.b(a).circleTypeName);
                        return;
                    }
                }
            }
            if (true)
            {
                continue;
            }
            i++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void b(Object obj)
    {
        a((d)obj);
    }

    (CircleEditorActivity circleeditoractivity)
    {
        a = circleeditoractivity;
        super();
    }
}
