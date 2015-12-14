// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.d;
import com.picsart.studio.profile.ProfileActivity;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.activity.FragmentActionsListener;
import com.socialin.android.activity.WhatsNewActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.constants.EventParam;
import com.socialin.android.picsart.profile.activity.AboutPicsartActivity;
import com.socialin.android.picsart.profile.activity.FindFriendsActivity;
import com.socialin.android.picsart.profile.activity.LoginFragmentActivity;
import com.socialin.android.picsart.profile.invite.i;
import com.socialin.android.util.f;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            av, au

public class NavigationFragment extends Fragment
    implements android.view.View.OnClickListener
{

    public au a;
    private av b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private View h;
    private View i;
    private int j;
    private e k;

    public NavigationFragment()
    {
        b = new av(this, (byte)0);
        j = 0;
        a = null;
    }

    public static NavigationFragment a()
    {
        return new NavigationFragment();
    }

    private void a(View view)
    {
        if (!isVisible()) goto _L2; else goto _L1
_L1:
        j;
        JVM INSTR tableswitch 11 14: default 40
    //                   11 41
    //                   12 40
    //                   13 84
    //                   14 127;
           goto _L2 _L3 _L2 _L4 _L5
_L2:
        return;
_L3:
        ((TextView)view.findViewById(0x7f1005de)).setTypeface(null, 1);
        ((TextView)view.findViewById(0x7f1005dd)).setTypeface(null, 0);
        ((TextView)view.findViewById(0x7f10001a)).setTypeface(null, 0);
        return;
_L4:
        ((TextView)view.findViewById(0x7f1005dd)).setTypeface(null, 1);
        ((TextView)view.findViewById(0x7f1005de)).setTypeface(null, 0);
        ((TextView)view.findViewById(0x7f10001a)).setTypeface(null, 0);
        return;
_L5:
        ((TextView)view.findViewById(0x7f10001a)).setTypeface(null, 1);
        ((TextView)view.findViewById(0x7f1005de)).setTypeface(null, 0);
        ((TextView)view.findViewById(0x7f1005dd)).setTypeface(null, 0);
        return;
    }

    static void a(NavigationFragment navigationfragment)
    {
        Intent intent = new Intent();
        if (navigationfragment.getActivity().getIntent().getExtras() != null)
        {
            intent.putExtras(navigationfragment.getActivity().getIntent().getExtras());
        }
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setClass(navigationfragment.getActivity(), com/socialin/android/picsart/profile/activity/LoginFragmentActivity);
        intent.setFlags(0x24000000);
        intent.putExtra("from", "drawer");
        navigationfragment.startActivityForResult(intent, 126);
    }

    static void a(NavigationFragment navigationfragment, Runnable runnable)
    {
        navigationfragment.a(runnable);
    }

    private void a(Runnable runnable)
    {
        Activity activity = getActivity();
        if (activity instanceof BaseActivity)
        {
            ((BaseActivity)activity).closeNavigationBar(runnable);
        } else
        if (activity instanceof ProfileActivity)
        {
            ((ProfileActivity)activity).closeNavigationBar(runnable);
            return;
        }
    }

    static int b(NavigationFragment navigationfragment)
    {
        return navigationfragment.j;
    }

    private void b()
    {
label0:
        {
label1:
            {
                int i1 = 0;
                if (getActivity() != null && !getActivity().isFinishing())
                {
                    if (!SocialinV3.getInstance().isRegistered())
                    {
                        break label0;
                    }
                    h.setVisibility(8);
                    i.setVisibility(0);
                    Object obj = SocialinV3.getInstance().getUser();
                    if (!TextUtils.isEmpty(((User) (obj)).name))
                    {
                        f.setText(((User) (obj)).name);
                    }
                    if (!TextUtils.isEmpty(((User) (obj)).username))
                    {
                        g.setText((new StringBuilder("@")).append(((User) (obj)).username).toString());
                    }
                    obj = SocialinV3.getInstance().getUser();
                    if (obj != null && SocialinV3.getInstance().isRegistered())
                    {
                        (new f(getActivity().getApplicationContext())).a(((User) (obj)).getPhoto(), c, k, null);
                        ImageView imageview = e;
                        if (!((User) (obj)).isValidated)
                        {
                            i1 = 8;
                        }
                        imageview.setVisibility(i1);
                    }
                    obj = SocialinV3.getInstance().getUser();
                    if (obj == null || TextUtils.isEmpty(((User) (obj)).cover))
                    {
                        break label1;
                    }
                    if (PicsartContext.a() < 0x100000)
                    {
                        obj = (new StringBuilder()).append(((User) (obj)).cover).append(ImageItem.prefixMidle).toString();
                    } else
                    {
                        obj = ((User) (obj)).cover;
                    }
                    (new d(getActivity().getApplicationContext())).a(((String) (obj)), d, com.bumptech.glide.request.e.b(l.a));
                }
                return;
            }
            d.setImageDrawable(null);
            return;
        }
        h.setVisibility(0);
        i.setVisibility(8);
    }

    static au c(NavigationFragment navigationfragment)
    {
        return navigationfragment.a;
    }

    private void c()
    {
        if (getActivity() instanceof FragmentActionsListener)
        {
            ((FragmentActionsListener)getActivity()).onFragmentFinishWithResultOK(166);
        }
    }

    static void d(NavigationFragment navigationfragment)
    {
        navigationfragment.b();
    }

    public final void a(int i1)
    {
        View view = getView();
        j = i1;
        a(view);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        getActivity().registerReceiver(b, new IntentFilter("com.picsart.studio.update.user.action"));
        c();
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (j1 != -1) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR lookupswitch 2: default 40
    //                   100: 46
    //                   126: 41;
           goto _L2 _L3 _L4
_L2:
        return;
_L4:
        c();
        return;
_L3:
        getActivity().finish();
        return;
    }

    public void onClick(View view)
    {
        int i1 = view.getId();
        if (i1 == 0x7f1005e2)
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.DrawerItemClickEvent("about"));
            a(new Runnable() {

                private NavigationFragment a;

                public final void run()
                {
                    Intent intent = new Intent(a.getActivity(), com/socialin/android/picsart/profile/activity/AboutPicsartActivity);
                    a.startActivity(intent);
                }

            
            {
                a = NavigationFragment.this;
                super();
            }
            });
        } else
        {
            if (i1 == 0x7f1005de)
            {
                AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.DrawerItemClickEvent("find_friends"));
                a(new Runnable() {

                    private NavigationFragment a;

                    public final void run()
                    {
label0:
                        {
label1:
                            {
                                if (NavigationFragment.b(a) != 11)
                                {
                                    if (!SocialinV3.getInstance().isRegistered())
                                    {
                                        break label0;
                                    }
                                    if (NavigationFragment.c(a) == null)
                                    {
                                        break label1;
                                    }
                                    NavigationFragment.c(a).a(11);
                                }
                                return;
                            }
                            Activity activity = a.getActivity();
                            Intent intent = new Intent(activity, com/socialin/android/picsart/profile/activity/FindFriendsActivity);
                            if (activity.getIntent() != null && activity.getIntent().getExtras() != null)
                            {
                                intent.putExtras(activity.getIntent().getExtras());
                            }
                            activity.startActivity(intent);
                            return;
                        }
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("drawer", "find_friends"));
                        NavigationFragment.a(a);
                    }

            
            {
                a = NavigationFragment.this;
                super();
            }
                });
                return;
            }
            if (i1 == 0x7f10001a)
            {
                AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.DrawerItemClickEvent("shop"));
                a(new Runnable() {

                    private NavigationFragment a;

                    public final void run()
                    {
                        if (NavigationFragment.b(a) != 14)
                        {
                            if (NavigationFragment.c(a) != null)
                            {
                                NavigationFragment.c(a).a(14);
                            } else
                            {
                                Activity activity = a.getActivity();
                                if (activity != null && !activity.isFinishing())
                                {
                                    Intent intent = new Intent();
                                    intent.setClassName(activity.getApplicationContext(), "com.picsart.shop.ShopActivity");
                                    if (activity.getIntent() != null && activity.getIntent().getExtras() != null)
                                    {
                                        intent.putExtras(activity.getIntent().getExtras());
                                    }
                                    activity.startActivity(intent);
                                    return;
                                }
                            }
                        }
                    }

            
            {
                a = NavigationFragment.this;
                super();
            }
                });
                return;
            }
            if (i1 == 0x7f1005e1)
            {
                AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.DrawerItemClickEvent("settings"));
                a(new Runnable() {

                    private NavigationFragment a;

                    public final void run()
                    {
                        Activity activity = a.getActivity();
                        Intent intent = new Intent();
                        intent.setClassName(activity.getPackageName(), "com.socialin.android.preference.PreferencesActivity");
                        a.startActivityForResult(intent, 101);
                        AnalyticUtils.getInstance(activity).trackLocalAction("more:settings");
                    }

            
            {
                a = NavigationFragment.this;
                super();
            }
                });
                return;
            }
            if (i1 == 0x7f1005e0)
            {
                AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.DrawerItemClickEvent("what's_new"));
                view = new Intent(getActivity(), com/socialin/android/activity/WhatsNewActivity);
                view.setFlags(0x20400000);
                startActivity(view);
                return;
            }
            if (i1 == 0x7f1005dd)
            {
                AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.DrawerItemClickEvent("explore"));
                a(new Runnable() {

                    private NavigationFragment a;

                    public final void run()
                    {
label0:
                        {
                            if (a.getActivity() != null)
                            {
                                if (NavigationFragment.c(a) == null)
                                {
                                    break label0;
                                }
                                NavigationFragment.c(a).a(13);
                            }
                            return;
                        }
                        Intent intent = new Intent();
                        intent.setClassName(a.getActivity().getPackageName(), "com.socialin.android.photo.picsinphoto.MainPagerActivity");
                        intent.setFlags(0x4000000);
                        intent.putExtra("souorce", "navigation");
                        a.startActivity(intent);
                    }

            
            {
                a = NavigationFragment.this;
                super();
            }
                });
                return;
            }
            if (i1 == 0x7f1005df)
            {
                AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.DrawerItemClickEvent("invite_friends"));
                com.socialin.android.picsart.profile.invite.i.a(this, "", EventParam.DRAWER.getName(), com.socialin.android.constants.CommonConstants.InviteMode.APP_INVITE);
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        k = (e)((e)com.bumptech.glide.request.e.b(l.a).a(0x7f020669)).b(0x7f020669);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030110, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
        getActivity().unregisterReceiver(b);
    }

    public void onResume()
    {
        super.onResume();
        b();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        f = (TextView)view.findViewById(0x7f100276);
        g = (TextView)view.findViewById(0x7f1005db);
        h = view.findViewById(0x7f1005dc);
        h.setOnClickListener(new android.view.View.OnClickListener() {

            final NavigationFragment a;

            public final void onClick(View view1)
            {
            /* block-local class not found */
            class _cls1 {}

                NavigationFragment.a(a, new _cls1());
            }

            
            {
                a = NavigationFragment.this;
                super();
            }
        });
        i = view.findViewById(0x7f1005d8);
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final NavigationFragment a;

            public final void onClick(View view1)
            {
            /* block-local class not found */
            class _cls1 {}

                NavigationFragment.a(a, new _cls1());
            }

            
            {
                a = NavigationFragment.this;
                super();
            }
        });
        view.findViewById(0x7f1005dd).setOnClickListener(this);
        view.findViewById(0x7f1005de).setOnClickListener(this);
        view.findViewById(0x7f10001a).setOnClickListener(this);
        view.findViewById(0x7f1005e1).setOnClickListener(this);
        view.findViewById(0x7f1005e0).setOnClickListener(this);
        view.findViewById(0x7f1005e2).setOnClickListener(this);
        bundle = view.findViewById(0x7f1005df);
        if (SocialinV3.getInstance().getSettings().isInviteFriendsEnabled())
        {
            bundle.setVisibility(0);
            bundle.setOnClickListener(this);
        } else
        {
            bundle.setVisibility(8);
        }
        c = (ImageView)view.findViewById(0x7f100273);
        e = (ImageView)view.findViewById(0x7f100275);
        d = (ImageView)view.findViewById(0x7f1005d9);
        a(view);
    }
}
