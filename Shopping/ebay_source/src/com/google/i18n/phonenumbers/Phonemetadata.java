// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public final class Phonemetadata
{
    public static class NumberFormat
        implements Externalizable
    {

        private String domesticCarrierCodeFormattingRule_;
        private String format_;
        private boolean hasDomesticCarrierCodeFormattingRule;
        private boolean hasFormat;
        private boolean hasNationalPrefixFormattingRule;
        private boolean hasNationalPrefixOptionalWhenFormatting;
        private boolean hasPattern;
        private List leadingDigitsPattern_;
        private String nationalPrefixFormattingRule_;
        private boolean nationalPrefixOptionalWhenFormatting_;
        private String pattern_;

        public String getDomesticCarrierCodeFormattingRule()
        {
            return domesticCarrierCodeFormattingRule_;
        }

        public String getFormat()
        {
            return format_;
        }

        public String getLeadingDigitsPattern(int i)
        {
            return (String)leadingDigitsPattern_.get(i);
        }

        public String getNationalPrefixFormattingRule()
        {
            return nationalPrefixFormattingRule_;
        }

        public String getPattern()
        {
            return pattern_;
        }

        public int leadingDigitsPatternSize()
        {
            return leadingDigitsPattern_.size();
        }

        public void readExternal(ObjectInput objectinput)
            throws IOException
        {
            setPattern(objectinput.readUTF());
            setFormat(objectinput.readUTF());
            int j = objectinput.readInt();
            for (int i = 0; i < j; i++)
            {
                leadingDigitsPattern_.add(objectinput.readUTF());
            }

            if (objectinput.readBoolean())
            {
                setNationalPrefixFormattingRule(objectinput.readUTF());
            }
            if (objectinput.readBoolean())
            {
                setDomesticCarrierCodeFormattingRule(objectinput.readUTF());
            }
            setNationalPrefixOptionalWhenFormatting(objectinput.readBoolean());
        }

        public NumberFormat setDomesticCarrierCodeFormattingRule(String s)
        {
            hasDomesticCarrierCodeFormattingRule = true;
            domesticCarrierCodeFormattingRule_ = s;
            return this;
        }

        public NumberFormat setFormat(String s)
        {
            hasFormat = true;
            format_ = s;
            return this;
        }

        public NumberFormat setNationalPrefixFormattingRule(String s)
        {
            hasNationalPrefixFormattingRule = true;
            nationalPrefixFormattingRule_ = s;
            return this;
        }

        public NumberFormat setNationalPrefixOptionalWhenFormatting(boolean flag)
        {
            hasNationalPrefixOptionalWhenFormatting = true;
            nationalPrefixOptionalWhenFormatting_ = flag;
            return this;
        }

        public NumberFormat setPattern(String s)
        {
            hasPattern = true;
            pattern_ = s;
            return this;
        }

        public void writeExternal(ObjectOutput objectoutput)
            throws IOException
        {
            objectoutput.writeUTF(pattern_);
            objectoutput.writeUTF(format_);
            int j = leadingDigitsPatternSize();
            objectoutput.writeInt(j);
            for (int i = 0; i < j; i++)
            {
                objectoutput.writeUTF((String)leadingDigitsPattern_.get(i));
            }

            objectoutput.writeBoolean(hasNationalPrefixFormattingRule);
            if (hasNationalPrefixFormattingRule)
            {
                objectoutput.writeUTF(nationalPrefixFormattingRule_);
            }
            objectoutput.writeBoolean(hasDomesticCarrierCodeFormattingRule);
            if (hasDomesticCarrierCodeFormattingRule)
            {
                objectoutput.writeUTF(domesticCarrierCodeFormattingRule_);
            }
            objectoutput.writeBoolean(nationalPrefixOptionalWhenFormatting_);
        }

        public NumberFormat()
        {
            pattern_ = "";
            format_ = "";
            leadingDigitsPattern_ = new ArrayList();
            nationalPrefixFormattingRule_ = "";
            nationalPrefixOptionalWhenFormatting_ = false;
            domesticCarrierCodeFormattingRule_ = "";
        }
    }

    public static class PhoneMetadata
        implements Externalizable
    {

        private PhoneNumberDesc carrierSpecific_;
        private int countryCode_;
        private PhoneNumberDesc emergency_;
        private PhoneNumberDesc fixedLine_;
        private PhoneNumberDesc generalDesc_;
        private boolean hasCarrierSpecific;
        private boolean hasCountryCode;
        private boolean hasEmergency;
        private boolean hasFixedLine;
        private boolean hasGeneralDesc;
        private boolean hasId;
        private boolean hasInternationalPrefix;
        private boolean hasLeadingDigits;
        private boolean hasLeadingZeroPossible;
        private boolean hasMainCountryForCode;
        private boolean hasMobile;
        private boolean hasNationalPrefix;
        private boolean hasNationalPrefixForParsing;
        private boolean hasNationalPrefixTransformRule;
        private boolean hasNoInternationalDialling;
        private boolean hasPager;
        private boolean hasPersonalNumber;
        private boolean hasPreferredExtnPrefix;
        private boolean hasPreferredInternationalPrefix;
        private boolean hasPremiumRate;
        private boolean hasSameMobileAndFixedLinePattern;
        private boolean hasSharedCost;
        private boolean hasShortCode;
        private boolean hasStandardRate;
        private boolean hasTollFree;
        private boolean hasUan;
        private boolean hasVoicemail;
        private boolean hasVoip;
        private String id_;
        private String internationalPrefix_;
        private List intlNumberFormat_;
        private String leadingDigits_;
        private boolean leadingZeroPossible_;
        private boolean mainCountryForCode_;
        private PhoneNumberDesc mobile_;
        private String nationalPrefixForParsing_;
        private String nationalPrefixTransformRule_;
        private String nationalPrefix_;
        private PhoneNumberDesc noInternationalDialling_;
        private List numberFormat_;
        private PhoneNumberDesc pager_;
        private PhoneNumberDesc personalNumber_;
        private String preferredExtnPrefix_;
        private String preferredInternationalPrefix_;
        private PhoneNumberDesc premiumRate_;
        private boolean sameMobileAndFixedLinePattern_;
        private PhoneNumberDesc sharedCost_;
        private PhoneNumberDesc shortCode_;
        private PhoneNumberDesc standardRate_;
        private PhoneNumberDesc tollFree_;
        private PhoneNumberDesc uan_;
        private PhoneNumberDesc voicemail_;
        private PhoneNumberDesc voip_;

        public int getCountryCode()
        {
            return countryCode_;
        }

        public PhoneNumberDesc getFixedLine()
        {
            return fixedLine_;
        }

        public PhoneNumberDesc getGeneralDesc()
        {
            return generalDesc_;
        }

        public String getInternationalPrefix()
        {
            return internationalPrefix_;
        }

        public String getLeadingDigits()
        {
            return leadingDigits_;
        }

        public PhoneNumberDesc getMobile()
        {
            return mobile_;
        }

        public String getNationalPrefixForParsing()
        {
            return nationalPrefixForParsing_;
        }

        public String getNationalPrefixTransformRule()
        {
            return nationalPrefixTransformRule_;
        }

        public PhoneNumberDesc getPager()
        {
            return pager_;
        }

        public PhoneNumberDesc getPersonalNumber()
        {
            return personalNumber_;
        }

        public String getPreferredExtnPrefix()
        {
            return preferredExtnPrefix_;
        }

        public PhoneNumberDesc getPremiumRate()
        {
            return premiumRate_;
        }

        public PhoneNumberDesc getSharedCost()
        {
            return sharedCost_;
        }

        public PhoneNumberDesc getTollFree()
        {
            return tollFree_;
        }

        public PhoneNumberDesc getUan()
        {
            return uan_;
        }

        public PhoneNumberDesc getVoicemail()
        {
            return voicemail_;
        }

        public PhoneNumberDesc getVoip()
        {
            return voip_;
        }

        public boolean hasLeadingDigits()
        {
            return hasLeadingDigits;
        }

        public boolean hasPreferredExtnPrefix()
        {
            return hasPreferredExtnPrefix;
        }

        public int intlNumberFormatSize()
        {
            return intlNumberFormat_.size();
        }

        public List intlNumberFormats()
        {
            return intlNumberFormat_;
        }

        public boolean isSameMobileAndFixedLinePattern()
        {
            return sameMobileAndFixedLinePattern_;
        }

        public int numberFormatSize()
        {
            return numberFormat_.size();
        }

        public List numberFormats()
        {
            return numberFormat_;
        }

        public void readExternal(ObjectInput objectinput)
            throws IOException
        {
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc = new PhoneNumberDesc();
                phonenumberdesc.readExternal(objectinput);
                setGeneralDesc(phonenumberdesc);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc1 = new PhoneNumberDesc();
                phonenumberdesc1.readExternal(objectinput);
                setFixedLine(phonenumberdesc1);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc2 = new PhoneNumberDesc();
                phonenumberdesc2.readExternal(objectinput);
                setMobile(phonenumberdesc2);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc3 = new PhoneNumberDesc();
                phonenumberdesc3.readExternal(objectinput);
                setTollFree(phonenumberdesc3);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc4 = new PhoneNumberDesc();
                phonenumberdesc4.readExternal(objectinput);
                setPremiumRate(phonenumberdesc4);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc5 = new PhoneNumberDesc();
                phonenumberdesc5.readExternal(objectinput);
                setSharedCost(phonenumberdesc5);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc6 = new PhoneNumberDesc();
                phonenumberdesc6.readExternal(objectinput);
                setPersonalNumber(phonenumberdesc6);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc7 = new PhoneNumberDesc();
                phonenumberdesc7.readExternal(objectinput);
                setVoip(phonenumberdesc7);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc8 = new PhoneNumberDesc();
                phonenumberdesc8.readExternal(objectinput);
                setPager(phonenumberdesc8);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc9 = new PhoneNumberDesc();
                phonenumberdesc9.readExternal(objectinput);
                setUan(phonenumberdesc9);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc10 = new PhoneNumberDesc();
                phonenumberdesc10.readExternal(objectinput);
                setEmergency(phonenumberdesc10);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc11 = new PhoneNumberDesc();
                phonenumberdesc11.readExternal(objectinput);
                setVoicemail(phonenumberdesc11);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc12 = new PhoneNumberDesc();
                phonenumberdesc12.readExternal(objectinput);
                setShortCode(phonenumberdesc12);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc13 = new PhoneNumberDesc();
                phonenumberdesc13.readExternal(objectinput);
                setStandardRate(phonenumberdesc13);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc14 = new PhoneNumberDesc();
                phonenumberdesc14.readExternal(objectinput);
                setCarrierSpecific(phonenumberdesc14);
            }
            if (objectinput.readBoolean())
            {
                PhoneNumberDesc phonenumberdesc15 = new PhoneNumberDesc();
                phonenumberdesc15.readExternal(objectinput);
                setNoInternationalDialling(phonenumberdesc15);
            }
            setId(objectinput.readUTF());
            setCountryCode(objectinput.readInt());
            setInternationalPrefix(objectinput.readUTF());
            if (objectinput.readBoolean())
            {
                setPreferredInternationalPrefix(objectinput.readUTF());
            }
            if (objectinput.readBoolean())
            {
                setNationalPrefix(objectinput.readUTF());
            }
            if (objectinput.readBoolean())
            {
                setPreferredExtnPrefix(objectinput.readUTF());
            }
            if (objectinput.readBoolean())
            {
                setNationalPrefixForParsing(objectinput.readUTF());
            }
            if (objectinput.readBoolean())
            {
                setNationalPrefixTransformRule(objectinput.readUTF());
            }
            setSameMobileAndFixedLinePattern(objectinput.readBoolean());
            int k = objectinput.readInt();
            for (int i = 0; i < k; i++)
            {
                NumberFormat numberformat = new NumberFormat();
                numberformat.readExternal(objectinput);
                numberFormat_.add(numberformat);
            }

            k = objectinput.readInt();
            for (int j = 0; j < k; j++)
            {
                NumberFormat numberformat1 = new NumberFormat();
                numberformat1.readExternal(objectinput);
                intlNumberFormat_.add(numberformat1);
            }

            setMainCountryForCode(objectinput.readBoolean());
            if (objectinput.readBoolean())
            {
                setLeadingDigits(objectinput.readUTF());
            }
            setLeadingZeroPossible(objectinput.readBoolean());
        }

        public PhoneMetadata setCarrierSpecific(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasCarrierSpecific = true;
                carrierSpecific_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setCountryCode(int i)
        {
            hasCountryCode = true;
            countryCode_ = i;
            return this;
        }

        public PhoneMetadata setEmergency(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasEmergency = true;
                emergency_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setFixedLine(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasFixedLine = true;
                fixedLine_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setGeneralDesc(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasGeneralDesc = true;
                generalDesc_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setId(String s)
        {
            hasId = true;
            id_ = s;
            return this;
        }

        public PhoneMetadata setInternationalPrefix(String s)
        {
            hasInternationalPrefix = true;
            internationalPrefix_ = s;
            return this;
        }

        public PhoneMetadata setLeadingDigits(String s)
        {
            hasLeadingDigits = true;
            leadingDigits_ = s;
            return this;
        }

        public PhoneMetadata setLeadingZeroPossible(boolean flag)
        {
            hasLeadingZeroPossible = true;
            leadingZeroPossible_ = flag;
            return this;
        }

        public PhoneMetadata setMainCountryForCode(boolean flag)
        {
            hasMainCountryForCode = true;
            mainCountryForCode_ = flag;
            return this;
        }

        public PhoneMetadata setMobile(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasMobile = true;
                mobile_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setNationalPrefix(String s)
        {
            hasNationalPrefix = true;
            nationalPrefix_ = s;
            return this;
        }

        public PhoneMetadata setNationalPrefixForParsing(String s)
        {
            hasNationalPrefixForParsing = true;
            nationalPrefixForParsing_ = s;
            return this;
        }

        public PhoneMetadata setNationalPrefixTransformRule(String s)
        {
            hasNationalPrefixTransformRule = true;
            nationalPrefixTransformRule_ = s;
            return this;
        }

        public PhoneMetadata setNoInternationalDialling(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasNoInternationalDialling = true;
                noInternationalDialling_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setPager(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasPager = true;
                pager_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setPersonalNumber(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasPersonalNumber = true;
                personalNumber_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setPreferredExtnPrefix(String s)
        {
            hasPreferredExtnPrefix = true;
            preferredExtnPrefix_ = s;
            return this;
        }

        public PhoneMetadata setPreferredInternationalPrefix(String s)
        {
            hasPreferredInternationalPrefix = true;
            preferredInternationalPrefix_ = s;
            return this;
        }

        public PhoneMetadata setPremiumRate(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasPremiumRate = true;
                premiumRate_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setSameMobileAndFixedLinePattern(boolean flag)
        {
            hasSameMobileAndFixedLinePattern = true;
            sameMobileAndFixedLinePattern_ = flag;
            return this;
        }

        public PhoneMetadata setSharedCost(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasSharedCost = true;
                sharedCost_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setShortCode(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasShortCode = true;
                shortCode_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setStandardRate(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasStandardRate = true;
                standardRate_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setTollFree(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasTollFree = true;
                tollFree_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setUan(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasUan = true;
                uan_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setVoicemail(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasVoicemail = true;
                voicemail_ = phonenumberdesc;
                return this;
            }
        }

        public PhoneMetadata setVoip(PhoneNumberDesc phonenumberdesc)
        {
            if (phonenumberdesc == null)
            {
                throw new NullPointerException();
            } else
            {
                hasVoip = true;
                voip_ = phonenumberdesc;
                return this;
            }
        }

        public void writeExternal(ObjectOutput objectoutput)
            throws IOException
        {
            objectoutput.writeBoolean(hasGeneralDesc);
            if (hasGeneralDesc)
            {
                generalDesc_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasFixedLine);
            if (hasFixedLine)
            {
                fixedLine_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasMobile);
            if (hasMobile)
            {
                mobile_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasTollFree);
            if (hasTollFree)
            {
                tollFree_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasPremiumRate);
            if (hasPremiumRate)
            {
                premiumRate_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasSharedCost);
            if (hasSharedCost)
            {
                sharedCost_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasPersonalNumber);
            if (hasPersonalNumber)
            {
                personalNumber_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasVoip);
            if (hasVoip)
            {
                voip_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasPager);
            if (hasPager)
            {
                pager_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasUan);
            if (hasUan)
            {
                uan_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasEmergency);
            if (hasEmergency)
            {
                emergency_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasVoicemail);
            if (hasVoicemail)
            {
                voicemail_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasShortCode);
            if (hasShortCode)
            {
                shortCode_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasStandardRate);
            if (hasStandardRate)
            {
                standardRate_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasCarrierSpecific);
            if (hasCarrierSpecific)
            {
                carrierSpecific_.writeExternal(objectoutput);
            }
            objectoutput.writeBoolean(hasNoInternationalDialling);
            if (hasNoInternationalDialling)
            {
                noInternationalDialling_.writeExternal(objectoutput);
            }
            objectoutput.writeUTF(id_);
            objectoutput.writeInt(countryCode_);
            objectoutput.writeUTF(internationalPrefix_);
            objectoutput.writeBoolean(hasPreferredInternationalPrefix);
            if (hasPreferredInternationalPrefix)
            {
                objectoutput.writeUTF(preferredInternationalPrefix_);
            }
            objectoutput.writeBoolean(hasNationalPrefix);
            if (hasNationalPrefix)
            {
                objectoutput.writeUTF(nationalPrefix_);
            }
            objectoutput.writeBoolean(hasPreferredExtnPrefix);
            if (hasPreferredExtnPrefix)
            {
                objectoutput.writeUTF(preferredExtnPrefix_);
            }
            objectoutput.writeBoolean(hasNationalPrefixForParsing);
            if (hasNationalPrefixForParsing)
            {
                objectoutput.writeUTF(nationalPrefixForParsing_);
            }
            objectoutput.writeBoolean(hasNationalPrefixTransformRule);
            if (hasNationalPrefixTransformRule)
            {
                objectoutput.writeUTF(nationalPrefixTransformRule_);
            }
            objectoutput.writeBoolean(sameMobileAndFixedLinePattern_);
            int k = numberFormatSize();
            objectoutput.writeInt(k);
            for (int i = 0; i < k; i++)
            {
                ((NumberFormat)numberFormat_.get(i)).writeExternal(objectoutput);
            }

            k = intlNumberFormatSize();
            objectoutput.writeInt(k);
            for (int j = 0; j < k; j++)
            {
                ((NumberFormat)intlNumberFormat_.get(j)).writeExternal(objectoutput);
            }

            objectoutput.writeBoolean(mainCountryForCode_);
            objectoutput.writeBoolean(hasLeadingDigits);
            if (hasLeadingDigits)
            {
                objectoutput.writeUTF(leadingDigits_);
            }
            objectoutput.writeBoolean(leadingZeroPossible_);
        }

        public PhoneMetadata()
        {
            generalDesc_ = null;
            fixedLine_ = null;
            mobile_ = null;
            tollFree_ = null;
            premiumRate_ = null;
            sharedCost_ = null;
            personalNumber_ = null;
            voip_ = null;
            pager_ = null;
            uan_ = null;
            emergency_ = null;
            voicemail_ = null;
            shortCode_ = null;
            standardRate_ = null;
            carrierSpecific_ = null;
            noInternationalDialling_ = null;
            id_ = "";
            countryCode_ = 0;
            internationalPrefix_ = "";
            preferredInternationalPrefix_ = "";
            nationalPrefix_ = "";
            preferredExtnPrefix_ = "";
            nationalPrefixForParsing_ = "";
            nationalPrefixTransformRule_ = "";
            sameMobileAndFixedLinePattern_ = false;
            numberFormat_ = new ArrayList();
            intlNumberFormat_ = new ArrayList();
            mainCountryForCode_ = false;
            leadingDigits_ = "";
            leadingZeroPossible_ = false;
        }
    }

    public static class PhoneMetadataCollection
        implements Externalizable
    {

        private List metadata_;

        public int getMetadataCount()
        {
            return metadata_.size();
        }

        public List getMetadataList()
        {
            return metadata_;
        }

        public void readExternal(ObjectInput objectinput)
            throws IOException
        {
            int j = objectinput.readInt();
            for (int i = 0; i < j; i++)
            {
                PhoneMetadata phonemetadata = new PhoneMetadata();
                phonemetadata.readExternal(objectinput);
                metadata_.add(phonemetadata);
            }

        }

        public void writeExternal(ObjectOutput objectoutput)
            throws IOException
        {
            int j = getMetadataCount();
            objectoutput.writeInt(j);
            for (int i = 0; i < j; i++)
            {
                ((PhoneMetadata)metadata_.get(i)).writeExternal(objectoutput);
            }

        }

        public PhoneMetadataCollection()
        {
            metadata_ = new ArrayList();
        }
    }

    public static class PhoneNumberDesc
        implements Externalizable
    {

        private String exampleNumber_;
        private boolean hasExampleNumber;
        private boolean hasNationalNumberPattern;
        private boolean hasPossibleNumberPattern;
        private String nationalNumberPattern_;
        private String possibleNumberPattern_;

        public String getNationalNumberPattern()
        {
            return nationalNumberPattern_;
        }

        public String getPossibleNumberPattern()
        {
            return possibleNumberPattern_;
        }

        public boolean hasNationalNumberPattern()
        {
            return hasNationalNumberPattern;
        }

        public void readExternal(ObjectInput objectinput)
            throws IOException
        {
            if (objectinput.readBoolean())
            {
                setNationalNumberPattern(objectinput.readUTF());
            }
            if (objectinput.readBoolean())
            {
                setPossibleNumberPattern(objectinput.readUTF());
            }
            if (objectinput.readBoolean())
            {
                setExampleNumber(objectinput.readUTF());
            }
        }

        public PhoneNumberDesc setExampleNumber(String s)
        {
            hasExampleNumber = true;
            exampleNumber_ = s;
            return this;
        }

        public PhoneNumberDesc setNationalNumberPattern(String s)
        {
            hasNationalNumberPattern = true;
            nationalNumberPattern_ = s;
            return this;
        }

        public PhoneNumberDesc setPossibleNumberPattern(String s)
        {
            hasPossibleNumberPattern = true;
            possibleNumberPattern_ = s;
            return this;
        }

        public void writeExternal(ObjectOutput objectoutput)
            throws IOException
        {
            objectoutput.writeBoolean(hasNationalNumberPattern);
            if (hasNationalNumberPattern)
            {
                objectoutput.writeUTF(nationalNumberPattern_);
            }
            objectoutput.writeBoolean(hasPossibleNumberPattern);
            if (hasPossibleNumberPattern)
            {
                objectoutput.writeUTF(possibleNumberPattern_);
            }
            objectoutput.writeBoolean(hasExampleNumber);
            if (hasExampleNumber)
            {
                objectoutput.writeUTF(exampleNumber_);
            }
        }

        public PhoneNumberDesc()
        {
            nationalNumberPattern_ = "";
            possibleNumberPattern_ = "";
            exampleNumber_ = "";
        }
    }

}
