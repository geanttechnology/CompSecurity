// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ab;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.ad;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import java.nio.ByteBuffer;
import myobfuscated.p.b;
import myobfuscated.p.d;
import myobfuscated.p.e;
import myobfuscated.s.g;
import myobfuscated.s.j;

// Referenced classes of package myobfuscated.ab:
//            b, c, d, g

public final class a
    implements f
{

    private static final myobfuscated.ab.b a = new myobfuscated.ab.b();
    private static c b = com.bumptech.glide.load.c.a("com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.DisableAnimation", Boolean.valueOf(false));
    private static final myobfuscated.ab.c c = new myobfuscated.ab.c();
    private final Context d;
    private final myobfuscated.ab.c e;
    private final g f;
    private final b g;

    public a(Context context, g g1, myobfuscated.s.b b1)
    {
        this(context, g1, b1, c, a);
    }

    private a(Context context, g g1, myobfuscated.s.b b1, myobfuscated.ab.c c1, myobfuscated.ab.b b2)
    {
        d = context;
        f = g1;
        g = new b(g1, b1);
        e = c1;
    }

    private myobfuscated.ab.g a(ByteBuffer bytebuffer, int i, int k)
    {
        Object obj1;
        e e1;
        obj1 = null;
        e1 = e.a(bytebuffer);
        long l1;
        l1 = myobfuscated.aj.f.a();
        if (e1.b == null)
        {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        break MISSING_BLOCK_LABEL_48;
        bytebuffer;
        e.a(e1);
        throw bytebuffer;
        Object obj2;
        if (!e1.c())
        {
            e1.b();
            if (!e1.c())
            {
                e1.a();
                if (e1.c.c < 0)
                {
                    e1.c.b = 1;
                }
            }
        }
        obj2 = e1.c;
        Object obj = obj1;
        if (((d) (obj2)).c <= 0) goto _L2; else goto _L1
_L1:
        int l = ((d) (obj2)).b;
        if (l == 0) goto _L4; else goto _L3
_L3:
        obj = obj1;
_L2:
        e.a(e1);
        return ((myobfuscated.ab.g) (obj));
_L4:
        l = Math.min(((d) (obj2)).g / k, ((d) (obj2)).f / i);
        if (l != 0)
        {
            break MISSING_BLOCK_LABEL_353;
        }
        l = 0;
_L6:
        l = Math.max(1, l);
        if (Log.isLoggable("BufferGifDecoder", 2))
        {
            (new StringBuilder("Downsampling gif, sampleSize: ")).append(l).append(", target dimens: [").append(i).append("x").append(k).append("], actual dimens: [").append(((d) (obj2)).f).append("x").append(((d) (obj2)).g).append("]");
        }
        bytebuffer = new myobfuscated.p.a(g, ((d) (obj2)), bytebuffer, l);
        bytebuffer.a();
        obj2 = bytebuffer.b();
        obj = obj1;
        if (obj2 == null) goto _L2; else goto _L5
_L5:
        obj = myobfuscated.x.b.a();
        bytebuffer = new myobfuscated.ab.d(d, bytebuffer, f, ((com.bumptech.glide.load.h) (obj)), i, k, ((android.graphics.Bitmap) (obj2)));
        if (Log.isLoggable("BufferGifDecoder", 2))
        {
            (new StringBuilder("Decoded gif from stream in ")).append(myobfuscated.aj.f.a(l1));
        }
        obj = new myobfuscated.ab.g(bytebuffer);
          goto _L2
        l = Integer.highestOneBit(l);
          goto _L6
    }

    public final volatile ad a(Object obj, int i, int k, com.bumptech.glide.load.e e1)
    {
        return a((ByteBuffer)obj, i, k);
    }

    public final boolean a(Object obj, com.bumptech.glide.load.e e1)
    {
        obj = (ByteBuffer)obj;
        j j1 = new j();
        return !((Boolean)e1.a(b)).booleanValue() && (new ImageHeaderParser(((ByteBuffer) (obj)), j1)).a() == com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType.GIF;
    }

}
