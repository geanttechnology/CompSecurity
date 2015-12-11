// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.a;

import com.mopub.common.c.a;
import com.mopub.common.f;
import com.mopub.common.m;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mopub.common.a:
//            a, b

public final class g
{

    public g()
    {
    }

    public static JSONArray a(List list)
    {
        JSONArray jsonarray;
        Iterator iterator;
        m.a(list);
        jsonarray = new JSONArray();
        iterator = list.iterator();
_L11:
        com.mopub.common.a.a a1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_776;
        }
        a1 = (com.mopub.common.a.a)iterator.next();
        JSONObject jsonobject;
        m.a(a1);
        jsonobject = new JSONObject();
        jsonobject.put("_category_", a1.a.c);
        jsonobject.put("ts", Long.valueOf(a1.B));
        jsonobject.put("name", a1.b.d);
        jsonobject.put("name_category", a1.c.b);
        list = a1.d;
        if (list != null) goto _L2; else goto _L1
_L1:
        list = null;
_L7:
        jsonobject.put("sdk_product", list);
        jsonobject.put("sdk_version", a1.a());
        jsonobject.put("ad_unit_id", a1.e);
        jsonobject.put("ad_creative_id", a1.f);
        jsonobject.put("ad_type", a1.g);
        jsonobject.put("ad_network_type", a1.h);
        jsonobject.put("ad_width_px", a1.i);
        jsonobject.put("ad_height_px", a1.j);
        list = a.a.c;
        if (list != null) goto _L4; else goto _L3
_L3:
        list = null;
_L8:
        jsonobject.put("app_platform", list);
        jsonobject.put("app_name", a1.b());
        jsonobject.put("app_package_name", a1.c());
        jsonobject.put("app_version", a1.d());
        jsonobject.put("client_advertising_id", "ifa:XXXX");
        int i;
        boolean flag;
        if (a1.C == null || a1.C.d())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        jsonobject.put("client_do_not_track", Boolean.valueOf(flag));
        jsonobject.put("device_manufacturer", a1.e());
        jsonobject.put("device_model", a1.f());
        jsonobject.put("device_product", a1.g());
        jsonobject.put("device_os_version", a1.h());
        jsonobject.put("device_screen_width_px", a1.k);
        jsonobject.put("device_screen_height_px", a1.l);
        jsonobject.put("geo_lat", a1.m);
        jsonobject.put("geo_lon", a1.n);
        jsonobject.put("geo_accuracy_radius_meters", a1.o);
        jsonobject.put("perf_duration_ms", a1.w);
        list = a1.p;
        if (list != null) goto _L6; else goto _L5
_L5:
        list = null;
_L9:
        try
        {
            jsonobject.put("network_type", list);
            jsonobject.put("network_operator_code", a1.q);
            jsonobject.put("network_operator_name", a1.r);
            jsonobject.put("network_iso_country_code", a1.s);
            jsonobject.put("network_sim_code", a1.t);
            jsonobject.put("network_sim_operator_name", a1.u);
            jsonobject.put("network_sim_iso_country_code", a1.v);
            jsonobject.put("req_id", a1.x);
            jsonobject.put("req_status_code", a1.y);
            jsonobject.put("req_uri", a1.z);
            jsonobject.put("req_retries", a1.A);
            jsonobject.put("timestamp_client", Long.valueOf(a1.B));
            if (a1 instanceof b)
            {
                list = (b)a1;
                jsonobject.put("error_exception_class_name", ((b) (list)).E);
                jsonobject.put("error_message", ((b) (list)).F);
                jsonobject.put("error_stack_trace", ((b) (list)).G);
                jsonobject.put("error_file_name", ((b) (list)).H);
                jsonobject.put("error_class_name", ((b) (list)).I);
                jsonobject.put("error_method_name", ((b) (list)).J);
                jsonobject.put("error_line_number", ((b) (list)).K);
            }
            jsonarray.put(jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            com.mopub.common.c.a.b((new StringBuilder("Failed to serialize event \"")).append(a1.b).append("\" to JSON: ").toString(), list);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        list = Integer.valueOf(((a.g) (list)).d);
          goto _L7
_L4:
        list = Integer.valueOf(((a.a) (list)).e);
          goto _L8
_L6:
        i = ((com.mopub.common.f.a) (list)).e;
        list = Integer.valueOf(i);
          goto _L9
        return jsonarray;
        if (true) goto _L11; else goto _L10
_L10:
    }
}
