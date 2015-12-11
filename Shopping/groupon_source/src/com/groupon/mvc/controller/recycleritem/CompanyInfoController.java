// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.groupon.activity.IntentFactory;
import com.groupon.callbacks.OnCompanyInfoEventListener;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Location;
import com.groupon.db.models.Merchant;
import com.groupon.db.models.Option;
import com.groupon.db.models.Rating;
import com.groupon.models.country.Country;
import com.groupon.mvc.model.CompanyInfo;
import com.groupon.service.AddressService;
import com.groupon.service.LocationService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CollectionUtils;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.GeoPoint;
import com.groupon.util.RedemptionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class CompanyInfoController extends RecyclerItemViewController
{
    private class OnCompanyInfoViewEventListener
        implements OnCompanyInfoEventListener
    {

        final CompanyInfoController this$0;

        public void onAddressClick(View view, String s)
        {
            view = String.format("https://maps.google.com/maps?f=d&daddr=%s", new Object[] {
                Uri.encode(s)
            });
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(view)));
        }

        public void onMapViewClick(View view, double d, double d1, String s)
        {
            view = new ArrayList();
            view.add(closestLocation);
            context.startActivity(intentFactory.newShowOnMapIntent(view, s, 0));
        }

        public void onMultipleLocationsClick(View view)
        {
            context.startActivity(intentFactory.newShowOnMapIntent(redemptionLocations, ((CompanyInfo)model).vendorName, getClosestLocationIndex()));
        }

        public void onPhoneClick(View view, String s)
        {
            try
            {
                view = new Intent("android.intent.action.DIAL", Uri.parse(String.format("tel:%s", new Object[] {
                    s
                })));
                context.startActivity(Intent.createChooser(view, context.getString(0x7f080083)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                Ln.d(view, "Formatting phone number failed", new Object[0]);
            }
        }

        public void onWebsiteClick(View view)
        {
            try
            {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((CompanyInfo)model).website)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                return;
            }
        }

        private OnCompanyInfoViewEventListener()
        {
            this$0 = CompanyInfoController.this;
            super();
        }

    }


    private static final String SHOW_REDEMPTION_LOCATIONS = "showRedemptionLocations";
    private AddressService addressService;
    private Location closestLocation;
    private CurrentCountryManager currentCountryManager;
    private Deal deal;
    private DeviceInfoUtil deviceInfoUtil;
    private IntentFactory intentFactory;
    private LocationService locationService;
    private Option option;
    private List redemptionLocations;
    private RedemptionUtils redemptionUtils;

    public CompanyInfoController(Context context)
    {
        super(context);
    }

    private Location getClosestLocation()
    {
        ArrayList arraylist = option.getRedemptionLocations();
        if (arraylist != null && arraylist.size() > 0)
        {
            return (Location)arraylist.get(getClosestLocationIndex());
        } else
        {
            return null;
        }
    }

    private int getClosestLocationIndex()
    {
        ArrayList arraylist = option.getRedemptionLocations();
        if (arraylist != null && arraylist.size() > 0)
        {
            Object obj = locationService.getLocation();
            RedemptionUtils redemptionutils = redemptionUtils;
            if (obj != null)
            {
                obj = new GeoPoint((int)(((android.location.Location) (obj)).getLatitude() * 1000000D), (int)(((android.location.Location) (obj)).getLongitude() * 1000000D));
            } else
            {
                obj = null;
            }
            return redemptionutils.findClosestLocationTo(((GeoPoint) (obj)), arraylist);
        } else
        {
            return 0;
        }
    }

    private Collection getDealRatings(Deal deal1)
    {
        if (deal1.merchant == null)
        {
            return Collections.emptyList();
        } else
        {
            return deal1.merchant.ratings;
        }
    }

    private Collection getRatings()
    {
        Object obj = (Location)CollectionUtils.getFirstItem(option.getRedemptionLocations(), null);
        if (obj != null)
        {
            obj = ((Location) (obj)).ratings;
        } else
        {
            obj = Collections.emptyList();
        }
        if (((Collection) (obj)).size() > 0)
        {
            return ((Collection) (obj));
        } else
        {
            return getDealRatings(deal);
        }
    }

    private Rating[] getVendorRatings()
    {
        Object obj = getRatings();
        ArrayList arraylist = new ArrayList();
        if (obj != null && ((Collection) (obj)).size() > 0)
        {
            obj = ((Collection) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Rating rating = (Rating)((Iterator) (obj)).next();
                if (isValidRating(rating))
                {
                    arraylist.add(rating);
                }
            } while (true);
        }
        return (Rating[])arraylist.toArray(new Rating[arraylist.size()]);
    }

    private String getVendorUrl()
    {
        if (deal != null && deal.merchant != null)
        {
            return deal.merchant.websiteUrl;
        } else
        {
            return null;
        }
    }

    private boolean isValidRating(Rating rating)
    {
        Integer integer;
        if (rating != null)
        {
            integer = rating.getReviewsCount();
        } else
        {
            integer = null;
        }
        return integer != null && integer.intValue() > 0 && Strings.notEmpty(rating.getLinkText()) && Strings.notEmpty(rating.getUrl()) && rating.getRating() != null;
    }

    public OnCompanyInfoEventListener getCallback()
    {
        return new OnCompanyInfoViewEventListener();
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    public void processData()
    {
        Object obj;
        boolean flag1;
        if (option != null)
        {
            obj = option.getRedemptionLocations();
        } else
        {
            obj = null;
        }
        redemptionLocations = ((List) (obj));
        flag1 = deal.getDisplayOption("showRedemptionLocations", true);
        if (deal == null || !flag1 || Strings.isEmpty(getVendorUrl()) && (redemptionLocations == null || redemptionLocations.size() == 0 && getVendorRatings().length == 0))
        {
            setState(0);
            return;
        }
        Collection collection = getRatings();
        double d;
        double d1;
        String s;
        String s1;
        CompanyInfo companyinfo;
        int i;
        boolean flag;
        boolean flag2;
        boolean flag3;
        if (redemptionLocations != null && redemptionLocations.size() > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (currentCountryManager.getCurrentCountry().isJapan() && !deal.shouldDisplayMap)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (flag1 && i == 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag1)
        {
            i = redemptionLocations.size();
        } else
        {
            i = 0;
        }
        closestLocation = getClosestLocation();
        d = 0.0D;
        d1 = 0.0D;
        obj = null;
        s = null;
        if (closestLocation != null)
        {
            d = closestLocation.lat;
            d1 = closestLocation.lng;
            s = closestLocation.phoneNumber;
            obj = addressService.getAddressFromLocation(closestLocation);
        }
        if (deal.merchant != null)
        {
            s1 = deal.merchant.name;
        } else
        {
            s1 = "";
        }
        if (Strings.notEmpty(getVendorUrl()) && getRatings().size() == 0 && (redemptionLocations == null || redemptionLocations.size() == 0))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        model = new CompanyInfo();
        companyinfo = (CompanyInfo)model;
        if (flag || collection != null && collection.size() > 0 && Strings.notEmpty(s1))
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        companyinfo.shouldShowVendorName = flag3;
        ((CompanyInfo)model).shouldShowMapView = flag2;
        ((CompanyInfo)model).shouldUseLargeSliceMap = flag1;
        ((CompanyInfo)model).locationsCount = i;
        ((CompanyInfo)model).lat = d;
        ((CompanyInfo)model).lng = d1;
        ((CompanyInfo)model).vendorName = s1;
        ((CompanyInfo)model).address = ((String) (obj));
        ((CompanyInfo)model).phone = s;
        ((CompanyInfo)model).website = getVendorUrl();
        ((CompanyInfo)model).vendorRatings = getVendorRatings();
        ((CompanyInfo)model).deviceScreenDensity = deviceInfoUtil.getDensity();
        setState(2);
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setOption(Option option1)
    {
        setState(1);
        option = option1;
    }




}
