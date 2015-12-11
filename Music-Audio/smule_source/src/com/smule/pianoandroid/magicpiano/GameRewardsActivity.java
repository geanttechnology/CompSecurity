// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.crittercism.app.Crittercism;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.smule.android.c.aa;
import com.smule.android.c.ab;
import com.smule.android.c.d;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.facebook.a;
import com.smule.android.network.managers.RecommendationManager;
import com.smule.android.network.managers.ak;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.a.x;
import com.smule.pianoandroid.a.y;
import com.smule.pianoandroid.a.z;
import com.smule.pianoandroid.data.model.AchievementDefinition;
import com.smule.pianoandroid.data.model.GameReward;
import com.smule.pianoandroid.data.model.LevelConfig;
import com.smule.pianoandroid.e.c;
import com.smule.pianoandroid.f.b;
import com.smule.pianoandroid.magicpiano.b.n;
import com.smule.pianoandroid.magicpiano.b.o;
import com.smule.pianoandroid.utils.q;
import com.smule.pianoandroid.utils.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, k, n, ay, 
//            aw, an, MagicApplication, ao, 
//            ar

public class GameRewardsActivity extends ag
    implements ab, o
{

    private static final String t = com/smule/pianoandroid/magicpiano/GameRewardsActivity.getName();
    TextView a;
    TextView b;
    ImageView c;
    Observer d;
    Dialog e;
    an f;
    boolean g;
    boolean h;
    String i;
    String j;
    int k;
    List l;
    AchievementDefinition m;
    protected boolean n;
    private t u;
    private an v;
    private int w;
    private CallbackManager x;
    private boolean y;
    private Runnable z;

    public GameRewardsActivity()
    {
        g = false;
        h = false;
        v = null;
        z = new Runnable() {

            final GameRewardsActivity a;

            public void run()
            {
                aa.c(com.smule.pianoandroid.magicpiano.GameRewardsActivity.c(), (new StringBuilder()).append("Claiming reward song: ").append(a.i).toString());
                com.smule.pianoandroid.magicpiano.c.a.a().a(a.i);
                com.smule.pianoandroid.magicpiano.c.a.a().b(false);
                com.smule.pianoandroid.magicpiano.c.a.a().a = true;
                q.j(a.i);
                Object obj = ak.a().a(a.i);
                obj = String.format(a.getResources().getString(0x7f0c005a), new Object[] {
                    ((SongV2) (obj)).title
                });
                a.f = new an(a, ((String) (obj)));
                a.f.setCancelable(false);
                a.f.a(new ao(this) {

                    final _cls5 a;

                    public void c_()
                    {
                        com.smule.pianoandroid.magicpiano.c.a.a().a = false;
                    }

            
            {
                a = _pcls5;
                super();
            }
                });
                a.f.show();
                (new n(a.i, a)).execute(new Void[0]);
                RecommendationManager.a().a(a.i, new com.smule.android.network.managers.RecommendationManager.RecommedationSelectCallback(this) {

                    final _cls5 a;

                    public void handleResponse(com.smule.android.network.managers.x x1)
                    {
                        p.a(com.smule.pianoandroid.a.z.a().b().edit().putBoolean("ONBOARDING_REPORTED", x1.a()));
                        com.smule.pianoandroid.magicpiano.suggestions.c.a().a(true);
                    }

                    public volatile void handleResponse(Object obj)
                    {
                        handleResponse((com.smule.android.network.managers.x)obj);
                    }

            
            {
                a = _pcls5;
                super();
            }
                });
                a.e.dismiss();
                a.e = null;
            }

            
            {
                a = GameRewardsActivity.this;
                super();
            }
        };
    }

    private void a(Bundle bundle)
    {
        if (i != null)
        {
            bundle.putString("song", i);
        }
        if (e != null && e.isShowing())
        {
            bundle.putBoolean("dialog", true);
        }
    }

    static void a(GameRewardsActivity gamerewardsactivity)
    {
        gamerewardsactivity.d();
    }

    static void a(GameRewardsActivity gamerewardsactivity, String s)
    {
        gamerewardsactivity.a(s);
    }

    private void a(String s)
    {
        Intent intent = new Intent();
        intent.putExtra("PRODUCT_UID", s);
        setResult(-1, intent);
        finish();
    }

    private void a(List list)
    {
        a(list, false);
    }

    private void a(List list, boolean flag)
    {
        if (!y) goto _L2; else goto _L1
_L1:
        findViewById(0x7f0a00c7).setVisibility(0);
        findViewById(0x7f0a0064).setVisibility(8);
        ((ListView)findViewById(0x7f0a00c8)).setAdapter(new k(this, this, list));
_L4:
        return;
_L2:
        LinearLayout linearlayout;
        findViewById(0x7f0a00c7).setVisibility(8);
        findViewById(0x7f0a0064).setVisibility(0);
        linearlayout = (LinearLayout)findViewById(0x7f0a0068);
        list = list.iterator();
_L5:
        if (!list.hasNext()) goto _L4; else goto _L3
_L3:
        GameReward gamereward;
        View view;
        gamereward = (GameReward)list.next();
        view = getLayoutInflater().inflate(0x7f030064, null);
        if (flag)
        {
            ((ImageView)view.findViewById(0x7f0a0040)).setImageResource(0x7f020173);
            TextView textview = (TextView)view.findViewById(0x7f0a0069);
            textview.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
            textview.setText(view.getResources().getString(0x7f0c0130));
        } else
        {
label0:
            {
                if (!gamereward.getRewardType().equals(com.smule.pianoandroid.data.model.GameReward.Type.COINS))
                {
                    break label0;
                }
                ((ImageView)view.findViewById(0x7f0a0040)).setImageResource(0x7f020170);
                ((TextView)view.findViewById(0x7f0a0069)).setText((new StringBuilder()).append("+").append(gamereward.amount).append(" ").append(view.getResources().getString(0x7f0c025e)).toString());
            }
        }
_L7:
        view.setTag(gamereward);
        linearlayout.addView(view);
          goto _L5
          goto _L4
        SongV2 songv2;
        if (!gamereward.getRewardType().equals(com.smule.pianoandroid.data.model.GameReward.Type.PRODUCT))
        {
            break MISSING_BLOCK_LABEL_406;
        }
        ((ImageView)view.findViewById(0x7f0a0040)).setImageResource(0x7f020171);
        songv2 = ak.a().a(gamereward.value);
        if (songv2 == null) goto _L5; else goto _L6
_L6:
        i = songv2.songId;
        ((TextView)view.findViewById(0x7f0a0069)).setText(songv2.title);
        view.findViewById(0x7f0a006a).setVisibility(0);
        ((TextView)view.findViewById(0x7f0a006a)).setText(songv2.artist);
        b.setVisibility(0);
          goto _L7
        ((ImageView)view.findViewById(0x7f0a0040)).setImageResource(0x7f020173);
        ((TextView)view.findViewById(0x7f0a0069)).setText((new StringBuilder()).append("+").append(gamereward.amount).append(" ").append(view.getResources().getString(0x7f0c02e2)).toString());
          goto _L7
    }

    private void b(Bundle bundle)
    {
        if (bundle != null)
        {
            i = bundle.getString("song");
            if (bundle.getBoolean("dialog"))
            {
                b(i);
            }
        }
    }

    static void b(GameRewardsActivity gamerewardsactivity)
    {
        gamerewardsactivity.n();
    }

    static void b(GameRewardsActivity gamerewardsactivity, String s)
    {
        gamerewardsactivity.b(s);
    }

    private void b(String s)
    {
        s = ak.a().a(s);
        if (s != null)
        {
            e = com.smule.pianoandroid.magicpiano.n.a(this, 0x7f02010d, getString(0x7f0c0239), null, String.format(getString(0x7f0c0238), new Object[] {
                ((SongV2) (s)).title
            }), getString(0x7f0c0042), getString(0x7f0c02bf), null, z, false);
            e.show();
            return;
        } else
        {
            aa.b(t, (new StringBuilder()).append("no product found for song: ").append(i).toString());
            finish();
            return;
        }
    }

    static String c()
    {
        return t;
    }

    static void c(GameRewardsActivity gamerewardsactivity)
    {
        gamerewardsactivity.h();
    }

    private void d()
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final GameRewardsActivity a;

            public void run()
            {
                GameRewardsActivity.e(a);
            }

            
            {
                a = GameRewardsActivity.this;
                super();
            }
        });
    }

    static void d(GameRewardsActivity gamerewardsactivity)
    {
        gamerewardsactivity.i();
    }

    private void e()
    {
        aa.a(t, (new StringBuilder()).append("publishFacebook. isLoggedIn=").append(com.smule.android.facebook.a.a().h()).append(" hasPublishPermission=").append(com.smule.android.facebook.a.a().i()).toString());
        if (com.smule.android.facebook.a.a().h())
        {
            if (n)
            {
                com.smule.android.facebook.a.a().f();
                com.smule.android.facebook.a.a().b(this);
                n = false;
            } else
            if (com.smule.android.facebook.a.a().i())
            {
                f();
                return;
            }
        }
    }

    static void e(GameRewardsActivity gamerewardsactivity)
    {
        gamerewardsactivity.e();
    }

    private void f()
    {
        if (m != null)
        {
            com.smule.pianoandroid.f.a.a(this).a(this, m, 4);
            return;
        } else
        {
            com.smule.pianoandroid.f.a.a(this).a(this, k, 4);
            return;
        }
    }

    static void f(GameRewardsActivity gamerewardsactivity)
    {
        gamerewardsactivity.g();
    }

    private void g()
    {
        aa.c(t, "Share to Facebook ");
        if (!com.smule.android.facebook.a.a().h())
        {
            n = true;
            LoginManager.getInstance().logInWithReadPermissions(this, b.b);
            return;
        }
        if (!com.smule.android.facebook.a.a().i())
        {
            com.smule.android.facebook.a.a().b(this);
            return;
        } else
        {
            f();
            return;
        }
    }

    private void h()
    {
        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

            final GameRewardsActivity a;

            public void onClick(View view)
            {
                if (a.m != null)
                {
                    com.smule.pianoandroid.f.a.a(a).b(a, a.m, 4);
                    return;
                } else
                {
                    com.smule.pianoandroid.f.a.a(a).b(a, a.k, 4);
                    return;
                }
            }

            
            {
                a = GameRewardsActivity.this;
                super();
            }
        };
        android.view.View.OnClickListener onclicklistener1 = new android.view.View.OnClickListener() {

            final GameRewardsActivity a;

            public void onClick(View view)
            {
                GameRewardsActivity.f(a);
            }

            
            {
                a = GameRewardsActivity.this;
                super();
            }
        };
        android.view.View.OnClickListener onclicklistener2 = new android.view.View.OnClickListener() {

            final GameRewardsActivity a;

            public void onClick(View view)
            {
                if (a.m != null)
                {
                    com.smule.pianoandroid.f.a.a(a).d(a, a.m, 4);
                    return;
                } else
                {
                    com.smule.pianoandroid.f.a.a(a).d(a, a.k, 4);
                    return;
                }
            }

            
            {
                a = GameRewardsActivity.this;
                super();
            }
        };
        android.view.View.OnClickListener onclicklistener3 = new android.view.View.OnClickListener() {

            final GameRewardsActivity a;

            public void onClick(View view)
            {
                if (a.m != null)
                {
                    com.smule.pianoandroid.f.a.a(a).c(a, a.m, 4);
                    return;
                } else
                {
                    com.smule.pianoandroid.f.a.a(a).c(a, a.k, 4);
                    return;
                }
            }

            
            {
                a = GameRewardsActivity.this;
                super();
            }
        };
        android.view.View.OnClickListener onclicklistener4 = new android.view.View.OnClickListener() {

            final GameRewardsActivity a;

            public void onClick(View view)
            {
                if (a.m != null)
                {
                    com.smule.pianoandroid.f.a.a(a).e(a, a.m, 4);
                    return;
                } else
                {
                    com.smule.pianoandroid.f.a.a(a).e(a, a.k, 4);
                    return;
                }
            }

            
            {
                a = GameRewardsActivity.this;
                super();
            }
        };
        ay ay1;
        if (m != null)
        {
            ay1 = com.smule.pianoandroid.magicpiano.ay.b;
        } else
        {
            ay1 = com.smule.pianoandroid.magicpiano.ay.c;
        }
        (new aw(this, ay1, null, null, onclicklistener, onclicklistener1, onclicklistener4, onclicklistener2, onclicklistener3, null)).show();
    }

    private void i()
    {
        class _cls6
        {

            static final int a[];

            static 
            {
                a = new int[com.smule.pianoandroid.a.y.values().length];
                try
                {
                    a[y.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[y.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[y.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[y.b.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        y y1;
        if (j != null)
        {
            y1 = com.smule.pianoandroid.a.x.b();
        } else
        {
            y1 = com.smule.pianoandroid.a.x.a();
        }
        aa.c(t, (new StringBuilder()).append("state : ").append(y1).toString());
        com.smule.pianoandroid.magicpiano._cls6.a[y1.ordinal()];
        JVM INSTR tableswitch 1 3: default 72
    //                   1 80
    //                   2 607
    //                   3 607;
           goto _L1 _L2 _L3 _L3
_L1:
        return;
_L2:
        if (k <= 0) goto _L5; else goto _L4
_L4:
        l = com.smule.pianoandroid.a.x.b(k);
        if (l == null)
        {
            Object obj = com.smule.pianoandroid.e.c.a().a(k);
            Object obj2;
            GameReward gamereward2;
            if (obj != null && ((LevelConfig) (obj)).rewards != null)
            {
                l = new ArrayList(((LevelConfig) (obj)).rewards);
            } else
            {
                l = new ArrayList();
                Crittercism.a(new Exception((new StringBuilder()).append("couldn't load level config for level ").append(k).toString()));
            }
        }
        if (!y) goto _L7; else goto _L6
_L6:
        int i1;
        obj = l.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            obj2 = (GameReward)((Iterator) (obj)).next();
            if (((GameReward) (obj2)).getRewardType() != com.smule.pianoandroid.data.model.GameReward.Type.COINS)
            {
                continue;
            }
            l.remove(obj2);
            break;
        } while (true);
        obj = com.smule.android.network.managers.a.a().a("piandroid.chooseRewards", "rewardSongs", null);
        if (obj != null)
        {
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); aa.c(t, (new StringBuilder()).append("adding reward choice: ").append(((String) (obj2))).toString()))
            {
                obj2 = (String)((Iterator) (obj)).next();
                gamereward2 = new GameReward();
                gamereward2.type = com.smule.pianoandroid.data.model.GameReward.Type.PRODUCT.name();
                gamereward2.value = ((String) (obj2));
                l.add(gamereward2);
            }

        }
        findViewById(0x7f0a00c4).setVisibility(8);
        ((TextView)findViewById(0x7f0a0037)).setText(getResources().getString(0x7f0c0236));
        i1 = 0;
_L9:
        if (l != null && l.size() > 0 || i1 > 0)
        {
            if (l == null)
            {
                l = new ArrayList(1);
            }
            if (i1 > 0)
            {
                GameReward gamereward = new GameReward();
                gamereward.type = com.smule.pianoandroid.data.model.GameReward.Type.UNKNOWN.toString();
                gamereward.amount = i1;
                l.add(gamereward);
            }
            String s = t;
            StringBuilder stringbuilder = (new StringBuilder()).append("Pending rewards : ");
            Object obj1;
            if (l == null)
            {
                obj1 = "null";
            } else
            {
                obj1 = Integer.valueOf(l.size());
            }
            aa.c(s, stringbuilder.append(obj1).toString());
            a(l);
        }
        q.a(d.d, l);
        return;
_L5:
        if (j != null)
        {
            l = com.smule.pianoandroid.a.x.b(j);
            if (l == null)
            {
                l = new ArrayList(m.rewards);
            }
            i1 = m.awardXp;
            continue; /* Loop/switch isn't completed */
        }
          goto _L7
_L3:
        GameReward gamereward1;
        if (j != null)
        {
            i1 = m.awardXp;
        } else
        {
            i1 = 0;
        }
        gamereward1 = new GameReward();
        gamereward1.type = com.smule.pianoandroid.data.model.GameReward.Type.UNKNOWN.toString();
        gamereward1.amount = i1;
        a(Arrays.asList(new GameReward[] {
            gamereward1
        }), true);
        y = false;
        return;
_L7:
        i1 = 0;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void m()
    {
        f.a(1, getResources().getString(0x7f0c0284), true);
        f.dismiss();
        a(i);
    }

    private void n()
    {
        if (m != null)
        {
            setResult(m.awardXp);
        }
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            if (h)
            {
                m();
                return;
            } else
            {
                g = true;
                return;
            }
        } else
        {
            f.a(2, getResources().getString(0x7f0c0237), true);
            return;
        }
    }

    public boolean a()
    {
        return true;
    }

    public String b()
    {
        return "GameRewardsActivity";
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        x.onActivityResult(i1, j1, intent);
    }

    public void onBackPressed()
    {
        n();
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().addFlags(2);
        getWindow().getAttributes().dimAmount = 0.75F;
        overridePendingTransition(0x7f040019, 0x7f04001a);
        setContentView(0x7f03002e);
        x = com.facebook.CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(x, new FacebookCallback() {

            final GameRewardsActivity a;

            public void a(LoginResult loginresult)
            {
                com.smule.pianoandroid.magicpiano.GameRewardsActivity.a(a);
            }

            public void onCancel()
            {
                com.smule.pianoandroid.magicpiano.GameRewardsActivity.a(a);
            }

            public void onError(FacebookException facebookexception)
            {
                aa.c(com.smule.pianoandroid.magicpiano.GameRewardsActivity.c(), "Facebook Error", facebookexception);
                com.smule.pianoandroid.magicpiano.GameRewardsActivity.a(a);
            }

            public void onSuccess(Object obj)
            {
                a((LoginResult)obj);
            }

            
            {
                a = GameRewardsActivity.this;
                super();
            }
        });
        u = new t(this);
        View view;
        if (!com.smule.pianoandroid.magicpiano.c.a.a().d())
        {
            com.smule.pianoandroid.magicpiano.c.a.a().a("");
            com.smule.pianoandroid.magicpiano.c.a.a().b(true);
            y = true;
            q.u();
        } else
        {
            y = false;
        }
        view = findViewById(0x1020002);
        a = (TextView)view.findViewById(0x7f0a00c6);
        b = (TextView)view.findViewById(0x7f0a00c5);
        c = (ImageView)view.findViewById(0x7f0a0040);
        j = getIntent().getStringExtra("ACHIEVEMENT_ID");
        k = getIntent().getIntExtra("LEVEL", 0);
        a.setOnClickListener(new android.view.View.OnClickListener() {

            final GameRewardsActivity a;

            public void onClick(View view1)
            {
                com.smule.pianoandroid.magicpiano.GameRewardsActivity.b(a);
                if (a.m == null && a.k >= 3)
                {
                    view1 = new Runnable(this) {

                        final _cls7 a;

                        public void run()
                        {
                            com.smule.pianoandroid.magicpiano.ar.a(true);
                            a.a.finish();
                        }

            
            {
                a = _pcls7;
                super();
            }
                    };
                    com.smule.pianoandroid.utils.o.a(a, view1, view1, a.getResources().getString(0x7f0c0216), a.getResources().getString(0x7f0c0215));
                    return;
                } else
                {
                    a.finish();
                    return;
                }
            }

            
            {
                a = GameRewardsActivity.this;
                super();
            }
        });
        b.setOnClickListener(new android.view.View.OnClickListener() {

            final GameRewardsActivity a;

            public void onClick(View view1)
            {
                if (a.m != null)
                {
                    view1 = a.getResources().getString(0x7f0c020a);
                    String s = a.getResources().getString(0x7f0c0209);
                    com.smule.pianoandroid.utils.o.a(a, new Runnable(this) {

                        final _cls8 a;

                        public void run()
                        {
                            com.smule.pianoandroid.magicpiano.GameRewardsActivity.c(a.a);
                        }

            
            {
                a = _pcls8;
                super();
            }
                    }, null, view1, s);
                } else
                if (a.k > 0)
                {
                    com.smule.pianoandroid.magicpiano.GameRewardsActivity.a(a, a.i);
                    return;
                }
            }

            
            {
                a = GameRewardsActivity.this;
                super();
            }
        });
        d = new Observer() {

            final GameRewardsActivity a;

            public void update(Observable observable, Object obj)
            {
                a.runOnUiThread(new Runnable(this) {

                    final _cls9 a;

                    public void run()
                    {
                        com.smule.pianoandroid.magicpiano.GameRewardsActivity.d(a.a);
                    }

            
            {
                a = _pcls9;
                super();
            }
                });
            }

            
            {
                a = GameRewardsActivity.this;
                super();
            }
        };
        if (j != null)
        {
            m = com.smule.pianoandroid.e.a.a().c(j);
            if (m == null)
            {
                aa.b(t, "Problem getting achievement definition");
                finish();
            }
            view.findViewById(0x7f0a0037).setVisibility(0);
            ((TextView)view.findViewById(0x7f0a0037)).setText(0x7f0c001c);
            ((TextView)view.findViewById(0x7f0a00c2)).setText(m.title);
        } else
        if (k > 0)
        {
            ((TextView)view.findViewById(0x7f0a0037)).setText(0x7f0c015a);
            ((TextView)view.findViewById(0x7f0a00c2)).setText(String.format(getString(0x7f0c015b), new Object[] {
                Integer.valueOf(k)
            }));
            c.setImageResource(0x7f02010d);
            q.b(k);
            b.setText(0x7f0c01e5);
            b.setVisibility(8);
        } else
        {
            aa.b(t, "Bad usage of activity.");
            finish();
        }
        b(bundle);
        com.smule.android.f.h.a().a(x.a, d);
        com.smule.android.f.h.a().a(x.b, d);
        i();
        if (com.smule.pianoandroid.magicpiano.c.a.a().d())
        {
            findViewById(0x7f0a0063).setOnClickListener(new android.view.View.OnClickListener() {

                final GameRewardsActivity a;

                public void onClick(View view1)
                {
                    com.smule.pianoandroid.magicpiano.GameRewardsActivity.b(a);
                    a.finish();
                }

            
            {
                a = GameRewardsActivity.this;
                super();
            }
            });
            findViewById(0x7f0a0064).setOnClickListener(new android.view.View.OnClickListener() {

                final GameRewardsActivity a;

                public void onClick(View view1)
                {
                }

            
            {
                a = GameRewardsActivity.this;
                super();
            }
            });
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        com.smule.android.f.h.a().b(x.a, d);
        com.smule.android.f.h.a().b(x.b, d);
        if (k > 0)
        {
            com.smule.pianoandroid.a.x.a(k);
            return;
        } else
        {
            com.smule.pianoandroid.a.x.a(j);
            return;
        }
    }

    protected void onPause()
    {
        super.onPause();
        MagicApplication.getInstance().onPause();
        h = false;
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        b(bundle);
    }

    protected void onResume()
    {
        boolean flag = true;
        super.onResume();
        u.d();
        h = true;
        if (g)
        {
            m();
        }
        if (v != null)
        {
            if (w != 1)
            {
                an an1 = v;
                int i1 = w;
                String s = getString(0x7f0c02cc);
                if (w != 2)
                {
                    flag = false;
                }
                an1.a(i1, s, flag);
            }
            v = null;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        a(bundle);
    }

    protected void onStart()
    {
        super.onStart();
        MagicApplication.onActivityStart(this);
    }

    protected void onStop()
    {
        super.onStop();
        MagicApplication.onActivityStop(this);
    }

}
