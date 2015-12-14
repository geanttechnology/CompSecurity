// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.editview.savemylook.a;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.CollageLayout;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.e;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.i;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.o;
import com.pf.common.utility.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.pages.editview.savemylook.a:
//            a, b

class a extends AsyncTask
{

    final b a;
    final a b;

    protected transient Void a(Void avoid[])
    {
        if (isCancelled())
        {
            return null;
        }
        float f1 = 1.0F;
        avoid = Globals.d().e();
        float f = f1;
        if (avoid != null)
        {
            f = f1;
            if (avoid.intValue() < 0xc3500)
            {
                f = 0.66F;
                avoid = com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.b(b.b).getTemplate();
                if (avoid != null)
                {
                    f = 1024F / (float)((o) (avoid)).i;
                    float f2 = 1024F / (float)((o) (avoid)).j;
                    class a
                        implements i
                    {

                        final a.a._cls1 a;

                        public void a()
                        {
                            m.e("rendering", "onCancel");
                            com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.a.a(a.b);
                        }

                        public void a(Bitmap bitmap)
                        {
                            (new AsyncTask(this, bitmap) {

                                final Bitmap a;
                                final a b;

                                protected transient Void a(Void avoid[])
                                {
                                    avoid = null;
                                    Object obj;
                                    String s;
                                    obj = com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.d();
                                    ((StringBuilder) (obj)).append(Globals.c);
                                    ((StringBuilder) (obj)).append((new StringBuilder()).append(b.a.a.b.a.toString()).append(".jpg").toString());
                                    s = ((StringBuilder) (obj)).toString();
                                    obj = new File(s);
                                    ((File) (obj)).getParentFile().mkdirs();
                                    ((File) (obj)).createNewFile();
                                    obj = new FileOutputStream(((File) (obj)));
                                    avoid = ((Void []) (obj));
                                    a.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((java.io.OutputStream) (obj)));
                                    avoid = ((Void []) (obj));
                                    b.a.a.c = s;
                                    if (obj != null)
                                    {
                                        try
                                        {
                                            ((FileOutputStream) (obj)).close();
                                        }
                                        // Misplaced declaration of an exception variable
                                        catch (Void avoid[])
                                        {
                                            m.e("CollagePagerAdapter", (new StringBuilder()).append("ExportBitmapCallback close output stream exception: ").append(avoid.getMessage()).toString());
                                        }
                                    }
                                    if (b.a.a.d == null)
                                    {
                                        a.recycle();
                                    }
_L2:
                                    return null;
                                    Object obj1;
                                    obj1;
                                    obj = null;
_L5:
                                    avoid = ((Void []) (obj));
                                    m.b("CollagePagerAdapter", "ExportBitmapCallback", ((Throwable) (obj1)));
                                    avoid = ((Void []) (obj));
                                    b.a.a.d = a;
                                    if (obj != null)
                                    {
                                        try
                                        {
                                            ((FileOutputStream) (obj)).close();
                                        }
                                        // Misplaced declaration of an exception variable
                                        catch (Void avoid[])
                                        {
                                            m.e("CollagePagerAdapter", (new StringBuilder()).append("ExportBitmapCallback close output stream exception: ").append(avoid.getMessage()).toString());
                                        }
                                    }
                                    if (b.a.a.d != null) goto _L2; else goto _L1
_L1:
                                    a.recycle();
                                    return null;
                                    obj1;
                                    obj = avoid;
                                    avoid = ((Void []) (obj1));
_L4:
                                    if (obj != null)
                                    {
                                        try
                                        {
                                            ((FileOutputStream) (obj)).close();
                                        }
                                        // Misplaced declaration of an exception variable
                                        catch (Object obj)
                                        {
                                            m.e("CollagePagerAdapter", (new StringBuilder()).append("ExportBitmapCallback close output stream exception: ").append(((IOException) (obj)).getMessage()).toString());
                                        }
                                    }
                                    if (b.a.a.d == null)
                                    {
                                        a.recycle();
                                    }
                                    throw avoid;
                                    obj1;
                                    obj = avoid;
                                    avoid = ((Void []) (obj1));
                                    if (true) goto _L4; else goto _L3
_L3:
                                    obj1;
                                      goto _L5
                                }

                                protected void a(Void void1)
                                {
                                    com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.d(b.a.b.b).add(b.a.a);
                                    b.a.b.b.notifyDataSetChanged();
                                    com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.a.a(b.a.b);
                                }

                                protected Object doInBackground(Object aobj[])
                                {
                                    return a((Void[])aobj);
                                }

                                protected void onPostExecute(Object obj)
                                {
                                    a((Void)obj);
                                }

            
            {
                b = a1;
                a = bitmap;
                super();
            }
                            }).executeOnExecutor(com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.c(a.b.b), new Void[0]);
                        }

                        public void a(String s)
                        {
                            m.e("rendering", (new StringBuilder()).append("onError: ").append(s).toString());
                            com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.a.a(a.b);
                        }

            a()
            {
                a = a.a._cls1.this;
                super();
            }
                    }

                    if (f >= f2)
                    {
                        f = f2;
                    }
                }
            }
        }
        e.a().a(com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.e(b.b), com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.b(b.b), f, new a());
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    a(a a1, b b1)
    {
        b = a1;
        a = b1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/editview/savemylook/a/a$a
    class a.a
        implements Runnable
    {

        final Handler a;
        final a b;
        private int c;

        private void a()
        {
            a.post(new a.a._cls2());
        }

        static void a(a.a a1)
        {
            a1.a();
        }

        static int b(a.a a1)
        {
            int i = a1.c;
            a1.c = i + 1;
            return i;
        }

        static int c(a.a a1)
        {
            return a1.c;
        }

        public void run()
        {
            if (c >= com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.a(b).size())
            {
                return;
            }
            b b1 = (b)com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.a(b).get(c);
            String s;
            if (b1.c != null)
            {
                s = b1.c;
            } else
            {
                s = "";
            }
            if ((new File(s)).exists())
            {
                b.notifyDataSetChanged();
                a();
                return;
            } else
            {
                o o1 = b1.b;
                com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.b(b).setTemplate(o1);
                com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.b(b).e();
                com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.a(b, (new a.a._cls1(this, b1)).executeOnExecutor(com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.c(b), new Void[0]));
                return;
            }
        }

            a.a(a a1, Handler handler)
            {
                b = a1;
                a = handler;
                super();
                c = 0;
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/pages/editview/savemylook/a/a$a$2

/* anonymous class */
        class a.a._cls2
            implements Runnable
        {

            final a.a a;

            public void run()
            {
                a.a.b(a);
                com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.a(a.b, null);
                if (a.a.c(a) < com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.a(a.b).size() && !com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.f(a.b).get())
                {
                    a.a.post(a);
                }
                if (a.a.c(a) >= com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.a(a.b).size())
                {
                    com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.b(a.b).a();
                }
            }

                    
                    {
                        a = a.a.this;
                        super();
                    }
        }

    }

}
