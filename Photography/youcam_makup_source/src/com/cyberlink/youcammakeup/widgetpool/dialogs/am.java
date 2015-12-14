// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.FacebookSharingActivity;
import com.cyberlink.youcammakeup.activity.WeiboSharingActivity;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.cc;
import com.cyberlink.youcammakeup.utility.o;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            an

public class am extends an
{

    private View e;
    private View f;
    private View g;

    public am(MakeupItemMetadata makeupitemmetadata)
    {
        super(makeupitemmetadata);
    }

    View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030195, viewgroup);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        e = getView().findViewById(0x7f0c071c);
        e.setOnClickListener(new android.view.View.OnClickListener() {

            final am a;

            public void onClick(View view)
            {
                cc.a(a.d.u());
                view = new ArrayList();
                view.add(Globals.d().B());
                Globals.d().a(view);
                view = new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/FacebookSharingActivity);
                view.putExtra("unlock_key_id", a.d.u());
                a.startActivity(view);
                a.dismiss();
            }

            
            {
                a = am.this;
                super();
            }
        });
        f = getView().findViewById(0x7f0c071d);
        f.setOnClickListener(new android.view.View.OnClickListener() {

            final am a;

            public void onClick(View view)
            {
                if (al.a("com.sina.weibo"))
                {
                    cc.a(a.d.u());
                    view = new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/WeiboSharingActivity);
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("mimeType", "image/*");
                    bundle1.putString("url", Globals.d().B().getPath());
                    bundle1.putString("unlock_key_id", a.d.u());
                    view.putExtras(bundle1);
                    a.startActivity(view);
                    a.dismiss();
                    return;
                } else
                {
                    view = Globals.d().i();
                    String s = a.getActivity().getString(0x7f070069);
                    view.a(a.getActivity(), null, s, false);
                    return;
                }
            }

            
            {
                a = am.this;
                super();
            }
        });
        g = getView().findViewById(0x7f0c071e);
        g.setOnClickListener(new android.view.View.OnClickListener() {

            final am a;

            public void onClick(View view)
            {
                if (al.a("com.tencent.mm"))
                {
                    cc.a(a.d.u());
                    view = new ArrayList();
                    view.add(Globals.d().B());
                    ShareActionProvider.a(a.getActivity(), view, false);
                    if (a.d.u() != null)
                    {
                        cc.c(a.d.u());
                    }
                    a.dismiss();
                    return;
                } else
                {
                    view = Globals.d().i();
                    String s = a.getActivity().getString(0x7f070068);
                    view.a(a.getActivity(), null, s, false);
                    return;
                }
            }

            
            {
                a = am.this;
                super();
            }
        });
    }
}
