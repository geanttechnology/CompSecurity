// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;

// Referenced classes of package android.support.v4.app:
//            Fragment

public class ListFragment extends Fragment
    implements TraceFieldInterface
{

    ListAdapter a;
    ListView b;
    View c;
    TextView d;
    View e;
    View f;
    CharSequence g;
    boolean h;
    private final Handler i = new Handler();
    private final Runnable j = new _cls1();
    private final android.widget.AdapterView.OnItemClickListener k = new _cls2();

    public ListFragment()
    {
    }

    private void a(boolean flag, boolean flag1)
    {
        b();
        if (e == null)
        {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (h == flag)
        {
            return;
        }
        h = flag;
        if (flag)
        {
            if (flag1)
            {
                e.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0001));
                f.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0000));
            } else
            {
                e.clearAnimation();
                f.clearAnimation();
            }
            e.setVisibility(8);
            f.setVisibility(0);
            return;
        }
        if (flag1)
        {
            e.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0000));
            f.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0001));
        } else
        {
            e.clearAnimation();
            f.clearAnimation();
        }
        e.setVisibility(0);
        f.setVisibility(8);
    }

    private void b()
    {
        if (b != null)
        {
            return;
        }
        Object obj = getView();
        if (obj == null)
        {
            throw new IllegalStateException("Content view not yet created");
        }
        if (obj instanceof ListView)
        {
            b = (ListView)obj;
        } else
        {
            d = (TextView)((View) (obj)).findViewById(0xff0001);
            if (d == null)
            {
                c = ((View) (obj)).findViewById(0x1020004);
            } else
            {
                d.setVisibility(8);
            }
            e = ((View) (obj)).findViewById(0xff0002);
            f = ((View) (obj)).findViewById(0xff0003);
            obj = ((View) (obj)).findViewById(0x102000a);
            if (!(obj instanceof ListView))
            {
                if (obj == null)
                {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                } else
                {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
            }
            b = (ListView)obj;
            if (c != null)
            {
                b.setEmptyView(c);
            } else
            if (g != null)
            {
                d.setText(g);
                b.setEmptyView(d);
            }
        }
        h = true;
        b.setOnItemClickListener(k);
        if (a != null)
        {
            obj = a;
            a = null;
            a(((ListAdapter) (obj)));
        } else
        if (e != null)
        {
            a(false, false);
        }
        i.post(j);
    }

    public void a(ListAdapter listadapter)
    {
        boolean flag1 = false;
        boolean flag;
        if (a != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = listadapter;
        if (b != null)
        {
            b.setAdapter(listadapter);
            if (!h && !flag)
            {
                if (getView().getWindowToken() != null)
                {
                    flag1 = true;
                }
                a(true, flag1);
            }
        }
    }

    public void a(ListView listview, View view, int l, long l1)
    {
    }

    public void a(boolean flag)
    {
        a(flag, true);
    }

    public ListView f_()
    {
        b();
        return b;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = getActivity();
        layoutinflater = new FrameLayout(viewgroup);
        bundle = new LinearLayout(viewgroup);
        bundle.setId(0xff0002);
        bundle.setOrientation(1);
        bundle.setVisibility(8);
        bundle.setGravity(17);
        bundle.addView(new ProgressBar(viewgroup, null, 0x101007a), new android.widget.FrameLayout.LayoutParams(-2, -2));
        layoutinflater.addView(bundle, new android.widget.FrameLayout.LayoutParams(-1, -1));
        viewgroup = new FrameLayout(viewgroup);
        viewgroup.setId(0xff0003);
        bundle = new TextView(getActivity());
        bundle.setId(0xff0001);
        bundle.setGravity(17);
        viewgroup.addView(bundle, new android.widget.FrameLayout.LayoutParams(-1, -1));
        bundle = new ListView(getActivity());
        bundle.setId(0x102000a);
        bundle.setDrawSelectorOnTop(false);
        viewgroup.addView(bundle, new android.widget.FrameLayout.LayoutParams(-1, -1));
        layoutinflater.addView(viewgroup, new android.widget.FrameLayout.LayoutParams(-1, -1));
        layoutinflater.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        return layoutinflater;
    }

    public void onDestroyView()
    {
        i.removeCallbacks(j);
        b = null;
        h = false;
        f = null;
        e = null;
        c = null;
        d = null;
        super.onDestroyView();
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        b();
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
