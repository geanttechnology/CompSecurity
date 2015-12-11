// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.tagmanager:
//            TrackingTag, Types, Log, HitSender, 
//            SharedPreferencesUtil, DelayedHitSender

class ArbitraryPixelTag extends TrackingTag
{
    public static interface HitSenderProvider
    {

        public abstract HitSender get();
    }


    private static final String ADDITIONAL_PARAMS;
    static final String ARBITRARY_PIXEL_UNREPEATABLE;
    private static final String ID;
    private static final String UNREPEATABLE;
    private static final String URL;
    private static final Set unrepeatableIds = new HashSet();
    private final Context mContext;
    private final HitSenderProvider mHitSenderProvider;

    public ArbitraryPixelTag(final Context context)
    {
        this(context, new HitSenderProvider() {

            final Context val$context;

            public HitSender get()
            {
                return DelayedHitSender.getInstance(context);
            }

            
            {
                context = context1;
                super();
            }
        });
    }

    ArbitraryPixelTag(Context context, HitSenderProvider hitsenderprovider)
    {
        super(ID, new String[] {
            URL
        });
        mHitSenderProvider = hitsenderprovider;
        mContext = context;
    }

    public static String getFunctionId()
    {
        return ID;
    }

    private boolean idProcessed(String s)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = idInCache(s);
        if (!flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (idInSharedPreferences(s))
        {
            unrepeatableIds.add(s);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_44;
        s;
        throw s;
        flag = false;
        if (true) goto _L1; else goto _L3
_L3:
    }

    void clearCache()
    {
        unrepeatableIds.clear();
    }

    public void evaluateTrackingTag(Map map)
    {
        String s;
        if (map.get(UNREPEATABLE) != null)
        {
            s = Types.valueToString((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(UNREPEATABLE));
        } else
        {
            s = null;
        }
        if (s == null || !idProcessed(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        android.net.Uri.Builder builder = Uri.parse(Types.valueToString((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(URL))).buildUpon();
        map = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(ADDITIONAL_PARAMS);
        if (map != null)
        {
            map = ((Map) (Types.valueToObject(map)));
            if (!(map instanceof List))
            {
                Log.e((new StringBuilder()).append("ArbitraryPixel: additional params not a list: not sending partial hit: ").append(builder.build().toString()).toString());
                return;
            }
            for (map = ((List)map).iterator(); map.hasNext();)
            {
                Object obj = map.next();
                if (!(obj instanceof Map))
                {
                    Log.e((new StringBuilder()).append("ArbitraryPixel: additional params contains non-map: not sending partial hit: ").append(builder.build().toString()).toString());
                    return;
                }
                obj = ((Map)obj).entrySet().iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                    builder.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                }
            }

        }
        map = builder.build().toString();
        mHitSenderProvider.get().sendHit(map);
        Log.v((new StringBuilder()).append("ArbitraryPixel: url = ").append(map).toString());
        if (s == null) goto _L1; else goto _L3
_L3:
        com/google/tagmanager/ArbitraryPixelTag;
        JVM INSTR monitorenter ;
        unrepeatableIds.add(s);
        SharedPreferencesUtil.saveAsync(mContext, ARBITRARY_PIXEL_UNREPEATABLE, s, "true");
        com/google/tagmanager/ArbitraryPixelTag;
        JVM INSTR monitorexit ;
        return;
        map;
        com/google/tagmanager/ArbitraryPixelTag;
        JVM INSTR monitorexit ;
        throw map;
    }

    boolean idInCache(String s)
    {
        return unrepeatableIds.contains(s);
    }

    boolean idInSharedPreferences(String s)
    {
        return mContext.getSharedPreferences(ARBITRARY_PIXEL_UNREPEATABLE, 0).contains(s);
    }

    static 
    {
        ID = FunctionType.ARBITRARY_PIXEL.toString();
        URL = Key.URL.toString();
        ADDITIONAL_PARAMS = Key.ADDITIONAL_PARAMS.toString();
        UNREPEATABLE = Key.UNREPEATABLE.toString();
        ARBITRARY_PIXEL_UNREPEATABLE = (new StringBuilder()).append("gtm_").append(ID).append("_unrepeatable").toString();
    }
}
