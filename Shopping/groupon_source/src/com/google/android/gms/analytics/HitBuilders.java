// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics:
//            zzc

public class HitBuilders
{
    public static class EventBuilder extends HitBuilder
    {

        public volatile Map build()
        {
            return super.build();
        }

        public EventBuilder setAction(String s)
        {
            set("&ea", s);
            return this;
        }

        public EventBuilder setCategory(String s)
        {
            set("&ec", s);
            return this;
        }

        public EventBuilder setLabel(String s)
        {
            set("&el", s);
            return this;
        }

        public EventBuilder setValue(long l)
        {
            set("&ev", Long.toString(l));
            return this;
        }

        public EventBuilder()
        {
            set("&t", "event");
        }
    }

    protected static class HitBuilder
    {

        private Map zzIB;
        ProductAction zzIC;
        Map zzID;
        List zzIE;
        List zzIF;

        public Map build()
        {
            HashMap hashmap = new HashMap(zzIB);
            if (zzIC != null)
            {
                hashmap.putAll(zzIC.build());
            }
            Iterator iterator = zzIE.iterator();
            for (int i = 1; iterator.hasNext(); i++)
            {
                hashmap.putAll(((Promotion)iterator.next()).zzaQ(zzc.zzT(i)));
            }

            iterator = zzIF.iterator();
            for (int j = 1; iterator.hasNext(); j++)
            {
                hashmap.putAll(((Product)iterator.next()).zzaQ(zzc.zzR(j)));
            }

            iterator = zzID.entrySet().iterator();
            for (int k = 1; iterator.hasNext(); k++)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                Object obj = (List)entry.getValue();
                String s = zzc.zzW(k);
                obj = ((List) (obj)).iterator();
                for (int l = 1; ((Iterator) (obj)).hasNext(); l++)
                {
                    hashmap.putAll(((Product)((Iterator) (obj)).next()).zzaQ((new StringBuilder()).append(s).append(zzc.zzV(l)).toString()));
                }

                if (!TextUtils.isEmpty((CharSequence)entry.getKey()))
                {
                    hashmap.put((new StringBuilder()).append(s).append("nm").toString(), entry.getKey());
                }
            }

            return hashmap;
        }

        public final HitBuilder set(String s, String s1)
        {
            if (s != null)
            {
                zzIB.put(s, s1);
                return this;
            } else
            {
                zzae.zzaC(" HitBuilder.set() called with a null paramName.");
                return this;
            }
        }

        protected HitBuilder()
        {
            zzIB = new HashMap();
            zzID = new HashMap();
            zzIE = new ArrayList();
            zzIF = new ArrayList();
        }
    }

    public static class ScreenViewBuilder extends HitBuilder
    {

        public volatile Map build()
        {
            return super.build();
        }

        public ScreenViewBuilder()
        {
            set("&t", "screenview");
        }
    }

}
