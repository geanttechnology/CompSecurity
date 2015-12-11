// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.ap;
import com.smule.android.network.managers.d;
import com.smule.pianoandroid.e.e;
import com.smule.pianoandroid.magicpiano.c.a;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.t;
import com.smule.pianoandroid.utils.u;
import com.smule.pianoandroid.utils.z;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity, PurchaseActivity_, LevelProgressActivity

public class b extends Fragment
    implements u
{

    private static final String g = com/smule/pianoandroid/magicpiano/b.getName();
    private static boolean i = false;
    private static int j = 1;
    private static long k = 0L;
    private static final int l[] = {
        0x7f050025, 0x7f050027, 0x7f050028
    };
    private static final int m[] = {
        131, 1698, 5616
    };
    protected View a;
    protected TextView b;
    protected ProgressBar c;
    protected View d;
    protected ProgressBar e;
    protected boolean f;
    private View h;
    private int n[];
    private int o;
    private SoundPool p;
    private BroadcastReceiver q;
    private Observer r;

    public b()
    {
        q = new BroadcastReceiver() {

            final b a;

            public void onReceive(Context context, Intent intent)
            {
                if (intent.getAction() == "BALANCE_UPDATE_EVENT" || intent.getAction() == "PURCHASE_CANCELLED")
                {
                    a.a(false);
                    return;
                }
                if (intent.getAction() == "BALANCE_SAME_EVENT")
                {
                    a.a(false);
                    return;
                }
                if (intent.getAction() == "SUBSCRIPTION_UPDATED")
                {
                    com.smule.pianoandroid.magicpiano.b.a(a);
                    return;
                } else
                {
                    aa.b(com.smule.pianoandroid.magicpiano.b.e(), "Unknown Broadcast received!");
                    return;
                }
            }

            
            {
                a = b.this;
                super();
            }
        };
        r = new Observer() {

            final b a;

            public void update(Observable observable, Object obj)
            {
                if ((Boolean)obj == Boolean.TRUE)
                {
                    com.smule.pianoandroid.magicpiano.b.a(com.smule.pianoandroid.e.e.a().e());
                    com.smule.pianoandroid.magicpiano.b.a(com.smule.pianoandroid.e.e.a().f());
                    com.smule.android.f.h.a().b("game.level.update", this);
                }
            }

            
            {
                a = b.this;
                super();
            }
        };
    }

    static int a(int i1)
    {
        j = i1;
        return i1;
    }

    static long a(long l1)
    {
        k = l1;
        return l1;
    }

    private void a(int i1, int j1, int k1)
    {
        b(true);
        Object obj;
        int l1;
        boolean flag;
        if (j1 != k1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = e;
        if (!flag)
        {
            l1 = i1;
        } else
        {
            l1 = e.getMax();
        }
        obj = ObjectAnimator.ofInt(obj, "progress", new int[] {
            l1
        });
        ((ObjectAnimator) (obj)).setDuration(2000L);
        ((ObjectAnimator) (obj)).start();
        if (f)
        {
            FragmentActivity fragmentactivity = getActivity();
            fragmentactivity.findViewById(0x7f0a0134).setVisibility(0);
            (new Handler()).postDelayed(new Runnable(fragmentactivity) {

                final Activity a;
                final b b;

                public void run()
                {
                    (new com.d.a.d(a, 180, 0x7f020198, 500L)).a(0.1F, 0.25F).b(45F).a(b.e, 5, 90, 2000);
                    b.b(b, com.smule.pianoandroid.utils.n.a(b.b(b), b.c(b)[0], 0.3F, true));
                }

            
            {
                b = b.this;
                a = activity;
                super();
            }
            }, 100L);
            (new Handler()).postDelayed(new Runnable(flag, i1, j1, k1, fragmentactivity) {

                final boolean a;
                final int b;
                final int c;
                final int d;
                final Activity e;
                final b f;

                public void run()
                {
                    if (com.smule.pianoandroid.magicpiano.b.d(f) != 0)
                    {
                        b.b(f).stop(com.smule.pianoandroid.magicpiano.b.d(f));
                    }
                    if (a)
                    {
                        Object obj1 = new Handler();
                        Object obj2 = new Runnable(this) {

                            final _cls8 a;

                            public void run()
                            {
                                com.smule.pianoandroid.magicpiano.b.a(a.f, a.b, a.c, a.d);
                                com.smule.pianoandroid.utils.n.a(b.b(a.f), b.c(a.f)[2], 0.3F, false);
                            }

            
            {
                a = _pcls8;
                super();
            }
                        };
                        int i2;
                        long l2;
                        if (b.f()[1] != 0)
                        {
                            i2 = b.f()[1];
                        } else
                        {
                            i2 = 2000;
                        }
                        ((Handler) (obj1)).postDelayed(((Runnable) (obj2)), i2 + 200);
                        com.smule.pianoandroid.utils.n.a(b.b(f), b.c(f)[1], 0.3F, false);
                        obj1 = e;
                        if (b.f()[1] != 0)
                        {
                            l2 = b.f()[1];
                        } else
                        {
                            l2 = 2500L;
                        }
                        obj1 = new com.d.a.d(((Activity) (obj1)), 200, 0x7f020198, l2);
                        ((com.d.a.d) (obj1)).b(0.7F, 1.3F);
                        ((com.d.a.d) (obj1)).a(0.1F, 0.25F);
                        ((com.d.a.d) (obj1)).c(90F, 180F);
                        ((com.d.a.d) (obj1)).a(200L, new AccelerateInterpolator());
                        obj2 = f.e;
                        if (b.f()[1] != 0)
                        {
                            i2 = b.f()[1];
                        } else
                        {
                            i2 = 2500;
                        }
                        ((com.d.a.d) (obj1)).a(((View) (obj2)), 5, 200, i2);
                        return;
                    } else
                    {
                        com.smule.pianoandroid.magicpiano.b.a(f, b, c, d);
                        return;
                    }
                }

            
            {
                f = b.this;
                a = flag;
                b = i1;
                c = j1;
                d = k1;
                e = activity;
                super();
            }
            }, 2100L);
            return;
        } else
        {
            b(i1, j1, k1);
            return;
        }
    }

    static void a(b b1)
    {
        b1.g();
    }

    public static void a(b b1, int i1)
    {
        if (!i)
        {
            j = com.smule.pianoandroid.e.e.a().f();
            k = com.smule.pianoandroid.e.e.a().e();
            i = true;
        }
        if (j == 1 && i1 < 10)
        {
            (new Handler()).postDelayed(b1. new Runnable(i1) {

                final b a;
                final int b;

                public void run()
                {
                    com.smule.pianoandroid.magicpiano.b.a(a, b + 1);
                }

            
            {
                a = b.this;
                b = i1;
                super();
            }
            }, 300L);
        } else
        {
            int l1 = com.smule.pianoandroid.e.e.a().f();
            long l2 = com.smule.pianoandroid.e.e.a().e();
            if (b1.isAdded())
            {
                ((TextView)b1.getView().findViewById(0x7f0a0074)).setText(String.format(b1.getString(0x7f0c0159), new Object[] {
                    Integer.valueOf(j)
                }));
                int k1 = Math.round(com.smule.pianoandroid.e.e.a().b() * (float)b1.e.getMax());
                int j1 = Math.round(com.smule.pianoandroid.e.e.a().a(k, j) * (float)b1.e.getMax());
                k = l2;
                i1 = j;
                j = l1;
                if (i && !com.smule.pianoandroid.magicpiano.c.a.a().d())
                {
                    i1 = b1.e.getMax();
                    j1 = 0;
                    k1 = i1 * 1;
                    i1 = 1;
                }
                b1.e.setProgress(j1);
                if (k1 != j1 || l1 != i1)
                {
                    b1.a(k1, l1, i1);
                    return;
                }
                if (b1.getActivity() instanceof ProductListActivity)
                {
                    b1.b(k1, l1, i1);
                    return;
                }
            }
        }
    }

    static void a(b b1, int i1, int j1, int k1)
    {
        b1.b(i1, j1, k1);
    }

    private boolean a(int i1, int j1)
    {
        if (!com.smule.pianoandroid.magicpiano.c.a.a().d() || i1 != j1)
        {
            com.smule.pianoandroid.magicpiano.a.a.a(getActivity());
            return true;
        } else
        {
            return false;
        }
    }

    static int b(b b1, int i1)
    {
        b1.o = i1;
        return i1;
    }

    static SoundPool b(b b1)
    {
        return b1.p;
    }

    private void b(int i1, int j1, int k1)
    {
        b(com.smule.pianoandroid.magicpiano.c.a.a().a);
        e.setProgress(i1);
        View view = getView();
        if (view != null)
        {
            ((TextView)view.findViewById(0x7f0a0074)).setText(String.format(getString(0x7f0c0159), new Object[] {
                Integer.valueOf(j1)
            }));
            getActivity().findViewById(0x7f0a0134).setVisibility(8);
            if (!a(j1, k1))
            {
                com.smule.android.f.h.a().a("LEVEL_PROGRESS_UPDATED", new Object[0]);
            }
        }
    }

    private void b(boolean flag)
    {
        Object obj = null;
        Object obj1 = a;
        android.view.View.OnClickListener onclicklistener;
        if (flag)
        {
            onclicklistener = null;
        } else
        {
            onclicklistener = new android.view.View.OnClickListener() {

                final b a;

                public void onClick(View view)
                {
                    if (!ap.a().b())
                    {
                        a.a(null);
                    }
                }

            
            {
                a = b.this;
                super();
            }
            };
        }
        ((View) (obj1)).setOnClickListener(onclicklistener);
        obj1 = d;
        if (flag)
        {
            onclicklistener = null;
        } else
        {
            onclicklistener = new android.view.View.OnClickListener() {

                final b a;

                public void onClick(View view)
                {
                    view = new Intent(a.getActivity(), com/smule/pianoandroid/magicpiano/LevelProgressActivity);
                    a.startActivity(view);
                }

            
            {
                a = b.this;
                super();
            }
            };
        }
        ((View) (obj1)).setOnClickListener(onclicklistener);
        obj1 = e;
        if (flag)
        {
            onclicklistener = obj;
        } else
        {
            onclicklistener = new android.view.View.OnClickListener() {

                final b a;

                public void onClick(View view)
                {
                    view = new Intent(a.getActivity(), com/smule/pianoandroid/magicpiano/LevelProgressActivity);
                    a.startActivity(view);
                }

            
            {
                a = b.this;
                super();
            }
            };
        }
        ((ProgressBar) (obj1)).setOnClickListener(onclicklistener);
    }

    static int[] c(b b1)
    {
        return b1.n;
    }

    static int d(b b1)
    {
        return b1.o;
    }

    static String e()
    {
        return g;
    }

    static int[] f()
    {
        return m;
    }

    private void g()
    {
        if (ap.a().b())
        {
            a.setClickable(false);
            h.findViewById(0x7f0a0076).setVisibility(8);
            h.findViewById(0x7f0a007c).setVisibility(0);
            h.findViewById(0x7f0a007b).setVisibility(8);
            return;
        } else
        {
            a.setClickable(true);
            h.findViewById(0x7f0a0076).setVisibility(0);
            h.findViewById(0x7f0a007b).setVisibility(0);
            h.findViewById(0x7f0a007c).setVisibility(8);
            return;
        }
    }

    protected void a()
    {
        byte byte0 = 4;
        boolean flag = com.smule.android.network.managers.d.a().d();
        Object obj = c;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        ((ProgressBar) (obj)).setVisibility(i1);
        obj = b;
        if (flag)
        {
            i1 = byte0;
        } else
        {
            i1 = 0;
        }
        ((TextView) (obj)).setVisibility(i1);
        t.e = this;
        c();
        g();
        b(com.smule.pianoandroid.magicpiano.c.a.a().a);
        obj = new IntentFilter();
        ((IntentFilter) (obj)).addAction("BALANCE_UPDATE_EVENT");
        ((IntentFilter) (obj)).addAction("BALANCE_SAME_EVENT");
        ((IntentFilter) (obj)).addAction("SUBSCRIPTION_UPDATED");
        ((IntentFilter) (obj)).addAction("PURCHASE_CANCELLED");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(q, ((IntentFilter) (obj)));
    }

    public void a(Uri uri)
    {
        List list = ap.a().f();
        if (com.smule.android.network.core.r.a(getActivity()) && list != null && !list.isEmpty())
        {
            Intent intent = new Intent(getActivity(), com/smule/pianoandroid/magicpiano/PurchaseActivity_);
            if (uri != null)
            {
                intent.setData(uri);
            }
            startActivity(intent);
            return;
        } else
        {
            com.smule.android.network.core.b.d().p();
            return;
        }
    }

    public void a(boolean flag)
    {
        boolean flag1 = false;
        c();
        Object obj = b;
        int i1;
        if (flag)
        {
            i1 = 4;
        } else
        {
            i1 = 0;
        }
        ((TextView) (obj)).setVisibility(i1);
        obj = c;
        if (flag)
        {
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            i1 = 4;
        }
        ((ProgressBar) (obj)).setVisibility(i1);
    }

    public int b()
    {
        return com.smule.android.network.managers.d.a().e();
    }

    public void c()
    {
        b.setText((new StringBuilder()).append("").append(b()).toString());
    }

    public void d()
    {
        a(true);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        z.a(h, z.d(getActivity()));
    }

    public void onCreate(Bundle bundle)
    {
        int i1 = 0;
        super.onCreate(bundle);
        com.smule.android.f.h.a().a("game.level.update", r);
        if (f)
        {
            n = new int[l.length];
            p = new SoundPool(1, 3, 0);
            for (; i1 < l.length; i1++)
            {
                n[i1] = p.load(getActivity(), l[i1], 1);
            }

        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        h = layoutinflater.inflate(0x7f03001e, viewgroup, false);
        return h;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (f)
        {
            int ai[] = n;
            int j1 = ai.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                int k1 = ai[i1];
                if (k1 != 0)
                {
                    p.unload(k1);
                }
            }

            p.release();
        }
        t.e = null;
        com.smule.android.f.h.a().b("game.level.update", r);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(q);
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        a(this, 0);
    }

}
