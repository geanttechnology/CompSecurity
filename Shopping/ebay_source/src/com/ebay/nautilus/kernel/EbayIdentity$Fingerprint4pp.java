// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel;

import android.text.TextUtils;
import android.util.Base64;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import junit.framework.Assert;

// Referenced classes of package com.ebay.nautilus.kernel:
//            EbayIdentity

public static final class State.Encrypted
{
    public static final class DeviceOs extends Enum
    {

        private static final DeviceOs $VALUES[];
        public static final DeviceOs Android;
        public static final DeviceOs Blackberry;
        public static final DeviceOs Ios;
        public static final DeviceOs Unknown;
        public static final DeviceOs WindowsMobile;

        public static DeviceOs valueOf(String s)
        {
            return (DeviceOs)Enum.valueOf(com/ebay/nautilus/kernel/EbayIdentity$Fingerprint4pp$DeviceOs, s);
        }

        public static DeviceOs[] values()
        {
            return (DeviceOs[])$VALUES.clone();
        }

        static 
        {
            Unknown = new DeviceOs("Unknown", 0);
            Ios = new DeviceOs("Ios", 1);
            Android = new DeviceOs("Android", 2);
            Blackberry = new DeviceOs("Blackberry", 3);
            WindowsMobile = new DeviceOs("WindowsMobile", 4);
            $VALUES = (new DeviceOs[] {
                Unknown, Ios, Android, Blackberry, WindowsMobile
            });
        }

        private DeviceOs(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class DeviceType extends Enum
    {

        private static final DeviceType $VALUES[];
        public static final DeviceType Computer;
        public static final DeviceType Mid;
        public static final DeviceType Phone;
        public static final DeviceType Tablet;
        public static final DeviceType Unknown;

        public static DeviceType valueOf(String s)
        {
            return (DeviceType)Enum.valueOf(com/ebay/nautilus/kernel/EbayIdentity$Fingerprint4pp$DeviceType, s);
        }

        public static DeviceType[] values()
        {
            return (DeviceType[])$VALUES.clone();
        }

        static 
        {
            Unknown = new DeviceType("Unknown", 0);
            Phone = new DeviceType("Phone", 1);
            Mid = new DeviceType("Mid", 2);
            Tablet = new DeviceType("Tablet", 3);
            Computer = new DeviceType("Computer", 4);
            $VALUES = (new DeviceType[] {
                Unknown, Phone, Mid, Tablet, Computer
            });
        }

        private DeviceType(String s, int i)
        {
            super(s, i);
        }
    }

    private static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State Encrypted;
        public static final State HmacCalculated;
        public static final State Unencrypted;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/ebay/nautilus/kernel/EbayIdentity$Fingerprint4pp$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            Unencrypted = new State("Unencrypted", 0);
            HmacCalculated = new State("HmacCalculated", 1);
            Encrypted = new State("Encrypted", 2);
            $VALUES = (new State[] {
                Unencrypted, HmacCalculated, Encrypted
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int OFFSET_DEVICE_COUNTRY = 5;
    private static final int OFFSET_DEVICE_LANGUAGE = 10;
    private static final int OFFSET_DEVICE_OPERATING_SYSTEM = 4;
    private static final int OFFSET_DEVICE_TYPE = 3;
    private static final int OFFSET_HMAC = 31;
    private static final int OFFSET_KEYSET = 1;
    private static final int OFFSET_MOBILE_NETWORK_CODE = 7;
    private static final int OFFSET_PADDING = 28;
    private static final int OFFSET_UNIQUE_IDENTIFIER = 12;
    private static final int OFFSET_VERSION = 0;
    private final byte data[];
    private State state;

    private void encryptDecrypt(boolean flag)
    {
        SecretKeySpec secretkeyspec = new SecretKeySpec(getCryptKey(), "AES");
        Cipher cipher;
        int i;
        try
        {
            cipher = Cipher.getInstance("AES/CBC/NoPadding");
        }
        catch (Exception exception)
        {
            throw new RuntimeException("Couldn't encrypt/decrypt data!", exception);
        }
        if (flag)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        cipher.init(i, secretkeyspec, new IvParameterSpec(new byte[16]));
        i = data.length - 3;
        System.arraycopy(cipher.doFinal(data, 3, i), 0, data, 3, i);
        return;
    }

    private void ensureEncrypted()
    {
        if (state == State.Encrypted)
        {
            return;
        } else
        {
            ensureHmac();
            encryptDecrypt(true);
            state = State.Encrypted;
            return;
        }
    }

    private void ensureHmac()
    {
        if (state != State.Unencrypted)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        Assert.assertEquals(data[28] | data[29] | data[30], 0);
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(getHmacKey(), mac.getAlgorithm()));
        mac.update(data, 0, 31);
        mac.doFinal(data, 31);
        state = State.HmacCalculated;
        return;
        Exception exception;
        exception;
        throw new RuntimeException("Couldn't create HMAC!", exception);
    }

    private void ensureUnencrypted()
    {
        if (state != State.Encrypted)
        {
            return;
        }
        if (!isSupportedVersion())
        {
            throw new RuntimeException((new StringBuilder()).append("Unknown version: ").append(getVersion()).toString());
        } else
        {
            encryptDecrypt(false);
            state = State.HmacCalculated;
            return;
        }
    }

    private byte[] getCryptKey()
    {
        switch (getKeyset())
        {
        default:
            throw new RuntimeException((new StringBuilder()).append("Unknown keyset: ").append(getKeyset()).toString());

        case 1: // '\001'
        case 2: // '\002'
            return (new byte[] {
                64, -87, 45, 37, -102, 68, -66, -79, -38, -18, 
                68, -114, 31, -25, 90, 16, 122, -74, 88, 32, 
                42, 112, 54, -23, 17, -79, 2, -117, 26, -19, 
                -39, 80
            });

        case 3: // '\003'
            return (new byte[] {
                -10, 34, -49, 3, 69, 49, -70, -48, 4, 49, 
                -75, 70, 46, 13, 17, -123, 0, -91, 70, 10, 
                -121, -90, -37, 78, 73, -45, -119, -20, -17, -83, 
                -20, -104
            });

        case 4: // '\004'
            return (new byte[] {
                43, -50, -93, 17, -57, -113, -57, -69, 72, 30, 
                108, -30, -41, 0, 50, -36, 42, -66, -83, -106, 
                117, 75, -75, 6, -63, 41, 8, 20, -29, -96, 
                101, -85
            });

        case 5: // '\005'
            return (new byte[] {
                -62, 112, 7, -80, 114, -36, 113, 106, 60, -62, 
                9, 37, -125, -54, 56, -118, -52, -67, 85, 90, 
                55, -102, -124, -59, 74, 68, 77, 43, -105, 9, 
                -84, 49
            });

        case 6: // '\006'
            return (new byte[] {
                53, 54, -110, -73, -12, -92, -102, -40, 16, 95, 
                -96, -125, -125, 96, -70, 76, -109, -1, 6, -38, 
                -91, -38, -82, -25, 82, 107, 32, -78, -79, 35, 
                15, 52
            });

        case 7: // '\007'
            return (new byte[] {
                -45, -23, -94, 114, -55, 81, 56, -118, 126, -54, 
                14, -90, 69, -55, 117, -97, 71, 3, -107, -17, 
                -8, 97, 3, 18, -127, 8, 117, 5, -110, 22, 
                59, 13
            });
        }
    }

    private byte[] getHmacKey()
    {
        switch (getKeyset())
        {
        default:
            throw new RuntimeException((new StringBuilder()).append("Unknown keyset: ").append(getKeyset()).toString());

        case 1: // '\001'
        case 2: // '\002'
            return (new byte[] {
                -121, 87, -57, -124, 40, 126, 27, 48, 98, 63, 
                18, -80, -126, -43, -104, -101, 31, 119, -10, -19, 
                109, 31, 108, -3, -63, 67, 37, 117, 77, -81, 
                -105, -14
            });

        case 3: // '\003'
            return (new byte[] {
                41, 33, -109, 105, 94, -27, 21, 73, -85, -99, 
                -127, -37, 23, 36, 113, -71, 53, 21, -70, 13, 
                -16, -109, 111, 97, 108, 116, 30, -103, -83, -109, 
                -24, 97
            });

        case 4: // '\004'
            return (new byte[] {
                -32, -44, 75, 40, -9, -109, 43, 79, 60, -100, 
                88, 114, -51, -79, 27, 58, 52, -24, 31, -118, 
                -117, -37, -39, 68, -48, 81, 77, -112, 96, -7, 
                -86, 101
            });

        case 5: // '\005'
            return (new byte[] {
                -97, -72, 18, -58, 35, -12, -119, 48, -36, -105, 
                -66, -44, -104, 103, 105, -38, 39, 125, -77, -91, 
                -71, -38, -62, -36, 123, -24, -29, -105, -77, 115, 
                -91, 52
            });

        case 6: // '\006'
            return (new byte[] {
                -18, -80, 73, 127, 17, 105, 58, -43, -28, -43, 
                -20, 6, -92, 38, -41, 122, -31, -14, 7, -112, 
                26, -17, 87, 26, 44, -107, -128, -18, 10, 57, 
                -61, -70
            });

        case 7: // '\007'
            return (new byte[] {
                -87, -97, -9, -83, -79, -1, 102, 82, -87, 95, 
                119, -114, -22, 69, 36, -36, -25, 108, -76, -10, 
                -26, -42, 104, 36, -97, -33, -93, -5, 73, 82, 
                1, -116
            });
        }
    }

    private static String toHexString(byte byte0)
    {
        return Integer.toHexString(byte0 & 0xff);
    }

    public String getDeviceCountry()
    {
        ensureUnencrypted();
        if (data[5] == 0 || data[6] == 0)
        {
            return null;
        } else
        {
            return new String(data, 5, 2);
        }
    }

    public String getDeviceLanguage()
    {
        ensureUnencrypted();
        if (data[10] == 0 || data[11] == 0)
        {
            return null;
        } else
        {
            return new String(data, 10, 2);
        }
    }

    public DeviceOs getDeviceOperatingSystem()
    {
        ensureUnencrypted();
        return DeviceOs.values()[data[4]];
    }

    public DeviceType getDeviceType()
    {
        ensureUnencrypted();
        return DeviceType.values()[data[3]];
    }

    public String getEncryptedString()
    {
        ensureEncrypted();
        return Base64.encodeToString(data, 2);
    }

    public short getKeyset()
    {
        short word0 = (short)((short)data[1] << 8);
        return (short)(data[2] & 0xff | word0);
    }

    public String getMobileNetworkCode()
    {
        ensureUnencrypted();
        int j = 0;
        for (int i = 0; i < 3 && data[i + 7] != 0; i++)
        {
            j++;
        }

        if (j == 0)
        {
            return null;
        } else
        {
            return new String(data, 7, j);
        }
    }

    public byte[] getUniqueIdentifier()
    {
        ensureUnencrypted();
        byte abyte0[] = new byte[16];
        System.arraycopy(data, 12, abyte0, 0, 16);
        return abyte0;
    }

    public byte getVersion()
    {
        return data[0];
    }

    public boolean isSupportedVersion()
    {
        return getVersion() == 1;
    }

    public void setDeviceCountry(String s)
    {
        ensureUnencrypted();
        state = State.Unencrypted;
        if (s != null && s.length() == 2)
        {
            s = s.getBytes();
        } else
        {
            s = null;
        }
        if (s == null || s.length != 2)
        {
            s = data;
            data[6] = 0;
            s[5] = 0;
            return;
        } else
        {
            data[5] = s[0];
            data[6] = s[1];
            return;
        }
    }

    public void setDeviceLanguage(String s)
    {
        ensureUnencrypted();
        state = State.Unencrypted;
        if (s != null && s.length() == 2)
        {
            s = s.getBytes();
        } else
        {
            s = null;
        }
        if (s == null || s.length != 2)
        {
            s = data;
            data[11] = 0;
            s[10] = 0;
            return;
        } else
        {
            data[10] = s[0];
            data[11] = s[1];
            return;
        }
    }

    public void setDeviceOperatingSystem(DeviceOs deviceos)
    {
        ensureUnencrypted();
        state = State.Unencrypted;
        data[4] = (byte)deviceos.ordinal();
    }

    public void setDeviceType(DeviceType devicetype)
    {
        ensureUnencrypted();
        state = State.Unencrypted;
        data[3] = (byte)devicetype.ordinal();
    }

    public void setKeyset(short word0)
    {
        ensureUnencrypted();
        state = State.Unencrypted;
        data[1] = (byte)(word0 >> 8 & 0xff);
        data[2] = (byte)(word0 & 0xff);
    }

    public void setMobileNetworkCode(String s)
    {
        ensureUnencrypted();
        state = State.Unencrypted;
        if (!TextUtils.isEmpty(s))
        {
            s = s.getBytes();
        } else
        {
            s = null;
        }
        if (s == null || s.length > 3)
        {
            s = data;
            byte abyte0[] = data;
            data[9] = 0;
            abyte0[8] = 0;
            s[7] = 0;
        } else
        {
            for (int i = 0; i < s.length; i++)
            {
                data[i + 7] = s[i];
            }

            int j = s.length;
            while (j < 3) 
            {
                data[j + 7] = 0;
                j++;
            }
        }
    }

    public void setUniqueIdentifier(byte abyte0[])
    {
        byte abyte1[];
label0:
        {
            ensureUnencrypted();
            state = State.Unencrypted;
            if (abyte0 != null)
            {
                abyte1 = abyte0;
                if (abyte0.length == 16)
                {
                    break label0;
                }
            }
            abyte1 = new byte[16];
        }
        System.arraycopy(abyte1, 0, data, 12, 16);
    }

    public void setVersion(byte byte0)
    {
        ensureUnencrypted();
        state = State.Unencrypted;
        data[0] = byte0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(state);
        if (state != State.Encrypted)
        {
            stringbuilder.append("\nversion = 0x").append(Integer.toHexString(getVersion())).append(",\nkeyset = 0x").append(Integer.toHexString(getKeyset())).append(",\ndeviceType = 0x").append(Integer.toHexString(getDeviceType().ordinal())).append(" (").append(getDeviceType()).append(')').append(",\ndeviceOperatingSystem = 0x").append(Integer.toHexString(getDeviceOperatingSystem().ordinal())).append(" (").append(getDeviceOperatingSystem()).append(')').append(",\ndeviceCountry = {0x").append(toHexString(data[5])).append(", 0x").append(toHexString(data[6])).append('}');
            String s = getDeviceCountry();
            if (s != null)
            {
                stringbuilder.append(" (").append(s).append(')');
            }
            stringbuilder.append(",\nmobileNetworkCode = {0x").append(toHexString(data[7])).append(", 0x").append(toHexString(data[8])).append(", 0x").append(toHexString(data[9])).append('}');
            s = getMobileNetworkCode();
            if (s != null)
            {
                stringbuilder.append(" (").append(s).append(')');
            }
            stringbuilder.append(",\ndeviceLanguage = {0x").append(toHexString(data[10])).append(", 0x").append(toHexString(data[11])).append('}');
            s = getDeviceLanguage();
            if (s != null)
            {
                stringbuilder.append(" (").append(s).append(')');
            }
            stringbuilder.append(",\nuniqueIdentifier = {0x").append(toHexString(data[12]));
            for (int i = 1; i < 16; i++)
            {
                stringbuilder.append(", 0x").append(toHexString(data[i + 12]));
            }

            stringbuilder.append("},\npadding = {0x").append(toHexString(data[28])).append(", 0x").append(toHexString(data[29])).append(", 0x").append(toHexString(data[30])).append('}').append(",\nhmac = {0x").append(toHexString(data[31]));
            for (int j = 1; j < 20; j++)
            {
                stringbuilder.append(", 0x").append(toHexString(data[j + 31]));
            }

            stringbuilder.append('}');
        }
        int k = 0;
        while (k < data.length) 
        {
            String s1;
            if (k % 8 == 0)
            {
                StringBuilder stringbuilder1 = stringbuilder.append('\n');
                int l;
                if (k < 16)
                {
                    s1 = "0x000";
                } else
                {
                    s1 = "0x00";
                }
                stringbuilder1.append(s1).append(Integer.toHexString(k)).append(':');
            }
            l = data[k] & 0xff;
            if (l < 16)
            {
                s1 = " 0x0";
            } else
            {
                s1 = " 0x";
            }
            stringbuilder.append(s1).append(Integer.toHexString(l));
            k++;
        }
        return stringbuilder.toString();
    }

    public boolean verifyHmac()
    {
        boolean flag = false;
        m.ebay.nautilus.kernel.EbayIdentity.Fingerprint4pp.State[state.ordinal()];
        JVM INSTR tableswitch 1 2: default 36
    //                   1 75
    //                   2 77;
           goto _L1 _L2 _L3
_L1:
        data data1 = new <init>();
        System.arraycopy(data, 0, data1.data, 0, 31);
        data1.ensureHmac();
        flag = Arrays.equals(data, data1.data);
_L2:
        return flag;
_L3:
        ensureUnencrypted();
        if (true) goto _L1; else goto _L4
_L4:
    }

    public State()
    {
        data = new byte[51];
        state = State.Unencrypted;
    }

    public State.Unencrypted(String s)
        throws IllegalArgumentException
    {
        data = new byte[51];
        state = State.Unencrypted;
        s = Base64.decode(s, 0);
        if (s == null || s.length != data.length)
        {
            throw new IllegalArgumentException("The string is not in the proper format.");
        } else
        {
            System.arraycopy(s, 0, data, 0, s.length);
            state = State.Encrypted;
            return;
        }
    }
}
