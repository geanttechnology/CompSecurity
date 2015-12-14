// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.UpdateUserController;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.UpdateUserParams;
import com.socialin.android.dialog.d;
import com.socialin.android.picsart.profile.activity.LoginFragmentActivity;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import com.socialin.asyncnet.b;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            bn

public class bm extends d
{

    private static final String a = com/socialin/android/picsart/profile/fragment/bm.getSimpleName();
    private UpdateUserController b;
    private UpdateUserParams c;
    private Button d;
    private Button e;

    public bm()
    {
        b = new UpdateUserController();
        c = new UpdateUserParams();
    }

    static String a()
    {
        return a;
    }

    static void a(bm bm1)
    {
        bm1.b();
    }

    static Button b(bm bm1)
    {
        return bm1.d;
    }

    private void b()
    {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing() && getView() != null)
        {
            if (!s.a(activity))
            {
                y.a(activity);
                return;
            }
            Object obj = getActivity();
            boolean flag;
            if (obj == null || ((Activity) (obj)).isFinishing())
            {
                flag = false;
            } else
            if (SocialinV3.getInstance().getUser() == null || SocialinV3.getInstance().getUser().id < 0L || !SocialinV3.getInstance().isRegistered())
            {
                com.socialin.android.d.b(com/socialin/android/picsart/profile/fragment/bm.getName(), "User is not registered!");
                Intent intent = ((Activity) (obj)).getIntent();
                intent.setClassName(((Activity) (obj)).getPackageName(), com/socialin/android/picsart/profile/activity/LoginFragmentActivity.getName());
                intent.setFlags(0x20000);
                intent.putExtra("from", "UserEmailEdit");
                startActivityForResult(intent, 1003);
                flag = false;
            } else
            {
                flag = true;
            }
            if (flag)
            {
                obj = ((EditText)getView().findViewById(0x7f100a0d)).getText().toString().toLowerCase().trim();
                if (((String) (obj)).equals("") || obj == null)
                {
                    Utils.c(activity, activity.getResources().getString(0x7f080236));
                    return;
                }
                if (d != null)
                {
                    d.setClickable(false);
                }
                c.email = ((String) (obj));
                b.doRequest(a, c);
                return;
            }
        }
    }

    static UpdateUserParams c(bm bm1)
    {
        return bm1.c;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getActivity();
        View view = getView();
        if (bundle == null || view == null)
        {
            return;
        } else
        {
            b.setRequestCompleteListener(new bn(this));
            ((TextView)view.findViewById(0x7f100a0d)).setText(SocialinV3.getInstance().getUser().email);
            view.findViewById(0x7f100a0e).setOnClickListener(new _cls1());
            d = (Button)view.findViewById(0x7f100a0f);
            d.setOnClickListener(new _cls2());
            e = (Button)view.findViewById(0x7f100a0e);
            e.setOnClickListener(new _cls3(bundle));
            return;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j != -1) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 1003 1003: default 32
    //                   1003 33;
           goto _L2 _L3
_L2:
        return;
_L3:
        b();
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(1, 0x7f0c0190);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030227, viewgroup, false);
        m.b(layoutinflater).setText(0x7f080536);
        return layoutinflater;
    }

    public void onDestroy()
    {
        com.socialin.asyncnet.b.a().a(a);
        if (b != null)
        {
            b.setRequestCompleteListener(null);
        }
        super.onDestroy();
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}

}
