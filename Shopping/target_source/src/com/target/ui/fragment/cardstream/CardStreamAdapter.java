// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import com.google.a.b.k;
import com.target.a.a.b;
import com.target.ui.analytics.b.f;
import com.target.ui.fragment.cardstream.f.d;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.cardstream:
//            b

public class CardStreamAdapter extends android.support.v7.widget.RecyclerView.a
{
    static class ViewHolder extends android.support.v7.widget.RecyclerView.t
    {

        FrameLayout mContentFrame;

        public ViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    private static final String TAG = "CardStreamAdapter";
    private final List mCardData;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final d mViewtagenExecutor;

    public CardStreamAdapter(d d1, List list)
    {
        mCardData = k.a(list);
        mViewtagenExecutor = d1;
    }

    static List a(CardStreamAdapter cardstreamadapter)
    {
        return cardstreamadapter.mCardData;
    }

    private boolean b(List list)
    {
        return mCardData.equals(list);
    }

    public int a()
    {
        return mCardData.size();
    }

    public android.support.v7.widget.RecyclerView.t a(ViewGroup viewgroup, int i)
    {
        return c(viewgroup, i);
    }

    public volatile void a(android.support.v7.widget.RecyclerView.t t, int i)
    {
        a((ViewHolder)t, i);
    }

    public void a(ViewHolder viewholder, final int position)
    {
        final com.target.ui.fragment.cardstream.b cardData = (com.target.ui.fragment.cardstream.b)mCardData.get(position);
        FrameLayout framelayout = viewholder.mContentFrame;
        framelayout.setOnClickListener(null);
        int i = framelayout.getResources().getDimensionPixelSize(0x7f0a00d1);
        framelayout.setPadding(i, i, i, i);
        if (framelayout.getChildCount() > 0)
        {
            framelayout.removeAllViews();
        }
        LayoutInflater.from(framelayout.getContext()).inflate(cardData.layoutToInflate, framelayout, true);
        Runnable runnable = new Runnable() {

            final CardStreamAdapter this$0;
            final com.target.ui.fragment.cardstream.b val$cardData;
            final int val$position;

            public void run()
            {
                f.a(cardData.cardName, position).a();
            }

            
            {
                this$0 = CardStreamAdapter.this;
                cardData = b1;
                position = i;
                super();
            }
        };
        mViewtagenExecutor.a(viewholder.itemView, cardData.chromeMutations, runnable);
        mViewtagenExecutor.a(framelayout, cardData.contentMutations, runnable);
    }

    public boolean a(final List newCardData)
    {
        if (!mCardData.isEmpty() && (newCardData == null || newCardData.isEmpty()))
        {
            com.target.a.a.b.b("CardStreamAdapter", "Refusing to replace extant card data with blank card data");
            return false;
        }
        if (b(newCardData))
        {
            com.target.a.a.b.b("CardStreamAdapter", "Refusing to reload card data with identical data");
            return false;
        } else
        {
            com.target.a.a.b.d("CardStreamAdapter", "Replacing adapter data, which will reload the stream");
            mCardData.clear();
            d();
            mHandler.postDelayed(new Runnable() {

                final CardStreamAdapter this$0;
                final List val$newCardData;

                public void run()
                {
                    for (Iterator iterator = newCardData.iterator(); iterator.hasNext(); d(CardStreamAdapter.a(CardStreamAdapter.this).size() - 1))
                    {
                        com.target.ui.fragment.cardstream.b b1 = (com.target.ui.fragment.cardstream.b)iterator.next();
                        CardStreamAdapter.a(CardStreamAdapter.this).add(b1);
                    }

                }

            
            {
                this$0 = CardStreamAdapter.this;
                newCardData = list;
                super();
            }
            }, 120L);
            return true;
        }
    }

    public ViewHolder c(ViewGroup viewgroup, int i)
    {
        return new ViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030025, viewgroup, false));
    }
}
