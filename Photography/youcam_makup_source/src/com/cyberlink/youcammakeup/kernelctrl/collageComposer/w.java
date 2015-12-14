// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.jniproxy.PixelFormat;
import com.cyberlink.youcammakeup.jniproxy.d;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.n;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.pf.common.utility.m;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            CollageLayout, o, p, s, 
//            t, x, aa, n, 
//            q, m, y, z, 
//            b, r, CollageTextPainter, CollageTextView, 
//            CollageDateHighlightView

public class w
{

    private Context a;
    private String b;
    private CollageLayout c;
    private ImageView d;
    private View e;
    private ViewEngine f;
    private Map g;
    private boolean h;
    private int i[];
    private b j;

    public w(Context context, CollageLayout collagelayout)
    {
        a = null;
        b = "CollageTemplateRenderer";
        c = null;
        d = null;
        e = null;
        f = ViewEngine.a();
        g = new HashMap();
        h = true;
        i = null;
        j = null;
        a = context;
        c = collagelayout;
    }

    private int a(String s1)
    {
        int k = 0;
        if (s1.toLowerCase(Locale.US).contains("bold"))
        {
            k = 1;
        }
        int l = k;
        if (s1.toLowerCase(Locale.US).contains("italic"))
        {
            l = k | 2;
        }
        return l;
    }

    private Bitmap a(long l)
    {
        Bitmap bitmap = null;
        m.e(b, (new StringBuilder()).append("getThumbnailFromImageID, imageID = ").append(l).toString());
        ImageBufferWrapper imagebufferwrapper;
        if (l == -10L || l == -11L)
        {
            imagebufferwrapper = f.a(l, 1.0D, null);
        } else
        {
            imagebufferwrapper = f.a(l, null);
        }
        if (imagebufferwrapper != null)
        {
            bitmap = Bitmap.createBitmap((int)imagebufferwrapper.b(), (int)imagebufferwrapper.c(), android.graphics.Bitmap.Config.ARGB_8888);
            imagebufferwrapper.c(bitmap);
            imagebufferwrapper.m();
        }
        return bitmap;
    }

    static View a(w w1, View view)
    {
        w1.e = view;
        return view;
    }

    static ImageView a(w w1)
    {
        return w1.d;
    }

    private void a(Bitmap bitmap, Bitmap bitmap1)
    {
        d d1 = new d(PixelFormat.a);
        d1.a(bitmap);
        d1.c(bitmap1);
        d1.c();
        d1.b();
    }

    static void a(w w1, y y1, y y2)
    {
        w1.a(y1, y2);
    }

    private void a(y y1, y y2)
    {
    }

    static int[] a(w w1, int ai[])
    {
        w1.i = ai;
        return ai;
    }

    static CollageLayout b(w w1)
    {
        return w1.c;
    }

    static String c(w w1)
    {
        return w1.b;
    }

    static View d(w w1)
    {
        return w1.e;
    }

    static Map e(w w1)
    {
        return w1.g;
    }

    static int[] f(w w1)
    {
        return w1.i;
    }

    void a()
    {
        m.e(b, "setDirty");
        h = true;
    }

    public void a(ImageView imageview)
    {
        m.e(b, "setThumbnailView");
        d = imageview;
    }

    public void a(b b1)
    {
        j = b1;
    }

    void a(o o1)
    {
        long l;
        m.e(b, (new StringBuilder()).append("initRenderResources, template = ").append(o1).toString());
        l = System.nanoTime();
        Bitmap bitmap = c.getCoverImage();
        if (bitmap != null)
        {
            bitmap.recycle();
            c.setCoverImage(null);
            c.setResizedCoverImage(null);
        }
        if (o1.b.equals("")) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        Object obj2;
        String s1;
        boolean flag;
        if (o1.b.indexOf("assets://") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c.c();
        c.b();
        c.d();
        obj1 = o1.l.iterator();
_L6:
        if (!((Iterator) (obj1)).hasNext()) goto _L4; else goto _L3
_L3:
        obj = (p)((Iterator) (obj1)).next();
        if (!(obj instanceof s)) goto _L6; else goto _L5
_L5:
        obj2 = ((s)obj).c.iterator();
_L10:
        if (!((Iterator) (obj2)).hasNext()) goto _L6; else goto _L7
_L7:
        s1 = ((t)((Iterator) (obj2)).next()).a;
        if (!flag) goto _L9; else goto _L8
_L8:
        obj = new BufferedInputStream(a.getAssets().open(o1.b.substring("assets://".length()).concat(s1)));
_L15:
        if (c.a(s1) == null)
        {
            Bitmap bitmap1 = BitmapFactory.decodeStream(((InputStream) (obj)));
            c.a(s1, bitmap1);
        }
        ((InputStream) (obj)).close();
          goto _L10
        obj;
        ((IOException) (obj)).printStackTrace();
_L2:
        obj = c.getGlobalMask();
        if (obj != null)
        {
            ((Bitmap) (obj)).recycle();
            c.setGlobalMask(null);
            c.setResizedGlobalMask(null);
        }
        if (o1.b.equals("") || o1.g.equals("")) goto _L12; else goto _L11
_L11:
        if (o1.e.equals("") || !o1.g.equals(o1.e)) goto _L14; else goto _L13
_L13:
        c.setGlobalMask(c.getCoverImage());
_L12:
        float f1 = System.nanoTime() - l;
        o1 = (new StringBuilder()).append(Float.valueOf(f1 * 1E-06F).toString()).append(" ms").toString();
        m.e(b, (new StringBuilder()).append("initRenderResources, take ").append(o1).toString());
        return;
_L9:
        obj = new FileInputStream(new File(o1.b.concat(s1)));
          goto _L15
_L4:
        if (o1.e.equals("")) goto _L2; else goto _L16
_L16:
        obj1 = new android.graphics.BitmapFactory.Options();
        obj1.inMutable = true;
        obj1.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        if (!flag) goto _L18; else goto _L17
_L17:
        obj1 = BitmapFactory.decodeStream(new BufferedInputStream(a.getAssets().open(o1.b.substring("assets://".length()).concat(o1.e))), null, ((android.graphics.BitmapFactory.Options) (obj1)));
        obj = obj1;
        if (o1.f.equals(""))
        {
            break MISSING_BLOCK_LABEL_849;
        }
        obj2 = BitmapFactory.decodeStream(new BufferedInputStream(a.getAssets().open(o1.b.substring("assets://".length()).concat(o1.f))));
        obj = obj1;
_L19:
        for (obj1 = obj2; obj1 == null; obj1 = null)
        {
            break MISSING_BLOCK_LABEL_635;
        }

        a(((Bitmap) (obj)), ((Bitmap) (obj1)));
        ((Bitmap) (obj1)).recycle();
        ((Bitmap) (obj)).setHasAlpha(true);
        c.setCoverImage(((Bitmap) (obj)));
          goto _L2
_L18:
        obj = new FileInputStream(new File(o1.b.concat(o1.e)));
        obj2 = BitmapFactory.decodeStream(((InputStream) (obj)), null, ((android.graphics.BitmapFactory.Options) (obj1)));
        ((FileInputStream) (obj)).close();
        obj = obj2;
        if (o1.f.equals(""))
        {
            break MISSING_BLOCK_LABEL_849;
        }
        obj = new FileInputStream(new File(o1.b.concat(o1.f)));
        obj1 = BitmapFactory.decodeStream(((InputStream) (obj)));
        ((FileInputStream) (obj)).close();
        obj = obj2;
          goto _L19
_L14:
        if (o1.b.indexOf("assets://") != 0)
        {
            break MISSING_BLOCK_LABEL_817;
        }
        o1 = BitmapFactory.decodeStream(new BufferedInputStream(a.getAssets().open(o1.b.substring("assets://".length()).concat(o1.g))));
_L20:
        if (o1 != null)
        {
            try
            {
                c.setGlobalMask(o1);
            }
            // Misplaced declaration of an exception variable
            catch (o o1)
            {
                o1.printStackTrace();
            }
        }
          goto _L12
        o1 = BitmapFactory.decodeStream(new FileInputStream(new File(o1.b.concat(o1.g))));
          goto _L20
    }

    void a(o o1, int k, int l, double d1)
    {
        Object obj;
        long l1;
        m.e(b, String.format("updateRenderResources, displayWidth = %d, displayHeight = %d", new Object[] {
            Integer.valueOf(k), Integer.valueOf(l)
        }));
        l1 = System.nanoTime();
        obj = c.getResizedCoverImage();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((Bitmap) (obj)).getWidth() != k || ((Bitmap) (obj)).getHeight() != l) goto _L4; else goto _L3
_L3:
        obj = c.getResizedGlobalMask();
        if (obj == null) goto _L6; else goto _L5
_L5:
        if (((Bitmap) (obj)).getWidth() != k || ((Bitmap) (obj)).getHeight() != l) goto _L8; else goto _L7
_L7:
        if (c.getImageMaskCount() != 0) goto _L10; else goto _L9
_L9:
        float f1 = System.nanoTime() - l1;
        o1 = (new StringBuilder()).append(Float.valueOf(f1 * 1E-06F).toString()).append(" ms").toString();
        m.e(b, (new StringBuilder()).append("updateRenderResources, take ").append(o1).toString());
        return;
_L4:
        ((Bitmap) (obj)).recycle();
_L2:
        obj = c.getCoverImage();
        if (obj != null)
        {
            obj = Bitmap.createScaledBitmap(((Bitmap) (obj)), k, l, true);
            c.setResizedCoverImage(((Bitmap) (obj)));
        }
          goto _L3
_L8:
        ((Bitmap) (obj)).recycle();
_L6:
        if (!o1.e.equals("") && o1.g.equals(o1.e))
        {
            c.setResizedGlobalMask(c.getResizedCoverImage());
        } else
        {
            obj = c.getGlobalMask();
            if (obj != null)
            {
                obj = Bitmap.createScaledBitmap(((Bitmap) (obj)), k, l, true);
                c.setResizedGlobalMask(((Bitmap) (obj)));
            }
        }
          goto _L7
_L10:
        obj = o1.l.iterator();
_L13:
        if (!((Iterator) (obj)).hasNext()) goto _L9; else goto _L11
_L11:
        o1 = (p)((Iterator) (obj)).next();
        if (!(o1 instanceof s)) goto _L13; else goto _L12
_L12:
        Iterator iterator = ((s)o1).c.iterator();
_L16:
        if (!iterator.hasNext()) goto _L13; else goto _L14
_L14:
        Bitmap bitmap;
        o1 = (t)iterator.next();
        bitmap = c.a(((t) (o1)).a);
        o1 = c.b(((t) (o1)).a);
        k = (int)((double)bitmap.getWidth() * d1);
        l = (int)((double)bitmap.getHeight() * d1);
        if (o1 == null)
        {
            break MISSING_BLOCK_LABEL_449;
        }
        if (o1.getWidth() == k && o1.getHeight() == l) goto _L16; else goto _L15
_L15:
        o1.recycle();
        if (k == bitmap.getWidth() && l == bitmap.getHeight())
        {
            if (bitmap.getConfig() == null)
            {
                o1 = android.graphics.Bitmap.Config.ARGB_8888;
            } else
            {
                o1 = bitmap.getConfig();
            }
            if (bitmap.copy(o1, true) == null)
            {
                (new Canvas(Bitmap.createBitmap(k, l, o1))).drawBitmap(bitmap, 0.0F, 0.0F, null);
            }
        } else
        {
            Bitmap.createScaledBitmap(bitmap, k, l, true);
        }
          goto _L16
    }

    void a(o o1, int k, int l, int i1, int j1, double d1)
    {
        Object obj = StatusManager.j().m();
        if (o1 == null || obj == null)
        {
            m.e(b, (new StringBuilder()).append("renderTemplate, template = ").append(o1).toString());
            m.e(b, (new StringBuilder()).append("renderTemplate, curImageIDArray = ").append(obj).toString());
        } else
        if (h)
        {
            b();
            Collections.sort(o1.l, new x());
            obj = new aa(this, o1.l, ((List) (obj)));
            if (((aa) (obj)).a())
            {
                int k1 = 0;
                Iterator iterator = o1.l.iterator();
                do
                {
                    if (iterator.hasNext())
                    {
                        Object obj4 = (p)iterator.next();
                        if (obj4 instanceof s)
                        {
                            Long long1 = ((aa) (obj)).a(((p) (obj4)));
                            if (long1 == null)
                            {
                                m.e(b, "renderTemplate(), error. imageID == null");
                            } else
                            {
                                Object obj2 = new com.cyberlink.youcammakeup.kernelctrl.collageComposer.n((int)((double)((p) (obj4)).a.c * d1), (int)((double)((p) (obj4)).a.d * d1), (int)((double)((p) (obj4)).a.a * d1) + k, (int)((double)((p) (obj4)).a.b * d1) + l, k1);
                                PanZoomViewer panzoomviewer = new PanZoomViewer(c.getContext());
                                panzoomviewer.setTag(obj4);
                                panzoomviewer.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
                                m.e("CollageTemplateRenderer", (new StringBuilder()).append(panzoomviewer).append(String.format(" (%d, %d, %d, %d)", new Object[] {
                                    Integer.valueOf((int)((double)((p) (obj4)).a.c * d1)), Integer.valueOf((int)((double)((p) (obj4)).a.d * d1)), Integer.valueOf((int)((double)((p) (obj4)).a.a * d1) + k), Integer.valueOf((int)((double)((p) (obj4)).a.b * d1) + l)
                                })).toString());
                                obj2 = new BitmapDrawable(a.getResources(), a(long1.longValue()));
                                obj4 = (s)obj4;
                                if (((s) (obj4)).c.size() > 0)
                                {
                                    obj4 = (t)((s) (obj4)).c.get(0);
                                    com.cyberlink.youcammakeup.kernelctrl.collageComposer.m m1 = new com.cyberlink.youcammakeup.kernelctrl.collageComposer.m();
                                    m1.a = ((t) (obj4)).a;
                                    m1.b = ((t) (obj4)).b;
                                    m1.c.a = (int)((double)((t) (obj4)).b.a * d1);
                                    m1.c.b = (int)((double)((t) (obj4)).b.b * d1);
                                    m1.c.c = (int)((double)((t) (obj4)).b.c * d1);
                                    m1.c.d = (int)((double)((t) (obj4)).b.d * d1);
                                    c.a(Integer.valueOf(panzoomviewer.hashCode()), m1);
                                    panzoomviewer.setImageMask(c.b(m1.a));
                                    panzoomviewer.setBackgroundColor(0);
                                } else
                                {
                                    panzoomviewer.setBackgroundColor(0xff000000);
                                }
                                obj4 = new n();
                                obj4.b = true;
                                obj4.a = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer.FitOption.b;
                                obj4.c = true;
                                obj4.d = true;
                                g.put(Integer.valueOf(panzoomviewer.hashCode()), new y(this, panzoomviewer, long1.longValue(), ((BitmapDrawable) (obj2))));
                                c.addView(panzoomviewer);
                                panzoomviewer.setOnTouchListener(new z(this));
                                panzoomviewer.a(long1.longValue(), null, null);
                                k1++;
                            }
                        }
                    } else
                    {
                        Object obj1 = c.getResizedCoverImage();
                        int l1 = k1;
                        if (obj1 != null)
                        {
                            m.e("CollageLayout", "drawCoverImage");
                            com.cyberlink.youcammakeup.kernelctrl.collageComposer.n n1 = new com.cyberlink.youcammakeup.kernelctrl.collageComposer.n(i1, j1, k, l, k1);
                            ImageView imageview = new ImageView(c.getContext());
                            imageview.setLayoutParams(n1);
                            imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                            imageview.setImageBitmap(((Bitmap) (obj1)));
                            c.addView(imageview);
                            l1 = k1 + 1;
                        }
                        j.a();
                        obj1 = new ArrayList();
                        o1 = o1.l.iterator();
                        do
                        {
                            if (!o1.hasNext())
                            {
                                break;
                            }
                            p p1 = (p)o1.next();
                            if (p1 instanceof r)
                            {
                                Object obj3 = (r)p1;
                                com.cyberlink.youcammakeup.kernelctrl.collageComposer.n n2 = new com.cyberlink.youcammakeup.kernelctrl.collageComposer.n(i1, j1, k, l, l1);
                                SimpleDateFormat simpledateformat = new SimpleDateFormat(((r) (obj3)).e, Locale.US);
                                String s1 = simpledateformat.format(new Date());
                                CollageTextPainter collagetextpainter = new CollageTextPainter(c.getContext());
                                collagetextpainter.a((int)((double)p1.a.a * d1), (int)((double)p1.a.b * d1));
                                collagetextpainter.a((int)((double)((r) (obj3)).f * d1));
                                collagetextpainter.a(s1);
                                collagetextpainter.a(simpledateformat);
                                collagetextpainter.b(((r) (obj3)).g);
                                collagetextpainter.b((int)((double)p1.a.c * d1), (int)((double)p1.a.d * d1));
                                collagetextpainter.b(((r) (obj3)).h);
                                collagetextpainter.a(Typeface.create(((r) (obj3)).c, a(((r) (obj3)).d)));
                                collagetextpainter.a(j.b());
                                obj3 = new CollageTextView(c.getContext());
                                ((CollageTextView) (obj3)).setTextPainter(collagetextpainter);
                                ((CollageTextView) (obj3)).setTag(p1);
                                ((CollageTextView) (obj3)).setLayoutParams(n2);
                                ((CollageTextView) (obj3)).setCollageDatePickerCtrl(j);
                                c.addView(((View) (obj3)));
                                ((List) (obj1)).add(obj3);
                                l1++;
                            }
                        } while (true);
                        o1 = new com.cyberlink.youcammakeup.kernelctrl.collageComposer.n(i1, j1, k, l, l1);
                        CollageDateHighlightView collagedatehighlightview = new CollageDateHighlightView(c.getContext());
                        collagedatehighlightview.setLayoutParams(o1);
                        c.addView(collagedatehighlightview);
                        (new Handler()).postDelayed(new Runnable(((List) (obj1)), collagedatehighlightview) {

                            final List a;
                            final CollageDateHighlightView b;
                            final w c;

                            public void run()
                            {
                                CollageTextView collagetextview;
                                for (Iterator iterator1 = a.iterator(); iterator1.hasNext(); b.a(collagetextview.getTextPainter().b()))
                                {
                                    collagetextview = (CollageTextView)iterator1.next();
                                }

                                b.a();
                            }

            
            {
                c = w.this;
                a = list;
                b = collagedatehighlightview;
                super();
            }
                        }, 300L);
                        h = false;
                        return;
                    }
                } while (true);
            }
        }
    }

    void b()
    {
        m.e(b, "unloadTemplate");
        g.clear();
        for (int k = 0; k < c.getChildCount(); k++)
        {
            View view = c.getChildAt(k);
            if (view instanceof PanZoomViewer)
            {
                ((PanZoomViewer)view).e();
            }
        }

        c.removeAllViews();
    }
}
