// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.ebay.android.widget.AdapterView;
import com.ebay.android.widget.Spinner;
import com.ebay.common.Preferences;
import com.ebay.common.TabsAdapter;
import com.ebay.common.net.api.trading.Feedback;
import com.ebay.common.net.api.trading.GetFeedbackNetLoader;
import com.ebay.common.net.api.trading.GetFeedbackResponse;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ItemViewCommonProgressAndError;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseFragment, ViewFeedbackActivity, UserDetailActivity, eBay

public class FeedbackFragment extends BaseFragment
    implements com.ebay.android.widget.AdapterView.OnItemSelectedListener
{
    private class SpinnerAdapter extends ArrayAdapter
    {

        final FeedbackFragment this$0;

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = super.getView(i, null, viewgroup);
            }
            viewgroup = (String)getItem(i);
            TextView textview = (TextView)view.findViewById(0x1020014);
            if (textview != null)
            {
                textview.setText(viewgroup);
            }
            return view;
        }

        public SpinnerAdapter(Context context, int i, List list)
        {
            this$0 = FeedbackFragment.this;
            super(context, i, list);
        }
    }

    private class ViewFeedbackAdapter extends ArrayAdapter
    {

        private final String buyer;
        private final Context context;
        private final String detailsMessage;
        private final LayoutInflater inflater;
        private final String itemNumber;
        private boolean lastPage;
        private final LinkMovementMethod linkMovementMethod = new LinkMovementMethod();
        private int positionForHeader;
        private final String seller;
        final FeedbackFragment this$0;

        private void getMore()
        {
            FeedbackFragment feedbackfragment = FeedbackFragment.this;
            feedbackfragment.currentPage = feedbackfragment.currentPage + 1;
            listView.setSelection(items.size() - 1);
            issueDataRequest(currentPage, position);
        }

        private void resetHeaderPosition()
        {
            positionForHeader = -1;
            if (items == null || items.size() <= 0) goto _L2; else goto _L1
_L1:
            Calendar calendar;
            Calendar calendar1;
            Iterator iterator;
            int i;
            calendar = Calendar.getInstance();
            calendar.add(5, -90);
            calendar1 = Calendar.getInstance();
            i = 0;
            iterator = items.iterator();
_L7:
            if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
            calendar1.setTime(((Feedback)iterator.next()).commentTime);
            if (!calendar1.before(calendar)) goto _L5; else goto _L4
_L4:
            positionForHeader = i;
_L2:
            return;
_L5:
            i++;
            if (true) goto _L7; else goto _L6
_L6:
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            Object obj;
            Feedback feedback;
            int j;
            if (view == null)
            {
                view = inflater.inflate(0x7f03027b, null);
                viewgroup = new ViewHolder();
                viewgroup.feedbackType = (ImageView)view.findViewById(0x7f100356);
                viewgroup.titleTextView = (TextView)view.findViewById(0x7f10005f);
                viewgroup.userTextView = (TextView)view.findViewById(0x7f100865);
                viewgroup.dateTextView = (TextView)view.findViewById(0x7f100866);
                viewgroup.progress = view.findViewById(0x7f100554);
                viewgroup.itemIdTextView = (TextView)view.findViewById(0x7f10040f);
                viewgroup.detailsMessageView = (TextView)view.findViewById(0x7f1003b9);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            feedback = (Feedback)items.get(i);
            obj = ((ViewHolder) (viewgroup)).feedbackType;
            if (feedback.loading)
            {
                j = 8;
            } else
            {
                j = 0;
            }
            ((ImageView) (obj)).setVisibility(j);
            obj = ((ViewHolder) (viewgroup)).titleTextView;
            if (feedback.loading)
            {
                j = 8;
            } else
            {
                j = 0;
            }
            ((TextView) (obj)).setVisibility(j);
            obj = ((ViewHolder) (viewgroup)).userTextView;
            if (feedback.loading)
            {
                j = 8;
            } else
            {
                j = 0;
            }
            ((TextView) (obj)).setVisibility(j);
            obj = ((ViewHolder) (viewgroup)).dateTextView;
            if (feedback.loading)
            {
                j = 8;
            } else
            {
                j = 0;
            }
            ((TextView) (obj)).setVisibility(j);
            obj = ((ViewHolder) (viewgroup)).progress;
            if (feedback.loading)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            ((View) (obj)).setVisibility(j);
            obj = ((ViewHolder) (viewgroup)).itemIdTextView;
            if (feedback.loading && !TextUtils.isEmpty(feedback.itemId))
            {
                j = 0;
            } else
            {
                j = 8;
            }
            ((TextView) (obj)).setVisibility(j);
            ((ViewHolder) (viewgroup)).detailsMessageView.setVisibility(8);
            if (!feedback.loading)
            {
                if (i == positionForHeader)
                {
                    ((ViewHolder) (viewgroup)).detailsMessageView.setText(detailsMessage);
                    ((ViewHolder) (viewgroup)).detailsMessageView.setVisibility(0);
                }
                if ("Positive".equals(feedback.commentType))
                {
                    ((ViewHolder) (viewgroup)).feedbackType.setBackgroundResource(0x7f02021c);
                } else
                if ("Negative".equals(feedback.commentType))
                {
                    ((ViewHolder) (viewgroup)).feedbackType.setBackgroundResource(0x7f020207);
                } else
                if ("Neutral".equals(feedback.commentType))
                {
                    ((ViewHolder) (viewgroup)).feedbackType.setBackgroundResource(0x7f020208);
                }
                ((ViewHolder) (viewgroup)).titleTextView.setText(feedback.commentText);
                if (!TextUtils.isEmpty(feedback.commentingUser))
                {
                    String s = feedback.commentingUser;
                    ViewFeedbackActivity viewfeedbackactivity = parent;
                    Object obj1;
                    if ("Seller".equals(feedback.role))
                    {
                        obj1 = buyer;
                    } else
                    {
                        obj1 = seller;
                    }
                    obj1 = viewfeedbackactivity.getString(0x7f070ba5, new Object[] {
                        obj1, s
                    });
                    if (s.length() >= 4 && "***".equals(s.substring(1, 4)))
                    {
                        ((ViewHolder) (viewgroup)).userTextView.setText(((CharSequence) (obj1)));
                        ((ViewHolder) (viewgroup)).userTextView.setVisibility(0);
                        ((ViewHolder) (viewgroup)).userTextView.setOnClickListener(null);
                        ((ViewHolder) (viewgroup)).userTextView.setClickable(false);
                    } else
                    {
                        int k = ((String) (obj1)).lastIndexOf(s);
                        obj1 = new SpannableString(((CharSequence) (obj1)));
                        ((SpannableString) (obj1)).setSpan(feedback. new ClickableSpan() {

                            final ViewFeedbackAdapter this$1;
                            final Feedback val$feedback;

                            public void onClick(View view)
                            {
                                showUser(feedback);
                            }

            
            {
                this$1 = final_viewfeedbackadapter;
                feedback = Feedback.this;
                super();
            }
                        }, k, s.length() + k, 33);
                        ((ViewHolder) (viewgroup)).userTextView.setText(((CharSequence) (obj1)));
                        ((ViewHolder) (viewgroup)).userTextView.setVisibility(0);
                        ((ViewHolder) (viewgroup)).userTextView.setMovementMethod(linkMovementMethod);
                    }
                }
                if (!TextUtils.isEmpty(feedback.itemId) && !TextUtils.isEmpty(feedback.transactionId) && positionForHeader != -1 && i < positionForHeader)
                {
                    ((ViewHolder) (viewgroup)).itemIdTextView.setText(Html.fromHtml((new StringBuilder()).append(itemNumber).append(" <a href=\"#\">").append(feedback.itemId).append("</a>").toString()));
                    Linkify.addLinks(((ViewHolder) (viewgroup)).itemIdTextView, 1);
                    ((ViewHolder) (viewgroup)).itemIdTextView.setVisibility(0);
                    ((ViewHolder) (viewgroup)).itemIdTextView.setOnClickListener(feedback. new android.view.View.OnClickListener() {

                        final ViewFeedbackAdapter this$1;
                        final Feedback val$feedback;

                        public void onClick(View view)
                        {
                            showItem(feedback);
                        }

            
            {
                this$1 = final_viewfeedbackadapter;
                feedback = Feedback.this;
                super();
            }
                    });
                }
                obj1 = new StringBuilder();
                ((StringBuilder) (obj1)).append(DateFormat.getDateFormat(context).format(feedback.commentTime));
                ((ViewHolder) (viewgroup)).dateTextView.setText(((CharSequence) (obj1)));
            }
            if (i == items.size() - 1 && !requestOutstanding && currentPage < totalPages && !lastPage)
            {
                getMore();
            }
            return view;
        }

        public void notifyDataSetChanged()
        {
            resetHeaderPosition();
            super.notifyDataSetChanged();
        }

        public void setLastPage(boolean flag)
        {
            lastPage = flag;
        }

        ViewFeedbackAdapter(Context context1)
        {
            this$0 = FeedbackFragment.this;
            super(context1, 0x7f03027b, items);
            positionForHeader = -1;
            context = context1;
            inflater = parent.getLayoutInflater();
            seller = context1.getString(0x7f070ba6);
            buyer = context1.getString(0x7f070ba4);
            itemNumber = context1.getString(0x7f070488);
            detailsMessage = getString(0x7f070411, new Object[] {
                "90"
            });
            resetHeaderPosition();
        }
    }

    public class ViewFeedbackAdapter.ViewHolder
    {

        TextView dateTextView;
        TextView detailsMessageView;
        ImageView feedbackType;
        TextView itemIdTextView;
        View progress;
        final ViewFeedbackAdapter this$1;
        TextView titleTextView;
        TextView userTextView;

        public ViewFeedbackAdapter.ViewHolder()
        {
            this$1 = ViewFeedbackAdapter.this;
            super();
        }
    }


    private static final int DEFAULT_POSITION = 0;
    private ViewFeedbackAdapter adapter;
    private String allFeedbackString;
    protected int currentPage;
    protected List items;
    protected ListView listView;
    private String negativeString;
    private String neutralString;
    private TextView noItems;
    private ImageView noItemsImage;
    private View noItemsLayout;
    protected ViewFeedbackActivity parent;
    protected int position;
    private String positiveString;
    protected boolean requestOutstanding;
    protected Spinner spinner;
    protected SpinnerAdapter spinnerAdapter;
    protected int totalPages;
    private ViewGroup viewGroup;

    public FeedbackFragment()
    {
        items = new ArrayList();
        currentPage = 1;
    }

    private int getNoItemsImage()
    {
        int j = 0x7f0201ca;
        int i = j;
        if (spinner != null)
        {
            String s = (String)spinner.getSelectedItem();
            if (getString(0x7f0707a5).equals(s))
            {
                i = 0x7f0201cd;
            } else
            {
                if (getString(0x7f07064f).equals(s))
                {
                    return 0x7f0201cb;
                }
                i = j;
                if (getString(0x7f070650).equals(s))
                {
                    return 0x7f0201cc;
                }
            }
        }
        return i;
    }

    private String getNoItemsText()
    {
        String s1 = getString(0x7f07065b);
        String s = s1;
        if (spinner != null)
        {
            String s2 = (String)spinner.getSelectedItem();
            if (getString(0x7f0707a5).equals(s2))
            {
                s = getString(0x7f07065e);
            } else
            {
                if (getString(0x7f07064f).equals(s2))
                {
                    return getString(0x7f07065c);
                }
                s = s1;
                if (getString(0x7f070650).equals(s2))
                {
                    return getString(0x7f07065d);
                }
            }
        }
        return s;
    }

    protected com.ebay.common.net.api.trading.GetFeedbackRequest.CommentType getCommentType()
    {
        com.ebay.common.net.api.trading.GetFeedbackRequest.CommentType commenttype = com.ebay.common.net.api.trading.GetFeedbackRequest.CommentType.ALL;
        String s = getSpinnerValue();
        if (getString(0x7f0707a5).equals(s))
        {
            commenttype = com.ebay.common.net.api.trading.GetFeedbackRequest.CommentType.POSITIVE;
        } else
        {
            if (getString(0x7f07064f).equals(s))
            {
                return com.ebay.common.net.api.trading.GetFeedbackRequest.CommentType.NEGATIVE;
            }
            if (getString(0x7f070650).equals(s))
            {
                return com.ebay.common.net.api.trading.GetFeedbackRequest.CommentType.NEUTRAL;
            }
        }
        return commenttype;
    }

    protected com.ebay.common.net.api.trading.GetFeedbackRequest.FeedbackType getFeedbackType()
    {
        if (position == 0)
        {
            return com.ebay.common.net.api.trading.GetFeedbackRequest.FeedbackType.RECEIVED_AS_SELLER;
        } else
        {
            return com.ebay.common.net.api.trading.GetFeedbackRequest.FeedbackType.RECEIVED_AS_BUYER;
        }
    }

    public String getSpinnerValue()
    {
        if (spinner == null)
        {
            return getString(0x7f070166);
        } else
        {
            return (String)spinner.getSelectedItem();
        }
    }

    protected void issueDataRequest(int i, int j)
    {
        requestOutstanding = true;
        ItemViewCommonProgressAndError.showLayouts(parent, viewGroup, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
        parent.issueDataRequest(i, j, getCommentType(), getFeedbackType());
    }

    public void onCreate(Bundle bundle)
    {
        int i = 0;
        super.onCreate(bundle);
        setHasOptionsMenu(false);
        setRetainInstance(true);
        bundle = getArguments();
        if (bundle != null)
        {
            i = bundle.getInt(TabsAdapter.EXTRA_POSITION, 0);
        }
        position = i;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewGroup = (ViewGroup)layoutinflater.inflate(0x7f0300aa, null);
        allFeedbackString = getString(0x7f070166);
        positiveString = getString(0x7f0707a5);
        neutralString = getString(0x7f070650);
        negativeString = getString(0x7f07064f);
        parent = (ViewFeedbackActivity)getActivity();
        spinner = (Spinner)viewGroup.findViewById(0x7f1001bb);
        layoutinflater = allFeedbackString;
        viewgroup = positiveString;
        bundle = neutralString;
        String s = negativeString;
        spinnerAdapter = new SpinnerAdapter(parent, 0x1090008, Arrays.asList(new String[] {
            layoutinflater, viewgroup, bundle, s
        }));
        spinnerAdapter.setDropDownViewResource(0x1090009);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);
        adapter = new ViewFeedbackAdapter(parent);
        listView = (ListView)viewGroup.findViewById(0x102000a);
        listView.setAdapter(adapter);
        noItems = (TextView)viewGroup.findViewById(0x7f1001be);
        noItemsImage = (ImageView)viewGroup.findViewById(0x7f1001bd);
        noItemsLayout = viewGroup.findViewById(0x7f1001bc);
        spinner.setSelection(parent.getInitialType().value, false);
        return viewGroup;
    }

    protected void onGetFeedbackComplete(GetFeedbackNetLoader getfeedbacknetloader)
    {
        byte byte0 = 8;
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        requestOutstanding = false;
        ItemViewCommonProgressAndError.showLayouts(parent, viewGroup, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.NORMAL);
        if (!getfeedbacknetloader.isError() && getfeedbacknetloader.getResponse() != null && adapter != null)
        {
            adapter.setNotifyOnChange(false);
            if (items == null)
            {
                items = new ArrayList();
            }
            Object obj;
            int i;
            if (((GetFeedbackResponse)getfeedbacknetloader.getResponse()).feedbackList != null)
            {
                Integer integer = parent.getMonths();
                Calendar calendar = Calendar.getInstance();
                if (integer != null)
                {
                    calendar.add(2, integer.intValue() * -1);
                }
                boolean flag = false;
                for (Iterator iterator = ((GetFeedbackResponse)getfeedbacknetloader.getResponse()).feedbackList.iterator(); iterator.hasNext();)
                {
                    Feedback feedback = (Feedback)iterator.next();
                    if (integer == null || feedback.commentTime.getTime() >= calendar.getTime().getTime())
                    {
                        items.add(feedback);
                    } else
                    {
                        flag = true;
                    }
                }

                adapter.setLastPage(flag);
            } else
            {
                items.clear();
            }
            if (items.isEmpty())
            {
                noItems.setText(getNoItemsText());
                noItemsImage.setImageResource(getNoItemsImage());
            }
            obj = noItemsLayout;
            if (items.isEmpty())
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((View) (obj)).setVisibility(i);
            obj = listView;
            if (items.isEmpty())
            {
                i = byte0;
            } else
            {
                i = 0;
            }
            ((ListView) (obj)).setVisibility(i);
            adapter.notifyDataSetChanged();
            totalPages = ((GetFeedbackResponse)getfeedbacknetloader.getResponse()).totalNumberOfPages;
            return;
        }
        if (EbayErrorUtil.userNotLoggedIn(getfeedbacknetloader.getServiceErrorsAndWarnings()) && MyApp.getPrefs().isSignedIn())
        {
            parent.handleIafTokenExpiration();
            return;
        } else
        {
            ItemViewCommonProgressAndError.showLayouts(parent, viewGroup, ItemViewCommonProgressAndError.updateLayoutForLoaderError(parent, getfeedbacknetloader));
            return;
        }
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        getFwLoaderManager().cancelAll(true);
        items.clear();
        noItemsLayout.setVisibility(8);
        currentPage = 1;
        issueDataRequest(currentPage, position);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    public void onTabChanged()
    {
        getFwLoaderManager().cancelAll(true);
        ItemViewCommonProgressAndError.showLayouts(parent, viewGroup, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.NORMAL);
        if (items == null || items.size() == 0)
        {
            noItemsLayout.setVisibility(8);
            issueDataRequest(currentPage, position);
        }
    }

    public void showItem(Feedback feedback)
    {
        com.ebay.common.ConstantsCommon.ItemKind itemkind;
        if (!"Seller".equals(feedback.role))
        {
            break MISSING_BLOCK_LABEL_39;
        }
        itemkind = com.ebay.common.ConstantsCommon.ItemKind.Sold;
_L1:
        long l = Long.parseLong(feedback.itemId);
        ItemViewActivity.StartActivity(parent, l, feedback.transactionId, itemkind);
        return;
        try
        {
            itemkind = com.ebay.common.ConstantsCommon.ItemKind.Won;
        }
        // Misplaced declaration of an exception variable
        catch (Feedback feedback)
        {
            Log.e("ViewFeedback", "showItem exception", feedback);
            return;
        }
          goto _L1
    }

    public void showUser(Feedback feedback)
    {
        boolean flag = true;
        ViewFeedbackActivity viewfeedbackactivity = parent;
        feedback = feedback.commentingUser;
        if (position != 1)
        {
            flag = false;
        }
        UserDetailActivity.StartActivity(viewfeedbackactivity, feedback, null, null, flag);
        if (!eBay.IsViewFeedbackLimited())
        {
            parent.finish();
        }
    }
}
