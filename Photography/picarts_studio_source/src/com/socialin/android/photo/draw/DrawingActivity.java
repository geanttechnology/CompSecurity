// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mobeta.android.dslv.DragSortListView;
import com.picsart.studio.DrawingGalleryActivity;
import com.picsart.studio.EditingData;
import com.picsart.studio.ImagePickerActivity;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.activity.StandaloneCropToolActivity;
import com.picsart.studio.view.WrappingListPopupWindow;
import com.picsart.studio.view.p;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.activity.SaveToSdCardDialogActivity;
import com.socialin.android.ads.SocialinAdManager;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.brush.Brush;
import com.socialin.android.brushlib.brush.BrushHistory;
import com.socialin.android.brushlib.camera.CameraPreviewContainer;
import com.socialin.android.brushlib.controller.ShapeOverlayController;
import com.socialin.android.brushlib.layer.BlendMode;
import com.socialin.android.brushlib.layer.CameraMaskLayer;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.overlay.LineOverlay;
import com.socialin.android.brushlib.overlay.Overlay;
import com.socialin.android.brushlib.overlay.ShapeOverlay;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.svg.ClipArtSvg;
import com.socialin.android.brushlib.svg.ShapeParams;
import com.socialin.android.brushlib.textart.DrawTextStyle;
import com.socialin.android.brushlib.util.j;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.brushlib.view.e;
import com.socialin.android.colorpicker.f;
import com.socialin.android.colorpicker.g;
import com.socialin.android.d;
import com.socialin.android.dialog.CancelDialogActivity;
import com.socialin.android.dialog.h;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.photo.clipart.SelectClipArtFrameActivity;
import com.socialin.android.photo.draw.dialog.SelectBrushDialog;
import com.socialin.android.photo.draw.dialog.SelectCanvasSizeDialog;
import com.socialin.android.photo.draw.dialog.SelectShapeDialog;
import com.socialin.android.photo.exception.InvalidIndexFileException;
import com.socialin.android.photo.exif.ExifTool;
import com.socialin.android.photo.textart.TextArt;
import com.socialin.android.photo.textart.TextArtStyle;
import com.socialin.android.photo.textart.TypefaceSpec;
import com.socialin.android.photo.view.ColorPickerPreview;
import com.socialin.android.picsart.profile.invite.i;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.ak;
import com.socialin.android.util.am;
import com.socialin.android.util.l;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import com.socialin.android.videogenerator.ActionCollector;
import com.socialin.android.videogenerator.actions.LayerClearAction;
import com.socialin.android.videogenerator.actions.LayerFillAction;
import com.socialin.android.videogenerator.actions.LayerTransformAction;
import com.socialin.android.videogenerator.actions.LayersMergeAction;
import com.socialin.android.videogenerator.actions.RedoAction;
import com.socialin.android.videogenerator.actions.UndoAction;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import myobfuscated.cv.c;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.draw:
//            b, a, c

public class DrawingActivity extends AdBaseActivity
{

    private static final String c;
    private static final String d;
    private boolean A;
    private Runnable B;
    private Runnable C;
    private Runnable D;
    private com.socialin.android.colorpicker.c E;
    private com.socialin.android.colorpicker.c F;
    private com.socialin.android.colorpicker.d G;
    private View H;
    private TextView I;
    private final e J = new e(this);
    private BackgroundType K;
    private Runnable L;
    private WrappingListPopupWindow M;
    private WrappingListPopupWindow N;
    private WrappingListPopupWindow O;
    private WrappingListPopupWindow P;
    private WrappingListPopupWindow Q;
    private am R;
    private ImageButton S;
    private FrameLayout T;
    private RectF U;
    private TextView V;
    private SeekBar W;
    private View X;
    private View Y;
    private View Z;
    final boolean a = System.getProperty("os.arch").toLowerCase().contains("armv") | System.getProperty("os.arch").toLowerCase().contains("86") | System.getProperty("os.arch").toLowerCase().contains("64");
    private com.socialin.android.photo.draw.b aa;
    private DragSortListView ab;
    private com.mobeta.android.dslv.i ac;
    private com.socialin.android.brushlib.util.c ad;
    private com.socialin.android.dialog.a ae;
    private com.socialin.android.dialog.a af;
    private boolean ag;
    private boolean ah;
    private CameraPanelState ai;
    private ViewGroup aj;
    private ViewGroup ak;
    private ViewGroup al;
    private ColorPickerPreview am;
    private LayerPanelState an;
    private boolean ao;
    private LayerPanelState ap;
    private String aq;
    private GoogleApiClient ar;
    private Integer as;
    private com.socialin.android.photo.draw.c at;
    private boolean au;
    private EditingData b;
    private final List e = BlendMode.getSupportedModes(myobfuscated.f.m.j(), myobfuscated.f.m.i());
    private final BroadcastReceiver f = new BroadcastReceiver() {

        private DrawingActivity a;

        public final void onReceive(Context context, Intent intent)
        {
            a.finish();
        }

            
            {
                a = DrawingActivity.this;
                super();
            }
    };
    private String g;
    private long h;
    private final List i = new LinkedList();
    private final android.widget.AdapterView.OnItemSelectedListener j = new android.widget.AdapterView.OnItemSelectedListener() {

        private DrawingActivity a;

        public final void onItemSelected(AdapterView adapterview, View view, int i1, long l1)
        {
            view = (BlendMode)com.socialin.android.photo.draw.DrawingActivity.a(a).get(i1);
            AnalyticUtils analyticutils = AnalyticUtils.getInstance(a);
            if (view != null)
            {
                adapterview = view.toString();
            } else
            {
                adapterview = null;
            }
            analyticutils.track(new com.socialin.android.apiv3.events.EventsFactory.EditCustomBlendEvent("drawing_layers", adapterview));
            com.socialin.android.photo.draw.DrawingActivity.b(a).setSelectedLayerBlendMode(view);
        }

        public final void onNothingSelected(AdapterView adapterview)
        {
        }

            
            {
                a = DrawingActivity.this;
                super();
            }
    };
    private boolean k;
    private final android.view.View.OnClickListener l = new android.view.View.OnClickListener() {

        final DrawingActivity a;

        public final void onClick(View view)
        {
            switch (view.getId())
            {
            case 2131755985: 
            default:
                return;

            case 2131755986: 
                boolean flag = com.socialin.android.photo.draw.DrawingActivity.c(a);
                com.socialin.android.photo.draw.DrawingActivity.d(a);
                com.socialin.android.photo.draw.DrawingActivity.a(a, new Runnable(this, flag) {

                    private boolean a;
                    private _cls21 b;

                    public final void run()
                    {
                        if (!a)
                        {
                            com.socialin.android.photo.draw.DrawingActivity.e(b.a);
                        }
                    }

            
            {
                b = _pcls21;
                a = flag;
                super();
            }
                });
                return;

            case 2131755987: 
                com.socialin.android.photo.draw.DrawingActivity.f(a);
                return;

            case 2131755988: 
                com.socialin.android.photo.draw.DrawingActivity.a(a, false);
                return;

            case 2131755984: 
                com.socialin.android.photo.draw.DrawingActivity.g(a);
                return;

            case 2131755983: 
                com.socialin.android.photo.draw.DrawingActivity.h(a);
                return;
            }
        }

            
            {
                a = DrawingActivity.this;
                super();
            }
    };
    private AppCompatDialog m;
    private long n;
    private String o;
    private HashMap p;
    private int q;
    private myobfuscated.bw.a r;
    private DrawingView s;
    private WeakReference t;
    private WeakReference u;
    private int v;
    private boolean w;
    private Spinner x;
    private boolean y;
    private CameraPreviewContainer z;

    public DrawingActivity()
    {
        n = 0L;
        q = -1;
        w = false;
        y = false;
        B = new Runnable() {

            private DrawingActivity a;

            public final void run()
            {
                com.socialin.android.photo.draw.DrawingActivity.a(a, false, true);
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        };
        C = new Runnable() {

            private DrawingActivity a;

            public final void run()
            {
                com.socialin.android.photo.draw.DrawingActivity.a(a, true, true);
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        };
        D = new Runnable() {

            private DrawingActivity a;

            public final void run()
            {
                com.socialin.android.photo.draw.DrawingActivity.i(a);
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        };
        E = new com.socialin.android.colorpicker.c() {

            private DrawingActivity a;

            public final void a(int i1)
            {
                com.socialin.android.photo.draw.DrawingActivity.b(a).setDrawingMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW);
                com.socialin.android.photo.draw.DrawingActivity.b(a).setCurrentColor(i1);
                com.socialin.android.photo.draw.DrawingActivity.j(a).run();
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        };
        F = new com.socialin.android.colorpicker.c() {

            private DrawingActivity a;

            public final void a(int i1)
            {
                DrawingView drawingview = com.socialin.android.photo.draw.DrawingActivity.b(a);
                if (!drawingview.c.f.b())
                {
                    b b1 = drawingview.c.b;
                    b1.j.drawColor(i1);
                    drawingview.c.a(b1);
                    drawingview.a(true);
                    ActionCollector.a().a(new LayerFillAction(UUID.fromString(b1.c), i1, drawingview.c.f.d().key));
                }
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        };
        G = new com.socialin.android.colorpicker.d() {

            private DrawingActivity a;

            public final void a()
            {
                com.socialin.android.photo.draw.DrawingActivity.b(a, false);
                DrawingActivity.k(a).setVisibility(0);
                DrawingActivity.k(a).animate().alpha(1.0F).setDuration(300L).setListener(null);
                com.socialin.android.photo.draw.DrawingActivity.l(a).setVisibility(0);
                com.socialin.android.photo.draw.DrawingActivity.l(a).animate().alpha(1.0F).setDuration(300L).setListener(null);
                if (com.socialin.android.photo.draw.DrawingActivity.m(a) == LayerPanelState.OPENED || DrawingActivity.n(a) == LayerPanelState.OPENING)
                {
                    DrawingActivity.o(a);
                }
                com.socialin.android.photo.draw.DrawingActivity.b(a).setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.COLOR_PICKER);
                com.socialin.android.photo.draw.DrawingActivity.b(a).a(true);
            }

            public final void b()
            {
                com.socialin.android.photo.draw.DrawingActivity.b(a, true);
                DrawingActivity.k(a).setVisibility(0);
                DrawingActivity.k(a).animate().alpha(1.0F).setDuration(300L).setListener(null);
                com.socialin.android.photo.draw.DrawingActivity.l(a).setVisibility(0);
                com.socialin.android.photo.draw.DrawingActivity.l(a).animate().alpha(1.0F).setDuration(300L).setListener(null);
                if (com.socialin.android.photo.draw.DrawingActivity.m(a) == LayerPanelState.OPENED || DrawingActivity.n(a) == LayerPanelState.OPENING)
                {
                    DrawingActivity.o(a);
                }
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        };
        U = new RectF();
        ac = new com.mobeta.android.dslv.i() {

            private DrawingActivity a;

            public final void a(int i1, int j1)
            {
                int k1 = com.socialin.android.photo.draw.DrawingActivity.b(a).h();
                DrawingView drawingview = com.socialin.android.photo.draw.DrawingActivity.b(a);
                drawingview.c.a(k1 - i1 - 1, k1 - j1 - 1);
                drawingview.c.c();
                com.socialin.android.photo.draw.DrawingActivity.b(a).invalidate();
                DrawingActivity.r(a).notifyDataSetChanged();
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        };
        ae = null;
        af = null;
        ai = CameraPanelState.OPENED;
        ap = LayerPanelState.CLOSED;
    }

    static DragSortListView A(DrawingActivity drawingactivity)
    {
        return drawingactivity.ab;
    }

    static CameraPreviewContainer B(DrawingActivity drawingactivity)
    {
        return drawingactivity.z;
    }

    static List C(DrawingActivity drawingactivity)
    {
        return drawingactivity.i;
    }

    static android.widget.AdapterView.OnItemSelectedListener D(DrawingActivity drawingactivity)
    {
        return drawingactivity.j;
    }

    static Spinner E(DrawingActivity drawingactivity)
    {
        return drawingactivity.x;
    }

    static void F(DrawingActivity drawingactivity)
    {
        boolean flag;
        if (!drawingactivity.ao)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        drawingactivity.d(flag);
    }

    static void G(DrawingActivity drawingactivity)
    {
        if (drawingactivity.k)
        {
            drawingactivity.j();
            return;
        } else
        {
            drawingactivity.i();
            return;
        }
    }

    static void H(DrawingActivity drawingactivity)
    {
        SelectCanvasSizeDialog selectcanvassizedialog = SelectCanvasSizeDialog.a(drawingactivity. new myobfuscated.bj.b() {

            private DrawingActivity a;

            public final void a(int i1, int j1)
            {
                DrawingActivity.t(a).show();
                if (DrawingActivity.L(a))
                {
                    DrawingActivity.B(a).b();
                    com.socialin.android.photo.draw.DrawingActivity.d(a, false);
                    DrawingActivity.ab(a);
                    com.socialin.android.photo.draw.DrawingActivity.b(a).d();
                }
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.DrawDoneEvent(DrawingActivity.Z(a).a, DrawingActivity.ac(a), com.socialin.android.photo.draw.DrawingActivity.b(a).g.b(), com.socialin.android.photo.draw.DrawingActivity.b(a).g.c(), "new", (System.nanoTime() - DrawingActivity.ad(a)) / 0x3b9aca00L));
                DrawingActivity.ae(a);
                if (com.socialin.android.photo.draw.DrawingActivity.b(a).c.k.isDraft())
                {
                    FileUtils.b(com.socialin.android.photo.draw.DrawingActivity.b(a).c.k.getRootFolder().getAbsolutePath());
                }
                com.socialin.android.photo.draw.DrawingActivity.b(a).b(false);
                com.socialin.android.photo.draw.DrawingActivity.b(a).a(i1, j1);
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        selectcanvassizedialog.setStyle(0, 0x7f0c0181);
        selectcanvassizedialog.show(drawingactivity.getFragmentManager(), null);
    }

    static void I(DrawingActivity drawingactivity)
    {
        drawingactivity.r();
        Intent intent = new Intent(drawingactivity, com/picsart/studio/DrawingGalleryActivity);
        intent.putExtra("currentProjectRoot", drawingactivity.s.c.k.getRootFolder().getAbsolutePath());
        intent.putExtra("drawingSessionId", drawingactivity.g);
        intent.putExtra("drawingSessionStart", drawingactivity.h);
        intent.putExtra("uid", drawingactivity.b.a);
        intent.putExtra("brushTime", drawingactivity.s.g.b().toString());
        intent.putExtra("eraserTime", drawingactivity.s.g.c().toString());
        drawingactivity.startActivity(intent);
    }

    static void J(DrawingActivity drawingactivity)
    {
        drawingactivity.s();
    }

    static boolean K(DrawingActivity drawingactivity)
    {
        drawingactivity.y = true;
        return true;
    }

    static boolean L(DrawingActivity drawingactivity)
    {
        return drawingactivity.A;
    }

    static void M(DrawingActivity drawingactivity)
    {
        drawingactivity.g(false);
    }

    static boolean N(DrawingActivity drawingactivity)
    {
        return drawingactivity.y;
    }

    static void O(DrawingActivity drawingactivity)
    {
        drawingactivity.q();
    }

    static void P(DrawingActivity drawingactivity)
    {
        AnalyticUtils.getInstance(drawingactivity).track(new com.socialin.android.apiv3.events.EventsFactory.DrawLayerAddedEvent("empty"));
        drawingactivity = drawingactivity.s.c;
        b b1 = com.socialin.android.brushlib.layer.b.a(((a) (drawingactivity)).d, ((a) (drawingactivity)).e);
        if (b1 != null)
        {
            drawingactivity.b(b1);
            drawingactivity.c();
            return;
        } else
        {
            ((a) (drawingactivity)).g.l();
            return;
        }
    }

    static void Q(DrawingActivity drawingactivity)
    {
        Intent intent = new Intent(drawingactivity, com/picsart/studio/ImagePickerActivity);
        intent.putExtra("from", "draw");
        intent.putExtra("showCameraEffects", true);
        myobfuscated.cv.c.a(intent, drawingactivity);
        drawingactivity.startActivityForResult(intent, RequestCode.CHOOSE_PIC_FOR_LAYER.toInt());
    }

    static void R(DrawingActivity drawingactivity)
    {
        b b1 = com.socialin.android.brushlib.layer.b.a(drawingactivity.s.f(), drawingactivity.s.g());
        if (b1 != null)
        {
            drawingactivity.s.c.b(b1);
            CameraMaskLayer cameramasklayer = drawingactivity.s.c.a(b1, com.socialin.android.brushlib.layer.CameraMaskLayer.MaskPlacement.BELOW);
            if (cameramasklayer != null)
            {
                cameramasklayer.a.eraseColor(-1);
                drawingactivity.s.c.c();
                drawingactivity.s.c.a(b1);
                drawingactivity.s.a(true);
                drawingactivity.a(false, 0);
                return;
            } else
            {
                drawingactivity.s.c.a(b1, true);
                drawingactivity.s.l();
                return;
            }
        } else
        {
            drawingactivity.s.l();
            return;
        }
    }

    static void S(DrawingActivity drawingactivity)
    {
        if (!drawingactivity.A && drawingactivity.s.c.b != null && drawingactivity.s.c.a(drawingactivity.s.c.b, com.socialin.android.brushlib.layer.CameraMaskLayer.MaskPlacement.ABOVE) != null)
        {
            drawingactivity.a(true, 0);
        }
    }

    static View T(DrawingActivity drawingactivity)
    {
        return drawingactivity.X;
    }

    static void U(DrawingActivity drawingactivity)
    {
        drawingactivity.o();
        drawingactivity.s.setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.LAYER_TRANSFORM);
    }

    static com.socialin.android.colorpicker.c V(DrawingActivity drawingactivity)
    {
        return drawingactivity.F;
    }

    static void W(DrawingActivity drawingactivity)
    {
        drawingactivity.m();
    }

    static void X(DrawingActivity drawingactivity)
    {
        drawingactivity.l();
    }

    static com.socialin.android.dialog.a Y(DrawingActivity drawingactivity)
    {
        return drawingactivity.af;
    }

    static EditingData Z(DrawingActivity drawingactivity)
    {
        return drawingactivity.b;
    }

    static int a(DrawingActivity drawingactivity, int i1)
    {
        drawingactivity.v = i1;
        return i1;
    }

    static long a(DrawingActivity drawingactivity, long l1)
    {
        drawingactivity.h = l1;
        return l1;
    }

    public static View a(DrawingActivity drawingactivity, View view)
    {
        drawingactivity.H = view;
        return view;
    }

    public static TextView a(DrawingActivity drawingactivity, TextView textview)
    {
        drawingactivity.I = textview;
        return textview;
    }

    static WrappingListPopupWindow a(DrawingActivity drawingactivity, WrappingListPopupWindow wrappinglistpopupwindow)
    {
        drawingactivity.M = wrappinglistpopupwindow;
        return wrappinglistpopupwindow;
    }

    static CameraPreviewContainer a(DrawingActivity drawingactivity, CameraPreviewContainer camerapreviewcontainer)
    {
        drawingactivity.z = camerapreviewcontainer;
        return camerapreviewcontainer;
    }

    static com.socialin.android.brushlib.util.c a(DrawingActivity drawingactivity, com.socialin.android.brushlib.util.c c1)
    {
        drawingactivity.ad = c1;
        return c1;
    }

    static CameraPanelState a(DrawingActivity drawingactivity, CameraPanelState camerapanelstate)
    {
        drawingactivity.ai = camerapanelstate;
        return camerapanelstate;
    }

    static LayerPanelState a(DrawingActivity drawingactivity, LayerPanelState layerpanelstate)
    {
        drawingactivity.ap = layerpanelstate;
        return layerpanelstate;
    }

    static Integer a(DrawingActivity drawingactivity, Integer integer)
    {
        drawingactivity.as = integer;
        return integer;
    }

    private String a(android.graphics.Bitmap.CompressFormat compressformat)
    {
        if (com.socialin.android.util.w.a(this))
        {
            String s2 = (new StringBuilder()).append(getString(0x7f0808fc)).append("_").append(System.currentTimeMillis()).toString();
            Bitmap bitmap = t();
            String s4 = getString(0x7f08096b);
            if (bitmap == null || bitmap.isRecycled())
            {
                Utils.a(this, 0x7f08024e);
                return null;
            }
            String s1;
            String s3;
            if (compressformat == android.graphics.Bitmap.CompressFormat.JPEG)
            {
                s1 = ".jpg";
            } else
            {
                s1 = ".png";
            }
            if (s2 == null)
            {
                s2 = (new StringBuilder("recent_")).append(System.currentTimeMillis()).toString();
            }
            s3 = s4;
            if (s4 == null)
            {
                s3 = getResources().getString(0x7f080957);
            }
            compressformat = com.socialin.android.util.w.a(s3, (new StringBuilder()).append(s2).append(s1).toString(), bitmap, this, compressformat, false);
            bitmap.recycle();
            return compressformat.getAbsolutePath();
        } else
        {
            return null;
        }
    }

    static String a(DrawingActivity drawingactivity, android.graphics.Bitmap.CompressFormat compressformat)
    {
        return drawingactivity.a(compressformat);
    }

    static String a(DrawingActivity drawingactivity, Project project, boolean flag)
    {
        int i1 = 0;
        String s1 = "";
        if (!project.isDraft())
        {
            s1 = project.getName();
            do
            {
                StringBuilder stringbuilder = (new StringBuilder()).append(s1);
                if (i1 == 0)
                {
                    project = "";
                } else
                {
                    project = (new StringBuilder("(")).append(i1).append(")").toString();
                }
                project = stringbuilder.append(project).toString();
                if (drawingactivity.a(((String) (project)), ((StringBuilder) (null)), flag))
                {
                    return project;
                }
                i1++;
            } while (true);
        }
        boolean flag1 = false;
        project = s1;
        while (!flag1) 
        {
            if (!flag)
            {
                project = (new StringBuilder("video_")).append((new SimpleDateFormat("MM-dd-hh.mm.ss")).format(new Date()).toString()).toString();
                if (!flag)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag1 = drawingactivity.a(((String) (project)), ((StringBuilder) (null)), flag1);
            } else
            {
                project = (new StringBuilder("gif_")).append((new SimpleDateFormat("MM-dd-hh.mm.ss")).format(new Date()).toString()).toString();
                flag1 = drawingactivity.a(((String) (project)), ((StringBuilder) (null)), flag);
            }
        }
        return project;
    }

    static String a(DrawingActivity drawingactivity, String s1)
    {
        drawingactivity.g = s1;
        return s1;
    }

    static List a(DrawingActivity drawingactivity)
    {
        return drawingactivity.e;
    }

    private void a(Bitmap bitmap, HashMap hashmap)
    {
        if (bitmap != null)
        {
            int i1 = com.picsart.studio.editor.helper.a.a().a(bitmap);
            if (q == 0)
            {
                bitmap = new Intent();
                bitmap.putExtra("bitmap.key", i1);
                bitmap.putExtra("editing_data", b);
                setResult(-1, bitmap);
                u();
                return;
            }
            bitmap = new Intent(this, com/picsart/studio/editor/activity/EditorActivity);
            if (K != BackgroundType.PHOTO)
            {
                bitmap.putExtra("bufferData", hashmap);
            }
            bitmap.putExtra("bitmap.key", i1);
            b(s.c.k);
            bitmap.putExtra("editing_data", b);
            startActivity(bitmap);
            u();
            return;
        } else
        {
            setResult(0);
            u();
            return;
        }
    }

    private static void a(ImageButton imagebutton, boolean flag)
    {
        if (flag)
        {
            imagebutton.setBackgroundResource(0x7f0f0094);
        } else
        {
            imagebutton.setBackgroundResource(0x7f02068f);
        }
        imagebutton.setSelected(flag);
    }

    private void a(b b1)
    {
        V.setText((new StringBuilder()).append((int)((100F * (float)b1.e) / 255F)).append(" %").toString());
        x.setOnItemSelectedListener(null);
        x.setSelection(b1.g.ordinal(), false);
        x.post(new Runnable() {

            private DrawingActivity a;

            public final void run()
            {
                DrawingActivity.E(a).setOnItemSelectedListener(DrawingActivity.D(a));
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        W.setProgress(b1.e);
        aa.notifyDataSetChanged();
    }

    private void a(Project project)
    {
        try
        {
            project = new ObjectOutputStream(new FileOutputStream(new File((new StringBuilder()).append(project.getRootFolder().getPath()).append(File.separator).append("editingdat.aaf").toString())));
            project.writeObject(b.b);
            project.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Project project)
        {
            project.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Project project)
        {
            project.printStackTrace();
        }
    }

    private void a(Project project, Runnable runnable)
    {
        (new AsyncTask(project, runnable) {

            private Project a;
            private Runnable b;

            private transient List a()
            {
                Object obj = com.socialin.android.brushlib.project.a.a();
                if (obj != null)
                {
                    obj = ((List) (obj)).iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        Project project1 = (Project)((Iterator) (obj)).next();
                        if (project1.equals(a))
                        {
                            continue;
                        }
                        if (project1.isValid())
                        {
                            try
                            {
                                myobfuscated.br.a.a(project1);
                                continue;
                            }
                            catch (InvalidIndexFileException invalidindexfileexception)
                            {
                                com.socialin.android.d.b(com.socialin.android.photo.draw.DrawingActivity.c(), new Object[] {
                                    (new StringBuilder("Got unexpected exception: ")).append(invalidindexfileexception.getMessage()).toString()
                                });
                            }
                        }
                        FileUtils.b(project1.getRootFolder().getAbsolutePath());
                    } while (true);
                    if (b != null)
                    {
                        b.run();
                    }
                }
                return null;
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            
            {
                a = project;
                b = runnable;
                super();
            }
        }).execute(new Void[0]);
    }

    private void a(com.socialin.android.brushlib.view.DrawingView.EditingMode editingmode, com.socialin.android.brushlib.view.DrawingView.DrawingMode drawingmode)
    {
label0:
        {
            if (editingmode != null && drawingmode != null)
            {
                if (editingmode != com.socialin.android.brushlib.view.DrawingView.EditingMode.CAMERA)
                {
                    break label0;
                }
                a((ImageButton)findViewById(0x7f1003af), true);
                a((ImageButton)findViewById(0x7f100285), false);
                a((ImageButton)findViewById(0x7f100286), false);
            }
            return;
        }
        final class _cls87
        {

            static final int a[];
            static final int b[];
            static final int c[];

            static 
            {
                c = new int[RequestCode.values().length];
                try
                {
                    c[RequestCode.EXPORT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    c[RequestCode.SAVE_TO_SD.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    c[RequestCode.CANCEL_CONFIRM.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    c[RequestCode.SELECT_BRUSH.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    c[RequestCode.SELECT_SHAPE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    c[RequestCode.SELECT_CLIPART.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    c[RequestCode.SELECT_TEXT.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    c[RequestCode.CHOOSE_PIC_FOR_LAYER.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    c[RequestCode.CHOOSE_PIC_FOR_ADD_PHOTO.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    c[RequestCode.CROP_IMG_FOR_LAYER.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    c[RequestCode.CROP_IMAGE_FOR_ADD_PHOTO.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                b = new int[com.socialin.android.brushlib.view.DrawingView.DrawingMode.values().length];
                try
                {
                    b[com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    b[com.socialin.android.brushlib.view.DrawingView.DrawingMode.ERASE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                a = new int[com.socialin.android.brushlib.view.DrawingView.EditingMode.values().length];
                try
                {
                    a[com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.socialin.android.brushlib.view.DrawingView.EditingMode.PHOTO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.socialin.android.brushlib.view.DrawingView.EditingMode.TEXT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.socialin.android.brushlib.view.DrawingView.EditingMode.SHAPE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.socialin.android.brushlib.view.DrawingView.EditingMode.COLOR_PICKER.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.socialin.android.photo.draw._cls87.b[drawingmode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            a((ImageButton)findViewById(0x7f1003af), false);
            a((ImageButton)findViewById(0x7f100285), true);
            a((ImageButton)findViewById(0x7f100286), false);
            return;

        case 2: // '\002'
            a((ImageButton)findViewById(0x7f1003af), false);
            break;
        }
        a((ImageButton)findViewById(0x7f100285), false);
        a((ImageButton)findViewById(0x7f100286), true);
    }

    private void a(com.socialin.android.colorpicker.c c1, int i1)
    {
        g g1 = new g();
        g1.a = c1;
        g1.f = i1;
        g1.c = false;
        c1 = g1.a(this);
        if (!c1.isShowing())
        {
            c1.show();
        }
        u = new WeakReference(c1);
    }

    static void a(DrawingActivity drawingactivity, Bitmap bitmap, HashMap hashmap)
    {
        drawingactivity.a(bitmap, hashmap);
    }

    static void a(DrawingActivity drawingactivity, b b1)
    {
        drawingactivity.a(b1);
    }

    public static void a(DrawingActivity drawingactivity, com.socialin.android.brushlib.view.DrawingView.EditingMode editingmode, com.socialin.android.brushlib.view.DrawingView.DrawingMode drawingmode)
    {
        drawingactivity.a(editingmode, drawingmode);
    }

    static void a(DrawingActivity drawingactivity, com.socialin.android.colorpicker.c c1)
    {
        drawingactivity.a(c1, -1);
    }

    static void a(DrawingActivity drawingactivity, com.socialin.android.colorpicker.c c1, com.socialin.android.colorpicker.d d1, int i1)
    {
        g g1 = new g();
        g1.a = c1;
        g1.e = i1;
        g1.f = i1;
        g1.c = true;
        g1.d = true;
        g1.b = d1;
        c1 = g1.a(drawingactivity);
        if (!c1.isShowing())
        {
            c1.show();
        }
        drawingactivity.t = new WeakReference(c1);
    }

    static void a(DrawingActivity drawingactivity, Runnable runnable)
    {
        drawingactivity.a(runnable);
    }

    static void a(DrawingActivity drawingactivity, String s1, HashMap hashmap, int i1)
    {
        drawingactivity.a(s1, hashmap, i1);
    }

    static void a(DrawingActivity drawingactivity, boolean flag)
    {
        drawingactivity.b(flag);
    }

    static void a(DrawingActivity drawingactivity, boolean flag, String s1, h h1)
    {
        Project project;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        project = drawingactivity.s.c.k;
        if (!com.socialin.android.brushlib.project.a.b(drawingactivity.s.c.k, s1)) goto _L2; else goto _L1
_L1:
        ActionCollector.a().a(project.getActionsFile(), project.getActionsInfoFile(), project.isValid());
        drawingactivity.a(project);
        Toast.makeText(drawingactivity, 0x7f08054c, 1).show();
_L4:
        return;
_L2:
        Toast.makeText(drawingactivity, 0x7f080549, 0).show();
        if (h1 == null) goto _L4; else goto _L3
_L3:
        s1 = drawingactivity.getFragmentManager().findFragmentByTag("textPromptDialog");
        if (s1 != null && s1.isAdded())
        {
            drawingactivity.getFragmentManager().beginTransaction().remove(s1).commit();
        }
        h1.show(drawingactivity.getFragmentManager(), null);
        return;
        try
        {
            h1 = drawingactivity.s.c.k;
            com.socialin.android.brushlib.project.a.a(drawingactivity.s.c.k, s1);
            ActionCollector.a().a(h1.getActionsFile(), h1.getActionsInfoFile(), h1.isValid());
            Toast.makeText(drawingactivity, 0x7f08054c, 1).show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Toast.makeText(drawingactivity, 0x7f080549, 0).show();
        }
        return;
    }

    static void a(DrawingActivity drawingactivity, boolean flag, boolean flag1)
    {
        drawingactivity.am.setColor(drawingactivity.s.l);
        drawingactivity.c(true);
        if (flag1)
        {
            AnalyticUtils analyticutils = AnalyticUtils.getInstance(drawingactivity);
            String s1 = drawingactivity.b.a;
            String s2 = drawingactivity.g;
            if (flag)
            {
                drawingactivity = "eyedropper_longtap";
            } else
            {
                drawingactivity = "pop_up";
            }
            analyticutils.track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushColorChangeEvent(s1, s2, drawingactivity));
        }
    }

    private void a(Runnable runnable)
    {
        Object obj = s;
        if (((DrawingView) (obj)).c.i == com.socialin.android.brushlib.view.DrawingView.EditingMode.SHAPE && ((DrawingView) (obj)).r)
        {
            ((DrawingView) (obj)).i.b();
        }
        obj = z;
        Runnable runnable1;
        com.socialin.android.brushlib.camera.a a1;
        AtomicBoolean atomicboolean;
        boolean flag;
        if (((CameraPreviewContainer) (obj)).a != null && !((CameraPreviewContainer) (obj)).e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        A = true;
        ag = true;
        obj = z;
        runnable1 = new Runnable() {

            private DrawingActivity a;

            public final void run()
            {
                a.a();
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        };
        a1 = new com.socialin.android.brushlib.camera.a(runnable) {

            final DrawingActivity a;
            private Runnable b;

            public final void a(Bitmap bitmap)
            {
                if (DrawingActivity.L(a) && bitmap != null)
                {
                    DrawingView drawingview = com.socialin.android.photo.draw.DrawingActivity.b(a);
                    CameraPreviewContainer camerapreviewcontainer = DrawingActivity.B(a);
                    android.hardware.Camera.Size size = camerapreviewcontainer.a(camerapreviewcontainer.c.a);
                    float f1 = Math.max((float)camerapreviewcontainer.d.width() / (float)size.width, (float)camerapreviewcontainer.d.height() / (float)size.height);
                    int i1 = (int)((float)size.width * f1);
                    int j1 = (int)((float)size.height * f1);
                    int k1 = i1 - camerapreviewcontainer.d.width();
                    int l1 = j1 - camerapreviewcontainer.d.height();
                    drawingview.setCapturedPicture(bitmap, new Rect(-k1, -l1, -k1 + i1, -l1 + j1), DrawingActivity.B(a).d, new Runnable(this) {

                        private _cls43 a;

                        public final void run()
                        {
                            AnalyticUtils.getInstance(a.a).track(new com.socialin.android.apiv3.events.EventsFactory.DrawLayerAddedEvent("camera"));
                            com.socialin.android.photo.draw.DrawingActivity.a(a.a, true);
                            DrawingActivity.af(a.a);
                            a.a.b();
                        }

            
            {
                a = _pcls43;
                super();
            }
                    });
                    if (b != null)
                    {
                        a.runOnUiThread(b);
                    }
                }
            }

            
            {
                a = DrawingActivity.this;
                b = runnable;
                super();
            }
        };
        s.j();
        s.f();
        s.g();
        atomicboolean = new AtomicBoolean(false);
        obj.e = true;
        ((CameraPreviewContainer) (obj)).a.autoFocus(new com.socialin.android.brushlib.camera.CameraPreviewContainer._cls2(((CameraPreviewContainer) (obj)), atomicboolean, runnable1, a1));
_L1:
        return;
        Exception exception;
        exception;
        com.socialin.android.d.b(c, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
        });
        b(false);
        if (m.isShowing())
        {
            m.dismiss();
        }
        if (runnable != null)
        {
            runOnUiThread(runnable);
        }
        ag = false;
        return;
        if (runnable != null)
        {
            runOnUiThread(runnable);
            return;
        }
          goto _L1
    }

    private void a(String s1)
    {
        ExifTool.a(s1, "Exif.Photo.UserComment", b.c().toString());
        String s2;
        if (SocialinV3.getInstance().isRegistered())
        {
            s2 = SocialinV3.getInstance().getUser().username;
        } else
        {
            s2 = null;
        }
        myobfuscated.f.m.a(s1, s2, null);
    }

    private void a(String s1, int i1, HashMap hashmap, int j1)
    {
        Intent intent = new Intent(this, com/picsart/studio/editor/activity/StandaloneCropToolActivity);
        intent.putExtra("imagePath", s1);
        intent.putExtra("bufferData", hashmap);
        intent.putExtra("degree", i1);
        intent.putExtra("maxPixel", PicsartContext.a.getMaxImageSizePixel());
        intent.putExtra("source", "draw");
        if (j1 == RequestCode.CROP_IMG_FOR_LAYER.toInt())
        {
            intent.putExtra("outputX", s.f());
            intent.putExtra("outputY", s.g());
        }
        startActivityForResult(intent, j1);
    }

    private void a(String s1, HashMap hashmap, int i1)
    {
        Object obj = null;
        try
        {
            s1 = b(s1, hashmap, i1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.socialin.android.d.b(c, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(s1.getMessage()).toString()
            });
            s1 = obj;
        }
        if (s1 != null)
        {
            s.setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.PHOTO);
            s.setImageForAddPhotoMode(s1, aq);
        }
    }

    private void a(boolean flag)
    {
        FragmentManager fragmentmanager = getFragmentManager();
        Object obj = fragmentmanager.findFragmentByTag("textPromptDialog");
        if (obj != null)
        {
            fragmentmanager.beginTransaction().remove(((Fragment) (obj))).commit();
        }
        obj = new h();
        obj.b = getString(0x7f08056e);
        ((h) (obj)).setStyle(0, 0x7f0c0181);
        obj.a = new com.socialin.android.dialog.i(this, flag, ((h) (obj))) {

            private boolean a;
            private h b;
            private DrawingActivity d;

            public final String a()
            {
                return "";
            }

            public final void a(String s1)
            {
                AnalyticUtils.getInstance(d).track(new com.socialin.android.apiv3.events.EventsFactory.DrawSaveEvent("draft"));
                com.socialin.android.photo.draw.DrawingActivity.a(d, a, s1, b);
            }

            
            {
                d = DrawingActivity.this;
                a = flag;
                b = h1;
                super(context);
            }
        };
        ((h) (obj)).show(fragmentmanager, "textPromptDialog");
    }

    private void a(boolean flag, int i1)
    {
        ah = flag;
        ag = false;
        if (A)
        {
            z.b();
        }
        m.show();
        z = (CameraPreviewContainer)findViewById(0x7f10039b);
        z.setOpenedCameraIndex(i1);
        (new AsyncTask(flag) {

            private boolean a;
            private DrawingActivity b;

            protected final Object doInBackground(Object aobj[])
            {
                return Boolean.valueOf(DrawingActivity.B(b).a());
            }

            protected final void onPostExecute(Object obj)
            {
                if (((Boolean)obj).booleanValue())
                {
                    com.socialin.android.photo.draw.DrawingActivity.d(b, true);
                    DrawingActivity.ag(b);
                    com.socialin.android.photo.draw.DrawingActivity.a(b, CameraPanelState.OPENED);
                    com.socialin.android.photo.draw.DrawingActivity.b(b).setCameraDrawingOn(a);
                } else
                {
                    DrawingActivity.ab(b);
                    Toast.makeText(b, b.getString(0x7f08025e), 0).show();
                }
                DrawingActivity.t(b).dismiss();
            }

            
            {
                b = DrawingActivity.this;
                a = flag;
                super();
            }
        }).execute(new Void[0]);
    }

    static boolean a(DrawingActivity drawingactivity, String s1, StringBuilder stringbuilder, boolean flag)
    {
        return drawingactivity.a(s1, stringbuilder, flag);
    }

    private boolean a(String s1, StringBuilder stringbuilder, boolean flag)
    {
        File file = new File(com.socialin.android.brushlib.project.a.a);
        if (flag)
        {
            file = new File(file, (new StringBuilder()).append(s1).append(".gif").toString());
        } else
        {
            file = new File(file, (new StringBuilder()).append(s1).append(".webm").toString());
        }
        if (s1.isEmpty())
        {
            if (stringbuilder != null)
            {
                stringbuilder.append(getString(0x7f080662));
            }
            return false;
        }
        if (file.exists())
        {
            if (stringbuilder != null)
            {
                stringbuilder.append(getString(0x7f080664));
            }
            return false;
        } else
        {
            return true;
        }
    }

    static com.socialin.android.dialog.a aa(DrawingActivity drawingactivity)
    {
        return drawingactivity.ae;
    }

    static void ab(DrawingActivity drawingactivity)
    {
        drawingactivity.n();
    }

    static String ac(DrawingActivity drawingactivity)
    {
        return drawingactivity.g;
    }

    static long ad(DrawingActivity drawingactivity)
    {
        return drawingactivity.h;
    }

    static void ae(DrawingActivity drawingactivity)
    {
        drawingactivity.d();
    }

    static boolean af(DrawingActivity drawingactivity)
    {
        drawingactivity.ag = false;
        return false;
    }

    static void ag(DrawingActivity drawingactivity)
    {
        drawingactivity = drawingactivity.findViewById(0x7f1003ab);
        drawingactivity.setVisibility(0);
        drawingactivity.animate().alpha(1.0F).setListener(null);
    }

    static com.socialin.android.colorpicker.c ah(DrawingActivity drawingactivity)
    {
        return drawingactivity.E;
    }

    static com.socialin.android.colorpicker.d ai(DrawingActivity drawingactivity)
    {
        return drawingactivity.G;
    }

    static void aj(DrawingActivity drawingactivity)
    {
        Intent intent = new Intent(drawingactivity, com/socialin/android/photo/draw/dialog/SelectBrushDialog);
        intent.putExtra("extra.brush.color", drawingactivity.s.l);
        BrushHistory.setProjectFolderPath((new StringBuilder()).append(drawingactivity.s.c.k.getRootFolder().getPath()).append("/").toString());
        intent.putExtra("extra.brush.history", drawingactivity.s.m);
        boolean flag;
        if (drawingactivity.s.b() == com.socialin.android.brushlib.view.DrawingView.DrawingMode.ERASE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        intent.putExtra("extra.is.eraser", flag);
        intent.putExtra("extra.draw.session.id", drawingactivity.g);
        intent.putExtra("extra.uid", drawingactivity.b.a);
        drawingactivity.startActivityForResult(intent, RequestCode.SELECT_BRUSH.toInt());
    }

    static void ak(DrawingActivity drawingactivity)
    {
        Object obj = drawingactivity.s.i;
        Object obj1 = ((com.socialin.android.brushlib.a) (obj)).a;
        if (((ShapeOverlayController) (obj)).g != null)
        {
            obj = ((ShapeOverlayController) (obj)).g;
        } else
        if (obj1 == null || (obj1 instanceof ShapeOverlay) && ((ShapeOverlay)obj1).getParams() == null || (obj1 instanceof LineOverlay) && ((LineOverlay)obj1).getParams() == null)
        {
            obj = (new com.socialin.android.brushlib.svg.b()).b(255);
            obj.c = 0xff000000;
            obj.b = 20F;
            obj.a = true;
            obj = ((com.socialin.android.brushlib.svg.b) (obj)).a();
        } else
        if (obj1 instanceof ShapeOverlay)
        {
            obj = ((ShapeOverlay)obj1).getParams();
        } else
        if (obj1 instanceof LineOverlay)
        {
            obj = ((LineOverlay)obj1).getParams();
        } else
        {
            obj = null;
        }
        obj1 = new Intent(drawingactivity, com/socialin/android/photo/draw/dialog/SelectShapeDialog);
        ((Intent) (obj1)).putExtra("extra.brush.color", drawingactivity.s.l);
        if (obj != null)
        {
            ((Intent) (obj1)).putExtra("extra.previous.opacity", Color.alpha(((ShapeParams) (obj)).getColor()));
            ((Intent) (obj1)).putExtra("extra.previous.thickness", ((ShapeParams) (obj)).getSize());
            ((Intent) (obj1)).putExtra("extra.previous.stroke", ((ShapeParams) (obj)).isStroke());
        } else
        {
            ((Intent) (obj1)).putExtra("extra.previous.opacity", 255);
            ((Intent) (obj1)).putExtra("extra.previous.thickness", 20);
            ((Intent) (obj1)).putExtra("extra.previous.stroke", true);
        }
        drawingactivity.startActivityForResult(((Intent) (obj1)), RequestCode.SELECT_SHAPE.toInt());
    }

    static void al(DrawingActivity drawingactivity)
    {
        Intent intent = new Intent(drawingactivity, com/socialin/android/photo/clipart/SelectClipArtFrameActivity);
        intent.putExtra("category", "textart");
        intent.putExtra("from-drawing", true);
        DrawTextStyle drawtextstyle = drawingactivity.s.j.c;
        TextArtStyle textartstyle;
        if (drawtextstyle != null)
        {
            textartstyle = new TextArtStyle();
            textartstyle.setFillColor(drawingactivity.s.l);
            textartstyle.setFillGradientBottomColor(drawtextstyle.gradientColor);
            textartstyle.setStrokeColor(drawtextstyle.borderColor);
            textartstyle.setFontSize(drawtextstyle.size);
            textartstyle.setTextHeight(drawtextstyle.textHeight);
            textartstyle.setHasGradient(drawtextstyle.hasGradient);
            textartstyle.setHasStroke(drawtextstyle.hasBorder);
            textartstyle.getTypefaceSpec().setFontPathFromSdCard(drawtextstyle.isFontFromSdCard);
            textartstyle.getTypefaceSpec().setFontPath(drawtextstyle.fontPath);
            textartstyle.getTypefaceSpec().setFontPackagePath(drawtextstyle.fontPackagePath);
        } else
        {
            textartstyle = new TextArtStyle();
            textartstyle.setFillColor(drawingactivity.s.l);
        }
        intent.putExtra("style", textartstyle);
        intent.putExtra("text", drawingactivity.s.j.d);
        if (drawtextstyle == null)
        {
            intent.putExtra("style-index", 0);
            intent.putExtra("font-type", 0);
        } else
        {
            intent.putExtra("style-index", drawtextstyle.styleIndex);
            intent.putExtra("font-type", drawtextstyle.fontType);
        }
        drawingactivity.startActivityForResult(intent, RequestCode.SELECT_TEXT.toInt());
    }

    static void am(DrawingActivity drawingactivity)
    {
label0:
        {
            if (drawingactivity.s != null && drawingactivity.s.c.b != null)
            {
                if (!drawingactivity.s.c.b.g())
                {
                    break label0;
                }
                Toast.makeText(drawingactivity, 0x7f080406, 0).show();
            }
            return;
        }
        Intent intent = new Intent(drawingactivity, com/picsart/studio/ImagePickerActivity);
        intent.putExtra("from", "draw");
        intent.putExtra("showCameraEffects", true);
        myobfuscated.cv.c.a(intent, drawingactivity);
        drawingactivity.startActivityForResult(intent, RequestCode.CHOOSE_PIC_FOR_ADD_PHOTO.toInt());
    }

    static void an(DrawingActivity drawingactivity)
    {
        Intent intent = new Intent(drawingactivity, com/socialin/android/photo/clipart/SelectClipArtFrameActivity);
        intent.putExtra("category", "clipart");
        drawingactivity.startActivityForResult(intent, RequestCode.SELECT_CLIPART.toInt());
    }

    static void ao(DrawingActivity drawingactivity)
    {
        if (drawingactivity.ap == LayerPanelState.CLOSED)
        {
            drawingactivity.f(true);
        } else
        if (drawingactivity.ap == LayerPanelState.OPENED)
        {
            drawingactivity.e(true);
            return;
        }
    }

    static void ap(DrawingActivity drawingactivity)
    {
        drawingactivity.p();
    }

    static boolean aq(DrawingActivity drawingactivity)
    {
        return drawingactivity.au;
    }

    static ViewGroup ar(DrawingActivity drawingactivity)
    {
        return drawingactivity.al;
    }

    static FrameLayout as(DrawingActivity drawingactivity)
    {
        return drawingactivity.T;
    }

    static void at(DrawingActivity drawingactivity)
    {
        drawingactivity.r();
    }

    static void au(DrawingActivity drawingactivity)
    {
        if (drawingactivity.m.isShowing())
        {
            drawingactivity.m.dismiss();
        }
    }

    static void av(DrawingActivity drawingactivity)
    {
        drawingactivity.u();
    }

    static Bitmap aw(DrawingActivity drawingactivity)
    {
        Bitmap bitmap = Bitmap.createBitmap(drawingactivity.s.f(), drawingactivity.s.g(), android.graphics.Bitmap.Config.ARGB_8888);
        DrawingView drawingview = drawingactivity.s;
        if (drawingview.p != null)
        {
            drawingview.p.d();
        }
        drawingactivity.s.a(bitmap);
        return bitmap;
    }

    private Bitmap b(String s1, HashMap hashmap, int i1)
    {
        if (hashmap != null)
        {
            try
            {
                s1 = com.socialin.android.util.w.a(hashmap, PicsartContext.a(), i1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                s1 = new com.socialin.android.dialog.b();
                s1.h = false;
                s1.b = getString(0x7f080482);
                s1.a().show(getFragmentManager(), null);
                return null;
            }
            return s1;
        } else
        {
            return com.socialin.android.util.w.b(s1, PicsartContext.a(), i1);
        }
    }

    static WrappingListPopupWindow b(DrawingActivity drawingactivity, WrappingListPopupWindow wrappinglistpopupwindow)
    {
        drawingactivity.N = wrappinglistpopupwindow;
        return wrappinglistpopupwindow;
    }

    public static DrawingView b(DrawingActivity drawingactivity)
    {
        return drawingactivity.s;
    }

    private void b(Project project)
    {
        Object obj = null;
        ObjectInputStream objectinputstream;
        try
        {
            objectinputstream = new ObjectInputStream(new FileInputStream(new File((new StringBuilder()).append(project.getRootFolder().getPath()).append(File.separator).append("editingdat.aaf").toString())));
        }
        // Misplaced declaration of an exception variable
        catch (Project project)
        {
            project.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Project project)
        {
            project.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Project project)
        {
            project.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Project project)
        {
            project.printStackTrace();
            return;
        }
        project = obj;
        if (objectinputstream.readObject() != null)
        {
            project = objectinputstream.readObject().toString();
        }
        objectinputstream.close();
        if (b == null || project == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        b.b = project;
    }

    static void b(DrawingActivity drawingactivity, View view)
    {
        Object obj = drawingactivity.s.c;
        if (obj != null && ((a) (obj)).k != null)
        {
            ((a) (obj)).k.isDraft();
        }
        obj = new myobfuscated.ce.a(drawingactivity);
        ((myobfuscated.ce.a) (obj)).add(new myobfuscated.ce.b(0x7f02051c, drawingactivity.getString(0x7f080103), null, true, 0x7f100034));
        ((myobfuscated.ce.a) (obj)).add(new myobfuscated.ce.b(0x7f020458, drawingactivity.getString(0x7f080102), null, true, 0x7f100033));
        p p1 = WrappingListPopupWindow.a(drawingactivity);
        p1.a = view;
        p1.b = ((android.widget.ListAdapter) (obj));
        p1.c = drawingactivity. new android.widget.AdapterView.OnItemClickListener() {

            private DrawingActivity a;

            public final void onItemClick(AdapterView adapterview, View view1, int i1, long l1)
            {
                switch (i1)
                {
                default:
                    return;

                case 0: // '\0'
                    DrawingActivity.W(a);
                    return;

                case 1: // '\001'
                    DrawingActivity.X(a);
                    break;
                }
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        };
        drawingactivity.N = p1.b();
    }

    static void b(DrawingActivity drawingactivity, String s1)
    {
        drawingactivity.a(s1);
    }

    static void b(DrawingActivity drawingactivity, boolean flag)
    {
        drawingactivity.c(flag);
    }

    private void b(boolean flag)
    {
        if (A && (flag || !z.e))
        {
            z.b();
            s.d();
            s.a(false);
            A = false;
            n();
        }
    }

    static WrappingListPopupWindow c(DrawingActivity drawingactivity, WrappingListPopupWindow wrappinglistpopupwindow)
    {
        drawingactivity.O = wrappinglistpopupwindow;
        return wrappinglistpopupwindow;
    }

    static String c()
    {
        return c;
    }

    static void c(DrawingActivity drawingactivity, boolean flag)
    {
        drawingactivity.a(flag);
    }

    private void c(boolean flag)
    {
        if (findViewById(0x7f1003a5) != null)
        {
            findViewById(0x7f1003a5).setEnabled(flag);
        }
        if (findViewById(0x7f1003b2) != null)
        {
            findViewById(0x7f1003b2).setEnabled(flag);
        }
        if (findViewById(0x7f1003b7) != null)
        {
            findViewById(0x7f1003b7).setEnabled(flag);
        }
        if (findViewById(0x7f1003b4) != null)
        {
            findViewById(0x7f1003b4).setEnabled(flag);
        }
        if (findViewById(0x7f1003b5) != null)
        {
            findViewById(0x7f1003b5).setEnabled(flag);
        }
        if (findViewById(0x7f1003b6) != null)
        {
            findViewById(0x7f1003b6).setEnabled(flag);
        }
        if (findViewById(0x7f1003b8) != null)
        {
            findViewById(0x7f1003b8).setEnabled(flag);
        }
        findViewById(0x7f1003a2).setEnabled(flag);
        findViewById(0x7f1003a3).setEnabled(flag);
        findViewById(0x7f1003a4).setEnabled(flag);
        findViewById(0x7f1003a6).setEnabled(flag);
        findViewById(0x7f1003a7).setEnabled(flag);
        findViewById(0x7f1003a8).setEnabled(flag);
        findViewById(0x7f1003ae).setEnabled(flag);
        findViewById(0x7f100285).setEnabled(flag);
        findViewById(0x7f100286).setEnabled(flag);
        findViewById(0x7f1003af).setEnabled(flag);
        findViewById(0x7f1003b0).setEnabled(flag);
        findViewById(0x7f1003b1).setEnabled(flag);
        findViewById(0x7f1003b3).setEnabled(flag);
    }

    static boolean c(DrawingActivity drawingactivity)
    {
        return drawingactivity.k;
    }

    static WrappingListPopupWindow d(DrawingActivity drawingactivity, WrappingListPopupWindow wrappinglistpopupwindow)
    {
        drawingactivity.P = wrappinglistpopupwindow;
        return wrappinglistpopupwindow;
    }

    private void d()
    {
        g = UUID.randomUUID().toString();
        h = System.nanoTime();
    }

    static void d(DrawingActivity drawingactivity)
    {
        drawingactivity.i();
    }

    private void d(boolean flag)
    {
        if (ao == flag)
        {
            return;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        aj.setVisibility(0);
        aj.animate().alpha(1.0F).setDuration(300L).setListener(null);
        ak.setVisibility(0);
        ak.animate().alpha(1.0F).setDuration(300L).setListener(null);
        T.animate().alpha(0.0F).setDuration(300L).setListener(new android.animation.Animator.AnimatorListener() {

            private DrawingActivity a;

            public final void onAnimationCancel(Animator animator)
            {
            }

            public final void onAnimationEnd(Animator animator)
            {
                DrawingActivity.as(a).setVisibility(8);
            }

            public final void onAnimationRepeat(Animator animator)
            {
            }

            public final void onAnimationStart(Animator animator)
            {
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        if (an == LayerPanelState.OPENED || ap == LayerPanelState.OPENING)
        {
            f(true);
        }
_L4:
        ao = flag;
        return;
_L2:
        aj.animate().alpha(0.0F).setDuration(300L).setListener(new android.animation.Animator.AnimatorListener() {

            private DrawingActivity a;

            public final void onAnimationCancel(Animator animator)
            {
                onAnimationEnd(animator);
            }

            public final void onAnimationEnd(Animator animator)
            {
                DrawingActivity.k(a).setVisibility(8);
            }

            public final void onAnimationRepeat(Animator animator)
            {
            }

            public final void onAnimationStart(Animator animator)
            {
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        ak.animate().alpha(0.0F).setDuration(300L).setListener(new android.animation.Animator.AnimatorListener() {

            private DrawingActivity a;

            public final void onAnimationCancel(Animator animator)
            {
                onAnimationEnd(animator);
            }

            public final void onAnimationEnd(Animator animator)
            {
                com.socialin.android.photo.draw.DrawingActivity.l(a).setVisibility(8);
            }

            public final void onAnimationRepeat(Animator animator)
            {
            }

            public final void onAnimationStart(Animator animator)
            {
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        T.setVisibility(0);
        T.animate().alpha(1.0F).setDuration(300L).setListener(null);
        an = ap;
        if (ap == LayerPanelState.OPENED || ap == LayerPanelState.OPENING)
        {
            e(true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean d(DrawingActivity drawingactivity, boolean flag)
    {
        drawingactivity.A = flag;
        return flag;
    }

    static WrappingListPopupWindow e(DrawingActivity drawingactivity, WrappingListPopupWindow wrappinglistpopupwindow)
    {
        drawingactivity.Q = wrappinglistpopupwindow;
        return wrappinglistpopupwindow;
    }

    static void e(DrawingActivity drawingactivity)
    {
        drawingactivity.j();
    }

    private void e(boolean flag)
    {
        ap = LayerPanelState.CLOSING;
        if (flag)
        {
            View view = findViewById(0x7f1003c2);
            if (getResources().getConfiguration().orientation == 1)
            {
                view.setX(s.getRight() - view.getWidth());
            } else
            {
                view.setX(s.getRight() - view.getWidth() - ak.getWidth());
            }
            view.animate().xBy(view.getWidth()).setDuration(500L).setListener(new android.animation.Animator.AnimatorListener() {

                private DrawingActivity a;

                public final void onAnimationCancel(Animator animator)
                {
                    onAnimationEnd(animator);
                }

                public final void onAnimationEnd(Animator animator)
                {
                    com.socialin.android.photo.draw.DrawingActivity.a(a, LayerPanelState.CLOSED);
                }

                public final void onAnimationRepeat(Animator animator)
                {
                }

                public final void onAnimationStart(Animator animator)
                {
                }

            
            {
                a = DrawingActivity.this;
                super();
            }
            });
        } else
        {
            ap = LayerPanelState.CLOSED;
            if (android.os.Build.VERSION.SDK_INT >= 12)
            {
                findViewById(0x7f1003c2).setX(s.getRight());
            } else
            {
                findViewById(0x7f1003c2).setVisibility(4);
            }
        }
        findViewById(0x7f1003b3).setBackgroundResource(0x7f02068f);
        findViewById(0x7f1003b3).setPadding(7, 7, 7, 7);
    }

    private boolean e()
    {
        String s1;
        if (getIntent() != null && getIntent().hasExtra("from"))
        {
            s1 = getIntent().getStringExtra("from");
        } else
        {
            s1 = "";
        }
        return s1 != null && "editor".equals(s1);
    }

    private long f()
    {
        long l1 = n;
        n = System.nanoTime();
        return (System.nanoTime() - l1) / 0x3b9aca00L;
    }

    static void f(DrawingActivity drawingactivity)
    {
        drawingactivity = drawingactivity.z;
        if (Camera.getNumberOfCameras() > 1)
        {
            drawingactivity.c();
            drawingactivity.setCamera(drawingactivity.a(1 - ((CameraPreviewContainer) (drawingactivity)).b), 1 - ((CameraPreviewContainer) (drawingactivity)).b);
        }
    }

    private void f(boolean flag)
    {
        ap = LayerPanelState.OPENING;
        findViewById(0x7f1003c2).setVisibility(0);
        if (flag)
        {
            View view = findViewById(0x7f1003c2);
            view.setX(s.getRight());
            view.animate().x(0.0F).setDuration(500L).setListener(new android.animation.Animator.AnimatorListener() {

                private DrawingActivity a;

                public final void onAnimationCancel(Animator animator)
                {
                    onAnimationEnd(animator);
                }

                public final void onAnimationEnd(Animator animator)
                {
                    com.socialin.android.photo.draw.DrawingActivity.a(a, LayerPanelState.OPENED);
                }

                public final void onAnimationRepeat(Animator animator)
                {
                }

                public final void onAnimationStart(Animator animator)
                {
                }

            
            {
                a = DrawingActivity.this;
                super();
            }
            });
        } else
        {
            ap = LayerPanelState.OPENED;
        }
        findViewById(0x7f1003b3).setBackgroundResource(0x7f0f0094);
        findViewById(0x7f1003b3).setPadding(7, 7, 7, 7);
    }

    private void g()
    {
        boolean flag2 = true;
        View view = Y;
        boolean flag;
        boolean flag1;
        if (s.h() >= 2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        view.setEnabled(flag1);
        if (s.h() == DrawingView.k())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = X;
        if (!flag)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        view.setEnabled(flag1);
    }

    static void g(DrawingActivity drawingactivity)
    {
        if (drawingactivity.ai == CameraPanelState.OPENED)
        {
            View view = drawingactivity.findViewById(0x7f1003d1);
            view.animate().translationX(-view.getWidth()).setListener(drawingactivity. new android.animation.Animator.AnimatorListener(view) {

                private View a;
                private DrawingActivity b;

                public final void onAnimationCancel(Animator animator)
                {
                }

                public final void onAnimationEnd(Animator animator)
                {
                    a.setVisibility(4);
                    b.findViewById(0x7f1003cf).setVisibility(0);
                    b.findViewById(0x7f1003d0).setVisibility(8);
                    com.socialin.android.photo.draw.DrawingActivity.a(b, CameraPanelState.CLOSED);
                }

                public final void onAnimationRepeat(Animator animator)
                {
                }

                public final void onAnimationStart(Animator animator)
                {
                    com.socialin.android.photo.draw.DrawingActivity.a(b, CameraPanelState.CLOSING);
                }

            
            {
                b = DrawingActivity.this;
                a = view;
                super();
            }
            });
        }
    }

    private void g(boolean flag)
    {
        (new AsyncTask(false) {

            private boolean a;
            private DrawingActivity b;

            protected final Object doInBackground(Object aobj[])
            {
                return DrawingActivity.aw(b);
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (Bitmap)obj;
                DrawingActivity.au(b);
                if (!a)
                {
                    com.socialin.android.util.x.a();
                    Object obj1 = com.socialin.android.util.x.e();
                    String s1 = com.socialin.android.util.x.d();
                    (new File(s1, ((String) (obj1)))).mkdirs();
                    obj1 = com.socialin.android.util.w.a((new StringBuilder()).append(s1).append("/").append(((String) (obj1))).append("/orig_w").append(((Bitmap) (obj)).getWidth()).append("_h").append(((Bitmap) (obj)).getHeight()).toString(), ((Bitmap) (obj)));
                    com.socialin.android.util.x.c();
                    DrawingActivity.at(b);
                    com.socialin.android.photo.draw.DrawingActivity.a(b, ((Bitmap) (obj)), ((HashMap) (obj1)));
                    AnalyticUtils.getInstance(b).track(new com.socialin.android.apiv3.events.EventsFactory.DrawDoneEvent(DrawingActivity.Z(b).a, DrawingActivity.ac(b), com.socialin.android.photo.draw.DrawingActivity.b(b).g.b(), com.socialin.android.photo.draw.DrawingActivity.b(b).g.c(), "save", (System.nanoTime() - DrawingActivity.ad(b)) / 0x3b9aca00L));
                    DrawingActivity.ae(b);
                    DrawingActivity.av(b);
                }
            }

            
            {
                b = DrawingActivity.this;
                a = flag;
                super();
            }
        }).execute(new Object[] {
            Boolean.valueOf(false)
        });
    }

    private void h()
    {
        int i1 = getResources().getConfiguration().screenLayout & 0xf;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        View view;
        View view1;
        View view2;
        boolean flag;
        if (i1 == 3 || i1 == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aj = (ViewGroup)findViewById(0x7f10033c);
        aj.post(new Runnable() {

            private DrawingActivity a;

            public final void run()
            {
                DrawingView drawingview = com.socialin.android.photo.draw.DrawingActivity.b(a);
                if (drawingview.d == null) goto _L2; else goto _L1
_L1:
                com.socialin.android.brushlib.view.DrawingView._cls9.a[drawingview.s.ordinal()];
                JVM INSTR tableswitch 1 1: default 44
            //                           1 45;
                   goto _L2 _L3
_L2:
                return;
_L3:
                drawingview.a();
                return;
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        S = (ImageButton)findViewById(0x7f1003aa);
        T = (FrameLayout)findViewById(0x7f1003a9);
        obj = findViewById(0x7f1003a2);
        obj1 = findViewById(0x7f1003a8);
        obj2 = findViewById(0x7f1003a3);
        obj3 = findViewById(0x7f1003a4);
        obj4 = findViewById(0x7f1003b4);
        obj5 = findViewById(0x7f1003b5);
        obj6 = (ImageButton)findViewById(0x7f1003b6);
        view = findViewById(0x7f1003a5);
        view1 = findViewById(0x7f1003a7);
        view2 = findViewById(0x7f1003a6);
        R.a(((View) (obj)), getString(0x7f080295));
        R.a(((View) (obj1)), getString(0x7f0802b8));
        R.a(((View) (obj2)), getString(0x7f080362));
        R.a(((View) (obj3)), getString(0x7f080331));
        R.a(view1, getString(0x7f080401));
        R.a(view2, getString(0x7f0802c6));
        if (flag)
        {
            R.a(((View) (obj4)), getString(0x7f0802d5));
            R.a(((View) (obj5)), getString(0x7f0802cc));
            R.a(((View) (obj6)), getString(0x7f08060e));
        } else
        {
            R.a(view, getString(0x7f080576));
        }
        if (flag)
        {
            ((View) (obj4)).setOnClickListener(new android.view.View.OnClickListener() {

                private DrawingActivity a;

                public final void onClick(View view3)
                {
                    DrawingActivity.F(a);
                }

            
            {
                a = DrawingActivity.this;
                super();
            }
            });
            ((View) (obj5)).setOnClickListener(new android.view.View.OnClickListener() {

                private DrawingActivity a;

                public final void onClick(View view3)
                {
                    com.socialin.android.photo.draw.DrawingActivity.b(a).a();
                }

            
            {
                a = DrawingActivity.this;
                super();
            }
            });
            ((ImageButton) (obj6)).setOnClickListener(new android.view.View.OnClickListener(((ImageButton) (obj6))) {

                private ImageButton a;
                private DrawingActivity b;

                public final void onClick(View view3)
                {
                    if (a.isSelected())
                    {
                        com.socialin.android.photo.draw.DrawingActivity.e(b);
                        a.setSelected(false);
                        return;
                    } else
                    {
                        com.socialin.android.photo.draw.DrawingActivity.d(b);
                        a.setSelected(true);
                        return;
                    }
                }

            
            {
                b = DrawingActivity.this;
                a = imagebutton;
                super();
            }
            });
        } else
        {
            view.setOnClickListener(new android.view.View.OnClickListener(view) {

                final DrawingActivity a;
                private View b;

                public final void onClick(View view3)
                {
                    myobfuscated.ce.a a1;
                    p p1;
                    int j1;
                    if (com.socialin.android.photo.draw.DrawingActivity.c(a))
                    {
                        view3 = a.getString(0x7f080147);
                    } else
                    {
                        view3 = a.getString(0x7f080146);
                    }
                    if (com.socialin.android.photo.draw.DrawingActivity.c(a))
                    {
                        j1 = 0x7f020451;
                    } else
                    {
                        j1 = 0x7f02044a;
                    }
                    a1 = new myobfuscated.ce.a(a);
                    a1.add(new myobfuscated.ce.b(0x7f020381, a.getString(0x7f0802d5), null, true, 0x7f10003c));
                    a1.add(new myobfuscated.ce.b(0x7f02036e, a.getString(0x7f0802cc), null, true, 0x7f10003b));
                    a1.add(new myobfuscated.ce.b(j1, view3, null, true, 0x7f10003d));
                    view3 = a;
                    p1 = WrappingListPopupWindow.a(a);
                    p1.a = b;
                    p1.b = a1;
                    p1.c = new android.widget.AdapterView.OnItemClickListener(this) {

                        private _cls16 a;

                        public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
                        {
                            switch (i1)
                            {
                            default:
                                return;

                            case 0: // '\0'
                                DrawingActivity.F(a.a);
                                return;

                            case 1: // '\001'
                                com.socialin.android.photo.draw.DrawingActivity.b(a.a).a();
                                return;

                            case 2: // '\002'
                                DrawingActivity.G(a.a);
                                break;
                            }
                        }

            
            {
                a = _pcls16;
                super();
            }
                    };
                    com.socialin.android.photo.draw.DrawingActivity.a(view3, p1.b());
                }

            
            {
                a = DrawingActivity.this;
                b = view;
                super();
            }
            });
        }
        view1.setOnClickListener(new android.view.View.OnClickListener(view1) {

            final DrawingActivity a;
            private View b;

            public final void onClick(View view3)
            {
                view3 = null;
                boolean flag2 = true;
                Object obj7 = com.socialin.android.photo.draw.DrawingActivity.b(a).c;
                Object obj8;
                boolean flag1;
                int j1;
                if (obj7 != null && ((a) (obj7)).k != null && !((a) (obj7)).k.isDraft())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                obj7 = new myobfuscated.ce.a(a);
                ((myobfuscated.ce.a) (obj7)).add(new myobfuscated.ce.b(0x7f0203ba, a.getString(0x7f080309), null, true, 0x7f100036));
                ((myobfuscated.ce.a) (obj7)).add(new myobfuscated.ce.b(0x7f0203bf, a.getString(0x7f0804c2), null, true, 0x7f100037));
                ((myobfuscated.ce.a) (obj7)).add(new myobfuscated.ce.b(0x7f02035b, a.getString(0x7f08056f), null, true, 0x7f10003a));
                if (flag1)
                {
                    j1 = 0x7f0203e5;
                } else
                {
                    j1 = 0x7f0203e6;
                }
                obj8 = a.getString(0x7f08056e);
                if (flag1)
                {
                    view3 = a.getString(0x7f080129);
                }
                if (flag1)
                {
                    flag2 = false;
                }
                ((myobfuscated.ce.a) (obj7)).add(new myobfuscated.ce.b(j1, ((String) (obj8)), view3, flag2, 0x7f100039));
                view3 = a;
                obj8 = WrappingListPopupWindow.a(a);
                obj8.a = b;
                obj8.b = ((android.widget.ListAdapter) (obj7));
                obj8.c = new android.widget.AdapterView.OnItemClickListener(this) {

                    private _cls17 a;

                    public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
                    {
                        switch (i1)
                        {
                        default:
                            return;

                        case 0: // '\0'
                            DrawingActivity.H(a.a);
                            return;

                        case 1: // '\001'
                            DrawingActivity.I(a.a);
                            return;

                        case 2: // '\002'
                            DrawingActivity.J(a.a);
                            return;

                        case 3: // '\003'
                            adapterview = a.a;
                            break;
                        }
                        boolean flag;
                        if (!com.socialin.android.photo.draw.DrawingActivity.b(a.a).c.k.isDraft())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        com.socialin.android.photo.draw.DrawingActivity.c(adapterview, flag);
                    }

            
            {
                a = _pcls17;
                super();
            }
                };
                com.socialin.android.photo.draw.DrawingActivity.b(view3, ((p) (obj8)).b());
            }

            
            {
                a = DrawingActivity.this;
                b = view;
                super();
            }
        });
        if (!a)
        {
            view2.setVisibility(8);
        } else
        {
            view2.setOnClickListener(new android.view.View.OnClickListener() {

                private DrawingActivity a;

                public final void onClick(View view3)
                {
                    com.socialin.android.photo.draw.DrawingActivity.b(a, view3);
                }

            
            {
                a = DrawingActivity.this;
                super();
            }
            });
        }
        ((View) (obj1)).setOnClickListener(new android.view.View.OnClickListener() {

            final DrawingActivity a;

            public final void onClick(View view3)
            {
label0:
                {
                    view3 = a.getSharedPreferences("socialin", 0);
                    if (ActionCollector.a().b() == 2 || view3.getBoolean("dontShowDialogAgain", false))
                    {
                        DrawingActivity.K(a);
                        if (DrawingActivity.L(a))
                        {
                            boolean flag1 = com.socialin.android.photo.draw.DrawingActivity.c(a);
                            com.socialin.android.photo.draw.DrawingActivity.d(a);
                            com.socialin.android.photo.draw.DrawingActivity.a(a, new Runnable(this, flag1) {

                                private boolean a;
                                private _cls19 b;

                                public final void run()
                                {
                                    b.a.a();
                                    DrawingActivity.M(b.a);
                                    if (!a)
                                    {
                                        com.socialin.android.photo.draw.DrawingActivity.e(b.a);
                                    }
                                }

            
            {
                b = _pcls19;
                a = flag;
                super();
            }
                            });
                        } else
                        {
                            a.a();
                            DrawingActivity.M(a);
                        }
                    }
                    if (!DrawingActivity.N(a))
                    {
                        view3 = new Intent(a, com/socialin/android/dialog/CancelDialogActivity);
                        view3.putExtra("showSaveProject", com.socialin.android.photo.draw.DrawingActivity.b(a).c.k.isDraft());
                        view3.putExtra("showExport", false);
                        view3.putExtra("showTitle", true);
                        view3.putExtra("showEdit", false);
                        view3.putExtra("drawingActivityActionDone", true);
                        view3.putExtra("showCheckbox", true);
                        if (a.a)
                        {
                            view3.putExtra("showExportVideo", true);
                            view3.putExtra("showExportGif", true);
                        }
                        if (com.socialin.android.photo.draw.DrawingActivity.b(a).c.k.isDraft() || a.a)
                        {
                            break label0;
                        }
                        a.a();
                        DrawingActivity.M(a);
                    }
                    return;
                }
                a.startActivityForResult(view3, RequestCode.CANCEL_CONFIRM.toInt());
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view3)
            {
                DrawingActivity.O(a);
                com.socialin.android.brushlib.project.a.b();
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        findViewById(0x7f1003a3).setOnClickListener(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view3)
            {
                boolean flag2 = false;
                view3 = com.socialin.android.photo.draw.DrawingActivity.b(a);
                boolean flag1;
                if (((com.socialin.android.brushlib.a) (((DrawingView) (view3)).i)).a != null)
                {
                    ((DrawingView) (view3)).i.c();
                    view3.a(true);
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (((com.socialin.android.brushlib.a) (((DrawingView) (view3)).h)).a != null)
                {
                    ((DrawingView) (view3)).h.a();
                    view3.setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH);
                    view3.a(true);
                    flag1 = true;
                }
                if (!flag1 && ((DrawingView) (view3)).c.f.e() && !((DrawingView) (view3)).c.f.b())
                {
                    myobfuscated.br.a a1 = ((DrawingView) (view3)).c.f;
                    if (a1.e != null && a1.e.getStatus() != android.os.AsyncTask.Status.FINISHED)
                    {
                        flag1 = flag2;
                    } else
                    {
                        a1.b.a();
                        a1.a((Snapshot)a1.b.c(), a1.c.c.a(null));
                        flag1 = true;
                    }
                    if (flag1)
                    {
                        ((DrawingView) (view3)).g.a();
                        ActionCollector.a().a(new UndoAction(((DrawingView) (view3)).c.f.d().previousSnapshotKey));
                    }
                }
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        findViewById(0x7f1003a4).setOnClickListener(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view3)
            {
                view3 = com.socialin.android.photo.draw.DrawingActivity.b(a);
                if (((DrawingView) (view3)).c.f.f() && !((DrawingView) (view3)).c.f.b())
                {
                    myobfuscated.br.a a1 = ((DrawingView) (view3)).c.f;
                    boolean flag1;
                    if (a1.e != null && a1.e.getStatus() != android.os.AsyncTask.Status.FINISHED)
                    {
                        flag1 = false;
                    } else
                    {
                        a1.b.b();
                        a1.a((Snapshot)a1.b.c(), a1.c.c.a(null));
                        flag1 = true;
                    }
                    if (flag1)
                    {
                        ((DrawingView) (view3)).g.a();
                        ActionCollector.a().a(new RedoAction(((DrawingView) (view3)).c.f.d().previousSnapshotKey));
                    }
                }
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        S.setOnClickListener(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view3)
            {
                DrawingActivity.F(a);
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        obj = (ImageButton)findViewById(0x7f100ac7);
        obj1 = (ImageButton)findViewById(0x7f100ac8);
        obj2 = (ImageButton)findViewById(0x7f100ac9);
        obj3 = (ImageButton)findViewById(0x7f100aca);
        obj4 = (ImageButton)findViewById(0x7f100acb);
        obj5 = (ImageButton)findViewById(0x7f100acc);
        al = (LinearLayout)findViewById(0x7f1003ad);
        obj6 = s.k;
        ((ImageButton) (obj1)).setOnClickListener(new android.view.View.OnClickListener(((com.socialin.android.brushlib.controller.h) (obj6))) {

            private com.socialin.android.brushlib.controller.h a;

            public final void onClick(View view3)
            {
                a.b();
            }

            
            {
                a = h1;
                super();
            }
        });
        obj6 = new android.view.View.OnClickListener(((com.socialin.android.brushlib.controller.h) (obj6))) {

            private com.socialin.android.brushlib.controller.h a;
            private DrawingActivity b;

            public final void onClick(View view3)
            {
                view3.getId();
                JVM INSTR tableswitch 2131757767 2131757772: default 44
            //                           2131757767 45
            //                           2131757768 73
            //                           2131757769 81
            //                           2131757770 190
            //                           2131757771 300
            //                           2131757772 410;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
                return;
_L2:
                a.a();
                DrawingActivity.ap(b);
                com.socialin.android.photo.draw.DrawingActivity.b(b).setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH);
                return;
_L3:
                a.b();
                return;
_L4:
                view3 = a;
                b b1 = ((com.socialin.android.brushlib.controller.h) (view3)).a.c.b;
                if (((com.socialin.android.brushlib.controller.h) (view3)).k == null || !((com.socialin.android.brushlib.controller.h) (view3)).k.isRunning())
                {
                    view3.l = ((com.socialin.android.brushlib.controller.h) (view3)).a.c.b.a;
                    ((com.socialin.android.brushlib.controller.h) (view3)).m.set(((com.socialin.android.brushlib.controller.h) (view3)).l);
                    ((com.socialin.android.brushlib.controller.h) (view3)).n.set(((com.socialin.android.brushlib.controller.h) (view3)).l);
                    ((com.socialin.android.brushlib.controller.h) (view3)).n.preRotate(90F, b1.i() / 2, b1.j() / 2);
                    view3.a(((com.socialin.android.brushlib.controller.h) (view3)).m, ((com.socialin.android.brushlib.controller.h) (view3)).n);
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L5:
                view3 = a;
                b b2 = ((com.socialin.android.brushlib.controller.h) (view3)).a.c.b;
                if (((com.socialin.android.brushlib.controller.h) (view3)).k == null || !((com.socialin.android.brushlib.controller.h) (view3)).k.isRunning())
                {
                    view3.l = ((com.socialin.android.brushlib.controller.h) (view3)).a.c.b.a;
                    ((com.socialin.android.brushlib.controller.h) (view3)).m.set(((com.socialin.android.brushlib.controller.h) (view3)).l);
                    ((com.socialin.android.brushlib.controller.h) (view3)).n.set(((com.socialin.android.brushlib.controller.h) (view3)).l);
                    ((com.socialin.android.brushlib.controller.h) (view3)).n.preScale(-1F, 1.0F, b2.i() / 2, b2.j() / 2);
                    view3.a(((com.socialin.android.brushlib.controller.h) (view3)).m, ((com.socialin.android.brushlib.controller.h) (view3)).n);
                    return;
                }
                if (true) goto _L1; else goto _L6
_L6:
                view3 = a;
                b b3 = ((com.socialin.android.brushlib.controller.h) (view3)).a.c.b;
                if (((com.socialin.android.brushlib.controller.h) (view3)).k == null || !((com.socialin.android.brushlib.controller.h) (view3)).k.isRunning())
                {
                    view3.l = ((com.socialin.android.brushlib.controller.h) (view3)).a.c.b.a;
                    ((com.socialin.android.brushlib.controller.h) (view3)).m.set(((com.socialin.android.brushlib.controller.h) (view3)).l);
                    ((com.socialin.android.brushlib.controller.h) (view3)).n.set(((com.socialin.android.brushlib.controller.h) (view3)).l);
                    ((com.socialin.android.brushlib.controller.h) (view3)).n.preScale(1.0F, -1F, b3.i() / 2, b3.j() / 2);
                    view3.a(((com.socialin.android.brushlib.controller.h) (view3)).m, ((com.socialin.android.brushlib.controller.h) (view3)).n);
                    return;
                }
                if (true) goto _L1; else goto _L7
_L7:
                view3 = a;
                b b4 = ((com.socialin.android.brushlib.controller.h) (view3)).a.c.b;
                Bitmap bitmap = b4.b;
                Bitmap bitmap1 = b4.b;
                int j1 = b4.i();
                int k1 = b4.j();
                Matrix matrix = b4.a;
                Paint paint = new Paint(3);
                Bitmap bitmap2 = Bitmap.createBitmap(j1, k1, android.graphics.Bitmap.Config.ARGB_8888);
                (new Canvas(bitmap2)).drawBitmap(bitmap1, matrix, paint);
                ActionCollector.a().a(new LayerTransformAction(UUID.fromString(b4.c), new Matrix(b4.a), ((com.socialin.android.brushlib.controller.h) (view3)).a.c.f.d().key));
                b4.a.reset();
                b4.b = bitmap2;
                b4.j = new Canvas(b4.b);
                bitmap.recycle();
                ((com.socialin.android.brushlib.controller.h) (view3)).a.c.a(b4);
                ((com.socialin.android.brushlib.controller.h) (view3)).a.a(true);
                DrawingActivity.ap(b);
                com.socialin.android.photo.draw.DrawingActivity.b(b).setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH);
                return;
            }

            
            {
                b = DrawingActivity.this;
                a = h1;
                super();
            }
        };
        ((ImageButton) (obj)).setOnClickListener(((android.view.View.OnClickListener) (obj6)));
        ((ImageButton) (obj1)).setOnClickListener(((android.view.View.OnClickListener) (obj6)));
        ((ImageButton) (obj2)).setOnClickListener(((android.view.View.OnClickListener) (obj6)));
        ((ImageButton) (obj3)).setOnClickListener(((android.view.View.OnClickListener) (obj6)));
        ((ImageButton) (obj4)).setOnClickListener(((android.view.View.OnClickListener) (obj6)));
        ((ImageButton) (obj5)).setOnClickListener(((android.view.View.OnClickListener) (obj6)));
        ak = (ViewGroup)findViewById(0x7f1003ac);
        obj = ak.findViewById(0x7f1003ae);
        obj1 = ak.findViewById(0x7f100285);
        obj2 = ak.findViewById(0x7f100286);
        obj3 = ak.findViewById(0x7f1003af);
        obj4 = ak.findViewById(0x7f1003b0);
        obj5 = ak.findViewById(0x7f1003b1);
        obj6 = ak.findViewById(0x7f1003b7);
        view = ak.findViewById(0x7f1003b8);
        view1 = ak.findViewById(0x7f1003b2);
        view2 = ak.findViewById(0x7f1003b3);
        R.a(((View) (obj)), getString(0x7f080582));
        R.a(((View) (obj1)), getString(0x7f08012e));
        R.a(((View) (obj2)), getString(0x7f080234));
        R.a(((View) (obj3)), getString(0x7f0802ba));
        R.a(((View) (obj4)), getString(0x7f080046));
        R.a(((View) (obj5)), getString(0x7f080045));
        R.a(view2, getString(0x7f0804c1));
        if (flag)
        {
            R.a(((View) (obj6)), getString(0x7f080042));
            R.a(view, getString(0x7f080040));
        } else
        {
            R.a(view1, getString(0x7f080044));
        }
        ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view3)
            {
                com.socialin.android.photo.draw.DrawingActivity.a(a, com.socialin.android.photo.draw.DrawingActivity.b(a).l);
                com.socialin.android.photo.draw.DrawingActivity.a(a, DrawingActivity.ah(a), DrawingActivity.ai(a), com.socialin.android.photo.draw.DrawingActivity.b(a).l);
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        ((View) (obj1)).setOnClickListener(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view3)
            {
                if (com.socialin.android.photo.draw.DrawingActivity.b(a).b() == com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW && com.socialin.android.photo.draw.DrawingActivity.b(a).e() == com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH)
                {
                    DrawingActivity.aj(a);
                }
                com.socialin.android.photo.draw.DrawingActivity.b(a).setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH);
                com.socialin.android.photo.draw.DrawingActivity.b(a).setDrawingMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW);
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        ((View) (obj2)).setOnClickListener(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view3)
            {
                if (com.socialin.android.photo.draw.DrawingActivity.b(a).b() == com.socialin.android.brushlib.view.DrawingView.DrawingMode.ERASE && com.socialin.android.photo.draw.DrawingActivity.b(a).e() == com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH)
                {
                    DrawingActivity.aj(a);
                }
                com.socialin.android.photo.draw.DrawingActivity.b(a).setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH);
                com.socialin.android.photo.draw.DrawingActivity.b(a).setDrawingMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.ERASE);
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        ((View) (obj3)).setOnClickListener(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view3)
            {
                com.socialin.android.photo.draw.DrawingActivity.b(a).setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.CAMERA);
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        ((View) (obj5)).setOnClickListener(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view3)
            {
                com.socialin.android.photo.draw.DrawingActivity.ak(a);
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        ((View) (obj4)).setOnClickListener(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view3)
            {
                DrawingActivity.al(a);
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        if (flag)
        {
            ((View) (obj6)).setOnClickListener(new android.view.View.OnClickListener() {

                private DrawingActivity a;

                public final void onClick(View view3)
                {
                    com.socialin.android.photo.draw.DrawingActivity.am(a);
                }

            
            {
                a = DrawingActivity.this;
                super();
            }
            });
            view.setOnClickListener(new android.view.View.OnClickListener() {

                private DrawingActivity a;

                public final void onClick(View view3)
                {
                    DrawingActivity.an(a);
                }

            
            {
                a = DrawingActivity.this;
                super();
            }
            });
        } else
        {
            view1.setOnClickListener(new android.view.View.OnClickListener(view1) {

                final DrawingActivity a;
                private View b;

                public final void onClick(View view3)
                {
                    view3 = new myobfuscated.ce.a(a);
                    view3.add(new myobfuscated.ce.b(0x7f0202f7, a.getString(0x7f08031f), null, true, 0x7f100029));
                    view3.add(new myobfuscated.ce.b(0x7f02031f, a.getString(0x7f0802a1), null, true, 0x7f100028));
                    DrawingActivity drawingactivity = a;
                    p p1 = WrappingListPopupWindow.a(a);
                    p1.a = b;
                    p1.b = view3;
                    p1.c = new android.widget.AdapterView.OnItemClickListener(this) {

                        private _cls57 a;

                        public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
                        {
                            switch (i1)
                            {
                            default:
                                return;

                            case 0: // '\0'
                                com.socialin.android.photo.draw.DrawingActivity.am(a.a);
                                return;

                            case 1: // '\001'
                                DrawingActivity.an(a.a);
                                break;
                            }
                        }

            
            {
                a = _pcls57;
                super();
            }
                    };
                    com.socialin.android.photo.draw.DrawingActivity.e(drawingactivity, p1.b());
                }

            
            {
                a = DrawingActivity.this;
                b = view;
                super();
            }
            });
        }
        view2.setOnClickListener(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view3)
            {
                DrawingActivity.ao(a);
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        am = (ColorPickerPreview)ak.findViewById(0x7f1002ad);
        am.setColor(s.l);
        c(true);
        obj = findViewById(0x7f1003ab);
        obj1 = ((View) (obj)).findViewById(0x7f1003d4);
        obj2 = ((View) (obj)).findViewById(0x7f1003d3);
        obj3 = ((View) (obj)).findViewById(0x7f1003d2);
        obj4 = ((View) (obj)).findViewById(0x7f1003cf);
        obj5 = ((View) (obj)).findViewById(0x7f1003d0);
        R.a(((View) (obj1)), getString(0x7f080099));
        R.a(((View) (obj2)), getString(0x7f0805eb));
        R.a(((View) (obj3)), getString(0x7f080125));
        R.a(((View) (obj4)), getString(0x7f0804c0));
        R.a(((View) (obj5)), getString(0x7f0800c5));
        ((View) (obj1)).setOnClickListener(l);
        if (Camera.getNumberOfCameras() < 2)
        {
            ((View) (obj2)).setVisibility(8);
        } else
        {
            ((View) (obj2)).setOnClickListener(l);
        }
        ((View) (obj3)).setOnClickListener(l);
        ((View) (obj4)).setOnClickListener(l);
        ((View) (obj5)).setOnClickListener(l);
        ((View) (obj)).setVisibility(8);
    }

    static void h(DrawingActivity drawingactivity)
    {
        if (drawingactivity.ai == CameraPanelState.CLOSED)
        {
            View view = drawingactivity.findViewById(0x7f1003d1);
            view.setVisibility(0);
            view.animate().translationX(0.0F).setListener(drawingactivity. new android.animation.Animator.AnimatorListener(view) {

                private View a;
                private DrawingActivity b;

                public final void onAnimationCancel(Animator animator)
                {
                }

                public final void onAnimationEnd(Animator animator)
                {
                    b.findViewById(0x7f1003cf).setVisibility(8);
                    b.findViewById(0x7f1003d0).setVisibility(0);
                    com.socialin.android.photo.draw.DrawingActivity.a(b, CameraPanelState.OPENED);
                }

                public final void onAnimationRepeat(Animator animator)
                {
                }

                public final void onAnimationStart(Animator animator)
                {
                    com.socialin.android.photo.draw.DrawingActivity.a(b, CameraPanelState.OPENING);
                    a.setVisibility(0);
                }

            
            {
                b = DrawingActivity.this;
                a = view;
                super();
            }
            });
        }
    }

    private void i()
    {
        k = true;
        Utils.f(this);
    }

    static void i(DrawingActivity drawingactivity)
    {
        drawingactivity.d(false);
    }

    static Runnable j(DrawingActivity drawingactivity)
    {
        return drawingactivity.B;
    }

    private void j()
    {
        k = false;
        Utils.g(this);
    }

    static ViewGroup k(DrawingActivity drawingactivity)
    {
        return drawingactivity.aj;
    }

    private void k()
    {
        aa = new com.socialin.android.photo.draw.b(this, new j(Collections.unmodifiableList(s.c.a)));
        ab = (DragSortListView)findViewById(0x7f1003c7);
        ab.setAdapter(aa);
        Object obj = new com.mobeta.android.dslv.a(ab) {

            private DrawingActivity i;

            public final int a(MotionEvent motionevent)
            {
                int i1 = b(motionevent);
                if (i1 >= 0 && com.socialin.android.photo.draw.DrawingActivity.b(i).c.b == com.socialin.android.photo.draw.b.a(DrawingActivity.r(i)).get(i1))
                {
                    return i1;
                } else
                {
                    return -1;
                }
            }

            public final boolean onSingleTapUp(MotionEvent motionevent)
            {
                int i1 = b(motionevent);
                if (i1 != -1)
                {
                    com.socialin.android.photo.draw.DrawingActivity.b(i).setSelectedLayer((b)com.socialin.android.photo.draw.b.a(DrawingActivity.r(i)).get(i1));
                    DrawingActivity.r(i).notifyDataSetChanged();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                i = DrawingActivity.this;
                super(dragsortlistview);
            }
        };
        obj.d = 0x7f1003be;
        obj.c = false;
        obj.b = true;
        obj.a = 1;
        ab.setFloatViewManager(((com.mobeta.android.dslv.j) (obj)));
        ab.setOnTouchListener(((android.view.View.OnTouchListener) (obj)));
        ab.setDragEnabled(true);
        ab.setDropListener(ac);
        obj = new com.socialin.android.photo.draw.a(this, e);
        x = (Spinner)findViewById(0x7f1003c9);
        x.setAdapter(((android.widget.SpinnerAdapter) (obj)));
        x.setSelection(0, false);
        x.setOnItemSelectedListener(j);
        V = (TextView)findViewById(0x7f1003cc);
        W = (SeekBar)findViewById(0x7f1003cd);
        W.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private DrawingActivity a;

            public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                if (flag)
                {
                    com.socialin.android.photo.draw.DrawingActivity.b(a).setSelectedLayerOpacity(seekbar.getProgress());
                }
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                com.socialin.android.photo.draw.DrawingActivity.b(a).c.c();
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        X = findViewById(0x7f1003c4);
        R.a(X, getString(0x7f080043));
        X.setOnClickListener(new android.view.View.OnClickListener() {

            final DrawingActivity a;

            public final void onClick(View view)
            {
                boolean flag1 = true;
                Object obj1;
                p p1;
                int i1;
                int j1;
                boolean flag;
                if (DrawingActivity.L(a))
                {
                    i1 = 0x7f0202f2;
                } else
                {
                    i1 = 0x7f0202f3;
                }
                if (DrawingActivity.L(a))
                {
                    j1 = 0x7f020314;
                } else
                {
                    j1 = 0x7f020315;
                }
                view = new myobfuscated.ce.a(a);
                view.add(new myobfuscated.ce.b(0x7f0202f4, a.getString(0x7f08022e), null, true, 0x7f100035));
                view.add(new myobfuscated.ce.b(0x7f0202f6, a.getString(0x7f0804cf), null, true, 0x7f100038));
                obj1 = a.getString(0x7f080092);
                if (!DrawingActivity.L(a))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.add(new myobfuscated.ce.b(i1, ((String) (obj1)), null, flag, 0x7f100031));
                obj1 = a.getString(0x7f080065);
                if (!DrawingActivity.L(a))
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                view.add(new myobfuscated.ce.b(j1, ((String) (obj1)), null, flag, 0x7f100030));
                obj1 = a;
                p1 = WrappingListPopupWindow.a(a);
                p1.a = DrawingActivity.T(a);
                p1.b = view;
                p1.c = new android.widget.AdapterView.OnItemClickListener(this) {

                    private _cls27 a;

                    public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
                    {
                        i1;
                        JVM INSTR tableswitch 0 3: default 32
                    //                                   0 33
                    //                                   1 44
                    //                                   2 55
                    //                                   3 79;
                           goto _L1 _L2 _L3 _L4 _L5
_L1:
                        return;
_L2:
                        DrawingActivity.P(a.a);
                        return;
_L3:
                        DrawingActivity.Q(a.a);
                        return;
_L4:
                        if (!DrawingActivity.L(a.a))
                        {
                            DrawingActivity.R(a.a);
                            return;
                        }
                        continue; /* Loop/switch isn't completed */
_L5:
                        if (!DrawingActivity.L(a.a))
                        {
                            DrawingActivity.S(a.a);
                            return;
                        }
                        if (true) goto _L1; else goto _L6
_L6:
                    }

            
            {
                a = _pcls27;
                super();
            }
                };
                com.socialin.android.photo.draw.DrawingActivity.c(((DrawingActivity) (obj1)), p1.b());
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        Y = findViewById(0x7f1003c5);
        R.a(Y, getString(0x7f080560));
        Y.setOnClickListener(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view)
            {
                if (com.socialin.android.photo.draw.DrawingActivity.b(a).h() > 1)
                {
                    com.socialin.android.photo.draw.DrawingActivity.b(a).i();
                    view = com.socialin.android.photo.draw.DrawingActivity.b(a);
                    ((DrawingView) (view)).c.a(((DrawingView) (view)).c.b, true);
                    ((DrawingView) (view)).c.c();
                    DrawingActivity.r(a).notifyDataSetChanged();
                }
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        obj = (ImageButton)findViewById(0x7f1003c6);
        R.a(((View) (obj)), getString(0x7f0803d4));
        ((ImageButton) (obj)).setOnClickListener(new android.view.View.OnClickListener(((ImageButton) (obj))) {

            final DrawingActivity a;
            private ImageButton b;

            public final void onClick(View view)
            {
                view = com.socialin.android.photo.draw.DrawingActivity.b(a);
                Object obj1 = Collections.unmodifiableList(((DrawingView) (view)).c.a);
                int i1 = ((List) (obj1)).indexOf(((DrawingView) (view)).c.b);
                p p1;
                boolean flag;
                boolean flag1;
                if (i1 < ((List) (obj1)).size() && i1 > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                i1 = com.socialin.android.photo.draw.DrawingActivity.b(a).h();
                com.socialin.android.photo.draw.DrawingActivity.b(a);
                if (i1 < DrawingView.k())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                view = new myobfuscated.ce.a(a);
                view.add(new myobfuscated.ce.b(0x7f02039b, a.getString(0x7f08035a), null, true, 0x7f100058));
                view.add(new myobfuscated.ce.b(0x7f0201cd, a.getString(0x7f0802ab), null, flag1, 0x7f100056));
                if (flag)
                {
                    i1 = 0x7f020576;
                } else
                {
                    i1 = 0x7f020577;
                }
                view.add(new myobfuscated.ce.b(i1, a.getString(0x7f080300), null, flag, 0x7f100057));
                view.add(new myobfuscated.ce.b(0x7f02031d, a.getString(0x7f08029f), null, true, 0x7f100055));
                obj1 = a;
                p1 = WrappingListPopupWindow.a(a);
                p1.a = b;
                p1.b = view;
                p1.c = new android.widget.AdapterView.OnItemClickListener(this, flag1) {

                    private boolean a;
                    private _cls29 b;

                    public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
                    {
                        i1;
                        JVM INSTR tableswitch 0 3: default 32
                    //                                   0 33
                    //                                   1 108
                    //                                   2 172
                    //                                   3 525;
                           goto _L1 _L2 _L3 _L4 _L5
_L1:
                        return;
_L2:
                        if (com.socialin.android.photo.draw.DrawingActivity.b(b.a).i != null)
                        {
                            com.socialin.android.photo.draw.DrawingActivity.b(b.a).i.b();
                        }
                        if (com.socialin.android.photo.draw.DrawingActivity.b(b.a).h != null)
                        {
                            com.socialin.android.photo.draw.DrawingActivity.b(b.a).h.d();
                        }
                        DrawingActivity.U(b.a);
                        return;
_L3:
                        if (a)
                        {
                            adapterview = com.socialin.android.photo.draw.DrawingActivity.b(b.a);
                            view = ((DrawingView) (adapterview)).c.b.k();
                            ((DrawingView) (adapterview)).c.b(view);
                            ((DrawingView) (adapterview)).c.c();
                            adapterview.setSelectedLayer(view);
                            return;
                        } else
                        {
                            Utils.a(b.a, 0x7f080240);
                            return;
                        }
_L4:
                        adapterview = com.socialin.android.photo.draw.DrawingActivity.b(b.a);
                        view = Collections.unmodifiableList(((DrawingView) (adapterview)).c.a);
                        i1 = view.indexOf(((DrawingView) (adapterview)).c.b);
                        if (i1 < view.size() && i1 > 0)
                        {
                            Object obj = (b)view.get(i1 - 1);
                            Object obj1 = ((DrawingView) (adapterview)).c.b;
                            adapterview = ((DrawingView) (adapterview)).c;
                            view = new b[2];
                            view[0] = obj;
                            view[1] = obj1;
                            obj = ActionCollector.a();
                            obj1 = ((a) (adapterview)).f.d().key;
                            if (((ActionCollector) (obj)).c)
                            {
                                obj1 = new LayersMergeAction(((String) (obj1)));
                                ((ActionCollector) (obj)).b.add(obj1);
                            }
                            obj = com.socialin.android.brushlib.layer.b.a(((a) (adapterview)).d, ((a) (adapterview)).e);
                            if (obj != null)
                            {
                                obj.d = false;
                                b b1 = view[0];
                                int k1 = ((a) (adapterview)).a.indexOf(b1);
                                int j1;
                                if (((a) (adapterview)).b == b1)
                                {
                                    i1 = 1;
                                } else
                                {
                                    i1 = 0;
                                }
                                for (j1 = 0; j1 < 2; j1++)
                                {
                                    b b2 = view[j1];
                                    if (((a) (adapterview)).b == b2)
                                    {
                                        i1 = 1;
                                    }
                                    b2.a(((b) (obj)).j);
                                    adapterview.a(b2, false);
                                }

                                adapterview.b(((b) (obj)));
                                if (i1 != 0)
                                {
                                    adapterview.a(((b) (obj)));
                                    if (k1 >= ((a) (adapterview)).a.size())
                                    {
                                        i1 = ((a) (adapterview)).a.size() - 1;
                                    } else
                                    {
                                        i1 = k1;
                                    }
                                    adapterview.a(((a) (adapterview)).a.indexOf(obj), i1);
                                }
                                adapterview.c();
                                adapterview = ActionCollector.a();
                                view = UUID.fromString(((b) (obj)).c);
                                if (((ActionCollector) (adapterview)).c)
                                {
                                    adapterview.a(view).setComplete(true);
                                    return;
                                }
                            } else
                            {
                                ((a) (adapterview)).g.l();
                                return;
                            }
                        }
                        continue; /* Loop/switch isn't completed */
_L5:
                        view = com.socialin.android.photo.draw.DrawingActivity.b(b.a);
                        if (((DrawingView) (view)).c.j != null && ((DrawingView) (view)).r)
                        {
                            adapterview = ((DrawingView) (view)).c.j;
                        } else
                        {
                            adapterview = ((DrawingView) (view)).c.b;
                            ActionCollector.a().a(new LayerClearAction(UUID.fromString(adapterview.f()), ((DrawingView) (view)).c.f.d().key));
                        }
                        obj = ((DrawingView) (view)).c.f;
                        view = new com.socialin.android.brushlib.view.DrawingView._cls8(view);
                        if (adapterview.e() != null)
                        {
                            ((myobfuscated.br.a) (obj)).c();
                            adapterview.b(adapterview.e());
                            ((myobfuscated.br.a) (obj)).d.a(adapterview, new File(((myobfuscated.br.a) (obj)).c.c.k.getLayerOrigBuffersFolder(), adapterview.d()), new myobfuscated.br.a._cls2(((myobfuscated.br.a) (obj)), adapterview, view));
                            return;
                        }
                        if (true) goto _L1; else goto _L6
_L6:
                    }

            
            {
                b = _pcls29;
                a = flag;
                super();
            }
                };
                com.socialin.android.photo.draw.DrawingActivity.d(((DrawingActivity) (obj1)), p1.b());
            }

            
            {
                a = DrawingActivity.this;
                b = imagebutton;
                super();
            }
        });
        Z = findViewById(0x7f1003ca);
        Z.setOnClickListener(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view)
            {
                com.socialin.android.photo.draw.DrawingActivity.a(a, DrawingActivity.V(a));
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
    }

    static ViewGroup l(DrawingActivity drawingactivity)
    {
        return drawingactivity.ak;
    }

    private void l()
    {
        com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions gifoptions = new com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions(50D, 10, "");
        StringBuilder stringbuilder = new StringBuilder();
        com.socialin.android.dialog.b b1 = new com.socialin.android.dialog.b();
        b1.f = 0x7f0301b4;
        b1 = b1.a(0, 0x7f0c0181);
        b1.a = getString(0x7f08037a);
        b1.p = new com.socialin.android.dialog.c(gifoptions, stringbuilder) {

            final com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions a;
            final StringBuilder b;
            final DrawingActivity c;

            public final void onViewCreated(View view, DialogFragment dialogfragment)
            {
                dialogfragment = (TextView)view.findViewById(0x7f100813);
                SeekBar seekbar = (SeekBar)view.findViewById(0x7f100814);
                view = (EditText)view.findViewById(0x7f100811);
                String s1 = com.socialin.android.photo.draw.DrawingActivity.a(c, com.socialin.android.photo.draw.DrawingActivity.b(c).c.k, true);
                a.setOutputPath((new StringBuilder()).append(com.socialin.android.brushlib.project.a.a).append(s1).append(".gif").toString());
                b.append(s1);
                view.setText(s1);
                dialogfragment.setText("0.5 sec");
                a.setDelay(50D);
                seekbar.setProgress(4);
                view.addTextChangedListener(new TextWatcher(this, view) {

                    private EditText a;
                    private _cls35 b;

                    public final void afterTextChanged(Editable editable)
                    {
                        editable = a.getText().toString();
                        b.b.setLength(0);
                        b.b.append(editable);
                        b.a.setOutputPath((new StringBuilder()).append(com.socialin.android.brushlib.project.a.a).append(editable).append(".gif").toString());
                    }

                    public final void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
                    {
                    }

                    public final void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
                    {
                    }

            
            {
                b = _pcls35;
                a = edittext;
                super();
            }
                });
                seekbar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(this, dialogfragment) {

                    private TextView a;
                    private _cls35 b;

                    public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
                    {
                        b.a.setDelay(i1 * 10 + 10);
                        a.setText((new StringBuilder()).append((double)(i1 + 1) / 10D).append(b.c.getString(0x7f080661)).toString());
                    }

                    public final void onStartTrackingTouch(SeekBar seekbar)
                    {
                    }

                    public final void onStopTrackingTouch(SeekBar seekbar)
                    {
                    }

            
            {
                b = _pcls35;
                a = textview;
                super();
            }
                });
            }

            
            {
                c = DrawingActivity.this;
                a = gifoptions;
                b = stringbuilder;
                super();
            }
        };
        af = b1.a(new android.view.View.OnClickListener(stringbuilder, gifoptions) {

            private StringBuilder a;
            private com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions b;
            private DrawingActivity c;

            public final void onClick(View view)
            {
                view = new StringBuilder();
                if (!com.socialin.android.photo.draw.DrawingActivity.a(c, a.toString(), view, true))
                {
                    Toast.makeText(c, view.toString(), 1).show();
                } else
                {
                    DrawingActivity.Y(c).dismiss();
                    b.setmUid(DrawingActivity.Z(c).a);
                    view = com.socialin.android.photo.draw.DrawingActivity.b(c);
                    com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions gifoptions1 = b;
                    if (((DrawingView) (view)).c.k.containsActions())
                    {
                        view.a(new com.socialin.android.brushlib.view.DrawingView._cls7(view, gifoptions1));
                        return;
                    }
                }
            }

            
            {
                c = DrawingActivity.this;
                a = stringbuilder;
                b = gifoptions;
                super();
            }
        }).b(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view)
            {
                DrawingActivity.Y(a).dismiss();
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        }).a();
        af.show(getFragmentManager(), null);
    }

    static LayerPanelState m(DrawingActivity drawingactivity)
    {
        return drawingactivity.an;
    }

    private void m()
    {
        boolean flag = Build.MODEL.contains("I9192");
        com.socialin.android.videogenerator.ProjectVideoGenerator.VideoOptions videooptions = new com.socialin.android.videogenerator.ProjectVideoGenerator.VideoOptions(30, 1.0F, 30, null, com.socialin.android.videogenerator.ProjectVideoGenerator.VideoResolution.p1080, com.socialin.android.videogenerator.ProjectVideoGenerator.VideoFormat.mp4, null);
        Object obj = SocialinAdManager.a(this, com.socialin.android.ads.SocialinAdManager.PicsArtInterstitialType.DRAW);
        s.setInterstitial(((com.picsart.studio.ads.h) (obj)));
        obj = new StringBuilder();
        com.socialin.android.dialog.b b1 = new com.socialin.android.dialog.b();
        b1.f = 0x7f0301bf;
        b1 = b1.a(0, 0x7f0c0181);
        b1.a = getString(0x7f080668);
        b1.p = new com.socialin.android.dialog.c(flag, videooptions, ((StringBuilder) (obj))) {

            final com.socialin.android.videogenerator.ProjectVideoGenerator.VideoOptions a;
            final StringBuilder b;
            final DrawingActivity c;
            private boolean d;

            public final void onViewCreated(View view, DialogFragment dialogfragment)
            {
                dialogfragment = (TextView)view.findViewById(0x7f10083d);
                SeekBar seekbar = (SeekBar)view.findViewById(0x7f10083e);
                Spinner spinner = (Spinner)view.findViewById(0x7f100835);
                Spinner spinner1 = (Spinner)view.findViewById(0x7f100837);
                EditText edittext;
                String as1[];
                if (android.os.Build.VERSION.SDK_INT < 18 || d)
                {
                    spinner1.setVisibility(8);
                    view.findViewById(0x7f100836).setVisibility(8);
                    a.setFormat(com.socialin.android.videogenerator.ProjectVideoGenerator.VideoFormat.webm);
                } else
                {
                    a.setFormat(com.socialin.android.videogenerator.ProjectVideoGenerator.VideoFormat.mp4);
                }
                edittext = (EditText)view.findViewById(0x7f100834);
                as1 = new String[1];
                as1[0] = com.socialin.android.photo.draw.DrawingActivity.a(c, com.socialin.android.photo.draw.DrawingActivity.b(c).c.k, false);
                b.append(as1[0]);
                edittext.addTextChangedListener(new TextWatcher(this, edittext) {

                    private EditText a;
                    private _cls38 b;

                    public final void afterTextChanged(Editable editable)
                    {
                        editable = a.getText().toString();
                        b.b.setLength(0);
                        b.b.append(editable);
                        b.a.setOutputPath((new StringBuilder()).append(com.socialin.android.brushlib.project.a.a).append(editable).append(".").append(b.a.getFormat()).toString());
                    }

                    public final void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
                    {
                    }

                    public final void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
                    {
                    }

            
            {
                b = _pcls38;
                a = edittext;
                super();
            }
                });
                edittext.setText(as1[0]);
                spinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener(this, spinner) {

                    private Spinner a;
                    private _cls38 b;

                    public final void onItemSelected(AdapterView adapterview, View view, int i1, long l1)
                    {
                        b.a.setResolution(com.socialin.android.videogenerator.ProjectVideoGenerator.VideoResolution.fromString(a.getSelectedItem().toString()));
                        if (b.a.getFormat() == com.socialin.android.videogenerator.ProjectVideoGenerator.VideoFormat.mp4 && b.a.getResolution() == com.socialin.android.videogenerator.ProjectVideoGenerator.VideoResolution.p1080)
                        {
                            b.a.setResolution(com.socialin.android.videogenerator.ProjectVideoGenerator.VideoResolution.p1072);
                        }
                    }

                    public final void onNothingSelected(AdapterView adapterview)
                    {
                    }

            
            {
                b = _pcls38;
                a = spinner;
                super();
            }
                });
                spinner1.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener(this, spinner1, as1) {

                    private Spinner a;
                    private String b[];
                    private _cls38 c;

                    public final void onItemSelected(AdapterView adapterview, View view, int i1, long l1)
                    {
                        c.a.setFormat(com.socialin.android.videogenerator.ProjectVideoGenerator.VideoFormat.formatFromString(a.getSelectedItem().toString()));
                        c.a.setOutputPath((new StringBuilder()).append(com.socialin.android.brushlib.project.a.a).append(b[0]).append(".").append(c.a.getFormat()).toString());
                    }

                    public final void onNothingSelected(AdapterView adapterview)
                    {
                    }

            
            {
                c = _pcls38;
                a = spinner;
                b = as1;
                super();
            }
                });
                seekbar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(this, dialogfragment) {

                    private TextView a;
                    private _cls38 b;

                    public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
                    {
                        b.a.setDuration(i1 + 15);
                        a.setText((new StringBuilder()).append(i1 + 15).append(b.c.getString(0x7f080661)).toString());
                    }

                    public final void onStartTrackingTouch(SeekBar seekbar)
                    {
                    }

                    public final void onStopTrackingTouch(SeekBar seekbar)
                    {
                    }

            
            {
                b = _pcls38;
                a = textview;
                super();
            }
                });
                ((RadioGroup)view.findViewById(0x7f100838)).setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener(this, dialogfragment, seekbar) {

                    private TextView a;
                    private SeekBar b;
                    private _cls38 c;

                    public final void onCheckedChanged(RadioGroup radiogroup, int i1)
                    {
                        switch (i1)
                        {
                        default:
                            return;

                        case 2131757113: 
                            a.setVisibility(8);
                            b.setVisibility(8);
                            c.a.setDuration(15);
                            return;

                        case 2131757114: 
                            a.setVisibility(8);
                            b.setVisibility(8);
                            c.a.setDuration(15);
                            return;

                        case 2131757115: 
                            a.setVisibility(8);
                            b.setVisibility(8);
                            c.a.setDuration(60);
                            return;

                        case 2131757116: 
                            a.setVisibility(0);
                            break;
                        }
                        b.setVisibility(0);
                        a.setText((new StringBuilder()).append(b.getProgress() + 15).append(c.c.getString(0x7f080661)).toString());
                        c.a.setDuration(b.getProgress() + 15);
                    }

            
            {
                c = _pcls38;
                a = textview;
                b = seekbar;
                super();
            }
                });
            }

            
            {
                c = DrawingActivity.this;
                d = flag;
                a = videooptions;
                b = stringbuilder;
                super();
            }
        };
        ae = b1.a(new android.view.View.OnClickListener(((StringBuilder) (obj)), videooptions) {

            private StringBuilder a;
            private com.socialin.android.videogenerator.ProjectVideoGenerator.VideoOptions b;
            private DrawingActivity c;

            public final void onClick(View view)
            {
                view = new StringBuilder();
                if (!com.socialin.android.photo.draw.DrawingActivity.a(c, a.toString(), view, false))
                {
                    Toast.makeText(c, view.toString(), 1).show();
                } else
                {
                    DrawingActivity.aa(c).dismiss();
                    b.setmUid(DrawingActivity.Z(c).a);
                    view = com.socialin.android.photo.draw.DrawingActivity.b(c);
                    com.socialin.android.videogenerator.ProjectVideoGenerator.VideoOptions videooptions1 = b;
                    if (((DrawingView) (view)).c.k.containsActions())
                    {
                        view.a(new com.socialin.android.brushlib.view.DrawingView._cls6(view, videooptions1));
                        return;
                    }
                }
            }

            
            {
                c = DrawingActivity.this;
                a = stringbuilder;
                b = videooptions;
                super();
            }
        }).b(new android.view.View.OnClickListener() {

            private DrawingActivity a;

            public final void onClick(View view)
            {
                DrawingActivity.aa(a).dismiss();
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        }).a();
        ae.show(getFragmentManager(), null);
    }

    static LayerPanelState n(DrawingActivity drawingactivity)
    {
        return drawingactivity.ap;
    }

    private void n()
    {
        View view = findViewById(0x7f1003ab);
        view.animate().alpha(0.0F).setListener(new android.animation.Animator.AnimatorListener(view) {

            private View a;

            public final void onAnimationCancel(Animator animator)
            {
            }

            public final void onAnimationEnd(Animator animator)
            {
                a.setVisibility(8);
            }

            public final void onAnimationRepeat(Animator animator)
            {
            }

            public final void onAnimationStart(Animator animator)
            {
            }

            
            {
                a = view;
                super();
            }
        });
    }

    private void o()
    {
        au = s.c.b.f;
        aj.animate().alpha(0.0F).setDuration(300L).setListener(new android.animation.Animator.AnimatorListener() {

            private DrawingActivity a;

            public final void onAnimationCancel(Animator animator)
            {
                onAnimationEnd(animator);
            }

            public final void onAnimationEnd(Animator animator)
            {
                if (!DrawingActivity.aq(a))
                {
                    com.socialin.android.photo.draw.DrawingActivity.b(a).c.b.f = true;
                }
                DrawingActivity.k(a).setVisibility(8);
            }

            public final void onAnimationRepeat(Animator animator)
            {
            }

            public final void onAnimationStart(Animator animator)
            {
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        ak.animate().alpha(0.0F).setDuration(300L).setListener(new android.animation.Animator.AnimatorListener() {

            private DrawingActivity a;

            public final void onAnimationCancel(Animator animator)
            {
                onAnimationEnd(animator);
            }

            public final void onAnimationEnd(Animator animator)
            {
                com.socialin.android.photo.draw.DrawingActivity.l(a).setVisibility(8);
            }

            public final void onAnimationRepeat(Animator animator)
            {
            }

            public final void onAnimationStart(Animator animator)
            {
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        al.setVisibility(0);
        al.animate().alpha(1.0F).setListener(null).setDuration(300L);
        an = ap;
        if (ap == LayerPanelState.OPENED || ap == LayerPanelState.OPENING)
        {
            e(true);
        }
    }

    static void o(DrawingActivity drawingactivity)
    {
        drawingactivity.f(true);
    }

    public static View p(DrawingActivity drawingactivity)
    {
        return drawingactivity.H;
    }

    private void p()
    {
        aj.setVisibility(0);
        aj.animate().alpha(1.0F).setDuration(300L).setListener(null);
        ak.setVisibility(0);
        ak.animate().alpha(1.0F).setDuration(300L).setListener(null);
        al.animate().alpha(0.0F).setDuration(300L).setListener(new android.animation.Animator.AnimatorListener() {

            private DrawingActivity a;

            public final void onAnimationCancel(Animator animator)
            {
                onAnimationEnd(animator);
            }

            public final void onAnimationEnd(Animator animator)
            {
                DrawingActivity.ar(a).setVisibility(8);
                com.socialin.android.photo.draw.DrawingActivity.b(a).c.b.f = DrawingActivity.aq(a);
                DrawingActivity.r(a).notifyDataSetChanged();
            }

            public final void onAnimationRepeat(Animator animator)
            {
            }

            public final void onAnimationStart(Animator animator)
            {
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        if (an == LayerPanelState.OPENED || ap == LayerPanelState.OPENING)
        {
            f(true);
        }
    }

    public static TextView q(DrawingActivity drawingactivity)
    {
        return drawingactivity.I;
    }

    private void q()
    {
        if (q != 2 || ActionCollector.a().b() != 2) goto _L2; else goto _L1
_L1:
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.DrawDoneEvent(b.a, g, s.g.b(), s.g.c(), "close", (System.nanoTime() - h) / 0x3b9aca00L));
        d();
        if (A)
        {
            boolean flag = k;
            i();
            a(new Runnable(flag) {

                private boolean a;
                private DrawingActivity b;

                public final void run()
                {
                    b.a();
                    DrawingActivity.M(b);
                    if (!a)
                    {
                        com.socialin.android.photo.draw.DrawingActivity.e(b);
                    }
                }

            
            {
                b = DrawingActivity.this;
                a = flag;
                super();
            }
            });
        } else
        {
            if (showEnjoyDialog)
            {
                com.socialin.android.picsart.profile.invite.i.a(this, "close");
            }
            executeInviteNotificaionAction();
            r();
            a(((Bitmap) (null)), ((HashMap) (null)));
        }
_L4:
        AnalyticUtils.getInstance(this).trackPageView("dialog_cancel_drawing");
        return;
_L2:
        if (ActionCollector.a().b() == 2)
        {
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.DrawDoneEvent(b.a, g, s.g.b(), s.g.c(), "close", (System.nanoTime() - h) / 0x3b9aca00L));
            d();
            if (s != null && s.c.k.isDraft())
            {
                FileUtils.b(s.c.k.getRootFolder().getAbsolutePath());
            }
            r();
            if (showEnjoyDialog)
            {
                com.socialin.android.picsart.profile.invite.i.a(this, "close");
            }
            executeInviteNotificaionAction();
            u();
        } else
        {
            if (q == 2)
            {
                Object obj = new com.socialin.android.dialog.b();
                obj.b = getString(0x7f080122);
                obj = ((com.socialin.android.dialog.b) (obj)).a(new android.view.View.OnClickListener() {

                    private DrawingActivity a;

                    public final void onClick(View view)
                    {
                        if (a.showEnjoyDialog)
                        {
                            com.socialin.android.picsart.profile.invite.i.a(a, "close");
                        }
                        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.DrawDoneEvent(DrawingActivity.Z(a).a, DrawingActivity.ac(a), com.socialin.android.photo.draw.DrawingActivity.b(a).g.b(), com.socialin.android.photo.draw.DrawingActivity.b(a).g.c(), "close", (System.nanoTime() - DrawingActivity.ad(a)) / 0x3b9aca00L));
                        DrawingActivity.ae(a);
                        a.executeInviteNotificaionAction();
                        DrawingActivity.at(a);
                        com.socialin.android.photo.draw.DrawingActivity.a(a, null, null);
                    }

            
            {
                a = DrawingActivity.this;
                super();
            }
                }).a();
                getFragmentManager().beginTransaction().add(((Fragment) (obj)), null).commitAllowingStateLoss();
                return;
            }
            AnalyticUtils.getInstance(this).trackLocalAction("drawing:cancel");
            if (s != null && s.c != null && s.c.k != null)
            {
                Intent intent = new Intent(this, com/socialin/android/dialog/CancelDialogActivity);
                intent.putExtra("drawingActivityActionCancel", true);
                intent.putExtra("showExportGif", false);
                startActivityForResult(intent, RequestCode.CANCEL_CONFIRM.toInt());
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static com.socialin.android.photo.draw.b r(DrawingActivity drawingactivity)
    {
        return drawingactivity.aa;
    }

    private void r()
    {
        EditingData editingdata = b;
        editingdata.e = (int)((long)editingdata.e + f());
        editingdata = b;
        editingdata.f = editingdata.f + ActionCollector.a().b();
        b.g = s.h();
        b.h = s.g.h;
        a(((Project) (null)), ((Runnable) (null)));
    }

    private void s()
    {
        Intent intent = new Intent(this, com/socialin/android/activity/SaveToSdCardDialogActivity);
        intent.putExtra("subFolderName", getString(0x7f0808fb));
        intent.putExtra("isReturnResult", true);
        startActivityForResult(intent, RequestCode.SAVE_TO_SD.toInt());
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.DrawSaveEvent("img"));
    }

    static boolean s(DrawingActivity drawingactivity)
    {
        return drawingactivity.ao;
    }

    private Bitmap t()
    {
        Bitmap bitmap = Bitmap.createBitmap(s.f(), s.g(), android.graphics.Bitmap.Config.ARGB_8888);
        s.a(bitmap);
        return bitmap;
    }

    static AppCompatDialog t(DrawingActivity drawingactivity)
    {
        return drawingactivity.m;
    }

    static RectF u(DrawingActivity drawingactivity)
    {
        return drawingactivity.U;
    }

    private void u()
    {
        com.socialin.android.picsart.profile.invite.i.a(this).edit().putBoolean("is_editor_active", false).apply();
        finish();
    }

    static void v(DrawingActivity drawingactivity)
    {
        drawingactivity.k();
    }

    static Runnable w(DrawingActivity drawingactivity)
    {
        return drawingactivity.L;
    }

    static Integer x(DrawingActivity drawingactivity)
    {
        return drawingactivity.as;
    }

    static void y(DrawingActivity drawingactivity)
    {
        drawingactivity.g();
    }

    static com.socialin.android.brushlib.util.c z(DrawingActivity drawingactivity)
    {
        return drawingactivity.ad;
    }

    public final void a()
    {
        runOnUiThread(new Runnable() {

            private DrawingActivity a;

            public final void run()
            {
                if (!DrawingActivity.t(a).isShowing() && !a.isFinishing())
                {
                    DrawingActivity.t(a).show();
                }
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
    }

    public final void b()
    {
        runOnUiThread(new Runnable() {

            private DrawingActivity a;

            public final void run()
            {
                DrawingActivity.t(a).dismiss();
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
    }

    public void checkForInviteDialogs(Boolean boolean1)
    {
        if (!e())
        {
            showEnjoyDialog = com.socialin.android.picsart.profile.invite.i.a(this, boolean1);
        }
    }

    public void executeInviteNotificaionAction()
    {
        if (!e())
        {
            com.socialin.android.picsart.profile.invite.i.a(this);
        }
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    protected void hideAdWithAnimation()
    {
        com.socialin.android.picsart.profile.invite.i.a(this, getAdLayout(), true);
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        float f1;
        Object obj;
        Object obj1;
        Object obj2;
        DrawTextStyle drawtextstyle;
        int k1;
        int l1;
        boolean flag;
        if (intent != null)
        {
            obj = intent.getExtras();
        } else
        {
            obj = null;
        }
        obj1 = RequestCode.fromInt(i1);
        if (obj1 == RequestCode.EXPORT && showEnjoyDialog)
        {
            com.socialin.android.picsart.profile.invite.i.a(this, "export");
        }
        if (obj1 == RequestCode.SAVE_TO_SD && showEnjoyDialog)
        {
            com.socialin.android.picsart.profile.invite.i.a(this, "savetogallery");
        }
        if (j1 != -1) goto _L2; else goto _L1
_L1:
        if (obj1 == null || obj == null) goto _L4; else goto _L3
_L3:
        com.socialin.android.photo.draw._cls87.c[((RequestCode) (obj1)).ordinal()];
        JVM INSTR tableswitch 1 11: default 148
    //                   1 166
    //                   2 166
    //                   3 224
    //                   4 1054
    //                   5 1326
    //                   6 1671
    //                   7 2099
    //                   8 2278
    //                   9 2278
    //                   10 2390
    //                   11 2542;
           goto _L4 _L5 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L11 _L12 _L13
_L4:
        if (i1 == 1124 && j1 == -1)
        {
            initAd();
        }
_L26:
        return;
_L5:
        intent = ((Bundle) (obj)).getString("selectedFolderName");
        obj1 = ((Bundle) (obj)).getString("selectedFileName");
        obj = ((Bundle) (obj)).getString("fileExtension");
        myobfuscated.f.m.a(this, t(), intent, ((String) (obj1)), ((String) (obj)), new Observer(((String) (obj)), intent, ((String) (obj1))) {

            private String a;
            private String b;
            private String c;
            private DrawingActivity d;

            public final void update(Observable observable, Object obj3)
            {
                if (!a.equalsIgnoreCase(".png"))
                {
                    com.socialin.android.photo.draw.DrawingActivity.b(d, (new StringBuilder()).append(b).append("/").append(c).append(a).toString());
                }
            }

            
            {
                d = DrawingActivity.this;
                a = s1;
                b = s2;
                c = s3;
                super();
            }
        });
        continue; /* Loop/switch isn't completed */
_L6:
        intent = ((Bundle) (obj)).getString("button");
        k1 = -1;
        intent.hashCode();
        JVM INSTR lookupswitch 11: default 340
    //                   -1727082830: 599
    //                   -737965158: 680
    //                   -407485789: 697
    //                   11576841: 567
    //                   1111669925: 631
    //                   1291988114: 714
    //                   1293361956: 647
    //                   1318040329: 615
    //                   1391073851: 583
    //                   1746810191: 663
    //                   2088201527: 731;
           goto _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25
_L14:
        switch (k1)
        {
        default:
            continue; /* Loop/switch isn't completed */

        case 0: // '\0'
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.DrawDoneEvent(b.a, g, s.g.b(), s.g.c(), "close", (System.nanoTime() - h) / 0x3b9aca00L));
            d();
            if (s.c.k.isDraft())
            {
                FileUtils.b(s.c.k.getRootFolder().getAbsolutePath());
            }
            if (s.c.k.isDraft())
            {
                intent = s.c.k;
            } else
            {
                intent = null;
            }
            a(intent, new Runnable() {

                private DrawingActivity a;

                public final void run()
                {
                    if (com.socialin.android.photo.draw.DrawingActivity.b(a).c.k.isDraft())
                    {
                        FileUtils.b(com.socialin.android.photo.draw.DrawingActivity.b(a).c.k.getRootFolder().getAbsolutePath());
                    }
                }

            
            {
                a = DrawingActivity.this;
                super();
            }
            });
            if (showEnjoyDialog)
            {
                com.socialin.android.picsart.profile.invite.i.a(this, "close");
            }
            executeInviteNotificaionAction();
            u();
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            if (com.socialin.android.util.w.a(this))
            {
                s();
                return;
            }
            break;

        case 2: // '\002'
            intent = a(android.graphics.Bitmap.CompressFormat.JPEG);
            if (intent != null)
            {
                a(intent);
                myobfuscated.cv.c.a(this, intent);
            }
            if (showEnjoyDialog)
            {
                com.socialin.android.picsart.profile.invite.i.a(this, "export");
                return;
            }
            break;

        case 3: // '\003'
            intent = a(android.graphics.Bitmap.CompressFormat.JPEG);
            if (intent != null)
            {
                a(intent);
                com.facebook.CallbackManager.Factory.create();
                FacebookUtils.startAdapterActivity(this, intent);
            }
            if (showEnjoyDialog)
            {
                com.socialin.android.picsart.profile.invite.i.a(this, "export");
                return;
            }
            break;

        case 4: // '\004'
            intent = a(android.graphics.Bitmap.CompressFormat.JPEG);
            if (intent != null)
            {
                a(intent);
                myobfuscated.cv.c.a(this, intent);
            }
            if (showEnjoyDialog)
            {
                com.socialin.android.picsart.profile.invite.i.a(this, "export");
                return;
            }
            break;

        case 5: // '\005'
            intent = a(android.graphics.Bitmap.CompressFormat.JPEG);
            if (intent != null)
            {
                a(intent);
                myobfuscated.cv.c.a(intent, this);
            }
            if (showEnjoyDialog)
            {
                com.socialin.android.picsart.profile.invite.i.a(this, "export");
                return;
            }
            break;

        case 6: // '\006'
            a(false);
            if (showEnjoyDialog)
            {
                com.socialin.android.picsart.profile.invite.i.a(this, "savetogallery");
            }
            continue; /* Loop/switch isn't completed */

        case 7: // '\007'
            m();
            if (showEnjoyDialog)
            {
                com.socialin.android.picsart.profile.invite.i.a(this, "savetogallery");
            }
            continue; /* Loop/switch isn't completed */

        case 8: // '\b'
            l();
            continue; /* Loop/switch isn't completed */

        case 9: // '\t'
            a();
            (new Thread() {

                private DrawingActivity a;

                public final void run()
                {
                    String s1 = com.socialin.android.photo.draw.DrawingActivity.a(a, android.graphics.Bitmap.CompressFormat.JPEG);
                    myobfuscated.cv.c.a(a, s1, com.socialin.android.photo.draw.DrawingActivity.b(a).f(), com.socialin.android.photo.draw.DrawingActivity.b(a).g());
                    a.b();
                }

            
            {
                a = DrawingActivity.this;
                super();
            }
            }).start();
            if (showEnjoyDialog)
            {
                com.socialin.android.picsart.profile.invite.i.a(this, "export");
            }
            continue; /* Loop/switch isn't completed */

        case 10: // '\n'
            y = true;
            com.socialin.android.brushlib.project.a.b();
            if (A)
            {
                flag = k;
                i();
                a(new Runnable(flag) {

                    private boolean a;
                    private DrawingActivity b;

                    public final void run()
                    {
                        b.a();
                        DrawingActivity.M(b);
                        if (!a)
                        {
                            com.socialin.android.photo.draw.DrawingActivity.e(b);
                        }
                    }

            
            {
                b = DrawingActivity.this;
                a = flag;
                super();
            }
                });
            } else
            {
                a();
                g(false);
            }
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L26; else goto _L18
_L18:
        if (intent.equals("button_ok"))
        {
            k1 = 0;
        }
          goto _L14
_L23:
        if (intent.equals("button_saveSD"))
        {
            k1 = 1;
        }
          goto _L14
_L15:
        if (intent.equals("button_uploadToPicsinId"))
        {
            k1 = 2;
        }
          goto _L14
_L22:
        if (intent.equals("button_postFB"))
        {
            k1 = 3;
        }
          goto _L14
_L19:
        if (intent.equals("button_postInstagram"))
        {
            k1 = 4;
        }
          goto _L14
_L21:
        if (intent.equals("button_tweet"))
        {
            k1 = 5;
        }
          goto _L14
_L24:
        if (intent.equals("button_saveProject"))
        {
            k1 = 6;
        }
          goto _L14
_L16:
        if (intent.equals("button_exportVideo"))
        {
            k1 = 7;
        }
          goto _L14
_L17:
        if (intent.equals("button_exportGif"))
        {
            k1 = 8;
        }
          goto _L14
_L20:
        if (intent.equals("button_share"))
        {
            k1 = 9;
        }
          goto _L14
_L25:
        if (intent.equals("button_picsartEdit"))
        {
            k1 = 10;
        }
          goto _L14
_L7:
        intent = (BrushHistory)((Bundle) (obj)).getSerializable("extra.brush.history");
        AnalyticUtils.getInstance(this).trackLocalAction((new StringBuilder("drawing:brush selected, id : ")).append(intent.getSelectedBrushId(false)).toString());
        if (s.b() == com.socialin.android.brushlib.view.DrawingView.DrawingMode.ERASE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k1 = intent.getSelectedBrushId(flag);
        obj = Brush.a(this, k1);
        obj1 = intent.getBrushSelectedParams(k1, flag);
        if (obj != null)
        {
            if (k1 == 21)
            {
                k1 = intent.getSelectedStickerIndex();
                obj2 = com.socialin.android.util.ak.a(this, "drawing");
                ((com.socialin.android.brushlib.brush.j)obj).a(((ak) (obj2)).b(k1));
                ((com.socialin.android.brushlib.brush.j)obj).a(com.socialin.android.util.d.a(((ak) (obj2)).c(k1)));
                ((com.socialin.android.brushlib.brush.j)obj).c = k1;
            } else
            if (k1 == 22)
            {
                ((com.socialin.android.brushlib.brush.f)obj).c = intent.getSelectedShapeName();
            }
        }
        s.setBrushHistory(intent);
        s.setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH);
        obj2 = AnalyticUtils.getInstance(this);
        if (obj != null)
        {
            intent = ((Brush) (obj)).e();
        } else
        {
            intent = null;
        }
        ((AnalyticUtils) (obj2)).track(new com.socialin.android.apiv3.events.EventsFactory.DrawChooseBrushEvent(intent, ((com.socialin.android.brushlib.brush.Brush.Params) (obj1)).getThickness()));
        s.setBrush(((Brush) (obj)));
        ((com.socialin.android.brushlib.brush.Brush.Params) (obj1)).setColorRGB(s.l);
        s.setBrushParams(((com.socialin.android.brushlib.brush.Brush.Params) (obj1)));
        continue; /* Loop/switch isn't completed */
_L8:
        intent = ((Bundle) (obj)).getString("extra.shape.name");
        f1 = ((Bundle) (obj)).getFloat("extra.shape.thickness", 1.0F);
        l1 = ((Bundle) (obj)).getInt("extra.shape.opacity", 255);
        flag = ((Bundle) (obj)).getBoolean("extra.shape.style");
        k1 = -1;
        intent.hashCode();
        JVM INSTR lookupswitch 2: default 1404
    //                   3321844: 1507
    //                   93090825: 1523;
           goto _L27 _L28 _L29
_L27:
        break; /* Loop/switch isn't completed */
_L29:
        break MISSING_BLOCK_LABEL_1523;
_L30:
        switch (k1)
        {
        default:
            s.setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.SHAPE);
            obj = s;
            obj1 = com.socialin.android.brushlib.controller.ShapeOverlayController.ShapeType.SVG;
            obj2 = new com.socialin.android.brushlib.svg.b();
            obj2.b = f1;
            obj2 = ((com.socialin.android.brushlib.svg.b) (obj2)).a(s.l);
            obj2.a = flag;
            ((DrawingView) (obj)).setShape(((com.socialin.android.brushlib.controller.ShapeOverlayController.ShapeType) (obj1)), intent, ((com.socialin.android.brushlib.svg.b) (obj2)).b(l1).a());
            break;

        case 0: // '\0'
            s.setDrawingMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW);
            intent = s;
            obj = com.socialin.android.brushlib.controller.ShapeOverlayController.ShapeType.LINE;
            obj1 = new com.socialin.android.brushlib.svg.b();
            obj1.b = f1;
            intent.setShape(((com.socialin.android.brushlib.controller.ShapeOverlayController.ShapeType) (obj)), null, ((com.socialin.android.brushlib.svg.b) (obj1)).b(l1).a(s.l).a());
            break;

        case 1: // '\001'
            s.setDrawingMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW);
            intent = s;
            obj = com.socialin.android.brushlib.controller.ShapeOverlayController.ShapeType.ARROW;
            obj1 = new com.socialin.android.brushlib.svg.b();
            obj1.b = f1;
            intent.setShape(((com.socialin.android.brushlib.controller.ShapeOverlayController.ShapeType) (obj)), null, ((com.socialin.android.brushlib.svg.b) (obj1)).b(l1).a(s.l).a());
            break;
        }
        break MISSING_BLOCK_LABEL_1666;
_L28:
        if (intent.equals("line"))
        {
            k1 = 0;
        }
          goto _L30
        if (intent.equals("arrow"))
        {
            k1 = 1;
        }
          goto _L30
        if (false)
        {
        }
        continue; /* Loop/switch isn't completed */
_L9:
        k1 = ((Bundle) (obj)).getInt("clipartResId");
        obj1 = ((Bundle) (obj)).getString("clipartPath");
        flag = ((Bundle) (obj)).getBoolean("fromPicsinFile");
        obj2 = ((Bundle) (obj)).getString("fileName");
        l1 = ((Bundle) (obj)).getInt("clipartType");
        if (l1 != 0)
        {
            break MISSING_BLOCK_LABEL_1968;
        }
        obj = null;
        intent = null;
        l1 = PicsartContext.a.getCollageImageMaxSize();
        if (!flag) goto _L32; else goto _L31
_L31:
        intent = ((Intent) (obj));
        obj1 = com.picsart.shop.a.a(getApplicationContext()).a(((String) (obj1)), ((String) (obj2)));
        intent = ((Intent) (obj));
        obj = com.socialin.android.util.c.a(((java.io.InputStream) (obj1)));
        intent = ((Intent) (obj));
        ((ByteArrayInputStream) (obj1)).close();
        intent = ((Intent) (obj));
_L33:
        if (intent != null)
        {
            intent = new Runnable(intent) {

                private Bitmap a;
                private DrawingActivity b;

                public final void run()
                {
                    com.socialin.android.photo.draw.DrawingActivity.b(b).setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.PHOTO);
                    com.socialin.android.photo.draw.DrawingActivity.b(b).setImageForAddPhotoMode(a, null);
                }

            
            {
                b = DrawingActivity.this;
                a = bitmap;
                super();
            }
            };
            if (s.c())
            {
                intent.run();
            } else
            {
                i.add(intent);
            }
        }
        continue; /* Loop/switch isn't completed */
        obj;
        com.socialin.android.d.b(c, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
          goto _L33
_L32:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_1935;
        }
        if (!(new File(((String) (obj1)))).exists()) goto _L26; else goto _L34
_L34:
        obj = com.socialin.android.util.w.b(((String) (obj1)), l1, l1, 0);
        intent = ((Intent) (obj));
          goto _L33
        obj;
        com.socialin.android.d.b(c, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
          goto _L33
        if (k1 != -1)
        {
            intent = com.socialin.android.util.c.a(getResources(), k1);
        }
          goto _L33
        if (l1 != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        intent = null;
        if (!flag) goto _L36; else goto _L35
_L35:
        intent = com.picsart.shop.a.a(getApplicationContext()).c(((String) (obj1)), ((String) (obj2)));
_L37:
        intent = new Runnable(intent) {

            private byte a[];
            private DrawingActivity b;

            public final void run()
            {
                com.socialin.android.photo.draw.DrawingActivity.b(b).setDrawingMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW);
                com.socialin.android.photo.draw.DrawingActivity.b(b).setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.SHAPE);
                com.socialin.android.photo.draw.DrawingActivity.b(b).setClipArtData(a);
            }

            
            {
                b = DrawingActivity.this;
                a = abyte0;
                super();
            }
        };
        if (s.c())
        {
            intent.run();
        } else
        {
            i.add(intent);
        }
        continue; /* Loop/switch isn't completed */
_L36:
        obj = FileUtils.f(new File(((String) (obj1))));
        intent = ((Intent) (obj));
          goto _L37
        obj;
        com.socialin.android.d.b(c, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
        });
          goto _L37
_L10:
        intent = (TextArtStyle)((Bundle) (obj)).getParcelable("style");
        k1 = ((Bundle) (obj)).getInt("style-index");
        l1 = ((Bundle) (obj)).getInt("font-type");
        obj1 = new Paint();
        obj2 = new Paint();
        TextArt.initTextArtForDrawing(this, intent, ((Paint) (obj2)), ((Paint) (obj1)));
        drawtextstyle = new DrawTextStyle(intent.getFillColor(), intent.getFillGradientBottomColor(), intent.getStrokeColor(), intent.getFontSize(), intent.hasGradient(), intent.hasStroke(), intent.getTypefaceSpec().isFontPathFromSdCard(), intent.getTypefaceSpec().getFontPath(), intent.getTypefaceSpec().getFontPackagePath(), k1, l1, intent.getTextHeight(), intent);
        intent = new Runnable(((Bundle) (obj)).getString("text"), ((Paint) (obj1)), ((Paint) (obj2)), drawtextstyle, intent) {

            private String a;
            private Paint b;
            private Paint c;
            private DrawTextStyle d;
            private TextArtStyle e;
            private DrawingActivity f;

            public final void run()
            {
                com.socialin.android.photo.draw.DrawingActivity.b(f).setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.TEXT);
                com.socialin.android.photo.draw.DrawingActivity.b(f).setTextParams(a, b, c, d, e);
                com.socialin.android.photo.draw.DrawingActivity.b(f).setCurrentColor(e.getFillColor());
                com.socialin.android.photo.draw.DrawingActivity.a(f, false, true);
            }

            
            {
                f = DrawingActivity.this;
                a = s1;
                b = paint;
                c = paint1;
                d = drawtextstyle;
                e = textartstyle;
                super();
            }
        };
        if (s.c())
        {
            intent.run();
        } else
        {
            i.add(intent);
        }
        continue; /* Loop/switch isn't completed */
_L11:
        aq = ((Bundle) (obj)).getString("source");
        obj2 = ((Bundle) (obj)).getString("path");
        k1 = ((Bundle) (obj)).getInt("degree", 0);
        obj = null;
        if (intent.hasExtra("bufferData"))
        {
            obj = (HashMap)intent.getSerializableExtra("bufferData");
        }
        if (obj1 == RequestCode.CHOOSE_PIC_FOR_LAYER)
        {
            a(((String) (obj2)), k1, ((HashMap) (obj)), RequestCode.CROP_IMG_FOR_LAYER.toInt());
        } else
        if (obj1 == RequestCode.CHOOSE_PIC_FOR_ADD_PHOTO)
        {
            a(((String) (obj2)), k1, ((HashMap) (obj)), RequestCode.CROP_IMAGE_FOR_ADD_PHOTO.toInt());
        }
        continue; /* Loop/switch isn't completed */
_L12:
        AnalyticUtils.getInstance(this).trackLocalAction("draw:crop");
        obj1 = ((Bundle) (obj)).getString("path");
        k1 = ((Bundle) (obj)).getInt("degree", 0);
        if (intent.hasExtra("bufferData"))
        {
            intent = (HashMap)intent.getExtras().getSerializable("bufferData");
        } else
        {
            intent = null;
        }
        if (s.c())
        {
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.DrawLayerAddedEvent("photo"));
            if (intent != null)
            {
                s.c.a(intent, k1);
            } else
            {
                s.c.a(((String) (obj1)), k1);
            }
        } else
        {
            i.add(new Runnable(intent, k1, ((String) (obj1))) {

                private HashMap a;
                private int b;
                private String c;
                private DrawingActivity d;

                public final void run()
                {
                    AnalyticUtils.getInstance(d).track(new com.socialin.android.apiv3.events.EventsFactory.DrawLayerAddedEvent("photo"));
                    if (a != null)
                    {
                        com.socialin.android.photo.draw.DrawingActivity.b(d).c.a(a, b);
                        return;
                    } else
                    {
                        com.socialin.android.photo.draw.DrawingActivity.b(d).c.a(c, b);
                        return;
                    }
                }

            
            {
                d = DrawingActivity.this;
                a = hashmap;
                b = i1;
                c = s1;
                super();
            }
            });
        }
        continue; /* Loop/switch isn't completed */
_L13:
        AnalyticUtils.getInstance(this).trackLocalAction("draw:crop");
        obj1 = ((Bundle) (obj)).getString("path");
        k1 = ((Bundle) (obj)).getInt("degree", 0);
        if (intent.hasExtra("bufferData"))
        {
            intent = (HashMap)intent.getExtras().getSerializable("bufferData");
        } else
        {
            intent = null;
        }
        if (s.c())
        {
            a(((String) (obj1)), intent, k1);
        } else
        {
            i.add(new Runnable(((String) (obj1)), intent, k1) {

                private String a;
                private HashMap b;
                private int c;
                private DrawingActivity d;

                public final void run()
                {
                    com.socialin.android.photo.draw.DrawingActivity.a(d, a, b, c);
                }

            
            {
                d = DrawingActivity.this;
                a = s1;
                b = hashmap;
                c = i1;
                super();
            }
            });
        }
        if (true) goto _L4; else goto _L2
_L2:
        if (j1 != 0 || obj1 == null) goto _L4; else goto _L38
_L38:
        switch (com.socialin.android.photo.draw._cls87.c[((RequestCode) (obj1)).ordinal()])
        {
        case 10: // '\n'
        case 11: // '\013'
            if (obj != null && ((Bundle) (obj)).getBoolean("memoryError", false))
            {
                s.l();
            }
            break;
        }
        if (true) goto _L4; else goto _L39
_L39:
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        AnalyticUtils.getInstance(this).trackLocalAction("drawing:onConfigurationChanged");
        int i1;
        if (z == null)
        {
            i1 = 0;
        } else
        {
            i1 = z.b;
        }
        ((ViewGroup)findViewById(0x7f10039c)).removeView(s);
        setContentView(0x7f0300ae);
        ((ViewGroup)findViewById(0x7f10039c)).removeView(findViewById(0x7f10039d));
        ((ViewGroup)findViewById(0x7f10039c)).addView(s);
        s.invalidate();
        configuration = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(configuration);
        initAd();
        h();
        if (s.c())
        {
            k();
            configuration = s.c.b;
            g();
            a(s.c.b);
        }
        if (ao)
        {
            aj.setVisibility(4);
            T.setVisibility(0);
            S.setVisibility(0);
            S.setClickable(true);
            ak.setVisibility(4);
        }
        if (t != null)
        {
            configuration = (f)t.get();
            if (configuration != null && configuration.isShowing())
            {
                int j1 = configuration.b();
                configuration.dismiss();
                configuration = E;
                com.socialin.android.colorpicker.d d1 = G;
                int l1 = v;
                g g1 = new g();
                g1.a = configuration;
                g1.e = l1;
                g1.f = j1;
                g1.c = true;
                g1.d = true;
                g1.b = d1;
                configuration = g1.a(this);
                if (!configuration.isShowing())
                {
                    configuration.show();
                }
                t = new WeakReference(configuration);
            }
        }
        if (u != null)
        {
            configuration = (f)u.get();
            if (configuration != null && configuration.isShowing())
            {
                int k1 = configuration.b();
                configuration.dismiss();
                a(F, k1);
            }
        }
        if (ap == LayerPanelState.OPENED || ap == LayerPanelState.OPENING)
        {
            f(false);
        } else
        if (ap == LayerPanelState.CLOSING)
        {
            e(false);
        }
        H = null;
        I = null;
        if (A && !ag)
        {
            a(ah, i1);
        } else
        {
            n();
        }
        if (s.c != null)
        {
            configuration = s.c.f;
            aj.findViewById(0x7f1003a3).setEnabled(configuration.e());
            aj.findViewById(0x7f1003a4).setEnabled(configuration.f());
        }
        if (s.e() != null && s.b() != null)
        {
            a(s.e(), s.b());
        }
        y = false;
        if (s.e() != null && s.e() == com.socialin.android.brushlib.view.DrawingView.EditingMode.LAYER_TRANSFORM)
        {
            o();
        }
        if (M != null)
        {
            M.dismiss();
        }
        if (N != null)
        {
            N.dismiss();
        }
        if (O != null)
        {
            O.dismiss();
        }
        if (P != null)
        {
            P.dismiss();
        }
        if (Q != null)
        {
            Q.dismiss();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
        Object obj1;
        Object obj2;
        super.onCreate(bundle);
        n = System.nanoTime();
        getWindow().setFlags(1024, 1024);
        PicsartContext.a(this);
        com.socialin.android.brushlib.svg.d.a(this);
        obj2 = getIntent().getExtras();
        obj1 = (Project)((Bundle) (obj2)).getSerializable("extra.project");
        if (obj1 != null)
        {
            BrushHistory.setProjectFolderPath((new StringBuilder()).append(((Project) (obj1)).getRootFolder().getPath()).append("/").toString());
        }
        setContentView(0x7f0300ae);
        at = new com.socialin.android.photo.draw.c(this, (byte)0);
        registerReceiver(at, new IntentFilter("update.adds.enabled.action"));
        R = new am(this);
        myobfuscated.bs.b.a(getResources());
        s = (DrawingView)findViewById(0x7f10039d);
        boolean flag;
        if (bundle != null)
        {
            obj = (Project)bundle.getSerializable("activeProject");
            q = bundle.getInt("comingFrom", -1);
            b = (EditingData)bundle.getParcelable("editing_data");
        } else
        {
            q = ((Bundle) (obj2)).getInt("comingFrom", -1);
            b = (EditingData)((Bundle) (obj2)).getParcelable("editing_data");
            obj = obj1;
            if (obj1 != null)
            {
                b(((Project) (obj1)));
                obj = obj1;
            }
        }
        if (bundle == null || ((Bundle) (obj2)).getBoolean("start_draw_session"))
        {
            d();
        }
        obj1 = new IntentFilter();
        ((IntentFilter) (obj1)).addAction("finish.old.drawing");
        registerReceiver(f, ((IntentFilter) (obj1)));
        L = new Runnable(bundle) {

            final DrawingActivity a;
            private Bundle b;

            public final void run()
            {
                if (b == null) goto _L2; else goto _L1
_L1:
                com.socialin.android.brushlib.view.DrawingView.EditingMode editingmode1 = (com.socialin.android.brushlib.view.DrawingView.EditingMode)b.getSerializable("editMode");
                com.socialin.android.brushlib.view.DrawingView.DrawingMode drawingmode = (com.socialin.android.brushlib.view.DrawingView.DrawingMode)b.getSerializable("drawMode");
                com.socialin.android.brushlib.view.DrawingView.EditingMode editingmode = editingmode1;
                if (editingmode1 == null)
                {
                    editingmode = com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH;
                }
                com.socialin.android.photo.draw.DrawingActivity.b(a).setEditingMode(editingmode);
                com.socialin.android.photo.draw.DrawingActivity.b(a).setDrawingMode(drawingmode);
                com.socialin.android.photo.draw._cls87.a[com.socialin.android.photo.draw.DrawingActivity.b(a).e().ordinal()];
                JVM INSTR tableswitch 1 4: default 112
            //                           1 112
            //                           2 213
            //                           3 250
            //                           4 360;
                   goto _L3 _L3 _L4 _L5 _L6
_L3:
                com.socialin.android.brushlib.controller.a a1 = com.socialin.android.photo.draw.DrawingActivity.b(a).g;
                HashMap hashmap = (HashMap)b.getSerializable("eraserTime");
                if (hashmap != null)
                {
                    a1.g = hashmap;
                }
                a1 = com.socialin.android.photo.draw.DrawingActivity.b(a).g;
                hashmap = (HashMap)b.getSerializable("brushTime");
                if (hashmap != null)
                {
                    a1.f = hashmap;
                }
                com.socialin.android.photo.draw.DrawingActivity.a(a, b.getString("drawingSessionId"));
                com.socialin.android.photo.draw.DrawingActivity.a(a, b.getLong("drawingSessionStart"));
                return;
_L4:
                Bundle bundle1 = b.getBundle("imageOverlayControllerData");
                if (bundle1 != null)
                {
                    com.socialin.android.photo.draw.DrawingActivity.b(a).post(new Runnable(this, bundle1) {

                        private Bundle a;
                        private _cls3 b;

                        public final void run()
                        {
                            com.socialin.android.photo.draw.DrawingActivity.b(b.a).h.a(a);
                        }

            
            {
                b = _pcls3;
                a = bundle;
                super();
            }
                    });
                }
                continue; /* Loop/switch isn't completed */
_L5:
                com.socialin.android.brushlib.controller.g g1 = com.socialin.android.photo.draw.DrawingActivity.b(a).j;
                Object obj3 = b.getBundle("textOverlayControllerData");
                g1.c = (DrawTextStyle)((Bundle) (obj3)).getSerializable("style");
                g1.d = (String)((Bundle) (obj3)).getSerializable("text");
                g1.b = ((Bundle) (obj3)).getParcelable("styleData");
                obj3 = new Paint();
                Paint paint = new Paint();
                TextArt.initTextArtForDrawing(a, (TextArtStyle)g1.b, paint, ((Paint) (obj3)));
                g1.a(g1.d, paint, ((Paint) (obj3)), g1.c, g1.b);
                continue; /* Loop/switch isn't completed */
_L6:
                Object obj4 = b.getBundle("shapeOverlayControllerData");
                ShapeOverlayController shapeoverlaycontroller = com.socialin.android.photo.draw.DrawingActivity.b(a).i;
                shapeoverlaycontroller.d = ((Bundle) (obj4)).getString("shapeName");
                shapeoverlaycontroller.e = (ClipArtSvg)((Bundle) (obj4)).getSerializable("svg");
                shapeoverlaycontroller.f = (com.socialin.android.brushlib.controller.ShapeOverlayController.ShapeType)((Bundle) (obj4)).getSerializable("shapeType");
                shapeoverlaycontroller.h = (com.socialin.android.brushlib.controller.ShapeOverlayController.ShapeEditingMode)((Bundle) (obj4)).getSerializable("editMode");
                shapeoverlaycontroller.g = (ShapeParams)((Bundle) (obj4)).getSerializable("currentParams");
                obj4 = (Overlay)((Bundle) (obj4)).getSerializable("overlay");
                if (obj4 != null)
                {
                    shapeoverlaycontroller.a(((Overlay) (obj4)));
                }
                if (shapeoverlaycontroller.h == com.socialin.android.brushlib.controller.ShapeOverlayController.ShapeEditingMode.EDIT)
                {
                    shapeoverlaycontroller.a();
                }
                if (true) goto _L3; else goto _L2
_L2:
                com.socialin.android.photo.draw.DrawingActivity.b(a).setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH);
                com.socialin.android.photo.draw.DrawingActivity.b(a).setDrawingMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW);
                return;
            }

            
            {
                a = DrawingActivity.this;
                b = bundle;
                super();
            }
        };
        bundle = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(bundle);
        U.set(0.0F, 0.0F, (int)getResources().getDimension(0x7f0b00da), (int)getResources().getDimension(0x7f0b00d9));
        s.setZoomChangeListener(J);
        s.setUiFreeRectCallable(new Callable() {

            private DrawingActivity a;

            public final Object call()
            {
                int j2;
                if (a.getResources().getConfiguration().orientation == 2)
                {
                    j2 = 1;
                } else
                {
                    j2 = 0;
                }
                if (j2 != 0)
                {
                    j2 = a.findViewById(0x7f10033c).getWidth();
                    int k2 = a.findViewById(0x7f1003ac).getWidth();
                    if (DrawingActivity.s(a))
                    {
                        return new RectF(0.0F, 0.0F, com.socialin.android.photo.draw.DrawingActivity.b(a).getWidth(), com.socialin.android.photo.draw.DrawingActivity.b(a).getHeight());
                    } else
                    {
                        return new RectF(j2, 0.0F, com.socialin.android.photo.draw.DrawingActivity.b(a).getWidth() - k2, com.socialin.android.photo.draw.DrawingActivity.b(a).getHeight());
                    }
                }
                j2 = a.findViewById(0x7f10033c).getHeight();
                int l2 = a.findViewById(0x7f1003ac).getHeight();
                if (DrawingActivity.s(a))
                {
                    return new RectF(0.0F, 0.0F, com.socialin.android.photo.draw.DrawingActivity.b(a).getWidth(), com.socialin.android.photo.draw.DrawingActivity.b(a).getHeight());
                } else
                {
                    return new RectF(0.0F, j2, com.socialin.android.photo.draw.DrawingActivity.b(a).getWidth(), com.socialin.android.photo.draw.DrawingActivity.b(a).getHeight() - l2);
                }
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        m = new AppCompatDialog(this, 0x7f0c0184);
        m.setContentView(0x7f0300a6);
        m.setCancelable(false);
        m.setCanceledOnTouchOutside(false);
        (new Handler()).postDelayed(new Runnable() {

            private DrawingActivity a;

            public final void run()
            {
                if (!com.socialin.android.photo.draw.DrawingActivity.b(a).c() && !a.isFinishing())
                {
                    a.a();
                }
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        }, 500L);
        s.setOnInitializedListener(new com.socialin.android.brushlib.view.d() {

            final DrawingActivity a;

            public final void a()
            {
                a.b();
                Object obj3 = a;
                Object obj4 = a.getResources();
                DrawingView drawingview = com.socialin.android.photo.draw.DrawingActivity.b(a);
                RectF rectf = DrawingActivity.u(a);
                drawingview.b.set(0.0F, 0.0F, drawingview.c.d, drawingview.c.e);
                com.socialin.android.util.l.a(drawingview.b, rectf);
                int j2 = Math.max(1, Math.round(drawingview.b.width()));
                drawingview = com.socialin.android.photo.draw.DrawingActivity.b(a);
                rectf = DrawingActivity.u(a);
                drawingview.b.set(0.0F, 0.0F, drawingview.c.d, drawingview.c.e);
                com.socialin.android.util.l.a(drawingview.b, rectf);
                com.socialin.android.photo.draw.DrawingActivity.a(((DrawingActivity) (obj3)), new com.socialin.android.brushlib.util.c(((Resources) (obj4)), j2, Math.max(1, Math.round(drawingview.b.height()))));
                DrawingActivity.v(a);
                com.socialin.android.photo.draw.DrawingActivity.w(a).run();
                obj4 = com.socialin.android.photo.draw.DrawingActivity.b(a).m;
                obj3 = Brush.a(a, ((BrushHistory) (obj4)).getSelectedBrushId(false));
                com.socialin.android.photo.draw.DrawingActivity.b(a).setBrush(((Brush) (obj3)));
                com.socialin.android.photo.draw.DrawingActivity.b(a).setBrushParams(((BrushHistory) (obj4)).getBrushSelectedParams(((BrushHistory) (obj4)).getSelectedBrushId(false), false));
                if (obj3 instanceof com.socialin.android.brushlib.brush.j)
                {
                    j2 = ((BrushHistory) (obj4)).getSelectedStickerIndex();
                    obj4 = com.socialin.android.util.ak.a(a, "drawing");
                    ((com.socialin.android.brushlib.brush.j)obj3).a(((ak) (obj4)).b(j2));
                    ((Brush) (obj3)).a(com.socialin.android.util.d.a(((ak) (obj4)).c(j2)));
                    ((com.socialin.android.brushlib.brush.j)obj3).c = j2;
                } else
                if (obj3 instanceof com.socialin.android.brushlib.brush.f)
                {
                    ((com.socialin.android.brushlib.brush.f)obj3).c = ((BrushHistory) (obj4)).getSelectedShapeName();
                }
                obj3 = com.socialin.android.photo.draw.DrawingActivity.b(a);
                if (com.socialin.android.photo.draw.DrawingActivity.x(a) != null)
                {
                    j2 = com.socialin.android.photo.draw.DrawingActivity.x(a).intValue();
                } else
                {
                    j2 = 0xff000000;
                }
                ((DrawingView) (obj3)).setCurrentColor(j2);
                com.socialin.android.photo.draw.DrawingActivity.a(a, Integer.valueOf(0xff000000));
                com.socialin.android.photo.draw.DrawingActivity.a(a, false, false);
                obj3 = com.socialin.android.photo.draw.DrawingActivity.b(a).c.f;
                DrawingActivity.k(a).findViewById(0x7f1003a3).setEnabled(((myobfuscated.br.a) (obj3)).e());
                DrawingActivity.k(a).findViewById(0x7f1003a4).setEnabled(((myobfuscated.br.a) (obj3)).f());
                com.socialin.android.photo.draw.DrawingActivity.b(a).c.f.a(new myobfuscated.br.b(this) {

                    private _cls8 a;

                    public final void a(myobfuscated.br.a a1)
                    {
                        DrawingActivity.k(a.a).findViewById(0x7f1003a3).setEnabled(a1.e());
                        DrawingActivity.k(a.a).findViewById(0x7f1003a4).setEnabled(a1.f());
                    }

            
            {
                a = _pcls8;
                super();
            }
                });
                com.socialin.android.photo.draw.DrawingActivity.b(a).c.a(new com.socialin.android.brushlib.state.b(this) {

                    final _cls8 a;

                    public final void a()
                    {
                        DrawingActivity.r(a.a).notifyDataSetChanged();
                        DrawingActivity drawingactivity = a.a;
                        b b1 = com.socialin.android.photo.draw.DrawingActivity.b(a.a).c.b;
                        DrawingActivity.y(drawingactivity);
                    }

                    public final void a(b b1)
                    {
                        DrawingActivity.z(a.a).a(b1, new com.socialin.android.brushlib.util.d(this) {

                            private _cls2 a;

                            public final void a(b b1)
                            {
                                if (DrawingActivity.r(a.a.a) != null && com.socialin.android.photo.draw.b.a(DrawingActivity.r(a.a.a)).contains(b1) && DrawingActivity.A(a.a.a) != null)
                                {
                                    int i1 = com.socialin.android.photo.draw.b.a(DrawingActivity.r(a.a.a)).indexOf(b1) - DrawingActivity.A(a.a.a).getFirstVisiblePosition();
                                    if (i1 >= 0)
                                    {
                                        b1 = DrawingActivity.A(a.a.a).getChildAt(i1);
                                        if (b1 != null)
                                        {
                                            b1.invalidate();
                                        }
                                    }
                                }
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                    }

                    public final void b()
                    {
                        com.socialin.android.photo.draw.DrawingActivity.a(a.a, false);
                        DrawingActivity.r(a.a).notifyDataSetChanged();
                    }

                    public final void b(b b1)
                    {
                        if (b1 == com.socialin.android.photo.draw.DrawingActivity.b(a.a).c.b)
                        {
                            com.socialin.android.photo.draw.DrawingActivity.a(a.a, b1);
                        }
                    }

                    public final void c()
                    {
                        DrawingActivity.r(a.a).notifyDataSetChanged();
                    }

                    public final void c(b b1)
                    {
                        DrawingActivity.y(a.a);
                        com.socialin.android.brushlib.util.c c1 = DrawingActivity.z(a.a);
                        c1.b.remove(c1.a.remove(b1));
                        DrawingActivity.r(a.a).notifyDataSetChanged();
                    }

                    public final void d(b b1)
                    {
                        DrawingActivity.r(a.a).notifyDataSetChanged();
                        DrawingActivity.y(a.a);
                        DrawingActivity.z(a.a).a(b1, new com.socialin.android.brushlib.util.d(this) {

                            private _cls2 a;

                            public final void a(b b1)
                            {
                                if (DrawingActivity.A(a.a.a) != null)
                                {
                                    b1 = DrawingActivity.A(a.a.a).getChildAt(com.socialin.android.photo.draw.b.a(DrawingActivity.r(a.a.a)).indexOf(b1));
                                    if (b1 != null)
                                    {
                                        b1.invalidate();
                                    }
                                }
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                    }

                    public final void e(b b1)
                    {
                        DrawingActivity.y(a.a);
                        com.socialin.android.photo.draw.DrawingActivity.a(a.a, b1);
                    }

            
            {
                a = _pcls8;
                super();
            }
                });
                com.socialin.android.photo.draw.DrawingActivity.a(a, (CameraPreviewContainer)a.findViewById(0x7f10039b));
                DrawingActivity.B(a).setPictureSize(com.socialin.android.photo.draw.DrawingActivity.b(a).f(), com.socialin.android.photo.draw.DrawingActivity.b(a).g());
                com.socialin.android.photo.draw.DrawingActivity.b(a).post(new Runnable(this) {

                    private _cls8 a;

                    public final void run()
                    {
                        for (Iterator iterator = DrawingActivity.C(a.a).iterator(); iterator.hasNext(); ((Runnable)iterator.next()).run()) { }
                        DrawingActivity.C(a.a).clear();
                    }

            
            {
                a = _pcls8;
                super();
            }
                });
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        s.a(new com.socialin.android.brushlib.view.b() {

            private DrawingActivity a;

            public final void a(com.socialin.android.brushlib.view.DrawingView.DrawingMode drawingmode)
            {
                com.socialin.android.brushlib.view.DrawingView.EditingMode editingmode = com.socialin.android.photo.draw.DrawingActivity.b(a).e();
                if (editingmode != null && drawingmode != null)
                {
                    com.socialin.android.photo.draw.DrawingActivity.a(a, editingmode, drawingmode);
                }
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        bundle = s;
        obj1 = new com.socialin.android.brushlib.view.c(this);
        ((DrawingView) (bundle)).t.add(obj1);
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj1 = getIntent().getExtras();
        w = ((Bundle) (obj1)).getBoolean("extra.has.bg.image");
        o = ((Bundle) (obj1)).getString("path");
        ((Bundle) (obj1)).getInt("degree");
        flag = ((Bundle) (obj1)).getBoolean("extra.bg.mode", false);
        if (flag)
        {
            K = BackgroundType.BACKGROUND;
        } else
        if (w)
        {
            K = BackgroundType.PHOTO;
        } else
        {
            K = BackgroundType.BLANK;
        }
        if (getIntent().hasExtra("bufferData"))
        {
            p = (HashMap)((Bundle) (obj1)).getSerializable("bufferData");
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        boolean flag1;
        obj2 = ((Bundle) (obj1)).getString("extra.bg.path");
        int i1 = ((Bundle) (obj1)).getInt("extra.bg.size");
        int j1 = ((Bundle) (obj1)).getInt("extra.canvas.width");
        int k1 = ((Bundle) (obj1)).getInt("extra.canvas.height");
        bundle = new android.graphics.BitmapFactory.Options();
        bundle.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(((String) (obj2)), bundle);
        int l1 = ((android.graphics.BitmapFactory.Options) (bundle)).outWidth;
        int i2 = ((android.graphics.BitmapFactory.Options) (bundle)).outHeight;
        if (j1 <= 0 || k1 <= 0)
        {
            throw new IllegalArgumentException("Width and height must be > 0");
        }
        if (l1 == j1 && i2 == k1)
        {
            bundle.inJustDecodeBounds = false;
            bundle.inSampleSize = 1;
            bundle.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
            bundle = BitmapFactory.decodeFile(((String) (obj2)), bundle);
        } else
        {
            Rect rect = new Rect();
            Rect rect1 = new Rect();
            if (j1 > l1 || k1 > i2)
            {
                bundle.inJustDecodeBounds = false;
                bundle.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
                obj = BitmapFactory.decodeFile(((String) (obj2)), bundle);
                if (obj == null)
                {
                    bundle = Bitmap.createBitmap(Math.max(j1, l1), Math.max(k1, i2), android.graphics.Bitmap.Config.ARGB_8888);
                    bundle.eraseColor(-1);
                    myobfuscated.f.m.a("Cannot load background", this, 1);
                } else
                {
                    bundle = Bitmap.createScaledBitmap(((Bitmap) (obj)), Math.max(j1, l1), Math.max(k1, i2), true);
                    ((Bitmap) (obj)).recycle();
                }
            } else
            {
                l1 = Math.min(l1 / j1, i2 / k1);
                bundle.inJustDecodeBounds = false;
                bundle.inSampleSize = l1;
                bundle.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
                bundle = BitmapFactory.decodeFile(((String) (obj2)), bundle);
            }
            obj = Bitmap.createBitmap(j1, k1, android.graphics.Bitmap.Config.ARGB_8888);
            i2 = bundle.getWidth();
            l1 = bundle.getHeight();
            i2 = (i2 - j1) / 2;
            l1 = (l1 - k1) / 2;
            rect.set(i2, l1, i2 + j1, l1 + k1);
            rect1.set(0, 0, j1, k1);
            (new Canvas(((Bitmap) (obj)))).drawBitmap(bundle, rect, rect1, null);
            bundle.recycle();
            bundle = ((Bundle) (obj));
        }
        if (i1 == ((Bundle) (obj1)).getInt("extra.canvas.width") && i1 == ((Bundle) (obj1)).getInt("extra.canvas.height"))
        {
            o = ((String) (obj2));
        } else
        {
            com.socialin.android.util.w.a(getString(0x7f08096b), (new StringBuilder("drawing_bg_")).append(System.currentTimeMillis()).toString(), bundle, this);
            o = null;
        }
        if (bundle != null)
        {
            s.a(bundle, new com.socialin.android.brushlib.b(), bundle.getWidth(), bundle.getHeight());
            flag1 = false;
        } else
        {
            Utils.a(this, 0x7f08061e);
            u();
            flag1 = false;
        }
_L7:
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.DrawOpenEvent(myobfuscated.f.m.a(getIntent(), "from"), flag1));
        AnalyticUtils.getInstance(this).trackLocalAction("drawing:onCreate");
        h();
        d(false);
        r = myobfuscated.f.m.f();
        r.a(s, new myobfuscated.bw.e() {

            private DrawingActivity a;

            public final boolean a(MotionEvent motionevent)
            {
                return com.socialin.android.photo.draw.DrawingActivity.b(a).a(motionevent);
            }

            public final boolean b(MotionEvent motionevent)
            {
                return com.socialin.android.photo.draw.DrawingActivity.b(a).a(motionevent);
            }

            public final boolean c(MotionEvent motionevent)
            {
                return com.socialin.android.photo.draw.DrawingActivity.b(a).a(motionevent);
            }

            public final void d(MotionEvent motionevent)
            {
                DrawingView drawingview = com.socialin.android.photo.draw.DrawingActivity.b(a);
                if (drawingview.b() == com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW)
                {
                    drawingview.setDrawingMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.ERASE);
                } else
                {
                    drawingview.setDrawingMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW);
                }
                if (com.socialin.android.photo.draw.DrawingActivity.b(a) != null)
                {
                    com.socialin.android.photo.draw.DrawingActivity.b(a).a(motionevent);
                    com.socialin.android.photo.draw.DrawingActivity.b(a).invalidate();
                }
            }

            
            {
                a = DrawingActivity.this;
                super();
            }
        });
        if (myobfuscated.bw.a.a())
        {
            r.a(s, new myobfuscated.bw.d() {

                private DrawingActivity a;

                public final void a()
                {
                    DrawingView drawingview = com.socialin.android.photo.draw.DrawingActivity.b(a);
                    if (drawingview.c.h == com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW)
                    {
                        drawingview.setDrawingMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.ERASE);
                    } else
                    {
                        drawingview.setDrawingMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW);
                    }
                    if (com.socialin.android.photo.draw.DrawingActivity.b(a) != null)
                    {
                        com.socialin.android.photo.draw.DrawingActivity.b(a).invalidate();
                    }
                }

                public final boolean a(View view, MotionEvent motionevent)
                {
                    return true;
                }

            
            {
                a = DrawingActivity.this;
                super();
            }
            });
        }
        initAd();
        s.setUpdateColorButtonRunnable(C);
        s.setToggleFullscreenRunnable(D);
        y = false;
        ar = myobfuscated.f.m.a(this);
        return;
_L4:
        if (!w)
        {
            break MISSING_BLOCK_LABEL_1415;
        }
        if (!((Bundle) (obj1)).containsKey("bitmap.key"))
        {
            break MISSING_BLOCK_LABEL_1325;
        }
        bundle = com.picsart.studio.editor.helper.a.a().a(((Bundle) (obj1)).getInt("bitmap.key"));
_L5:
        if (bundle != null)
        {
            try
            {
                s.a(bundle, new com.socialin.android.brushlib.b(), bundle.getWidth(), bundle.getHeight());
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                com.socialin.android.d.b(c, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(bundle.getMessage()).toString()
                });
                flag1 = false;
                continue; /* Loop/switch isn't completed */
            }
            flag1 = false;
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_1357;
        bundle = b(((Bundle) (obj1)).getString("path"), (HashMap)((Bundle) (obj1)).getSerializable("bufferData"), ((Bundle) (obj1)).getInt("degree"));
          goto _L5
        Utils.a(this, 0x7f08061e);
        u();
        flag1 = false;
        continue; /* Loop/switch isn't completed */
        s.a(((Bundle) (obj1)).getInt("extra.canvas.width"), ((Bundle) (obj1)).getInt("extra.canvas.height"));
        flag1 = false;
        continue; /* Loop/switch isn't completed */
_L2:
        s.a(((Project) (obj)));
        flag1 = true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected void onDestroy()
    {
        if (at != null)
        {
            unregisterReceiver(at);
        }
        super.onDestroy();
        if (s != null)
        {
            s.b(true);
            com.socialin.android.util.c.b(d);
            com.socialin.android.util.c.b(myobfuscated.bs.a.a);
            myobfuscated.bs.b.b();
            myobfuscated.bs.b.a(null);
            if (ad != null)
            {
                com.socialin.android.brushlib.util.c c1 = ad;
                c1.a.clear();
                if (c1.f != null)
                {
                    c1.f.recycle();
                    c1.f = null;
                }
            }
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            if (s.e() == com.socialin.android.brushlib.view.DrawingView.EditingMode.COLOR_PICKER)
            {
                if (G != null)
                {
                    G.b();
                }
                keyevent = s;
                keyevent.setEditingMode(((DrawingView) (keyevent)).q);
                d(false);
                return true;
            }
            if (s.e() == com.socialin.android.brushlib.view.DrawingView.EditingMode.LAYER_TRANSFORM)
            {
                s.k.a();
                p();
                s.setEditingMode(com.socialin.android.brushlib.view.DrawingView.EditingMode.BRUSH);
                return true;
            }
            if (ap == LayerPanelState.OPENED)
            {
                e(true);
                return true;
            } else
            {
                q();
                return true;
            }
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    protected void onPause()
    {
        super.onPause();
        EditingData editingdata = b;
        editingdata.e = (int)((long)editingdata.e + f());
        if (s.c != null && s.c.k != null)
        {
            a(s.c.k);
        }
        if (A)
        {
            z.b();
        }
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (s != null && bundle != null)
        {
            as = Integer.valueOf(bundle.getInt("currentColor"));
        }
        y = false;
    }

    protected void onResume()
    {
        super.onResume();
        n = System.nanoTime();
        if (A)
        {
            z.a();
        }
        y = false;
        com.socialin.android.picsart.profile.invite.i.a(this).edit().putBoolean("is_editor_active", true).apply();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (s == null) goto _L2; else goto _L1
_L1:
        bundle.putSerializable("drawMode", s.b());
        bundle.putSerializable("editMode", s.e());
        if (s.c != null && s.c.k != null)
        {
            bundle.putSerializable("activeProject", s.c.k);
        }
        if (s.e() == null) goto _L4; else goto _L3
_L3:
        com.socialin.android.photo.draw._cls87.a[s.e().ordinal()];
        JVM INSTR tableswitch 1 5: default 140
    //                   1 490
    //                   2 327
    //                   3 430
    //                   4 225
    //                   5 507;
           goto _L4 _L5 _L6 _L7 _L8 _L9
_L4:
        bundle.putSerializable("eraserTime", (HashMap)s.g.g);
        bundle.putSerializable("brushTime", (HashMap)s.g.f);
_L2:
        bundle.putInt("comingFrom", q);
        bundle.putString("drawingSessionId", g);
        bundle.putLong("drawingSessionStart", h);
        bundle.putParcelable("editing_data", b);
        return;
_L8:
        ShapeOverlayController shapeoverlaycontroller = s.i;
        Bundle bundle2 = new Bundle();
        Overlay overlay1 = ((com.socialin.android.brushlib.a) (shapeoverlaycontroller)).a;
        bundle2.putString("shapeName", shapeoverlaycontroller.d);
        bundle2.putSerializable("svg", shapeoverlaycontroller.e);
        bundle2.putSerializable("shapeType", shapeoverlaycontroller.f);
        bundle2.putSerializable("editMode", shapeoverlaycontroller.h);
        bundle2.putSerializable("currentParams", shapeoverlaycontroller.g);
        if (overlay1 != null)
        {
            bundle2.putSerializable("overlay", overlay1);
        }
        bundle.putBundle("shapeOverlayControllerData", bundle2);
        continue; /* Loop/switch isn't completed */
_L6:
        Overlay overlay = ((com.socialin.android.brushlib.a) (s.h)).a;
        if (overlay != null) goto _L11; else goto _L10
_L10:
        Bundle bundle1 = null;
_L13:
        bundle.putBundle("imageOverlayControllerData", bundle1);
        continue; /* Loop/switch isn't completed */
_L11:
        bundle1 = new Bundle();
        bundle1.putSerializable("overlayTransform", overlay.getTransform());
        if (!(overlay instanceof ShapeOverlay))
        {
            break; /* Loop/switch isn't completed */
        }
        bundle1.putSerializable("overlayParams", ((ShapeOverlay)overlay).getParams());
_L15:
        bundle1.putSerializable("overlay", overlay);
        if (true) goto _L13; else goto _L12
_L12:
        if (!(overlay instanceof LineOverlay)) goto _L15; else goto _L14
_L14:
        bundle1.putSerializable("overlayParams", ((LineOverlay)overlay).getParams());
          goto _L15
_L7:
        com.socialin.android.brushlib.controller.g g1 = s.j;
        Bundle bundle3 = new Bundle();
        bundle3.putSerializable("style", g1.c);
        bundle3.putParcelable("styleData", g1.b);
        bundle3.putSerializable("text", g1.d);
        bundle.putBundle("textOverlayControllerData", bundle3);
        continue; /* Loop/switch isn't completed */
_L5:
        bundle.putInt("currentColor", s.l);
        continue; /* Loop/switch isn't completed */
_L9:
        bundle.putInt("currentColor", s.l);
        if (true) goto _L4; else goto _L16
_L16:
    }

    protected void onStart()
    {
        super.onStart();
        ar.connect();
        myobfuscated.f.m.a(ar, "http://schema.org/ActivateAction", getString(0x7f08012a), "android-app://com.picsart.studio/picsart/draw");
    }

    protected void onStop()
    {
        super.onStop();
        myobfuscated.f.m.b(ar, "http://schema.org/ActivateAction", getString(0x7f08012a), "android-app://com.picsart.studio/picsart/draw");
        ar.disconnect();
    }

    static 
    {
        String s1 = com/socialin/android/photo/draw/DrawingActivity.getSimpleName();
        c = s1;
        d = s1;
    }

    private class CameraPanelState extends Enum
    {

        private static final CameraPanelState $VALUES[];
        public static final CameraPanelState CLOSED;
        public static final CameraPanelState CLOSING;
        public static final CameraPanelState OPENED;
        public static final CameraPanelState OPENING;

        public static CameraPanelState valueOf(String s1)
        {
            return (CameraPanelState)Enum.valueOf(com/socialin/android/photo/draw/DrawingActivity$CameraPanelState, s1);
        }

        public static CameraPanelState[] values()
        {
            return (CameraPanelState[])$VALUES.clone();
        }

        static 
        {
            OPENING = new CameraPanelState("OPENING", 0);
            CLOSING = new CameraPanelState("CLOSING", 1);
            CLOSED = new CameraPanelState("CLOSED", 2);
            OPENED = new CameraPanelState("OPENED", 3);
            $VALUES = (new CameraPanelState[] {
                OPENING, CLOSING, CLOSED, OPENED
            });
        }

        private CameraPanelState(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class LayerPanelState extends Enum
    {

        private static final LayerPanelState $VALUES[];
        public static final LayerPanelState CLOSED;
        public static final LayerPanelState CLOSING;
        public static final LayerPanelState OPENED;
        public static final LayerPanelState OPENING;

        public static LayerPanelState valueOf(String s1)
        {
            return (LayerPanelState)Enum.valueOf(com/socialin/android/photo/draw/DrawingActivity$LayerPanelState, s1);
        }

        public static LayerPanelState[] values()
        {
            return (LayerPanelState[])$VALUES.clone();
        }

        static 
        {
            OPENED = new LayerPanelState("OPENED", 0);
            OPENING = new LayerPanelState("OPENING", 1);
            CLOSING = new LayerPanelState("CLOSING", 2);
            CLOSED = new LayerPanelState("CLOSED", 3);
            $VALUES = (new LayerPanelState[] {
                OPENED, OPENING, CLOSING, CLOSED
            });
        }

        private LayerPanelState(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class RequestCode extends Enum
    {

        private static final RequestCode $VALUES[];
        public static final RequestCode CANCEL_CONFIRM;
        public static final RequestCode CHOOSE_PIC_FOR_ADD_PHOTO;
        public static final RequestCode CHOOSE_PIC_FOR_LAYER;
        public static final RequestCode CROP_IMAGE_FOR_ADD_PHOTO;
        public static final RequestCode CROP_IMG_FOR_LAYER;
        public static final RequestCode EXPORT;
        public static final RequestCode SAVE_TO_SD;
        public static final RequestCode SELECT_BRUSH;
        public static final RequestCode SELECT_CLIPART;
        public static final RequestCode SELECT_SHAPE;
        public static final RequestCode SELECT_TEXT;

        public static RequestCode fromInt(int i1)
        {
            RequestCode arequestcode[] = values();
            if (i1 < 0 || i1 >= arequestcode.length)
            {
                return null;
            } else
            {
                return values()[i1];
            }
        }

        public static RequestCode valueOf(String s1)
        {
            return (RequestCode)Enum.valueOf(com/socialin/android/photo/draw/DrawingActivity$RequestCode, s1);
        }

        public static RequestCode[] values()
        {
            return (RequestCode[])$VALUES.clone();
        }

        public final int toInt()
        {
            return ordinal();
        }

        static 
        {
            SAVE_TO_SD = new RequestCode("SAVE_TO_SD", 0);
            EXPORT = new RequestCode("EXPORT", 1);
            CANCEL_CONFIRM = new RequestCode("CANCEL_CONFIRM", 2);
            CHOOSE_PIC_FOR_LAYER = new RequestCode("CHOOSE_PIC_FOR_LAYER", 3);
            CHOOSE_PIC_FOR_ADD_PHOTO = new RequestCode("CHOOSE_PIC_FOR_ADD_PHOTO", 4);
            CROP_IMG_FOR_LAYER = new RequestCode("CROP_IMG_FOR_LAYER", 5);
            CROP_IMAGE_FOR_ADD_PHOTO = new RequestCode("CROP_IMAGE_FOR_ADD_PHOTO", 6);
            SELECT_BRUSH = new RequestCode("SELECT_BRUSH", 7);
            SELECT_TEXT = new RequestCode("SELECT_TEXT", 8);
            SELECT_SHAPE = new RequestCode("SELECT_SHAPE", 9);
            SELECT_CLIPART = new RequestCode("SELECT_CLIPART", 10);
            $VALUES = (new RequestCode[] {
                SAVE_TO_SD, EXPORT, CANCEL_CONFIRM, CHOOSE_PIC_FOR_LAYER, CHOOSE_PIC_FOR_ADD_PHOTO, CROP_IMG_FOR_LAYER, CROP_IMAGE_FOR_ADD_PHOTO, SELECT_BRUSH, SELECT_TEXT, SELECT_SHAPE, 
                SELECT_CLIPART
            });
        }

        private RequestCode(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class BackgroundType extends Enum
    {

        private static final BackgroundType $VALUES[];
        public static final BackgroundType BACKGROUND;
        public static final BackgroundType BLANK;
        public static final BackgroundType PHOTO;

        public static BackgroundType valueOf(String s1)
        {
            return (BackgroundType)Enum.valueOf(com/socialin/android/photo/draw/DrawingActivity$BackgroundType, s1);
        }

        public static BackgroundType[] values()
        {
            return (BackgroundType[])$VALUES.clone();
        }

        static 
        {
            BLANK = new BackgroundType("BLANK", 0);
            PHOTO = new BackgroundType("PHOTO", 1);
            BACKGROUND = new BackgroundType("BACKGROUND", 2);
            $VALUES = (new BackgroundType[] {
                BLANK, PHOTO, BACKGROUND
            });
        }

        private BackgroundType(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
