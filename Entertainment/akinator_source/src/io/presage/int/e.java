// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.int;

import android.content.Context;
import android.content.SharedPreferences;
import io.presage.Presage;
import io.presage.do.d;
import io.presage.utils.do.a;
import io.presage.utils.do.do.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import shared_presage.com.google.gson.Gson;

// Referenced classes of package io.presage.int:
//            b, g

public final class e extends io.presage.int.b
    implements g
{

    private a a;

    public e(String s)
    {
        super(s);
        a = Presage.getInstance().getWS();
    }

    public final void a(b b1)
    {
        Object obj = (List)a().get(c());
        b1 = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); b1.add(new d((Map)((Iterator) (obj)).next()))) { }
        a.a(b1);
        b1 = (new Gson()).toJson(a()).toString();
        obj = Presage.getInstance().getContext().getSharedPreferences("presage", 0).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("filters", b1);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
    }
}
