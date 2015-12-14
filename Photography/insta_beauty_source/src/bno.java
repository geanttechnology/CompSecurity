// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Color;
import com.wantu.piprender.renderengine.filters.BlendMode;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.HashMap;

public class bno extends bmy
{

    public bno()
    {
        a("_fantasy");
    }

    public void a(Context context, HashMap hashmap)
    {
        super.a(context, hashmap);
        a(((bmx) ((bnj)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE, hashmap))));
        hashmap = new HashMap();
        hashmap.put("blendMode", Integer.valueOf(BlendMode.LIGHTEN.ordinal()));
        hashmap.put("blendImagePath", "filterRes/fantasy_res.jpg");
        hashmap.put("opacity", Float.valueOf(0.7F));
        a(((bmx) ((bmn)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND, hashmap))));
        hashmap = new HashMap();
        hashmap.put("blendMode", Integer.valueOf(BlendMode.SCREEN.ordinal()));
        hashmap.put("blendImagePath", "filterRes/fantasy_res.jpg");
        hashmap.put("opacity", Float.valueOf(0.12F));
        a(((bmx) ((bmn)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND, hashmap))));
        hashmap = new HashMap();
        hashmap.put("blendMode", Integer.valueOf(BlendMode.SOFTLIGHT.ordinal()));
        hashmap.put("blendColor", Integer.valueOf(Color.argb(1, 0, 0, 0)));
        hashmap.put("opacity", Float.valueOf(0.18F));
        a(((bmx) ((bmn)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND, hashmap))));
    }
}
