// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.appsettings;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.exacttarget.etpushsdk.ETException;
import com.exacttarget.etpushsdk.ETPush;
import java.util.ArrayList;
import java.util.Iterator;
import lq;
import nb;

// Referenced classes of package com.bestbuy.android.activities.appsettings:
//            NotificationsCategoryFragment

public class NotificationsFragment extends BBYBaseFragment
{

    FragmentManager a;
    FragmentTransaction b;
    private Activity c;
    private SharedPreferences g;
    private FrameLayout h;

    public NotificationsFragment()
    {
    }

    static SharedPreferences a(NotificationsFragment notificationsfragment)
    {
        return notificationsfragment.g;
    }

    static Activity b(NotificationsFragment notificationsfragment)
    {
        return notificationsfragment.c;
    }

    public void a(boolean flag)
    {
        a = getChildFragmentManager();
        b = a.beginTransaction();
        if (flag)
        {
            h.setVisibility(0);
            flag = g.getBoolean(getResources().getString(0x7f08008b), false);
            b.replace(0x7f0c0056, new NotificationsCategoryFragment(flag));
            b.commit();
            return;
        } else
        {
            h.setVisibility(8);
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        c = activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030085, viewgroup, false);
        h = (FrameLayout)layoutinflater.findViewById(0x7f0c0056);
        g = nb.a().c();
        f = nb.a();
        viewgroup = (Switch)layoutinflater.findViewById(0x7f0c01ee);
        viewgroup.setChecked(Boolean.valueOf(g.getBoolean(getResources().getString(0x7f08004b), false)).booleanValue());
        viewgroup.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final NotificationsFragment a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                compoundbutton = NotificationsFragment.a(a).edit();
                if (flag)
                {
                    compoundbutton.putBoolean(a.getResources().getString(0x7f08004b), true);
                } else
                {
                    compoundbutton.putBoolean(a.getResources().getString(0x7f08004b), false);
                    try
                    {
                        ETPush.pushManager().removeTag(a.getString(0x7f0802c1));
                    }
                    catch (ETException etexception)
                    {
                        etexception.printStackTrace();
                    }
                }
                compoundbutton.commit();
                lq.a(NotificationsFragment.b(a), null);
            }

            
            {
                a = NotificationsFragment.this;
                super();
            }
        });
        viewgroup = (Switch)layoutinflater.findViewById(0x7f0c01ef);
        viewgroup.setChecked(Boolean.valueOf(g.getBoolean(getResources().getString(0x7f08003e), false)).booleanValue());
        viewgroup.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final NotificationsFragment a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                compoundbutton = NotificationsFragment.a(a).edit();
                if (flag)
                {
                    compoundbutton.putBoolean(a.getResources().getString(0x7f08003e), true);
                } else
                {
                    compoundbutton.putBoolean(a.getResources().getString(0x7f08003e), false);
                    try
                    {
                        ETPush.pushManager().removeTag(a.getString(0x7f08016f));
                    }
                    catch (ETException etexception)
                    {
                        etexception.printStackTrace();
                    }
                }
                compoundbutton.commit();
                lq.a(NotificationsFragment.b(a), null);
            }

            
            {
                a = NotificationsFragment.this;
                super();
            }
        });
        viewgroup = (Switch)layoutinflater.findViewById(0x7f0c01f0);
        bundle = Boolean.valueOf(g.getBoolean(getResources().getString(0x7f08008a), false));
        viewgroup.setChecked(bundle.booleanValue());
        android.content.SharedPreferences.Editor editor = g.edit();
        editor.putBoolean(getResources().getString(0x7f08008b), false);
        editor.commit();
        a(bundle.booleanValue());
        viewgroup.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final NotificationsFragment a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                Object obj;
                compoundbutton = NotificationsFragment.a(a).edit();
                obj = lq.a(NotificationsFragment.b(a));
                if (!flag) goto _L2; else goto _L1
_L1:
                compoundbutton.putBoolean(a.getResources().getString(0x7f08008b), true);
_L4:
                compoundbutton.putBoolean(a.getResources().getString(0x7f08008a), flag);
                compoundbutton.commit();
                a.a(flag);
                lq.a(NotificationsFragment.b(a), null);
                return;
_L2:
                compoundbutton.putBoolean(a.getResources().getString(0x7f08008b), false);
                ETException etexception;
                ETPush.pushManager().removeTag(a.getString(0x7f080388));
                String s;
                for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ETPush.pushManager().removeTag(s))
                {
                    s = (String)((Iterator) (obj)).next();
                }

                try
                {
                    lq.c(NotificationsFragment.b(a));
                }
                // Misplaced declaration of an exception variable
                catch (ETException etexception)
                {
                    etexception.printStackTrace();
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = NotificationsFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        ((BBYBaseFragmentActivity)c).showActionBarHome();
        ((BBYBaseFragmentActivity)c).updateActionBarTitle(f.T());
    }

    public void onResume()
    {
        super.onResume();
        String s = ((BBYBaseFragmentActivity)c).getCurrentActionBarTitle();
        if (!s.isEmpty())
        {
            f.i(s);
        }
        ((BBYBaseFragmentActivity)c).updateActionBarTitle("");
        ((BBYBaseFragmentActivity)c).hideActionBarHomeAndSearchBox(c);
    }
}
