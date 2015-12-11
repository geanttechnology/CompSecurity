// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.i18n.phonenumbers;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.i18n.phonenumbers:
//            RegexCache, CountryCodeToRegionCodeMap, NumberParseException

public class PhoneNumberUtil
{
    public static final class PhoneNumberFormat extends Enum
    {

        private static final PhoneNumberFormat $VALUES[];
        public static final PhoneNumberFormat E164;
        public static final PhoneNumberFormat INTERNATIONAL;
        public static final PhoneNumberFormat NATIONAL;
        public static final PhoneNumberFormat RFC3966;

        public static PhoneNumberFormat valueOf(String s)
        {
            return (PhoneNumberFormat)Enum.valueOf(com/google/i18n/phonenumbers/PhoneNumberUtil$PhoneNumberFormat, s);
        }

        public static PhoneNumberFormat[] values()
        {
            return (PhoneNumberFormat[])$VALUES.clone();
        }

        static 
        {
            E164 = new PhoneNumberFormat("E164", 0);
            INTERNATIONAL = new PhoneNumberFormat("INTERNATIONAL", 1);
            NATIONAL = new PhoneNumberFormat("NATIONAL", 2);
            RFC3966 = new PhoneNumberFormat("RFC3966", 3);
            $VALUES = (new PhoneNumberFormat[] {
                E164, INTERNATIONAL, NATIONAL, RFC3966
            });
        }

        private PhoneNumberFormat(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class PhoneNumberType extends Enum
    {

        private static final PhoneNumberType $VALUES[];
        public static final PhoneNumberType FIXED_LINE;
        public static final PhoneNumberType FIXED_LINE_OR_MOBILE;
        public static final PhoneNumberType MOBILE;
        public static final PhoneNumberType PAGER;
        public static final PhoneNumberType PERSONAL_NUMBER;
        public static final PhoneNumberType PREMIUM_RATE;
        public static final PhoneNumberType SHARED_COST;
        public static final PhoneNumberType TOLL_FREE;
        public static final PhoneNumberType UAN;
        public static final PhoneNumberType UNKNOWN;
        public static final PhoneNumberType VOICEMAIL;
        public static final PhoneNumberType VOIP;

        public static PhoneNumberType valueOf(String s)
        {
            return (PhoneNumberType)Enum.valueOf(com/google/i18n/phonenumbers/PhoneNumberUtil$PhoneNumberType, s);
        }

        public static PhoneNumberType[] values()
        {
            return (PhoneNumberType[])$VALUES.clone();
        }

        static 
        {
            FIXED_LINE = new PhoneNumberType("FIXED_LINE", 0);
            MOBILE = new PhoneNumberType("MOBILE", 1);
            FIXED_LINE_OR_MOBILE = new PhoneNumberType("FIXED_LINE_OR_MOBILE", 2);
            TOLL_FREE = new PhoneNumberType("TOLL_FREE", 3);
            PREMIUM_RATE = new PhoneNumberType("PREMIUM_RATE", 4);
            SHARED_COST = new PhoneNumberType("SHARED_COST", 5);
            VOIP = new PhoneNumberType("VOIP", 6);
            PERSONAL_NUMBER = new PhoneNumberType("PERSONAL_NUMBER", 7);
            PAGER = new PhoneNumberType("PAGER", 8);
            UAN = new PhoneNumberType("UAN", 9);
            VOICEMAIL = new PhoneNumberType("VOICEMAIL", 10);
            UNKNOWN = new PhoneNumberType("UNKNOWN", 11);
            $VALUES = (new PhoneNumberType[] {
                FIXED_LINE, MOBILE, FIXED_LINE_OR_MOBILE, TOLL_FREE, PREMIUM_RATE, SHARED_COST, VOIP, PERSONAL_NUMBER, PAGER, UAN, 
                VOICEMAIL, UNKNOWN
            });
        }

        private PhoneNumberType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ValidationResult extends Enum
    {

        private static final ValidationResult $VALUES[];
        public static final ValidationResult INVALID_COUNTRY_CODE;
        public static final ValidationResult IS_POSSIBLE;
        public static final ValidationResult TOO_LONG;
        public static final ValidationResult TOO_SHORT;

        public static ValidationResult valueOf(String s)
        {
            return (ValidationResult)Enum.valueOf(com/google/i18n/phonenumbers/PhoneNumberUtil$ValidationResult, s);
        }

        public static ValidationResult[] values()
        {
            return (ValidationResult[])$VALUES.clone();
        }

        static 
        {
            IS_POSSIBLE = new ValidationResult("IS_POSSIBLE", 0);
            INVALID_COUNTRY_CODE = new ValidationResult("INVALID_COUNTRY_CODE", 1);
            TOO_SHORT = new ValidationResult("TOO_SHORT", 2);
            TOO_LONG = new ValidationResult("TOO_LONG", 3);
            $VALUES = (new ValidationResult[] {
                IS_POSSIBLE, INVALID_COUNTRY_CODE, TOO_SHORT, TOO_LONG
            });
        }

        private ValidationResult(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Map ALL_PLUS_NUMBER_GROUPING_SYMBOLS;
    private static final Map ALPHA_MAPPINGS;
    private static final Map ALPHA_PHONE_MAPPINGS;
    private static final Pattern CAPTURING_DIGIT_PATTERN = Pattern.compile("(\\p{Nd})");
    private static final Pattern CC_PATTERN = Pattern.compile("\\$CC");
    private static final Map DIALLABLE_CHAR_MAPPINGS;
    private static final Pattern EXTN_PATTERN = Pattern.compile((new StringBuilder()).append("(?:").append(EXTN_PATTERNS_FOR_PARSING).append(")$").toString(), 66);
    static final String EXTN_PATTERNS_FOR_MATCHING = createExtnPattern("x\uFF58#\uFF03~\uFF5E");
    private static final String EXTN_PATTERNS_FOR_PARSING = createExtnPattern((new StringBuilder()).append(",").append("x\uFF58#\uFF03~\uFF5E").toString());
    private static final Pattern FG_PATTERN = Pattern.compile("\\$FG");
    private static final Pattern FIRST_GROUP_ONLY_PREFIX_PATTERN = Pattern.compile("\\(?\\$1\\)?");
    private static final Pattern FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
    static final Pattern NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
    private static final Pattern NP_PATTERN = Pattern.compile("\\$NP");
    static final Pattern PLUS_CHARS_PATTERN = Pattern.compile("[+\uFF0B]+");
    static final Pattern SECOND_NUMBER_START_PATTERN = Pattern.compile("[\\\\/] *x");
    private static final Pattern SEPARATOR_PATTERN = Pattern.compile("[-x\u2010-\u2015\u2212\u30FC\uFF0D-\uFF0F \240\255\u200B\u2060\u3000()\uFF08\uFF09\uFF3B\uFF3D.\\[\\]/~\u2053\u223C\uFF5E]+");
    private static final Pattern UNIQUE_INTERNATIONAL_PREFIX = Pattern.compile("[\\d]+(?:[~\u2053\u223C\uFF5E][\\d]+)?");
    static final Pattern UNWANTED_END_CHAR_PATTERN = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
    private static final String VALID_ALPHA;
    private static final Pattern VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    private static final String VALID_PHONE_NUMBER;
    private static final Pattern VALID_PHONE_NUMBER_PATTERN;
    private static final Pattern VALID_START_CHAR_PATTERN = Pattern.compile("[+\uFF0B\\p{Nd}]");
    private static PhoneNumberUtil instance = null;
    private static final Logger logger = Logger.getLogger(com/google/i18n/phonenumbers/PhoneNumberUtil.getName());
    private final Map countryCallingCodeToRegionCodeMap;
    private final Map countryCodeToNonGeographicalMetadataMap = Collections.synchronizedMap(new HashMap());
    private final Set countryCodesForNonGeographicalRegion = new HashSet();
    private final String currentFilePrefix;
    private final Set nanpaRegions = new HashSet(35);
    private final RegexCache regexCache = new RegexCache(100);
    private final Map regionToMetadataMap = Collections.synchronizedMap(new HashMap());
    private final Set supportedRegions = new HashSet(320);

    private PhoneNumberUtil(String s, Map map)
    {
        currentFilePrefix = s;
        countryCallingCodeToRegionCodeMap = map;
        for (s = map.entrySet().iterator(); s.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)s.next();
            List list = (List)entry.getValue();
            if (list.size() == 1 && "001".equals(list.get(0)))
            {
                countryCodesForNonGeographicalRegion.add(entry.getKey());
            } else
            {
                supportedRegions.addAll(list);
            }
        }

        if (supportedRegions.remove("001"))
        {
            logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        nanpaRegions.addAll((Collection)map.get(Integer.valueOf(1)));
    }

    private void buildNationalNumberForParsing(String s, StringBuilder stringbuilder)
    {
        int i = s.indexOf(";phone-context=");
        if (i > 0)
        {
            int j = i + ";phone-context=".length();
            if (s.charAt(j) == '+')
            {
                int k = s.indexOf(';', j);
                if (k > 0)
                {
                    stringbuilder.append(s.substring(j, k));
                } else
                {
                    stringbuilder.append(s.substring(j));
                }
            }
            stringbuilder.append(s.substring(s.indexOf("tel:") + "tel:".length(), i));
        } else
        {
            stringbuilder.append(extractPossibleNumber(s));
        }
        i = stringbuilder.indexOf(";isub=");
        if (i > 0)
        {
            stringbuilder.delete(i, stringbuilder.length());
        }
    }

    private boolean checkRegionForParsing(String s, String s1)
    {
        return isValidRegionCode(s1) || s != null && s.length() != 0 && PLUS_CHARS_PATTERN.matcher(s).lookingAt();
    }

    private static void close(InputStream inputstream)
    {
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        inputstream.close();
        return;
        inputstream;
        logger.log(Level.WARNING, "error closing input stream (ignored)", inputstream);
        return;
    }

    private static String createExtnPattern(String s)
    {
        return (new StringBuilder()).append(";ext=(\\p{Nd}{1,7})|[ \240\\t,]*(?:e?xt(?:ensi(?:o\u0301?|\363))?n?|\uFF45?\uFF58\uFF54\uFF4E?|[").append(s).append("]|int|anexo|\uFF49\uFF4E\uFF54)").append("[:\\.\uFF0E]?[ \240\\t,-]*").append("(\\p{Nd}{1,7})").append("#?|").append("[- ]+(").append("\\p{Nd}").append("{1,5})#").toString();
    }

    static String extractPossibleNumber(String s)
    {
        Object obj = VALID_START_CHAR_PATTERN.matcher(s);
        if (((Matcher) (obj)).find())
        {
            obj = s.substring(((Matcher) (obj)).start());
            Matcher matcher = UNWANTED_END_CHAR_PATTERN.matcher(((CharSequence) (obj)));
            s = ((String) (obj));
            if (matcher.find())
            {
                s = ((String) (obj)).substring(0, matcher.start());
                logger.log(Level.FINER, (new StringBuilder()).append("Stripped trailing characters: ").append(s).toString());
            }
            matcher = SECOND_NUMBER_START_PATTERN.matcher(s);
            obj = s;
            if (matcher.find())
            {
                obj = s.substring(0, matcher.start());
            }
            return ((String) (obj));
        } else
        {
            return "";
        }
    }

    private String formatNsn(String s, Phonemetadata.PhoneMetadata phonemetadata, PhoneNumberFormat phonenumberformat)
    {
        return formatNsn(s, phonemetadata, phonenumberformat, null);
    }

    private String formatNsn(String s, Phonemetadata.PhoneMetadata phonemetadata, PhoneNumberFormat phonenumberformat, String s1)
    {
        if (phonemetadata.intlNumberFormats().size() == 0 || phonenumberformat == PhoneNumberFormat.NATIONAL)
        {
            phonemetadata = phonemetadata.numberFormats();
        } else
        {
            phonemetadata = phonemetadata.intlNumberFormats();
        }
        phonemetadata = chooseFormattingPatternForNumber(phonemetadata, s);
        if (phonemetadata == null)
        {
            return s;
        } else
        {
            return formatNsnUsingPattern(s, phonemetadata, phonenumberformat, s1);
        }
    }

    private String formatNsnUsingPattern(String s, Phonemetadata.NumberFormat numberformat, PhoneNumberFormat phonenumberformat, String s1)
    {
        String s2 = numberformat.getFormat();
        s = regexCache.getPatternForRegex(numberformat.getPattern()).matcher(s);
        if (phonenumberformat == PhoneNumberFormat.NATIONAL && s1 != null && s1.length() > 0 && numberformat.getDomesticCarrierCodeFormattingRule().length() > 0)
        {
            numberformat = numberformat.getDomesticCarrierCodeFormattingRule();
            numberformat = CC_PATTERN.matcher(numberformat).replaceFirst(s1);
            s = s.replaceAll(FIRST_GROUP_PATTERN.matcher(s2).replaceFirst(numberformat));
        } else
        {
            numberformat = numberformat.getNationalPrefixFormattingRule();
            if (phonenumberformat == PhoneNumberFormat.NATIONAL && numberformat != null && numberformat.length() > 0)
            {
                s = s.replaceAll(FIRST_GROUP_PATTERN.matcher(s2).replaceFirst(numberformat));
            } else
            {
                s = s.replaceAll(s2);
            }
        }
        numberformat = s;
        if (phonenumberformat == PhoneNumberFormat.RFC3966)
        {
            numberformat = SEPARATOR_PATTERN.matcher(s);
            if (numberformat.lookingAt())
            {
                s = numberformat.replaceFirst("");
            }
            numberformat = numberformat.reset(s).replaceAll("-");
        }
        return numberformat;
    }

    private int getCountryCodeForValidRegion(String s)
    {
        Phonemetadata.PhoneMetadata phonemetadata = getMetadataForRegion(s);
        if (phonemetadata == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid region code: ").append(s).toString());
        } else
        {
            return phonemetadata.getCountryCode();
        }
    }

    public static PhoneNumberUtil getInstance()
    {
        com/google/i18n/phonenumbers/PhoneNumberUtil;
        JVM INSTR monitorenter ;
        if (instance != null) goto _L2; else goto _L1
_L1:
        PhoneNumberUtil phonenumberutil = getInstance("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap());
_L4:
        com/google/i18n/phonenumbers/PhoneNumberUtil;
        JVM INSTR monitorexit ;
        return phonenumberutil;
_L2:
        phonenumberutil = instance;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static PhoneNumberUtil getInstance(String s, Map map)
    {
        com/google/i18n/phonenumbers/PhoneNumberUtil;
        JVM INSTR monitorenter ;
        if (instance != null)
        {
            throw new IllegalStateException("PhoneNumberUtil instance is already set (you should call resetInstance() first)");
        }
        break MISSING_BLOCK_LABEL_26;
        s;
        com/google/i18n/phonenumbers/PhoneNumberUtil;
        JVM INSTR monitorexit ;
        throw s;
        instance = new PhoneNumberUtil(s, map);
        s = instance;
        com/google/i18n/phonenumbers/PhoneNumberUtil;
        JVM INSTR monitorexit ;
        return s;
    }

    private Phonemetadata.PhoneMetadata getMetadataForRegionOrCallingCode(int i, String s)
    {
        if ("001".equals(s))
        {
            return getMetadataForNonGeographicalRegion(i);
        } else
        {
            return getMetadataForRegion(s);
        }
    }

    private PhoneNumberType getNumberTypeHelper(String s, Phonemetadata.PhoneMetadata phonemetadata)
    {
        Phonemetadata.PhoneNumberDesc phonenumberdesc = phonemetadata.getGeneralDesc();
        if (!phonenumberdesc.hasNationalNumberPattern() || !isNumberMatchingDesc(s, phonenumberdesc))
        {
            return PhoneNumberType.UNKNOWN;
        }
        if (isNumberMatchingDesc(s, phonemetadata.getPremiumRate()))
        {
            return PhoneNumberType.PREMIUM_RATE;
        }
        if (isNumberMatchingDesc(s, phonemetadata.getTollFree()))
        {
            return PhoneNumberType.TOLL_FREE;
        }
        if (isNumberMatchingDesc(s, phonemetadata.getSharedCost()))
        {
            return PhoneNumberType.SHARED_COST;
        }
        if (isNumberMatchingDesc(s, phonemetadata.getVoip()))
        {
            return PhoneNumberType.VOIP;
        }
        if (isNumberMatchingDesc(s, phonemetadata.getPersonalNumber()))
        {
            return PhoneNumberType.PERSONAL_NUMBER;
        }
        if (isNumberMatchingDesc(s, phonemetadata.getPager()))
        {
            return PhoneNumberType.PAGER;
        }
        if (isNumberMatchingDesc(s, phonemetadata.getUan()))
        {
            return PhoneNumberType.UAN;
        }
        if (isNumberMatchingDesc(s, phonemetadata.getVoicemail()))
        {
            return PhoneNumberType.VOICEMAIL;
        }
        if (isNumberMatchingDesc(s, phonemetadata.getFixedLine()))
        {
            if (phonemetadata.isSameMobileAndFixedLinePattern())
            {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            if (isNumberMatchingDesc(s, phonemetadata.getMobile()))
            {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            } else
            {
                return PhoneNumberType.FIXED_LINE;
            }
        }
        if (!phonemetadata.isSameMobileAndFixedLinePattern() && isNumberMatchingDesc(s, phonemetadata.getMobile()))
        {
            return PhoneNumberType.MOBILE;
        } else
        {
            return PhoneNumberType.UNKNOWN;
        }
    }

    private String getRegionCodeForNumberFromRegionList(Phonenumber.PhoneNumber phonenumber, List list)
    {
label0:
        {
            phonenumber = getNationalSignificantNumber(phonenumber);
            list = list.iterator();
            String s;
            Phonemetadata.PhoneMetadata phonemetadata;
label1:
            do
            {
                do
                {
                    if (!list.hasNext())
                    {
                        break label0;
                    }
                    s = (String)list.next();
                    phonemetadata = getMetadataForRegion(s);
                    if (!phonemetadata.hasLeadingDigits())
                    {
                        continue label1;
                    }
                } while (!regexCache.getPatternForRegex(phonemetadata.getLeadingDigits()).matcher(phonenumber).lookingAt());
                return s;
            } while (getNumberTypeHelper(phonenumber, phonemetadata) == PhoneNumberType.UNKNOWN);
            return s;
        }
        return null;
    }

    private boolean hasValidCountryCallingCode(int i)
    {
        return countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(i));
    }

    private boolean isValidRegionCode(String s)
    {
        return s != null && supportedRegions.contains(s);
    }

    static boolean isViablePhoneNumber(String s)
    {
        if (s.length() < 2)
        {
            return false;
        } else
        {
            return VALID_PHONE_NUMBER_PATTERN.matcher(s).matches();
        }
    }

    private void maybeAppendFormattedExtension(Phonenumber.PhoneNumber phonenumber, Phonemetadata.PhoneMetadata phonemetadata, PhoneNumberFormat phonenumberformat, StringBuilder stringbuilder)
    {
label0:
        {
            if (phonenumber.hasExtension() && phonenumber.getExtension().length() > 0)
            {
                if (phonenumberformat != PhoneNumberFormat.RFC3966)
                {
                    break label0;
                }
                stringbuilder.append(";ext=").append(phonenumber.getExtension());
            }
            return;
        }
        if (phonemetadata.hasPreferredExtnPrefix())
        {
            stringbuilder.append(phonemetadata.getPreferredExtnPrefix()).append(phonenumber.getExtension());
            return;
        } else
        {
            stringbuilder.append(" ext. ").append(phonenumber.getExtension());
            return;
        }
    }

    static String normalize(String s)
    {
        if (VALID_ALPHA_PHONE_PATTERN.matcher(s).matches())
        {
            return normalizeHelper(s, ALPHA_PHONE_MAPPINGS, true);
        } else
        {
            return normalizeDigitsOnly(s);
        }
    }

    static void normalize(StringBuilder stringbuilder)
    {
        String s = normalize(stringbuilder.toString());
        stringbuilder.replace(0, stringbuilder.length(), s);
    }

    static StringBuilder normalizeDigits(String s, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder(s.length());
        s = s.toCharArray();
        int j = s.length;
        int i = 0;
        while (i < j) 
        {
            char c = s[i];
            int k = Character.digit(c, 10);
            if (k != -1)
            {
                stringbuilder.append(k);
            } else
            if (flag)
            {
                stringbuilder.append(c);
            }
            i++;
        }
        return stringbuilder;
    }

    public static String normalizeDigitsOnly(String s)
    {
        return normalizeDigits(s, false).toString();
    }

    private static String normalizeHelper(String s, Map map, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder(s.length());
        int i = 0;
        while (i < s.length()) 
        {
            char c = s.charAt(i);
            Character character = (Character)map.get(Character.valueOf(Character.toUpperCase(c)));
            if (character != null)
            {
                stringbuilder.append(character);
            } else
            if (!flag)
            {
                stringbuilder.append(c);
            }
            i++;
        }
        return stringbuilder.toString();
    }

    private void parseHelper(String s, String s1, boolean flag, boolean flag1, Phonenumber.PhoneNumber phonenumber)
        throws NumberParseException
    {
        if (s == null)
        {
            throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
        }
        if (s.length() > 250)
        {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        }
        Object obj = new StringBuilder();
        buildNationalNumberForParsing(s, ((StringBuilder) (obj)));
        if (!isViablePhoneNumber(((StringBuilder) (obj)).toString()))
        {
            throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
        }
        if (flag1 && !checkRegionForParsing(((StringBuilder) (obj)).toString(), s1))
        {
            throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
        }
        if (flag)
        {
            phonenumber.setRawInput(s);
        }
        s = maybeStripExtension(((StringBuilder) (obj)));
        if (s.length() > 0)
        {
            phonenumber.setExtension(s);
        }
        Phonemetadata.PhoneMetadata phonemetadata = getMetadataForRegion(s1);
        StringBuilder stringbuilder = new StringBuilder();
        int i;
        try
        {
            i = maybeExtractCountryCode(((StringBuilder) (obj)).toString(), phonemetadata, stringbuilder, flag, phonenumber);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Matcher matcher = PLUS_CHARS_PATTERN.matcher(((StringBuilder) (obj)).toString());
            if (s.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE && matcher.lookingAt())
            {
                int j = maybeExtractCountryCode(((StringBuilder) (obj)).substring(matcher.end()), phonemetadata, stringbuilder, flag, phonenumber);
                i = j;
                if (j == 0)
                {
                    throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                }
            } else
            {
                throw new NumberParseException(s.getErrorType(), s.getMessage());
            }
        }
        if (i != 0)
        {
            obj = getRegionCodeForCountryCode(i);
            s = phonemetadata;
            if (!((String) (obj)).equals(s1))
            {
                s = getMetadataForRegionOrCallingCode(i, ((String) (obj)));
            }
        } else
        {
            normalize(((StringBuilder) (obj)));
            stringbuilder.append(((CharSequence) (obj)));
            if (s1 != null)
            {
                phonenumber.setCountryCode(phonemetadata.getCountryCode());
                s = phonemetadata;
            } else
            {
                s = phonemetadata;
                if (flag)
                {
                    phonenumber.clearCountryCodeSource();
                    s = phonemetadata;
                }
            }
        }
        if (stringbuilder.length() < 2)
        {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        }
        if (s != null)
        {
            s1 = new StringBuilder();
            maybeStripNationalPrefixAndCarrierCode(stringbuilder, s, s1);
            if (flag)
            {
                phonenumber.setPreferredDomesticCarrierCode(s1.toString());
            }
        }
        i = stringbuilder.length();
        if (i < 2)
        {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        }
        if (i > 16)
        {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
        }
        if (stringbuilder.charAt(0) == '0')
        {
            phonenumber.setItalianLeadingZero(true);
        }
        phonenumber.setNationalNumber(Long.parseLong(stringbuilder.toString()));
    }

    private boolean parsePrefixAsIdd(Pattern pattern, StringBuilder stringbuilder)
    {
        int i;
label0:
        {
            pattern = pattern.matcher(stringbuilder);
            if (pattern.lookingAt())
            {
                i = pattern.end();
                pattern = CAPTURING_DIGIT_PATTERN.matcher(stringbuilder.substring(i));
                if (!pattern.find() || !normalizeDigitsOnly(pattern.group(1)).equals("0"))
                {
                    break label0;
                }
            }
            return false;
        }
        stringbuilder.delete(0, i);
        return true;
    }

    private void prefixNumberWithCountryCallingCode(int i, PhoneNumberFormat phonenumberformat, StringBuilder stringbuilder)
    {
        static class _cls2
        {

            static final int $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[];
            static final int $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[];
            static final int $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[];

            static 
            {
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType = new int[PhoneNumberType.values().length];
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.PREMIUM_RATE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.TOLL_FREE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.MOBILE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.FIXED_LINE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.SHARED_COST.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.VOIP.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.PAGER.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.UAN.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.VOICEMAIL.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat = new int[PhoneNumberFormat.values().length];
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.E164.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.INTERNATIONAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.RFC3966.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.NATIONAL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource = new int[Phonenumber.PhoneNumber.CountryCodeSource.values().length];
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat[phonenumberformat.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            stringbuilder.insert(0, i).insert(0, '+');
            return;

        case 2: // '\002'
            stringbuilder.insert(0, " ").insert(0, i).insert(0, '+');
            return;

        case 3: // '\003'
            stringbuilder.insert(0, "-").insert(0, i).insert(0, '+').insert(0, "tel:");
            break;
        }
    }

    private ValidationResult testNumberLengthAgainstPattern(Pattern pattern, String s)
    {
        pattern = pattern.matcher(s);
        if (pattern.matches())
        {
            return ValidationResult.IS_POSSIBLE;
        }
        if (pattern.lookingAt())
        {
            return ValidationResult.TOO_LONG;
        } else
        {
            return ValidationResult.TOO_SHORT;
        }
    }

    Phonemetadata.NumberFormat chooseFormattingPatternForNumber(List list, String s)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            Phonemetadata.NumberFormat numberformat = (Phonemetadata.NumberFormat)list.next();
            int i = numberformat.leadingDigitsPatternSize();
            if ((i == 0 || regexCache.getPatternForRegex(numberformat.getLeadingDigitsPattern(i - 1)).matcher(s).lookingAt()) && regexCache.getPatternForRegex(numberformat.getPattern()).matcher(s).matches())
            {
                return numberformat;
            }
        }

        return null;
    }

    int extractCountryCode(StringBuilder stringbuilder, StringBuilder stringbuilder1)
    {
        if (stringbuilder.length() == 0 || stringbuilder.charAt(0) == '0')
        {
            return 0;
        }
        int j = stringbuilder.length();
        for (int i = 1; i <= 3 && i <= j; i++)
        {
            int k = Integer.parseInt(stringbuilder.substring(0, i));
            if (countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(k)))
            {
                stringbuilder1.append(stringbuilder.substring(i));
                return k;
            }
        }

        return 0;
    }

    public String format(Phonenumber.PhoneNumber phonenumber, PhoneNumberFormat phonenumberformat)
    {
        if (phonenumber.getNationalNumber() == 0L && phonenumber.hasRawInput())
        {
            String s = phonenumber.getRawInput();
            if (s.length() > 0)
            {
                return s;
            }
        }
        StringBuilder stringbuilder = new StringBuilder(20);
        format(phonenumber, phonenumberformat, stringbuilder);
        return stringbuilder.toString();
    }

    public void format(Phonenumber.PhoneNumber phonenumber, PhoneNumberFormat phonenumberformat, StringBuilder stringbuilder)
    {
        stringbuilder.setLength(0);
        int i = phonenumber.getCountryCode();
        String s = getNationalSignificantNumber(phonenumber);
        if (phonenumberformat == PhoneNumberFormat.E164)
        {
            stringbuilder.append(s);
            prefixNumberWithCountryCallingCode(i, PhoneNumberFormat.E164, stringbuilder);
            return;
        }
        if (!hasValidCountryCallingCode(i))
        {
            stringbuilder.append(s);
            return;
        } else
        {
            Phonemetadata.PhoneMetadata phonemetadata = getMetadataForRegionOrCallingCode(i, getRegionCodeForCountryCode(i));
            stringbuilder.append(formatNsn(s, phonemetadata, phonenumberformat));
            maybeAppendFormattedExtension(phonenumber, phonemetadata, phonenumberformat, stringbuilder);
            prefixNumberWithCountryCallingCode(i, phonenumberformat, stringbuilder);
            return;
        }
    }

    Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int i)
    {
label0:
        {
            synchronized (countryCodeToNonGeographicalMetadataMap)
            {
                if (countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(i)))
                {
                    break label0;
                }
            }
            return null;
        }
        if (!countryCodeToNonGeographicalMetadataMap.containsKey(Integer.valueOf(i)))
        {
            loadMetadataFromFile(currentFilePrefix, "001", i);
        }
        map;
        JVM INSTR monitorexit ;
        return (Phonemetadata.PhoneMetadata)countryCodeToNonGeographicalMetadataMap.get(Integer.valueOf(i));
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    Phonemetadata.PhoneMetadata getMetadataForRegion(String s)
    {
        if (!isValidRegionCode(s))
        {
            return null;
        }
        synchronized (regionToMetadataMap)
        {
            if (!regionToMetadataMap.containsKey(s))
            {
                loadMetadataFromFile(currentFilePrefix, s, 0);
            }
        }
        return (Phonemetadata.PhoneMetadata)regionToMetadataMap.get(s);
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public String getNationalSignificantNumber(Phonenumber.PhoneNumber phonenumber)
    {
        Object obj;
        if (phonenumber.isItalianLeadingZero())
        {
            obj = "0";
        } else
        {
            obj = "";
        }
        obj = new StringBuilder(((String) (obj)));
        ((StringBuilder) (obj)).append(phonenumber.getNationalNumber());
        return ((StringBuilder) (obj)).toString();
    }

    public String getRegionCodeForCountryCode(int i)
    {
        List list = (List)countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i));
        if (list == null)
        {
            return "ZZ";
        } else
        {
            return (String)list.get(0);
        }
    }

    public String getRegionCodeForNumber(Phonenumber.PhoneNumber phonenumber)
    {
        int i = phonenumber.getCountryCode();
        List list = (List)countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i));
        if (list == null)
        {
            phonenumber = getNationalSignificantNumber(phonenumber);
            logger.log(Level.WARNING, (new StringBuilder()).append("Missing/invalid country_code (").append(i).append(") for number ").append(phonenumber).toString());
            return null;
        }
        if (list.size() == 1)
        {
            return (String)list.get(0);
        } else
        {
            return getRegionCodeForNumberFromRegionList(phonenumber, list);
        }
    }

    boolean isNumberMatchingDesc(String s, Phonemetadata.PhoneNumberDesc phonenumberdesc)
    {
        Matcher matcher = regexCache.getPatternForRegex(phonenumberdesc.getNationalNumberPattern()).matcher(s);
        return isNumberPossibleForDesc(s, phonenumberdesc) && matcher.matches();
    }

    boolean isNumberPossibleForDesc(String s, Phonemetadata.PhoneNumberDesc phonenumberdesc)
    {
        return regexCache.getPatternForRegex(phonenumberdesc.getPossibleNumberPattern()).matcher(s).matches();
    }

    public boolean isPossibleNumber(Phonenumber.PhoneNumber phonenumber)
    {
        return isPossibleNumberWithReason(phonenumber) == ValidationResult.IS_POSSIBLE;
    }

    public ValidationResult isPossibleNumberWithReason(Phonenumber.PhoneNumber phonenumber)
    {
        String s = getNationalSignificantNumber(phonenumber);
        int i = phonenumber.getCountryCode();
        if (!hasValidCountryCallingCode(i))
        {
            return ValidationResult.INVALID_COUNTRY_CODE;
        }
        phonenumber = getMetadataForRegionOrCallingCode(i, getRegionCodeForCountryCode(i)).getGeneralDesc();
        if (!phonenumber.hasNationalNumberPattern())
        {
            logger.log(Level.FINER, "Checking if number is possible with incomplete metadata.");
            int j = s.length();
            if (j < 2)
            {
                return ValidationResult.TOO_SHORT;
            }
            if (j > 16)
            {
                return ValidationResult.TOO_LONG;
            } else
            {
                return ValidationResult.IS_POSSIBLE;
            }
        } else
        {
            return testNumberLengthAgainstPattern(regexCache.getPatternForRegex(phonenumber.getPossibleNumberPattern()), s);
        }
    }

    public boolean isValidNumber(Phonenumber.PhoneNumber phonenumber)
    {
        return isValidNumberForRegion(phonenumber, getRegionCodeForNumber(phonenumber));
    }

    public boolean isValidNumberForRegion(Phonenumber.PhoneNumber phonenumber, String s)
    {
        Phonemetadata.PhoneMetadata phonemetadata;
        int i;
        boolean flag;
        flag = true;
        i = phonenumber.getCountryCode();
        phonemetadata = getMetadataForRegionOrCallingCode(i, s);
        if (phonemetadata != null && ("001".equals(s) || i == getCountryCodeForValidRegion(s))) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        s = phonemetadata.getGeneralDesc();
        phonenumber = getNationalSignificantNumber(phonenumber);
        if (s.hasNationalNumberPattern())
        {
            continue; /* Loop/switch isn't completed */
        }
        i = phonenumber.length();
        if (i > 2 && i <= 16) goto _L4; else goto _L3
_L3:
        return false;
        if (getNumberTypeHelper(phonenumber, phonemetadata) != PhoneNumberType.UNKNOWN) goto _L4; else goto _L5
_L5:
        return false;
    }

    void loadMetadataFromFile(String s, String s1, int i)
    {
        Object obj;
        Object obj1;
        String s2;
        boolean flag;
        flag = "001".equals(s1);
        obj = (new StringBuilder()).append(s).append("_");
        if (flag)
        {
            s = String.valueOf(i);
        } else
        {
            s = s1;
        }
        s2 = ((StringBuilder) (obj)).append(s).toString();
        obj = com/google/i18n/phonenumbers/PhoneNumberUtil.getResourceAsStream(s2);
        if (obj == null)
        {
            logger.log(Level.SEVERE, (new StringBuilder()).append("missing metadata: ").append(s2).toString());
            throw new IllegalStateException((new StringBuilder()).append("missing metadata: ").append(s2).toString());
        }
        s = null;
        obj1 = null;
        obj = new ObjectInputStream(((InputStream) (obj)));
        s = new Phonemetadata.PhoneMetadataCollection();
        s.readExternal(((java.io.ObjectInput) (obj)));
        s = s.getMetadataList();
        if (s.isEmpty())
        {
            logger.log(Level.SEVERE, (new StringBuilder()).append("empty metadata: ").append(s2).toString());
            throw new IllegalStateException((new StringBuilder()).append("empty metadata: ").append(s2).toString());
        }
          goto _L1
        s;
        s1 = ((String) (obj));
        obj = s;
_L9:
        s = s1;
        logger.log(Level.SEVERE, (new StringBuilder()).append("cannot load/parse metadata: ").append(s2).toString(), ((Throwable) (obj)));
        s = s1;
        throw new RuntimeException((new StringBuilder()).append("cannot load/parse metadata: ").append(s2).toString(), ((Throwable) (obj)));
        s1;
_L7:
        close(s);
        throw s1;
_L1:
        if (s.size() > 1)
        {
            logger.log(Level.WARNING, (new StringBuilder()).append("invalid metadata (too many entries): ").append(s2).toString());
        }
        s = (Phonemetadata.PhoneMetadata)s.get(0);
        if (!flag) goto _L3; else goto _L2
_L2:
        countryCodeToNonGeographicalMetadataMap.put(Integer.valueOf(i), s);
_L5:
        close(((InputStream) (obj)));
        return;
_L3:
        regionToMetadataMap.put(s1, s);
        if (true) goto _L5; else goto _L4
_L4:
        s1;
        s = ((String) (obj));
        if (true) goto _L7; else goto _L6
_L6:
        obj;
        s1 = obj1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    int maybeExtractCountryCode(String s, Phonemetadata.PhoneMetadata phonemetadata, StringBuilder stringbuilder, boolean flag, Phonenumber.PhoneNumber phonenumber)
        throws NumberParseException
    {
        if (s.length() == 0)
        {
            return 0;
        }
        StringBuilder stringbuilder1 = new StringBuilder(s);
        s = "NonMatch";
        if (phonemetadata != null)
        {
            s = phonemetadata.getInternationalPrefix();
        }
        s = maybeStripInternationalPrefixAndNormalize(stringbuilder1, s);
        if (flag)
        {
            phonenumber.setCountryCodeSource(s);
        }
        if (s != Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY)
        {
            if (stringbuilder1.length() <= 2)
            {
                throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
            }
            int i = extractCountryCode(stringbuilder1, stringbuilder);
            if (i != 0)
            {
                phonenumber.setCountryCode(i);
                return i;
            } else
            {
                throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
            }
        }
        if (phonemetadata != null)
        {
            int j = phonemetadata.getCountryCode();
            s = String.valueOf(j);
            Object obj = stringbuilder1.toString();
            if (((String) (obj)).startsWith(s))
            {
                s = new StringBuilder(((String) (obj)).substring(s.length()));
                Phonemetadata.PhoneNumberDesc phonenumberdesc = phonemetadata.getGeneralDesc();
                obj = regexCache.getPatternForRegex(phonenumberdesc.getNationalNumberPattern());
                maybeStripNationalPrefixAndCarrierCode(s, phonemetadata, null);
                phonemetadata = regexCache.getPatternForRegex(phonenumberdesc.getPossibleNumberPattern());
                if (!((Pattern) (obj)).matcher(stringbuilder1).matches() && ((Pattern) (obj)).matcher(s).matches() || testNumberLengthAgainstPattern(phonemetadata, stringbuilder1.toString()) == ValidationResult.TOO_LONG)
                {
                    stringbuilder.append(s);
                    if (flag)
                    {
                        phonenumber.setCountryCodeSource(Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                    }
                    phonenumber.setCountryCode(j);
                    return j;
                }
            }
        }
        phonenumber.setCountryCode(0);
        return 0;
    }

    String maybeStripExtension(StringBuilder stringbuilder)
    {
        Matcher matcher = EXTN_PATTERN.matcher(stringbuilder);
        if (matcher.find() && isViablePhoneNumber(stringbuilder.substring(0, matcher.start())))
        {
            int i = 1;
            for (int j = matcher.groupCount(); i <= j; i++)
            {
                if (matcher.group(i) != null)
                {
                    String s = matcher.group(i);
                    stringbuilder.delete(matcher.start(), stringbuilder.length());
                    return s;
                }
            }

        }
        return "";
    }

    Phonenumber.PhoneNumber.CountryCodeSource maybeStripInternationalPrefixAndNormalize(StringBuilder stringbuilder, String s)
    {
        if (stringbuilder.length() == 0)
        {
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = PLUS_CHARS_PATTERN.matcher(stringbuilder);
        if (matcher.lookingAt())
        {
            stringbuilder.delete(0, matcher.end());
            normalize(stringbuilder);
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        s = regexCache.getPatternForRegex(s);
        normalize(stringbuilder);
        if (parsePrefixAsIdd(s, stringbuilder))
        {
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD;
        } else
        {
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
    }

    boolean maybeStripNationalPrefixAndCarrierCode(StringBuilder stringbuilder, Phonemetadata.PhoneMetadata phonemetadata, StringBuilder stringbuilder1)
    {
        Object obj;
        int i;
        i = stringbuilder.length();
        obj = phonemetadata.getNationalPrefixForParsing();
        if (i != 0 && ((String) (obj)).length() != 0) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Pattern pattern;
        int j;
        boolean flag;
        if (!((Matcher) (obj = regexCache.getPatternForRegex(((String) (obj))).matcher(stringbuilder))).lookingAt())
        {
            continue; /* Loop/switch isn't completed */
        }
        pattern = regexCache.getPatternForRegex(phonemetadata.getGeneralDesc().getNationalNumberPattern());
        flag = pattern.matcher(stringbuilder).matches();
        j = ((Matcher) (obj)).groupCount();
        phonemetadata = phonemetadata.getNationalPrefixTransformRule();
        if (phonemetadata != null && phonemetadata.length() != 0 && ((Matcher) (obj)).group(j) != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!flag || pattern.matcher(stringbuilder.substring(((Matcher) (obj)).end())).matches())
        {
            if (stringbuilder1 != null && j > 0 && ((Matcher) (obj)).group(j) != null)
            {
                stringbuilder1.append(((Matcher) (obj)).group(1));
            }
            stringbuilder.delete(0, ((Matcher) (obj)).end());
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        StringBuilder stringbuilder2 = new StringBuilder(stringbuilder);
        stringbuilder2.replace(0, i, ((Matcher) (obj)).replaceFirst(phonemetadata));
        if (!flag || pattern.matcher(stringbuilder2.toString()).matches())
        {
            if (stringbuilder1 != null && j > 1)
            {
                stringbuilder1.append(((Matcher) (obj)).group(1));
            }
            stringbuilder.replace(0, stringbuilder.length(), stringbuilder2.toString());
            return true;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public Phonenumber.PhoneNumber parse(String s, String s1)
        throws NumberParseException
    {
        Phonenumber.PhoneNumber phonenumber = new Phonenumber.PhoneNumber();
        parse(s, s1, phonenumber);
        return phonenumber;
    }

    public void parse(String s, String s1, Phonenumber.PhoneNumber phonenumber)
        throws NumberParseException
    {
        parseHelper(s, s1, false, true, phonenumber);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put(Character.valueOf('0'), Character.valueOf('0'));
        hashmap.put(Character.valueOf('1'), Character.valueOf('1'));
        hashmap.put(Character.valueOf('2'), Character.valueOf('2'));
        hashmap.put(Character.valueOf('3'), Character.valueOf('3'));
        hashmap.put(Character.valueOf('4'), Character.valueOf('4'));
        hashmap.put(Character.valueOf('5'), Character.valueOf('5'));
        hashmap.put(Character.valueOf('6'), Character.valueOf('6'));
        hashmap.put(Character.valueOf('7'), Character.valueOf('7'));
        hashmap.put(Character.valueOf('8'), Character.valueOf('8'));
        hashmap.put(Character.valueOf('9'), Character.valueOf('9'));
        HashMap hashmap1 = new HashMap(40);
        hashmap1.put(Character.valueOf('A'), Character.valueOf('2'));
        hashmap1.put(Character.valueOf('B'), Character.valueOf('2'));
        hashmap1.put(Character.valueOf('C'), Character.valueOf('2'));
        hashmap1.put(Character.valueOf('D'), Character.valueOf('3'));
        hashmap1.put(Character.valueOf('E'), Character.valueOf('3'));
        hashmap1.put(Character.valueOf('F'), Character.valueOf('3'));
        hashmap1.put(Character.valueOf('G'), Character.valueOf('4'));
        hashmap1.put(Character.valueOf('H'), Character.valueOf('4'));
        hashmap1.put(Character.valueOf('I'), Character.valueOf('4'));
        hashmap1.put(Character.valueOf('J'), Character.valueOf('5'));
        hashmap1.put(Character.valueOf('K'), Character.valueOf('5'));
        hashmap1.put(Character.valueOf('L'), Character.valueOf('5'));
        hashmap1.put(Character.valueOf('M'), Character.valueOf('6'));
        hashmap1.put(Character.valueOf('N'), Character.valueOf('6'));
        hashmap1.put(Character.valueOf('O'), Character.valueOf('6'));
        hashmap1.put(Character.valueOf('P'), Character.valueOf('7'));
        hashmap1.put(Character.valueOf('Q'), Character.valueOf('7'));
        hashmap1.put(Character.valueOf('R'), Character.valueOf('7'));
        hashmap1.put(Character.valueOf('S'), Character.valueOf('7'));
        hashmap1.put(Character.valueOf('T'), Character.valueOf('8'));
        hashmap1.put(Character.valueOf('U'), Character.valueOf('8'));
        hashmap1.put(Character.valueOf('V'), Character.valueOf('8'));
        hashmap1.put(Character.valueOf('W'), Character.valueOf('9'));
        hashmap1.put(Character.valueOf('X'), Character.valueOf('9'));
        hashmap1.put(Character.valueOf('Y'), Character.valueOf('9'));
        hashmap1.put(Character.valueOf('Z'), Character.valueOf('9'));
        ALPHA_MAPPINGS = Collections.unmodifiableMap(hashmap1);
        hashmap1 = new HashMap(100);
        hashmap1.putAll(ALPHA_MAPPINGS);
        hashmap1.putAll(hashmap);
        ALPHA_PHONE_MAPPINGS = Collections.unmodifiableMap(hashmap1);
        hashmap1 = new HashMap();
        hashmap1.putAll(hashmap);
        hashmap1.put(Character.valueOf('+'), Character.valueOf('+'));
        hashmap1.put(Character.valueOf('*'), Character.valueOf('*'));
        DIALLABLE_CHAR_MAPPINGS = Collections.unmodifiableMap(hashmap1);
        hashmap1 = new HashMap();
        char c;
        for (Iterator iterator = ALPHA_MAPPINGS.keySet().iterator(); iterator.hasNext(); hashmap1.put(Character.valueOf(c), Character.valueOf(c)))
        {
            c = ((Character)iterator.next()).charValue();
            hashmap1.put(Character.valueOf(Character.toLowerCase(c)), Character.valueOf(c));
        }

        hashmap1.putAll(hashmap);
        hashmap1.put(Character.valueOf('-'), Character.valueOf('-'));
        hashmap1.put(Character.valueOf('\uFF0D'), Character.valueOf('-'));
        hashmap1.put(Character.valueOf('\u2010'), Character.valueOf('-'));
        hashmap1.put(Character.valueOf('\u2011'), Character.valueOf('-'));
        hashmap1.put(Character.valueOf('\u2012'), Character.valueOf('-'));
        hashmap1.put(Character.valueOf('\u2013'), Character.valueOf('-'));
        hashmap1.put(Character.valueOf('\u2014'), Character.valueOf('-'));
        hashmap1.put(Character.valueOf('\u2015'), Character.valueOf('-'));
        hashmap1.put(Character.valueOf('\u2212'), Character.valueOf('-'));
        hashmap1.put(Character.valueOf('/'), Character.valueOf('/'));
        hashmap1.put(Character.valueOf('\uFF0F'), Character.valueOf('/'));
        hashmap1.put(Character.valueOf(' '), Character.valueOf(' '));
        hashmap1.put(Character.valueOf('\u3000'), Character.valueOf(' '));
        hashmap1.put(Character.valueOf('\u2060'), Character.valueOf(' '));
        hashmap1.put(Character.valueOf('.'), Character.valueOf('.'));
        hashmap1.put(Character.valueOf('\uFF0E'), Character.valueOf('.'));
        ALL_PLUS_NUMBER_GROUPING_SYMBOLS = Collections.unmodifiableMap(hashmap1);
        VALID_ALPHA = (new StringBuilder()).append(Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).replaceAll("[, \\[\\]]", "")).append(Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", "")).toString();
        VALID_PHONE_NUMBER = (new StringBuilder()).append("\\p{Nd}{2}|[+\uFF0B]*+(?:[-x\u2010-\u2015\u2212\u30FC\uFF0D-\uFF0F \240\255\u200B\u2060\u3000()\uFF08\uFF09\uFF3B\uFF3D.\\[\\]/~\u2053\u223C\uFF5E*]*\\p{Nd}){3,}[-x\u2010-\u2015\u2212\u30FC\uFF0D-\uFF0F \240\255\u200B\u2060\u3000()\uFF08\uFF09\uFF3B\uFF3D.\\[\\]/~\u2053\u223C\uFF5E*").append(VALID_ALPHA).append("\\p{Nd}").append("]*").toString();
        VALID_PHONE_NUMBER_PATTERN = Pattern.compile((new StringBuilder()).append(VALID_PHONE_NUMBER).append("(?:").append(EXTN_PATTERNS_FOR_PARSING).append(")?").toString(), 66);
    }
}
