// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mobile.sdk.environment;

import android.content.Context;
import android.graphics.Typeface;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import jumiomobile.ab;

public class Environment
{

    private static boolean BENCHMARK_LIB_IS_LOADED = false;
    public static final String BUILD_VERSION = "JMSDK 1.7.0 (1441790640-34)";
    private static final String CARD_DETECTOR_CONFIG_FILE = "card_detector/card_detection_engine.xml";
    public static final String CLIENTLIB_VERSION = "1.91.3";
    private static boolean CPU_INFO_LIB_IS_LOADED = false;
    private static String DATA_DIRECTORY = "/jumio/";
    private static boolean JNI_IMAGE_QUALITY_LIB_IS_LOADED = false;
    private static boolean JNI_INTERFACE_LIB_IS_LOADED = false;
    private static boolean LIVELINESS_DETECTION_AND_TM_NATIVE_LIB_IS_LOADED = false;
    private static final String LIVENESS_CONFIG_FOLDER = "livenessDetector";
    private static final String MRZ_CONFIG_FILE = "mrz_mobile/mrzapi_engine.xml";
    private static boolean MRZ_JNI_INTERFACE_LIB_IS_LOADED = false;
    private static Typeface OCRA_FONT = null;
    private static final String OCR_CONFIG_FILE = "ocr/ocrengine-full-fast.xml";
    public static final String OCR_VERSION = "1.82.0";
    public static final String OTF_OCRASTD = "94d996897f0200d38fa47a6dce468b6ed74357cd4df7520d319e794d439101e5";
    private static boolean PHOTOPAY_NATIVE_API_LIB_IS_LOADED = false;
    private static boolean TEMPLATEMATCHER_NATIVE_LIB_IS_LOADED = false;

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
        ((BufferedInputStream) (obj)).close();
_L7:
        int j;
        file = messagedigest.digest();
        j = file.length;
        i = 0;
_L6:
        if (i >= j) goto _L5; else goto _L4
_L4:
        byte byte0 = file[i];
        stringbuilder.append(Character.forDigit((byte0 & 0xf0) >> 4, 16));
        stringbuilder.append(Character.forDigit(byte0 & 0xf, 16));
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

    public static void checkOcrVersion(Context context)
    {
        context = getDataDirectory(context);
        File file = new File(context, "cv");
        if (!"1.82.0".equals(readFile(file)))
        {
            deleteDirectory(context);
            writeFile("1.82.0", file);
        }
    }

    private static void deleteDirectory(File file)
    {
        if (file != null && file.exists() && file.isDirectory()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((file = file.listFiles()) != null)
        {
            int j = file.length;
            int i = 0;
            while (i < j) 
            {
                File file1 = file[i];
                if (file1.isDirectory())
                {
                    deleteDirectory(file1);
                    file1.delete();
                } else
                {
                    file1.delete();
                }
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static String extractFile(Context context, String s, String s1, String s2)
    {
        context = new File(getDataDirectory(context), (new StringBuilder()).append(s).append(s2).toString());
        if (context.getName().startsWith("_"))
        {
            s2 = context.getName().substring(1);
            context = new File(context.getParentFile(), s2);
        }
        s2 = calculateHash(context);
        if (context.isFile() && s1.equals(s2)) goto _L2; else goto _L1
_L1:
        s2 = new byte[2048];
        int i;
        if (context.isFile())
        {
            context.delete();
        } else
        {
            context.getParentFile().mkdirs();
        }
        s1 = com/jumio/mobile/sdk/environment/Environment.getResourceAsStream(s);
        s = new FileOutputStream(context);
_L5:
        i = s1.read(s2);
        if (i <= 0) goto _L4; else goto _L3
_L3:
        s.write(s2, 0, i);
          goto _L5
        context;
_L10:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        s1.close();
_L7:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        s.close();
_L8:
        throw context;
_L4:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        try
        {
            s1.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            try
            {
                ab.a(s1);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ab.a(context);
                return null;
            }
        }
        s.close();
_L2:
        return context.getAbsolutePath();
        s;
        ab.a(s);
        if (true) goto _L2; else goto _L6
_L6:
        s1;
        ab.a(s1);
          goto _L7
        s;
        ab.a(s);
          goto _L8
        context;
        s = null;
        s1 = null;
        continue; /* Loop/switch isn't completed */
        context;
        s = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static String getCardDetectionSettingsPath(Context context)
    {
        extractFile(context, "card_detector/card_detection_engine", "9ef87da4d5737222a284baa8fdbe72c2805334b85a779fb3a5f68cc18420bc3f", ".xml");
        extractFile(context, "card_detector/card_detection_engine-by_jumio", "66715acf23836e35c1ccd770b1ccc4d77c9cbc811d766c1680c04120de1495d4", ".json");
        extractFile(context, "card_detector/fast_findcard_config", "839c941a7446898b3f2e655850e65d60d8e70d72ac394c36b4b4bf9093042682", ".xml");
        return (new File(getDataDirectory(context), "card_detector/card_detection_engine.xml")).getAbsolutePath();
    }

    public static File getDataDirectory(Context context)
    {
        context = new File(context.getFilesDir(), DATA_DIRECTORY);
        if (!context.isDirectory())
        {
            context.mkdirs();
        }
        return context;
    }

    public static String getLivenessEngineSettingsPath(Context context)
    {
        extractFile(context, "livenessDetector/smile", "0d4a24f4fdee26d40b318654fc123af50ac2404571b27d22b2a736051ae64f2b", ".dat");
        extractFile(context, "livenessDetector/cascade", "4a979bbeae0ef4316e97832f282eef536aeabae0ac80dd2090b08a45f8d237a9", ".pb");
        extractFile(context, "livenessDetector/sp", "69a694249414e8b5cbda17e65a6d6fc2863a9ec90e1d7567d60228ee7a3b19bf", ".dat");
        return (new File(getDataDirectory(context), "livenessDetector")).getAbsolutePath();
    }

    public static String getMRZEngineSettingsPath(Context context)
    {
        extractFile(context, "mrz_mobile/mrzapi_engine", "67071f707d9f6e6e515d670fcb7fc0ebdbe85f0ebfd615712e7e70e142e5f93b", ".xml");
        extractFile(context, "mrz_mobile/mrzcontexts/field_syntax_restrictions", "3925ca191439b16624ac1d1031604c7ca20a445e7ce9befe832d316e39f6c5f6", ".xml");
        extractFile(context, "mrz_mobile/dictionaries/sc_an_rules", "6f366db36c024868078647a56f90300e1cfd5dc4b685f62ffb4fdfe2f7020d8f", ".txt");
        extractFile(context, "mrz_mobile/dictionaries/name", "5fdc4542884401d9314f469cf5b63395bb2b2418dc489f695008aaddad62a81f", ".dict");
        extractFile(context, "mrz_mobile/dictionaries/six_digits", "f9464d0f4f38a80629e8c94bcfada9d9a4f93a17ce7387a38ad1da784985208f", ".pb");
        extractFile(context, "mrz_mobile/dictionaries/surname", "9e1747493f14722e44af43c014bac4cd92cfa5696bd4b826aba36091ea80a7da", ".dict");
        extractFile(context, "mrz_mobile/mrzhighlight/highlight-ini", "7a2db3523eea4897eca168c26c18466a2e3498311cd47721c431a3039b2bccbc", ".pb");
        extractFile(context, "mrz_mobile/mrztriadonaries/usa.thirdname.dist", "42fcd09c8e7bf52f2e69fa848bda237163a91a8d12e93f4492b654313c9e6fa5", ".trimpb");
        extractFile(context, "mrz_mobile/mrztriadonaries/usa.firstname.dist", "ba24e128c23726d734c048044723fd25c049a13b2734c5bdcc35855b2326f28d", ".trimpb");
        extractFile(context, "mrz_mobile/mrztriadonaries/usa.lastname.dist", "19fbd6450764db534b5a3843039d8313eef36d463d69f99d4241514e34d82c2b", ".trimpb");
        extractFile(context, "mrz_mobile/mrzocr/network_6_packed", "c1b80624cb2a615ba60f9b09b20ff299b707300a89a311c1f6678e22a72a28e7", ".pb");
        return (new File(getDataDirectory(context), "mrz_mobile/mrzapi_engine.xml")).getAbsolutePath();
    }

    public static String getOCREngineSettingsPath(Context context)
    {
        extractFile(context, "ocr/ocrengine-full-fast", "cd3ae52ec981e695b7ebec9426fe23449e3594f56cadd8e67cdf12c5a596cdb0", ".xml");
        extractFile(context, "ocr/retriever_settings_sym_1", "2fd6bc528c178441a011aa124299a5687730ec528521a9b1fbc43d62887258a5", ".json");
        extractFile(context, "ocr/retr_sampling", "dfa5f286c1c82accc8a8c078d24ff341a8b6aea13aeb4192fa1b8066b19a6cd6", ".yaml");
        extractFile(context, "ocr/_ocrengine", "ec8e90d656d917acb8c86a221ca331488cd86bf37ef5f38c98dbc81cc21f1f7a", ".xml");
        extractFile(context, "ocr/retriever_settings", "43c544cc79e29515da94dc68452d7f4ba4c454d3a669be9f44f741dc6dd7559b", ".json");
        extractFile(context, "ocr/retr_alphabet", "06f97848a282ffe17911b201d38ef6ac0b6023685343cc90ea3ea554fda07cc3", ".yaml");
        extractFile(context, "ocr/ocrengine-full-server", "0665ac274176a4fb0e827502f78013b945bb865ef61b663a253f8f6cc6b6570f", ".xml");
        extractFile(context, "ocr/retriever_settings_sym", "28522a041eaad3d0280feef2161ae1cbfb9b19d7c5568c377e8563d25005133b", ".json");
        extractFile(context, "ocr/dictionaries/sc_an_rules", "6f366db36c024868078647a56f90300e1cfd5dc4b685f62ffb4fdfe2f7020d8f", ".txt");
        extractFile(context, "ocr/dictionaries/name", "5fdc4542884401d9314f469cf5b63395bb2b2418dc489f695008aaddad62a81f", ".dict");
        extractFile(context, "ocr/dictionaries/six_digits", "f9464d0f4f38a80629e8c94bcfada9d9a4f93a17ce7387a38ad1da784985208f", ".pb");
        extractFile(context, "ocr/dictionaries/surname", "9e1747493f14722e44af43c014bac4cd92cfa5696bd4b826aba36091ea80a7da", ".dict");
        extractFile(context, "ocr/card_detector/card_detection_engine", "9ef87da4d5737222a284baa8fdbe72c2805334b85a779fb3a5f68cc18420bc3f", ".xml");
        extractFile(context, "ocr/card_detector/fast_findcard_config", "839c941a7446898b3f2e655850e65d60d8e70d72ac394c36b4b4bf9093042682", ".xml");
        extractFile(context, "ocr/detectors/discover1a_101x19", "4a65667ff4cb870298ec64720fade973f941d10abbc94f2bc53dce1a936ef723", ".pb");
        extractFile(context, "ocr/detectors/visa1_41x21", "7ba21dc70458132f8ddb44249b8aa6179e23715a03f665d5b0f2ccf4f12ea522", ".pb");
        extractFile(context, "ocr/detectors/mc_41x25", "0416d4eff2a06908e91a9d87c3afa677e0a91d23d1bb2df35a793c8791c139e0", ".pb");
        extractFile(context, "ocr/detectors/discover1b_117x21", "9339de5197978a0532ac9bc6e0554744f8872820259b9d98eed31586e93463d6", ".pb");
        extractFile(context, "ocr/detectors/discover2_37x23", "503d347c45dca9131392050ae92991f085fd513c02084a3fb3ab54d2257ba0a3", ".pb");
        extractFile(context, "ocr/detectors/dc_75x21", "f462bb8ecd8ce929a8ee0c173ef90b792dfccc14fda407af0131a30035a842e3", ".pb");
        extractFile(context, "ocr/detectors/visa2_41x21", "daad5d6edd7bb6843e03a429de9e15d1ff7a9a7ef0134f50e433ef3d23e0b3f1", ".pb");
        extractFile(context, "ocr/triadonaries/name.trigrams", "42fcd09c8e7bf52f2e69fa848bda237163a91a8d12e93f4492b654313c9e6fa5", ".trimpb");
        extractFile(context, "ocr/ocrengine/smalldig_highlight", "5d4c9f818c66158f77e906daf975a5f708ab5b6028c449d6783912f82280e5df", ".pb");
        extractFile(context, "ocr/ocrengine/smallsym_rescaler", "bc40364c970c1a6c9c579aa831bad258a8fb462209fbb0e79eb48986a4ef525f", ".txt");
        extractFile(context, "ocr/ocrengine/smalldig_recognizer_3_packed", "6ee2961e7de00ade3643367ba23710ae37baafd0ac8d9b380ae0c173aa5680be", ".pb");
        extractFile(context, "ocr/ocrengine/smallsym_highlight", "0b92222352d276198cd097f8d8d55dbc13106a71413cc392d630226faa2d83b0", ".pb");
        extractFile(context, "ocr/ocrengine/ump_digits_recognizer", "811cc2ff3dab8bc2471607697b31c592d6823f031ad8c0a14f5d569750ae7e0c", ".pb");
        extractFile(context, "ocr/ocrengine/bigdig_rescaler", "680bcfd891ccae2a6b73c8983acde7927a751b54d3a8673cb683d6f2459c368f", ".txt");
        extractFile(context, "ocr/ocrengine/smallsym_recognizer_intpacked", "2718664ee28bee92f41fd00977240eb0521b1057b2cd3e2cba15cb6c1cc5e547", ".pb");
        extractFile(context, "ocr/ocrengine/smallsym_recognizer_fp_intpacked", "b7ee6e6d538325be9a81be7963497524a6d1325f6955ff5c84f91524656f1822", ".pb");
        extractFile(context, "ocr/ocrengine/ump_symbols_recognizer", "c3d945245baf200383e1a9469c9c9836ceba24e16750e253baad722e148a5cbc", ".pb");
        extractFile(context, "ocr/ocrengine/bigdig_recognizer_packed", "f7740e9c316a5be4fe016c003ea808b101bc0e41c2a6eb0391d6c2922131bb07", ".pb");
        extractFile(context, "ocr/ocrengine/bigdig_highlight", "5dbda788a30cbe26a347fc54b7ad00b8eb5f1f257dc83f3c077c28c3e5945914", ".pb");
        extractFile(context, "ocr/ocrengine/double_sym_recognizer_intpacked", "3ec67fda5ec4d3730dcd851f866c26ee5125a351b6266c10c71c8125a968e62e", ".pb");
        extractFile(context, "ocr/ocrengine/smallsymdig_recognizer_packed", "06e2218202253618eedf3ae1259a1878662162bfd1678e90d6453e00838fbc34", ".pb");
        extractFile(context, "ocr/ocrengine/smalldig_recognizer_packed", "5a5fba0843be9194c984b744073d29214a9be83409189b0fe2ff8d35eb753fb3", ".pb");
        return (new File(getDataDirectory(context), "ocr/ocrengine-full-fast.xml")).getAbsolutePath();
    }

    public static boolean isLollipop()
    {
        return android.os.Build.VERSION.SDK_INT == 21;
    }

    public static boolean loadBenchmarkLib()
    {
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorenter ;
        if (!BENCHMARK_LIB_IS_LOADED)
        {
            System.loadLibrary("nativeBenchmark");
            BENCHMARK_LIB_IS_LOADED = true;
        }
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean loadCpuInfoLib()
    {
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorenter ;
        if (!CPU_INFO_LIB_IS_LOADED)
        {
            System.loadLibrary("cpuinfo");
            CPU_INFO_LIB_IS_LOADED = true;
        }
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean loadJniImageQualityLib()
    {
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorenter ;
        if (!JNI_IMAGE_QUALITY_LIB_IS_LOADED)
        {
            System.loadLibrary("jniImageQualityAcquisition");
            JNI_IMAGE_QUALITY_LIB_IS_LOADED = true;
        }
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean loadJniInterfaceLib()
    {
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorenter ;
        if (!JNI_INTERFACE_LIB_IS_LOADED)
        {
            System.loadLibrary("jniInterface");
            JNI_INTERFACE_LIB_IS_LOADED = true;
        }
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean loadLivenessDetectorAndTemplateMatcherLib()
    {
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorenter ;
        if (!LIVELINESS_DETECTION_AND_TM_NATIVE_LIB_IS_LOADED)
        {
            System.loadLibrary("jniLivenessAndTM");
            LIVELINESS_DETECTION_AND_TM_NATIVE_LIB_IS_LOADED = true;
        }
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean loadMRZJniInterfaceLib()
    {
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorenter ;
        if (!MRZ_JNI_INTERFACE_LIB_IS_LOADED)
        {
            System.loadLibrary("mrzjniInterface");
            MRZ_JNI_INTERFACE_LIB_IS_LOADED = true;
        }
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    public static Typeface loadOcraFontTypeface(Context context)
    {
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorenter ;
        if (OCRA_FONT == null)
        {
            OCRA_FONT = Typeface.createFromFile(extractFile(context, "ocrastd", "94d996897f0200d38fa47a6dce468b6ed74357cd4df7520d319e794d439101e5", ".otf"));
        }
        context = OCRA_FONT;
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static boolean loadPhotopayNativeAPILib()
    {
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorenter ;
        if (!PHOTOPAY_NATIVE_API_LIB_IS_LOADED)
        {
            System.loadLibrary("photopaynativeapi");
            PHOTOPAY_NATIVE_API_LIB_IS_LOADED = true;
        }
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean loadTemplateMatcherLib()
    {
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorenter ;
        if (!TEMPLATEMATCHER_NATIVE_LIB_IS_LOADED)
        {
            System.loadLibrary("jniTemplateMatcher");
            TEMPLATEMATCHER_NATIVE_LIB_IS_LOADED = true;
        }
        com/jumio/mobile/sdk/environment/Environment;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    private static String readFile(File file)
    {
        File file1;
        StringBuffer stringbuffer;
        file1 = null;
        stringbuffer = new StringBuffer("");
        if (file == null || !file.isFile())
        {
            return "";
        }
        file = new FileInputStream(file);
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(file));
        stringbuffer.append(bufferedreader.readLine());
        try
        {
            file.close();
            bufferedreader.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            ab.a(file);
        }
        return stringbuffer.toString().trim();
        file;
        bufferedreader = null;
_L2:
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        file1.close();
        if (bufferedreader == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        bufferedreader.close();
        throw file;
        Exception exception;
        exception;
        bufferedreader = null;
        file1 = file;
        file = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        file1 = file;
        file = exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static void writeFile(String s, File file)
    {
        file = new OutputStreamWriter(new FileOutputStream(file));
        file.write(s);
        break MISSING_BLOCK_LABEL_21;
_L2:
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        file.flush();
        file.close();
        throw s;
        try
        {
            file.flush();
            file.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ab.a(s);
        }
        return;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        file = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static 
    {
        JNI_INTERFACE_LIB_IS_LOADED = false;
        CPU_INFO_LIB_IS_LOADED = false;
        MRZ_JNI_INTERFACE_LIB_IS_LOADED = false;
        LIVELINESS_DETECTION_AND_TM_NATIVE_LIB_IS_LOADED = false;
        BENCHMARK_LIB_IS_LOADED = false;
        JNI_IMAGE_QUALITY_LIB_IS_LOADED = false;
    }
}
