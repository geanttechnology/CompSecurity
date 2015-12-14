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

public class FragmentOne extends Fragment
{

    private static String b = "FragmentOne";
    ImageView a;

    public FragmentOne()
    {
    }

    private void a()
    {
        try
        {
            FlurryAgent.logEvent("FragmentONE");
            oa oa1 = new oa(getActivity());
            oa1.a(new ob() {

                final FragmentOne a;

                public void a()
                {
                    FragmentOne.b(a);
                }

                public void a(File file)
                {
                    a.a(file);
                }

            
            {
                a = FragmentOne.this;
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

    static void a(FragmentOne fragmentone)
    {
        fragmentone.a();
    }

    private void b()
    {
        FlurryAgent.logEvent("_ADBanner_clicked");
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
        return;
    }

    static void b(FragmentOne fragmentone)
    {
        fragmentone.b();
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
        System.out.println("FragmentOne onCreate");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(0x7f03002e, viewgroup, false);
        a = (ImageView)viewgroup.findViewById(0x7f0c00e4);
        if (pb.a())
        {
            layoutinflater = "adRes/instamag_01_cn.jpg";
        } else
        {
            layoutinflater = "adRes/instamag_01_en.jpg";
        }
        layoutinflater = pb.b(PIPCameraApplication.a, layoutinflater);
        a.setImageBitmap(layoutinflater);
        a.setOnClickListener(new android.view.View.OnClickListener() {

            final FragmentOne a;

            public void onClick(View view)
            {
                FragmentOne.a(a);
            }

            
            {
                a = FragmentOne.this;
                super();
            }
        });
        return viewgroup;
    }

    public void onPause()
    {
        super.onPause();
        System.out.println("FragmentOne onPause");
    }

    public void onResume()
    {
        super.onResume();
        System.out.println("FragmentOne onResume");
    }

    public void onStop()
    {
        super.onStop();
        System.out.println("FragmentOne onStop");
    }

}
