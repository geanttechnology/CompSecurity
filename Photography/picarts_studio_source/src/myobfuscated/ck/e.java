// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.picsart.effectnew.EffectShapeDrawerNew;
import com.picsart.effectnew.EffectsDrawController;
import com.picsart.effectnew.MaskBrushNew;
import com.picsart.effectnew.d;
import com.picsart.effectnew.h;
import com.picsart.effectnew.k;
import com.picsart.effectnew.l;
import com.picsart.studio.EditingData;
import com.picsart.studio.utils.c;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.CancelDialogActivity;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.photo.effects.activity.EffectsActivityNew;
import com.socialin.android.picsart.profile.invite.i;
import com.socialin.android.util.Utils;
import com.socialin.android.util.o;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import myobfuscated.cm.n;
import myobfuscated.f.m;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.ck:
//            c, f, a, d, 
//            b

public class e
    implements d, l
{

    boolean a;
    boolean b;
    boolean c;
    boolean d;
    myobfuscated.ck.a e;
    myobfuscated.ck.c f;
    k g;
    boolean h;
    boolean i;
    f j;
    myobfuscated.ck.d k;
    private com.picsart.effectnew.a l;

    public e(myobfuscated.ck.a a1, myobfuscated.ck.c c1)
    {
        a = false;
        b = false;
        c = false;
        d = false;
        l = null;
        h = false;
        i = false;
        e = a1;
        f = c1;
    }

    static myobfuscated.ck.c a(e e1)
    {
        return e1.f;
    }

    static void a(Activity activity)
    {
        if (activity != null && !activity.isFinishing())
        {
            com.socialin.android.picsart.profile.invite.i.a(activity).edit().putBoolean("is_editor_active", false).apply();
            activity.finish();
        }
    }

    static void a(Activity activity, String s1)
    {
        if (activity != null && (activity instanceof EffectsActivityNew))
        {
            if (((EffectsActivityNew)activity).showEnjoyDialog)
            {
                com.socialin.android.picsart.profile.invite.i.a(activity, s1);
            }
            ((EffectsActivityNew)activity).executeInviteNotificaionAction();
        }
    }

    static void a(e e1, String s1, String s2)
    {
        int j1 = 0;
        Object obj = new JSONObject();
        Activity activity = e1.p();
        String s3 = s1.substring(s1.lastIndexOf('.') + 1);
        int i1;
        if (!s1.isEmpty())
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(s1, options);
            i1 = options.outHeight;
            j1 = options.outWidth;
        } else
        {
            i1 = 0;
        }
        s1 = EditingData.a(s1);
        if (!((JSONObject) (obj)).isNull("effects_applied"))
        {
            int k1 = ((JSONObject) (obj)).optInt("effects_applied");
            try
            {
                ((JSONObject) (obj)).put("effects_applied", k1 + e1.f.i().size());
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }
        if (!((JSONObject) (obj)).isNull("total_effects_actions"))
        {
            k1 = ((JSONObject) (obj)).optInt("total_effects_actions");
            try
            {
                ((JSONObject) (obj)).put("total_effects_actions", k1 + e1.f.b);
            }
            // Misplaced declaration of an exception variable
            catch (e e1)
            {
                e1.printStackTrace();
            }
        }
        obj = com.picsart.studio.utils.c.a(activity, null);
        if ("jpg".equalsIgnoreCase(s3) || "jpeg".equalsIgnoreCase(s3))
        {
            e1 = "jpg";
        } else
        if ("png".equalsIgnoreCase(s3))
        {
            e1 = "png";
        } else
        if ("gif".equalsIgnoreCase(s3))
        {
            e1 = "gif";
        } else
        {
            e1 = "";
        }
        AnalyticUtils.trackImageExport(activity, s2, s1, e1, i1, j1, ((android.location.Location) (obj)));
    }

    static void b(Activity activity, String s1)
    {
        a(activity, s1);
    }

    static void b(e e1)
    {
        Activity activity = e1.p();
        if (activity != null)
        {
            b b1 = new b();
            b1.b = e1.b(0x7f080405);
            b1.h = false;
            b1.a().show(activity.getFragmentManager(), null);
        }
    }

    static boolean c(e e1)
    {
        return e1.a;
    }

    static Activity d(e e1)
    {
        return e1.p();
    }

    static void e(e e1)
    {
        e1.q();
    }

    static boolean f(e e1)
    {
        return e1.c;
    }

    static boolean g(e e1)
    {
        return e1.d;
    }

    static f h(e e1)
    {
        return e1.j;
    }

    public static void h()
    {
    }

    static CompoundButton i(e e1)
    {
        return e1.h(((View) (null)));
    }

    static CompoundButton j(e e1)
    {
        return e1.i(((View) (null)));
    }

    static myobfuscated.ck.d k(e e1)
    {
        return e1.k;
    }

    static void l(e e1)
    {
        CheckBox checkbox = null;
        Activity activity = e1.p();
        View view = e1.e(((View) (null)));
        View view1 = e1.f(((View) (null)));
        if (view == null || view1 == null)
        {
            return;
        }
        if (e1.f.f())
        {
            if (e1.j != null)
            {
                e1.j.k();
            }
            view1.findViewById(0x7f100583).setVisibility(8);
            view1 = e1.k(((View) (null)));
            if (view1 != null)
            {
                checkbox = (CheckBox)view1.findViewById(0x7f100194);
            }
            checkbox.setChecked(false);
        }
        if (view.getVisibility() == 8)
        {
            view.startAnimation(AnimationUtils.loadAnimation(activity, 0x7f040017));
            view.setVisibility(0);
            e1.h = true;
        } else
        {
            view.startAnimation(AnimationUtils.loadAnimation(activity, 0x7f040016));
            view.setVisibility(8);
            e1.h = false;
        }
        e1.k();
    }

    static void m(e e1)
    {
        Activity activity = e1.p();
        if (e1.j != null)
        {
            e1.j.l();
        }
        if (e1.g != null)
        {
            k k1 = e1.g;
            View view = e1.e();
            k1.b(view);
            if (k1.a != null)
            {
                Object obj;
                Context context;
                if (view == null)
                {
                    obj = k1.a.e();
                } else
                {
                    obj = view;
                }
                context = k1.a.d();
                if (context != null && obj != null)
                {
                    int i1 = 30 - k1.a.a();
                    ((TextView)((View) (obj)).findViewById(0x7f100192)).setText((new StringBuilder()).append(context.getString(0x7f080068)).append(" ").append((int)(((float)i1 / 30F) * 50F)).toString());
                    obj = (SeekBar)((View) (obj)).findViewById(0x7f100193);
                    ((SeekBar) (obj)).setMax(30);
                    ((SeekBar) (obj)).setProgress(i1);
                }
            }
            k1.a(view);
        }
        obj = e1.f(((View) (null)));
        if (((View) (obj)).getVisibility() == 8)
        {
            ((View) (obj)).setVisibility(0);
            ((View) (obj)).startAnimation(AnimationUtils.loadAnimation(activity, 0x7f040042));
            e1.i = true;
        } else
        {
            ((View) (obj)).startAnimation(AnimationUtils.loadAnimation(activity, 0x7f040041));
            ((View) (obj)).setVisibility(8);
            e1.i = false;
        }
        obj = e1.e(((View) (null)));
        if (((View) (obj)).getVisibility() == 0)
        {
            ((View) (obj)).setVisibility(8);
            e1.h = false;
        }
    }

    static void n(e e1)
    {
        Object obj;
        Activity activity;
        activity = e1.p();
        obj = e1.f;
        if (((myobfuscated.ck.c) (obj)).j == null) goto _L2; else goto _L1
_L1:
        MaskBrushNew maskbrushnew = ((myobfuscated.ck.c) (obj)).j.b();
        if (maskbrushnew == null) goto _L2; else goto _L3
_L3:
        obj = new com.picsart.effectnew.b();
        obj.a = maskbrushnew.a;
        obj.b = maskbrushnew.a();
        obj.c = 100F - maskbrushnew.c;
_L5:
        if (obj != null)
        {
            com.picsart.effectnew.c c1 = new com.picsart.effectnew.c();
            c1.a = e1.b(0x7f0805fb);
            c1.f = 0x7f030047;
            c1.h = false;
            c1.a(e1. new android.view.View.OnClickListener() {

                private e a;

                public final void onClick(View view)
                {
                    if (myobfuscated.ck.e.o(a) != null)
                    {
                        a.a(myobfuscated.ck.e.o(a).b);
                    }
                }

            
            {
                a = e.this;
                super();
            }
            });
            e1.l = c1.a(((com.picsart.effectnew.b) (obj)), e1);
            e1.l.setRetainInstance(true);
            e1.l.show(activity.getFragmentManager(), "BRUSH_SETTINGS_DIALOG");
        }
        return;
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    static com.picsart.effectnew.a o(e e1)
    {
        return e1.l;
    }

    static myobfuscated.ck.a p(e e1)
    {
        return e1.e;
    }

    static boolean q(e e1)
    {
        return e1.b;
    }

    static boolean r()
    {
        return true;
    }

    static boolean s()
    {
        return true;
    }

    public final int a()
    {
        h h1 = f.h();
        if (h1 != null)
        {
            return h1.a;
        } else
        {
            return 0;
        }
    }

    final ImageButton a(View view)
    {
        view = k(view);
        if (view != null)
        {
            return (ImageButton)view.findViewById(0x7f10018b);
        } else
        {
            return null;
        }
    }

    public final void a(int i1)
    {
        if (j != null)
        {
            j.a(i1);
        }
    }

    public final void a(View view, boolean flag)
    {
        CheckBox checkbox;
label0:
        {
            checkbox = b(view);
            view = k(view);
            if (view != null)
            {
                view = (TextView)view.findViewById(0x7f100190);
            } else
            {
                view = null;
            }
            if (checkbox != null)
            {
                if (!flag)
                {
                    break label0;
                }
                checkbox.setVisibility(0);
                view.setVisibility(0);
            }
            return;
        }
        checkbox.setVisibility(8);
        view.setVisibility(8);
    }

    public final void a(com.picsart.effectnew.EffectShapeDrawerNew.ShapeType shapetype)
    {
        if (j != null)
        {
            j.a(shapetype);
        }
    }

    public final void a(com.picsart.effectnew.b b1)
    {
        if (j != null)
        {
            j.a(b1);
        }
    }

    public final void a(boolean flag)
    {
        CompoundButton compoundbutton;
        CompoundButton compoundbutton1;
label0:
        {
            compoundbutton = d(((View) (null)));
            compoundbutton1 = c(((View) (null)));
            if (compoundbutton != null && compoundbutton1 != null)
            {
                if (!flag)
                {
                    break label0;
                }
                compoundbutton.setChecked(false);
                compoundbutton1.setChecked(true);
            }
            return;
        }
        compoundbutton.setChecked(true);
        compoundbutton1.setChecked(false);
    }

    final CheckBox b(View view)
    {
        view = k(view);
        if (view != null)
        {
            return (CheckBox)view.findViewById(0x7f100191);
        } else
        {
            return null;
        }
    }

    public final String b(int i1)
    {
        if (e != null)
        {
            return e.getString(i1);
        } else
        {
            return null;
        }
    }

    public final boolean b()
    {
        return f.g();
    }

    final CompoundButton c(View view)
    {
        view = k(view);
        if (view != null)
        {
            return (CompoundButton)view.findViewById(0x7f10018e);
        } else
        {
            return null;
        }
    }

    public final com.picsart.effectnew.EffectShapeDrawerNew.ShapeType c()
    {
        h h1 = f.h();
        if (h1 != null)
        {
            return h1.e.m;
        } else
        {
            return null;
        }
    }

    public final Context d()
    {
        return p();
    }

    final CompoundButton d(View view)
    {
        view = k(view);
        if (view != null)
        {
            return (CompoundButton)view.findViewById(0x7f10018d);
        } else
        {
            return null;
        }
    }

    public final View e()
    {
        if (e != null)
        {
            return e.getView();
        } else
        {
            return null;
        }
    }

    final View e(View view)
    {
        view = k(view);
        if (view != null)
        {
            return view.findViewById(0x7f100133);
        } else
        {
            return null;
        }
    }

    final View f(View view)
    {
        view = k(view);
        if (view != null)
        {
            return view.findViewById(0x7f100583);
        } else
        {
            return null;
        }
    }

    public final void f()
    {
        if (j != null)
        {
            j.r();
        }
    }

    public final Button g(View view)
    {
        view = k(view);
        if (view != null)
        {
            return (Button)view.findViewById(0x7f100763);
        } else
        {
            return null;
        }
    }

    public final void g()
    {
        if (f.q != null)
        {
            EditingData editingdata = f.q;
            editingdata.d = editingdata.d + 1;
        }
    }

    final CompoundButton h(View view)
    {
        view = k(view);
        if (view != null)
        {
            return (CompoundButton)view.findViewById(0x7f1006f9);
        } else
        {
            return null;
        }
    }

    final CompoundButton i(View view)
    {
        view = k(view);
        if (view != null)
        {
            return (CompoundButton)view.findViewById(0x7f100762);
        } else
        {
            return null;
        }
    }

    public final void i()
    {
        Object obj = p();
        if (obj == null)
        {
            return;
        }
        if (j())
        {
            obj = new Intent(((Context) (obj)), com/socialin/android/dialog/CancelDialogActivity);
            ((Intent) (obj)).putExtra("source", "editor");
            ((Intent) (obj)).putExtra("action", "effect_exit_save_screen");
            e.startActivityForResult(((Intent) (obj)), 0);
            return;
        } else
        {
            ((Activity) (obj)).setResult(0);
            a(((Activity) (obj)), "close");
            a(((Activity) (obj)));
            return;
        }
    }

    final Button j(View view)
    {
        view = k(view);
        if (view != null)
        {
            return (Button)view.findViewById(0x7f1002bb);
        } else
        {
            return null;
        }
    }

    public final boolean j()
    {
        return !f.a() || f.e();
    }

    final View k(View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = e();
        }
        return view1;
    }

    public final void k()
    {
        View view = f(((View) (null)));
        if (view.getVisibility() == 0)
        {
            view.setVisibility(8);
            i = false;
        }
    }

    public final void l()
    {
        if (j != null)
        {
            j.q();
        }
        a(true);
    }

    public final void m()
    {
        if (j != null)
        {
            j.p();
        }
        a(false);
    }

    public final void n()
    {
        Object obj = e(((View) (null)));
        Object obj1 = f(((View) (null)));
        ((View) (obj)).setVisibility(8);
        ((View) (obj1)).setVisibility(8);
        h = false;
        i = false;
        obj = h(((View) (null)));
        obj1 = i(((View) (null)));
        ((CompoundButton) (obj)).setChecked(false);
        ((CompoundButton) (obj1)).setChecked(false);
    }

    public final void o()
    {
        Object obj = e(((View) (null)));
        Object obj1 = f(((View) (null)));
        ((View) (obj)).setVisibility(8);
        ((View) (obj1)).setVisibility(8);
        h = false;
        i = false;
        obj = h(((View) (null)));
        obj1 = i(((View) (null)));
        ((CompoundButton) (obj)).setChecked(false);
        ((CompoundButton) (obj1)).setChecked(false);
        obj = j(((View) (null)));
        obj1 = g(((View) (null)));
        ((View) (obj)).setEnabled(false);
        ((View) (obj1)).setEnabled(false);
    }

    final Activity p()
    {
        if (e != null)
        {
            return e.getActivity();
        } else
        {
            return null;
        }
    }

    final void q()
    {
        Observer observer = new Observer() {

            private e a;

            public final void update(Observable observable, Object obj)
            {
                observable = (n)obj;
                obj = myobfuscated.ck.e.d(a);
                if (obj != null && !((Activity) (obj)).isFinishing()) goto _L2; else goto _L1
_L1:
                return;
_L2:
                x.a();
                if (((n) (observable)).a == null) goto _L4; else goto _L3
_L3:
                Object obj1 = ((n) (observable)).a;
                myobfuscated.ck.e.a(a).i();
                String s1 = x.e();
                String s2 = x.d();
                (new File(s2, s1)).mkdirs();
                obj1 = w.a((new StringBuilder()).append(s2).append("/").append(s1).append("/orig_w").append(((Bitmap) (obj1)).getWidth()).append("_h").append(((Bitmap) (obj1)).getHeight()).toString(), ((Bitmap) (obj1)));
                x.c();
                observable.b = ((java.util.HashMap) (obj1));
_L5:
                if (((n) (observable)).a != null && !((n) (observable)).a.isRecycled())
                {
                    com.socialin.android.util.c.a(((n) (observable)).a);
                }
                e.s();
                Object obj2 = new Intent();
                ((Intent) (obj2)).setClassName("com.picsart.studio", "com.picsart.studio.editor.activity.EditorActivity");
                ((Intent) (obj2)).addCategory("android.intent.category.DEFAULT");
                if (((n) (observable)).b != null)
                {
                    ((Intent) (obj2)).putExtra("bufferData", ((n) (observable)).b);
                } else
                {
                    ((Intent) (obj2)).putExtra("path", ((n) (observable)).c);
                }
                if (myobfuscated.ck.e.a(a).q != null)
                {
                    ((Intent) (obj2)).putExtra("editing_data", myobfuscated.ck.e.a(a).q);
                }
                e.p(a).startActivity(((Intent) (obj2)));
                if (e.q(a))
                {
                    ((Activity) (obj)).setResult(-1);
                    e.r();
                    ((Activity) (obj)).finish();
                    return;
                }
                if (true) goto _L1; else goto _L4
_L4:
                if (((n) (observable)).b != null)
                {
                    obj2 = ((n) (observable)).b;
                    myobfuscated.ck.e.a(a).i();
                    x.a(((java.util.HashMap) (obj2)));
                } else
                if (((n) (observable)).c != null)
                {
                    obj2 = ((n) (observable)).c;
                    myobfuscated.ck.e.a(a).i();
                    x.b(((String) (obj2)), false);
                }
                  goto _L5
            }

            
            {
                a = e.this;
                super();
            }
        };
        if (j != null)
        {
            j.a(true, android.graphics.Bitmap.CompressFormat.PNG, observer);
        }
    }

    static 
    {
        myobfuscated/ck/e.getSimpleName();
    }

    // Unreferenced inner class myobfuscated/ck/e$1

/* anonymous class */
    final class _cls1
        implements android.view.View.OnClickListener
    {

        final myobfuscated.ck.b a;
        final e b;

        public final void onClick(View view)
        {
            if (myobfuscated.ck.e.a(b).c || !myobfuscated.ck.e.a(b).d)
            {
                return;
            }
            if (myobfuscated.ck.e.a(b).e)
            {
                myobfuscated.ck.e.b(b);
                return;
            }
            if (!myobfuscated.ck.e.c(b))
            {
                AnalyticUtils.getInstance(myobfuscated.ck.e.d(b)).trackLocalAction("effect:cancel_dialog_picsartEdit");
                e.e(b);
                return;
            } else
            {
                AnalyticUtils.getInstance(myobfuscated.ck.e.d(b)).trackLocalAction("effect:done");
                view = myobfuscated.ck.e.a(b).k.a(myobfuscated.ck.e.a(b).g);
                AnalyticUtils.getInstance(myobfuscated.ck.e.d(b)).track(new com.socialin.android.apiv3.events.EventsFactory.EffectDoneEvent(view));
                view = new Observer(this) {

                    private _cls1 a;

                    public final void update(Observable observable, Object obj)
                    {
                        n n1 = (n)obj;
    final class _cls1
        implements android.view.View.OnClickListener
    {
                        obj = myobfuscated.ck.e.d(a.b);
                        if (obj == null || ((Activity) (obj)).isFinishing())
                        {
                            return;
                        }
                        Intent intent = new Intent();
                        if (myobfuscated.ck.e.a(a.b).g != null && myobfuscated.ck.e.a(a.b).g.compareTo("None") != 0)
                        {
                            observable = myobfuscated.ck.e.a(a.b).q;
                            observable.k = ((EditingData) (observable)).k + 1;
                        }
                        ArrayList arraylist = myobfuscated.ck.e.a(a.b).i();
                        if (e.f(a.b))
                        {
                            if (n1.a != null)
                            {
                                observable = null;
                                if (!e.g(a.b))
                                {
                                    Log.e("ex1", "NOT saveResultToRecents");
                                    observable = (new StringBuilder()).append(((Activity) (obj)).getString(0x7f0808fc)).append("_").append(System.currentTimeMillis()).toString();
                                    observable = w.a((new StringBuilder()).append(myobfuscated.ck.e.a(a.b).l.a).append(observable).toString(), n1.a);
                                }
                                intent.putExtra("bufferData", observable);
                            }
                        } else
                        {
                            intent.putExtra("path", n1.c);
                        }
                        intent.putStringArrayListExtra("effects", arraylist);
                        if (myobfuscated.ck.e.a(a.b).q != null)
                        {
                            if (a.a != null)
                            {
                                a.a.a();
                            }
                            intent.putExtra("editing_data", myobfuscated.ck.e.a(a.b).q);
                        }
                        ((Activity) (obj)).setResult(-1, intent);
                        e.r();
                        ((Activity) (obj)).finish();
                    }

            
            {
                a = _pcls1;
                super();
            }
                };
                myobfuscated.ck.e.h(b).a(e.f(b), android.graphics.Bitmap.CompressFormat.PNG, view);
                return;
            }
        }

            
            {
                b = e.this;
                a = b1;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$11

/* anonymous class */
    final class _cls11
        implements Observer
    {

        private e a;

        public final void update(Observable observable, Object obj)
        {
            Activity activity = myobfuscated.ck.e.d(a);
            if (activity == null || activity.isFinishing())
            {
                return;
            }
            obj = ((n)obj).c;
            if (obj != null)
            {
                if (SocialinV3.getInstance().isRegistered())
                {
                    observable = String.valueOf(SocialinV3.getInstance().getUser().id);
                } else
                {
                    observable = null;
                }
                myobfuscated.f.m.a(((String) (obj)), observable, myobfuscated.ck.e.a(a).q.c().toString());
                x.a(((String) (obj)), myobfuscated.ck.e.a(a).i().size(), myobfuscated.ck.e.a(a).b);
                new o(activity, ((String) (obj)), "image/*");
            }
            myobfuscated.ck.e.a(a, ((String) (obj)), "local");
            Utils.a(activity, ((String) (obj)));
            myobfuscated.ck.e.b(activity, "savetogallery");
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$12

/* anonymous class */
    final class _cls12
        implements android.view.View.OnClickListener
    {

        private e a;

        public final void onClick(View view)
        {
            if (myobfuscated.ck.e.a(a).d)
            {
                view = myobfuscated.ck.e.d(a);
                AnalyticUtils.getInstance(view).trackLocalAction("effect:apply");
                if (myobfuscated.ck.e.a(a).e)
                {
                    myobfuscated.ck.e.b(a);
                    return;
                }
                if (myobfuscated.ck.e.h(a) != null)
                {
                    if (myobfuscated.ck.e.h(a).s())
                    {
                        a.o();
                        return;
                    } else
                    {
                        Utils.b(view, 0x7f0805ca);
                        return;
                    }
                }
            }
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$13

/* anonymous class */
    final class _cls13
        implements android.view.View.OnClickListener
    {

        private e a;

        public final void onClick(View view)
        {
            if (myobfuscated.ck.e.a(a).d)
            {
                AnalyticUtils.getInstance(myobfuscated.ck.e.d(a)).trackLocalAction("effect:reset");
                if (myobfuscated.ck.e.a(a).e)
                {
                    myobfuscated.ck.e.b(a);
                    return;
                }
                if (myobfuscated.ck.e.h(a) != null)
                {
                    view = myobfuscated.ck.e.a(a);
                    boolean flag;
                    if (!((myobfuscated.ck.c) (view)).e && ((myobfuscated.ck.c) (view)).l.d != null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        myobfuscated.ck.e.h(a).d(false);
                        a.o();
                        return;
                    }
                }
            }
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$14

/* anonymous class */
    final class _cls14
        implements android.view.View.OnClickListener
    {

        private e a;

        public final void onClick(View view)
        {
            if (!myobfuscated.ck.e.a(a).d)
            {
                return;
            } else
            {
                AnalyticUtils.getInstance(myobfuscated.ck.e.d(a)).trackLocalAction("effect:close");
                a.i();
                return;
            }
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$15

/* anonymous class */
    final class _cls15
        implements android.view.View.OnClickListener
    {

        private e a;

        public final void onClick(View view)
        {
            boolean flag1;
            boolean flag3;
            flag3 = true;
            flag1 = true;
            if (myobfuscated.ck.e.a(a).d) goto _L2; else goto _L1
_L1:
            ((CompoundButton)view).setChecked(false);
_L8:
            return;
_L2:
            CompoundButton compoundbutton;
            Activity activity;
            CompoundButton compoundbutton1;
            activity = myobfuscated.ck.e.d(a);
            compoundbutton1 = myobfuscated.ck.e.i(a);
            compoundbutton = e.j(a);
            if (!myobfuscated.ck.e.a(a).c && !myobfuscated.ck.e.a(a).f)
            {
                break MISSING_BLOCK_LABEL_129;
            }
            if (!myobfuscated.ck.e.a(a).f()) goto _L4; else goto _L3
_L3:
            compoundbutton.setChecked(true);
_L6:
            compoundbutton1.setChecked(false);
            return;
_L4:
            if (!myobfuscated.ck.e.a(a).d()) goto _L6; else goto _L5
_L5:
            compoundbutton.setChecked(false);
            compoundbutton1.setChecked(true);
            return;
            if (myobfuscated.ck.e.k(a) != null)
            {
                myobfuscated.ck.e.k(a).j = 0L;
            }
            AnalyticUtils.getInstance(activity).trackLocalAction("effect:brush");
            if (myobfuscated.ck.e.a(a).a())
            {
                if (view.getId() == 0x7f1006f9)
                {
                    Utils.a(activity, 0x7f08046a);
                } else
                {
                    Utils.a(activity, 0x7f08046b);
                }
                compoundbutton.setChecked(false);
                compoundbutton1.setChecked(false);
                return;
            }
            if (!myobfuscated.ck.e.a(a).c())
            {
                compoundbutton.setChecked(false);
                compoundbutton1.setChecked(false);
                if (view.getId() == 0x7f1006f9)
                {
                    Utils.a(activity, 0x7f080404);
                    return;
                } else
                {
                    Utils.a(activity, 0x7f08046e);
                    return;
                }
            }
            if (view.getId() == 0x7f1006f9)
            {
                view = myobfuscated.ck.e.a(a);
                boolean flag = flag1;
                if (view.f())
                {
                    flag = flag1;
                    if (((myobfuscated.ck.c) (view)).j.c.o)
                    {
                        flag = false;
                    }
                }
                if (flag)
                {
                    myobfuscated.ck.e.l(a);
                    compoundbutton.setChecked(false);
                    return;
                }
            } else
            {
                view = myobfuscated.ck.e.a(a);
                boolean flag2 = flag3;
                if (((myobfuscated.ck.c) (view)).k != null)
                {
                    flag2 = flag3;
                    if (((myobfuscated.ck.c) (view)).g != null)
                    {
                        flag2 = ((myobfuscated.ck.c) (view)).k.c(((myobfuscated.ck.c) (view)).g);
                    }
                }
                if (!flag2)
                {
                    Utils.a(activity, 0x7f08046e);
                    compoundbutton.setChecked(false);
                    return;
                } else
                {
                    myobfuscated.ck.e.m(a);
                    compoundbutton1.setChecked(false);
                    return;
                }
            }
            if (true) goto _L8; else goto _L7
_L7:
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$16

/* anonymous class */
    final class _cls16
        implements android.view.View.OnClickListener
    {

        private e a;

        public final void onClick(View view)
        {
            if (myobfuscated.ck.e.k(a) != null)
            {
                myobfuscated.ck.e.k(a).j = 0L;
            }
            a.l();
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$17

/* anonymous class */
    final class _cls17
        implements android.view.View.OnClickListener
    {

        private e a;

        public final void onClick(View view)
        {
            if (myobfuscated.ck.e.k(a) != null)
            {
                myobfuscated.ck.e.k(a).j = 0L;
            }
            a.m();
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$18

/* anonymous class */
    final class _cls18
        implements android.view.View.OnClickListener
    {

        private e a;

        public final void onClick(View view)
        {
            if (myobfuscated.ck.e.k(a) != null)
            {
                myobfuscated.ck.e.k(a).j = 0L;
            }
            if (myobfuscated.ck.e.h(a) != null)
            {
                myobfuscated.ck.e.h(a).n();
            }
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$19

/* anonymous class */
    final class _cls19
        implements android.view.View.OnClickListener
    {

        private e a;

        public final void onClick(View view)
        {
            if (myobfuscated.ck.e.h(a) != null)
            {
                myobfuscated.ck.e.h(a).o();
            }
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$2

/* anonymous class */
    final class _cls2
        implements android.view.View.OnClickListener
    {

        private e a;

        public final void onClick(View view)
        {
            if (myobfuscated.ck.e.h(a) != null)
            {
                myobfuscated.ck.e.h(a).m();
            }
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$3

/* anonymous class */
    final class _cls3
        implements android.view.View.OnClickListener
    {

        private e a;

        public final void onClick(View view)
        {
            myobfuscated.ck.e.n(a);
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$5

/* anonymous class */
    final class _cls5
        implements Observer
    {

        private e a;

        public final void update(Observable observable, Object obj)
        {
            Activity activity = myobfuscated.ck.e.d(a);
            if (activity != null && !activity.isFinishing())
            {
                if ((obj = ((n)obj).c) != null)
                {
                    if (SocialinV3.getInstance().isRegistered())
                    {
                        observable = String.valueOf(SocialinV3.getInstance().getUser().id);
                    } else
                    {
                        observable = null;
                    }
                    myobfuscated.f.m.a(((String) (obj)), observable, myobfuscated.ck.e.a(a).q.c().toString());
                    x.a(((String) (obj)), myobfuscated.ck.e.a(a).i().size(), myobfuscated.ck.e.a(a).b);
                    myobfuscated.cv.c.a(activity, ((String) (obj)));
                    return;
                }
            }
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$6

/* anonymous class */
    final class _cls6
        implements Observer
    {

        private e a;

        public final void update(Observable observable, Object obj)
        {
            Activity activity;
            obj = ((n)obj).c;
            activity = myobfuscated.ck.e.d(a);
            break MISSING_BLOCK_LABEL_16;
            if (activity != null && !activity.isFinishing() && obj != null)
            {
                if (SocialinV3.getInstance().isRegistered())
                {
                    observable = String.valueOf(SocialinV3.getInstance().getUser().id);
                } else
                {
                    observable = null;
                }
                myobfuscated.f.m.a(((String) (obj)), observable, myobfuscated.ck.e.a(a).q.c().toString());
                if (myobfuscated.ck.e.a(a).a != null)
                {
                    FacebookUtils.startAdapterActivity(activity, ((String) (obj)));
                    myobfuscated.ck.e.a(a, ((String) (obj)), "facebook");
                    return;
                }
            }
            return;
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$7

/* anonymous class */
    final class _cls7
        implements Observer
    {

        private e a;

        public final void update(Observable observable, Object obj)
        {
            obj = ((n)obj).c;
            for (observable = myobfuscated.ck.e.d(a); observable == null || observable.isFinishing() || obj == null;)
            {
                return;
            }

            if (SocialinV3.getInstance().isRegistered())
            {
                observable = String.valueOf(SocialinV3.getInstance().getUser().id);
            } else
            {
                observable = null;
            }
            myobfuscated.f.m.a(((String) (obj)), observable, myobfuscated.ck.e.a(a).q.c().toString());
            myobfuscated.ck.e.a(a, myobfuscated.cv.c.a(myobfuscated.ck.e.d(a), ((String) (obj))), "instagram");
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$8

/* anonymous class */
    final class _cls8
        implements Observer
    {

        private e a;

        public final void update(Observable observable, Object obj)
        {
            obj = ((n)obj).c;
            Activity activity;
            for (activity = myobfuscated.ck.e.d(a); activity == null || activity.isFinishing() || obj == null;)
            {
                return;
            }

            if (SocialinV3.getInstance().isRegistered())
            {
                observable = String.valueOf(SocialinV3.getInstance().getUser().id);
            } else
            {
                observable = null;
            }
            myobfuscated.f.m.a(((String) (obj)), observable, myobfuscated.ck.e.a(a).q.c().toString());
            x.a(((String) (obj)), myobfuscated.ck.e.a(a).i().size(), myobfuscated.ck.e.a(a).b);
            myobfuscated.cv.c.a(((String) (obj)), activity);
            myobfuscated.ck.e.a(a, ((String) (obj)), "twitter");
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/ck/e$9

/* anonymous class */
    final class _cls9
        implements Observer
    {

        private e a;

        public final void update(Observable observable, Object obj)
        {
            observable = ((n)obj).c;
            obj = myobfuscated.ck.e.d(a);
            break MISSING_BLOCK_LABEL_16;
            if (obj != null && !((Activity) (obj)).isFinishing() && observable != null)
            {
                Point point = myobfuscated.ck.e.a(a).a;
                if (point != null)
                {
                    myobfuscated.cv.c.a(((Activity) (obj)), observable, point.x, point.y);
                    return;
                }
            }
            return;
        }

            
            {
                a = e.this;
                super();
            }
    }

}
