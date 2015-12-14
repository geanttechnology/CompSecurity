// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.scrollAds;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.pipcamera.application.PIPCameraApplication;
import java.io.File;
import java.io.PrintStream;
import oa;
import ob;
import pb;

public class FragmentTwo extends Fragment
{

    ImageView a;

    public FragmentTwo()
    {
    }

    private void a()
    {
        try
        {
            FlurryAgent.logEvent("_ADBanner_clicked");
            oa oa1 = new oa(getActivity());
            oa1.a(new ob() {

                final FragmentTwo a;

                public void a()
                {
                    FragmentTwo.b(a);
                }

                public void a(File file)
                {
                    a.a(file);
                }

            
            {
                a = FragmentTwo.this;
                super();
            }
            });
            oa1.a();
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }

    static void a(FragmentTwo fragmenttwo)
    {
        fragmenttwo.a();
    }

    private void b()
    {
        String s;
        if (pb.a())
        {
            s = "http://ad.apps.fm/qZSXqUCiQ7TPNAInZbPxCq5px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9ER3LxReYnbzOvFQ_H2YFnatCMomOoKIF_7eP3wqROstQ";
        } else
        {
            s = "http://ad.apps.fm/SeSHiXfNF3n1YChnV23pr65px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9ER3LxReYnbzOvFQ_H2YFnarGegQRDGKF2qKHfUcvMNRc";
        }
        try
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }

    static void b(FragmentTwo fragmenttwo)
    {
        fragmenttwo.b();
    }

    public void a(File file)
    {
        try
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            Crashlytics.logException(file);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        System.out.println("FragmentTwo onCreate");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(0x7f03002e, viewgroup, false);
        a = (ImageView)viewgroup.findViewById(0x7f0c00e4);
        if (pb.a())
        {
            layoutinflater = "adRes/instamag_02_cn.jpg";
        } else
        {
            layoutinflater = "adRes/instamag_02_en.jpg";
        }
        layoutinflater = pb.b(PIPCameraApplication.a, layoutinflater);
        a.setImageBitmap(layoutinflater);
        a.setOnClickListener(new android.view.View.OnClickListener() {

            final FragmentTwo a;

            public void onClick(View view)
            {
                FragmentTwo.a(a);
            }

            
            {
                a = FragmentTwo.this;
                super();
            }
        });
        return viewgroup;
    }

    public void onPause()
    {
        super.onPause();
        System.out.println("FragmentTwo onPause");
    }

    public void onResume()
    {
        super.onResume();
        System.out.println("FragmentTwo onResume");
    }

    public void onStop()
    {
        super.onStop();
        System.out.println("FragmentTwo onStop");
    }
}
