// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.sessionm.api.AchievementData;
import com.sessionm.api.SessionListener;
import com.sessionm.api.SessionM;
import com.sessionm.api.User;
import com.sessionm.b.a;
import com.sessionm.net.Request;
import com.sessionm.net.RequestQueue;
import com.sessionm.net.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.sessionm.core:
//            f, AchievementImpl, d

public class h
    implements User
{
    public static interface a
    {

        public abstract void onOptInFailed();

        public abstract void onOptInSucceeded();
    }


    private static final String dF = "com.sessionm.user.user_state";
    private static final String dM = "point_balance";
    private static final String dN = "opted_out";
    private static final String dO = "unclaimed_achievement_count";
    private static final String dP = "unclaimed_achievement_value";
    private com.sessionm.b.a dG;
    private int dH;
    private boolean dI;
    private boolean dJ;
    private int dK;
    private int dL;
    private List dQ;

    h()
    {
        dQ = new ArrayList();
        dJ = true;
        aA();
    }

    h(h h1)
    {
        dQ = new ArrayList();
        dI = h1.dI;
        dH = h1.dH;
        dK = h1.dK;
        dL = h1.dL;
        dG = h1.dG;
        dQ = new ArrayList();
        dQ.addAll(h1.dQ);
    }

    static void a(h h1)
    {
        h1.aC();
    }

    private void aA()
    {
        dQ.clear();
        Object obj = f.E().getApplicationContext();
        if (obj != null)
        {
            obj = ((Context) (obj)).getSharedPreferences("com.sessionm.user.user_state", 0);
            dH = ((SharedPreferences) (obj)).getInt("point_balance", 0);
            dK = ((SharedPreferences) (obj)).getInt("unclaimed_achievement_count", 0);
            dL = ((SharedPreferences) (obj)).getInt("unclaimed_achievement_value", 0);
            dI = ((SharedPreferences) (obj)).getBoolean("opted_out", false);
        }
    }

    private void aC()
    {
        Object obj = f.E().getApplicationContext();
        if (obj == null)
        {
            return;
        }
        obj = ((Context) (obj)).getSharedPreferences("com.sessionm.user.user_state", 0);
        if (obj != null)
        {
            try
            {
                obj = ((SharedPreferences) (obj)).edit();
                ((android.content.SharedPreferences.Editor) (obj)).putInt("point_balance", dH);
                ((android.content.SharedPreferences.Editor) (obj)).putInt("unclaimed_achievement_count", dK);
                ((android.content.SharedPreferences.Editor) (obj)).putInt("unclaimed_achievement_value", dL);
                ((android.content.SharedPreferences.Editor) (obj)).putBoolean("opted_out", dI);
                ((android.content.SharedPreferences.Editor) (obj)).commit();
                return;
            }
            catch (Exception exception)
            {
                if (Log.isLoggable("SessionM", 6))
                {
                    Log.e("SessionM", "Exception persisting user", exception);
                }
            }
        }
        return;
    }

    public void a(Context context, boolean flag, a a1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = dI;
        if (flag != flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        dI = flag;
        final f session = f.E();
        session.getExecutorService().execute(new Runnable(a1, flag, context) {

            final Context cK;
            final a dR;
            final boolean dS;
            final h dT;
            final f val$session;

            public void run()
            {
                f f1 = session;
                f1;
                JVM INSTR monitorenter ;
                if (dT.isOptedOut())
                {
                    session.aq().g(session.getApplicationContext());
                }
                com.sessionm.core.h.a(dT);
                if (session.getSessionState() != com.sessionm.api.SessionM.State.STOPPED) goto _L2; else goto _L1
_L1:
                session.a(new SessionListener(this) {

                    final _cls1 dU;

                    public void onSessionFailed(SessionM sessionm, int i)
                    {
                        if (dU.dR != null)
                        {
                            dU.dR.onOptInFailed();
                        }
                        dU.session.b(this);
                    }

                    public void onSessionStateChanged(SessionM sessionm, com.sessionm.api.SessionM.State state)
                    {
                        if (dU.dR != null && state.isStarted())
                        {
                            if (state == com.sessionm.api.SessionM.State.STARTED_ONLINE && dU.session.D().isOptedOut() == dU.dS)
                            {
                                dU.dR.onOptInSucceeded();
                            } else
                            {
                                dU.dR.onOptInFailed();
                            }
                            dU.session.b(this);
                        }
                    }

                    public void onUserUpdated(SessionM sessionm, User user)
                    {
                    }

            
            {
                dU = _pcls1;
                super();
            }
                });
                if (!session.b(cK, session.F()) && dR != null)
                {
                    dR.onOptInFailed();
                }
_L3:
                return;
_L2:
                Object obj1 = com.sessionm.b.a.aG();
                Object obj;
                if (dS)
                {
                    obj = "1";
                } else
                {
                    obj = "0";
                }
                ((com.sessionm.b.a) (obj1)).put("member[opted_out]", ((String) (obj)));
                obj = new Request(com.sessionm.net.Request.Type.fr);
                ((Request) (obj)).d(((com.sessionm.b.a) (obj1)));
                obj1 = session.M();
                ((RequestQueue) (obj1)).a(((Request) (obj)), new c(this) {

                    final _cls1 dU;

                    public void onReplyReceived(Request request)
                    {
                        if (request.ba() == com.sessionm.net.Request.State.fg)
                        {
                            if (dU.dR != null)
                            {
                                dU.dR.onOptInSucceeded();
                            }
                        } else
                        if (dU.dR != null)
                        {
                            dU.dR.onOptInFailed();
                            return;
                        }
                    }

            
            {
                dU = _pcls1;
                super();
            }
                });
                ((RequestQueue) (obj1)).d(((Request) (obj)));
                  goto _L3
                obj;
                f1;
                JVM INSTR monitorexit ;
                throw obj;
            }

            
            {
                dT = h.this;
                session = f1;
                dR = a1;
                dS = flag;
                cK = context;
                super();
            }
        });
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    public String aB()
    {
        this;
        JVM INSTR monitorenter ;
        String s = dG.toString();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    boolean c(com.sessionm.b.a a1)
    {
        boolean flag = false;
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        if (a1 == null) goto _L2; else goto _L1
_L1:
        dG = a1;
        flag = flag1;
        int i;
        if (!a1.has("point_balance"))
        {
            break MISSING_BLOCK_LABEL_53;
        }
        i = a1.getInt("point_balance");
        flag = flag1;
        if (i == dH)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        dH = i;
        flag = true;
        flag1 = flag;
        if (!a1.has("opted_out"))
        {
            break MISSING_BLOCK_LABEL_103;
        }
        flag1 = a1.getBoolean("opted_out");
        if (flag1 == dI)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        dI = flag1;
        flag = true;
        flag1 = flag;
        if (dI)
        {
            flag1 = true;
        }
        flag = flag1;
        if (!a1.has("unclaimed_achievement_count"))
        {
            break MISSING_BLOCK_LABEL_140;
        }
        i = a1.getInt("unclaimed_achievement_count");
        flag = flag1;
        if (i == dK)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        dK = i;
        flag = true;
        flag1 = flag;
        if (!a1.has("unclaimed_achievement_value"))
        {
            break MISSING_BLOCK_LABEL_178;
        }
        i = a1.getInt("unclaimed_achievement_value");
        flag1 = flag;
        if (i == dL)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        dL = i;
        flag1 = true;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        flag = flag1;
        if (!dJ)
        {
            break MISSING_BLOCK_LABEL_210;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        aC();
        dJ = false;
        flag = flag1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        dJ = true;
        dQ.clear();
        if (true) goto _L4; else goto _L3
_L3:
        a1;
        throw a1;
    }

    public void clear()
    {
        Object obj = f.E().getApplicationContext();
        if (obj == null)
        {
            return;
        }
        obj = ((Context) (obj)).getSharedPreferences("com.sessionm.user.user_state", 0);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        obj = ((SharedPreferences) (obj)).edit();
        ((android.content.SharedPreferences.Editor) (obj)).clear();
        ((android.content.SharedPreferences.Editor) (obj)).commit();
_L2:
        aA();
        return;
        Exception exception;
        exception;
        if (Log.isLoggable("SessionM", 6))
        {
            Log.e("SessionM", "Exception clearing user", exception);
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public List getAchievements()
    {
        return dQ;
    }

    public int getPointBalance()
    {
        this;
        JVM INSTR monitorenter ;
        int i = dH;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getUnclaimedAchievementCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = dK;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getUnclaimedAchievementValue()
    {
        this;
        JVM INSTR monitorenter ;
        int i = dL;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public Object getValueForKey(String s)
    {
        this;
        JVM INSTR monitorenter ;
        com.sessionm.b.a a1 = dG;
        if (a1 != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = ((String) (dG.getObject(s)));
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public boolean isOptedOut()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = dI;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public AchievementImpl l(String s)
    {
        for (Iterator iterator = dQ.iterator(); iterator.hasNext();)
        {
            AchievementData achievementdata = (AchievementData)iterator.next();
            if (((AchievementImpl)achievementdata).a().equals(s))
            {
                return (AchievementImpl)achievementdata;
            }
        }

        return null;
    }

    public void setOptedOut(Context context, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        a(context, flag, null);
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public String toString()
    {
        this;
        JVM INSTR monitorenter ;
        String s = String.format(Locale.US, "<User point balance: %d unclaimed achievement count: %d unclaimed achievement value: %d opted_out: %b", new Object[] {
            Integer.valueOf(dH), Integer.valueOf(dK), Integer.valueOf(dL), Boolean.valueOf(dI)
        });
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }
}
