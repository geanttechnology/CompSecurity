// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.LauncherActivity;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivity;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivityForIntent;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.a;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.pages.librarypicker.albumpage.AlbumView;
import com.cyberlink.youcammakeup.pages.librarypicker.libraryviewfragment.Status;
import com.cyberlink.youcammakeup.pages.librarypicker.photopage.PhotoView;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.PhotoZoomFragment;
import com.pf.common.utility.m;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker:
//            TopBarFragment

public class LibraryViewFragment extends Fragment
{

    public static final String a = (new StringBuilder()).append(com/cyberlink/youcammakeup/pages/librarypicker/LibraryViewFragment.toString()).append("_STATE").toString();
    public static final UUID b = UUID.randomUUID();
    private Context c;
    private Globals d;
    private AlbumView e;
    private PhotoView f;
    private PhotoZoomFragment g;
    private TopBarFragment h;
    private Status i;

    public LibraryViewFragment()
    {
    }

    static AlbumView a(LibraryViewFragment libraryviewfragment)
    {
        return libraryviewfragment.e;
    }

    private boolean a(LibraryPickerActivity librarypickeractivity)
    {
        if (librarypickeractivity.j().c().equals("editViewForIntent"))
        {
            librarypickeractivity = new Intent();
            librarypickeractivity.setClassName("com.cyberlink.youperfect", "com.cyberlink.youperfect.activity.LauncherActivity");
            startActivity(librarypickeractivity);
        } else
        if (librarypickeractivity.isTaskRoot())
        {
            return true;
        }
        return false;
    }

    private boolean b(long l)
    {
        return com.cyberlink.youcammakeup.c.c().b(l).length > 0;
    }

    public void a()
    {
        long l1 = StatusManager.j().p();
        int j = StatusManager.j().q();
        long l2 = StatusManager.j().l();
        Intent intent;
        long l;
        boolean flag;
        if (i.b() != null)
        {
            l = i.b().longValue();
        } else
        {
            l = -1L;
        }
        intent = ((Activity)c).getIntent();
        if (intent != null)
        {
            boolean flag1 = intent.getBooleanExtra("ShowZooView", false);
            if (f != null)
            {
                f.b = flag1;
            }
            flag = flag1;
            if (flag1)
            {
                intent.removeExtra("ShowZooView");
                flag = flag1;
            }
        } else
        {
            flag = false;
        }
        if (l1 != -1L)
        {
            if (b(l1))
            {
                if (flag)
                {
                    a(l1, l2);
                    return;
                } else
                {
                    a(l1, j);
                    return;
                }
            } else
            {
                b();
                return;
            }
        }
        if (l1 != -1L)
        {
            a(l1, j);
            return;
        }
        if (l != -1L)
        {
            a(l);
            return;
        } else
        {
            b();
            return;
        }
    }

    public void a(long l)
    {
        a(l, 0);
    }

    public void a(long l, int j)
    {
        i.a(com.cyberlink.youcammakeup.pages.librarypicker.ViewType.a);
        i.a(Long.valueOf(l));
        h.a(false);
        e.setVisibility(8);
        f.setVisibility(0);
        g.getView().setVisibility(8);
        f.a(l, j);
        StatusManager.j().b(l);
    }

    public void a(long l, long l1)
    {
        Activity activity = getActivity();
        if (activity == null)
        {
            return;
        } else
        {
            i.a(com.cyberlink.youcammakeup.pages.librarypicker.ViewType.c);
            h.a(true);
            e.setVisibility(8);
            f.setVisibility(8);
            g.getView().setVisibility(0);
            ((PhotoZoomFragment)activity.getFragmentManager().findFragmentById(0x7f0c05b7)).a(l, l1);
            return;
        }
    }

    public void b()
    {
        i.a(ViewType.b);
        i.a(null);
        StatusManager.j().b(-1L);
        h.a(false);
        e.a();
        e.setVisibility(0);
        f.setVisibility(8);
        g.getView().setVisibility(8);
    }

    public void c()
    {
        LibraryPickerActivity librarypickeractivity;
        if (i.a() == com.cyberlink.youcammakeup.pages.librarypicker.ViewType.c)
        {
            a(StatusManager.j().p());
            return;
        }
        if (i.a() == com.cyberlink.youcammakeup.pages.librarypicker.ViewType.a)
        {
            b();
            return;
        }
        Globals.d().c(null);
        StatusManager.j().b(-1L);
        StatusManager.j().a(-1L, b);
        StatusManager.j().a(null, b);
        librarypickeractivity = (LibraryPickerActivity)getActivity();
        break MISSING_BLOCK_LABEL_88;
        if (!librarypickeractivity.d() && a(librarypickeractivity))
        {
            startActivity(new Intent(librarypickeractivity.getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
        }
        librarypickeractivity.finish();
        return;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle == null)
        {
            a();
            return;
        }
        if (i.a() == ViewType.b)
        {
            b();
            return;
        }
        bundle = i.b();
        if (bundle == null)
        {
            b();
            return;
        } else
        {
            a(bundle.longValue());
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getActivity();
        c = getActivity();
        d = (Globals)c.getApplicationContext();
        AnimationUtils.loadAnimation(d, 0x7f040016);
        AnimationUtils.loadAnimation(d, 0x7f040017);
        AnimationUtils.loadAnimation(d, 0x7f040018);
        AnimationUtils.loadAnimation(d, 0x7f040019);
        if (bundle != null)
        {
            bundle = (Status)bundle.getSerializable(a);
            if (bundle != null)
            {
                i = bundle;
            }
        }
        if (i == null)
        {
            i = new Status();
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03011f, viewgroup, false);
        e = (AlbumView)layoutinflater.findViewById(0x7f0c05b5);
        if (!(getActivity() instanceof LibraryPickerActivityForIntent))
        {
            e.a(getActivity());
        } else
        {
            m.b("widgetpool.LibraryViewFragment", "Intent case from YCP");
            (new AsyncTask() {

                int a;
                final LibraryViewFragment b;

                protected transient Void a(Void avoid[])
                {
                    avoid = (LibraryPickerActivityForIntent)b.getActivity();
_L2:
                    if (avoid.q() || a >= 100)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    m.e("widgetpool.LibraryViewFragment", (new StringBuilder()).append("Wait !activity.IsSampleReady(), count=").append(a).toString());
                    Thread.sleep(50L);
                    a = a + 1;
                    if (true) goto _L2; else goto _L1
                    avoid;
                    m.e("widgetpool.LibraryViewFragment", (new StringBuilder()).append("e=").append(avoid.toString()).toString());
_L1:
                    return null;
                }

                protected void a(Void void1)
                {
                    m.b("widgetpool.LibraryViewFragment", "Sample is ready, do init adapter");
                    com.cyberlink.youcammakeup.pages.librarypicker.LibraryViewFragment.a(b).a(b.getActivity());
                    com.cyberlink.youcammakeup.pages.librarypicker.LibraryViewFragment.a(b).a();
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
                b = LibraryViewFragment.this;
                super();
                a = 0;
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        e.setLibraryViewFragment(this);
        f = (PhotoView)layoutinflater.findViewById(0x7f0c05b6);
        g = (PhotoZoomFragment)getActivity().getFragmentManager().findFragmentById(0x7f0c05b7);
        g.getView().setVisibility(8);
        h = (TopBarFragment)getActivity().getFragmentManager().findFragmentById(0x7f0c0156);
        return layoutinflater;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(a, i);
    }


    private class ViewType extends Enum
    {

        public static final ViewType a;
        public static final ViewType b;
        public static final ViewType c;
        public static final ViewType d;
        private static final ViewType e[];

        public static ViewType valueOf(String s)
        {
            return (ViewType)Enum.valueOf(com/cyberlink/youcammakeup/pages/librarypicker/LibraryViewFragment$ViewType, s);
        }

        public static ViewType[] values()
        {
            return (ViewType[])e.clone();
        }

        static 
        {
            a = new ViewType("PhotoView", 0);
            b = new ViewType("AlbumView", 1);
            c = new ViewType("PhotoZoomView", 2);
            d = new ViewType("Unknow", 3);
            e = (new ViewType[] {
                a, b, c, d
            });
        }

        private ViewType(String s, int j)
        {
            super(s, j);
        }
    }

}
