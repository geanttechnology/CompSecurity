// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.country;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.Channel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.country:
//            EnabledFeatures, PaymentMethod, CreditCard

public class Country
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Country createFromParcel(Parcel parcel)
        {
            return new Country(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Country[] newArray(int i)
        {
            return new Country[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final String COUNTRIES_WITH_PHONE_NUMBER_AT_SIGN_UP[] = {
        "co", "pe"
    };
    public String bonusPaymentName;
    public String currency;
    public String defaultLocale;
    public boolean doubleOptin;
    public EnabledFeatures enabledFeatures;
    public String facebookAppId;
    public int id;
    public int incentiveRewardAmount;
    public String isoName;
    public List localeLanguages;
    public boolean markAsUsed;
    public List paymentMethods;
    public int rewardUnits;
    public String shortName;
    public String url;

    public Country()
    {
        enabledFeatures = new EnabledFeatures();
        localeLanguages = Collections.EMPTY_LIST;
        paymentMethods = Collections.EMPTY_LIST;
    }

    protected Country(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        enabledFeatures = new EnabledFeatures();
        localeLanguages = Collections.EMPTY_LIST;
        paymentMethods = Collections.EMPTY_LIST;
        id = parcel.readInt();
        shortName = parcel.readString();
        url = parcel.readString();
        currency = parcel.readString();
        rewardUnits = parcel.readInt();
        bonusPaymentName = parcel.readString();
        incentiveRewardAmount = parcel.readInt();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        doubleOptin = flag;
        defaultLocale = parcel.readString();
        enabledFeatures = (EnabledFeatures)parcel.readValue(com/groupon/models/country/EnabledFeatures.getClassLoader());
        if (parcel.readByte() == 1)
        {
            localeLanguages = new ArrayList();
            parcel.readList(localeLanguages, java/lang/String.getClassLoader());
        } else
        {
            localeLanguages = null;
        }
        if (parcel.readByte() == 1)
        {
            paymentMethods = new ArrayList();
            parcel.readList(paymentMethods, com/groupon/models/country/PaymentMethod.getClassLoader());
        } else
        {
            paymentMethods = null;
        }
        facebookAppId = parcel.readString();
        isoName = parcel.readString();
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        markAsUsed = flag;
    }

    public boolean acceptsOtherPayments()
    {
        for (Iterator iterator = paymentMethods.iterator(); iterator.hasNext();)
        {
            if (!((PaymentMethod)iterator.next() instanceof CreditCard))
            {
                return true;
            }
        }

        return false;
    }

    public boolean acceptsPayment(String s)
    {
        s = s.toLowerCase(Locale.ENGLISH);
        if (Strings.equalsIgnoreCase(s, "google-wallet") && isUnitedStates())
        {
            return true;
        }
        for (Iterator iterator = paymentMethods.iterator(); iterator.hasNext();)
        {
            if (Strings.equals(((PaymentMethod)iterator.next()).name.toLowerCase(Locale.ENGLISH), s))
            {
                return true;
            }
        }

        return false;
    }

    public boolean acceptsPaypal()
    {
        for (Iterator iterator = paymentMethods.iterator(); iterator.hasNext();)
        {
            if (((PaymentMethod)iterator.next()).name.equals("paypal"))
            {
                return true;
            }
        }

        return false;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof Country))
            {
                return false;
            }
            obj = (Country)obj;
            if (doubleOptin != ((Country) (obj)).doubleOptin)
            {
                return false;
            }
            if (id != ((Country) (obj)).id)
            {
                return false;
            }
            if (incentiveRewardAmount != ((Country) (obj)).incentiveRewardAmount)
            {
                return false;
            }
            if (markAsUsed != ((Country) (obj)).markAsUsed)
            {
                return false;
            }
            if (rewardUnits != ((Country) (obj)).rewardUnits)
            {
                return false;
            }
            if (bonusPaymentName == null ? ((Country) (obj)).bonusPaymentName != null : !bonusPaymentName.equals(((Country) (obj)).bonusPaymentName))
            {
                return false;
            }
            if (currency == null ? ((Country) (obj)).currency != null : !currency.equals(((Country) (obj)).currency))
            {
                return false;
            }
            if (defaultLocale == null ? ((Country) (obj)).defaultLocale != null : !defaultLocale.equals(((Country) (obj)).defaultLocale))
            {
                return false;
            }
            if (enabledFeatures == null ? ((Country) (obj)).enabledFeatures != null : !enabledFeatures.equals(((Country) (obj)).enabledFeatures))
            {
                return false;
            }
            if (facebookAppId == null ? ((Country) (obj)).facebookAppId != null : !facebookAppId.equals(((Country) (obj)).facebookAppId))
            {
                return false;
            }
            if (isoName == null ? ((Country) (obj)).isoName != null : !isoName.equals(((Country) (obj)).isoName))
            {
                return false;
            }
            if (!localeLanguages.equals(((Country) (obj)).localeLanguages))
            {
                return false;
            }
            if (paymentMethods.isEmpty() ? !((Country) (obj)).paymentMethods.isEmpty() : !paymentMethods.equals(((Country) (obj)).paymentMethods))
            {
                return false;
            }
            if (shortName == null ? ((Country) (obj)).shortName != null : !shortName.equals(((Country) (obj)).shortName))
            {
                return false;
            }
            if (url == null ? ((Country) (obj)).url != null : !url.equals(((Country) (obj)).url))
            {
                return false;
            }
        }
        return true;
    }

    public List getCreditCards()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = paymentMethods.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            PaymentMethod paymentmethod = (PaymentMethod)iterator.next();
            if (paymentmethod instanceof CreditCard)
            {
                arraylist.add((CreditCard)paymentmethod);
            }
        } while (true);
        return arraylist;
    }

    public PaymentMethod getPaymentMethodByName(String s)
    {
label0:
        {
            Object obj = paymentMethods;
            if (obj == null)
            {
                break label0;
            }
            obj = ((List) (obj)).iterator();
            PaymentMethod paymentmethod;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                paymentmethod = (PaymentMethod)((Iterator) (obj)).next();
            } while (!Strings.equalsIgnoreCase(paymentmethod.name, s));
            return paymentmethod;
        }
        return null;
    }

    public int hashCode()
    {
        int j2 = 1;
        int k2 = id;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int l2;
        int i3;
        int j3;
        int k3;
        if (shortName != null)
        {
            i = shortName.hashCode();
        } else
        {
            i = 0;
        }
        if (url != null)
        {
            j = url.hashCode();
        } else
        {
            j = 0;
        }
        if (currency != null)
        {
            k = currency.hashCode();
        } else
        {
            k = 0;
        }
        l2 = rewardUnits;
        if (bonusPaymentName != null)
        {
            l = bonusPaymentName.hashCode();
        } else
        {
            l = 0;
        }
        i3 = incentiveRewardAmount;
        if (doubleOptin)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (defaultLocale != null)
        {
            j1 = defaultLocale.hashCode();
        } else
        {
            j1 = 0;
        }
        if (enabledFeatures != null)
        {
            k1 = enabledFeatures.hashCode();
        } else
        {
            k1 = 0;
        }
        j3 = localeLanguages.hashCode();
        k3 = paymentMethods.hashCode();
        if (facebookAppId != null)
        {
            l1 = facebookAppId.hashCode();
        } else
        {
            l1 = 0;
        }
        if (isoName != null)
        {
            i2 = isoName.hashCode();
        } else
        {
            i2 = 0;
        }
        if (!markAsUsed)
        {
            j2 = 0;
        }
        return (((((((((((((k2 * 31 + i) * 31 + j) * 31 + k) * 31 + l2) * 31 + l) * 31 + i3) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + j3) * 31 + k3) * 31 + l1) * 31 + i2) * 31 + j2;
    }

    public boolean isAPACMigrate()
    {
        return com.groupon.Constants.Location.APAC_MIGRATE_COUNTRIES.contains(shortName);
    }

    public boolean isASIACompatible()
    {
        return com.groupon.Constants.Location.AS_API_COUNTRIES.contains(shortName);
    }

    public boolean isAustria()
    {
        return Strings.equals(shortName, "at");
    }

    public boolean isBelgium()
    {
        return Strings.equalsIgnoreCase(shortName, "be");
    }

    public boolean isBrazil()
    {
        return Strings.equals(shortName, "br");
    }

    public boolean isBuyAsGiftCountry()
    {
        return enabledFeatures.buyAsGift;
    }

    public boolean isCVVRequired()
    {
        return enabledFeatures.requireCVVForBillingRecordsIds;
    }

    public boolean isCanada()
    {
        return Strings.equals(shortName, "ca") || Strings.equals(shortName, "ca_eu");
    }

    public boolean isCanadaQuebec()
    {
        return Strings.equals(shortName, "ca_eu");
    }

    public boolean isChannelEnabled(String s, boolean flag)
    {
        if (!flag || !isUSACompatible()) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        String as[] = enabledFeatures.channels;
        int j = as.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                if (Strings.equalsIgnoreCase(as[i], s))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return false;
    }

    public boolean isChile()
    {
        return Strings.equals(shortName, "cl");
    }

    public boolean isCityDealCountry()
    {
        return isEuCompatible() || isINCompatible() || isASIACompatible();
    }

    public boolean isColombia()
    {
        return Strings.equals(shortName, "co");
    }

    public boolean isEuCompatible()
    {
        return com.groupon.Constants.Location.EU_API_COUNTRIES.contains(shortName);
    }

    public boolean isFinePrintEnabledCountry()
    {
        return isUSACompatible() || com.groupon.Constants.Location.LUP1_API_COUNTRIES.contains(shortName);
    }

    public boolean isGermany()
    {
        return Strings.equals(shortName, "de");
    }

    public boolean isGetawaysTitle()
    {
        boolean flag1 = false;
        String s = shortName;
        boolean flag;
        if (!Strings.isEmpty(s) && (s.equals("uk") || s.equals("nz") || s.equals("ie")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (isUSACompatible() || flag)
        {
            flag1 = true;
        }
        return flag1;
    }

    public boolean isINCompatible()
    {
        return com.groupon.Constants.Location.IN_API_COUNTRIES.contains(shortName);
    }

    public boolean isIntlOccasionsChannelEnabled()
    {
        return isChannelEnabled(Channel.OCCASIONS.toString(), false);
    }

    public boolean isIsrael()
    {
        return Strings.equals(shortName, "il");
    }

    public boolean isJPCompatible()
    {
        return com.groupon.Constants.Location.JP_API_COUNTRIES.contains(shortName);
    }

    public boolean isJapan()
    {
        return Strings.equals(shortName, "jp");
    }

    public boolean isLATAMCompatible()
    {
        return com.groupon.Constants.Location.CL_API_COUNTRIES.contains(shortName);
    }

    public boolean isLocationsAutocompleteEnabledCountry()
    {
        return enabledFeatures.locationAutocomplete || isUSACompatible();
    }

    public boolean isMegamindEnabledCountry()
    {
        return enabledFeatures.megamind || isUSACompatible();
    }

    public boolean isMexico()
    {
        return Strings.equals(shortName, "mx");
    }

    public boolean isNearbyEnabledCountry()
    {
        return enabledFeatures.nearby;
    }

    public boolean isNewsletterOptInEnabledCountry()
    {
        return isCityDealCountry() && enabledFeatures.newsletterOptIn;
    }

    public boolean isRTRForFeaturedEnabledCountry()
    {
        return enabledFeatures.relevanceFeatured;
    }

    public boolean isRussia()
    {
        return Strings.equals(shortName, "ru");
    }

    public boolean isSearchEnabledCountry()
    {
        return enabledFeatures.search;
    }

    public boolean isSellerOfRecordCountry()
    {
        String s = shortName.toLowerCase();
        HashSet hashset = new HashSet();
        hashset.addAll(com.groupon.Constants.Location.EU_API_COUNTRIES);
        hashset.addAll(com.groupon.Constants.Location.AS_API_COUNTRIES);
        hashset.addAll(com.groupon.Constants.Location.IN_API_COUNTRIES);
        return hashset.contains(s);
    }

    public boolean isShoppingChannelEnabled()
    {
        return isChannelEnabled(Channel.SHOPPING.toString(), true);
    }

    public boolean isSweden()
    {
        return Strings.equalsIgnoreCase(shortName, "se");
    }

    public boolean isTravelChannelEnabled()
    {
        return isChannelEnabled(Channel.TRAVEL.toString(), true);
    }

    public boolean isUAE()
    {
        return Strings.equalsIgnoreCase(shortName, "ae");
    }

    public boolean isUSACompatible()
    {
        return Strings.equals(shortName, "us") || Strings.equals(shortName, "ca");
    }

    public boolean isUSOnly()
    {
        return Strings.equals(shortName, "us");
    }

    public boolean isUnitedKingdom()
    {
        return Strings.equalsIgnoreCase(shortName, "uk");
    }

    public boolean isUnitedStates()
    {
        return Strings.equalsIgnoreCase(shortName, "us");
    }

    public boolean needsPhoneNumberAtSignUp()
    {
        return Arrays.asList(COUNTRIES_WITH_PHONE_NUMBER_AT_SIGN_UP).contains(shortName);
    }

    public boolean requiresMarkViewedBeforeShowingBarcode()
    {
        return isUSACompatible();
    }

    public boolean shouldDisplayFastScrollBar()
    {
        return !isJapan();
    }

    public boolean shouldHideEmailSubscriptionInOnBoarding()
    {
        return isRussia();
    }

    public boolean shouldShowOnBoarding()
    {
        return !isJapan() && !isLATAMCompatible();
    }

    public boolean shouldSortCitiesByDivisionId()
    {
        return isJapan();
    }

    public boolean shouldUseDivisionAsHeader()
    {
        return isJapan();
    }

    public boolean supportsDealBreakdowns()
    {
        return !isJapan() && !isRussia();
    }

    public boolean supportsIHQ()
    {
        return !isJapan();
    }

    public boolean supportsMultipleDeliveryAddresses()
    {
        return isLATAMCompatible() || isJapan();
    }

    public String toString()
    {
        return (new StringBuilder()).append("Country{id=").append(id).append(", shortName='").append(shortName).append('\'').append(", url='").append(url).append('\'').append(", currency='").append(currency).append('\'').append(", rewardUnits=").append(rewardUnits).append(", bonusPaymentName='").append(bonusPaymentName).append('\'').append(", incentiveRewardAmount=").append(incentiveRewardAmount).append(", doubleOptin=").append(doubleOptin).append(", defaultLocale='").append(defaultLocale).append('\'').append(", enabledFeatures=").append(enabledFeatures).append(", localeLanguages=").append(localeLanguages).append(", paymentMethods=").append(paymentMethods).append(", facebookAppId='").append(facebookAppId).append('\'').append(", isoName='").append(isoName).append('\'').append(", markAsUsed=").append(markAsUsed).append('}').toString();
    }

    public boolean usePostalCodeBeforeStreet()
    {
        return isJapan();
    }

    public boolean usesMetricSystem()
    {
        return !Strings.equals(shortName, "us") && !Strings.equals(shortName, "uk");
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeInt(id);
        parcel.writeString(shortName);
        parcel.writeString(url);
        parcel.writeString(currency);
        parcel.writeInt(rewardUnits);
        parcel.writeString(bonusPaymentName);
        parcel.writeInt(incentiveRewardAmount);
        if (doubleOptin)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeString(defaultLocale);
        parcel.writeValue(enabledFeatures);
        if (localeLanguages == null)
        {
            parcel.writeByte((byte)0);
        } else
        {
            parcel.writeByte((byte)1);
            parcel.writeList(localeLanguages);
        }
        if (paymentMethods == null)
        {
            parcel.writeByte((byte)0);
        } else
        {
            parcel.writeByte((byte)1);
            parcel.writeList(paymentMethods);
        }
        parcel.writeString(facebookAppId);
        parcel.writeString(isoName);
        if (markAsUsed)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

}
