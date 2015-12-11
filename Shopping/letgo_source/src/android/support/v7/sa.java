// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            rz, ud, nz

public class sa
    implements rz.a
{

    private final boolean a;
    private final boolean b;

    public sa(boolean flag, boolean flag1)
    {
        a = flag;
        b = flag1;
    }

    public com.google.android.gms.ads.internal.formats.zzh.zza a(rz rz1, JSONObject jsonobject)
        throws JSONException, InterruptedException, ExecutionException
    {
        return b(rz1, jsonobject);
    }

    public zzd b(rz rz1, JSONObject jsonobject)
        throws JSONException, InterruptedException, ExecutionException
    {
        Object obj = rz1.a(jsonobject, "images", true, a, b);
        ud ud1 = rz1.a(jsonobject, "app_icon", true, a);
        rz1 = rz1.b(jsonobject);
        ArrayList arraylist = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((ud)((Iterator) (obj)).next()).get())) { }
        return new zzd(jsonobject.getString("headline"), arraylist, jsonobject.getString("body"), (nz)ud1.get(), jsonobject.getString("call_to_action"), jsonobject.optDouble("rating", -1D), jsonobject.optString("store"), jsonobject.optString("price"), (zza)rz1.get(), new Bundle());
    }
}
