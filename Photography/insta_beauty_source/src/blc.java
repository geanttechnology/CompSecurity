// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.wantu.piprender.renderengine.filters.BlendMode;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.HashMap;

public class blc
{

    static final boolean a;

    public blc()
    {
    }

    public static bmx a(Context context, String s)
    {
        HashMap hashmap = new HashMap();
        com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE type;
        Object obj;
        if (s.equals("0"))
        {
            type = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE;
        } else
        if (s.equalsIgnoreCase("1"))
        {
            type = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
            hashmap.put("blendMode", Integer.valueOf(BlendMode.SCREEN.ordinal()));
            hashmap.put("blendImagePath", "lightStreamFilter/colorr.jpg");
        } else
        if (s.equalsIgnoreCase("2"))
        {
            type = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
            hashmap.put("blendMode", Integer.valueOf(BlendMode.SCREEN.ordinal()));
            hashmap.put("blendImagePath", "lightStreamFilter/cyborg.jpg");
        } else
        if (s.equalsIgnoreCase("3"))
        {
            type = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
            hashmap.put("blendMode", Integer.valueOf(BlendMode.SCREEN.ordinal()));
            hashmap.put("blendImagePath", "lightStreamFilter/drop.jpg");
        } else
        if (s.equalsIgnoreCase("4"))
        {
            type = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
            hashmap.put("blendMode", Integer.valueOf(BlendMode.OVERLAY.ordinal()));
            hashmap.put("blendImagePath", "lightStreamFilter/burn.jpg");
        } else
        if (s.equalsIgnoreCase("5"))
        {
            type = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
            hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
            hashmap.put("blendImagePath", "lightStreamFilter/sand.jpg");
        } else
        if (s.equalsIgnoreCase("6"))
        {
            type = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
            hashmap.put("blendMode", Integer.valueOf(BlendMode.OVERLAY.ordinal()));
            hashmap.put("blendImagePath", "lightStreamFilter/bocea.jpg");
        } else
        if (s.equalsIgnoreCase("7"))
        {
            type = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
            hashmap.put("blendMode", Integer.valueOf(BlendMode.SCREEN.ordinal()));
            hashmap.put("blendImagePath", "lightStreamFilter/glitter.jpg");
        } else
        if (s.equalsIgnoreCase("8"))
        {
            type = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
            hashmap.put("blendMode", Integer.valueOf(BlendMode.SCREEN.ordinal()));
            hashmap.put("blendImagePath", "lightStreamFilter/twinkle.jpg");
        } else
        if (s.equalsIgnoreCase("9"))
        {
            type = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
            hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
            hashmap.put("blendImagePath", "lightStreamFilter/vignette.jpg");
        } else
        if (s.equalsIgnoreCase("10"))
        {
            type = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
            hashmap.put("blendMode", Integer.valueOf(BlendMode.OVERLAY.ordinal()));
            hashmap.put("opacity", Float.valueOf(1.0F));
            hashmap.put("blendImagePath", "lightStreamFilter/rain.jpg");
        } else
        if (s.equalsIgnoreCase("11"))
        {
            type = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
            hashmap.put("blendMode", Integer.valueOf(BlendMode.SCREEN.ordinal()));
            hashmap.put("opacity", Float.valueOf(0.9F));
            hashmap.put("blendImagePath", "lightStreamFilter/stop.jpg");
        } else
        if (s.equalsIgnoreCase("12"))
        {
            type = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND;
            hashmap.put("blendMode", Integer.valueOf(BlendMode.MULTIPLY.ordinal()));
            hashmap.put("opacity", Float.valueOf(0.9F));
            hashmap.put("blendImagePath", "lightStreamFilter/dirt.jpg");
        } else
        {
            if (!a)
            {
                throw new AssertionError();
            }
            type = null;
        }
        if (type == null)
        {
            s = bld.a(context, s);
            if (s == null)
            {
                type = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE;
            }
        } else
        {
            s = null;
        }
        obj = s;
        if (s == null)
        {
            obj = ImageFilterFactory.a(context, type, hashmap);
        }
        return ((bmx) (obj));
    }

    static 
    {
        boolean flag;
        if (!blc.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
