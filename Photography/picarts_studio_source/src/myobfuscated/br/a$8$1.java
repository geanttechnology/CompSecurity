// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.br;

import android.os.AsyncTask;
import android.os.Handler;
import com.socialin.android.brushlib.layer.CameraMaskLayer;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.state.LayerMetaInfo;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

// Referenced classes of package myobfuscated.br:
//            a, d

final class >
    implements Runnable
{

    final a a;
    private String b;
    private ByteBuffer c;

    public final void run()
    {
        RandomAccessFile randomaccessfile = new RandomAccessFile(new File(myobfuscated.br.a.a(a.a).c.k.getRootFolder(), b), "rw");
        c.rewind();
        myobfuscated.br.d.a(c, randomaccessfile);
        myobfuscated.br.a.b(a.a).post(new Runnable() {

            private a._cls8._cls1 a;

            public final void run()
            {
                myobfuscated.br.a.a(a.a.c).c.c(myobfuscated.br.a.a(a.a.a));
                if (a.a.b != null)
                {
                    a.a.b.run();
                }
            }

            
            {
                a = a._cls8._cls1.this;
                super();
            }
        });
_L1:
        return;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        d.b(myobfuscated.br.a.g(), new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(filenotfoundexception.getMessage()).toString()
        });
        if (a.a != null)
        {
            myobfuscated.br.a.b(a.a).post(a.a);
            return;
        }
          goto _L1
    }

    init>(init> init>, String s, ByteBuffer bytebuffer)
    {
        a = init>;
        b = s;
        c = bytebuffer;
        super();
    }

    // Unreferenced inner class myobfuscated/br/a$8

/* anonymous class */
    final class a._cls8 extends AsyncTask
    {

        final com.socialin.android.brushlib.layer.a a;
        final Runnable b;
        final myobfuscated.br.a c;
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
            myobfuscated.br.a.h().execute(new a._cls8._cls1(this, s, ((ByteBuffer) (obj))));
            return;
_L2:
            if (Collections.unmodifiableList(myobfuscated.br.a.a(c).c.a).indexOf(a) != -1)
            {
                ((LayerMetaInfo)e.layerInfoList.get(Collections.unmodifiableList(myobfuscated.br.a.a(c).c.a).indexOf(a))).currentBufferKey = s;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

            
            {
                c = a1;
                a = a2;
                b = runnable;
                e = snapshot;
                super();
            }
    }

}
