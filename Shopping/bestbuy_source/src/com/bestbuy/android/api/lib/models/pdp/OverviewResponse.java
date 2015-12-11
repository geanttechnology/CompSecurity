// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import com.bestbuy.android.api.lib.models.home.BrandClass;
import com.bestbuy.android.api.lib.models.home.SubClass;
import com.bestbuy.android.api.lib.models.pdp.castandcrew.CastAndCrew;
import com.bestbuy.android.api.lib.models.pdp.games.GameDetails;
import com.bestbuy.android.api.lib.models.pdp.protectionservices.ProtectionServiceMatrix;
import com.bestbuy.android.api.lib.models.pdpmovies.MovieDetails;
import com.bestbuy.android.api.lib.models.pdpmusic.MusicResponse;
import com.bestbuy.android.api.lib.models.pdpmusic.Properties;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Attributes;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Availability;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Brand;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Department;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Descriptions;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Manufacturer;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Meta;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import gu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp:
//            Categories, ProductColor, Dates, ESRBRating, 
//            PDPMedia, MovieRatings, Services, SoftWareDetails

public class OverviewResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private boolean active;
    private Attributes attributes;
    private Availability availability;
    private List bonusContent;
    private Brand brand;
    private BrandClass brandClass;
    private List breadcrumb;
    private ArrayList bundleItems;
    private CastAndCrew castAndCrew;
    private Categories categories;
    private ProductColor color;
    private String condition;
    private CustomerRatings customerRatings;
    private Dates dates;
    private Department department;
    private Descriptions descriptions;
    private List episodes;
    private ESRBRating esrbRating;
    private List features;
    private GameDetails gameDetails;
    private List includedItems;
    private Manufacturer manufacturerId;
    private PDPMedia media;
    private Meta meta;
    private MovieDetails movieDetails;
    private MovieRatings movieRatings;
    private MusicResponse musicResponse;
    private Names names;
    private PriceBlock priceBlock;
    private List productFamily;
    private String productId;
    private String productType;
    private Properties properties;
    private ProtectionServiceMatrix protectionServiceMatrix;
    private PriceBlock restrictedPriceBlock;
    private Services services;
    private String skuId;
    private SoftWareDetails softwareDetails;
    private List specialFeatures;
    private List specifications;
    private List subSections;
    private SubClass subclass;
    private List trackInfo;
    private String upc;
    private String url;

    public OverviewResponse()
    {
    }

    public void Availability(Availability availability1)
    {
        availability = availability1;
    }

    public Attributes getAttributes()
    {
        return attributes;
    }

    public Availability getAvailability()
    {
        return availability;
    }

    public List getBonusContent()
    {
        return bonusContent;
    }

    public Brand getBrand()
    {
        return brand;
    }

    public BrandClass getBrandClass()
    {
        return brandClass;
    }

    public List getBreadcrumb()
    {
        return breadcrumb;
    }

    public ArrayList getBundleItems()
    {
        return bundleItems;
    }

    public CastAndCrew getCastAndCrew()
    {
        return castAndCrew;
    }

    public Categories getCategories()
    {
        return categories;
    }

    public ProductColor getColor()
    {
        return color;
    }

    public String getCondition()
    {
        return condition;
    }

    public CustomerRatings getCustomerRatings()
    {
        return customerRatings;
    }

    public Dates getDates()
    {
        return dates;
    }

    public Department getDepartment()
    {
        return department;
    }

    public Descriptions getDescriptions()
    {
        return descriptions;
    }

    public List getEpisodesList()
    {
        return episodes;
    }

    public ESRBRating getEsrbRating()
    {
        return esrbRating;
    }

    public List getFeatures()
    {
        return features;
    }

    public GameDetails getGameDetails()
    {
        return gameDetails;
    }

    public List getIncludedItems()
    {
        return includedItems;
    }

    public Manufacturer getManufacturerId()
    {
        return manufacturerId;
    }

    public PDPMedia getMedia()
    {
        return media;
    }

    public Meta getMeta()
    {
        return meta;
    }

    public MovieDetails getMovieDetails()
    {
        return movieDetails;
    }

    public MovieRatings getMovieRatings()
    {
        return movieRatings;
    }

    public MusicResponse getMusicResponse()
    {
        return musicResponse;
    }

    public Names getNames()
    {
        return names;
    }

    public PriceBlock getPriceBlock()
    {
        return priceBlock;
    }

    public List getProductFamily()
    {
        return productFamily;
    }

    public String getProductId()
    {
        return productId;
    }

    public String getProductType()
    {
        return productType;
    }

    public Properties getProperties()
    {
        return properties;
    }

    public ProtectionServiceMatrix getProtectionServiceMatrix()
    {
        return protectionServiceMatrix;
    }

    public PriceBlock getRestrictedPriceBlock()
    {
        return restrictedPriceBlock;
    }

    public Services getServices()
    {
        return services;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public SoftWareDetails getSoftwareDetails()
    {
        return softwareDetails;
    }

    public List getSpecialFeatures()
    {
        return specialFeatures;
    }

    public List getSpecifications()
    {
        return specifications;
    }

    public List getSubSections()
    {
        return subSections;
    }

    public SubClass getSubclass()
    {
        return subclass;
    }

    public List getTrackInfo()
    {
        return trackInfo;
    }

    public String getUpc()
    {
        return upc;
    }

    public String getUrl()
    {
        return url;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean flag)
    {
        active = flag;
    }

    public void setAttributes(Attributes attributes1)
    {
        attributes = attributes1;
    }

    public void setBonusContent(List list)
    {
        bonusContent = list;
    }

    public void setBrand(Brand brand1)
    {
        brand = brand1;
    }

    public void setBrandClass(BrandClass brandclass)
    {
        brandClass = brandclass;
    }

    public void setBreadcrumb(List list)
    {
        breadcrumb = list;
    }

    public void setBundleItems(ArrayList arraylist)
    {
        bundleItems = arraylist;
    }

    public void setCastAndCrew(CastAndCrew castandcrew)
    {
        castAndCrew = castandcrew;
    }

    public void setCategories(Categories categories1)
    {
        categories = categories1;
    }

    public void setColor(ProductColor productcolor)
    {
        color = productcolor;
    }

    public void setCondition(String s)
    {
        condition = s;
    }

    public void setCustomerRatings(CustomerRatings customerratings)
    {
        customerRatings = customerratings;
    }

    public void setDates(Dates dates1)
    {
        dates = dates1;
    }

    public void setDepartment(Department department1)
    {
        department = department1;
    }

    public void setDescriptions(Descriptions descriptions1)
    {
        descriptions = descriptions1;
    }

    public void setEpisodesList(List list)
    {
        episodes = list;
    }

    public void setEsrbRating(ESRBRating esrbrating)
    {
        esrbRating = esrbrating;
    }

    public void setFeatures(List list)
    {
        features = list;
    }

    public void setGameDetails(GameDetails gamedetails)
    {
        gameDetails = gamedetails;
    }

    public void setIncludedItems(List list)
    {
        includedItems = list;
    }

    public void setManufacturerId(Manufacturer manufacturer)
    {
        manufacturerId = manufacturer;
    }

    public void setMedia(PDPMedia pdpmedia)
    {
        media = pdpmedia;
    }

    public void setMeta(Meta meta1)
    {
        meta = meta1;
    }

    public void setMovieDetails(MovieDetails moviedetails)
    {
        movieDetails = moviedetails;
    }

    public void setMovieRatings(MovieRatings movieratings)
    {
        movieRatings = movieratings;
    }

    public void setMusicResponse(MusicResponse musicresponse)
    {
        musicResponse = musicresponse;
    }

    public void setNames(Names names1)
    {
        names = names1;
    }

    public void setPriceBlock(PriceBlock priceblock)
    {
        priceBlock = priceblock;
    }

    public void setProductFamily(List list)
    {
        productFamily = list;
    }

    public void setProductId(String s)
    {
        productId = s;
    }

    public void setProductType(String s)
    {
        productType = s;
    }

    public void setProperties(Properties properties1)
    {
        properties = properties1;
    }

    public void setProtectionServiceMatrix(ProtectionServiceMatrix protectionservicematrix)
    {
        protectionServiceMatrix = protectionservicematrix;
    }

    public void setRestrictedPriceBlock(PriceBlock priceblock)
    {
        restrictedPriceBlock = priceblock;
    }

    public void setServices(Services services1)
    {
        services = services1;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }

    public void setSoftwareDetails(SoftWareDetails softwaredetails)
    {
        softwareDetails = softwaredetails;
    }

    public void setSpecialFeatures(List list)
    {
        specialFeatures = list;
    }

    public void setSpecifications(List list)
    {
        specifications = list;
    }

    public void setSubSections(List list)
    {
        subSections = list;
    }

    public void setSubclass(SubClass subclass1)
    {
        subclass = subclass1;
    }

    public void setTrackInfo(List list)
    {
        trackInfo = list;
    }

    public void setUpc(String s)
    {
        upc = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
