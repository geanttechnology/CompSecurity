// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import android.widget.Spinner;
import android.widget.TextView;
import com.photo.effect.Effect;
import com.photo.effect.EffectParameter;
import com.photo.effect.d;
import com.photo.effects.utils.RenderScriptUnsupportDevice;
import com.picsart.effectnew.EffectShapeDrawerNew;
import com.picsart.effectnew.EffectsDrawController;
import com.picsart.effectnew.EffectsDrawHistoryController;
import com.picsart.effectnew.MaskBrushNew;
import com.picsart.effectnew.o;
import com.picsart.effectnew.q;
import com.picsart.effects.blemishfix.BlemishFixActivity;
import com.picsart.effects.blemishfix.BlemishFixActivityMainProcess;
import com.picsart.effects.eyereplacer.EyeReplacerActivity;
import com.picsart.effects.eyereplacer.EyeReplacerActivityMainProcess;
import com.picsart.effects.redeyeremover.RedEyeRemoverActivity;
import com.picsart.effects.redeyeremover.RedEyeRemoverActivityMainProcess;
import com.picsart.studio.EditingData;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.SocialinApplication;
import com.socialin.android.activity.SaveToSdCardDialogActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.effects.activity.EffectsActivityNew;
import com.socialin.android.photo.effects.draw.EffectsView;
import com.socialin.android.photo.effects.draw.b;
import com.socialin.android.photo.effects.factory.EffectsFactory;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.af;
import com.socialin.android.util.w;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import myobfuscated.ch.f;
import myobfuscated.ch.h;
import myobfuscated.ch.i;
import myobfuscated.ch.j;
import myobfuscated.ch.k;
import myobfuscated.ch.l;
import myobfuscated.ch.n;
import myobfuscated.ch.p;
import myobfuscated.ch.r;
import myobfuscated.ch.s;
import myobfuscated.ch.t;
import myobfuscated.ch.u;
import myobfuscated.cj.c;
import myobfuscated.cl.e;
import myobfuscated.f.m;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package myobfuscated.ck:
//            f, c, e, d, 
//            b

public class a extends Fragment
    implements o, q, b, myobfuscated.cg.b, myobfuscated.ck.f, e
{

    public static final String a = (new StringBuilder("fragment_")).append(myobfuscated/ck/a.toString()).toString();
    private myobfuscated.ck.c A;
    private g B;
    private boolean C;
    private int D;
    private android.content.DialogInterface.OnCancelListener E;
    private Intent F;
    private int G;
    private int H;
    private myobfuscated.ck.d I;
    private boolean J;
    private int K;
    private TimeCalculator L;
    public myobfuscated.ck.e b;
    public Bitmap c;
    private myobfuscated.ci.c d;
    private myobfuscated.cl.c e;
    private myobfuscated.cl.d f;
    private myobfuscated.cj.b g;
    private ThreadPoolExecutor h;
    private Bitmap i;
    private Bitmap j;
    private Bitmap k;
    private Bitmap l;
    private Point m;
    private int n;
    private Point o;
    private ByteBuffer p;
    private ByteBuffer q;
    private ByteBuffer r;
    private ByteBuffer s;
    private boolean t;
    private Object u;
    private myobfuscated.cm.c v;
    private boolean w;
    private android.view.animation.Animation.AnimationListener x;
    private myobfuscated.cg.a y;
    private boolean z;

    public a()
    {
        o = new Point();
        t = true;
        w = true;
        z = false;
        C = false;
        J = true;
        K = 0;
    }

    static Object A(a a1)
    {
        return a1.u;
    }

    private JSONArray A()
    {
        JSONArray jsonarray = new JSONArray();
        if (A.i != null)
        {
            jsonarray = A.i.c();
        }
        return jsonarray;
    }

    static void B(a a1)
    {
        a1.v();
    }

    static ImageButton C(a a1)
    {
        return a1.e(((View) (null)));
    }

    static android.view.animation.Animation.AnimationListener D(a a1)
    {
        return a1.x;
    }

    static void E(a a1)
    {
        a1.x();
    }

    static void F(a a1)
    {
        if (a1.A.j != null)
        {
            a1.A.j.a(Boolean.valueOf(true));
            a1.A.j.c.a(false);
            a1 = a1.g(((View) (null)));
            if (a1 != null)
            {
                a1.invalidate();
            }
        }
    }

    static int G(a a1)
    {
        return a1.K;
    }

    static Button H(a a1)
    {
        return a1.i(((View) (null)));
    }

    static myobfuscated.cm.d I(a a1)
    {
        return a1.y();
    }

    static myobfuscated.cm.c J(a a1)
    {
        return a1.v;
    }

    static Spinner K(a a1)
    {
        return a1.j(((View) (null)));
    }

    static boolean L(a a1)
    {
        a1.C = false;
        return false;
    }

    static boolean M(a a1)
    {
        return a1.J;
    }

    static int a(a a1, int i1)
    {
        a1.K = i1;
        return i1;
    }

    private Intent a(Class class1)
    {
        c c1 = g.a();
        return myobfuscated.ay.e.a(getActivity(), class1, c1.c, c1.a, c1.b, g.f);
    }

    public static Bitmap a(Bitmap bitmap)
    {
        return bitmap;
    }

    public static Bitmap a(a a1, Bitmap bitmap)
    {
        a1.i = bitmap;
        return bitmap;
    }

    public static Point a(a a1, Point point)
    {
        a1.m = point;
        return point;
    }

    public static Object a(a a1, Object obj)
    {
        a1.u = obj;
        return obj;
    }

    public static ByteBuffer a(a a1, ByteBuffer bytebuffer)
    {
        a1.r = bytebuffer;
        return bytebuffer;
    }

    public static myobfuscated.ck.c a(a a1)
    {
        return a1.A;
    }

    private void a(int i1, int j1, Intent intent)
    {
        Object obj;
        long l1;
        boolean flag;
        l1 = 0L;
        flag = false;
        obj = b;
        if (i1 != 0 && i1 != 1) goto _L2; else goto _L1
_L1:
        if (j1 != -1) goto _L4; else goto _L3
_L3:
        Object obj2 = ((myobfuscated.ck.e) (obj)).p();
        i1;
        JVM INSTR tableswitch 0 1: default 56
    //                   0 65
    //                   1 695;
           goto _L5 _L6 _L7
_L4:
        byte byte0 = 1;
_L18:
        if (byte0 != 0)
        {
            return;
        }
        break; /* Loop/switch isn't completed */
_L6:
        Object obj3;
        obj3 = intent.getExtras().getString("button");
        byte0 = -1;
        ((String) (obj3)).hashCode();
        JVM INSTR lookupswitch 8: default 160
    //                   -1727082830: 272
    //                   11576841: 238
    //                   1111669925: 323
    //                   1291988114: 340
    //                   1293361956: 306
    //                   1318040329: 289
    //                   1391073851: 255
    //                   2088201527: 358;
           goto _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L8:
        switch (byte0)
        {
        case 0: // '\0'
            AnalyticUtils.getInstance(((Context) (obj2))).trackLocalAction("effect:cancel_dialog_ok");
            myobfuscated.ck.e.a(((Activity) (obj2)), "close");
            myobfuscated.ck.e.a(((Activity) (obj2)));
            break;

        case 1: // '\001'
            AnalyticUtils.getInstance(((Context) (obj2))).trackLocalAction("effect:cancel_dialog_save");
            obj2 = new Intent(((Context) (obj2)), com/socialin/android/activity/SaveToSdCardDialogActivity);
            ((Intent) (obj2)).putExtra("subFolderName", ((myobfuscated.ck.e) (obj)).b(0x7f0808fb));
            ((Intent) (obj2)).putExtra("isReturnResult", true);
            ((myobfuscated.ck.e) (obj)).e.startActivityForResult(((Intent) (obj2)), 1);
            break;

        case 2: // '\002'
            AnalyticUtils.getInstance(((Context) (obj2))).trackLocalAction("effect:cancel_dialog_upload_picsin");
            obj2 = new e._cls5(((myobfuscated.ck.e) (obj)));
            if (((myobfuscated.ck.e) (obj)).j != null)
            {
                ((myobfuscated.ck.e) (obj)).j.a(false, android.graphics.Bitmap.CompressFormat.JPEG, ((Observer) (obj2)));
            }
            break;

        case 3: // '\003'
            AnalyticUtils.getInstance(((Context) (obj2))).trackLocalAction("effect:cancel_dialog_post_fb");
            obj2 = new e._cls6(((myobfuscated.ck.e) (obj)));
            if (((myobfuscated.ck.e) (obj)).j != null)
            {
                ((myobfuscated.ck.e) (obj)).j.a(false, android.graphics.Bitmap.CompressFormat.JPEG, ((Observer) (obj2)));
            }
            break;

        case 4: // '\004'
            AnalyticUtils.getInstance(((Context) (obj2))).trackLocalAction("effect:cancel_dialog_tweet");
            obj2 = new e._cls8(((myobfuscated.ck.e) (obj)));
            if (((myobfuscated.ck.e) (obj)).j != null)
            {
                ((myobfuscated.ck.e) (obj)).j.a(false, android.graphics.Bitmap.CompressFormat.JPEG, ((Observer) (obj2)));
            }
            break;

        case 5: // '\005'
            obj2 = new e._cls7(((myobfuscated.ck.e) (obj)));
            if (((myobfuscated.ck.e) (obj)).j != null)
            {
                ((myobfuscated.ck.e) (obj)).j.a(false, android.graphics.Bitmap.CompressFormat.JPEG, ((Observer) (obj2)));
            }
            break;

        case 6: // '\006'
            AnalyticUtils.getInstance(((Context) (obj2))).trackLocalAction("effect:cancel_dialog_export");
            obj2 = new e._cls9(((myobfuscated.ck.e) (obj)));
            if (((myobfuscated.ck.e) (obj)).j != null)
            {
                ((myobfuscated.ck.e) (obj)).j.a(false, android.graphics.Bitmap.CompressFormat.JPEG, ((Observer) (obj2)));
            }
            break;

        case 7: // '\007'
            AnalyticUtils.getInstance(((Context) (obj2))).trackLocalAction("effect:cancel_dialog_picsartEdit");
            ((myobfuscated.ck.e) (obj)).q();
            break;
        }
          goto _L5
_L10:
        if (((String) (obj3)).equals("button_ok"))
        {
            byte0 = 0;
        }
          goto _L8
_L15:
        if (((String) (obj3)).equals("button_saveSD"))
        {
            byte0 = 1;
        }
          goto _L8
_L9:
        if (((String) (obj3)).equals("button_uploadToPicsinId"))
        {
            byte0 = 2;
        }
          goto _L8
_L14:
        if (((String) (obj3)).equals("button_postFB"))
        {
            byte0 = 3;
        }
          goto _L8
_L13:
        if (((String) (obj3)).equals("button_tweet"))
        {
            byte0 = 4;
        }
          goto _L8
_L11:
        if (((String) (obj3)).equals("button_postInstagram"))
        {
            byte0 = 5;
        }
          goto _L8
_L12:
        if (((String) (obj3)).equals("button_share"))
        {
            byte0 = 6;
        }
          goto _L8
_L16:
        if (((String) (obj3)).equals("button_picsartEdit"))
        {
            byte0 = 7;
        }
          goto _L8
_L5:
        if (false)
        {
        }
        continue; /* Loop/switch isn't completed */
_L7:
        Object obj4 = intent.getExtras();
        String s1 = ((Bundle) (obj4)).getString("selectedFolderName");
        obj3 = ((Bundle) (obj4)).getString("selectedFileName");
        obj4 = ((Bundle) (obj4)).getString("fileExtension");
        (new StringBuilder("selectedFolderName -")).append(s1).append(" selectedFileName -").append(((String) (obj3))).append(" fileExtension -").append(((String) (obj4)));
        e._cls11 _lcls11 = new e._cls11(((myobfuscated.ck.e) (obj)));
        if (((myobfuscated.ck.e) (obj)).j != null)
        {
            ((myobfuscated.ck.e) (obj)).j.a(s1, ((String) (obj3)), ((String) (obj4)), _lcls11);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        byte0 = 0;
        if (true) goto _L18; else goto _L17
_L17:
        if (j1 != -1) goto _L20; else goto _L19
_L19:
        obj3 = intent.getExtras();
        i1;
        JVM INSTR tableswitch 2 9: default 872
    //                   2 873
    //                   3 873
    //                   4 873
    //                   5 873
    //                   6 873
    //                   7 1213
    //                   8 873
    //                   9 873;
           goto _L21 _L22 _L22 _L22 _L22 _L22 _L23 _L22 _L22
_L21:
        return;
_L22:
        i1;
        JVM INSTR tableswitch 3 9: default 916
    //                   3 1112
    //                   4 1119
    //                   5 1126
    //                   6 1133
    //                   7 916
    //                   8 916
    //                   9 1140;
           goto _L24 _L25 _L26 _L27 _L28 _L24 _L24 _L29
_L24:
        intent = "Clone";
_L34:
        if (((Bundle) (obj3)).containsKey("effects_dynamic_processing_time"))
        {
            l1 = ((Bundle) (obj3)).getLong("effects_dynamic_processing_time");
        }
        if (((Bundle) (obj3)).containsKey("effects_default_settings_changed"))
        {
            flag = ((Bundle) (obj3)).getBoolean("effects_default_settings_changed");
        }
        if (!((Bundle) (obj3)).containsKey("effects_color_splash_options")) goto _L31; else goto _L30
_L30:
        obj = new JSONArray(((Bundle) (obj3)).getString("effects_color_splash_options"));
_L32:
        if (((Bundle) (obj3)).containsKey("path"))
        {
            c c1 = new c(((Bundle) (obj3)).getString("path"), 0, null);
            g.a(c1, intent);
        } else
        if (((Bundle) (obj3)).containsKey("result_buffer_Data"))
        {
            c c2 = new c(null, 0, (HashMap)((Bundle) (obj3)).getSerializable("result_buffer_Data"));
            g.a(c2, intent);
        }
        if (i1 == 6 || i1 == 9)
        {
            Activity activity = getActivity();
            if (i1 == 6)
            {
                intent = "effect_color_splash";
            } else
            {
                intent = "effect_color_replace";
            }
            i1 = o.x;
            j1 = o.y;
            obj3 = A;
            getActivity();
            myobfuscated.ay.e.a(activity, intent, i1, j1, flag, true, l1, false, ((JSONArray) (obj)), ((myobfuscated.ck.c) (obj3)).j());
        }
        d(false);
        return;
_L25:
        intent = "Blemish Fix";
        continue; /* Loop/switch isn't completed */
_L26:
        intent = "Red Eye";
        continue; /* Loop/switch isn't completed */
_L27:
        intent = "Color Eye";
        continue; /* Loop/switch isn't completed */
_L28:
        intent = "Color Splash";
        continue; /* Loop/switch isn't completed */
_L29:
        intent = "Color Replace";
        continue; /* Loop/switch isn't completed */
        obj;
        ((JSONException) (obj)).printStackTrace();
_L31:
        obj = null;
          goto _L32
_L23:
        Activity activity1 = getActivity();
        Object obj1;
        HashMap hashmap;
        if (intent.hasExtra("path"))
        {
            obj1 = intent.getExtras().getString("path");
        } else
        {
            obj1 = null;
        }
        hashmap = null;
        if (intent.hasExtra("bufferData"))
        {
            hashmap = (HashMap)((Bundle) (obj3)).getSerializable("bufferData");
        }
        if (obj1 != null || hashmap != null && activity1 != null && !activity1.isFinishing())
        {
            intent = new d(hashmap, ((String) (obj1)), g.f);
            obj1 = d.a("Popart 2");
            if (obj1 != null)
            {
                obj1 = ((myobfuscated.ci.b) (obj1)).a(activity1);
                obj1.a = intent;
                EffectsFactory.setupEffectDrawer(((Effect) (obj1)), o.x, o.y);
                w();
                a(((Effect) (obj1)), false);
                a(((Effect) (obj1)));
                i();
                f.a("Popart 2");
                return;
            } else
            {
                f.a();
                return;
            }
        } else
        {
            f.a();
            return;
        }
_L20:
        f.a();
        return;
        if (true) goto _L34; else goto _L33
_L33:
        if (true) goto _L4; else goto _L35
_L35:
    }

    private void a(int i1, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        Activity activity;
        if (B == null || !B.isShowing())
        {
            if ((activity = getActivity()) != null)
            {
                B = new g(activity);
                B.setMessage(getString(i1));
                android.content.DialogInterface.OnCancelListener oncancellistener1 = oncancellistener;
                if (oncancellistener == null)
                {
                    oncancellistener1 = new android.content.DialogInterface.OnCancelListener() {

                        private a a;

                        public final void onCancel(DialogInterface dialoginterface)
                        {
                            a.L(a);
                        }

            
            {
                a = a.this;
                super();
            }
                    };
                }
                B.setOnCancelListener(oncancellistener1);
                E = oncancellistener1;
                D = i1;
                myobfuscated.f.m.a(activity, B);
                C = true;
                return;
            }
        }
    }

    private void a(View view)
    {
        RecyclerView recyclerview = c(view);
        recyclerview.setAdapter(f);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        view = d(view);
        view.setAdapter(e);
        view.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private a a;

            public final void onItemClick(AdapterView adapterview, View view1, int i1, long l1)
            {
                myobfuscated.ck.a.b(a, i1);
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

    private void a(View view, String s1)
    {
        ImageButton imagebutton;
label0:
        {
            imagebutton = h(view);
            view = f(view);
            if (imagebutton != null && view != null)
            {
                if (s1.compareTo("None") != 0 && !view.isOpened())
                {
                    break label0;
                }
                imagebutton.setVisibility(8);
                x();
            }
            return;
        }
        imagebutton.setVisibility(0);
    }

    private void a(Effect effect)
    {
        EffectsView effectsview = g(((View) (null)));
        Object obj = A;
        obj.b = ((myobfuscated.ck.c) (obj)).b + 1;
        A.i = effect;
        obj = A.i;
        Activity activity = getActivity();
        boolean flag;
        if (obj == null || ((Effect) (obj)).c.size() == 0)
        {
            obj = null;
        } else
        if (((Effect) (obj)).d.compareTo("Cross Proc") == 0)
        {
            obj = new myobfuscated.ch.e(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Cross Proc 2") == 0)
        {
            obj = new f(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Lomo") == 0)
        {
            obj = new j(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Vintage") == 0)
        {
            obj = new t(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Vignette") == 0)
        {
            obj = new s(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("B&W") == 0)
        {
            obj = new myobfuscated.ch.b(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Zoom Blur") == 0)
        {
            obj = new h(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Radial Blur") == 0)
        {
            obj = new myobfuscated.ch.m(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Lens Blur") == 0)
        {
            obj = new i(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Motion") == 0)
        {
            obj = new l(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Shear") == 0)
        {
            obj = new n(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Sketcher1") == 0 || ((Effect) (obj)).d.compareTo("Sketcher2") == 0)
        {
            obj = new myobfuscated.ch.o(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Color gradient") == 0)
        {
            obj = new myobfuscated.ch.d(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Stenciler 1") == 0 || ((Effect) (obj)).d.compareTo("Stenciler 2") == 0 || ((Effect) (obj)).d.compareTo("Stenciler 3") == 0 || ((Effect) (obj)).d.compareTo("Stenciler 4") == 0 || ((Effect) (obj)).d.compareTo("Stenciler 5") == 0 || ((Effect) (obj)).d.compareTo("Stenciler 6") == 0 || ((Effect) (obj)).d.compareTo("Stenciler 7") == 0 || ((Effect) (obj)).d.compareTo("Stenciler 8") == 0)
        {
            obj = new p(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Mirrors") == 0)
        {
            obj = new k(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Caricature") == 0)
        {
            obj = new myobfuscated.ch.c(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Fish Eye") == 0)
        {
            obj = new myobfuscated.ch.g(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Swirled") == 0)
        {
            obj = new r(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Bathroom 2") == 0)
        {
            obj = new myobfuscated.ch.a(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("Water") == 0)
        {
            obj = new u(activity, ((Effect) (obj)).c);
        } else
        if (((Effect) (obj)).d.compareTo("SunlessTan") == 0)
        {
            obj = new myobfuscated.ch.q(activity, ((Effect) (obj)).c);
        } else
        {
            obj = new myobfuscated.cg.h(activity, ((Effect) (obj)).c);
        }
        y = ((myobfuscated.cg.a) (obj));
        if (y != null)
        {
            y.c = this;
        }
        a(y, ((View) (null)));
        if (A.i != null && A.k.d(effect.d))
        {
            flag = y.a();
            effect = A.j;
            if (((com.socialin.android.photo.effects.draw.a) (effect)).o == null)
            {
                effect.o = new myobfuscated.ay.b(((com.socialin.android.photo.effects.draw.a) (effect)).x, ((com.socialin.android.photo.effects.draw.a) (effect)).l, ((com.socialin.android.photo.effects.draw.a) (effect)).j.width(), ((com.socialin.android.photo.effects.draw.a) (effect)).j.height(), flag);
                ((com.socialin.android.photo.effects.draw.a) (effect)).o.a = effect;
            } else
            {
                ((com.socialin.android.photo.effects.draw.a) (effect)).o.e = flag;
            }
            obj = ((com.socialin.android.photo.effects.draw.a) (effect)).o;
            obj.i = (((myobfuscated.ay.b) (obj)).k * 50F) / 100F;
            obj.j = (((myobfuscated.ay.b) (obj)).l * 50F) / 100F;
            ((com.socialin.android.photo.effects.draw.a) (effect)).o.c(((com.socialin.android.photo.effects.draw.a) (effect)).l);
        } else
        {
            A.j.a(false);
        }
        if (A.i != null)
        {
            effect = b;
            obj = A;
            if (((myobfuscated.ck.c) (obj)).i != null)
            {
                flag = ((myobfuscated.ck.c) (obj)).k.b(((myobfuscated.ck.c) (obj)).i.d);
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            effect.a(null, flag);
            if (!A.c())
            {
                b.n();
            }
        } else
        {
            a("None");
        }
        if (effectsview != null)
        {
            effectsview.invalidate();
        }
        b(((View) (null)));
    }

    private void a(Effect effect, boolean flag)
    {
        Object obj1 = y();
        Object obj;
        myobfuscated.cm.h h1;
        int i1;
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        J = flag1;
        v.a();
        obj = v;
        flag1 = effect.e;
        i1 = K;
        h1 = new myobfuscated.cm.h(this, flag);
        obj1 = new myobfuscated.cm.i(((myobfuscated.cm.c) (obj)), effect, ((myobfuscated.cm.c) (obj)).b, flag1, ((myobfuscated.cm.d) (obj1)), new myobfuscated.cm.j(((myobfuscated.cm.c) (obj)), ((myobfuscated.cm.d) (obj1)), i1, h1, flag1));
        obj1.c = ((myobfuscated.cm.c) (obj)).e;
        obj.c = ((myobfuscated.cm.i) (obj1));
        ((myobfuscated.cm.c) (obj)).d.c = true;
        ((myobfuscated.cm.i) (obj1)).executeOnExecutor(((myobfuscated.cm.c) (obj)).a, new Void[] {
            null
        });
        obj = A.k;
        effect = effect.d;
        if (((com.socialin.android.photo.effects.factory.b) (obj)).e.containsKey(effect))
        {
            flag = ((Boolean)((com.socialin.android.photo.effects.factory.b) (obj)).e.get(effect)).booleanValue();
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            a(0x7f080679, new android.content.DialogInterface.OnCancelListener() {

                private a a;

                public final void onCancel(DialogInterface dialoginterface)
                {
                    dialoginterface = a.getActivity();
                    if (dialoginterface != null && !dialoginterface.isFinishing())
                    {
                        Utils.b(dialoginterface, 0x7f08041d);
                    }
                    a.L(a);
                }

            
            {
                a = a.this;
                super();
            }
            });
        }
    }

    private void a(EffectsView effectsview)
    {
        if (effectsview != null && A.d && A.j != null)
        {
            effectsview.setDrawController(A.j);
            effectsview.setEditingData(A.q);
            effectsview.setOrigBitmap(A.j.h);
            effectsview.setupSpenTouch();
        }
    }

    private void a(String s1)
    {
        A.g = s1;
        a(((View) (null)), s1);
    }

    private void a(myobfuscated.cg.a a1, View view)
    {
        Object obj = l(view);
        if (obj != null)
        {
            obj = (LinearLayout)((View) (obj)).findViewById(0x7f100581);
        } else
        {
            obj = null;
        }
        if (((LinearLayout) (obj)).getChildCount() > 0)
        {
            ((LinearLayout) (obj)).removeAllViews();
        }
        view = f(view);
        if (a1 != null && a1.b.size() > 0)
        {
            view.setVisibility(0);
            ((LinearLayout) (obj)).addView(a1.a(new android.widget.LinearLayout.LayoutParams(-1, -2)));
            return;
        } else
        {
            view.setVisibility(8);
            return;
        }
    }

    public static void a(a a1, int i1, int j1, Intent intent)
    {
        a1.a(i1, j1, intent);
    }

    public static void a(a a1, Effect effect, boolean flag)
    {
        if (a1.u()) goto _L2; else goto _L1
_L1:
        Activity activity;
        Object obj;
        Object obj1;
        a1.j();
        activity = a1.getActivity();
        String s1 = effect.d;
        boolean flag2 = a1.A.k.b(s1);
        obj = a1.A.g;
        EffectsDrawController effectsdrawcontroller = a1.A.j.c;
        boolean flag1;
        boolean flag3;
        if ((a1.A.k.b(((String) (obj))) || flag2) && s1.compareTo(((String) (obj))) != 0)
        {
            obj1 = effectsdrawcontroller.k;
            if (flag2)
            {
                if (effectsdrawcontroller.m == com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.SHAPE)
                {
                    effectsdrawcontroller.a(com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH, false);
                    if (a1.b != null)
                    {
                        a1.b.k();
                    }
                }
                ((MaskBrushNew) (obj1)).a(com.picsart.effectnew.MaskBrushNew.BrushDrawMode.DRAW);
                if (s1.compareTo("Teeth whiten") == 0)
                {
                    ((MaskBrushNew) (obj1)).a(4);
                    flag2 = true;
                    flag1 = true;
                } else
                {
                    ((MaskBrushNew) (obj1)).a(2);
                    flag2 = true;
                    flag1 = true;
                }
            } else
            {
                ((MaskBrushNew) (obj1)).a(com.picsart.effectnew.MaskBrushNew.BrushDrawMode.ERASE);
                if (((String) (obj)).compareTo("Teeth whiten") == 0)
                {
                    ((MaskBrushNew) (obj1)).a(2);
                }
                flag2 = false;
                flag1 = true;
            }
        } else
        {
            if (!a1.A.k.c(s1) && effectsdrawcontroller.m == com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.SHAPE)
            {
                effectsdrawcontroller.a(com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH, false);
                if (a1.b != null)
                {
                    a1.b.k();
                }
            }
            flag2 = false;
            flag1 = false;
        }
        obj = a1.A.k;
        effect = effect.d;
        if (((com.socialin.android.photo.effects.factory.b) (obj)).c != null && ((com.socialin.android.photo.effects.factory.b) (obj)).c.containsKey(effect))
        {
            flag3 = ((Boolean)((com.socialin.android.photo.effects.factory.b) (obj)).c.get(effect)).booleanValue();
        } else
        {
            flag3 = false;
        }
        if (flag3)
        {
            a1.A.j.c();
            flag1 = true;
        }
        if (a1.b == null) goto _L4; else goto _L3
_L3:
        effect = a1.b;
        obj = effect.h(null);
        obj1 = effect.i(null);
        if (obj == null || obj1 == null) goto _L4; else goto _L5
_L5:
        if (!((myobfuscated.ck.e) (effect)).f.f()) goto _L7; else goto _L6
_L6:
        ((CompoundButton) (obj1)).setChecked(true);
_L9:
        ((CompoundButton) (obj)).setChecked(false);
_L4:
        a1.a(s1);
        if (a1.b != null)
        {
            effect = a1.b;
            if (s1.compareTo("None") != 0)
            {
                effect.j(null).setEnabled(true);
                if (((myobfuscated.ck.e) (effect)).f.e())
                {
                    effect.g(null).setEnabled(true);
                }
            }
            effect.e(null).invalidate();
            if (a1.A.i != null && a1.A.c())
            {
                if (!a1.A.m)
                {
                    effect = a1.b.h(null);
                    if (effect != null)
                    {
                        effect.performClick();
                    }
                    a1.A.m = true;
                }
            } else
            {
                a1.b.n();
            }
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_614;
        }
        if (flag1)
        {
            effectsdrawcontroller.a(a1.h, flag2, false);
        } else
        {
            a1.A.j.c.b(activity, a1.h);
        }
        a1.A.j.i = false;
_L2:
        return;
_L7:
        if (!((myobfuscated.ck.e) (effect)).f.d()) goto _L9; else goto _L8
_L8:
        ((CompoundButton) (obj1)).setChecked(false);
        ((CompoundButton) (obj)).setChecked(true);
          goto _L4
        Utils.b(activity, 0x7f0805ca);
        return;
    }

    public static void a(a a1, EffectsView effectsview)
    {
        a1.a(effectsview);
    }

    static void a(a a1, String s1)
    {
        a1.a(((View) (null)), s1);
    }

    static void a(a a1, boolean flag, Observer observer, myobfuscated.cm.n n1, String s1, long l1, boolean flag1, 
            JSONArray jsonarray, String s2)
    {
        a1.a(flag, observer, n1, s1, l1, flag1, jsonarray, s2);
    }

    public static void a(a a1, boolean flag, boolean flag1)
    {
        a1.a(flag, flag1);
    }

    private void a(boolean flag, String s1, android.graphics.Bitmap.CompressFormat compressformat, Observer observer)
    {
        Object obj = getActivity();
        if (obj == null || ((Activity) (obj)).isFinishing())
        {
            return;
        }
        A.e = true;
        A.n = true;
        String s2 = A.g;
        s2 = A.k.a(s2);
        if (A.a())
        {
            c c1 = A.l.a();
            obj = v;
            (new myobfuscated.cm.c._cls4(flag, g.f, A.i(), new myobfuscated.cm.l(observer, s2) {

                private Observer a;
                private String b;
                private a c;

                public final void a(Object obj1, boolean flag2, myobfuscated.cm.n n1, long l1)
                {
                    obj1 = c.getActivity();
                    if (obj1 == null || ((Activity) (obj1)).isFinishing())
                    {
                        return;
                    } else
                    {
                        obj1 = c;
                        Observer observer1 = a;
                        String s3 = b;
                        JSONArray jsonarray1 = new JSONArray();
                        myobfuscated.ck.c c3 = a.a(c);
                        c.getActivity().getApplicationContext();
                        a.a(((a) (obj1)), flag2, observer1, n1, s3, l1, true, jsonarray1, c3.j());
                        return;
                    }
                }

            
            {
                c = a.this;
                a = observer;
                b = s1;
                super();
            }
            })).execute(new Object[] {
                c1, compressformat, ((myobfuscated.cm.c) (obj)).b, s1
            });
            return;
        }
        if (z() && l == null)
        {
            Bitmap bitmap = A.j.c.l();
            if (bitmap == null || bitmap.isRecycled())
            {
                A.e = false;
                A.n = false;
                Utils.b(((Activity) (obj)), 0x7f0805ca);
                return;
            }
            myobfuscated.f.m.a(r, bitmap);
            obj = A();
            if (flag)
            {
                s1 = new myobfuscated.cm.n();
                s1.a = bitmap;
                if (bitmap != null && !bitmap.isRecycled())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                compressformat = A;
                getActivity().getApplicationContext();
                a(flag, observer, ((myobfuscated.cm.n) (s1)), s2, 0L, true, ((JSONArray) (obj)), compressformat.j());
                return;
            } else
            {
                ArrayList arraylist1 = A.i();
                v.a(s1, bitmap, compressformat, arraylist1, new myobfuscated.cm.l(observer, s2, ((JSONArray) (obj))) {

                    private Observer a;
                    private String b;
                    private JSONArray c;
                    private a d;

                    public final void a(Object obj1, boolean flag2, myobfuscated.cm.n n1, long l1)
                    {
                        obj1 = d.getActivity();
                        if (obj1 == null || ((Activity) (obj1)).isFinishing())
                        {
                            return;
                        } else
                        {
                            obj1 = d;
                            Observer observer1 = a;
                            String s3 = b;
                            JSONArray jsonarray1 = c;
                            myobfuscated.ck.c c3 = a.a(d);
                            d.getActivity().getApplicationContext();
                            a.a(((a) (obj1)), flag2, observer1, n1, s3, l1, true, jsonarray1, c3.j());
                            return;
                        }
                    }

            
            {
                d = a.this;
                a = observer;
                b = s1;
                c = jsonarray;
                super();
            }
                });
                return;
            }
        }
        if (A.i == null)
        {
            A.e = false;
            A.n = false;
            Utils.b(((Activity) (obj)), 0x7f0805ca);
            return;
        } else
        {
            ArrayList arraylist = A.i();
            JSONArray jsonarray = A();
            myobfuscated.cm.d d1 = y();
            boolean flag1 = A.i.e;
            myobfuscated.cm.c c2 = v;
            Effect effect = A.i;
            ArrayList arraylist2 = A.j.c.m();
            (new myobfuscated.cm.c._cls6(c2, d1, flag1, effect, K, arraylist2, flag, new myobfuscated.cm.l(observer, s2, flag1, jsonarray) {

                private Observer a;
                private String b;
                private boolean c;
                private JSONArray d;
                private a e;

                public final void a(Object obj1, boolean flag2, myobfuscated.cm.n n1, long l1)
                {
                    obj1 = e.getActivity();
                    if (obj1 == null || ((Activity) (obj1)).isFinishing())
                    {
                        return;
                    }
                    obj1 = e;
                    Observer observer1 = a;
                    String s3 = b;
                    JSONArray jsonarray1;
                    myobfuscated.ck.c c3;
                    boolean flag3;
                    if (!c)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    jsonarray1 = d;
                    c3 = a.a(e);
                    e.getActivity().getApplicationContext();
                    a.a(((a) (obj1)), flag2, observer1, n1, s3, l1, flag3, jsonarray1, c3.j());
                }

            
            {
                e = a.this;
                a = observer;
                b = s1;
                c = flag;
                d = jsonarray;
                super();
            }
            }, s1, compressformat, arraylist)).executeOnExecutor(c2.a, new Object[] {
                c2.b
            });
            return;
        }
    }

    private void a(boolean flag, Observer observer, myobfuscated.cm.n n1, String s1, long l1, boolean flag1, 
            JSONArray jsonarray, String s2)
    {
        A.e = false;
        A.n = false;
        if (flag)
        {
            Activity activity = getActivity();
            if (activity != null)
            {
                myobfuscated.ay.e.a(activity.getApplicationContext(), s1, m.x, m.y, J, false, l1, flag1, jsonarray, s2);
            }
        }
        j();
        if (flag)
        {
            observer.update(null, n1);
        } else
        {
            observer = getActivity();
            if (observer != null)
            {
                Utils.b(observer, 0x7f08044b);
                return;
            }
        }
    }

    private void a(boolean flag, boolean flag1)
    {
        boolean flag2 = true;
        Object obj = getActivity();
        if (obj != null && !((Activity) (obj)).isFinishing())
        {
            if (A.j != null)
            {
                A.j.c.a(true);
            }
            if (flag)
            {
                j();
                if (A.j != null)
                {
                    A.j.c();
                    A.j.i = true;
                    A.j.c.a(h);
                }
                if (flag1)
                {
                    Log.e("ex1", "setNone");
                } else
                {
                    obj = b;
                    Button button = ((myobfuscated.ck.e) (obj)).j(null);
                    Button button1 = ((myobfuscated.ck.e) (obj)).j(null);
                    if (!((myobfuscated.ck.e) (obj)).f.a() && !((myobfuscated.ck.e) (obj)).f.e)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    button.setEnabled(flag);
                    if (((myobfuscated.ck.e) (obj)).f.e() && !((myobfuscated.ck.e) (obj)).f.a() && !((myobfuscated.ck.e) (obj)).f.e)
                    {
                        flag = flag2;
                    } else
                    {
                        flag = false;
                    }
                    button1.setEnabled(flag);
                }
                a(((Effect) (null)));
                f.a("None");
                obj = g(((View) (null)));
                if (obj != null)
                {
                    ((EffectsView) (obj)).invalidate();
                    return;
                }
            } else
            {
                Utils.b(((Activity) (obj)), 0x7f0805ca);
                return;
            }
        }
    }

    static boolean a(a a1, boolean flag)
    {
        a1.w = flag;
        return flag;
    }

    public static Bitmap b(a a1)
    {
        return a1.i;
    }

    public static Bitmap b(a a1, Bitmap bitmap)
    {
        a1.j = bitmap;
        return bitmap;
    }

    public static Point b(a a1, Point point)
    {
        a1.o = point;
        return point;
    }

    public static ByteBuffer b(a a1, ByteBuffer bytebuffer)
    {
        a1.p = bytebuffer;
        return bytebuffer;
    }

    private void b(int i1)
    {
        e.a = i1;
        e.notifyDataSetChanged();
        Object obj = d;
        myobfuscated.cl.d d1;
        if (i1 >= 0 && i1 < ((myobfuscated.ci.c) (obj)).a.size())
        {
            obj = (myobfuscated.ci.a)((myobfuscated.ci.c) (obj)).a.get(i1);
        } else
        {
            obj = null;
        }
        d1 = f;
        obj = ((myobfuscated.ci.a) (obj)).b;
        if (obj != d1.a)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        d1.a = ((ArrayList) (obj));
        if (i1 != 0)
        {
            d1.d.clear();
            d1.e.clear();
        }
        f.notifyDataSetChanged();
    }

    private void b(View view)
    {
label0:
        {
            view = k(view);
            if (view != null)
            {
                if (A.i == null)
                {
                    break label0;
                }
                view.setVisibility(0);
            }
            return;
        }
        view.setVisibility(8);
    }

    static void b(a a1, int i1)
    {
        a1.b(i1);
        RecyclerView recyclerview = a1.c(((View) (null)));
        if (recyclerview != null && recyclerview.getLayoutManager() != null)
        {
            ((LinearLayoutManager)recyclerview.getLayoutManager()).scrollToPosition(0);
        }
        a1.i();
    }

    public static Bitmap c(a a1, Bitmap bitmap)
    {
        a1.k = bitmap;
        return bitmap;
    }

    public static Point c(a a1)
    {
        return a1.m;
    }

    private RecyclerView c(View view)
    {
        view = l(view);
        if (view != null)
        {
            return (RecyclerView)view.findViewById(0x7f100579);
        } else
        {
            return null;
        }
    }

    public static ByteBuffer c(a a1, ByteBuffer bytebuffer)
    {
        a1.q = bytebuffer;
        return bytebuffer;
    }

    public static int d(a a1)
    {
        return a1.n;
    }

    public static Bitmap d(a a1, Bitmap bitmap)
    {
        a1.l = bitmap;
        return bitmap;
    }

    private ListView d(View view)
    {
        view = l(view);
        if (view != null)
        {
            return (ListView)view.findViewById(0x7f100582);
        } else
        {
            return null;
        }
    }

    public static ByteBuffer d(a a1, ByteBuffer bytebuffer)
    {
        a1.s = bytebuffer;
        return bytebuffer;
    }

    public static Point e(a a1)
    {
        return a1.o;
    }

    private ImageButton e(View view)
    {
        view = l(view);
        if (view != null)
        {
            return (ImageButton)view.findViewById(0x7f10057b);
        } else
        {
            return null;
        }
    }

    public static Bitmap f(a a1)
    {
        return a1.j;
    }

    private SlidingDrawer f(View view)
    {
        view = l(view);
        if (view != null)
        {
            return (SlidingDrawer)view.findViewById(0x7f10057c);
        } else
        {
            return null;
        }
    }

    public static Bitmap g(a a1)
    {
        return a1.k;
    }

    private EffectsView g(View view)
    {
        view = l(view);
        if (view != null)
        {
            return (EffectsView)view.findViewById(0x7f100577);
        } else
        {
            return null;
        }
    }

    public static Bitmap h(a a1)
    {
        return a1.l;
    }

    private ImageButton h(View view)
    {
        view = l(view);
        if (view != null)
        {
            return (ImageButton)view.findViewById(0x7f100578);
        } else
        {
            return null;
        }
    }

    private Button i(View view)
    {
        view = l(view);
        if (view != null)
        {
            return (Button)view.findViewById(0x7f100580);
        } else
        {
            return null;
        }
    }

    public static void i(a a1)
    {
        a1.b(0);
    }

    private Spinner j(View view)
    {
        view = l(view);
        if (view != null)
        {
            return (Spinner)view.findViewById(0x7f10057f);
        } else
        {
            return null;
        }
    }

    public static myobfuscated.cl.d j(a a1)
    {
        return a1.f;
    }

    private ViewGroup k(View view)
    {
        view = l(view);
        if (view != null)
        {
            return (ViewGroup)view.findViewById(0x7f10057e);
        } else
        {
            return null;
        }
    }

    public static ByteBuffer k(a a1)
    {
        return a1.p;
    }

    private View l(View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = getView();
        }
        return view1;
    }

    public static ByteBuffer l(a a1)
    {
        return a1.q;
    }

    public static boolean m(a a1)
    {
        return a1.t;
    }

    public static EffectsView n(a a1)
    {
        return a1.g(((View) (null)));
    }

    public static void o(a a1)
    {
        a1.a(((View) (null)));
    }

    public static Intent p(a a1)
    {
        return a1.F;
    }

    public static int q(a a1)
    {
        return a1.G;
    }

    public static int r(a a1)
    {
        return a1.H;
    }

    public static Intent s(a a1)
    {
        a1.F = null;
        return null;
    }

    public static Bitmap t(a a1)
    {
        return a1.c;
    }

    private void t()
    {
        if (g.c == null && c != null)
        {
            Log.e("ex1", "effectsFilesManager.getOrigFileInfo() == null && sourceBitmap != null");
            Object obj = g.a("");
            Bitmap bitmap = c;
            getActivity();
            obj = new c(null, 0, com.socialin.android.util.w.a(((String) (obj)), bitmap));
            g.c = ((c) (obj));
        }
    }

    public static void u(a a1)
    {
        if (a1.c != null)
        {
            (a1. new ModernAsyncTask() {

                private a a;

                protected final Object doInBackground(Object aobj[])
                {
                    aobj = myobfuscated.ck.a.w(a).a("");
                    Bitmap bitmap = myobfuscated.ck.a.t(a);
                    a.getActivity();
                    return com.socialin.android.util.w.a(((String) (aobj)), bitmap);
                }

                protected final void onPostExecute(Object obj)
                {
                    obj = (HashMap)obj;
                    Log.e("ex1", "*****************************************");
                    Log.e("ex1", "*****************************************");
                    Activity activity = a.getActivity();
                    if (activity == null || activity.isFinishing())
                    {
                        return;
                    }
                    if (obj != null)
                    {
                        Log.e("ex1", "bufferData != null");
                        obj = new c(null, 0, ((HashMap) (obj)));
                        myobfuscated.ck.a.w(a).c = ((c) (obj));
                    }
                    Log.e("ex1", "*****************************************");
                    Log.e("ex1", "*****************************************");
                }

            
            {
                a = a.this;
                super();
            }
            }).executeOnExecutor(a1.h, new Void[] {
                null
            });
        }
    }

    private boolean u()
    {
        Activity activity = getActivity();
        return z || activity == null || activity.isFinishing();
    }

    private void v()
    {
        if (A.q != null)
        {
            Log.e("ex1", "effectsFragmentInfo.getEditingData() != null");
            EditingData editingdata = A.q;
            editingdata.c = (int)((long)editingdata.c + L.d());
        }
    }

    public static void v(a a1)
    {
        Activity activity = a1.getActivity();
        if (activity != null && !activity.isFinishing())
        {
            Utils.a(activity, 0x7f0805ca);
            a1 = a1.getActivity();
            if (a1 != null && !a1.isFinishing())
            {
                com.socialin.android.picsart.profile.invite.i.a(a1).edit().putBoolean("is_editor_active", false).apply();
                a1.finish();
            }
        }
    }

    public static myobfuscated.cj.b w(a a1)
    {
        return a1.g;
    }

    private void w()
    {
        Spinner spinner = j(((View) (null)));
        Button button = i(((View) (null)));
        K = 0;
        Activity activity = getActivity();
        if (activity != null && spinner != null && button != null)
        {
            spinner.setSelection(K);
            button.setText(com.socialin.android.photo.effects.factory.b.a(K, activity));
        }
    }

    static ListView x(a a1)
    {
        return a1.d(((View) (null)));
    }

    private void x()
    {
        if (A.j != null)
        {
            A.j.a(Boolean.valueOf(false));
            if (!A.e)
            {
                A.j.c.a(true);
            }
            EffectsView effectsview = g(((View) (null)));
            if (effectsview != null)
            {
                effectsview.invalidate();
            }
        }
    }

    static ByteBuffer y(a a1)
    {
        return a1.s;
    }

    private myobfuscated.cm.d y()
    {
        myobfuscated.cm.d d1 = new myobfuscated.cm.d();
        d1.a = i;
        d1.b = j;
        d1.c = k;
        d1.d = l;
        d1.g = p;
        d1.i = q;
        d1.k = u;
        d1.f = o;
        d1.e = m;
        d1.j = s;
        d1.h = r;
        return d1;
    }

    static ByteBuffer z(a a1)
    {
        return a1.r;
    }

    private boolean z()
    {
        return o.x == m.x && o.y == m.y;
    }

    public final myobfuscated.au.b a()
    {
        if (A.i != null)
        {
            return A.i.f;
        } else
        {
            return null;
        }
    }

    public final void a(int i1)
    {
        if (A.j != null)
        {
            A.j.c.l.a(i1);
            EffectsView effectsview = g(((View) (null)));
            if (effectsview != null)
            {
                effectsview.invalidate();
            }
        }
    }

    public final void a(int i1, int j1)
    {
        if (A.i != null && A.k.d(A.i.d))
        {
            EffectParameter.a(A.i.c, i1, j1);
            if (y != null)
            {
                EffectParameter.a(y.b, i1, j1);
            }
            a(A.i, true);
        }
    }

    public final void a(com.picsart.effectnew.EffectShapeDrawerNew.ShapeType shapetype)
    {
        if (A.j != null)
        {
            A.j.c.l.e.m = shapetype;
            shapetype = g(((View) (null)));
            if (shapetype != null)
            {
                shapetype.invalidate();
            }
        }
    }

    public final void a(EffectsDrawHistoryController effectsdrawhistorycontroller, boolean flag)
    {
        boolean flag1 = true;
        EffectsDrawController effectsdrawcontroller;
        int i1;
        boolean flag2;
        if (A.b())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        flag2 = effectsdrawhistorycontroller.c();
        effectsdrawcontroller = A.j.c;
        if (flag)
        {
            myobfuscated.ck.e e1;
            if (flag2)
            {
                effectsdrawcontroller.k.a(com.picsart.effectnew.MaskBrushNew.BrushDrawMode.DRAW);
            } else
            {
                effectsdrawcontroller.k.a(com.picsart.effectnew.MaskBrushNew.BrushDrawMode.ERASE);
            }
            effectsdrawcontroller.p = flag2;
        }
        e1 = b;
        if (effectsdrawhistorycontroller.a.size() > i1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        effectsdrawhistorycontroller = e1.a(null);
        if (effectsdrawhistorycontroller != null)
        {
            effectsdrawhistorycontroller.setEnabled(flag);
        }
        effectsdrawhistorycontroller = b.b(null);
        if (effectsdrawhistorycontroller != null)
        {
            effectsdrawhistorycontroller.setChecked(flag2);
        }
        effectsdrawhistorycontroller = b;
        if (((myobfuscated.ck.e) (effectsdrawhistorycontroller)).g != null)
        {
            ((myobfuscated.ck.e) (effectsdrawhistorycontroller)).g.b(null);
        }
        effectsdrawhistorycontroller = b;
        if (effectsdrawcontroller.k.v == com.picsart.effectnew.MaskBrushNew.BrushDrawMode.ERASE)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        effectsdrawhistorycontroller.a(flag);
    }

    public final void a(com.picsart.effectnew.b b1)
    {
        if (A.j != null)
        {
            Object obj = A.q;
            obj.d = ((EditingData) (obj)).d + 1;
            obj = A.j.b();
            ((MaskBrushNew) (obj)).b(b1.b);
            ((MaskBrushNew) (obj)).a(b1.c);
            ((MaskBrushNew) (obj)).a(b1.a);
        }
    }

    public final void a(String s1, String s2, View view, ImageView imageview, TextView textview)
    {
label0:
        {
            if (I != null)
            {
                com.socialin.android.photo.effects.factory.b b1 = A.k;
                boolean flag;
                if (b1.f.containsKey(s1) && ((Boolean)b1.f.get(s1)).booleanValue())
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                if (!flag)
                {
                    break label0;
                }
                imageview.setTag(s1);
                textview.setTag(s2);
                s1 = I;
                myobfuscated.f.m.f().a(view, ((myobfuscated.ck.d) (s1)).g);
            }
            return;
        }
        imageview.setTag(null);
        textview.setTag(null);
        myobfuscated.ck.d.a(view);
    }

    public final void a(String s1, String s2, String s3, Observer observer)
    {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        if (com.socialin.android.util.w.a(activity))
        {
            s2 = (new StringBuilder()).append(s2).append(s3).toString();
            s2 = (new StringBuilder()).append(s1).append("/").append(s2).toString();
            s1 = android.graphics.Bitmap.CompressFormat.JPEG;
            if (s3.equalsIgnoreCase(".png"))
            {
                s1 = android.graphics.Bitmap.CompressFormat.PNG;
            }
            a(false, s2, ((android.graphics.Bitmap.CompressFormat) (s1)), observer);
            a(0x7f080573, ((android.content.DialogInterface.OnCancelListener) (null)));
            return;
        } else
        {
            Utils.a(activity, 0x7f0805a0);
            return;
        }
    }

    public final void a(ArrayList arraylist, boolean flag)
    {
        if (A.i != null)
        {
            Object obj = A.i.f;
            if (obj != null)
            {
                obj.f = flag;
            }
            if (!flag)
            {
                obj = A.q;
                obj.d = ((EditingData) (obj)).d + 1;
                obj = A.i;
                Log.e("ex1", "Effect setParameters");
                if (((Effect) (obj)).c != arraylist)
                {
                    Log.e("ex1", "this.parameters != parameters");
                } else
                {
                    Log.e("ex1", "this.parameters == parameters");
                }
                obj.c = arraylist;
                if (((Effect) (obj)).f != null)
                {
                    ((Effect) (obj)).f.a(arraylist);
                }
                a(A.i, true);
            } else
            if (obj != null)
            {
                ((myobfuscated.au.b) (obj)).a(arraylist);
                ((myobfuscated.au.b) (obj)).a(o.x, o.y);
                arraylist = g(((View) (null)));
                if (arraylist != null)
                {
                    arraylist.invalidate();
                    return;
                }
            }
        }
    }

    public final void a(myobfuscated.ci.b b1, int i1)
    {
        if (I != null)
        {
            myobfuscated.ck.d d1 = I;
            d1.j = 0L;
            if (d1.f != null)
            {
                d1.f.setVisibility(8);
            }
        }
        Object obj = A.q;
        obj.l = ((EditingData) (obj)).l + 1;
        Log.e("ex1", (new StringBuilder("effect clicked name = ")).append(b1.a).toString());
        Log.e("ex1", (new StringBuilder("position = ")).append(i1).toString());
        obj = b1.a;
        if (A.e && (!A.n || ((String) (obj)).compareTo("None") == 0))
        {
            a(0x7f080679, ((android.content.DialogInterface.OnCancelListener) (null)));
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        Activity activity;
        return;
_L2:
        if ((activity = getActivity()) == null) goto _L1; else goto _L3
_L3:
        if (!b1.b) goto _L5; else goto _L4
_L4:
        com.socialin.android.photo.effects.factory.b b2 = A.k;
        String s1 = b1.a;
        boolean flag;
        if (b2.d.containsKey(s1))
        {
            flag = ((Boolean)b2.d.get(s1)).booleanValue();
        } else
        {
            flag = false;
        }
        if (flag) goto _L5; else goto _L6
_L6:
        b1 = b1.a(activity);
        EffectsFactory.setupEffectDrawer(b1, o.x, o.y);
        w();
        a(((Effect) (b1)), false);
_L7:
        a(((Effect) (b1)));
        i();
        return;
_L5:
label0:
        {
            if (b1.a.compareTo("None") == 0)
            {
                break label0;
            }
            b1 = b1.a;
            t();
            c c1 = g.a();
            if (c1 != null)
            {
                if (c1.a == null && c1.c == null)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                if (i1 == 0)
                {
                    Object obj1 = getActivity();
                    myobfuscated.ay.e.a(((Context) (obj1)), b1, o.x, o.y, 0L);
                    if (b1.compareTo("Clone") == 0)
                    {
                        b1 = a(myobfuscated.f.m.c());
                        b1.putExtra("openedFromEffects", true);
                        b1.putExtra("buffer_to_save", g.a(""));
                        obj1 = A;
                        getActivity().getApplicationContext();
                        b1.putExtra("recent_orig_file_path", ((myobfuscated.ck.c) (obj1)).k());
                        if (A.q != null)
                        {
                            b1.putExtra("editing_data", A.q);
                        }
                        startActivityForResult(b1, 2);
                        return;
                    }
                    if (b1.compareTo("Red Eye") == 0)
                    {
                        if (SocialinV3.getInstance().getAppProps() != null && SocialinV3.getInstance().getAppProps().getProcess().equals("multy"))
                        {
                            b1 = com/picsart/effects/redeyeremover/RedEyeRemoverActivity;
                        } else
                        {
                            b1 = com/picsart/effects/redeyeremover/RedEyeRemoverActivityMainProcess;
                        }
                        b1 = a(((Class) (b1)));
                        b1.putExtra("buffer_to_save", g.a(""));
                        obj1 = A;
                        getActivity().getApplicationContext();
                        b1.putExtra("recent_orig_file_path", ((myobfuscated.ck.c) (obj1)).k());
                        if (A.q != null)
                        {
                            b1.putExtra("editing_data", A.q);
                        }
                        startActivityForResult(b1, 4);
                        return;
                    }
                    if (b1.compareTo("Blemish Fix") == 0)
                    {
                        if (SocialinV3.getInstance().getAppProps() != null && SocialinV3.getInstance().getAppProps().getProcess().equals("multy"))
                        {
                            b1 = com/picsart/effects/blemishfix/BlemishFixActivity;
                        } else
                        {
                            b1 = com/picsart/effects/blemishfix/BlemishFixActivityMainProcess;
                        }
                        b1 = a(((Class) (b1)));
                        b1.putExtra("buffer_to_save", g.a(""));
                        obj1 = A;
                        getActivity().getApplicationContext();
                        b1.putExtra("recent_orig_file_path", ((myobfuscated.ck.c) (obj1)).k());
                        if (A.q != null)
                        {
                            b1.putExtra("editing_data", A.q);
                        }
                        startActivityForResult(b1, 3);
                        return;
                    }
                    if (b1.compareTo("Color Eye") == 0)
                    {
                        if (SocialinV3.getInstance().getAppProps() != null && SocialinV3.getInstance().getAppProps().getProcess().equals("multy"))
                        {
                            b1 = com/picsart/effects/eyereplacer/EyeReplacerActivity;
                        } else
                        {
                            b1 = com/picsart/effects/eyereplacer/EyeReplacerActivityMainProcess;
                        }
                        b1 = a(((Class) (b1)));
                        b1.putExtra("buffer_to_save", g.a(""));
                        obj1 = A;
                        getActivity().getApplicationContext();
                        b1.putExtra("recent_orig_file_path", ((myobfuscated.ck.c) (obj1)).k());
                        if (A.q != null)
                        {
                            b1.putExtra("editing_data", A.q);
                        }
                        startActivityForResult(b1, 5);
                        return;
                    }
                    if (b1.compareTo("Color Splash") == 0)
                    {
                        b1 = a(myobfuscated.f.m.b());
                        b1.putExtra("buffer_to_save", g.a(""));
                        b1.putExtra("effectMode", 1);
                        if (A.q != null)
                        {
                            b1.putExtra("editing_data", A.q);
                        }
                        startActivityForResult(b1, 6);
                        return;
                    }
                    if (b1.compareTo("Color Replace") == 0)
                    {
                        b1 = a(myobfuscated.f.m.b());
                        b1.putExtra("buffer_to_save", g.a(""));
                        b1.putExtra("effectMode", 0);
                        if (A.q != null)
                        {
                            b1.putExtra("editing_data", A.q);
                        }
                        startActivityForResult(b1, 9);
                        return;
                    }
                    if (b1.compareTo("Popart 2") == 0)
                    {
                        b1 = g.a();
                        i1 = Math.round((float)m.x / 4F);
                        int j1 = m.y;
                        myobfuscated.ay.e.a(((Activity) (obj1)), this, ((c) (b1)).a, ((c) (b1)).b, ((c) (b1)).c, i1, j1, g.f);
                        return;
                    }
                }
            }
        }
          goto _L1
        d(true);
        b1 = null;
          goto _L7
    }

    public final void a(boolean flag)
    {
        if (flag)
        {
            a(0x7f080679, ((android.content.DialogInterface.OnCancelListener) (null)));
            return;
        } else
        {
            j();
            return;
        }
    }

    public final void a(boolean flag, android.graphics.Bitmap.CompressFormat compressformat, Observer observer)
    {
        Activity activity;
label0:
        {
            activity = getActivity();
            if (activity != null && !activity.isFinishing())
            {
                if (!com.socialin.android.util.w.a(activity))
                {
                    break label0;
                }
                String s1;
                if (compressformat == android.graphics.Bitmap.CompressFormat.PNG)
                {
                    s1 = ".png";
                } else
                {
                    s1 = ".jpg";
                }
                s1 = (new StringBuilder()).append(activity.getString(0x7f0808fc)).append("_").append(System.currentTimeMillis()).append(s1).toString();
                a(flag, (new StringBuilder()).append(g.a).append(s1).toString(), compressformat, observer);
                a(0x7f080573, ((android.content.DialogInterface.OnCancelListener) (null)));
            }
            return;
        }
        Utils.a(activity, 0x7f0805a0);
    }

    public final void b(int i1, int j1)
    {
        if (A.i != null)
        {
            String s1 = A.i.d;
            if (A.k.d(s1))
            {
                Object obj = A.i.f;
                if (obj != null)
                {
                    ((myobfuscated.au.b) (obj)).b(i1, j1);
                    ((myobfuscated.au.b) (obj)).a(o.x, o.y);
                    obj = g(((View) (null)));
                    if (obj != null)
                    {
                        ((EffectsView) (obj)).invalidate();
                    }
                }
            }
        }
    }

    public final void b(boolean flag)
    {
        if (A.j != null)
        {
            A.j.a(flag);
            EffectsView effectsview = g(((View) (null)));
            if (effectsview != null)
            {
                effectsview.invalidate();
            }
        }
    }

    public final boolean b()
    {
        return getView() != null;
    }

    public final void c(boolean flag)
    {
        if (!u()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        j();
        if (A.j != null)
        {
            A.j.c.a(true);
        }
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        a(((Effect) (null)));
        if (A.j != null)
        {
            A.j.c();
            A.j.i = true;
            EffectsDrawController effectsdrawcontroller = A.j.c;
            effectsdrawcontroller.a(com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH, false);
            effectsdrawcontroller.a(h);
            A.j.a(false);
        }
        b.o();
        f.a("None");
_L4:
        EffectsView effectsview = g(((View) (null)));
        if (effectsview != null)
        {
            effectsview.invalidate();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        Activity activity = getActivity();
        if (activity != null)
        {
            Utils.b(activity, 0x7f0805ca);
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public final boolean c()
    {
        return A.e;
    }

    public final void d(boolean flag)
    {
        if (A.j != null)
        {
            A.j.a(false);
            EffectsDrawController effectsdrawcontroller = A.j.c;
            effectsdrawcontroller.a(com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH, false);
            effectsdrawcontroller.a(false);
        }
        Object obj1 = b;
        ((myobfuscated.ck.e) (obj1)).n();
        Object obj = ((myobfuscated.ck.e) (obj1)).j(null);
        obj1 = ((myobfuscated.ck.e) (obj1)).j(null);
        ((View) (obj)).setEnabled(false);
        ((View) (obj1)).setEnabled(false);
        v.a();
        obj = g.c;
        if (!flag)
        {
            obj = g.d;
        }
        A.e = true;
        a("None");
        Object obj2 = y();
        if (flag && c != null && !c.isRecycled())
        {
            Bitmap bitmap = com.socialin.android.util.c.b(c, android.graphics.Bitmap.Config.ARGB_8888);
            obj1 = bitmap;
            if (bitmap == null)
            {
                a(false, flag);
                return;
            }
        } else
        {
            obj1 = null;
        }
        myobfuscated.cm.c c1 = v;
        int i1 = g.f;
        obj1 = new myobfuscated.cm.c._cls3(c1, ((Bitmap) (obj1)), new myobfuscated.cm.m(this, flag));
        Bitmap bitmap1 = ((myobfuscated.cm.d) (obj2)).a;
        Bitmap bitmap2 = ((myobfuscated.cm.d) (obj2)).d;
        Bitmap bitmap3 = ((myobfuscated.cm.d) (obj2)).b;
        obj2 = ((myobfuscated.cm.d) (obj2)).g;
        ((ModernAsyncTask) (obj1)).executeOnExecutor(c1.a, new Object[] {
            obj, Integer.valueOf(i1), bitmap1, bitmap2, bitmap3, obj2
        });
        a(0x7f080679, ((android.content.DialogInterface.OnCancelListener) (null)));
    }

    public final boolean d()
    {
        return A.c;
    }

    public final boolean e()
    {
        return A.a();
    }

    public final boolean f()
    {
        return A.e();
    }

    public final void g()
    {
label0:
        {
            Log.e("ex1", "fragment spenSwitchMode");
            if (A.j != null)
            {
                if (A.j.b().v != com.picsart.effectnew.MaskBrushNew.BrushDrawMode.ERASE)
                {
                    break label0;
                }
                b.m();
            }
            return;
        }
        b.l();
    }

    public final void h()
    {
        Log.e("ex1", "fragment spenSetBrushEraseMode");
        b.l();
    }

    public final boolean i()
    {
        ListView listview = d(((View) (null)));
        Activity activity;
        for (activity = getActivity(); listview == null || listview.getVisibility() != 0;)
        {
            return false;
        }

        Animation animation = AnimationUtils.loadAnimation(activity, 0x7f04002d);
        animation.setAnimationListener(x);
        listview.startAnimation(animation);
        e(((View) (null))).startAnimation(AnimationUtils.loadAnimation(activity, 0x7f04003e));
        w = false;
        return true;
    }

    public final void j()
    {
        if (B != null && B.isShowing())
        {
            myobfuscated.f.m.b(getActivity(), B);
            C = false;
        }
    }

    public final void k()
    {
        if (A.j != null)
        {
            A.j.c.a(com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH, true);
            EffectsView effectsview = g(((View) (null)));
            if (effectsview != null)
            {
                effectsview.invalidate();
            }
        }
    }

    public final void l()
    {
        if (A.j != null)
        {
            A.j.c.a(com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.SHAPE, true);
            EffectsView effectsview = g(((View) (null)));
            if (effectsview != null)
            {
                effectsview.invalidate();
            }
        }
    }

    public final void m()
    {
        Object obj = A.q;
        obj.d = ((EditingData) (obj)).d + 1;
        obj = A.j.c.n;
        if (A.b())
        {
            ((EffectsDrawHistoryController) (obj)).a.size();
        }
        obj = getActivity();
        ThreadPoolExecutor threadpoolexecutor = h;
        A.j.c.a(((Activity) (obj)), threadpoolexecutor);
    }

    public final void n()
    {
        Object obj = A.q;
        obj.d = ((EditingData) (obj)).d + 1;
        getActivity();
        obj = h;
        A.j.c.a(((ThreadPoolExecutor) (obj)), A.b(), true);
    }

    public final void o()
    {
        Object obj = A.q;
        obj.d = ((EditingData) (obj)).d + 1;
        obj = getActivity();
        ThreadPoolExecutor threadpoolexecutor = h;
        A.j.c.a(((Activity) (obj)), threadpoolexecutor, null, com.picsart.effectnew.EffectsDrawHistoryController.HistoryTaskAction.HistoryTaskActionAddMaskInvert);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (C && A.d)
        {
            B = null;
            a(D, E);
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (!A.d)
        {
            if (j1 == -1)
            {
                F = intent;
                G = i1;
                H = j1;
            }
            return;
        } else
        {
            a(i1, j1, intent);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Activity activity = getActivity();
        L = new TimeCalculator();
        A = new myobfuscated.ck.c();
        A.r = c;
        g = new myobfuscated.cj.b(activity.getApplicationContext());
        A.l = g;
        Object obj1;
        Object obj3;
        Bundle bundle1;
        int j1;
        if (bundle == null)
        {
            Log.e("ex1", "bundle == null");
            bundle1 = getArguments();
        } else
        {
            Log.e("ex1", "bundle != null");
            bundle1 = bundle;
        }
        bundle = A;
        if (bundle1 != null)
        {
            if (bundle1.containsKey("maskBufferData"))
            {
                bundle.o = (HashMap)bundle1.getSerializable("maskBufferData");
            }
            bundle.p = bundle1.getString("origin");
            ArrayList arraylist;
            myobfuscated.cj.b b1;
            int k1;
            if (bundle1.containsKey("editing_data"))
            {
                bundle.q = (EditingData)bundle1.getParcelable("editing_data");
            } else
            {
                bundle.q = EditingData.a(null);
            }
        }
        b1 = g;
        obj3 = null;
        j1 = 0;
        obj1 = new ArrayList();
        if (bundle1 != null)
        {
            Object obj2 = bundle1.getString("effects_apply_main_dir", null);
            Object obj;
            Object obj4;
            Object obj5;
            int i1;
            if (bundle1.containsKey("bufferData"))
            {
                bundle = (HashMap)bundle1.getSerializable("bufferData");
            } else
            {
                bundle = null;
            }
            obj4 = bundle1.getString("path");
            i1 = bundle1.getInt("degree");
            if (bundle != null)
            {
                Log.e("ex1", "origFileBufferData != null");
            }
            if (obj4 != null)
            {
                Log.e("ex1", "path != null");
            }
            b1.f = bundle1.getInt("pixelsMaxCount");
            obj5 = bundle1.getString("apply_path");
            j1 = bundle1.getInt("apply_degree");
            if (bundle1.containsKey("apply_bufferData"))
            {
                obj = (HashMap)bundle1.getSerializable("apply_bufferData");
            } else
            {
                obj = null;
            }
            if (bundle1.containsKey("applied_effect_names"))
            {
                arraylist = bundle1.getStringArrayList("applied_effect_names");
                obj1 = obj5;
                obj3 = obj4;
                obj4 = bundle;
                bundle = arraylist;
                k1 = j1;
                obj5 = obj2;
                j1 = i1;
                obj2 = obj;
                i1 = k1;
                obj = bundle;
                bundle = ((Bundle) (obj5));
            } else
            {
                obj3 = obj;
                obj = obj2;
                obj2 = obj5;
                int l1 = i1;
                obj5 = bundle;
                bundle = ((Bundle) (obj));
                obj = obj1;
                i1 = j1;
                obj1 = obj2;
                obj2 = obj3;
                j1 = l1;
                obj3 = obj4;
                obj4 = obj5;
            }
        } else
        {
            Log.e("ex1", "setupFromBundle bundle == null");
            obj5 = null;
            obj2 = null;
            i1 = 0;
            obj = obj1;
            bundle = null;
            obj4 = null;
            obj1 = obj5;
        }
        obj5 = bundle;
        if (bundle == null)
        {
            obj5 = myobfuscated.ay.e.a(b1.e, System.currentTimeMillis());
        }
        b1.b = ((String) (obj5));
        if (obj3 != null || obj4 != null)
        {
            b1.c = new c(((String) (obj3)), j1, ((HashMap) (obj4)));
        }
        if (obj2 != null || obj1 != null)
        {
            b1.d = new c(((String) (obj1)), i1, ((HashMap) (obj2)));
            b1.d.d = ((ArrayList) (obj));
        }
        n = myobfuscated.ay.e.b(activity);
        t = RenderScriptUnsupportDevice.setupAndGetRenderScriptSupport(activity);
        Log.e("ex1", "**********************");
        Log.e("ex1", "**********************");
        Log.e("ex1", (new StringBuilder("useRenderScript = ")).append(t).toString());
        Log.e("ex1", "**********************");
        Log.e("ex1", "**********************");
        bundle = (SocialinApplication)activity.getApplication();
        if (t)
        {
            Log.e("ex1", "getEffectsThreadPoolExecutor");
            if (((SocialinApplication) (bundle)).d == null)
            {
                bundle.d = (ThreadPoolExecutor)Executors.newFixedThreadPool(1);
            }
            h = ((SocialinApplication) (bundle)).d;
        } else
        {
            Log.e("ex1", "new Executor");
            h = (ThreadPoolExecutor)Executors.newFixedThreadPool(1);
        }
        v = new myobfuscated.cm.c(activity.getApplicationContext(), h, A);
        d = new myobfuscated.ci.c(activity.getApplicationContext());
        A.h = d;
        A.k = new com.socialin.android.photo.effects.factory.b(activity.getApplicationContext());
        bundle = activity.getApplicationContext();
        if (e == null)
        {
            e = new myobfuscated.cl.c(d.b, A.k);
        }
        if (f == null)
        {
            f = new myobfuscated.cl.d(bundle, A.k);
            f.c = this;
        }
        x = new af() {

            private a a;

            public final void onAnimationEnd(Animation animation)
            {
                super.onAnimationEnd(animation);
                animation = a.x(a);
                if (animation != null)
                {
                    animation.setVisibility(8);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        b = new myobfuscated.ck.e(this, A);
        bundle = b;
        bundle.a = bundle1.getBoolean("isReturn", false);
        bundle.b = bundle1.getBoolean("closeAfterEdit", false);
        bundle.c = bundle1.getBoolean("FX_SAVE_RESULT_AS_BUFFER", false);
        bundle.d = bundle1.getBoolean("FX_SAVE_RESULT_TO_RECENTS", false);
        b.j = this;
        (new myobfuscated.cm.a(activity.getApplicationContext(), c, g.c, g.d, g.f, new myobfuscated.cm.b(this, activity))).executeOnExecutor(h, new Void[] {
            null
        });
        a(0x7f080548, ((android.content.DialogInterface.OnCancelListener) (null)));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        boolean flag1 = true;
        viewgroup = layoutinflater.inflate(0x7f030106, viewgroup, false);
        c(viewgroup).setHasFixedSize(true);
        layoutinflater = c(viewgroup);
        if (layoutinflater != null)
        {
            bundle = getActivity();
            layoutinflater.setHasFixedSize(true);
            bundle = new LinearLayoutManager(bundle);
            Object obj;
            Object obj1;
            int i1;
            boolean flag;
            if (getResources().getConfiguration().orientation == 1)
            {
                i1 = 0;
            } else
            {
                i1 = 1;
            }
            bundle.setOrientation(i1);
            layoutinflater.setLayoutManager(bundle);
        }
        layoutinflater = getActivity();
        bundle = c(viewgroup);
        bundle.setAdapter(f);
        bundle.setItemAnimator(new DefaultItemAnimator());
        if (A.d)
        {
            a(viewgroup);
        }
        bundle = e(viewgroup);
        if (w)
        {
            obj = d(viewgroup);
            ((ListView) (obj)).setVisibility(0);
            ((ListView) (obj)).startAnimation(AnimationUtils.loadAnimation(layoutinflater, 0x7f04002e));
            bundle.startAnimation(AnimationUtils.loadAnimation(layoutinflater, 0x7f04003f));
        }
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            private a a;

            public final void onClick(View view)
            {
                view = a.x(a);
                ImageButton imagebutton = a.C(a);
                Activity activity = a.getActivity();
                if (activity == null || view == null || imagebutton == null)
                {
                    return;
                }
                if (view.getVisibility() == 8)
                {
                    view.setVisibility(0);
                    view.startAnimation(AnimationUtils.loadAnimation(activity, 0x7f04002e));
                    imagebutton.startAnimation(AnimationUtils.loadAnimation(activity, 0x7f04003f));
                    a.a(a, true);
                    return;
                } else
                {
                    Animation animation = AnimationUtils.loadAnimation(activity, 0x7f04002d);
                    animation.setAnimationListener(a.D(a));
                    view.startAnimation(animation);
                    imagebutton.startAnimation(AnimationUtils.loadAnimation(activity, 0x7f04003e));
                    a.a(a, false);
                    return;
                }
            }

            
            {
                a = a.this;
                super();
            }
        });
        if (y != null)
        {
            y.a = layoutinflater;
        }
        a(y, viewgroup);
        a(g(viewgroup));
        bundle = h(viewgroup);
        bundle.setOnTouchListener(new android.view.View.OnTouchListener() {

            private a a;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getPointerCount() > 1) goto _L2; else goto _L1
_L1:
                motionevent.getAction();
                JVM INSTR tableswitch 0 3: default 44
            //                           0 46
            //                           1 77
            //                           2 44
            //                           3 77;
                   goto _L3 _L4 _L2 _L3 _L2
_L3:
                return false;
_L4:
                view = a.a(a).q;
                view.d = ((EditingData) (view)).d + 1;
                a.F(a);
                continue; /* Loop/switch isn't completed */
_L2:
                a.E(a);
                if (true) goto _L3; else goto _L5
_L5:
            }

            
            {
                a = a.this;
                super();
            }
        });
        obj = f(viewgroup);
        ((SlidingDrawer) (obj)).setOnDrawerOpenListener(new android.widget.SlidingDrawer.OnDrawerOpenListener() {

            private a a;

            public final void onDrawerOpened()
            {
                a.a(a, a.a(a).g);
            }

            
            {
                a = a.this;
                super();
            }
        });
        ((SlidingDrawer) (obj)).setOnDrawerCloseListener(new android.widget.SlidingDrawer.OnDrawerCloseListener() {

            private a a;

            public final void onDrawerClosed()
            {
                a.a(a, a.a(a).g);
            }

            
            {
                a = a.this;
                super();
            }
        });
        a(bundle, A.g);
        a(viewgroup, A.g);
        bundle = j(viewgroup);
        obj = i(viewgroup);
        obj1 = com.socialin.android.photo.effects.factory.b.a(layoutinflater);
        ((Button) (obj)).setText((String)((ArrayList) (obj1)).get(K));
        layoutinflater = new myobfuscated.ay.d(layoutinflater, ((ArrayList) (obj1)));
        layoutinflater.setDropDownViewResource(0x7f03024f);
        bundle.setAdapter(layoutinflater);
        bundle.setSelection(K);
        bundle.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            public final a a;

            public final void onItemSelected(AdapterView adapterview, View view, int j1, long l1)
            {
                adapterview = a.getActivity();
                if (adapterview != null && !adapterview.isFinishing())
                {
                    Log.e("ex1", (new StringBuilder("onItemSelected position = ")).append(j1).toString());
                    if (a.G(a) != j1)
                    {
                        a.a(a);
                        adapterview = com.socialin.android.photo.effects.factory.b.a(j1, adapterview);
                        view = a.H(a);
                        if (view != null)
                        {
                            view.setText(adapterview);
                        }
                        a.a(a, j1);
                        adapterview = a.a(a).i;
                        if (adapterview != null)
                        {
                            view = a.J(a);
                            (new myobfuscated.cm.c._cls1(a.I(a), a.G(a), new myobfuscated.cm.k(this, adapterview))).executeOnExecutor(((myobfuscated.cm.c) (view)).a, new Void[] {
                                null
                            });
                        }
                        Log.e("ex1", "onItemSelected END");
                        return;
                    }
                }
            }

            public final void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                a = a.this;
                super();
            }
        });
        ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            private a a;

            public final void onClick(View view)
            {
                view = a.K(a);
                if (view != null)
                {
                    view.performClick();
                }
            }

            
            {
                a = a.this;
                super();
            }
        });
        b(viewgroup);
        k(viewgroup).setVisibility(0);
        if (myobfuscated.bw.a.a())
        {
            if (I == null)
            {
                I = new myobfuscated.ck.d(getActivity().getApplicationContext(), A);
                layoutinflater = I;
                layoutinflater.m = new d._cls1(layoutinflater);
                layoutinflater.k = new d._cls2(layoutinflater);
                layoutinflater.h = new d._cls3(layoutinflater);
                layoutinflater.g = new d._cls4(layoutinflater);
            }
            layoutinflater = I;
            layoutinflater.d = (ImageView)viewgroup.findViewById(0x7f1005cd);
            layoutinflater.e = (TextView)viewgroup.findViewById(0x7f1005ce);
            layoutinflater.f = (RelativeLayout)viewgroup.findViewById(0x7f1005cc);
            layoutinflater.i = (TextView)viewgroup.findViewById(0x7f1006b6);
            layoutinflater = I;
            bundle = (CompoundButton)viewgroup.findViewById(0x7f1006f9);
            obj = (CompoundButton)viewgroup.findViewById(0x7f100762);
            myobfuscated.f.m.f().a(bundle, ((myobfuscated.ck.d) (layoutinflater)).h);
            myobfuscated.f.m.f().a(((View) (obj)), ((myobfuscated.ck.d) (layoutinflater)).h);
            myobfuscated.f.m.f().a(viewgroup.findViewById(0x7f10018b), ((myobfuscated.ck.d) (layoutinflater)).h);
            myobfuscated.f.m.f().a(viewgroup.findViewById(0x7f100136), ((myobfuscated.ck.d) (layoutinflater)).h);
            myobfuscated.f.m.f().a(viewgroup.findViewById(0x7f10018c), ((myobfuscated.ck.d) (layoutinflater)).h);
            myobfuscated.f.m.f().a(viewgroup.findViewById(0x7f100761), ((myobfuscated.ck.d) (layoutinflater)).h);
            myobfuscated.f.m.f().a(viewgroup.findViewById(0x7f100540), ((myobfuscated.ck.d) (layoutinflater)).h);
        }
        b.k = I;
        bundle = b;
        obj = new myobfuscated.ck.b(this);
        layoutinflater = bundle.k(viewgroup);
        if (layoutinflater != null)
        {
            layoutinflater = (ImageButton)layoutinflater.findViewById(0x7f100540);
        } else
        {
            layoutinflater = null;
        }
        layoutinflater.setOnClickListener(new e._cls1(bundle, ((myobfuscated.ck.b) (obj))));
        layoutinflater = bundle.j(viewgroup);
        if (!((myobfuscated.ck.e) (bundle)).f.a() && !((myobfuscated.ck.e) (bundle)).f.e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        layoutinflater.setEnabled(flag);
        layoutinflater.setOnClickListener(new e._cls12(bundle));
        obj = bundle.h(viewgroup);
        obj1 = bundle.i(viewgroup);
        if (((myobfuscated.ck.e) (bundle)).f.a() || !((myobfuscated.ck.e) (bundle)).f.c())
        {
            ((CompoundButton) (obj)).setChecked(false);
            ((CompoundButton) (obj1)).setChecked(false);
        } else
        if (((myobfuscated.ck.e) (bundle)).f.d())
        {
            ((CompoundButton) (obj)).setChecked(true);
            ((CompoundButton) (obj1)).setChecked(false);
        } else
        {
            ((CompoundButton) (obj1)).setChecked(true);
            ((CompoundButton) (obj)).setChecked(false);
        }
        layoutinflater = bundle.g(viewgroup);
        if (((myobfuscated.ck.e) (bundle)).f.e() && !((myobfuscated.ck.e) (bundle)).f.a() && !((myobfuscated.ck.e) (bundle)).f.e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        layoutinflater.setEnabled(flag);
        layoutinflater.setOnClickListener(new e._cls13(bundle));
        layoutinflater = bundle.k(viewgroup);
        if (layoutinflater != null)
        {
            layoutinflater = (ImageButton)layoutinflater.findViewById(0x7f100761);
        } else
        {
            layoutinflater = null;
        }
        layoutinflater.setOnClickListener(new e._cls14(bundle));
        layoutinflater = new e._cls15(bundle);
        ((CompoundButton) (obj)).setOnClickListener(layoutinflater);
        ((CompoundButton) (obj1)).setOnClickListener(layoutinflater);
        layoutinflater = bundle.c(viewgroup);
        obj = bundle.d(viewgroup);
        obj1 = ((myobfuscated.ck.e) (bundle)).f;
        if (((myobfuscated.ck.c) (obj1)).j != null)
        {
            if (((myobfuscated.ck.c) (obj1)).j.b().v == com.picsart.effectnew.MaskBrushNew.BrushDrawMode.DRAW)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            ((CompoundButton) (obj)).setChecked(true);
            layoutinflater.setChecked(false);
        } else
        {
            ((CompoundButton) (obj)).setChecked(false);
            layoutinflater.setChecked(true);
        }
        layoutinflater.setOnClickListener(new e._cls16(bundle));
        ((CompoundButton) (obj)).setOnClickListener(new e._cls17(bundle));
        viewgroup.findViewById(0x7f10018c).setOnClickListener(new e._cls18(bundle));
        layoutinflater = bundle.b(viewgroup);
        layoutinflater.setChecked(((myobfuscated.ck.e) (bundle)).f.g());
        layoutinflater.setOnClickListener(new e._cls19(bundle));
        if (!((myobfuscated.ck.e) (bundle)).f.b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.a(viewgroup, flag);
        layoutinflater = bundle.a(viewgroup);
        obj = ((myobfuscated.ck.e) (bundle)).f;
        if (((myobfuscated.ck.c) (obj)).j != null && !((myobfuscated.ck.c) (obj)).j.c.n.e())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        layoutinflater.setEnabled(flag);
        layoutinflater.setOnClickListener(new e._cls2(bundle));
        viewgroup.findViewById(0x7f100136).setOnClickListener(new e._cls3(bundle));
        if (((myobfuscated.ck.e) (bundle)).g == null)
        {
            bundle.g = new com.picsart.effectnew.k();
            ((myobfuscated.ck.e) (bundle)).g.a = bundle;
        }
        obj = ((myobfuscated.ck.e) (bundle)).g;
        if (((com.picsart.effectnew.k) (obj)).a != null)
        {
            if (viewgroup == null)
            {
                layoutinflater = ((com.picsart.effectnew.k) (obj)).a.e();
            } else
            {
                layoutinflater = viewgroup;
            }
            if (layoutinflater != null)
            {
                obj1 = ((com.picsart.effectnew.k) (obj)).a.d();
                i1 = 30 - ((com.picsart.effectnew.k) (obj)).a.a();
                ((TextView)layoutinflater.findViewById(0x7f100192)).setText((new StringBuilder()).append(((Context) (obj1)).getString(0x7f080068)).append(" ").append((int)(((float)i1 / 30F) * 50F)).toString());
                obj1 = (SeekBar)layoutinflater.findViewById(0x7f100193);
                ((SeekBar) (obj1)).setMax(30);
                ((SeekBar) (obj1)).setProgress(i1);
                ((SeekBar) (obj1)).setOnSeekBarChangeListener(new com.picsart.effectnew.k._cls1(((com.picsart.effectnew.k) (obj))));
                flag = ((com.picsart.effectnew.k) (obj)).a.b();
                obj1 = (CheckBox)layoutinflater.findViewById(0x7f100194);
                ((CheckBox) (obj1)).setChecked(flag);
                ((CheckBox) (obj1)).setOnClickListener(new com.picsart.effectnew.k._cls2(((com.picsart.effectnew.k) (obj))));
                ((com.picsart.effectnew.k) (obj)).a(layoutinflater);
                obj = new com.picsart.effectnew.k._cls3(((com.picsart.effectnew.k) (obj)));
                obj1 = (CompoundButton)layoutinflater.findViewById(0x7f100195);
                layoutinflater = (CompoundButton)layoutinflater.findViewById(0x7f100196);
                ((CompoundButton) (obj1)).setOnClickListener(((android.view.View.OnClickListener) (obj)));
                layoutinflater.setOnClickListener(((android.view.View.OnClickListener) (obj)));
            }
        }
        layoutinflater = bundle.e(viewgroup);
        obj = bundle.f(viewgroup);
        if (!((myobfuscated.ck.e) (bundle)).h) goto _L2; else goto _L1
_L1:
        layoutinflater.setVisibility(0);
_L4:
        Utils.b(bundle.hashCode());
        return viewgroup;
_L2:
        if (((myobfuscated.ck.e) (bundle)).i)
        {
            ((View) (obj)).setVisibility(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPause()
    {
        super.onPause();
        myobfuscated.ck.e.h();
        L.b();
        v();
    }

    public void onResume()
    {
        super.onResume();
        if (b != null)
        {
            Utils.b(b.hashCode());
        }
        L.a();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        t();
        Object obj = g;
        if (((myobfuscated.cj.b) (obj)).b != null)
        {
            bundle.putString("effects_apply_main_dir", ((myobfuscated.cj.b) (obj)).b);
        }
        if (((myobfuscated.cj.b) (obj)).c != null)
        {
            if (((myobfuscated.cj.b) (obj)).c.c != null)
            {
                bundle.putSerializable("bufferData", ((myobfuscated.cj.b) (obj)).c.c);
            }
            bundle.putInt("degree", ((myobfuscated.cj.b) (obj)).c.b);
            if (((myobfuscated.cj.b) (obj)).c.a != null)
            {
                bundle.putString("path", ((myobfuscated.cj.b) (obj)).c.a);
            }
        }
        bundle.putInt("pixelsMaxCount", ((myobfuscated.cj.b) (obj)).f);
        if (((myobfuscated.cj.b) (obj)).d != null)
        {
            bundle.putInt("apply_degree", ((myobfuscated.cj.b) (obj)).d.b);
            if (((myobfuscated.cj.b) (obj)).d.a != null)
            {
                bundle.putString("apply_path", ((myobfuscated.cj.b) (obj)).d.a);
            }
            if (((myobfuscated.cj.b) (obj)).d.c != null)
            {
                bundle.putSerializable("apply_bufferData", ((myobfuscated.cj.b) (obj)).d.c);
            }
            bundle.putStringArrayList("applied_effect_names", ((myobfuscated.cj.b) (obj)).d.a());
        }
        obj = b;
        bundle.putBoolean("isReturn", ((myobfuscated.ck.e) (obj)).a);
        bundle.putBoolean("closeAfterEdit", ((myobfuscated.ck.e) (obj)).b);
        bundle.putBoolean("FX_SAVE_RESULT_AS_BUFFER", ((myobfuscated.ck.e) (obj)).c);
        bundle.putBoolean("FX_SAVE_RESULT_TO_RECENTS", ((myobfuscated.ck.e) (obj)).d);
        obj = A;
        if (((myobfuscated.ck.c) (obj)).o != null)
        {
            bundle.putSerializable("maskBufferData", ((myobfuscated.ck.c) (obj)).o);
        }
        if (((myobfuscated.ck.c) (obj)).p != null)
        {
            bundle.putString("origin", ((myobfuscated.ck.c) (obj)).p);
        }
        if (((myobfuscated.ck.c) (obj)).q != null)
        {
            bundle.putParcelable("editing_data", ((myobfuscated.ck.c) (obj)).q);
        }
    }

    public void onStop()
    {
        super.onStop();
        Activity activity = getActivity();
        if (activity != null && activity.isFinishing())
        {
            z = true;
            v.a();
            EffectsActivityNew.a = A.e;
            (new ModernAsyncTask() {

                private a a;

                protected final volatile Object doInBackground(Object aobj[])
                {
                    return null;
                }

                protected final void onPostExecute(Object obj)
                {
                    obj = myobfuscated.cj.a.a();
                    if (myobfuscated.ck.a.k(a) != null)
                    {
                        ((myobfuscated.cj.a) (obj)).a(myobfuscated.ck.a.k(a));
                        myobfuscated.ck.a.b(a, null);
                    }
                    if (myobfuscated.ck.a.l(a) != null)
                    {
                        ((myobfuscated.cj.a) (obj)).a(myobfuscated.ck.a.l(a));
                        myobfuscated.ck.a.c(a, null);
                    }
                    if (a.y(a) != null)
                    {
                        ((myobfuscated.cj.a) (obj)).a(a.y(a));
                    }
                    if (a.z(a) != null)
                    {
                        ImageOpCommon.freeNativeBuffer(a.z(a));
                        a.a(a, null);
                        Log.e("ex1", "free alphaBuffer");
                    }
                    Log.e("ex1", "Onstop free task end");
                    Log.e("ex1", "************");
                    Log.e("ex1", (new StringBuilder("getAllocatedBuffersCount = ")).append(((myobfuscated.cj.a) (obj)).a).toString());
                    Log.e("ex1", "************");
                    Log.e("ex1", "************");
                    Log.e("ex1", (new StringBuilder("effectsUtils buffers count = ")).append(myobfuscated.ay.e.a).toString());
                    Log.e("ex1", "************");
                    if (myobfuscated.ck.a.b(a) != null && !myobfuscated.ck.a.b(a).isRecycled())
                    {
                        com.socialin.android.util.c.a(myobfuscated.ck.a.b(a));
                        a.a(a, null);
                        Log.e("ex1", "BitmapManager.recycle(origBitmap);");
                    }
                    if (myobfuscated.ck.a.h(a) != null && !myobfuscated.ck.a.h(a).isRecycled())
                    {
                        com.socialin.android.util.c.a(myobfuscated.ck.a.h(a));
                    }
                    if (a.a(a).j != null)
                    {
                        obj = a.a(a).j;
                        if (((com.socialin.android.photo.effects.draw.a) (obj)).o != null)
                        {
                            myobfuscated.ay.b b1 = ((com.socialin.android.photo.effects.draw.a) (obj)).o;
                            b1.e = false;
                            if (b1.f != null && !b1.f.isRecycled())
                            {
                                b1.f.recycle();
                            }
                            b1.f = null;
                        }
                        if (((com.socialin.android.photo.effects.draw.a) (obj)).c != null)
                        {
                            ((com.socialin.android.photo.effects.draw.a) (obj)).c.k();
                        }
                        Log.e("ex1", "effectsFragmentInfo.drawController.freeResources();");
                    }
                    if (a.A(a) != null)
                    {
                        ((RenderScript)a.A(a)).destroy();
                        a.a(a, null);
                        Log.e("ex1", "rs destroy");
                    }
                    obj = myobfuscated.ck.a.w(a).b;
                    if (obj != null)
                    {
                        boolean flag = Utils.a(new File(((String) (obj))));
                        Log.e("ex1", (new StringBuilder("applyMainDir Deleted = ")).append(flag).toString());
                    }
                }

            
            {
                a = a.this;
                super();
            }
            }).executeOnExecutor(h, new Void[] {
                null
            });
            if (I != null)
            {
                myobfuscated.ck.d d1 = I;
                if (d1.c != null)
                {
                    com.socialin.android.util.c.a(d1.c, d1.a);
                    d1.c = null;
                }
                if (d1.b != null)
                {
                    com.socialin.android.util.c.a(d1.b, d1.a);
                    d1.b = null;
                }
            }
        }
    }

    public final void p()
    {
        if (A.j != null)
        {
            EditingData editingdata = A.q;
            editingdata.d = editingdata.d + 1;
            A.j.d();
            A.j.b().a(com.picsart.effectnew.MaskBrushNew.BrushDrawMode.DRAW);
        }
    }

    public final void q()
    {
        if (A.j != null)
        {
            EditingData editingdata = A.q;
            editingdata.d = editingdata.d + 1;
            A.j.d();
            A.j.b().a(com.picsart.effectnew.MaskBrushNew.BrushDrawMode.ERASE);
        }
    }

    public final void r()
    {
        o();
    }

    public final boolean s()
    {
        boolean flag1;
        if (A.i == null)
        {
            flag1 = false;
        } else
        {
            Object obj = A.q;
            obj.k = ((EditingData) (obj)).k + 1;
            Log.e("ex1", "effectsfragment applyEffectMaxSize()");
            Object obj1 = y();
            obj = g.a("");
            boolean flag;
            if (z() && l == null)
            {
                Bitmap bitmap = A.j.c.l();
                if (bitmap != null)
                {
                    Object obj3 = A();
                    myobfuscated.cm.c c2 = v;
                    Object obj2 = A.i;
                    obj3 = new myobfuscated.cm.e(((JSONArray) (obj3))) {

                        private JSONArray a;
                        private a b;

                        public final void a(c c3, boolean flag2, long l1, boolean flag3)
                        {
                            if (flag2)
                            {
                                Object obj5 = a.a(b).g;
                                myobfuscated.ck.a.w(b).a(c3, ((String) (obj5)));
                                Object obj6 = b.getActivity();
                                if (obj6 != null)
                                {
                                    c3 = a.a(b).k.a(((String) (obj5)));
                                    obj5 = ((Activity) (obj6)).getApplicationContext();
                                    int j1 = myobfuscated.ck.a.c(b).x;
                                    int k1 = myobfuscated.ck.a.c(b).y;
                                    flag3 = a.M(b);
                                    obj6 = a;
                                    myobfuscated.ck.c c4 = a.a(b);
                                    b.getActivity().getApplicationContext();
                                    myobfuscated.ay.e.a(((Context) (obj5)), c3, j1, k1, flag3, true, l1, true, ((JSONArray) (obj6)), c4.j());
                                }
                            }
                            a.a(b).e = false;
                            a.a(b).f = false;
                            b.c(flag2);
                        }

            
            {
                b = a.this;
                a = jsonarray;
                super();
            }
                    };
                    Log.e("ex1", "apply effect small size");
                    obj2 = new myobfuscated.cm.c._cls2(((myobfuscated.cm.e) (obj3)), ((Effect) (obj2)));
                    obj3 = ((myobfuscated.cm.d) (obj1)).g;
                    Bitmap bitmap1 = ((myobfuscated.cm.d) (obj1)).a;
                    Bitmap bitmap2 = ((myobfuscated.cm.d) (obj1)).b;
                    Bitmap bitmap3 = ((myobfuscated.cm.d) (obj1)).d;
                    obj1 = ((myobfuscated.cm.d) (obj1)).h;
                    ((ModernAsyncTask) (obj2)).executeOnExecutor(c2.a, new Object[] {
                        bitmap, obj, c2.b, obj3, bitmap1, bitmap2, bitmap3, obj1
                    });
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                Object obj4 = A();
                myobfuscated.cm.c c1 = v;
                Effect effect = A.i;
                flag = A.i.e;
                ArrayList arraylist = A.j.c.m();
                int i1 = K;
                obj4 = new myobfuscated.cm.e(((JSONArray) (obj4))) {

                    private JSONArray a;
                    private a b;

                    public final void a(c c3, boolean flag2, long l1, boolean flag3)
                    {
                        if (flag2)
                        {
                            Object obj5 = a.a(b).g;
                            myobfuscated.ck.a.w(b).a(c3, ((String) (obj5)));
                            Object obj6 = b.getActivity();
                            if (obj6 != null)
                            {
                                c3 = a.a(b).k.a(((String) (obj5)));
                                obj5 = ((Activity) (obj6)).getApplicationContext();
                                int j1 = myobfuscated.ck.a.c(b).x;
                                int k1 = myobfuscated.ck.a.c(b).y;
                                boolean flag4 = a.M(b);
                                myobfuscated.ck.c c4;
                                if (!flag3)
                                {
                                    flag3 = true;
                                } else
                                {
                                    flag3 = false;
                                }
                                obj6 = a;
                                c4 = a.a(b);
                                b.getActivity().getApplicationContext();
                                myobfuscated.ay.e.a(((Context) (obj5)), c3, j1, k1, flag4, true, l1, flag3, ((JSONArray) (obj6)), c4.j());
                            }
                        }
                        a.a(b).e = false;
                        a.a(b).f = false;
                        b.c(flag2);
                    }

            
            {
                b = a.this;
                a = jsonarray;
                super();
            }
                };
                (new myobfuscated.cm.f(c1.b, effect, ((myobfuscated.cm.d) (obj1)), flag, arraylist, ((String) (obj)), i1, new myobfuscated.cm.g(c1, ((myobfuscated.cm.e) (obj4)), flag))).executeOnExecutor(c1.a, new Void[] {
                    null
                });
                flag = true;
            }
            flag1 = flag;
            if (flag)
            {
                A.e = true;
                A.f = true;
                a(0x7f080679, ((android.content.DialogInterface.OnCancelListener) (null)));
                flag1 = flag;
                if (A.j != null)
                {
                    A.j.a(false);
                    A.j.c.a(false);
                    return flag;
                }
            }
        }
        return flag1;
    }

}
