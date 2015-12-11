// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;

import android.app.Application;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.AnnotatedConstantBindingBuilder;
import com.google.inject.binder.ConstantBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.name.Names;
import com.groupon.component.creditcardscanner.CreditCardScanner;
import com.groupon.cookies.CookieFactory;
import com.groupon.db.dao.DaoBand;
import com.groupon.db.dao.DaoBugReportEmail;
import com.groupon.db.dao.DaoBusiness;
import com.groupon.db.dao.DaoBusinessSummary;
import com.groupon.db.dao.DaoCategorizationItem;
import com.groupon.db.dao.DaoCategory;
import com.groupon.db.dao.DaoCollection;
import com.groupon.db.dao.DaoCollectionCardAttribute;
import com.groupon.db.dao.DaoCouponCategory;
import com.groupon.db.dao.DaoCouponDetail;
import com.groupon.db.dao.DaoCouponMerchant;
import com.groupon.db.dao.DaoCouponSummary;
import com.groupon.db.dao.DaoCustomField;
import com.groupon.db.dao.DaoDeal;
import com.groupon.db.dao.DaoDealSubsetAttribute;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.dao.DaoDealType;
import com.groupon.db.dao.DaoDeliveryEstimation;
import com.groupon.db.dao.DaoDivision;
import com.groupon.db.dao.DaoExternalDealProvider;
import com.groupon.db.dao.DaoFinder;
import com.groupon.db.dao.DaoGiftWrappingCharge;
import com.groupon.db.dao.DaoGiftingCategory;
import com.groupon.db.dao.DaoGiftingTheme;
import com.groupon.db.dao.DaoHotel;
import com.groupon.db.dao.DaoHotelReview;
import com.groupon.db.dao.DaoHotelReviews;
import com.groupon.db.dao.DaoImage;
import com.groupon.db.dao.DaoInAppMessage;
import com.groupon.db.dao.DaoIncentive;
import com.groupon.db.dao.DaoInventoryService;
import com.groupon.db.dao.DaoLegalDisclosure;
import com.groupon.db.dao.DaoLocation;
import com.groupon.db.dao.DaoMarketRateResult;
import com.groupon.db.dao.DaoMerchant;
import com.groupon.db.dao.DaoMyGrouponItem;
import com.groupon.db.dao.DaoMyGrouponItemSummary;
import com.groupon.db.dao.DaoOption;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.dao.DaoPrice;
import com.groupon.db.dao.DaoPricingMetadata;
import com.groupon.db.dao.DaoProvider;
import com.groupon.db.dao.DaoRating;
import com.groupon.db.dao.DaoRecommendation;
import com.groupon.db.dao.DaoSchedulerOption;
import com.groupon.db.dao.DaoShipment;
import com.groupon.db.dao.DaoShippingOption;
import com.groupon.db.dao.DaoSnapGroceryDetails;
import com.groupon.db.dao.DaoSpecial;
import com.groupon.db.dao.DaoStockCategory;
import com.groupon.db.dao.DaoStockValue;
import com.groupon.db.dao.DaoTip;
import com.groupon.db.dao.DaoTrait;
import com.groupon.db.dao.DaoUiTreatment;
import com.groupon.db.dao.DaoUniversal;
import com.groupon.db.dao.DaoVideo;
import com.groupon.db.dao.DaoWidgetSummary;
import com.groupon.db.models.Band;
import com.groupon.db.models.BugReportEmail;
import com.groupon.db.models.Business;
import com.groupon.db.models.BusinessSummary;
import com.groupon.db.models.CategorizationItem;
import com.groupon.db.models.Category;
import com.groupon.db.models.CollectionCardAttribute;
import com.groupon.db.models.CouponCategory;
import com.groupon.db.models.CouponDetail;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.CouponSummary;
import com.groupon.db.models.CustomField;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealCollection;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.DealType;
import com.groupon.db.models.DeliveryEstimation;
import com.groupon.db.models.Division;
import com.groupon.db.models.ExternalDealProvider;
import com.groupon.db.models.Finder;
import com.groupon.db.models.GiftWrappingCharge;
import com.groupon.db.models.GiftingCategory;
import com.groupon.db.models.GiftingTheme;
import com.groupon.db.models.Hotel;
import com.groupon.db.models.HotelReview;
import com.groupon.db.models.HotelReviews;
import com.groupon.db.models.Image;
import com.groupon.db.models.InAppMessage;
import com.groupon.db.models.Incentive;
import com.groupon.db.models.InventoryService;
import com.groupon.db.models.LegalDisclosure;
import com.groupon.db.models.Location;
import com.groupon.db.models.MarketRateResult;
import com.groupon.db.models.Merchant;
import com.groupon.db.models.Option;
import com.groupon.db.models.Pagination;
import com.groupon.db.models.Price;
import com.groupon.db.models.PricingMetadata;
import com.groupon.db.models.Rating;
import com.groupon.db.models.Recommendation;
import com.groupon.db.models.SchedulerOption;
import com.groupon.db.models.Shipment;
import com.groupon.db.models.ShippingOption;
import com.groupon.db.models.SnapGroceryDetail;
import com.groupon.db.models.Special;
import com.groupon.db.models.StockCategory;
import com.groupon.db.models.StockValue;
import com.groupon.db.models.Tip;
import com.groupon.db.models.Trait;
import com.groupon.db.models.UiTreatment;
import com.groupon.db.models.UniversalStub;
import com.groupon.db.models.Video;
import com.groupon.db.models.WidgetSummary;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.db.models.mygroupons.MyGrouponItemSummary;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.http.GrouponOkHttpClient;
import com.groupon.http.UserAgentProvider;
import com.groupon.inject.ArrayObscuredSharedPreferencesProvider;
import com.groupon.inject.ArraySharedPreferencesProvider;
import com.groupon.inject.ReferrerProvider;
import com.groupon.inject.SingleThreadPausableThreadPoolExecutorProvider;
import com.groupon.provider.CreditCardScannerProvider;
import com.groupon.provider.LocalizedSharedPreferencesProvider;
import com.groupon.service.LoginService;
import com.groupon.service.ReportABugPreferenceChanged;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.DeviceSettings;
import com.groupon.tracking.mobile.sdk.ExceptionFunctor;
import com.groupon.tracking.mobile.sdk.InfoFunctor;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.DTFDateTimeFormat;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.FullDateTimeFormat;
import com.groupon.util.GrouponLnImpl;
import com.groupon.util.HumanReadableCountdownFormatB;
import com.groupon.util.HumanReadableCountdownFormatC;
import com.groupon.util.IntlDateFormat;
import com.groupon.util.LocalTimeDateFormat;
import com.groupon.util.LoggerNotifier;
import com.groupon.util.LoggerNotifierDialog;
import com.groupon.util.LoggerProxy;
import com.groupon.util.LongDateFormat;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.PausableThreadPoolExecutor;
import com.groupon.util.WeekDateFormat;
import com.groupon.util.ZonedDateTimeFormat;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;
import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.restlet.engine.util.InternetDateFormat;
import roboguice.inject.ContextSingleton;
import roboguice.inject.SharedPreferencesName;
import roboguice.inject.fragment.FragmentManagerProvider;
import roboguice.inject.fragment.SupportFragmentManagerProvider;
import roboguice.util.Ln;
import roboguice.util.LnInterface;
import roboguice.util.Strings;

// Referenced classes of package com.groupon:
//            ConsumerDeviceSettings

public class GrouponModule extends AbstractModule
{

    private Application app;
    private final DeviceInfoUtil deviceInfoUtil;
    private boolean loggingEnabled;

    public GrouponModule(Application application)
    {
        this(application, true);
    }

    public GrouponModule(Application application, boolean flag)
    {
        app = application;
        loggingEnabled = flag;
        deviceInfoUtil = new DeviceInfoUtil(application);
    }

    private void bindAnnotatedObscuredSharedPreferences(String s)
    {
        bind(com/groupon/util/ArraySharedPreferences).annotatedWith(Names.named(s)).toProvider(new ArrayObscuredSharedPreferencesProvider(s));
    }

    private void bindAnnotatedSharedPreferences(String s)
    {
        bind(com/groupon/util/ArraySharedPreferences).annotatedWith(Names.named(s)).toProvider(new ArraySharedPreferencesProvider(s));
    }

    private void bindAnnotatedSharedPreferences(String s, Class class1)
    {
        bind(com/groupon/util/ArraySharedPreferences).annotatedWith(Names.named(s)).toProvider(class1);
    }

    private void bindDaoToPojo(Class class1, Class class2)
    {
        superbind(class1).toProvider(new DaoProvider(class2));
    }

    private boolean showTrackingInfo()
    {
        return app.getSharedPreferences("default", 0).getBoolean("showTrackingInfo", false);
    }

    protected void configure()
    {
        CookieFactory cookiefactory = new CookieFactory(app);
        ArrayList arraylist = new ArrayList();
        arraylist.add(com/groupon/service/LoginService);
        arraylist.add(com/groupon/service/countryanddivision/CurrentDivisionManager);
        arraylist.add(com/groupon/service/countryanddivision/CurrentCountryManager);
        arraylist.add(com/groupon/service/core/AbTestService);
        arraylist.add(com/groupon/service/ReportABugPreferenceChanged);
        Object obj;
        Object obj1;
        PackageInfo packageinfo;
        try
        {
            packageinfo = app.getPackageManager().getPackageInfo(app.getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        obj1 = android.provider.Settings.Secure.getString(app.getContentResolver(), "android_id");
        obj = obj1;
        if (obj1 == null)
        {
            obj = "9774d56d682e549c";
        }
        requestStaticInjection(new Class[] {
            roboguice/util/Ln
        });
        if (showTrackingInfo())
        {
            bind(com/groupon/tracking/mobile/sdk/Logger).to(com/groupon/util/LoggerProxy);
            bind(com/groupon/util/LoggerNotifier).to(com/groupon/util/LoggerNotifierDialog);
        }
        superbind(java/lang/Boolean).annotatedWith(Names.named("LOGGING_ENABLED")).toInstance(Boolean.valueOf(loggingEnabled));
        bind(java/lang/String).annotatedWith(Names.named("LOGGING_CLIENT_ID")).toInstance("b9ab4fb791ccb18cac3a83c999a9d559");
        bind(java/lang/String).annotatedWith(Names.named("LOGGING_CLIENT_VERSION_ID")).toInstance(packageinfo.versionName);
        bind(java/lang/String).annotatedWith(Names.named("USER_AGENT")).toProvider(com/groupon/http/UserAgentProvider).asEagerSingleton();
        bind(java/lang/String).annotatedWith(Names.named("referrer")).toProvider(com/groupon/inject/ReferrerProvider);
        obj1 = bindConstant().annotatedWith(Names.named("deviceId"));
        if (Strings.equals("9774d56d682e549c", obj))
        {
            obj = cookiefactory.getBrowserCookie();
        }
        ((ConstantBindingBuilder) (obj1)).to(((String) (obj)));
        bindConstant().annotatedWith(roboguice/inject/SharedPreferencesName).to("default");
        bindConstant().annotatedWith(Names.named("versionName")).to(packageinfo.versionName);
        bindConstant().annotatedWith(Names.named("versionCode")).to(packageinfo.versionCode);
        bind(java/text/DateFormat).to(org/restlet/engine/util/InternetDateFormat);
        bind(java/text/DateFormat).annotatedWith(Names.named("localTime")).to(com/groupon/util/LocalTimeDateFormat);
        bind(java/text/DateFormat).annotatedWith(Names.named("localDate")).to(com/groupon/util/IntlDateFormat);
        bind(java/text/DateFormat).annotatedWith(Names.named("localLongDate")).to(com/groupon/util/LongDateFormat);
        bind(java/text/DateFormat).annotatedWith(Names.named("fullDateTime")).to(com/groupon/util/FullDateTimeFormat);
        bind(java/text/DateFormat).annotatedWith(Names.named("dtfDateTime")).to(com/groupon/util/DTFDateTimeFormat);
        bind(java/text/DateFormat).annotatedWith(Names.named("zonedDateTime")).to(com/groupon/util/ZonedDateTimeFormat);
        bind(java/text/DateFormat).annotatedWith(Names.named("weekDate")).to(com/groupon/util/WeekDateFormat);
        bind(java/text/DateFormat).annotatedWith(Names.named("timeLeftB")).to(com/groupon/util/HumanReadableCountdownFormatB);
        bind(java/text/DateFormat).annotatedWith(Names.named("timeLeftC")).to(com/groupon/util/HumanReadableCountdownFormatC);
        bindAnnotatedSharedPreferences("localizedStore", com/groupon/provider/LocalizedSharedPreferencesProvider);
        bindAnnotatedSharedPreferences("cacheBust");
        bindAnnotatedObscuredSharedPreferences("loginStore");
        bindAnnotatedSharedPreferences("okHttpCookieStore3");
        bindAnnotatedSharedPreferences("SupportInfoService");
        bindAnnotatedSharedPreferences("StatusService");
        bindAnnotatedSharedPreferences("CollectionsService");
        bindAnnotatedSharedPreferences("DivisionsService");
        bind(com/groupon/util/ArraySharedPreferences).toProvider(new ArraySharedPreferencesProvider());
        bindDaoToPojo(com/groupon/db/dao/DaoBugReportEmail, com/groupon/db/models/BugReportEmail);
        bindDaoToPojo(com/groupon/db/dao/DaoBusiness, com/groupon/db/models/Business);
        bindDaoToPojo(com/groupon/db/dao/DaoBusinessSummary, com/groupon/db/models/BusinessSummary);
        bindDaoToPojo(com/groupon/db/dao/DaoCategorizationItem, com/groupon/db/models/CategorizationItem);
        bindDaoToPojo(com/groupon/db/dao/DaoCategory, com/groupon/db/models/Category);
        bindDaoToPojo(com/groupon/db/dao/DaoCouponCategory, com/groupon/db/models/CouponCategory);
        bindDaoToPojo(com/groupon/db/dao/DaoCouponDetail, com/groupon/db/models/CouponDetail);
        bindDaoToPojo(com/groupon/db/dao/DaoCouponMerchant, com/groupon/db/models/CouponMerchant);
        bindDaoToPojo(com/groupon/db/dao/DaoCouponSummary, com/groupon/db/models/CouponSummary);
        bindDaoToPojo(com/groupon/db/dao/DaoCustomField, com/groupon/db/models/CustomField);
        bindDaoToPojo(com/groupon/db/dao/DaoDeal, com/groupon/db/models/Deal);
        bindDaoToPojo(com/groupon/db/dao/DaoDealSummary, com/groupon/db/models/DealSummary);
        bindDaoToPojo(com/groupon/db/dao/DaoDealSubsetAttribute, com/groupon/db/models/DealSubsetAttribute);
        bindDaoToPojo(com/groupon/db/dao/DaoDealType, com/groupon/db/models/DealType);
        bindDaoToPojo(com/groupon/db/dao/DaoDeliveryEstimation, com/groupon/db/models/DeliveryEstimation);
        bindDaoToPojo(com/groupon/db/dao/DaoDivision, com/groupon/db/models/Division);
        bindDaoToPojo(com/groupon/db/dao/DaoGiftingTheme, com/groupon/db/models/GiftingTheme);
        bindDaoToPojo(com/groupon/db/dao/DaoGiftingCategory, com/groupon/db/models/GiftingCategory);
        bindDaoToPojo(com/groupon/db/dao/DaoMyGrouponItem, com/groupon/db/models/mygroupons/MyGrouponItem);
        bindDaoToPojo(com/groupon/db/dao/DaoMyGrouponItemSummary, com/groupon/db/models/mygroupons/MyGrouponItemSummary);
        bindDaoToPojo(com/groupon/db/dao/DaoHotel, com/groupon/db/models/Hotel);
        bindDaoToPojo(com/groupon/db/dao/DaoHotelReview, com/groupon/db/models/HotelReview);
        bindDaoToPojo(com/groupon/db/dao/DaoHotelReviews, com/groupon/db/models/HotelReviews);
        bindDaoToPojo(com/groupon/db/dao/DaoImage, com/groupon/db/models/Image);
        bindDaoToPojo(com/groupon/db/dao/DaoInAppMessage, com/groupon/db/models/InAppMessage);
        bindDaoToPojo(com/groupon/db/dao/DaoIncentive, com/groupon/db/models/Incentive);
        bindDaoToPojo(com/groupon/db/dao/DaoLegalDisclosure, com/groupon/db/models/LegalDisclosure);
        bindDaoToPojo(com/groupon/db/dao/DaoLocation, com/groupon/db/models/Location);
        bindDaoToPojo(com/groupon/db/dao/DaoMarketRateResult, com/groupon/db/models/MarketRateResult);
        bindDaoToPojo(com/groupon/db/dao/DaoMerchant, com/groupon/db/models/Merchant);
        bindDaoToPojo(com/groupon/db/dao/DaoOption, com/groupon/db/models/Option);
        bindDaoToPojo(com/groupon/db/dao/DaoPagination, com/groupon/db/models/Pagination);
        bindDaoToPojo(com/groupon/db/dao/DaoPrice, com/groupon/db/models/Price);
        bindDaoToPojo(com/groupon/db/dao/DaoPricingMetadata, com/groupon/db/models/PricingMetadata);
        bindDaoToPojo(com/groupon/db/dao/DaoRating, com/groupon/db/models/Rating);
        bindDaoToPojo(com/groupon/db/dao/DaoRecommendation, com/groupon/db/models/Recommendation);
        bindDaoToPojo(com/groupon/db/dao/DaoSchedulerOption, com/groupon/db/models/SchedulerOption);
        bindDaoToPojo(com/groupon/db/dao/DaoInventoryService, com/groupon/db/models/InventoryService);
        bindDaoToPojo(com/groupon/db/dao/DaoShipment, com/groupon/db/models/Shipment);
        bindDaoToPojo(com/groupon/db/dao/DaoShippingOption, com/groupon/db/models/ShippingOption);
        bindDaoToPojo(com/groupon/db/dao/DaoGiftWrappingCharge, com/groupon/db/models/GiftWrappingCharge);
        bindDaoToPojo(com/groupon/db/dao/DaoSnapGroceryDetails, com/groupon/db/models/SnapGroceryDetail);
        bindDaoToPojo(com/groupon/db/dao/DaoSpecial, com/groupon/db/models/Special);
        bindDaoToPojo(com/groupon/db/dao/DaoStockCategory, com/groupon/db/models/StockCategory);
        bindDaoToPojo(com/groupon/db/dao/DaoStockValue, com/groupon/db/models/StockValue);
        bindDaoToPojo(com/groupon/db/dao/DaoTip, com/groupon/db/models/Tip);
        bindDaoToPojo(com/groupon/db/dao/DaoTrait, com/groupon/db/models/Trait);
        bindDaoToPojo(com/groupon/db/dao/DaoUniversal, com/groupon/db/models/UniversalStub);
        bindDaoToPojo(com/groupon/db/dao/DaoVideo, com/groupon/db/models/Video);
        bindDaoToPojo(com/groupon/db/dao/DaoWidgetSummary, com/groupon/db/models/WidgetSummary);
        bindDaoToPojo(com/groupon/db/dao/DaoExternalDealProvider, com/groupon/db/models/ExternalDealProvider);
        bindDaoToPojo(com/groupon/db/dao/DaoFinder, com/groupon/db/models/Finder);
        bindDaoToPojo(com/groupon/db/dao/DaoBand, com/groupon/db/models/Band);
        bindDaoToPojo(com/groupon/db/dao/DaoCollection, com/groupon/db/models/DealCollection);
        bindDaoToPojo(com/groupon/db/dao/DaoCollectionCardAttribute, com/groupon/db/models/CollectionCardAttribute);
        bindDaoToPojo(com/groupon/db/dao/DaoUiTreatment, com/groupon/db/models/UiTreatment);
        bind(com/groupon/util/ObjectMapperWrapper).toInstance(new ObjectMapperWrapper());
        bind(com/groupon/util/PausableThreadPoolExecutor).toProvider(new SingleThreadPausableThreadPoolExecutorProvider());
        bind(com/groupon/tracking/mobile/sdk/ExceptionFunctor).toInstance(new ExceptionFunctor() {

            final GrouponModule this$0;

            public void logException(Exception exception)
            {
                Ln.e(exception);
            }

            
            {
                this$0 = GrouponModule.this;
                super();
            }
        });
        bind(com/groupon/tracking/mobile/sdk/InfoFunctor).toInstance(new InfoFunctor() {

            final GrouponModule this$0;

            public void logInfo(String s)
            {
                Ln.d(s, new Object[0]);
            }

            
            {
                this$0 = GrouponModule.this;
                super();
            }
        });
        bind(com/groupon/cookies/CookieFactory).toInstance(cookiefactory);
        try
        {
            obj = SSLContext.getInstance("TLS");
            ((SSLContext) (obj)).init(null, null, null);
            obj = ((SSLContext) (obj)).getSocketFactory();
            bind(javax/net/ssl/SSLSocketFactory).toInstance(obj);
        }
        catch (GeneralSecurityException generalsecurityexception)
        {
            throw new RuntimeException(generalsecurityexception);
        }
        superbind(com/squareup/okhttp/OkHttpClient).to(com/groupon/http/GrouponOkHttpClient);
        bind(com/groupon/util/DeviceInfoUtil).toInstance(deviceInfoUtil);
        bind(com/groupon/tracking/mobile/sdk/DeviceSettings).to(com/groupon/ConsumerDeviceSettings);
        bind(new TypeLiteral() {

            final GrouponModule this$0;

            
            {
                this$0 = GrouponModule.this;
                super();
            }
        }).annotatedWith(Names.named("configChangeProviders")).toInstance(arraylist);
        bind(com/groupon/component/creditcardscanner/CreditCardScanner).toProvider(com/groupon/provider/CreditCardScannerProvider);
        bind(android/location/Geocoder).toProvider(new Provider() {

            final GrouponModule this$0;

            public Geocoder get()
            {
                return new Geocoder(app);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = GrouponModule.this;
                super();
            }
        });
        bind(android/location/Geocoder).annotatedWith(Names.named("ENGLISH_GEOCODER")).toProvider(new Provider() {

            final GrouponModule this$0;

            public Geocoder get()
            {
                return new Geocoder(app, Locale.ENGLISH);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = GrouponModule.this;
                super();
            }
        });
        bind(roboguice/util/LnInterface).to(com/groupon/util/GrouponLnImpl);
        bind(com/squareup/otto/Bus).annotatedWith(Names.named("GlobalEventManager")).toInstance(new Bus(ThreadEnforcer.ANY, "GlobalEventManager"));
        bind(com/squareup/otto/Bus).toProvider(new Provider() {

            final GrouponModule this$0;

            public Bus get()
            {
                return new Bus(ThreadEnforcer.ANY);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = GrouponModule.this;
                super();
            }
        }).in(roboguice/inject/ContextSingleton);
        bind(android/app/FragmentManager).toProvider(roboguice/inject/fragment/FragmentManagerProvider);
        bind(android/support/v4/app/FragmentManager).toProvider(roboguice/inject/fragment/SupportFragmentManagerProvider);
        bind(com/groupon/deeplink/DeepLinkUtil).in(com/google/inject/Singleton);
    }

}
