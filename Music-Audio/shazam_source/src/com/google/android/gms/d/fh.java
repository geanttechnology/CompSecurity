// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.a;
import com.google.android.gms.ads.internal.formats.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            fg, ha, bk

public final class fh
    implements fg.a
{

    private final boolean a;
    private final boolean b;

    public fh(boolean flag, boolean flag1)
    {
        a = flag;
        b = flag1;
    }

    public final com.google.android.gms.ads.internal.formats.g.a a(fg fg1, JSONObject jsonobject)
    {
        Object obj = fg1.b(jsonobject, "images", a, b);
        ha ha1 = fg1.a(jsonobject, "app_icon", true, a);
        fg1 = fg1.a(jsonobject);
        ArrayList arraylist = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((ha)((Iterator) (obj)).next()).get())) { }
        return new c(jsonobject.getString("headline"), arraylist, jsonobject.getString("body"), (bk)ha1.get(), jsonobject.getString("call_to_action"), jsonobject.optDouble("rating", -1D), jsonobject.optString("store"), jsonobject.optString("price"), (a)fg1.get(), new Bundle());
    }
}
