// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.a;
import com.cyberlink.youcammakeup.database.n;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.pages.librarypicker.LibraryViewFragment;
import com.cyberlink.youcammakeup.pages.librarypicker.PickedFragment;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;
import com.perfectcorp.utility.j;
import com.pf.common.utility.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage:
//            b, TouchViewPager, a

public class PhotoZoomFragment extends Fragment
{

    private View a;
    private TouchViewPager b;
    private com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.b c;
    private View d;
    private View e;
    private View f;
    private long g;
    private long h;
    private LibraryViewFragment i;
    private PickedFragment j;
    private int k;
    private long l[];
    private android.view.View.OnClickListener m;
    private android.view.View.OnClickListener n;
    private android.view.View.OnClickListener o;

    public PhotoZoomFragment()
    {
        g = -1L;
        h = -1L;
        k = -1;
        l = null;
        m = new android.view.View.OnClickListener() {

            final PhotoZoomFragment a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLivePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent.Operation.c));
                (new j(this) {

                    final _cls1 a;

                    protected Uri a(Void void1)
                    {
                        void1 = com.cyberlink.youcammakeup.c.f();
                        if (void1.d(a.a.a()) != null)
                        {
                            if ((void1 = new File(void1.b(a.a.a()).b())).exists())
                            {
                                return Uri.fromFile(void1);
                            }
                        }
                        return null;
                    }

                    protected volatile Object a(Object obj)
                    {
                        return a((Void)obj);
                    }

            
            {
                a = _pcls1;
                super();
            }
                }).d(null).a(new com.perfectcorp.utility.m(this) {

                    final _cls1 a;

                    protected void a(Uri uri)
                    {
                        if (uri != null)
                        {
                            Activity activity = a.a.getActivity();
                            if (activity != null)
                            {
                                Intent intent = new Intent("android.intent.action.SEND");
                                intent.setType("image/*");
                                intent.putExtra("android.intent.extra.STREAM", uri);
                                PackageManager packagemanager = a.a.getActivity().getPackageManager();
                                List list = packagemanager.queryIntentActivities(intent, 0);
                                ArrayList arraylist = new ArrayList();
                                int i1 = 0;
                                while (i1 < list.size()) 
                                {
                                    ResolveInfo resolveinfo = (ResolveInfo)list.get(i1);
                                    String s = resolveinfo.activityInfo.packageName;
                                    if (!s.contains("com.cyberlink.youcammakeup"))
                                    {
                                        Intent intent1 = new Intent();
                                        intent1.setComponent(new ComponentName(s, resolveinfo.activityInfo.name));
                                        intent1.setAction("android.intent.action.SEND");
                                        intent1.setType("image/*");
                                        intent1.putExtra("android.intent.extra.STREAM", uri);
                                        arraylist.add(new LabeledIntent(intent1, s, resolveinfo.loadLabel(packagemanager), resolveinfo.icon));
                                    }
                                    i1++;
                                }
                                if (arraylist.size() == 0)
                                {
                                    uri = intent;
                                } else
                                {
                                    uri = Intent.createChooser((Intent)arraylist.remove(0), null);
                                    uri.putExtra("android.intent.extra.INITIAL_INTENTS", (LabeledIntent[])arraylist.toArray(new LabeledIntent[arraylist.size()]));
                                }
                                uri.putExtra("LibraryPickerActivity_RESET_STATE", true);
                                activity.startActivity(uri);
                            }
                        }
                    }

                    protected void b(Object obj)
                    {
                        a((Uri)obj);
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            
            {
                a = PhotoZoomFragment.this;
                super();
            }
        };
        n = new android.view.View.OnClickListener() {

            final PhotoZoomFragment a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLivePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent.Operation.b));
                YMKSavingPageEvent.b(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Source.b.a());
                (new j(this) {

                    final _cls2 a;

                    protected Boolean a(Void void1)
                    {
                        void1 = com.cyberlink.youcammakeup.c.f();
                        if (void1.d(a.a.a()) == null)
                        {
                            return Boolean.valueOf(false);
                        }
                        if (!(new File(void1.b(a.a.a()).b())).exists())
                        {
                            return Boolean.valueOf(false);
                        } else
                        {
                            return Boolean.valueOf(true);
                        }
                    }

                    protected volatile Object a(Object obj)
                    {
                        return a((Void)obj);
                    }

            
            {
                a = _pcls2;
                super();
            }
                }).d(null).a(new com.perfectcorp.utility.m(this) {

                    final _cls2 a;

                    protected void a(Boolean boolean1)
                    {
                        if (boolean1.booleanValue())
                        {
                            boolean1 = a.a.getActivity();
                            if (boolean1 != null)
                            {
                                StatusManager.j().b(com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.PhotoZoomFragment.a(a.a));
                                StatusManager.j().a(a.a.a(), UUID.randomUUID());
                                Intent intent = (new Intent(a.a.getActivity(), com/cyberlink/youcammakeup/activity/EditViewActivity)).setFlags(0x4000000);
                                intent.putExtra("ShowZooView", true);
                                boolean1.startActivity(intent);
                                boolean1.finish();
                            }
                            return;
                        } else
                        {
                            boolean1 = a.a.getString(0x7f070060);
                            Toast.makeText(a.a.getActivity(), boolean1, 1).show();
                            return;
                        }
                    }

                    protected void b(Object obj)
                    {
                        a((Boolean)obj);
                    }

            
            {
                a = _pcls2;
                super();
            }
                });
            }

            
            {
                a = PhotoZoomFragment.this;
                super();
            }
        };
        o = new android.view.View.OnClickListener() {

            final PhotoZoomFragment a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLivePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent.Operation.d));
                view = a.getActivity();
                o o1 = Globals.d().i();
                o1.c(view);
                o1.d(view);
                o1.a(new w(this, o1, view) {

                    final o a;
                    final Activity b;
                    final _cls3 c;

                    public void a(boolean flag)
                    {
                        a.i(b);
                        com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.PhotoZoomFragment.b(c.a);
                    }

                    public void b(boolean flag)
                    {
                        a.i(b);
                    }

            
            {
                c = _pcls3;
                a = o1;
                b = activity;
                super();
            }
                });
            }

            
            {
                a = PhotoZoomFragment.this;
                super();
            }
        };
    }

    static long a(PhotoZoomFragment photozoomfragment)
    {
        return photozoomfragment.g;
    }

    private void a(String s)
    {
        ContentResolver contentresolver = Globals.d().getContentResolver();
        s = contentresolver.query(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] {
            "_id"
        }, "_data = ?", new String[] {
            s
        }, null);
        if (s.moveToFirst())
        {
            long l1 = s.getLong(s.getColumnIndexOrThrow("_id"));
            contentresolver.delete(ContentUris.withAppendedId(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, l1), null, null);
        } else
        {
            com.pf.common.utility.m.e("PhotoZoomFragment", "contentResolver.query is empty!");
        }
        s.close();
    }

    private void a(long al[], int i1)
    {
        c = new com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.b(getActivity(), al, b);
        if (b != null)
        {
            b.setAdapter(c);
            b.setCurrentItem(i1);
            b.setOnPageChangeListener(new com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.a());
            return;
        } else
        {
            k = i1;
            l = al;
            return;
        }
    }

    private void b()
    {
        b = (TouchViewPager)a.findViewById(0x7f0c05b8);
        d = a.findViewById(0x7f0c05bb);
        e = a.findViewById(0x7f0c05bc);
        f = a.findViewById(0x7f0c05ba);
        Fragment fragment = getActivity().getFragmentManager().findFragmentById(0x7f0c0158);
        if (fragment != null && (fragment instanceof LibraryViewFragment))
        {
            i = (LibraryViewFragment)fragment;
        }
        fragment = getActivity().getFragmentManager().findFragmentById(0x7f0c0157);
        if (fragment != null && (fragment instanceof PickedFragment))
        {
            j = (PickedFragment)fragment;
        }
        if (k != -1 && l != null)
        {
            a(l, k);
        }
    }

    static void b(PhotoZoomFragment photozoomfragment)
    {
        photozoomfragment.d();
    }

    private void c()
    {
        if (d != null)
        {
            d.setOnClickListener(o);
        }
        if (e != null)
        {
            e.setOnClickListener(n);
        }
        if (f != null)
        {
            f.setOnClickListener(m);
        }
    }

    private void d()
    {
        Globals.d().i().b(getActivity());
        Object obj;
        long l1;
        l1 = c.a();
        com.pf.common.utility.m.b("PhotoZoomFragment", (new StringBuilder()).append("delete image id = ").append(l1).toString());
        obj = com.cyberlink.youcammakeup.c.f().a(l1);
        if (obj == null)
        {
            Globals.d().i().h(getActivity());
            return;
        }
        if (j != null)
        {
            j.c(((Long) (obj)).longValue());
        }
        obj = com.cyberlink.youcammakeup.c.f().g(l1);
        if ((new File(((String) (obj)))).delete())
        {
            com.cyberlink.youcammakeup.c.f().h(l1);
            com.cyberlink.youcammakeup.c.e().b(((String) (obj)));
            a(((String) (obj)));
            e();
        }
        Globals.d().i().h(getActivity());
        return;
        Object obj1;
        obj1;
        com.pf.common.utility.m.e("PhotoZoomFragment", (new StringBuilder()).append("delete exception = ").append(((Exception) (obj1)).toString()).toString());
        Globals.d().i().h(getActivity());
        return;
        obj1;
        Globals.d().i().h(getActivity());
        throw obj1;
    }

    private void e()
    {
        int i1 = b.getChildCount();
        int j1 = b.getCurrentItem();
        if (i1 <= 1)
        {
            if (i != null)
            {
                i.b();
            }
            return;
        }
        c.a(b, j1);
        i1 = j1;
        if (j1 == b.getChildCount())
        {
            i1 = j1 - 1;
        }
        if (i1 == 0)
        {
            b.setCurrentItem(1);
            return;
        } else
        {
            b.setCurrentItem(i1);
            return;
        }
    }

    public long a()
    {
        if (c != null)
        {
            return c.a();
        } else
        {
            return h;
        }
    }

    public void a(long l1, long l2)
    {
        g = l1;
        h = l2;
        if (h != -1L && g != -1L)
        {
            long al[] = com.cyberlink.youcammakeup.c.c().c(g);
            int i1 = 0;
            while (i1 < al.length) 
            {
                if (al[i1] == h)
                {
                    a(al, i1);
                    return;
                }
                i1++;
            }
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKLivePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent.Operation.f));
        super.onActivityCreated(bundle);
        b();
        c();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f030120, viewgroup, false);
        return a;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

    public void onDetach()
    {
        super.onDetach();
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
    }

    public void onStart()
    {
        super.onStart();
    }
}
