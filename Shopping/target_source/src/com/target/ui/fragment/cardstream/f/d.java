// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.f;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.a.b.h;
import com.target.a.a.b;
import com.target.ui.adapter.b.c;
import com.target.ui.view.BitmapImageView;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.fragment.cardstream.f:
//            e, c, a

public class d
{

    private static final String LOG_TAG = "ViewtagenExecutor";
    private final a mOnClickHandler;

    public d(a a1)
    {
        mOnClickHandler = a1;
    }

    static a a(d d1)
    {
        return d1.mOnClickHandler;
    }

    private void a(View view, b.f f, Runnable runnable)
    {
        int k;
        switch (f.mutationType)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("No such view mutation type found: ").append(f.mutationType).toString());

        case 1: // '\001'
            f = (String)f.param;
            ((TextView)view).setText(f);
            return;

        case 2: // '\002'
            int i = ((Integer)f.param).intValue();
            ((TextView)view).setText(i);
            return;

        case 3: // '\003'
            int j = ((Integer)f.param).intValue();
            ((ImageView)view).setImageResource(j);
            return;

        case 4: // '\004'
            view.setVisibility(((Integer)f.param).intValue());
            return;

        case 5: // '\005'
            a((ViewGroup)view, (b.a)f.param, runnable);
            return;

        case 6: // '\006'
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final d this$0;
                final Runnable val$extraOnClickAction;
                final b.e val$onClickMutation;

                public void onClick(View view1)
                {
                    d.a(d.this).a(view1, onClickMutation);
                    if (extraOnClickAction != null)
                    {
                        extraOnClickAction.run();
                    }
                }

            
            {
                this$0 = d.this;
                onClickMutation = e1;
                extraOnClickAction = runnable;
                super();
            }
            });
            return;

        case 7: // '\007'
            f = (String)f.param;
            runnable = (BitmapImageView)view;
            c.a(view.getContext(), f, runnable);
            return;

        case 8: // '\b'
            k = (int)((float)((Integer)f.param).intValue() * view.getResources().getDisplayMetrics().density);
            break;
        }
        view.setPadding(k, k, k, k);
    }

    private void a(ViewGroup viewgroup, b.a a1, Runnable runnable)
    {
        int i = a1.collectionItemLayout;
        LayoutInflater layoutinflater = LayoutInflater.from(viewgroup.getContext());
        View view;
        for (a1 = a1.collectionItemViewtagens.iterator(); a1.hasNext(); viewgroup.addView(view))
        {
            e e1 = (e)a1.next();
            view = layoutinflater.inflate(i, viewgroup, false);
            a(view, e1, runnable);
        }

        viewgroup.requestLayout();
    }

    public void a(View view, e e1, Runnable runnable)
    {
        for (e1 = e1.a().values().iterator(); e1.hasNext();)
        {
            Object obj = (com.target.ui.fragment.cardstream.f.c)e1.next();
            View view1 = view.findViewById(((com.target.ui.fragment.cardstream.f.c) (obj)).mViewToModify);
            if (view1 == null)
            {
                b.b("ViewtagenExecutor", (new StringBuilder()).append("No view found with ID ").append(((com.target.ui.fragment.cardstream.f.c) (obj)).mViewToModify).toString());
            } else
            {
                obj = ((com.target.ui.fragment.cardstream.f.c) (obj)).mMutations.c();
                while (((Iterator) (obj)).hasNext()) 
                {
                    a(view1, (b.f)((Iterator) (obj)).next(), runnable);
                }
            }
        }

    }
}
