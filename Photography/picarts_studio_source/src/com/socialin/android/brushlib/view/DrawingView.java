// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v7.app.AppCompatDialog;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.gifencoder.GifEncoder;
import com.socialin.android.ads.SocialinAdManager;
import com.socialin.android.brushlib.Transform;
import com.socialin.android.brushlib.brush.Brush;
import com.socialin.android.brushlib.brush.BrushHistory;
import com.socialin.android.brushlib.brush.j;
import com.socialin.android.brushlib.controller.ShapeOverlayController;
import com.socialin.android.brushlib.controller.e;
import com.socialin.android.brushlib.controller.g;
import com.socialin.android.brushlib.controller.h;
import com.socialin.android.brushlib.gizmo.SimpleTransformGizmo;
import com.socialin.android.brushlib.input.TouchResponse;
import com.socialin.android.brushlib.layer.BlendMode;
import com.socialin.android.brushlib.layer.CameraMaskLayer;
import com.socialin.android.brushlib.overlay.EyeDropperOverlay;
import com.socialin.android.brushlib.overlay.ImageOverlay;
import com.socialin.android.brushlib.overlay.LineOverlay;
import com.socialin.android.brushlib.overlay.Overlay;
import com.socialin.android.brushlib.overlay.ShapeOverlay;
import com.socialin.android.brushlib.overlay.SvgClipArtOverlay;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.state.LayerMetaInfo;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.svg.ShapeParams;
import com.socialin.android.brushlib.svg.d;
import com.socialin.android.brushlib.textart.DrawTextStyle;
import com.socialin.android.brushlib.util.b;
import com.socialin.android.encoder.VideoEncoderDexLoader;
import com.socialin.android.photo.exception.InvalidIndexFileException;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.ak;
import com.socialin.android.util.l;
import com.socialin.android.videogenerator.ActionCollector;
import com.socialin.android.videogenerator.ProjectVideoGenerator;
import com.socialin.android.videogenerator.actions.LayerAdditionAction;
import com.socialin.android.videogenerator.actions.LayerConfigChangeAction;
import com.socialin.android.videogenerator.actions.OverlayAdditionAction;
import com.socialin.android.videogenerator.f;
import com.socialin.android.videogenerator.layer.LayerConfig;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.socialin.android.brushlib.view:
//            Camera, d, a, b, 
//            c, e

public class DrawingView extends ViewGroup
{

    public static float a;
    private static final String u = com/socialin/android/brushlib/view/DrawingView.getSimpleName();
    private Handler A;
    private com.socialin.android.brushlib.controller.f B;
    private com.socialin.android.brushlib.controller.d C;
    private com.socialin.android.brushlib.controller.b D;
    private Paint E;
    private com.picsart.studio.ads.h F;
    private List G;
    private List H;
    private Rect I;
    private Rect J;
    private Callable K;
    private com.socialin.android.brushlib.view.d L;
    private final Set M = new HashSet();
    private final Set N = new HashSet();
    private final com.socialin.android.brushlib.state.b O = new com.socialin.android.brushlib.state.b() {

        private DrawingView a;

        public final void a()
        {
            a.a(true);
        }

        public final void a(com.socialin.android.brushlib.layer.b b1)
        {
        }

        public final void b()
        {
        }

        public final void b(com.socialin.android.brushlib.layer.b b1)
        {
            a.a(true);
        }

        public final void c()
        {
        }

        public final void c(com.socialin.android.brushlib.layer.b b1)
        {
            a.a(true);
            DrawingView.c(a);
            com.socialin.android.brushlib.view.DrawingView.b(a);
        }

        public final void d(com.socialin.android.brushlib.layer.b b1)
        {
            a.a(true);
        }

        public final void e(com.socialin.android.brushlib.layer.b b1)
        {
        }

            
            {
                a = DrawingView.this;
                super();
            }
    };
    private final myobfuscated.br.b P = new myobfuscated.br.b() {

        public final void a(myobfuscated.br.a a1)
        {
        }

    };
    public RectF b;
    public a c;
    public Camera d;
    public Runnable e;
    public Runnable f;
    public com.socialin.android.brushlib.controller.a g;
    public e h;
    public ShapeOverlayController i;
    public g j;
    public h k;
    public int l;
    public BrushHistory m;
    public Dialog n;
    public com.socialin.android.brushlib.view.e o;
    public com.socialin.android.brushlib.input.d p;
    public EditingMode q;
    public boolean r;
    public volatile State s;
    public final Set t = new HashSet();
    private RectF v;
    private Paint w;
    private Paint x;
    private Paint y;
    private Drawable z;

    public DrawingView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = new RectF();
        v = new RectF();
        w = new Paint();
        x = new Paint();
        y = new Paint();
        A = new Handler(Looper.getMainLooper());
        E = new Paint();
        F = null;
        H = new ArrayList();
        I = new Rect();
        J = new Rect();
        new com.socialin.android.brushlib.brush.Brush.Params();
        s = State.UNINITIALIZED;
        com.socialin.android.brushlib.svg.d.a(context);
        a = TypedValue.applyDimension(1, 5F, context.getResources().getDisplayMetrics());
        n = new AppCompatDialog(context, 0x7f0c0184);
        n.setContentView(0x7f0300a6);
        n.setCancelable(false);
        n.setCanceledOnTouchOutside(false);
        m = BrushHistory.loadFromFile();
        k = new h(this);
        G = new LinkedList();
        w.setAntiAlias(true);
        w.setColor(0xff000000);
        w.setStyle(android.graphics.Paint.Style.STROKE);
        w.setStrokeWidth(3F);
        x.setFilterBitmap(true);
        x.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_ATOP));
        y.setPathEffect(new DashPathEffect(new float[] {
            10F, 10F
        }, 0.0F));
        y.setStyle(android.graphics.Paint.Style.STROKE);
        y.setColor(0xff000000);
        y.setStrokeWidth(1.0F);
        z = getResources().getDrawable(0x7f02011f);
        E.setStyle(android.graphics.Paint.Style.STROKE);
        E.setStrokeWidth(5F);
        E.setColor(0xffff0000);
    }

    private final Bitmap a(Bitmap bitmap, Bitmap bitmap1, Rect rect)
    {
        float f1 = Math.min((float)bitmap.getWidth() / (float)rect.width(), (float)bitmap.getHeight() / (float)rect.height());
        int j1 = bitmap.getWidth();
        int i1 = bitmap.getHeight();
        Object obj = new RectF(0.0F, 0.0F, j1, i1);
        j1 = (int)((float)j1 / f1);
        i1 = (int)((float)i1 / f1);
        Object obj1 = new RectF();
        ((RectF) (obj1)).set(0.0F, 0.0F, j1, i1);
        ((RectF) (obj1)).offset(-((float)j1 - v.width()) / 2.0F, -((float)i1 - v.height()) / 2.0F);
        rect = d;
        obj1.left = rect.d(((RectF) (obj1)).left);
        obj1.top = rect.e(((RectF) (obj1)).top);
        obj1.right = rect.d(((RectF) (obj1)).right);
        obj1.bottom = rect.e(((RectF) (obj1)).bottom);
        rect = new Matrix();
        rect.setRectToRect(((RectF) (obj)), ((RectF) (obj1)), android.graphics.Matrix.ScaleToFit.CENTER);
        obj = new Paint();
        ((Paint) (obj)).setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        (new Paint(2)).setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
        obj1 = Bitmap.createBitmap(c.d, c.e, android.graphics.Bitmap.Config.ARGB_8888);
        com.socialin.android.brushlib.util.b.a(bitmap, ((Bitmap) (obj1)), rect);
        if (bitmap1 != null)
        {
            (new Canvas(((Bitmap) (obj1)))).drawBitmap(bitmap1, 0.0F, 0.0F, ((Paint) (obj)));
        }
        return ((Bitmap) (obj1));
    }

    static a a(DrawingView drawingview)
    {
        return drawingview.c;
    }

    static a a(DrawingView drawingview, a a1)
    {
        drawingview.c = a1;
        return a1;
    }

    static Camera a(DrawingView drawingview, Camera camera)
    {
        drawingview.d = camera;
        return camera;
    }

    static State a(DrawingView drawingview, State state)
    {
        drawingview.s = state;
        return state;
    }

    static void a(DrawingView drawingview, com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions gifoptions)
    {
        Project project = drawingview.c.k;
        com.socialin.android.videogenerator.a a1 = com.socialin.android.videogenerator.a.a();
        gifoptions = new ProjectVideoGenerator(project, drawingview. new com.socialin.android.videogenerator.d(a1, gifoptions) {

            private Integer a;
            private boolean b;
            private com.socialin.android.videogenerator.a c;
            private com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions d;
            private DrawingView e;

            public final void a()
            {
                String s1 = e.getContext().getString(0x7f080663);
                if (a != null && a.intValue() == ProjectVideoGenerator.c)
                {
                    s1 = e.getContext().getString(0x7f08039a);
                }
                c.dismiss();
                Utils.b((Activity)e.getContext(), s1);
            }

            public final void a(int i1)
            {
                a = Integer.valueOf(i1);
            }

            public final void b()
            {
                c.getArguments().putSerializable("MODEL", d);
                c.a(d);
            }

            public final void b(int i1)
            {
                c.a.setProgress(i1);
                if (!b && DrawingView.i(e) != null)
                {
                    b = SocialinAdManager.a(com.socialin.android.ads.SocialinAdManager.PicsArtInterstitialType.DRAW);
                }
            }

            
            {
                e = DrawingView.this;
                c = a1;
                d = gifoptions;
                super();
                a = null;
                b = false;
            }
        }, gifoptions, new GifEncoder());
        gifoptions.a();
        a1.setCancelable(false);
        a1.show(((Activity)drawingview.getContext()).getFragmentManager(), null);
        a1.a(drawingview.getContext().getString(0x7f080295), new android.view.View.OnClickListener(a1, gifoptions) {

            private com.socialin.android.videogenerator.a a;
            private ProjectVideoGenerator b;

            public final void onClick(View view)
            {
                if (a != null && b != null)
                {
                    b.b();
                    a.dismiss();
                }
            }

            
            {
                a = a1;
                b = projectvideogenerator;
                super();
            }
        });
    }

    static void a(DrawingView drawingview, com.socialin.android.videogenerator.ProjectVideoGenerator.VideoOptions videooptions)
    {
        Project project = drawingview.c.k;
        f f1 = com.socialin.android.videogenerator.f.a();
        com.socialin.android.videogenerator.d d1 = drawingview. new com.socialin.android.videogenerator.d(f1, videooptions) {

            private Integer a;
            private boolean b;
            private f c;
            private com.socialin.android.videogenerator.ProjectVideoGenerator.VideoOptions d;
            private DrawingView e;

            public final void a()
            {
                String s1 = e.getContext().getString(0x7f080663);
                if (a != null && a.intValue() == ProjectVideoGenerator.c)
                {
                    s1 = e.getContext().getString(0x7f08039a);
                }
                c.dismiss();
                Utils.b((Activity)e.getContext(), s1);
            }

            public final void a(int j1)
            {
                a = Integer.valueOf(j1);
            }

            public final void b()
            {
                c.getArguments().putSerializable("MODEL", d);
                c.a(d);
            }

            public final void b(int j1)
            {
                c.a.setProgress(j1);
                if (!b && DrawingView.i(e) != null)
                {
                    b = SocialinAdManager.a(com.socialin.android.ads.SocialinAdManager.PicsArtInterstitialType.DRAW);
                }
            }

            
            {
                e = DrawingView.this;
                c = f1;
                d = videooptions;
                super();
                a = null;
                b = false;
            }
        };
        Resources resources = drawingview.getResources();
        int i1;
        if (videooptions.getResolution() == com.socialin.android.videogenerator.ProjectVideoGenerator.VideoResolution.p1080)
        {
            i1 = 0x7f0205cc;
        } else
        {
            i1 = 0x7f0205cd;
        }
        videooptions = new ProjectVideoGenerator(project, d1, videooptions, BitmapFactory.decodeResource(resources, i1), VideoEncoderDexLoader.loadDexEncoder(drawingview.getContext()));
        videooptions.a();
        f1.setCancelable(false);
        f1.show(((Activity)drawingview.getContext()).getFragmentManager(), null);
        f1.a(drawingview.getContext().getString(0x7f080295), new android.view.View.OnClickListener(f1, videooptions) {

            private f a;
            private ProjectVideoGenerator b;

            public final void onClick(View view)
            {
                if (a != null && b != null)
                {
                    b.b();
                    a.dismiss();
                }
            }

            
            {
                a = f1;
                b = projectvideogenerator;
                super();
            }
        });
    }

    static e b(DrawingView drawingview)
    {
        return drawingview.h;
    }

    private void b(Bitmap bitmap, com.socialin.android.brushlib.b b1, int i1, int j1)
    {
        if (s == State.INITIALIZING)
        {
            return;
        } else
        {
            s = State.INITIALIZING;
            (new AsyncTask(i1, j1, bitmap, b1) {

                final DrawingView a;
                private int b;
                private int c;
                private Bitmap d;
                private com.socialin.android.brushlib.b e;

                protected final Object doInBackground(Object aobj[])
                {
                    aobj = DrawingView.n();
                    aobj = new Project(new File(com.socialin.android.brushlib.project.a.d, ((String) (aobj))), true);
                    com.socialin.android.brushlib.view.DrawingView.a(a, new a(a, ((Project) (aobj)), b, c));
                    com.socialin.android.brushlib.view.DrawingView.a(a).f.a(com.socialin.android.brushlib.view.DrawingView.d(a));
                    com.socialin.android.brushlib.view.DrawingView.a(a).a(com.socialin.android.brushlib.view.DrawingView.e(a));
                    com.socialin.android.brushlib.layer.b b2;
                    if (d != null)
                    {
                        aobj = com.socialin.android.brushlib.layer.b.a(d, b, c, e);
                    } else
                    {
                        aobj = com.socialin.android.brushlib.layer.b.a(com.socialin.android.brushlib.view.DrawingView.a(a).d, com.socialin.android.brushlib.view.DrawingView.a(a).e, -1);
                    }
                    b2 = com.socialin.android.brushlib.layer.b.a(com.socialin.android.brushlib.view.DrawingView.a(a).d, com.socialin.android.brushlib.view.DrawingView.a(a).e);
                    com.socialin.android.brushlib.view.DrawingView.a(a, com.socialin.android.brushlib.view.Camera.a());
                    if (a.getWidth() != 0 && a.getHeight() != 0)
                    {
                        com.socialin.android.brushlib.view.DrawingView.h(a).a(a.getWidth(), a.getHeight());
                        a.post(new Runnable(this) {

                            private _cls11 a;

                            public final void run()
                            {
                                a.a.a();
                            }

            
            {
                a = _pcls11;
                super();
            }
                        });
                    }
                    com.socialin.android.brushlib.view.DrawingView.f(a);
                    ((Activity)a.getContext()).runOnUiThread(new Runnable(this, ((com.socialin.android.brushlib.layer.b) (aobj)), b2) {

                        private com.socialin.android.brushlib.layer.b a;
                        private com.socialin.android.brushlib.layer.b b;
                        private _cls11 c;

                        public final void run()
                        {
                            int i1 = 0;
                            com.socialin.android.brushlib.view.DrawingView.a(c.a, State.INITIALIZED);
                            com.socialin.android.brushlib.view.DrawingView.g(c.a);
                            if (c.a.getWidth() != 0 && c.a.getHeight() != 0)
                            {
                                com.socialin.android.brushlib.view.DrawingView.h(c.a).a(c.a.getWidth(), c.a.getHeight());
                                c.a.a();
                            }
                            a a1 = com.socialin.android.brushlib.view.DrawingView.a(c.a);
                            com.socialin.android.brushlib.layer.b b1 = a;
                            com.socialin.android.brushlib.layer.b b2 = b;
                            for (; i1 < 2; i1++)
                            {
                                com.socialin.android.brushlib.layer.b b3 = (new com.socialin.android.brushlib.layer.b[] {
                                    b1, b2
                                })[i1];
                                a1.a.add(b3);
                                a1.f(b3);
                                LayerAdditionAction layeradditionaction = new LayerAdditionAction(UUID.fromString(b3.c), null, null);
                                ActionCollector.a().a(layeradditionaction);
                                a1.f.a(b3, new com.socialin.android.brushlib.state.a._cls2(layeradditionaction, b3));
                            }

                            a1.f.a(a1.a(null));
                            com.socialin.android.brushlib.view.DrawingView.a(c.a).a(b);
                            c.a.invalidate();
                        }

            
            {
                c = _pcls11;
                a = b1;
                b = b2;
                super();
            }
                    });
                    return null;
                }

            
            {
                a = DrawingView.this;
                b = i1;
                c = j1;
                d = bitmap;
                e = b1;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
    }

    private void b(MotionEvent motionevent)
    {
        int i1 = 0;
_L2:
        com.socialin.android.brushlib.input.d d1;
        Object obj;
        if (i1 >= G.size())
        {
            break MISSING_BLOCK_LABEL_151;
        }
        d1 = (com.socialin.android.brushlib.input.d)G.get(i1);
        if (d1 != p)
        {
            obj = d1.a(motionevent);
            if (obj != TouchResponse.UNDEFINED)
            {
                break; /* Loop/switch isn't completed */
            }
            H.add(d1);
        }
_L3:
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        if (obj == TouchResponse.ACCEPT)
        {
            p = d1;
            for (motionevent = H.iterator(); motionevent.hasNext();)
            {
                obj = (com.socialin.android.brushlib.input.d)motionevent.next();
                if (obj != d1)
                {
                    ((com.socialin.android.brushlib.input.d) (obj)).d();
                }
            }

            break MISSING_BLOCK_LABEL_151;
        }
        if (obj == TouchResponse.REJECT)
        {
            H.remove(d1);
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    static ShapeOverlayController c(DrawingView drawingview)
    {
        return drawingview.i;
    }

    static myobfuscated.br.b d(DrawingView drawingview)
    {
        return drawingview.P;
    }

    static com.socialin.android.brushlib.state.b e(DrawingView drawingview)
    {
        return drawingview.O;
    }

    static int f(DrawingView drawingview)
    {
        drawingview.l = 0xff000000;
        return 0xff000000;
    }

    static void g(DrawingView drawingview)
    {
        if (drawingview.L != null)
        {
            drawingview.L.a();
        }
    }

    static Camera h(DrawingView drawingview)
    {
        return drawingview.d;
    }

    static com.picsart.studio.ads.h i(DrawingView drawingview)
    {
        return drawingview.F;
    }

    static Handler j(DrawingView drawingview)
    {
        return drawingview.A;
    }

    public static int k()
    {
        return PicsartContext.a.getMaxDrawingLayersCount();
    }

    static String m()
    {
        return u;
    }

    static String n()
    {
        int i1 = 1;
        File file = new File(com.socialin.android.brushlib.project.a.d);
        Object obj = Calendar.getInstance();
        obj = (new StringBuilder("Draft ")).append(((Calendar) (obj)).get(5)).append(".").append(((Calendar) (obj)).get(2)).append(".").append(((Calendar) (obj)).get(1)).toString();
        if (!(new File(file, ((String) (obj)))).exists())
        {
            return ((String) (obj));
        }
        String s1;
        while ((new File(file, s1 = (new StringBuilder()).append(((String) (obj))).append(" (").append(i1).append(")").toString())).exists()) 
        {
            i1++;
        }
        return s1;
    }

    private void o()
    {
        C = new com.socialin.android.brushlib.controller.d(this);
        g = new com.socialin.android.brushlib.controller.a(this);
        h = new e(this);
        i = new ShapeOverlayController(this);
        j = new g(this);
        D = new com.socialin.android.brushlib.controller.b(this);
        B = new com.socialin.android.brushlib.controller.f(getContext(), new Runnable() {

            private DrawingView a;

            public final void run()
            {
                a.setEditingMode(EditingMode.COLOR_PICKER);
                a.a(true);
            }

            
            {
                a = DrawingView.this;
                super();
            }

            private class EditingMode extends Enum
            {

                private static final EditingMode $VALUES[];
                public static final EditingMode BRUSH;
                public static final EditingMode CAMERA;
                public static final EditingMode COLOR_PICKER;
                public static final EditingMode LAYER_TRANSFORM;
                public static final EditingMode PHOTO;
                public static final EditingMode SHAPE;
                public static final EditingMode TEXT;

                public static EditingMode valueOf(String s1)
                {
                    return (EditingMode)Enum.valueOf(com/socialin/android/brushlib/view/DrawingView$EditingMode, s1);
                }

                public static EditingMode[] values()
                {
                    return (EditingMode[])$VALUES.clone();
                }

                static 
                {
                    BRUSH = new EditingMode("BRUSH", 0);
                    SHAPE = new EditingMode("SHAPE", 1);
                    TEXT = new EditingMode("TEXT", 2);
                    COLOR_PICKER = new EditingMode("COLOR_PICKER", 3);
                    PHOTO = new EditingMode("PHOTO", 4);
                    CAMERA = new EditingMode("CAMERA", 5);
                    LAYER_TRANSFORM = new EditingMode("LAYER_TRANSFORM", 6);
                    $VALUES = (new EditingMode[] {
                        BRUSH, SHAPE, TEXT, COLOR_PICKER, PHOTO, CAMERA, LAYER_TRANSFORM
                    });
                }

                private EditingMode(String s1, int i1)
                {
                    super(s1, i1);
                }
            }

        });
        a(g);
        a(i);
        a(j);
        a(g);
        a(i);
        a(j);
        for (Iterator iterator = G.iterator(); iterator.hasNext(); ((com.socialin.android.brushlib.input.d)iterator.next()).d()) { }
        G.clear();
        G.add(B);
        G.add(g);
        G.add(D);
    }

    public final void a()
    {
        RectF rectf = new RectF(0.0F, 0.0F, getWidth(), getHeight());
        RectF rectf1 = (RectF)K.call();
        rectf = rectf1;
_L2:
        D.a(new RectF(0.0F, 0.0F, c.d, c.e), rectf);
        a(true);
        return;
        Exception exception;
        exception;
        com.socialin.android.d.b(u, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
        });
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void a(int i1, int j1)
    {
        if (c != null)
        {
            c.f();
        }
        s = State.UNINITIALIZED;
        o();
        b(null, null, i1, j1);
    }

    public final void a(Bitmap bitmap)
    {
        Object obj = c;
        bitmap = new Canvas(bitmap);
        for (obj = ((a) (obj)).a.iterator(); ((Iterator) (obj)).hasNext(); ((com.socialin.android.brushlib.layer.b)((Iterator) (obj)).next()).a(bitmap)) { }
    }

    public final void a(Bitmap bitmap, com.socialin.android.brushlib.b b1, int i1, int j1)
    {
        if (c != null)
        {
            c.f();
        }
        s = State.UNINITIALIZED;
        o();
        b(bitmap, b1, i1, j1);
    }

    public final void a(RectF rectf)
    {
        rectf.roundOut(I);
        invalidate(I.left, I.top, I.right, I.bottom);
    }

    public final void a(Project project)
    {
        if (c != null)
        {
            c.f();
        }
        s = State.UNINITIALIZED;
        o();
        if (s != State.INITIALIZING)
        {
            s = State.INITIALIZING;
            (new ModernAsyncTask(project) {

                final Project a;
                final DrawingView b;

                private transient Void a()
                {
                    Object obj;
                    try
                    {
                        obj = myobfuscated.br.d.a(a);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        com.socialin.android.d.b(DrawingView.m(), new Object[] {
                            (new StringBuilder("Got unexpected exception: ")).append(((InvalidIndexFileException) (obj)).getMessage()).toString()
                        });
                        obj = null;
                    }
                    if (obj == null || ((myobfuscated.br.e) (obj)).e() || ((myobfuscated.br.e) (obj)).c() == null || ((Snapshot)((myobfuscated.br.e) (obj)).c()).layerInfoList == null)
                    {
                        b.post(new Runnable(this) {

                            private _cls10 a;

                            public final void run()
                            {
                                Toast.makeText(a.b.getContext(), a.b.getResources().getString(0x7f08009c, new Object[] {
                                    a.a.getDisplayName()
                                }), 0).show();
                            }

            
            {
                a = _pcls10;
                super();
            }
                        });
                        b.b(true);
                        ((Activity)b.getContext()).finish();
                        return null;
                    } else
                    {
                        Snapshot snapshot = (Snapshot)((myobfuscated.br.e) (obj)).c();
                        LayerMetaInfo layermetainfo = (LayerMetaInfo)snapshot.layerInfoList.get(0);
                        com.socialin.android.brushlib.view.DrawingView.a(b, new a(b, a, layermetainfo.width, layermetainfo.height, ((myobfuscated.br.e) (obj))));
                        com.socialin.android.brushlib.view.DrawingView.a(b).f.a(com.socialin.android.brushlib.view.DrawingView.d(b));
                        com.socialin.android.brushlib.view.DrawingView.a(b).a(com.socialin.android.brushlib.view.DrawingView.e(b));
                        com.socialin.android.brushlib.view.DrawingView.a(b).f.b(snapshot);
                        com.socialin.android.brushlib.view.DrawingView.a(b, com.socialin.android.brushlib.view.Camera.a());
                        com.socialin.android.brushlib.view.DrawingView.f(b);
                        ((Activity)b.getContext()).runOnUiThread(new Runnable(this, snapshot) {

                            private Snapshot a;
                            private _cls10 b;

                            public final void run()
                            {
                                com.socialin.android.brushlib.view.DrawingView.a(b.b, State.INITIALIZED);
                                com.socialin.android.brushlib.view.DrawingView.g(b.b);
                                if (b.b.getWidth() != 0 && b.b.getHeight() != 0)
                                {
                                    com.socialin.android.brushlib.view.DrawingView.h(b.b).a(b.b.getWidth(), b.b.getHeight());
                                    b.b.a();
                                }
                                com.socialin.android.brushlib.layer.b b1;
                                for (Iterator iterator = Collections.unmodifiableList(com.socialin.android.brushlib.view.DrawingView.a(b.b).a).iterator(); iterator.hasNext(); com.socialin.android.brushlib.view.DrawingView.a(b.b).f(b1))
                                {
                                    b1 = (com.socialin.android.brushlib.layer.b)iterator.next();
                                }

                                com.socialin.android.brushlib.view.DrawingView.a(b.b).a((com.socialin.android.brushlib.layer.b)Collections.unmodifiableList(com.socialin.android.brushlib.view.DrawingView.a(b.b).a).get(a.selectedLayerIndex));
                                b.b.invalidate();
                            }

            
            {
                b = _pcls10;
                a = snapshot;
                super();
            }
                        });
                        return null;
                    }
                }

                protected final Object doInBackground(Object aobj[])
                {
                    return a();
                }

            public 
            {
                b = DrawingView.this;
                a = project;
                super();
            }
            }).execute(new Void[0]);
        }
    }

    public final void a(com.socialin.android.brushlib.view.a a1)
    {
        M.add(a1);
    }

    public final void a(com.socialin.android.brushlib.view.b b1)
    {
        N.add(b1);
    }

    public final void a(Runnable runnable)
    {
        ScheduledExecutorService scheduledexecutorservice = Executors.newSingleThreadScheduledExecutor();
        scheduledexecutorservice.schedule(new Runnable(runnable, scheduledexecutorservice) {

            final Runnable a;
            private ScheduledExecutorService b;
            private DrawingView c;

            public final void run()
            {
                if (!c.c.f.b())
                {
                    com.socialin.android.brushlib.view.DrawingView.j(c).post(new Runnable(this) {

                        private _cls5 a;

                        public final void run()
                        {
                            a.a.run();
                        }

            
            {
                a = _pcls5;
                super();
            }
                    });
                    b.shutdown();
                    return;
                } else
                {
                    b.schedule(this, 500L, TimeUnit.MILLISECONDS);
                    return;
                }
            }

            
            {
                c = DrawingView.this;
                a = runnable;
                b = scheduledexecutorservice;
                super();
            }
        }, 500L, TimeUnit.MILLISECONDS);
    }

    public final void a(boolean flag)
    {
        if (flag)
        {
            invalidate();
            return;
        } else
        {
            postInvalidate();
            return;
        }
    }

    public final boolean a(MotionEvent motionevent)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (c == null) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (!c.l) goto _L2; else goto _L3
_L3:
        if (motionevent.getActionMasked() != 0) goto _L5; else goto _L4
_L4:
        p = null;
_L9:
        b(motionevent);
_L11:
        if (p != null) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (H.size() <= 0) goto _L2; else goto _L7
_L7:
        flag = true;
_L2:
        return flag;
_L5:
        if (p == null) goto _L9; else goto _L8
_L8:
        TouchResponse touchresponse = p.a(motionevent);
        public final class _cls9
        {

            public static final int a[];
            static final int b[];
            public static final int c[];

            static 
            {
                c = new int[EditingMode.values().length];
                try
                {
                    c[EditingMode.TEXT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    c[EditingMode.BRUSH.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    c[EditingMode.COLOR_PICKER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    c[EditingMode.PHOTO.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    c[EditingMode.SHAPE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    c[EditingMode.CAMERA.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    c[EditingMode.LAYER_TRANSFORM.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                b = new int[TouchResponse.values().length];
                try
                {
                    b[TouchResponse.REJECT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    b[TouchResponse.UNDEFINED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    b[TouchResponse.ACCEPT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                a = new int[State.values().length];
                try
                {
                    a[State.INITIALIZED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[State.INITIALIZING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[State.UNINITIALIZED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.socialin.android.brushlib.view._cls9.b[touchresponse.ordinal()])
        {
        case 1: // '\001'
            p = null;
            // fall through

        case 2: // '\002'
            H.clear();
            b(motionevent);
            break;
        }
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final int b(int i1, int j1)
    {
        return c.b((int)d.d(i1), (int)d.e(j1));
    }

    public final DrawingMode b()
    {
        if (c != null)
        {
            return c.h;
        } else
        {
            return DrawingMode.DRAW;
        }
    }

    public final void b(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        com.socialin.android.brushlib.svg.d.a(null);
        if (c != null)
        {
            myobfuscated.br.a a1 = c.f;
            if (!c.f.b())
            {
                c.f();
            }
        }
        ActionCollector actioncollector = ActionCollector.a();
        if (actioncollector.c)
        {
            actioncollector.a.execute(new com.socialin.android.videogenerator.ActionCollector._cls2(actioncollector));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean c()
    {
        return s == State.INITIALIZED;
    }

    public final void d()
    {
        a a1 = c;
        if (a1.j != null)
        {
            a1.d();
        }
        setCameraDrawingOn(false);
    }

    public final EditingMode e()
    {
        if (c == null)
        {
            return EditingMode.BRUSH;
        } else
        {
            return c.i;
        }
    }

    public final int f()
    {
        if (c != null)
        {
            return c.d;
        } else
        {
            return 0;
        }
    }

    public final int g()
    {
        if (c != null)
        {
            return c.e;
        } else
        {
            return 0;
        }
    }

    public final int h()
    {
        return c.a.size();
    }

    public final boolean i()
    {
        this;
        JVM INSTR monitorenter ;
        return false;
    }

    public final RectF j()
    {
        RectF rectf = new RectF(0.0F, 0.0F, c.d, c.e);
        d.a(rectf);
        return rectf;
    }

    public final void l()
    {
        Toast.makeText(getContext(), 0x7f0804cb, 0).show();
    }

    protected void onDraw(Canvas canvas)
    {
        com.socialin.android.brushlib.view._cls9.a[s.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 43
    //                   2 37
    //                   3 37;
           goto _L1 _L2 _L3 _L3
_L1:
        return;
_L3:
        canvas.drawColor(-1);
        return;
_L2:
        a a1 = c;
        if (a1.j == null || !a1.j.d.f || !a1.a.contains(a1.j.d)) goto _L5; else goto _L4
_L4:
        int i1 = a1.a.indexOf(a1.j.d);
        com.socialin.android.brushlib.state.a._cls4.a[a1.j.c.ordinal()];
        JVM INSTR tableswitch 1 2: default 140
    //                   1 206
    //                   2 209;
           goto _L6 _L6 _L7
_L7:
        i1--;
_L6:
        com.socialin.android.brushlib.layer.b b1 = a1.e();
        int j1 = 0;
        while (j1 <= i1) 
        {
            com.socialin.android.brushlib.layer.b b3 = (com.socialin.android.brushlib.layer.b)a1.a.get(j1);
            if (b3.f)
            {
                boolean flag1;
                if (b3 != b1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                a1.a(canvas, b3, flag1);
            }
            j1++;
        }
        a1.g.d.b(canvas);
        a1.j.a(canvas);
        canvas.restore();
        i1++;
        while (i1 < a1.a.size()) 
        {
            com.socialin.android.brushlib.layer.b b4 = (com.socialin.android.brushlib.layer.b)a1.a.get(i1);
            if (b4.f)
            {
                boolean flag2;
                if (b4 != b1)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                a1.a(canvas, b4, flag2);
            }
            i1++;
        }
        canvas.save();
        if (a1.c != null)
        {
            a1.c.a(canvas);
        }
        canvas.restore();
        return;
_L5:
        DrawingView drawingview = a1.g;
        drawingview.j().roundOut(drawingview.J);
        drawingview.J.inset(2, 2);
        drawingview.z.setBounds(drawingview.J);
        drawingview.z.draw(canvas);
        if (a1.a.size() <= 1) goto _L9; else goto _L8
_L8:
        Iterator iterator = a1.a.iterator();
_L12:
        if (!iterator.hasNext()) goto _L9; else goto _L10
_L10:
        if (((com.socialin.android.brushlib.layer.b)iterator.next()).g == BlendMode.NORMAL) goto _L12; else goto _L11
_L11:
        boolean flag = true;
          goto _L13
_L9:
        flag = false;
_L13:
        if (flag)
        {
            canvas.saveLayer(0.0F, 0.0F, a1.g.getWidth(), a1.g.getHeight(), null, 31);
        }
        com.socialin.android.brushlib.layer.b b2 = a1.e();
        Iterator iterator1 = a1.a.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            com.socialin.android.brushlib.layer.b b5 = (com.socialin.android.brushlib.layer.b)iterator1.next();
            if (b5.f)
            {
                boolean flag3;
                if (b5 != b2)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                a1.a(canvas, b5, flag3);
            }
        } while (true);
        canvas.save();
        if (a1.c != null)
        {
            a1.c.a(canvas);
        }
        canvas.restore();
        if (flag)
        {
            canvas.restore();
            return;
        }
        if (true) goto _L1; else goto _L14
_L14:
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        Point point = com.socialin.android.util.l.a((Activity)getContext());
        v.set(0.0F, 0.0F, point.x, point.y);
        if (d != null)
        {
            d.a(i1, j1);
        }
    }

    public void setBrush(Brush brush)
    {
        com.socialin.android.brushlib.controller.a a1 = g;
        a1.a(brush);
        a1.c = brush;
        if (!(brush instanceof j))
        {
            if (a1.e.b() != null)
            {
                brush.a(a1.e.b());
            } else
            {
                brush.a(DrawingMode.DRAW);
            }
        }
        brush.b(a1.d);
    }

    public void setBrushHistory(BrushHistory brushhistory)
    {
        m = brushhistory;
    }

    public void setBrushParams(com.socialin.android.brushlib.brush.Brush.Params params)
    {
        com.socialin.android.brushlib.controller.a a1 = g;
        a1.c.a(params);
        a1.d.set(params);
    }

    public void setCameraDrawingOn(boolean flag)
    {
        Object obj;
        r = flag;
        obj = i;
        if (((com.socialin.android.brushlib.a) (obj)).a == null) goto _L2; else goto _L1
_L1:
        Overlay overlay = ((com.socialin.android.brushlib.a) (obj)).a;
        if (!(overlay instanceof ShapeOverlay)) goto _L4; else goto _L3
_L3:
        ShapeParams shapeparams = ((ShapeOverlay)overlay).getParams();
        if (flag)
        {
            shapeparams.setMode(DrawingMode.ERASE);
        } else
        {
            shapeparams.setMode(((ShapeOverlayController) (obj)).b.b());
        }
        ((ShapeOverlay)overlay).setParams(shapeparams);
_L6:
        ((ShapeOverlayController) (obj)).b.a(true);
_L2:
        obj = g;
        ((com.socialin.android.brushlib.controller.a) (obj)).a(((com.socialin.android.brushlib.controller.a) (obj)).c);
        return;
_L4:
        if (overlay instanceof LineOverlay)
        {
            ShapeParams shapeparams1 = ((LineOverlay)overlay).getParams();
            if (flag)
            {
                shapeparams1.setMode(DrawingMode.ERASE);
            } else
            {
                shapeparams1.setMode(((ShapeOverlayController) (obj)).b.b());
            }
            ((LineOverlay)overlay).setParams(shapeparams1);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setCapturedPicture(Bitmap bitmap, Rect rect, Rect rect1, Runnable runnable)
    {
        if (c.j.c == com.socialin.android.brushlib.layer.CameraMaskLayer.MaskPlacement.ABOVE)
        {
            rect = Bitmap.createBitmap(c.d, c.e, android.graphics.Bitmap.Config.ALPHA_8);
            rect.eraseColor(-1);
            Canvas canvas = new Canvas(rect);
            c.j.a(canvas);
            post(new Runnable(a(bitmap, rect, rect1), rect, runnable) {

                final Bitmap a;
                final Runnable b;
                private Bitmap c;
                private DrawingView d;

                public final void run()
                {
                    Object obj = com.socialin.android.brushlib.view.DrawingView.a(d).j.d;
                    Object obj1 = new ImageOverlay(c, d.c.k.getImageDataFolder());
                    ((ImageOverlay) (obj1)).getTransform().setPosition((float)com.socialin.android.brushlib.view.DrawingView.a(d).d / 2.0F, (float)com.socialin.android.brushlib.view.DrawingView.a(d).e / 2.0F);
                    ((ImageOverlay) (obj1)).draw(((com.socialin.android.brushlib.layer.b) (obj)).j);
                    ActionCollector.a().a(new OverlayAdditionAction(((Overlay) (obj1)), UUID.fromString(((com.socialin.android.brushlib.layer.b) (obj)).c), d.c.f.d().key));
                    obj = com.socialin.android.brushlib.view.DrawingView.a(d);
                    obj1 = com.socialin.android.brushlib.view.DrawingView.a(d).j.d;
                    Runnable runnable1 = new Runnable(this) {

                        private _cls12 a;

                        public final void run()
                        {
                            a.a.recycle();
                            a.b.run();
                        }

            
            {
                a = _pcls12;
                super();
            }
                    };
                    ((a) (obj)).f.b(((com.socialin.android.brushlib.layer.a) (obj1)), runnable1);
                }

            
            {
                d = DrawingView.this;
                c = bitmap;
                a = bitmap1;
                b = runnable;
                super();
            }
            });
            return;
        } else
        {
            bitmap = a(bitmap, null, rect1);
            c.a(c.j.d, bitmap);
            post(new Runnable(runnable) {

                private Runnable a;
                private DrawingView b;

                public final void run()
                {
                    b.a(true);
                    com.socialin.android.brushlib.view.DrawingView.a(b).c(com.socialin.android.brushlib.view.DrawingView.a(b).j.d);
                    a.run();
                }

            
            {
                b = DrawingView.this;
                a = runnable;
                super();
            }
            });
            return;
        }
    }

    public void setClipArtData(byte abyte0[])
    {
        if (((com.socialin.android.brushlib.a) (h)).a != null)
        {
            h.d();
        }
        setEditingMode(EditingMode.PHOTO);
        h.a(new SvgClipArtOverlay(abyte0));
    }

    public void setCurrentColor(int i1)
    {
        l = i1;
        for (Iterator iterator = M.iterator(); iterator.hasNext(); ((com.socialin.android.brushlib.view.a)iterator.next()).a(i1)) { }
    }

    public void setDrawingMode(DrawingMode drawingmode)
    {
        if (c == null || drawingmode == c.h) goto _L2; else goto _L1
_L1:
        c.h = drawingmode;
        for (Iterator iterator = N.iterator(); iterator.hasNext(); ((com.socialin.android.brushlib.view.b)iterator.next()).a(drawingmode)) { }
        com.socialin.android.brushlib.brush.Brush.Params params;
        ak ak1;
        int i1;
        boolean flag;
        if (drawingmode == DrawingMode.ERASE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        drawingmode = Brush.a(getContext(), m.getSelectedBrushId(flag));
        params = m.getBrushSelectedParams(m.getSelectedBrushId(flag), flag);
        params.setColorRGB(l);
        if (!(drawingmode instanceof j)) goto _L4; else goto _L3
_L3:
        ak1 = ak.a(getContext(), "drawing");
        i1 = m.getSelectedStickerIndex();
        ((j)drawingmode).a(ak1.b(i1));
        drawingmode.a(com.socialin.android.util.d.a(ak1.c(i1)));
        ((j)drawingmode).c = i1;
_L6:
        setBrush(drawingmode);
        setBrushParams(params);
_L2:
        return;
_L4:
        if (drawingmode instanceof com.socialin.android.brushlib.brush.f)
        {
            ((com.socialin.android.brushlib.brush.f)drawingmode).c = m.getSelectedShapeName();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setEditingMode(EditingMode editingmode)
    {
        if (c != null) goto _L2; else goto _L1
_L1:
        EditingMode editingmode1;
        return;
_L2:
        if (editingmode == (editingmode1 = c.i)) goto _L1; else goto _L3
_L3:
        q = editingmode1;
        c.i = editingmode;
        for (Iterator iterator = t.iterator(); iterator.hasNext(); ((c)iterator.next()).a(editingmode)) { }
        _cls9.c[editingmode.ordinal()];
        JVM INSTR tableswitch 1 7: default 124
    //                   1 125
    //                   2 180
    //                   3 295
    //                   4 828
    //                   5 929
    //                   6 1101
    //                   7 1185;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L4:
        return;
_L6:
        p = g;
        c.c = g;
        for (editingmode = G.iterator(); editingmode.hasNext(); ((com.socialin.android.brushlib.input.d)editingmode.next()).d()) { }
        G.clear();
        G.add(B);
        G.add(D);
        G.add(g);
        D.a = false;
        return;
_L7:
        if (!B.c) goto _L13; else goto _L12
_L12:
        editingmode = C;
        obj = B;
        PointF pointf = new PointF(((com.socialin.android.brushlib.controller.f) (obj)).a, ((com.socialin.android.brushlib.controller.f) (obj)).b);
        System.out.println(((com.socialin.android.brushlib.a) (editingmode)).a);
        obj = ((com.socialin.android.brushlib.controller.d) (editingmode)).b.j();
        ((com.socialin.android.brushlib.controller.d) (editingmode)).f.set(pointf);
        pointf = ((com.socialin.android.brushlib.controller.d) (editingmode)).f;
        pointf.y = pointf.y - TypedValue.applyDimension(1, EyeDropperOverlay.getRadiusDip(), ((com.socialin.android.brushlib.controller.d) (editingmode)).b.getResources().getDisplayMetrics());
        if (((RectF) (obj)).contains(((com.socialin.android.brushlib.controller.d) (editingmode)).f.x, ((com.socialin.android.brushlib.controller.d) (editingmode)).f.y)) goto _L15; else goto _L14
_L14:
        if (((com.socialin.android.brushlib.controller.d) (editingmode)).f.x <= ((RectF) (obj)).right) goto _L17; else goto _L16
_L16:
        ((com.socialin.android.brushlib.controller.d) (editingmode)).f.x = (float)Math.floor(((RectF) (obj)).right);
_L21:
        if (((com.socialin.android.brushlib.controller.d) (editingmode)).f.y > ((RectF) (obj)).bottom)
        {
            ((com.socialin.android.brushlib.controller.d) (editingmode)).f.y = (float)Math.floor(((RectF) (obj)).bottom);
        } else
        if (((com.socialin.android.brushlib.controller.d) (editingmode)).f.y < ((RectF) (obj)).top)
        {
            ((com.socialin.android.brushlib.controller.d) (editingmode)).f.y = (float)Math.ceil(((RectF) (obj)).top);
        }
_L15:
        B.c = false;
_L19:
        p = C;
        editingmode = C;
        editingmode.a(new EyeDropperOverlay(((com.socialin.android.brushlib.controller.d) (editingmode)).b));
        ((com.socialin.android.brushlib.a) (editingmode)).a.getTransform().setPosition(((com.socialin.android.brushlib.controller.d) (editingmode)).f).setScale(0.0F);
        ((EyeDropperOverlay)((com.socialin.android.brushlib.a) (editingmode)).a).setColor(((com.socialin.android.brushlib.controller.d) (editingmode)).b.b((int)((com.socialin.android.brushlib.controller.d) (editingmode)).f.x, (int)((com.socialin.android.brushlib.controller.d) (editingmode)).f.y));
        ((EyeDropperOverlay)((com.socialin.android.brushlib.a) (editingmode)).a).setLastPickedColor(((com.socialin.android.brushlib.controller.d) (editingmode)).b.l);
        ((com.socialin.android.brushlib.controller.d) (editingmode)).c.removeAllUpdateListeners();
        ((com.socialin.android.brushlib.controller.d) (editingmode)).c.removeAllListeners();
        ((com.socialin.android.brushlib.controller.d) (editingmode)).c.addListener(((com.socialin.android.brushlib.controller.d) (editingmode)).h);
        ((com.socialin.android.brushlib.controller.d) (editingmode)).c.addUpdateListener(((com.socialin.android.brushlib.controller.d) (editingmode)).g);
        ((com.socialin.android.brushlib.controller.d) (editingmode)).c.setDuration(200L);
        ((com.socialin.android.brushlib.controller.d) (editingmode)).c.start();
        c.c = C;
        for (editingmode = G.iterator(); editingmode.hasNext(); ((com.socialin.android.brushlib.input.d)editingmode.next()).d()) { }
        break; /* Loop/switch isn't completed */
_L17:
        if (((com.socialin.android.brushlib.controller.d) (editingmode)).f.x < ((RectF) (obj)).left)
        {
            ((com.socialin.android.brushlib.controller.d) (editingmode)).f.x = (float)Math.ceil(((RectF) (obj)).left);
        }
        continue; /* Loop/switch isn't completed */
_L13:
        editingmode = C;
        float f1 = getWidth() / 2;
        float f2 = getHeight() / 2;
        ((com.socialin.android.brushlib.controller.d) (editingmode)).f.set(f1, f2);
        if (true) goto _L19; else goto _L18
_L18:
        G.clear();
        G.add(C);
        D.a = false;
        return;
_L8:
        p = h;
        c.c = h;
        for (editingmode = G.iterator(); editingmode.hasNext(); ((com.socialin.android.brushlib.input.d)editingmode.next()).d()) { }
        G.clear();
        G.add(h);
        G.add(D);
        D.a = true;
        return;
_L9:
        p = i;
        i.b.a(true);
        c.c = i;
        for (editingmode = G.iterator(); editingmode.hasNext(); ((com.socialin.android.brushlib.input.d)editingmode.next()).d()) { }
        G.clear();
        G.add(B);
        G.add(i);
        G.add(D);
        D.a = false;
        return;
_L5:
        p = j;
        c.c = j;
        Object obj;
        for (editingmode = G.iterator(); editingmode.hasNext(); ((com.socialin.android.brushlib.input.d)editingmode.next()).d()) { }
        G.clear();
        G.add(j);
        G.add(D);
        D.a = false;
        return;
_L10:
        p = D;
        c.c = null;
        for (editingmode = G.iterator(); editingmode.hasNext(); ((com.socialin.android.brushlib.input.d)editingmode.next()).d()) { }
        G.clear();
        G.add(D);
        D.a = true;
        return;
_L11:
        p = k;
        editingmode = k;
        com.socialin.android.brushlib.layer.b b1 = ((h) (editingmode)).a.c.b;
        editingmode.b = new PointF(((h) (editingmode)).a.j().centerX(), ((h) (editingmode)).a.j().centerY());
        editingmode.c = new Matrix(b1.a);
        c.c = null;
        G.clear();
        G.add(k);
        return;
        if (true) goto _L21; else goto _L20
_L20:
    }

    public void setImageForAddPhotoMode(Bitmap bitmap, String s1)
    {
        if (((com.socialin.android.brushlib.a) (h)).a != null)
        {
            h.d();
        }
        h.a(new ImageOverlay(bitmap, c.k.getImageDataFolder()));
    }

    public void setInterstitial(com.picsart.studio.ads.h h1)
    {
        F = h1;
    }

    public void setLayerVisibility(com.socialin.android.brushlib.layer.b b1, boolean flag)
    {
        a a1 = c;
        b1.f = flag;
        LayerConfig layerconfig = new LayerConfig(b1.g, b1.e, b1.f);
        ActionCollector.a().a(new LayerConfigChangeAction(UUID.fromString(b1.c), layerconfig, a1.f.d().key));
        a1.d(b1);
        c.c();
    }

    public void setOnInitializedListener(com.socialin.android.brushlib.view.d d1)
    {
        L = d1;
    }

    public void setPanDragModeEnabled(boolean flag)
    {
        D.a = flag;
    }

    public void setSelectedLayer(com.socialin.android.brushlib.layer.b b1)
    {
        c.a(b1);
    }

    public void setSelectedLayerBlendMode(BlendMode blendmode)
    {
        if (c.b != null)
        {
            a a1 = c;
            com.socialin.android.brushlib.layer.b b1 = c.b;
            if (b1 != null)
            {
                b1.a(blendmode);
                blendmode = new LayerConfig(b1.g, b1.e, b1.f);
                ActionCollector.a().a(new LayerConfigChangeAction(UUID.fromString(b1.c), blendmode, a1.f.d().key));
                a1.d(b1);
            }
            c.c();
        }
    }

    public void setSelectedLayerOpacity(int i1)
    {
        a a1 = c;
        com.socialin.android.brushlib.layer.b b1 = c.b;
        b1.a(i1);
        LayerConfig layerconfig = new LayerConfig(b1.g, b1.e, b1.f);
        ActionCollector.a().a(new LayerConfigChangeAction(UUID.fromString(b1.c), layerconfig, a1.f.d().key));
        a1.d(b1);
    }

    public void setShape(com.socialin.android.brushlib.controller.ShapeOverlayController.ShapeType shapetype, String s1, ShapeParams shapeparams)
    {
        shapeparams.setMode(c.h);
        ShapeOverlayController shapeoverlaycontroller = i;
        com.socialin.android.brushlib.controller.ShapeOverlayController.ShapeType shapetype1 = shapeoverlaycontroller.f;
        shapeoverlaycontroller.f = shapetype;
        shapeoverlaycontroller.d = s1;
        if (((com.socialin.android.brushlib.a) (shapeoverlaycontroller)).a != null)
        {
            if (shapetype1 == shapeoverlaycontroller.f)
            {
                shapetype = (ShapeOverlay)((com.socialin.android.brushlib.a) (shapeoverlaycontroller)).a;
                if (shapetype.getShapeName() != s1)
                {
                    s1 = new ShapeOverlay(s1);
                    s1.getTransform().set(shapetype.getTransform());
                    s1.setParams(shapetype.getParams());
                    shapeoverlaycontroller.a(s1);
                    shapeoverlaycontroller.c = SimpleTransformGizmo.a(shapeoverlaycontroller.b.getResources(), s1, shapeoverlaycontroller.b);
                }
            } else
            {
                shapeoverlaycontroller.b();
            }
        }
        shapetype = i;
        shapetype.g = shapeparams;
        s1 = ((com.socialin.android.brushlib.a) (shapetype)).a;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (((ShapeOverlayController) (shapetype)).b.r && ((ShapeOverlayController) (shapetype)).b.c.b == ((ShapeOverlayController) (shapetype)).b.c.j.d)
        {
            ((ShapeOverlayController) (shapetype)).g.setMode(DrawingMode.ERASE);
        } else
        {
            ((ShapeOverlayController) (shapetype)).g.setMode(((ShapeOverlayController) (shapetype)).b.b());
        }
        if (!(s1 instanceof ShapeOverlay)) goto _L4; else goto _L3
_L3:
        ((ShapeOverlay)s1).setParams(((ShapeOverlayController) (shapetype)).g);
_L6:
        ((ShapeOverlayController) (shapetype)).b.a(true);
_L2:
        setEditingMode(EditingMode.SHAPE);
        return;
_L4:
        if (s1 instanceof LineOverlay)
        {
            ((LineOverlay)s1).setParams(((ShapeOverlayController) (shapetype)).g);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setTextParams(String s1, Paint paint, Paint paint1, DrawTextStyle drawtextstyle, Parcelable parcelable)
    {
        j.a(s1, paint1, paint, drawtextstyle, parcelable);
    }

    public void setTmp(boolean flag)
    {
    }

    public void setToggleFullscreenRunnable(Runnable runnable)
    {
        f = runnable;
    }

    public void setUiFreeRectCallable(Callable callable)
    {
        K = callable;
    }

    public void setUpdateColorButtonRunnable(Runnable runnable)
    {
        e = runnable;
    }

    public void setZoomChangeListener(com.socialin.android.brushlib.view.e e1)
    {
        o = e1;
    }

    static 
    {
        (new Paint()).setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
    }

    // Unreferenced inner class com/socialin/android/brushlib/view/DrawingView$6

/* anonymous class */
    public final class _cls6
        implements Runnable
    {

        private com.socialin.android.videogenerator.ProjectVideoGenerator.VideoOptions a;
        private DrawingView b;

        public final void run()
        {
            com.socialin.android.brushlib.view.DrawingView.a(b, a);
        }

            public 
            {
                b = DrawingView.this;
                a = videooptions;
                super();
            }
    }


    // Unreferenced inner class com/socialin/android/brushlib/view/DrawingView$7

/* anonymous class */
    public final class _cls7
        implements Runnable
    {

        private com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions a;
        private DrawingView b;

        public final void run()
        {
            com.socialin.android.brushlib.view.DrawingView.a(b, a);
        }

            public 
            {
                b = DrawingView.this;
                a = gifoptions;
                super();
            }
    }


    // Unreferenced inner class com/socialin/android/brushlib/view/DrawingView$8

/* anonymous class */
    public final class _cls8
        implements Runnable
    {

        private DrawingView a;

        public final void run()
        {
            EditingMode editingmode = com.socialin.android.brushlib.view.DrawingView.a(a).i;
            if (editingmode == null) goto _L2; else goto _L1
_L1:
            _cls9.c[editingmode.ordinal()];
            JVM INSTR tableswitch 4 5: default 44
        //                       4 53
        //                       5 66;
               goto _L2 _L3 _L4
_L2:
            a.a(true);
            return;
_L3:
            com.socialin.android.brushlib.view.DrawingView.b(a).a();
            continue; /* Loop/switch isn't completed */
_L4:
            DrawingView.c(a).c();
            if (true) goto _L2; else goto _L5
_L5:
        }

            public 
            {
                a = DrawingView.this;
                super();
            }
    }


    private class State extends Enum
    {

        private static final State $VALUES[];
        public static final State INITIALIZED;
        public static final State INITIALIZING;
        public static final State UNINITIALIZED;

        public static State valueOf(String s1)
        {
            return (State)Enum.valueOf(com/socialin/android/brushlib/view/DrawingView$State, s1);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            UNINITIALIZED = new State("UNINITIALIZED", 0);
            INITIALIZING = new State("INITIALIZING", 1);
            INITIALIZED = new State("INITIALIZED", 2);
            $VALUES = (new State[] {
                UNINITIALIZED, INITIALIZING, INITIALIZED
            });
        }

        private State(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class DrawingMode extends Enum
    {

        private static final DrawingMode $VALUES[];
        public static final DrawingMode DRAW;
        public static final DrawingMode ERASE;
        public final PorterDuffXfermode xfermode;

        public static DrawingMode valueOf(String s1)
        {
            return (DrawingMode)Enum.valueOf(com/socialin/android/brushlib/view/DrawingView$DrawingMode, s1);
        }

        public static DrawingMode[] values()
        {
            return (DrawingMode[])$VALUES.clone();
        }

        static 
        {
            DRAW = new DrawingMode("DRAW", 0, null);
            ERASE = new DrawingMode("ERASE", 1, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
            $VALUES = (new DrawingMode[] {
                DRAW, ERASE
            });
        }

        private DrawingMode(String s1, int i1, PorterDuffXfermode porterduffxfermode)
        {
            super(s1, i1);
            xfermode = porterduffxfermode;
        }
    }

}
