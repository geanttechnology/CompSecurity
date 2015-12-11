// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.groupon.models.division.Division;
import com.groupon.models.emailsubscription.EmailSubscription;
import com.groupon.models.emailsubscription.EmailSubscriptionsContainer;
import com.groupon.service.EmailSubscriptionsService;
import com.groupon.service.countryanddivision.DivisionsService;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.view.EmailSubscriptionItemView;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            GrouponListActivity

public class EmailSubscriptions extends GrouponListActivity
{
    private class EmailSubscriptionArrayAdapter extends ArrayAdapter
    {

        private final List allSubscriptions;
        final EmailSubscriptions this$0;

        public int getCount()
        {
            return allSubscriptions.size();
        }

        public EmailSubscription getItem(int i)
        {
            return (EmailSubscription)allSubscriptions.get(i);
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
            if (view instanceof EmailSubscriptionItemView)
            {
                view = (EmailSubscriptionItemView)view;
            } else
            {
                view = new EmailSubscriptionItemView(getContext());
            }
            viewgroup = getItem(i);
            view.setClickable(false);
            view.setSubscription(viewgroup);
            return view;
        }

        public EmailSubscriptionArrayAdapter(List list)
        {
            this$0 = EmailSubscriptions.this;
            super(EmailSubscriptions.this, 0x7f0300d6, 0x7f100280, list);
            allSubscriptions = list;
        }
    }

    private class EmailSubscriptionOnClickListener
        implements android.widget.AdapterView.OnItemClickListener
    {

        final EmailSubscriptions this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (view instanceof EmailSubscriptionItemView)
            {
                ((EmailSubscriptionItemView)view).toggleStateWithApiCall(i. new Function1() {

                    final EmailSubscriptionOnClickListener this$1;
                    final int val$position;

                    public void execute(EmailSubscription emailsubscription)
                    {
                        if (emailsubscription != null)
                        {
                            allSubscriptions.set(position, emailsubscription);
                        }
                    }

                    public volatile void execute(Object obj)
                        throws Exception
                    {
                        execute((EmailSubscription)obj);
                    }

            
            {
                this$1 = final_emailsubscriptiononclicklistener;
                position = I.this;
                super();
            }
                });
            }
        }

        private EmailSubscriptionOnClickListener()
        {
            this$0 = EmailSubscriptions.this;
            super();
        }

    }

    private class EmailSubscriptionOnRefreshListener
        implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    {

        final EmailSubscriptions this$0;

        public void onRefresh()
        {
            doRefreshSubscriptions();
        }

        private EmailSubscriptionOnRefreshListener()
        {
            this$0 = EmailSubscriptions.this;
            super();
        }

    }


    private ArrayAdapter adapter;
    private List allSubscriptions;
    private DeviceInfoUtil deviceInfoUtil;
    private DivisionsService divisionService;
    private EmailSubscriptionsService emailSubscriptionsService;
    SwipeRefreshLayout swipeLayout;

    public EmailSubscriptions()
    {
    }

    private void doRefreshSubscriptions()
    {
        final ArrayList userSubscriptions = new ArrayList();
        emailSubscriptionsService.getEmaiSubscriptionsNoProgressBar(new Function1() {

            final EmailSubscriptions this$0;
            final List val$userSubscriptions;

            public void execute(EmailSubscriptionsContainer emailsubscriptionscontainer)
            {
                userSubscriptions.clear();
                userSubscriptions.addAll(emailsubscriptionscontainer.emailSubscriptions);
                resetAllSubscriptions(allSubscriptions);
                Ln.d("SUBSCRIPTIONS: %s", new Object[] {
                    userSubscriptions
                });
                emailsubscriptionscontainer = userSubscriptions.iterator();
label0:
                do
                {
                    if (!emailsubscriptionscontainer.hasNext())
                    {
                        break;
                    }
                    EmailSubscription emailsubscription = (EmailSubscription)emailsubscriptionscontainer.next();
                    Iterator iterator = allSubscriptions.iterator();
                    EmailSubscription emailsubscription1;
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            continue label0;
                        }
                        emailsubscription1 = (EmailSubscription)iterator.next();
                    } while (!emailsubscription1.equals(emailsubscription));
                    Ln.d("SUBSCRIPTIONS: %s, %s", new Object[] {
                        emailsubscription.id, emailsubscription.emailAddress
                    });
                    emailsubscription1.id = emailsubscription.id;
                    emailsubscription1.emailAddress = emailsubscription.emailAddress;
                    swipeLayout.setRefreshing(false);
                } while (true);
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((EmailSubscriptionsContainer)obj);
            }

            
            {
                this$0 = EmailSubscriptions.this;
                userSubscriptions = list;
                super();
            }
        }, null, new Function0() {

            final EmailSubscriptions this$0;

            public void execute()
            {
                Ln.d("SUBSCRIPTIONS: finally", new Object[0]);
                adapter.notifyDataSetChanged();
                swipeLayout.setRefreshing(false);
            }

            
            {
                this$0 = EmailSubscriptions.this;
                super();
            }
        });
    }

    private void resetAllSubscriptions(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            EmailSubscription emailsubscription = (EmailSubscription)list.next();
            emailsubscription.emailAddress = "";
            emailsubscription.id = "";
        }

    }

    private void setupSubscriptions()
    {
        allSubscriptions = new ArrayList();
        Object obj = divisionService.getDivisions();
        adapter = new EmailSubscriptionArrayAdapter(allSubscriptions);
        getListView().setOnItemClickListener(new EmailSubscriptionOnClickListener());
        getListView().setAdapter(adapter);
        EmailSubscription emailsubscription;
        for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); allSubscriptions.add(emailsubscription))
        {
            Division division = (Division)((Iterator) (obj)).next();
            emailsubscription = new EmailSubscription();
            emailsubscription.division = division;
        }

        Collections.sort(allSubscriptions, new Comparator() {

            final EmailSubscriptions this$0;

            public int compare(EmailSubscription emailsubscription1, EmailSubscription emailsubscription2)
            {
                return Collator.getInstance(deviceInfoUtil.getDeviceLocale()).compare(emailsubscription1.division.name, emailsubscription2.division.name);
            }

            public volatile int compare(Object obj1, Object obj2)
            {
                return compare((EmailSubscription)obj1, (EmailSubscription)obj2);
            }

            
            {
                this$0 = EmailSubscriptions.this;
                super();
            }
        });
        doRefreshSubscriptions();
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f080286));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle(0x7f080286);
        setContentView(0x7f0300d7);
        setupSubscriptions();
        swipeLayout.setOnRefreshListener(new EmailSubscriptionOnRefreshListener());
    }





}
