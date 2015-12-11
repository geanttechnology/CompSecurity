// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.home.cards:
//            ListOfSellingDraftsViewModel, ListOfScheduledViewModel, SellingDraftViewModel, ScheduledListingViewModel

public class SellingDraftsContentViewHolder extends ViewHolder
{
    public class DraftContentViewHolder extends ViewHolder
    {

        private final RemoteImageView image;
        private final View placeholderImage;
        private final TextView subtitle;
        final SellingDraftsContentViewHolder this$0;
        private final TextView title;

        public void bind(ViewModel viewmodel)
        {
            super.bind(viewmodel);
            if (!(viewmodel instanceof SellingDraftViewModel)) goto _L2; else goto _L1
_L1:
            SellingDraftViewModel sellingdraftviewmodel = (SellingDraftViewModel)viewmodel;
            if (viewmodel.listener != null && TextUtils.isEmpty(sellingdraftviewmodel.draftTitle))
            {
                sellingdraftviewmodel.draftTitle = resources.getString(0x7f070b92);
            }
            title.setText(sellingdraftviewmodel.draftTitle);
            if (!TextUtils.isEmpty(sellingdraftviewmodel.draftModifiedDate))
            {
                subtitle.setText(resources.getString(0x7f070a04, new Object[] {
                    sellingdraftviewmodel.draftModifiedDate
                }));
            }
            image.setRemoteImageUrl(sellingdraftviewmodel.imageUrl);
_L4:
            setItemState(true);
            return;
_L2:
            if (viewmodel instanceof ScheduledListingViewModel)
            {
                viewmodel = (ScheduledListingViewModel)viewmodel;
                title.setText(((ScheduledListingViewModel) (viewmodel)).title);
                if (((ScheduledListingViewModel) (viewmodel)).date != null)
                {
                    Object obj = DateFormat.getMediumDateFormat(context);
                    java.text.DateFormat dateformat = DateFormat.getTimeFormat(context);
                    obj = context.getString(0x7f070048, new Object[] {
                        ((java.text.DateFormat) (obj)).format(((ScheduledListingViewModel) (viewmodel)).date), dateformat.format(((ScheduledListingViewModel) (viewmodel)).date).toLowerCase(Locale.getDefault())
                    });
                    subtitle.setText(((CharSequence) (obj)));
                } else
                {
                    subtitle.setText("");
                }
                image.setRemoteImageUrl(((ScheduledListingViewModel) (viewmodel)).imageUrl);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void setItemState(boolean flag)
        {
            byte byte0 = 8;
            if (SellingDraftsContentViewHolder.isTablet)
            {
                itemView.setEnabled(flag);
                View view;
                int i;
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                image.setVisibility(i);
                title.setVisibility(i);
                subtitle.setVisibility(i);
                view = placeholderImage;
                if (i == 0)
                {
                    i = byte0;
                } else
                {
                    i = 0;
                }
                view.setVisibility(i);
            }
        }

        public DraftContentViewHolder(View view)
        {
            this$0 = SellingDraftsContentViewHolder.this;
            super(view);
            title = (TextView)view.findViewById(0x7f100108);
            subtitle = (TextView)view.findViewById(0x7f100281);
            image = (RemoteImageView)view.findViewById(0x7f1000fc);
            placeholderImage = view.findViewById(0x7f100282);
            view.setOnClickListener(this);
        }
    }


    protected static boolean isTablet;
    private static final int viewIds[] = {
        0x7f1000fd, 0x7f1000fe, 0x7f1000ff, 0x7f100238, 0x7f100246
    };
    private final Context context;
    private final Spannable draftsTimeoutText;
    private final TextView groupTitle;
    private final Resources resources;
    private final Spannable scheduledTimeoutText;
    public final View separatorView;
    private final Button showMoreButton;
    private final TextView timeoutTextView;
    public final List views = new ArrayList();

    public SellingDraftsContentViewHolder(View view)
    {
        super(view);
        resources = view.getResources();
        context = view.getContext();
        String s = resources.getString(0x7f07046d);
        int i = resources.getColor(0x7f0d00df);
        String s1 = (new StringBuilder()).append(s).append("\n").append(resources.getString(0x7f070469)).toString();
        draftsTimeoutText = new SpannableStringBuilder(s1);
        int k = s.length();
        int l = s1.length();
        draftsTimeoutText.setSpan(new TextAppearanceSpan(context, 0x7f0a0152), k, l, 33);
        draftsTimeoutText.setSpan(new ForegroundColorSpan(i), k, l, 33);
        s = (new StringBuilder()).append(s).append("\n").append(resources.getString(0x7f07046b)).toString();
        scheduledTimeoutText = new SpannableStringBuilder(s);
        l = s.length();
        scheduledTimeoutText.setSpan(new TextAppearanceSpan(context, 0x7f0a0152), k, l, 33);
        scheduledTimeoutText.setSpan(new ForegroundColorSpan(i), k, l, 33);
        isTablet = resources.getBoolean(0x7f0b0006);
        int ai[] = viewIds;
        k = ai.length;
        for (int j = 0; j < k; j++)
        {
            View view1 = view.findViewById(ai[j]);
            if (view1 != null)
            {
                views.add(new DraftContentViewHolder(view1));
            }
        }

        separatorView = view.findViewById(0x7f10029f);
        groupTitle = (TextView)view.findViewById(0x7f10005f);
        timeoutTextView = (TextView)view.findViewById(0x7f10021a);
        showMoreButton = (Button)view.findViewById(0x7f1002a0);
        showMoreButton.setOnClickListener(this);
        itemView.setOnClickListener(this);
        setFullSpan(true);
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        return viewmodel != null && ((viewmodel instanceof ListOfSellingDraftsViewModel) || (viewmodel instanceof ListOfScheduledViewModel));
    }

    public void bind(ViewModel viewmodel)
    {
        List list;
        super.bind(viewmodel);
        list = null;
        if (!(model instanceof ListOfSellingDraftsViewModel)) goto _L2; else goto _L1
_L1:
        viewmodel = (ListOfSellingDraftsViewModel)viewmodel;
        if (TextUtils.isEmpty(timeoutTextView.getText()))
        {
            timeoutTextView.setText(draftsTimeoutText);
        }
        groupTitle.setText(((ListOfSellingDraftsViewModel) (viewmodel)).groupTitle);
        showMoreButton.setText(0x7f0701da);
        list = ((ListOfSellingDraftsViewModel) (viewmodel)).drafts;
_L4:
        for (viewmodel = views.iterator(); viewmodel.hasNext(); ((DraftContentViewHolder)viewmodel.next()).itemView.setVisibility(8)) { }
        break; /* Loop/switch isn't completed */
_L2:
        if (model instanceof ListOfScheduledViewModel)
        {
            viewmodel = (ListOfScheduledViewModel)viewmodel;
            if (TextUtils.isEmpty(timeoutTextView.getText()))
            {
                timeoutTextView.setText(scheduledTimeoutText);
            }
            groupTitle.setText(((ListOfScheduledViewModel) (viewmodel)).groupTitle);
            showMoreButton.setText(0x7f070471);
            list = ((ListOfScheduledViewModel) (viewmodel)).scheduledListings;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (separatorView != null)
        {
            separatorView.setVisibility(8);
        }
        int l = list.size();
        int j = views.size();
        int k = Math.min(j, l);
        viewmodel = timeoutTextView;
        int i;
        boolean flag;
        if (k == 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        viewmodel.setVisibility(i);
        viewmodel = showMoreButton;
        if (k == 0)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        viewmodel.setVisibility(i);
        viewmodel = itemView;
        if (k == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        viewmodel.setClickable(flag);
        if (k > 0)
        {
            if (isTablet)
            {
                i = j;
            } else
            {
                i = k;
            }
            j = 0;
            while (j < i) 
            {
                viewmodel = (DraftContentViewHolder)views.get(j);
                ((DraftContentViewHolder) (viewmodel)).itemView.setVisibility(0);
                if (j < l)
                {
                    viewmodel.bind((ViewModel)list.get(j));
                } else
                {
                    viewmodel.setItemState(false);
                }
                j++;
            }
            if (i > 1 && separatorView != null)
            {
                separatorView.setVisibility(0);
            }
        }
        return;
    }



}
