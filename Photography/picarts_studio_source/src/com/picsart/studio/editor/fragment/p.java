// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.EditorAction;
import com.picsart.studio.editor.utils.b;
import com.picsart.studio.gifencoder.GifEncoder;
import com.socialin.android.brushlib.project.a;
import com.socialin.android.share.SaveExportActivity;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i, o

public final class p extends i
    implements o
{

    private static Executor C = Executors.newSingleThreadExecutor();
    private static final String I;
    private static com.picsart.studio.editor.utils.a d;
    private static int x = 0;
    private volatile boolean A;
    private ImageButton B;
    private ProgressBar D;
    private com.socialin.android.dialog.b E;
    private com.socialin.android.dialog.a F;
    private GifEncoder G;
    private ProgressBar H;
    private b J;
    private List c;
    private e e;
    private float f;
    private int i;
    private int j;
    private RectF k;
    private RectF l;
    private Matrix m;
    private Paint n;
    private Bitmap o;
    private Point p;
    private Canvas q;
    private int r;
    private ImageView s;
    private SeekBar t;
    private TextView u;
    private Runnable v;
    private Handler w;
    private int y;
    private com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions z;

    public p()
    {
        f = 0.0F;
        i = 1;
        j = 1;
        r = 0;
        y = 500;
        A = false;
        J = new b(this);
    }

    static int a(p p1, int i1)
    {
        p1.y = i1;
        return i1;
    }

    static ProgressBar a(p p1, ProgressBar progressbar)
    {
        p1.H = progressbar;
        return progressbar;
    }

    static com.socialin.android.dialog.a a(p p1, com.socialin.android.dialog.a a1)
    {
        p1.F = a1;
        return a1;
    }

    private void a(Bitmap bitmap, Bitmap bitmap1, int i1)
    {
        k.set(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
        l.set(0.0F, 0.0F, bitmap1.getWidth(), bitmap1.getHeight());
        m.setRectToRect(k, l, android.graphics.Matrix.ScaleToFit.CENTER);
        q.drawBitmap(bitmap, m, n);
        bitmap = null;
        Object obj = new FileOutputStream((new StringBuilder()).append(I).append("/").append(i1).append(".png").toString());
        bitmap = ((Bitmap) (obj));
        bitmap1.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, ((java.io.OutputStream) (obj)));
        ((FileOutputStream) (obj)).close();
_L2:
        return;
        bitmap;
        bitmap.printStackTrace();
        return;
        Exception exception;
        exception;
        bitmap1 = null;
_L5:
        bitmap = bitmap1;
        exception.printStackTrace();
        if (bitmap1 == null) goto _L2; else goto _L1
_L1:
        try
        {
            bitmap1.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
        }
        return;
        obj;
        bitmap1 = bitmap;
        bitmap = ((Bitmap) (obj));
_L4:
        if (bitmap1 != null)
        {
            try
            {
                bitmap1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap1)
            {
                bitmap1.printStackTrace();
            }
        }
        throw bitmap;
        obj;
        bitmap1 = bitmap;
        bitmap = ((Bitmap) (obj));
        if (true) goto _L4; else goto _L3
_L3:
        exception;
        bitmap1 = ((Bitmap) (obj));
          goto _L5
    }

    static void a(p p1)
    {
        if (x > p1.r - 1)
        {
            x = 0;
        }
        p1.o = BitmapFactory.decodeFile((new StringBuilder()).append(I).append("/").append(x).append(".png").toString());
        if (!p1.getActivity().isFinishing())
        {
            p1.getActivity().runOnUiThread(p1. new Runnable() {

                private p a;

                public final void run()
                {
                    p.i(a).setImageBitmap(p.h(a));
                }

            
            {
                a = p.this;
                super();
            }
            });
        }
        x++;
    }

    public static void a(p p1, com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions gifoptions)
    {
        p1.a(gifoptions);
    }

    private void a(com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions gifoptions)
    {
        Intent intent = new Intent(getActivity(), com/socialin/android/share/SaveExportActivity);
        intent.putExtra("gifPath", gifoptions.getOutputPath());
        intent.putExtra("videoAndGif", true);
        intent.putExtra("gifDelay", gifoptions.getDelay() / 100D);
        intent.putExtra("gifDir", gifoptions.getOutputDir());
        intent.putExtra("gifName", gifoptions.getOutputName());
        intent.putExtra("editor_export_gif_uid", gifoptions.getmUid());
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            intent.putExtra("gifVideoPath", gifoptions.setupGifToVideoPathAndGet());
        }
        d.j = false;
        startActivity(intent);
    }

    static boolean a(p p1, boolean flag)
    {
        p1.A = flag;
        return flag;
    }

    static Handler b(p p1)
    {
        return p1.w;
    }

    static int c(p p1)
    {
        p1.r = 0;
        return 0;
    }

    static void d(p p1)
    {
        p1.o = Bitmap.createBitmap(p1.p.x, p1.p.y, android.graphics.Bitmap.Config.ARGB_8888);
        int i1 = p1.p.x;
        i1 = p1.p.y;
        i1 = p1.r;
        p1.q = new Canvas(p1.o);
        Bitmap bitmap = Bitmap.createScaledBitmap(p1.e.a.a(), p1.p.x, p1.p.y, true);
        if (i1 == 0)
        {
            p1.a(bitmap, p1.o, p1.r);
            p1.r = p1.r + 1;
        }
        int k1 = p1.c.size() + 1;
        p1.f = (float)k1 / 10F;
        for (int j1 = 0; j1 < p1.c.size();)
        {
            Bitmap bitmap1;
label0:
            {
                if ((int)(p1.f * (float)p1.i) != p1.j)
                {
                    bitmap1 = bitmap;
                    if (k1 >= 10)
                    {
                        break label0;
                    }
                }
                bitmap1 = ((EditorAction)p1.c.get(j1)).apply(bitmap);
                p1.o.eraseColor(0);
                if (j1 >= p1.r - 1)
                {
                    p1.a(bitmap1, p1.o, p1.r);
                    p1.r = p1.r + 1;
                }
                p1.i = p1.i + 1;
            }
            p1.j = p1.j + 1;
            j1++;
            bitmap = bitmap1;
        }

        p1.a(bitmap, p1.o, p1.r);
        p1.r = p1.r + 1;
        bitmap.recycle();
    }

    static ImageButton e(p p1)
    {
        return p1.B;
    }

    static ProgressBar f(p p1)
    {
        return p1.D;
    }

    static int g(p p1)
    {
        return p1.y;
    }

    static Bitmap h(p p1)
    {
        return p1.o;
    }

    static ImageView i(p p1)
    {
        return p1.s;
    }

    static String i()
    {
        return I;
    }

    static TextView j(p p1)
    {
        return p1.u;
    }

    static com.picsart.studio.editor.utils.a j()
    {
        return d;
    }

    static com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions k(p p1)
    {
        return p1.z;
    }

    static void k()
    {
        m();
    }

    static Runnable l(p p1)
    {
        return p1.v;
    }

    private void l()
    {
        if (!A)
        {
            Object obj = e;
            Point point = new Point(((e) (obj)).a.b());
            Object obj1 = ((e) (obj)).c.e();
            obj = new SparseIntArray();
            obj1 = ((List) (obj1)).iterator();
            while (((Iterator) (obj1)).hasNext()) 
            {
                ((EditorAction)((Iterator) (obj1)).next()).getOutSize(point);
                if (point.x > 512 || point.y > 512)
                {
                    int i1;
                    int k1;
                    if (point.x > point.y)
                    {
                        i1 = (int)(((float)point.y * 512F) / (float)point.x);
                        k1 = 512;
                    } else
                    {
                        k1 = (int)(((float)point.x * 512F) / (float)point.y);
                        i1 = 512;
                    }
                    point.set(k1, i1);
                }
                i1 = (int)(((float)point.y * 500F) / (float)point.x);
                ((SparseIntArray) (obj)).put(i1, ((SparseIntArray) (obj)).get(i1) + 1);
            }
            int l1 = ((SparseIntArray) (obj)).size() - 1;
            for (int j1 = 0; j1 < ((SparseIntArray) (obj)).size();)
            {
                int i2 = l1;
                if (((SparseIntArray) (obj)).valueAt(j1) > ((SparseIntArray) (obj)).valueAt(l1))
                {
                    i2 = j1;
                }
                j1++;
                l1 = i2;
            }

            point.set(500, ((SparseIntArray) (obj)).keyAt(l1));
            p = point;
            (new ModernAsyncTask() {

                private p a;

                protected final Object doInBackground(Object aobj[])
                {
                    if (!(new File(p.i())).exists())
                    {
                        com.picsart.studio.editor.fragment.p.c(a);
                        (new File(p.i())).mkdirs();
                    }
                    p.d(a);
                    return null;
                }

                protected final void onPostExecute(Object obj2)
                {
                    super.onPostExecute((Void)obj2);
                    p.f(a).setVisibility(8);
                    com.picsart.studio.editor.fragment.p.e(a).setEnabled(true);
                    com.picsart.studio.editor.fragment.p.a(a, true);
                    a.a(p.g(a));
                }

                protected final void onPreExecute()
                {
                    super.onPreExecute();
                    com.picsart.studio.editor.fragment.p.a(a, false);
                    com.picsart.studio.editor.fragment.p.e(a).setEnabled(false);
                    p.f(a).setVisibility(0);
                }

            
            {
                a = p.this;
                super();
            }
            }).executeOnExecutor(C, new Void[0]);
        }
    }

    private static void m()
    {
        FileUtils.a(new File(I));
    }

    static boolean m(p p1)
    {
        return p1.A;
    }

    public static ProgressBar n(p p1)
    {
        return p1.H;
    }

    private static String n()
    {
        String s1 = "";
        boolean flag = false;
        while (!flag) 
        {
            s1 = (new StringBuilder("gif_")).append((new SimpleDateFormat("MM-dd-hh.mm.ss")).format(new Date()).toString()).toString();
            if ((new File(new File(a.a), (new StringBuilder()).append(s1).append(".gif").toString())).exists())
            {
                flag = false;
            } else
            {
                flag = true;
            }
        }
        return (new StringBuilder()).append(a.a).append(s1).append(".gif").toString();
    }

    private void o()
    {
        if (getResources().getConfiguration().orientation == 1)
        {
            getActivity().setRequestedOrientation(1);
            return;
        } else
        {
            getActivity().setRequestedOrientation(0);
            return;
        }
    }

    public static void o(p p1)
    {
        if (p1.getActivity() != null)
        {
            p1.getActivity().setRequestedOrientation(4);
        }
    }

    static com.socialin.android.dialog.b p(p p1)
    {
        com.socialin.android.dialog.b b1 = (new com.socialin.android.dialog.b()).a(0x7f0c0187, 0x7f0c0181);
        b1.f = 0x7f0300c0;
        b1.p = p1. new com.socialin.android.dialog.c() {

            private p a;

            public final void onViewCreated(View view, DialogFragment dialogfragment)
            {
                dialogfragment.setStyle(0x7f0c0187, 0x7f0c0181);
                com.picsart.studio.editor.fragment.p.a(a, (ProgressBar)view.findViewById(0x7f1003fd));
                p.n(a).setProgress(p.j().i);
            }

            
            {
                a = p.this;
                super();
            }
        };
        b1.i = false;
        String s1 = p1.getResources().getString(0x7f080295);
        b1.l = p1. new android.view.View.OnClickListener() {

            private p a;

            public final void onClick(View view)
            {
                if (p.j() != null)
                {
                    p.j().a();
                }
                if (p.m(a))
                {
                    a.a(p.g(a));
                }
                p.o(a);
            }

            
            {
                a = p.this;
                super();
            }
        };
        b1.h = true;
        if (s1 != null)
        {
            b1.d = s1;
        }
        b1.g = false;
        b1.h = true;
        p1.E = b1;
        return p1.E;
    }

    static com.socialin.android.dialog.b q(p p1)
    {
        return p1.E;
    }

    public static com.socialin.android.dialog.a r(p p1)
    {
        return p1.F;
    }

    static void s(p p1)
    {
        p1.o();
    }

    public final void a(long l1)
    {
        Handler handler = w;
        Runnable runnable = new Runnable(l1) {

            private long a;
            private p b;

            public final void run()
            {
                if (b.getActivity() != null && !b.getActivity().isFinishing())
                {
                    com.picsart.studio.editor.fragment.p.a(b);
                    com.picsart.studio.editor.fragment.p.b(b).postDelayed(this, a);
                }
            }

            
            {
                b = p.this;
                a = l1;
                super();
            }
        };
        v = runnable;
        handler.postDelayed(runnable, l1);
    }

    public final void a(o o1)
    {
        G = new GifEncoder();
        com.picsart.studio.editor.utils.a a1;
        if (d != null)
        {
            a1 = d;
            boolean flag;
            if (a1.k != null && a1.k.getStatus() == com.socialin.android.util.ModernAsyncTask.Status.RUNNING)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                d.a();
                d = null;
            }
        }
        a1 = new com.picsart.studio.editor.utils.a(com.picsart.studio.editor.e.a(), z, G, J);
        d = a1;
        if (com.picsart.studio.editor.e.a().c.e() != null && com.picsart.studio.editor.e.a().c.e().size() > 0)
        {
            a1.k = new com.picsart.studio.editor.utils.a._cls1(a1);
            a1.k.execute(new Void[0]);
        } else
        {
            a1.h = 1;
            a1.d.a();
        }
        if (o1 != null)
        {
            o1.f_();
        }
    }

    public final void d()
    {
        super.d();
        m();
    }

    public final Tool e()
    {
        return Tool.GIFEXPORT;
    }

    public final void f_()
    {
        getActivity().runOnUiThread(new Runnable() {

            private p a;

            public final void run()
            {
                p.p(a);
                com.picsart.studio.editor.fragment.p.a(a, p.q(a).a());
                p.r(a).show(a.getFragmentManager(), "gif_generation");
                p.s(a);
            }

            
            {
                a = p.this;
                super();
            }
        });
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        View view = getView();
        e = com.picsart.studio.editor.e.a();
        try
        {
            c = e.c.e();
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            if (d != null)
            {
                d.a();
                d = null;
            }
            Utils.b(getActivity(), 0x7f0805ca);
        }
        z = new com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions(50D, 10, n());
        w = new Handler();
        D = (ProgressBar)view.findViewById(0x7f100188);
        s = (ImageView)view.findViewById(0x7f100643);
        t = (SeekBar)view.findViewById(0x7f100646);
        u = (TextView)view.findViewById(0x7f100645);
        t.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private p a;

            public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                if (flag)
                {
                    i1++;
                    p.j(a).setText((new StringBuilder()).append((float)(11 - i1) / 10F).append(" sec").toString());
                    com.picsart.studio.editor.fragment.p.a(a, (11 - i1) * 100);
                    p.k(a).setDelay((float)(11 - i1) * 10F);
                    com.picsart.studio.editor.fragment.p.b(a).removeCallbacks(p.l(a));
                    if (p.m(a))
                    {
                        a.a(p.g(a));
                    }
                }
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = p.this;
                super();
            }
        });
        B = (ImageButton)view.findViewById(0x7f100550);
        B.setOnClickListener(new android.view.View.OnClickListener() {

            final p a;

            public final void onClick(View view1)
            {
                if (p.l(a) != null)
                {
                    com.picsart.studio.editor.fragment.p.b(a).removeCallbacks(p.l(a));
                }
                a.getActivity().runOnUiThread(new Runnable(this) {

                    final _cls9 a;

                    public final void run()
                    {
                        if (p.j() != null)
                        {
                            p.j().a();
                        }
                        (new ModernAsyncTask(this) {

                            private _cls1 a;

                            protected final Object doInBackground(Object aobj[])
                            {
                                aobj = new Bundle();
                                ((Bundle) (aobj)).putSerializable("gifOptions", p.k(a.a.a));
                                a.a.a.getActivity().getIntent().putExtras(((Bundle) (aobj)));
                                a.a.a.a(a.a.a);
                                return null;
                            }

                            protected final volatile void onPostExecute(Object obj)
                            {
                                super.onPostExecute((Void)obj);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        }).execute(new Void[0]);
                    }

            
            {
                a = _pcls9;
                super();
            }
                });
            }

            
            {
                a = p.this;
                super();
            }
        });
        view.findViewById(0x7f10054f).setOnClickListener(new android.view.View.OnClickListener() {

            private p a;

            public final void onClick(View view1)
            {
                p.k();
                if (a.g != null)
                {
                    a.g.a(a);
                }
            }

            
            {
                a = p.this;
                super();
            }
        });
        if (bundle != null) goto _L2; else goto _L1
_L1:
        FileUtils.a(new File(I));
        t.setProgress(5);
        u.setText("0.5 sec");
        if (F != null)
        {
            bundle = getFragmentManager().beginTransaction();
            bundle.remove(F);
            bundle.commit();
            getFragmentManager().popBackStack();
        }
_L4:
        l();
        return;
_L2:
        F = (com.socialin.android.dialog.a)getFragmentManager().findFragmentByTag("gif_generation");
        if (d != null && d.j)
        {
            a(d.b);
            if (F != null)
            {
                FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
                fragmenttransaction.remove(F);
                fragmenttransaction.commit();
                getFragmentManager().popBackStack();
            }
        }
        if (d != null && F != null)
        {
            d.d = J;
            if (F.getView() != null)
            {
                H = (ProgressBar)F.getView().findViewById(0x7f1003fd);
                H.setProgress(d.i);
            } else
            {
                F.a(new com.socialin.android.dialog.c() {

                    private p a;

                    public final void onViewCreated(View view1, DialogFragment dialogfragment)
                    {
                        com.picsart.studio.editor.fragment.p.a(a, (ProgressBar)view1.findViewById(0x7f1003fd));
                        p.n(a).setProgress(p.j().i);
                    }

            
            {
                a = p.this;
                super();
            }
                });
            }
            F.f = new android.view.View.OnClickListener() {

                private p a;

                public final void onClick(View view1)
                {
                    if (p.j() != null)
                    {
                        p.j().a();
                    }
                    p.o(a);
                    if (p.m(a))
                    {
                        a.a(p.g(a));
                    }
                }

            
            {
                a = p.this;
                super();
            }
            };
            F.setCancelable(false);
            if (!F.isAdded())
            {
                getFragmentManager().beginTransaction().add(F, F.getTag());
            }
        }
        if (F != null)
        {
            if (d != null || c == null)
            {
                break; /* Loop/switch isn't completed */
            }
            F.a(new com.socialin.android.dialog.c() {

                private p a;

                public final void onViewCreated(View view1, DialogFragment dialogfragment)
                {
                    com.picsart.studio.editor.fragment.p.a(a, (ProgressBar)view1.findViewById(0x7f1003fd));
                    p.n(a).setProgress(p.j().i);
                }

            
            {
                a = p.this;
                super();
            }
            });
            F.f = new android.view.View.OnClickListener() {

                private p a;

                public final void onClick(View view1)
                {
                    if (p.j() != null)
                    {
                        p.j().a();
                    }
                    p.r(a).dismiss();
                    p.o(a);
                }

            
            {
                a = p.this;
                super();
            }
            };
            F.setCancelable(false);
            a(((o) (null)));
            o();
        }
_L6:
        r = bundle.getInt("fileCount", 0);
        A = bundle.getBoolean("animLock", false);
        y = bundle.getInt("delay", 500);
        z = new com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions((float)y / 10F, 10, n());
        u.setText((new StringBuilder()).append(String.valueOf((float)y / 1000F)).append(" sec").toString());
        t.setProgress(y / 100);
        if (A)
        {
            a(y);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (d != null || c != null) goto _L6; else goto _L5
_L5:
        FragmentTransaction fragmenttransaction1 = getFragmentManager().beginTransaction();
        fragmenttransaction1.remove(F);
        fragmenttransaction1.commit();
        getFragmentManager().popBackStack();
          goto _L6
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        m = new Matrix();
        k = new RectF();
        l = new RectF();
        n = new Paint(2);
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030129, viewgroup, false);
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        Bundle bundle1 = new Bundle();
        Intent intent1 = getActivity().getIntent();
        Intent intent = intent1;
        if (intent1 == null)
        {
            intent = new Intent();
        }
        bundle1.putBoolean("animLock", A);
        bundle1.putInt("delay", y);
        bundle1.putInt("fileCount", r);
        intent.putExtras(bundle1);
        bundle.putBoolean("animLock", A);
        bundle.putInt("delay", y);
        bundle.putInt("fileCount", r);
        super.onSaveInstanceState(bundle);
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        if (w == null)
        {
            w = new Handler();
        }
    }

    static 
    {
        I = (new StringBuilder()).append(a.a).append(".preview").toString();
    }
}
