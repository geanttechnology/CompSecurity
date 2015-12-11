// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.target.mothership.model.common.GiftCardTender;
import com.target.ui.f.c;
import com.target.ui.fragment.account.b.a;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.helper.a.b;

// Referenced classes of package com.target.ui.fragment.account:
//            AccountGiftCardsFragment

public class AccountGiftCardDetailFragment extends BaseNavigationFragment
    implements a
{
    static class Views extends com.target.ui.view.a
    {

        Button buttonDone;
        ImageView ivBarcode;
        TextView tvGiftCardAccessNumber;
        TextView tvGiftCardPrice;
        WebView wvBarcode;

        Views(View view)
        {
            super(view);
        }
    }


    private static final String ARG_GIFT_CARD_TENDER = "gift_card_tender";
    private static final String ENCODING = "UTF-8";
    private static final String GIFT_CARD_HTML_POSTFIX = "\"/></body></html>";
    private static final String GIFT_CARD_HTML_PREFIX = "<html><head><style type='text/css'>body{margin:auto auto;text-align:center;} img{width:100%; height:100%} </style></head><body><img src=\"";
    private static final String TEXT_HTML = "text/html";
    private com.target.ui.fragment.account.c.a mPresenter;
    private Views mViews;

    public AccountGiftCardDetailFragment()
    {
    }

    public static AccountGiftCardDetailFragment a(GiftCardTender giftcardtender)
    {
        AccountGiftCardDetailFragment accountgiftcarddetailfragment = new AccountGiftCardDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("gift_card_tender", giftcardtender);
        accountgiftcarddetailfragment.setArguments(bundle);
        return accountgiftcarddetailfragment;
    }

    static com.target.ui.fragment.account.c.a a(AccountGiftCardDetailFragment accountgiftcarddetailfragment)
    {
        return accountgiftcarddetailfragment.mPresenter;
    }

    private GiftCardTender b()
    {
        return (GiftCardTender)getArguments().getParcelable("gift_card_tender");
    }

    private com.target.ui.fragment.account.c.a b(GiftCardTender giftcardtender)
    {
        return new com.target.ui.fragment.account.c.a(giftcardtender, new b());
    }

    private void c()
    {
        mViews.buttonDone.setOnClickListener(new android.view.View.OnClickListener() {

            final AccountGiftCardDetailFragment this$0;

            public void onClick(View view)
            {
                if (com.target.ui.fragment.account.AccountGiftCardDetailFragment.a(AccountGiftCardDetailFragment.this) != null)
                {
                    com.target.ui.fragment.account.AccountGiftCardDetailFragment.a(AccountGiftCardDetailFragment.this).c();
                }
            }

            
            {
                this$0 = AccountGiftCardDetailFragment.this;
                super();
            }
        });
    }

    public void a()
    {
        c c1;
        if (!Z())
        {
            if ((c1 = m()) != null)
            {
                c1.a(AccountGiftCardsFragment.TAG);
                return;
            }
        }
    }

    public void a(Bitmap bitmap)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.wvBarcode.setVisibility(8);
            mViews.ivBarcode.setVisibility(0);
            mViews.ivBarcode.setImageBitmap(bitmap);
            return;
        }
    }

    public void a(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            s = getResources().getString(0x7f090076, new Object[] {
                s
            });
            mViews.tvGiftCardAccessNumber.setText(s);
            return;
        }
    }

    public void b(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.tvGiftCardPrice.setText(s);
            return;
        }
    }

    public void c(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.ivBarcode.setVisibility(8);
            mViews.wvBarcode.setVisibility(0);
            s = (new StringBuilder()).append("<html><head><style type='text/css'>body{margin:auto auto;text-align:center;} img{width:100%; height:100%} </style></head><body><img src=\"").append(s).append("\"/></body></html>").toString();
            mViews.wvBarcode.loadData(s, "text/html", "UTF-8");
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPresenter = b(b());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onCreateOptionsMenu(menu, menuinflater);
            j(getString(0x7f090075));
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030040, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.wvBarcode.setVerticalScrollbarOverlay(false);
        mViews.wvBarcode.setHorizontalScrollbarOverlay(false);
        c();
        mPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mPresenter = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mPresenter.z_();
    }
}
