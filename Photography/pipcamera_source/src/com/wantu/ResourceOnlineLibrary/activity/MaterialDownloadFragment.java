// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.ImageCache;
import com.wantu.model.res.TResInfo;
import fo;
import fr;
import gb;
import sb;
import tu;
import ud;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.activity:
//            MainResourceActivity

public class MaterialDownloadFragment extends Fragment
{

    public static String a = "SaveInstaceString_rid";
    public static String b = "SaveInstaceString_previewUrl";
    public static String c = "SaveInstaceString_otherAppId";
    public static String d = "SaveInstaceString_needReviewing";
    static int e = 1558;
    private String f;
    private ImageView g;
    private ImageView h;
    private Button i;
    private ud j;
    private tu k;
    private TResInfo l;
    private MainResourceActivity m;
    private ProgressBar n;

    public MaterialDownloadFragment()
    {
        f = "MaterialDownloadFragment";
    }

    public static MaterialDownloadFragment a(tu tu1, TResInfo tresinfo)
    {
        MaterialDownloadFragment materialdownloadfragment = new MaterialDownloadFragment();
        materialdownloadfragment.k = tu1;
        materialdownloadfragment.l = tresinfo;
        return materialdownloadfragment;
    }

    private ud a()
    {
        if (j == null)
        {
            fo fo1 = new fo(getActivity().getApplicationContext(), ImageCache.b);
            fo1.a(0.05F);
            fo1.g = true;
            j = new ud(getActivity(), 320);
            j.a(getActivity().getSupportFragmentManager(), fo1);
        }
        return j;
    }

    static void a(MaterialDownloadFragment materialdownloadfragment)
    {
        materialdownloadfragment.b();
    }

    public static boolean a(Context context, String s)
    {
        if (s != null)
        {
            try
            {
                context = context.getPackageManager().getPackageInfo(s, 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                context = null;
            }
            if (context != null)
            {
                return true;
            }
        }
        return false;
    }

    static MainResourceActivity b(MaterialDownloadFragment materialdownloadfragment)
    {
        return materialdownloadfragment.m;
    }

    private void b()
    {
        if (k == null || l == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        if (!l.needReviewing || sb.c() || !a(m, "com.android.vending"))
        {
            break MISSING_BLOCK_LABEL_182;
        }
        Log.v(f, (new StringBuilder()).append(f).append(" installed google play store , reviewing").toString());
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(m);
        builder.setTitle(m.getResources().getString(0x7f060277));
        builder.setMessage(m.getResources().getString(0x7f0600f3));
        builder.setPositiveButton(m.getResources().getString(0x7f060283), new android.content.DialogInterface.OnClickListener() {

            final MaterialDownloadFragment a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                try
                {
                    dialoginterface = MaterialDownloadFragment.b(a).getPackageName();
                    MaterialDownloadFragment.b(a).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(dialoginterface).toString())));
                    sb.b();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    Crashlytics.logException(dialoginterface);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    Crashlytics.logException(dialoginterface);
                }
            }

            
            {
                a = MaterialDownloadFragment.this;
                super();
            }
        });
        builder.setNegativeButton(m.getResources().getString(0x7f060033), new android.content.DialogInterface.OnClickListener() {

            final MaterialDownloadFragment a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
            }

            
            {
                a = MaterialDownloadFragment.this;
                super();
            }
        });
        builder.create().show();
        return;
        Exception exception;
        exception;
        Crashlytics.logException(exception);
        return;
        if (l.otherAppStoreId != null && !l.otherAppStoreId.equalsIgnoreCase("null") && l.otherAppStoreId.length() > 0 && !a(m, l.otherAppStoreId))
        {
            Log.v(f, (new StringBuilder()).append(f).append(" google play stroe package name:").append("com.android.vending").toString());
            Log.v(f, (new StringBuilder()).append(f).append(" otherAppStoreId name:").append(l.otherAppStoreId).toString());
            if ("com.android.vending" != null && a(m, "com.android.vending") || a(m, "com.qihoo.appstore"))
            {
                Log.v(f, (new StringBuilder()).append(f).append(" installed google play store , down other App").toString());
                android.app.AlertDialog.Builder builder1 = new android.app.AlertDialog.Builder(m);
                builder1.setTitle(m.getResources().getString(0x7f060277));
                builder1.setMessage(m.getResources().getString(0x7f0600d5));
                builder1.setPositiveButton(m.getResources().getString(0x7f0600d8), new android.content.DialogInterface.OnClickListener() {

                    final MaterialDownloadFragment a;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                        try
                        {
                            MaterialDownloadFragment.b(a).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(MaterialDownloadFragment.c(a).otherAppStoreId).toString())));
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (DialogInterface dialoginterface)
                        {
                            Crashlytics.logException(dialoginterface);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (DialogInterface dialoginterface)
                        {
                            Crashlytics.logException(dialoginterface);
                        }
                    }

            
            {
                a = MaterialDownloadFragment.this;
                super();
            }
                });
                builder1.setNegativeButton(m.getResources().getString(0x7f060033), new android.content.DialogInterface.OnClickListener() {

                    final MaterialDownloadFragment a;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                    }

            
            {
                a = MaterialDownloadFragment.this;
                super();
            }
                });
                builder1.create().show();
                return;
            }
            Log.v(f, (new StringBuilder()).append(f).append(" not installed  google play store or 360").toString());
        }
        if (m != null)
        {
            m.a(m.getResources().getString(0x7f0600da), e);
        }
        k.downloadRes(l);
        i.setEnabled(false);
        g.setBackgroundColor(0x106000b);
        n.setVisibility(4);
        return;
    }

    static TResInfo c(MaterialDownloadFragment materialdownloadfragment)
    {
        return materialdownloadfragment.l;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        j = a();
        j.a(l, g);
        if (android/view/View$OnClickListener.isInstance(getActivity()) && gb.c())
        {
            g.setOnClickListener((android.view.View.OnClickListener)getActivity());
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        m = (MainResourceActivity)activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            if (l == null)
            {
                l = new TResInfo();
            }
            l.resId = bundle.getInt(a);
            l.previewUrl = bundle.getString(b);
            l.otherAppStoreId = bundle.getString(c);
            l.needReviewing = bundle.getBoolean(d);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        boolean flag1 = true;
        boolean flag = false;
        layoutinflater = layoutinflater.inflate(0x7f03005c, viewgroup, false);
        n = (ProgressBar)layoutinflater.findViewById(0x7f0c007c);
        viewgroup = getResources().getDisplayMetrics();
        float f1 = (float)((DisplayMetrics) (viewgroup)).widthPixels - ((DisplayMetrics) (viewgroup)).density * 10F;
        viewgroup = (FrameLayout)layoutinflater.findViewById(0x7f0c0194);
        bundle = (android.widget.FrameLayout.LayoutParams)viewgroup.getLayoutParams();
        bundle.width = (int)f1;
        bundle.height = (int)f1;
        viewgroup.setLayoutParams(bundle);
        g = (ImageView)layoutinflater.findViewById(0x7f0c013b);
        g.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        h = (ImageView)layoutinflater.findViewById(0x7f0c0195);
        int i1;
        boolean flag2;
        if (l.needReviewing && !sb.c())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        flag2 = a(m, "com.android.vending");
        if (i1 != 0 && flag2)
        {
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        viewgroup = h;
        if (i1 != 0)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 4;
        }
        viewgroup.setVisibility(i1);
        i = (Button)layoutinflater.findViewById(0x7f0c0196);
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final MaterialDownloadFragment a;

            public void onClick(View view)
            {
                MaterialDownloadFragment.a(a);
            }

            
            {
                a = MaterialDownloadFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (g != null)
        {
            fr.a(g);
            g.setImageDrawable(null);
        }
    }

    public void onPause()
    {
        super.onPause();
        if (j != null)
        {
            j.a(true);
        }
    }

    public void onResume()
    {
        super.onResume();
        if (j != null)
        {
            j.a(false);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (l == null)
        {
            return;
        } else
        {
            bundle.putInt(a, l.resId);
            bundle.putString(b, l.previewUrl);
            bundle.putString(c, l.otherAppStoreId);
            bundle.putBoolean(d, l.needReviewing);
            return;
        }
    }

}
