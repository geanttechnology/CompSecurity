// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.utility.bb;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            SessionState, e, ImageStateChangedEvent, a, 
//            StatusManager

public class d
{

    private final String a;
    private String b;
    private ExecutorService c;
    private final long d;
    private SessionState e;
    private SessionState f;
    private List g;
    private int h;
    private e i;

    d(long l1, String s1)
    {
        b = "SessionManager";
        c = Executors.newFixedThreadPool(1);
        d = l1;
        a = (new StringBuilder()).append(Globals.d().q()).append("/session").append(s1).append("/").append(String.valueOf(d)).toString();
        bb.a(a);
        l();
        b = (new StringBuilder()).append("SessionManager").append(s1).toString();
    }

    private void a(String s1)
    {
    }

    private boolean a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        int k1 = g.size();
        int j1;
        j1 = i1;
        if (i1 < 0)
        {
            j1 = 0;
        }
        Object obj;
        ArrayList arraylist;
        Iterator iterator;
        obj = g.subList(j1, k1);
        arraylist = new ArrayList(((List) (obj)).size());
        iterator = ((List) (obj)).iterator();
_L2:
        String s1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_106;
            }
            s1 = ((SessionState)iterator.next()).d();
        } while (s1 == null);
        arraylist.add(s1);
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
        ((List) (obj)).clear();
        h = j1;
        this;
        JVM INSTR monitorexit ;
        return true;
    }

    private void b(String s1)
    {
    }

    private void l()
    {
        this;
        JVM INSTR monitorenter ;
        Globals.d().e((new StringBuilder()).append("SessionManager::clear(), info. TAG=").append(b).append(", mImageID=").append(d).toString());
        if (e != null)
        {
            e.d();
            e = null;
        }
        if (f != null)
        {
            f.d();
            f = null;
        }
        m();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void m()
    {
        this;
        JVM INSTR monitorenter ;
        Globals.d().e((new StringBuilder()).append("SessionManager::_clear(), info. TAG=").append(b).append(", mImageID=").append(d).toString());
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        a(0);
_L1:
        h = -1;
        i = new e(this);
        this;
        JVM INSTR monitorexit ;
        return;
        g = new ArrayList();
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    private SessionState n()
    {
        SessionState sessionstate = null;
        this;
        JVM INSTR monitorenter ;
        int i1;
        b("[getPrevState] ");
        i1 = h;
        if (i1 != -1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return sessionstate;
_L2:
        i1 = h - 2;
        if (i1 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        sessionstate = (SessionState)g.get(i1);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private boolean o()
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        Globals globals;
        StringBuilder stringbuilder;
        globals = Globals.d();
        stringbuilder = (new StringBuilder()).append("SessionManager::isInitialized(), info. TAG=").append(b).append(", mImageID=").append(d).append(", mCount=").append(h).append(", mStateList.size()=").append(g.size()).append(", mInitState=");
        String s1;
        int i1;
        boolean flag;
        if (f != null)
        {
            s1 = "exist";
        } else
        {
            s1 = "null";
        }
        globals.e(stringbuilder.append(s1).toString());
        i1 = g.size();
        if (h > -1) goto _L2; else goto _L1
_L1:
        if (f != null) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (i1 == 0) goto _L5; else goto _L4
_L4:
        a("[isInitialized] ");
        l();
        flag = flag1;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (f != null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        a("[isInitialized] ");
        l();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
        flag = true;
        if (true) goto _L5; else goto _L6
_L6:
    }

    private void p()
    {
        this;
        JVM INSTR monitorenter ;
        g().c();
        d().c();
        h = h + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void q()
    {
        this;
        JVM INSTR monitorenter ;
        d().c();
        h = h - 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean r()
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        int i1 = g.size();
        if (i1 > 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        String s1 = ((SessionState)g.get(0)).d();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        bb.b(new File(s1));
        g.subList(0, 1).clear();
        h = h - 1;
        flag = true;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void s()
    {
        this;
        JVM INSTR monitorenter ;
        b("[clearRedoHistory] ");
        a(h);
        b("[clearRedoHistory] ");
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a()
    {
        l();
        bb.b(new File(a));
    }

    public boolean a(a a1, ImageBufferWrapper imagebufferwrapper)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        Globals.d().e((new StringBuilder()).append("SessionManager::init() enter, TAG=").append(b).append(", mImageID=").append(d).toString());
        if (a1 != null) goto _L2; else goto _L1
_L1:
        Globals.d().e((new StringBuilder()).append("SessionManager::init() error, stateInfo == null, TAG=").append(b).append(", mImageID=").append(d).toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (imagebufferwrapper != null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        Globals.d().e((new StringBuilder()).append("SessionManager::init() error, srcBuffer == null, TAG=").append(b).append(", mImageID=").append(d).toString());
        continue; /* Loop/switch isn't completed */
        a1;
        throw a1;
        if (o())
        {
            Globals.d().e((new StringBuilder()).append("SessionManager::init() error, isInitialized==false, TAG=").append(b).append(", mImageID=").append(d).toString());
            continue; /* Loop/switch isn't completed */
        }
        if (e == null)
        {
            e = new SessionState(this, i.a(), a1, imagebufferwrapper);
        }
        f = new SessionState(this, i.a(), a1, imagebufferwrapper);
        h = 0;
        a1 = new ImageStateChangedEvent(a1.a, f, null, ImageStateChangedEvent.ActionDirection.d);
        StatusManager.j().a(a1);
        Globals.d().e((new StringBuilder()).append("SessionManager::init() leave, TAG=").append(b).append(", mImageID=").append(d).toString());
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean a(a a1, ImageBufferWrapper imagebufferwrapper, ImageBufferWrapper imagebufferwrapper1)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        Globals.d().e((new StringBuilder()).append("SessionManager::initWithoutCompare() enter, TAG=").append(b).append(", mImageID=").append(d).toString());
        boolean flag1;
        if (a1 != null);
        if (imagebufferwrapper != null);
          goto _L1
_L6:
        flag1 = o();
        if (!flag1) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        if (e == null)
        {
            e = new SessionState(this, i.a(), a1, imagebufferwrapper1);
        }
        f = new SessionState(this, i.a(), a1, imagebufferwrapper);
        h = 0;
        a1 = new ImageStateChangedEvent(a1.a, f, null, ImageStateChangedEvent.ActionDirection.d);
        StatusManager.j().a(a1);
        Globals.d().e((new StringBuilder()).append("SessionManager::initWithoutCompare() leave, TAG=").append(b).append(", mImageID=").append(d).toString());
        flag = true;
        if (true) goto _L2; else goto _L4
_L4:
        a1;
        throw a1;
_L1:
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String b()
    {
        return a;
    }

    public boolean b(a a1, ImageBufferWrapper imagebufferwrapper)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (a1 != null);
        if (imagebufferwrapper != null);
          goto _L1
_L7:
        if (imagebufferwrapper.j() != null);
        flag = o();
        if (flag) goto _L3; else goto _L2
_L2:
        flag = false;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        s();
        if (h == 30)
        {
            r();
        }
        a1 = new SessionState(this, i.a(), a1, imagebufferwrapper);
        g.add(a1);
        p();
        b("[saveState] ");
        ViewEngine.a().a(d, imagebufferwrapper);
        flag = true;
        if (true) goto _L5; else goto _L4
_L4:
        a1;
        throw a1;
_L1:
        if (true) goto _L7; else goto _L6
_L6:
    }

    public ExecutorService c()
    {
        return c;
    }

    public SessionState d()
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        b("[getCurrState] ");
        i1 = h;
        if (i1 != -1) goto _L2; else goto _L1
_L1:
        SessionState sessionstate = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return sessionstate;
_L2:
        if (h == 0)
        {
            sessionstate = f;
            continue; /* Loop/switch isn't completed */
        }
        int j1 = h;
        sessionstate = (SessionState)g.get(j1 - 1);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public a e()
    {
        this;
        JVM INSTR monitorenter ;
        if (o()) goto _L2; else goto _L1
_L1:
        String s1 = (new StringBuilder()).append("SessionManager::getCurrentState() error, return null, TAG=").append(b).append(", mImageID=").append(d).toString();
        Globals.d().e(s1);
        a a1 = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return a1;
_L2:
        a1 = d().a();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public a f()
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        if (o()) goto _L2; else goto _L1
_L1:
        String s1 = (new StringBuilder()).append("SessionManager::getPreviousState() error, return null, TAG=").append(b).append(", mImageID=").append(d).toString();
        Globals.d().e(s1);
        a a1 = obj;
_L4:
        this;
        JVM INSTR monitorexit ;
        return a1;
_L2:
        a1 = obj;
        if (!h())
        {
            continue; /* Loop/switch isn't completed */
        }
        a1 = obj;
        if (n() != null)
        {
            a1 = n().a();
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public SessionState g()
    {
        b("[getCompareState] ");
        if (!o())
        {
            return null;
        } else
        {
            return e;
        }
    }

    public boolean h()
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = o();
        if (flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        int i1 = h;
        if (i1 > 0)
        {
            flag = true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected ImageStateChangedEvent i()
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        ImageStateChangedEvent.ActionDirection actiondirection;
        boolean flag;
        actiondirection = ImageStateChangedEvent.ActionDirection.a;
        flag = o();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return ((ImageStateChangedEvent) (obj));
_L2:
        if (h <= 0)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        b("[_undo] ");
        obj = d();
        q();
        SessionState sessionstate = d();
        obj = new ImageStateChangedEvent(d, sessionstate, ((SessionState) (obj)), actiondirection);
          goto _L1
        Exception exception;
        exception;
        throw exception;
        a("[_undo] ");
          goto _L1
    }

    public boolean j()
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = o();
        if (flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        int i1;
        int j1;
        i1 = g.size();
        j1 = h;
        if (i1 > j1)
        {
            flag = true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected ImageStateChangedEvent k()
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        ImageStateChangedEvent.ActionDirection actiondirection;
        boolean flag;
        actiondirection = ImageStateChangedEvent.ActionDirection.b;
        flag = o();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return ((ImageStateChangedEvent) (obj));
_L2:
        int i1 = g.size();
        if (h >= i1)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        b("[_redo] ");
        obj = d();
        p();
        b("[_redo] ");
        SessionState sessionstate = d();
        obj = new ImageStateChangedEvent(d, sessionstate, ((SessionState) (obj)), actiondirection);
          goto _L1
        Exception exception;
        exception;
        throw exception;
        a("[_redo] ");
          goto _L1
    }
}
