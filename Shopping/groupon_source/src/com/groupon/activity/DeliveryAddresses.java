// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.loader.DealLoaderCallbacks;
import com.groupon.models.LocationsContainer;
import com.groupon.models.country.Country;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.models.shippingFields.RegionMX;
import com.groupon.models.shippingFields.ShippingSelectValue;
import com.groupon.models.shippingFields.SpecialShippingFieldsCLCO;
import com.groupon.models.user.User;
import com.groupon.models.user.UserContainer;
import com.groupon.service.ShippingService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.DealUtils;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import com.groupon.view.DealCardCompact;
import com.groupon.view.GrouponCheckMark;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory

public class DeliveryAddresses extends GrouponActivity
{

    private static final String DASH = " - ";
    public static final int REQUEST_CODE = 10122;
    View addAddressButton;
    TextView addAddressLabel;
    ViewGroup addressesContainer;
    View addressesSection;
    String cartDealImageUrl;
    Channel channel;
    private CurrentCountryManager currentCountryManager;
    DealCardCompact dealCardCompact;
    String dealId;
    DealBreakdownAddress defaultAddress;
    private IntentFactory intentFactory;
    boolean isShippingAddress;
    private boolean isUSACompatible;
    Integer itemsCount;
    private LayoutInflater layoutInflater;
    String maxCartDiscount;
    String optionId;
    private SharedPreferences prefs;
    ProgressBar progressBar;
    View selectedLabel;
    private ShippingService shippingService;

    public DeliveryAddresses()
    {
    }

    private void addDetailsSeparator()
    {
        if (addressesContainer.getChildCount() > 0)
        {
            layoutInflater.inflate(0x7f0301ae, addressesContainer);
        }
    }

    private void filterAddressesBasedOnRegionAndLocation(List list, HashMap hashmap, List list1)
    {
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            final DealBreakdownAddress location = (DealBreakdownAddress)iterator.next();
            Object obj = location.shipping_state;
            int j = list.size();
            if (list1.contains(obj))
            {
                obj = (List)hashmap.get(obj);
                if (obj != null && !((List) (obj)).isEmpty())
                {
                    obj = ((List) (obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        if (Strings.equals(((ShippingSelectValue)((Iterator) (obj)).next()).value, location.shipping_district))
                        {
                            ViewGroup viewgroup = addressesContainer;
                            int i;
                            if (isUSACompatible)
                            {
                                i = 0x7f0301e2;
                            } else
                            {
                                i = 0x7f0301e1;
                            }
                            getBasicListItem(viewgroup, i, location.locationString, location.shipping_name, location, new android.view.View.OnClickListener() {

                                final DeliveryAddresses this$0;
                                final DealBreakdownAddress val$location;

                                public void onClick(View view)
                                {
                                    shippingService.store(location.id);
                                    setResultAndFinish();
                                }

            
            {
                this$0 = DeliveryAddresses.this;
                location = dealbreakdownaddress;
                super();
            }
                            }, new android.view.View.OnClickListener() {

                                final DeliveryAddresses this$0;
                                final DealBreakdownAddress val$location;

                                public void onClick(View view)
                                {
                                    startAddEditShippingAddressActivity(location);
                                }

            
            {
                this$0 = DeliveryAddresses.this;
                location = dealbreakdownaddress;
                super();
            }
                            });
                            if (j > 1)
                            {
                                addDetailsSeparator();
                            }
                        }
                    }
                }
            }
        }

    }

    private View getBasicListItem(ViewGroup viewgroup, int i, String s, String s1, android.view.View.OnClickListener onclicklistener, DealBreakdownAddress dealbreakdownaddress)
    {
        boolean flag;
        flag = false;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        viewgroup = getBasicListItem(viewgroup, i, s, s1, onclicklistener);
        if (!isUSACompatible) goto _L2; else goto _L1
_L1:
        s = (GrouponCheckMark)viewgroup.findViewById(0x7f10050c);
        if (s != null)
        {
            s.setUncheckedStateVisibility(false);
            s.setChecked(isSameAddressAsPrefs(dealbreakdownaddress));
        }
_L4:
        return viewgroup;
_L2:
        s = (ImageView)viewgroup.findViewById(0x7f10050b);
        if (s == null) goto _L4; else goto _L3
_L3:
        s.setImageResource(0x7f020066);
        if (isSameAddressAsPrefs(dealbreakdownaddress))
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 4;
        }
        s.setVisibility(i);
        return viewgroup;
        return null;
    }

    private void handleCheckMarks(View view)
    {
        int i = 0;
        do
        {
label0:
            {
                if (i < addressesContainer.getChildCount())
                {
                    GrouponCheckMark grouponcheckmark = (GrouponCheckMark)addressesContainer.getChildAt(i).findViewById(0x7f10050c);
                    if (grouponcheckmark == null || !grouponcheckmark.isChecked())
                    {
                        break label0;
                    }
                    grouponcheckmark.setChecked(false, true);
                }
                ((GrouponCheckMark)view.findViewById(0x7f10050c)).setChecked(true, true, new AnimatorListenerAdapter() {

                    final DeliveryAddresses this$0;

                    public void onAnimationEnd(Animator animator)
                    {
                        super.onAnimationEnd(animator);
                        setResultAndFinish();
                    }

            
            {
                this$0 = DeliveryAddresses.this;
                super();
            }
                });
                return;
            }
            i++;
        } while (true);
    }

    private boolean isSameAddressAsPrefs(DealBreakdownAddress dealbreakdownaddress)
    {
        return Strings.equalsIgnoreCase(prefs.getString("preferredShippingName", ""), dealbreakdownaddress.name) && Strings.equalsIgnoreCase(prefs.getString("preferredShippingAddr1", ""), dealbreakdownaddress.address1) && Strings.equalsIgnoreCase(prefs.getString("preferredShippingCity", ""), dealbreakdownaddress.city);
    }

    private boolean isSameAddressAsPrefs(String s)
    {
        return Strings.equalsIgnoreCase(prefs.getString("preferredShippingLocationId", null), s);
    }

    private void onFinally()
    {
        if (!currentCountryManager.getCurrentCountry().isLATAMCompatible())
        {
            progressBar.setVisibility(8);
        }
    }

    private void onSuccess(List list)
    {
        int j;
        boolean flag1;
        j = list.size();
        int i;
        boolean flag;
        if (j > 0 && !currentCountryManager.getCurrentCountry().isColombia() && !currentCountryManager.getCurrentCountry().isChile())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        if (addressesSection != null)
        {
            addressesSection.setVisibility(i);
            addressesContainer.setVisibility(i);
        } else
        if (!currentCountryManager.getCurrentCountry().isChile() && !currentCountryManager.getCurrentCountry().isColombia())
        {
            addressesContainer.setVisibility(i);
        }
        flag = currentCountryManager.getCurrentCountry().isLATAMCompatible();
        flag1 = currentCountryManager.getCurrentCountry().isJapan();
        if (!flag) goto _L2; else goto _L1
_L1:
        if (currentCountryManager.getCurrentCountry().isChile() || currentCountryManager.getCurrentCountry().isColombia())
        {
            processLocationsCLCO(list);
        } else
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                processLocationLatam((DealBreakdownAddress)list.next());
                if (j > 1)
                {
                    addDetailsSeparator();
                }
            }
        }
_L4:
        return;
_L2:
        if (!flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        list = list.iterator();
        while (list.hasNext()) 
        {
            processLocationJapan((DealBreakdownAddress)list.next());
            if (j > 1)
            {
                addDetailsSeparator();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        list = list.iterator();
        while (list.hasNext()) 
        {
            processLocation((DealBreakdownAddress)list.next());
            if (j > 1)
            {
                addDetailsSeparator();
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private void processLocation(final DealBreakdownAddress location)
    {
        ViewGroup viewgroup = addressesContainer;
        int i;
        if (isUSACompatible)
        {
            i = 0x7f0301e0;
        } else
        {
            i = 0x7f0301df;
        }
        getBasicListItem(viewgroup, i, shippingService.getAsJoin(location, false, true, false), location.name, new android.view.View.OnClickListener() {

            final DeliveryAddresses this$0;
            final DealBreakdownAddress val$location;

            public void onClick(View view)
            {
                shippingService.storeMultipleShipping(location);
                if (isUSACompatible)
                {
                    handleCheckMarks(view);
                    return;
                } else
                {
                    setResultAndFinish();
                    return;
                }
            }

            
            {
                this$0 = DeliveryAddresses.this;
                location = dealbreakdownaddress;
                super();
            }
        }, location);
    }

    private void processLocationJapan(final DealBreakdownAddress location)
    {
        ViewGroup viewgroup = addressesContainer;
        int i;
        if (isUSACompatible)
        {
            i = 0x7f0301e2;
        } else
        {
            i = 0x7f0301e1;
        }
        getBasicListItem(viewgroup, i, shippingService.getAsJoin(location), shippingService.getFullName(location), location, new android.view.View.OnClickListener() {

            final DeliveryAddresses this$0;
            final DealBreakdownAddress val$location;

            public void onClick(View view)
            {
                shippingService.store(location.id);
                setResultAndFinish();
            }

            
            {
                this$0 = DeliveryAddresses.this;
                location = dealbreakdownaddress;
                super();
            }
        }, new android.view.View.OnClickListener() {

            final DeliveryAddresses this$0;
            final DealBreakdownAddress val$location;

            public void onClick(View view)
            {
                startAddEditShippingAddressActivity(location);
            }

            
            {
                this$0 = DeliveryAddresses.this;
                location = dealbreakdownaddress;
                super();
            }
        });
    }

    private void processLocationsCLCO(final List locations)
    {
        shippingService.getShippingFieldsCLCO(dealId, new Function1() {

            final DeliveryAddresses this$0;
            final List val$locations;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((List)obj);
            }

            public void execute(List list)
            {
                Object obj = shippingService.getSpecialShippingFieldsCLCO(list);
                list = ((SpecialShippingFieldsCLCO) (obj)).getAvailableRegionsForCurrentDeal();
                obj = ((SpecialShippingFieldsCLCO) (obj)).getAvailableLocationsForCurrentDeal();
                filterAddressesBasedOnRegionAndLocation(locations, ((HashMap) (obj)), list);
                list = addressesContainer;
                int i;
                if (addressesContainer.getChildCount() > 0)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                list.setVisibility(i);
            }

            
            {
                this$0 = DeliveryAddresses.this;
                locations = list;
                super();
            }
        }, null, new Function0() {

            final DeliveryAddresses this$0;

            public void execute()
                throws RuntimeException
            {
                byte byte0 = 8;
                progressBar.setVisibility(8);
                if (addressesContainer.getChildCount() > 0)
                {
                    byte0 = 0;
                }
                if (addressesSection != null)
                {
                    addressesSection.setVisibility(byte0);
                }
                addressesContainer.setVisibility(byte0);
            }

            
            {
                this$0 = DeliveryAddresses.this;
                super();
            }
        });
    }

    private void setDealCardCompact()
    {
        boolean flag;
label0:
        {
            if (isUSACompatible)
            {
                if (itemsCount != null && itemsCount.intValue() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label0;
                }
                dealCardCompact.setShoppingCartInfo(itemsCount.intValue(), maxCartDiscount, cartDealImageUrl);
            }
            return;
        }
        dealCardCompact.setLoading(true);
        getLoaderManager().initLoader(0, null, new DealLoaderCallbacks(dealId, flag) {

            final DeliveryAddresses this$0;
            final boolean val$isCartExperience;

            public void onDealLoaded(Deal deal)
            {
                dealCardCompact.setInfo(new DealSummary(deal, channel), DealUtils.getOption(deal, optionId));
            }

            public void onLoadFinished(Loader loader, Deal deal)
            {
                boolean flag1 = false;
                super.onLoadFinished(loader, deal);
                dealCardCompact.setLoading(false);
                loader = dealCardCompact;
                int i = ((flag1) ? 1 : 0);
                if (deal == null)
                {
                    if (isCartExperience)
                    {
                        i = ((flag1) ? 1 : 0);
                    } else
                    {
                        i = 8;
                    }
                }
                loader.setVisibility(i);
            }

            public volatile void onLoadFinished(Loader loader, Object obj)
            {
                onLoadFinished(loader, (Deal)obj);
            }

            
            {
                this$0 = DeliveryAddresses.this;
                isCartExperience = flag;
                super(final_context, s);
            }
        });
    }

    private boolean shouldSendDefaultAddress()
    {
        return !currentCountryManager.getCurrentCountry().isJapan() && !currentCountryManager.getCurrentCountry().isLATAMCompatible();
    }

    private void startAddEditShippingAddressActivity(DealBreakdownAddress dealbreakdownaddress)
    {
        IntentFactory intentfactory = intentFactory;
        boolean flag = isShippingAddress;
        String s = dealId;
        String s1 = optionId;
        Channel channel1 = channel;
        int i;
        if (itemsCount != null)
        {
            i = itemsCount.intValue();
        } else
        {
            i = 0;
        }
        startActivityForResult(intentfactory.newShippingAddressIntent(dealbreakdownaddress, flag, s, s1, channel1, i, maxCartDiscount, cartDealImageUrl), 10119);
    }

    protected View getBasicListItem(ViewGroup viewgroup, int i, String s, String s1, android.view.View.OnClickListener onclicklistener)
    {
        if (i > 0)
        {
            View view = layoutInflater.inflate(i, viewgroup, false);
            TextView textview = (TextView)view.findViewById(0x7f1002d3);
            boolean flag;
            if (Strings.notEmpty(s))
            {
                textview.setText(s);
            } else
            {
                textview.setVisibility(8);
            }
            s = (TextView)view.findViewById(0x7f100249);
            if (Strings.notEmpty(s1))
            {
                s.setText(s1);
            } else
            {
                s.setVisibility(8);
            }
            if (onclicklistener != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setClickable(flag);
            view.setFocusable(flag);
            view.setFocusableInTouchMode(false);
            view.setOnClickListener(onclicklistener);
            viewgroup.addView(view);
            return view;
        } else
        {
            return null;
        }
    }

    protected View getBasicListItem(ViewGroup viewgroup, int i, String s, String s1, DealBreakdownAddress dealbreakdownaddress, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1)
    {
        if (i > 0)
        {
            viewgroup = getBasicListItem(viewgroup, i, s, s1, onclicklistener);
            s = viewgroup.findViewById(0x7f10050d);
            if (onclicklistener1 != null)
            {
                s.setOnClickListener(onclicklistener1);
            } else
            {
                s.setVisibility(8);
            }
            s = (TextView)viewgroup.findViewById(0x7f10050e);
            if (s != null)
            {
                s.setText((new StringBuilder()).append(" - ").append(getString(0x7f080364)).toString());
                if (isSameAddressAsPrefs(dealbreakdownaddress.id))
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                s.setVisibility(i);
            }
            return viewgroup;
        } else
        {
            return null;
        }
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        if (isUSACompatible)
        {
            bundle = getString(0x7f08035f);
        } else
        {
            bundle = getString(0x7f080049);
        }
        setToolbarTitle(bundle);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 10119 && j == -1)
        {
            setResultAndFinish();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        isUSACompatible = currentCountryManager.getCurrentCountry().isUSACompatible();
        int i;
        if (isUSACompatible)
        {
            i = 0x7f0300cf;
        } else
        {
            i = 0x7f0300ce;
        }
        setContentView(i);
        setDealCardCompact();
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            shippingService.getShippingAddresses(new Function1() {

                final DeliveryAddresses this$0;

                public void execute(UserContainer usercontainer)
                {
                    onSuccess(usercontainer.user.shippingAddresses);
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((UserContainer)obj);
                }

            
            {
                this$0 = DeliveryAddresses.this;
                super();
            }
            }, null, new Function0() {

                final DeliveryAddresses this$0;

                public void execute()
                {
                    onFinally();
                }

            
            {
                this$0 = DeliveryAddresses.this;
                super();
            }
            });
        } else
        {
            shippingService.getLocations(new Function1() {

                final DeliveryAddresses this$0;

                public void execute(LocationsContainer locationscontainer)
                {
                    onSuccess(locationscontainer.getLocations());
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((LocationsContainer)obj);
                }

            
            {
                this$0 = DeliveryAddresses.this;
                super();
            }
            }, new ReturningFunction1() {

                final DeliveryAddresses this$0;

                public Boolean execute(Exception exception)
                {
                    if (currentCountryManager.getCurrentCountry().isLATAMCompatible())
                    {
                        progressBar.setVisibility(8);
                    }
                    return null;
                }

                public volatile Object execute(Object obj)
                    throws Exception
                {
                    return execute((Exception)obj);
                }

            
            {
                this$0 = DeliveryAddresses.this;
                super();
            }
            }, new Function0() {

                final DeliveryAddresses this$0;

                public void execute()
                {
                    onFinally();
                }

            
            {
                this$0 = DeliveryAddresses.this;
                super();
            }
            });
        }
        bundle = addAddressLabel;
        if (isUSACompatible)
        {
            i = 0x7f080050;
        } else
        {
            i = 0x7f080049;
        }
        bundle.setText(i);
        addAddressButton.setOnClickListener(new android.view.View.OnClickListener() {

            final DeliveryAddresses this$0;

            public void onClick(View view)
            {
                DeliveryAddresses deliveryaddresses = DeliveryAddresses.this;
                if (shouldSendDefaultAddress())
                {
                    view = defaultAddress;
                } else
                {
                    view = null;
                }
                deliveryaddresses.startAddEditShippingAddressActivity(view);
            }

            
            {
                this$0 = DeliveryAddresses.this;
                super();
            }
        });
    }

    protected void processLocationLatam(final DealBreakdownAddress location)
    {
        shippingService.getLocationsByPostalCodeMX(this, location.shipping_postal_code, new Function1() {

            final DeliveryAddresses this$0;
            final DealBreakdownAddress val$location;

            public void execute(RegionMX regionmx)
            {
                progressBar.setVisibility(8);
                DeliveryAddresses deliveryaddresses = DeliveryAddresses.this;
                ViewGroup viewgroup = addressesContainer;
                int i;
                if (isUSACompatible)
                {
                    i = 0x7f0301e2;
                } else
                {
                    i = 0x7f0301e1;
                }
                deliveryaddresses.getBasicListItem(viewgroup, i, shippingService.getAsJoin(location, regionmx.stateName, regionmx.name, false), location.shipping_name, location, new android.view.View.OnClickListener() {

                    final _cls10 this$1;

                    public void onClick(View view)
                    {
                        shippingService.store(location.id);
                        setResultAndFinish();
                    }

            
            {
                this$1 = _cls10.this;
                super();
            }
                }, new android.view.View.OnClickListener() {

                    final _cls10 this$1;

                    public void onClick(View view)
                    {
                        startAddEditShippingAddressActivity(location);
                    }

            
            {
                this$1 = _cls10.this;
                super();
            }
                });
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((RegionMX)obj);
            }

            
            {
                this$0 = DeliveryAddresses.this;
                location = dealbreakdownaddress;
                super();
            }
        }, new ReturningFunction1() {

            final DeliveryAddresses this$0;

            public Boolean execute(Exception exception)
                throws RuntimeException
            {
                progressBar.setVisibility(8);
                return Boolean.valueOf(true);
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = DeliveryAddresses.this;
                super();
            }
        }, null);
    }

    protected void setResultAndFinish()
    {
        setResult(-1);
        finish();
    }









}
