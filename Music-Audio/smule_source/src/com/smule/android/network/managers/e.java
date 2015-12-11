// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.format.Time;
import android.util.Pair;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.network.a.c;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.smule.android.network.managers:
//            f, g, UserManager, i

public class e
{

    private static final String a = com/smule/android/network/managers/e.getName();
    private static e h;
    private com.smule.android.network.models.ContestData.ContestInfo b;
    private Map c;
    private Map d;
    private long e;
    private Timer f;
    private Context g;
    private Observer i;

    public e()
    {
        e = 0L;
        i = new Observer() {

            final e a;

            public void update(Observable observable, Object obj)
            {
                if (((String)obj).compareTo("LOGIN_TYPE_EXISTING") == 0)
                {
                    e.a(a);
                    com.smule.android.f.h.a().b("USER_LOGGED_IN_EVENT", com.smule.android.network.managers.e.b(a));
                }
            }

            
            {
                a = e.this;
                super();
            }
        };
    }

    private Time a(Time time)
    {
        Time time1 = new Time();
        time1.switchTimezone("America/Los_Angeles");
        time1.set(0, 0, 12, time.monthDay, time.month, time.year);
        return time1;
    }

    public static e a()
    {
        com/smule/android/network/managers/e;
        JVM INSTR monitorenter ;
        e e1;
        if (h == null)
        {
            h = new e();
        }
        e1 = h;
        com/smule/android/network/managers/e;
        JVM INSTR monitorexit ;
        return e1;
        Exception exception;
        exception;
        throw exception;
    }

    public static f a(Long long1, Integer integer, Boolean boolean1)
    {
        ArrayList arraylist = new ArrayList();
        HashMap hashmap = new HashMap();
        hashmap.put("contestId", long1);
        hashmap.put("score", integer);
        arraylist.add(hashmap);
        return new f(com.smule.android.network.a.c.a(arraylist, boolean1));
    }

    public static f a(ArrayList arraylist, Boolean boolean1)
    {
        ArrayList arraylist1 = new ArrayList();
        HashMap hashmap;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); arraylist1.add(hashmap))
        {
            Pair pair = (Pair)arraylist.next();
            hashmap = new HashMap();
            hashmap.put("contestId", pair.first);
            hashmap.put("score", pair.second);
        }

        return new f(com.smule.android.network.a.c.a(arraylist1, boolean1));
    }

    public static g a(Long long1, String s, Integer integer)
    {
        return new g(com.smule.android.network.a.c.a(long1, s, integer));
    }

    static void a(e e1)
    {
        e1.o();
    }

    private void a(List list)
    {
        com.smule.android.network.models.ContestData.ContestInfo contestinfo;
        for (list = list.iterator(); list.hasNext(); c.put(contestinfo.contest.id, contestinfo))
        {
            contestinfo = (com.smule.android.network.models.ContestData.ContestInfo)list.next();
            com.smule.android.network.models.ContestData.ContestUserState contestuserstate = a(contestinfo);
            if (contestinfo.rank != null)
            {
                contestuserstate.rank = contestinfo.rank;
            }
            if (contestinfo.score != null)
            {
                contestuserstate.score = contestinfo.score;
            }
            if (contestinfo.rank != null && contestinfo.score != null)
            {
                contestuserstate.started = Boolean.valueOf(true);
            }
            if (!contestinfo.isEnded())
            {
                b = contestinfo;
            }
        }

        long l1 = Long.valueOf(System.currentTimeMillis() / 1000L).longValue();
        list = c.entrySet().iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            if (((com.smule.android.network.models.ContestData.ContestInfo)((java.util.Map.Entry)list.next()).getValue()).contest.end.longValue() < Long.valueOf(l1 - 0x54600L).longValue())
            {
                list.remove();
            }
        } while (true);
        list = d.entrySet().iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)list.next();
            if (!c.containsKey(entry.getKey()))
            {
                list.remove();
            }
        } while (true);
        l();
        e = System.currentTimeMillis();
        com.smule.android.f.h.a().a("CONTEST_STATE_MIGHT_HAVE_CHANGED", new Object[0]);
    }

    static Observer b(e e1)
    {
        return e1.i;
    }

    public static f c()
    {
        return new f(com.smule.android.network.a.c.a());
    }

    static void c(e e1)
    {
        e1.m();
    }

    public static f d()
    {
        return new f(com.smule.android.network.a.c.b());
    }

    public static int j()
    {
        Time time = new Time();
        time.setToNow();
        time.switchTimezone("America/Los_Angeles");
        if (time.hour < 12)
        {
            return 12 - time.hour;
        } else
        {
            return 36 - time.hour;
        }
    }

    private void k()
    {
        Object obj = g.getSharedPreferences("CONTEST_SETTINGS", 0);
        if (!((SharedPreferences) (obj)).getString("version", "").equals("1.0"))
        {
            aa.e(a, "Resetting settings");
            c = new HashMap();
            d = new HashMap();
            b = null;
        }
        String s = ((SharedPreferences) (obj)).getString("contests", null);
        if (s != null)
        {
            try
            {
                c = com.smule.android.f.e.a(com.smule.android.f.e.a().readTree(s), new TypeReference() {

                    final e a;

            
            {
                a = e.this;
                super();
            }
                });
            }
            catch (Exception exception1)
            {
                c = new HashMap();
            }
        } else
        {
            c = new HashMap();
        }
        obj = ((SharedPreferences) (obj)).getString("states", null);
        if (obj != null)
        {
            try
            {
                d = com.smule.android.f.e.a(com.smule.android.f.e.a().readTree(((String) (obj))), new TypeReference() {

                    final e a;

            
            {
                a = e.this;
                super();
            }
                });
            }
            catch (Exception exception)
            {
                d = new HashMap();
            }
        } else
        {
            d = new HashMap();
        }
        b = null;
        obj = c.values().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            com.smule.android.network.models.ContestData.ContestInfo contestinfo = (com.smule.android.network.models.ContestData.ContestInfo)((Iterator) (obj)).next();
            if (contestinfo.isEnded())
            {
                continue;
            }
            b = contestinfo;
            break;
        } while (true);
    }

    private void l()
    {
        android.content.SharedPreferences.Editor editor = g.getSharedPreferences("CONTEST_SETTINGS", 0).edit();
        editor.putString("version", "1.0");
        editor.putString("contests", com.smule.android.f.e.a(c));
        editor.putString("states", com.smule.android.f.e.a(d));
        com.smule.android.f.p.a(editor);
    }

    private void m()
    {
        n();
        Date date = i();
        f = new Timer();
        f.schedule(new TimerTask() {

            final e a;

            public void run()
            {
                com.smule.android.f.h.a().a("CONTEST_STATE_MIGHT_HAVE_CHANGED", new Object[0]);
                com.smule.android.network.managers.e.c(a);
            }

            
            {
                a = e.this;
                super();
            }
        }, date);
    }

    private void n()
    {
        f.cancel();
        f.purge();
    }

    private void o()
    {
        b = null;
        c = new HashMap();
    }

    private List p()
    {
        ArrayList arraylist = new ArrayList(c.values());
        Collections.sort(arraylist, new Comparator() {

            final e a;

            public int a(com.smule.android.network.models.ContestData.ContestInfo contestinfo, com.smule.android.network.models.ContestData.ContestInfo contestinfo1)
            {
                return contestinfo.contest.id.compareTo(contestinfo1.contest.id);
            }

            public int compare(Object obj, Object obj1)
            {
                return a((com.smule.android.network.models.ContestData.ContestInfo)obj, (com.smule.android.network.models.ContestData.ContestInfo)obj1);
            }

            
            {
                a = e.this;
                super();
            }
        });
        return arraylist;
    }

    public com.smule.android.network.models.ContestData.ContestUserState a(com.smule.android.network.models.ContestData.ContestInfo contestinfo)
    {
        com.smule.android.network.models.ContestData.ContestUserState contestuserstate1 = (com.smule.android.network.models.ContestData.ContestUserState)d.get(contestinfo.contest.id);
        com.smule.android.network.models.ContestData.ContestUserState contestuserstate = contestuserstate1;
        if (contestuserstate1 == null)
        {
            contestuserstate = new com.smule.android.network.models.ContestData.ContestUserState();
            contestuserstate.reported = Boolean.valueOf(false);
            contestuserstate.started = Boolean.valueOf(false);
            d.put(contestinfo.contest.id, contestuserstate);
        }
        return contestuserstate;
    }

    public void a(int i1, com.smule.android.network.models.ContestData.ContestInfo contestinfo)
    {
        a(contestinfo).score = Integer.valueOf(i1);
        l();
    }

    public void a(Context context)
    {
        g = context;
        f = new Timer();
        k();
        m();
        if (!UserManager.n().h())
        {
            com.smule.android.f.h.a().a("USER_LOGGED_IN_EVENT", i);
        }
    }

    public void b()
    {
        if (c.isEmpty())
        {
            com.smule.android.network.core.b.a(new Runnable() {

                final e a;

                public void run()
                {
                    a.e();
                }

            
            {
                a = e.this;
                super();
            }
            });
        }
    }

    public void b(com.smule.android.network.models.ContestData.ContestInfo contestinfo)
    {
        a(contestinfo).started = Boolean.valueOf(true);
        l();
        com.smule.android.f.h.a().a("CONTEST_STATE_MIGHT_HAVE_CHANGED", new Object[0]);
    }

    public void c(com.smule.android.network.models.ContestData.ContestInfo contestinfo)
    {
        com.smule.android.network.models.ContestData.ContestUserState contestuserstate = a(contestinfo);
        g g1 = a(contestinfo.contest.id, contestinfo.contest.songId, contestuserstate.score);
        if (g1.a.a())
        {
            contestuserstate.submitState = com.smule.android.network.models.ContestData.SubmitState.SUBMIT_SUCCESS;
            if (g1.b.rank != null)
            {
                contestuserstate.rank = g1.b.rank;
            }
            if (g1.b.score != null)
            {
                contestuserstate.score = g1.b.score;
            }
            contestinfo.leaderboard = g1.b.leaderboard;
        } else
        {
            if (g1.a.b == 1016)
            {
                contestinfo = com.smule.android.network.models.ContestData.SubmitState.SUBMIT_EXPIRED;
            } else
            {
                contestinfo = com.smule.android.network.models.ContestData.SubmitState.SUBMIT_ERROR;
            }
            contestuserstate.submitState = contestinfo;
        }
        l();
        com.smule.android.f.h.a().a("NOTIFICATION_SCORE_SUBMITTED", contestuserstate.submitState);
    }

    public boolean d(com.smule.android.network.models.ContestData.ContestInfo contestinfo)
    {
        com.smule.android.network.models.ContestData.ContestUserState contestuserstate;
        if (contestinfo.isEnded())
        {
            if ((contestuserstate = a(contestinfo)).submitState != null && contestuserstate.submitState == com.smule.android.network.models.ContestData.SubmitState.SUBMIT_SUCCESS && contestuserstate.score != null && contestuserstate.rank != null && contestuserstate.rank.longValue() < (long)contestinfo.contest.numWinners.intValue())
            {
                return true;
            }
        }
        return false;
    }

    public List e()
    {
        Object obj = null;
        if (b != null) goto _L2; else goto _L1
_L1:
        if (d != null && d.size() > 0)
        {
            obj = new ArrayList();
            Iterator iterator = d.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (((com.smule.android.network.models.ContestData.ContestUserState)entry.getValue()).score != null)
                {
                    ((ArrayList) (obj)).add(new Pair(entry.getKey(), ((com.smule.android.network.models.ContestData.ContestUserState)entry.getValue()).score));
                }
            } while (true);
            obj = a(((ArrayList) (obj)), Boolean.valueOf(true));
        } else
        {
            obj = d();
        }
_L4:
        if (obj != null && ((f) (obj)).a.a())
        {
            a(((f) (obj)).b.contestInfos);
        }
        return p();
_L2:
        if (b.isEnded() || System.currentTimeMillis() > e + 0x927c0L)
        {
            obj = a(b);
            if (obj != null && ((com.smule.android.network.models.ContestData.ContestUserState) (obj)).score != null)
            {
                obj = a(b.contest.id, ((com.smule.android.network.models.ContestData.ContestUserState) (obj)).score, Boolean.valueOf(true));
            } else
            {
                obj = c();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public com.smule.android.network.models.ContestData.ContestInfo f()
    {
        return b;
    }

    public com.smule.android.network.models.ContestData.ContestInfo g()
    {
        Object obj = null;
        List list = p();
        Collections.reverse(list);
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.smule.android.network.models.ContestData.ContestInfo contestinfo = (com.smule.android.network.models.ContestData.ContestInfo)iterator.next();
            if (contestinfo.isEnded())
            {
                com.smule.android.network.models.ContestData.ContestUserState contestuserstate = a(contestinfo);
                if (d(contestinfo) && !contestuserstate.reported.booleanValue())
                {
                    contestuserstate.reported = Boolean.valueOf(true);
                    contestuserstate.rewardEndDate = new Date(System.currentTimeMillis() + (contestinfo.contest.end.longValue() - contestinfo.contest.start.longValue()) * 1000L);
                    l();
                    obj = contestinfo.contest.rewards.iterator();
                    boolean flag = false;
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        com.smule.android.network.models.ContestData.Reward reward = (com.smule.android.network.models.ContestData.Reward)((Iterator) (obj)).next();
                        if (reward.type.equals("SONG"))
                        {
                            com.smule.android.network.managers.i.a().d(reward.value);
                            aa.b(a, (new StringBuilder()).append("contest ").append(contestinfo.contest.songId).append(" won, adding local entitlement: ").append(reward.value).toString());
                            flag = true;
                        }
                    } while (true);
                    obj = contestinfo;
                    if (!flag)
                    {
                        aa.b(a, "contest won, but an entitlement was not awarded!");
                        obj = contestinfo;
                    }
                }
            }
        } while (true);
        return ((com.smule.android.network.models.ContestData.ContestInfo) (obj));
    }

    public float h()
    {
        Object obj = p();
        Collections.reverse(((List) (obj)));
        obj = ((List) (obj)).iterator();
        Object obj2;
label0:
        do
        {
            if (((Iterator) (obj)).hasNext())
            {
                Object obj1 = (com.smule.android.network.models.ContestData.ContestInfo)((Iterator) (obj)).next();
                obj2 = a(((com.smule.android.network.models.ContestData.ContestInfo) (obj1)));
                if (!((com.smule.android.network.models.ContestData.ContestUserState) (obj2)).reported.booleanValue() || !((com.smule.android.network.models.ContestData.ContestUserState) (obj2)).rewardEndDate.after(new Date()))
                {
                    continue;
                }
                obj1 = ((com.smule.android.network.models.ContestData.ContestInfo) (obj1)).contest.rewards.iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        continue label0;
                    }
                    obj2 = (com.smule.android.network.models.ContestData.Reward)((Iterator) (obj1)).next();
                } while (!((com.smule.android.network.models.ContestData.Reward) (obj2)).type.equals("XP"));
                break;
            } else
            {
                return 0.0F;
            }
        } while (true);
        return Float.parseFloat(((com.smule.android.network.models.ContestData.Reward) (obj2)).value);
    }

    public Date i()
    {
        if (b != null && !b.isEnded())
        {
            return new Date(b.contest.end.longValue() * 1000L);
        }
        Time time = new Time();
        time.setToNow();
        Time time1 = a(time);
        if (time.before(time1))
        {
            return new Date(time1.toMillis(false));
        } else
        {
            Time time2 = new Time();
            time2.set(time.toMillis(false) + 0x5265c00L);
            return new Date(a(time2).toMillis(false));
        }
    }

}
