// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.invite;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import com.socialin.android.activity.BaseActivity;

// Referenced classes of package com.socialin.android.picsart.profile.invite:
//            h

public class InviteSocialsActivity extends BaseActivity
{

    public InviteSocialsActivity()
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        Object obj = getFragmentManager().findFragmentByTag("inviteShareFragment");
        if (obj != null)
        {
            obj = (h)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((h) (obj)).onActivityResult(i, j, intent);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030146);
        bundle = getFragmentManager().beginTransaction();
        Object obj = getFragmentManager().findFragmentByTag("inviteShareFragment");
        if (obj == null)
        {
            obj = new h();
            Bundle bundle1 = new Bundle();
            bundle1.putBoolean("isAdRemover", getIntent().getBooleanExtra("isAdRemover", false));
            ((Fragment) (obj)).setArguments(bundle1);
            bundle.add(0x7f1006b3, ((Fragment) (obj)), "inviteShareFragment");
        } else
        {
            bundle.show(((Fragment) (obj)));
        }
        bundle.commit();
    }
}
