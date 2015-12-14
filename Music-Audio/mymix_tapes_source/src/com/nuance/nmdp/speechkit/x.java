// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import ax;
import ay;
import ba;
import com.nuance.nmdp.speechkit.recognitionresult.b;
import com.nuance.nmdp.speechkit.util.dataupload.Data;
import com.nuance.nmdp.speechkit.util.dataupload.DataBlock;
import com.nuance.nmdp.speechkit.util.grammar.Grammar;
import g;
import h;
import java.util.Iterator;
import java.util.Vector;
import k;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            j, f, u, l, 
//            n, r, d, z, 
//            ab, Prompt, b, DataUploadCommand, 
//            GenericCommand, NluRecognizer, Recognizer, TextRecognizer, 
//            Vocalizer

final class x
{

    private static x a = null;
    private static Object b = new Object();
    private static Object o = new Object();
    private m c;
    private final String d;
    private final String e;
    private final int f;
    private boolean g;
    private Object h;
    private final ay i = new ay();
    private Prompt j;
    private Prompt k;
    private Prompt l;
    private Prompt m;
    private final k n;
    private com.nuance.nmdp.speechkit.b p;
    private DataBlock q;
    private boolean r;
    private int s;
    private int t;

    private x(Object obj, String s1, String s2, String s3, int i1, String s4, boolean flag, 
            byte abyte0[], SpeechKit.CmdSetType cmdsettype)
    {
        p = null;
        r = false;
        s = 0;
        t = 0;
        d = s2;
        e = s3;
        f = i1;
        g = true;
        c = null;
        h = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = new k(obj, s1, e, f, s4, flag, d, abyte0, cmdsettype);
        ax.a(new Runnable() {

            private x a;

            public final void run()
            {
                x.a(a, new m(x.a(a)));
            }

            
            {
                a = x.this;
                super();
            }
        });
    }

    static Prompt a(x x1, Prompt prompt)
    {
        x1.j = prompt;
        return prompt;
    }

    public static x a(Object obj, String s1, String s2, String s3, int i1, String s4, boolean flag, byte abyte0[], 
            SpeechKit.CmdSetType cmdsettype)
    {
        a(obj, "appContext");
        a(s2, "id");
        a(s3, "host");
        a(s1, "appVersion");
        a(abyte0, "applicationKey");
        if (i1 < 0 || i1 > 65535)
        {
            a(((RuntimeException) (new IllegalArgumentException("port must be between 0 and 65535"))));
        }
        a(obj, "type");
        Object obj1 = b;
        obj1;
        JVM INSTR monitorenter ;
        x x1;
        com.nuance.nmdp.speechkit.recognitionresult.b.a(null, "Initializing SpeechKit");
        if (a == null)
        {
            ax.a();
        }
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        x1 = a;
        boolean flag1;
        if (x1.d.equals(s2) && x1.e.equals(s3) && x1.f == i1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        com.nuance.nmdp.speechkit.recognitionresult.b.a(null, "Releasing old SpeechKit before creating new instance");
        a.p();
        a = null;
        if (a == null)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(null, "Creating fresh SpeechKit instance");
            a = new x(obj, s1, s2, s3, i1, s4, flag, abyte0, cmdsettype);
        }
        obj1;
        JVM INSTR monitorexit ;
        return a;
        obj;
        throw obj;
    }

    static k a(x x1)
    {
        return x1.n;
    }

    static m a(x x1, m m1)
    {
        x1.c = m1;
        return m1;
    }

    private void a(j j1)
    {
        if (j != null)
        {
            j1.setPrompt(0, j);
        }
        if (k != null)
        {
            j1.setPrompt(1, k);
        }
        if (l != null)
        {
            j1.setPrompt(2, l);
        }
        if (m != null)
        {
            j1.setPrompt(3, m);
        }
    }

    static final void a(Object obj, String s1)
    {
        if (obj == null)
        {
            a(((RuntimeException) (new IllegalArgumentException((new StringBuilder()).append(s1).append(" must not be null").toString()))));
        }
    }

    private static void a(RuntimeException runtimeexception)
    {
        com.nuance.nmdp.speechkit.recognitionresult.b.c(null, runtimeexception.getMessage());
        throw runtimeexception;
    }

    static final void a(String s1, String s2)
    {
        if (s1 == null || s1.length() == 0)
        {
            a(((RuntimeException) (new IllegalArgumentException((new StringBuilder()).append(s2).append(" must not be null or empty").toString()))));
        }
    }

    static Prompt b(x x1, Prompt prompt)
    {
        x1.k = prompt;
        return prompt;
    }

    static Object b()
    {
        return b;
    }

    static m b(x x1)
    {
        return x1.c;
    }

    static ay c(x x1)
    {
        return x1.i;
    }

    static Prompt c(x x1, Prompt prompt)
    {
        x1.l = prompt;
        return prompt;
    }

    static Prompt d(x x1, Prompt prompt)
    {
        x1.m = prompt;
        return prompt;
    }

    static DataBlock d(x x1)
    {
        return x1.q;
    }

    static com.nuance.nmdp.speechkit.b e(x x1)
    {
        return x1.p;
    }

    static int f(x x1)
    {
        return x1.s;
    }

    static final void f()
    {
        a(new IllegalStateException("SpeechKit instance is released"));
    }

    static int g(x x1)
    {
        return x1.t;
    }

    static boolean h(x x1)
    {
        x1.r = true;
        return true;
    }

    static Object o()
    {
        return o;
    }

    private void p()
    {
        g = false;
        ax.a(new Runnable() {

            private x a;

            public final void run()
            {
                com.nuance.nmdp.speechkit.x.b(a).a();
                int j1 = x.c(a).c();
                for (int i1 = 0; i1 < j1; i1++)
                {
                    ((Prompt)x.c(a).a()).a().c();
                }

            }

            
            {
                a = x.this;
                super();
            }
        });
    }

    public final DataUploadCommand a(DataBlock datablock, int i1, int j1, DataUploadCommand.Listener listener, Object obj)
    {
        a(datablock, "datablock");
        a(listener, "listener");
        Object obj1 = b;
        obj1;
        JVM INSTR monitorenter ;
        if (!g)
        {
            f();
        }
        listener = new f(this, listener, obj);
        p = listener;
        q = datablock;
        s = i1;
        t = j1;
        ax.a(new Runnable() {

            private x a;

            public final void run()
            {
                Object obj2 = x.o();
                obj2;
                JVM INSTR monitorenter ;
                com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary;
                com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence sequence;
                Vector vector;
                x.e(a).addParam("DATA_BLOCK", x.d(a).getDataBlockDictionary());
                dictionary = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary();
                sequence = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence();
                dictionary.put("num_data_blocks", 1);
                vector = x.d(a).getDataList();
                int k1 = 0;
_L2:
                if (k1 >= vector.size())
                {
                    break; /* Loop/switch isn't completed */
                }
                com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary1 = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary();
                dictionary1.put("id", ((Data)vector.elementAt(k1)).getId());
                dictionary1.put("type", ((Data)vector.elementAt(k1)).getTypeStr());
                dictionary1.put("current_checksum", Integer.toString(x.f(a)));
                dictionary1.put("new_checksum", Integer.toString(x.g(a)));
                dictionary1.put("algorithm_id", "MD5");
                sequence.add(dictionary1);
                k1++;
                if (true) goto _L2; else goto _L1
_L1:
                dictionary.put("checksums", sequence);
                x.e(a).addParam("UPLOAD_DONE", dictionary);
                x.h(a);
                x.o().notify();
                obj2;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                obj2;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = x.this;
                super();
            }
        });
        datablock = ((DataBlock) (o));
        datablock;
        JVM INSTR monitorenter ;
_L3:
        boolean flag = r;
        if (flag) goto _L2; else goto _L1
_L1:
        try
        {
            o.wait();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally { }
        if (true) goto _L3; else goto _L2
_L2:
        listener.b();
        datablock;
        JVM INSTR monitorexit ;
        obj1;
        JVM INSTR monitorexit ;
        return listener;
        datablock;
        JVM INSTR monitorexit ;
        throw listener;
        datablock;
        obj1;
        JVM INSTR monitorexit ;
        throw datablock;
    }

    public final GenericCommand a(GenericCommand.Listener listener, Object obj)
    {
        a(listener, "listener");
        synchronized (b)
        {
            if (!g)
            {
                f();
            }
            listener = new u(this, listener, obj);
        }
        return listener;
    }

    public final GenericCommand a(String s1, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary, String s2, GenericCommand.Listener listener, Object obj)
    {
        a(s1, "event");
        a(dictionary, "content");
        a(listener, "listener");
        synchronized (b)
        {
            if (!g)
            {
                f();
            }
            s2 = new l(this, s2, listener, obj);
            listener = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary();
            listener.put("event", s1);
            listener.put("content", dictionary);
            s2.addParam("LOG_CONTENT", listener);
        }
        return s2;
    }

    public final NluRecognizer a(String s1, int i1, String s2, String s3, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary, NluRecognizer.Listener listener, Object obj)
    {
        a(s1, "type");
        a(s2, "language");
        a(listener, "listener");
        a(dictionary, "requestParams");
        synchronized (b)
        {
            if (!g)
            {
                f();
            }
            s1 = new n(this, s1, i1, s2, s3, dictionary, listener, obj);
            a(((j) (s1)));
        }
        return s1;
    }

    public final Recognizer a(String s1, int i1, String s2, Recognizer.Listener listener, Object obj)
    {
        a(s1, "type");
        a(s2, "language");
        a(listener, "listener");
        synchronized (b)
        {
            if (!g)
            {
                f();
            }
            s1 = new r(this, s1, i1, s2, listener, obj);
            a(((j) (s1)));
        }
        return s1;
    }

    public final Recognizer a(String s1, int i1, String s2, Vector vector, Recognizer.Listener listener, Object obj)
    {
        a(s1, "type");
        a(s2, "language");
        a(listener, "listener");
        a(vector, "grammarList");
        Object obj1 = b;
        obj1;
        JVM INSTR monitorenter ;
        if (!g)
        {
            f();
        }
        com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence sequence = null;
        if (vector == null) goto _L2; else goto _L1
_L1:
        com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence sequence1;
        sequence1 = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence();
        vector = vector.iterator();
_L3:
        sequence = sequence1;
        if (!vector.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        sequence1.add(((Grammar)vector.next()).getGrammarDictionary());
        if (true) goto _L3; else goto _L2
        s1;
        throw s1;
_L2:
        s1 = new d(this, s1, i1, s2, sequence, listener, obj);
        a(((j) (s1)));
        obj1;
        JVM INSTR monitorexit ;
        return s1;
    }

    public final TextRecognizer a(String s1, String s2, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary, TextRecognizer.Listener listener, Object obj)
    {
        a(s1, "language");
        a(listener, "listener");
        a(dictionary, "requestParams");
        synchronized (b)
        {
            if (!g)
            {
                f();
            }
            s1 = new z(this, s1, s2, dictionary, listener, obj);
        }
        return s1;
    }

    public final Vocalizer a(String s1, Vocalizer.Listener listener, Object obj)
    {
        a(s1, "language");
        a(listener, "listener");
        synchronized (b)
        {
            if (!g)
            {
                f();
            }
            s1 = new ab(this, null, s1, listener, obj);
        }
        return s1;
    }

    final void a(Prompt prompt)
    {
        if (i.c(prompt))
        {
            i.b(prompt);
        }
        prompt.a().c();
        if (prompt == j)
        {
            j = null;
        }
        if (prompt == k)
        {
            k = null;
        }
        if (prompt == l)
        {
            l = null;
        }
        if (prompt == m)
        {
            m = null;
        }
    }

    public final void a(Prompt prompt, Prompt prompt1, Prompt prompt2, Prompt prompt3)
    {
        synchronized (b)
        {
            if (!g)
            {
                f();
            }
        }
        ax.a(new Runnable(prompt, prompt1, prompt2, prompt3) {

            private Prompt a;
            private Prompt b;
            private Prompt c;
            private Prompt d;
            private x e;

            public final void run()
            {
label0:
                {
                    x.a(e, null);
                    com.nuance.nmdp.speechkit.x.b(e, null);
                    x.c(e, null);
                    x.d(e, null);
                    if (a != null)
                    {
                        if (!a.a().b())
                        {
                            x.a(e, a);
                        } else
                        {
                            com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Recording start prompt is invalid");
                        }
                    }
                    if (b != null)
                    {
                        if (!b.a().b())
                        {
                            com.nuance.nmdp.speechkit.x.b(e, b);
                        } else
                        {
                            com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Recording stop prompt is invalid");
                        }
                    }
                    if (c != null)
                    {
                        if (!c.a().b())
                        {
                            x.c(e, c);
                        } else
                        {
                            com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Result prompt is invalid");
                        }
                    }
                    if (d != null)
                    {
                        if (d.a().b())
                        {
                            break label0;
                        }
                        x.d(e, d);
                    }
                    return;
                }
                com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Error prompt is invalid");
            }

            
            {
                e = x.this;
                a = prompt;
                b = prompt1;
                c = prompt2;
                d = prompt3;
                super();
            }
        });
    }

    public final void a(SpeechKit.CmdSetType cmdsettype)
    {
        n.a(cmdsettype);
    }

    final void a(Object obj)
    {
        h = obj;
    }

    final boolean a()
    {
        return g;
    }

    public final Vocalizer b(String s1, Vocalizer.Listener listener, Object obj)
    {
        a(s1, "voice");
        a(listener, "listener");
        synchronized (b)
        {
            if (!g)
            {
                f();
            }
            s1 = new ab(this, s1, null, listener, obj);
        }
        return s1;
    }

    public final void b(Prompt prompt)
    {
        synchronized (b)
        {
            i.a(prompt);
        }
    }

    public final void b(String s1, String s2)
    {
        synchronized (b)
        {
            if (!g)
            {
                f();
            }
            ax.a(new Runnable(s1, s2) {

                private String a;
                private String b;
                private x c;

                public final void run()
                {
                    com.nuance.nmdp.speechkit.x.b(c).a(a, b);
                }

            
            {
                c = x.this;
                a = s1;
                b = s2;
                super();
            }
            });
        }
    }

    final m c()
    {
        return c;
    }

    final Object d()
    {
        return h;
    }

    final void e()
    {
        synchronized (b)
        {
            if (!g)
            {
                f();
            }
        }
    }

    public final void g()
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        if (this != a)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Releasing SpeechKit instance");
        p();
        a = null;
        ax.a(new Runnable() {

            public final void run()
            {
                ax.b();
            }

        });
_L2:
        return;
        com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "SpeechKit instance already released");
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public final void h()
    {
        synchronized (b)
        {
            if (!g)
            {
                f();
            }
            ax.a(new Runnable() {

                private x a;

                public final void run()
                {
                    g g1 = com.nuance.nmdp.speechkit.x.b(a).a(new h() {

                        public final void a(g g1)
                        {
                        }

                        public final void a(g g1, int i1, String s1, String s2)
                        {
                        }

                    });
                    if (g1 != null)
                    {
                        g1.a();
                    }
                }

            
            {
                a = x.this;
                super();
            }
            });
        }
    }

    public final String i()
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        String s1;
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        s1 = c.c();
        return s1;
        obj;
        JVM INSTR monitorexit ;
        return null;
        Exception exception;
        exception;
        throw exception;
    }

    public final void j()
    {
        synchronized (b)
        {
            if (!g)
            {
                f();
            }
            ax.a(new Runnable() {

                private x a;

                public final void run()
                {
                    com.nuance.nmdp.speechkit.x.b(a).d();
                }

            
            {
                a = x.this;
                super();
            }
            });
        }
    }

    public final String k()
    {
        return n.v();
    }

    public final String l()
    {
        return n.w();
    }

    public final String m()
    {
        return n.x();
    }

    public final SpeechKit.CmdSetType n()
    {
        return n.A();
    }

}
