// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.youcammakeup.database.r;
import com.cyberlink.youcammakeup.database.s;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.pages.librarypicker.a.a;
import com.cyberlink.youcammakeup.pages.librarypicker.a.b;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker:
//            a

public class PickedFragment extends Fragment
{

    public static final String a = (new StringBuilder()).append(com/cyberlink/youcammakeup/pages/librarypicker/PickedFragment.toString()).append("_STATE").toString();
    LinearLayout b;
    HorizontalScrollView c;

    public PickedFragment()
    {
    }

    private int c()
    {
        return b.getChildCount();
    }

    public void a()
    {
        int i = c();
        int j = getView().getVisibility();
        if (i > 0 && j != 0)
        {
            getView().setVisibility(0);
        } else
        if (i <= 0 && j != 8)
        {
            getView().setVisibility(8);
            return;
        }
    }

    public void a(long l)
    {
        Object obj = s.a(l);
        if (obj == null)
        {
            return;
        } else
        {
            obj = new a(((r) (obj)).w(), ((r) (obj)).f());
            b b1 = new b(getActivity(), ((a) (obj)));
            b1.setOnCloseListener(new android.view.View.OnClickListener(b1) {

                final b a;
                final PickedFragment b;

                public void onClick(View view)
                {
                    a.setOnCloseListener(null);
                    b.b.removeView(a);
                    b.a();
                }

            
            {
                b = PickedFragment.this;
                a = b1;
                super();
            }
            });
            b.addView(b1);
            a();
            (new Handler()).postDelayed(new Runnable() {

                final PickedFragment a;

                public void run()
                {
                    a.c.fullScroll(66);
                }

            
            {
                a = PickedFragment.this;
                super();
            }
            }, 100L);
            (new com.cyberlink.youcammakeup.pages.librarypicker.a(b1, ((a) (obj)).b())).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
    }

    public void a(com.cyberlink.youcammakeup.pages.librarypicker.photopage.b b1)
    {
        a(b1.getItem().b());
    }

    public void a(String s1)
    {
        ((TextView)getView().findViewById(0x7f0c05b1)).setText(s1);
    }

    public void b(long l)
    {
        Object obj = s.a(l);
        if (obj == null)
        {
            return;
        } else
        {
            obj = new a(((r) (obj)).w(), ((r) (obj)).f());
            obj = new b(getActivity(), ((a) (obj)));
            b.addView(((View) (obj)));
            return;
        }
    }

    public Long[] b()
    {
        int j = b.getChildCount();
        Long along[] = new Long[j];
        int i = 0;
        while (i < j) 
        {
            b b1 = (b)b.getChildAt(i);
            if (b1 != null)
            {
                along[i] = Long.valueOf(b1.getItem().b());
            }
            i++;
        }
        return along;
    }

    public void c(long l)
    {
        int i = b.getChildCount();
        boolean flag = false;
        i--;
        do
        {
            if (i < 0)
            {
                break;
            }
            b b1 = (b)b.getChildAt(i);
            if (b1 != null && l == b1.getItem().a())
            {
                b1.setOnCloseListener(null);
                b.removeView(b1);
                flag = true;
            }
            i--;
        } while (true);
        if (flag)
        {
            a();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle == null)
        {
            bundle = StatusManager.j().m();
            if (bundle != null)
            {
                for (bundle = bundle.iterator(); bundle.hasNext(); a(((Long)bundle.next()).longValue())) { }
            }
        } else
        {
            bundle = (State)bundle.getSerializable(a);
            if (bundle != null)
            {
                bundle = bundle.a();
                int j = bundle.length;
                for (int i = 0; i < j; i++)
                {
                    a(bundle[i]);
                }

            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03011e, viewgroup, false);
        b = (LinearLayout)layoutinflater.findViewById(0x7f0c05b4);
        c = (HorizontalScrollView)layoutinflater.findViewById(0x7f0c05b2);
        return layoutinflater;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        State state = new State(b());
        bundle.putSerializable(a, state);
    }


    private class State
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private final long mPickedImageIds[];

        private void readObject(ObjectInputStream objectinputstream)
        {
            try
            {
                objectinputstream.defaultReadObject();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ObjectInputStream objectinputstream)
            {
                return;
            }
        }

        private void writeObject(ObjectOutputStream objectoutputstream)
        {
            try
            {
                objectoutputstream.defaultWriteObject();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ObjectOutputStream objectoutputstream)
            {
                return;
            }
        }

        public long[] a()
        {
            return mPickedImageIds;
        }

        public State(Long along[])
        {
            mPickedImageIds = new long[along.length];
            for (int i = 0; i < along.length; i++)
            {
                mPickedImageIds[i] = along[i].longValue();
            }

        }
    }

}
