// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.smule.android.c.a;
import com.smule.android.c.aa;
import com.smule.android.f.c;
import com.smule.android.f.h;
import com.smule.android.f.j;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.e;
import com.smule.android.network.managers.i;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import com.smule.android.network.models.StoreSectionV2;
import com.smule.pianoandroid.magicpiano.b.p;
import com.smule.pianoandroid.magicpiano.b.q;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, j, ProductListActivity, g, 
//            MagicActivity, i, MagicApplication, f, 
//            h

public class DailyChallengeActivity extends ag
    implements q, com.smule.pianoandroid.magicpiano.j
{

    private static final String a = com/smule/pianoandroid/magicpiano/DailyChallengeActivity.getName();
    private com.smule.pianoandroid.magicpiano.i b;
    private p c;
    private boolean d;
    private boolean e;
    private SongV2 f;
    private ListView g;
    private View h;
    private List i;
    private List j;
    private Object k;
    private int l;
    private Observer m;
    private Observer n;
    private Observer t;
    private Observer u;

    public DailyChallengeActivity()
    {
        f = null;
        i = new ArrayList(4);
        j = new ArrayList(4);
        k = new ReentrantLock();
        l = 0;
        m = new Observer() {

            final DailyChallengeActivity a;

            public void update(Observable observable, Object obj)
            {
                (new com.smule.pianoandroid.magicpiano.h(a)).execute(new Void[] {
                    null, null, null
                });
            }

            
            {
                a = DailyChallengeActivity.this;
                super();
            }
        };
        n = new Observer() {

            final DailyChallengeActivity a;

            public void update(Observable observable, Object obj)
            {
                observable = (com.smule.android.network.models.ContestData.SubmitState)obj;
                if (observable != com.smule.android.network.models.ContestData.SubmitState.SUBMIT_ERROR) goto _L2; else goto _L1
_L1:
                a.runOnUiThread(new Runnable(this) {

                    final _cls3 a;

                    public void run()
                    {
                        Toast.makeText(a.a, a.a.getString(0x7f0c027a), 1).show();
                    }

            
            {
                a = _pcls3;
                super();
            }
                });
_L4:
                (new com.smule.pianoandroid.magicpiano.h(a)).execute(new Void[] {
                    null, null, null
                });
                return;
_L2:
                if (observable == com.smule.android.network.models.ContestData.SubmitState.SUBMIT_EXPIRED)
                {
                    a.runOnUiThread(new Runnable(this) {

                        final _cls3 a;

                        public void run()
                        {
                            Toast.makeText(a.a, a.a.getString(0x7f0c027b), 1).show();
                        }

            
            {
                a = _pcls3;
                super();
            }
                    });
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = DailyChallengeActivity.this;
                super();
            }
        };
        t = new Observer() {

            final DailyChallengeActivity a;

            public void update(Observable observable, Object obj)
            {
                if ((com.smule.android.network.models.ContestData.SubmitState)obj == com.smule.android.network.models.ContestData.SubmitState.SUBMIT_SUCCESS)
                {
                    com.smule.pianoandroid.utils.q.d(com.smule.android.network.managers.e.a().f().contest.songId);
                }
            }

            
            {
                a = DailyChallengeActivity.this;
                super();
            }
        };
        u = new Observer() {

            final DailyChallengeActivity a;

            public void update(Observable observable, Object obj)
            {
                aa.a(DailyChallengeActivity.b(), "LoadContestTask called from DailyChallenges.init");
                (new com.smule.pianoandroid.magicpiano.h(a)).execute(new Void[] {
                    null, null, null
                });
                com.smule.android.f.h.a().b("DAILY_CHALLENGES_INIT", com.smule.pianoandroid.magicpiano.DailyChallengeActivity.h(a));
            }

            
            {
                a = DailyChallengeActivity.this;
                super();
            }
        };
    }

    static Object a(DailyChallengeActivity dailychallengeactivity)
    {
        return dailychallengeactivity.k;
    }

    static List a(DailyChallengeActivity dailychallengeactivity, List list)
    {
        dailychallengeactivity.i = list;
        return list;
    }

    private void a(int i1, int j1)
    {
        int k1 = 0;
        while (k1 < i1) 
        {
            Object obj = (ImageView)j.get(k1);
            int l1;
            if (k1 == j1)
            {
                l1 = 0x7f0200cf;
            } else
            {
                l1 = 0x7f0200ce;
            }
            ((ImageView) (obj)).setImageResource(l1);
            obj = (View)i.get(k1);
            if (k1 == j1)
            {
                l1 = 4;
            } else
            {
                l1 = 0;
            }
            ((View) (obj)).setVisibility(l1);
            k1++;
        }
    }

    static void a(DailyChallengeActivity dailychallengeactivity, SongV2 songv2)
    {
        dailychallengeactivity.c(songv2);
    }

    static void a(DailyChallengeActivity dailychallengeactivity, String s)
    {
        dailychallengeactivity.a(s);
    }

    static void a(DailyChallengeActivity dailychallengeactivity, List list, int i1)
    {
        dailychallengeactivity.a(list, i1);
    }

    private void a(String s)
    {
        Intent intent = new Intent(getApplicationContext(), com/smule/pianoandroid/magicpiano/ProductListActivity);
        intent.addFlags(0x4000000);
        if (s != null)
        {
            Object obj = ak.a().f(s);
            if (obj != null)
            {
                obj = ak.a().e(((ListingV2) (obj)).listingId);
                if (obj != null)
                {
                    intent.setData((new android.net.Uri.Builder()).path((new StringBuilder()).append("/section/").append(((StoreSectionV2) (obj)).sectionId).append("/song/").append(s).toString()).build());
                }
            }
        }
        startActivity(intent);
        finish();
    }

    private void a(List list, int i1)
    {
        com.smule.android.network.models.ContestData.ContestInfo contestinfo = (com.smule.android.network.models.ContestData.ContestInfo)list.get(i1);
        if (contestinfo.leaderboard != null && !contestinfo.leaderboard.isEmpty())
        {
            com.smule.android.network.models.ContestData.ContestUserState contestuserstate = com.smule.android.network.managers.e.a().a(contestinfo);
            aa.a(a, (new StringBuilder()).append("setAdapter leaderboard ").append(contestinfo.leaderboard).toString());
            ((g)((HeaderViewListAdapter)g.getAdapter()).getWrappedAdapter()).a(contestinfo.leaderboard, contestuserstate.score, contestuserstate.rank);
            h.findViewById(0x7f0a012f).setVisibility(8);
        } else
        {
            com.smule.android.network.models.ContestData.ContestUserState contestuserstate1 = com.smule.android.network.managers.e.a().a(contestinfo);
            aa.a(a, (new StringBuilder()).append("setAdapter empty leaderboard ").append(contestinfo.leaderboard).toString());
            ((g)((HeaderViewListAdapter)g.getAdapter()).getWrappedAdapter()).a(new ArrayList(), contestuserstate1.score, contestuserstate1.rank);
            if (i1 == list.size() - 1)
            {
                h.findViewById(0x7f0a012f).setVisibility(0);
            } else
            {
                h.findViewById(0x7f0a012f).setVisibility(8);
            }
        }
        a(list.size(), i1);
        com.smule.pianoandroid.utils.q.a(list.size() - i1);
    }

    static int b(DailyChallengeActivity dailychallengeactivity)
    {
        return dailychallengeactivity.l;
    }

    static String b()
    {
        return a;
    }

    static List b(DailyChallengeActivity dailychallengeactivity, List list)
    {
        dailychallengeactivity.j = list;
        return list;
    }

    private void b(SongV2 songv2)
    {
        if (songv2 != null && songv2.resourceFilePaths != null && songv2.resourceFilePaths.size() > 0)
        {
            Intent intent = new Intent(this, com/smule/pianoandroid/magicpiano/MagicActivity);
            intent.putExtra("CHALLENGE_EXTRA", true);
            intent.putExtra("CREATE_ACTIVITY_ON_FINISH", true);
            intent.putExtra("SONG_MIDI_EXTRA", (String)songv2.resourceFilePaths.get("main"));
            intent.putExtra("SONG_NAME_EXTRA", songv2.title);
            intent.putExtra("SONG_UID_EXTRA", songv2.songId);
            intent.putExtra("SONG_GENRE_EXTRA", songv2.genre);
            intent.putExtra("SONG_COMPOSER_EXTRA", songv2.artist);
            intent.putExtra("SONG_DIFFICULTY", 3);
            intent.putExtra("SONG_OWNED", Boolean.valueOf(com.smule.android.network.managers.i.a().c(songv2.songId)));
            com.smule.pianoandroid.utils.i.d().a(null, false);
            com.smule.android.network.managers.e.a().b(com.smule.android.network.managers.e.a().f());
            startActivity(intent);
            finish();
        } else
        {
            songv2 = getResources().getString(0x7f0c00d7);
            b.a(2, songv2, true);
        }
        c = null;
    }

    static void b(DailyChallengeActivity dailychallengeactivity, List list, int i1)
    {
        dailychallengeactivity.b(list, i1);
    }

    private void b(List list, int i1)
    {
        com.smule.android.network.models.ContestData.ContestInfo contestinfo = (com.smule.android.network.models.ContestData.ContestInfo)list.get(i1);
        if (contestinfo.leaderboard != null && !contestinfo.leaderboard.isEmpty())
        {
            com.smule.android.network.models.ContestData.ContestUserState contestuserstate = com.smule.android.network.managers.e.a().a(contestinfo);
            aa.a(a, (new StringBuilder()).append("setAdapter leaderboard ").append(contestinfo.leaderboard).toString());
            g.setAdapter(new g(this, this, 0x7f030039, contestinfo.leaderboard, contestuserstate.score, contestuserstate.rank));
            h.findViewById(0x7f0a012f).setVisibility(8);
        } else
        {
            com.smule.android.network.models.ContestData.ContestUserState contestuserstate1 = com.smule.android.network.managers.e.a().a(contestinfo);
            aa.a(a, (new StringBuilder()).append("setAdapter empty leaderboard ").append(contestinfo.leaderboard).toString());
            g.setAdapter(new g(this, this, 0x7f030039, new ArrayList(), contestuserstate1.score, contestuserstate1.rank));
            if (i1 == list.size() - 1)
            {
                h.findViewById(0x7f0a012f).setVisibility(0);
            } else
            {
                h.findViewById(0x7f0a012f).setVisibility(8);
            }
        }
        a(list.size(), i1);
        com.smule.pianoandroid.utils.q.a(list.size() - i1);
    }

    static int c(DailyChallengeActivity dailychallengeactivity)
    {
        int i1 = dailychallengeactivity.l;
        dailychallengeactivity.l = i1 + 1;
        return i1;
    }

    private void c(SongV2 songv2)
    {
        String s = String.format(getResources().getString(0x7f0c00da), new Object[] {
            songv2.title
        });
        if (b != null)
        {
            b.dismiss();
        }
        b = new com.smule.pianoandroid.magicpiano.i(this, s);
        b.a(this);
        b.setCancelable(true);
        b.show();
        (new Bundle()).putBoolean("CREATE_ACTIVITY_ON_FINISH", true);
        c = new p(this, songv2, this, b);
        aa.c(a, (new StringBuilder()).append("Downloading ").append(songv2.songId).append(" for play").toString());
        c.execute(new Void[] {
            null, null, null
        });
    }

    static View d(DailyChallengeActivity dailychallengeactivity)
    {
        return dailychallengeactivity.h;
    }

    static List e(DailyChallengeActivity dailychallengeactivity)
    {
        return dailychallengeactivity.j;
    }

    static List f(DailyChallengeActivity dailychallengeactivity)
    {
        return dailychallengeactivity.i;
    }

    static int g(DailyChallengeActivity dailychallengeactivity)
    {
        int i1 = dailychallengeactivity.l;
        dailychallengeactivity.l = i1 - 1;
        return i1;
    }

    static Observer h(DailyChallengeActivity dailychallengeactivity)
    {
        return dailychallengeactivity.u;
    }

    public void a(SongV2 songv2)
    {
        if (d)
        {
            b(songv2);
            return;
        } else
        {
            e = true;
            f = songv2;
            return;
        }
    }

    public void c_()
    {
        if (c != null)
        {
            c.cancel(true);
            c = null;
        }
        if (b != null)
        {
            b.dismiss();
            b = null;
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(this, com/smule/pianoandroid/magicpiano/ProductListActivity));
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030025);
        g = (ListView)findViewById(0x7f0a009c);
        h = getLayoutInflater().inflate(0x7f03003a, null);
        g.addHeaderView(h);
        bundle = (RelativeLayout)h.findViewById(0x7f0a0123);
        LinearLayout linearlayout = (LinearLayout)h.findViewById(0x7f0a0126);
        try
        {
            com.smule.android.f.c.a(bundle, getResources().getDrawable(0x7f020053));
            com.smule.android.f.c.a(linearlayout, getResources().getDrawable(0x7f020053));
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            com.smule.android.f.c.a(bundle, getResources().getDrawable(0x7f02012d));
            com.smule.android.f.c.a(linearlayout, getResources().getDrawable(0x7f02012d));
        }
        if (!UserManager.n().h())
        {
            bundle = com.smule.android.network.managers.e.a().f();
            if (bundle != null && !bundle.isEnded())
            {
                bundle = com.smule.android.network.managers.e.a().a(bundle);
                if (bundle != null && ((com.smule.android.network.models.ContestData.ContestUserState) (bundle)).started.booleanValue() && ((com.smule.android.network.models.ContestData.ContestUserState) (bundle)).score != null && ((com.smule.android.network.models.ContestData.ContestUserState) (bundle)).submitState == com.smule.android.network.models.ContestData.SubmitState.NOT_SUBMITTED)
                {
                    o.a(this, new Runnable() {

                        final DailyChallengeActivity a;

                        public void run()
                        {
                        }

            
            {
                a = DailyChallengeActivity.this;
                super();
            }
                    }, null, getString(0x7f0c0048), getString(0x7f0c0047));
                }
            }
        }
        com.smule.android.f.h.a().a("NOTIFICATION_SCORE_SUBMITTED", n);
        com.smule.android.f.h.a().a("NOTIFICATION_SCORE_SUBMITTED", t);
        com.smule.android.f.h.a().a("DAILY_CHALLENGES_INIT", u);
        MagicApplication.getInstance();
        MagicApplication.getLoader().a("DailyChallenges.init", Arrays.asList(new String[] {
            "StoreManager.loadStore"
        }), new f()).a();
    }

    public void onDestroy()
    {
        com.smule.android.f.h.a().b("NOTIFICATION_SCORE_SUBMITTED", n);
        com.smule.android.f.h.a().b("NOTIFICATION_SCORE_SUBMITTED", t);
        com.smule.android.f.h.a().b("DAILY_CHALLENGES_INIT", u);
        if (b != null)
        {
            b.dismiss();
            b = null;
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
        d = false;
    }

    protected void onResume()
    {
        super.onResume();
        d = true;
        com.smule.android.c.a.a(r.g);
        if (e)
        {
            b(f);
            e = false;
        }
    }

}
