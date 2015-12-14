// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.state;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.socialin.android.brushlib.b;
import com.socialin.android.brushlib.brush.Brush;
import com.socialin.android.brushlib.controller.ShapeOverlayController;
import com.socialin.android.brushlib.controller.e;
import com.socialin.android.brushlib.layer.BlendMode;
import com.socialin.android.brushlib.layer.CameraMaskLayer;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.view.Camera;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.d;
import com.socialin.android.util.w;
import com.socialin.android.videogenerator.ActionCollector;
import com.socialin.android.videogenerator.actions.LayerAdditionAction;
import com.socialin.android.videogenerator.actions.LayerRemoveAction;
import com.socialin.android.videogenerator.actions.LayersMoveAction;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import myobfuscated.br.c;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.brushlib.state:
//            b, LayerMetaInfo, Snapshot

public class a
    implements c
{

    private static final Paint m = new Paint(2);
    private static final String n = com/socialin/android/brushlib/state/a.getSimpleName();
    private static final Bitmap o;
    private static final Canvas p;
    public List a;
    public com.socialin.android.brushlib.layer.b b;
    public com.socialin.android.brushlib.a c;
    public final int d;
    public final int e;
    public final myobfuscated.br.a f;
    public final DrawingView g;
    public com.socialin.android.brushlib.view.DrawingView.DrawingMode h;
    public com.socialin.android.brushlib.view.DrawingView.EditingMode i;
    public CameraMaskLayer j;
    public Project k;
    public boolean l;
    private final Set q;

    public a(DrawingView drawingview, Project project, int i1, int j1)
    {
        a = new ArrayList();
        q = new HashSet();
        g = drawingview;
        k = project;
        f = new myobfuscated.br.a(drawingview);
        d = i1;
        e = j1;
        i();
    }

    public a(DrawingView drawingview, Project project, int i1, int j1, myobfuscated.br.e e1)
    {
        a = new ArrayList();
        q = new HashSet();
        g = drawingview;
        k = project;
        f = new myobfuscated.br.a(drawingview, e1);
        d = i1;
        e = j1;
        i();
    }

    static DrawingView a(a a1)
    {
        return a1.g;
    }

    private void i()
    {
        ActionCollector.a().a(k.getActionsFile(), k.getActionsInfoFile(), k.containsActions());
        f.f.add(this);
        f.a(new myobfuscated.br.b() {

            private a a;

            public final void a(myobfuscated.br.a a1)
            {
                a.a(a).a(true);
            }

            
            {
                a = a.this;
                super();
            }
        });
        l = true;
    }

    public final CameraMaskLayer a(com.socialin.android.brushlib.layer.b b1, com.socialin.android.brushlib.layer.CameraMaskLayer.MaskPlacement maskplacement)
    {
        if (g.p != null)
        {
            DrawingView drawingview = g;
            drawingview.i.d();
            drawingview.h.d();
        }
        if (maskplacement != com.socialin.android.brushlib.layer.CameraMaskLayer.MaskPlacement.ABOVE) goto _L2; else goto _L1
_L1:
        g.setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH);
_L4:
        j = CameraMaskLayer.a(b1, maskplacement);
        if (j != null)
        {
            f.a(j, null);
            for (b1 = q.iterator(); b1.hasNext(); ((com.socialin.android.brushlib.state.b)b1.next()).c()) { }
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (i == com.socialin.android.brushlib.view.DrawingView.EditingMode.PHOTO)
        {
            g.setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH);
        }
        if (true) goto _L4; else goto _L3
_L3:
        return j;
    }

    public final com.socialin.android.brushlib.layer.b a(String s, int i1)
    {
        try
        {
            s = w.b(s, 2048, 2048, i1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(n, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
            });
            s = null;
        }
        if (s != null)
        {
            if (!s.isMutable())
            {
                Bitmap bitmap = s.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
                s.recycle();
                s = bitmap;
            }
            com.socialin.android.brushlib.layer.b b1 = com.socialin.android.brushlib.layer.b.a(s, d, e, new b());
            if (b1 != null)
            {
                b(b1);
                c();
                s.recycle();
                return b1;
            } else
            {
                g.l();
                return null;
            }
        } else
        {
            return null;
        }
    }

    public final com.socialin.android.brushlib.layer.b a(HashMap hashmap, int i1)
    {
        com.socialin.android.brushlib.layer.b b1;
label0:
        {
            b1 = null;
            try
            {
                hashmap = w.a(hashmap, 2048, 2048, i1);
            }
            // Misplaced declaration of an exception variable
            catch (HashMap hashmap)
            {
                com.socialin.android.d.b(n, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(hashmap.getMessage()).toString()
                });
                hashmap = null;
            }
            if (hashmap != null)
            {
                b1 = com.socialin.android.brushlib.layer.b.a(hashmap, d, e, new b());
                if (b1 == null)
                {
                    break label0;
                }
                b(b1);
                c();
                hashmap.recycle();
            }
            return b1;
        }
        g.l();
        return b1;
    }

    public final Snapshot a(String s)
    {
        ArrayList arraylist = new ArrayList();
        com.socialin.android.brushlib.layer.b b1;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); arraylist.add(new LayerMetaInfo(b1.i(), b1.j(), b1.c, b1.l, b1.k, b1.e, b1.f, b1.g)))
        {
            b1 = (com.socialin.android.brushlib.layer.b)iterator.next();
        }

        if (j != null)
        {
            CameraMaskLayer cameramasklayer = j;
            cameramasklayer.g();
            int i1 = cameramasklayer.a.getWidth();
            cameramasklayer.g();
            return new Snapshot(s, arraylist, new LayerMetaInfo(i1, cameramasklayer.a.getHeight(), cameramasklayer.f, cameramasklayer.g, cameramasklayer.h, 255, true, BlendMode.NORMAL), System.currentTimeMillis(), a.indexOf(b));
        } else
        {
            return new Snapshot(s, arraylist, null, System.currentTimeMillis(), a.indexOf(b));
        }
    }

    public final void a()
    {
        DrawingView drawingview = g;
        myobfuscated.f.m.a((Activity)drawingview.getContext(), drawingview.n);
        l = false;
    }

    public final void a(int i1, int j1)
    {
        a.add(j1, a.remove(i1));
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = Collections.unmodifiableList(a).iterator(); iterator.hasNext(); arraylist.add(UUID.fromString(((com.socialin.android.brushlib.layer.b)iterator.next()).c))) { }
        ActionCollector.a().a(new LayersMoveAction(arraylist, f.d().key));
        g();
    }

    public final void a(Canvas canvas, com.socialin.android.brushlib.layer.b b1, boolean flag)
    {
        Object obj;
        Object obj1;
        com.socialin.android.brushlib.view.DrawingView.EditingMode editingmode;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        flag2 = false;
        flag3 = false;
        flag5 = false;
        flag4 = false;
        obj1 = g;
        editingmode = ((DrawingView) (obj1)).c.i;
        obj = ((DrawingView) (obj1)).c.h;
        flag1 = flag2;
        com.socialin.android.brushlib.view.DrawingView._cls9.c[editingmode.ordinal()];
        JVM INSTR tableswitch 1 5: default 84
    //                   1 218
    //                   2 256
    //                   3 400
    //                   4 453
    //                   5 483;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        flag1 = false;
_L4:
        b1.a(flag);
        if (flag1)
        {
            canvas.saveLayer(0.0F, 0.0F, g.getWidth(), g.getHeight(), b1.h, 31);
        }
        g.d.b(canvas);
        if (flag1)
        {
            obj = m;
            if (!b1.i && b1.f)
            {
                canvas.drawBitmap(b1.b, 0.0F, 0.0F, ((Paint) (obj)));
            }
        } else
        {
            b1.a(canvas);
        }
        canvas.restore();
        canvas.save();
        if (c != null)
        {
            c.a(canvas, b1);
        }
        canvas.restore();
        if (flag1)
        {
            canvas.restore();
        }
        b1.a(true);
        return;
_L2:
        if (obj != com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW || b1.e != 255) goto _L8; else goto _L7
_L7:
        flag1 = flag4;
        if (b1.g == BlendMode.NORMAL) goto _L4; else goto _L8
_L8:
        flag1 = true;
          goto _L4
_L3:
        flag1 = flag2;
        if (((DrawingView) (obj1)).r) goto _L4; else goto _L9
_L9:
        obj1 = ((DrawingView) (obj1)).g;
        if (((com.socialin.android.brushlib.controller.a) (obj1)).c == null) goto _L11; else goto _L10
_L10:
        ((com.socialin.android.brushlib.controller.a) (obj1)).c.c();
        JVM INSTR lookupswitch 11: default 388
    //                   0: 403
    //                   1: 409
    //                   2: 403
    //                   4: 403
    //                   5: 409
    //                   6: 409
    //                   7: 403
    //                   8: 403
    //                   21: 409
    //                   22: 409
    //                   28: 409;
           goto _L11 _L12 _L13 _L12 _L12 _L13 _L13 _L12 _L12 _L13 _L13 _L13
_L11:
        flag1 = true;
_L16:
        if (!flag1) goto _L15; else goto _L14
_L14:
        flag1 = flag2;
          goto _L4
_L12:
        flag1 = false;
          goto _L16
_L13:
        flag1 = true;
          goto _L16
_L15:
        if (obj == com.socialin.android.brushlib.view.DrawingView.DrawingMode.ERASE || b1.e != 255) goto _L18; else goto _L17
_L17:
        flag1 = flag3;
        if (b1.g == BlendMode.NORMAL) goto _L4; else goto _L18
_L18:
        flag1 = true;
          goto _L4
_L5:
        if (b1.e != 255) goto _L20; else goto _L19
_L19:
        flag1 = flag5;
        if (b1.g == BlendMode.NORMAL) goto _L4; else goto _L20
_L20:
        flag1 = true;
          goto _L4
_L6:
        flag1 = flag2;
        if (((DrawingView) (obj1)).r) goto _L4; else goto _L21
_L21:
        if (obj != com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW || b1.e != 255) goto _L23; else goto _L22
_L22:
        flag1 = flag2;
        if (b1.g == BlendMode.NORMAL) goto _L4; else goto _L23
_L23:
        flag1 = true;
          goto _L4
    }

    public final void a(com.socialin.android.brushlib.layer.a a1)
    {
        f.b(a1, null);
    }

    public final void a(com.socialin.android.brushlib.layer.b b1)
    {
        if (b1 != b)
        {
            b = b1;
            g(b);
        }
    }

    public final void a(com.socialin.android.brushlib.layer.b b1, Bitmap bitmap)
    {
        Object obj1;
        myobfuscated.br.a a1;
        ByteBuffer bytebuffer;
        a1 = f;
        bytebuffer = myobfuscated.br.d.a(bitmap.getRowBytes() * bitmap.getHeight());
        bitmap.copyPixelsToBuffer(bytebuffer);
        bytebuffer.rewind();
        obj1 = null;
        Object obj = new RandomAccessFile(new File(a1.c.c.k.getLayerOrigBuffersFolder(), b1.l), "rw");
        obj1 = obj;
        com.socialin.android.brushlib.util.b.a(bytebuffer, ((RandomAccessFile) (obj)));
        ((RandomAccessFile) (obj)).close();
        obj1 = obj;
_L9:
        Bitmap bitmap1;
        Bitmap bitmap2;
        Canvas canvas;
        ArrayList arraylist;
        Iterator iterator;
        bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap1);
        arraylist = new ArrayList();
        iterator = Collections.unmodifiableList(a1.b.a).iterator();
        obj = obj1;
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj2;
        boolean flag;
        obj2 = ((Snapshot)iterator.next()).layerInfoList.iterator();
        do
        {
            if (!((Iterator) (obj2)).hasNext())
            {
                break MISSING_BLOCK_LABEL_1003;
            }
            obj1 = (LayerMetaInfo)((Iterator) (obj2)).next();
        } while (!((LayerMetaInfo) (obj1)).key.equals(b1.c));
        obj2 = ((LayerMetaInfo) (obj1)).currentBufferKey;
        flag = ((LayerMetaInfo) (obj1)).currentBufferKey.equals(((LayerMetaInfo) (obj1)).origBufferKey);
_L18:
        if (obj2 == null || arraylist.contains(obj2)) goto _L4; else goto _L3
_L3:
        arraylist.add(obj2);
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, null);
        if (!flag) goto _L6; else goto _L5
_L5:
        obj1 = a1.c.c.k.getLayerOrigBuffersFolder();
_L11:
        obj1 = new RandomAccessFile(new File(((File) (obj1)), ((String) (obj2))), "rw");
        bytebuffer.rewind();
        myobfuscated.br.d.b(bytebuffer, ((RandomAccessFile) (obj1)));
        bytebuffer.rewind();
        bitmap2.copyPixelsFromBuffer(bytebuffer);
        canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, null);
        canvas.drawBitmap(bitmap2, 0.0F, 0.0F, null);
        bytebuffer.rewind();
        bitmap1.copyPixelsToBuffer(bytebuffer);
        bytebuffer.rewind();
        if (!flag) goto _L8; else goto _L7
_L7:
        obj = a1.c.c.k.getLayerOrigBuffersFolder();
_L12:
        obj = new RandomAccessFile(new File(((File) (obj)), ((String) (obj2))), "rw");
        com.socialin.android.brushlib.util.b.a(bytebuffer, ((RandomAccessFile) (obj)));
        try
        {
            ((RandomAccessFile) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            com.socialin.android.d.b(myobfuscated.br.a.a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj1)).getMessage()).toString()
            });
        }
          goto _L4
        obj1;
        com.socialin.android.d.b(myobfuscated.br.a.a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj1)).getMessage()).toString()
        });
        obj1 = obj;
          goto _L9
        obj2;
        obj = null;
_L17:
        obj1 = obj;
        com.socialin.android.d.b(myobfuscated.br.a.a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((FileNotFoundException) (obj2)).getMessage()).toString()
        });
        obj1 = obj;
        if (obj == null) goto _L9; else goto _L10
_L10:
        ((RandomAccessFile) (obj)).close();
        obj1 = obj;
          goto _L9
        obj1;
        com.socialin.android.d.b(myobfuscated.br.a.a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj1)).getMessage()).toString()
        });
        obj1 = obj;
          goto _L9
        b1;
_L16:
        if (obj1 != null)
        {
            try
            {
                ((RandomAccessFile) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                com.socialin.android.d.b(myobfuscated.br.a.a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(bitmap.getMessage()).toString()
                });
            }
        }
        throw b1;
_L6:
        obj1 = a1.c.c.k.getRootFolder();
          goto _L11
_L8:
        obj = a1.c.c.k.getRootFolder();
          goto _L12
        obj1;
_L15:
        com.socialin.android.d.b(myobfuscated.br.a.a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((FileNotFoundException) (obj1)).getMessage()).toString()
        });
        if (obj != null)
        {
            try
            {
                ((RandomAccessFile) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                com.socialin.android.d.b(myobfuscated.br.a.a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj1)).getMessage()).toString()
                });
            }
        }
          goto _L4
        b1;
        bitmap = ((Bitmap) (obj));
_L14:
        if (bitmap != null)
        {
            try
            {
                bitmap.close();
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                com.socialin.android.d.b(myobfuscated.br.a.a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(bitmap.getMessage()).toString()
                });
            }
        }
        throw b1;
_L2:
        if (b1.l.equals(b1.k))
        {
            myobfuscated.br.d.a(b1, new File(a1.c.c.k.getLayerOrigBuffersFolder(), b1.k));
        } else
        {
            myobfuscated.br.d.a(b1, new File(a1.c.c.k.getRootFolder(), b1.k));
        }
        bitmap1.recycle();
        bitmap2.recycle();
        return;
        b1;
        bitmap = ((Bitmap) (obj1));
        continue; /* Loop/switch isn't completed */
        b1;
        bitmap = ((Bitmap) (obj));
        continue; /* Loop/switch isn't completed */
        b1;
        bitmap = ((Bitmap) (obj));
        if (true) goto _L14; else goto _L13
_L13:
        obj2;
        obj = obj1;
        obj1 = obj2;
          goto _L15
        obj1;
          goto _L15
        b1;
          goto _L16
        obj2;
          goto _L17
        obj2 = null;
        flag = false;
          goto _L18
    }

    public final void a(com.socialin.android.brushlib.layer.b b1, boolean flag)
    {
        if (flag && b == b1)
        {
            int i1 = a.indexOf(b);
            if (i1 == 0)
            {
                i1 = 1;
            } else
            {
                i1--;
            }
            b = (com.socialin.android.brushlib.layer.b)a.get(i1);
            g(b);
        }
        a.remove(b1);
        e(b1);
        b1.h();
        if (j != null && j.d == b1)
        {
            d();
        }
        ActionCollector.a().a(new LayerRemoveAction(UUID.fromString(b1.c), f.d().key));
    }

    public final void a(com.socialin.android.brushlib.state.b b1)
    {
        q.add(b1);
    }

    public final int b(int i1, int j1)
    {
        Iterator iterator;
        o.eraseColor(0);
        iterator = a.iterator();
_L1:
        Object obj;
        int k1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_164;
            }
            obj = (com.socialin.android.brushlib.layer.b)iterator.next();
        } while (!((com.socialin.android.brushlib.layer.b) (obj)).f);
        k1 = ((com.socialin.android.brushlib.layer.b) (obj)).b.getPixel(i1, j1);
        k1 = k1 & 0xffffff | (int)((float)(Color.alpha(k1) * ((com.socialin.android.brushlib.layer.b) (obj)).e) / 255F) << 24;
        obj = ((com.socialin.android.brushlib.layer.b) (obj)).g.getMode();
label0:
        {
            if (obj != null)
            {
                break label0;
            }
            try
            {
                p.drawColor(k1);
            }
            catch (Exception exception)
            {
                com.socialin.android.d.b(n, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                });
                return 0xff000000;
            }
        }
          goto _L1
        p.drawColor(k1, ((android.graphics.PorterDuff.Mode) (obj)));
          goto _L1
        i1 = o.getPixel(0, 0);
        return i1 & 0xffffff | 0xff000000;
    }

    public final com.socialin.android.brushlib.layer.b b(com.socialin.android.brushlib.layer.b b1)
    {
        if (b1 != null)
        {
            a.add(b1);
            f(b1);
            a(b1);
            g(b1);
            LayerAdditionAction layeradditionaction = new LayerAdditionAction(UUID.fromString(b1.c), null, f.d().key);
            ActionCollector.a().a(layeradditionaction);
            f.a(b1, new Runnable(layeradditionaction, b1) {

                private LayerAdditionAction a;
                private com.socialin.android.brushlib.layer.b b;

                public final void run()
                {
                    a.setImageBufferPath(b.k);
                    ActionCollector.a().a(a);
                }

            
            {
                a = layeradditionaction;
                b = b1;
                super();
            }
            });
        }
        return b1;
    }

    public final void b()
    {
        DrawingView drawingview = g;
        myobfuscated.f.m.b((Activity)drawingview.getContext(), drawingview.n);
        l = true;
    }

    public final void c()
    {
        f.a(a(f.d().key));
    }

    public final void c(com.socialin.android.brushlib.layer.b b1)
    {
        for (Iterator iterator = q.iterator(); iterator.hasNext(); ((com.socialin.android.brushlib.state.b)iterator.next()).a(b1)) { }
    }

    public final void d()
    {
        if (j != null)
        {
            CameraMaskLayer cameramasklayer = j;
            cameramasklayer.a.recycle();
            cameramasklayer.e = true;
            j = null;
            h();
        }
    }

    public final void d(com.socialin.android.brushlib.layer.b b1)
    {
        for (Iterator iterator = q.iterator(); iterator.hasNext(); ((com.socialin.android.brushlib.state.b)iterator.next()).b(b1)) { }
    }

    public final com.socialin.android.brushlib.layer.b e()
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            com.socialin.android.brushlib.layer.b b1 = (com.socialin.android.brushlib.layer.b)iterator.next();
            if (b1.f)
            {
                return b1;
            }
        }

        return null;
    }

    public final void e(com.socialin.android.brushlib.layer.b b1)
    {
        for (Iterator iterator = q.iterator(); iterator.hasNext(); ((com.socialin.android.brushlib.state.b)iterator.next()).c(b1)) { }
    }

    public final void f()
    {
        myobfuscated.br.d.a();
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((com.socialin.android.brushlib.layer.b)iterator.next()).h()) { }
    }

    public final void f(com.socialin.android.brushlib.layer.b b1)
    {
        for (Iterator iterator = q.iterator(); iterator.hasNext(); ((com.socialin.android.brushlib.state.b)iterator.next()).d(b1)) { }
    }

    public final void g()
    {
        for (Iterator iterator = q.iterator(); iterator.hasNext(); ((com.socialin.android.brushlib.state.b)iterator.next()).a()) { }
    }

    public final void g(com.socialin.android.brushlib.layer.b b1)
    {
        for (Iterator iterator = q.iterator(); iterator.hasNext(); ((com.socialin.android.brushlib.state.b)iterator.next()).e(b1)) { }
    }

    public final void h()
    {
        for (Iterator iterator = q.iterator(); iterator.hasNext(); ((com.socialin.android.brushlib.state.b)iterator.next()).b()) { }
    }

    static 
    {
        o = Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ARGB_8888);
        p = new Canvas(o);
    }

    // Unreferenced inner class com/socialin/android/brushlib/state/a$2

/* anonymous class */
    public final class _cls2
        implements Runnable
    {

        private LayerAdditionAction a;
        private com.socialin.android.brushlib.layer.b b;

        public final void run()
        {
            a.setImageBufferPath(b.k);
            ActionCollector.a().a(a);
        }

            public 
            {
                a = layeradditionaction;
                b = b1;
                super();
            }
    }


    // Unreferenced inner class com/socialin/android/brushlib/state/a$4

/* anonymous class */
    public final class _cls4
    {

        public static final int a[];

        static 
        {
            a = new int[com.socialin.android.brushlib.layer.CameraMaskLayer.MaskPlacement.values().length];
            try
            {
                a[com.socialin.android.brushlib.layer.CameraMaskLayer.MaskPlacement.ABOVE.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[com.socialin.android.brushlib.layer.CameraMaskLayer.MaskPlacement.BELOW.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
