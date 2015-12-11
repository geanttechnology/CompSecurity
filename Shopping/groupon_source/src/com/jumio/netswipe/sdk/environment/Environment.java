// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netswipe.sdk.environment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import com.jumio.ocr.impl.smartEngines.swig.jumioModule;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.UUID;
import netswipe.dh;

public class Environment
{

    public static final String BUILD_VERSION = "2.0.3";
    private static String DATA_DIRECTORY = "/netswipe/";
    private static String DICT_FILE_EXTENSION = ".dict";
    public static final String DICT_NAME = "fe3c23ce859ec03a4f961dcf9c87f928edf7437fbc8eea11cb89b60e5be2abd0";
    public static final String DICT_SURNAME = "0a53f9fbe66653276a2f13a78764a2979c710b3162d67ece61b398491be7bee5";
    public static final String FONT_OCRA_CHECKSUM = "94d996897f0200d38fa47a6dce468b6ed74357cd4df7520d319e794d439101e5";
    private static boolean JNI_INTERFACE_LIB_IS_LOADED = false;
    public static final String JSON_CARD_DETECTION_ENGINE = "6561d5d87b4487d1c5995e3fb137b456f6d6e2a683fcfc640fe5bb694571cbc6";
    public static final String JSON_FAST_FINDCARD_CONFIG = "04f73e7b83388ac720c08bbc12bc67cda18ad6e57747669ce6ce3385778896f7";
    private static String JSON_FILE_EXTENSION = ".json";
    public static final String JSON_OCRENGINE = "4edbcf1dd30e935783ec86f8603a81579ec84107bfd33c5b53c75fd4b993ec99";
    private static boolean JUMIO_LIB_IS_LOADED = false;
    public static final String LIB_JNI_INTERFACE_CHECKSUM = "8ece748f6f8fddf53a1a331f14d8e111ee53a054299d9e5b62c3fff730544110";
    public static final String LIB_JUMIO_CHECKSUM = "795f013a8c696aecb1485130aa87e18dd10aeda4f5b58c83e83bdeb1d4f7eb1f";
    public static final String MOD_AE0_28X28 = "";
    public static final String MOD_AE0_28X28_180 = "";
    public static final String MOD_AEL0_40X50 = "";
    public static final String MOD_AEL0_40X50_180 = "";
    public static final String MOD_CORNER0_31X31_LL = "";
    public static final String MOD_CORNER0_31X31_LR = "";
    public static final String MOD_CORNER0_31X31_UL = "";
    public static final String MOD_CORNER0_31X31_UR = "";
    public static final String MOD_CORNER0_32X32_LL = "";
    public static final String MOD_CORNER0_32X32_LR = "";
    public static final String MOD_CORNER0_32X32_UL = "";
    public static final String MOD_CORNER0_32X32_UR = "";
    public static final String MOD_CORNER0_61X61_LL = "";
    public static final String MOD_CORNER0_61X61_LR = "";
    public static final String MOD_CORNER0_61X61_UL = "";
    public static final String MOD_CORNER0_61X61_UR = "";
    public static final String MOD_CORNER1_31X31_LL = "";
    public static final String MOD_CORNER1_31X31_LR = "";
    public static final String MOD_CORNER1_31X31_UL = "";
    public static final String MOD_CORNER1_31X31_UR = "";
    public static final String MOD_CORNER1_32X32_LL = "";
    public static final String MOD_CORNER1_32X32_LR = "";
    public static final String MOD_CORNER1_32X32_UL = "";
    public static final String MOD_CORNER1_32X32_UR = "";
    public static final String MOD_CORNER1_61X61_LL = "";
    public static final String MOD_CORNER1_61X61_LR = "";
    public static final String MOD_CORNER1_61X61_UL = "";
    public static final String MOD_CORNER1_61X61_UR = "";
    public static final String MOD_CORNER2_31X31_LL = "";
    public static final String MOD_CORNER2_31X31_LR = "";
    public static final String MOD_CORNER2_31X31_UL = "";
    public static final String MOD_CORNER2_31X31_UR = "";
    public static final String MOD_MC0_40X24 = "";
    public static final String MOD_MC0_40X24_180 = "";
    public static final String MOD_MC1_40X24 = "";
    public static final String MOD_MC1_40X24_180 = "";
    public static final String MOD_RANDOM = "";
    public static final String MOD_VISA0_40X20 = "";
    public static final String MOD_VISA0_40X20_180 = "";
    public static final String MOD_VISAW0_40X20 = "";
    public static final String MOD_VISAW0_40X20_180 = "";
    private static Typeface OCRA_FONT = null;
    public static final String OCR_VERSION = "1.19.2";
    public static final String PB_BIGDIGFIRSTPASS_RECOGNIZER = "a376d4a4578d66116fef7fac4c6fb98971c569a2fd9d3bf85e255083e08b0045";
    public static final String PB_BIGDIG_HIGHLIGHT = "4e6df57531c550064d2a1105a14f6372436fda2cf40449261685dd5e4740afd6";
    public static final String PB_BIGDIG_RECOGNIZER = "332c269db6a283d4bb46a06ecf88365cb8e27a369172a4b78ea8c35c9cbaa9eb";
    private static String PB_FILE_EXTENSION = ".pb";
    public static final String PB_SIX_DIGITS = "575b612cab9adf3dc433c420c3bdddbe5f6ccf5f847e2f55836a39327173b4ec";
    public static final String PB_SMALLDIGFIRSTPASS_RECOGNIZER = "2730c388d6f32763d325caa861d885ecc50a7b25ace685f2974545c70d985b5f";
    public static final String PB_SMALLDIG_HIGHLIGHT = "38e15d6ebd9d56c4c731f4b106397d8adcab7c7c92a09080950465cbf5bfd9e8";
    public static final String PB_SMALLDIG_RECOGNIZER = "d87fbec083b0674a26e24c294769bf45a441190a6233d6298a1cac445262c0d3";
    public static final String PB_SMALLDIG_SECOND_PASS_HIGHLIGHT = "5d38fb1cdb9528f4144e4a6371c3d8a2fd488666a7563a88656a59f19fefa942";
    public static final String PB_SMALLSYM_HIGHLIGHT = "6c7caec24050833412259b898292469d625c4e9ab260a65194375e3b5a5ef39c";
    public static final String PB_SMALLSYM_RECOGNIZER = "28755aa25e285a8530af4ea2af42f4e86124308a20e0cf7c4550056020fc9c66";
    public static final String PB_SORTCODE = "aea77bae7ea898c651d9934a2eea1c291578ee94f0544a2f1ae277458685dde1";
    private static String TRIA_FILE_EXTENSION = ".trigrams.pb";
    public static final String TRIA_NAME = "8cb3e383e4739c76b03a2b427f9a7b906666717f6a52f2b814793486130d5adf";
    public static final String TXT_BIGDIG_RESCALER = "267a0b327fac69926495a540b6aa84788ae8af991eb77d20bdb1a62acd2814b5";
    private static String TXT_FILE_EXTENSION = ".txt";
    public static final String TXT_SC_AN_RULES = "9b220545f66d2ca01b0b8e57e10ddace62ca8c42633e40e29555916fbb04b7c2";
    public static final String TXT_SMALLSYM_RESCALER = "bc40364c970c1a6c9c579aa831bad258a8fb462209fbb0e79eb48986a4ef525f";
    private static String YAML_FILE_EXTENSION = ".yaml";
    public static final String YAML_RETRIEVER_SETTINGS = "3dc30e3fb2cba4298e986db55a1866dccdfc76345d1102a4e8c2a224992504c9";
    public static final String YAML_RETRIEVER_SETTINGS_0 = "7b730ed97b4d738fcc32090fd4a19dbf9f9d7a40c2f0cf9ccd62bc3d152f49aa";
    public static final String YAML_RETR_ALPHABET = "06f97848a282ffe17911b201d38ef6ac0b6023685343cc90ea3ea554fda07cc3";
    public static final String YAML_RETR_SAMPLING = "dfa5f286c1c82accc8a8c078d24ff341a8b6aea13aeb4192fa1b8066b19a6cd6";

    public Environment()
    {
    }

    private static String calculateHash(File file)
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        if (!file.isFile())
        {
            return null;
        }
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
        Object obj = new BufferedInputStream(new FileInputStream(file.getPath()));
        file = new byte[2048];
_L3:
        int i = ((BufferedInputStream) (obj)).read(file);
        if (i == -1) goto _L2; else goto _L1
_L1:
        messagedigest.update(file, 0, i);
          goto _L3
        file;
_L10:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        ((BufferedInputStream) (obj)).close();
_L8:
        throw file;
        file;
_L5:
        return stringbuilder.toString();
_L2:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        ((BufferedInputStream) (obj)).close();
_L7:
        file = messagedigest.digest();
        i = 0;
_L6:
        if (i >= file.length) goto _L5; else goto _L4
_L4:
        stringbuilder.append(Character.forDigit((file[i] & 0xf0) >> 4, 16));
        stringbuilder.append(Character.forDigit(file[i] & 0xf, 16));
        i++;
          goto _L6
          goto _L5
        file;
        file.printStackTrace();
          goto _L7
        obj;
        ((IOException) (obj)).printStackTrace();
          goto _L8
        file;
        obj = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static String extractFile(Context context, String s, String s1, String s2)
    {
        context = new File(getDataDirectory(context), (new StringBuilder()).append(s).append(s2).toString());
        s2 = calculateHash(context);
        if (context.isFile() && s1.equals(s2)) goto _L2; else goto _L1
_L1:
        s2 = new byte[2048];
        if (context.isFile())
        {
            context.delete();
        }
        s1 = com/jumio/netswipe/sdk/environment/Environment.getResourceAsStream(s);
        s = new FileOutputStream(context);
_L5:
        int i = s1.read(s2);
        if (i <= 0) goto _L4; else goto _L3
_L3:
        s.write(s2, 0, i);
          goto _L5
        context;
_L11:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        s1.close();
_L8:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        s.close();
_L9:
        throw context;
_L4:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        s1.close();
_L7:
        if (s == null) goto _L2; else goto _L6
_L6:
        s.close();
_L2:
        return context.getAbsolutePath();
        s1;
        try
        {
            s1.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
          goto _L7
        s;
        s.printStackTrace();
          goto _L2
        s1;
        s1.printStackTrace();
          goto _L8
        s;
        s.printStackTrace();
          goto _L9
        context;
        s = null;
        s1 = null;
        continue; /* Loop/switch isn't completed */
        context;
        s = null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public static Location getBestKnownLocation(Context context)
    {
        Location location = null;
        LocationManager locationmanager = (LocationManager)context.getSystemService("location");
        if (locationmanager == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        if (locationmanager.isProviderEnabled("network"))
        {
            context = locationmanager.getLastKnownLocation("network");
        } else
        {
            context = null;
        }
        if (locationmanager.isProviderEnabled("gps"))
        {
            location = locationmanager.getLastKnownLocation("gps");
        }
        if (location != null) goto _L2; else goto _L1
_L1:
        return context;
_L2:
        if (context == null)
        {
            return location;
        }
        if (location.getTime() < context.getTime()) goto _L1; else goto _L3
_L3:
        return location;
        return null;
    }

    public static String getCardDetectionSettingsPath(Context context)
    {
        dh.b("getCardDetectionSettingsPath");
        (new File(getDataDirectory(context), "card_detector/")).mkdirs();
        return extractFile(context, "card_detector/card_detection_engine", "6561d5d87b4487d1c5995e3fb137b456f6d6e2a683fcfc640fe5bb694571cbc6", JSON_FILE_EXTENSION);
    }

    public static String getCpuCount(Context context)
    {
        return Integer.toString(jumioModule.getCpuCount());
    }

    public static String getCpuFamily(Context context)
    {
        if (!JUMIO_LIB_IS_LOADED)
        {
            loadJumioLib(context);
        }
        int i = jumioModule.getCpuFamily();
        switch (i)
        {
        default:
            return (new StringBuilder()).append("UNKNOWN (").append(i).append(")").toString();

        case 1: // '\001'
            return "ARM";

        case 2: // '\002'
            return "X86";

        case 3: // '\003'
            return "MIPS";
        }
    }

    public static String getCpuFeatures(Context context)
    {
        int i;
        int j;
        if (!JUMIO_LIB_IS_LOADED)
        {
            loadJumioLib(context);
        }
        i = jumioModule.getCpuFamily();
        j = jumioModule.getCpuFeatures();
        context = "";
        i;
        JVM INSTR tableswitch 1 2: default 44
    //                   1 49
    //                   2 172;
           goto _L1 _L2 _L3
_L1:
        context = "";
_L5:
        return context;
_L2:
        Object obj = context;
        if ((j & 1) == 1)
        {
            obj = (new StringBuilder()).append("").append("ARMv7 ").toString();
        }
        context = ((Context) (obj));
        if ((j & 2) == 2)
        {
            context = (new StringBuilder()).append(((String) (obj))).append("VFPv3 ").toString();
        }
        obj = context;
        if ((j & 4) == 4)
        {
            obj = (new StringBuilder()).append(context).append("NEON ").toString();
        }
        context = ((Context) (obj));
        if ((j & 8) == 8)
        {
            return (new StringBuilder()).append(((String) (obj))).append("LDREX_STREX ").toString();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if ((j & 1) == 1)
        {
            context = (new StringBuilder()).append("").append("SSSE3 ").toString();
        }
        Object obj1 = context;
        if ((j & 2) == 2)
        {
            obj1 = (new StringBuilder()).append(context).append("POPCNT ").toString();
        }
        context = ((Context) (obj1));
        if ((j & 4) == 4)
        {
            return (new StringBuilder()).append(((String) (obj1))).append("MOVBE ").toString();
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static File getDataDirectory(Context context)
    {
        context = new File(context.getFilesDir(), DATA_DIRECTORY);
        if (!context.isDirectory())
        {
            context.mkdirs();
        }
        return context;
    }

    public static String getDeviceId(Context context)
    {
        Object obj;
        Object obj1;
        SharedPreferences sharedpreferences;
        sharedpreferences = context.getSharedPreferences("UniqueID", 0);
        obj1 = sharedpreferences.getString("deviceId", null);
        if (obj1 != null)
        {
            obj = obj1;
            if (!((String) (obj1)).equals(""))
            {
                break MISSING_BLOCK_LABEL_81;
            }
        }
        context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        obj = obj1;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        obj = obj1;
        if (context.length() > 0)
        {
            obj = obj1;
            int i;
            try
            {
                if (!context.equals("9774d56d682e549c"))
                {
                    obj = context.toUpperCase(Locale.GERMAN);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                obj = null;
            }
        }
label0:
        {
            if (obj != null)
            {
                context = ((Context) (obj));
                if (!((String) (obj)).equals(""))
                {
                    break label0;
                }
            }
            try
            {
                context = Build.SERIAL.toUpperCase(Locale.GERMAN);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context = null;
            }
        }
label1:
        {
            if (context != null)
            {
                obj = context;
                if (!context.equals(""))
                {
                    break label1;
                }
            }
            obj = UUID.randomUUID().toString().replace('-', '0');
        }
        context = new StringBuffer();
        obj1 = MessageDigest.getInstance("SHA-1");
        ((MessageDigest) (obj1)).reset();
        ((MessageDigest) (obj1)).update(((String) (obj)).getBytes("UTF-8"));
        obj = ((MessageDigest) (obj1)).digest();
        i = 0;
_L2:
        if (i >= obj.length)
        {
            break; /* Loop/switch isn't completed */
        }
        if ((obj[i] & 0xff) >= 16)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        context.append("0");
        context.append(Integer.toHexString(obj[i] & 0xff));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            context = context.toString();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = "0000000000000000";
        }
        obj = sharedpreferences.edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("deviceId", context);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        return context;
    }

    public static String getOCREngineSettingsPath(Context context)
    {
        (new File(getDataDirectory(context), "card_detector/")).mkdirs();
        extractFile(context, "card_detector/fast_findcard_config", "04f73e7b83388ac720c08bbc12bc67cda18ad6e57747669ce6ce3385778896f7", JSON_FILE_EXTENSION);
        extractFile(context, "retr_alphabet", "06f97848a282ffe17911b201d38ef6ac0b6023685343cc90ea3ea554fda07cc3", YAML_FILE_EXTENSION);
        extractFile(context, "retr_sampling", "dfa5f286c1c82accc8a8c078d24ff341a8b6aea13aeb4192fa1b8066b19a6cd6", YAML_FILE_EXTENSION);
        extractFile(context, "retriever_settings", "3dc30e3fb2cba4298e986db55a1866dccdfc76345d1102a4e8c2a224992504c9", YAML_FILE_EXTENSION);
        extractFile(context, "retriever_settings_0", "7b730ed97b4d738fcc32090fd4a19dbf9f9d7a40c2f0cf9ccd62bc3d152f49aa", YAML_FILE_EXTENSION);
        (new File(getDataDirectory(context), "ocrengine/")).mkdirs();
        extractFile(context, "ocrengine/bigdig_highlight", "4e6df57531c550064d2a1105a14f6372436fda2cf40449261685dd5e4740afd6", PB_FILE_EXTENSION);
        extractFile(context, "ocrengine/bigdig_recognizer", "332c269db6a283d4bb46a06ecf88365cb8e27a369172a4b78ea8c35c9cbaa9eb", PB_FILE_EXTENSION);
        extractFile(context, "ocrengine/bigdig_rescaler", "267a0b327fac69926495a540b6aa84788ae8af991eb77d20bdb1a62acd2814b5", TXT_FILE_EXTENSION);
        extractFile(context, "ocrengine/bigdigfirstpass_recognizer", "a376d4a4578d66116fef7fac4c6fb98971c569a2fd9d3bf85e255083e08b0045", PB_FILE_EXTENSION);
        extractFile(context, "ocrengine/smalldig_highlight", "38e15d6ebd9d56c4c731f4b106397d8adcab7c7c92a09080950465cbf5bfd9e8", PB_FILE_EXTENSION);
        extractFile(context, "ocrengine/smalldig_recognizer", "d87fbec083b0674a26e24c294769bf45a441190a6233d6298a1cac445262c0d3", PB_FILE_EXTENSION);
        extractFile(context, "ocrengine/smalldig_second_pass_highlight", "5d38fb1cdb9528f4144e4a6371c3d8a2fd488666a7563a88656a59f19fefa942", PB_FILE_EXTENSION);
        extractFile(context, "ocrengine/smalldigfirstpass_recognizer", "2730c388d6f32763d325caa861d885ecc50a7b25ace685f2974545c70d985b5f", PB_FILE_EXTENSION);
        extractFile(context, "ocrengine/smallsym_highlight", "6c7caec24050833412259b898292469d625c4e9ab260a65194375e3b5a5ef39c", PB_FILE_EXTENSION);
        extractFile(context, "ocrengine/smallsym_recognizer", "28755aa25e285a8530af4ea2af42f4e86124308a20e0cf7c4550056020fc9c66", PB_FILE_EXTENSION);
        extractFile(context, "ocrengine/smallsym_rescaler", "28755aa25e285a8530af4ea2af42f4e86124308a20e0cf7c4550056020fc9c66", TXT_FILE_EXTENSION);
        (new File(getDataDirectory(context), "dictionaries/")).mkdirs();
        extractFile(context, "dictionaries/name", "fe3c23ce859ec03a4f961dcf9c87f928edf7437fbc8eea11cb89b60e5be2abd0", DICT_FILE_EXTENSION);
        extractFile(context, "dictionaries/sortcode", "aea77bae7ea898c651d9934a2eea1c291578ee94f0544a2f1ae277458685dde1", PB_FILE_EXTENSION);
        extractFile(context, "dictionaries/surname", "0a53f9fbe66653276a2f13a78764a2979c710b3162d67ece61b398491be7bee5", DICT_FILE_EXTENSION);
        extractFile(context, "dictionaries/six_digits", "575b612cab9adf3dc433c420c3bdddbe5f6ccf5f847e2f55836a39327173b4ec", PB_FILE_EXTENSION);
        extractFile(context, "dictionaries/sc_an_rules", "9b220545f66d2ca01b0b8e57e10ddace62ca8c42633e40e29555916fbb04b7c2", TXT_FILE_EXTENSION);
        (new File(getDataDirectory(context), "triadonaries/")).mkdirs();
        extractFile(context, "triadonaries/name", "8cb3e383e4739c76b03a2b427f9a7b906666717f6a52f2b814793486130d5adf", TRIA_FILE_EXTENSION);
        return extractFile(context, "ocr_engine", "4edbcf1dd30e935783ec86f8603a81579ec84107bfd33c5b53c75fd4b993ec99", JSON_FILE_EXTENSION);
    }

    public static boolean isSupportedPlatform(Context context)
    {
        if (!JUMIO_LIB_IS_LOADED)
        {
            loadJumioLib(context);
        }
        String s = getCpuFeatures(context);
        return getCpuFamily(context).equals("ARM") && s.contains("ARMv7") && s.contains("NEON");
    }

    public static boolean loadJniInterfaceLib(Context context)
    {
        dh.b("loadJniInterfaceLib");
        if (!JNI_INTERFACE_LIB_IS_LOADED)
        {
            System.load(extractFile(context, "libjniInterface", "8ece748f6f8fddf53a1a331f14d8e111ee53a054299d9e5b62c3fff730544110", ".so"));
            JNI_INTERFACE_LIB_IS_LOADED = true;
        }
        return true;
    }

    public static boolean loadJumioLib(Context context)
    {
        dh.b("loadJumioLib");
        if (!JUMIO_LIB_IS_LOADED)
        {
            System.load(extractFile(context, "libjumio", "795f013a8c696aecb1485130aa87e18dd10aeda4f5b58c83e83bdeb1d4f7eb1f", ".so"));
            JUMIO_LIB_IS_LOADED = true;
        }
        return true;
    }

    public static Typeface loadOcraFontTypeface(Context context)
    {
        dh.b("loadOcraFontTypeface");
        if (OCRA_FONT == null)
        {
            OCRA_FONT = Typeface.createFromFile(extractFile(context, "ocrastd", "94d996897f0200d38fa47a6dce468b6ed74357cd4df7520d319e794d439101e5", ".otf"));
        }
        return OCRA_FONT;
    }

    static 
    {
        JUMIO_LIB_IS_LOADED = false;
        JNI_INTERFACE_LIB_IS_LOADED = false;
    }
}
