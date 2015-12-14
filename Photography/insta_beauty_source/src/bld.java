// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.Log;
import com.wantu.imagelib.filter.TImageFilterInfo;
import com.wantu.imagelib.filter.TLightingFilterManager;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.HashMap;

public class bld
{

    static final boolean a;

    public bld()
    {
    }

    public static bmx a(Context context, String s)
    {
        HashMap hashmap = new HashMap();
        Object obj = null;
        Log.v("ImageNetGLFilterMapping", s);
        TImageFilterInfo timagefilterinfo = (new TLightingFilterManager()).imageFilterInfoWithName(s);
        if (timagefilterinfo != null)
        {
            obj = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.NET_EXBLEND;
            Log.v("ImageNetGLFilterMapping blendMode\uFF1A", String.format("%d", new Object[] {
                Integer.valueOf(timagefilterinfo.BlendMode)
            }));
            hashmap.put("blendMode", Integer.valueOf(timagefilterinfo.BlendMode));
            hashmap.put("opacity", Float.valueOf(timagefilterinfo.opacity));
            s = ((String) (obj));
            if (timagefilterinfo.frameUrl != null)
            {
                int i = timagefilterinfo.frameUrl.lastIndexOf("/");
                s = timagefilterinfo.frameUrl.substring(i + 1);
                Log.v("ImageNetGLFilterMapping", s);
                hashmap.put("blendImagePath", s);
                s = ((String) (obj));
            }
        } else
        {
            s = ((String) (obj));
            if (!a)
            {
                throw new AssertionError();
            }
        }
        obj = s;
        if (s == null)
        {
            obj = com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE;
        }
        return ImageFilterFactory.a(context, ((com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE) (obj)), hashmap);
    }

    static 
    {
        boolean flag;
        if (!bld.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
