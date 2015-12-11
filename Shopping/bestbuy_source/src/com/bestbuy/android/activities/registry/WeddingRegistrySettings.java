// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import cg;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.registry.Recipient;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.api.lib.models.registry.WishListReqData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYTextView;
import ct;
import dd;
import fr;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import jc;
import jm;
import jp;
import jq;
import ju;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            MyEmptyWeddingRegistryList, WishListWithProductsFragment, EmptyWeddingRegistryContainer, WeddingAddressFragment, 
//            CreateWeddingRegistry, RegistryPrivacySetting

public class WeddingRegistrySettings extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private boolean A;
    private WishListReqData B;
    private String C;
    private RelativeLayout D;
    private BBYTextView E;
    private BBYTextView F;
    private int G;
    private boolean H;
    private boolean I;
    Recipient a;
    private BBYTextView b;
    private BBYTextView c;
    private BBYTextView g;
    private BBYTextView h;
    private RegistryWishList i;
    private RelativeLayout j;
    private String k;
    private EditText l;
    private EditText m;
    private EditText n;
    private EditText o;
    private Spinner p;
    private Bundle q;
    private ct r;
    private View s;
    private RelativeLayout t;
    private RelativeLayout u;
    private RelativeLayout v;
    private Calendar w;
    private android.app.DatePickerDialog.OnDateSetListener x;
    private WeddingRegistryData y;
    private Fragment z;

    public WeddingRegistrySettings()
    {
        B = new WishListReqData();
    }

    public WeddingRegistrySettings(RegistryWishList registrywishlist, Fragment fragment, boolean flag)
    {
        B = new WishListReqData();
        i = registrywishlist;
        z = fragment;
        H = flag;
    }

    static String a(WeddingRegistrySettings weddingregistrysettings, String s1)
    {
        weddingregistrysettings.k = s1;
        return s1;
    }

    static Calendar a(WeddingRegistrySettings weddingregistrysettings)
    {
        return weddingregistrysettings.w;
    }

    private void a(String s1)
    {
        w = Calendar.getInstance();
        try
        {
            s1 = (new SimpleDateFormat("MM/dd/yy")).parse(s1);
            s1 = TextUtils.split((new SimpleDateFormat("MM/dd/yyyy")).format(s1), "/");
            int i1 = Integer.parseInt(s1[0]);
            int j1 = Integer.parseInt(s1[1]);
            int k1 = Integer.parseInt(s1[2]);
            w.set(k1, i1 - 1, j1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
        }
    }

    public static boolean a(WeddingRegistrySettings weddingregistrysettings, boolean flag)
    {
        weddingregistrysettings.I = flag;
        return flag;
    }

    static BBYTextView b(WeddingRegistrySettings weddingregistrysettings)
    {
        return weddingregistrysettings.c;
    }

    static EditText c(WeddingRegistrySettings weddingregistrysettings)
    {
        return weddingregistrysettings.l;
    }

    static EditText d(WeddingRegistrySettings weddingregistrysettings)
    {
        return weddingregistrysettings.m;
    }

    private void d()
    {
        Object obj = new android.app.AlertDialog.Builder(d);
        ((android.app.AlertDialog.Builder) (obj)).setMessage(Html.fromHtml(d.getResources().getString(0x7f0802e6))).setCancelable(false).setNegativeButton(Html.fromHtml(d.getResources().getString(0x7f0800e9)), new android.content.DialogInterface.OnClickListener() {

            final WeddingRegistrySettings a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.dismiss();
            }

            
            {
                a = WeddingRegistrySettings.this;
                super();
            }
        }).setPositiveButton(Html.fromHtml(d.getResources().getString(0x7f0802e7)), new android.content.DialogInterface.OnClickListener() {

            final WeddingRegistrySettings a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                String s4 = WeddingRegistrySettings.b(a).getText().toString();
                String s5 = WeddingRegistrySettings.c(a).getText().toString();
                String s6 = WeddingRegistrySettings.d(a).getText().toString();
                String s2 = WeddingRegistrySettings.e(a).getText().toString();
                String s3 = WeddingRegistrySettings.f(a).getText().toString();
                String s1 = WeddingRegistrySettings.g(a).getSelectedItem().toString();
                dialoginterface = s1;
                if (s1.length() > 0)
                {
                    dialoginterface = s1.substring(0, 2);
                }
                WeddingRegistrySettings.h(a).setEventDate(s4);
                WeddingRegistrySettings.h(a).setRegistryName(s5);
                WeddingRegistrySettings.h(a).setAddDescription(s6);
                s1 = s2;
                if (s2 != null)
                {
                    String as[] = s2.split(", ");
                    s1 = s2;
                    if (as.length > 1)
                    {
                        s1 = as[0];
                    }
                }
                WeddingRegistrySettings.h(a).setEventLocation(s1);
                WeddingRegistrySettings.h(a).setEventCity(s3);
                WeddingRegistrySettings.h(a).setEventState(dialoginterface);
                WeddingRegistrySettings.a(a, WeddingRegistrySettings.i(a).getUuid());
                if (WeddingRegistrySettings.j(a) == null || WeddingRegistrySettings.j(a).isEmpty())
                {
                    dialoginterface = a.d.getSharedPreferences("sharedPrefs", 0);
                    WeddingRegistrySettings.a(a, dialoginterface.getString("LIST_UUID", ""));
                }
                WeddingRegistrySettings.h(a).setUuid(WeddingRegistrySettings.j(a));
                WeddingRegistrySettings.h(a).setListType("weddingregistrylists");
                if (WeddingRegistrySettings.k(a).getText().toString().contains("BestBuy.com, Best Buy Stores"))
                {
                    dialoginterface = "public";
                } else
                {
                    dialoginterface = "private";
                }
                WeddingRegistrySettings.h(a).setPrivacySetting(dialoginterface);
                if (!WeddingRegistrySettings.k(a).getText().toString().equals("BestBuy.com, Best Buy Stores, TheKnot.com")) goto _L2; else goto _L1
_L1:
                WeddingRegistrySettings.h(a).setTheKnot(true);
                WeddingRegistrySettings.h(a).setMyregistry(false);
_L4:
                if (a.a != null)
                {
                    WeddingRegistrySettings.h(a).setFirstName(a.a.getFirstName());
                    WeddingRegistrySettings.h(a).setLastName(a.a.getLastName());
                }
                if (WeddingRegistrySettings.i(a) != null)
                {
                    WeddingRegistrySettings.h(a).setCoregistrantFirstName(WeddingRegistrySettings.i(a).getCoRegistrantFirstName());
                    WeddingRegistrySettings.h(a).setCoregistrantLastName(WeddingRegistrySettings.i(a).getCoRegistrantLastName());
                }
                (new jq(a.d, a, WeddingRegistrySettings.l(a), WeddingRegistrySettings.h(a))).executeOnExecutor(nb.g, new Void[0]);
                return;
_L2:
                if (WeddingRegistrySettings.k(a).getText().toString().equals("BestBuy.com, Best Buy Stores, MyRegistry.com"))
                {
                    WeddingRegistrySettings.h(a).setTheKnot(false);
                    WeddingRegistrySettings.h(a).setMyregistry(true);
                } else
                if (WeddingRegistrySettings.k(a).getText().toString().equals("BestBuy.com, Best Buy Stores, TheKnot.com, MyRegistry.com"))
                {
                    WeddingRegistrySettings.h(a).setTheKnot(true);
                    WeddingRegistrySettings.h(a).setMyregistry(true);
                } else
                if (WeddingRegistrySettings.k(a).getText().toString().equals("BestBuy.com, Best Buy Stores"))
                {
                    WeddingRegistrySettings.h(a).setTheKnot(false);
                    WeddingRegistrySettings.h(a).setMyregistry(false);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = WeddingRegistrySettings.this;
                super();
            }
        });
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        ((AlertDialog) (obj)).show();
        ((TextView)((AlertDialog) (obj)).findViewById(0x102000b)).setGravity(17);
    }

    static EditText e(WeddingRegistrySettings weddingregistrysettings)
    {
        return weddingregistrysettings.n;
    }

    private void e()
    {
label0:
        {
            a = i.getRecipient();
            if (y != null)
            {
                String s1 = y.getFirstName();
                String s3 = y.getLastName();
                String s4 = y.getCoregistrantFirstName();
                String s5 = y.getCoregistrantLastName();
                String s6 = y.getPrivacySetting();
                F.setVisibility(0);
                String s7;
                String s8;
                String s9;
                String s10;
                String s11;
                String s12;
                String s13;
                String s14;
                String s15;
                String s16;
                String s17;
                String s18;
                if (s6 != null && s6.equals("public") && y.isTheKnot() && !y.isMyregistry())
                {
                    E.setText("BestBuy.com, Best Buy Stores, TheKnot.com");
                } else
                if (s6 != null && s6.equals("public") && !y.isTheKnot() && y.isMyregistry())
                {
                    E.setText("BestBuy.com, Best Buy Stores, MyRegistry.com");
                } else
                if (s6 != null && s6.equals("public") && y.isTheKnot() && y.isMyregistry())
                {
                    E.setText("BestBuy.com, Best Buy Stores, TheKnot.com, MyRegistry.com");
                } else
                if (s6 != null && s6.equals("public") && !y.isTheKnot() && !y.isMyregistry())
                {
                    E.setText("BestBuy.com, Best Buy Stores");
                } else
                if (s6 != null && s6.equals("private") && y.isTheKnot() && !y.isMyregistry())
                {
                    E.setText("TheKnot.com");
                } else
                if (s6 != null && s6.equals("private") && !y.isTheKnot() && y.isMyregistry())
                {
                    E.setText("MyRegistry.com");
                } else
                if (s6 != null && s6.equals("private") && y.isTheKnot() && y.isMyregistry())
                {
                    E.setText("TheKnot.com, MyRegistry.com");
                } else
                if (s6 != null && s6.equals("private") && !y.isTheKnot() && !y.isMyregistry())
                {
                    E.setText("Private Registry");
                    F.setVisibility(8);
                }
                C = s6;
                s12 = y.getEventDate();
                a(s12);
                s13 = l.getText().toString();
                s14 = m.getText().toString();
                s15 = n.getText().toString();
                s16 = y.getAddressFirstName();
                s17 = y.getAddressLastName();
                s6 = y.getAddressLine1();
                s7 = y.getAddressLine2();
                s8 = y.getZipCode();
                s9 = y.getState();
                s10 = y.getCity();
                s11 = y.getPhone();
                s18 = E.getText().toString();
                if (s18 != null && !s18.isEmpty())
                {
                    i.setPrivacySetting(y.getPrivacySetting());
                    i.setTheKnot(y.isTheKnot());
                    i.setMyRegistry(y.isMyregistry());
                }
                if (s12 != null && !s12.isEmpty())
                {
                    c.setText(s12);
                } else
                {
                    c.setText(i.getOccasionDate());
                }
                if (s13 != null && !s13.isEmpty())
                {
                    l.setText(s13);
                    l.setHint(s13);
                } else
                {
                    l.setText(y.getAddDescription());
                    l.setHint(y.getAddDescription());
                }
                if (s1 != null && !s1.isEmpty() && s3 != null && !s3.isEmpty() && s4 != null && !s4.isEmpty() && s5 != null && !s5.isEmpty())
                {
                    b.setText((new StringBuilder()).append(s1).append(" ").append(s3).append(" & ").append(s4).append(" ").append(s5).toString());
                    y.setFirstName(s1);
                    y.setLastName(s3);
                    y.setCoregistrantFirstName(s4);
                    y.setCoregistrantLastName(s5);
                    i.setFirstName(s1);
                    i.setLastName(s3);
                    i.setCoRegistrantFirstName(s4);
                    i.setCoRegistrantLastName(s5);
                } else
                {
                    b.setText((new StringBuilder()).append(a.getFirstName()).append(" ").append(a.getLastName()).append(" & ").append(i.getCoRegistrantFirstName()).append(" ").append(i.getCoRegistrantLastName()).toString());
                    y.setFirstName(a.getFirstName());
                    y.setLastName(a.getLastName());
                    y.setCoregistrantFirstName(i.getCoRegistrantFirstName());
                    y.setCoregistrantLastName(i.getCoRegistrantLastName());
                }
                if (s14 != null && !s14.isEmpty())
                {
                    m.setText(s14);
                } else
                {
                    m.setText(y.getPersonalized_message());
                }
                if (s15 != null && !s15.isEmpty())
                {
                    n.setText(s15);
                } else
                {
                    n.setText(y.getEventLocation());
                }
                if (s16 != null && !s16.isEmpty() && s17 != null && !s17.isEmpty())
                {
                    g.setText((new StringBuilder()).append(s16).append(" ").append(s17).toString());
                    y.setAddressFirstName(s16);
                    y.setAddressLastName(s17);
                } else
                {
                    g.setText((new StringBuilder()).append(a.getFirstName()).append(" ").append(a.getLastName()).toString());
                    y.setAddressFirstName(a.getFirstName());
                    y.setAddressLastName(a.getLastName());
                }
                if (s6 == null || s6.isEmpty() || s10 == null || s10.isEmpty() || s9 == null || s9.isEmpty() || s8 == null || s8.isEmpty() || s11 == null || s11.isEmpty())
                {
                    break label0;
                }
                s1 = (new StringBuilder()).append("(").append(s11.substring(0, 3)).append(") ").append(s11.substring(3, 6)).append("-").append(s11.substring(6, 10)).toString();
                h.setText((new StringBuilder()).append(s6).append(s7).append("\n").append(s10).append(", ").append(s9).append(" ").append(s8).append("\n").append(s1).toString());
                y.setAddressLine1(s6);
                y.setAddressLine2(s7);
                y.setCity(s10);
                y.setState(s9);
                y.setZipCode(s8);
                y.setPhone(s11);
                a.setAddressLine1(s6);
                a.setAddressLine2(s7);
                a.setAddressCity(s10);
                a.setAddressState(s9);
                a.setAddressZip(s8);
                a.setPhoneNumber(s11);
                i.setRecipient(a);
            }
            return;
        }
        String s2 = a.getPhoneNumber();
        s2 = (new StringBuilder()).append("(").append(s2.substring(0, 3)).append(") ").append(s2.substring(3, 6)).append("-").append(s2.substring(6, 10)).toString();
        h.setText((new StringBuilder()).append(a.getAddressLine1()).append(", ").append(a.getAddressLine2()).append("\n").append(a.getAddressCity()).append(", ").append(a.getAddressState()).append(" ").append(a.getAddressZip()).append("\n").append(s2).toString());
        y.setAddressLine1(a.getAddressLine1());
        y.setAddressLine2(a.getAddressLine2());
        y.setCity(a.getAddressCity());
        y.setState(a.getAddressState());
        y.setZipCode(a.getAddressZip());
        y.setPhone(a.getPhoneNumber());
    }

    static EditText f(WeddingRegistrySettings weddingregistrysettings)
    {
        return weddingregistrysettings.o;
    }

    private void f()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(d);
        builder.setMessage(Html.fromHtml(d.getResources().getString(0x7f0800ba)));
        builder.setPositiveButton(Html.fromHtml(d.getResources().getString(0x7f080391)), new android.content.DialogInterface.OnClickListener() {

            final WeddingRegistrySettings a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.dismiss();
                if (WeddingRegistrySettings.i(a) != null)
                {
                    WeddingRegistrySettings.a(a, WeddingRegistrySettings.i(a).getUuid());
                    (new jc(a.d, a, WeddingRegistrySettings.l(a), "weddingregistrylists", WeddingRegistrySettings.j(a))).executeOnExecutor(nb.g, new Void[0]);
                    dialoginterface = new HashMap();
                    dialoginterface.put("Registry List Name", WeddingRegistrySettings.i(a).getShortDescription());
                    dialoginterface.put("Registry List Type", "weddingregistrylists");
                    dialoginterface.put("Registry List UUID", WeddingRegistrySettings.j(a));
                    lu.a(lu.at, dialoginterface);
                }
            }

            
            {
                a = WeddingRegistrySettings.this;
                super();
            }
        });
        builder.setNegativeButton(Html.fromHtml(d.getResources().getString(0x7f0800e9)), new android.content.DialogInterface.OnClickListener() {

            final WeddingRegistrySettings a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.dismiss();
            }

            
            {
                a = WeddingRegistrySettings.this;
                super();
            }
        });
        ((TextView)builder.show().findViewById(0x102000b)).setGravity(17);
    }

    static Spinner g(WeddingRegistrySettings weddingregistrysettings)
    {
        return weddingregistrysettings.p;
    }

    static WeddingRegistryData h(WeddingRegistrySettings weddingregistrysettings)
    {
        return weddingregistrysettings.y;
    }

    static RegistryWishList i(WeddingRegistrySettings weddingregistrysettings)
    {
        return weddingregistrysettings.i;
    }

    static String j(WeddingRegistrySettings weddingregistrysettings)
    {
        return weddingregistrysettings.k;
    }

    static BBYTextView k(WeddingRegistrySettings weddingregistrysettings)
    {
        return weddingregistrysettings.E;
    }

    static View l(WeddingRegistrySettings weddingregistrysettings)
    {
        return weddingregistrysettings.s;
    }

    public void a(Bundle bundle, WeddingRegistryData weddingregistrydata, boolean flag, int i1)
    {
        y = weddingregistrydata;
        q = bundle;
        A = true;
        if (flag)
        {
            B = b(weddingregistrydata);
            G = i1;
            (new jp(d, this, null, B)).executeOnExecutor(nb.h, new Void[0]);
        }
    }

    public void a(RegistryWishList registrywishlist)
    {
        i = registrywishlist;
        ((BBYBaseFragmentActivity)d).updateActionBarTitle("Registry Settings");
        if (registrywishlist == null) goto _L2; else goto _L1
_L1:
        String s2;
        String s4;
        String s5;
        a(registrywishlist.getOccasionDate());
        a = registrywishlist.getRecipient();
        C = registrywishlist.getPrivacySetting();
        c.setText(registrywishlist.getOccasionDate());
        if (a != null)
        {
            String s3 = a.getPhoneNumber();
            String s1 = s3;
            if (s3 != null)
            {
                s1 = s3;
                if (s3.length() > 10)
                {
                    s1 = (new StringBuilder()).append("(").append(s3.substring(0, 3)).append(") ").append(s3.substring(3, 6)).append("-").append(s3.substring(6, 10)).toString();
                }
            }
            b.setText((new StringBuilder()).append(a.getFirstName()).append(" ").append(a.getLastName()).append(" & ").append(registrywishlist.getCoRegistrantFirstName()).append(" ").append(registrywishlist.getCoRegistrantLastName()).toString());
            g.setText((new StringBuilder()).append(a.getFirstName()).append(" ").append(a.getLastName()).toString());
            h.setText((new StringBuilder()).append(a.getAddressLine1()).append(", ").append(a.getAddressLine2()).append("\n").append(a.getAddressCity()).append(", ").append(a.getAddressState()).append(" ").append(a.getAddressZip()).append("\n").append(s1).toString());
        }
        l.setText(registrywishlist.getShortDescription());
        l.setHint(registrywishlist.getShortDescription());
        m.setText(registrywishlist.getPersonalizedMessage());
        s2 = registrywishlist.getCity();
        s4 = registrywishlist.getState();
        s5 = registrywishlist.getLocation();
        if (s5 == null || s5.isEmpty()) goto _L4; else goto _L3
_L3:
        n.setText(s5);
        if (s5 != null)
        {
            String as1[] = s5.split(", ");
            if (as1.length > 1)
            {
                n.setText(as1[0]);
            }
        }
        if (s2 != null && !s2.isEmpty())
        {
            o.setText(s2);
        }
        if (s4 == null || s4.isEmpty()) goto _L4; else goto _L5
_L5:
        String as[];
        int i1;
        s2 = "";
        HashMap hashmap = ju.a();
        if (s4.length() > 0)
        {
            s4.trim();
            s2 = (String)hashmap.get(s4.substring(0, 2));
        }
        as = getResources().getStringArray(0x7f0a0000);
        i1 = 0;
_L13:
        if (i1 >= as.length) goto _L4; else goto _L6
_L6:
        if (!as[i1].equals(s2)) goto _L8; else goto _L7
_L7:
        p.setSelection(i1);
_L4:
        F.setVisibility(0);
        if (registrywishlist.getPrivacySetting() == null || !registrywishlist.getPrivacySetting().equals("public") || !registrywishlist.isTheKnot() || registrywishlist.isMyRegistry()) goto _L10; else goto _L9
_L9:
        E.setText("BestBuy.com, Best Buy Stores, TheKnot.com");
_L2:
        return;
_L8:
        i1++;
        continue; /* Loop/switch isn't completed */
_L10:
        if (registrywishlist.getPrivacySetting() != null && registrywishlist.getPrivacySetting().equals("public") && !registrywishlist.isTheKnot() && registrywishlist.isMyRegistry())
        {
            E.setText("BestBuy.com, Best Buy Stores, MyRegistry.com");
            return;
        }
        if (registrywishlist.getPrivacySetting() != null && registrywishlist.getPrivacySetting().equals("public") && registrywishlist.isTheKnot() && registrywishlist.isMyRegistry())
        {
            E.setText("BestBuy.com, Best Buy Stores, TheKnot.com, MyRegistry.com");
            return;
        }
        if (registrywishlist.getPrivacySetting() != null && registrywishlist.getPrivacySetting().equals("public") && !registrywishlist.isTheKnot() && !registrywishlist.isMyRegistry())
        {
            E.setText("BestBuy.com, Best Buy Stores");
            return;
        }
        if (registrywishlist.getPrivacySetting() != null && registrywishlist.getPrivacySetting().equals("private") && registrywishlist.isTheKnot() && !registrywishlist.isMyRegistry())
        {
            E.setText("TheKnot.com");
            return;
        }
        if (registrywishlist.getPrivacySetting() != null && registrywishlist.getPrivacySetting().equals("private") && !registrywishlist.isTheKnot() && registrywishlist.isMyRegistry())
        {
            E.setText("MyRegistry.com");
            return;
        }
        if (registrywishlist.getPrivacySetting() != null && registrywishlist.getPrivacySetting().equals("private") && registrywishlist.isTheKnot() && registrywishlist.isMyRegistry())
        {
            E.setText("TheKnot.com, MyRegistry.com");
            return;
        }
        if (registrywishlist.getPrivacySetting() == null || !registrywishlist.getPrivacySetting().equals("private") || registrywishlist.isTheKnot() || registrywishlist.isMyRegistry()) goto _L2; else goto _L11
_L11:
        F.setVisibility(8);
        E.setText("Private Registry");
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public void a(WeddingRegistryData weddingregistrydata)
    {
        f.c(true);
        ((BBYBaseFragmentActivity)d).updateActionBarTitle("");
        fr.b(weddingregistrydata.getRegistryName());
        ((HomeActivity)d).refreshHomeCard();
        if (!(z instanceof MyEmptyWeddingRegistryList)) goto _L2; else goto _L1
_L1:
        ((MyEmptyWeddingRegistryList)z).a(weddingregistrydata);
_L4:
        ((HomeActivity)d).onBackPressed();
        return;
_L2:
        if (z instanceof WishListWithProductsFragment)
        {
            ((WishListWithProductsFragment)z).a(weddingregistrydata);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public WishListReqData b(WeddingRegistryData weddingregistrydata)
    {
        B = new WishListReqData();
        B.setAddDescription(weddingregistrydata.getAddDescription());
        B.setAddressFirstName(weddingregistrydata.getAddressFirstName());
        B.setAddressLastName(weddingregistrydata.getAddressLastName());
        B.setAddressLine1(weddingregistrydata.getAddressLine1());
        B.setAddressLine2(weddingregistrydata.getAddressLine2());
        B.setCity(weddingregistrydata.getCity());
        B.setCoregistrantFirstName(weddingregistrydata.getCoregistrantFirstName());
        B.setCoregistrantLastName(weddingregistrydata.getCoregistrantLastName());
        B.setCreatedBy(weddingregistrydata.getCreatedBy());
        B.setEventDate(weddingregistrydata.getEventDate());
        B.setEventLocation(weddingregistrydata.getEventLocation());
        B.setFirstName(weddingregistrydata.getFirstName());
        B.setLastModifiedBy(weddingregistrydata.getLastModifiedBy());
        B.setLastName(weddingregistrydata.getLastName());
        B.setListType(i.getType());
        B.setModified(weddingregistrydata.getModified());
        B.setModifiedDetails(weddingregistrydata.getModifiedDetails());
        B.setEventDate(weddingregistrydata.getEventDate());
        B.setPersonalized_message(weddingregistrydata.getPersonalized_message());
        B.setPhone(weddingregistrydata.getPhone());
        B.setPrivacySetting(weddingregistrydata.getPrivacySetting());
        B.setRecepient(weddingregistrydata.getRecepient());
        B.setRecepientUuid(weddingregistrydata.getRecepientUuid());
        B.setRegistryName(weddingregistrydata.getRegistryName());
        B.setShippingAddress(weddingregistrydata.getShippingAddress());
        B.setState(weddingregistrydata.getState());
        B.setUuid(i.getUuid());
        B.setZipCode(weddingregistrydata.getZipCode());
        return B;
    }

    public void b()
    {
    }

    public void c()
    {
        BaseFragmentContainer basefragmentcontainer = (BaseFragmentContainer)getParentFragment();
        if (!H)
        {
            List list = basefragmentcontainer.getChildFragmentManager().getFragments();
            for (int i1 = list.size() - 1; i1 >= 0; i1--)
            {
                Fragment fragment = (Fragment)list.get(i1);
                if ((basefragmentcontainer instanceof BaseFragmentContainer) && fragment != null && !fragment.getTag().equals("MyRegistryDetailsFragment") && !fragment.getTag().equals("RegistryAndGiftsFragment") && !fragment.getTag().equals("HomeTabFragment"))
                {
                    ((HomeActivity)d).onBackPressed();
                }
            }

            if ((basefragmentcontainer instanceof EmptyWeddingRegistryContainer) && basefragmentcontainer.isVisible())
            {
                basefragmentcontainer.getFragmentManager().popBackStackImmediate();
            }
        } else
        {
            basefragmentcontainer.getFragmentManager().popBackStack();
        }
        fr.a(String.valueOf(false));
        fr.b("");
        ((HomeActivity)d).buildSideMenu();
        ((HomeActivity)d).refreshHomeCard();
    }

    public void g()
    {
        if (I)
        {
            d();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        if (A)
        {
            e();
            return;
        } else
        {
            k = i.getUuid();
            (new jm(d, this, s, k)).executeOnExecutor(nb.g, new Void[0]);
            return;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
        r = (ct)activity;
        r.onCreateMyEmptyRegistryFragmentLaunch();
    }

    public void onClick(View view)
    {
        if (view != u) goto _L2; else goto _L1
_L1:
        view = new WeddingAddressFragment(this, true, i);
        Fragment fragment = getParentFragment();
        if (fragment instanceof BaseFragmentContainer)
        {
            ((BaseFragmentContainer)fragment).a(view, true);
        }
_L4:
        return;
_L2:
        if (view != t)
        {
            break; /* Loop/switch isn't completed */
        }
        view = new CreateWeddingRegistry(this, true, i);
        Fragment fragment1 = getParentFragment();
        if (fragment1 instanceof BaseFragmentContainer)
        {
            ((BaseFragmentContainer)fragment1).a(view, true);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (view == v)
        {
            view = new DatePickerDialog(getActivity(), x, w.get(1), w.get(2), w.get(5));
            view.getDatePicker().setMinDate(System.currentTimeMillis() - 1000L);
            Calendar calendar = Calendar.getInstance();
            calendar.add(2, 18);
            view.getDatePicker().setMaxDate(calendar.getTimeInMillis());
            view.show();
            return;
        }
        if (view == j)
        {
            f();
            return;
        }
        if (view == D)
        {
            view = new RegistryPrivacySetting(this, true, i);
            Fragment fragment2 = getParentFragment();
            if (fragment2 instanceof BaseFragmentContainer)
            {
                ((BaseFragmentContainer)fragment2).a(view, true, "RegistryPrivacySetting");
                return;
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        y = new WeddingRegistryData();
        lu.a(lu.az);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030114, viewgroup, false);
        d.getWindow().setSoftInputMode(16);
        s = layoutinflater.findViewById(0x7f0c0064);
        b = (BBYTextView)layoutinflater.findViewById(0x7f0c03f6);
        g = (BBYTextView)layoutinflater.findViewById(0x7f0c03fb);
        h = (BBYTextView)layoutinflater.findViewById(0x7f0c03fc);
        t = (RelativeLayout)layoutinflater.findViewById(0x7f0c03f5);
        u = (RelativeLayout)layoutinflater.findViewById(0x7f0c03fa);
        v = (RelativeLayout)layoutinflater.findViewById(0x7f0c03f8);
        D = (RelativeLayout)layoutinflater.findViewById(0x7f0c03fd);
        E = (BBYTextView)layoutinflater.findViewById(0x7f0c03ff);
        F = (BBYTextView)layoutinflater.findViewById(0x7f0c03fe);
        D.setOnClickListener(this);
        u.setOnClickListener(this);
        t.setOnClickListener(this);
        v.setOnClickListener(this);
        n = (EditText)layoutinflater.findViewById(0x7f0c0371);
        o = (EditText)layoutinflater.findViewById(0x7f0c0374);
        p = (Spinner)layoutinflater.findViewById(0x7f0c0377);
        m = (EditText)layoutinflater.findViewById(0x7f0c0404);
        l = (EditText)layoutinflater.findViewById(0x7f0c012a);
        l.addTextChangedListener(new dd(this, l));
        c = (BBYTextView)layoutinflater.findViewById(0x7f0c03f9);
        x = new android.app.DatePickerDialog.OnDateSetListener() {

            final WeddingRegistrySettings a;

            private void a()
            {
                SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
                WeddingRegistrySettings.b(a).setText(simpledateformat.format(WeddingRegistrySettings.a(a).getTime()));
            }

            public void onDateSet(DatePicker datepicker, int i1, int j1, int k1)
            {
                WeddingRegistrySettings.a(a).set(1, i1);
                WeddingRegistrySettings.a(a).set(2, j1);
                WeddingRegistrySettings.a(a).set(5, k1);
                a();
            }

            
            {
                a = WeddingRegistrySettings.this;
                super();
            }
        };
        j = (RelativeLayout)layoutinflater.findViewById(0x7f0c040b);
        j.setOnClickListener(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        d.getWindow().setSoftInputMode(32);
        if (f.E().booleanValue())
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle(y.getRegistryName());
        }
    }

    public void onResume()
    {
        super.onResume();
        HomeActivity.inLifeEventsFragment = true;
        if (isVisible())
        {
            ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle("Registry Settings");
            ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
            ((BBYBaseFragmentActivity)d).changeActionBarAddToVisibility(d, false);
            ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, false);
            String s1 = ((BBYBaseFragmentActivity)d).getCurrentActionBarTitle();
            f.i(s1);
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "Save", true);
        }
    }
}
