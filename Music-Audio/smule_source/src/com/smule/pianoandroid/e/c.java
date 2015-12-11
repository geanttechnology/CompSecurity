// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.smule.android.c.aa;
import com.smule.android.f.e;
import com.smule.android.f.k;
import com.smule.android.network.a.g;
import com.smule.android.network.core.b;
import com.smule.pianoandroid.a.a;
import com.smule.pianoandroid.a.d;
import com.smule.pianoandroid.a.i;
import com.smule.pianoandroid.a.j;
import com.smule.pianoandroid.a.l;
import com.smule.pianoandroid.a.m;
import com.smule.pianoandroid.a.n;
import com.smule.pianoandroid.a.o;
import com.smule.pianoandroid.a.p;
import com.smule.pianoandroid.a.q;
import com.smule.pianoandroid.a.r;
import com.smule.pianoandroid.a.s;
import com.smule.pianoandroid.a.u;
import com.smule.pianoandroid.a.w;
import com.smule.pianoandroid.a.z;
import com.smule.pianoandroid.data.model.AchievementDefinition;
import com.smule.pianoandroid.data.model.GameReward;
import com.smule.pianoandroid.data.model.LevelConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.e:
//            a

public class c
{

    public static final String a = com/smule/pianoandroid/e/c.getSimpleName();
    private static c c = null;
    private static boolean h = false;
    private Context b;
    private Map d;
    private final Map e = new HashMap();
    private Map f;
    private OrmLiteSqliteOpenHelper g;

    private c()
    {
        f = new HashMap();
        b = com.smule.android.network.core.b.d().e();
        d = new HashMap();
        d.put("equals", com/smule/pianoandroid/a/i);
        d.put("like", com/smule/pianoandroid/a/p);
        d.put("gt", com/smule/pianoandroid/a/l);
        d.put("ge", com/smule/pianoandroid/a/m);
        d.put("lt", com/smule/pianoandroid/a/n);
        d.put("le", com/smule/pianoandroid/a/o);
        d.put("ne", com/smule/pianoandroid/a/q);
        d.put("and", com/smule/pianoandroid/a/d);
        d.put("or", com/smule/pianoandroid/a/r);
        d.put("true", com/smule/pianoandroid/a/s);
        d.put("false", com/smule/pianoandroid/a/j);
    }

    public static c a()
    {
        com/smule/pianoandroid/e/c;
        JVM INSTR monitorenter ;
        c c1;
        if (c == null)
        {
            c = new c();
        }
        c1 = c;
        com/smule/pianoandroid/e/c;
        JVM INSTR monitorexit ;
        return c1;
        Exception exception;
        exception;
        throw exception;
    }

    private void a(Collection collection)
    {
        Map map = e;
        map;
        JVM INSTR monitorenter ;
        e.clear();
        for (collection = collection.iterator(); collection.hasNext();)
        {
            LevelConfig levelconfig = (LevelConfig)collection.next();
            Iterator iterator = levelconfig.rewards.iterator();
            while (iterator.hasNext()) 
            {
                GameReward gamereward = (GameReward)iterator.next();
                if (gamereward.getRewardType() == com.smule.pianoandroid.data.model.GameReward.Type.PRODUCT)
                {
                    e.put(gamereward.value, Integer.valueOf(levelconfig.level));
                }
            }
        }

        break MISSING_BLOCK_LABEL_116;
        collection;
        map;
        JVM INSTR monitorexit ;
        throw collection;
        map;
        JVM INSTR monitorexit ;
    }

    private void a(List list)
    {
        aa.c(a, (new StringBuilder()).append("Syncing level configurations. Number of levels: ").append(list.size()).toString());
        Map map = f;
        map;
        JVM INSTR monitorenter ;
        HashMap hashmap;
        hashmap = new HashMap(list.size());
        LevelConfig levelconfig;
        for (list = list.iterator(); list.hasNext(); f.remove(Integer.valueOf(levelconfig.level)))
        {
            levelconfig = (LevelConfig)list.next();
            hashmap.put(Integer.valueOf(levelconfig.level), levelconfig);
        }

        break MISSING_BLOCK_LABEL_122;
        list;
        map;
        JVM INSTR monitorexit ;
        throw list;
        f = hashmap;
        map;
        JVM INSTR monitorexit ;
    }

    private static void a(boolean flag)
    {
        com.smule.android.f.p.a(z.a().b().edit().putBoolean("game.config.downloaded", flag));
    }

    static boolean a(c c1)
    {
        return c1.i();
    }

    private void b(JsonNode jsonnode)
    {
        android.content.SharedPreferences.Editor editor = b.getSharedPreferences("LEVEL_SETTINGS", 0).edit();
        jsonnode = com.smule.android.f.e.a(jsonnode);
        aa.a(a, (new StringBuilder()).append("saving levels config ").append(jsonnode).toString());
        editor.putString("levels", jsonnode);
        com.smule.android.f.p.a(editor);
    }

    private void c(JsonNode jsonnode)
    {
        ArrayList arraylist = new ArrayList();
        for (jsonnode = jsonnode.iterator(); jsonnode.hasNext(); arraylist.add(com.smule.android.f.e.a((JsonNode)jsonnode.next(), com/smule/pianoandroid/data/model/LevelConfig))) { }
        a(arraylist);
        a(arraylist);
    }

    static boolean f()
    {
        return j();
    }

    static boolean g()
    {
        return h;
    }

    private void h()
    {
        String s1;
        s1 = b.getSharedPreferences("LEVEL_SETTINGS", 0).getString("levels", null);
        if (TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_65;
        }
        aa.a(a, (new StringBuilder()).append("loading levels config ").append(s1).toString());
        c(com.smule.android.f.e.a().readTree(s1));
        return;
        Exception exception;
        exception;
        aa.b(a, "Error parsing levels config", exception);
        return;
    }

    private boolean i()
    {
        try
        {
            long l1 = System.currentTimeMillis();
            String s1 = com.smule.android.f.n.a(com.smule.android.network.core.b.d().e(), com.smule.pianoandroid.b.default_game_config);
            a(com.smule.android.f.e.a().readTree(s1));
            h = true;
            aa.a(a, (new StringBuilder()).append("Loading default config took ").append(System.currentTimeMillis() - l1).append("ms").toString());
        }
        catch (IOException ioexception)
        {
            aa.b(a, "Could not load default game config", ioexception);
            return false;
        }
        return true;
    }

    private static boolean j()
    {
        return z.a().b().getBoolean("game.config.downloaded", false);
    }

    public a a(Map map)
    {
        return com.smule.pianoandroid.a.a.b(map);
    }

    public com.smule.pianoandroid.a.b a(String s1)
    {
        s1 = (Class)d.get(s1);
        try
        {
            s1 = (com.smule.pianoandroid.a.b)s1.newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return null;
        }
        return s1;
    }

    public LevelConfig a(int k)
    {
        LevelConfig levelconfig;
        synchronized (f)
        {
            levelconfig = (LevelConfig)f.get(Integer.valueOf(k));
        }
        return levelconfig;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(JsonNode jsonnode)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        arraylist = new ArrayList();
        for (Iterator iterator = jsonnode.get("achievements").iterator(); iterator.hasNext(); arraylist.add(AchievementDefinition.fromJson((JsonNode)iterator.next()))) { }
        break MISSING_BLOCK_LABEL_57;
        jsonnode;
        throw jsonnode;
        com.smule.pianoandroid.e.a.a().a(arraylist);
        c(jsonnode.get("levels"));
        b(jsonnode.get("levels"));
        this;
        JVM INSTR monitorexit ;
    }

    public void a(OrmLiteSqliteOpenHelper ormlitesqliteopenhelper)
    {
        g = ormlitesqliteopenhelper;
    }

    public void a(com.smule.android.f.j j1)
    {
        j1.a("GameConfigManager.loadDefaultConfig", null, new k() {

            final c a;

            static k a(_cls1 _pcls1)
            {
                return _pcls1.h;
            }

            public void a(com.smule.android.f.j j2)
            {
                if (!c.f() && !com.smule.pianoandroid.e.c.g())
                {
                    w.a(new Runnable(this, j2) {

                        final com.smule.android.f.j a;
                        final _cls1 b;

                        public void run()
                        {
                            com.smule.pianoandroid.e.c.a(b.a);
                            a.b(com.smule.pianoandroid.e._cls1.a(b));
                        }

            
            {
                b = _pcls1;
                a = j1;
                super();
            }
                    });
                    return;
                } else
                {
                    j2.b(h);
                    return;
                }
            }

            
            {
                a = c.this;
                super();
            }
        }).a();
        j1.a("GameConfigManager.getGameConfig", Arrays.asList(new String[] {
            "GameConfigManager.loadDefaultConfig", "UserManager.userLoggedIn"
        }), new k() {

            final c a;

            static k a(_cls2 _pcls2)
            {
                return _pcls2.h;
            }

            public void a(com.smule.android.f.j j2)
            {
                a.a(new Runnable(this, j2) {

                    final com.smule.android.f.j a;
                    final _cls2 b;

                    public void run()
                    {
                        a.b(com.smule.pianoandroid.e._cls2.a(b));
                    }

            
            {
                b = _pcls2;
                a = j1;
                super();
            }
                });
            }

            
            {
                a = c.this;
                super();
            }
        }).a();
        boolean flag = j();
        aa.c(a, (new StringBuilder()).append("Initializing game config. Config downloaded: ").append(flag).append(" default loaded ").append(h).toString());
        if (!flag)
        {
            com.smule.android.network.core.b.a().i();
            return;
        } else
        {
            a().h();
            com.smule.pianoandroid.e.a.a().b();
            return;
        }
    }

    public void a(Runnable runnable)
    {
        com.smule.android.network.core.b.a(new Runnable(runnable) {

            final Runnable a;
            final c b;

            public void run()
            {
                b.d();
                if (a != null)
                {
                    a.run();
                }
            }

            
            {
                b = c.this;
                a = runnable;
                super();
            }
        });
    }

    public OrmLiteSqliteOpenHelper b()
    {
        return g;
    }

    public Integer b(String s1)
    {
        synchronized (e)
        {
            if (e.size() <= 0)
            {
                a(f.values());
            }
            s1 = (Integer)e.get(s1);
        }
        return s1;
        s1;
        map;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public void c()
    {
        List list = u.e().queryForAll();
        b(com.smule.android.f.e.a().valueToTree(list));
        a(list);
    }

    public boolean d()
    {
        com.smule.android.network.core.o o1 = com.smule.android.network.a.g.a();
        if (o1 != null && o1.j != null && o1.a())
        {
            a(o1.j);
            a(true);
            return true;
        } else
        {
            return false;
        }
    }

    public Collection e()
    {
        Collection collection;
        synchronized (f)
        {
            collection = f.values();
        }
        return collection;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
