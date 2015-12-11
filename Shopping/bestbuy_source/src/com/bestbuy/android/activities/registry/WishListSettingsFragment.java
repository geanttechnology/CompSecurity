// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import cg;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.registry.ListTypes;
import com.bestbuy.android.api.lib.models.registry.Recipient;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.WishListReqData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import je;
import jk;
import jp;
import jr;
import ju;
import ks;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WishlistAddressFragment, WishListFragmentContainer, RegistryFragmentContainer, EditListDetailsFragment, 
//            WishListPrivacyFragment

public class WishListSettingsFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private ImageView A;
    private ImageView B;
    private ImageView C;
    private String D;
    private int E;
    private boolean F;
    Calendar a;
    android.app.DatePickerDialog.OnDateSetListener b;
    Recipient c;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private EditText k;
    private EditText l;
    private EditText m;
    private EditText n;
    private Spinner o;
    private EditText p;
    private Button q;
    private RegistryWishList r;
    private View s;
    private WishListReqData t;
    private BBYBaseFragment u;
    private ArrayList v;
    private String w;
    private boolean x;
    private RelativeLayout y;
    private RelativeLayout z;

    public WishListSettingsFragment()
    {
        a = null;
        b = null;
    }

    public WishListSettingsFragment(BBYBaseFragment bbybasefragment, RegistryWishList registrywishlist, boolean flag)
    {
        a = null;
        b = null;
        u = bbybasefragment;
        r = registrywishlist;
        F = flag;
    }

    static Button a(WishListSettingsFragment wishlistsettingsfragment)
    {
        return wishlistsettingsfragment.q;
    }

    static RegistryWishList b(WishListSettingsFragment wishlistsettingsfragment)
    {
        return wishlistsettingsfragment.r;
    }

    static WishListReqData c(WishListSettingsFragment wishlistsettingsfragment)
    {
        return wishlistsettingsfragment.t;
    }

    static String d(WishListSettingsFragment wishlistsettingsfragment)
    {
        return wishlistsettingsfragment.D;
    }

    static EditText e(WishListSettingsFragment wishlistsettingsfragment)
    {
        return wishlistsettingsfragment.p;
    }

    private void e()
    {
        Object obj = new android.app.AlertDialog.Builder(d);
        ((android.app.AlertDialog.Builder) (obj)).setMessage(Html.fromHtml(d.getResources().getString(0x7f0802e6))).setCancelable(false).setNegativeButton(Html.fromHtml(d.getResources().getString(0x7f0800e9)), new android.content.DialogInterface.OnClickListener() {

            final WishListSettingsFragment a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.dismiss();
            }

            
            {
                a = WishListSettingsFragment.this;
                super();
            }
        }).setPositiveButton(Html.fromHtml(d.getResources().getString(0x7f0802e7)), new android.content.DialogInterface.OnClickListener() {

            final WishListSettingsFragment a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                String s2 = WishListSettingsFragment.b(a).getType();
                String s3 = WishListSettingsFragment.f(a).getText().toString();
                String s1;
                String as[];
                String s4;
                String s5;
                String s6;
                String s7;
                String s8;
                if (WishListSettingsFragment.g(a).getText().toString().equals("Public"))
                {
                    dialoginterface = "public";
                } else
                if (WishListSettingsFragment.g(a).getText().toString().equals("Private"))
                {
                    dialoginterface = "private";
                } else
                {
                    dialoginterface = "";
                }
                s7 = WishListSettingsFragment.h(a).getText().toString();
                s8 = WishListSettingsFragment.i(a).getText().toString();
                s1 = WishListSettingsFragment.j(a).getText().toString();
                s4 = WishListSettingsFragment.k(a).getText().toString();
                s5 = WishListSettingsFragment.l(a).getSelectedItem().toString();
                s6 = WishListSettingsFragment.e(a).getText().toString();
                if (WishListSettingsFragment.c(a) == null) goto _L2; else goto _L1
_L1:
                WishListSettingsFragment.c(a).setListType(s2);
                WishListSettingsFragment.c(a).setRegistryName(s3);
                WishListSettingsFragment.c(a).setPrivacySetting(dialoginterface);
                WishListSettingsFragment.c(a).setShippingAddress(s7);
                WishListSettingsFragment.c(a).setAddDescription(s8);
                dialoginterface = s1;
                if (s1 == null)
                {
                    break MISSING_BLOCK_LABEL_241;
                }
                as = s1.split(",");
                dialoginterface = s1;
                if (as.length >= 3)
                {
                    dialoginterface = as[0];
                }
                if (!s5.contains("Select")) goto _L4; else goto _L3
_L3:
                WishListSettingsFragment.c(a).setEventState("");
_L5:
                WishListSettingsFragment.c(a).setEventLocation(dialoginterface);
                WishListSettingsFragment.c(a).setEventCity(s4);
                WishListSettingsFragment.c(a).setEventDate(s6);
                WishListSettingsFragment.c(a).setUuid(WishListSettingsFragment.b(a).getUuid());
                WishListSettingsFragment.c(a).setRecepient(a.c);
                if (a.c != null)
                {
                    WishListSettingsFragment.c(a).setFirstName(a.c.getFirstName());
                    WishListSettingsFragment.c(a).setLastName(a.c.getLastName());
                }
                (new jr(a.d, a, WishListSettingsFragment.m(a), WishListSettingsFragment.c(a))).executeOnExecutor(nb.g, new Void[0]);
_L2:
                WishListSettingsFragment.b(a).setRecipient(a.c);
                return;
_L4:
                WishListSettingsFragment.c(a).setEventState(s5);
                  goto _L5
                dialoginterface;
                dialoginterface.printStackTrace();
                  goto _L2
            }

            
            {
                a = WishListSettingsFragment.this;
                super();
            }
        });
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        ((AlertDialog) (obj)).show();
        ((TextView)((AlertDialog) (obj)).findViewById(0x102000b)).setGravity(17);
    }

    static TextView f(WishListSettingsFragment wishlistsettingsfragment)
    {
        return wishlistsettingsfragment.h;
    }

    static TextView g(WishListSettingsFragment wishlistsettingsfragment)
    {
        return wishlistsettingsfragment.i;
    }

    static EditText h(WishListSettingsFragment wishlistsettingsfragment)
    {
        return wishlistsettingsfragment.k;
    }

    static EditText i(WishListSettingsFragment wishlistsettingsfragment)
    {
        return wishlistsettingsfragment.l;
    }

    static EditText j(WishListSettingsFragment wishlistsettingsfragment)
    {
        return wishlistsettingsfragment.m;
    }

    static EditText k(WishListSettingsFragment wishlistsettingsfragment)
    {
        return wishlistsettingsfragment.n;
    }

    static Spinner l(WishListSettingsFragment wishlistsettingsfragment)
    {
        return wishlistsettingsfragment.o;
    }

    static View m(WishListSettingsFragment wishlistsettingsfragment)
    {
        return wishlistsettingsfragment.s;
    }

    public void a(RegistryWishList registrywishlist)
    {
        int i1 = 0;
        if (registrywishlist == null) goto _L2; else goto _L1
_L1:
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        String s8;
        s4 = registrywishlist.getType();
        s5 = registrywishlist.getShortDescription();
        s6 = registrywishlist.getPrivacySetting();
        D = s6;
        c = registrywishlist.getRecipient();
        s3 = "";
        s7 = registrywishlist.getCity();
        s8 = registrywishlist.getState();
        s1 = registrywishlist.getLocation();
        s2 = s1;
        if (s1 == null) goto _L4; else goto _L3
_L3:
        Object obj = s1.split(", ");
        if (obj.length != 0) goto _L6; else goto _L5
_L5:
        s1 = "";
_L14:
        s2 = s3;
        if (c != null)
        {
            s2 = (new StringBuilder()).append(c.getAddressLine1()).append(" ").append(c.getAddressLine2()).append(" ").append(c.getAddressCity()).append(" ").append(c.getAddressState()).append(" ").append(c.getAddressZip()).toString();
        }
        obj = registrywishlist.getPersonalizedMessage();
        String s9 = registrywishlist.getOccasionDate();
        HashMap hashmap;
        String as[];
        if (s4.contains("school"))
        {
            j.setText(d.getString(0x7f0802ec));
        } else
        {
            j.setText(d.getString(0x7f080216));
        }
        a(s4);
        h.setText(s5);
        w = s5;
        if (s6.equals("public"))
        {
            i.setText("Public");
        } else
        {
            i.setText("Private");
        }
        k.setText(s2);
        l.setText(((CharSequence) (obj)));
        if (s1 != null && !s1.contains("null"))
        {
            m.setText(s1);
        }
        p.setText(s9);
        if (s7 != null && !s7.isEmpty())
        {
            n.setText(s7);
        }
        if (s8 == null || s8.isEmpty()) goto _L8; else goto _L7
_L7:
        s3 = "";
        hashmap = ju.a();
        if (s8.length() > 0)
        {
            s8.trim();
            s3 = (String)hashmap.get(s8.substring(0, 2));
        }
        as = getResources().getStringArray(0x7f0a0000);
_L12:
        if (i1 >= as.length) goto _L8; else goto _L9
_L9:
        if (!as[i1].equals(s3)) goto _L11; else goto _L10
_L10:
        o.setSelection(i1);
_L8:
        t = new WishListReqData();
        t.setListType(s4);
        t.setRegistryName(s5);
        t.setPrivacySetting(s6);
        t.setShippingAddress(s2);
        t.setAddDescription(((String) (obj)));
        t.setEventLocation(s1);
        t.setEventCity(s7);
        t.setEventState(s8);
        t.setEventDate(s9);
        t.setRecepient(c);
        t.setUuid(registrywishlist.getUuid());
_L2:
        return;
_L6:
        s1 = obj[0];
        if (obj.length == 2)
        {
            if (!obj[1].contains("-"))
            {
                s2 = obj[1];
            } else
            {
                s2 = obj[1];
            }
        } else
        {
            s2 = s1;
            if (obj.length != 3)
            {
                break; /* Loop/switch isn't completed */
            }
            s2 = obj[1];
            s2 = obj[2];
        }
        continue; /* Loop/switch isn't completed */
_L11:
        i1++;
        if (true) goto _L12; else goto _L4
_L4:
        s1 = s2;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public void a(WishListReqData wishlistreqdata)
    {
label0:
        {
label1:
            {
                {
                    if (wishlistreqdata == null)
                    {
                        break label1;
                    }
                    String s2 = wishlistreqdata.getListType();
                    String s1 = wishlistreqdata.getRegistryName();
                    String s3 = wishlistreqdata.getPrivacySetting();
                    String s4 = wishlistreqdata.getEventLocation();
                    Object obj = "";
                    String s5;
                    int i1;
                    if (s4 != null)
                    {
                        String as[] = s4.split(", ");
                        if (as.length >= 3)
                        {
                            obj = as[1];
                            obj = as[2];
                        }
                    } else
                    {
                        wishlistreqdata.getEventCity();
                        obj = wishlistreqdata.getEventState();
                    }
                    s5 = wishlistreqdata.getAddDescription();
                    if (wishlistreqdata.getAddressLine1() != null && wishlistreqdata.getAddressLine2() != null && wishlistreqdata.getCity() != null && wishlistreqdata.getPhone() != null && wishlistreqdata.getZipCode() != null && wishlistreqdata.getState() != null)
                    {
                        String s6 = wishlistreqdata.getPhone();
                        s6 = (new StringBuilder()).append("(").append(s6.substring(0, 3)).append(") ").append(s6.substring(3, 6)).append("-").append(s6.substring(6, 10)).toString();
                        s6 = (new StringBuilder()).append(wishlistreqdata.getAddressLine1()).append(", ").append(wishlistreqdata.getAddressLine2()).append(", ").append(wishlistreqdata.getCity()).append(", ").append(wishlistreqdata.getState()).append(" ").append(wishlistreqdata.getZipCode()).append(", ").append(s6).toString();
                        k.setText(s6);
                        t.setAddressLine1(wishlistreqdata.getAddressLine1());
                        t.setAddressLine2(wishlistreqdata.getAddressLine2());
                        t.setCity(wishlistreqdata.getCity());
                        t.setPhone(wishlistreqdata.getPhone());
                        t.setState(wishlistreqdata.getState());
                        t.setZipCode(wishlistreqdata.getZipCode());
                        t.setShippingAddress(s6);
                        c = new Recipient();
                        c.setAddressLine1(wishlistreqdata.getAddressLine1());
                        c.setAddressLine2(wishlistreqdata.getAddressLine2());
                        c.setAddressCity(wishlistreqdata.getCity());
                        c.setAddressState(wishlistreqdata.getState());
                        c.setAddressZip(wishlistreqdata.getZipCode());
                        c.setPhoneNumber(wishlistreqdata.getPhone());
                        t.setRecepient(c);
                    }
                    if (s2.contains("school"))
                    {
                        j.setText(d.getString(0x7f0802ec));
                    } else
                    {
                        j.setText(d.getString(0x7f080216));
                    }
                    a(s2);
                    h.setText(s1);
                    if (s3.equals("public"))
                    {
                        i.setText("Public");
                    } else
                    {
                        i.setText("Private");
                    }
                    D = s3;
                    l.setText(s5);
                    m.setText(s4);
                    n.setText(wishlistreqdata.getEventCity());
                    wishlistreqdata = ju.a();
                    if (obj != null && ((String) (obj)).length() > 0)
                    {
                        wishlistreqdata = (String)wishlistreqdata.get(((String) (obj)).substring(0, 2));
                    } else
                    {
                        wishlistreqdata = "";
                    }
                    obj = getResources().getStringArray(0x7f0a0000);
                    i1 = 0;
                }
                if (i1 < obj.length)
                {
                    if (!obj[i1].equals(wishlistreqdata))
                    {
                        break label0;
                    }
                    o.setSelection(i1);
                }
                w = s1;
            }
            return;
        }
        i1++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_568;
        }
    }

    public void a(WishListReqData wishlistreqdata, boolean flag, int i1)
    {
        t = wishlistreqdata;
        x = true;
        if (flag)
        {
            E = i1;
            (new jp(d, this, null, wishlistreqdata)).executeOnExecutor(nb.h, new Void[0]);
        }
    }

    public void a(String s1)
    {
        if (v != null)
        {
            int i1 = 0;
            while (i1 < v.size()) 
            {
                if (s1.equals("weddingregistrys") && ((ListTypes)v.get(i1)).getType().contains("weddingregistry"))
                {
                    g.setText((new StringBuilder()).append(((ListTypes)v.get(i1)).getDescription()).append(" List").toString());
                    C.setImageResource(0x7f020198);
                }
                if (((ListTypes)v.get(i1)).getType().equalsIgnoreCase(s1))
                {
                    g.setText((new StringBuilder()).append(((ListTypes)v.get(i1)).getDescription()).append(" List").toString());
                    if (((ListTypes)v.get(i1)).getType().equals("backtoschoollists"))
                    {
                        C.setImageResource(0x7f020191);
                    } else
                    if (((ListTypes)v.get(i1)).getType().equals("holidaylists"))
                    {
                        C.setImageResource(0x7f020196);
                    } else
                    if (((ListTypes)v.get(i1)).getType().equals("graduationlists"))
                    {
                        C.setImageResource(0x7f020195);
                    } else
                    if (((ListTypes)v.get(i1)).getType().equals("anniversarylists"))
                    {
                        C.setImageResource(0x7f020190);
                    } else
                    if (((ListTypes)v.get(i1)).getType().equals("birthdaylists"))
                    {
                        C.setImageResource(0x7f020192);
                    } else
                    if (((ListTypes)v.get(i1)).getType().equals("movinglists"))
                    {
                        C.setImageResource(0x7f020197);
                    } else
                    {
                        C.setImageResource(0x7f020193);
                    }
                }
                i1++;
            }
        }
    }

    public void a(ArrayList arraylist)
    {
        v = arraylist;
    }

    public void b()
    {
    }

    public void c()
    {
        q.setEnabled(true);
    }

    public void d()
    {
        Object obj = (BaseFragmentContainer)getParentFragment();
        List list = ((BaseFragmentContainer) (obj)).getChildFragmentManager().getFragments();
        if (!F)
        {
            for (int i1 = list.size() - 1; i1 >= 0; i1--)
            {
                obj = (Fragment)list.get(i1);
                if (obj != null && !((Fragment) (obj)).getTag().equals("MyWishListsFragment"))
                {
                    ((HomeActivity)d).onBackPressed();
                }
            }

        } else
        {
            ((BaseFragmentContainer) (obj)).getFragmentManager().popBackStack();
        }
    }

    public void g()
    {
        e();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        HomeActivity.inLifeEventsFragment = true;
        super.onAttach(activity);
    }

    public void onClick(View view)
    {
        if (view == A || view == k)
        {
            WishlistAddressFragment wishlistaddressfragment = new WishlistAddressFragment(t, this, true, E, null);
            Fragment fragment = getParentFragment();
            if (fragment instanceof WishListFragmentContainer)
            {
                ((BaseFragmentContainer)fragment).a(wishlistaddressfragment, true, "WishlistAddressFragment");
            }
            if (fragment instanceof RegistryFragmentContainer)
            {
                ((BaseFragmentContainer)fragment).a(wishlistaddressfragment, true, "WishlistAddressFragment");
            }
        }
        if (view == B || view == p || view == z)
        {
            DatePickerDialog datepickerdialog = new DatePickerDialog(getActivity(), b, a.get(1), a.get(2), a.get(5));
            datepickerdialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000L);
            datepickerdialog.getDatePicker().setMaxDate(System.currentTimeMillis() + 0x757b12c00L);
            datepickerdialog.show();
        }
        if (view != y);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03011e, viewgroup, false);
        d.getWindow().setSoftInputMode(16);
        y = (RelativeLayout)layoutinflater.findViewById(0x7f0c0076);
        s = layoutinflater.findViewById(0x7f0c0064);
        g = (TextView)layoutinflater.findViewById(0x7f0c040d);
        C = (ImageView)layoutinflater.findViewById(0x7f0c0435);
        h = (TextView)layoutinflater.findViewById(0x7f0c0436);
        i = (TextView)layoutinflater.findViewById(0x7f0c0437);
        A = (ImageView)layoutinflater.findViewById(0x7f0c0411);
        k = (EditText)layoutinflater.findViewById(0x7f0c0410);
        l = (EditText)layoutinflater.findViewById(0x7f0c0413);
        j = (TextView)layoutinflater.findViewById(0x7f0c0415);
        m = (EditText)layoutinflater.findViewById(0x7f0c0416);
        n = (EditText)layoutinflater.findViewById(0x7f0c0374);
        o = (Spinner)layoutinflater.findViewById(0x7f0c0377);
        p = (EditText)layoutinflater.findViewById(0x7f0c0438);
        B = (ImageView)layoutinflater.findViewById(0x7f0c0439);
        z = (RelativeLayout)layoutinflater.findViewById(0x7f0c041b);
        q = (Button)layoutinflater.findViewById(0x7f0c043a);
        (new je(d, this, null)).executeOnExecutor(nb.g, new Void[0]);
        A.setOnClickListener(this);
        k.setOnClickListener(this);
        p.setOnClickListener(this);
        B.setOnClickListener(this);
        y.setOnClickListener(this);
        z.setOnClickListener(this);
        q.setOnClickListener(new android.view.View.OnClickListener() {

            final WishListSettingsFragment a;

            public void onClick(View view)
            {
                WishListSettingsFragment.a(a).setEnabled(false);
                view = WishListSettingsFragment.b(a).getType();
                String s1 = WishListSettingsFragment.b(a).getUuid();
                (new ks(a.d, a, view, s1)).a();
            }

            
            {
                a = WishListSettingsFragment.this;
                super();
            }
        });
        h.setOnClickListener(new android.view.View.OnClickListener() {

            final WishListSettingsFragment a;

            public void onClick(View view)
            {
                view = new EditListDetailsFragment(WishListSettingsFragment.c(a), a, true);
                Fragment fragment = a.getParentFragment();
                if (fragment instanceof WishListFragmentContainer)
                {
                    ((BaseFragmentContainer)fragment).a(view, true, "EditListDetailsFragment");
                }
                if (fragment instanceof RegistryFragmentContainer)
                {
                    ((BaseFragmentContainer)fragment).a(view, true, "EditListDetailsFragment");
                }
            }

            
            {
                a = WishListSettingsFragment.this;
                super();
            }
        });
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final WishListSettingsFragment a;

            public void onClick(View view)
            {
                view = new WishListPrivacyFragment(WishListSettingsFragment.c(a), WishListSettingsFragment.d(a), a, true);
                Fragment fragment = a.getParentFragment();
                if (fragment instanceof WishListFragmentContainer)
                {
                    ((BaseFragmentContainer)fragment).a(view, true, "WishListPrivacyFragment");
                }
                if (fragment instanceof RegistryFragmentContainer)
                {
                    ((BaseFragmentContainer)fragment).a(view, true, "WishListPrivacyFragment");
                }
            }

            
            {
                a = WishListSettingsFragment.this;
                super();
            }
        });
        a = Calendar.getInstance();
        viewgroup = r.getOccasionDate();
        if (viewgroup != null)
        {
            try
            {
                if (!viewgroup.isEmpty())
                {
                    viewgroup = (new SimpleDateFormat("MM/dd/yy")).parse(viewgroup);
                    viewgroup = TextUtils.split((new SimpleDateFormat("MM/dd/yyyy")).format(viewgroup), "/");
                    int i1 = Integer.parseInt(viewgroup[0]);
                    int j1 = Integer.parseInt(viewgroup[1]);
                    int k1 = Integer.parseInt(viewgroup[2]);
                    a.set(k1, i1 - 1, j1);
                }
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                viewgroup.printStackTrace();
            }
        }
        b = new android.app.DatePickerDialog.OnDateSetListener() {

            final WishListSettingsFragment a;

            private void a()
            {
                SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
                WishListSettingsFragment.e(a).setText(simpledateformat.format(a.a.getTime()));
            }

            public void onDateSet(DatePicker datepicker, int l1, int i2, int j2)
            {
                a.a.set(1, l1);
                a.a.set(2, i2);
                a.a.set(5, j2);
                a();
            }

            
            {
                a = WishListSettingsFragment.this;
                super();
            }
        };
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        d.getWindow().setSoftInputMode(32);
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", false);
    }

    public void onResume()
    {
        super.onResume();
        HomeActivity.inLifeEventsFragment = true;
        if (isVisible())
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle("List Settings");
            ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
            ((BBYBaseFragmentActivity)d).changeActionBarAddToVisibility(d, false);
            ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, false);
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, getString(0x7f0802e5), true);
            if (x)
            {
                a(t);
                x = false;
            } else
            if (r != null)
            {
                (new jk(d, this, s, r.getUuid(), r.getType())).executeOnExecutor(nb.g, new Void[0]);
                return;
            }
        }
    }
}
