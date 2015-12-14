// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.BroadcastReceiver;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.picsart.studio.utils.ItemControl;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.adapter.a;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.MyNetworkController;
import com.socialin.android.apiv3.controllers.RemoveItemController;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.request.ParamWithItemId;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.picsart.profile.activity.LoginFragmentActivity;
import com.socialin.android.picsart.profile.activity.PhotosByLocationActivity;
import com.socialin.android.picsart.profile.adapter.ab;
import com.socialin.android.picsart.profile.adapter.ac;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.picsart.profile.util.NetworkFragmentException;
import com.socialin.android.picsart.profile.util.x;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.picsart.upload.PicsartUploadEditActivity;
import com.socialin.android.picsart.upload.UploadItem;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import com.socialin.asyncnet.b;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.cr.c;
import myobfuscated.cr.f;
import myobfuscated.cr.h;
import myobfuscated.cs.e;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            a

public class at extends com.socialin.android.picsart.profile.fragment.a
    implements android.app.LoaderManager.LoaderCallbacks, a, e
{

    private static final String m = com/socialin/android/picsart/profile/fragment/at.getSimpleName();
    private static final String n = (new StringBuilder()).append(com/socialin/android/picsart/profile/fragment/at.getSimpleName()).append("_").append(System.currentTimeMillis()).toString();
    private ab o;
    private final BroadcastReceiver p = new _cls1();
    private MyNetworkController q;
    private RemoveItemController r;
    private ParamWithItemId s;
    private g t;
    private int u;

    public at()
    {
        r = new RemoveItemController();
        s = new ParamWithItemId();
        u = -1;
    }

    public static ab a(at at1)
    {
        return at1.o;
    }

    private void a(int i, boolean flag, String s1)
    {
        getActivity().getIntent().putExtra("openItemDetails", true);
        getActivity().getIntent().putExtra("keyboardHide", flag);
        b(i, true, s1);
_L1:
        return;
        s1;
        d.b(m, "handleShowItemDetailsClick", s1);
        if (d.b)
        {
            throw new NetworkFragmentException(s1);
        }
          goto _L1
    }

    private void a(ImageItem imageitem)
    {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!com.socialin.android.util.s.a(activity))
        {
            GalleryUtils.a(activity);
            return;
        }
        if (!y.a(getActivity(), "MyNetwork") || imageitem.isReposting()) goto _L1; else goto _L3
_L3:
        int i;
        _cls3 _lcls3 = new _cls3();
        x.b(activity, imageitem, _lcls3, _lcls3, "my_network");
        if (!imageitem.isReposted)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        imageitem.isReposted = false;
        imageitem.repostsCount = imageitem.repostsCount - 1;
        i = 0;
_L8:
        if (i >= imageitem.reposts.size()) goto _L5; else goto _L4
_L4:
        if (((ViewerUser)imageitem.reposts.get(i)).id != SocialinV3.getInstance().getUser().id) goto _L7; else goto _L6
_L6:
        imageitem.reposts.remove(i);
_L5:
        k();
        return;
_L7:
        i++;
          goto _L8
        imageitem.isReposted = true;
        imageitem.repostsCount = imageitem.repostsCount + 1;
          goto _L5
    }

    static void a(at at1, ImageItem imageitem)
    {
        AnalyticUtils.getInstance(at1.getActivity()).trackLocalAction("myNetwork:remove");
        Object obj = at1.getActivity();
        at1.getString(0x7f080450);
        obj = g.a(((android.content.Context) (obj)), at1.getString(0x7f08041a), true);
        at1.r.setRequestCompleteListener(new _cls6(at1, ((g) (obj)), imageitem));
        at1.s.itemId = imageitem.id;
        at1.r.setRequestParams(at1.s);
        com.socialin.asyncnet.b.a().a(at1.r.getRequestId());
        at1.r.doRequest("removeItem", at1.s);
    }

    private void b(int i)
    {
        getActivity().getIntent().putExtra("openItemDetails", false);
        b(i, false, null);
_L1:
        return;
        Exception exception;
        exception;
        d.b(m, "handleImageItemClick", exception);
        if (d.b)
        {
            throw new NetworkFragmentException(exception);
        }
          goto _L1
    }

    private void b(int i, boolean flag, String s1)
    {
        int l = 0;
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing())
        {
            ImageItem imageitem;
            int i1;
            if (o != null)
            {
                i1 = o.getItemCount() - o.a();
            } else
            {
                i1 = 0;
            }
            if (i1 > 0)
            {
                imageitem = (ImageItem)o.getItem(i);
            } else
            {
                imageitem = null;
            }
            if (imageitem != null)
            {
                ArrayList arraylist = new ArrayList();
                ImageItem aimageitem[] = new ImageItem[i1];
                do
                {
                    if (l >= i1)
                    {
                        break;
                    }
                    int j1;
                    if (SocialinV3.getInstance().isRegistered())
                    {
                        j1 = l;
                    } else
                    {
                        j1 = l + 1;
                    }
                    if (j1 == i1)
                    {
                        break;
                    }
                    aimageitem[l] = (ImageItem)o.getItem(j1);
                    arraylist.add(aimageitem[l]);
                    l++;
                } while (true);
                l = i;
                if (!SocialinV3.getInstance().isRegistered())
                {
                    l = i - 1;
                }
                activity.getIntent().putExtra("broadcast_action_handler", com/socialin/android/picsart/profile/fragment/at.getName());
                activity.getIntent().putExtra("request_controller_code", 4);
                String s2;
                if (imageitem.url == null)
                {
                    s2 = null;
                } else
                {
                    s2 = imageitem.url.substring(imageitem.url.lastIndexOf("."), imageitem.url.length());
                }
                GalleryUtils.b(activity, String.valueOf(imageitem.id), s2);
                if (!flag)
                {
                    GalleryUtils.b(this, arraylist, l, ((BaseActivity)activity).getGalleryItemFragmentFrame());
                    return;
                } else
                {
                    GalleryUtils.a(getActivity(), aimageitem, l, s1, "my_network");
                    return;
                }
            }
        }
    }

    public static at m()
    {
        return new at();
    }

    static String o()
    {
        return m;
    }

    public final void a()
    {
        super.a();
        if (o.isEmpty() && SocialinV3.getInstance().isRegistered())
        {
            a(myobfuscated.f.m.a(getActivity(), 0x7f080635, true, Integer.valueOf(0x7f0300e8)));
        }
    }

    public final transient void a(int i, ItemControl itemcontrol, Object aobj[])
    {
        Object obj = null;
        u = i;
        Activity activity;
        if (i >= 0)
        {
            aobj = (ImageItem)o.getItem(i);
        } else
        {
            aobj = null;
        }
        com.socialin.android.picsart.profile.fragment._cls8.a[itemcontrol.ordinal()];
        JVM INSTR tableswitch 1 23: default 140
    //                   1 141
    //                   2 177
    //                   3 221
    //                   4 253
    //                   5 285
    //                   6 449
    //                   7 486
    //                   8 492
    //                   9 556
    //                   10 566
    //                   11 576
    //                   12 586
    //                   13 596
    //                   14 606
    //                   15 616
    //                   16 629
    //                   17 673
    //                   18 705
    //                   19 714
    //                   20 774
    //                   21 828
    //                   22 981
    //                   23 1097;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24
_L1:
        break; /* Loop/switch isn't completed */
_L24:
        break MISSING_BLOCK_LABEL_1097;
_L25:
        return;
_L2:
        itemcontrol = new Intent(getActivity(), com/socialin/android/picsart/profile/activity/PhotosByLocationActivity);
        itemcontrol.putExtra("location", ((ImageItem) (aobj)).address);
        getActivity().startActivity(itemcontrol);
        return;
_L3:
        itemcontrol = new Intent();
        itemcontrol.setClassName(getActivity().getPackageName(), "com.socialin.android.picsart.profile.activity.AddToMemboxActivity");
        itemcontrol.putExtra("item_id", ((ImageItem) (aobj)).id);
        startActivityForResult(itemcontrol, 4543);
        return;
_L4:
        GalleryUtils.a(getActivity(), 127, ((ImageItem) (aobj)).user, ((ImageItem) (aobj)).user.id, ((ImageItem) (aobj)).user.username, null, "MyNetwork", null);
        return;
_L5:
        GalleryUtils.a(getActivity(), 127, ((ImageItem) (aobj)).user, ((ImageItem) (aobj)).user.id, ((ImageItem) (aobj)).user.username, null, "MyNetwork", null);
        return;
_L6:
        if (!SocialinV3.getInstance().isRegistered())
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("my_network", "like"));
        }
        activity = getActivity();
        if (activity != null && !activity.isFinishing())
        {
            if (!com.socialin.android.util.s.a(activity))
            {
                GalleryUtils.a(activity);
                return;
            }
            if (y.a(getActivity(), "MyNetwork") && aobj != null && !((ImageItem) (aobj)).isLiking())
            {
                itemcontrol = new _cls2(((ImageItem) (aobj)));
                if (((ImageItem) (aobj)).isLiked)
                {
                    itemcontrol = ((ItemControl) (obj));
                }
                x.a(activity, ((ImageItem) (aobj)), itemcontrol, "my_network");
                if (((ImageItem) (aobj)).isLiked)
                {
                    aobj.isLiked = false;
                    aobj.likesCount = ((ImageItem) (aobj)).likesCount - 1;
                } else
                {
                    aobj.isLiked = true;
                    aobj.likesCount = ((ImageItem) (aobj)).likesCount + 1;
                }
                k();
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (!SocialinV3.getInstance().isRegistered())
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("my_network", "repost"));
        }
        a(((ImageItem) (aobj)));
        return;
_L8:
        b(i);
        return;
_L9:
        if (!SocialinV3.getInstance().isRegistered())
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("my_network", "double_tap_like"));
        }
        x.a(getActivity(), ((android.os.Parcelable) (aobj)), "my_network");
        (new Handler()).postDelayed(new _cls4(), 450L);
        return;
_L10:
        a(i, false, "item.details.comments");
        return;
_L11:
        a(i, true, "item.details.comments");
        return;
_L12:
        a(i, true, "item.details.likes");
        return;
_L13:
        a(i, true, "item.details.reposts");
        return;
_L14:
        a(i, true, "item.details.reposts");
        return;
_L15:
        a(i, true, "item.details.memboxes");
        return;
_L16:
        y.a(getActivity(), ((ImageItem) (aobj)), t);
        return;
_L17:
        if (aobj != null)
        {
            itemcontrol = com.bumptech.glide.b.b(getActivity().getApplicationContext()).j().a(((ImageItem) (aobj)).getMidleUrl());
            itemcontrol.a = new _cls7(((ImageItem) (aobj)));
            itemcontrol.b();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L18:
        if (aobj != null)
        {
            GalleryUtils.b(getActivity(), (new StringBuilder("http://picsart.com/i/")).append(((ImageItem) (aobj)).id).toString());
            return;
        }
        if (true) goto _L25; else goto _L19
_L19:
        GalleryUtils.b(getActivity(), ((ImageItem) (aobj)));
        return;
_L20:
        if (!SocialinV3.getInstance().isRegistered())
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("my_network", "add_to_membox"));
        }
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.AddToMemBoxEvent("my_network_card_more"));
        GalleryUtils.c(getActivity(), ((ImageItem) (aobj)));
        return;
_L21:
        if (!SocialinV3.getInstance().isRegistered())
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("my_network", "follow_user"));
        }
        if (aobj != null)
        {
            itemcontrol = ((ImageItem) (aobj)).user;
        } else
        {
            itemcontrol = null;
        }
        x.a(itemcontrol, this, null, "my_network");
        return;
_L22:
        if (getActivity().isFinishing() || !y.c(getActivity())) goto _L25; else goto _L26
_L26:
        itemcontrol = new Intent(getActivity(), com/socialin/android/picsart/upload/PicsartUploadEditActivity);
        obj = new ImageItem();
        obj.url = ((ImageItem) (aobj)).url;
        obj.id = ((ImageItem) (aobj)).id;
        obj.title = ((ImageItem) (aobj)).title;
        obj.address = ((ImageItem) (aobj)).address;
        obj.isMature = ((ImageItem) (aobj)).isMature;
        obj.isPublic = ((ImageItem) (aobj)).isPublic;
        obj.tags = ((ImageItem) (aobj)).tags;
        obj.width = ((ImageItem) (aobj)).width;
        obj.height = ((ImageItem) (aobj)).height;
        itemcontrol.putExtra("item", ((android.os.Parcelable) (obj)));
        itemcontrol.putExtra("is_edit_mode", true);
        startActivityForResult(itemcontrol, 4547);
        return;
_L23:
        if (aobj == null || SocialinV3.getInstance().getUser().id != ((ImageItem) (aobj)).user.id) goto _L25; else goto _L27
_L27:
        try
        {
            itemcontrol = getFragmentManager().beginTransaction();
            obj = getFragmentManager().findFragmentByTag("remove_confirm_dialog");
        }
        // Misplaced declaration of an exception variable
        catch (ItemControl itemcontrol)
        {
            d.b(m, "openConfirmDeleteDialog", itemcontrol);
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1037;
        }
        itemcontrol.remove(((android.app.Fragment) (obj)));
        obj = new com.socialin.android.dialog.b();
        obj.b = getString(0x7f0805ea);
        ((com.socialin.android.dialog.b) (obj)).a(new _cls5(((ImageItem) (aobj)))).a().show(itemcontrol, "remove_confirm_dialog");
        return;
        if (!SocialinV3.getInstance().isRegistered())
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("my_network", "login_or_sign_up"));
        }
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.LoginOrSignupClickEvent());
        itemcontrol = new Intent();
        itemcontrol.addCategory("android.intent.category.DEFAULT");
        itemcontrol.setClass(getActivity(), com/socialin/android/picsart/profile/activity/LoginFragmentActivity);
        itemcontrol.setFlags(0x4000000);
        itemcontrol.putExtra("from", "my_nettwork");
        startActivityForResult(itemcontrol, 1);
        return;
    }

    public final void n()
    {
        if (c != null)
        {
            c.clear();
            return;
        } else
        {
            o.clear();
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        boolean flag;
        if (bundle == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        getLoaderManager().initLoader(1, null, this);
        a(false, true, flag);
    }

    public void onActivityResult(int i, int l, Intent intent)
    {
        super.onActivityResult(i, l, intent);
        i;
        JVM INSTR lookupswitch 3: default 44
    //                   1: 45
    //                   2: 58
    //                   4547: 66;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if (l == -1)
        {
            a(false, true, true);
            return;
        }
          goto _L1
_L3:
        a(false, true, true);
        return;
_L4:
        if (l != -1) goto _L1; else goto _L5
_L5:
        if (intent == null) goto _L7; else goto _L6
_L6:
        if (intent.hasExtra("item") && u >= 0)
        {
            intent = (ImageItem)intent.getParcelableExtra("item");
            ImageItem imageitem = (ImageItem)o.getItem(u);
            if (((ImageItem) (intent)).id == imageitem.id)
            {
                imageitem.title = ((ImageItem) (intent)).title;
                imageitem.tags = ((ImageItem) (intent)).tags;
                imageitem.address = ((ImageItem) (intent)).address;
                imageitem.isPublic = ((ImageItem) (intent)).isPublic;
                imageitem.isMature = ((ImageItem) (intent)).isMature;
            }
            k();
        }
_L7:
        u = -1;
        return;
        intent;
        d.b(m, "onActivityResult", intent);
        u = -1;
        return;
        intent;
        u = -1;
        throw intent;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        q = new MyNetworkController(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        y.a(getActivity(), p);
        t = new g(getActivity());
        t.setCancelable(false);
        Object obj = y.a(getActivity().getApplicationContext());
        o = new ab(getActivity(), this);
        bundle = o;
        int i = ((Point) (obj)).x;
        int l = ((Point) (obj)).y;
        bundle.a = i;
        bundle.b = l;
        bundle = a(o);
        a(com.socialin.android.apiv3.model.AppProps.TabAdType.NETWORK, ((Point) (obj)));
        obj = myobfuscated.cr.a.a(q, bundle);
        c c1 = new c();
        c1.a = getResources().getInteger(0x7f0e0019);
        c1.b = getResources().getInteger(0x7f0e001a);
        obj.h = new myobfuscated.cr.b(c1.a, c1.b);
        a(getActivity());
        b(bundle, ((myobfuscated.cr.a) (obj)));
        bundle = Utils.g(getActivity());
        i = bundle[0];
        l = bundle[1];
        int i1 = getResources().getColor(0x7f0f009b);
        int j1 = (int)getResources().getDimension(0x7f0b009d);
        bundle = new h(getResources());
        bundle.c = l;
        bundle.e = i1;
        bundle.a = i;
        bundle.j = j1;
        a(bundle.a(new com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle[] {
            com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle.STAGGERED
        }).b());
        o.e = new ac(this);
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new CursorLoader(getActivity(), myobfuscated.bg.a.a, null, "upload_status=2", null, "created_at DESC");
    }

    public void onDestroy()
    {
        super.onDestroy();
        l();
        try
        {
            com.socialin.asyncnet.b.a().a(n);
        }
        catch (Exception exception)
        {
            d.b(m, "onDestroy", exception);
            if (d.b)
            {
                throw new NetworkFragmentException(exception);
            }
            ExceptionReportService.report(SocialinV3.getInstance().getContext(), exception, String.valueOf(SocialinV3.getInstance().getUser().id));
        }
        y.b(getActivity(), p);
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        loader = (Cursor)obj;
        if (SocialinV3.getInstance().isRegistered())
        {
            obj = new ArrayList();
            if (loader != null && loader.getCount() > 0)
            {
                loader.moveToFirst();
                do
                {
                    if (loader.isAfterLast())
                    {
                        break;
                    }
                    UploadItem uploaditem = UploadItem.a(loader);
                    String s1 = String.valueOf(uploaditem.j);
                    if (uploaditem.g())
                    {
                        int i = 0;
                        do
                        {
                            String as[] = UploadItem.c;
                            if (i >= 8)
                            {
                                break;
                            }
                            String s2 = UploadItem.c[i];
                            int l = uploaditem.i(s2);
                            if (uploaditem.h(s2) && !uploaditem.e(s2) && uploaditem.e[l] > UploadItem.a(s2))
                            {
                                l = 1;
                            } else
                            {
                                l = 0;
                            }
                            if (l && !o.a(s1, s2) && (UploadItem.b(s2) && !s2.equals("facebook") || (s2.equals("picsart") && uploaditem.i() || s2.equals("facebook")) && !TextUtils.isEmpty(uploaditem.e())))
                            {
                                ((List) (obj)).add(new com.socialin.android.picsart.upload.c(UploadItem.c[i], uploaditem.b(), s1, uploaditem.e()));
                            }
                            i++;
                        } while (true);
                        loader.moveToNext();
                    }
                } while (true);
            }
            if (!((List) (obj)).isEmpty() && com.socialin.android.util.s.a(getActivity()))
            {
                o.d.addAll(((java.util.Collection) (obj)));
                super.d = o.a();
                k();
                ((List) (obj)).size();
            }
        }
    }

    public void onLoaderReset(Loader loader)
    {
    }

    public void onResume()
    {
        super.onResume();
        boolean flag;
        if (super.i == null || super.i.getChildCount() <= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            a(false, true, true);
        }
    }

    public void onStop()
    {
        super.onStop();
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls5 {}

}
