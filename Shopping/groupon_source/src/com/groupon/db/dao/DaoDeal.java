// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import android.app.Application;
import android.content.Context;
import com.groupon.db.models.CategorizationItem;
import com.groupon.db.models.CustomField;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealType;
import com.groupon.db.models.Image;
import com.groupon.db.models.Incentive;
import com.groupon.db.models.LegalDisclosure;
import com.groupon.db.models.Location;
import com.groupon.db.models.Merchant;
import com.groupon.db.models.Option;
import com.groupon.db.models.Rating;
import com.groupon.db.models.Recommendation;
import com.groupon.db.models.ShippingOption;
import com.groupon.db.models.StockCategory;
import com.groupon.db.models.StockValue;
import com.groupon.db.models.Tip;
import com.groupon.db.models.Trait;
import com.groupon.db.models.UiTreatment;
import com.groupon.db.models.Video;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao, DaoPrice, DaoDivision, DaoMerchant, 
//            DaoRating, DaoTip, DaoRecommendation, DaoExternalDealProvider, 
//            DaoImage, DaoPricingMetadata, DaoGiftWrappingCharge, DaoSchedulerOption, 
//            DaoInventoryService, DaoOption, DaoLocation, DaoLegalDisclosure, 
//            DaoShippingOption, DaoTrait, DaoCustomField, DaoStockCategory, 
//            DaoStockValue, DaoUiTreatment, DaoDealType, DaoCategorizationItem, 
//            DaoVideo, DaoIncentive

public class DaoDeal extends GrouponBaseDao
{

    private Lazy categorizationDao;
    private Lazy customFieldDao;
    private Lazy dealTypeDao;
    private Lazy divisionDao;
    private Lazy externalDealProviderDao;
    private Lazy giftWrappingChargeDao;
    private Lazy imageDao;
    private Lazy incentiveDao;
    private Lazy inventoryServiceDao;
    private Lazy legalDisclosureDao;
    private Lazy locationDao;
    private Lazy merchantDao;
    private Lazy optionDao;
    private Lazy priceDao;
    private Lazy pricingMetadataDao;
    private Lazy ratingDao;
    private Lazy recommendationDao;
    private Lazy schedulerOptionDao;
    private Lazy shippingOptionDao;
    private Lazy stockCategoryDao;
    private Lazy stockValueDao;
    private Lazy tipDao;
    private Lazy traitDao;
    private Lazy uiTreatmentDao;
    private Lazy videoDao;

    public DaoDeal(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public void replace(Deal deal)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("remoteId", deal.remoteId);
        deletebuilder.delete();
        create(deal);
    }

    public void save(Deal deal)
        throws SQLException
    {
        ((DaoPrice)priceDao.get()).create(deal.getPrice());
        ((DaoPrice)priceDao.get()).create(deal.getValue());
        ((DaoPrice)priceDao.get()).create(deal.getDiscount());
        if (deal.division != null)
        {
            ((DaoDivision)divisionDao.get()).create(deal.division);
        }
        if (deal.merchant != null)
        {
            ((DaoMerchant)merchantDao.get()).create(deal.merchant);
            Rating rating;
            for (Iterator iterator = deal.merchant.ratings.iterator(); iterator.hasNext(); ((DaoRating)ratingDao.get()).create(rating))
            {
                rating = (Rating)iterator.next();
            }

            Tip tip;
            for (Iterator iterator1 = deal.merchant.tips.iterator(); iterator1.hasNext(); ((DaoTip)tipDao.get()).create(tip))
            {
                tip = (Tip)iterator1.next();
            }

            Recommendation recommendation;
            for (Iterator iterator2 = deal.merchant.recommendations.iterator(); iterator2.hasNext(); ((DaoRecommendation)recommendationDao.get()).create(recommendation))
            {
                recommendation = (Recommendation)iterator2.next();
            }

        }
        if (deal.externalDealProvider != null)
        {
            ((DaoExternalDealProvider)externalDealProviderDao.get()).create(deal.externalDealProvider);
        }
        replace(deal);
        ((DaoPrice)priceDao.get()).update(deal.getPrice());
        ((DaoPrice)priceDao.get()).update(deal.getValue());
        ((DaoPrice)priceDao.get()).update(deal.getDiscount());
        ((DaoDivision)divisionDao.get()).update(deal.division);
        ((DaoMerchant)merchantDao.get()).update(deal.merchant);
        ((DaoExternalDealProvider)externalDealProviderDao.get()).update(deal.externalDealProvider);
        Image image;
        for (Iterator iterator3 = deal.getImagesList().iterator(); iterator3.hasNext(); ((DaoImage)imageDao.get()).create(image))
        {
            image = (Image)iterator3.next();
        }

        for (Iterator iterator4 = deal.getOptions().iterator(); iterator4.hasNext();)
        {
            Object obj = (Option)iterator4.next();
            ((DaoPrice)priceDao.get()).create(((Option) (obj)).getPrice());
            ((DaoPrice)priceDao.get()).create(((Option) (obj)).getValue());
            ((DaoPrice)priceDao.get()).create(((Option) (obj)).getDiscount());
            ((DaoPrice)priceDao.get()).create(((Option) (obj)).regularPrice);
            ((DaoPricingMetadata)pricingMetadataDao.get()).create(((Option) (obj)).pricingMetadata);
            ((DaoGiftWrappingCharge)giftWrappingChargeDao.get()).create(((Option) (obj)).giftWrappingCharge);
            ((DaoSchedulerOption)schedulerOptionDao.get()).create(((Option) (obj)).schedulerOptions);
            ((DaoInventoryService)inventoryServiceDao.get()).create(((Option) (obj)).inventoryService);
            ((DaoOption)optionDao.get()).create(obj);
            ((DaoPrice)priceDao.get()).update(((Option) (obj)).getPrice());
            ((DaoPrice)priceDao.get()).update(((Option) (obj)).getValue());
            ((DaoPrice)priceDao.get()).update(((Option) (obj)).getDiscount());
            ((DaoPrice)priceDao.get()).update(((Option) (obj)).regularPrice);
            ((DaoPricingMetadata)pricingMetadataDao.get()).update(((Option) (obj)).pricingMetadata);
            ((DaoGiftWrappingCharge)giftWrappingChargeDao.get()).update(((Option) (obj)).giftWrappingCharge);
            ((DaoSchedulerOption)schedulerOptionDao.get()).update(((Option) (obj)).schedulerOptions);
            ((DaoInventoryService)inventoryServiceDao.get()).update(((Option) (obj)).inventoryService);
            Location location;
            for (Iterator iterator11 = ((Option) (obj)).getRedemptionLocations().iterator(); iterator11.hasNext(); ((DaoLocation)locationDao.get()).create(location))
            {
                location = (Location)iterator11.next();
            }

            LegalDisclosure legaldisclosure1;
            for (Iterator iterator12 = ((Option) (obj)).getLegalDisclosures().iterator(); iterator12.hasNext(); ((DaoLegalDisclosure)legalDisclosureDao.get()).create(legaldisclosure1))
            {
                legaldisclosure1 = (LegalDisclosure)iterator12.next();
            }

            Image image1;
            for (Iterator iterator13 = ((Option) (obj)).images.iterator(); iterator13.hasNext(); ((DaoImage)imageDao.get()).create(image1))
            {
                image1 = (Image)iterator13.next();
            }

            ShippingOption shippingoption;
            for (Iterator iterator14 = ((Option) (obj)).shippingOptions.iterator(); iterator14.hasNext(); ((DaoPrice)priceDao.get()).update(shippingoption.price))
            {
                shippingoption = (ShippingOption)iterator14.next();
                ((DaoPrice)priceDao.get()).create(shippingoption.price);
                ((DaoShippingOption)shippingOptionDao.get()).create(shippingoption);
            }

            Trait trait;
            for (Iterator iterator15 = ((Option) (obj)).traits.iterator(); iterator15.hasNext(); ((DaoTrait)traitDao.get()).create(trait))
            {
                trait = (Trait)iterator15.next();
            }

            CustomField customfield;
            for (Iterator iterator16 = ((Option) (obj)).customFields.iterator(); iterator16.hasNext(); ((DaoCustomField)customFieldDao.get()).create(customfield))
            {
                customfield = (CustomField)iterator16.next();
            }

            for (Iterator iterator17 = ((Option) (obj)).stockCategories.iterator(); iterator17.hasNext();)
            {
                Object obj1 = (StockCategory)iterator17.next();
                ((DaoStockCategory)stockCategoryDao.get()).create(obj1);
                obj1 = ((StockCategory) (obj1)).stockValues.iterator();
                while (((Iterator) (obj1)).hasNext()) 
                {
                    StockValue stockvalue = (StockValue)((Iterator) (obj1)).next();
                    ((DaoStockValue)stockValueDao.get()).create(stockvalue);
                }
            }

            obj = ((Option) (obj)).getUiTreatments().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                UiTreatment uitreatment1 = (UiTreatment)((Iterator) (obj)).next();
                ((DaoUiTreatment)uiTreatmentDao.get()).create(uitreatment1);
            }
        }

        DealType dealtype;
        for (Iterator iterator5 = deal.getDealTypes().iterator(); iterator5.hasNext(); ((DaoDealType)dealTypeDao.get()).create(dealtype))
        {
            dealtype = (DealType)iterator5.next();
            dealtype.parentDeal = deal;
        }

        CategorizationItem categorizationitem;
        for (Iterator iterator6 = deal.getCategorizations().iterator(); iterator6.hasNext(); ((DaoCategorizationItem)categorizationDao.get()).create(categorizationitem))
        {
            categorizationitem = (CategorizationItem)iterator6.next();
            categorizationitem.parentDeal = deal;
        }

        Video video;
        for (Iterator iterator7 = deal.getVideos().iterator(); iterator7.hasNext(); ((DaoVideo)videoDao.get()).create(video))
        {
            video = (Video)iterator7.next();
            video.parentDeal = deal;
        }

        LegalDisclosure legaldisclosure;
        for (Iterator iterator8 = deal.getLegalDisclosures().iterator(); iterator8.hasNext(); ((DaoLegalDisclosure)legalDisclosureDao.get()).create(legaldisclosure))
        {
            legaldisclosure = (LegalDisclosure)iterator8.next();
            legaldisclosure.parentDeal = deal;
        }

        Incentive incentive;
        for (Iterator iterator9 = deal.getIncentives().iterator(); iterator9.hasNext(); ((DaoIncentive)incentiveDao.get()).create(incentive))
        {
            incentive = (Incentive)iterator9.next();
            incentive.parentDeal = deal;
        }

        UiTreatment uitreatment;
        for (Iterator iterator10 = deal.getUiTreatment().iterator(); iterator10.hasNext(); ((DaoUiTreatment)uiTreatmentDao.get()).create(uitreatment))
        {
            uitreatment = (UiTreatment)iterator10.next();
            uitreatment.parentDeal = deal;
        }

    }

    public void setApplication(Application application)
    {
        super.setApplication(application);
        customFieldDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        dealTypeDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        divisionDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        imageDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        incentiveDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        inventoryServiceDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        legalDisclosureDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        locationDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        merchantDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        optionDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        priceDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        pricingMetadataDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        ratingDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        recommendationDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        schedulerOptionDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        shippingOptionDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        giftWrappingChargeDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        stockCategoryDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        stockValueDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        tipDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        traitDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        videoDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        categorizationDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        externalDealProviderDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
        uiTreatmentDao = new Lazy(application) {

            final DaoDeal this$0;

            
            {
                this$0 = DaoDeal.this;
                super(context);
            }
        };
    }
}
