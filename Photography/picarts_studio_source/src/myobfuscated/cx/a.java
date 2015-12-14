// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cx;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.dropbox.client2.DropboxAPI;
import com.facebook.CallbackManager;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.deviantart.DeviantArtOAuthMainActivity;
import com.socialin.android.dropbox.DropBoxSessionManager;
import com.socialin.android.facebook.p;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.googleplus.GooglePlusSignInActivity;
import com.socialin.android.instagram.f;
import com.socialin.android.instagram.h;
import com.socialin.android.tumblr.TumblrOAuthActivity;
import com.socialin.android.tumblr.b;
import com.socialin.android.twitter.TwitterSessionManager;
import com.socialin.android.util.Utils;
import com.socialin.android.util.aj;
import com.socialin.android.util.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cv.c;
import myobfuscated.f.m;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.cx:
//            b, c

public class a extends Fragment
    implements com.socialin.android.a
{

    private static final String a = myobfuscated/cx/a.getSimpleName();
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private CallbackManager E;
    private boolean b;
    private b c;
    private TwitterSessionManager d;
    private DropBoxSessionManager e;
    private com.socialin.android.deviantart.a f;
    private com.socialin.android.googleplus.a g;
    private f h;
    private SharedPreferences i;
    private List j;
    private myobfuscated.cx.c k;
    private GridView l;
    private LinearLayout m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private final p u = new p() {

        private a a;

        public final void a()
        {
            boolean flag = false;
            a.a(a);
            myobfuscated.cx.b b1 = a.a(0);
            b1.e = myobfuscated.cx.a.b(a);
            if (myobfuscated.cx.a.c(a) || FacebookUtils.canIPost())
            {
                flag = true;
            }
            b1.f = flag;
            myobfuscated.cx.a.d(a).edit().putBoolean(b1.a, true).apply();
            if (a.getActivity() != null && !a.getActivity().isFinishing())
            {
                a.e(a);
            }
        }

            
            {
                a = a.this;
                super();
            }
    };
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public a()
    {
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        j = null;
        k = null;
        n = true;
        o = true;
        p = true;
        q = true;
        r = true;
        s = true;
        A = true;
        B = false;
    }

    static void a(a a1, int i1)
    {
        myobfuscated.cx.b b1 = a1.a(i1);
        i1;
        JVM INSTR tableswitch 0 6: default 48
    //                   0 93
    //                   1 276
    //                   2 192
    //                   3 237
    //                   4 416
    //                   5 335
    //                   6 374;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        if (a1.B)
        {
            b1.e = false;
        }
        if (i1 != 0)
        {
            a1.i.edit().putBoolean(b1.a, false).apply();
            a1.d();
        }
        return;
_L2:
        b1.f = false;
        if (a1.B)
        {
            a1.t = false;
            myobfuscated.cx.b b2 = a1.a(0);
            b2.e = a1.t;
            b2.f = false;
            FacebookUtils.logoutFacebook(true);
            SocialinV3.getInstance().removeFbConnection();
            a1.i.edit().putBoolean(b2.a, b2.f).apply();
            a1.d();
            AnalyticUtils.getInstance(a1.getActivity()).trackLocalAction("social_connections:fbDisconnect");
        } else
        {
            a1.d();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        b1.f = false;
        if (a1.B)
        {
            a1.w = false;
            a1.d.clearTwitterSession();
            SocialinV3.getInstance().removeTwitterConnection();
            AnalyticUtils.getInstance(a1.getActivity()).trackLocalAction("social_connections:twitterDisconnect");
        }
        continue; /* Loop/switch isn't completed */
_L5:
        b1.f = false;
        if (a1.B)
        {
            a1.v = false;
            a1.c.a();
            AnalyticUtils.getInstance(a1.getActivity()).trackLocalAction("social_connections:tumblrDisconnect");
        }
        continue; /* Loop/switch isn't completed */
_L3:
        b1.f = false;
        if (a1.B)
        {
            a1.b = false;
            b1.f = false;
            f f1 = a1.h;
            Utils.b(f1.a);
            com.socialin.android.instagram.h.c(f1.a.getApplicationContext());
            AnalyticUtils.getInstance(a1.getActivity()).trackLocalAction("social_connections:instagramDisconnect");
        }
        continue; /* Loop/switch isn't completed */
_L7:
        b1.f = false;
        if (a1.B)
        {
            a1.x = false;
            a1.e.clearDropBoxSession();
            AnalyticUtils.getInstance(a1.getActivity()).trackLocalAction("social_connections:dropboxDisconnect");
        }
        continue; /* Loop/switch isn't completed */
_L8:
        b1.f = false;
        if (a1.B)
        {
            a1.y = false;
            com.socialin.android.oauth2.a.a(a1.f.b);
            AnalyticUtils.getInstance(a1.getActivity()).trackLocalAction("social_connections:deviantartDisconnect");
        }
        continue; /* Loop/switch isn't completed */
_L6:
        b1.f = false;
        if (a1.B)
        {
            a1.z = false;
            a1.g.a();
            AnalyticUtils.getInstance(a1.getActivity()).trackLocalAction("social_connections:googlePlusDisconnect");
        }
        if (true) goto _L1; else goto _L9
_L9:
    }

    static void a(a a1, boolean flag)
    {
        myobfuscated.cx.b b1;
        boolean flag1;
        flag1 = false;
        a1.z = flag;
        b1 = a1.a(4);
        b1.e = a1.z;
        if (!a1.B) goto _L2; else goto _L1
_L1:
        flag = a1.z;
_L4:
        b1.f = flag;
        a1.d();
        return;
_L2:
        flag = flag1;
        if (a1.z)
        {
            flag = flag1;
            if (a1.i.getBoolean(b1.a, false))
            {
                flag = true;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean a(a a1)
    {
        a1.t = true;
        return true;
    }

    static void b(a a1, int i1)
    {
        if (com.socialin.android.util.s.a(a1.getActivity())) goto _L2; else goto _L1
_L1:
        a1.f();
_L4:
        return;
_L2:
        switch (i1)
        {
        default:
            return;

        case 0: // '\0'
            if (!a1.t)
            {
                if (a1.B)
                {
                    FacebookUtils.connectFacebook(a1.getActivity(), a1.E, a1.u);
                } else
                {
                    FacebookUtils.approvePostAction(a1.getActivity(), a1.E, a1.u);
                }
                AnalyticUtils.getInstance(a1.getActivity()).trackLocalAction("social_connections:fbConnect");
                return;
            }
            myobfuscated.cx.b b1 = a1.a(0);
            if (a1.B)
            {
                b1.f = true;
            } else
            {
                FacebookUtils.approvePostAction(a1.getActivity(), a1.E, a1.u);
            }
            a1.i.edit().putBoolean(b1.a, true).apply();
            a1.d();
            return;

        case 2: // '\002'
            if (!a1.w)
            {
                a1.d.startTwitterNewSession(751, true);
                AnalyticUtils.getInstance(a1.getActivity()).trackLocalAction("social_connections:twitterConnect");
                return;
            } else
            {
                myobfuscated.cx.b b2 = a1.a(2);
                b2.f = true;
                a1.i.edit().putBoolean(b2.a, true).apply();
                a1.d();
                return;
            }

        case 3: // '\003'
            if (!a1.v)
            {
                b b3 = a1.c;
                Intent intent = new Intent(b3.a, com/socialin/android/tumblr/TumblrOAuthActivity);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("method", "auth");
                ((Activity)b3.a).startActivityForResult(intent, 750);
                AnalyticUtils.getInstance(a1.getActivity()).trackLocalAction("social_connections:tumblrConnect");
                return;
            } else
            {
                myobfuscated.cx.b b4 = a1.a(3);
                b4.f = true;
                a1.i.edit().putBoolean(b4.a, true).apply();
                a1.d();
                return;
            }

        case 5: // '\005'
            if (!a1.x)
            {
                a1.e.startDropBoxNewSession();
                AnalyticUtils.getInstance(a1.getActivity()).trackLocalAction("social_connections:dropboxConnect");
                return;
            } else
            {
                myobfuscated.cx.b b5 = a1.a(5);
                b5.f = true;
                a1.i.edit().putBoolean(b5.a, true).apply();
                a1.d();
                return;
            }

        case 6: // '\006'
            if (!a1.y)
            {
                com.socialin.android.deviantart.a a2 = a1.f;
                Intent intent1 = new Intent(a2.a, com/socialin/android/deviantart/DeviantArtOAuthMainActivity);
                intent1.addCategory("android.intent.category.DEFAULT");
                intent1.putExtra("method", "auth");
                ((Activity)a2.a).startActivityForResult(intent1, 759);
                AnalyticUtils.getInstance(a1.getActivity()).trackLocalAction("social_connections:devianartConnect");
                return;
            } else
            {
                myobfuscated.cx.b b6 = a1.a(6);
                b6.f = true;
                a1.i.edit().putBoolean(b6.a, true).apply();
                a1.d();
                return;
            }

        case 4: // '\004'
            if (!a1.z)
            {
                if (a1.g != null)
                {
                    com.socialin.android.googleplus.a a3 = a1.g;
                    Intent intent2 = new Intent(a3.a, com/socialin/android/googleplus/GooglePlusSignInActivity);
                    intent2.putExtra("method", "connect");
                    ((Activity)a3.a).startActivityForResult(intent2, 760);
                    AnalyticUtils.getInstance(a1.getActivity()).trackLocalAction("social_connections:googlePlusConnect");
                    return;
                }
            } else
            {
                myobfuscated.cx.b b7 = a1.a(4);
                b7.f = true;
                a1.i.edit().putBoolean(b7.a, true).apply();
                a1.d();
                return;
            }
            break;

        case 1: // '\001'
            if (!a1.b)
            {
                a1.h.a(761);
                AnalyticUtils.getInstance(a1.getActivity()).trackLocalAction("social_connections:instagramConnect");
                return;
            } else
            {
                myobfuscated.cx.b b8 = a1.a(1);
                b8.f = true;
                a1.i.edit().putBoolean(b8.a, true).apply();
                a1.d();
                return;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean b(a a1)
    {
        return a1.t;
    }

    private void c()
    {
        boolean flag1 = true;
        if (com.socialin.android.util.s.a(getActivity())) goto _L2; else goto _L1
_L1:
        f();
_L16:
        return;
_L2:
        if (getString(0x7f0808c8).equalsIgnoreCase(getString(0x7f0808cc))) goto _L4; else goto _L3
_L3:
        b();
        if (!n) goto _L6; else goto _L5
_L5:
        Object obj;
        c = new b(getActivity());
        obj = c;
        boolean flag;
        if (((b) (obj)).b.getString("tumblr_oauth_token", null) != null && ((b) (obj)).b.getString("tumblr_oauth_token_secret", null) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        v = flag;
        obj = a(3);
        if (obj == null) goto _L6; else goto _L7
_L7:
        obj.e = v;
        if (!B) goto _L9; else goto _L8
_L8:
        flag = v;
_L20:
        obj.f = flag;
        d();
_L6:
        if (!o) goto _L11; else goto _L10
_L10:
        d = new TwitterSessionManager(getActivity());
        w = d.checkTwitterSession();
        obj = a(2);
        if (obj == null) goto _L11; else goto _L12
_L12:
        obj.e = w;
        if (!B) goto _L14; else goto _L13
_L13:
        flag = w;
_L21:
        obj.f = flag;
        d();
_L11:
        if (r && A)
        {
            e();
        }
        if (s)
        {
            h = new f(getActivity());
            b = com.socialin.android.instagram.h.b(getActivity().getApplicationContext());
            a(b);
        }
_L4:
        if (!p)
        {
            continue; /* Loop/switch isn't completed */
        }
        e = DropBoxSessionManager.getInstance(getActivity());
        x = e.checkDropBoxSession();
        obj = a(5);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj.e = x;
        if (B)
        {
            flag = x;
        } else
        if (x && i.getBoolean(((myobfuscated.cx.b) (obj)).a, false))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj.f = flag;
        d();
        if (!q) goto _L16; else goto _L15
_L15:
        f = new com.socialin.android.deviantart.a(getActivity());
        y = com.socialin.android.oauth2.a.b(f.b);
        obj = a(6);
        if (obj == null) goto _L16; else goto _L17
_L17:
        obj.e = y;
        if (!B) goto _L19; else goto _L18
_L18:
        flag = y;
_L24:
        obj.f = flag;
        d();
        return;
_L9:
        if (!v)
        {
            break MISSING_BLOCK_LABEL_461;
        }
        flag = i.getBoolean(((myobfuscated.cx.b) (obj)).a, false);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_461;
        }
        flag = true;
          goto _L20
        flag = false;
          goto _L20
        obj;
        com.socialin.android.d.b(a, (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString(), ((Throwable) (obj)));
          goto _L6
_L14:
        if (!w)
        {
            break MISSING_BLOCK_LABEL_529;
        }
        flag = i.getBoolean(((myobfuscated.cx.b) (obj)).a, false);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_529;
        }
        flag = true;
          goto _L21
        flag = false;
          goto _L21
        obj;
        com.socialin.android.d.b(a, (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString(), ((Throwable) (obj)));
          goto _L11
_L19:
        if (!y) goto _L23; else goto _L22
_L22:
        flag = flag1;
        if (i.getBoolean(((myobfuscated.cx.b) (obj)).a, false)) goto _L24; else goto _L23
_L23:
        flag = false;
          goto _L24
    }

    static boolean c(a a1)
    {
        return a1.B;
    }

    static SharedPreferences d(a a1)
    {
        return a1.i;
    }

    private void d()
    {
        getActivity().runOnUiThread(new Runnable() {

            private a a;

            public final void run()
            {
                if (myobfuscated.cx.a.f(a))
                {
                    myobfuscated.cx.a.h(a).setAdapter(a.g(a));
                    myobfuscated.cx.a.h(a).invalidate();
                    return;
                }
                a.i(a).removeAllViews();
                for (int i1 = 0; i1 < a.g(a).getCount(); i1++)
                {
                    View view = a.g(a).getView(i1, null, a.i(a));
                    a.i(a).addView(view);
                }

                a.i(a).invalidate();
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

    private void e()
    {
        g = new com.socialin.android.googleplus.a(getActivity());
        g.b = new aj() {

            private a a;

            public final void a()
            {
                if (a.getActivity() != null && !a.getActivity().isFinishing())
                {
                    a.a(a, true);
                }
            }

            public final void b()
            {
                if (a.getActivity() != null && !a.getActivity().isFinishing())
                {
                    a.a(a, false);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        (new Thread() {

            private a a;

            public final void run()
            {
                a.j(a).a(false);
            }

            
            {
                a = a.this;
                super();
            }
        }).start();
    }

    static void e(a a1)
    {
        a1.d();
    }

    private void f()
    {
        getActivity().runOnUiThread(new Runnable() {

            private a a;

            public final void run()
            {
                myobfuscated.cy.d.a(a.getActivity());
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

    static boolean f(a a1)
    {
        return a1.D;
    }

    static myobfuscated.cx.c g(a a1)
    {
        return a1.k;
    }

    static GridView h(a a1)
    {
        return a1.l;
    }

    static LinearLayout i(a a1)
    {
        return a1.m;
    }

    static com.socialin.android.googleplus.a j(a a1)
    {
        return a1.g;
    }

    static void k(a a1)
    {
        a1.f();
    }

    public final myobfuscated.cx.b a(int i1)
    {
        for (Iterator iterator = j.iterator(); iterator.hasNext();)
        {
            myobfuscated.cx.b b1 = (myobfuscated.cx.b)iterator.next();
            if (b1.d == i1)
            {
                return b1;
            }
        }

        return null;
    }

    public final void a()
    {
        c();
    }

    public final void a(boolean flag)
    {
        myobfuscated.cx.b b1;
        boolean flag1;
        flag1 = true;
        b = flag;
        b1 = a(1);
        if (b1 == null) goto _L2; else goto _L1
_L1:
        b1.e = flag;
        if (!B) goto _L4; else goto _L3
_L3:
        flag = b;
_L6:
        b1.f = flag;
        i.edit().putBoolean(b1.a, b1.f).apply();
        d();
_L2:
        return;
_L4:
        if (b)
        {
            flag = flag1;
            if (i.getBoolean(b1.a, false))
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void b()
    {
        myobfuscated.cx.b b1;
        boolean flag1;
        flag1 = false;
        b1 = a(0);
        t = FacebookUtils.isSessionValid();
        b1.e = t;
        b1.f = false;
        if (!B) goto _L2; else goto _L1
_L1:
        boolean flag = t;
_L4:
        b1.f = flag;
        d();
        return;
_L2:
        flag = flag1;
        if (t)
        {
            flag = flag1;
            if (i.getBoolean(b1.a, false))
            {
                flag = flag1;
                if (FacebookUtils.canIPost())
                {
                    flag = true;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        boolean flag;
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        A = flag;
        bundle = getArguments();
        if (bundle != null)
        {
            n = bundle.getBoolean("showTumblr", true);
            o = bundle.getBoolean("showTwitter", true);
            p = bundle.getBoolean("showDropbox", true);
            q = bundle.getBoolean("showDeviantart", true);
            r = bundle.getBoolean("showGooglePlus", true);
            s = bundle.getBoolean("showInstagram", true);
            C = bundle.getBoolean("isTransparentIcons", false);
            D = bundle.getBoolean("isGridView", false);
            B = bundle.getBoolean("isFromSettings", false);
        }
        r = false;
        j = new ArrayList();
        if (getView() != null)
        {
            l = (GridView)getView().findViewById(0x7f100397);
            m = (LinearLayout)getView().findViewById(0x7f100396);
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("isFacebookConnected : ")).append(t).toString()
            });
            com.socialin.android.d.b(a, new Object[] {
                String.format("showTwitter= %s  isTwitterConnected : %s", new Object[] {
                    Boolean.valueOf(o), Boolean.valueOf(w)
                })
            });
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("isDropboxConnected : ")).append(x).toString()
            });
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("isDeviantartConnected : ")).append(y).toString()
            });
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("isGooglePlusConnected : ")).append(z).toString()
            });
            int i1;
            if (!getResources().getString(0x7f0808c8).equals(getResources().getString(0x7f0808cc)))
            {
                bundle = j;
                String s1 = getString(0x7f0802c7);
                if (C)
                {
                    i1 = 0x7f02045e;
                } else
                {
                    i1 = 0x7f02045c;
                }
                bundle.add(new myobfuscated.cx.b(s1, i1, 0x7f020205, 0, t));
                if (s)
                {
                    bundle = j;
                    String s2 = getString(0x7f0802e2);
                    if (C)
                    {
                        i1 = 0x7f020470;
                    } else
                    {
                        i1 = 0x7f02078a;
                    }
                    bundle.add(new myobfuscated.cx.b(s2, i1, 0x7f020533, 1, b));
                }
                if (o)
                {
                    bundle = j;
                    s2 = getString(0x7f080360);
                    if (C)
                    {
                        i1 = 0x7f02050e;
                    } else
                    {
                        i1 = 0x7f02050d;
                    }
                    bundle.add(new myobfuscated.cx.b(s2, i1, 0x7f02072c, 2, w));
                }
                if (r && A)
                {
                    bundle = j;
                    s2 = getString(0x7f0802db);
                    if (C)
                    {
                        i1 = 0x7f020468;
                    } else
                    {
                        i1 = 0x7f020467;
                    }
                    bundle.add(new myobfuscated.cx.b(s2, i1, 0x7f020243, 4, z));
                }
            }
            if (p)
            {
                bundle = j;
                s2 = getString(0x7f0802bc);
                if (C)
                {
                    i1 = 0x7f02044e;
                } else
                {
                    i1 = 0x7f02044d;
                }
                bundle.add(new myobfuscated.cx.b(s2, i1, 0x7f0201cb, 5, x));
            }
            if (q)
            {
                bundle = j;
                s2 = getString(0x7f0802b5);
                if (C)
                {
                    i1 = 0x7f020446;
                } else
                {
                    i1 = 0x7f020447;
                }
                bundle.add(new myobfuscated.cx.b(s2, i1, 0x7f02019f, 6, y));
            }
            k = new myobfuscated.cx.c(this, getActivity().getApplicationContext(), j);
            d();
        }
        c();
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        boolean flag;
        flag = true;
        super.onActivityResult(i1, j1, intent);
        if (myobfuscated.cv.c.a() != 0 && i1 != 135) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (i1 != 761 || j1 != 326) goto _L4; else goto _L3
_L3:
        Object obj;
        b = true;
        obj = intent.getExtras().getString("oauth2ResultJson");
        obj = new com.socialin.android.instagram.a(new JSONObject(((String) (obj))));
        com.socialin.android.instagram.h.a(getActivity().getApplicationContext(), ((com.socialin.android.instagram.a) (obj)));
        boolean flag1 = true;
_L21:
        if (j1 != -1) goto _L6; else goto _L5
_L5:
        i1;
        JVM INSTR lookupswitch 6: default 152
    //                   11: 369
    //                   750: 325
    //                   751: 309
    //                   754: 336
    //                   759: 347
    //                   760: 358;
           goto _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L7:
        flag1 = true;
_L6:
        if (j1 != 0)
        {
            break MISSING_BLOCK_LABEL_442;
        }
        i1;
        JVM INSTR tableswitch 750 761: default 224
    //                   750 387
    //                   751 376
    //                   752 224
    //                   753 224
    //                   754 398
    //                   755 224
    //                   756 224
    //                   757 224
    //                   758 224
    //                   759 409
    //                   760 420
    //                   761 431;
           goto _L14 _L15 _L16 _L14 _L14 _L17 _L14 _L14 _L14 _L14 _L18 _L19 _L20
_L14:
        i1 = 0;
_L22:
        intent = a(myobfuscated.cv.c.a());
        intent.e = flag1;
        intent.f = flag1;
        i.edit().putBoolean(((myobfuscated.cx.b) (intent)).a, ((myobfuscated.cx.b) (intent)).f).apply();
        d();
        if (i1 != 0)
        {
            Utils.a(getActivity(), 0x7f08024e);
            return;
        }
          goto _L1
        JSONException jsonexception;
        jsonexception;
        com.socialin.android.d.a(a, jsonexception);
_L4:
        flag1 = false;
          goto _L21
_L10:
        myobfuscated.cv.c.a(intent, this);
        w = true;
        flag1 = true;
          goto _L6
_L9:
        v = true;
        flag1 = true;
          goto _L6
_L11:
        x = true;
        flag1 = true;
          goto _L6
_L12:
        y = true;
        flag1 = true;
          goto _L6
_L13:
        z = true;
        flag1 = true;
          goto _L6
_L8:
        e();
          goto _L7
_L16:
        w = false;
        i1 = ((flag) ? 1 : 0);
          goto _L22
_L15:
        v = false;
        i1 = ((flag) ? 1 : 0);
          goto _L22
_L17:
        x = false;
        i1 = ((flag) ? 1 : 0);
          goto _L22
_L18:
        y = false;
        i1 = ((flag) ? 1 : 0);
          goto _L22
_L19:
        z = false;
        i1 = ((flag) ? 1 : 0);
          goto _L22
_L20:
        b = false;
        i1 = ((flag) ? 1 : 0);
          goto _L22
        i1 = 0;
          goto _L22
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        i = activity.getSharedPreferences((new StringBuilder("sinPref_")).append(getString(myobfuscated.f.m.e(activity, "app_name_short"))).toString(), 0);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        E = com.facebook.CallbackManager.Factory.create();
        return layoutinflater.inflate(0x7f0300a9, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        if (e == null || e.getApi() == null) goto _L2; else goto _L1
_L1:
        com.dropbox.client2.android.a a1 = (com.dropbox.client2.android.a)e.getApi().a;
        if (com.dropbox.client2.android.a.a())
        {
            a1.b();
            if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
            {
                com.socialin.android.util.b.a(SocialinV3.getInstance().getContext()).a("Connected Dropbox", true);
            }
            e.storeAuth(a1);
            if (!x)
            {
                x = true;
                myobfuscated.cx.b b1 = a(5);
                b1.e = true;
                b1.f = true;
                i.edit().putBoolean(b1.a, true).apply();
                d();
            }
        }
_L4:
        return;
_L2:
        myobfuscated.cx.b b2;
        boolean flag;
        if (e != null && e.handleAuthCallback())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
        {
            com.socialin.android.util.b.a(SocialinV3.getInstance().getContext()).a("Connected Dropbox", true);
        }
        if (x) goto _L4; else goto _L3
_L3:
        x = true;
        b2 = a(5);
        b2.e = true;
        b2.f = true;
        i.edit().putBoolean(b2.a, true).apply();
        d();
        return;
        if (!getActivity().getIntent().hasExtra("instagram_browser_action")) goto _L4; else goto _L5
_L5:
        myobfuscated.cx.b b3 = a(1);
        b = true;
        b3.e = true;
        b3.f = true;
        i.edit().putBoolean(b3.a, true).apply();
        d();
        return;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void onStop()
    {
        super.onStop();
    }

}
