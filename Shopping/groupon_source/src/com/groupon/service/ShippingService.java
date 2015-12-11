// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.Html;
import com.google.android.gms.wallet.Address;
import com.groupon.http.Http;
import com.groupon.models.LocationsContainer;
import com.groupon.models.country.Country;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.models.order.AddressDetail;
import com.groupon.models.order.UserAddress;
import com.groupon.models.shipping.AddressEu;
import com.groupon.models.shipping.ShippingField;
import com.groupon.models.shippingFields.RegionMX;
import com.groupon.models.shippingFields.ShippingSelectValue;
import com.groupon.models.shippingFields.SpecialShippingFieldsCLCO;
import com.groupon.models.shippingFields.converter.ShippingFieldsConverter;
import com.groupon.models.support.StaticSupportInfo;
import com.groupon.models.user.User;
import com.groupon.models.user.UserContainer;
import com.groupon.service.core.StaticSupportInfoService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.CheckedFunction1;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.LowerCaseFirstCharacter;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.ReturningFunction1;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            ApiServiceBase, LoginService, GoogleWalletService

public class ShippingService
{
    protected class StoreShippingAddresses
        implements Function1
    {

        final ShippingService this$0;

        public void execute(UserContainer usercontainer)
        {
            usercontainer = usercontainer.user.shippingAddresses;
            boolean flag;
            if (usercontainer != null && usercontainer.size() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && !isStored())
            {
                storeMultipleShipping((DealBreakdownAddress)usercontainer.get(0));
            }
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((UserContainer)obj);
        }

        protected StoreShippingAddresses()
        {
            this$0 = ShippingService.this;
            super();
        }
    }


    private static final String HTML_BOLD_CLOSE_TAG = "</b>";
    private static final String HTML_BOLD_OPEN_TAG = "<b>";
    private static final String SHIPPING_ADDRESS_SEPARATOR_NEW_LINE = "\n";
    private static final String SHIPPING_ADDRESS_SEPARATOR_NEW_LINE_HTML = "<br/>";
    private static final String SHIPPING_ADDRESS_SEPARATOR_SPACE = " ";
    private String SHIPPING_TITLE_MR;
    private String SHIPPING_TITLE_MRS;
    private Application application;
    private Lazy currentCountryManager;
    private DeviceInfoUtil deviceInfoUtil;
    protected Lazy googleWalletService;
    private ArraySharedPreferences loginPrefs;
    private Lazy loginService;
    private ApiServiceBase multipleLocationService;
    private ObjectMapperWrapper om;
    private SharedPreferences prefs;
    private ShippingFieldsConverter shippingFieldsConverter;
    private AtomicReference staticJsonShippingFields;
    private Lazy staticSupportInfoService;
    private ApiServiceBase userService;

    public ShippingService()
    {
        staticJsonShippingFields = new AtomicReference();
    }

    private String applySeparator(String s)
    {
        if (!((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isJapan() || Strings.equalsIgnoreCase(s, "\n"))
        {
            return s;
        } else
        {
            return "";
        }
    }

    private List getHttpParams(DealBreakdownAddress dealbreakdownaddress, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        if (dealbreakdownaddress != null)
        {
            Object obj = getShippingAddress();
            com.groupon.models.shipping.ShippingField.MapContainer mapcontainer = (com.groupon.models.shipping.ShippingField.MapContainer)staticJsonShippingFields.get();
            Iterator iterator = ((List) (obj)).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (String)iterator.next();
                if (!Strings.equalsIgnoreCase(obj, "shippingTitle"))
                {
                    Object obj1 = (ShippingField)mapcontainer.shippingFields.get(obj);
                    if (flag)
                    {
                        obj = ((ShippingField) (obj1)).httpParam;
                    } else
                    {
                        obj = ((ShippingField) (obj1)).httpParamAlt;
                    }
                    obj1 = ((ShippingField) (obj1)).jsonParam;
                    try
                    {
                        arraylist.addAll(Arrays.asList(new Object[] {
                            obj, dealbreakdownaddress.getClass().getDeclaredField(LowerCaseFirstCharacter.toLowerCaseFirstCharacter(((String) (obj1)))).get(dealbreakdownaddress)
                        }));
                    }
                    // Misplaced declaration of an exception variable
                    catch (DealBreakdownAddress dealbreakdownaddress)
                    {
                        throw new RuntimeException(dealbreakdownaddress);
                    }
                }
            } while (true);
            obj = dealbreakdownaddress.title;
            if (Strings.notEmpty(obj))
            {
                arraylist.addAll(Arrays.asList(new String[] {
                    "title", obj
                }));
            }
            int i = dealbreakdownaddress.pref;
            if (i > 0)
            {
                String s;
                if (flag)
                {
                    s = "shipping_pref";
                } else
                {
                    s = "pref";
                }
                arraylist.addAll(Arrays.asList(new Serializable[] {
                    s, Integer.valueOf(i)
                }));
            }
            arraylist.addAll(Arrays.asList(new String[] {
                "country", dealbreakdownaddress.country
            }));
        }
        return arraylist;
    }

    private void init()
        throws Exception
    {
        staticJsonShippingFields.compareAndSet(null, om.readValue(application.getAssets().open("shipping_fields.json"), com/groupon/models/shipping/ShippingField$MapContainer));
        multipleLocationService = new ApiServiceBase(application, com/groupon/models/LocationsContainer);
        userService = new ApiServiceBase(application, com/groupon/models/user/UserContainer);
        loginService = new Lazy(application) {

            final ShippingService this$0;

            
            {
                this$0 = ShippingService.this;
                super(context);
            }
        };
        currentCountryManager = new Lazy(application) {

            final ShippingService this$0;

            
            {
                this$0 = ShippingService.this;
                super(context);
            }
        };
        staticSupportInfoService = new Lazy(application) {

            final ShippingService this$0;

            
            {
                this$0 = ShippingService.this;
                super(context);
            }
        };
        googleWalletService = new Lazy(application) {

            final ShippingService this$0;

            
            {
                this$0 = ShippingService.this;
                super(context);
            }
        };
        SHIPPING_TITLE_MR = application.getString(0x7f0803a5);
        SHIPPING_TITLE_MRS = application.getString(0x7f0803a6);
    }

    private boolean isFirstName(String s)
    {
        return Strings.equalsIgnoreCase(s, "shippingFirstName");
    }

    private boolean isPhoneJP(String s)
    {
        return Strings.equalsIgnoreCase(s, "shippingPhoneJP");
    }

    public void addParams(List list)
    {
        if (((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isUSACompatible())
        {
            Collections.addAll(list, new String[] {
                "shipping_name", prefs.getString("preferredShippingName", null), "shipping_address1", prefs.getString("preferredShippingAddr1", null), "shipping_address2", prefs.getString("preferredShippingAddr2", null), "shipping_city", prefs.getString("preferredShippingCity", null), "shipping_state", prefs.getString("preferredShippingState", null), 
                "shipping_postal_code", prefs.getString("preferredShippingPostalCode", null), "shipping_country", prefs.getString("preferredShippingCountry", null)
            });
            return;
        } else
        {
            Collections.addAll(list, new String[] {
                "shipping_location_id", getSelectedShippingLocationId()
            });
            return;
        }
    }

    public transient void addShippingAddressEu(final Activity final_context, Integer integer, Function1 function1, Function1 function1_1, Function0 function0, Object aobj[])
    {
        final_context = (new Http(aobj, function1, function1_1, function0) {

            final ShippingService this$0;
            final Function1 val$onException;
            final Function0 val$onFinally;
            final Function1 val$onSuccess;

            protected void onException(Exception exception)
            {
                if (onException != null)
                {
                    clearStore();
                    onException.execute(exception);
                    return;
                } else
                {
                    super.onException(exception);
                    return;
                }
            }

            protected void onFinally()
            {
                if (onFinally == null)
                {
                    super.onFinally();
                    return;
                } else
                {
                    onFinally.execute();
                    return;
                }
            }

            protected void onSuccess(AddressEu addresseu)
                throws Exception
            {
                if (onSuccess != null)
                {
                    onSuccess.execute(addresseu);
                }
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((AddressEu)obj);
            }

            transient 
            {
                this$0 = ShippingService.this;
                onSuccess = function1;
                onException = function1_1;
                onFinally = function0;
                super(final_context, final_class1, final_s, aobj);
            }
        }).method("POST");
        if (integer != null)
        {
            final_context.progressView(integer.intValue());
        }
        final_context.execute();
    }

    public boolean areAddressesCloseEnough(DealBreakdownAddress dealbreakdownaddress, DealBreakdownAddress dealbreakdownaddress1)
    {
        if (dealbreakdownaddress == null || dealbreakdownaddress1 == null)
        {
            return false;
        }
        String s18 = Strings.toString(dealbreakdownaddress.shippingAddress1).trim();
        String s = Strings.toString(dealbreakdownaddress.shippingAddress2).trim();
        String s19 = Strings.toString(dealbreakdownaddress.address1).trim();
        String s15 = Strings.toString(dealbreakdownaddress.address2).trim();
        String s16 = Strings.toString(dealbreakdownaddress1.shippingAddress1).trim();
        String s1 = Strings.toString(dealbreakdownaddress1.shippingAddress2).trim();
        String s17 = Strings.toString(dealbreakdownaddress1.address1).trim();
        String s14 = Strings.toString(dealbreakdownaddress1.address2).trim();
        String s2 = Strings.toString(dealbreakdownaddress.shippingPostalCode).trim();
        String s3 = Strings.toString(dealbreakdownaddress1.shippingPostalCode).trim();
        String s13 = Strings.toString(dealbreakdownaddress.postalCode).trim();
        String s12 = Strings.toString(dealbreakdownaddress1.postalCode).trim();
        String s4 = Strings.toString(dealbreakdownaddress.shippingCity).trim();
        String s5 = Strings.toString(dealbreakdownaddress1.shippingCity).trim();
        String s11 = Strings.toString(dealbreakdownaddress.city).trim();
        String s10 = Strings.toString(dealbreakdownaddress1.city).trim();
        String s6 = Strings.toString(dealbreakdownaddress.shippingState).trim();
        String s7 = Strings.toString(dealbreakdownaddress1.shippingState).trim();
        String s9 = Strings.toString(dealbreakdownaddress.state).trim();
        String s8 = Strings.toString(dealbreakdownaddress1.state).trim();
        boolean flag;
        boolean flag2;
        if (Strings.notEmpty(s18))
        {
            dealbreakdownaddress = s18;
        } else
        {
            dealbreakdownaddress = s19;
        }
        if (Strings.notEmpty(s16))
        {
            dealbreakdownaddress1 = s16;
        } else
        {
            dealbreakdownaddress1 = s17;
        }
        if (!Strings.notEmpty(s))
        {
            s = s15;
        }
        if (!Strings.notEmpty(s1))
        {
            s1 = s14;
        }
        if (!Strings.notEmpty(s2))
        {
            s2 = s13;
        }
        if (!Strings.notEmpty(s3))
        {
            s3 = s12;
        }
        if (!Strings.notEmpty(s4))
        {
            s4 = s11;
        }
        if (!Strings.notEmpty(s5))
        {
            s5 = s10;
        }
        if (!Strings.notEmpty(s6))
        {
            s6 = s9;
        }
        if (!Strings.notEmpty(s7))
        {
            s7 = s8;
        }
        flag = Strings.equals(dealbreakdownaddress, dealbreakdownaddress1);
        flag2 = Strings.equals(s, s1);
        if (!flag || !flag2)
        {
            boolean flag1 = Strings.equals(dealbreakdownaddress, s1);
            boolean flag3 = Strings.equals(s, dealbreakdownaddress1);
            if (!flag1 || !flag3)
            {
                return false;
            }
        }
        return Strings.equals(s4, s5) && Strings.equals(s6, s7) && Strings.equals(s2, s3);
    }

    public void clearStore()
    {
        prefs.edit().remove("preferredShippingLocationId").remove("preferredShippingName").remove("preferredShippingAddr1").remove("preferredShippingAddr2").remove("preferredShippingCity").remove("preferredShippingState").remove("preferredShippingPostalCode").remove("preferredShippingCountry").apply();
    }

    public AddressDetail getAddressDetails()
    {
        DealBreakdownAddress dealbreakdownaddress = getAddressFromPrefs();
        AddressDetail addressdetail = new AddressDetail();
        UserAddress useraddress = new UserAddress();
        addressdetail.shippingAddress = useraddress;
        useraddress.shippingName = dealbreakdownaddress.name;
        useraddress.shippingAddress1 = dealbreakdownaddress.streetAddress1;
        useraddress.shippingAddress2 = dealbreakdownaddress.streetAddress2;
        useraddress.shippingCity = dealbreakdownaddress.city;
        useraddress.shippingState = dealbreakdownaddress.state;
        useraddress.shippingPostalCode = dealbreakdownaddress.postalCode;
        useraddress.shippingCountry = dealbreakdownaddress.country;
        return addressdetail;
    }

    public DealBreakdownAddress getAddressFromPrefs()
    {
        return new DealBreakdownAddress(prefs.getString("preferredShippingName", ""), prefs.getString("preferredShippingAddr1", ""), prefs.getString("preferredShippingAddr2", ""), prefs.getString("preferredShippingCity", ""), prefs.getString("preferredShippingState", ""), prefs.getString("preferredShippingPostalCode", ""), prefs.getString("preferredShippingCountry", ""));
    }

    public List getAltHttpParams(DealBreakdownAddress dealbreakdownaddress)
    {
        return getHttpParams(dealbreakdownaddress, false);
    }

    public CharSequence getAsJoin()
    {
        String s = Strings.join(", ", new String[] {
            prefs.getString("preferredShippingAddr1", null), prefs.getString("preferredShippingAddr2", null), prefs.getString("preferredShippingCity", null), Strings.join(" ", new String[] {
                prefs.getString("preferredShippingState", null), prefs.getString("preferredShippingPostalCode", null), prefs.getString("preferredShippingCountry", null)
            })
        });
        String s1 = prefs.getString("preferredShippingName", null);
        return Html.fromHtml(Strings.join("<br/>", new String[] {
            (new StringBuilder()).append("<b>").append(s1).append("</b>").toString(), s
        }));
    }

    public CharSequence getAsJoin(Address address)
    {
        if (address != null)
        {
            String s = Strings.join(", ", new String[] {
                address.getAddress1(), address.getAddress2(), address.getCity(), Strings.join(" ", new String[] {
                    address.getState(), address.getPostalCode(), address.getCountryCode()
                })
            });
            address = address.getName();
            return Html.fromHtml(Strings.join("<br/>", new String[] {
                (new StringBuilder()).append("<b>").append(address).append("</b>").toString(), s
            }));
        } else
        {
            return null;
        }
    }

    public String getAsJoin(DealBreakdownAddress dealbreakdownaddress)
    {
        return getAsJoin(dealbreakdownaddress, true, false, false);
    }

    public String getAsJoin(DealBreakdownAddress dealbreakdownaddress, String s, String s1)
    {
        return Strings.join(", ", new String[] {
            getAsJoin(dealbreakdownaddress), s, s1
        });
    }

    public String getAsJoin(DealBreakdownAddress dealbreakdownaddress, String s, String s1, boolean flag)
    {
        return Strings.join(", ", new String[] {
            getAsJoin(dealbreakdownaddress, flag, false, false), s, s1
        });
    }

    public String getAsJoin(DealBreakdownAddress dealbreakdownaddress, boolean flag, boolean flag1, boolean flag2)
    {
        Object obj;
        StringBuilder stringbuilder;
        Iterator iterator;
        String s;
        boolean flag3;
        flag3 = ((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isUSACompatible();
        stringbuilder = new StringBuilder();
        com.groupon.models.shipping.ShippingField.MapContainer mapcontainer;
        if (flag1)
        {
            obj = shippingAddressMulti();
        } else
        {
            obj = getShippingAddress();
        }
        mapcontainer = (com.groupon.models.shipping.ShippingField.MapContainer)staticJsonShippingFields.get();
        iterator = ((List) (obj)).iterator();
_L13:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_424;
        }
        s = (String)iterator.next();
        obj = (ShippingField)mapcontainer.shippingFields.get(s);
        if (isLastName(s) && !flag2 || isPhoneJP(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!flag || !Strings.equalsIgnoreCase(s, "shippingTitle")) goto _L2; else goto _L1
_L1:
        if (Strings.equalsIgnoreCase(dealbreakdownaddress.title, "m"))
        {
            obj = SHIPPING_TITLE_MR;
        } else
        {
            obj = SHIPPING_TITLE_MRS;
        }
        stringbuilder.append(((String) (obj)));
        stringbuilder.append(applySeparator(" "));
_L4:
        if (((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isJapan() && Strings.equalsIgnoreCase(s, "shippingPostalCodeJP") && dealbreakdownaddress.pref > 0)
        {
            stringbuilder.append(application.getResources().getStringArray(0x7f0f000b)[dealbreakdownaddress.pref - 1]);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        obj = ((ShippingField) (obj)).jsonParam;
        obj = Strings.toString(dealbreakdownaddress.getClass().getDeclaredField(LowerCaseFirstCharacter.toLowerCaseFirstCharacter(((String) (obj)))).get(dealbreakdownaddress));
        if (!Strings.notEmpty(obj))
        {
            continue; /* Loop/switch isn't completed */
        }
        stringbuilder.append(((String) (obj)));
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (flag3)
        {
            obj = "\n";
        } else
        {
            obj = " ";
        }
        if (!isFirstNameJP(s))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = "\n";
_L7:
        try
        {
            stringbuilder.append(applySeparator(((String) (obj))));
        }
        // Misplaced declaration of an exception variable
        catch (DealBreakdownAddress dealbreakdownaddress)
        {
            throw new RuntimeException(dealbreakdownaddress);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!flag) goto _L6; else goto _L5
_L5:
        if (isFirstName(s)) goto _L7; else goto _L6
_L6:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_396;
        }
        if (!isLastName(s))
        {
            break MISSING_BLOCK_LABEL_396;
        }
        obj = "\n";
          goto _L7
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_416;
        }
        if (!isLastNameJP(s))
        {
            break MISSING_BLOCK_LABEL_416;
        }
        obj = " ";
          goto _L7
        obj = ", ";
          goto _L7
        if (!((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isUSACompatible()) goto _L9; else goto _L8
_L8:
        stringbuilder.append(applySeparator(", "));
        stringbuilder.append(dealbreakdownaddress.state);
        stringbuilder.append(applySeparator(", "));
        stringbuilder.append(dealbreakdownaddress.country);
_L11:
        dealbreakdownaddress = stringbuilder.toString();
        prefs.edit().putString("selectedShippingAddress", dealbreakdownaddress).apply();
        return dealbreakdownaddress;
_L9:
        if (((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isCanadaQuebec())
        {
            stringbuilder.append(applySeparator(", "));
            stringbuilder.append(dealbreakdownaddress.state);
        }
        if (true) goto _L11; else goto _L10
_L10:
        if (true) goto _L13; else goto _L12
_L12:
    }

    public String getAsJoin(boolean flag)
    {
        String s = Strings.join(", ", new String[] {
            prefs.getString("preferredShippingAddr1", null), prefs.getString("preferredShippingAddr2", null), prefs.getString("preferredShippingCity", null), Strings.join(" ", new String[] {
                prefs.getString("preferredShippingState", null), prefs.getString("preferredShippingPostalCode", null), prefs.getString("preferredShippingCountry", null)
            })
        });
        if (flag)
        {
            return s;
        } else
        {
            return Strings.join(", ", new String[] {
                prefs.getString("preferredShippingName", null), s
            });
        }
    }

    public String getFullName(DealBreakdownAddress dealbreakdownaddress)
    {
        StringBuilder stringbuilder = new StringBuilder();
        List list = getShippingAddress();
        com.groupon.models.shipping.ShippingField.MapContainer mapcontainer = (com.groupon.models.shipping.ShippingField.MapContainer)staticJsonShippingFields.get();
        Iterator iterator = list.iterator();
label0:
        do
        {
            String s;
            Object obj;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                s = (String)iterator.next();
                obj = (ShippingField)mapcontainer.shippingFields.get(s);
                if (!Strings.equalsIgnoreCase(s, "shippingTitle"))
                {
                    break;
                }
                if (Strings.equalsIgnoreCase(dealbreakdownaddress.title, "m"))
                {
                    s = SHIPPING_TITLE_MR;
                } else
                {
                    s = SHIPPING_TITLE_MRS;
                }
                stringbuilder.append(s);
                stringbuilder.append(" ");
            } while (true);
            obj = ((ShippingField) (obj)).jsonParam;
            boolean flag;
            try
            {
                stringbuilder.append(Strings.toString(dealbreakdownaddress.getClass().getDeclaredField(LowerCaseFirstCharacter.toLowerCaseFirstCharacter(((String) (obj)))).get(dealbreakdownaddress)));
                stringbuilder.append(" ");
                flag = isFirstNameJP(s);
            }
            // Misplaced declaration of an exception variable
            catch (DealBreakdownAddress dealbreakdownaddress)
            {
                throw new RuntimeException(dealbreakdownaddress);
            }
        } while (!flag);
        return stringbuilder.toString();
    }

    public void getLocations(Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        if (((LoginService)loginService.get()).isLoggedIn())
        {
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(Arrays.asList(new String[] {
                "lang", deviceInfoUtil.getLanguageFromLocale()
            }));
            multipleLocationService.execute(function1, returningfunction1, function0, String.format("https:/users/%s/locations", new Object[] {
                loginPrefs.getString("userId", "")
            }), "GET", arraylist);
        }
    }

    public void getLocationsByPostalCodeMX(Context context, String s, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        (new ApiServiceBase(context, com/groupon/models/shippingFields/RegionMX)).execute(function1, returningfunction1, function0, String.format("/postal_codes/%s/municipio", new Object[] {
            s
        }), "GET");
    }

    public List getMainHttpParams(DealBreakdownAddress dealbreakdownaddress)
    {
        return getHttpParams(dealbreakdownaddress, true);
    }

    public String getSelectedShippingLocationId()
    {
        return prefs.getString("preferredShippingLocationId", "");
    }

    public List getShippingAddress()
    {
        return ((StaticSupportInfoService)staticSupportInfoService.get()).getSupportInfo(((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry()).shippingAddress;
    }

    public String getShippingAddressStringEu()
    {
        return prefs.getString("selectedShippingAddress", "");
    }

    public void getShippingAddresses(Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        List list = Arrays.asList(new Object[] {
            "show", "shippingAddresses"
        });
        userService.execute(function1, returningfunction1, function0, String.format("https:/users/%s", new Object[] {
            loginPrefs.getString("userId", "")
        }), "GET", list);
    }

    public com.groupon.models.shipping.ShippingField.MapContainer getShippingFields()
    {
        return (com.groupon.models.shipping.ShippingField.MapContainer)staticJsonShippingFields.get();
    }

    public void getShippingFieldsCLCO(String s, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        (new Http(new Object[] {
            "deal_id", s
        }, function1, returningfunction1, function0) {

            final ShippingService this$0;
            final ReturningFunction1 val$exceptionCallback;
            final Function0 val$finallyCallback;
            final Function1 val$successCallback;

            protected void onException(Exception exception)
                throws RuntimeException
            {
                super.onException(exception);
                if (exceptionCallback != null)
                {
                    exceptionCallback.execute(exception);
                }
            }

            protected void onFinally()
            {
                super.onFinally();
                if (finallyCallback != null)
                {
                    finallyCallback.execute();
                }
            }

            protected void onSuccess(com.groupon.models.shippingFields.json.ShippingField.List list)
                throws Exception
            {
                super.onSuccess(list);
                list = shippingFieldsConverter.fromJson(list);
                successCallback.execute(list);
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((com.groupon.models.shippingFields.json.ShippingField.List)obj);
            }

            transient 
            {
                this$0 = ShippingService.this;
                successCallback = function1;
                exceptionCallback = returningfunction1;
                finallyCallback = function0;
                super(final_context, final_class1, final_s, aobj);
            }
        }).execute();
    }

    public SpecialShippingFieldsCLCO getSpecialShippingFieldsCLCO(List list)
    {
        HashMap hashmap = new HashMap();
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        list = hashmap;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (com.groupon.models.shippingFields.ShippingField)iterator.next();
            if (Strings.equals(((com.groupon.models.shippingFields.ShippingField) (obj)).name, "shipping_state"))
            {
                obj = ((com.groupon.models.shippingFields.ShippingField) (obj)).selectValues.iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    arraylist.add(((ShippingSelectValue)((Iterator) (obj)).next()).value);
                }
            } else
            if (Strings.equals(((com.groupon.models.shippingFields.ShippingField) (obj)).name, "shipping_district"))
            {
                list = ((com.groupon.models.shippingFields.ShippingField) (obj)).dynamicSelectValues;
            }
        } while (true);
        return new SpecialShippingFieldsCLCO(arraylist, list);
    }

    public boolean isFirstNameJP(String s)
    {
        return Strings.equalsIgnoreCase(s, "shippingFirstNameJP");
    }

    public boolean isLastName(String s)
    {
        return Strings.equalsIgnoreCase(s, "shippingLastName") || Strings.equalsIgnoreCase(s, "firstLastNameLatam") || Strings.equalsIgnoreCase(s, "firstLastName") || Strings.equalsIgnoreCase(s, "shippingSurname");
    }

    public boolean isLastNameJP(String s)
    {
        return Strings.equalsIgnoreCase(s, "shippingLastNameJP");
    }

    public boolean isStored()
    {
        if (((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isUSACompatible())
        {
            return prefs.contains("preferredShippingName");
        } else
        {
            return prefs.contains("preferredShippingLocationId");
        }
    }

    public List shippingAddressMulti()
    {
        return ((StaticSupportInfoService)staticSupportInfoService.get()).getSupportInfo(((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry()).shippingAddressMulti;
    }

    public void store(Address address)
    {
        if (address != null)
        {
            store(address.getName(), address.getAddress1(), address.getAddress2(), address.getCity(), address.getState(), address.getPostalCode(), address.getCountryCode());
        }
    }

    public void store(DealBreakdownAddress dealbreakdownaddress)
    {
        store(dealbreakdownaddress, false);
    }

    public void store(DealBreakdownAddress dealbreakdownaddress, boolean flag)
    {
        String s = dealbreakdownaddress.name;
        String s1 = dealbreakdownaddress.streetAddress1;
        String s2 = dealbreakdownaddress.streetAddress2;
        String s9 = dealbreakdownaddress.shippingAddress1;
        String s7 = dealbreakdownaddress.shippingAddress2;
        String s10 = dealbreakdownaddress.address1;
        String s8 = dealbreakdownaddress.address2;
        String s3 = dealbreakdownaddress.city;
        String s4 = dealbreakdownaddress.state;
        String s5 = dealbreakdownaddress.postalCode;
        String s6 = dealbreakdownaddress.country;
        Address address = ((GoogleWalletService)googleWalletService.get()).getMaskedWalletShippingAddress();
        if (!Strings.notEmpty(s))
        {
            if (flag && address != null)
            {
                s = address.getName();
            } else
            {
                s = prefs.getString("preferredShippingName", "");
            }
        }
        if (!Strings.notEmpty(s1))
        {
            if (Strings.notEmpty(s9))
            {
                s1 = s9;
            } else
            {
                s1 = s10;
            }
        }
        if (!Strings.notEmpty(s2))
        {
            if (Strings.notEmpty(s7))
            {
                s2 = s7;
            } else
            {
                s2 = s8;
            }
        }
        if (!Strings.notEmpty(s3))
        {
            s3 = dealbreakdownaddress.shippingCity;
        }
        if (!Strings.notEmpty(s4))
        {
            s4 = dealbreakdownaddress.shippingState;
        }
        if (!Strings.notEmpty(s5))
        {
            s5 = dealbreakdownaddress.shippingPostalCode;
        }
        if (Strings.notEmpty(s6))
        {
            dealbreakdownaddress = s6;
        } else
        {
            dealbreakdownaddress = dealbreakdownaddress.shippingCountry;
        }
        store(s, s1, s2, s3, s4, s5, ((String) (dealbreakdownaddress)));
    }

    public void store(String s)
    {
        prefs.edit().putString("preferredShippingLocationId", s).apply();
    }

    public void store(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        prefs.edit().putString("preferredShippingName", Strings.toString(s).trim()).putString("preferredShippingAddr1", Strings.toString(s1).trim()).putString("preferredShippingAddr2", Strings.toString(s2).trim()).putString("preferredShippingCity", Strings.toString(s3).trim()).putString("preferredShippingState", Strings.toString(s4).trim()).putString("preferredShippingPostalCode", Strings.toString(s5).trim()).putString("preferredShippingCountry", Strings.toString(s6).trim()).apply();
    }

    public void storeMultipleShipping(DealBreakdownAddress dealbreakdownaddress)
    {
        store(dealbreakdownaddress.name, dealbreakdownaddress.address1, dealbreakdownaddress.address2, dealbreakdownaddress.city, dealbreakdownaddress.state, dealbreakdownaddress.postalCode, dealbreakdownaddress.country);
    }

    public transient void updateShippingAddressEu(final Activity final_context, String s, Integer integer, CheckedFunction1 checkedfunction1, Function1 function1, Function0 function0, Object aobj[])
    {
        final_context = (new Http(aobj, checkedfunction1, function1, function0) {

            final ShippingService this$0;
            final Function1 val$exceptionListener;
            final Function0 val$finallyListener;
            final CheckedFunction1 val$listener;

            protected void onException(Exception exception)
            {
                super.onException(exception);
                clearStore();
                if (exceptionListener != null)
                {
                    exceptionListener.execute(exception);
                }
            }

            protected void onFinally()
            {
                super.onFinally();
                if (finallyListener != null)
                {
                    finallyListener.execute();
                }
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((Void)obj);
            }

            protected void onSuccess(Void void1)
                throws Exception
            {
                super.onSuccess(void1);
                if (listener != null)
                {
                    listener.execute(void1);
                }
            }

            transient 
            {
                this$0 = ShippingService.this;
                listener = checkedfunction1;
                exceptionListener = function1;
                finallyListener = function0;
                super(final_context, final_class1, final_s, aobj);
            }
        }).method("PUT");
        if (integer != null)
        {
            final_context.progressView(integer.intValue());
        }
        final_context.execute();
    }

}
