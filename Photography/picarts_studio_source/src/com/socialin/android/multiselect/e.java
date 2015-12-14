// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.l;
import com.socialin.android.dialog.g;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.socialin.android.multiselect:
//            f

public final class e extends Fragment
{

    public int a;
    private LinearLayout b;
    private HorizontalScrollView c;
    private ArrayList d;
    private LayoutInflater e;
    private int f;
    private String g;
    private HashMap h;
    private g i;
    private j j;
    private j k;
    private com.bumptech.glide.request.e l;

    public e()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = -1;
        g = "";
        h = new HashMap();
        a = -1;
        i = null;
    }

    static String a(String s)
    {
        return b(s);
    }

    private ArrayList a()
    {
        ArrayList arraylist = new ArrayList();
        int j1 = d.size();
        int i1 = 0;
_L2:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!"".equals(((f)d.get(i1)).b))
        {
            arraylist.add(((f)d.get(i1)).b);
        }
        i1++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
_L1:
        return arraylist;
    }

    static void a(e e1)
    {
        if (e1.getActivity() != null && !e1.getActivity().isFinishing())
        {
            e1.getActivity().setRequestedOrientation(e1.getActivity().getResources().getConfiguration().orientation);
            File file = Environment.getExternalStorageDirectory();
            if (file.exists() && file.canWrite())
            {
                ArrayList arraylist = e1.a();
                com.socialin.android.net.e e2 = new com.socialin.android.net.e(e1.getActivity());
                com.socialin.android.net.b b1 = e1. new com.socialin.android.net.b(arraylist) {

                    private ArrayList a;
                    private e b;

                    public final void a(Intent intent)
                    {
                        if (intent.getAction().equals("intent.action.download.complete"))
                        {
                            intent = intent.getStringArrayExtra("downloaded_file_paths");
                            e.a(b, intent, a);
                        }
                    }

            
            {
                b = e.this;
                a = arraylist;
                super();
            }
                };
                if (!e1.g.endsWith("/"))
                {
                    e1.g = (new StringBuilder()).append(e1.g).append("/").toString();
                }
                if (arraylist.size() > 0)
                {
                    if (e1.a == 10)
                    {
                        (e1. new AsyncTask(arraylist, e2, b1) {

                            private ArrayList a;
                            private com.socialin.android.net.e b;
                            private com.socialin.android.net.b c;
                            private e d;

                            protected final Object doInBackground(Object aobj[])
                            {
                                int j1 = a.size();
                                for (int i1 = 0; i1 < j1; i1++)
                                {
                                    aobj = (String)a.remove(i1);
                                    a.add(i1, e.a(((String) (aobj))));
                                }

                                return null;
                            }

                            protected final void onPostExecute(Object obj)
                            {
                                if (e.e(d) != null && e.e(d).isShowing())
                                {
                                    e.e(d).dismiss();
                                }
                                b.a(a, e.f(d), c);
                            }

                            protected final void onPreExecute()
                            {
                                super.onPreExecute();
                                if (e.e(d) != null && !e.e(d).isShowing())
                                {
                                    e.e(d).show();
                                }
                            }

            
            {
                d = e.this;
                a = arraylist;
                b = e2;
                c = b1;
                super();
            }
                        }).execute(new Void[0]);
                    } else
                    {
                        e2.a(arraylist, e1.g, b1);
                    }
                }
                arraylist = e1.b();
                if (arraylist.size() > 0)
                {
                    e2.a(arraylist, e1.g, b1);
                    return;
                }
            }
        }
    }

    static void a(e e1, String as[], ArrayList arraylist)
    {
        Intent intent = new Intent();
        for (int i1 = 0; i1 < as.length; i1++)
        {
            (new StringBuilder("multiselect img    ")).append(i1).append(" = ").append(as[i1]);
        }

        intent.putExtra("selectedItems", as);
        intent.putExtra("selectedItemsCount", as.length);
        intent.putStringArrayListExtra("extra.orig.urls", arraylist);
        e1.getActivity().setResult(-1, intent);
        e1.getActivity().finish();
    }

    private void a(f f1)
    {
        if (d.size() >= f && f != -1)
        {
            Utils.a(getActivity(), 0x7f080442);
        } else
        {
            View view = getView();
            if (view != null)
            {
                if (view.getVisibility() != 0)
                {
                    view.setVisibility(0);
                }
                View view1 = e.inflate(0x7f03016f, null);
                ImageView imageview = (ImageView)view1.findViewById(0x7f10072b);
                if (f1.a.toLowerCase().startsWith("http"))
                {
                    k.a(f1.a).a(imageview);
                } else
                {
                    String s = f1.c;
                    if (h.containsKey(s) && h.get(s) != null)
                    {
                        imageview.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(100, 100));
                        imageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                        imageview.setImageBitmap((Bitmap)h.get(s));
                    }
                    (new AsyncTask(s, imageview) {

                        private String a;
                        private ImageView b;
                        private e c;

                        protected final Object doInBackground(Object aobj[])
                        {
                            aobj = com.socialin.android.util.c.a(a);
                            com.socialin.android.multiselect.e.g(c).put(a, ((Object) (aobj)));
                            return ((Object) (aobj));
                        }

                        protected final void onPostExecute(Object obj)
                        {
                            obj = (Bitmap)obj;
                            super.onPostExecute(obj);
                            b.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(100, 100));
                            b.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                            b.setImageBitmap(((Bitmap) (obj)));
                        }

            
            {
                c = e.this;
                a = s;
                b = imageview;
                super();
            }
                    }).execute(new Integer[] {
                        Integer.valueOf(0)
                    });
                }
                view1.setOnClickListener(new android.view.View.OnClickListener(f1, view) {

                    private f a;
                    private View b;
                    private e c;

                    public final void onClick(View view2)
                    {
                        if (com.socialin.android.multiselect.e.g(c).containsKey(a.c))
                        {
                            if (com.socialin.android.multiselect.e.g(c).get(a.c) != null)
                            {
                                ((Bitmap)com.socialin.android.multiselect.e.g(c).get(a.c)).recycle();
                            }
                            com.socialin.android.multiselect.e.g(c).remove(a.c);
                        }
                        com.socialin.android.multiselect.e.c(c).removeView(view2);
                        com.socialin.android.multiselect.e.b(c).remove(a);
                        ((TextView)b.findViewById(0x7f10072e)).setText((new StringBuilder()).append(com.socialin.android.multiselect.e.b(c).size()).toString());
                        if (com.socialin.android.multiselect.e.b(c).size() == 0)
                        {
                            b.setVisibility(8);
                        }
                    }

            
            {
                c = e.this;
                a = f1;
                b = view;
                super();
            }
                });
                b.addView(view1);
                d.add(f1);
                ((TextView)getView().findViewById(0x7f10072e)).setText((new StringBuilder()).append(d.size()).toString());
                (new Handler()).postDelayed(new Runnable() {

                    private e a;

                    public final void run()
                    {
                        e.h(a).fullScroll(66);
                    }

            
            {
                a = e.this;
                super();
            }
                }, 100L);
                return;
            }
        }
    }

    private static String b(String s)
    {
        if (!s.startsWith("user:"))
        {
            return s;
        }
        String s2 = s.replace("user:", "");
        String s1 = "";
        try
        {
            s = new URL(s2);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = null;
        }
        try
        {
            s = s.openConnection();
            s.getInputStream().close();
            s = s.getURL().toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = s1;
        }
        if (s.equals(s2))
        {
            return s;
        } else
        {
            s = s2.substring(s2.lastIndexOf("."));
            return s2.replace(s2.substring(s2.lastIndexOf("_")), s);
        }
    }

    private ArrayList b()
    {
        ArrayList arraylist = new ArrayList();
        int j1 = d.size();
        int i1 = 0;
_L2:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        d.get(i1);
        i1++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
_L1:
        return arraylist;
    }

    static ArrayList b(e e1)
    {
        return e1.d;
    }

    static LinearLayout c(e e1)
    {
        return e1.b;
    }

    private void c()
    {
        if (h.size() > 0)
        {
            Iterator iterator = h.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if (h.get(s) != null)
                {
                    com.socialin.android.util.c.a((Bitmap)h.get(s));
                }
            } while (true);
            h.clear();
        }
    }

    static void d(e e1)
    {
        e1.c();
    }

    static g e(e e1)
    {
        return e1.i;
    }

    static String f(e e1)
    {
        return e1.g;
    }

    static HashMap g(e e1)
    {
        return e1.h;
    }

    static HorizontalScrollView h(e e1)
    {
        return e1.c;
    }

    public final void a(String s, String s1, String s2)
    {
        a(new f(s1, s, s2));
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setRetainInstance(true);
        if (getActivity().getIntent().hasExtra("multipleCheckPhotoCount"))
        {
            f = getActivity().getIntent().getIntExtra("multipleCheckPhotoCount", -1);
            if (f != -1)
            {
                ((TextView)getView().findViewById(0x7f10072f)).setText((new StringBuilder("/ ")).append(f).toString());
            }
        }
        if (d == null)
        {
            d = new ArrayList();
        }
        if (d.size() > 0)
        {
            bundle = d;
            d = new ArrayList();
            for (Iterator iterator = bundle.iterator(); iterator.hasNext(); a((f)iterator.next())) { }
            bundle.clear();
            return;
        } else
        {
            getView().setVisibility(8);
            return;
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        g = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808c0)).toString();
        i = new g(getActivity());
        i.setMessage(getResources().getString(0x7f08043d));
        i.setCancelable(false);
        l = (com.bumptech.glide.request.e)com.bumptech.glide.request.e.c(getActivity().getApplicationContext()).a(l.e);
        j = com.bumptech.glide.b.b(getActivity().getApplicationContext()).i().a(0.1F).a(l);
        bundle = com.bumptech.glide.b.b(getActivity().getApplicationContext()).i();
        bundle.b = j;
        k = bundle.a(l.a(100, 100));
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(0x7f030170, null);
        e = layoutinflater;
        b = (LinearLayout)viewgroup.findViewById(0x7f100733);
        c = (HorizontalScrollView)viewgroup.findViewById(0x7f100732);
        viewgroup.findViewById(0x7f100731).setOnClickListener(new android.view.View.OnClickListener() {

            private e a;

            public final void onClick(View view)
            {
                e.a(a);
            }

            
            {
                a = e.this;
                super();
            }
        });
        viewgroup.findViewById(0x7f100730).setOnClickListener(new android.view.View.OnClickListener() {

            private e a;

            public final void onClick(View view)
            {
                com.socialin.android.multiselect.e.b(a).clear();
                com.socialin.android.multiselect.e.c(a).removeAllViews();
                a.getView().setVisibility(8);
                e.d(a);
            }

            
            {
                a = e.this;
                super();
            }
        });
        return viewgroup;
    }

    public final void onDestroy()
    {
        super.onDestroy();
        c();
    }
}
