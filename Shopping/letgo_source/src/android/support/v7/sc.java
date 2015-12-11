// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            vk, rz

public class sc
    implements rz.a
{

    private final boolean a;

    public sc(boolean flag)
    {
        a = flag;
    }

    private vk a(vk vk1)
        throws InterruptedException, ExecutionException
    {
        vk vk2 = new vk();
        for (int i = 0; i < vk1.size(); i++)
        {
            vk2.put(vk1.b(i), ((Future)vk1.c(i)).get());
        }

        return vk2;
    }

    private void a(rz rz1, JSONObject jsonobject, vk vk1)
        throws JSONException
    {
        vk1.put(jsonobject.getString("name"), rz1.a(jsonobject, "image_value", a));
    }

    private void a(JSONObject jsonobject, vk vk1)
        throws JSONException
    {
        vk1.put(jsonobject.getString("name"), jsonobject.getString("string_value"));
    }

    public com.google.android.gms.ads.internal.formats.zzh.zza a(rz rz1, JSONObject jsonobject)
        throws JSONException, InterruptedException, ExecutionException
    {
        return b(rz1, jsonobject);
    }

    public zzf b(rz rz1, JSONObject jsonobject)
        throws JSONException, InterruptedException, ExecutionException
    {
        vk vk1 = new vk();
        vk vk2 = new vk();
        ud ud = rz1.b(jsonobject);
        JSONArray jsonarray = jsonobject.getJSONArray("custom_assets");
        int i = 0;
        while (i < jsonarray.length()) 
        {
            JSONObject jsonobject1 = jsonarray.getJSONObject(i);
            String s = jsonobject1.getString("type");
            if ("string".equals(s))
            {
                a(jsonobject1, vk2);
            } else
            if ("image".equals(s))
            {
                a(rz1, jsonobject1, vk1);
            } else
            {
                zzb.zzaE((new StringBuilder()).append("Unknown custom asset type: ").append(s).toString());
            }
            i++;
        }
        return new zzf(jsonobject.getString("custom_template_id"), a(vk1), vk2, (zza)ud.get());
    }
}
