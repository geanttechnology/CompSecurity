// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.groupon.models.GenericAmount;
import com.groupon.models.IncentiveTicket;
import com.groupon.models.user.User;
import com.groupon.models.user.UserContainer;
import com.groupon.service.GiftCodesService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function1;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.ReturningFunction1;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class IncentiveTickets extends GrouponActivity
    implements GrouponDialogListener
{
    private class IncentiveTicketHolder
    {

        RadioButton checkBox;
        TextView info;
        TextView name;
        final IncentiveTickets this$0;
        TextView value;

        private IncentiveTicketHolder()
        {
            this$0 = IncentiveTickets.this;
            super();
        }

    }

    private class IncentiveTicketsAdapter extends BaseAdapter
    {

        private int checkedIndex;
        final IncentiveTickets this$0;

        public int getCount()
        {
            if (incentiveTickets != null)
            {
                return incentiveTickets.size();
            } else
            {
                return 0;
            }
        }

        public IncentiveTicket getItem(int i)
        {
            if (incentiveTickets != null)
            {
                return (IncentiveTicket)incentiveTickets.get(i);
            } else
            {
                return null;
            }
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            IncentiveTicket incentiveticket;
            if (view == null)
            {
                view = ((LayoutInflater)getApplicationContext().getSystemService("layout_inflater")).inflate(0x7f030145, viewgroup, false);
                viewgroup = new IncentiveTicketHolder();
                viewgroup.checkBox = (RadioButton)view.findViewById(0x7f1003cc);
                viewgroup.name = (TextView)view.findViewById(0x7f10016b);
                viewgroup.value = (TextView)view.findViewById(0x7f1003cd);
                viewgroup.info = (TextView)view.findViewById(0x7f1003ce);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (IncentiveTicketHolder)view.getTag();
            }
            incentiveticket = getItem(i);
            if (incentiveticket != null)
            {
                RadioButton radiobutton = ((IncentiveTicketHolder) (viewgroup)).checkBox;
                int j;
                boolean flag;
                if (isComingFromCheckout.booleanValue())
                {
                    j = 0;
                } else
                {
                    j = 8;
                }
                radiobutton.setVisibility(j);
                radiobutton = ((IncentiveTicketHolder) (viewgroup)).checkBox;
                if (i == checkedIndex || Strings.equals(incentiveticket.type, selectedTicketType))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                radiobutton.setChecked(flag);
                ((IncentiveTicketHolder) (viewgroup)).name.setText(incentiveticket.name);
                ((IncentiveTicketHolder) (viewgroup)).value.setText(String.format(getString(0x7f080235), new Object[] {
                    incentiveticket.points.getFormattedAmount()
                }));
                ((IncentiveTicketHolder) (viewgroup)).info.setText(String.format(getString(0x7f080234), new Object[] {
                    incentiveticket.minimum_points.getFormattedAmount()
                }));
            }
            return view;
        }

        public void setCheckedIndex(int i)
        {
            checkedIndex = i;
        }

        private IncentiveTicketsAdapter()
        {
            this$0 = IncentiveTickets.this;
            super();
            checkedIndex = -1;
        }

    }


    private static final String INCENTIVE_TICKETS_REMOVE_DIALOG = "incentive_tickets_remove";
    public static final int REQUEST_CODE = 10126;
    private static final String SELECTED_TICKET_POSITION = "selected_ticket_position";
    String dealId;
    TextView emptyView;
    private GiftCodesService giftCodesService;
    private List incentiveTickets;
    private IncentiveTicketsAdapter incentiveTicketsAdapter;
    ListView incentiveTicketsListView;
    Boolean isComingFromCheckout;
    Boolean isUsingGiftCodes;
    ProgressBar loadingView;
    String selectedTicketType;

    public IncentiveTickets()
    {
    }

    private void setAdapter()
    {
        incentiveTicketsAdapter = new IncentiveTicketsAdapter();
        incentiveTicketsListView.setAdapter(incentiveTicketsAdapter);
    }

    private void setListeners()
    {
        incentiveTicketsListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final IncentiveTickets this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
label0:
                {
                    if (isComingFromCheckout.booleanValue())
                    {
                        if (isUsingGiftCodes == null || !isUsingGiftCodes.booleanValue())
                        {
                            break label0;
                        }
                        adapterview = new GrouponDialogFragment();
                        view = new Bundle();
                        view.putInt("dialog_title_res_id", 0x7f080315);
                        view.putInt("dialog_message_res_id", 0x7f080316);
                        view.putInt("dialog_positive_button_text_res_id", 0x7f080426);
                        view.putInt("dialog_negative_button_text_res_id", 0x7f0802a6);
                        view.putInt("selected_ticket_position", i);
                        adapterview.setArguments(view);
                        adapterview.setCancelable(false);
                        GrouponDialogFragment.show(getFragmentManager(), adapterview, "incentive_tickets_remove");
                    }
                    return;
                }
                setResultAndFinish(i, false);
            }

            
            {
                this$0 = IncentiveTickets.this;
                super();
            }
        });
    }

    private void setResultAndFinish(int i, boolean flag)
    {
        IncentiveTicket incentiveticket = incentiveTicketsAdapter.getItem(i);
        boolean flag1 = Strings.equals(incentiveticket.type, selectedTicketType);
        Object obj = incentiveTicketsAdapter;
        if (flag1)
        {
            i = -1;
        }
        ((IncentiveTicketsAdapter) (obj)).setCheckedIndex(i);
        incentiveTicketsAdapter.notifyDataSetChanged();
        Intent intent = new Intent();
        if (flag1)
        {
            obj = null;
        } else
        {
            obj = incentiveticket.type;
        }
        intent.putExtra("incentive_ticket_type", ((String) (obj))).putExtra("removeGiftCodes", flag);
        setResult(-1, intent);
        finish();
        logger.logClick("", "incentive_ticket_selection", "incentive_ticket", (new StringBuilder()).append(dealId).append(",").append(incentiveticket.points.getAmount()).append(",").append(incentiveticket.minimum_points.getAmount()).toString());
    }

    private void toggleViewVisibility(View view, boolean flag)
    {
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f080236));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030146);
        setAdapter();
        setListeners();
        toggleViewVisibility(loadingView, true);
        giftCodesService.getCreditsForUser(new Function1() {

            final IncentiveTickets this$0;

            public void execute(UserContainer usercontainer)
            {
                boolean flag = false;
                incentiveTickets = usercontainer.user.incentiveTickets;
                incentiveTicketsAdapter.notifyDataSetChanged();
                toggleViewVisibility(loadingView, false);
                usercontainer = IncentiveTickets.this;
                TextView textview = emptyView;
                if (incentiveTickets == null || incentiveTickets.size() == 0)
                {
                    flag = true;
                }
                usercontainer.toggleViewVisibility(textview, flag);
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((UserContainer)obj);
            }

            
            {
                this$0 = IncentiveTickets.this;
                super();
            }
        }, new ReturningFunction1() {

            final IncentiveTickets this$0;

            public Boolean execute(Exception exception)
            {
                toggleViewVisibility(loadingView, false);
                exception = IncentiveTickets.this;
                TextView textview = emptyView;
                boolean flag;
                if (incentiveTickets == null || incentiveTickets.size() == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                exception.toggleViewVisibility(textview, flag);
                return Boolean.valueOf(false);
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = IncentiveTickets.this;
                super();
            }
        }, null);
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "incentive_tickets_remove"))
        {
            finish();
        }
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "incentive_tickets_remove"))
        {
            s = getFragmentManager().findFragmentByTag("incentive_tickets_remove");
            if (s != null)
            {
                setResultAndFinish(s.getArguments().getInt("selected_ticket_position"), true);
            }
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }



/*
    static List access$002(IncentiveTickets incentivetickets, List list)
    {
        incentivetickets.incentiveTickets = list;
        return list;
    }

*/



}
