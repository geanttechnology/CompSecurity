// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.mybby.MyBBYHomeActivity;
import com.bestbuy.android.activities.registry.EmptyWeddingRegistryContainer;
import com.bestbuy.android.api.lib.models.registry.Entity;
import com.bestbuy.android.api.lib.models.registry.LoggedInUserProfile;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;
import fr;
import io;
import java.text.NumberFormat;
import java.util.List;
import kf;
import mr;
import nb;
import nf;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeActivity

public class MyBBYHomeCard extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private static final String a = com/bestbuy/android/activities/home/MyBBYHomeCard.getSimpleName();
    private mr b;
    private RelativeLayout c;
    private RelativeLayout g;
    private BBYTextView h;
    private BBYTextView i;
    private nb j;
    private ImageView k;
    private View l;
    private RelativeLayout m;
    private View n;

    public MyBBYHomeCard()
    {
        b = null;
    }

    static BBYTextView a(MyBBYHomeCard mybbyhomecard)
    {
        return mybbyhomecard.h;
    }

    private String a(String s)
    {
        String s1;
        try
        {
            s1 = NumberFormat.getInstance().format(Long.parseLong(s));
            kf.b(a, (new StringBuilder()).append("addDelimiters() formatedString=").append(s1).toString());
        }
        catch (Exception exception)
        {
            kf.e(a, (new StringBuilder()).append("addDelimiters() e=").append(exception).toString());
            return s;
        }
        return s1;
    }

    public void a(LoggedInUserProfile loggedinuserprofile)
    {
label0:
        {
            {
                Object obj;
label1:
                {
                    if (j != null)
                    {
                        j.o(false);
                    }
                    String s;
                    String s1;
                    int j1;
                    if (loggedinuserprofile == null)
                    {
                        obj = fr.h();
                    } else
                    {
                        obj = ((Entity)loggedinuserprofile.getEntities().get(0)).getPointsBalance();
                    }
                    s1 = fr.e();
                    if (s1 == null || s1.isEmpty())
                    {
                        break label0;
                    }
                    g.setVisibility(0);
                    c.setVisibility(8);
                    s = s1;
                    if (s1 != null)
                    {
                        s = s1;
                        if (!s1.isEmpty())
                        {
                            s = s1.toLowerCase();
                            s = (new StringBuilder()).append(Character.toString(s.charAt(0)).toUpperCase()).append(s.substring(1)).toString();
                        }
                    }
                    h.setText(s);
                    if (s != null && s.length() > 25)
                    {
                        h.setSingleLine();
                        h.setEllipsize(android.text.TextUtils.TruncateAt.END);
                        h.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                            final MyBBYHomeCard a;

                            public void onGlobalLayout()
                            {
                                MyBBYHomeCard.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                                if (MyBBYHomeCard.a(a).getLineCount() > 0)
                                {
                                    int k1 = MyBBYHomeCard.a(a).getLayout().getLineEnd(0);
                                    String s2 = (new StringBuilder()).append(MyBBYHomeCard.a(a).getText().subSequence(0, k1 - (k1 - 25))).append("...").toString();
                                    MyBBYHomeCard.a(a).setText(s2);
                                }
                            }

            
            {
                a = MyBBYHomeCard.this;
                super();
            }
                        });
                    } else
                    {
                        h.setText(s);
                        h.setSingleLine();
                        h.setEllipsize(android.text.TextUtils.TruncateAt.END);
                    }
                    if (obj != null)
                    {
                        s1 = ((String) (obj));
                        if (!((String) (obj)).isEmpty())
                        {
                            break label1;
                        }
                    }
                    s1 = "0";
                }
                j1 = nf.b(d);
                if (!fr.l())
                {
                    obj = (new StringBuilder()).append(a(s1)).append(" Points").toString();
                    int i1;
                    if (s != null && obj != null)
                    {
                        i1 = s.length() + ((String) (obj)).length() + 1;
                    } else
                    {
                        i1 = 0;
                    }
                    i = new BBYTextView(d);
                    if (((String) (obj)).length() > 10)
                    {
                        i.setTextSize(2, 15F);
                    }
                    if (((String) (obj)).length() > 12)
                    {
                        i.setTextSize(2, 14F);
                    }
                    i.setText(((String) (obj)));
                    i.setTextColor(-1);
                    obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                    if (j1 < 748 && i1 > 23 || s != null && j1 >= 748 && s.length() > 20)
                    {
                        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(3, h.getId());
                    } else
                    {
                        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(1, h.getId());
                    }
                    ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(nf.b(10F, d), 0, 0, 0);
                    ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(15);
                    g.addView(i, ((android.view.ViewGroup.LayoutParams) (obj)));
                }
                obj = fr.j();
                if (obj != null && ((String) (obj)).equals("10150"))
                {
                    k.setImageResource(0x7f02012d);
                } else
                if (obj != null && ((String) (obj)).equals("10067"))
                {
                    k.setImageResource(0x7f02012c);
                } else
                if (obj != null && ((String) (obj)).equals("10130"))
                {
                    k.setImageResource(0x7f02012a);
                }
                if (Boolean.valueOf(fr.g()).booleanValue() && fr.k() != null && !fr.k().isEmpty())
                {
                    m.setVisibility(0);
                    ((BBYTextView)m.findViewById(0x7f0c012a)).setText(fr.k());
                }
            }
            if (loggedinuserprofile != null && (d instanceof HomeActivity))
            {
                ((HomeActivity)d).buildSideMenu();
            }
            return;
        }
        g.setVisibility(8);
        c.setVisibility(0);
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_494;
        }
    }

    public void b()
    {
        j.m(true);
        (new io(d, this, null, fr.d(), fr.b())).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public void onClick(View view)
    {
        if (view != n) goto _L2; else goto _L1
_L1:
        if (fr.b() != null && !fr.b().isEmpty()) goto _L4; else goto _L3
_L3:
        view = new Intent(d, com/bestbuy/android/activities/mybby/MyBBYHomeActivity);
        d.startActivityForResult(view, 7890);
        d.overridePendingTransition(0x7f04000e, 0x7f040005);
_L6:
        return;
_L4:
        if (fr.b() != null || !fr.b().isEmpty())
        {
            ((HomeActivity)getActivity()).openLeftNavigation();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (view == m)
        {
            view = new EmptyWeddingRegistryContainer();
            FragmentTransaction fragmenttransaction = ((HomeActivity)d).getSupportFragmentManager().beginTransaction();
            fragmenttransaction.add(0x7f0c0033, view, "EmptyWeddingRegistryContainer");
            fragmenttransaction.addToBackStack(null);
            fragmenttransaction.commit();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        j = nb.a();
        b = j.w();
        n = layoutinflater.inflate(0x7f030051, viewgroup, false);
        l = n.findViewById(0x7f0c0126);
        c = (RelativeLayout)n.findViewById(0x7f0c0123);
        g = (RelativeLayout)n.findViewById(0x7f0c0124);
        h = (BBYTextView)n.findViewById(0x7f0c0125);
        k = (ImageView)n.findViewById(0x7f0c0122);
        m = (RelativeLayout)n.findViewById(0x7f0c0127);
        n.setOnClickListener(this);
        m.setOnClickListener(this);
        return n;
    }

    public void onDetach()
    {
        super.onDetach();
        if (j != null)
        {
            j.o(true);
        }
    }

    public void onResume()
    {
        super.onResume();
        if (fr.b() != null && !fr.b().isEmpty())
        {
            mr mr1 = j.w();
            if (j.ac())
            {
                a(((LoggedInUserProfile) (null)));
                b();
                return;
            }
            if (mr1 != null)
            {
                a(mr1.a());
                return;
            } else
            {
                g.setVisibility(8);
                c.setVisibility(0);
                return;
            }
        } else
        {
            g.setVisibility(8);
            c.setVisibility(0);
            return;
        }
    }

}
