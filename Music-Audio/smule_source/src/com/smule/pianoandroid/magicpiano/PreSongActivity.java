// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smule.android.c.aa;
import com.smule.android.c.ab;
import com.smule.android.c.f;
import com.smule.android.f.c;
import com.smule.android.f.p;
import com.smule.android.network.managers.ak;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.data.model.ScoreInfo;
import com.smule.pianoandroid.data.model.SongProgress;
import com.smule.pianoandroid.magicpiano.a.e;
import com.smule.pianoandroid.magicpiano.a.g;
import com.smule.pianoandroid.magicpiano.a.k;
import com.smule.pianoandroid.magicpiano.c.a;
import com.smule.pianoandroid.utils.i;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.t;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, MagicActivity, MagicApplication

public class PreSongActivity extends ag
    implements ab
{

    private static final String j = com/smule/pianoandroid/magicpiano/PreSongActivity.getName();
    LinearLayout a;
    LinearLayout b;
    LinearLayout c;
    RelativeLayout d;
    t e;
    com.smule.pianoandroid.magicpiano.a.a f;
    Integer g;
    Integer h;
    Intent i;
    private Intent k;

    public PreSongActivity()
    {
        e = null;
        g = null;
        h = null;
    }

    private void a(int l)
    {
        if (isFinishing())
        {
            return;
        }
        Object obj = (ProgressBar)findViewById(0x7f0a01a8);
        if (obj != null)
        {
            ((ProgressBar) (obj)).setVisibility(0);
        }
        obj = (ImageView)findViewById(0x7f0a0134);
        if (obj != null)
        {
            ((ImageView) (obj)).setVisibility(0);
        }
        k.setClass(this, com/smule/pianoandroid/magicpiano/MagicActivity);
        int i1 = l;
        if (com.smule.pianoandroid.utils.i.d().b())
        {
            i1 = l;
            if (!com.smule.pianoandroid.magicpiano.c.a.a().h())
            {
                i1 = 1;
            }
        }
        String s2 = k.getStringExtra("SONG_UID_EXTRA");
        if (com.smule.pianoandroid.utils.i.d().b())
        {
            String s1 = com.smule.pianoandroid.utils.i.d().a().song.performanceKey;
            String s = s1;
            if (TextUtils.isEmpty(s1))
            {
                s = "n/a";
            }
            com.smule.android.c.a.b(s, s2, f.e);
        } else
        {
            com.smule.android.c.a.a(null, s2, f.a);
        }
        k.putExtra("SONG_DIFFICULTY", i1);
        startActivity(k);
        finish();
    }

    static void a(PreSongActivity presongactivity)
    {
        presongactivity.d();
    }

    static void a(PreSongActivity presongactivity, int l)
    {
        presongactivity.a(l);
    }

    private boolean c()
    {
        boolean flag1 = false;
        String s = Build.MODEL;
        String as[] = getResources().getStringArray(0x7f060000);
        int i1 = as.length;
        int l = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (l < i1)
                {
                    if (!as[l].equals(Build.MODEL))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            l++;
        } while (true);
    }

    private void d()
    {
        Object obj;
        if (c())
        {
            if (!Boolean.valueOf(((SharedPreferences) (obj = getSharedPreferences("magic_piano_prefs", 0))).getBoolean("htc_multitouch", false)).booleanValue())
            {
                MagicApplication.getInstance().showToast(getString(0x7f0c0141), 1);
                obj = ((SharedPreferences) (obj)).edit();
                ((android.content.SharedPreferences.Editor) (obj)).putBoolean("htc_multitouch", true);
                p.a(((android.content.SharedPreferences.Editor) (obj)));
                return;
            }
        }
    }

    private void e()
    {
        Object obj;
        Object obj1;
        obj = (TextView)findViewById(0x7f0a0121);
        obj1 = k.getStringExtra("SONG_UID_EXTRA");
        if (ak.a().a(((String) (obj1))) != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((obj1 = com.smule.pianoandroid.magicpiano.a.g.a().a(((String) (obj1)))) == null || ((List) (obj1)).size() == 0 || ((ScoreInfo) (obj1 = (ScoreInfo)((List) (obj1)).get(0))).topScore == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((TextView) (obj)).setText(MessageFormat.format(getResources().getString(0x7f0c0242), new Object[] {
            Integer.valueOf(((ScoreInfo) (obj1)).topScore)
        }));
        if (((ScoreInfo) (obj1)).progress == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((ScoreInfo) (obj1)).progress.iterator();
_L5:
        while (((Iterator) (obj)).hasNext()) 
        {
            obj1 = (SongProgress)((Iterator) (obj)).next();
            if (((SongProgress) (obj1)).difficulty == k.b.ordinal())
            {
                if (((SongProgress) (obj1)).stars > 0)
                {
                    android.graphics.drawable.Drawable drawable = getResources().getDrawable(0x7f020195);
                    int l = 1;
                    while (l <= ((SongProgress) (obj1)).stars) 
                    {
                        ((ImageView)findViewById(getResources().getIdentifier((new StringBuilder()).append("bronze_star_").append(l).toString(), "id", getPackageName()))).setImageDrawable(drawable);
                        l++;
                    }
                }
            } else
            {
                if (((SongProgress) (obj1)).difficulty != k.c.ordinal())
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (((SongProgress) (obj1)).stars > 0)
                {
                    android.graphics.drawable.Drawable drawable1 = getResources().getDrawable(0x7f020199);
                    int i1 = 1;
                    while (i1 <= ((SongProgress) (obj1)).stars) 
                    {
                        ((ImageView)findViewById(getResources().getIdentifier((new StringBuilder()).append("silver_star_").append(i1).toString(), "id", getPackageName()))).setImageDrawable(drawable1);
                        i1++;
                    }
                }
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (((SongProgress) (obj1)).stars <= 0) goto _L5; else goto _L4
_L4:
        android.graphics.drawable.Drawable drawable2 = getResources().getDrawable(0x7f020197);
        int j1 = 1;
        while (j1 <= ((SongProgress) (obj1)).stars) 
        {
            ((ImageView)findViewById(getResources().getIdentifier((new StringBuilder()).append("gold_star_").append(j1).toString(), "id", getPackageName()))).setImageDrawable(drawable2);
            j1++;
        }
          goto _L5
    }

    public boolean a()
    {
        return true;
    }

    public String b()
    {
        return "preSong";
    }

    public void onActivityResult(int l, int i1, Intent intent)
    {
        g = Integer.valueOf(l);
        h = Integer.valueOf(i1);
        i = intent;
    }

    public void onBackPressed()
    {
        if (!com.smule.pianoandroid.magicpiano.c.a.a().a)
        {
            o.e(this);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = null;
        if (com.smule.pianoandroid.utils.i.d().a() != null)
        {
            bundle = com.smule.pianoandroid.utils.i.d().a();
        }
        if (bundle != null && com.smule.pianoandroid.utils.i.d().b())
        {
            setContentView(0x7f030055);
            bundle = n.a(((ListingV2) (bundle)).song);
            ActionBar actionbar;
            if (bundle.isEmpty())
            {
                aa.b(j, "No singer info!");
            } else
            {
                TextView textview = (TextView)findViewById(0x7f0a01c4);
                TextView textview1 = (TextView)findViewById(0x7f0a014a);
                ImageView imageview = (ImageView)findViewById(0x7f0a0149);
                View view = findViewById(0x7f0a01c7);
                ImageView imageview1 = (ImageView)view.findViewById(0x7f0a014c);
                TextView textview2 = (TextView)findViewById(0x7f0a014d);
                textview1.setText((CharSequence)((Pair)bundle.get(0)).first);
                com.smule.android.f.c.a((String)((Pair)bundle.get(0)).second, imageview, 0, true, 0);
                if (bundle.size() > 1)
                {
                    textview.setText(getString(0x7f0c01ed));
                    textview2.setVisibility(0);
                    textview2.setText((CharSequence)((Pair)bundle.get(1)).first);
                    view.setVisibility(0);
                    com.smule.android.f.c.a((String)((Pair)bundle.get(1)).second, imageview1, 0x7f0200ae, true, 0);
                } else
                {
                    textview.setText(getString(0x7f0c01ee));
                    textview2.setVisibility(8);
                    view.setVisibility(8);
                    findViewById(0x7f0a014b).setVisibility(8);
                }
            }
            d = (RelativeLayout)findViewById(0x7f0a01c8);
            d.setOnClickListener(new android.view.View.OnClickListener() {

                final PreSongActivity a;

                public void onClick(View view1)
                {
                    view1 = new Intent("android.intent.action.VIEW");
                    view1.setData(Uri.parse(a.getString(0x7f0c0259)));
                    a.startActivity(view1);
                }

            
            {
                a = PreSongActivity.this;
                super();
            }
            });
        } else
        {
            setContentView(0x7f030054);
        }
        k = getIntent();
        aa.a(j, k.getExtras().keySet().toString());
        bundle = k.getStringExtra("SONG_NAME_EXTRA");
        actionbar = getActionBar();
        if (!com.smule.pianoandroid.magicpiano.c.a.a().e())
        {
            actionbar.setDisplayHomeAsUpEnabled(false);
            actionbar.setHomeButtonEnabled(false);
            com.smule.pianoandroid.magicpiano.c.a.a().b(true);
        }
        ((TextView)actionbar.getCustomView().findViewById(0x7f0a0037)).setText(bundle);
        a = (LinearLayout)findViewById(0x7f0a01b3);
        a.setOnClickListener(new android.view.View.OnClickListener() {

            final PreSongActivity a;

            public void onClick(View view1)
            {
                int l = 1;
                if (com.smule.pianoandroid.d.a.b(a) < 1)
                {
                    l = 0;
                }
                com.smule.pianoandroid.magicpiano.PreSongActivity.a(a, l);
            }

            
            {
                a = PreSongActivity.this;
                super();
            }
        });
        b = (LinearLayout)findViewById(0x7f0a01b4);
        b.setOnClickListener(new android.view.View.OnClickListener() {

            final PreSongActivity a;

            public void onClick(View view1)
            {
                if (com.smule.pianoandroid.d.a.b(a) > 2)
                {
                    com.smule.pianoandroid.magicpiano.PreSongActivity.a(a);
                    com.smule.pianoandroid.magicpiano.PreSongActivity.a(a, 2);
                    return;
                }
                view1 = a.getSharedPreferences("user", 0);
                if (!view1.getBoolean("medium_shown", false))
                {
                    o.a(a, 3, a.getResources().getString(0x7f0c017e), new Runnable(this) {

                        final _cls3 a;

                        public void run()
                        {
                            com.smule.pianoandroid.magicpiano.PreSongActivity.a(a.a, 2);
                        }

            
            {
                a = _pcls3;
                super();
            }
                    });
                    view1 = view1.edit();
                    view1.putBoolean("medium_shown", true);
                    p.a(view1);
                    return;
                } else
                {
                    com.smule.pianoandroid.magicpiano.PreSongActivity.a(a, 2);
                    return;
                }
            }

            
            {
                a = PreSongActivity.this;
                super();
            }
        });
        c = (LinearLayout)findViewById(0x7f0a01bd);
        c.setOnClickListener(new android.view.View.OnClickListener() {

            final PreSongActivity a;

            public void onClick(View view1)
            {
                if (com.smule.pianoandroid.d.a.b(a) > 3)
                {
                    com.smule.pianoandroid.magicpiano.PreSongActivity.a(a);
                    com.smule.pianoandroid.magicpiano.PreSongActivity.a(a, 3);
                    return;
                }
                view1 = a.getSharedPreferences("user", 0);
                if (!view1.getBoolean("hard_shown", false))
                {
                    o.a(a, 4, a.getResources().getString(0x7f0c0138), new Runnable(this) {

                        final _cls4 a;

                        public void run()
                        {
                            com.smule.pianoandroid.magicpiano.PreSongActivity.a(a.a, 3);
                        }

            
            {
                a = _pcls4;
                super();
            }
                    });
                    view1 = view1.edit();
                    view1.putBoolean("hard_shown", true);
                    p.a(view1);
                    return;
                } else
                {
                    com.smule.pianoandroid.magicpiano.PreSongActivity.a(a, 3);
                    return;
                }
            }

            
            {
                a = PreSongActivity.this;
                super();
            }
        });
        f = new com.smule.pianoandroid.magicpiano.a.a(this);
        e();
    }

    protected void onDestroy()
    {
        com.smule.pianoandroid.magicpiano.a.e.a(null);
        f.c();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        o.e(this);
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        f.b();
        MagicApplication.getInstance().onPause();
    }

    protected void onPostResume()
    {
        super.onPostResume();
        if (e != null)
        {
            e.d();
            e = null;
        }
        if (g != null)
        {
            if (f.a(g.intValue(), h.intValue(), i))
            {
                e = new t(this);
                e.a(true);
                e.a(i.getStringExtra("PRODUCT_UID"));
            }
            g = null;
            h = null;
            i = null;
        }
        f.a();
    }

    protected void onResume()
    {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
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
