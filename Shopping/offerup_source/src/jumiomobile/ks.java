// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.jumio.netverify.sdk.core.ModelTemplate;
import java.util.List;

// Referenced classes of package jumiomobile:
//            jw, ll, hr, lm, 
//            mk, gj, mf, gk, 
//            ha, cv, ht

public class ks extends ListFragment
    implements android.support.v7.widget.SearchView.OnQueryTextListener, android.view.View.OnClickListener, jw, ll
{

    protected lm a;
    private gj b;
    private MenuItem c;
    private SearchView d;

    public ks()
    {
    }

    public static ks a()
    {
        return new ks();
    }

    private void a(ViewGroup viewgroup)
    {
        viewgroup.setBackgroundColor(0);
        int i = 0;
        while (i < viewgroup.getChildCount()) 
        {
            if (viewgroup.getChildAt(i) instanceof ViewGroup)
            {
                a((ViewGroup)viewgroup.getChildAt(i));
            } else
            if (viewgroup.getChildAt(i) != null)
            {
                viewgroup.getChildAt(i).setBackgroundColor(0);
            }
            i++;
        }
    }

    private void b()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)getActivity().getSystemService("input_method");
        View view = getActivity().getCurrentFocus();
        if (view != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public boolean a(ht ht)
    {
        return false;
    }

    public boolean c()
    {
        return false;
    }

    public boolean d()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (c != null)
        {
            flag = flag1;
            if (c.isActionViewExpanded())
            {
                c.collapseActionView();
                d.setQuery("", false);
                flag = true;
            }
        }
        return flag;
    }

    public void l()
    {
        a.showFragment(hr.d);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a.checkOrientation();
        if (getActivity() instanceof AppCompatActivity)
        {
            bundle = ((AppCompatActivity)getActivity()).getSupportActionBar();
            if (bundle != null)
            {
                SpannableString spannablestring = new SpannableString(mk.a(getActivity(), "actionbar_title_country"));
                spannablestring.setSpan(new AbsoluteSizeSpan(20, true), 0, spannablestring.length(), 33);
                bundle.setTitle(spannablestring);
            }
        }
        b = new gj(getActivity(), a.getModel().d());
        b.a(this);
        setListAdapter(b);
        bundle = getListView();
        bundle.setEmptyView(getView().findViewById(0x1020004));
        bundle.setFastScrollEnabled(true);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            a = (lm)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            activity = new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement PropertiesFragmentCallback").toString());
            activity.setStackTrace(classcastexception.getStackTrace());
            throw activity;
        }
    }

    public void onClick(View view)
    {
        Object obj = (ProgressBar)view.findViewById(mf.j);
        Object obj1 = (TextView)view.findViewById(mf.i);
        ((ProgressBar) (obj)).getLayoutParams().height = ((TextView) (obj1)).getHeight();
        obj = (gk)view.getTag();
        obj1 = a.getModel();
        a.getController().a(((ModelTemplate) (obj1)).d().indexOf(((gk) (obj)).a));
        a.getController().a(view, mf.j, this, a.isScanViewNext(hr.d));
        b();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        a.registerActivityCallback(this);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        d = new SearchView(getActivity());
        d.setOnQueryTextListener(this);
        a(d);
        c = menu.add(0, 1, 1, mk.a(getActivity(), "search"));
        c.setIcon(cv.a(getActivity(), "abc_ic_search_api_mtrl_alpha", "drawable"));
        c.setActionView(d);
        c.setShowAsAction(9);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return mf.c(getActivity(), a.getModel().H);
    }

    public void onDestroyView()
    {
        if (b != null)
        {
            b.a();
        }
        super.onDestroyView();
    }

    public boolean onQueryTextChange(String s)
    {
        if (b != null)
        {
            b.a(s);
        }
        return false;
    }

    public boolean onQueryTextSubmit(String s)
    {
        if (b != null)
        {
            b.a(s);
        }
        return true;
    }
}
