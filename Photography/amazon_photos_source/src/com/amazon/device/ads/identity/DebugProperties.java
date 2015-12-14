// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import android.os.Environment;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Properties;
import javax.crypto.Cipher;

// Referenced classes of package com.amazon.device.ads.identity:
//            DefaultFileHandlerFactory, Log, FileHandlerFactory, FileInputHandler

class DebugProperties
{

    private static final String LOG_TAG = com/amazon/device/ads/identity/DebugProperties.getSimpleName();
    private static final DebugProperties instance = new DebugProperties(new DefaultFileHandlerFactory());
    private static final BigInteger privExponent = new BigInteger("5599215006722084151841970702827860151139465197978118529242591197804380779249736540498127864809226859371835159226553869008622098243456195347852554241917744888762998133926842072150379542281041403163862165638226686887497980590930009552760406707269286898150890998325325890252103828011111664174475487114957696526157790937869377570600085450453371238028811033168218737171144699577236108423054506552958366535341910569552237227686862748056351625445281035713423043506793107235726047151346608576583081807969458368853010104969843563629579750936551771756389538574062221915919980316992216032119182896925094308799622409361028579777");
    private static final BigInteger privModulus = new BigInteger("22425945969293236512819607281747202268852113345956851069545419503178249900977203670147638322801582881051882957295768557918356441519366172126884608406316888515239296504501830280664879549133570276792155151832332847188532369002492210234019359186842709493620665119919750832332220777141369255943445578381285984064028865613478676828533273460580467686485184132743895959747097454385452868408957601246667523882372216446056029831689133478714597838700864119273209955182548633182248700235085802575904827859971001196599005060045450779595767759943984991630413046800554347791145167910883355627096118148593841261053098773337592734097");
    private boolean debugModeOn;
    private final Properties debugProperties = new Properties();
    private final FileHandlerFactory fileHandlerFactory;

    public DebugProperties(FileHandlerFactory filehandlerfactory)
    {
        debugModeOn = false;
        fileHandlerFactory = filehandlerfactory;
    }

    public static DebugProperties getInstance()
    {
        return instance;
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
            Log.d(LOG_TAG, (new StringBuilder("Exception ")).append(abyte0).append(" trying to decrypt debug file").toString(), new Object[0]);
            return null;
        }
        return abyte0;
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
                    Log.e(LOG_TAG, "Unable to parse boolean debug property - property: %s, value: %s", new Object[] {
                        s, s1
                    });
                    return boolean1;
                }
                return Boolean.valueOf(flag);
            }
        }
        return boolean1;
    }

    public boolean getDebugPropertyAsBoolean(String s, boolean flag)
    {
        return getDebugPropertyAsBoolean(s, Boolean.valueOf(flag)).booleanValue();
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

    public void readDebugProperties()
    {
        if (!"mounted".equals(Environment.getExternalStorageState())) goto _L2; else goto _L1
_L1:
        Object obj;
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
            Log.d(LOG_TAG, "Exception closing input stream.", new Object[0]);
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
        Log.d(LOG_TAG, "Exception loading debug properties. %s", new Object[] {
            ((IOException) (obj1)).getMessage()
        });
        try
        {
            abyte0.close();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.d(LOG_TAG, "Exception closing input stream.", new Object[0]);
        }
          goto _L5
        obj1;
        try
        {
            abyte0.close();
        }
        catch (IOException ioexception)
        {
            Log.d(LOG_TAG, "Exception closing input stream.", new Object[0]);
        }
        throw obj1;
    }

}
