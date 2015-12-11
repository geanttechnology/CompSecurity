// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.Parcel;
import android.text.Html;
import com.google.a.a.e;
import com.target.mothership.common.a.f;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.product.CatEntryId;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.i;
import com.target.mothership.common.product.j;
import com.target.mothership.common.product.m;
import com.target.mothership.common.product.n;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.common.tender.b;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.GiftProduct;
import com.target.mothership.model.cart.interfaces.InitiatedCheckout;
import com.target.mothership.model.cart.interfaces.SaveForLaterProduct;
import com.target.mothership.model.cart.interfaces.UsableShipMode;
import com.target.mothership.model.common.Address;
import com.target.mothership.model.common.Coordinates;
import com.target.mothership.model.common.Geofence;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.OrderProductImage;
import com.target.mothership.model.common.PersonName;
import com.target.mothership.model.common.PhoneNumber;
import com.target.mothership.model.common.a;
import com.target.mothership.model.common.c;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.coupons.interfaces.RegisteredPhone;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.dvm.interfaces.DvmRemoteData;
import com.target.mothership.model.guest.interfaces.AccountDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.guest.interfaces.GuestProfile;
import com.target.mothership.model.guest.interfaces.OrderSummary;
import com.target.mothership.model.product.interfaces.ProductAgeRestriction;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductEsrbRating;
import com.target.mothership.model.product.interfaces.ProductIndustryRating;
import com.target.mothership.model.product.interfaces.ProductOnlineInfo;
import com.target.mothership.model.product.interfaces.ProductStoreInfo;
import com.target.mothership.model.product.interfaces.ProductVariation;
import com.target.mothership.model.product.interfaces.ProductVariationValues;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.model.store.interfaces.StoreDetail;
import com.target.mothership.model.store.interfaces.StoreSummary;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class g
{

    public static final Object Data[];
    public static final AccountDetails FAKE_ACCOUNT_DETAILS;
    public static final GuestAddress FAKE_ADDRESS;
    public static final AddressParams FAKE_ADDRESS_PARAMS;
    public static final ProductDetails FAKE_AGE_RESTRICTED_PRODUCT_DETAILS;
    public static final com.target.mothership.common.params.b FAKE_AMEX_PAYMENT_CARD_PARAMS;
    public static final Guest FAKE_ANON_GUEST = new FakeData._cls7();
    public static final CompletedSignUp FAKE_COMPLETED_SIGNUP;
    public static final DvmDataResponse FAKE_DVM_DATA_RESPONSE = new FakeData._cls33();
    public static final DvmRemoteData FAKE_DVM_REMOTE_DATA = new FakeData._cls32();
    public static final Geofence FAKE_GEOFENCE;
    public static final GiftProduct FAKE_GIFT_PRODUCT_INVALID;
    public static final Guest FAKE_GUEST;
    public static final Guest FAKE_GUEST_NEW = new FakeData._cls9();
    public static final GuestProfile FAKE_GUEST_PROFILE;
    public static final InitiatedCheckout FAKE_INITIATED_CHECKOUT;
    public static final Guest FAKE_LOCAL_GUEST;
    public static final OrderSummary FAKE_ORDER_SUMMARY;
    public static final PaymentTender FAKE_PAYMENT_TENDER;
    public static final CartProduct FAKE_PRODUCT;
    public static final ProductDetails FAKE_PRODUCT_DETAILS;
    public static final ProductVariation FAKE_PRODUCT_GIFT_CARD_VARIATION;
    public static final ProductDetails FAKE_PUIS_PRODUCT_DETAILS;
    public static final RegisteredPhone FAKE_REGISTERED_PHONE;
    public static final Address FAKE_RELEVANT_STORE_ADDRESS_FREQUENTED = new FakeData._cls29();
    public static final Address FAKE_RELEVANT_STORE_ADDRESS_OUTSIDE = new FakeData._cls27();
    public static final Address FAKE_RELEVANT_STORE_ADDRESS_OUTSIDE_2 = new FakeData._cls28();
    public static final RelevantStoreSummary FAKE_RELEVANT_STORE_FREQUENTED;
    public static final RelevantStoreSummary FAKE_RELEVANT_STORE_SUMMARY_INSIDE;
    public static final RelevantStoreSummary FAKE_RELEVANT_STORE_SUMMARY_OUTSIDE;
    public static final RelevantStoreSummary FAKE_RELEVANT_STORE_SUMMARY_OUTSIDE_2 = new FakeData._cls22();
    public static final com.target.mothership.model.store.interfaces.b FAKE_REQUEST_TEAM_MEMBER_CODE;
    public static final SaveForLaterProduct FAKE_SAVE_FOR_LATER_PRODUCT = new FakeData._cls15();
    public static final Store FAKE_STORE;
    public static final Address FAKE_STORE_ADDRESS;
    public static final StoreDetail FAKE_STORE_DETAIL;
    public static final StoreSummary FAKE_STORE_SUMMARY;
    public static final UsableShipMode FAKE_USABLE_SHIP_MODE;

    static 
    {
        FAKE_PRODUCT_DETAILS = new FakeData._cls1();
        FAKE_AGE_RESTRICTED_PRODUCT_DETAILS = new FakeData._cls2();
        FAKE_PUIS_PRODUCT_DETAILS = new FakeData._cls3();
        FAKE_PRODUCT_GIFT_CARD_VARIATION = new FakeData._cls4();
        FAKE_STORE = new FakeData._cls5();
        FAKE_STORE_SUMMARY = new FakeData._cls6();
        FAKE_GUEST = new FakeData._cls8();
        FAKE_GUEST_PROFILE = new FakeData._cls10();
        FAKE_ACCOUNT_DETAILS = new FakeData._cls11();
        FAKE_LOCAL_GUEST = new FakeData._cls12();
        FAKE_ADDRESS_PARAMS = new AddressParams(a.Shipping, Arrays.asList(new String[] {
            "123 main st", "Apt 2"
        }), "New York", "NY", "55111", "USA", "john", "", "smith", "5551234567", c.Home, true);
        FAKE_AMEX_PAYMENT_CARD_PARAMS = com.target.mothership.common.params.b.c("371449635398431", "smith", b.May, 2020, true, FAKE_ADDRESS_PARAMS, true, null);
        FAKE_PAYMENT_TENDER = new FakeData._cls13();
        FAKE_ADDRESS = new FakeData._cls14();
        FAKE_PRODUCT = new FakeData._cls16();
        FAKE_INITIATED_CHECKOUT = new FakeData._cls17();
        FAKE_GIFT_PRODUCT_INVALID = new FakeData._cls18();
        FAKE_USABLE_SHIP_MODE = new FakeData._cls19();
        FAKE_RELEVANT_STORE_SUMMARY_INSIDE = new FakeData._cls20();
        FAKE_RELEVANT_STORE_SUMMARY_OUTSIDE = new FakeData._cls21();
        FAKE_RELEVANT_STORE_FREQUENTED = new FakeData._cls23();
        FAKE_STORE_DETAIL = new FakeData._cls24();
        FAKE_GEOFENCE = new FakeData._cls25();
        FAKE_STORE_ADDRESS = new FakeData._cls26();
        FAKE_REGISTERED_PHONE = new FakeData._cls30();
        FAKE_COMPLETED_SIGNUP = new FakeData._cls31();
        FAKE_ORDER_SUMMARY = new FakeData._cls34();
        FAKE_REQUEST_TEAM_MEMBER_CODE = new com.target.mothership.model.store.interfaces.b() {

            public String a()
            {
                return "Bakery";
            }

            public int b()
            {
                return 137;
            }

        };
        Data = (new Object[] {
            FAKE_GUEST, FAKE_GUEST_PROFILE, FAKE_ACCOUNT_DETAILS, FAKE_ADDRESS, FAKE_ADDRESS_PARAMS, FAKE_AGE_RESTRICTED_PRODUCT_DETAILS, FAKE_GIFT_PRODUCT_INVALID, FAKE_INITIATED_CHECKOUT, FAKE_LOCAL_GUEST, FAKE_AMEX_PAYMENT_CARD_PARAMS, 
            FAKE_PAYMENT_TENDER, FAKE_PRODUCT, FAKE_PRODUCT_DETAILS, FAKE_PRODUCT_GIFT_CARD_VARIATION, FAKE_PUIS_PRODUCT_DETAILS, FAKE_STORE, FAKE_STORE_SUMMARY, FAKE_RELEVANT_STORE_SUMMARY_INSIDE, FAKE_RELEVANT_STORE_SUMMARY_OUTSIDE, FAKE_RELEVANT_STORE_FREQUENTED, 
            FAKE_USABLE_SHIP_MODE, FAKE_STORE_DETAIL, FAKE_GEOFENCE, FAKE_STORE_ADDRESS, FAKE_REGISTERED_PHONE, FAKE_COMPLETED_SIGNUP, FAKE_ORDER_SUMMARY, FAKE_REQUEST_TEAM_MEMBER_CODE
        });
    }

    // Unreferenced inner class com/target/mothership/util/FakeData$1

/* anonymous class */
    static final class FakeData._cls1
        implements ProductDetails
    {

        public List A()
        {
            return Collections.emptyList();
        }

        public boolean B()
        {
            return false;
        }

        public e C()
        {
            return null;
        }

        public e D()
        {
            return com.google.a.a.e.e();
        }

        public List E()
        {
            return null;
        }

        public List F()
        {
            return null;
        }

        public boolean G()
        {
            return false;
        }

        public boolean H()
        {
            return false;
        }

        public boolean I()
        {
            return false;
        }

        public e J()
        {
            return null;
        }

        public e a()
        {
            return com.google.a.a.e.e();
        }

        public e a(String s1, String s2)
        {
            return com.google.a.a.e.e();
        }

        public String b()
        {
            return null;
        }

        public List b(String s1, String s2)
        {
            return Collections.emptyList();
        }

        public ProductOnlineInfo c()
        {
            return null;
        }

        public int describeContents()
        {
            return 0;
        }

        public e e()
        {
            return com.google.a.a.e.e();
        }

        public e f()
        {
            return com.google.a.a.e.b(new CatEntryId("206044347"));
        }

        public String g()
        {
            return null;
        }

        public e h()
        {
            return com.google.a.a.e.e();
        }

        public com.target.mothership.common.product.c i()
        {
            return null;
        }

        public e j()
        {
            return com.google.a.a.e.e();
        }

        public boolean k()
        {
            return false;
        }

        public Tcin k_()
        {
            return null;
        }

        public boolean l()
        {
            return false;
        }

        public List m()
        {
            return null;
        }

        public List n()
        {
            return null;
        }

        public j o()
        {
            return j.OTHERS;
        }

        public e p()
        {
            return com.google.a.a.e.e();
        }

        public e q()
        {
            return com.google.a.a.e.e();
        }

        public e r()
        {
            return com.google.a.a.e.e();
        }

        public e s()
        {
            return com.google.a.a.e.e();
        }

        public ProductAgeRestriction t()
        {
            return new FakeData._cls1._cls1();
        }

        public ProductStoreInfo u()
        {
            return null;
        }

        public e v()
        {
            return com.google.a.a.e.e();
        }

        public List w()
        {
            return Collections.emptyList();
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
        }

        public List x()
        {
            return Collections.emptyList();
        }

        public List y()
        {
            return Collections.emptyList();
        }

        public e z()
        {
            return com.google.a.a.e.e();
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$1$1

/* anonymous class */
    class FakeData._cls1._cls1
        implements ProductAgeRestriction
    {

        final FakeData._cls1 this$0;

        public boolean a()
        {
            return false;
        }

        public String b()
        {
            return null;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

            
            {
                this$0 = FakeData._cls1.this;
                super();
            }
    }


    // Unreferenced inner class com/target/mothership/util/FakeData$1$2

/* anonymous class */
    class FakeData._cls1._cls2
        implements ProductIndustryRating
    {

        final FakeData._cls1 this$0;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }
    }


    // Unreferenced inner class com/target/mothership/util/FakeData$1$2$1

/* anonymous class */
    class FakeData._cls1._cls2._cls1
        implements ProductEsrbRating
    {

        final FakeData._cls1._cls2 this$1;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }
    }


    // Unreferenced inner class com/target/mothership/util/FakeData$10

/* anonymous class */
    static final class FakeData._cls10
        implements GuestProfile
    {

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$11

/* anonymous class */
    static final class FakeData._cls11
        implements AccountDetails
    {

        public int describeContents()
        {
            return 0;
        }

        public int getCartQuantity()
        {
            return 3;
        }

        public String getEmailAddress()
        {
            return "test@example.com";
        }

        public String getFirstName()
        {
            return "Jake";
        }

        public String getLastName()
        {
            return "Smith";
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$12

/* anonymous class */
    static final class FakeData._cls12
        implements Guest
    {

        public int describeContents()
        {
            return 0;
        }

        public String getAccessToken()
        {
            return null;
        }

        public e getAccountDetails()
        {
            return e.e();
        }

        public Date getExpirationDate()
        {
            return null;
        }

        public String getGuestId()
        {
            return com.target.mothership.model.guest.b.a().getGuestId();
        }

        public String getRefreshToken()
        {
            return null;
        }

        public boolean isAnonymous()
        {
            return com.target.mothership.model.guest.b.a().isAnonymous();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$13

/* anonymous class */
    static final class FakeData._cls13
        implements PaymentTender
    {

        public String a()
        {
            return "memberCardInfoId here";
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$14

/* anonymous class */
    static final class FakeData._cls14
        implements GuestAddress
    {

        public String a()
        {
            return "12345";
        }

        public a b()
        {
            return a.Shipping;
        }

        public e c()
        {
            return com.google.a.a.e.c(new FakeData._cls14._cls1());
        }

        public PhoneNumber d()
        {
            return new FakeData._cls14._cls2();
        }

        public int describeContents()
        {
            return 0;
        }

        public Boolean e()
        {
            return Boolean.valueOf(true);
        }

        public List getAddressLines()
        {
            ArrayList arraylist = new ArrayList(1);
            arraylist.add("123 Main Street");
            return arraylist;
        }

        public String getCity()
        {
            return "Minneapolis";
        }

        public String getCountry()
        {
            return "USA";
        }

        public String getPostalCode()
        {
            return "55401";
        }

        public String getStateOrProvince()
        {
            return "MN";
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$14$1

/* anonymous class */
    class FakeData._cls14._cls1
        implements PersonName
    {

        final FakeData._cls14 this$0;

        public String a()
        {
            return "George";
        }

        public String b()
        {
            return null;
        }

        public String c()
        {
            return "Herman";
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

            
            {
                this$0 = FakeData._cls14.this;
                super();
            }
    }


    // Unreferenced inner class com/target/mothership/util/FakeData$14$2

/* anonymous class */
    class FakeData._cls14._cls2
        implements PhoneNumber
    {

        final FakeData._cls14 this$0;

        public String a()
        {
            return "555-555-5555";
        }

        public c b()
        {
            return c.Home;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

            
            {
                this$0 = FakeData._cls14.this;
                super();
            }
    }


    // Unreferenced inner class com/target/mothership/util/FakeData$15

/* anonymous class */
    static final class FakeData._cls15
        implements SaveForLaterProduct
    {

        public OrderProductImage a()
        {
            return null;
        }

        public String b()
        {
            return "2083384767";
        }

        public BigDecimal c()
        {
            return BigDecimal.TEN;
        }

        public int describeContents()
        {
            return 0;
        }

        public e e()
        {
            return com.google.a.a.e.e();
        }

        public e f()
        {
            return com.google.a.a.e.e();
        }

        public String g()
        {
            return "Saved For Later Product";
        }

        public e h()
        {
            return com.google.a.a.e.e();
        }

        public boolean i()
        {
            return false;
        }

        public Tcin k_()
        {
            return new Tcin("1234567890");
        }

        public void writeToParcel(Parcel parcel, int j)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$16

/* anonymous class */
    static final class FakeData._cls16
        implements CartProduct
    {

        public boolean A()
        {
            return false;
        }

        public String a()
        {
            return "2083384767";
        }

        public OrderProductImage b()
        {
            return null;
        }

        public com.target.mothership.common.a.b c()
        {
            return com.target.mothership.common.a.b.Premium;
        }

        public f d()
        {
            return f.ShipToHome;
        }

        public int describeContents()
        {
            return 0;
        }

        public e e()
        {
            return com.google.a.a.e.b(new Dpci("003-08-0594"));
        }

        public e f()
        {
            return com.google.a.a.e.b(new CatEntryId("204520078"));
        }

        public String g()
        {
            return "Tide Clean Breeze High Efficiency Liquid Laundry Detergent - 100 oz";
        }

        public i g_()
        {
            return i.InStock;
        }

        public e h()
        {
            return com.google.a.a.e.e();
        }

        public BigDecimal h_()
        {
            return new BigDecimal("9.99");
        }

        public e i()
        {
            return com.google.a.a.e.b(Integer.valueOf(3));
        }

        public BigDecimal i_()
        {
            return new BigDecimal("9.99");
        }

        public e j()
        {
            return com.google.a.a.e.e();
        }

        public int j_()
        {
            return 1;
        }

        public e k()
        {
            return com.google.a.a.e.e();
        }

        public Tcin k_()
        {
            return new Tcin("13918062");
        }

        public e l()
        {
            return com.google.a.a.e.e();
        }

        public boolean m()
        {
            return false;
        }

        public boolean n()
        {
            return false;
        }

        public boolean o()
        {
            return false;
        }

        public Date p()
        {
            return null;
        }

        public boolean q()
        {
            return false;
        }

        public boolean r()
        {
            return false;
        }

        public boolean s()
        {
            return false;
        }

        public boolean t()
        {
            return false;
        }

        public e u()
        {
            return com.google.a.a.e.b(new Date());
        }

        public e v()
        {
            return com.google.a.a.e.e();
        }

        public boolean w()
        {
            return false;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
        }

        public List x()
        {
            return Collections.emptyList();
        }

        public List y()
        {
            return Collections.emptyList();
        }

        public String z()
        {
            return "12051";
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$17

/* anonymous class */
    static final class FakeData._cls17
        implements InitiatedCheckout
    {

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$18

/* anonymous class */
    static final class FakeData._cls18
        implements GiftProduct
    {

        public List a()
        {
            return null;
        }

        public BigDecimal b()
        {
            return new BigDecimal("10.00");
        }

        public com.target.mothership.common.a.b c()
        {
            return com.target.mothership.common.a.b.Email;
        }

        public int d()
        {
            return 1;
        }

        public int describeContents()
        {
            return 0;
        }

        public e e()
        {
            return com.google.a.a.e.b(new Dpci("790-05-1836"));
        }

        public e f()
        {
            return com.google.a.a.e.b(new CatEntryId("111111111"));
        }

        public String g()
        {
            return Html.fromHtml("Promotional Email Gift Card $10").toString();
        }

        public e h()
        {
            return com.google.a.a.e.e();
        }

        public Tcin k_()
        {
            return new Tcin("14713509");
        }

        public boolean l_()
        {
            return false;
        }

        public String m_()
        {
            return "2849019";
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$19

/* anonymous class */
    static final class FakeData._cls19
        implements UsableShipMode
    {

        public com.target.mothership.common.a.b a()
        {
            return com.target.mothership.common.a.b.Express;
        }

        public int b()
        {
            return 12053;
        }

        public e c()
        {
            return e.b(new Date());
        }

        public e d()
        {
            return e.e();
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$2

/* anonymous class */
    static final class FakeData._cls2
        implements ProductDetails
    {

        public List A()
        {
            return Collections.emptyList();
        }

        public boolean B()
        {
            return false;
        }

        public e C()
        {
            return null;
        }

        public e D()
        {
            return com.google.a.a.e.e();
        }

        public List E()
        {
            return null;
        }

        public List F()
        {
            return null;
        }

        public boolean G()
        {
            return false;
        }

        public boolean H()
        {
            return false;
        }

        public boolean I()
        {
            return false;
        }

        public e J()
        {
            return null;
        }

        public e a()
        {
            return com.google.a.a.e.e();
        }

        public e a(String s1, String s2)
        {
            return com.google.a.a.e.e();
        }

        public String b()
        {
            return null;
        }

        public List b(String s1, String s2)
        {
            return Collections.emptyList();
        }

        public ProductOnlineInfo c()
        {
            return null;
        }

        public int describeContents()
        {
            return 0;
        }

        public e e()
        {
            return com.google.a.a.e.e();
        }

        public e f()
        {
            return com.google.a.a.e.b(new CatEntryId("205371698"));
        }

        public String g()
        {
            return null;
        }

        public e h()
        {
            return com.google.a.a.e.e();
        }

        public com.target.mothership.common.product.c i()
        {
            return null;
        }

        public e j()
        {
            return com.google.a.a.e.e();
        }

        public boolean k()
        {
            return false;
        }

        public Tcin k_()
        {
            return null;
        }

        public boolean l()
        {
            return false;
        }

        public List m()
        {
            return null;
        }

        public List n()
        {
            return null;
        }

        public j o()
        {
            return j.OTHERS;
        }

        public e p()
        {
            return com.google.a.a.e.e();
        }

        public e q()
        {
            return com.google.a.a.e.e();
        }

        public e r()
        {
            return com.google.a.a.e.e();
        }

        public e s()
        {
            return com.google.a.a.e.e();
        }

        public ProductAgeRestriction t()
        {
            return null;
        }

        public ProductStoreInfo u()
        {
            new FakeData._cls2._cls2();
            return null;
        }

        public e v()
        {
            return com.google.a.a.e.e();
        }

        public List w()
        {
            return Collections.emptyList();
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
        }

        public List x()
        {
            return null;
        }

        public List y()
        {
            return null;
        }

        public e z()
        {
            return com.google.a.a.e.e();
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$2$1

/* anonymous class */
    class FakeData._cls2._cls1
        implements ProductIndustryRating
    {

        final FakeData._cls2 this$0;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }
    }


    // Unreferenced inner class com/target/mothership/util/FakeData$2$1$1

/* anonymous class */
    class FakeData._cls2._cls1._cls1
        implements ProductEsrbRating
    {

        final FakeData._cls2._cls1 this$1;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }
    }


    // Unreferenced inner class com/target/mothership/util/FakeData$2$2

/* anonymous class */
    class FakeData._cls2._cls2
        implements ProductStoreInfo
    {

        final FakeData._cls2 this$0;

        public boolean a()
        {
            return false;
        }

        public List b()
        {
            return null;
        }

        public i c()
        {
            return null;
        }

        public m d()
        {
            return m.PickUpInStore;
        }

        public int describeContents()
        {
            return 0;
        }

        public n i()
        {
            return n.SINGLE;
        }

        public e j()
        {
            return e.e();
        }

        public e k()
        {
            return e.e();
        }

        public void writeToParcel(Parcel parcel, int l)
        {
        }

            
            {
                this$0 = FakeData._cls2.this;
                super();
            }
    }


    // Unreferenced inner class com/target/mothership/util/FakeData$20

/* anonymous class */
    static final class FakeData._cls20
        implements RelevantStoreSummary
    {

        public boolean a()
        {
            return true;
        }

        public boolean b()
        {
            return false;
        }

        public boolean c()
        {
            return false;
        }

        public int describeContents()
        {
            return 0;
        }

        public Address getAddress()
        {
            return g.FAKE_STORE_ADDRESS;
        }

        public Geofence getGeofence()
        {
            return g.FAKE_GEOFENCE;
        }

        public String getName()
        {
            return "Oahu-Honolulu West";
        }

        public StoreIdentifier getStoreId()
        {
            return new StoreIdentifier("2410");
        }

        public boolean hasRequestATeamMember()
        {
            return false;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$21

/* anonymous class */
    static final class FakeData._cls21
        implements RelevantStoreSummary
    {

        public boolean a()
        {
            return false;
        }

        public boolean b()
        {
            return false;
        }

        public boolean c()
        {
            return false;
        }

        public int describeContents()
        {
            return 0;
        }

        public Address getAddress()
        {
            return g.FAKE_RELEVANT_STORE_ADDRESS_OUTSIDE;
        }

        public Geofence getGeofence()
        {
            return g.FAKE_GEOFENCE;
        }

        public String getName()
        {
            return "Hawaii-Kona";
        }

        public StoreIdentifier getStoreId()
        {
            return new StoreIdentifier("2412");
        }

        public boolean hasRequestATeamMember()
        {
            return false;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$22

/* anonymous class */
    static final class FakeData._cls22
        implements RelevantStoreSummary
    {

        public boolean a()
        {
            return false;
        }

        public boolean b()
        {
            return false;
        }

        public boolean c()
        {
            return false;
        }

        public int describeContents()
        {
            return 0;
        }

        public Address getAddress()
        {
            return g.FAKE_RELEVANT_STORE_ADDRESS_OUTSIDE_2;
        }

        public Geofence getGeofence()
        {
            return g.FAKE_GEOFENCE;
        }

        public String getName()
        {
            return "Oahu-Kapolei";
        }

        public StoreIdentifier getStoreId()
        {
            return new StoreIdentifier("2411");
        }

        public boolean hasRequestATeamMember()
        {
            return false;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$23

/* anonymous class */
    static final class FakeData._cls23
        implements RelevantStoreSummary
    {

        public boolean a()
        {
            return false;
        }

        public boolean b()
        {
            return true;
        }

        public boolean c()
        {
            return false;
        }

        public int describeContents()
        {
            return 0;
        }

        public Address getAddress()
        {
            return g.FAKE_RELEVANT_STORE_ADDRESS_FREQUENTED;
        }

        public Geofence getGeofence()
        {
            return g.FAKE_GEOFENCE;
        }

        public String getName()
        {
            return "Hawaii-Hilo";
        }

        public StoreIdentifier getStoreId()
        {
            return new StoreIdentifier("2682");
        }

        public boolean hasRequestATeamMember()
        {
            return false;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$24

/* anonymous class */
    static final class FakeData._cls24
        implements StoreDetail
    {

        public String a()
        {
            return "Oahu-Honolulu West";
        }

        public Address b()
        {
            return g.FAKE_STORE_ADDRESS;
        }

        public List c()
        {
            return new ArrayList();
        }

        public List d()
        {
            return new ArrayList();
        }

        public int describeContents()
        {
            return 0;
        }

        public List e()
        {
            return new ArrayList();
        }

        public List f()
        {
            return new ArrayList();
        }

        public StoreIdentifier getStoreId()
        {
            return new StoreIdentifier("2410");
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$25

/* anonymous class */
    static final class FakeData._cls25
        implements Geofence
    {

        public int describeContents()
        {
            return 0;
        }

        public Coordinates getCenter()
        {
            return new FakeData._cls25._cls1();
        }

        public double getRadius()
        {
            return 500D;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$25$1

/* anonymous class */
    class FakeData._cls25._cls1
        implements Coordinates
    {

        final FakeData._cls25 this$0;

        public int describeContents()
        {
            return 0;
        }

        public double getLatitude()
        {
            return 45D;
        }

        public double getLongitude()
        {
            return -90D;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

            
            {
                this$0 = FakeData._cls25.this;
                super();
            }
    }


    // Unreferenced inner class com/target/mothership/util/FakeData$26

/* anonymous class */
    static final class FakeData._cls26
        implements Address
    {

        public int describeContents()
        {
            return 0;
        }

        public List getAddressLines()
        {
            return Arrays.asList(new String[] {
                "4380 Lawehana St"
            });
        }

        public String getCity()
        {
            return "Honolulu";
        }

        public String getCountry()
        {
            return "USA";
        }

        public String getPostalCode()
        {
            return "96818";
        }

        public String getStateOrProvince()
        {
            return "HI";
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$27

/* anonymous class */
    static final class FakeData._cls27
        implements Address
    {

        public int describeContents()
        {
            return 0;
        }

        public List getAddressLines()
        {
            return Arrays.asList(new String[] {
                "74-5455 Makala Blvd"
            });
        }

        public String getCity()
        {
            return "Kaliua Kona";
        }

        public String getCountry()
        {
            return "USA";
        }

        public String getPostalCode()
        {
            return "96740-2727";
        }

        public String getStateOrProvince()
        {
            return "HI";
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$28

/* anonymous class */
    static final class FakeData._cls28
        implements Address
    {

        public int describeContents()
        {
            return 0;
        }

        public List getAddressLines()
        {
            return Arrays.asList(new String[] {
                "4450 Kapolei Pkwy"
            });
        }

        public String getCity()
        {
            return "Kapolei";
        }

        public String getCountry()
        {
            return "USA";
        }

        public String getPostalCode()
        {
            return "96707-1878";
        }

        public String getStateOrProvince()
        {
            return "HI";
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$29

/* anonymous class */
    static final class FakeData._cls29
        implements Address
    {

        public int describeContents()
        {
            return 0;
        }

        public List getAddressLines()
        {
            return Arrays.asList(new String[] {
                "391 E Makaala St"
            });
        }

        public String getCity()
        {
            return "Hilo";
        }

        public String getCountry()
        {
            return "USA";
        }

        public String getPostalCode()
        {
            return "96720-5146";
        }

        public String getStateOrProvince()
        {
            return "HI";
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$3

/* anonymous class */
    static final class FakeData._cls3
        implements ProductDetails
    {

        public List A()
        {
            return Collections.emptyList();
        }

        public boolean B()
        {
            return false;
        }

        public e C()
        {
            return null;
        }

        public e D()
        {
            return com.google.a.a.e.e();
        }

        public List E()
        {
            return null;
        }

        public List F()
        {
            return null;
        }

        public boolean G()
        {
            return false;
        }

        public boolean H()
        {
            return false;
        }

        public boolean I()
        {
            return false;
        }

        public e J()
        {
            return null;
        }

        public e a()
        {
            return com.google.a.a.e.e();
        }

        public e a(String s1, String s2)
        {
            return com.google.a.a.e.e();
        }

        public String b()
        {
            return null;
        }

        public List b(String s1, String s2)
        {
            return Collections.emptyList();
        }

        public ProductOnlineInfo c()
        {
            return null;
        }

        public int describeContents()
        {
            return 0;
        }

        public e e()
        {
            return com.google.a.a.e.e();
        }

        public e f()
        {
            return com.google.a.a.e.b(new CatEntryId("205997648"));
        }

        public String g()
        {
            return null;
        }

        public e h()
        {
            return com.google.a.a.e.e();
        }

        public com.target.mothership.common.product.c i()
        {
            return null;
        }

        public e j()
        {
            return com.google.a.a.e.e();
        }

        public boolean k()
        {
            return false;
        }

        public Tcin k_()
        {
            return null;
        }

        public boolean l()
        {
            return false;
        }

        public List m()
        {
            return null;
        }

        public List n()
        {
            return null;
        }

        public j o()
        {
            return j.OTHERS;
        }

        public e p()
        {
            return com.google.a.a.e.e();
        }

        public e q()
        {
            return com.google.a.a.e.e();
        }

        public e r()
        {
            return com.google.a.a.e.e();
        }

        public e s()
        {
            return com.google.a.a.e.e();
        }

        public ProductAgeRestriction t()
        {
            return null;
        }

        public ProductStoreInfo u()
        {
            new FakeData._cls3._cls2();
            return null;
        }

        public e v()
        {
            return com.google.a.a.e.e();
        }

        public List w()
        {
            return Collections.emptyList();
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
        }

        public List x()
        {
            return null;
        }

        public List y()
        {
            return null;
        }

        public e z()
        {
            return com.google.a.a.e.e();
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$3$1

/* anonymous class */
    class FakeData._cls3._cls1
        implements ProductIndustryRating
    {

        final FakeData._cls3 this$0;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }
    }


    // Unreferenced inner class com/target/mothership/util/FakeData$3$1$1

/* anonymous class */
    class FakeData._cls3._cls1._cls1
        implements ProductEsrbRating
    {

        final FakeData._cls3._cls1 this$1;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }
    }


    // Unreferenced inner class com/target/mothership/util/FakeData$3$2

/* anonymous class */
    class FakeData._cls3._cls2
        implements ProductStoreInfo
    {

        final FakeData._cls3 this$0;

        public boolean a()
        {
            return false;
        }

        public List b()
        {
            return null;
        }

        public i c()
        {
            return null;
        }

        public m d()
        {
            return m.PickUpInStore;
        }

        public int describeContents()
        {
            return 0;
        }

        public n i()
        {
            return n.SINGLE;
        }

        public e j()
        {
            return e.e();
        }

        public e k()
        {
            return e.e();
        }

        public void writeToParcel(Parcel parcel, int l)
        {
        }

            
            {
                this$0 = FakeData._cls3.this;
                super();
            }
    }


    // Unreferenced inner class com/target/mothership/util/FakeData$30

/* anonymous class */
    static final class FakeData._cls30
        implements RegisteredPhone
    {

        public String a()
        {
            return "3123123123";
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$31

/* anonymous class */
    static final class FakeData._cls31
        implements CompletedSignUp
    {

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$32

/* anonymous class */
    static final class FakeData._cls32
        implements DvmRemoteData
    {

        public URL a()
        {
            URL url;
            try
            {
                url = new URL("http://pubads.g.doubleclick.net/gampad/adx?m=application/json&sz=1x1&iu=/7079046/mtarget_test/RedSkyTest/Target/back_to_college/college_electronics/college_video_games&t=pt%3Dproductdetails%26nap%3Diphone%26item%3D15623726%26cat%3Dcollege_video_games");
            }
            catch (MalformedURLException malformedurlexception)
            {
                return null;
            }
            return url;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$33

/* anonymous class */
    static final class FakeData._cls33
        implements DvmDataResponse
    {

        public String a()
        {
            return new String("http://pagead2.googlesyndication.com/pagead/imgad?id=CICAgKDT8MzcdhABGAEyCFoOm7cUISTA");
        }

        public String b()
        {
            return "http://adclick.g.doubleclick.net/aclk?sa=L&ai=BL_vroklSVdC8BNCQpgO9y4HIAq789OsFAAAAEAEg_pqnFzgAWPabmcLSAWDJtuCJlKSYE7oBCWdmcF9pbWFnZcgBCcACAuACAOoCIC83MDc5MDQ2L210YXJnZXRfdGVzdC9SZWRTa3lUZXN0-AL_0R6AAwGQA6QDmAOkA6gDAeAEAZAGAaAGH9gHAA&num=0&cid=5GiwSneFH3o3EoNdWy_xVtqd&sig=AOD64_1OqFgve3WK9QIDpr-dkIhnij0qVA&client=ca-pub-5802538799304581&adurl=";
        }

        public String c()
        {
            return "target://product/detail?idType=TCIN&id=16731163&trackingId=dvmo181435646l23402486c56510270966";
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$34

/* anonymous class */
    static final class FakeData._cls34
        implements OrderSummary
    {

        public String a()
        {
            return "872364834556";
        }

        public Date b()
        {
            return null;
        }

        public List c()
        {
            return Collections.emptyList();
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$4

/* anonymous class */
    static final class FakeData._cls4
        implements ProductVariation
    {

        public List A()
        {
            return Collections.emptyList();
        }

        public boolean B()
        {
            return false;
        }

        public e C()
        {
            return null;
        }

        public e D()
        {
            return com.google.a.a.e.e();
        }

        public List E()
        {
            return Collections.emptyList();
        }

        public List F()
        {
            return Collections.emptyList();
        }

        public boolean G()
        {
            return false;
        }

        public boolean H()
        {
            return false;
        }

        public boolean I()
        {
            return false;
        }

        public e J()
        {
            return com.google.a.a.e.e();
        }

        public e a()
        {
            return com.google.a.a.e.e();
        }

        public e a(String s1, String s2)
        {
            return com.google.a.a.e.e();
        }

        public String b()
        {
            return null;
        }

        public List b(String s1, String s2)
        {
            return Collections.emptyList();
        }

        public ProductOnlineInfo c()
        {
            return null;
        }

        public int describeContents()
        {
            return 0;
        }

        public e e()
        {
            return com.google.a.a.e.e();
        }

        public e f()
        {
            return com.google.a.a.e.b(new CatEntryId("203712629"));
        }

        public String g()
        {
            return null;
        }

        public e h()
        {
            return com.google.a.a.e.e();
        }

        public com.target.mothership.common.product.c i()
        {
            return null;
        }

        public e j()
        {
            return com.google.a.a.e.e();
        }

        public boolean k()
        {
            return false;
        }

        public Tcin k_()
        {
            return null;
        }

        public boolean l()
        {
            return false;
        }

        public List m()
        {
            return null;
        }

        public List n()
        {
            return null;
        }

        public j o()
        {
            return j.OTHERS;
        }

        public e p()
        {
            return com.google.a.a.e.e();
        }

        public e q()
        {
            return com.google.a.a.e.e();
        }

        public e r()
        {
            return com.google.a.a.e.e();
        }

        public e s()
        {
            return com.google.a.a.e.e();
        }

        public ProductAgeRestriction t()
        {
            return null;
        }

        public ProductStoreInfo u()
        {
            return null;
        }

        public e v()
        {
            return com.google.a.a.e.b(new FakeData._cls4._cls1());
        }

        public List w()
        {
            return null;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
        }

        public List x()
        {
            return null;
        }

        public List y()
        {
            return null;
        }

        public e z()
        {
            return com.google.a.a.e.e();
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$4$1

/* anonymous class */
    class FakeData._cls4._cls1
        implements ProductVariationValues
    {

        final FakeData._cls4 this$0;

        public String a()
        {
            return "GIFTCARD_DELIVERY";
        }

        public String b()
        {
            return "MOBILE";
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

            
            {
                this$0 = FakeData._cls4.this;
                super();
            }
    }


    // Unreferenced inner class com/target/mothership/util/FakeData$5

/* anonymous class */
    static final class FakeData._cls5
        implements Store
    {

        public int describeContents()
        {
            return 0;
        }

        public StoreIdentifier getStoreId()
        {
            return new StoreIdentifier("52");
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$6

/* anonymous class */
    static final class FakeData._cls6
        implements StoreSummary
    {

        public int describeContents()
        {
            return 0;
        }

        public Address getAddress()
        {
            return new FakeData._cls6._cls1();
        }

        public Geofence getGeofence()
        {
            return g.FAKE_GEOFENCE;
        }

        public String getName()
        {
            return "Nicollet Mall";
        }

        public StoreIdentifier getStoreId()
        {
            return new StoreIdentifier("52");
        }

        public boolean hasRequestATeamMember()
        {
            return false;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$6$1

/* anonymous class */
    class FakeData._cls6._cls1
        implements Address
    {

        final FakeData._cls6 this$0;

        public int describeContents()
        {
            return 0;
        }

        public List getAddressLines()
        {
            return Arrays.asList(new String[] {
                "1100 Nicollet Ave"
            });
        }

        public String getCity()
        {
            return "Minneapolis";
        }

        public String getCountry()
        {
            return "USA";
        }

        public String getPostalCode()
        {
            return "55123";
        }

        public String getStateOrProvince()
        {
            return "MN";
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

            
            {
                this$0 = FakeData._cls6.this;
                super();
            }
    }


    // Unreferenced inner class com/target/mothership/util/FakeData$7

/* anonymous class */
    static final class FakeData._cls7
        implements Guest
    {

        public int describeContents()
        {
            return 0;
        }

        public String getAccessToken()
        {
            return "fake access token";
        }

        public e getAccountDetails()
        {
            return e.e();
        }

        public Date getExpirationDate()
        {
            return new Date();
        }

        public String getGuestId()
        {
            return "123345";
        }

        public String getRefreshToken()
        {
            return "fake refresh token";
        }

        public boolean isAnonymous()
        {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$8

/* anonymous class */
    static final class FakeData._cls8
        implements Guest
    {

        public int describeContents()
        {
            return 0;
        }

        public String getAccessToken()
        {
            return "fake access token";
        }

        public e getAccountDetails()
        {
            return e.b(g.FAKE_ACCOUNT_DETAILS);
        }

        public Date getExpirationDate()
        {
            return new Date();
        }

        public String getGuestId()
        {
            return "123345";
        }

        public String getRefreshToken()
        {
            return "fake refresh token";
        }

        public boolean isAnonymous()
        {
            return false;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }


    // Unreferenced inner class com/target/mothership/util/FakeData$9

/* anonymous class */
    static final class FakeData._cls9
        implements Guest
    {

        public int describeContents()
        {
            return 0;
        }

        public String getAccessToken()
        {
            return "fake access token";
        }

        public e getAccountDetails()
        {
            return e.b(g.FAKE_ACCOUNT_DETAILS);
        }

        public Date getExpirationDate()
        {
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, 30);
            return calendar.getTime();
        }

        public String getGuestId()
        {
            return "123345";
        }

        public String getRefreshToken()
        {
            return "fake refresh token";
        }

        public boolean isAnonymous()
        {
            return false;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }

}
