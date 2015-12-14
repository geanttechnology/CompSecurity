// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.wantu.piprender.renderengine.filters.BlendMode;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.HashMap;

public class bls extends blt
{

    private bmx e;
    private bmn f;
    private float g;
    private Handler h;

    public bls(Context context)
    {
        super(context);
        g = 1.0F;
    }

    public void a()
    {
        d.a();
    }

    public void a(float f1)
    {
        if (f == null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("blendMode", Integer.valueOf(BlendMode.NORMAL.ordinal()));
            hashmap.put("blendSrcLocation", Integer.valueOf(0));
            hashmap.put("opacity", Float.valueOf(f1));
            f = (bmn)ImageFilterFactory.a(b, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND, hashmap);
            f.a(c.a, c.b);
            f.a(d);
        } else
        {
            f.a(f1);
        }
        g = f1;
    }

    public void a(int i, int j)
    {
        b(i, j);
        if (e != null)
        {
            e.a(b().a, b().b);
            e.a(c());
        }
        if (f != null)
        {
            f.a(b().a, b().b);
            f.a(c());
        }
    }

    public void a(Handler handler)
    {
        h = handler;
    }

    public void a(bmx bmx1)
    {
        if (e != null)
        {
            e.a();
        }
        e = bmx1;
        if (bmx1 != null)
        {
            bmx1.a(b().a, b().b);
            bmx1.a(c());
        }
    }

    public void b(int i)
    {
        Object obj;
        GLES20.glViewport(0, 0, b().a, b().b);
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        if (g == 1.0F)
        {
            e.c(i);
        } else
        {
            int j = e.c(i);
            f.d(i);
            f.c(j);
        }
        obj = b(0, 0, b().a, b().b);
        if (obj != null) goto _L2; else goto _L1
_L1:
        Log.e("ImageProcessRenderingEngine", "bmp is null");
_L4:
        return;
_L2:
        if (h == null) goto _L4; else goto _L3
_L3:
        obj = Message.obtain(h, 0, obj);
        h.sendMessage(((Message) (obj)));
        return;
        Log.e("ImageProcessRenderingEngine", "no process filter is set");
        return;
    }

    public void b(int i, int j)
    {
        c.a = i;
        c.b = j;
        d = new blu();
        d.a(i, j);
    }
}
