// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.a;

import android.content.SharedPreferences;
import com.crittercism.app.Crittercism;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.network.a.i;
import com.smule.android.network.core.o;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.a;
import com.smule.android.network.managers.ak;
import com.smule.android.network.models.SongV2;
import com.smule.magicpiano.MagicPerformanceStats;
import com.smule.pianoandroid.a.u;
import com.smule.pianoandroid.a.w;
import com.smule.pianoandroid.a.x;
import com.smule.pianoandroid.a.z;
import com.smule.pianoandroid.data.db.b;
import com.smule.pianoandroid.data.model.ScoreInfo;
import com.smule.pianoandroid.data.model.SongProgress;
import com.smule.pianoandroid.e.d;
import com.smule.pianoandroid.e.e;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.smule.pianoandroid.magicpiano.a:
//            k, e, h, j

public class g
{

    public static final String a = com/smule/pianoandroid/magicpiano/a/g.getSimpleName();
    private static g b = null;
    private AtomicBoolean c;
    private double d;
    private double e;
    private double f;
    private Map g;
    private boolean h;
    private Map i;

    private g()
    {
        c = new AtomicBoolean(false);
        h = false;
        i = new ConcurrentHashMap(8, 0.9F, 1);
        Observer observer = new Observer() {

            final g a;

            public void update(Observable observable, Object obj)
            {
                com.smule.pianoandroid.magicpiano.a.g.a(a);
            }

            
            {
                a = g.this;
                super();
            }
        };
        com.smule.android.f.h.a().a("game.data.sync", observer);
        observer = new Observer() {

            final g a;

            public void update(Observable observable, Object obj)
            {
                if ("SONGBOOK_SYNCED_ACTION".equals((String)((Map)obj).get("ACTION")))
                {
                    com.smule.pianoandroid.magicpiano.a.g.a(a, true);
                    com.smule.pianoandroid.magicpiano.a.g.b(a);
                }
            }

            
            {
                a = g.this;
                super();
            }
        };
        com.smule.android.f.h.a().a("SONGBOOK_UPDATED_EVENT", observer);
        observer = new Observer() {

            final g a;

            public void update(Observable observable, Object obj)
            {
                if (((String)obj).compareTo("LOGIN_TYPE_EXISTING") == 0)
                {
                    com.smule.pianoandroid.magicpiano.a.g.a(a, false);
                    com.smule.android.f.h.a().b("USER_LOGGED_IN_EVENT", this);
                }
            }

            
            {
                a = g.this;
                super();
            }
        };
        com.smule.android.f.h.a().a("USER_LOGGED_IN_EVENT", observer);
        observer = new Observer() {

            final g a;

            public void update(Observable observable, Object obj)
            {
                com.smule.pianoandroid.magicpiano.a.g.a(a, (Map)obj);
                com.smule.pianoandroid.magicpiano.a.g.b(a);
            }

            
            {
                a = g.this;
                super();
            }
        };
        com.smule.android.f.h.a().a("game.data.available", observer);
    }

    private int a(float f1)
    {
        if ((double)f1 >= f)
        {
            return 3;
        }
        if ((double)f1 >= e)
        {
            return 2;
        }
        return (double)f1 < d ? 0 : 1;
    }

    public static g a()
    {
        com/smule/pianoandroid/magicpiano/a/g;
        JVM INSTR monitorenter ;
        g g1;
        if (b == null)
        {
            com.smule.pianoandroid.e.e.a();
            b = new g();
        }
        g1 = b;
        com/smule/pianoandroid/magicpiano/a/g;
        JVM INSTR monitorexit ;
        return g1;
        Exception exception;
        exception;
        throw exception;
    }

    static Map a(g g1, Map map)
    {
        g1.g = map;
        return map;
    }

    private void a(o o1)
    {
        this;
        JVM INSTR monitorenter ;
        Dao dao;
        long l1;
        dao = u.a().getDao(com/smule/pianoandroid/data/model/ScoreInfo);
        l1 = dao.countOf();
        aa.c(a, String.format("Updating score info from server. User has %d scores in DB currently", new Object[] {
            Long.valueOf(l1)
        }));
        if (o1 != null) goto _L2; else goto _L1
_L1:
        o1 = null;
_L13:
        if (o1 == null) goto _L4; else goto _L3
_L3:
        if (!o1.has("playerScores") || l1 != 0L) goto _L4; else goto _L5
_L5:
        Iterator iterator = o1.get("playerScores").iterator();
_L9:
        if (!iterator.hasNext()) goto _L4; else goto _L6
_L6:
        ScoreInfo scoreinfo;
        String s1;
        o1 = (JsonNode)iterator.next();
        scoreinfo = (ScoreInfo)com.smule.android.f.e.a(o1, com/smule/pianoandroid/data/model/ScoreInfo);
        String s = o1.get("songId").asText();
        s1 = ak.a().k(s);
        scoreinfo.songId = s1;
        if (ak.a().a(s1) != null) goto _L8; else goto _L7
_L7:
        aa.b(a, (new StringBuilder()).append("Problem attaching scores from game to actual products. Songbook snapshot should be downloaded first! Problem song : ").append(s1).toString());
          goto _L9
        o1;
        throw o1;
_L2:
        o1 = o1.b();
        continue; /* Loop/switch isn't completed */
_L8:
        o1 = o1.get("progress").asText();
        if (o1 == null) goto _L9; else goto _L10
_L10:
        if (o1.trim().length() <= 0) goto _L9; else goto _L11
_L11:
        for (o1 = com.smule.android.f.e.a().readTree(o1).iterator(); o1.hasNext(); scoreinfo.addSongProgress(SongProgress.fromJsonNode((JsonNode)o1.next()))) { }
        List list;
        scoreinfo.synced = true;
        dao.create(scoreinfo);
        list = a(s1);
        o1 = list;
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_305;
        }
        o1 = new ArrayList();
        i.put(s1, o1);
        o1.add(scoreinfo);
        com.smule.android.f.h.a().a("song_progressed", new Object[] {
            "SONG_PARAM", scoreinfo.songId, "IS_GAME_DATA_UPDATE_PARAM", Boolean.valueOf(true)
        });
          goto _L9
_L4:
        j();
        com.smule.android.f.h.a().a("piandroid.scores.synced", new Object[0]);
        this;
        JVM INSTR monitorexit ;
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    static void a(g g1)
    {
        g1.j();
    }

    static void a(g g1, String s, MagicPerformanceStats magicperformancestats)
    {
        g1.a(s, magicperformancestats);
    }

    private void a(String s, MagicPerformanceStats magicperformancestats)
    {
        SongV2 songv2 = ak.a().a(s);
        if (songv2 == null)
        {
            throw new RuntimeException((new StringBuilder()).append("No product with UID ").append(s).toString());
        }
        List list = a(s);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            i.put(s, obj);
        }
        int i1;
        if (!((List) (obj)).isEmpty())
        {
            s = (ScoreInfo)((List) (obj)).get(0);
        } else
        {
            s = new ScoreInfo();
            s.topScore = magicperformancestats.score();
            s.songId = songv2.songId;
            MagicApplication.getHelper().getDao(com/smule/pianoandroid/data/model/ScoreInfo).create(s);
            ((List) (obj)).add(s);
        }
        i1 = com.smule.pianoandroid.magicpiano.a.k.b.ordinal();
        while (i1 <= magicperformancestats.difficulty) 
        {
            if (com.smule.android.network.managers.a.a().a("piandroid.progression", "backfill_stars", false) || i1 == magicperformancestats.difficulty)
            {
                Object obj1 = s.progressForDifficulty(i1);
                SongProgress songprogress = ((SongProgress) (obj1));
                if (obj1 == null)
                {
                    songprogress = new SongProgress();
                    songprogress.difficulty = i1;
                    songprogress.scoreInfo = s;
                    if (((ScoreInfo) (s)).progress == null)
                    {
                        s.progress = new ArrayList();
                    }
                    ((ScoreInfo) (s)).progress.add(songprogress);
                }
                if (i1 == magicperformancestats.difficulty)
                {
                    float f1 = magicperformancestats.partialProgress();
                    if ((double)f1 > songprogress.bestPartialSuccess)
                    {
                        songprogress.bestPartialSuccess = f1;
                    }
                }
                int j1 = songprogress.stars;
                int k1 = a(magicperformancestats.scoringHitChords(), magicperformancestats.totalScoringChords());
                if (k1 > songprogress.stars)
                {
                    songprogress.stars = k1;
                }
                obj1 = new com.smule.magicpiano.a(songprogress.stars, j1, com.smule.pianoandroid.magicpiano.a.k.values()[i1]);
                magicperformancestats.starCounts.add(obj1);
                MagicApplication.getHelper().getDao(com/smule/pianoandroid/data/model/SongProgress).createOrUpdate(songprogress);
            }
            i1++;
        }
        s.maxScore = magicperformancestats.totalPointsPossible();
        s.lastScore = magicperformancestats.score();
        if (((ScoreInfo) (s)).lastScore > ((ScoreInfo) (s)).topScore)
        {
            s.topScore = ((ScoreInfo) (s)).lastScore;
            com.smule.pianoandroid.magicpiano.a.e.a("beat_personal_score", songv2, magicperformancestats);
        }
        s.synced = false;
        MagicApplication.getHelper().getDao(com/smule/pianoandroid/data/model/ScoreInfo).createOrUpdate(s);
        com.smule.android.f.h.a().a("song_progressed", new Object[] {
            "SONG_PARAM", songv2.songId, "IS_GAME_DATA_UPDATE_PARAM", Boolean.valueOf(false)
        });
        ak.a().i();
        magicperformancestats = new com.smule.pianoandroid.magicpiano.a.h(magicperformancestats, com.smule.pianoandroid.magicpiano.a.j.a());
        if (!com.smule.pianoandroid.magicpiano.c.a.a().d() && com.smule.pianoandroid.e.e.a().f() == 1)
        {
            com.smule.pianoandroid.e.e.a().c();
        } else
        {
            long l1 = magicperformancestats.c();
            if (l1 > 0x30d40L || l1 < 0L)
            {
                Crittercism.a(new Exception((new StringBuilder()).append("invalid xp for song: ").append(l1).append(" score: ").append(((ScoreInfo) (s)).lastScore).append(" base xp: ").append(magicperformancestats.a()).append(" star xp: ").append(magicperformancestats.b()).toString()));
                l1 = 0L;
            }
            com.smule.pianoandroid.e.e.a().b(l1);
        }
        com.smule.pianoandroid.e.d.a().c();
    }

    static boolean a(g g1, boolean flag)
    {
        g1.h = flag;
        return flag;
    }

    static void b(g g1)
    {
        g1.i();
    }

    private void h()
    {
        i.clear();
        try
        {
            ScoreInfo scoreinfo;
            for (Iterator iterator = u.a().getDao(com/smule/pianoandroid/data/model/ScoreInfo).queryForAll().iterator(); iterator.hasNext(); ((List)i.get(scoreinfo.songId)).add(scoreinfo))
            {
                scoreinfo = (ScoreInfo)iterator.next();
                if (!i.containsKey(scoreinfo.songId))
                {
                    i.put(scoreinfo.songId, new ArrayList());
                }
            }

        }
        catch (SQLException sqlexception)
        {
            aa.b(a, "Failed to load songs' ScoreInfo", sqlexception);
        }
    }

    private void i()
    {
        if (g == null || !h)
        {
            return;
        }
        try
        {
            a((o)g.get("game.data.param"));
            g = null;
            return;
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException("SQL exception while updating score info.", sqlexception);
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException("IO exception while updating score info.", ioexception);
        }
    }

    private void j()
    {
        if (c.getAndSet(true))
        {
            return;
        }
        k();
        c.set(false);
        return;
        Object obj;
        obj;
        aa.b(a, "Failed to sync scores.", ((Throwable) (obj)));
        throw new RuntimeException("Failed to sync scores", ((Throwable) (obj)));
        obj;
        c.set(false);
        throw obj;
        obj;
        aa.b(a, "Failed to sync scores.", ((Throwable) (obj)));
        throw new RuntimeException("Failed to sync scores", ((Throwable) (obj)));
    }

    private void k()
    {
        Object obj;
        int i1;
        int j1;
        long l1;
        long l4;
        obj = null;
        if (UserManager.n().h())
        {
            com.smule.pianoandroid.utils.aa.b();
            obj = u.a().getDao(com/smule/pianoandroid/data/model/ScoreInfo);
            obj = ((Dao) (obj)).query(((Dao) (obj)).queryBuilder().where().eq("synced", Boolean.valueOf(false)).prepare());
        }
        i1 = com.smule.pianoandroid.e.e.a().f();
        l4 = com.smule.pianoandroid.e.e.a().e();
        j1 = l();
        l1 = m();
        if ((obj == null || ((List) (obj)).size() > 0) && obj != null || i1 != j1 || l4 != l1) goto _L2; else goto _L1
_L1:
        aa.a(a, "No need to sync scores. Nothing has changed.");
_L4:
        return;
_L2:
        Object obj1;
        long l2;
label0:
        {
            if (obj == null)
            {
                obj = new ArrayList();
            }
            aa.a(a, String.format("Syncing %d scores to server. Level %s / %s.", new Object[] {
                Integer.valueOf(((List) (obj)).size()), Integer.valueOf(com.smule.pianoandroid.e.e.a().f()), Long.valueOf(com.smule.pianoandroid.e.e.a().e())
            }));
            obj1 = new ArrayList(((List) (obj)).size());
            if (UserManager.n().h())
            {
                Iterator iterator = ((List) (obj)).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    ScoreInfo scoreinfo = (ScoreInfo)iterator.next();
                    Object obj2 = new ArrayList(scoreinfo.progress.size());
                    for (Iterator iterator1 = scoreinfo.progress.iterator(); iterator1.hasNext(); ((List) (obj2)).add(((SongProgress)iterator1.next()).toMapForJson())) { }
                    obj2 = com.smule.android.f.e.a().writeValueAsString(obj2);
                    if (scoreinfo.songId != null)
                    {
                        ((List) (obj1)).add(new i(scoreinfo.songId, scoreinfo.lastScore, ((String) (obj2))));
                    }
                } while (true);
            }
            x.c();
            long l3 = com.smule.pianoandroid.e.e.a().e();
            if (l3 <= 0x30d40L)
            {
                l2 = l3;
                if (l3 >= 0L)
                {
                    break label0;
                }
            }
            Crittercism.a(new Exception((new StringBuilder()).append("doSyncScores: invalid xp : ").append(l3).toString()));
            l2 = 0L;
        }
        obj1 = com.smule.android.network.a.g.a(com.smule.pianoandroid.e.e.a().f(), l2, ((List) (obj1)));
        x.a(((o) (obj1)));
        if (!((o) (obj1)).a() || ((o) (obj1)).b() == null)
        {
            aa.b(a, (new StringBuilder()).append("Error response from server. Response : ").append(obj1).toString());
            return;
        }
        a(i1, l4);
        if (UserManager.n().h() && ((List) (obj)).size() > 0)
        {
            Dao dao = u.a().getDao(com/smule/pianoandroid/data/model/ScoreInfo);
            UpdateBuilder updatebuilder = dao.updateBuilder();
            updatebuilder.updateColumnValue("synced", Boolean.valueOf(true));
            ArrayList arraylist = new ArrayList();
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(Integer.valueOf(((ScoreInfo)((Iterator) (obj)).next())._id))) { }
            updatebuilder.where().in("_id", arraylist);
            dao.update(updatebuilder.prepare());
            aa.a(a, "Marked scores locally as synced");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private int l()
    {
        return z.a().b().getInt("last.update.level", 0);
    }

    private long m()
    {
        return z.a().b().getLong("last.update.xp", 0L);
    }

    public int a(float f1, float f2)
    {
        if (f2 <= 0.0F)
        {
            return 0;
        } else
        {
            return a(f1 / f2);
        }
    }

    public List a(String s)
    {
        return (List)i.get(s);
    }

    public void a(double d1, double d2, double d3)
    {
        d = d1;
        e = d2;
        f = d3;
    }

    public void a(int i1, long l1)
    {
        p.a(z.a().c().putInt("last.update.level", i1).putLong("last.update.xp", l1));
    }

    public void a(String s, MagicPerformanceStats magicperformancestats, Runnable runnable)
    {
        w.a(new Runnable(s, magicperformancestats) {

            final String a;
            final MagicPerformanceStats b;
            final g c;

            public void run()
            {
                try
                {
                    com.smule.pianoandroid.magicpiano.a.g.a(c, a, b);
                    return;
                }
                catch (SQLException sqlexception)
                {
                    aa.b(com.smule.pianoandroid.magicpiano.a.g.a, "Problem setting score for song.", sqlexception);
                    return;
                }
                catch (Exception exception)
                {
                    aa.b(com.smule.pianoandroid.magicpiano.a.g.a, "Problem setting score for song.", exception);
                }
            }

            
            {
                c = g.this;
                a = s;
                b = magicperformancestats;
                super();
            }
        }, runnable);
    }

    public void b()
    {
        h();
    }

    public boolean b(String s)
    {
        return i.containsKey(s);
    }

    public void c()
    {
        i.clear();
    }

    public Set d()
    {
        return i.keySet();
    }

    public double e()
    {
        return d;
    }

    public double f()
    {
        return e;
    }

    public double g()
    {
        return f;
    }

}
