// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.photo.effect.Effect;
import com.socialin.android.util.ModernAsyncTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import myobfuscated.cd.a;
import myobfuscated.ci.b;

// Referenced classes of package myobfuscated.cl:
//            b, a, e

public final class d extends android.support.v7.widget.RecyclerView.Adapter
    implements myobfuscated.cl.b
{

    public ArrayList a;
    public Bitmap b;
    public e c;
    public HashMap d;
    public HashMap e;
    private com.socialin.android.photo.effects.factory.b f;
    private Context g;
    private a h;
    private a i;
    private ThreadPoolExecutor j;
    private String k;
    private String l;
    private Handler m;

    public d(Context context, com.socialin.android.photo.effects.factory.b b1)
    {
        a = new ArrayList();
        b = null;
        g = null;
        d = new HashMap();
        e = new HashMap();
        j = (ThreadPoolExecutor)Executors.newFixedThreadPool(1);
        k = "None";
        l = "None";
        m = new Handler();
        g = context;
        f = b1;
        h = new a(context.getResources(), BitmapFactory.decodeResource(context.getResources(), 0x7f020566));
        i = new a(context.getResources(), ((BitmapDrawable)context.getResources().getDrawable(0x7f0204a2)).getBitmap());
    }

    static Context a(d d1)
    {
        return d1.g;
    }

    private int b(String s)
    {
        for (int i1 = 0; i1 < a.size(); i1++)
        {
            if (((b)a.get(i1)).a.compareTo(s) == 0)
            {
                return i1;
            }
        }

        return -1;
    }

    static Bitmap b(d d1)
    {
        return d1.b;
    }

    static ArrayList c(d d1)
    {
        return d1.a;
    }

    static HashMap d(d d1)
    {
        return d1.d;
    }

    static HashMap e(d d1)
    {
        return d1.e;
    }

    static e f(d d1)
    {
        return d1.c;
    }

    public final void a()
    {
        if (l != null)
        {
            a(l);
        }
    }

    public final void a(int i1)
    {
        if (c != null && i1 >= 0 && i1 < a.size())
        {
            b b1 = (b)a.get(i1);
            a(b1.a);
            m.post(new Runnable(b1, i1) {

                private b a;
                private int b;
                private d c;

                public final void run()
                {
                    d.f(c).a(a, b);
                }

            
            {
                c = d.this;
                a = b1;
                b = i1;
                super();
            }
            });
        }
    }

    public final void a(String s)
    {
        l = k;
        k = s;
        int i1 = b(s);
        if (i1 >= 0 && i1 < a.size())
        {
            notifyItemChanged(i1);
        }
        i1 = b(l);
        if (i1 >= 0 && i1 < a.size())
        {
            notifyItemChanged(i1);
        }
    }

    public final int getItemCount()
    {
        return a.size();
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i1)
    {
        myobfuscated.cl.a a1 = (myobfuscated.cl.a)viewholder;
        b b1 = (b)a.get(i1);
        String s = b1.a;
        String s1 = com.socialin.android.photo.effects.factory.b.a(g, s);
        a1.c.setText(s1);
        a1.f = this;
        viewholder = f;
        String s2 = b1.a;
        if (((com.socialin.android.photo.effects.factory.b) (viewholder)).b.containsKey(s2))
        {
            viewholder = (Integer)((com.socialin.android.photo.effects.factory.b) (viewholder)).b.get(s2);
        } else
        {
            viewholder = null;
        }
        if (b1.b && viewholder == null)
        {
            viewholder = (Bitmap)d.get(s);
            boolean flag;
            if (viewholder != null && !viewholder.isRecycled())
            {
                a1.b.setImageBitmap(viewholder);
            } else
            {
                if (e.get(s) != null)
                {
                    flag = ((Boolean)e.get(s)).booleanValue();
                } else
                {
                    flag = false;
                }
                if (b != null && !flag)
                {
                    e.put(s, Boolean.valueOf(true));
                    (new ModernAsyncTask(b1, i1) {

                        private b a;
                        private int b;
                        private d c;

                        protected final Object doInBackground(Object aobj[])
                        {
                            aobj = a.a(myobfuscated.cl.d.a(c));
                            Log.e("ex1", (new StringBuilder("effect name = ")).append(((Effect) (aobj)).d).toString());
                            aobj = ((Effect) (aobj)).a(myobfuscated.cl.d.a(c), myobfuscated.cl.d.b(c));
                            if (aobj == null)
                            {
                                Log.e("ex1", "************************");
                                Log.e("ex1", "************************");
                                Log.e("ex1", "thumb destBitmap == null");
                                Log.e("ex1", "************************");
                                Log.e("ex1", "************************");
                            }
                            return ((Object) (aobj));
                        }

                        protected final void onPostExecute(Object obj)
                        {
                            obj = (Bitmap)obj;
                            if (d.c(c).contains(a))
                            {
                                if (obj != null)
                                {
                                    d.d(c).put(a.a, obj);
                                    c.notifyItemChanged(b);
                                }
                                d.e(c).put(a.a, Boolean.valueOf(false));
                            }
                        }

            
            {
                c = d.this;
                a = b1;
                b = i1;
                super();
            }
                    }).executeOnExecutor(j, new Void[] {
                        null
                    });
                }
                a1.b.setImageDrawable(h);
            }
        } else
        if (b1.a.compareTo("None") == 0)
        {
            if (b != null)
            {
                a1.b.setImageBitmap(b);
            } else
            {
                a1.b.setImageDrawable(h);
            }
        } else
        {
            a1.b.setImageResource(viewholder.intValue());
        }
        viewholder = f;
        if (((com.socialin.android.photo.effects.factory.b) (viewholder)).h.containsKey(s))
        {
            flag = ((Boolean)((com.socialin.android.photo.effects.factory.b) (viewholder)).h.get(s)).booleanValue();
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a1.d.setImageDrawable(i);
            a1.d.setVisibility(0);
        } else
        {
            a1.d.setVisibility(8);
        }
        if (s.compareTo(k) == 0)
        {
            a1.e.setVisibility(0);
            a1.c.setTextColor(g.getResources().getColor(0x7f0f0093));
        } else
        {
            a1.e.setVisibility(4);
            a1.c.setTextColor(-1);
        }
        if (c != null)
        {
            c.a(s, s1, a1.a, a1.b, a1.c);
        }
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i1)
    {
        return new myobfuscated.cl.a(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300c2, viewgroup, false));
    }
}
