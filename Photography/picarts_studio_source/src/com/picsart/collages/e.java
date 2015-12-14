// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.l;
import com.picsart.effects.view.WrappingSlidingDrawer;
import com.picsart.shop.a;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.activity.StandaloneCropToolActivity;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.activity.SaveToSdCardDialogActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.colorpicker.c;
import com.socialin.android.colorpicker.f;
import com.socialin.android.colorpicker.g;
import com.socialin.android.d;
import com.socialin.android.dialog.CancelDialogActivity;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.photo.clipart.SelectClipArtFrameActivity;
import com.socialin.android.photo.collage.SelectCollageBgActivity;
import com.socialin.android.photo.effects.activity.EffectsActivityNew;
import com.socialin.android.photo.template.Template;
import com.socialin.android.photo.template.TemplateImage;
import com.socialin.android.photo.view.ColorPickerPreview;
import com.socialin.android.picsart.profile.invite.i;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import com.socialin.gson.Gson;
import com.socialin.gson.GsonBuilder;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package com.picsart.collages:
//            CollageCreatorView, a, CollageImage, b, 
//            SPArrow, ControlPoint, CollageCellItem, CollagesActivity, 
//            c, g, f, SelectCollageActivity

public final class e extends Fragment
{

    CollageCreatorView a;
    String b;
    private String c;
    private float d;
    private SeekBar e;
    private SeekBar f;
    private View g;
    private String h[];
    private int i[];
    private float j;
    private int k;
    private View l;
    private TextView m;
    private TextView n;
    private Bitmap o;
    private int p;
    private Template q;
    private ColorPickerPreview r;
    private com.picsart.collages.b s;
    private com.socialin.android.dialog.g t;
    private boolean u;
    private float v;
    private float w;

    public e()
    {
        a = null;
        c = "";
        d = 0.0F;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = 0.0F;
        k = 12;
        l = null;
        m = null;
        n = null;
        o = null;
        p = 0;
        q = null;
        s = null;
        t = null;
        u = false;
        v = 0.0F;
        w = 0.0F;
    }

    static float a(e e1, float f1)
    {
        e1.d = f1;
        return f1;
    }

    private static TemplateImage a(TemplateImage templateimage, float f1)
    {
        TemplateImage templateimage1 = new TemplateImage();
        templateimage1.a = templateimage.a * f1;
        templateimage1.b = templateimage.b * f1;
        templateimage1.d = templateimage.d * f1;
        templateimage1.e = templateimage.e * f1;
        templateimage1.c = templateimage.c;
        return templateimage1;
    }

    static String a(e e1)
    {
        return e1.b;
    }

    private void a(Bundle bundle)
    {
        p = bundle.getInt("collageType");
        c = bundle.getString("selectedCollagePath");
        q = (Template)bundle.getParcelable("collageTemplate");
        i = bundle.getIntArray("degrees");
        h = bundle.getStringArray("bitmapPaths");
        if (a != null)
        {
            a.setActiveCellIndex(bundle.getInt("selectedCellIndex"));
        }
        j = (int)bundle.getFloat("borderWidth");
    }

    static void a(e e1, int i1)
    {
        Iterator iterator = e1.a.b.iterator();
        float f1 = 3.402823E+38F;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            float f2 = ((com.picsart.collages.a)iterator.next()).u;
            if (f1 > f2)
            {
                f1 = f2;
            }
        } while (true);
        e1.j = ((float)i1 / 100F) * f1;
        if (e1.p == 1)
        {
            e1.a.setStrokeWidth(e1.j);
            e1.a.setBorderWidth(e1.j);
        } else
        {
            e1.a.setStrokeWidth(0.0F);
            e1.a.setBorderWidth(0.0F);
        }
        e1.n.setText(String.valueOf(i1));
        e1.k = i1;
    }

    static void a(e e1, Intent intent, int i1)
    {
        if (e1.p == 2 && i1 == 1)
        {
            e1.a.setBackgroundBitmap(null, null);
        }
        e1.p = i1;
        e1.a.setControlsVisible(false);
        e1.a.setControls(new ArrayList());
        e1.g.findViewById(0x7f1002a8).setSelected(false);
        Iterator iterator = e1.a.b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.picsart.collages.a a1 = (com.picsart.collages.a)iterator.next();
            if (a1.d != null)
            {
                a1.a(null, true, null, false);
            }
        } while (true);
        int j1;
        int k1;
        int l1;
        int i2;
        if (intent.hasExtra("degrees"))
        {
            intent = intent.getIntArrayExtra("degrees");
        } else
        {
            intent = e1.i;
        }
        e1.i = intent;
        if (e1.i == null)
        {
            e1.i = new int[0];
        }
        e1.a.b.clear();
        e1.d();
        i2 = e1.a.b.size();
        l1 = e1.a.d();
        k1 = 0;
        i1 = 0;
        do
        {
            j1 = i1;
            if (k1 >= l1)
            {
                break;
            }
            intent = (CollageImage)e1.a.s.get(Integer.valueOf(k1));
            if (i1 < i2)
            {
                j1 = i1;
                if (intent != null)
                {
                    e1.a.setImageToCell(intent, i1, false, null, true);
                    j1 = i1 + 1;
                }
            } else
            {
                e1.a.s.put(Integer.valueOf(i1), intent);
                j1 = i1 + 1;
            }
            k1++;
            i1 = j1;
        } while (true);
        for (; j1 < l1; j1++)
        {
            e1.a.s.remove(Integer.valueOf(j1));
        }

        e1.a.setActiveCellIndex(-1);
        if (e1.s != null)
        {
            e1.s.b();
        }
        e1.a.invalidate();
    }

    static void a(e e1, Bundle bundle)
    {
        e1.a.b.clear();
        e1.a.setCornerRadiusPercent(0);
        e1.a.setBackgroundBitmap(null, null);
        e1.a.setCollageAspectRatio(1.0F);
        e1.w = bundle.getFloat("collageHeightInJson");
        e1.v = bundle.getFloat("collageWidthInJson");
        if (e1.a.q)
        {
            e1.a.setIsCollageFrame(false);
            e1.a.setBackgroundBitmap(null, null);
        }
        int i2 = bundle.getInt("cellsCount");
        bundle.getFloat("collageWidth");
        for (int i1 = 0; i1 < i2; i1++)
        {
            ArrayList arraylist = new ArrayList();
            int j2 = bundle.getInt((new StringBuilder("verticesCount")).append(i1).toString());
            for (int k1 = 0; k1 < j2; k1++)
            {
                arraylist.add((SPArrow)bundle.getSerializable((new StringBuilder("vertice")).append(i1).append("_").append(k1).toString()));
            }

            e1.a.a(arraylist);
        }

        e1.a.setCollageAspectRatio(bundle.getFloat("aspectRatio"));
        int l1 = bundle.getInt("controlsCount");
        ArrayList arraylist1 = new ArrayList();
        for (int j1 = 0; j1 < l1; j1++)
        {
            arraylist1.add((ControlPoint)bundle.getSerializable((new StringBuilder("control")).append(j1).toString()));
        }

        e1.a.setControls(arraylist1);
        if (arraylist1.isEmpty())
        {
            e1.g.findViewById(0x7f1002a8).setVisibility(8);
            return;
        } else
        {
            e1.g.findViewById(0x7f1002a8).setVisibility(0);
            return;
        }
    }

    static void a(e e1, c c1, int i1)
    {
        g g1 = new g();
        g1.a = c1;
        g1.f = i1;
        g1.c = false;
        e1 = g1.a(e1.getActivity());
        if (!e1.isShowing())
        {
            e1.show();
        }
    }

    static void a(e e1, boolean flag)
    {
        if (flag)
        {
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, -e1.l.getMeasuredHeight(), 0.0F);
            translateanimation.setDuration(300L);
            if (e1.l.getVisibility() != 0)
            {
                e1.l.setVisibility(0);
                e1.l.startAnimation(translateanimation);
            }
        } else
        if (e1.l.getVisibility() == 0)
        {
            TranslateAnimation translateanimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -e1.l.getMeasuredHeight());
            translateanimation1.setDuration(300L);
            translateanimation1.setAnimationListener(e1. new android.view.animation.Animation.AnimationListener() {

                private e a;

                public final void onAnimationEnd(Animation animation)
                {
                    com.picsart.collages.e.k(a).setVisibility(8);
                }

                public final void onAnimationRepeat(Animation animation)
                {
                }

                public final void onAnimationStart(Animation animation)
                {
                }

            
            {
                a = e.this;
                super();
            }
            });
            e1.l.startAnimation(translateanimation1);
            return;
        }
    }

    static int b(e e1, int i1)
    {
        e1.k = i1;
        return i1;
    }

    static CollageCreatorView b(e e1)
    {
        return e1.a;
    }

    private void b(Bundle bundle)
    {
        boolean flag = false;
        int i2 = a.b.size();
        bundle.putInt("cellsCount", i2);
        bundle.putFloat("aspectRatio", a.i);
        bundle.putFloat("collageWidth", a.getWidth());
        for (int i1 = 0; i1 < i2; i1++)
        {
            com.picsart.collages.a a1 = a.a(i1);
            int j2 = a1.a.size();
            bundle.putInt((new StringBuilder("verticesCount")).append(i1).toString(), j2);
            bundle.putFloat((new StringBuilder("cellItemWidth")).append(i1).toString(), a1.e.width());
            bundle.putFloat((new StringBuilder("cellItemHeight")).append(i1).toString(), a1.e.height());
            int k1 = 0;
            while (k1 < j2) 
            {
                SPArrow sparrow = (SPArrow)a1.b.get(k1);
                float f1 = sparrow.getLength();
                String s1 = (new StringBuilder("vertice")).append(i1).append("_").append(k1).toString();
                if (f1 == 0.0F)
                {
                    sparrow = SPArrow.getInstance().setXY(0.0F, 0.0F);
                } else
                {
                    sparrow = SPArrow.getInstance().setXY(sparrow.getX(), sparrow.getY());
                }
                bundle.putSerializable(s1, sparrow);
                k1++;
            }
        }

        ArrayList arraylist = a.m;
        if (arraylist != null && arraylist.size() > 0)
        {
            int l1 = arraylist.size();
            bundle.putInt("controlsCount", l1);
            for (int j1 = ((flag) ? 1 : 0); j1 < l1; j1++)
            {
                bundle.putSerializable((new StringBuilder("control")).append(j1).toString(), (Serializable)arraylist.get(j1));
            }

        }
    }

    static void b(e e1, Bundle bundle)
    {
        String as[] = bundle.getStringArray("selectedItems");
        e1.i = bundle.getIntArray("selectedItemsDegrees");
        bundle = e1.a.b;
        int k1 = bundle.size();
        int l1 = as.length;
        int j1 = 0;
        for (int i1 = 0; j1 < k1 && i1 < l1; j1++)
        {
            com.picsart.collages.a a1 = (com.picsart.collages.a)bundle.get(j1);
            if (a1.d == null && !a1.v && e1.a.d != j1)
            {
                e1.a.setImageToCell(new CollageImage(false, as[i1], null, e1.i[i1]), j1, false, null, true);
                i1++;
            }
        }

    }

    private void c()
    {
        String s1;
        s1 = a.n;
        a.b.clear();
        a.setCornerRadiusPercent(0);
        a.setBackgroundBitmap(null, null);
        if (a.q)
        {
            a.setIsCollageFrame(false);
            a.setBackgroundBitmap(null, null);
        }
        Object obj;
        obj = getResources().getAssets().open(c);
        byte abyte0[] = new byte[((InputStream) (obj)).available()];
        ((InputStream) (obj)).read(abyte0);
        obj = new String(abyte0);
        obj = (CollageCellItem)(new GsonBuilder()).create().fromJson(((String) (obj)), com/picsart/collages/CollageCellItem);
        if (((CollageCellItem) (obj)).controls != null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L5:
        ArrayList arraylist = new ArrayList();
        int j1 = 0;
_L4:
        if (j1 >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(new ControlPoint(((CollageCellItem) (obj)).controls[j1]));
        j1++;
        if (true) goto _L4; else goto _L3
_L2:
        i1 = ((CollageCellItem) (obj)).controls.length;
          goto _L5
_L3:
        int k1;
        k1 = ((CollageCellItem) (obj)).paths.length;
        v = a.b();
        w = v;
        i1 = 0;
_L9:
        if (i1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        String as[];
        ArrayList arraylist1;
        as = ((CollageCellItem) (obj)).paths[i1].split(" ");
        arraylist1 = new ArrayList();
        j1 = 0;
_L7:
        if (j1 >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        String as1[] = as[j1].split(",");
        float f1 = Float.parseFloat(as1[0]);
        float f2 = Float.parseFloat(as1[1]);
        arraylist1.add(SPArrow.getInstance().setXY(f1, f2));
        j1++;
        if (true) goto _L7; else goto _L6
_L6:
        a.a(arraylist1);
        i1++;
        if (true) goto _L9; else goto _L8
_L8:
        g.findViewById(0x7f1002a2).setVisibility(0);
        a.setControls(arraylist);
        a.setCollageAspectRatio(((CollageCellItem) (obj)).width / ((CollageCellItem) (obj)).height);
        if (!arraylist.isEmpty()) goto _L11; else goto _L10
_L10:
        g.findViewById(0x7f1002a8).setVisibility(8);
_L13:
        a.post(new Runnable() {

            private e a;

            public final void run()
            {
                com.picsart.collages.e.a(a, e.q(a));
                com.picsart.collages.e.j(a).setProgress(e.q(a));
            }

            
            {
                a = e.this;
                super();
            }
        });
        f.setProgress(0);
        if (!TextUtils.isEmpty(s1))
        {
            a(s1);
        }
        return;
_L11:
        try
        {
            g.findViewById(0x7f1002a8).setVisibility(0);
        }
        catch (Exception exception)
        {
            com.socialin.android.d.a(exception.getMessage(), exception);
        }
        if (true) goto _L13; else goto _L12
_L12:
    }

    static void c(e e1)
    {
        Activity activity = e1.getActivity();
        if (activity == null || activity.isFinishing()) goto _L2; else goto _L1
_L1:
        String s1;
        int i1;
        s1 = (new StringBuilder()).append(com.socialin.android.util.w.a(e1.getResources().getString(0x7f08096b), activity).getAbsolutePath()).append("/").append(System.currentTimeMillis()).toString();
        i1 = activity.getWindowManager().getDefaultDisplay().getRotation();
        e1.getResources().getConfiguration().orientation;
        JVM INSTR tableswitch 1 2: default 104
    //                   1 140
    //                   2 167;
           goto _L3 _L4 _L5
_L3:
        if (!e1.t.isShowing())
        {
            e1.t.show();
        }
        e1.a.a(activity, s1, e1. new com.picsart.collages.f(activity) {

            private Activity a;
            private e b;

            public final void a(String s2)
            {
                com.picsart.collages.e.b(b).setChanged(false);
                x.a();
                s2 = x.a(s2);
                Intent intent = new Intent();
                if (!e.t(b))
                {
                    intent.putExtra("path", s2);
                    intent.putExtra("origin", "collage");
                    com.picsart.collages.e.l(b).dismiss();
                    a.setResult(-1, intent);
                    e.u(b);
                    return;
                } else
                {
                    intent.setClass(a, com/picsart/studio/editor/activity/EditorActivity);
                    intent.putExtra("path", s2);
                    intent.putExtra("origin", "collage");
                    intent.putExtra("degree", 0);
                    intent.putExtra("mode", 0);
                    b.startActivity(intent);
                    e.u(b);
                    return;
                }
            }

            
            {
                b = e.this;
                a = activity;
                super();
            }
        });
_L2:
        return;
_L4:
        if (i1 == 1 || i1 == 2)
        {
            activity.setRequestedOrientation(9);
        } else
        {
            activity.setRequestedOrientation(1);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (i1 == 0 || i1 == 1)
        {
            activity.setRequestedOrientation(0);
        } else
        {
            activity.setRequestedOrientation(8);
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

    static ColorPickerPreview d(e e1)
    {
        return e1.r;
    }

    private void d()
    {
        p;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 777
    //                   2 29;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        a.setBorderWidth(0.0F);
        a.setStrokeWidth(0.0F);
        a.setCornerRadiusPercent(0);
        a.b.clear();
        a.setBackgroundBitmap(null, null);
        if (!q.o) goto _L5; else goto _L4
_L4:
        Object obj = null;
        Object obj1 = com.picsart.shop.a.a(getActivity()).a(q.p, q.h);
        obj = obj1;
_L11:
        int i1;
        int j1;
        o = BitmapFactory.decodeStream(((InputStream) (obj)));
        com.socialin.android.util.w.a(getActivity().getApplicationContext().getExternalCacheDir().getPath(), "frameTemp", o, getActivity(), android.graphics.Bitmap.CompressFormat.PNG, true);
        obj = (new StringBuilder()).append(getActivity().getApplicationContext().getExternalCacheDir().getPath()).append("/frameTemp").toString();
        j1 = o.getWidth();
        i1 = o.getHeight();
_L12:
        float f1;
        float f2;
        f1 = j1;
        f2 = i1;
        a.setIsCollageFrame(true);
        g.findViewById(0x7f1002a2).setVisibility(8);
        a.setBackgroundBitmap(o, ((String) (obj)));
        j1 = q.f.size();
        i1 = 0;
_L10:
        if (i1 >= j1) goto _L7; else goto _L6
_L6:
        obj1 = (TemplateImage)q.f.get(i1);
        if (o.getWidth() <= 2048 && o.getHeight() <= 2048) goto _L9; else goto _L8
_L8:
        obj = a(((TemplateImage) (obj1)), 5F);
_L16:
        float f3 = ((TemplateImage) (obj)).a / f1;
        float f4 = ((TemplateImage) (obj)).b / f2;
        float f5 = ((TemplateImage) (obj)).d / f1;
        float f6 = ((TemplateImage) (obj)).e / f2;
        double d1 = ((TemplateImage) (obj)).c;
        obj = new ArrayList();
        obj1 = SPArrow.getInstance().setXY(f3, f4);
        SPArrow sparrow = SPArrow.getInstance().setXY(f3, f4 + f6);
        SPArrow sparrow1 = SPArrow.getInstance().setXY(f3 + f5, f6 + f4);
        SPArrow sparrow2 = SPArrow.getInstance().setXY(f3 + f5, f4);
        ((ArrayList) (obj)).add(obj1);
        ((ArrayList) (obj)).add(sparrow);
        ((ArrayList) (obj)).add(sparrow1);
        ((ArrayList) (obj)).add(sparrow2);
        obj1 = a;
        o.getWidth();
        o.getHeight();
        obj = ((CollageCreatorView) (obj1)).a(((ArrayList) (obj)));
        obj.q = (float)d1;
        ((com.picsart.collages.a) (obj)).b(Math.max(f1, f2));
        i1++;
          goto _L10
        obj1;
        ((Exception) (obj1)).printStackTrace();
          goto _L11
_L5:
        int k1;
        obj = com.socialin.android.util.w.a(q.g);
        j1 = ((android.graphics.BitmapFactory.Options) (obj)).outWidth;
        k1 = ((android.graphics.BitmapFactory.Options) (obj)).outHeight;
        obj = q.g;
        o = com.socialin.android.util.w.a(q.g, Math.max(j1, k1), Math.max(j1, k1), 0);
        i1 = k1;
          goto _L12
        obj1;
_L20:
        i1 = 2;
_L13:
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_651;
        }
        o = com.socialin.android.util.w.a(q.g, Math.max(j1, k1), Math.max(j1, k1), 0);
_L19:
        ((OutOfMemoryError) (obj1)).toString();
        i1 = k1;
          goto _L12
        Object obj2;
        obj2;
        i1--;
          goto _L13
_L9:
        if (o.getWidth() <= 1024 && o.getHeight() <= 1024) goto _L15; else goto _L14
_L14:
        obj = a(((TemplateImage) (obj1)), 3.2F);
          goto _L16
_L15:
        if (o.getWidth() > 640) goto _L18; else goto _L17
_L17:
        obj = obj1;
        if (o.getHeight() <= 640) goto _L16; else goto _L18
_L18:
        obj = a(((TemplateImage) (obj1)), 1.6F);
          goto _L16
_L7:
        try
        {
            a.setCollageAspectRatio(f1 / f2);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return;
_L2:
        c();
        return;
        obj2;
          goto _L19
        obj1;
        exception = "";
          goto _L20
    }

    private void e()
    {
        if (getActivity() != null && !getActivity().isFinishing())
        {
            com.socialin.android.picsart.profile.invite.i.a(getActivity()).edit().putBoolean("is_editor_active", false).apply();
            getActivity().finish();
        }
    }

    static void e(e e1)
    {
        Intent intent = new Intent(e1.getActivity(), com/socialin/android/photo/collage/SelectCollageBgActivity);
        intent.putExtra("showColorPanel", false);
        intent.putExtra("showGalleryPanel", true);
        e1.startActivityForResult(intent, 1004);
    }

    static TextView f(e e1)
    {
        return e1.m;
    }

    static void g(e e1)
    {
        String s1 = null;
        Object obj = e1.a.e();
        if (obj == null || e1.a.j || ((com.picsart.collages.a) (obj)).x == null || ((com.picsart.collages.a) (obj)).d == null || ((com.picsart.collages.a) (obj)).d.isRecycled())
        {
            return;
        }
        int i1;
        for (i1 = e1.a.e().e() + e1.a.e().w; i1 < 0; i1 += 360) { }
        int j1;
        if (e1.a.e().x.isFromBuffer())
        {
            obj = e1.a.e().x.getBufferData();
        } else
        {
            s1 = e1.a.e().x.getPath();
            obj = null;
        }
        j1 = PicsartContext.a.getCollageImageMaxSize();
        e1.startActivityForResult(EffectsActivityNew.a(e1.getActivity(), "collage", ((HashMap) (obj)), s1, i1, j1 * j1), 1002);
    }

    static float h(e e1)
    {
        return e1.j;
    }

    static TextView i(e e1)
    {
        return e1.n;
    }

    static SeekBar j(e e1)
    {
        return e1.e;
    }

    static View k(e e1)
    {
        return e1.l;
    }

    static com.socialin.android.dialog.g l(e e1)
    {
        return e1.t;
    }

    static int m(e e1)
    {
        return e1.p;
    }

    static void n(e e1)
    {
        e1.d();
    }

    static float o(e e1)
    {
        return e1.d;
    }

    static SeekBar p(e e1)
    {
        return e1.f;
    }

    static int q(e e1)
    {
        return e1.k;
    }

    static int[] r(e e1)
    {
        return e1.i;
    }

    static com.picsart.collages.b s(e e1)
    {
        return e1.s;
    }

    static boolean t(e e1)
    {
        return e1.u;
    }

    static void u(e e1)
    {
        e1.e();
    }

    public final void a()
    {
        if (a.r)
        {
            startActivityForResult(new Intent(getActivity(), com/socialin/android/dialog/CancelDialogActivity), 1007);
            return;
        }
        if (b())
        {
            com.socialin.android.picsart.profile.invite.i.a(getActivity(), "close");
        }
        if (getActivity() instanceof CollagesActivity)
        {
            ((CollagesActivity)getActivity()).executeInviteNotificaionAction();
        }
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CollageCreateSecreenActionEvent(b, "close"));
        e();
    }

    public final void a(String s1)
    {
        com.bumptech.glide.b.b(getActivity().getApplicationContext()).i().a((new StringBuilder("file://")).append(s1).toString()).a(0.1F).a(com.bumptech.glide.request.e.b(l.e)).a((ImageView)g.findViewById(0x7f1002ae));
        a.post(new Runnable(s1) {

            final String a;
            final e b;

            public final void run()
            {
                (new AsyncTask(this) {

                    private _cls28 a;

                    private transient Bitmap a()
                    {
                        int i1 = (int)com.picsart.collages.e.b(a.b).a(0).o;
                        Bitmap bitmap;
                        try
                        {
                            bitmap = com.socialin.android.util.w.a(a.a, i1, i1, myobfuscated.f.m.d(a.a));
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                            return null;
                        }
                        return bitmap;
                    }

                    protected final Object doInBackground(Object aobj[])
                    {
                        return a();
                    }

                    protected final void onPostExecute(Object obj)
                    {
                        obj = (Bitmap)obj;
                        com.picsart.collages.e.b(a.b).setBackgroundBitmap(((Bitmap) (obj)), a.a);
                        com.picsart.collages.e.b(a.b).invalidate();
                    }

            
            {
                a = _pcls28;
                super();
            }
                }).execute(new String[] {
                    a
                });
            }

            
            {
                b = e.this;
                a = s1;
                super();
            }
        });
    }

    public final boolean b()
    {
        if (getActivity() instanceof AdBaseActivity)
        {
            return ((AdBaseActivity)getActivity()).isShowEnjoyDialog();
        } else
        {
            return false;
        }
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        t = new com.socialin.android.dialog.g(getActivity());
        if (bundle == null)
        {
            if (p == 0)
            {
                Intent intent = getActivity().getIntent();
                p = intent.getIntExtra("cType", 0);
                u = intent.getBooleanExtra("isAutomatically", false);
                c = intent.getStringExtra("collagePath");
                h = intent.getStringArrayExtra("paths");
                i = intent.getIntArrayExtra("degrees");
                q = (Template)intent.getParcelableExtra("collageTemplate");
            }
        } else
        {
            a(bundle);
        }
        if (h == null)
        {
            h = new String[0];
        }
        if (i == null)
        {
            i = new int[0];
        }
        if (a.b == null || a.b.size() == 0)
        {
            a.post(new Runnable(bundle) {

                private Bundle a;
                private e b;

                public final void run()
                {
                    float f2 = 0.0F;
                    com.picsart.collages.e.l(b).show();
                    float f1;
                    Object obj;
                    int i1;
                    if (com.picsart.collages.e.b(b).b == null || com.picsart.collages.e.b(b).b.isEmpty())
                    {
                        if (a == null || com.picsart.collages.e.m(b) == 2)
                        {
                            e.n(b);
                            i1 = 1;
                        } else
                        {
                            com.picsart.collages.e.a(b, a);
                            i1 = 1;
                        }
                    } else
                    {
                        i1 = 0;
                    }
                    obj = com.picsart.collages.e.b(b).b.iterator();
                    f1 = 3.402823E+38F;
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        float f3 = ((com.picsart.collages.a)((Iterator) (obj)).next()).u;
                        if (f1 > f3)
                        {
                            f1 = f3;
                        }
                    } while (true);
                    com.picsart.collages.e.a(b, f1 * (e.o(b) / 100F));
                    obj = com.picsart.collages.e.b(b);
                    if (com.picsart.collages.e.m(b) == 2)
                    {
                        f1 = 0.0F;
                    } else
                    {
                        f1 = e.o(b);
                    }
                    ((CollageCreatorView) (obj)).setStrokeWidth(f1);
                    obj = com.picsart.collages.e.b(b);
                    if (com.picsart.collages.e.m(b) == 2)
                    {
                        f1 = 0.0F;
                    } else
                    {
                        f1 = e.o(b);
                    }
                    ((CollageCreatorView) (obj)).setBorderWidth(f1);
                    if (a != null)
                    {
                        a.getInt("count");
                        int j1 = a.getInt("activeCellIndex");
                        int l1 = a.getInt("cornerRadius");
                        com.picsart.collages.e.b(b).setActiveCellIndex(j1);
                        if (i1 != 0)
                        {
                            Object obj1 = com.picsart.collages.e.b(b);
                            f1 = f2;
                            if (com.picsart.collages.e.m(b) == 1)
                            {
                                f1 = a.getFloat("borderWidth");
                            }
                            ((CollageCreatorView) (obj1)).setBorderWidth(f1);
                            com.picsart.collages.e.j(b).setProgress((int)e.h(b));
                            com.picsart.collages.e.b(b).setCornerRadiusPercent(l1);
                            e.p(b).setProgress(l1);
                            com.picsart.collages.e.b(b).setCollageRotateAngle(a.getInt("rotateAngle"));
                            com.picsart.collages.e.b(b, a.getInt("borderWidthProgress"));
                            com.picsart.collages.e.a(b, e.q(b));
                            HashMap hashmap;
                            Matrix matrix;
                            float af[];
                            int k1;
                            if (TextUtils.isEmpty(com.picsart.collages.e.b(b).n))
                            {
                                if (!TextUtils.isEmpty(a.getString("bgImagePath")))
                                {
                                    b.a(a.getString("bgImagePath"));
                                } else
                                {
                                    com.picsart.collages.e.b(b).setBackgroundColor(a.getInt("bgImageColor"));
                                }
                            }
                        }
                        obj1 = com.picsart.collages.e.b(b).b;
                        k1 = a.getInt("imagesCount");
                        hashmap = (HashMap)a.getSerializable("importedImages");
                        i1 = 0;
                        while (i1 < k1) 
                        {
                            matrix = new Matrix();
                            af = a.getFloatArray((new StringBuilder("matrix")).append(i1).toString());
                            if (af != null)
                            {
                                matrix.setValues(af);
                            }
                            CollageImage collageimage = (CollageImage)hashmap.get(Integer.valueOf(i1));
                            if (i1 < ((List) (obj1)).size())
                            {
                                if (collageimage != null)
                                {
                                    ((com.picsart.collages.a)((List) (obj1)).get(i1)).v = true;
                                    ((com.picsart.collages.a)((List) (obj1)).get(i1)).i = matrix;
                                    com.picsart.collages.e.b(b).setImageToCell(collageimage, i1, true, matrix, true);
                                }
                            } else
                            {
                                com.picsart.collages.e.b(b).s.put(Integer.valueOf(i1), collageimage);
                            }
                            i1++;
                        }
                    }
                    com.picsart.collages.e.l(b).dismiss();
                    if (b.getActivity() != null && b.getActivity().getIntent() != null && b.getActivity().getIntent().getIntExtra("itemsCount", 0) > 0)
                    {
                        com.picsart.collages.e.b(b, b.getActivity().getIntent().getExtras());
                    }
                }

            
            {
                b = e.this;
                a = bundle;
                super();
            }
            });
            return;
        } else
        {
            a.post(new Runnable() {

                private e a;

                public final void run()
                {
                    com.picsart.collages.e.l(a).show();
                    CollageCreatorView collagecreatorview = com.picsart.collages.e.b(a);
                    float f1 = collagecreatorview.b();
                    for (Iterator iterator = collagecreatorview.b.iterator(); iterator.hasNext(); ((com.picsart.collages.a)iterator.next()).b(f1)) { }
                    float f2;
                    if (collagecreatorview.b.size() > 0)
                    {
                        com.picsart.collages.a a1 = (com.picsart.collages.a)collagecreatorview.b.get(0);
                        f1 = a1.k;
                        f2 = a1.l;
                    } else
                    {
                        f1 = 0.0F;
                        f2 = 0.0F;
                    }
                    collagecreatorview.g.set(0.0F, 0.0F, f1 + (collagecreatorview.e + collagecreatorview.f) * 2.0F, f2 + (collagecreatorview.e + collagecreatorview.f) * 2.0F);
                    if (collagecreatorview.k != null)
                    {
                        collagecreatorview.l.set(0, 0, collagecreatorview.k.getWidth(), collagecreatorview.k.getHeight());
                        if ((float)collagecreatorview.k.getWidth() < collagecreatorview.g.width() || (float)collagecreatorview.k.getHeight() < collagecreatorview.g.height())
                        {
                            f2 = Math.max(collagecreatorview.g.width() / (float)collagecreatorview.k.getWidth(), collagecreatorview.g.height() / (float)collagecreatorview.k.getHeight());
                            f1 = (float)collagecreatorview.k.getWidth() * f2;
                            f2 *= collagecreatorview.k.getHeight();
                            collagecreatorview.h.set((collagecreatorview.g.width() - f1) / 2.0F, (collagecreatorview.g.height() - f2) / 2.0F, (f1 + collagecreatorview.g.width()) / 2.0F, (f2 + collagecreatorview.g.height()) / 2.0F);
                        } else
                        {
                            RectF rectf = collagecreatorview.h;
                            f1 = (collagecreatorview.g.width() - (float)collagecreatorview.k.getWidth()) / 2.0F;
                            f2 = (collagecreatorview.g.height() - (float)collagecreatorview.k.getHeight()) / 2.0F;
                            float f3 = (collagecreatorview.g.width() + (float)collagecreatorview.k.getWidth()) / 2.0F;
                            float f4 = collagecreatorview.g.height();
                            rectf.set(f1, f2, f3, ((float)collagecreatorview.k.getHeight() + f4) / 2.0F);
                        }
                    }
                    com.picsart.collages.e.a(a, e.q(a));
                    com.picsart.collages.e.l(a).dismiss();
                }

            
            {
                a = e.this;
                super();
            }
            });
            return;
        }
    }

    public final void onActivityResult(int i1, int j1, Intent intent)
    {
        Object obj;
        boolean flag;
        flag = false;
        obj = null;
        super.onActivityResult(i1, j1, intent);
        if (j1 != -1) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR lookupswitch 11: default 116
    //                   49: 1272
    //                   1001: 929
    //                   1002: 1090
    //                   1003: 1125
    //                   1004: 1211
    //                   1006: 1240
    //                   1007: 117
    //                   1008: 810
    //                   1010: 1171
    //                   1230: 1272
    //                   1231: 1272;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L4 _L4
_L28:
        return;
_L10:
        intent = intent.getExtras().getString("button");
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CollageCreateSecreenActionEvent(b, "close"));
        intent.hashCode();
        JVM INSTR lookupswitch 6: default 216
    //                   -1727082830: 330
    //                   11576841: 299
    //                   1111669925: 375
    //                   1293361956: 360
    //                   1318040329: 345
    //                   1391073851: 315;
           goto _L13 _L14 _L15 _L16 _L17 _L18 _L19
_L13:
        i1 = -1;
_L21:
        switch (i1)
        {
        default:
            return;

        case 0: // '\0'
            if (b())
            {
                com.socialin.android.picsart.profile.invite.i.a(getActivity(), "close");
            }
            if (getActivity() instanceof CollagesActivity)
            {
                ((CollagesActivity)getActivity()).executeInviteNotificaionAction();
            }
            e();
            return;

        case 1: // '\001'
            AnalyticUtils.getInstance(getActivity()).trackLocalAction("main:cancel_dialog_save");
            intent = getString(0x7f0808fb);
            obj = new Intent(getActivity().getApplicationContext(), com/socialin/android/activity/SaveToSdCardDialogActivity);
            ((Intent) (obj)).putExtra("fileName", null);
            ((Intent) (obj)).putExtra("subFolderName", intent);
            ((Intent) (obj)).putExtra("extension", null);
            ((Intent) (obj)).putExtra("isReturnResult", true);
            startActivityForResult(((Intent) (obj)), 1008);
            return;

        case 2: // '\002'
            intent = getActivity();
            if (intent != null && !intent.isFinishing())
            {
                obj = (new StringBuilder()).append(intent.getExternalCacheDir().getAbsolutePath()).append("/").append(System.currentTimeMillis()).toString();
                if (!t.isShowing())
                {
                    t.show();
                }
                a.a(intent, ((String) (obj)), new com.picsart.collages.f(intent) {

                    private Activity a;
                    private e b;

                    public final void a(String s2)
                    {
                        myobfuscated.cv.c.a(a, s2);
                        EditingData editingdata = EditingData.a(s2, "collage");
                        String s3;
                        if (SocialinV3.getInstance().isRegistered())
                        {
                            s3 = String.valueOf(SocialinV3.getInstance().getUser().id);
                        } else
                        {
                            s3 = null;
                        }
                        myobfuscated.f.m.a(s2, s3, editingdata.c().toString());
                        com.picsart.collages.e.b(b).setChanged(false);
                        com.picsart.collages.e.l(b).dismiss();
                        if (b.b())
                        {
                            com.socialin.android.picsart.profile.invite.i.a(b.getActivity(), "export");
                        }
                    }

            
            {
                b = e.this;
                a = activity;
                super();
            }
                });
                return;
            }
            break;

        case 3: // '\003'
            intent = getActivity();
            if (intent != null && !intent.isFinishing())
            {
                obj = (new StringBuilder()).append(intent.getExternalCacheDir().getAbsolutePath()).append("/").append(System.currentTimeMillis()).toString();
                if (!t.isShowing())
                {
                    t.show();
                }
                a.a(intent, ((String) (obj)), new com.picsart.collages.f() {

                    private e a;

                    public final void a(String s2)
                    {
                        com.picsart.collages.e.b(a).setChanged(false);
                        com.picsart.collages.e.l(a).dismiss();
                        FacebookUtils.startAdapterActivity(a.getActivity(), s2);
                        if (a.b())
                        {
                            com.socialin.android.picsart.profile.invite.i.a(a.getActivity(), "export");
                        }
                    }

            
            {
                a = e.this;
                super();
            }
                });
                return;
            }
            break;

        case 4: // '\004'
            intent = getActivity();
            if (intent != null && !intent.isFinishing())
            {
                obj = (new StringBuilder()).append(intent.getExternalCacheDir().getAbsolutePath()).append("/").append(System.currentTimeMillis()).toString();
                if (!t.isShowing())
                {
                    t.show();
                }
                a.a(intent, ((String) (obj)), new com.picsart.collages.f(intent) {

                    private Activity a;
                    private e b;

                    public final void a(String s2)
                    {
                        myobfuscated.cv.c.a(s2, a);
                        com.picsart.collages.e.b(b).setChanged(false);
                        com.picsart.collages.e.l(b).dismiss();
                        if (b.b())
                        {
                            com.socialin.android.picsart.profile.invite.i.a(b.getActivity(), "export");
                        }
                    }

            
            {
                b = e.this;
                a = activity;
                super();
            }
                });
                return;
            }
            break;

        case 5: // '\005'
            intent = getActivity();
            continue; /* Loop/switch isn't completed */
        }
        continue; /* Loop/switch isn't completed */
_L15:
        if (!intent.equals("button_ok")) goto _L13; else goto _L20
_L20:
        i1 = ((flag) ? 1 : 0);
          goto _L21
_L19:
        if (!intent.equals("button_saveSD")) goto _L13; else goto _L22
_L22:
        i1 = 1;
          goto _L21
_L14:
        if (!intent.equals("button_uploadToPicsinId")) goto _L13; else goto _L23
_L23:
        i1 = 2;
          goto _L21
_L18:
        if (!intent.equals("button_postFB")) goto _L13; else goto _L24
_L24:
        i1 = 3;
          goto _L21
_L17:
        if (!intent.equals("button_tweet")) goto _L13; else goto _L25
_L25:
        i1 = 4;
          goto _L21
_L16:
        if (!intent.equals("button_postInstagram")) goto _L13; else goto _L26
_L26:
        i1 = 5;
          goto _L21
_L3:
        if (true) goto _L28; else goto _L27
_L27:
        if (intent == null || intent.isFinishing()) goto _L28; else goto _L29
_L29:
        obj = (new StringBuilder()).append(intent.getExternalCacheDir().getAbsolutePath()).append("/").append(System.currentTimeMillis()).toString();
        a.a(intent, ((String) (obj)), new com.picsart.collages.f(intent) {

            private Activity a;
            private e b;

            public final void a(String s2)
            {
                myobfuscated.cv.c.a(a, s2);
                com.picsart.collages.e.b(b).setChanged(false);
            }

            
            {
                b = e.this;
                a = activity;
                super();
            }
        });
        return;
_L11:
        Object obj1 = intent.getExtras();
        intent = ((Bundle) (obj1)).getString("selectedFolderName");
        obj = ((Bundle) (obj1)).getString("selectedFileName");
        obj1 = ((Bundle) (obj1)).getString("fileExtension");
        if (!t.isShowing())
        {
            t.show();
        }
        a.a(getActivity(), (new StringBuilder()).append(intent).append("/").append(((String) (obj))).append(((String) (obj1))).toString(), new com.picsart.collages.f() {

            private e a;

            public final void a(String s2)
            {
                Toast.makeText(a.getActivity().getApplicationContext(), (new StringBuilder()).append(a.getString(0x7f080572)).append(" ").append(s2).toString(), 0).show();
                com.picsart.collages.e.b(a).setChanged(false);
                com.picsart.collages.e.l(a).dismiss();
            }

            
            {
                a = e.this;
                super();
            }
        });
        if (b())
        {
            com.socialin.android.picsart.profile.invite.i.a(getActivity(), "savetogallery");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (intent != null)
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CollageCreateSecreenActionEvent(b, "add_photo"));
            Bundle bundle = intent.getExtras();
            if (intent.hasExtra("selectedItems"))
            {
                intent = bundle.getStringArray("selectedItems");
                i = bundle.getIntArray("selectedItemsDegrees");
                a.post(new Runnable(intent) {

                    private String a[];
                    private e b;

                    public final void run()
                    {
                        ArrayList arraylist = com.picsart.collages.e.b(b).b;
                        int i2 = arraylist.size();
                        int j2 = a.length;
                        int k1;
                        int l1;
                        if (com.picsart.collages.e.b(b).d != -1 && com.picsart.collages.e.b(b).b != null && com.picsart.collages.e.b(b).b.size() > 0 && com.picsart.collages.e.b(b).e().d == null)
                        {
                            CollageImage collageimage = new CollageImage(false, a[0], null, e.r(b)[0]);
                            com.picsart.collages.e.b(b).setImageToCell(collageimage, com.picsart.collages.e.b(b).d, false, null, true);
                            e.s(b).a();
                            k1 = 1;
                        } else
                        {
                            k1 = 0;
                        }
                        for (l1 = 0; l1 < i2 && k1 < j2; l1++)
                        {
                            com.picsart.collages.a a1 = (com.picsart.collages.a)arraylist.get(l1);
                            if (a1.d == null && !a1.v && com.picsart.collages.e.b(b).d != l1)
                            {
                                com.picsart.collages.e.b(b).setImageToCell(new CollageImage(false, a[k1], null, e.r(b)[k1]), l1, false, null, true);
                                k1++;
                            }
                        }

                    }

            
            {
                b = e.this;
                a = as;
                super();
            }
                });
                return;
            }
            boolean flag1 = intent.hasExtra("bufferData");
            String s1 = bundle.getString("path");
            i1 = bundle.getInt("degree");
            intent = ((Intent) (obj));
            if (flag1)
            {
                intent = (HashMap)bundle.getSerializable("bufferData");
            }
            s.a();
            a.post(new Runnable(flag1, intent, s1, i1) {

                private boolean a;
                private HashMap b;
                private String c;
                private int d;
                private e e;

                public final void run()
                {
                    if (com.picsart.collages.e.b(e).d != -1 && com.picsart.collages.e.b(e).b != null && !com.picsart.collages.e.b(e).b.isEmpty())
                    {
                        CollageCreatorView collagecreatorview = com.picsart.collages.e.b(e);
                        boolean flag2;
                        if (a && b != null)
                        {
                            flag2 = true;
                        } else
                        {
                            flag2 = false;
                        }
                        collagecreatorview.setImageToCell(new CollageImage(flag2, c, b, d), com.picsart.collages.e.b(e).d, false, null, true);
                    }
                }

            
            {
                e = e.this;
                a = flag;
                b = hashmap;
                c = s1;
                d = i1;
                super();
            }
            });
            return;
        }
        if (true) goto _L28; else goto _L6
_L6:
        HashMap hashmap = (HashMap)intent.getExtras().getSerializable("bufferData");
        a.post(new Runnable(intent, hashmap) {

            private Intent a;
            private HashMap b;
            private e c;

            public final void run()
            {
                int k1 = com.picsart.collages.e.b(c).e().e();
                float f1 = com.picsart.collages.e.b(c).e().h;
                CollageImage collageimage = new CollageImage(true, a.getExtras().getString("path"), b, 0);
                com.picsart.collages.e.b(c).e().b(f1 - (float)k1 - (float)com.picsart.collages.e.b(c).e().w, com.picsart.collages.e.b(c).e().j.getX(), com.picsart.collages.e.b(c).e().j.getY());
                com.picsart.collages.e.b(c).setImageToCell(collageimage, com.picsart.collages.e.b(c).d, true, com.picsart.collages.e.b(c).e().i, true, new myobfuscated.ax.a(k1));
            }

            
            {
                c = e.this;
                a = intent;
                b = hashmap;
                super();
            }
        });
        return;
_L7:
        HashMap hashmap1 = (HashMap)intent.getExtras().getSerializable("bufferData");
        if (intent.getBooleanExtra("hasChanges", true))
        {
            a.post(new Runnable(hashmap1, intent) {

                private HashMap a;
                private Intent b;
                private e c;

                public final void run()
                {
                    CollageImage collageimage;
                    boolean flag2;
                    if (a != null)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    collageimage = new CollageImage(flag2, b.getExtras().getString("path"), a, 0);
                    com.picsart.collages.e.b(c).setImageToCell(collageimage, com.picsart.collages.e.b(c).d, false, com.picsart.collages.e.b(c).e().i, true);
                }

            
            {
                c = e.this;
                a = hashmap;
                b = intent;
                super();
            }
            });
            return;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L12:
        p = 2;
        q = (Template)intent.getExtras().getParcelable("template");
        a.post(new Runnable(intent) {

            private Intent a;
            private e b;

            public final void run()
            {
                com.picsart.collages.e.a(b, a, com.picsart.collages.e.m(b));
            }

            
            {
                b = e.this;
                a = intent;
                super();
            }
        });
        return;
_L8:
        intent = intent.getExtras().getString("path");
        a.post(new Runnable(intent) {

            private String a;
            private e b;

            public final void run()
            {
                b.a(a);
            }

            
            {
                b = e.this;
                a = s1;
                super();
            }
        });
        return;
_L9:
        c = intent.getExtras().getString("collagePath");
        a.post(new Runnable(intent) {

            private Intent a;
            private e b;

            public final void run()
            {
                com.picsart.collages.e.a(b, a, a.getIntExtra("cType", 0));
            }

            
            {
                b = e.this;
                a = intent;
                super();
            }
        });
        return;
_L4:
        Toast.makeText(getActivity().getApplicationContext(), getString(0x7f08027c), 0).show();
        return;
_L2:
        if (j1 == 0 && i1 == 1001)
        {
            a.setActiveCellIndex(-1);
            a.invalidate();
            return;
        }
        if (true) goto _L28; else goto _L30
_L30:
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (a != null)
        {
            a.onConfigurationChanged(configuration);
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            a(bundle);
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (g == null)
        {
            g = layoutinflater.inflate(0x7f03006f, viewgroup, false);
        }
        s = new com.picsart.collages.b(this);
        layoutinflater = (WrappingSlidingDrawer)g.findViewById(0x7f1002a2);
        layoutinflater.setOnDrawerCloseListener(new android.widget.SlidingDrawer.OnDrawerCloseListener() {

            private e a;

            public final void onDrawerClosed()
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CollageCreateSecreenActionEvent(com.picsart.collages.e.a(a), "setting"));
            }

            
            {
                a = e.this;
                super();
            }
        });
        layoutinflater.setOnDrawerOpenListener(new android.widget.SlidingDrawer.OnDrawerOpenListener() {

            private e a;

            public final void onDrawerOpened()
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CollageCreateSecreenActionEvent(com.picsart.collages.e.a(a), "setting"));
            }

            
            {
                a = e.this;
                super();
            }
        });
        m = (TextView)g.findViewById(0x7f1002a6);
        n = (TextView)g.findViewById(0x7f1002aa);
        l = g.findViewById(0x7f10029c);
        g.findViewById(0x7f1002a8).setOnClickListener(new android.view.View.OnClickListener() {

            private e a;

            public final void onClick(View view)
            {
                boolean flag = true;
                if (view.isSelected())
                {
                    view.setSelected(false);
                } else
                {
                    view.setSelected(true);
                }
                view = com.picsart.collages.e.b(a);
                if (com.picsart.collages.e.b(a).p)
                {
                    flag = false;
                }
                view.setControlsVisible(flag);
                com.picsart.collages.e.b(a).invalidate();
            }

            
            {
                a = e.this;
                super();
            }
        });
        g.findViewById(0x7f10029a).setOnClickListener(new android.view.View.OnClickListener() {

            private e a;

            public final void onClick(View view)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CollageCreateSecreenActionEvent(com.picsart.collages.e.a(a), "apply"));
                com.picsart.collages.e.c(a);
            }

            
            {
                a = e.this;
                super();
            }
        });
        g.findViewById(0x7f100296).setOnClickListener(new android.view.View.OnClickListener() {

            private e a;

            public final void onClick(View view)
            {
                view = a.getActivity();
                if (view != null && !view.isFinishing())
                {
                    a.a();
                    return;
                } else
                {
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CollageCreateSecreenActionEvent(com.picsart.collages.e.a(a), "close"));
                    return;
                }
            }

            
            {
                a = e.this;
                super();
            }
        });
        g.findViewById(0x7f100297).setOnClickListener(new android.view.View.OnClickListener() {

            private e a;

            public final void onClick(View view)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CollageCreateSecreenActionEvent(com.picsart.collages.e.a(a), "shuffle"));
                view = com.picsart.collages.e.b(a);
                int j1 = ((CollageCreatorView) (view)).b.size();
                Random random = new Random();
                for (int i1 = 0; i1 < j1 / 2 + j1 % 1; i1++)
                {
                    view.a(i1, random.nextInt(j1));
                }

                view.invalidate();
            }

            
            {
                a = e.this;
                super();
            }
        });
        g.findViewById(0x7f100298).setOnClickListener(new android.view.View.OnClickListener() {

            private e a;

            public final void onClick(View view)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CollageCreateSecreenActionEvent(com.picsart.collages.e.a(a), "frame"));
                view = new Intent(a.getActivity().getApplicationContext(), com/socialin/android/photo/clipart/SelectClipArtFrameActivity);
                view.putExtra("category", "collage_frame");
                view.putExtra("readFrom", "collage_frame.json");
                view.putExtra("degrees", com.picsart.collages.e.b(a).c());
                a.startActivityForResult(view, 1010);
            }

            
            {
                a = e.this;
                super();
            }
        });
        g.findViewById(0x7f100299).setOnClickListener(new android.view.View.OnClickListener() {

            private e a;

            public final void onClick(View view)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CollageCreateSecreenActionEvent(com.picsart.collages.e.a(a), "grid"));
                view = a.getActivity();
                if (view != null && !view.isFinishing())
                {
                    view = new Intent(view, com/picsart/collages/SelectCollageActivity);
                    view.putExtra("degrees", com.picsart.collages.e.b(a).c());
                    view.putExtra("from", "collage");
                    view.putExtra("session_id", com.picsart.collages.e.a(a));
                    a.startActivityForResult(view, 1006);
                }
            }

            
            {
                a = e.this;
                super();
            }
        });
        g.findViewById(0x7f1002ac).setOnClickListener(new android.view.View.OnClickListener() {

            final e a;

            public final void onClick(View view)
            {
                com.picsart.collages.e.a(a, new c(this) {

                    private _cls1 a;

                    public final void a(int i1)
                    {
                        com.picsart.collages.e.b(a.a).setBackgroundColor(i1);
                        com.picsart.collages.e.b(a.a).setBackgroundBitmap(null, null);
                        com.picsart.collages.e.b(a.a).invalidate();
                        com.picsart.collages.e.d(a.a).setColor(i1);
                    }

            
            {
                a = _pcls1;
                super();
            }
                }, com.picsart.collages.e.b(a).a.getColor());
            }

            
            {
                a = e.this;
                super();
            }
        });
        g.findViewById(0x7f1002ae).setOnClickListener(new android.view.View.OnClickListener() {

            private e a;

            public final void onClick(View view)
            {
                e.e(a);
            }

            
            {
                a = e.this;
                super();
            }
        });
        g.findViewById(0x7f1002a0).setOnClickListener(new android.view.View.OnClickListener() {

            private e a;

            public final void onClick(View view)
            {
                view = com.picsart.collages.e.b(a).e();
                if (view != null && ((com.picsart.collages.a) (view)).d != null)
                {
                    SPArrow sparrow = view.a(((com.picsart.collages.a) (view)).c);
                    ((com.picsart.collages.a) (view)).i.postScale(-1F, 1.0F);
                    view.a(sparrow.getX() * 2.0F, 0.0F);
                }
                com.picsart.collages.e.b(a).invalidate();
            }

            
            {
                a = e.this;
                super();
            }
        });
        g.findViewById(0x7f10029f).setOnClickListener(new android.view.View.OnClickListener() {

            private e a;

            public final void onClick(View view)
            {
                view = com.picsart.collages.e.b(a).e();
                if (view != null)
                {
                    PointF pointf = view.b();
                    view.b(90F - ((com.picsart.collages.a) (view)).h % 90F, pointf.x, pointf.y);
                    com.picsart.collages.e.b(a).invalidate();
                }
            }

            
            {
                a = e.this;
                super();
            }
        });
        e = (SeekBar)g.findViewById(0x7f1002ab);
        d = e.getProgress();
        e.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private e a;

            public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                if (!flag)
                {
                    return;
                } else
                {
                    com.picsart.collages.e.a(a, i1);
                    return;
                }
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = e.this;
                super();
            }
        });
        f = (SeekBar)g.findViewById(0x7f1002a7);
        f.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private e a;

            public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                com.picsart.collages.e.b(a).setCornerRadiusPercent(i1);
                com.picsart.collages.e.f(a).setText(String.valueOf(i1));
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = e.this;
                super();
            }
        });
        g.findViewById(0x7f1002a1).setOnClickListener(new android.view.View.OnClickListener() {

            private e a;

            public final void onClick(View view)
            {
                view = com.picsart.collages.e.b(a);
                int i1 = com.picsart.collages.e.b(a).d;
                if (i1 >= 0)
                {
                    ((CollageCreatorView) (view)).s.remove(Integer.valueOf(i1));
                    if (i1 < ((CollageCreatorView) (view)).b.size())
                    {
                        ((com.picsart.collages.a)((CollageCreatorView) (view)).b.get(i1)).a(null, false, null, false, null);
                    }
                }
                view.d = -1;
                view.invalidate();
                com.picsart.collages.e.a(a, false);
            }

            
            {
                a = e.this;
                super();
            }
        });
        g.findViewById(0x7f10029d).setOnClickListener(new android.view.View.OnClickListener() {

            private e a;

            public final void onClick(View view)
            {
                com.picsart.collages.e.g(a);
            }

            
            {
                a = e.this;
                super();
            }
        });
        g.findViewById(0x7f10029e).setOnClickListener(new android.view.View.OnClickListener() {

            private e a;

            public final void onClick(View view)
            {
                view = com.picsart.collages.e.b(a).e();
                e e1;
                if (view != null && ((com.picsart.collages.a) (view)).x != null && (((com.picsart.collages.a) (view)).x.getPath() != null && !"".equals(((com.picsart.collages.a) (view)).x.getPath()) || ((com.picsart.collages.a) (view)).x.isFromBuffer() && ((com.picsart.collages.a) (view)).x.getBufferData() != null))
                {
                    if ((e1 = a).a.e() != null && !e1.a.j)
                    {
                        Intent intent = new Intent(e1.getActivity(), com/picsart/studio/editor/activity/StandaloneCropToolActivity);
                        int i1;
                        if (((com.picsart.collages.a) (view)).x.isFromBuffer() && ((com.picsart.collages.a) (view)).x.getBufferData() != null)
                        {
                            intent.putExtra("bufferData", ((com.picsart.collages.a) (view)).x.getBufferData());
                        } else
                        {
                            intent.putExtra("imagePath", ((com.picsart.collages.a) (view)).x.getPath());
                        }
                        i1 = view.e();
                        intent.putExtra("degree", ((com.picsart.collages.a) (view)).w + i1);
                        intent.putExtra("scale", true);
                        intent.putExtra("width", PicsartContext.a.getCollageImageMaxSize());
                        intent.putExtra("height", PicsartContext.a.getCollageImageMaxSize());
                        intent.putExtra("source", "collage");
                        e1.startActivityForResult(intent, 1003);
                        return;
                    }
                }
            }

            
            {
                a = e.this;
                super();
            }
        });
        a = (CollageCreatorView)g.findViewById(0x7f10029b);
        a.setImageSelectListener(new com.picsart.collages.c(this));
        a.setOnCellActivatedListener(s);
        a.setOnCellChangedListener(new com.picsart.collages.g(this));
        r = (ColorPickerPreview)g.findViewById(0x7f1002ad);
        r.setColor(a.a.getColor());
        return g;
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        int j1 = a.b.size();
        bundle.putInt("count", j1);
        bundle.putInt("imagesCount", a.d());
        bundle.putInt("activeCellIndex", a.d);
        bundle.putString("bgImagePath", a.n);
        bundle.putInt("cornerRadius", a.c);
        bundle.putFloat("borderWidth", a.f);
        bundle.putInt("borderWidthProgress", k);
        bundle.putInt("bgImageColor", a.a.getColor());
        bundle.putInt("rotateAngle", a.o);
        for (int i1 = 0; i1 < j1; i1++)
        {
            float af[] = new float[9];
            ((com.picsart.collages.a)a.b.get(i1)).i.getValues(af);
            bundle.putFloatArray((new StringBuilder("matrix")).append(i1).toString(), af);
        }

        bundle.putSerializable("importedImages", a.s);
        bundle.putInt("collageType", p);
        bundle.putString("selectedCollagePath", c);
        bundle.putIntArray("degrees", i);
        bundle.putStringArray("bitmapPaths", h);
        bundle.putParcelable("collageTemplate", q);
        bundle.putInt("selectedCellIndex", a.d);
        bundle.putFloat("collageWidthInJson", v);
        bundle.putFloat("collageHeightInJson", w);
        b(bundle);
        super.onSaveInstanceState(bundle);
    }
}
