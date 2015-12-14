// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.session.Session;
import com.socialin.android.activity.FragmentActionsListener;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.dropbox.DropBoxSessionManager;
import com.socialin.android.dropbox.a;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import myobfuscated.f.m;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package myobfuscated.bt:
//            a, g, f, e

public class c extends Fragment
{

    private static final String k = myobfuscated/bt/c.getSimpleName();
    private static final String l[] = {
        ".jpg", ".jpeg", ".png", ".gif", ".JPG", ".JPEG", ".PNG", ".GIF"
    };
    String a;
    public String b;
    String c;
    String d;
    String e;
    String f;
    g g;
    public SharedPreferences h;
    e i;
    k j;
    private DropBoxSessionManager m;
    private myobfuscated.bt.a n;
    private ListView o;
    private Button p;
    private boolean q;
    private j r;

    public c()
    {
        a = "dropboxMethodGet";
        b = "";
        c = "";
        d = "";
        e = "";
        f = null;
        n = null;
        o = null;
        p = null;
        q = false;
        r = null;
        j = null;
    }

    static SharedPreferences a(c c1)
    {
        return c1.h;
    }

    private static List a(List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
label0:
        do
        {
            if (list.hasNext())
            {
                a a1 = (a)list.next();
                int i1 = 0;
                do
                {
                    if (i1 >= 8)
                    {
                        continue label0;
                    }
                    if (a1.a.endsWith(l[i1]) || a1.c)
                    {
                        arraylist.add(a1);
                        continue label0;
                    }
                    i1++;
                } while (true);
            }
            return arraylist;
        } while (true);
    }

    static void a(c c1, Integer integer, String s, String s1)
    {
        if (integer.intValue() != -1)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        FileUtils.c(s);
        ((FragmentActionsListener)c1.getActivity()).onFragmentFinishWithResultError(0);
_L1:
        return;
        c1;
        com.socialin.android.d.a("Error while deleting file from sd", c1);
        return;
        if (integer.intValue() == -2)
        {
            Utils.a(c1.getActivity(), 0x7f080342);
            return;
        }
        if (integer.intValue() == 1)
        {
            s = new File(s);
            integer = new JSONArray();
            String s2;
            try
            {
                integer.put(0, s.getPath());
                integer.put(1, s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                com.socialin.android.d.a(k, s1);
            }
            c1 = (FragmentActionsListener)c1.getActivity();
            s1 = s.getPath();
            s2 = s.getPath();
            s = s.getPath();
            c1.onFragmentImageSelected(s1, false, new String[] {
                s2
            }, new String[] {
                s
            }, 0, integer);
            return;
        }
          goto _L1
    }

    static void a(c c1, String s, List list)
    {
        c1.c = s;
        String s1 = s;
        if (s.endsWith(File.separator))
        {
            s1 = s.substring(0, s.length() - 1);
        }
        if (TextUtils.isEmpty(s1))
        {
            s = "";
        } else
        {
            s = s1.substring(0, s1.lastIndexOf("/") + 1);
        }
        c1.b = s;
        com.socialin.android.d.b(k, new Object[] {
            (new StringBuilder("current path = ")).append(c1.c).toString()
        });
        com.socialin.android.d.b(k, new Object[] {
            (new StringBuilder("parent path = ")).append(c1.b).toString()
        });
        s = a(list);
        if (s.isEmpty() && "dropboxMethodGet".equals(c1.a))
        {
            c1 = Toast.makeText(c1.getActivity(), c1.getString(0x7f080445), 0);
            c1.setGravity(17, 0, 0);
            c1.show();
            return;
        }
        Collections.sort(s, new Comparator() {

            public final volatile int compare(Object obj, Object obj1)
            {
                obj = (a)obj;
                obj1 = (a)obj1;
                if (((a) (obj)).c && !((a) (obj1)).c)
                {
                    return -1;
                }
                return ((a) (obj)).c || !((a) (obj1)).c ? 0 : 1;
            }

        });
        c1.n = new myobfuscated.bt.a(c1, c1.getActivity(), s);
        c1.n.a = Boolean.valueOf(c1.getActivity().getIntent().getBooleanExtra("multipleCheckMode", false)).booleanValue();
        if ("dropboxMethodGet".equals(c1.a))
        {
            ((android.widget.RelativeLayout.LayoutParams)c1.o.getLayoutParams()).bottomMargin = 0;
        }
        c1.o.setAdapter(c1.n);
    }

    static boolean b(c c1)
    {
        return c1.b();
    }

    static g c(c c1)
    {
        return c1.g;
    }

    static String c()
    {
        return k;
    }

    private void d()
    {
        if (!b())
        {
            myobfuscated.f.m.a(getActivity(), g);
            Object obj = f;
            myobfuscated.bt.g g1 = new myobfuscated.bt.g(this, (byte)0);
            obj = new Request((new StringBuilder("https://api.dropbox.com/1/account/info?access_token=")).append(((String) (obj))).toString(), null, "GET");
            ((Request) (obj)).c();
            com.socialin.asyncnet.b.a().a(((Request) (obj)), g1);
        }
    }

    final String a(a a1)
    {
        return (new StringBuilder()).append(myobfuscated.f.m.e(a1.b)).append("?access_token=").append(f).toString();
    }

    public final void a()
    {
        m = DropBoxSessionManager.getInstance(getActivity());
        m.startDropBoxNewSession();
    }

    public final void a(String s)
    {
        f f1;
        String s2;
        o.setAdapter(null);
        myobfuscated.f.m.a(getActivity(), g);
        s2 = f;
        f1 = new f(this, s);
        if (!s.startsWith(File.separator))
        {
            break MISSING_BLOCK_LABEL_143;
        }
_L1:
        String s1 = s;
        try
        {
            if (!s.endsWith(File.separator))
            {
                s1 = (new StringBuilder()).append(s).append(File.separator).toString();
            }
            s = new Request((new StringBuilder("https://api.dropbox.com/1/metadata/dropbox")).append(myobfuscated.f.m.e(s1)).append("?access_token=").append(s2).append("&list=true").toString(), new com.socialin.android.dropbox.b(), "GET");
            com.socialin.asyncnet.b.a().a(s, f1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.a("getDropboxMetadata", s);
        }
        break MISSING_BLOCK_LABEL_176;
        s = (new StringBuilder()).append(File.separator).append(s).toString();
          goto _L1
    }

    final boolean b()
    {
        Activity activity = getActivity();
        return activity == null || activity.isFinishing();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (!b())
        {
            bundle = getActivity().getIntent();
            if (bundle != null)
            {
                if (bundle.hasExtra("dropboxMethod"))
                {
                    a = bundle.getStringExtra("dropboxMethod");
                    com.socialin.android.d.b(k, new Object[] {
                        (new StringBuilder("onCreate() - method: ")).append(a).toString()
                    });
                    if ("dropboxMethodGet".equals(a))
                    {
                        d = bundle.getStringExtra("dropboxCacheDir");
                        com.socialin.android.d.b(k, new Object[] {
                            (new StringBuilder("onCreate() - dropboxCacheDir: ")).append(d).toString()
                        });
                        if (TextUtils.isEmpty(d))
                        {
                            throw new IllegalStateException();
                        }
                    }
                } else
                {
                    throw new IllegalStateException();
                }
                if ("dropboxMethodPost".equals(a))
                {
                    e = bundle.getStringExtra("path");
                    com.socialin.android.d.b(k, new Object[] {
                        (new StringBuilder("onCreate() - path: ")).append(e).toString()
                    });
                    if (TextUtils.isEmpty(e))
                    {
                        throw new IllegalStateException();
                    }
                }
            }
            g = new g(getActivity());
            g.setMessage(getString(0x7f08043d));
            g.setCancelable(true);
            h = getActivity().getSharedPreferences("DropboxPrefs", 0);
            if (com.socialin.android.oauth2.a.b(h))
            {
                f = h.getString("oauth2AccessToken", null);
                d();
            } else
            {
                com.socialin.android.d.b(k, new Object[] {
                    "user not logged in : startDropBoxNewSession()."
                });
                a();
            }
            i = (e)com.bumptech.glide.request.e.c(getActivity().getApplicationContext()).a(l.e);
            r = com.bumptech.glide.b.b(getActivity().getApplicationContext()).i().a(0.1F).a(i);
            j = com.bumptech.glide.b.b(getActivity().getApplicationContext());
            bundle = j.i();
            bundle.b = r;
            bundle.a(i);
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 != 2342) goto _L2; else goto _L1
_L1:
        j1;
        JVM INSTR tableswitch -1 1: default 40
    //                   -1 41
    //                   0 63
    //                   1 77;
           goto _L2 _L3 _L4 _L5
_L2:
        return;
_L3:
        f = h.getString("oauth2AccessToken", null);
        d();
        return;
_L4:
        Utils.c(getActivity(), getString(0x7f080428));
_L5:
        getActivity().finish();
        return;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (n != null)
        {
            n.notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300b9, null);
        o = (ListView)layoutinflater.findViewById(0x7f1003e7);
        p = (Button)layoutinflater.findViewById(0x7f1003e8);
        viewgroup = p;
        int i1;
        if ("dropboxMethodPost".equals(a))
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        viewgroup.setVisibility(i1);
        p.setOnClickListener(new android.view.View.OnClickListener() {

            private c a;

            public final void onClick(View view)
            {
                view = a;
                if (!view.b())
                {
                    ((c) (view)).g.setMessage(view.getString(0x7f080656));
                    myobfuscated.f.m.a(view.getActivity(), ((c) (view)).g);
                    myobfuscated.f.m.a(((c) (view)).e, ((c) (view)).c, ((c) (view)).f, new myobfuscated.bt.e(view, (byte)0));
                }
            }

            
            {
                a = c.this;
                super();
            }
        });
        ((FragmentActionsListener)getActivity()).onFragmentLoaded();
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        if (m != null && m.handleAuthCallback())
        {
            if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
            {
                com.socialin.android.util.b.a(SocialinV3.getInstance().getContext()).a("Connected Dropbox", true);
            }
            f = ((Session) ((com.dropbox.client2.android.a)m.getApi().a)).b;
            d();
        } else
        if (q)
        {
            getActivity().finish();
            return;
        }
    }

    public void onStop()
    {
        super.onStop();
        q = true;
    }

}
