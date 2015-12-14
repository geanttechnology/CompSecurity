// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.controller.activity.RegisterActivity;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.utility.cc;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            an

public class p extends an
{

    public p(MakeupItemMetadata makeupitemmetadata)
    {
        super(makeupitemmetadata);
    }

    private void a(int i)
    {
        cc.a(d.u());
        Intent intent = new Intent();
        intent.setClass(getActivity(), com/cyberlink/beautycircle/controller/activity/RegisterActivity);
        intent.putExtra("SignInMode", i);
        intent.putExtra("ReDirectMode", 0);
        intent.putExtra("EditProfileMode", 5);
        startActivityForResult(intent, 48144);
    }

    static void a(p p1, int i)
    {
        p1.a(i);
    }

    View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030150, viewgroup);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        getView().findViewById(0x7f0c0605).setOnClickListener(new android.view.View.OnClickListener() {

            final p a;

            public void onClick(View view)
            {
                p.a(a, 1);
            }

            
            {
                a = p.this;
                super();
            }
        });
        getView().findViewById(0x7f0c0606).setOnClickListener(new android.view.View.OnClickListener() {

            final p a;

            public void onClick(View view)
            {
                p.a(a, 2);
            }

            
            {
                a = p.this;
                super();
            }
        });
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        switch (i)
        {
        default:
            return;

        case 48144: 
            break;
        }
        if (cc.a(com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata.UnlockMethod.b))
        {
            cc.c(d.u());
        }
        dismiss();
    }
}
