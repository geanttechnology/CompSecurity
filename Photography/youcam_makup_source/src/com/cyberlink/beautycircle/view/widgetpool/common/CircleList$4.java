// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.SharedPreferences;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            CircleList

final class  extends j
{

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected ArrayList a(Void void1)
    {
        return Model.b(java/lang/Long, Globals.D().getString("LastShareInCircleIds", null));
    }

    ()
    {
    }
}
