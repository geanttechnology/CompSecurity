// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.br;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.socialin.android.brushlib.layer.CameraMaskLayer;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.project.c;
import com.socialin.android.brushlib.state.LayerMetaInfo;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.util.k;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.d;
import com.socialin.android.photo.exception.InvalidIndexFileException;
import com.socialin.android.util.FileUtils;
import com.socialin.android.videogenerator.ActionCollector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package myobfuscated.br:
//            e, d, b, c

public class a
{

    public static final String a = myobfuscated/br/a.getSimpleName();
    private static ExecutorService h = Executors.newCachedThreadPool();
    public e b;
    public DrawingView c;
    public myobfuscated.br.d d;
    public AsyncTask e;
    public final Set f;
    private Handler g;
    private AtomicInteger i;
    private final Set j;

    public a(DrawingView drawingview)
    {
        b = new e(20);
        g = new Handler(Looper.getMainLooper());
        i = new AtomicInteger(0);
        j = new HashSet();
        f = new HashSet();
        c = drawingview;
        d = new myobfuscated.br.d(this);
    }

    public a(DrawingView drawingview, e e1)
    {
        b = new e(20);
        g = new Handler(Looper.getMainLooper());
        i = new AtomicInteger(0);
        j = new HashSet();
        f = new HashSet();
        c = drawingview;
        d = new myobfuscated.br.d(this);
        b = e1;
    }

    static b a(com.socialin.android.brushlib.layer.a a1)
    {
        if (a1 instanceof CameraMaskLayer)
        {
            return ((CameraMaskLayer)a1).d;
        } else
        {
            return (b)a1;
        }
    }

    static DrawingView a(a a1)
    {
        return a1.c;
    }

    public static ExecutorService a()
    {
        return h;
    }

    public static void a(Project project)
    {
        File file = project.getIndexFile();
        Object obj = FileUtils.e(file);
        if (((List) (obj)).size() != 2)
        {
            throw new InvalidIndexFileException("Index file must contain 2 lines");
        }
        obj = (String)((List) (obj)).get(0);
        Snapshot snapshot = (Snapshot)k.a(new File(project.getRootFolder(), ((String) (obj))));
        if (snapshot == null)
        {
            return;
        } else
        {
            (new AsyncTask(snapshot, project, file, (new StringBuilder()).append(((String) (obj))).append(System.getProperty("line.separator")).append(((String) (obj))).toString(), ((String) (obj))) {

                final Snapshot a;
                final String b;
                private Project c;
                private File d;
                private String e;

                protected final Object doInBackground(Object aobj[])
                {
                    aobj = new Snapshot(a.key, null, a.layerInfoList, null, a.creationDate, a.selectedLayerIndex);
                    k.a(new File(c.getRootFolder(), ((Snapshot) (aobj)).key), ((java.io.Serializable) (aobj)));
                    FileUtils.b(d, e);
                    com.socialin.android.brushlib.project.a.a(c, new c(this) {

                        private _cls3 a;

                        public final boolean a(String s)
                        {
                            if (s.equals((new StringBuilder()).append(a.a.key).append(".thumb").toString()))
                            {
                                return true;
                            }
                            if (s.equals("INDEX"))
                            {
                                return true;
                            }
                            if (s.equals("brush-data"))
                            {
                                return true;
                            }
                            if (s.equals("editingdat.aaf"))
                            {
                                return true;
                            }
                            if (s.equals(a.b))
                            {
                                return true;
                            }
                            if (s.equals("orig-buffers"))
                            {
                                return true;
                            }
                            for (Iterator iterator = a.a.layerInfoList.iterator(); iterator.hasNext();)
                            {
                                LayerMetaInfo layermetainfo = (LayerMetaInfo)iterator.next();
                                if (s.equals(layermetainfo.key))
                                {
                                    return true;
                                }
                                if (s.equals(layermetainfo.currentBufferKey))
                                {
                                    return true;
                                }
                                if (s.equals(layermetainfo.origBufferKey))
                                {
                                    return true;
                                }
                            }

                            ActionCollector.a();
                            return ActionCollector.a(s);
                        }

            
            {
                a = _pcls3;
                super();
            }
                    });
                    return null;
                }

            
            {
                a = snapshot;
                c = project;
                d = file;
                e = s;
                b = s1;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
    }

    static Handler b(a a1)
    {
        return a1.g;
    }

    static void c(a a1)
    {
        a1.i();
    }

    static void d(a a1)
    {
        for (Iterator iterator = a1.j.iterator(); iterator.hasNext(); ((myobfuscated.br.b)iterator.next()).a(a1)) { }
    }

    static e e(a a1)
    {
        return a1.b;
    }

    static myobfuscated.br.d f(a a1)
    {
        return a1.d;
    }

    static String g()
    {
        return a;
    }

    static ExecutorService h()
    {
        return h;
    }

    private void i()
    {
        if (i.decrementAndGet() <= 0)
        {
            g.post(new Runnable() {

                private a a;

                public final void run()
                {
                    for (Iterator iterator = a.f.iterator(); iterator.hasNext(); ((myobfuscated.br.c)iterator.next()).b()) { }
                }

            
            {
                a = a.this;
                super();
            }
            });
        }
    }

    public final void a(com.socialin.android.brushlib.layer.a a1, Runnable runnable)
    {
        c();
        Object obj1 = UUID.randomUUID().toString();
        a1.a(((String) (obj1)));
        a1.b(((String) (obj1)));
        if (!(a1 instanceof b) || !((b)a1).d)
        {
            Object obj;
            if (a1 instanceof CameraMaskLayer)
            {
                obj = c.c.k.getRootFolder();
            } else
            {
                obj = c.c.k.getLayerOrigBuffersFolder();
            }
            obj = new File(((File) (obj)), ((String) (obj1)));
            obj1 = new Runnable(a1, runnable) {

                private com.socialin.android.brushlib.layer.a a;
                private Runnable b;
                private a c;

                public final void run()
                {
                    a.a(c).c.c(a.a(a));
                    if (b != null)
                    {
                        myobfuscated.br.a.b(c).post(b);
                    }
                    myobfuscated.br.a.c(c);
                }

            
            {
                c = a.this;
                a = a2;
                b = runnable;
                super();
            }
            };
            runnable = myobfuscated.br.d.a(a1.a());
            a1.a(runnable);
            runnable.rewind();
            try
            {
                a1 = new RandomAccessFile(((File) (obj)), "rw");
                obj = new d._cls1(((Runnable) (obj1)));
                h.execute(new d._cls2(runnable, a1, ((Runnable) (obj))));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (com.socialin.android.brushlib.layer.a a1)
            {
                com.socialin.android.d.b(d.a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(a1.getMessage()).toString()
                });
            }
            return;
        }
        if (runnable != null)
        {
            g.post(runnable);
        }
        i();
    }

    public final void a(Snapshot snapshot)
    {
        b.a(snapshot);
        g.post(new Runnable() {

            private a a;

            public final void run()
            {
                myobfuscated.br.a.d(a);
            }

            
            {
                a = a.this;
                super();
            }
        });
        List list = Collections.unmodifiableList(b.a);
        (new AsyncTask(snapshot, (new StringBuilder()).append(((Snapshot)b.c()).key).append(System.getProperty("line.separator")).append(((Snapshot)list.get(list.size() - 1)).key).toString()) {

            private Snapshot a;
            private String b;
            private a c;

            protected final Object doInBackground(Object aobj[])
            {
                k.a(new File(a.a(c).c.k.getRootFolder(), a.key), a);
                FileUtils.b(a.a(c).c.k.getIndexFile(), b);
                com.socialin.android.brushlib.project.a.a(a.a(c).c.k, new com.socialin.android.brushlib.project.b(a.e(c)));
                return null;
            }

            
            {
                c = a.this;
                a = snapshot;
                b = s;
                super();
            }
        }).execute(new Void[0]);
    }

    public final void a(Snapshot snapshot, Snapshot snapshot1)
    {
        c();
        Object obj = Collections.unmodifiableList(b.a);
        (new AsyncTask((new StringBuilder()).append(((Snapshot)b.c()).key).append(System.getProperty("line.separator")).append(((Snapshot)((List) (obj)).get(((List) (obj)).size() - 1)).key).toString()) {

            private String a;
            private a b;

            protected final Object doInBackground(Object aobj[])
            {
                FileUtils.b(a.a(b).c.k.getIndexFile(), a);
                return null;
            }

            
            {
                b = a.this;
                a = s;
                super();
            }
        }).execute(new Void[0]);
        obj = new ArrayList(c.c.a);
        ConcurrentHashMap concurrenthashmap = new ConcurrentHashMap();
        b b2;
        for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext(); concurrenthashmap.put(b2.c, b2))
        {
            b2 = (b)iterator.next();
        }

        b b1 = c.c.b;
        ((List) (obj)).clear();
        (new AsyncTask(snapshot, concurrenthashmap, ((List) (obj)), snapshot1, b1) {

            private Snapshot a;
            private ConcurrentMap b;
            private List c;
            private Snapshot d;
            private b e;
            private a f;

            private transient Void a()
            {
                for (Iterator iterator1 = a.layerInfoList.iterator(); iterator1.hasNext();)
                {
                    LayerMetaInfo layermetainfo = (LayerMetaInfo)iterator1.next();
                    if (b.containsKey(layermetainfo.key))
                    {
                        b b3 = (b)b.get(layermetainfo.key);
                        c.add(b3);
                        if (!b3.k.equals(layermetainfo.currentBufferKey))
                        {
                            if (layermetainfo.currentBufferKey.equals(layermetainfo.origBufferKey))
                            {
                                myobfuscated.br.d.a(b3, new File(a.a(f).c.k.getLayerOrigBuffersFolder(), layermetainfo.currentBufferKey));
                            } else
                            {
                                myobfuscated.br.d.a(b3, new File(a.a(f).c.k.getRootFolder(), layermetainfo.currentBufferKey));
                            }
                            b3.k = layermetainfo.currentBufferKey;
                        }
                        b3.k = layermetainfo.currentBufferKey;
                        b3.a(layermetainfo.opacity);
                        b3.a(layermetainfo.getBlendMode());
                        b3.f = layermetainfo.isVisible;
                    } else
                    {
                        b b4 = com.socialin.android.brushlib.layer.b.a(a.a(f).c.d, a.a(f).c.e);
                        b4.c = layermetainfo.key;
                        b.put(b4.c, b4);
                        if (layermetainfo.currentBufferKey.equals(layermetainfo.origBufferKey))
                        {
                            myobfuscated.br.d.a(b4, new File(a.a(f).c.k.getLayerOrigBuffersFolder(), layermetainfo.currentBufferKey));
                        } else
                        {
                            myobfuscated.br.d.a(b4, new File(a.a(f).c.k.getRootFolder(), layermetainfo.currentBufferKey));
                        }
                        b4.k = layermetainfo.currentBufferKey;
                        b4.a(layermetainfo.opacity);
                        b4.a(layermetainfo.getBlendMode());
                        b4.l = layermetainfo.origBufferKey;
                        b4.f = layermetainfo.isVisible;
                        c.add(b4);
                    }
                }

                CameraMaskLayer cameramasklayer = a.a(f).c.j;
                if (a.a(f).c.j != null && a.cameraLayerInfo != null)
                {
                    if (!cameramasklayer.d().equals(a.cameraLayerInfo.currentBufferKey))
                    {
                        if (a.cameraLayerInfo.origBufferKey.equals(a.cameraLayerInfo.origBufferKey))
                        {
                            myobfuscated.br.d.a(cameramasklayer, new File(a.a(f).c.k.getLayerOrigBuffersFolder(), a.cameraLayerInfo.currentBufferKey));
                        } else
                        {
                            myobfuscated.br.d.a(cameramasklayer, new File(a.a(f).c.k.getRootFolder(), a.cameraLayerInfo.currentBufferKey));
                        }
                        cameramasklayer.b(a.cameraLayerInfo.currentBufferKey);
                    }
                } else
                if (cameramasklayer != null && a.cameraLayerInfo == null)
                {
                    cameramasklayer.b(cameramasklayer.e());
                    if (cameramasklayer.e().equals(cameramasklayer.d()))
                    {
                        a.f(f).a(cameramasklayer, new File(a.a(f).c.k.getLayerOrigBuffersFolder(), cameramasklayer.d()), null);
                    } else
                    {
                        a.f(f).a(cameramasklayer, new File(a.a(f).c.k.getRootFolder(), cameramasklayer.d()), null);
                    }
                    a.a(f).c.c(a.a(cameramasklayer));
                    return null;
                }
                return null;
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            protected final void onPostExecute(Object obj1)
            {
                super.onPostExecute((Void)obj1);
                a.a(f).c.a.clear();
                a.a(f).c.a.addAll(c);
                if (d == null) goto _L2; else goto _L1
_L1:
                Iterator iterator1;
                int l;
                int i1;
                boolean flag;
                iterator1 = a.layerInfoList.iterator();
                l = 0;
                i1 = 0;
                flag = false;
_L7:
                if (!iterator1.hasNext()) goto _L4; else goto _L3
_L3:
                LayerMetaInfo layermetainfo;
                Object obj2;
                layermetainfo = (LayerMetaInfo)iterator1.next();
                obj2 = d.layerInfoList.iterator();
_L8:
                if (!((Iterator) (obj2)).hasNext())
                {
                    break MISSING_BLOCK_LABEL_611;
                }
                obj1 = (LayerMetaInfo)((Iterator) (obj2)).next();
                if (!((LayerMetaInfo) (obj1)).key.equals(layermetainfo.key)) goto _L6; else goto _L5
_L5:
                if (!flag && l != i1)
                {
                    flag = true;
                }
_L16:
                if (obj1 != null)
                {
                    obj2 = (com.socialin.android.brushlib.layer.a)b.get(layermetainfo.key);
                    if (!((LayerMetaInfo) (obj1)).currentBufferKey.equals(layermetainfo.currentBufferKey))
                    {
                        a.a(f).c.c(a.a(((com.socialin.android.brushlib.layer.a) (obj2))));
                    }
                    if (((LayerMetaInfo) (obj1)).opacity != layermetainfo.opacity)
                    {
                        a.a(f).c.d(a.a(((com.socialin.android.brushlib.layer.a) (obj2))));
                    }
                    if (((LayerMetaInfo) (obj1)).getBlendMode() != layermetainfo.getBlendMode())
                    {
                        a.a(f).c.d(a.a(((com.socialin.android.brushlib.layer.a) (obj2))));
                    }
                    if (((LayerMetaInfo) (obj1)).isVisible != layermetainfo.isVisible)
                    {
                        a.a(f).c.d(a.a(((com.socialin.android.brushlib.layer.a) (obj2))));
                    }
                } else
                {
                    a.a(f).c.f((b)b.get(layermetainfo.key));
                }
                i1++;
                  goto _L7
_L6:
                l++;
                  goto _L8
_L4:
                iterator1 = d.layerInfoList.iterator();
_L15:
                if (!iterator1.hasNext()) goto _L10; else goto _L9
_L9:
                layermetainfo = (LayerMetaInfo)iterator1.next();
                obj2 = a.layerInfoList.iterator();
_L14:
                if (!((Iterator) (obj2)).hasNext()) goto _L12; else goto _L11
_L11:
                obj1 = (LayerMetaInfo)((Iterator) (obj2)).next();
                if (!((LayerMetaInfo) (obj1)).key.equals(layermetainfo.key)) goto _L14; else goto _L13
_L13:
                if (obj1 == null)
                {
                    a.a(f).c.e((b)b.get(layermetainfo.key));
                }
                  goto _L15
_L10:
                if (d.cameraLayerInfo != null && a.cameraLayerInfo == null)
                {
                    a.a(f).c.h();
                }
                myobfuscated.br.a.d(f);
                if (!c.contains(e))
                {
                    obj1 = (b)c.get(c.size() - 1);
                    a.a(f).c.a(((b) (obj1)));
                    a.a(f).c.g(((b) (obj1)));
                }
                if (flag)
                {
                    a.a(f).c.g();
                }
                myobfuscated.br.a.c(f);
_L2:
                return;
_L12:
                obj1 = null;
                  goto _L13
                obj1 = null;
                  goto _L16
            }

            
            {
                f = a.this;
                a = snapshot;
                b = concurrentmap;
                c = list;
                d = snapshot1;
                e = b1;
                super();
            }
        }).execute(new Void[0]);
    }

    public final void a(myobfuscated.br.b b1)
    {
        j.add(b1);
    }

    public final void b(com.socialin.android.brushlib.layer.a a1, Runnable runnable)
    {
        if (a1 == null || Collections.unmodifiableList(c.c.a).indexOf(a1) == -1)
        {
            return;
        }
        if (e != null && e.getStatus() != android.os.AsyncTask.Status.FINISHED)
        {
            e.cancel(true);
        }
        e = new AsyncTask(a1, runnable, c.c.a(((Snapshot)b.c()).key)) {

            final com.socialin.android.brushlib.layer.a a;
            final Runnable b;
            final a c;
            private ByteBuffer d;
            private Snapshot e;

            protected final Object doInBackground(Object aobj[])
            {
                d = myobfuscated.br.d.a(a.a());
                if (isCancelled())
                {
                    return null;
                } else
                {
                    a.a(d);
                    return d;
                }
            }

            protected final void onCancelled()
            {
                super.onCancelled();
                if (d != null)
                {
                    myobfuscated.br.d.a(d);
                }
                if (b != null)
                {
                    b.run();
                }
            }

            protected final void onPostExecute(Object obj)
            {
                String s;
                obj = (ByteBuffer)obj;
                super.onPostExecute(obj);
                s = UUID.randomUUID().toString();
                a.b(s);
                if (!(a instanceof CameraMaskLayer)) goto _L2; else goto _L1
_L1:
                e.cameraLayerInfo.currentBufferKey = s;
_L4:
                c.a(e);
                a.h().execute(new Runnable(this, s, ((ByteBuffer) (obj))) {

                    final _cls8 a;
                    private String b;
                    private ByteBuffer c;

                    public final void run()
                    {
                        RandomAccessFile randomaccessfile = new RandomAccessFile(new File(a.a(a.c).c.k.getRootFolder(), b), "rw");
                        c.rewind();
                        myobfuscated.br.d.a(c, randomaccessfile);
                        myobfuscated.br.a.b(a.c).post(new Runnable(this) {

                            private _cls1 a;

                            public final void run()
                            {
                                a.a(a.a.c).c.c(a.a(a.a.a));
                                if (a.a.b != null)
                                {
                                    a.a.b.run();
                                }
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
_L1:
                        return;
                        FileNotFoundException filenotfoundexception;
                        filenotfoundexception;
                        com.socialin.android.d.b(a.g(), new Object[] {
                            (new StringBuilder("Got unexpected exception: ")).append(filenotfoundexception.getMessage()).toString()
                        });
                        if (a.b != null)
                        {
                            myobfuscated.br.a.b(a.c).post(a.b);
                            return;
                        }
                          goto _L1
                    }

            
            {
                a = _pcls8;
                b = s;
                c = bytebuffer;
                super();
            }
                });
                return;
_L2:
                if (Collections.unmodifiableList(a.a(c).c.a).indexOf(a) != -1)
                {
                    ((LayerMetaInfo)e.layerInfoList.get(Collections.unmodifiableList(a.a(c).c.a).indexOf(a))).currentBufferKey = s;
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                c = a.this;
                a = a2;
                b = runnable;
                e = snapshot;
                super();
            }
        };
        e.execute(new Void[0]);
    }

    public final void b(Snapshot snapshot)
    {
        c();
        List list = c.c.a;
        ConcurrentHashMap concurrenthashmap = new ConcurrentHashMap();
        b b1;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); concurrenthashmap.put(b1.c, b1))
        {
            b1 = (b)iterator.next();
        }

        list.clear();
        do
        {
            for (snapshot = snapshot.layerInfoList.iterator(); snapshot.hasNext();)
            {
                LayerMetaInfo layermetainfo = (LayerMetaInfo)snapshot.next();
                if (concurrenthashmap.containsKey(layermetainfo.key))
                {
                    b b2 = (b)concurrenthashmap.get(layermetainfo.key);
                    list.add(b2);
                    if (!b2.k.equals(layermetainfo.currentBufferKey))
                    {
                        if (layermetainfo.currentBufferKey.equals(layermetainfo.origBufferKey))
                        {
                            myobfuscated.br.d.a(b2, new File(c.c.k.getLayerOrigBuffersFolder(), layermetainfo.currentBufferKey));
                        } else
                        {
                            myobfuscated.br.d.a(b2, new File(c.c.k.getRootFolder(), layermetainfo.currentBufferKey));
                        }
                        b2.k = layermetainfo.currentBufferKey;
                    }
                    b2.k = layermetainfo.currentBufferKey;
                    b2.a(layermetainfo.opacity);
                    b2.a(layermetainfo.getBlendMode());
                    b2.f = layermetainfo.isVisible;
                } else
                {
                    b b3 = com.socialin.android.brushlib.layer.b.a(c.c.d, c.c.e);
                    b3.c = layermetainfo.key;
                    concurrenthashmap.put(b3.c, b3);
                    if (layermetainfo.currentBufferKey.equals(layermetainfo.origBufferKey))
                    {
                        myobfuscated.br.d.a(b3, new File(c.c.k.getLayerOrigBuffersFolder(), layermetainfo.currentBufferKey));
                    } else
                    {
                        myobfuscated.br.d.a(b3, new File(c.c.k.getRootFolder(), layermetainfo.currentBufferKey));
                    }
                    b3.l = layermetainfo.origBufferKey;
                    b3.k = layermetainfo.currentBufferKey;
                    b3.a(layermetainfo.opacity);
                    b3.a(layermetainfo.getBlendMode());
                    b3.f = layermetainfo.isVisible;
                    list.add(b3);
                }
            }

            c.c.a((b)list.get(0));
            i();
            return;
        } while (true);
    }

    public final boolean b()
    {
        return i.get() != 0;
    }

    public final boolean c()
    {
        if (i.incrementAndGet() > 0)
        {
            g.post(new Runnable() {

                private a a;

                public final void run()
                {
                    for (Iterator iterator = a.f.iterator(); iterator.hasNext(); ((myobfuscated.br.c)iterator.next()).a()) { }
                }

            
            {
                a = a.this;
                super();
            }
            });
        }
        return true;
    }

    public final Snapshot d()
    {
        return (Snapshot)b.c();
    }

    public final boolean e()
    {
        return b.b + 1 > 1;
    }

    public final boolean f()
    {
        e e1 = b;
        return e1.a.size() - e1.b - 1 > 0;
    }


    // Unreferenced inner class myobfuscated/br/a$2

/* anonymous class */
    public final class _cls2
        implements Runnable
    {

        private com.socialin.android.brushlib.layer.a a;
        private Runnable b;
        private a c;

        public final void run()
        {
            a.a(c).c.c(a.a(a));
            c.a(a.a(c).c.a(((Snapshot)a.e(c).c()).key));
            myobfuscated.br.a.c(c);
            if (b != null)
            {
                myobfuscated.br.a.b(c).post(b);
            }
        }

            public 
            {
                c = a.this;
                a = a2;
                b = runnable;
                super();
            }
    }

}
