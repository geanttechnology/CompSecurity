// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jumio.commons.camera.ImageData;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import com.jumio.netverify.sdk.custom.NetverifyDocumentPart;
import com.jumio.netverify.sdk.custom.SDKNotConfiguredException;
import com.jumio.netverify.sdk.enums.NVScanSide;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package jumiomobile:
//            ki, ln, ng, lm, 
//            mk, ht, ha, lv, 
//            ly, lx, cv, ce, 
//            lw, lr, nu, nh, 
//            nd, ma, ls, ab, 
//            lq, lt, lu, mf, 
//            bg, me, lz, mb, 
//            mh, md, bp, hu, 
//            hq, kt

public final class lp extends ki
    implements ln, ng
{

    private RelativeLayout b;
    private nu c;
    private Button d;
    private RelativeLayout e;
    private nd f;
    private TextView g;
    private Button h;
    private Button i;
    private View j;
    private LinearLayout k;
    private AnimatorSet l;
    private AnimatorSet m;
    private SparseArray n;
    private boolean o;
    private List p;
    private ht q;
    private Context r;
    private Object s;

    public lp()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        o = false;
        q = null;
        s = new Object();
    }

    static TextView a(lp lp1)
    {
        return lp1.g;
    }

    static ht a(lp lp1, ht ht1)
    {
        lp1.q = ht1;
        return ht1;
    }

    private void a(int i1)
    {
        Intent intent = new Intent();
        intent.putExtra("scanReference", a.getModel().j);
        intent.putExtra("scanData", a.getModel().I);
        a.finishSDK(intent, i1);
    }

    static void a(lp lp1, int i1)
    {
        lp1.a(i1);
    }

    private void a(boolean flag)
    {
        Button button = d;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        button.setVisibility(i1);
        d.setEnabled(flag);
        a(mk.a(getActivity(), "actionbar_title_upload"));
    }

    static boolean a(lp lp1, boolean flag)
    {
        lp1.o = flag;
        return flag;
    }

    static Button b(lp lp1)
    {
        return lp1.i;
    }

    public static lp b()
    {
        return new lp();
    }

    private void b(ht ht1)
    {
        android.app.AlertDialog.Builder builder;
        if (Environment.isLollipop())
        {
            builder = new android.app.AlertDialog.Builder(r, 5);
        } else
        {
            builder = new android.app.AlertDialog.Builder(r);
        }
        builder.setMessage(ht1.a(r));
        builder.setTitle(mk.a(r, "dialog_title_error"));
        if (!o)
        {
            a.getController().j();
        }
        lv.a[ht1.ordinal()];
        JVM INSTR tableswitch 1 4: default 104
    //                   1 234
    //                   2 218
    //                   3 218
    //                   4 274;
           goto _L1 _L2 _L3 _L3 _L4
_L1:
        builder.setPositiveButton(mk.a(r, "button_retry"), new ly(this, null));
        builder.setNegativeButton(mk.a(r, "button_change_photos"), new lx(this, null));
_L6:
        builder.setCancelable(false);
        ht1 = builder.show();
        ht1.getButton(-2).setTextColor(ce.b(r, cv.a(r, "netverify_dialogNegativeButtonTextColor", "attr"), 0xff666666));
        ht1.getButton(-1).setTextColor(ce.b(r, cv.a(r, "netverify_dialogPositiveButtonTextColor", "attr"), 0xff97be0d));
_L3:
        return;
_L2:
        builder.setNegativeButton(mk.a(getActivity(), "button_cancel"), new lw(this, ht1));
        builder.setOnCancelListener(new lr(this, ht1));
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        if (!o)
        {
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static nd c(lp lp1)
    {
        return lp1.f;
    }

    static void d(lp lp1)
    {
        lp1.j();
    }

    static AnimatorSet e(lp lp1)
    {
        return lp1.m;
    }

    static Button f(lp lp1)
    {
        return lp1.d;
    }

    static AnimatorSet g(lp lp1)
    {
        return lp1.l;
    }

    static View h(lp lp1)
    {
        return lp1.j;
    }

    static nu i(lp lp1)
    {
        return lp1.c;
    }

    private void i()
    {
        k.setVisibility(8);
        j.setVisibility(0);
        c.setBackgroundColor(0);
        e.setVisibility(0);
        f.setUploadStatus(nh.a);
        g.setText(mk.a(getActivity(), "submission_uploading"));
        j.setTranslationY(-b.getHeight() + c.getCurrentHeight());
        a(mk.a(getActivity(), "actionbar_title_submission"));
        l = new AnimatorSet();
        Object obj = ObjectAnimator.ofFloat(d, "alpha", new float[] {
            1.0F, 0.0F
        });
        ((ObjectAnimator) (obj)).setDuration(200L);
        ((ObjectAnimator) (obj)).setInterpolator(new AccelerateDecelerateInterpolator());
        obj = l.play(((android.animation.Animator) (obj)));
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(c, "alpha", new float[] {
            1.0F, 0.0F
        });
        objectanimator.setDuration(200L);
        objectanimator.setInterpolator(new AccelerateDecelerateInterpolator());
        ((android.animation.AnimatorSet.Builder) (obj)).with(objectanimator);
        for (int i1 = 0; i1 < n.size(); i1++)
        {
            objectanimator = ObjectAnimator.ofFloat(((ma)n.get(i1)).b, "translationX", new float[] {
                0.0F, (float)b.getWidth()
            });
            objectanimator.setStartDelay((long)i1 * 100L);
            objectanimator.setDuration(200L);
            objectanimator.setInterpolator(new AccelerateDecelerateInterpolator());
            ((android.animation.AnimatorSet.Builder) (obj)).with(objectanimator);
        }

        objectanimator = ObjectAnimator.ofFloat(j, "translationY", new float[] {
            (float)(-b.getHeight() + c.getCurrentHeight()), (float)(-b.getHeight())
        });
        objectanimator.setDuration(200L);
        objectanimator.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(e, "alpha", new float[] {
            0.0F, 1.0F
        });
        objectanimator1.setDuration(200L);
        objectanimator1.setInterpolator(new AccelerateDecelerateInterpolator());
        ((android.animation.AnimatorSet.Builder) (obj)).before(objectanimator).before(objectanimator1);
        l.addListener(new ls(this));
        l.start();
    }

    private void j()
    {
        i();
        try
        {
            a.getController().k();
            return;
        }
        catch (SDKNotConfiguredException sdknotconfiguredexception)
        {
            ab.a(sdknotconfiguredexception);
        }
    }

    public final void a()
    {
        synchronized (s)
        {
            f.setUploadStatus(nh.b);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean a(ht ht1)
    {
        if (o)
        {
            q = ht1;
            f.setUploadStatus(nh.c);
            i.setVisibility(0);
            i.setEnabled(true);
            ht1 = ObjectAnimator.ofFloat(g, "alpha", new float[] {
                1.0F, 0.0F
            });
            ht1.setDuration(200L);
            ht1.setInterpolator(new AccelerateDecelerateInterpolator());
            ht1.addListener(new lq(this));
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(g, "alpha", new float[] {
                0.0F, 1.0F
            });
            objectanimator.setDuration(200L);
            objectanimator.setInterpolator(new AccelerateDecelerateInterpolator());
            ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(i, "alpha", new float[] {
                0.0F, 1.0F
            });
            objectanimator1.setDuration(200L);
            objectanimator1.setInterpolator(new AccelerateDecelerateInterpolator());
            AnimatorSet animatorset = new AnimatorSet();
            animatorset.play(objectanimator).with(objectanimator1).after(ht1);
            animatorset.start();
            return true;
        } else
        {
            b(ht1);
            return true;
        }
    }

    public final boolean c()
    {
        lm lm1 = a;
        ht ht1;
        if (o && q != null)
        {
            ht1 = q;
        } else
        {
            ht1 = ht.m;
        }
        lm1.cancelSDK(ht1);
        return true;
    }

    public final boolean d()
    {
label0:
        {
            synchronized (s)
            {
                if (h.getVisibility() != 0)
                {
                    break label0;
                }
                a(102);
            }
            return true;
        }
        if (!o)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        a.getController().c();
        f();
        o = false;
        q = null;
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        a.getController().d();
        obj;
        JVM INSTR monitorexit ;
        return false;
    }

    public final void e()
    {
        if (!a.getModel().g())
        {
            return;
        } else
        {
            a(true);
            return;
        }
    }

    public final void f()
    {
        m = new AnimatorSet();
        k.setVisibility(0);
        Object obj = ObjectAnimator.ofFloat(d, "alpha", new float[] {
            0.0F, 1.0F
        });
        ((ObjectAnimator) (obj)).setDuration(200L);
        ((ObjectAnimator) (obj)).setInterpolator(new AccelerateDecelerateInterpolator());
        obj = m.play(((android.animation.Animator) (obj)));
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(c, "alpha", new float[] {
            0.0F, 1.0F
        });
        objectanimator.setDuration(200L);
        objectanimator.setInterpolator(new AccelerateDecelerateInterpolator());
        ((android.animation.AnimatorSet.Builder) (obj)).with(objectanimator);
        for (int i1 = 0; i1 < n.size(); i1++)
        {
            objectanimator = ObjectAnimator.ofFloat(((ma)n.get(i1)).b, "translationX", new float[] {
                (float)(-b.getWidth()), 0.0F
            });
            objectanimator.setStartDelay((long)i1 * 100L);
            objectanimator.setDuration(200L);
            objectanimator.setInterpolator(new AccelerateDecelerateInterpolator());
            ((android.animation.AnimatorSet.Builder) (obj)).with(objectanimator);
        }

        if (i.getVisibility() == 0)
        {
            objectanimator = ObjectAnimator.ofFloat(i, "alpha", new float[] {
                1.0F, 0.0F
            });
            objectanimator.setDuration(200L);
            objectanimator.setInterpolator(new AccelerateDecelerateInterpolator());
            ((android.animation.AnimatorSet.Builder) (obj)).after(objectanimator);
        }
        objectanimator = ObjectAnimator.ofFloat(e, "alpha", new float[] {
            1.0F, 0.0F
        });
        objectanimator.setDuration(200L);
        objectanimator.setInterpolator(new AccelerateDecelerateInterpolator());
        ((android.animation.AnimatorSet.Builder) (obj)).after(objectanimator);
        objectanimator = ObjectAnimator.ofFloat(j, "translationY", new float[] {
            (float)(-b.getHeight()), (float)(-b.getHeight() + c.getCurrentHeight())
        });
        objectanimator.setDuration(200L);
        objectanimator.setInterpolator(new AccelerateDecelerateInterpolator());
        ((android.animation.AnimatorSet.Builder) (obj)).after(objectanimator);
        m.addListener(new lt(this));
        m.start();
    }

    public final void g()
    {
        i.setVisibility(8);
        h.setVisibility(0);
        if (getActivity() instanceof AppCompatActivity)
        {
            ActionBar actionbar = ((AppCompatActivity)getActivity()).getSupportActionBar();
            if (actionbar != null)
            {
                actionbar.setHomeButtonEnabled(false);
                actionbar.setDisplayHomeAsUpEnabled(false);
            }
        }
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(g, "alpha", new float[] {
            1.0F, 0.0F
        });
        objectanimator.setDuration(200L);
        objectanimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectanimator.start();
    }

    public final void h()
    {
        g.setText(mk.a(getActivity(), "submission_complete"));
        f.setFinishStatus(nh.b);
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(g, "alpha", new float[] {
            0.0F, 1.0F
        });
        objectanimator.setDuration(200L);
        objectanimator.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(h, "alpha", new float[] {
            0.0F, 1.0F
        });
        objectanimator1.setDuration(200L);
        objectanimator1.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.play(objectanimator).with(objectanimator1);
        animatorset.addListener(new lu(this));
        animatorset.start();
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ModelTemplate modeltemplate = a.getModel();
        a.checkOrientation();
        a(mk.a(getActivity(), "actionbar_title_upload"));
        b = (RelativeLayout)getView().findViewById(mf.d);
        j = getView().findViewById(mf.ac);
        c = (nu)getView().findViewById(mf.J);
        c.setCenterText(false);
        if (modeltemplate.L)
        {
            Object obj = new android.graphics.BitmapFactory.Options();
            obj.inJustDecodeBounds = true;
            int i1 = (int)Math.ceil((float)((android.graphics.BitmapFactory.Options) (obj)).outWidth / bg.a(getActivity(), 40F));
            if (i1 > 1)
            {
                obj.inSampleSize = i1;
            }
            obj.inJustDecodeBounds = false;
            obj = cv.a(((Country)modeltemplate.d().get(modeltemplate.w)).b().toLowerCase(Locale.GERMAN), ((android.graphics.BitmapFactory.Options) (obj)));
            c.setLeftImage(((android.graphics.Bitmap) (obj)));
        }
        c.a(false, false);
        Object obj1 = new SpannableString(modeltemplate.v.getName(getActivity()));
        ((SpannableString) (obj1)).setSpan(new ForegroundColorSpan(c.getTextColor().getDefaultColor()), 0, ((SpannableString) (obj1)).length(), 33);
        ((SpannableString) (obj1)).setSpan(new AbsoluteSizeSpan((int)TypedValue.applyDimension(2, 22F, getResources().getDisplayMetrics())), 0, ((SpannableString) (obj1)).length(), 33);
        c.setText(((CharSequence) (obj1)));
        n = new SparseArray();
        int j1 = cv.a(getActivity(), "netverify_submissionTextColor", "attr");
        obj1 = ce.b(getActivity(), j1, 0xff666666);
        e = (RelativeLayout)getView().findViewById(mf.N);
        f = (nd)getView().findViewById(mf.O);
        f.setCallback(this);
        f.setTextColor(((ColorStateList) (obj1)).getDefaultColor());
        g = (TextView)getView().findViewById(mf.Q);
        g.setTextColor(((ColorStateList) (obj1)));
        d = (Button)getView().findViewById(mf.t);
        d.setOnClickListener(new me(this, null));
        h = (Button)getView().findViewById(mf.r);
        h.setOnClickListener(new lz(this, null));
        i = (Button)getView().findViewById(mf.s);
        i.setOnClickListener(new mb(this, null));
        r = getActivity();
        k = (LinearLayout)getView().findViewById(mf.u);
        j1 = 0;
        Iterator iterator = p.iterator();
        int l1 = 0;
        do
        {
            if (iterator.hasNext())
            {
                Object obj2 = (NetverifyDocumentPart)iterator.next();
                ma ma1 = new ma(this, null);
                int k1;
                if (l1 == 0)
                {
                    if (p.size() > 1)
                    {
                        j1 = mh.H;
                    } else
                    {
                        j1 = mh.G;
                    }
                    if (p.size() > 1)
                    {
                        k1 = mh.L;
                    } else
                    {
                        k1 = mh.K;
                    }
                } else
                if (l1 > 0 && l1 < p.size() - 1)
                {
                    j1 = mh.I;
                    k1 = mh.M;
                } else
                if (l1 == p.size() - 1)
                {
                    j1 = mh.J;
                    k1 = mh.N;
                } else
                {
                    k1 = 0;
                }
                ma1.b = mf.c(getActivity(), j1, k1);
                ma1.b.setOnClickListener(new md(this, ma1));
                ma1.c = (RelativeLayout)ma1.b.findViewById(mf.v);
                ma1.d = (ImageView)ma1.b.findViewById(mf.w);
                ma1.f = (TextView)ma1.b.findViewById(mf.C);
                ma1.g = (TextView)ma1.b.findViewById(mf.D);
                ma1.a = ((NetverifyDocumentPart) (obj2)).getScanSide();
                if (((NetverifyDocumentPart) (obj2)).getScanSide() == NVScanSide.FRONT)
                {
                    ma1.d.setImageBitmap(mh.a(getResources(), mh.w));
                    ma1.f.setText(mk.a(getActivity(), "front"));
                    ma1.g.setText(mk.a(getActivity(), "take_photo_front"));
                } else
                if (((NetverifyDocumentPart) (obj2)).getScanSide() == NVScanSide.FACE)
                {
                    ma1.d.setImageBitmap(mh.a(getResources(), mh.y));
                    ma1.f.setText(mk.a(getActivity(), "face"));
                    ma1.g.setText(mk.a(getActivity(), "take_photo_face"));
                } else
                if (((NetverifyDocumentPart) (obj2)).getScanSide() == NVScanSide.BACK)
                {
                    ma1.d.setImageBitmap(mh.a(getResources(), mh.x));
                    ma1.f.setText(mk.a(getActivity(), "back"));
                    ma1.g.setText(mk.a(getActivity(), "take_photo_back"));
                }
                k1 = ma1.a.getPartNumber();
                obj2 = (ImageData)modeltemplate.u.get(k1);
                if (obj2 != null && ((ImageData) (obj2)).g())
                {
                    mh.a(k1);
                    if ("SKIPPED".equals(((ImageData) (obj2)).f()))
                    {
                        ma1.g.setText(mk.a(getActivity(), "photo_not_necessary"));
                        ma1.f.setEnabled(false);
                        ma1.g.setEnabled(false);
                        ma1.g.setTypeface(null, 2);
                        bp.a(ma1.d, 75);
                        ma1.b.setEnabled(false);
                    } else
                    {
                        if (((ImageData) (obj2)).i())
                        {
                            obj2 = ((ImageData) (obj2)).h();
                        } else
                        {
                            obj2 = ((ImageData) (obj2)).f();
                        }
                        ma1.e = ((String) (obj2));
                        ma1.d.setImageBitmap(mh.a(ma1.e, 300, 300, k1, 0));
                        if (ma1.a == NVScanSide.FRONT)
                        {
                            ma1.g.setText(mk.a(getActivity(), "change_photo_front"));
                        } else
                        if (ma1.a == NVScanSide.BACK)
                        {
                            ma1.g.setText(mk.a(getActivity(), "change_photo_back"));
                        } else
                        if (ma1.a == NVScanSide.FACE)
                        {
                            ma1.g.setText(mk.a(getActivity(), "change_photo_face"));
                        }
                    }
                }
                n.append(l1, ma1);
                k.addView(ma1.b);
                l1++;
                continue;
            }
            e();
            if (bundle != null && modeltemplate.c == hu.h)
            {
                i();
            }
            return;
        } while (true);
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (a.getModel() != null)
        {
            bundle = a.getModel();
            p = a.getController().f();
            if (p.size() == 1)
            {
                a.showFragment(kt.a(a.getController().a(NVScanSide.FRONT), ((ModelTemplate) (bundle)).v.getDocumentScanMode().a(), NVScanSide.FRONT, true));
                return;
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a.registerActivityCallback(this);
        return mf.f(getActivity(), a.getModel().H);
    }
}
