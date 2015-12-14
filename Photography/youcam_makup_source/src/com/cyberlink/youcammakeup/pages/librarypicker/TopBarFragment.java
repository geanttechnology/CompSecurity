// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivity;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent;
import com.cyberlink.youcammakeup.database.a;
import com.cyberlink.youcammakeup.database.b;
import com.cyberlink.youcammakeup.flurry.LauncherGotoEvent;
import com.cyberlink.youcammakeup.g;
import com.cyberlink.youcammakeup.kernelctrl.Camera;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.l;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.PhotoZoomFragment;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.h;
import com.cyberlink.youcammakeup.widgetpool.dialogs.i;
import com.pf.common.utility.m;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker:
//            LibraryViewFragment, PickedFragment

public class TopBarFragment extends Fragment
    implements l
{

    public static final UUID a = UUID.randomUUID();
    private TextView b;
    private View c;
    private View d;
    private View e;
    private View f;
    private android.view.View.OnClickListener g;
    private android.view.View.OnClickListener h;
    private android.view.View.OnClickListener i;
    private android.view.View.OnClickListener j;

    public TopBarFragment()
    {
        g = new android.view.View.OnClickListener() {

            final TopBarFragment a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLivePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent.Operation.a));
                a.a();
            }

            
            {
                a = TopBarFragment.this;
                super();
            }
        };
        h = new android.view.View.OnClickListener() {

            final TopBarFragment a;

            public void onClick(View view)
            {
                view = (LibraryPickerActivity)a.getActivity();
                if (view != null && view.j().d() && !view.o())
                {
                    view = (PhotoZoomFragment)view.getFragmentManager().findFragmentById(0x7f0c05b7);
                    PickedFragment pickedfragment = (PickedFragment)a.getFragmentManager().findFragmentById(0x7f0c0157);
                    if (view != null && pickedfragment != null)
                    {
                        pickedfragment.b(view.a());
                    }
                }
            }

            
            {
                a = TopBarFragment.this;
                super();
            }
        };
        i = new android.view.View.OnClickListener() {

            final TopBarFragment a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLivePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent.Operation.e));
                a.b();
            }

            
            {
                a = TopBarFragment.this;
                super();
            }
        };
        j = new android.view.View.OnClickListener() {

            final TopBarFragment a;
            private Toast b;

            private void a(Activity activity, com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception)
            {
                m.e("pages.librarypicker.TopBarFragment", cannotcreatefolderexception.toString());
                if (b != null)
                {
                    b.cancel();
                    b = null;
                }
                b = Toast.makeText(activity, 0x7f0704ea, 0);
                b.show();
            }

            static void a(_cls4 _pcls4, Activity activity, com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception)
            {
                _pcls4.a(activity, cannotcreatefolderexception);
            }

            public void onClick(View view)
            {
                boolean flag = false;
                view = a.getActivity();
                if (view == null)
                {
                    return;
                }
                com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.LauncherGotoEvent.DestName.a));
                Globals.d().a(false);
                if (!al.a(view.getPackageManager()))
                {
                    int k = z.b();
                    if (k % 3 == 0)
                    {
                        if (z.g().isEmpty())
                        {
                            z.a(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS.a);
                            com.cyberlink.youcammakeup.clflurry.b.a(new YCPInstallTrackEvent(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS.a));
                        }
                        h h1 = new h();
                        h1.a(new i(this, view) {

                            final Activity a;
                            final _cls4 b;

                            public void a(boolean flag)
                            {
                                if (flag)
                                {
                                    break MISSING_BLOCK_LABEL_14;
                                }
                                Camera.a().a(a);
                                return;
                                com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception;
                                cannotcreatefolderexception;
                                com.cyberlink.youcammakeup.pages.librarypicker._cls4.a(b, a, cannotcreatefolderexception);
                                return;
                            }

            
            {
                b = _pcls4;
                a = activity;
                super();
            }
                        });
                        o.a(view, h1, "DownloadYouPerfectDialog");
                        k = ((flag) ? 1 : 0);
                    } else
                    {
                        try
                        {
                            Camera.a().a(view);
                        }
                        catch (com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception)
                        {
                            a(view, cannotcreatefolderexception);
                        }
                    }
                    z.a(k + 1);
                    return;
                }
                try
                {
                    Camera.a().a(view);
                    return;
                }
                catch (com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception1)
                {
                    a(view, cannotcreatefolderexception1);
                }
            }

            
            {
                a = TopBarFragment.this;
                super();
            }
        };
    }

    private void b(long l1)
    {
        if (b == null)
        {
            return;
        }
        if (l1 == -1L)
        {
            b.setText(getActivity().getString(0x7f070055));
            return;
        }
        b b1 = com.cyberlink.youcammakeup.c.c().a(l1);
        String s = null;
        if (b1 != null)
        {
            s = b1.b();
        }
        if (s != null && !s.isEmpty())
        {
            b.setText(s);
            return;
        } else
        {
            b.setText(getActivity().getString(0x7f070055));
            return;
        }
    }

    public void a()
    {
        ((LibraryViewFragment)getActivity().getFragmentManager().findFragmentById(0x7f0c0158)).c();
    }

    public void a(long l1)
    {
        if (StatusManager.j().p() != l1)
        {
            return;
        } else
        {
            b(l1);
            return;
        }
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            b.setVisibility(4);
            e.setVisibility(0);
            return;
        } else
        {
            b.setVisibility(0);
            e.setVisibility(4);
            return;
        }
    }

    public void b()
    {
        Activity activity = getActivity();
        if (activity == null)
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.g.a(activity, null, null, null);
            activity.finish();
            return;
        }
    }

    public void c()
    {
        f.performClick();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(0x7f030121, viewgroup, false);
        b = (TextView)viewgroup.findViewById(0x7f0c05bf);
        b(StatusManager.j().p());
        StatusManager.j().a(this);
        c = viewgroup.findViewById(0x7f0c05bd);
        c.setOnClickListener(g);
        e = viewgroup.findViewById(0x7f0c05be);
        e.setOnClickListener(g);
        d = viewgroup.findViewById(0x7f0c05c0);
        d.setOnClickListener(h);
        f = viewgroup.findViewById(0x7f0c05c2);
        layoutinflater = getActivity();
        if (layoutinflater != null)
        {
            layoutinflater = layoutinflater.getIntent();
            if (layoutinflater != null)
            {
                bundle = f;
                if (layoutinflater.getBooleanExtra("ShowZooView", false))
                {
                    layoutinflater = i;
                } else
                {
                    layoutinflater = j;
                }
                bundle.setOnClickListener(layoutinflater);
            }
        }
        return viewgroup;
    }

    public void onDestroyView()
    {
        StatusManager.j().b(this);
        super.onDestroyView();
    }

}
