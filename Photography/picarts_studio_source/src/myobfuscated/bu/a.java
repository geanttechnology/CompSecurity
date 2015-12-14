// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bu;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.facebook.login.LoginManager;
import com.socialin.android.activity.FragmentActionsListener;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.dialog.d;
import com.socialin.android.facebook.p;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.util.c;
import myobfuscated.f.m;

public class a extends d
{

    public p a;
    public String b[];
    private final String c = (new StringBuilder()).append(myobfuscated/bu/a.getSimpleName()).append("_").append(System.currentTimeMillis()).toString();
    private LinearLayout d;
    private View e;

    public a()
    {
        d = null;
        setRetainInstance(true);
    }

    static void a(a a1)
    {
        FacebookUtils.setSSOMode(false);
        FacebookUtils.singleSignOnFallbackLogin(a1.getActivity(), a1.b, a1.a);
        a1.dismiss();
    }

    static View b(a a1)
    {
        return a1.e;
    }

    static LinearLayout c(a a1)
    {
        return a1.d;
    }

    static p d(a a1)
    {
        return a1.a;
    }

    public void onActivityCreated(Bundle bundle)
    {
        String s = null;
        super.onActivityCreated(bundle);
        bundle = getActivity();
        Object obj = getView();
        if (bundle != null && obj != null)
        {
            m.b(((View) (obj))).setText(0x7f080265);
            d = (LinearLayout)((View) (obj)).findViewById(0x7f1004f3);
            e = ((View) (obj)).findViewById(0x7f1004f2);
            ((Button)((View) (obj)).findViewById(0x7f1004f4)).setOnClickListener(new android.view.View.OnClickListener() {

                private a a;

                public final void onClick(View view)
                {
                    LoginManager.getInstance().logOut();
                    FacebookUtils.setUserData(null);
                    FacebookUtils.clearPrefs();
                    a.a(a);
                }

            
            {
                a = a.this;
                super();
            }
            });
            bundle = getArguments();
            if (bundle != null)
            {
                s = bundle.getString("userId");
                bundle = bundle.getString("userDisplayName");
            } else
            {
                bundle = null;
            }
            obj = bundle;
            if (TextUtils.isEmpty(bundle))
            {
                if (SocialinV3.getInstance().getUserFbData() != null)
                {
                    obj = SocialinV3.getInstance().getUserFbData().name;
                } else
                {
                    obj = "";
                }
            }
            if (!TextUtils.isEmpty(s) && !s.equals("-1") && !TextUtils.isEmpty(((CharSequence) (obj))) && getActivity() != null && !getActivity().isFinishing() && getView() != null)
            {
                getActivity().runOnUiThread(new Runnable(((String) (obj)), s) {

                    final a a;
                    private String b;
                    private String c;

                    public final void run()
                    {
                        if (a.getActivity() == null || a.getActivity().isFinishing() || a.getView() == null)
                        {
                            return;
                        } else
                        {
                            a.b(a).setVisibility(8);
                            myobfuscated.bu.a.c(a).setVisibility(0);
                            a.getView().findViewById(0x7f100361).setVisibility(0);
                            myobfuscated.bu.a.c(a).removeAllViews();
                            Object obj1 = LayoutInflater.from(a.getActivity()).inflate(0x7f0300f3, myobfuscated.bu.a.c(a), false);
                            ((View) (obj1)).setClickable(true);
                            ((View) (obj1)).setOnClickListener(new android.view.View.OnClickListener(this) {

                                private _cls2 a;

                                public final void onClick(View view)
                                {
                                    try
                                    {
                                        if (SocialinV3.getInstance().isRegistered())
                                        {
                                            SocialinV3.getInstance().addFbConnection(FacebookUtils.getFbConnectionData());
                                        }
                                        FacebookUtils.setConnectionState(true);
                                        myobfuscated.bu.a.d(a.a).a();
                                        a.a.dismiss();
                                        return;
                                    }
                                    // Misplaced declaration of an exception variable
                                    catch (View view)
                                    {
                                        view.printStackTrace();
                                    }
                                }

            
            {
                a = _pcls2;
                super();
            }
                            });
                            myobfuscated.bu.a.c(a).addView(((View) (obj1)));
                            ((TextView)((View) (obj1)).findViewById(0x7f1004f1)).setText(b);
                            obj1 = (ImageView)((View) (obj1)).findViewById(0x7f1004f0);
                            String s1 = (new StringBuilder("https://graph.facebook.com/v2.4/")).append(c).append("/picture?type=square").toString();
                            com.socialin.android.d.b("FacebookAccountsDialog", new Object[] {
                                (new StringBuilder("user_img_url= ")).append(s1).toString()
                            });
                            (new com.picsart.studio.d(a.getActivity())).c(s1, ((ImageView) (obj1)), com.bumptech.glide.request.e.b(l.a));
                            return;
                        }
                    }

            
            {
                a = a.this;
                b = s;
                c = s1;
                super();
            }
                });
                return;
            }
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        dismiss();
        try
        {
            ((FragmentActionsListener)getActivity()).dismissFragmentProgressDialog();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            dialoginterface.printStackTrace();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(1, 0x7f0c0190);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0300f4, viewgroup, false);
    }

    public void onDestroy()
    {
        try
        {
            com.socialin.android.util.c.b(c);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        super.onDestroy();
    }

    public void onDestroyView()
    {
        if (getDialog() != null && getRetainInstance())
        {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    public void onDetach()
    {
        super.onDetach();
        getActivity().getIntent().putExtra("user_selected", true);
    }
}
