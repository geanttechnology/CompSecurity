// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import cg;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.stores.DialogSpinner;
import com.bestbuy.android.api.lib.models.registry.Entities;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYTextView;
import dg;
import fr;
import java.util.ArrayList;
import java.util.HashMap;
import jd;
import jk;
import jn;
import ll;
import lu;
import mm;
import mp;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            EmptyWeddingRegistryContainer, MyEmptyWishListFragment, MyEmptyWeddingRegistryList, AddItemsToPLPFragment, 
//            MyWishListsFragment, MyWeddingRegistryFragment

public class WishListWithProductsFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private int A;
    private View B;
    private boolean C;
    private boolean D;
    private boolean E;
    private ArrayList F;
    private ArrayList G;
    private LinearLayout H;
    private LinearLayout I;
    private android.widget.AdapterView.OnItemSelectedListener J = new android.widget.AdapterView.OnItemSelectedListener() {

        final WishListWithProductsFragment a;

        public void onItemSelected(AdapterView adapterview, View view, int i1, long l1)
        {
            adapterview = (String)WishListWithProductsFragment.a(a).getAdapter().getItem(i1);
            WishListWithProductsFragment.a(a, adapterview, false);
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

            
            {
                a = WishListWithProductsFragment.this;
                super();
            }
    };
    private android.widget.AbsListView.OnScrollListener K = new android.widget.AbsListView.OnScrollListener() {

        final WishListWithProductsFragment a;

        public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
        {
            if (WishListWithProductsFragment.b(a) || k1 <= 0 || i1 + j1 != k1)
            {
                break MISSING_BLOCK_LABEL_196;
            }
            i1 = (WishListWithProductsFragment.c(a) + 1) * 25;
            k1 = i1 + 25;
            if (WishListWithProductsFragment.d(a) == null || WishListWithProductsFragment.d(a).size() <= i1)
            {
                break MISSING_BLOCK_LABEL_196;
            }
            abslistview = new ArrayList();
            do
            {
label0:
                {
                    if (WishListWithProductsFragment.d(a).size() > k1)
                    {
                        j1 = k1;
                    } else
                    {
                        j1 = WishListWithProductsFragment.d(a).size();
                    }
                    if (i1 >= j1)
                    {
                        break label0;
                    }
                    abslistview.add(WishListWithProductsFragment.d(a).get(i1));
                    i1++;
                }
            } while (true);
            WishListWithProductsFragment.e(a);
            WishListWithProductsFragment.a(a, true);
            if (abslistview.size() > 0)
            {
                (new jn(a.d, a, null, abslistview, WishListWithProductsFragment.f(a))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }

        public void onScrollStateChanged(AbsListView abslistview, int i1)
        {
        }

            
            {
                a = WishListWithProductsFragment.this;
                super();
            }
    };
    private View a;
    private View b;
    private ListView c;
    private dg g;
    private RelativeLayout h;
    private DialogSpinner i;
    private RegistryWishList j;
    private RelativeLayout k;
    private BBYTextView l;
    private BBYTextView m;
    private boolean n;
    private ArrayList o;
    private ArrayList p;
    private BBYBaseFragment q;
    private boolean r;
    private View s;
    private LinearLayout t;
    private LinearLayout u;
    private BBYTextView v;
    private nb w;
    private BBYTextView x;
    private BBYTextView y;
    private ImageView z;

    public WishListWithProductsFragment()
    {
        n = false;
        r = false;
        A = 0;
        C = false;
        E = false;
        F = new ArrayList();
        G = new ArrayList();
    }

    public WishListWithProductsFragment(BBYBaseFragment bbybasefragment, RegistryWishList registrywishlist, ArrayList arraylist)
    {
        n = false;
        r = false;
        A = 0;
        C = false;
        E = false;
        F = new ArrayList();
        G = new ArrayList();
        j = registrywishlist;
        o = arraylist;
        q = bbybasefragment;
    }

    public WishListWithProductsFragment(BBYBaseFragment bbybasefragment, RegistryWishList registrywishlist, ArrayList arraylist, boolean flag)
    {
        n = false;
        r = false;
        A = 0;
        C = false;
        E = false;
        F = new ArrayList();
        G = new ArrayList();
        j = registrywishlist;
        o = arraylist;
        q = bbybasefragment;
        r = flag;
    }

    public WishListWithProductsFragment(boolean flag, BBYBaseFragment bbybasefragment, RegistryWishList registrywishlist)
    {
        n = false;
        r = false;
        A = 0;
        C = false;
        E = false;
        F = new ArrayList();
        G = new ArrayList();
        q = bbybasefragment;
        j = registrywishlist;
        D = flag;
    }

    public WishListWithProductsFragment(boolean flag, BBYBaseFragment bbybasefragment, RegistryWishList registrywishlist, boolean flag1)
    {
        n = false;
        r = false;
        A = 0;
        C = false;
        E = false;
        F = new ArrayList();
        G = new ArrayList();
        q = bbybasefragment;
        j = registrywishlist;
        r = flag1;
        D = flag;
    }

    static DialogSpinner a(WishListWithProductsFragment wishlistwithproductsfragment)
    {
        return wishlistwithproductsfragment.i;
    }

    static void a(WishListWithProductsFragment wishlistwithproductsfragment, String s1, boolean flag)
    {
        wishlistwithproductsfragment.a(s1, flag);
    }

    private void a(String s1, boolean flag)
    {
        if (!s1.equals("All Items") && !s1.equals("All Gifts")) goto _L2; else goto _L1
_L1:
        E = false;
        F.clear();
        G.clear();
        F.addAll(o);
        G.addAll(p);
        v.setVisibility(8);
        if (flag)
        {
            g = new dg(d, this, 0x7f03011c, G, F, 4, r);
        } else
        {
            g = new dg(d, this, 0x7f03011c, G, F, 1, r);
        }
_L4:
        c.setAdapter(g);
        return;
_L2:
        if (s1.equals("Favorite Items") || s1.equals("Favorite Gifts"))
        {
            E = true;
            F.clear();
            G.clear();
            for (int i1 = 0; i1 < p.size(); i1++)
            {
                if (((Entities)o.get(i1)).isFavorite())
                {
                    F.add(o.get(i1));
                    G.add(p.get(i1));
                }
            }

            if (F.size() <= 0)
            {
                v.setVisibility(0);
                v.bringToFront();
                if (r)
                {
                    v.setText("No Favorite Gifts");
                } else
                {
                    v.setText("No Favorite Items");
                }
            } else
            {
                v.setVisibility(8);
            }
            if (flag)
            {
                g = new dg(d, this, 0x7f03011c, G, F, 4, r);
            } else
            {
                g = new dg(d, this, 0x7f03011c, G, F, 1, r);
            }
        } else
        if (s1.equals("Purchased Gifts") || s1.equals("Purchased Items"))
        {
            E = false;
            F.clear();
            G.clear();
            for (int j1 = 0; j1 < p.size(); j1++)
            {
                if (((Entities)o.get(j1)).getPurchaseQuantity() > 0)
                {
                    F.add(o.get(j1));
                    G.add(p.get(j1));
                }
            }

            if (F.size() <= 0)
            {
                v.setVisibility(0);
                v.bringToFront();
                if (r)
                {
                    v.setText("No Purchased Gifts");
                } else
                {
                    v.setText("No Purchased Items");
                }
            } else
            {
                v.setVisibility(8);
            }
            if (flag)
            {
                g = new dg(d, this, 0x7f03011c, G, F, 4, r);
            } else
            {
                g = new dg(d, this, 0x7f03011c, G, F, 1, r);
            }
        } else
        if (s1.equals("Not Purchased Gifts") || s1.equals("Not Purchased Items"))
        {
            E = false;
            F.clear();
            G.clear();
            for (int k1 = 0; k1 < p.size(); k1++)
            {
                if (((Entities)o.get(k1)).getPurchaseQuantity() == 0)
                {
                    F.add(o.get(k1));
                    G.add(p.get(k1));
                }
            }

            if (F.size() <= 0)
            {
                v.setVisibility(0);
                v.bringToFront();
                if (r)
                {
                    v.setText("No Not Purchased Gifts");
                } else
                {
                    v.setText("No Not Purchased Items");
                }
            } else
            {
                v.setVisibility(8);
            }
            if (flag)
            {
                g = new dg(d, this, 0x7f03011c, G, F, 4, r);
            } else
            {
                g = new dg(d, this, 0x7f03011c, G, F, 1, r);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean a(WishListWithProductsFragment wishlistwithproductsfragment, boolean flag)
    {
        wishlistwithproductsfragment.C = flag;
        return flag;
    }

    static boolean b(WishListWithProductsFragment wishlistwithproductsfragment)
    {
        return wishlistwithproductsfragment.C;
    }

    static int c(WishListWithProductsFragment wishlistwithproductsfragment)
    {
        return wishlistwithproductsfragment.A;
    }

    static ArrayList d(WishListWithProductsFragment wishlistwithproductsfragment)
    {
        return wishlistwithproductsfragment.o;
    }

    static int e(WishListWithProductsFragment wishlistwithproductsfragment)
    {
        int i1 = wishlistwithproductsfragment.A;
        wishlistwithproductsfragment.A = i1 + 1;
        return i1;
    }

    static boolean f(WishListWithProductsFragment wishlistwithproductsfragment)
    {
        return wishlistwithproductsfragment.n;
    }

    private void h()
    {
        Object obj = new ArrayList();
        if (r)
        {
            ((ArrayList) (obj)).add("All Gifts");
            ((ArrayList) (obj)).add("Purchased Gifts");
            ((ArrayList) (obj)).add("Not Purchased Gifts");
            ((ArrayList) (obj)).add("Favorite Gifts");
        } else
        {
            ((ArrayList) (obj)).add("All Items");
            ((ArrayList) (obj)).add("Purchased Items");
            ((ArrayList) (obj)).add("Not Purchased Items");
            ((ArrayList) (obj)).add("Favorite Items");
        }
        obj = new ArrayAdapter(d, 0x7f03002c, ((java.util.List) (obj)));
        ((ArrayAdapter) (obj)).setDropDownViewResource(0x1090009);
        i.setAdapter(((SpinnerAdapter) (obj)));
        i.setSelection(0, false);
        i.setOnItemSelectedListener(J);
    }

    public void a(RegistryWishList registrywishlist)
    {
        j = registrywishlist;
        if (w.E().booleanValue())
        {
            w.c(false);
            if (b != null)
            {
                b.setVisibility(8);
            }
            return;
        }
        if (o.size() > 25)
        {
            A = 0;
            registrywishlist = new ArrayList();
            for (int i1 = 0; i1 < 25; i1++)
            {
                registrywishlist.add(o.get(i1));
            }

            (new jn(d, this, b, registrywishlist, n)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            (new jn(d, this, b, o, n)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
    }

    public void a(WeddingRegistryData weddingregistrydata)
    {
        ((BBYBaseFragmentActivity)d).updateActionBarTitle(weddingregistrydata.getRegistryName());
    }

    public void a(String s1)
    {
        PLPFragmentContainer plpfragmentcontainer = new PLPFragmentContainer(false, true);
        s1 = new PLPFragment(true, "Similar", "Related Products", "all", s1, "", 50);
        s1.b(true);
        ((HomeActivity)d).addFragment(0x7f0c0033, plpfragmentcontainer, "PLPFragmentContainer");
        plpfragmentcontainer.a(s1, true);
    }

    public void a(ArrayList arraylist)
    {
        o = arraylist;
        if (arraylist != null && arraylist.size() > 0)
        {
            (new jk(d, this, b, j.getUuid(), j.getType())).executeOnExecutor(nb.g, new Void[0]);
            return;
        }
        w.B().remove(j.getUuid());
        nb.a().j(false);
        if ((BaseFragmentContainer)getParentFragment() instanceof EmptyWeddingRegistryContainer)
        {
            d();
            return;
        } else
        {
            c();
            return;
        }
    }

    public void a(ArrayList arraylist, ArrayList arraylist1, boolean flag)
    {
        C = false;
        o = arraylist1;
        if (arraylist != null && arraylist.size() > 0)
        {
            y.setVisibility(8);
            h.setVisibility(0);
            u.setVisibility(0);
            if (p != null && A > 0)
            {
                p.addAll(arraylist);
            } else
            {
                p = arraylist;
            }
            h();
            if (!flag)
            {
                if (g == null)
                {
                    c.addFooterView(B);
                    g = new dg(d, this, 0x7f03011c, p, o, 1, r);
                    c.setAdapter(g);
                } else
                {
                    g.a(1);
                    g.notifyDataSetChanged();
                }
            } else
            if (g == null)
            {
                c.addFooterView(B);
                g = new dg(d, this, 0x7f03011c, p, o, 4, r);
                c.setAdapter(g);
            } else
            {
                g.a(4);
                g.notifyDataSetChanged();
            }
            if (p.size() < 25 || o.size() == p.size())
            {
                c.removeFooterView(B);
            }
        } else
        if (arraylist.size() == 0)
        {
            h.setVisibility(8);
            u.setVisibility(8);
            y.setVisibility(0);
            return;
        }
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            t.setVisibility(0);
            ll.b(t);
            return;
        } else
        {
            t.setVisibility(8);
            return;
        }
    }

    public void a(boolean flag, String s1, String s2, String s3)
    {
        if (flag)
        {
            int i1 = g.a(s3);
            s1 = (Entities)F.get(i1);
            s2 = (BBYProduct)G.get(i1);
            F.remove(i1);
            G.remove(i1);
            o.remove(s1);
            p.remove(s2);
            if (F.size() > 0)
            {
                g.notifyDataSetChanged();
            } else
            {
                if (F.size() == 0 && (i.getSelectedItem().toString().equalsIgnoreCase("All Items") || i.getSelectedItem().toString().equalsIgnoreCase("All Gifts")))
                {
                    w.B().remove(j.getUuid());
                    nb.a().j(false);
                    if ((BaseFragmentContainer)getParentFragment() instanceof EmptyWeddingRegistryContainer)
                    {
                        d();
                        return;
                    } else
                    {
                        c();
                        return;
                    }
                }
                if (F.size() == 0 && (i.getSelectedItem().toString().equalsIgnoreCase("Favorite Items") || i.getSelectedItem().toString().equalsIgnoreCase("Favorite Gifts")))
                {
                    v.setVisibility(0);
                    v.bringToFront();
                    if (r)
                    {
                        v.setText("No Favorite Gifts");
                        return;
                    } else
                    {
                        v.setText("No Favorite Items");
                        return;
                    }
                }
                if (F.size() == 0 && (i.getSelectedItem().toString().equalsIgnoreCase("Purchased Items") || i.getSelectedItem().toString().equalsIgnoreCase("Purchased Gifts")))
                {
                    v.setVisibility(0);
                    v.bringToFront();
                    if (r)
                    {
                        v.setText("No Purchased Gifts");
                        return;
                    } else
                    {
                        v.setText("No Purchased Items");
                        return;
                    }
                }
                if (F.size() == 0 && (i.getSelectedItem().toString().equalsIgnoreCase("Not Purchased Gifts") || i.getSelectedItem().toString().equalsIgnoreCase("Not Purchased Items")))
                {
                    v.setVisibility(0);
                    v.bringToFront();
                    if (r)
                    {
                        v.setText("No Not Purchased Gifts");
                        return;
                    } else
                    {
                        v.setText("No Not Purchased Items");
                        return;
                    }
                }
            }
        }
    }

    public void a(boolean flag, String s1, String s2, String s3, int i1, mp mp1)
    {
        int j1 = g.a(s3);
        if (!flag) goto _L2; else goto _L1
_L1:
        ((Entities)F.get(j1)).setRequiredQuantity(i1);
        if (i1 <= 1) goto _L4; else goto _L3
_L3:
        mp1.d.setImageResource(0x7f020115);
_L6:
        mp1.e.setText(Integer.toString(i1));
_L2:
        return;
_L4:
        if (i1 == 1)
        {
            mp1.d.setImageResource(0x7f020116);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void a(boolean flag, String s1, String s2, String s3, mp mp1)
    {
        int l1;
        if (o != null)
        {
            int i1 = 0;
            int k1 = 0;
            do
            {
                l1 = k1;
                if (i1 >= o.size())
                {
                    break;
                }
                if (((Entities)o.get(i1)).getUuid().equals(s3))
                {
                    k1 = i1;
                }
                i1++;
            } while (true);
        } else
        {
            l1 = 0;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (!mp1.a.getTag().equals("Favorite this")) goto _L4; else goto _L3
_L3:
        if (!r) goto _L6; else goto _L5
_L5:
        mp1.a.setImageResource(0x7f0200c9);
        mp1.b.setText("Our Favorite");
_L9:
        ((Entities)o.get(l1)).setFavorite(true);
_L7:
        if (E && o != null)
        {
            s1 = new ArrayList();
            s2 = new ArrayList();
            s1.clear();
            s2.clear();
            for (int j1 = 0; j1 < p.size(); j1++)
            {
                if (((Entities)o.get(j1)).isFavorite())
                {
                    s1.add(o.get(j1));
                    s2.add(p.get(j1));
                }
            }

            if (s1.size() <= 0)
            {
                E = false;
                v.setVisibility(0);
                v.bringToFront();
                if (r)
                {
                    v.setText("No Favorite Gifts");
                } else
                {
                    v.setText("No Favorite Items");
                }
            } else
            {
                v.setVisibility(8);
            }
            g = new dg(d, this, 0x7f03011c, s2, s1, 1, r);
            c.setAdapter(g);
        }
          goto _L2
_L6:
        if (!r)
        {
            mp1.a.setImageResource(0x7f0200c9);
            mp1.b.setText("My Favorite");
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (mp1.a.getTag().equals("My Favorite") || mp1.a.getTag().equals("Our Favorite"))
        {
            mp1.a.setImageResource(0x7f0200cc);
            mp1.b.setText("Favorite this");
            ((Entities)o.get(l1)).setFavorite(false);
        }
          goto _L7
_L2:
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void b()
    {
        ArrayList arraylist = w.B();
        String s1 = j.getUuid();
        if (arraylist.contains(s1))
        {
            WishListWithProductsFragment wishlistwithproductsfragment = new WishListWithProductsFragment(this, j, ((ArrayList) (null)));
            ((BaseFragmentContainer)getParentFragment()).a(wishlistwithproductsfragment, true, "WishListWithProductsFragment");
            arraylist.remove(s1);
            w.a(arraylist);
            w.b(false);
        }
    }

    public void b(String s1)
    {
        int i1 = nb.a().b().getInt("cartQuantity", 0);
        HashMap hashmap = new HashMap();
        if (i1 == 1)
        {
            hashmap.put("bb.scOpen", "1");
        }
        hashmap.put("bb.scAdd", "1");
        hashmap.put("&&products", (new StringBuilder()).append(";[").append(s1).append("];;;;eVar7=[LE]").toString());
        hashmap.put(lu.bp, "LE");
        lu.a(lu.J, hashmap);
        ll.b(H);
    }

    public void c()
    {
        Object obj = j.getType().trim();
        lu.a((new StringBuilder()).append(lu.y).append(((String) (obj)).substring(0, ((String) (obj)).length() - 1)).toString());
        ((BaseFragmentContainer)getParentFragment()).d();
        obj = new MyEmptyWishListFragment(j);
        ((BaseFragmentContainer)getParentFragment()).a(((android.support.v4.app.Fragment) (obj)), true, "MyEmptyWishListFragment");
    }

    public void c(String s1)
    {
        String s2;
label0:
        {
            if (s1 != null)
            {
                s2 = s1;
                if (!s1.isEmpty())
                {
                    break label0;
                }
            }
            s2 = getString(0x7f08009e);
        }
        ((BBYTextView)I.findViewById(0x7f0c0083)).setText(s2);
        ll.b(I);
    }

    public void d()
    {
        lu.a(lu.az);
        ((BaseFragmentContainer)getParentFragment()).d();
        MyEmptyWeddingRegistryList myemptyweddingregistrylist = new MyEmptyWeddingRegistryList(j);
        ((BaseFragmentContainer)getParentFragment()).a(myemptyweddingregistrylist, true, "MyEmptyWeddingRegistryList");
    }

    public View e()
    {
        return b;
    }

    public void f()
    {
        A = 0;
        p = new ArrayList();
        o = new ArrayList();
        g = null;
        ArrayList arraylist = w.B();
        arraylist.remove(j.getUuid());
        w.a(arraylist);
        C = true;
        (new jd(d, this, fr.d(), j.getUuid(), j.getType(), false, b)).executeOnExecutor(nb.g, new Void[0]);
    }

    public void g()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (w.E().booleanValue())
        {
            (new jk(d, this, b, j.getUuid(), j.getType())).executeOnExecutor(nb.g, new Void[0]);
        }
        if (j != null)
        {
            j.getType().substring(0, j.getType().length() - 1);
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        InputMethodManager inputmethodmanager = (InputMethodManager)activity.getSystemService("input_method");
        if (activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void onClick(View view)
    {
        if (view == l)
        {
            n = true;
            m.setVisibility(0);
            l.setVisibility(8);
            v.setVisibility(8);
            a(i.getSelectedItem().toString(), n);
        } else
        {
            if (view == m)
            {
                n = false;
                l.setVisibility(0);
                m.setVisibility(8);
                a(i.getSelectedItem().toString(), n);
                return;
            }
            if (view == k)
            {
                ((BaseFragmentContainer)getParentFragment()).a(new AddItemsToPLPFragment(j, j.getType(), j.getUuid(), j.getShortDescription(), r), true);
                return;
            }
            if (view == u)
            {
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        w = nb.a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (a == null)
        {
            d.getWindow().setSoftInputMode(32);
            d.getWindow().setFlags(0x40000, 0x40000);
            a = layoutinflater.inflate(0x7f03011f, null);
            c = (ListView)a.findViewById(0x7f0c043f);
            H = (LinearLayout)a.findViewById(0x7f0c0080);
            c.setOnScrollListener(K);
            h = (RelativeLayout)a.findViewById(0x7f0c003a);
            u = (LinearLayout)a.findViewById(0x7f0c043c);
            b = a.findViewById(0x7f0c0064);
            i = (DialogSpinner)a.findViewById(0x7f0c007d);
            k = (RelativeLayout)a.findViewById(0x7f0c0442);
            I = (LinearLayout)a.findViewById(0x7f0c0082);
            x = (BBYTextView)a.findViewById(0x7f0c0134);
            l = (BBYTextView)a.findViewById(0x7f0c043d);
            m = (BBYTextView)a.findViewById(0x7f0c043e);
            z = (ImageView)a.findViewById(0x7f0c0443);
            t = (LinearLayout)a.findViewById(0x7f0c0440);
            v = (BBYTextView)a.findViewById(0x7f0c007f);
            y = (BBYTextView)a.findViewById(0x7f0c043b);
            B = layoutinflater.inflate(0x7f0300bc, null);
            v.setVisibility(8);
            m.setOnClickListener(this);
            l.setOnClickListener(this);
            k.setOnClickListener(this);
            u.setOnClickListener(this);
            if (r)
            {
                x.setText("Add Gifts");
                l.setText("Edit Gifts");
                z.setImageResource(0x7f02000b);
            }
            if (n)
            {
                m.setVisibility(0);
                l.setVisibility(8);
            } else
            {
                l.setVisibility(0);
                m.setVisibility(8);
            }
            if (r)
            {
                s = mm.a(d, this, null, j, D, r);
            } else
            {
                s = mm.a(d, this, j, null, D, r);
            }
            if (s != null)
            {
                h.removeAllViews();
                h.addView(s);
            }
            if (!w.C() && !w.W())
            {
                if (o != null)
                {
                    (new jk(d, this, b, j.getUuid(), j.getType())).executeOnExecutor(nb.g, new Void[0]);
                } else
                {
                    (new jd(d, this, fr.d(), j.getUuid(), j.getType(), false, b)).executeOnExecutor(nb.g, new Void[0]);
                }
            }
        } else
        {
            ((ViewGroup)a.getParent()).removeView(a);
        }
        return a;
    }

    public void onDestroy()
    {
        super.onDestroy();
        nb.a().j(false);
        b();
    }

    public void onResume()
    {
        super.onResume();
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", false);
        if (!w.E().booleanValue())
        {
            if (j != null || (q instanceof MyWishListsFragment))
            {
                ((BBYBaseFragmentActivity)d).updateActionBarTitle(j.getShortDescription());
                String s1 = ((BBYBaseFragmentActivity)d).getCurrentActionBarTitle();
                w.i(s1);
                ((HomeActivity)d).changeSearchBarVisibility(true);
            }
            if (j != null || (q instanceof MyWeddingRegistryFragment))
            {
                ((BBYBaseFragmentActivity)d).updateActionBarTitle(j.getShortDescription());
                String s2 = ((BBYBaseFragmentActivity)d).getCurrentActionBarTitle();
                w.i(s2);
                ((HomeActivity)d).changeSearchBarVisibility(true);
            } else
            {
                ((BBYBaseFragmentActivity)d).updateActionBarTitle("");
            }
        }
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        if (w.W())
        {
            f();
            w.b(false);
            w.j(false);
        } else
        if (w.C() && ((BaseFragmentContainer)getParentFragment() instanceof BaseFragmentContainer))
        {
            f();
            w.b(false);
            return;
        }
    }
}
