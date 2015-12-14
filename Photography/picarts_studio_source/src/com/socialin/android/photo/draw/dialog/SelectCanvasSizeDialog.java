// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.view.WrappingListPopupWindow;
import com.picsart.studio.view.p;
import com.socialin.android.dialog.d;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.bj.b;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            e

public class SelectCanvasSizeDialog extends d
{

    static final String a = com/socialin/android/photo/draw/dialog/SelectCanvasSizeDialog.getSimpleName();
    EditText b;
    EditText c;
    public b d;
    private android.view.View.OnClickListener e;

    public SelectCanvasSizeDialog()
    {
        setStyle(1, 0x7f0c0181);
    }

    private SelectCanvasSizeDialog(b b1)
    {
        d = b1;
        setStyle(1, 0x7f0c0181);
    }

    public static Point a(Activity activity)
    {
label0:
        {
label1:
            {
                Point point = b(activity);
                if (point != null)
                {
                    activity = point;
                    if (c(point.x, point.y))
                    {
                        break label1;
                    }
                }
                if (PicsartContext.b() > 1)
                {
                    break label0;
                }
                activity = new Point(1024, 768);
            }
            return activity;
        }
        if (PicsartContext.b() <= 2)
        {
            return new Point(1600, 1200);
        }
        if (PicsartContext.b() <= 3)
        {
            return new Point(2048, 1536);
        }
        if (PicsartContext.b() <= 4)
        {
            return new Point(2048, 1536);
        }
        if (PicsartContext.b() <= 5)
        {
            return new Point(2048, 1536);
        }
        if (PicsartContext.b() <= 6)
        {
            return new Point(2048, 1536);
        }
        if (PicsartContext.b() <= 7)
        {
            return new Point(2048, 1536);
        }
        if (PicsartContext.b() <= 8)
        {
            return new Point(2048, 1536);
        } else
        {
            return new Point(1024, 768);
        }
    }

    static EditText a(SelectCanvasSizeDialog selectcanvassizedialog)
    {
        return selectcanvassizedialog.b;
    }

    public static SelectCanvasSizeDialog a(b b1)
    {
        return new SelectCanvasSizeDialog(b1);
    }

    static String a()
    {
        return a;
    }

    static void a(ImageButton imagebutton, boolean flag)
    {
        b(imagebutton, flag);
    }

    static void a(SelectCanvasSizeDialog selectcanvassizedialog, int i, int j)
    {
        selectcanvassizedialog.a(i, j);
    }

    private static Point b(Activity activity)
    {
        DataInputStream datainputstream;
        Point point;
        if (activity == null)
        {
            return null;
        }
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            activity = activity.getExternalCacheDir();
        } else
        {
            activity = activity.getCacheDir();
        }
        activity = new File(activity, "canvas.def");
        activity.createNewFile();
        datainputstream = new DataInputStream(new FileInputStream(activity));
        activity = datainputstream;
        point = new Point();
        activity = datainputstream;
        point.x = datainputstream.readInt();
        activity = datainputstream;
        point.y = datainputstream.readInt();
        datainputstream.close();
        activity = point;
_L1:
        return activity;
        activity;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(activity.getMessage()).toString()
        });
        activity = point;
          goto _L1
        IOException ioexception;
        ioexception;
        datainputstream = null;
_L4:
        activity = datainputstream;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
        });
        if (datainputstream == null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        datainputstream.close();
        activity = null;
          goto _L1
        activity;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(activity.getMessage()).toString()
        });
        activity = null;
          goto _L1
        Exception exception;
        exception;
        activity = null;
_L3:
        if (activity != null)
        {
            try
            {
                activity.close();
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(activity.getMessage()).toString()
                });
            }
        }
        throw exception;
        exception;
        if (true) goto _L3; else goto _L2
_L2:
        ioexception;
          goto _L4
    }

    static EditText b(SelectCanvasSizeDialog selectcanvassizedialog)
    {
        return selectcanvassizedialog.c;
    }

    static ImageOrientation b(int i, int j)
    {
        return d(i, j);
    }

    private static void b(ImageButton imagebutton, boolean flag)
    {
        if (flag)
        {
            imagebutton.setBackgroundResource(0x7f0200aa);
            return;
        } else
        {
            imagebutton.setBackgroundResource(0x7f0200be);
            return;
        }
    }

    private static boolean c(int i, int j)
    {
        return i * j <= PicsartContext.a();
    }

    private static ImageOrientation d(int i, int j)
    {
        if (i < j)
        {
            return ImageOrientation.PORTRAIT;
        } else
        {
            return ImageOrientation.LANDSCAPE;
        }
    }

    final void a(int i, int j)
    {
        Object obj = getActivity();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        obj = new File(((Activity) (obj)).getExternalCacheDir(), "canvas.def");
        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(((File) (obj))));
        obj = dataoutputstream;
        dataoutputstream.writeInt(i);
        obj = dataoutputstream;
        dataoutputstream.writeInt(j);
        try
        {
            dataoutputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
            });
        }
        return;
        IOException ioexception1;
        ioexception1;
        dataoutputstream = null;
_L6:
        obj = dataoutputstream;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(ioexception1.getMessage()).toString()
        });
        if (dataoutputstream == null) goto _L1; else goto _L3
_L3:
        try
        {
            dataoutputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
            });
        }
        return;
        Exception exception;
        exception;
        obj = null;
_L5:
        if (obj != null)
        {
            try
            {
                ((DataOutputStream) (obj)).close();
            }
            catch (IOException ioexception)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
                });
            }
        }
        throw exception;
        exception;
        if (true) goto _L5; else goto _L4
_L4:
        ioexception1;
          goto _L6
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0301a8, viewgroup, false);
        m.b(layoutinflater).setText(0x7f080581);
        viewgroup = layoutinflater.findViewById(0x7f100125);
        viewgroup.setVisibility(0);
        e = new android.view.View.OnClickListener() {

            private SelectCanvasSizeDialog a;

            public final void onClick(View view)
            {
                SelectCanvasSizeDialog selectcanvassizedialog = a;
                int l = Integer.parseInt(selectcanvassizedialog.b.getText().toString());
                int i1 = Integer.parseInt(selectcanvassizedialog.c.getText().toString());
_L2:
                if (l < 16 || i1 < 16)
                {
                    Toast.makeText(selectcanvassizedialog.getActivity(), selectcanvassizedialog.getString(0x7f080251, new Object[] {
                        Integer.valueOf(16)
                    }), 0).show();
                    return;
                }
                break; /* Loop/switch isn't completed */
                view;
                l = 0;
_L3:
                com.socialin.android.d.b(SelectCanvasSizeDialog.a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(view.getMessage()).toString()
                });
                i1 = 0;
                if (true) goto _L2; else goto _L1
_L1:
                if (l > 4096 || i1 > 4096 || l * i1 > PicsartContext.a(selectcanvassizedialog.getActivity()))
                {
                    Toast.makeText(selectcanvassizedialog.getActivity(), selectcanvassizedialog.getString(0x7f080235, new Object[] {
                        Integer.valueOf(PicsartContext.b())
                    }), 0).show();
                    return;
                }
                selectcanvassizedialog.a(l, i1);
                if (selectcanvassizedialog.d != null)
                {
                    selectcanvassizedialog.d.a(l, i1);
                }
                selectcanvassizedialog.dismiss();
                return;
                view;
                  goto _L3
            }

            
            {
                a = SelectCanvasSizeDialog.this;
                super();
            }
        };
        viewgroup.setOnClickListener(e);
        viewgroup = layoutinflater.findViewById(0x7f100395);
        viewgroup.setVisibility(0);
        viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

            private SelectCanvasSizeDialog a;

            public final void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = SelectCanvasSizeDialog.this;
                super();
            }
        });
        b = (EditText)layoutinflater.findViewById(0x7f100392);
        c = (EditText)layoutinflater.findViewById(0x7f100393);
        viewgroup = (ImageButton)layoutinflater.findViewById(0x7f1007e3);
        bundle = (ImageButton)layoutinflater.findViewById(0x7f1007e4);
        Object obj = a(getActivity());
        b.setText(String.valueOf(((Point) (obj)).x));
        c.setText(String.valueOf(((Point) (obj)).y));
        String as[];
        Object obj1;
        int i;
        int k;
        if (d(((Point) (obj)).x, ((Point) (obj)).y) == ImageOrientation.PORTRAIT)
        {
            b(viewgroup, false);
            b(bundle, true);
        } else
        {
            b(viewgroup, true);
            b(bundle, false);
        }
        i = getResources().getDisplayMetrics().widthPixels;
        k = getResources().getDisplayMetrics().heightPixels;
        obj = new ArrayList();
        if (PicsartContext.b() <= 1)
        {
            ((List) (obj)).add(new e(800, 600));
            ((List) (obj)).add(new e(640, 480));
            ((List) (obj)).add(new e(1280, 720));
            ((List) (obj)).add(new e(900, 600));
            ((List) (obj)).add(new e(1024, 768));
            ((List) (obj)).add(new e(1024, 1024));
        } else
        if (PicsartContext.b() <= 2)
        {
            ((List) (obj)).add(new e(1680, 1050));
            ((List) (obj)).add(new e(1440, 900));
            ((List) (obj)).add(new e(1280, 1024));
            ((List) (obj)).add(new e(1920, 1080));
            ((List) (obj)).add(new e(1600, 1200));
        } else
        if (PicsartContext.b() <= 3)
        {
            ((List) (obj)).add(new e(1920, 1200));
            ((List) (obj)).add(new e(1920, 1080));
            ((List) (obj)).add(new e(2048, 1536));
            ((List) (obj)).add(new e(1536, 1536));
        } else
        if (PicsartContext.b() <= 4)
        {
            ((List) (obj)).add(new e(1920, 1200));
            ((List) (obj)).add(new e(2560, 1600));
            ((List) (obj)).add(new e(2560, 1440));
            ((List) (obj)).add(new e(2048, 1536));
            ((List) (obj)).add(new e(2048, 2048));
        } else
        if (PicsartContext.b() <= 5)
        {
            ((List) (obj)).add(new e(1920, 1200));
            ((List) (obj)).add(new e(2560, 2048));
            ((List) (obj)).add(new e(2560, 1440));
            ((List) (obj)).add(new e(2048, 1536));
            ((List) (obj)).add(new e(2048, 2048));
        } else
        if (PicsartContext.b() <= 6)
        {
            ((List) (obj)).add(new e(1920, 1200));
            ((List) (obj)).add(new e(2560, 2048));
            ((List) (obj)).add(new e(2560, 1440));
            ((List) (obj)).add(new e(2048, 1536));
            ((List) (obj)).add(new e(2560, 2560));
        } else
        if (PicsartContext.b() <= 7)
        {
            ((List) (obj)).add(new e(1920, 1200));
            ((List) (obj)).add(new e(2560, 2048));
            ((List) (obj)).add(new e(2560, 1440));
            ((List) (obj)).add(new e(3000, 2000));
            ((List) (obj)).add(new e(2048, 1536));
            ((List) (obj)).add(new e(2560, 2560));
        } else
        {
            ((List) (obj)).add(new e(1920, 1200));
            ((List) (obj)).add(new e(2560, 2048));
            ((List) (obj)).add(new e(3840, 2160));
            ((List) (obj)).add(new e(3456, 2304));
            ((List) (obj)).add(new e(2048, 1536));
            ((List) (obj)).add(new e(2560, 2560));
        }
        if (c(851, 315))
        {
            ((List) (obj)).add(new e((new StringBuilder()).append(getResources().getString(0x7f08026b)).append(" (851 x 315").append(")").toString(), 851, 315));
        }
        if (c(i, k))
        {
            ((List) (obj)).add(new e((new StringBuilder()).append(getResources().getString(0x7f080577)).append(" (").append(i).append(" x ").append(k).append(")").toString(), i, k));
        }
        if (c(1920, 1080))
        {
            ((List) (obj)).add(new e((new StringBuilder()).append(getResources().getString(0x7f080285)).append(" (1920 x 1080").append(")").toString(), 1920, 1080));
        }
        as = new String[((List) (obj)).size()];
        obj1 = ((List) (obj)).iterator();
        for (int j = 0; ((Iterator) (obj1)).hasNext(); j++)
        {
            as[j] = ((e)((Iterator) (obj1)).next()).a;
        }

        ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), ((List) (obj)), as) {

            private String a[];

            public final View getView(int l, View view, ViewGroup viewgroup1)
            {
                view = super.getView(l, view, viewgroup1);
                getItem(l);
                view.setId(0x7f100032);
                ((TextView)view).setText(a[l]);
                return view;
            }

            
            {
                a = as;
                super(context, 0x7f03024f, list);
            }
        };
        obj = new android.widget.AdapterView.OnItemClickListener(((List) (obj)), viewgroup, bundle) {

            private List a;
            private ImageButton b;
            private ImageButton c;
            private SelectCanvasSizeDialog d;

            public final void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                adapterview = (e)a.get(l);
                SelectCanvasSizeDialog.a(d).setText(String.valueOf(((e) (adapterview)).b));
                com.socialin.android.photo.draw.dialog.SelectCanvasSizeDialog.b(d).setText(String.valueOf(((e) (adapterview)).c));
                if (com.socialin.android.photo.draw.dialog.SelectCanvasSizeDialog.b(((e) (adapterview)).b, ((e) (adapterview)).c) == ImageOrientation.PORTRAIT)
                {
                    SelectCanvasSizeDialog.a(b, false);
                    SelectCanvasSizeDialog.a(c, true);
                    return;
                } else
                {
                    SelectCanvasSizeDialog.a(b, true);
                    SelectCanvasSizeDialog.a(c, false);
                    return;
                }
            }

            
            {
                d = SelectCanvasSizeDialog.this;
                a = list;
                b = imagebutton;
                c = imagebutton1;
                super();
            }
        };
        obj1 = (Button)layoutinflater.findViewById(0x7f1007e2);
        ((Button) (obj1)).setOnClickListener(new android.view.View.OnClickListener(((Button) (obj1)), arrayadapter, ((android.widget.AdapterView.OnItemClickListener) (obj))) {

            final Button a;
            final ArrayAdapter b;
            final android.widget.AdapterView.OnItemClickListener c;
            final SelectCanvasSizeDialog d;

            public final void onClick(View view)
            {
                view = (InputMethodManager)d.getActivity().getSystemService("input_method");
                view.hideSoftInputFromWindow(SelectCanvasSizeDialog.a(d).getWindowToken(), 0);
                view.hideSoftInputFromWindow(com.socialin.android.photo.draw.dialog.SelectCanvasSizeDialog.b(d).getWindowToken(), 0);
                (new Handler()).postDelayed(new Runnable(this) {

                    private _cls5 a;

                    public final void run()
                    {
                        p p1 = WrappingListPopupWindow.a(a.d.getActivity());
                        p1.a = a.a;
                        p1.b = a.b;
                        p1.c = a.c;
                        p1.b();
                    }

            
            {
                a = _pcls5;
                super();
            }
                }, 180L);
            }

            
            {
                d = SelectCanvasSizeDialog.this;
                a = button;
                b = arrayadapter;
                c = onitemclicklistener;
                super();
            }
        });
        viewgroup.setOnClickListener(new android.view.View.OnClickListener(viewgroup, bundle) {

            private ImageButton a;
            private ImageButton b;
            private SelectCanvasSizeDialog c;

            public final void onClick(View view)
            {
                SelectCanvasSizeDialog.a(a, true);
                SelectCanvasSizeDialog.a(b, false);
                try
                {
                    int i1 = Integer.parseInt(SelectCanvasSizeDialog.a(c).getText().toString());
                    int j1 = Integer.parseInt(com.socialin.android.photo.draw.dialog.SelectCanvasSizeDialog.b(c).getText().toString());
                    int l = Math.max(i1, j1);
                    i1 = Math.min(i1, j1);
                    SelectCanvasSizeDialog.a(c, l, i1);
                    SelectCanvasSizeDialog.a(c).setText(Integer.toString(l));
                    com.socialin.android.photo.draw.dialog.SelectCanvasSizeDialog.b(c).setText(Integer.toString(i1));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    com.socialin.android.d.b(SelectCanvasSizeDialog.a(), new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(view.getMessage()).toString()
                    });
                }
                Toast.makeText(c.getActivity(), c.getString(0x7f08023d), 0).show();
            }

            
            {
                c = SelectCanvasSizeDialog.this;
                a = imagebutton;
                b = imagebutton1;
                super();
            }
        });
        bundle.setOnClickListener(new android.view.View.OnClickListener(viewgroup, bundle) {

            private ImageButton a;
            private ImageButton b;
            private SelectCanvasSizeDialog c;

            public final void onClick(View view)
            {
                SelectCanvasSizeDialog.a(a, false);
                SelectCanvasSizeDialog.a(b, true);
                try
                {
                    int i1 = Integer.parseInt(SelectCanvasSizeDialog.a(c).getText().toString());
                    int j1 = Integer.parseInt(com.socialin.android.photo.draw.dialog.SelectCanvasSizeDialog.b(c).getText().toString());
                    int l = Math.min(i1, j1);
                    i1 = Math.max(i1, j1);
                    SelectCanvasSizeDialog.a(c, l, i1);
                    SelectCanvasSizeDialog.a(c).setText(Integer.toString(l));
                    com.socialin.android.photo.draw.dialog.SelectCanvasSizeDialog.b(c).setText(Integer.toString(i1));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    com.socialin.android.d.b(SelectCanvasSizeDialog.a(), new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(view.getMessage()).toString()
                    });
                }
                Toast.makeText(c.getActivity(), c.getString(0x7f08023d), 0).show();
            }

            
            {
                c = SelectCanvasSizeDialog.this;
                a = imagebutton;
                b = imagebutton1;
                super();
            }
        });
        return layoutinflater;
    }


    private class ImageOrientation extends Enum
    {

        private static final ImageOrientation $VALUES[];
        public static final ImageOrientation LANDSCAPE;
        public static final ImageOrientation PORTRAIT;

        public static ImageOrientation valueOf(String s)
        {
            return (ImageOrientation)Enum.valueOf(com/socialin/android/photo/draw/dialog/SelectCanvasSizeDialog$ImageOrientation, s);
        }

        public static ImageOrientation[] values()
        {
            return (ImageOrientation[])$VALUES.clone();
        }

        static 
        {
            PORTRAIT = new ImageOrientation("PORTRAIT", 0);
            LANDSCAPE = new ImageOrientation("LANDSCAPE", 1);
            $VALUES = (new ImageOrientation[] {
                PORTRAIT, LANDSCAPE
            });
        }

        private ImageOrientation(String s, int i)
        {
            super(s, i);
        }
    }

}
