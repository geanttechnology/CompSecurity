// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            te, ps, tg, pq, 
//            tw

public class px
{

    public px()
    {
    }

    public List a(JSONObject jsonobject, String s)
        throws JSONException
    {
        jsonobject = jsonobject.optJSONArray(s);
        if (jsonobject != null)
        {
            s = new ArrayList(jsonobject.length());
            for (int i = 0; i < jsonobject.length(); i++)
            {
                s.add(jsonobject.getString(i));
            }

            return Collections.unmodifiableList(s);
        } else
        {
            return null;
        }
    }

    public void a(Context context, String s, te te1, String s1, boolean flag, List list)
    {
        if (list != null && !list.isEmpty())
        {
            String s2;
            Iterator iterator;
            if (flag)
            {
                s2 = "1";
            } else
            {
                s2 = "0";
            }
            iterator = list.iterator();
            while (iterator.hasNext()) 
            {
                String s3 = ((String)iterator.next()).replaceAll("@gw_adlocid@", s1).replaceAll("@gw_adnetrefresh@", s2).replaceAll("@gw_qdata@", te1.o.f).replaceAll("@gw_sdkver@", s).replaceAll("@gw_sessid@", zzp.zzbA().a()).replaceAll("@gw_seqnum@", te1.i);
                list = s3;
                if (te1.l != null)
                {
                    list = s3.replaceAll("@gw_adnetid@", te1.l.b).replaceAll("@gw_allocid@", te1.l.d);
                }
                (new tw(context, s, list)).zzgn();
            }
        }
    }
}
