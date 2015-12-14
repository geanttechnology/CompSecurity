// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;

import com.cyberlink.youcammakeup.jniproxy.AccessMode;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.viewengine:
//            ImageBufferWrapper, k, ViewEngine

class m
{

    private static final Set a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Long[] {
        Long.valueOf(-5L), Long.valueOf(-6L), Long.valueOf(-20L)
    })));
    private ConcurrentHashMap b;
    private Vector c;
    private ConcurrentHashMap d;
    private double e;
    private Vector f;
    private Thread g;
    private long h;
    private volatile boolean i;

    public m(ViewEngine viewengine)
    {
        g = null;
        h = 15000L;
        i = false;
        b = new ConcurrentHashMap();
        c = new Vector();
        d = new ConcurrentHashMap();
        e = 0.0D;
        f = new Vector();
        g = new Thread(new Runnable() {

            final m a;

            public void run()
            {
                while (!m.a(a)) 
                {
                    try
                    {
                        Thread.sleep(m.b(a));
                        m.c(a);
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                }
            }

            
            {
                a = m.this;
                super();
            }
        });
        g.setName("[ViewEngine] gcWorkerThread");
    }

    private void a(long l)
    {
        this;
        JVM INSTR monitorenter ;
        Vector vector = (Vector)d.get(Long.valueOf(l));
        if (vector != null) goto _L2; else goto _L1
_L1:
        a((new StringBuilder()).append("[ViewEngineCacheMgr][removeBufferFromImageID] Cannot find out the cached list. ImageID:").append(l).toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (vector == null) goto _L4; else goto _L3
_L3:
        for (; vector.size() > 0; b((String)vector.get(0))) { }
        break MISSING_BLOCK_LABEL_78;
        Exception exception;
        exception;
        throw exception;
        d.remove(Long.valueOf(l));
          goto _L4
    }

    static void a(m m1, long l)
    {
        m1.a(l);
    }

    private void a(String s)
    {
    }

    private boolean a(double d1)
    {
        this;
        JVM INSTR monitorenter ;
_L4:
        if (e + d1 <= 350D) goto _L2; else goto _L1
_L1:
        Iterator iterator = d.keySet().iterator();
        boolean flag = false;
label0:
        do
        {
            Long long1;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                long1 = (Long)iterator.next();
            } while (a.contains(long1));
            flag = c(long1.longValue());
        } while (!flag);
        if (flag) goto _L4; else goto _L3
_L3:
        if (a(c)) goto _L4; else goto _L5
_L5:
        a("[ViewEngineCacheMgr][requestMemorySize] Warning ~!!! Do not remove anything !! this is an bugs~");
        flag = false;
_L7:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
        Exception exception;
        exception;
        throw exception;
    }

    static boolean a(m m1)
    {
        return m1.i;
    }

    private boolean a(Vector vector)
    {
        this;
        JVM INSTR monitorenter ;
        String s = null;
        String as[];
        int j1;
        as = (String[])vector.toArray(new String[0]);
        j1 = as.length;
        int j;
        int l;
        l = 0;
        j = -1;
        vector = s;
_L6:
        if (l >= j1)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        s = as[l];
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        j = ((ImageBufferWrapper)b.get(s)).b;
        vector = s;
        break MISSING_BLOCK_LABEL_133;
        int i1 = ((ImageBufferWrapper)b.get(s)).b;
        if (j > i1)
        {
            j = i1;
            vector = s;
        }
        break MISSING_BLOCK_LABEL_133;
        if (vector == null) goto _L2; else goto _L1
_L1:
        b(vector);
        boolean flag = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        a("[ViewEngineCacheMgr][removeMemoryFromList] Do not remove anything !!");
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        vector;
        throw vector;
        l++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static long b(m m1)
    {
        return m1.h;
    }

    private void b(long l)
    {
        this;
        JVM INSTR monitorenter ;
        Vector vector = (Vector)d.get(Long.valueOf(l));
        if (vector != null) goto _L2; else goto _L1
_L1:
        a((new StringBuilder()).append("[ViewEngineCacheMgr][removeThumbBufferFromImageID] Cannot find out the cached list. ImageID:").append(l).toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (vector == null) goto _L4; else goto _L3
_L3:
        String as[];
        int i1;
        as = (String[])vector.toArray(new String[0]);
        i1 = as.length;
        int j = 0;
_L6:
        if (j >= i1) goto _L4; else goto _L5
_L5:
        String s = as[j];
        if (!((ImageBufferWrapper)b.get(s)).imageType.equals(ViewEngine.ImageType.b))
        {
            break MISSING_BLOCK_LABEL_121;
        }
        b(s);
          goto _L4
        Exception exception;
        exception;
        throw exception;
        j++;
          goto _L6
    }

    private void b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        ImageBufferWrapper imagebufferwrapper = (ImageBufferWrapper)b.get(s);
        if (imagebufferwrapper != null) goto _L2; else goto _L1
_L1:
        a((new StringBuilder()).append("[ViewEngineCacheMgr][removeBufferFromKey] removeKey: ").append(s).toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        long l = imagebufferwrapper.imageID;
        e = e - imagebufferwrapper.h();
        imagebufferwrapper.m();
        b.remove(s);
        c.remove(s);
        if (d.containsKey(Long.valueOf(l)))
        {
            ((Vector)d.get(Long.valueOf(l))).remove(s);
        }
        f.remove(s);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    private void c(ImageBufferWrapper imagebufferwrapper)
    {
        this;
        JVM INSTR monitorenter ;
        String s = imagebufferwrapper.f();
        long l = imagebufferwrapper.imageID;
        if (!b.containsKey(s))
        {
            b.put(s, imagebufferwrapper);
            c.add(s);
            if (!d.containsKey(Long.valueOf(l)))
            {
                d.put(Long.valueOf(l), new Vector());
            }
            ((Vector)d.get(Long.valueOf(l))).add(s);
            if (imagebufferwrapper.g())
            {
                f.add(s);
            }
            imagebufferwrapper.l();
            e = e + imagebufferwrapper.h();
            if (imagebufferwrapper.name.lastIndexOf("_VESrc") == -1)
            {
                imagebufferwrapper.name = (new StringBuilder()).append(imagebufferwrapper.name).append("_VESrc").toString();
            }
            imagebufferwrapper.a(AccessMode.b);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        imagebufferwrapper;
        throw imagebufferwrapper;
    }

    static void c(m m1)
    {
        m1.e();
    }

    private boolean c(long l)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        Vector vector;
        if (!d.containsKey(Long.valueOf(l)))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        vector = (Vector)d.get(Long.valueOf(l));
_L3:
        flag1 = flag;
        if (vector.size() <= 2)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        flag1 = a(vector);
        if (flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = true;
          goto _L3
        Exception exception;
        exception;
        throw exception;
        flag = flag1;
          goto _L1
    }

    private void d(ImageBufferWrapper imagebufferwrapper)
    {
        this;
        JVM INSTR monitorenter ;
        long l = imagebufferwrapper.imageID;
        if (c(l))
        {
            a((new StringBuilder()).append("[ViewEngineCacheMgr][pushMemory] Too many buffer in Memory. Remove it. imageID:").append(l).toString());
        }
        c(imagebufferwrapper);
        this;
        JVM INSTR monitorexit ;
        return;
        imagebufferwrapper;
        throw imagebufferwrapper;
    }

    private void e()
    {
        this;
        JVM INSTR monitorenter ;
        double d1 = e;
        if (d1 >= 100D) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator;
        long l1;
        l1 = StatusManager.j().l();
        iterator = d.keySet().iterator();
_L4:
        String as[];
        int l;
        Long long1;
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            long1 = (Long)iterator.next();
        } while (long1.longValue() == l1 || a.contains(long1));
        as = (String[])((Vector)d.get(long1)).toArray(new String[0]);
        l = as.length;
        int j = 0;
_L6:
        if (j >= l) goto _L4; else goto _L3
_L3:
        Object obj = as[j];
        if (!b.containsKey(obj))
        {
            break MISSING_BLOCK_LABEL_229;
        }
        obj = (ImageBufferWrapper)b.get(obj);
        if (((ImageBufferWrapper) (obj)).b != ((ImageBufferWrapper) (obj)).c)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        if (((ImageBufferWrapper) (obj)).b > 10)
        {
            obj.b = ((ImageBufferWrapper) (obj)).b - 1;
            obj.c = ((ImageBufferWrapper) (obj)).c - 1;
            break MISSING_BLOCK_LABEL_229;
        }
        e(((ImageBufferWrapper) (obj)));
        break MISSING_BLOCK_LABEL_229;
        Exception exception;
        exception;
        throw exception;
        obj.c = ((ImageBufferWrapper) (obj)).b;
        j++;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L4; else goto _L7
_L7:
        if (true) goto _L1; else goto _L8
_L8:
    }

    private void e(ImageBufferWrapper imagebufferwrapper)
    {
        b(imagebufferwrapper.f());
    }

    public ImageBufferWrapper a(long l, double d1, ViewEngine.ImageType imagetype)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = (Vector)d.get(Long.valueOf(l));
        if (obj != null) goto _L2; else goto _L1
_L1:
        imagetype = null;
_L7:
        this;
        JVM INSTR monitorexit ;
        return imagetype;
_L2:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        String as[];
        int i1;
        as = (String[])((Vector) (obj)).toArray(new String[0]);
        i1 = as.length;
        int j = 0;
_L5:
        if (j >= i1) goto _L4; else goto _L3
_L3:
        obj = as[j];
        if (!b.containsKey(obj))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (ImageBufferWrapper)b.get(obj);
        if (((ImageBufferWrapper) (obj)).imageID != l || (((ImageBufferWrapper) (obj)).imageType != imagetype || imagetype != ViewEngine.ImageType.b) && ((ImageBufferWrapper) (obj)).scaleRatio != d1)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj.b = ((ImageBufferWrapper) (obj)).b + 1;
        imagetype = ((ViewEngine.ImageType) (obj));
        continue; /* Loop/switch isn't completed */
        imagetype;
        throw imagetype;
          goto _L5
_L4:
        imagetype = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void a()
    {
        i = true;
        g.interrupt();
    }

    public void a(ImageBufferWrapper imagebufferwrapper)
    {
        a(imagebufferwrapper, ((ViewEngine.Argd) (null)));
    }

    public void a(ImageBufferWrapper imagebufferwrapper, ViewEngine.Argd argd)
    {
        this;
        JVM INSTR monitorenter ;
        ViewEngine.Argd argd1;
        argd1 = argd;
        if (argd != null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        argd1 = new ViewEngine.Argd(null);
        argd = (Boolean)argd1.get("bCurrentImageID");
        if (argd == null) goto _L2; else goto _L1
_L1:
        if (!argd.booleanValue()) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L9:
        double d1;
        a((new StringBuilder()).append("[ViewEngineCacheMgr][push] push name:").append(imagebufferwrapper.e()).append(" isCurrentImage:").append(flag).toString());
        argd = imagebufferwrapper.f();
        d1 = imagebufferwrapper.h();
        if (!c.contains(argd)) goto _L5; else goto _L4
_L4:
        a((new StringBuilder()).append("[ViewEngineCacheMgr][push] Already in Memory Pools:").append(imagebufferwrapper.e()).toString());
_L7:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L5:
        if (e + d1 >= 350D && !a(d1))
        {
            a("[ViewEngineCacheMgr][push] Warning~!!! Buffer out of expected");
        }
        d(imagebufferwrapper);
        if (true) goto _L7; else goto _L6
_L6:
        imagebufferwrapper;
        throw imagebufferwrapper;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = b.keySet().iterator(); iterator.hasNext(); b((String)iterator.next())) { }
        break MISSING_BLOCK_LABEL_45;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void b(ImageBufferWrapper imagebufferwrapper)
    {
        b(imagebufferwrapper, null);
    }

    public void b(ImageBufferWrapper imagebufferwrapper, ViewEngine.Argd argd)
    {
        this;
        JVM INSTR monitorenter ;
        ViewEngine.Argd argd1;
        argd1 = argd;
        if (argd != null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        argd1 = new ViewEngine.Argd(null);
        argd = (Boolean)argd1.get("bCurrentImageID");
        if (argd == null) goto _L2; else goto _L1
_L1:
        if (!argd.booleanValue()) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L9:
        double d1;
        a((new StringBuilder()).append("[ViewEngineCacheMgr][pushThumb] push name:").append(imagebufferwrapper.e()).append(" isCurrentImage:").append(flag).toString());
        argd = imagebufferwrapper.f();
        d1 = imagebufferwrapper.h();
        if (!c.contains(argd)) goto _L5; else goto _L4
_L4:
        a((new StringBuilder()).append("[ViewEngineCacheMgr][pushThumb] Already in Memory Pools:").append(imagebufferwrapper.e()).toString());
_L7:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L5:
        b(imagebufferwrapper.imageID);
        if (e + d1 >= 350D && !a(d1))
        {
            a("[ViewEngineCacheMgr][pushThumb] Warning~!!! Buffer out of expected");
        }
        d(imagebufferwrapper);
        if (true) goto _L7; else goto _L6
_L6:
        imagebufferwrapper;
        throw imagebufferwrapper;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = b.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            ImageBufferWrapper imagebufferwrapper = (ImageBufferWrapper)b.get(s);
            if (imagebufferwrapper.imageID != -1L && !a.contains(Long.valueOf(imagebufferwrapper.imageID)) && imagebufferwrapper.d <= 1L)
            {
                a((new StringBuilder()).append("[ViewEngineCacheMgr][releaseBuffersNotBeingUsed] remove buffer: ").append(s).toString());
                b(s);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_121;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void d()
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator;
        a("============= MemoryPool =============");
        iterator = b.keySet().iterator();
_L1:
        Object obj;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_125;
            }
            obj = (String)iterator.next();
            obj = (ImageBufferWrapper)b.get(obj);
            if (!((ImageBufferWrapper) (obj)).g())
            {
                break MISSING_BLOCK_LABEL_95;
            }
            a((new StringBuilder()).append("MasterBuffer:").append(((ImageBufferWrapper) (obj)).e()).toString());
        } while (true);
        Exception exception;
        exception;
        throw exception;
        a((new StringBuilder()).append("RatioBuffer:").append(((ImageBufferWrapper) (obj)).e()).toString());
          goto _L1
        a("========================================");
        a((new StringBuilder()).append("Total Memory Size:").append(k.a(e, 2)).append(" MB").toString());
        this;
        JVM INSTR monitorexit ;
    }

}
