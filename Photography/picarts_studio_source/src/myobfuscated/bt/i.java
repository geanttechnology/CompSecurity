// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.request.e;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.dropbox.a;
import com.socialin.android.net.b;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.bt:
//            j, c

public final class i extends Fragment
{

    LinearLayout a;
    List b;
    public myobfuscated.bt.c c;
    private HorizontalScrollView d;
    private LayoutInflater e;
    private int f;
    private Map g;
    private com.socialin.android.net.e h;
    private b i;
    private g j;

    public i()
    {
        a = null;
        d = null;
        b = null;
        e = null;
        f = -1;
        g = new HashMap();
        h = null;
        i = null;
        j = null;
    }

    private List a(String s)
    {
        int i1 = b.size();
        ArrayList arraylist = new ArrayList();
        for (int l = 0; l < i1; l++)
        {
            a a1 = ((myobfuscated.bt.j)b.get(l)).b;
            arraylist.add((new StringBuilder("https://api-content.dropbox.com/1/files/dropbox")).append(m.e(a1.b)).append("?access_token=").append(s).toString());
        }

        return arraylist;
    }

    static void a(i l)
    {
        Activity activity;
label0:
        {
            File file = Environment.getExternalStorageDirectory();
            if (file.exists() && file.canWrite())
            {
                activity = l.getActivity();
                if (activity != null && !activity.isFinishing())
                {
                    break label0;
                }
            }
            return;
        }
        l.getActivity().runOnUiThread(l. new Runnable() {

            private i a;

            public final void run()
            {
                myobfuscated.bt.i.b(a).show();
            }

            
            {
                a = i.this;
                super();
            }
        });
        String s1 = l.getActivity().getSharedPreferences("DropboxPrefs", 0).getString("oauth2AccessToken", null);
        String s = "";
        Intent intent = l.getActivity().getIntent();
        if (intent.hasExtra("dropboxCacheDir"))
        {
            s = intent.getStringExtra("dropboxCacheDir");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalStateException();
        } else
        {
            activity.runOnUiThread(l. new Runnable(l.a(s1), s) {

                private List a;
                private String b;
                private i c;

                public final void run()
                {
                    if (myobfuscated.bt.i.b(c) != null)
                    {
                        myobfuscated.bt.i.b(c).dismiss();
                    }
                    if (myobfuscated.bt.i.c(c) != null)
                    {
                        myobfuscated.bt.i.c(c).a(a, b, myobfuscated.bt.i.d(c));
                    }
                }

            
            {
                c = i.this;
                a = list;
                b = s;
                super();
            }
            });
            return;
        }
    }

    static void a(i l, myobfuscated.bt.j j1, View view)
    {
        if (l.g.containsKey(j1.a))
        {
            if (l.g.get(j1.a) != null)
            {
                ((Bitmap)l.g.get(j1.a)).recycle();
            }
            l.g.remove(j1.a);
        }
        l.a.removeView(view);
        l.b.remove(j1);
        ((TextView)l.getView().findViewById(0x7f10072e)).setText((new StringBuilder()).append(l.b.size()).toString());
        if (!l.b.isEmpty())
        {
            l.getView().setVisibility(8);
        }
    }

    static void a(i l, String as[])
    {
        Intent intent = new Intent();
        if (d.b)
        {
            for (int i1 = 0; i1 < as.length; i1++)
            {
                (new StringBuilder("multi select img    ")).append(i1).append(" = ").append(as[i1]);
            }

        }
        intent.putExtra("selectedItems", as);
        intent.putExtra("selectedItemsCount", as.length);
        l.getActivity().setResult(-1, intent);
        l.getActivity().finish();
    }

    static g b(i l)
    {
        return l.j;
    }

    static com.socialin.android.net.e c(i l)
    {
        return l.h;
    }

    static b d(i l)
    {
        return l.i;
    }

    static HorizontalScrollView e(i l)
    {
        return l.d;
    }

    final void a()
    {
        if (!g.isEmpty())
        {
            Iterator iterator = g.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if (g.get(s) != null)
                {
                    com.socialin.android.util.c.a((Bitmap)g.get(s));
                }
            } while (true);
            g.clear();
        }
    }

    public final void a(myobfuscated.bt.j j1)
    {
        if (b.size() >= f && f != -1)
        {
            Utils.a(getActivity(), 0x7f080442);
        } else
        if (getView() != null)
        {
            getView().setVisibility(0);
            View view = e.inflate(0x7f03016f, null);
            view.findViewById(0x7f10072a).setVisibility(8);
            ImageView imageview = (ImageView)view.findViewById(0x7f10072b);
            if (c != null)
            {
                myobfuscated.bt.c c1 = c;
                Object obj = j1.b;
                obj = (new StringBuilder("https://api-content.dropbox.com/1/thumbnails/dropbox")).append(c1.a(((a) (obj)))).append("&size=128x128&format=jpeg").toString();
                c1.j.a(obj).a(c1.i.a(0x7f020566)).a(imageview);
            }
            view.setOnClickListener(new android.view.View.OnClickListener(j1) {

                private myobfuscated.bt.j a;
                private i b;

                public final void onClick(View view1)
                {
                    myobfuscated.bt.i.a(b, a, view1);
                }

            
            {
                b = i.this;
                a = j1;
                super();
            }
            });
            a.addView(view);
            b.add(j1);
            ((TextView)getView().findViewById(0x7f10072e)).setText((new StringBuilder()).append(b.size()).toString());
            (new Handler()).postDelayed(new Runnable() {

                private i a;

                public final void run()
                {
                    myobfuscated.bt.i.e(a).fullScroll(66);
                }

            
            {
                a = i.this;
                super();
            }
            }, 100L);
            return;
        }
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
        if (b == null)
        {
            b = new ArrayList();
        }
        if (!b.isEmpty())
        {
            bundle = b;
            b = new ArrayList();
            for (bundle = bundle.iterator(); bundle.hasNext(); a((myobfuscated.bt.j)bundle.next())) { }
        } else
        {
            getView().setVisibility(8);
        }
        j = new g(getActivity());
        j.setMessage(getResources().getString(0x7f080450));
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        h = new com.socialin.android.net.e(getActivity());
        i = new b() {

            private i a;

            public final void a(Intent intent)
            {
                if (intent.getAction().equals("intent.action.download.complete"))
                {
                    intent = intent.getStringArrayExtra("downloaded_file_paths");
                    myobfuscated.bt.i.a(a, intent);
                }
            }

            
            {
                a = i.this;
                super();
            }
        };
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(0x7f030170, null);
        e = layoutinflater;
        a = (LinearLayout)viewgroup.findViewById(0x7f100733);
        d = (HorizontalScrollView)viewgroup.findViewById(0x7f100732);
        viewgroup.findViewById(0x7f100731).setOnClickListener(new android.view.View.OnClickListener() {

            final i a;

            public final void onClick(View view)
            {
                (new AsyncTask(this) {

                    private _cls2 a;

                    protected final Object doInBackground(Object aobj[])
                    {
                        myobfuscated.bt.i.a(a.a);
                        return null;
                    }

            
            {
                a = _pcls2;
                super();
            }
                }).execute(new Integer[] {
                    Integer.valueOf(0)
                });
            }

            
            {
                a = i.this;
                super();
            }
        });
        viewgroup.findViewById(0x7f100730).setOnClickListener(new android.view.View.OnClickListener() {

            private i a;

            public final void onClick(View view)
            {
                view = a;
                if (view.getView() != null)
                {
                    ((i) (view)).b.clear();
                    ((i) (view)).a.removeAllViews();
                    view.getView().setVisibility(8);
                    view.a();
                }
            }

            
            {
                a = i.this;
                super();
            }
        });
        return viewgroup;
    }

    public final void onDestroy()
    {
        super.onDestroy();
        a();
    }
}
