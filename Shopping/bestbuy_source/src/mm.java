// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.mybby.MyBBYListIdActivity;
import com.bestbuy.android.activities.registry.WeddingRegistrySettings;
import com.bestbuy.android.activities.registry.WishListSettingsFragment;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYTextView;

public class mm
{

    public static View a(Context context, BBYBaseFragment bbybasefragment, RegistryWishList registrywishlist, RegistryWishList registrywishlist1, boolean flag, boolean flag1)
    {
        mn mn1 = new mn();
        View view = LayoutInflater.from(context).inflate(0x7f03011d, null);
        mn.a(mn1, (LinearLayout)view.findViewById(0x7f0c042c));
        mn.b(mn1, (LinearLayout)view.findViewById(0x7f0c042f));
        mn.c(mn1, (LinearLayout)view.findViewById(0x7f0c004f));
        mn.a(mn1, (RelativeLayout)view.findViewById(0x7f0c042b));
        mn.a(mn1, (BBYTextView)view.findViewById(0x7f0c0431));
        if (flag1)
        {
            mn.a(mn1).setText("Registry ID");
        } else
        {
            mn.a(mn1).setText("List ID");
        }
        mn.b(mn1).setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view1)
            {
            }

        });
        mn.c(mn1).setOnClickListener(new android.view.View.OnClickListener(registrywishlist, context, bbybasefragment, registrywishlist1) {

            final RegistryWishList a;
            final Context b;
            final BBYBaseFragment c;
            final RegistryWishList d;

            public void onClick(View view1)
            {
                if (a != null)
                {
                    view1 = (new StringBuilder()).append("https://www-ssl.bestbuy.com/profile/list/searchviewlist?listType=").append(a.getType().substring(0, a.getType().length() - 1)).append("&listId=").append(a.getUuid()).append("#!/view/").toString();
                    (new jt((Activity)b, c, null, view1, true)).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
                }
                if (d != null)
                {
                    view1 = (new StringBuilder()).append("https://www-ssl.bestbuy.com/profile/list/searchviewlist?listType=weddingregistrylist&listId=").append(d.getUuid()).append("#!/view/").toString();
                    (new jt((Activity)b, c, null, view1, false)).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
                }
            }

            
            {
                a = registrywishlist;
                b = context;
                c = bbybasefragment;
                d = registrywishlist1;
                super();
            }
        });
        mn.d(mn1).setOnClickListener(new android.view.View.OnClickListener(registrywishlist, context, bbybasefragment, registrywishlist1) {

            final RegistryWishList a;
            final Context b;
            final BBYBaseFragment c;
            final RegistryWishList d;

            public void onClick(View view1)
            {
                if (a != null)
                {
                    view1 = new Intent(b, com/bestbuy/android/activities/mybby/MyBBYListIdActivity);
                    view1.putExtra("FragmentName", "ListIdModalFragment");
                    view1.putExtra("uuid", a.getUuid());
                    kf.c(getClass().getName(), (new StringBuilder()).append("The alias is ").append(a.getRetailListAlias()).toString());
                    view1.putExtra("retailListAlias", a.getRetailListAlias());
                    view1.putExtra("listName", a.getShortDescription());
                    view1.putExtra("listType", a.getType());
                    b.startActivity(view1);
                    c.getActivity().overridePendingTransition(0x7f04000e, 0x7f040005);
                }
                if (d != null)
                {
                    view1 = new Intent(b, com/bestbuy/android/activities/mybby/MyBBYListIdActivity);
                    view1.putExtra("FragmentName", "ListIdModalFragment");
                    view1.putExtra("uuid", d.getUuid());
                    kf.c(getClass().getName(), (new StringBuilder()).append("The alias is ").append(d.getRetailListAlias()).toString());
                    view1.putExtra("retailListAlias", d.getRetailListAlias());
                    view1.putExtra("listType", d.getType());
                    b.startActivity(view1);
                    c.getActivity().overridePendingTransition(0x7f04000e, 0x7f040005);
                }
            }

            
            {
                a = registrywishlist;
                b = context;
                c = bbybasefragment;
                d = registrywishlist1;
                super();
            }
        });
        mn.e(mn1).setOnClickListener(new android.view.View.OnClickListener(registrywishlist1, bbybasefragment, flag, registrywishlist) {

            final RegistryWishList a;
            final BBYBaseFragment b;
            final boolean c;
            final RegistryWishList d;

            public void onClick(View view1)
            {
                if (a != null)
                {
                    view1 = new WeddingRegistrySettings(a, b, c);
                    Fragment fragment = b.getParentFragment();
                    if (fragment instanceof BaseFragmentContainer)
                    {
                        ((BaseFragmentContainer)fragment).a(view1, true);
                    }
                } else
                if (d != null)
                {
                    Object obj = new Bundle();
                    ((Bundle) (obj)).putString("listType", d.getType());
                    ((Bundle) (obj)).putString("listUuid", d.getUuid());
                    ((Bundle) (obj)).putString("listName", d.getShortDescription());
                    ((Bundle) (obj)).putString("listPrivacy", d.getPrivacySetting());
                    ((Bundle) (obj)).putString("shippingAddress", d.getShippingAddress());
                    ((Bundle) (obj)).putString("addDescription", d.getPersonalizedMessage());
                    ((Bundle) (obj)).putString("location", d.getLocation());
                    view1 = new WishListSettingsFragment(b, d, c);
                    view1.setArguments(((Bundle) (obj)));
                    obj = b.getParentFragment();
                    if (obj instanceof BaseFragmentContainer)
                    {
                        ((BaseFragmentContainer)obj).a(view1, true, "WishListSettingsFragment");
                        return;
                    }
                }
            }

            
            {
                a = registrywishlist;
                b = bbybasefragment;
                c = flag;
                d = registrywishlist1;
                super();
            }
        });
        return view;
    }
}
