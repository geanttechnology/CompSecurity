// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.abtest.BitmapAbTestHelper;
import com.groupon.db.models.Location;
import com.groupon.models.Bucks;
import com.groupon.models.FailureReason;
import com.groupon.models.GenericAmount;
import com.groupon.models.ReservationHotel;
import com.groupon.models.hotel.HotelAddress;
import com.groupon.models.hotel.HotelCancellationPolicy;
import com.groupon.models.hotel.HotelReservation;
import com.groupon.network.HttpResponseException;
import com.groupon.service.LoginService;
import com.groupon.service.marketrate.HotelsService;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DialogManager;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.MarketRateUtil;
import com.groupon.util.TimeZoneUSFriendlyDateFormat;
import com.groupon.view.MapSliceRedesign;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.restlet.engine.util.InternetDateFormat;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory

public class MarketRateReservation extends GrouponActivity
    implements GrouponDialogListener
{

    View amenitiesContainer;
    TextView amenitiesView;
    private BitmapAbTestHelper bitmapAbTestHelper;
    LinearLayout bookingInfoContainer;
    private CurrencyFormatter currencyFormatter;
    private DeviceInfoUtil deviceInfoUtil;
    private DialogManager dialogManager;
    private boolean enable565Bitmap1506;
    View finePrintContainer;
    WebView finePrintWebView;
    private TimeZoneUSFriendlyDateFormat friendlyDateFormatter;
    View gBucksContainer;
    TextView gBucksValue;
    View highlightsContainer;
    TextView highlightsTitleView;
    WebView highlightsWebView;
    ImageView hotelImageView;
    TextView hotelLocation;
    String hotelTimeZoneIdentifier;
    TextView hotelTitle;
    private HotelsService hotelsService;
    private LayoutInflater inflater;
    private IntentFactory intentFactory;
    private InternetDateFormat internetDateFormat;
    private LoginService loginService;
    MapSliceRedesign mapSlice;
    View progress;
    private HotelReservation reservation;
    String reservationId;

    public MarketRateReservation()
    {
    }

    private View addBasicListItem(ViewGroup viewgroup, int i, String s, String s1, int j, int k, boolean flag, 
            boolean flag1, android.view.View.OnClickListener onclicklistener)
    {
        if (i > 0)
        {
            View view = inflater.inflate(i, viewgroup, false);
            TextView textview = (TextView)view.findViewById(0x7f1002d3);
            if (textview != null && s != null)
            {
                textview.setText(s);
                textview.setTextColor(getResources().getColor(j));
                s = textview.getTypeface();
                if (flag)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                textview.setTypeface(s, i);
            }
            s = (TextView)view.findViewById(0x7f100249);
            if (s != null)
            {
                if (Strings.notEmpty(s1))
                {
                    s.setText(s1);
                    s.setTextColor(getResources().getColor(k));
                    s1 = s.getTypeface();
                    if (flag1)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    s.setTypeface(s1, i);
                } else
                {
                    s.setVisibility(8);
                }
            }
            if (onclicklistener != null)
            {
                view.setOnClickListener(onclicklistener);
            }
            if (onclicklistener != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setClickable(flag);
            if (onclicklistener != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setFocusable(flag);
            view.setFocusableInTouchMode(false);
            viewgroup.addView(view);
            return view;
        } else
        {
            return null;
        }
    }

    private void buildBookingDetails()
    {
        bookingInfoContainer.removeAllViews();
        int j = 0;
        Object obj = reservation.roomName;
        if (Strings.notEmpty(obj))
        {
            addBasicListItem(bookingInfoContainer, 0x7f03013a, ((String) (obj)), null, 0x7f0e0031, 0x7f0e0196, false, false, null);
            j = 0 + 1;
        }
        obj = getString(0x7f0800af);
        String s = getFormattedDate(reservation.checkInUtc);
        int i = j;
        if (Strings.notEmpty(s))
        {
            addBasicListItem(bookingInfoContainer, 0x7f030139, ((String) (obj)), s, 0x7f0e0031, 0x7f0e00d5, false, false, null);
            i = j + 1;
        }
        obj = getString(0x7f0800b2);
        s = getFormattedDate(reservation.checkOutUtc);
        j = i;
        if (Strings.notEmpty(s))
        {
            addBasicListItem(bookingInfoContainer, 0x7f030139, ((String) (obj)), s, 0x7f0e0031, 0x7f0e00d5, false, false, null);
            j = i + 1;
        }
        obj = getString(0x7f080079);
        s = reservation.recordLocator;
        if (Strings.notEmpty(s))
        {
            addBasicListItem(bookingInfoContainer, 0x7f030139, ((String) (obj)), s, 0x7f0e0031, 0x7f0e00d5, false, false, null);
            j++;
        } else
        {
            addBasicListItem(bookingInfoContainer, 0x7f030139, ((String) (obj)), getString(0x7f080223), 0x7f0e0031, 0x7f0e01bc, false, false, null);
            j++;
        }
        obj = reservation.status;
        i = j;
        if (Strings.notEmpty(obj))
        {
            String s1 = getString(0x7f080528);
            String s3 = Strings.capitalize(((String) (obj)));
            addBasicListItem(bookingInfoContainer, 0x7f030139, s1, s3, 0x7f0e0031, MarketRateUtil.getStatusColor(((String) (obj)), 0x7f0e00d5), false, false, null);
            i = j + 1;
        }
        j = i;
        if (Strings.notEmpty(obj))
        {
            j = i;
            if (Strings.equals(obj, "processing"))
            {
                addBasicListItem(bookingInfoContainer, 0x7f03013a, getString(0x7f08050a), null, 0x7f0e01bc, 0x7f0e0196, false, false, null);
                j = i + 1;
            }
        }
        i = j;
        if (Strings.notEmpty(obj))
        {
            i = j;
            if (Strings.equals(obj, "confirmed"))
            {
                addBasicListItem(bookingInfoContainer, 0x7f03013a, getString(0x7f0804cf), null, 0x7f0e00bb, 0x7f0e0196, false, false, null);
                i = j + 1;
            }
        }
        j = i;
        if (Strings.notEmpty(obj))
        {
            j = i;
            if (((String) (obj)).matches("cancell?ed"))
            {
                obj = null;
                String s2 = getFormattedDate(reservation.updatedAt);
                if (Strings.notEmpty(s2))
                {
                    obj = String.format(getString(0x7f080092), new Object[] {
                        s2
                    });
                }
                j = i;
                if (Strings.notEmpty(obj))
                {
                    addBasicListItem(bookingInfoContainer, 0x7f03013a, ((String) (obj)), null, 0x7f0e015c, 0x7f0e0196, false, false, null);
                    j = i + 1;
                }
            }
        }
        obj = reservation.failureReason;
        i = j;
        if (obj != null)
        {
            obj = ((FailureReason) (obj)).message;
            i = j;
            if (Strings.notEmpty(obj))
            {
                addBasicListItem(bookingInfoContainer, 0x7f03013a, ((String) (obj)), null, 0x7f0e015c, 0x7f0e0196, false, false, null);
                i = j + 1;
            }
        }
        obj = bookingInfoContainer;
        if (i > 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((LinearLayout) (obj)).setVisibility(i);
    }

    private void buildFinePrint()
    {
        Object obj = new StringBuilder();
        Object obj1 = reservation.cancellationPolicies.iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            String s = ((HotelCancellationPolicy)((Iterator) (obj1)).next()).descriptionHtml;
            if (Strings.notEmpty(s))
            {
                ((StringBuilder) (obj)).append(s);
                ((StringBuilder) (obj)).append("<br/><br/>");
            }
        } while (true);
        obj1 = reservation.crsPolicyHtml;
        if (Strings.notEmpty(obj1))
        {
            ((StringBuilder) (obj)).append(((String) (obj1)));
        }
        obj = ((StringBuilder) (obj)).toString();
        if (Strings.notEmpty(obj))
        {
            finePrintContainer.setVisibility(0);
            finePrintWebView.loadDataWithBaseURL(null, (new StringBuilder()).append("<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:10px 0px 0px 0px; color:#75787b;} a:link {color:#369ec1;} ul{padding-left:25px} blockquote{margin:0px;}</style>").append(((String) (obj))).toString(), "text/html", "UTF-8", null);
        }
    }

    private void buildGBucksDetails()
    {
        final String gBucksDisclaimer = Integer.valueOf(reservation.bucks.amount);
        if (gBucksDisclaimer.intValue() > 0)
        {
            gBucksContainer.setVisibility(0);
            final GenericAmount gBucksAmount = new GenericAmount();
            gBucksAmount.setAmount(gBucksDisclaimer.intValue());
            gBucksAmount.setCurrencyCode(reservation.bucks.currencyCode);
            gBucksValue.setText(currencyFormatter.format(gBucksAmount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never));
            if (reservation.hotel.bucksDisclaimer == null)
            {
                gBucksDisclaimer = "";
            } else
            {
                gBucksDisclaimer = reservation.hotel.bucksDisclaimer;
            }
            gBucksContainer.setOnClickListener(new android.view.View.OnClickListener() {

                final MarketRateReservation this$0;
                final GenericAmount val$gBucksAmount;
                final String val$gBucksDisclaimer;

                public void onClick(View view)
                {
                    startActivity(intentFactory.newMarketRateGBucksIntent(gBucksAmount, gBucksDisclaimer));
                }

            
            {
                this$0 = MarketRateReservation.this;
                gBucksAmount = genericamount;
                gBucksDisclaimer = s;
                super();
            }
            });
            return;
        } else
        {
            gBucksContainer.setVisibility(8);
            return;
        }
    }

    private void buildHotelViewsAfterRequest()
    {
        int i = 1;
        buildImageHeader();
        Object obj;
        if (reservation.hotel.name == null)
        {
            obj = "";
        } else
        {
            obj = reservation.hotel.name;
        }
        highlightsTitleView.setText(String.format(getString(0x7f080041), new Object[] {
            obj
        }));
        obj = reservation.hotel.descriptionHtml;
        if (Strings.notEmpty(obj))
        {
            highlightsContainer.setVisibility(0);
            highlightsWebView.loadDataWithBaseURL(null, (new StringBuilder()).append("<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:10px 0px 0px 0px; color:#75787b;} a:link {color:#369ec1;} ul{padding-left:25px} blockquote{margin:0px;}</style>").append(((String) (obj))).toString(), "text/html", "UTF-8", null);
        }
        obj = reservation.hotel.hotelAmenities;
        if (obj == null || obj.length <= 0)
        {
            i = 0;
        }
        if (i != 0)
        {
            amenitiesContainer.setVisibility(0);
            StringBuilder stringbuilder = new StringBuilder();
            int j = obj.length;
            for (i = 0; i < j; i++)
            {
                String s = obj[i];
                if (Strings.notEmpty(s))
                {
                    stringbuilder.append("&#8226; ").append(s).append("<br/>");
                }
            }

            amenitiesView.setText(Html.fromHtml(stringbuilder.toString()));
        }
        updateMapSection();
    }

    private void buildImageHeader()
    {
        Object obj = reservation.hotel.mediumImageUrl;
        DeviceInfoUtil deviceinfoutil = deviceInfoUtil;
        if (!((String) (obj)).startsWith("http://"))
        {
            obj = (new StringBuilder()).append("http://").append(((String) (obj))).toString();
        }
        MarketRateUtil.setHeaderImage(this, deviceinfoutil, ((String) (obj)), hotelImageView, enable565Bitmap1506);
        obj = reservation.hotel.name;
        if (Strings.notEmpty(obj))
        {
            hotelTitle.setText(((CharSequence) (obj)));
        }
        obj = reservation.hotel.address;
        if (obj != null)
        {
            String s = ((HotelAddress) (obj)).city;
            if (Strings.notEmpty(((HotelAddress) (obj)).state))
            {
                obj = ((HotelAddress) (obj)).state;
            } else
            {
                obj = ((HotelAddress) (obj)).country;
            }
            if (Strings.notEmpty(s) && Strings.notEmpty(obj))
            {
                hotelLocation.setText((new StringBuilder()).append(s).append(", ").append(((String) (obj))));
            }
        }
    }

    private ArrayList getHotelReservationRequestParameters()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new String[] {
            "fields[hotel]", "*"
        }));
        return arraylist;
    }

    private void reload()
    {
        hotelsService.getHotelReservation(loginService.getConsumerId(), reservationId, getHotelReservationRequestParameters(), progress, new Function1() {

            final MarketRateReservation this$0;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((List)obj);
            }

            public void execute(List list)
            {
                if (!list.isEmpty())
                {
                    reservation = (HotelReservation)list.get(0);
                    updateReservationViewsAfterRequest();
                }
            }

            
            {
                this$0 = MarketRateReservation.this;
                super();
            }
        }, new Function1() {

            final MarketRateReservation this$0;

            public void execute(Exception exception)
            {
                if (exception instanceof HttpResponseException)
                {
                    handleException(exception);
                    return;
                } else
                {
                    throw new RuntimeException(exception);
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Exception)obj);
            }

            
            {
                this$0 = MarketRateReservation.this;
                super();
            }
        }, new Function0() {

            final MarketRateReservation this$0;

            public void execute()
            {
            }

            
            {
                this$0 = MarketRateReservation.this;
                super();
            }
        });
    }

    private void updateMapSection()
    {
        Object obj = reservation.hotel.address;
        if (obj != null)
        {
            mapSlice.setVisibility(0);
            final Double lat = ((HotelAddress) (obj)).lat;
            final Double lng = ((HotelAddress) (obj)).lng;
            if (lat != null && lng != null)
            {
                mapSlice.setLocationCoordinates(lat.doubleValue(), lng.doubleValue());
                mapSlice.setOnImageClickListener(new android.view.View.OnClickListener() {

                    final MarketRateReservation this$0;
                    final Double val$lat;
                    final Double val$lng;

                    public void onClick(View view)
                    {
                        double d1 = 0.0D;
                        view = new Location();
                        double d;
                        if (lat == null)
                        {
                            d = 0.0D;
                        } else
                        {
                            d = lat.doubleValue();
                        }
                        view.lat = d;
                        if (lng == null)
                        {
                            d = d1;
                        } else
                        {
                            d = lng.doubleValue();
                        }
                        view.lng = d;
                        startActivity(intentFactory.newShowOnMapIntent(view, reservation.hotel.name, 0));
                    }

            
            {
                this$0 = MarketRateReservation.this;
                lat = double1;
                lng = double2;
                super();
            }
                });
            }
            mapSlice.setLocationAddress(((HotelAddress) (obj)).streetAddress1, ((HotelAddress) (obj)).streetAddress2, ((HotelAddress) (obj)).postalCode, ((HotelAddress) (obj)).city, ((HotelAddress) (obj)).state, ((HotelAddress) (obj)).country);
            obj = reservation.hotel.phoneNumber;
            if (obj != null)
            {
                mapSlice.setVendorInfo(((String) (obj)), "");
            }
            mapSlice.show();
        }
    }

    private void updateReservationViewsAfterRequest()
    {
        buildHotelViewsAfterRequest();
        buildBookingDetails();
        buildGBucksDetails();
        buildFinePrint();
    }

    public String getFormattedDate(String s)
    {
        return MarketRateUtil.getFormattedDate(s, internetDateFormat, friendlyDateFormatter, this);
    }

    public void handleException(Exception exception)
    {
        Ln.w(exception);
        GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(Integer.valueOf(0x7f080165)), "http_error_dialog");
    }

    protected boolean hasCartIcon()
    {
        return true;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setDisplayToolbarTitle(false);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03015f);
        enable565Bitmap1506 = bitmapAbTestHelper.isEnable565Bitmap1506();
        friendlyDateFormatter.setOutputType(com.groupon.util.TimeZoneUSFriendlyDateFormat.OutputType.shortDate);
        if (Strings.notEmpty(hotelTimeZoneIdentifier))
        {
            friendlyDateFormatter.setTimeZoneByIdentifier(hotelTimeZoneIdentifier);
        }
        reload();
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
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "http_error_dialog"))
        {
            finish();
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }



/*
    static HotelReservation access$002(MarketRateReservation marketratereservation, HotelReservation hotelreservation)
    {
        marketratereservation.reservation = hotelreservation;
        return hotelreservation;
    }

*/


}
