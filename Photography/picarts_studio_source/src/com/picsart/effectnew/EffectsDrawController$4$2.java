// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;

import android.app.Activity;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.view.View;
import com.socialin.android.photo.imgop.ImageOp;
import java.nio.ByteBuffer;
import myobfuscated.ay.e;
import myobfuscated.bb.bp;

// Referenced classes of package com.picsart.effectnew:
//            EffectsDrawController, r

final class a
    implements Runnable
{

    private ByteBuffer a;
    private b b;

    public final void run()
    {
        a.position(0);
        b.b.f.copyPixelsFromBuffer(a);
        e.a(a);
        if (b.b.c != null)
        {
            b.b.c.invalidate();
        }
        EffectsDrawController.a(b.b, false);
    }

    a(a a1, ByteBuffer bytebuffer)
    {
        b = a1;
        a = bytebuffer;
        super();
    }

    // Unreferenced inner class com/picsart/effectnew/EffectsDrawController$4

/* anonymous class */
    final class EffectsDrawController._cls4 extends r
    {

        final EffectsDrawController a;
        private Object e;
        private Activity f;

        public final void run()
        {
            Object obj3;
            Object obj4;
            Bitmap bitmap;
            obj3 = null;
            obj4 = null;
            bitmap = super.b;
            if (!super.c) goto _L2; else goto _L1
_L1:
            if (e == null) goto _L4; else goto _L3
_L3:
            Object obj;
            RenderScript renderscript;
            renderscript = (RenderScript)e;
            obj = new bp(renderscript);
            Object obj1 = Allocation.createFromBitmap(renderscript, a.d);
            Object obj2 = Allocation.createTyped(renderscript, ((Allocation) (obj1)).getType());
            ((Allocation) (obj2)).copyFrom(a.e);
            obj4 = Allocation.createFromBitmap(renderscript, bitmap);
            obj3 = obj4;
            ((bp) (obj)).a(((Allocation) (obj2)), ((Allocation) (obj1)), ((Allocation) (obj3)));
            ((bp) (obj)).a(((Allocation) (obj2)));
            ((bp) (obj)).destroy();
            if (obj1 != null)
            {
                ((Allocation) (obj1)).destroy();
            }
            OutOfMemoryError outofmemoryerror;
            Object obj5;
            boolean flag;
            if (obj3 != null)
            {
                ((Allocation) (obj3)).destroy();
                flag = true;
            } else
            {
                flag = true;
            }
            if (!flag) goto _L4; else goto _L5
_L5:
            if (!super.d) goto _L7; else goto _L6
_L6:
            ((Allocation) (obj2)).copyTo(a.f);
            ((Allocation) (obj2)).destroy();
            if (a.c != null)
            {
                a.c.invalidate();
            }
            EffectsDrawController.a(a, false);
_L2:
            return;
            obj;
            obj = null;
            obj2 = null;
            obj3 = null;
            obj1 = obj4;
_L10:
            if (obj3 != null)
            {
                ((bp) (obj3)).destroy();
            }
            if (obj2 != null)
            {
                ((Allocation) (obj2)).destroy();
            }
            if (obj != null)
            {
                ((Allocation) (obj)).destroy();
                flag = false;
                obj2 = obj1;
            } else
            {
                flag = false;
                obj2 = obj1;
            }
            break MISSING_BLOCK_LABEL_130;
            obj2;
            obj1 = null;
            obj = null;
_L9:
            if (obj != null)
            {
                ((bp) (obj)).destroy();
            }
            if (obj1 != null)
            {
                ((Allocation) (obj1)).destroy();
            }
            if (obj3 != null)
            {
                ((Allocation) (obj3)).destroy();
            }
            throw obj2;
_L7:
            f.runOnUiThread(new EffectsDrawController._cls4._cls1(((Allocation) (obj2))));
            return;
_L4:
            obj = myobfuscated.ay.e.a(a.h * a.i * 4);
            ((ByteBuffer) (obj)).position(0);
            a.d.copyPixelsToBuffer(((java.nio.Buffer) (obj)));
            obj1 = myobfuscated.ay.e.a(a.h * a.i * 4);
            ((ByteBuffer) (obj1)).position();
            bitmap.copyPixelsToBuffer(((java.nio.Buffer) (obj1)));
            obj2 = myobfuscated.ay.e.a(a.h * a.i * 4);
            ((ByteBuffer) (obj2)).position(0);
            a.e.copyPixelsToBuffer(((java.nio.Buffer) (obj2)));
            ImageOp.blend4buf(((java.nio.Buffer) (obj)), ((java.nio.Buffer) (obj2)), ((java.nio.Buffer) (obj1)), 0, a.h, a.i, ((java.nio.Buffer) (obj2)), a.h, a.i);
            myobfuscated.ay.e.a(((ByteBuffer) (obj)));
            myobfuscated.ay.e.a(((ByteBuffer) (obj1)));
            if (super.d)
            {
                ((ByteBuffer) (obj2)).position(0);
                a.f.copyPixelsFromBuffer(((java.nio.Buffer) (obj2)));
                myobfuscated.ay.e.a(((ByteBuffer) (obj2)));
                if (a.c != null)
                {
                    a.c.invalidate();
                }
                EffectsDrawController.a(a, false);
                return;
            } else
            {
                f.runOnUiThread(new EffectsDrawController._cls4._cls2(this, ((ByteBuffer) (obj2))));
                return;
            }
            obj2;
            obj1 = null;
            continue; /* Loop/switch isn't completed */
            obj2;
            continue; /* Loop/switch isn't completed */
            obj2;
            if (true) goto _L9; else goto _L8
_L8:
            obj1;
            obj1 = null;
            obj2 = null;
            obj3 = obj;
            obj = obj1;
            obj1 = obj4;
              goto _L10
            obj2;
            obj5 = null;
            obj2 = obj1;
            obj3 = obj;
            obj = obj5;
            obj1 = obj4;
              goto _L10
            obj3;
            obj5 = null;
            obj3 = obj1;
            obj4 = obj;
            obj = obj5;
            obj1 = obj2;
            obj2 = obj3;
            obj3 = obj4;
              goto _L10
            outofmemoryerror;
            outofmemoryerror = ((OutOfMemoryError) (obj1));
            obj5 = obj;
            obj = obj3;
            obj1 = obj2;
            obj2 = outofmemoryerror;
            obj3 = obj5;
              goto _L10
        }

            
            {
                a = effectsdrawcontroller;
                e = obj;
                f = activity;
                super();
            }

        // Unreferenced inner class com/picsart/effectnew/EffectsDrawController$4$1

/* anonymous class */
        final class EffectsDrawController._cls4._cls1
            implements Runnable
        {

            private Allocation a;
            private EffectsDrawController._cls4 b;

            public final void run()
            {
                a.copyTo(b.a.f);
                a.destroy();
                if (b.a.c != null)
                {
                    b.a.c.invalidate();
                }
                EffectsDrawController.a(b.a, false);
            }

                    
                    {
                        b = EffectsDrawController._cls4.this;
                        a = allocation;
                        super();
                    }
        }

    }

}
