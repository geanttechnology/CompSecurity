// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.editview.savemylook.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.CollageLayout;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.e;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.i;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.o;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.v;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.utility.bb;
import com.cyberlink.youcammakeup.widgetpool.common.CollageImageView;
import com.pf.common.utility.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.pages.editview.savemylook.a:
//            b

public class a extends PagerAdapter
{

    private Activity a;
    private CollageLayout b;
    private List c;
    private List d;
    private final ExecutorService e = Executors.newFixedThreadPool(1);
    private v f;
    private AtomicBoolean g;
    private AsyncTask h;
    private ag i;

    public a(Activity activity, CollageLayout collagelayout, List list)
    {
        g = new AtomicBoolean(false);
        a = activity;
        b = collagelayout;
        c = new ArrayList();
        d = new ArrayList();
        f = new v(a);
        f();
        int l = list.size();
        for (int j = 0; j < l; j++)
        {
            activity = new b(this);
            activity.a = (com.cyberlink.youcammakeup.widgetpool.collageBasicView.a)list.get(j);
            c.add(j, activity);
        }

    }

    static AsyncTask a(a a1, AsyncTask asynctask)
    {
        a1.h = asynctask;
        return asynctask;
    }

    static List a(a a1)
    {
        return a1.c;
    }

    static List a(a a1, List list)
    {
        a1.c = list;
        return list;
    }

    static CollageLayout b(a a1)
    {
        return a1.b;
    }

    static ExecutorService c(a a1)
    {
        return a1.e;
    }

    static StringBuilder d()
    {
        return e();
    }

    static List d(a a1)
    {
        return a1.d;
    }

    static Activity e(a a1)
    {
        return a1.a;
    }

    private static StringBuilder e()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(NetworkManager.b());
        stringbuilder.append(Globals.c);
        stringbuilder.append("CollagePageAdapter");
        return stringbuilder;
    }

    static AtomicBoolean f(a a1)
    {
        return a1.g;
    }

    private void f()
    {
        k k1 = new k(a, null);
        k1.g = false;
        k1.a(0.15F);
        i = new ag(a);
        i.a(false);
        i.a(a.getFragmentManager(), k1);
    }

    static v g(a a1)
    {
        return a1.f;
    }

    public Bitmap a(int j)
    {
        if (j < 0 || d.size() <= j)
        {
            return null;
        } else
        {
            return BitmapFactory.decodeFile(((b)d.get(j)).c);
        }
    }

    public void a()
    {
        if (c.size() == d.size())
        {
            notifyDataSetChanged();
            return;
        } else
        {
            g.set(false);
            (new AsyncTask(new Handler()) {

                final Handler a;
                final a b;

                protected transient Void a(Void avoid[])
                {
                    int l = a.a(b).size();
                    avoid = new ArrayList();
                    int j = 0;
                    while (j < l) 
                    {
                        b b1 = (b)a.a(b).get(j);
                        if (b1.c == null)
                        {
                            Object obj = b1.a;
                            obj = a.g(b).a(((com.cyberlink.youcammakeup.widgetpool.collageBasicView.a) (obj)).a, ((com.cyberlink.youcammakeup.widgetpool.collageBasicView.a) (obj)).b);
                            if (obj != null)
                            {
                                b1.b = ((o) (obj));
                                avoid.add(b1);
                            }
                        }
                        j++;
                    }
                    a.a(b, avoid);
                    return null;
                }

                protected void a(Void void1)
                {
                    if (a.a(b).size() > 0)
                    {
                        class a
                            implements Runnable
                        {

                            final Handler a;
                            final a b;
                            private int c;

                            private void a()
                            {
                                a.post(new Runnable(this) {

                                    final a a;

                                    public void run()
                                    {
                                        a.b(a);
                                        a.a(a.b, null);
                                        if (a.c(a) < a.a(a.b).size() && !a.f(a.b).get())
                                        {
                                            a.a.post(a);
                                        }
                                        if (a.c(a) >= a.a(a.b).size())
                                        {
                                            a.b(a.b).a();
                                        }
                                    }

            
            {
                a = a1;
                super();
            }
                                });
                            }

                            static void a(a a1)
                            {
                                a1.a();
                            }

                            static int b(a a1)
                            {
                                int j = a1.c;
                                a1.c = j + 1;
                                return j;
                            }

                            static int c(a a1)
                            {
                                return a1.c;
                            }

                            public void run()
                            {
                                if (c >= a.a(b).size())
                                {
                                    return;
                                }
                                b b1 = (b)a.a(b).get(c);
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
                                    o o = b1.b;
                                    a.b(b).setTemplate(o);
                                    a.b(b).e();
                                    a.a(b, (new AsyncTask(this, b1) {

                                        final b a;
                                        final a b;

                                        protected transient Void a(Void avoid[])
                                        {
                                            if (isCancelled())
                                            {
                                                return null;
                                            }
                                            float f2 = 1.0F;
                                            avoid = Globals.d().e();
                                            float f1 = f2;
                                            if (avoid != null)
                                            {
                                                f1 = f2;
                                                if (avoid.intValue() < 0xc3500)
                                                {
                                                    f1 = 0.66F;
                                                    avoid = a.b(b.b).getTemplate();
                                                    if (avoid != null)
                                                    {
                                                        f1 = 1024F / (float)((o) (avoid)).i;
                                                        float f3 = 1024F / (float)((o) (avoid)).j;
                                                        class a._cls1.a
                                                            implements i
                                                        {

                                                            final a._cls1 a;

                                                            public void a()
                                                            {
                                                                m.e("rendering", "onCancel");
                                                                a.a(a.b);
                                                            }

                                                            public void a(Bitmap bitmap)
                                                            {
                                                                (new AsyncTask(this, bitmap) {

                                                                    final Bitmap a;
                                                                    final a._cls1.a b;

                                                                    protected transient Void a(Void avoid[])
                                                                    {
                                                                        avoid = null;
                                                                        Object obj;
                                                                        String s;
                                                                        obj = a.d();
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
                                                                        a.d(b.a.b.b).add(b.a.a);
                                                                        b.a.b.b.notifyDataSetChanged();
                                                                        a.a(b.a.b);
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
                                                                }).executeOnExecutor(a.c(a.b.b), new Void[0]);
                                                            }

                                                            public void a(String s)
                                                            {
                                                                m.e("rendering", (new StringBuilder()).append("onError: ").append(s).toString());
                                                                a.a(a.b);
                                                            }

            a._cls1.a(a._cls1 _pcls1)
            {
                a = _pcls1;
                super();
            }
                                                        }

                                                        if (f1 >= f3)
                                                        {
                                                            f1 = f3;
                                                        }
                                                    }
                                                }
                                            }
                                            com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a().a(com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.e(b.b), a.b(b.b), f1, new a(this));
                                            return null;
                                        }

                                        protected Object doInBackground(Object aobj[])
                                        {
                                            return a((Void[])aobj);
                                        }

            
            {
                b = a1;
                a = b1;
                super();
            }
                                    }).executeOnExecutor(a.c(b), new Void[0]));
                                    return;
                                }
                            }

            a(Handler handler)
            {
                b = a.this;
                a = handler;
                super();
                c = 0;
            }
                        }

                        a.post(b. new a(a));
                        return;
                    } else
                    {
                        b.notifyDataSetChanged();
                        return;
                    }
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
                b = a.this;
                a = handler;
                super();
            }
            }).executeOnExecutor(e, new Void[0]);
            return;
        }
    }

    public void b()
    {
        g.set(true);
        AsyncTask asynctask = h;
        if (asynctask != null)
        {
            asynctask.cancel(true);
        }
    }

    public void c()
    {
        d.clear();
        int l = c.size();
        for (int j = 0; j < l; j++)
        {
            b b1 = (b)c.get(j);
            b1.a = null;
            b1.b = null;
            if (b1.d != null)
            {
                b1.d.recycle();
            }
        }

        c.clear();
        b.a();
        bb.b(new File(e().toString()));
    }

    public void destroyItem(ViewGroup viewgroup, int j, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public int getCount()
    {
        return d.size();
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }

    public Object instantiateItem(ViewGroup viewgroup, int j)
    {
        View view = View.inflate(a, 0x7f0300ef, null);
        Object obj = (b)d.get(j);
        CollageImageView collageimageview = (CollageImageView)view.findViewById(0x7f0c0548);
        if (((b) (obj)).c != null)
        {
            obj = ((b) (obj)).c;
            i.a(((String) (obj)), collageimageview);
        } else
        {
            collageimageview.setImageBitmap(((b) (obj)).d);
        }
        collageimageview.setPosition(j);
        collageimageview.setTag(Integer.valueOf(j));
        viewgroup.addView(view);
        return view;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }
}
