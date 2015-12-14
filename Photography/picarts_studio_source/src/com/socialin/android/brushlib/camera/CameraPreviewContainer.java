// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.camera;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.brushlib.util.a;
import com.socialin.android.brushlib.util.b;
import com.socialin.android.d;
import com.socialin.android.util.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.brushlib.camera:
//            b, a

public class CameraPreviewContainer extends ViewGroup
    implements android.view.SurfaceHolder.Callback
{

    private static final String f = com/socialin/android/brushlib/camera/CameraPreviewContainer.getSimpleName();
    public Camera a;
    public int b;
    public com.socialin.android.brushlib.camera.b c;
    public final Rect d = new Rect();
    public volatile boolean e;
    private final a g = new a(com/socialin/android/brushlib/camera/CameraPreviewContainer.getSimpleName());
    private SurfaceView h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private final ExecutorService m = Executors.newSingleThreadExecutor();
    private boolean n;
    private Camera o;

    public CameraPreviewContainer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            return;
        } else
        {
            g.a = false;
            h = new SurfaceView(context);
            addView(h);
            context = h.getHolder();
            context.addCallback(this);
            context.setType(3);
            return;
        }
    }

    static int a(CameraPreviewContainer camerapreviewcontainer)
    {
        return camerapreviewcontainer.b;
    }

    private com.socialin.android.brushlib.camera.b a(Camera camera, int i1, int j1, int k1, int l1)
    {
        Object obj = camera.getParameters();
        camera = ((android.hardware.Camera.Parameters) (obj)).getSupportedPreviewSizes();
        obj = ((android.hardware.Camera.Parameters) (obj)).getSupportedPictureSizes();
        ArrayList arraylist = new ArrayList();
        android.hardware.Camera.Size size = b(camera, i1, j1);
        for (Iterator iterator = camera.iterator(); iterator.hasNext();)
        {
            android.hardware.Camera.Size size1 = (android.hardware.Camera.Size)iterator.next();
            Iterator iterator1 = ((List) (obj)).iterator();
            while (iterator1.hasNext()) 
            {
                android.hardware.Camera.Size size2 = (android.hardware.Camera.Size)iterator1.next();
                if (c(size1) == c(size2) && size1.width == size.width && size1.height == size.height)
                {
                    arraylist.add(new com.socialin.android.brushlib.camera.b(this, size1, size2));
                }
            }
        }

        if (arraylist.isEmpty())
        {
            return new com.socialin.android.brushlib.camera.b(this, (android.hardware.Camera.Size)camera.get(0), (android.hardware.Camera.Size)((List) (obj)).get(0));
        } else
        {
            return a(((List) (arraylist)), k1, l1);
        }
    }

    private static com.socialin.android.brushlib.camera.b a(List list, int i1, int j1)
    {
        com.socialin.android.brushlib.camera.b b1 = (com.socialin.android.brushlib.camera.b)list.get(0);
        int l1 = list.size();
        for (int k1 = 1; k1 < l1; k1++)
        {
            com.socialin.android.brushlib.camera.b b2 = (com.socialin.android.brushlib.camera.b)list.get(k1);
            if (Math.abs((b2.b.width - i1) * (b2.b.height - j1)) < Math.abs((b1.b.width - i1) * (b1.b.height - j1)))
            {
                b1 = b2;
            }
        }

        return b1;
    }

    private static void a(android.hardware.Camera.Parameters parameters)
    {
        Iterator iterator = parameters.getSupportedFocusModes().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (!"continuous-picture".equals(s))
            {
                continue;
            }
            parameters.setFocusMode(s);
            break;
        } while (true);
    }

    private static android.hardware.Camera.Size b(List list, int i1, int j1)
    {
        double d3 = (double)i1 / (double)j1;
        android.hardware.Camera.Size size;
        if (list == null)
        {
            size = null;
        } else
        {
            Iterator iterator = list.iterator();
            size = null;
            double d1 = 1.7976931348623157E+308D;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                android.hardware.Camera.Size size1 = (android.hardware.Camera.Size)iterator.next();
                if (Math.abs((double)size1.width / (double)size1.height - d3) <= 0.050000000000000003D && (double)j1 / (double)size1.height <= 1.5D && ((double)size1.width * (double)j1) / (double)size1.height <= (double)i1)
                {
                    if ((double)Math.abs(size1.height - j1) < d1)
                    {
                        d1 = Math.abs(size1.height - j1);
                        size = size1;
                    } else
                    if ((double)Math.abs(size1.height - j1) == d1 && size != null && Math.abs(size1.width - i1) < Math.abs(size.width - i1))
                    {
                        d1 = Math.abs(size1.height - j1);
                        size = size1;
                    }
                }
            } while (true);
            android.hardware.Camera.Size size2 = size;
            if (size == null)
            {
                double d2 = 1.7976931348623157E+308D;
                Iterator iterator1 = list.iterator();
                do
                {
                    size2 = size;
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    size2 = (android.hardware.Camera.Size)iterator1.next();
                    if (((double)size2.width * (double)j1) / (double)size2.height <= (double)i1)
                    {
                        if ((double)Math.abs(size2.height - j1) < d2)
                        {
                            d2 = Math.abs(size2.height - j1);
                            size = size2;
                        } else
                        if ((double)Math.abs(size2.height - j1) == d2 && size != null && Math.abs(size2.width - i1) < Math.abs(size.width - i1))
                        {
                            d2 = Math.abs(size2.height - j1);
                            size = size2;
                        }
                    }
                } while (true);
            }
            size = size2;
            if (size2 == null)
            {
                return (android.hardware.Camera.Size)list.get(0);
            }
        }
        return size;
    }

    static String b(android.hardware.Camera.Size size)
    {
        return (new StringBuilder("{")).append(size.width).append(", ").append(size.height).append("}").toString();
    }

    static boolean b(CameraPreviewContainer camerapreviewcontainer)
    {
        camerapreviewcontainer.e = false;
        return false;
    }

    private static float c(android.hardware.Camera.Size size)
    {
        return (float)size.width / (float)size.height;
    }

    static ExecutorService c(CameraPreviewContainer camerapreviewcontainer)
    {
        return camerapreviewcontainer.m;
    }

    static String d()
    {
        return f;
    }

    public final android.hardware.Camera.Size a(android.hardware.Camera.Size size)
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((android.hardware.Camera.Size) (obj));
_L2:
        boolean flag;
        if ((myobfuscated.f.m.a((Activity)getContext(), b) / 90) % 2 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (size.width <= size.height)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = size;
        if (!flag)
        {
            obj = a;
            obj.getClass();
            return new android.hardware.Camera.Size(((Camera) (obj)), size.height, size.width);
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj = size;
        if (flag)
        {
            Camera camera = a;
            camera.getClass();
            return new android.hardware.Camera.Size(camera, size.height, size.width);
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public final Camera a(int i1)
    {
        Camera camera;
        camera = null;
        if (a != null)
        {
            g.a("Releasing camera");
            a.stopPreview();
            a.release();
            a = null;
        }
        if (o != null)
        {
            g.a("Releasing camera2");
            o.release();
            o = null;
        }
        Camera camera1 = Camera.open(i1);
        camera = camera1;
_L1:
        Object obj;
        if (camera == null)
        {
            obj = o;
        } else
        {
            obj = camera;
        }
        o = ((Camera) (obj));
        return camera;
        obj;
        ExceptionReportService.report(((Throwable) (obj)));
          goto _L1
    }

    public final boolean a()
    {
        Camera camera;
label0:
        {
            boolean flag = true;
            if (a == null)
            {
                camera = a(b);
                if (camera != null)
                {
                    break label0;
                }
                flag = false;
            }
            return flag;
        }
        setCamera(camera);
        n = true;
        post(new Runnable() {

            private CameraPreviewContainer a;

            public final void run()
            {
                a.requestLayout();
            }

            
            {
                a = CameraPreviewContainer.this;
                super();
            }
        });
        return true;
    }

    public final void b()
    {
        c();
        e = false;
    }

    public final void c()
    {
        try
        {
            if (a != null)
            {
                g.a("Releasing camera");
                a.stopPreview();
                a.release();
                a = null;
            }
            if (o != null)
            {
                o.release();
                g.a("Releasing camera2");
                o = null;
            }
            return;
        }
        catch (Exception exception)
        {
            ExceptionReportService.report(exception);
        }
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        g.a((new StringBuilder()).append(n).append(" ").append(flag).append(getChildCount()).toString());
        if (a != null && (n || flag && getChildCount() > 0))
        {
            View view = getChildAt(0);
            Point point = com.socialin.android.util.l.a((Activity)getContext());
            i1 = point.x;
            j1 = point.y;
            if (a != null)
            {
                g.a("camera's not null");
                c = a(a, Math.max(i1, j1), Math.min(i1, j1), k, l);
                if (a != null)
                {
                    Object obj = a.getParameters();
                    ((android.hardware.Camera.Parameters) (obj)).setPreviewSize(c.a.width, c.a.height);
                    ((android.hardware.Camera.Parameters) (obj)).setPictureSize(c.b.width, c.b.height);
                    a(((android.hardware.Camera.Parameters) (obj)));
                    k1 = myobfuscated.f.m.a((Activity)getContext(), b);
                    a.stopPreview();
                    a.setDisplayOrientation(k1);
                    a.setParameters(((android.hardware.Camera.Parameters) (obj)));
                    if (i)
                    {
                        g.a("surface available, starting preview");
                        a.startPreview();
                    } else
                    {
                        g.a("surface isn't available");
                        j = true;
                    }
                }
            }
            obj = a(c.a);
            k1 = ((android.hardware.Camera.Size) (obj)).width;
            l1 = ((android.hardware.Camera.Size) (obj)).height;
            if (i1 * l1 > j1 * k1)
            {
                k1 = (k1 * j1) / l1;
                view.layout((i1 - k1) / 2, 0, (i1 + k1) / 2, j1);
                d.set((i1 - k1) / 2, 0, (k1 + i1) / 2, j1);
            } else
            {
                k1 = (l1 * i1) / k1;
                view.layout(0, (j1 - k1) / 2, i1, (j1 + k1) / 2);
                d.set(0, (j1 - k1) / 2, i1, (k1 + j1) / 2);
            }
            n = false;
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        setMeasuredDimension(resolveSize(getSuggestedMinimumWidth(), i1), resolveSize(getSuggestedMinimumHeight(), j1));
    }

    public void setCamera(Camera camera)
    {
        setCamera(camera, b);
    }

    public void setCamera(Camera camera, int i1)
    {
        b = i1;
        a = camera;
        g.a((new StringBuilder("camera index : ")).append(i1).toString());
        if (camera != null)
        {
            g.a("camera is not null");
            if (i)
            {
                try
                {
                    camera.setPreviewDisplay(h.getHolder());
                    g.a("preview set but not started");
                }
                // Misplaced declaration of an exception variable
                catch (Camera camera)
                {
                    g.a("Exception on set preview display");
                }
                n = true;
                post(new Runnable() {

                    private CameraPreviewContainer a;

                    public final void run()
                    {
                        a.requestLayout();
                    }

            
            {
                a = CameraPreviewContainer.this;
                super();
            }
                });
            }
        }
    }

    public void setOpenedCameraIndex(int i1)
    {
        b = i1;
    }

    public void setPictureSize(int i1, int j1)
    {
        k = i1;
        l = j1;
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
        i = true;
        if (j)
        {
            g.a("starting preview");
            a.startPreview();
            j = false;
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        i = true;
        try
        {
            if (a != null)
            {
                a.setPreviewDisplay(surfaceholder);
                g.a("preview display set");
                if (j)
                {
                    g.a("preview started");
                    a.startPreview();
                    j = false;
                }
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SurfaceHolder surfaceholder)
        {
            ExceptionReportService.report(surfaceholder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        i = false;
        if (a != null)
        {
            g.a("stopping preview");
            a.stopPreview();
        }
    }


    // Unreferenced inner class com/socialin/android/brushlib/camera/CameraPreviewContainer$2

/* anonymous class */
    public final class _cls2
        implements android.hardware.Camera.AutoFocusCallback
    {

        final AtomicBoolean a;
        final Runnable b;
        final com.socialin.android.brushlib.camera.a c;
        final CameraPreviewContainer d;

        public final void onAutoFocus(boolean flag, Camera camera)
        {
            if (!a.get())
            {
                try
                {
                    camera.takePicture(null, null, new android.hardware.Camera.PictureCallback(this) {

                        final _cls2 a;

                        public final void onPictureTaken(byte abyte0[], Camera camera)
                        {
    public final class _cls2
        implements android.hardware.Camera.AutoFocusCallback
    {
                            a.a.set(true);
                            if (a.b != null)
                            {
                                ((Activity)a.d.getContext()).runOnUiThread(a.b);
                            }
                            CameraPreviewContainer.c(a.d).execute(new Runnable(this, abyte0) {

                                private byte a[];
                                private _cls1 b;

                                public final void run()
                                {
                                    android.graphics.Bitmap bitmap;
                                    boolean flag;
                                    int j1;
                                    bitmap = BitmapFactory.decodeByteArray(a, 0, a.length);
                                    j1 = myobfuscated.f.m.a((Activity)b.a.d.getContext(), com.socialin.android.brushlib.camera.CameraPreviewContainer.a(b.a.d));
                                    int i1 = com.socialin.android.brushlib.camera.CameraPreviewContainer.a(b.a.d);
                                    if (android.os.Build.VERSION.SDK_INT < 9)
                                    {
                                        break MISSING_BLOCK_LABEL_150;
                                    }
                                    android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
                                    Camera.getCameraInfo(i1, camerainfo);
                                    if (camerainfo.facing != 1)
                                    {
                                        break MISSING_BLOCK_LABEL_150;
                                    }
                                    flag = true;
_L1:
                                    if (!flag)
                                    {
                                        bitmap = com.socialin.android.brushlib.util.b.a(bitmap, j1, false, false);
                                    } else
                                    if ((j1 / 90) % 2 == 1)
                                    {
                                        bitmap = com.socialin.android.brushlib.util.b.a(bitmap, j1, false, true);
                                    } else
                                    {
                                        bitmap = com.socialin.android.brushlib.util.b.a(bitmap, j1, true, false);
                                    }
                                    if (b.a.c != null)
                                    {
                                        b.a.c.a(bitmap);
                                    }
                                    com.socialin.android.brushlib.camera.CameraPreviewContainer.b(b.a.d);
                                    return;
                                    flag = false;
                                      goto _L1
                                }

            
            {
                b = _pcls1;
                a = abyte0;
                super();
            }
                            });
                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Camera camera)
                {
                    com.socialin.android.d.b(com.socialin.android.brushlib.camera.CameraPreviewContainer.d(), new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(camera.getMessage()).toString()
                    });
                }
                if (b != null)
                {
                    ((Activity)d.getContext()).runOnUiThread(b);
                }
                if (c != null)
                {
                    c.a(null);
                    return;
                }
            }
        }

            public 
            {
                d = CameraPreviewContainer.this;
                a = atomicboolean;
                b = runnable;
                c = a1;
                super();
            }
    }

}
