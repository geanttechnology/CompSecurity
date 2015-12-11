// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j256.ormlite.dao.Dao;
import com.smule.android.c.aa;
import com.smule.android.f.e;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.network.a.g;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.managers.UserManager;
import com.smule.pianoandroid.a.c;
import com.smule.pianoandroid.a.t;
import com.smule.pianoandroid.a.u;
import com.smule.pianoandroid.a.v;
import com.smule.pianoandroid.a.w;
import com.smule.pianoandroid.a.x;
import com.smule.pianoandroid.data.model.AchievementDefinition;
import com.smule.pianoandroid.data.model.AchievementGoal;
import com.smule.pianoandroid.data.model.AchievementGoalState;
import com.smule.pianoandroid.data.model.AchievementState;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.smule.pianoandroid.e:
//            c, d, b

public class a
{

    public static final String a = com/smule/pianoandroid/e/a.getName();
    private static a c = null;
    private Context b;
    private AtomicBoolean d;
    private final Map e = new HashMap();
    private Map f;
    private Map g;

    private a()
    {
        d = new AtomicBoolean(false);
        f = new HashMap();
        g = new HashMap();
        b = com.smule.android.network.core.b.d().e();
        Observer observer = new Observer() {

            final a a;

            public void update(Observable observable, Object obj)
            {
                observable = (Map)obj;
                try
                {
                    a.a(a, (o)observable.get("game.data.param"), false);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Observable observable)
                {
                    throw new RuntimeException("IO exception while updating achievement info.", observable);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        h.a().a("game.data.sync", observer);
        observer = new Observer() {

            final a a;

            public void update(Observable observable, Object obj)
            {
                observable = (Map)obj;
                try
                {
                    a.a(a, (o)observable.get("game.data.param"), true);
                    h.a().b("game.data.available", this);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Observable observable)
                {
                    throw new RuntimeException("IO exception while updating achievement info.", observable);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        h.a().a("game.data.available", observer);
    }

    public static a a()
    {
        com/smule/pianoandroid/e/a;
        JVM INSTR monitorenter ;
        a a1;
        if (c == null)
        {
            c = new a();
        }
        a1 = c;
        com/smule/pianoandroid/e/a;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
    }

    private String a(v v1, String s)
    {
        s = s.substring(1);
        return (String)com.smule.pianoandroid.a.c.a(v1.b, s);
    }

    private String a(AchievementState achievementstate)
    {
        HashMap hashmap = new HashMap();
        ArrayList arraylist = new ArrayList(achievementstate.goals);
        int j = 10;
        Object obj = "";
        do
        {
            String s;
label0:
            {
                if (j > 0)
                {
                    hashmap.put("goals", arraylist);
                    s = com.smule.android.f.e.a().writeValueAsString(hashmap);
                    if (s.length() > 4050)
                    {
                        break label0;
                    }
                    obj = s;
                }
                return ((String) (obj));
            }
            int i = 0;
            obj = null;
            Iterator iterator = arraylist.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                AchievementGoalState achievementgoalstate = (AchievementGoalState)iterator.next();
                if (achievementgoalstate.uniques.size() > i)
                {
                    i = achievementgoalstate.uniques.size();
                    obj = achievementgoalstate;
                }
            } while (true);
            if (obj != null)
            {
                aa.c(a, (new StringBuilder()).append("Truncating uniques for goal : ").append(((AchievementGoalState) (obj)).goalId).append(" of ").append(achievementstate.definitionId).toString());
                ((AchievementGoalState) (obj)).uniques.clear();
            }
            j--;
            obj = s;
        } while (true);
    }

    private void a(int i)
    {
        h.a().a("game.achievement.loaded", Integer.valueOf(i));
    }

    private void a(o o1, boolean flag)
    {
        int i = 0;
        this;
        JVM INSTR monitorenter ;
        Object obj = new ArrayList();
        Object obj1 = f;
        obj1;
        JVM INSTR monitorenter ;
        Iterator iterator = f.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AchievementDefinition achievementdefinition = (AchievementDefinition)iterator.next();
            if (achievementdefinition.state.completed)
            {
                ((List) (obj)).add(achievementdefinition.state);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_97;
        o1;
        obj1;
        JVM INSTR monitorexit ;
        throw o1;
        o1;
        this;
        JVM INSTR monitorexit ;
        throw o1;
        obj1;
        JVM INSTR monitorexit ;
        if (o1 != null) goto _L2; else goto _L1
_L1:
        o1 = null;
_L18:
        if (o1 == null) goto _L4; else goto _L3
_L3:
        if (!o1.has("playerAchievements") || ((List) (obj)).size() != 0) goto _L4; else goto _L5
_L5:
        o1 = o1.get("playerAchievements").iterator();
_L9:
        if (!o1.hasNext()) goto _L7; else goto _L6
_L6:
        obj = AchievementState.fromJson((JsonNode)o1.next());
        if (obj == null) goto _L9; else goto _L8
_L8:
        obj1 = (AchievementDefinition)f.get(((AchievementState) (obj)).definitionId);
        if (obj1 == null) goto _L11; else goto _L10
_L10:
        obj1.state = ((AchievementState) (obj));
        if (!((AchievementDefinition) (obj1)).state.claimed) goto _L13; else goto _L12
_L12:
        ((AchievementDefinition) (obj1)).state.display();
        int j = i;
_L15:
        a(((AchievementDefinition) (obj1)));
        aa.c(a, (new StringBuilder()).append("Added achievement state : ").append(obj).toString());
        i = j;
          goto _L9
_L2:
        o1 = o1.b();
        continue; /* Loop/switch isn't completed */
_L13:
        j = i;
        if (!((AchievementDefinition) (obj1)).state.completed) goto _L15; else goto _L14
_L14:
        j = i;
        if (((AchievementDefinition) (obj1)).state.claimed) goto _L15; else goto _L16
_L16:
        j = i + 1;
          goto _L15
_L11:
        aa.b(a, (new StringBuilder()).append("Missing achievement definition for UID=").append(((AchievementState) (obj)).definitionId).toString());
          goto _L9
_L7:
        a(i);
_L4:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_352;
        }
        a(((String) (null)), false);
        this;
        JVM INSTR monitorexit ;
        return;
        if (true) goto _L18; else goto _L17
_L17:
    }

    static void a(a a1, o o1, boolean flag)
    {
        a1.a(o1, flag);
    }

    static void a(a a1, String s, boolean flag)
    {
        a1.a(s, flag);
    }

    private void a(String s, boolean flag)
    {
        if (d.getAndSet(true))
        {
            return;
        }
        b(s, flag);
        d.set(false);
        return;
        s;
        aa.b(a, "Failed to sync achievements.", s);
        throw new RuntimeException("Failed to sync achievements", s);
        s;
        d.set(false);
        throw s;
    }

    private boolean a(AchievementDefinition achievementdefinition, v v1, int i)
    {
        Iterator iterator = achievementdefinition.goals.iterator();
        boolean flag = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AchievementGoal achievementgoal = (AchievementGoal)iterator.next();
            if (achievementgoal.eventType.equals(v1.a))
            {
                Map map = achievementgoal.getConditionMap();
                if (map != null && map.size() > 0 && !com.smule.pianoandroid.e.c.a().a(map).a(v1.b))
                {
                    aa.d(a, String.format("Achievement id: %s filtered by condition for goal %s", new Object[] {
                        achievementdefinition.uid, achievementgoal.id
                    }));
                } else
                {
                    aa.a(a, String.format("Achievement id: %s passed condition for goal %s progress increment %d", new Object[] {
                        achievementdefinition.uid, achievementgoal.id, Integer.valueOf(i)
                    }));
                    if (a(achievementgoal, achievementdefinition, v1, i))
                    {
                        flag = true;
                    }
                }
            }
        } while (true);
        return flag;
    }

    private boolean a(AchievementGoal achievementgoal, AchievementDefinition achievementdefinition, v v1, int i)
    {
        AchievementGoalState achievementgoalstate = (AchievementGoalState)achievementdefinition.state.getGoalStateMap().get(achievementgoal.id);
        boolean flag;
        if (achievementgoalstate == null)
        {
            achievementgoalstate = new AchievementGoalState();
            achievementgoalstate.goalId = achievementgoal.id;
            achievementgoalstate.achievement = achievementdefinition.state;
            if (achievementdefinition.state.goals == null)
            {
                achievementdefinition.state.goals = new ArrayList();
            }
            achievementdefinition.state.goals.add(achievementgoalstate);
            flag = true;
        } else
        {
            flag = false;
        }
        if (achievementgoal.uniqueKey != null)
        {
            v1 = a(v1, achievementgoal.uniqueKey);
            if (achievementgoalstate.uniques == null)
            {
                achievementgoalstate.uniques = new HashSet();
            }
            if (achievementgoalstate.uniques.contains(v1))
            {
                return false;
            }
            achievementgoalstate.uniques.add(v1);
            flag = true;
        }
        aa.a(a, (new StringBuilder()).append("Updating achv ").append(achievementdefinition.uid).append(" goal ").append(achievementgoal.id).append(" progress from ").append(achievementgoalstate.progress).append(" by adding ").append(i).toString());
        achievementgoalstate.progress = achievementgoalstate.progress + i;
        if (achievementgoalstate.progress >= achievementgoal.threshold)
        {
            achievementgoalstate.completed = true;
            flag = true;
        }
        if (flag)
        {
            a().a(achievementdefinition);
        }
        return true;
    }

    private void b(String s, boolean flag)
    {
        Object obj = null;
        if (s != null)
        {
            AchievementDefinition achievementdefinition = c(s);
            s = ((String) (obj));
            if (achievementdefinition != null)
            {
                s = ((String) (obj));
                if (achievementdefinition.state.completed)
                {
                    s = ((String) (obj));
                    if (!achievementdefinition.state.claimed)
                    {
                        s = Arrays.asList(new AchievementState[] {
                            achievementdefinition.state
                        });
                    }
                }
            }
        } else
        {
            s = g();
        }
        if (s == null || s.size() == 0)
        {
            return;
        }
        aa.a(a, String.format("Syncing %d achievements to server", new Object[] {
            Integer.valueOf(s.size())
        }));
        obj = new ArrayList();
        Iterator iterator = s.iterator();
        while (iterator.hasNext()) 
        {
            AchievementState achievementstate1 = (AchievementState)iterator.next();
            boolean flag1;
            if (flag && achievementstate1.completed)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ((List) (obj)).add(new com.smule.android.network.a.h(achievementstate1.definitionId, a(achievementstate1), achievementstate1.completed, flag1));
        }
        x.d();
        obj = com.smule.android.network.a.g.a(((List) (obj)));
        x.b(((o) (obj)));
        if (!((o) (obj)).a() || ((o) (obj)).b() == null)
        {
            aa.b(a, (new StringBuilder()).append("Error response from server. Response : ").append(obj).toString());
            return;
        }
        obj = s.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            AchievementState achievementstate = (AchievementState)((Iterator) (obj)).next();
            if (achievementstate.completed && flag)
            {
                aa.a(a, "Marked achievements locally as claimed");
                achievementstate.claimed = true;
                a(achievementstate.getDefinition());
            }
        } while (true);
        c(s);
    }

    private void b(List list)
    {
        Map map = e;
        map;
        JVM INSTR monitorenter ;
        AchievementState achievementstate;
        for (list = list.iterator(); list.hasNext(); e.put(achievementstate.definitionId, achievementstate))
        {
            achievementstate = (AchievementState)list.next();
        }

        break MISSING_BLOCK_LABEL_56;
        list;
        map;
        JVM INSTR monitorexit ;
        throw list;
        map;
        JVM INSTR monitorexit ;
    }

    private void c(List list)
    {
        Map map = e;
        map;
        JVM INSTR monitorenter ;
        AchievementState achievementstate;
        for (list = list.iterator(); list.hasNext(); e.remove(achievementstate.definitionId))
        {
            achievementstate = (AchievementState)list.next();
        }

        break MISSING_BLOCK_LABEL_55;
        list;
        map;
        JVM INSTR monitorexit ;
        throw list;
        map;
        JVM INSTR monitorexit ;
    }

    private List g()
    {
        ArrayList arraylist;
        synchronized (e)
        {
            arraylist = new ArrayList(e.values());
        }
        return arraylist;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public t a(v v1, int i)
    {
        t t1;
        Object obj;
        t1 = new t();
        aa.a(a, (new StringBuilder()).append("Register event ").append(v1.a).append(" values ").append(v1.b).toString());
        obj = d(v1.a);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_361;
        }
        obj = ((List) (obj)).iterator();
_L2:
        Object obj1;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (AchievementDefinition)((Iterator) (obj)).next();
        aa.c(a, String.format("Game event %s is bound to achievement %s progress increment %d", new Object[] {
            v1.a, ((AchievementDefinition) (obj1)).uid, Integer.valueOf(i)
        }));
        AchievementState achievementstate = ((AchievementDefinition) (obj1)).state;
        if (achievementstate.checkCompletion())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!achievementstate.started)
        {
            achievementstate.started = true;
            a(((AchievementDefinition) (obj1)));
        }
        if (!a(((AchievementDefinition) (obj1)), v1, i))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (achievementstate.checkCompletion())
        {
            t1.a.add(achievementstate);
            aa.c(a, String.format("Achievement %s completed", new Object[] {
                ((AchievementDefinition) (obj1)).uid
            }));
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            aa.c(a, String.format("Achievement %s in progress", new Object[] {
                ((AchievementDefinition) (obj1)).uid
            }));
            t1.b.add(achievementstate);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            aa.b(a, (new StringBuilder()).append("Exception registering game event!").append(((Exception) (obj1)).toString()).toString());
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (UserManager.n().h())
        {
            b(t1.a);
            b(t1.b);
        }
        if (t1.a.size() > 0 || t1.b.size() > 0)
        {
            com.smule.pianoandroid.e.d.a().c();
        }
        return t1;
    }

    public void a(v v1, int i, com.smule.pianoandroid.e.b b1)
    {
        w.a(new Runnable(v1, i, b1) {

            final v a;
            final int b;
            final com.smule.pianoandroid.e.b c;
            final a d;

            public void run()
            {
                t t1 = d.a(a, b);
                if (c != null)
                {
                    c.a(t1);
                }
_L2:
                return;
                Object obj;
                obj;
                aa.b(a.a, (new StringBuilder()).append("Exception registering game event!").append(((Exception) (obj)).toString()).toString(), ((Throwable) (obj)));
                if (c == null) goto _L2; else goto _L1
_L1:
                c.a(null);
                return;
                obj;
                if (c != null)
                {
                    c.a(null);
                }
                throw obj;
            }

            
            {
                d = a.this;
                a = v1;
                b = i;
                c = b1;
                super();
            }
        });
    }

    public void a(AchievementDefinition achievementdefinition)
    {
        android.content.SharedPreferences.Editor editor = b.getSharedPreferences("ACHIEVEMENTS_SETTINGS", 0).edit();
        String s = achievementdefinition.toJson();
        aa.a(a, (new StringBuilder()).append("Saving achievement ").append(s).toString());
        editor.putString((new StringBuilder()).append("achievement_").append(achievementdefinition.uid).toString(), s);
        p.a(editor);
    }

    public void a(String s)
    {
        w.a(new Runnable(s) {

            final String a;
            final a b;

            public void run()
            {
                a.a(b, a, true);
            }

            
            {
                b = a.this;
                a = s;
                super();
            }
        });
    }

    public void a(List list)
    {
        Map map = f;
        map;
        JVM INSTR monitorenter ;
        HashMap hashmap;
        hashmap = new HashMap(list.size());
        g.clear();
        list = list.iterator();
_L5:
        AchievementDefinition achievementdefinition;
        AchievementDefinition achievementdefinition1;
        if (!list.hasNext())
        {
            break MISSING_BLOCK_LABEL_267;
        }
        achievementdefinition = (AchievementDefinition)list.next();
        hashmap.put(achievementdefinition.uid, achievementdefinition);
        achievementdefinition1 = (AchievementDefinition)f.get(achievementdefinition.uid);
        if (achievementdefinition1 == null) goto _L2; else goto _L1
_L1:
        achievementdefinition.state = achievementdefinition1.state;
        f.remove(achievementdefinition.uid);
_L4:
        if (achievementdefinition.goals != null)
        {
            AchievementGoal achievementgoal;
            for (Iterator iterator = achievementdefinition.goals.iterator(); iterator.hasNext(); ((List)g.get(achievementgoal.eventType)).add(achievementdefinition.uid))
            {
                achievementgoal = (AchievementGoal)iterator.next();
                if (!g.containsKey(achievementgoal.eventType))
                {
                    g.put(achievementgoal.eventType, new ArrayList());
                }
            }

        }
        break MISSING_BLOCK_LABEL_258;
        list;
        map;
        JVM INSTR monitorexit ;
        throw list;
_L2:
        if (achievementdefinition.state != null) goto _L4; else goto _L3
_L3:
        achievementdefinition.state = AchievementState.build(achievementdefinition);
          goto _L4
        a(achievementdefinition);
          goto _L5
        for (list = f.keySet().iterator(); list.hasNext(); b((String)list.next())) { }
        f = hashmap;
        list = b.getSharedPreferences("ACHIEVEMENTS_SETTINGS", 0).edit();
        list.putString("achievements_list", TextUtils.join(",", f.keySet()));
        p.a(list);
        map;
        JVM INSTR monitorexit ;
    }

    public void b()
    {
        int i = 0;
        SharedPreferences sharedpreferences = b.getSharedPreferences("ACHIEVEMENTS_SETTINGS", 0);
        String s = sharedpreferences.getString("achievements_list", null);
        if (!TextUtils.isEmpty(s))
        {
            String as[] = TextUtils.split(s, ",");
            ArrayList arraylist = new ArrayList(as.length);
            for (int j = as.length; i < j; i++)
            {
                Object obj = as[i];
                obj = sharedpreferences.getString((new StringBuilder()).append("achievement_").append(((String) (obj))).toString(), null);
                if (TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    continue;
                }
                aa.a(a, (new StringBuilder()).append("loading achievement ").append(((String) (obj))).toString());
                obj = AchievementDefinition.fromJson(((String) (obj)));
                if (obj != null)
                {
                    arraylist.add(obj);
                }
            }

            a(arraylist);
        }
    }

    public void b(AchievementDefinition achievementdefinition)
    {
        achievementdefinition.state = AchievementState.build(achievementdefinition);
        a(achievementdefinition);
    }

    public void b(String s)
    {
        android.content.SharedPreferences.Editor editor = b.getSharedPreferences("ACHIEVEMENTS_SETTINGS", 0).edit();
        editor.remove((new StringBuilder()).append("achievement_").append(s).toString());
        p.a(editor);
    }

    public AchievementDefinition c(String s)
    {
        synchronized (f)
        {
            s = (AchievementDefinition)f.get(s);
        }
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public List c()
    {
        ArrayList arraylist;
        synchronized (f)
        {
            arraylist = new ArrayList(f.values());
        }
        return arraylist;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public List d(String s)
    {
        Object obj = (List)g.get(s);
        if (obj != null)
        {
            s = new ArrayList(((List) (obj)).size());
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                AchievementDefinition achievementdefinition = c((String)((Iterator) (obj)).next());
                if (achievementdefinition != null)
                {
                    s.add(achievementdefinition);
                }
            } while (true);
            return s;
        } else
        {
            return null;
        }
    }

    public void d()
    {
        List list = u.d().queryForAll();
        AchievementDefinition achievementdefinition;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); achievementdefinition.rewards = u.b().queryForEq("achievement", Integer.valueOf(achievementdefinition._id)))
        {
            achievementdefinition = (AchievementDefinition)iterator.next();
            aa.a(a, (new StringBuilder()).append("Migrating achievement ").append(achievementdefinition.uid).toString());
            List list1 = u.g().queryForEq("definitionId", achievementdefinition.uid);
            if (list1 == null || list1.isEmpty())
            {
                continue;
            }
            aa.a(a, (new StringBuilder()).append("Migrating achievement ").append(achievementdefinition.uid).append(" state ").toString());
            achievementdefinition.state = (AchievementState)list1.get(0);
            if (achievementdefinition.state.claimed)
            {
                achievementdefinition.state.display();
            }
            list1 = u.f().queryForEq("achievement", Integer.valueOf(achievementdefinition.state._id));
            achievementdefinition.state.goals = list1;
        }

        a(list);
    }

    public void e()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = f.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AchievementDefinition achievementdefinition = (AchievementDefinition)iterator.next();
            if (achievementdefinition.state.started)
            {
                arraylist.add(achievementdefinition.state);
            }
        } while (true);
        if (!arraylist.isEmpty())
        {
            b(arraylist);
        }
    }

    public void f()
    {
        Map map = f;
        map;
        JVM INSTR monitorenter ;
        for (Iterator iterator = f.values().iterator(); iterator.hasNext(); b((AchievementDefinition)iterator.next())) { }
        break MISSING_BLOCK_LABEL_52;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        map;
        JVM INSTR monitorexit ;
    }

}
