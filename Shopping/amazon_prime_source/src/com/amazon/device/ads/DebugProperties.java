// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.Environment;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Properties;
import javax.crypto.Cipher;

// Referenced classes of package com.amazon.device.ads:
//            DefaultFileHandlerFactory, MobileAdsLoggerFactory, MobileAdsLogger, FileHandlerFactory, 
//            FileInputHandler

class DebugProperties
{

    public static final String DEBUG_AAX_AD_HOSTNAME = "debug.aaxHostname";
    public static final String DEBUG_AAX_AD_PARAMS = "debug.aaxAdParams";
    public static final String DEBUG_AAX_CONFIG_HOSTNAME = "debug.aaxConfigHostname";
    public static final String DEBUG_AAX_CONFIG_PARAMS = "debug.aaxConfigParams";
    public static final String DEBUG_AAX_CONFIG_USE_SECURE = "debug.aaxConfigUseSecure";
    public static final String DEBUG_ADID = "debug.adid";
    public static final String DEBUG_AD_PREF_URL = "debug.adPrefURL";
    public static final String DEBUG_AD_RESOURCE_PATH = "debug.adResourcePath";
    public static final String DEBUG_APPID = "debug.appid";
    public static final String DEBUG_CAN_TIMEOUT = "debug.canTimeout";
    public static final String DEBUG_CHANNEL = "debug.channel";
    public static final String DEBUG_CONFIG_FEATURE_USE_GPS_ADVERTISING_ID = "debug.fUseGPSAID";
    public static final String DEBUG_DINFO = "debug.dinfo";
    public static final String DEBUG_DIRECTEDID = "debug.directedId";
    public static final String DEBUG_ECPM = "debug.ec";
    public static final String DEBUG_GEOLOC = "debug.geoloc";
    public static final String DEBUG_IDFA = "debug.idfa";
    public static final String DEBUG_IU_INTERVAL = "debug.identifyUserInterval";
    public static final String DEBUG_LOGGING = "debug.logging";
    public static final String DEBUG_MADS_HOSTNAME = "debug.madsHostname";
    public static final String DEBUG_MADS_USE_SECURE = "debug.madsUseSecure";
    public static final String DEBUG_MD5UDID = "debug.md5udid";
    public static final String DEBUG_MXSZ = "debug.mxsz";
    public static final String DEBUG_NORETRYTTL = "debug.noRetryTTL";
    public static final String DEBUG_NORETRYTTL_MAX = "debug.noRetryTTLMax";
    public static final String DEBUG_ON = "debug.mode";
    public static final String DEBUG_OPT_OUT = "debug.optOut";
    public static final String DEBUG_PA = "debug.pa";
    public static final String DEBUG_PK = "debug.pk";
    public static final String DEBUG_PKG = "debug.pkg";
    public static final String DEBUG_PT = "debug.pt";
    public static final String DEBUG_SEND_GEO = "debug.sendGeo";
    public static final String DEBUG_SHA1UDID = "debug.sha1udid";
    public static final String DEBUG_SHOULD_FETCH_CONFIG = "debug.shouldFetchConfig";
    public static final String DEBUG_SHOULD_IDENTIFY_USER = "debug.shouldIdentifyUser";
    public static final String DEBUG_SHOULD_REGISTER_SIS = "debug.shouldRegisterSIS";
    public static final String DEBUG_SIS_CHECKIN_INTERVAL = "debug.sisCheckinInterval";
    public static final String DEBUG_SIS_DOMAIN = "debug.sisDomain";
    public static final String DEBUG_SIS_URL = "debug.sisURL";
    public static final String DEBUG_SIZE = "debug.size";
    public static final String DEBUG_SLOT = "debug.slot";
    public static final String DEBUG_SLOTS = "debug.slots";
    public static final String DEBUG_SLOT_ID = "debug.slotId";
    public static final String DEBUG_SP = "debug.sp";
    public static final String DEBUG_SUPPORTED_MEDIA_TYPES = "debug.supportedMediaTypes";
    public static final String DEBUG_TEST = "debug.test";
    public static final String DEBUG_TLS_ENABLED = "debug.tlsEnabled";
    public static final String DEBUG_TRUNCATE_LAT_LON = "debug.truncateLatLon";
    public static final String DEBUG_UA = "debug.ua";
    public static final String DEBUG_VER = "debug.ver";
    public static final String DEBUG_VIDEO_OPTIONS = "debug.videoOptions";
    public static final String DEBUG_WEBVIEWS = "debug.webViews";
    public static final String DEBUG_WHITELISTED_CUSTOMER = "debug.whiteListedCustomer";
    private static final String FILE_PREFIX = "/com.amazon.device.ads.debug";
    private static final String LOGTAG = com/amazon/device/ads/DebugProperties.getSimpleName();
    private static final DebugProperties instance = new DebugProperties(new DefaultFileHandlerFactory());
    private static final BigInteger privExponent = new BigInteger("5599215006722084151841970702827860151139465197978118529242591197804380779249736540498127864809226859371835159226553869008622098243456195347852554241917744888762998133926842072150379542281041403163862165638226686887497980590930009552760406707269286898150890998325325890252103828011111664174475487114957696526157790937869377570600085450453371238028811033168218737171144699577236108423054506552958366535341910569552237227686862748056351625445281035713423043506793107235726047151346608576583081807969458368853010104969843563629579750936551771756389538574062221915919980316992216032119182896925094308799622409361028579777");
    private static final BigInteger privModulus = new BigInteger("22425945969293236512819607281747202268852113345956851069545419503178249900977203670147638322801582881051882957295768557918356441519366172126884608406316888515239296504501830280664879549133570276792155151832332847188532369002492210234019359186842709493620665119919750832332220777141369255943445578381285984064028865613478676828533273460580467686485184132743895959747097454385452868408957601246667523882372216446056029831689133478714597838700864119273209955182548633182248700235085802575904827859971001196599005060045450779595767759943984991630413046800554347791145167910883355627096118148593841261053098773337592734097");
    private boolean debugModeOn;
    private final Properties debugProperties = new Properties();
    private final FileHandlerFactory fileHandlerFactory;
    private final MobileAdsLogger logger;

    public DebugProperties(FileHandlerFactory filehandlerfactory)
    {
        debugModeOn = false;
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);
        fileHandlerFactory = filehandlerfactory;
    }

    public static DebugProperties getInstance()
    {
        return instance;
    }

    public boolean containsDebugProperty(String s)
    {
        if (!debugModeOn)
        {
            return false;
        } else
        {
            return debugProperties.containsKey(s);
        }
    }

    protected byte[] decrypt(byte abyte0[])
    {
        try
        {
            Object obj = new RSAPrivateKeySpec(privModulus, privExponent);
            obj = KeyFactory.getInstance("RSA").generatePrivate(((java.security.spec.KeySpec) (obj)));
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(2, ((java.security.Key) (obj)));
            abyte0 = cipher.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            logger.d((new StringBuilder()).append("Exception ").append(abyte0).append(" trying to decrypt debug file").toString());
            return null;
        }
        return abyte0;
    }

    void disableDebugging()
    {
        debugModeOn = false;
    }

    void enableDebugging()
    {
        debugModeOn = true;
    }

    public Boolean getDebugPropertyAsBoolean(String s, Boolean boolean1)
    {
        String s1;
        if (debugModeOn)
        {
            if ((s1 = debugProperties.getProperty(s)) != null)
            {
                boolean flag;
                try
                {
                    flag = Boolean.parseBoolean(s1);
                }
                catch (NumberFormatException numberformatexception)
                {
                    logger.e("Unable to parse boolean debug property - property: %s, value: %s", new Object[] {
                        s, s1
                    });
                    return boolean1;
                }
                return Boolean.valueOf(flag);
            }
        }
        return boolean1;
    }

    public Integer getDebugPropertyAsInteger(String s, Integer integer)
    {
        String s1;
        if (debugModeOn)
        {
            if ((s1 = debugProperties.getProperty(s)) != null)
            {
                int i;
                try
                {
                    i = Integer.parseInt(s1);
                }
                catch (NumberFormatException numberformatexception)
                {
                    logger.e("Unable to parse integer debug property - property: %s, value: %s", new Object[] {
                        s, s1
                    });
                    return integer;
                }
                return Integer.valueOf(i);
            }
        }
        return integer;
    }

    public Long getDebugPropertyAsLong(String s, Long long1)
    {
        String s1;
        if (debugModeOn)
        {
            if ((s1 = debugProperties.getProperty(s)) != null)
            {
                long l;
                try
                {
                    l = Long.parseLong(s1);
                }
                catch (NumberFormatException numberformatexception)
                {
                    logger.e("Unable to parse long debug property - property: %s, value: %s", new Object[] {
                        s, s1
                    });
                    return long1;
                }
                return Long.valueOf(l);
            }
        }
        return long1;
    }

    public String getDebugPropertyAsString(String s, String s1)
    {
        if (!debugModeOn)
        {
            return s1;
        } else
        {
            return debugProperties.getProperty(s, s1);
        }
    }

    public boolean isDebugModeOn()
    {
        return debugModeOn;
    }

    public void readDebugProperties()
    {
        Object obj;
        obj = null;
        String s;
        try
        {
            s = Environment.getExternalStorageState();
        }
        catch (NullPointerException nullpointerexception)
        {
            logger.w("Exception loading debug properties. %s", new Object[] {
                nullpointerexception.getMessage()
            });
            continue; /* Loop/switch isn't completed */
        }
        obj = s;
_L7:
        if (obj == null || !"mounted".equals(obj)) goto _L2; else goto _L1
_L1:
        obj = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/com.amazon.device.ads.debug").toString();
        obj = fileHandlerFactory.createFileInputHandler(((String) (obj)));
        if (((FileInputHandler) (obj)).doesFileExist() && ((FileInputHandler) (obj)).getFileLength() <= 0x7fffffffL) goto _L3; else goto _L2
_L2:
        byte abyte0[];
        return;
_L3:
        if ((abyte0 = ((FileInputHandler) (obj)).readAllBytesFromFileAndClose()) == null || (abyte0 = decrypt(abyte0)) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        abyte0 = new ByteArrayInputStream(abyte0);
        debugProperties.clear();
        debugProperties.load(abyte0);
        try
        {
            abyte0.close();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            logger.d("Exception closing input stream.");
        }
_L5:
        if (Boolean.valueOf(debugProperties.getProperty("debug.mode", "false")).booleanValue())
        {
            debugModeOn = true;
            return;
        }
        if (true) goto _L2; else goto _L4
_L4:
        Object obj1;
        obj1;
        logger.d("Exception loading debug properties. %s", new Object[] {
            ((IOException) (obj1)).getMessage()
        });
        try
        {
            abyte0.close();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            logger.d("Exception closing input stream.");
        }
          goto _L5
        obj1;
        try
        {
            abyte0.close();
        }
        catch (IOException ioexception)
        {
            logger.d("Exception closing input stream.");
        }
        throw obj1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    void setDebugProperty(String s, String s1)
    {
        debugProperties.put(s, s1);
    }

}
