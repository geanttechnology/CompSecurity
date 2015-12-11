// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.extras.Base64;
import cz.msebera.android.httpclient.util.EncodingUtils;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package cz.msebera.android.httpclient.impl.auth:
//            NTLMEngine, NTLMEngineException

final class NTLMEngineImpl
    implements NTLMEngine
{
    protected static class CipherGen
    {

        protected final byte challenge[];
        protected byte clientChallenge[];
        protected byte clientChallenge2[];
        protected final String domain;
        protected byte lanManagerSessionKey[];
        protected byte lm2SessionResponse[];
        protected byte lmHash[];
        protected byte lmResponse[];
        protected byte lmUserSessionKey[];
        protected byte lmv2Hash[];
        protected byte lmv2Response[];
        protected byte ntlm2SessionResponse[];
        protected byte ntlm2SessionResponseUserSessionKey[];
        protected byte ntlmHash[];
        protected byte ntlmResponse[];
        protected byte ntlmUserSessionKey[];
        protected byte ntlmv2Blob[];
        protected byte ntlmv2Hash[];
        protected byte ntlmv2Response[];
        protected byte ntlmv2UserSessionKey[];
        protected final String password;
        protected byte secondaryKey[];
        protected final String target;
        protected final byte targetInformation[];
        protected byte timestamp[];
        protected final String user;

        public byte[] getClientChallenge()
            throws NTLMEngineException
        {
            if (clientChallenge == null)
            {
                clientChallenge = NTLMEngineImpl.makeRandomChallenge();
            }
            return clientChallenge;
        }

        public byte[] getClientChallenge2()
            throws NTLMEngineException
        {
            if (clientChallenge2 == null)
            {
                clientChallenge2 = NTLMEngineImpl.makeRandomChallenge();
            }
            return clientChallenge2;
        }

        public byte[] getLM2SessionResponse()
            throws NTLMEngineException
        {
            if (lm2SessionResponse == null)
            {
                byte abyte0[] = getClientChallenge();
                lm2SessionResponse = new byte[24];
                System.arraycopy(abyte0, 0, lm2SessionResponse, 0, abyte0.length);
                Arrays.fill(lm2SessionResponse, abyte0.length, lm2SessionResponse.length, (byte)0);
            }
            return lm2SessionResponse;
        }

        public byte[] getLMHash()
            throws NTLMEngineException
        {
            if (lmHash == null)
            {
                lmHash = NTLMEngineImpl.lmHash(password);
            }
            return lmHash;
        }

        public byte[] getLMResponse()
            throws NTLMEngineException
        {
            if (lmResponse == null)
            {
                lmResponse = NTLMEngineImpl.lmResponse(getLMHash(), challenge);
            }
            return lmResponse;
        }

        public byte[] getLMUserSessionKey()
            throws NTLMEngineException
        {
            if (lmUserSessionKey == null)
            {
                lmUserSessionKey = new byte[16];
                System.arraycopy(getLMHash(), 0, lmUserSessionKey, 0, 8);
                Arrays.fill(lmUserSessionKey, 8, 16, (byte)0);
            }
            return lmUserSessionKey;
        }

        public byte[] getLMv2Hash()
            throws NTLMEngineException
        {
            if (lmv2Hash == null)
            {
                lmv2Hash = NTLMEngineImpl.lmv2Hash(domain, user, getNTLMHash());
            }
            return lmv2Hash;
        }

        public byte[] getLMv2Response()
            throws NTLMEngineException
        {
            if (lmv2Response == null)
            {
                lmv2Response = NTLMEngineImpl.lmv2Response(getLMv2Hash(), challenge, getClientChallenge());
            }
            return lmv2Response;
        }

        public byte[] getLanManagerSessionKey()
            throws NTLMEngineException
        {
            if (lanManagerSessionKey == null)
            {
                try
                {
                    byte abyte0[] = new byte[14];
                    System.arraycopy(getLMHash(), 0, abyte0, 0, 8);
                    Arrays.fill(abyte0, 8, abyte0.length, (byte)-67);
                    Key key1 = NTLMEngineImpl.createDESKey(abyte0, 0);
                    Key key = NTLMEngineImpl.createDESKey(abyte0, 7);
                    byte abyte1[] = new byte[8];
                    System.arraycopy(getLMResponse(), 0, abyte1, 0, abyte1.length);
                    Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
                    cipher.init(1, key1);
                    byte abyte2[] = cipher.doFinal(abyte1);
                    cipher = Cipher.getInstance("DES/ECB/NoPadding");
                    cipher.init(1, key);
                    key = cipher.doFinal(abyte1);
                    lanManagerSessionKey = new byte[16];
                    System.arraycopy(abyte2, 0, lanManagerSessionKey, 0, abyte2.length);
                    System.arraycopy(key, 0, lanManagerSessionKey, abyte2.length, key.length);
                }
                catch (Exception exception)
                {
                    throw new NTLMEngineException(exception.getMessage(), exception);
                }
            }
            return lanManagerSessionKey;
        }

        public byte[] getNTLM2SessionResponse()
            throws NTLMEngineException
        {
            if (ntlm2SessionResponse == null)
            {
                ntlm2SessionResponse = NTLMEngineImpl.ntlm2SessionResponse(getNTLMHash(), challenge, getClientChallenge());
            }
            return ntlm2SessionResponse;
        }

        public byte[] getNTLM2SessionResponseUserSessionKey()
            throws NTLMEngineException
        {
            if (ntlm2SessionResponseUserSessionKey == null)
            {
                byte abyte0[] = getLM2SessionResponse();
                byte abyte1[] = new byte[challenge.length + abyte0.length];
                System.arraycopy(challenge, 0, abyte1, 0, challenge.length);
                System.arraycopy(abyte0, 0, abyte1, challenge.length, abyte0.length);
                ntlm2SessionResponseUserSessionKey = NTLMEngineImpl.hmacMD5(abyte1, getNTLMUserSessionKey());
            }
            return ntlm2SessionResponseUserSessionKey;
        }

        public byte[] getNTLMHash()
            throws NTLMEngineException
        {
            if (ntlmHash == null)
            {
                ntlmHash = NTLMEngineImpl.ntlmHash(password);
            }
            return ntlmHash;
        }

        public byte[] getNTLMResponse()
            throws NTLMEngineException
        {
            if (ntlmResponse == null)
            {
                ntlmResponse = NTLMEngineImpl.lmResponse(getNTLMHash(), challenge);
            }
            return ntlmResponse;
        }

        public byte[] getNTLMUserSessionKey()
            throws NTLMEngineException
        {
            if (ntlmUserSessionKey == null)
            {
                MD4 md4 = new MD4();
                md4.update(getNTLMHash());
                ntlmUserSessionKey = md4.getOutput();
            }
            return ntlmUserSessionKey;
        }

        public byte[] getNTLMv2Blob()
            throws NTLMEngineException
        {
            if (ntlmv2Blob == null)
            {
                ntlmv2Blob = NTLMEngineImpl.createBlob(getClientChallenge2(), targetInformation, getTimestamp());
            }
            return ntlmv2Blob;
        }

        public byte[] getNTLMv2Hash()
            throws NTLMEngineException
        {
            if (ntlmv2Hash == null)
            {
                ntlmv2Hash = NTLMEngineImpl.ntlmv2Hash(domain, user, getNTLMHash());
            }
            return ntlmv2Hash;
        }

        public byte[] getNTLMv2Response()
            throws NTLMEngineException
        {
            if (ntlmv2Response == null)
            {
                ntlmv2Response = NTLMEngineImpl.lmv2Response(getNTLMv2Hash(), challenge, getNTLMv2Blob());
            }
            return ntlmv2Response;
        }

        public byte[] getNTLMv2UserSessionKey()
            throws NTLMEngineException
        {
            if (ntlmv2UserSessionKey == null)
            {
                byte abyte0[] = getNTLMv2Hash();
                byte abyte1[] = new byte[16];
                System.arraycopy(getNTLMv2Response(), 0, abyte1, 0, 16);
                ntlmv2UserSessionKey = NTLMEngineImpl.hmacMD5(abyte1, abyte0);
            }
            return ntlmv2UserSessionKey;
        }

        public byte[] getSecondaryKey()
            throws NTLMEngineException
        {
            if (secondaryKey == null)
            {
                secondaryKey = NTLMEngineImpl.makeSecondaryKey();
            }
            return secondaryKey;
        }

        public byte[] getTimestamp()
        {
            if (timestamp == null)
            {
                long l = (System.currentTimeMillis() + 0xa9730b66800L) * 10000L;
                timestamp = new byte[8];
                for (int i = 0; i < 8; i++)
                {
                    timestamp[i] = (byte)(int)l;
                    l >>>= 8;
                }

            }
            return timestamp;
        }

        public CipherGen(String s, String s1, String s2, byte abyte0[], String s3, byte abyte1[])
        {
            this(s, s1, s2, abyte0, s3, abyte1, null, null, null, null);
        }

        public CipherGen(String s, String s1, String s2, byte abyte0[], String s3, byte abyte1[], byte abyte2[], 
                byte abyte3[], byte abyte4[], byte abyte5[])
        {
            lmHash = null;
            lmResponse = null;
            ntlmHash = null;
            ntlmResponse = null;
            ntlmv2Hash = null;
            lmv2Hash = null;
            lmv2Response = null;
            ntlmv2Blob = null;
            ntlmv2Response = null;
            ntlm2SessionResponse = null;
            lm2SessionResponse = null;
            lmUserSessionKey = null;
            ntlmUserSessionKey = null;
            ntlmv2UserSessionKey = null;
            ntlm2SessionResponseUserSessionKey = null;
            lanManagerSessionKey = null;
            domain = s;
            target = s3;
            user = s1;
            password = s2;
            challenge = abyte0;
            targetInformation = abyte1;
            clientChallenge = abyte2;
            clientChallenge2 = abyte3;
            secondaryKey = abyte4;
            timestamp = abyte5;
        }
    }

    static class HMACMD5
    {

        protected byte ipad[];
        protected MessageDigest md5;
        protected byte opad[];

        byte[] getOutput()
        {
            byte abyte0[] = md5.digest();
            md5.update(opad);
            return md5.digest(abyte0);
        }

        void update(byte abyte0[])
        {
            md5.update(abyte0);
        }

        void update(byte abyte0[], int i, int j)
        {
            md5.update(abyte0, i, j);
        }

        HMACMD5(byte abyte0[])
            throws NTLMEngineException
        {
            byte abyte1[];
            int i;
            int j;
            int k;
            try
            {
                md5 = MessageDigest.getInstance("MD5");
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new NTLMEngineException((new StringBuilder()).append("Error getting md5 message digest implementation: ").append(abyte0.getMessage()).toString(), abyte0);
            }
            ipad = new byte[64];
            opad = new byte[64];
            i = abyte0.length;
            abyte1 = abyte0;
            j = i;
            if (i > 64)
            {
                md5.update(abyte0);
                abyte1 = md5.digest();
                j = abyte1.length;
            }
            i = 0;
            do
            {
                k = i;
                if (i >= j)
                {
                    break;
                }
                ipad[i] = (byte)(abyte1[i] ^ 0x36);
                opad[i] = (byte)(abyte1[i] ^ 0x5c);
                i++;
            } while (true);
            for (; k < 64; k++)
            {
                ipad[k] = 54;
                opad[k] = 92;
            }

            md5.reset();
            md5.update(ipad);
        }
    }

    static class MD4
    {

        protected int A;
        protected int B;
        protected int C;
        protected int D;
        protected long count;
        protected byte dataBuffer[];

        byte[] getOutput()
        {
            int i = (int)(count & 63L);
            byte abyte0[];
            if (i < 56)
            {
                i = 56 - i;
            } else
            {
                i = 120 - i;
            }
            abyte0 = new byte[i + 8];
            abyte0[0] = -128;
            for (int j = 0; j < 8; j++)
            {
                abyte0[i + j] = (byte)(int)(count * 8L >>> j * 8);
            }

            update(abyte0);
            abyte0 = new byte[16];
            NTLMEngineImpl.writeULong(abyte0, A, 0);
            NTLMEngineImpl.writeULong(abyte0, B, 4);
            NTLMEngineImpl.writeULong(abyte0, C, 8);
            NTLMEngineImpl.writeULong(abyte0, D, 12);
            return abyte0;
        }

        protected void processBuffer()
        {
            int ai[] = new int[16];
            for (int i = 0; i < 16; i++)
            {
                ai[i] = (dataBuffer[i * 4] & 0xff) + ((dataBuffer[i * 4 + 1] & 0xff) << 8) + ((dataBuffer[i * 4 + 2] & 0xff) << 16) + ((dataBuffer[i * 4 + 3] & 0xff) << 24);
            }

            int j = A;
            int k = B;
            int l = C;
            int i1 = D;
            round1(ai);
            round2(ai);
            round3(ai);
            A = A + j;
            B = B + k;
            C = C + l;
            D = D + i1;
        }

        protected void round1(int ai[])
        {
            A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.F(B, C, D) + ai[0], 3);
            D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.F(A, B, C) + ai[1], 7);
            C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.F(D, A, B) + ai[2], 11);
            B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.F(C, D, A) + ai[3], 19);
            A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.F(B, C, D) + ai[4], 3);
            D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.F(A, B, C) + ai[5], 7);
            C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.F(D, A, B) + ai[6], 11);
            B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.F(C, D, A) + ai[7], 19);
            A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.F(B, C, D) + ai[8], 3);
            D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.F(A, B, C) + ai[9], 7);
            C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.F(D, A, B) + ai[10], 11);
            B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.F(C, D, A) + ai[11], 19);
            A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.F(B, C, D) + ai[12], 3);
            D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.F(A, B, C) + ai[13], 7);
            C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.F(D, A, B) + ai[14], 11);
            B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.F(C, D, A) + ai[15], 19);
        }

        protected void round2(int ai[])
        {
            A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.G(B, C, D) + ai[0] + 0x5a827999, 3);
            D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.G(A, B, C) + ai[4] + 0x5a827999, 5);
            C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.G(D, A, B) + ai[8] + 0x5a827999, 9);
            B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.G(C, D, A) + ai[12] + 0x5a827999, 13);
            A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.G(B, C, D) + ai[1] + 0x5a827999, 3);
            D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.G(A, B, C) + ai[5] + 0x5a827999, 5);
            C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.G(D, A, B) + ai[9] + 0x5a827999, 9);
            B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.G(C, D, A) + ai[13] + 0x5a827999, 13);
            A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.G(B, C, D) + ai[2] + 0x5a827999, 3);
            D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.G(A, B, C) + ai[6] + 0x5a827999, 5);
            C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.G(D, A, B) + ai[10] + 0x5a827999, 9);
            B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.G(C, D, A) + ai[14] + 0x5a827999, 13);
            A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.G(B, C, D) + ai[3] + 0x5a827999, 3);
            D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.G(A, B, C) + ai[7] + 0x5a827999, 5);
            C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.G(D, A, B) + ai[11] + 0x5a827999, 9);
            B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.G(C, D, A) + ai[15] + 0x5a827999, 13);
        }

        protected void round3(int ai[])
        {
            A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.H(B, C, D) + ai[0] + 0x6ed9eba1, 3);
            D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.H(A, B, C) + ai[8] + 0x6ed9eba1, 9);
            C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.H(D, A, B) + ai[4] + 0x6ed9eba1, 11);
            B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.H(C, D, A) + ai[12] + 0x6ed9eba1, 15);
            A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.H(B, C, D) + ai[2] + 0x6ed9eba1, 3);
            D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.H(A, B, C) + ai[10] + 0x6ed9eba1, 9);
            C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.H(D, A, B) + ai[6] + 0x6ed9eba1, 11);
            B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.H(C, D, A) + ai[14] + 0x6ed9eba1, 15);
            A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.H(B, C, D) + ai[1] + 0x6ed9eba1, 3);
            D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.H(A, B, C) + ai[9] + 0x6ed9eba1, 9);
            C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.H(D, A, B) + ai[5] + 0x6ed9eba1, 11);
            B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.H(C, D, A) + ai[13] + 0x6ed9eba1, 15);
            A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.H(B, C, D) + ai[3] + 0x6ed9eba1, 3);
            D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.H(A, B, C) + ai[11] + 0x6ed9eba1, 9);
            C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.H(D, A, B) + ai[7] + 0x6ed9eba1, 11);
            B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.H(C, D, A) + ai[15] + 0x6ed9eba1, 15);
        }

        void update(byte abyte0[])
        {
            int j = (int)(count & 63L);
            int i;
            for (i = 0; (abyte0.length - i) + j >= dataBuffer.length;)
            {
                int k = dataBuffer.length - j;
                System.arraycopy(abyte0, i, dataBuffer, j, k);
                count = count + (long)k;
                j = 0;
                i += k;
                processBuffer();
            }

            if (i < abyte0.length)
            {
                int l = abyte0.length - i;
                System.arraycopy(abyte0, i, dataBuffer, j, l);
                count = count + (long)l;
            }
        }

        MD4()
        {
            A = 0x67452301;
            B = 0xefcdab89;
            C = 0x98badcfe;
            D = 0x10325476;
            count = 0L;
            dataBuffer = new byte[64];
        }
    }

    static class NTLMMessage
    {

        private int currentOutputPosition;
        private byte messageContents[];

        protected void addByte(byte byte0)
        {
            messageContents[currentOutputPosition] = byte0;
            currentOutputPosition = currentOutputPosition + 1;
        }

        protected void addBytes(byte abyte0[])
        {
            if (abyte0 != null)
            {
                int j = abyte0.length;
                int i = 0;
                while (i < j) 
                {
                    byte byte0 = abyte0[i];
                    messageContents[currentOutputPosition] = byte0;
                    currentOutputPosition = currentOutputPosition + 1;
                    i++;
                }
            }
        }

        protected void addULong(int i)
        {
            addByte((byte)(i & 0xff));
            addByte((byte)(i >> 8 & 0xff));
            addByte((byte)(i >> 16 & 0xff));
            addByte((byte)(i >> 24 & 0xff));
        }

        protected void addUShort(int i)
        {
            addByte((byte)(i & 0xff));
            addByte((byte)(i >> 8 & 0xff));
        }

        protected int getMessageLength()
        {
            return currentOutputPosition;
        }

        protected int getPreambleLength()
        {
            return NTLMEngineImpl.SIGNATURE.length + 4;
        }

        String getResponse()
        {
            byte abyte0[];
            if (messageContents.length > currentOutputPosition)
            {
                abyte0 = new byte[currentOutputPosition];
                System.arraycopy(messageContents, 0, abyte0, 0, currentOutputPosition);
            } else
            {
                abyte0 = messageContents;
            }
            return EncodingUtils.getAsciiString(Base64.encode(abyte0, 2));
        }

        protected void prepareResponse(int i, int j)
        {
            messageContents = new byte[i];
            currentOutputPosition = 0;
            addBytes(NTLMEngineImpl.SIGNATURE);
            addULong(j);
        }

        protected byte readByte(int i)
            throws NTLMEngineException
        {
            if (messageContents.length < i + 1)
            {
                throw new NTLMEngineException("NTLM: Message too short");
            } else
            {
                return messageContents[i];
            }
        }

        protected void readBytes(byte abyte0[], int i)
            throws NTLMEngineException
        {
            if (messageContents.length < abyte0.length + i)
            {
                throw new NTLMEngineException("NTLM: Message too short");
            } else
            {
                System.arraycopy(messageContents, i, abyte0, 0, abyte0.length);
                return;
            }
        }

        protected byte[] readSecurityBuffer(int i)
            throws NTLMEngineException
        {
            return NTLMEngineImpl.readSecurityBuffer(messageContents, i);
        }

        protected int readULong(int i)
            throws NTLMEngineException
        {
            return NTLMEngineImpl.readULong(messageContents, i);
        }

        protected int readUShort(int i)
            throws NTLMEngineException
        {
            return NTLMEngineImpl.readUShort(messageContents, i);
        }

        NTLMMessage()
        {
            messageContents = null;
            currentOutputPosition = 0;
        }

        NTLMMessage(String s, int i)
            throws NTLMEngineException
        {
            messageContents = null;
            currentOutputPosition = 0;
            messageContents = Base64.decode(EncodingUtils.getBytes(s, "ASCII"), 2);
            if (messageContents.length < NTLMEngineImpl.SIGNATURE.length)
            {
                throw new NTLMEngineException("NTLM message decoding error - packet too short");
            }
            for (int j = 0; j < NTLMEngineImpl.SIGNATURE.length; j++)
            {
                if (messageContents[j] != NTLMEngineImpl.SIGNATURE[j])
                {
                    throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
                }
            }

            int k = readULong(NTLMEngineImpl.SIGNATURE.length);
            if (k != i)
            {
                throw new NTLMEngineException((new StringBuilder()).append("NTLM type ").append(Integer.toString(i)).append(" message expected - instead got type ").append(Integer.toString(k)).toString());
            } else
            {
                currentOutputPosition = messageContents.length;
                return;
            }
        }
    }

    static class Type1Message extends NTLMMessage
    {

        protected byte domainBytes[];
        protected byte hostBytes[];

        String getResponse()
        {
            prepareResponse(40, 1);
            addULong(0xa2088201);
            addUShort(0);
            addUShort(0);
            addULong(40);
            addUShort(0);
            addUShort(0);
            addULong(40);
            addUShort(261);
            addULong(2600);
            addUShort(3840);
            return super.getResponse();
        }

        Type1Message(String s, String s1)
            throws NTLMEngineException
        {
            Object obj = null;
            super();
            String s2;
            try
            {
                s2 = NTLMEngineImpl.convertHost(s1);
                s1 = NTLMEngineImpl.convertDomain(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new NTLMEngineException((new StringBuilder()).append("Unicode unsupported: ").append(s.getMessage()).toString(), s);
            }
            if (s2 == null)
            {
                break MISSING_BLOCK_LABEL_60;
            }
            s = s2.getBytes("ASCII");
_L1:
            hostBytes = s;
            s = obj;
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_54;
            }
            s = s1.toUpperCase(Locale.ENGLISH).getBytes("ASCII");
            domainBytes = s;
            return;
            s = null;
              goto _L1
        }
    }

    static class Type2Message extends NTLMMessage
    {

        protected byte challenge[];
        protected int flags;
        protected String target;
        protected byte targetInfo[];

        byte[] getChallenge()
        {
            return challenge;
        }

        int getFlags()
        {
            return flags;
        }

        String getTarget()
        {
            return target;
        }

        byte[] getTargetInfo()
        {
            return targetInfo;
        }

        Type2Message(String s)
            throws NTLMEngineException
        {
            super(s, 2);
            challenge = new byte[8];
            readBytes(challenge, 24);
            flags = readULong(20);
            if ((flags & 1) == 0)
            {
                throw new NTLMEngineException((new StringBuilder()).append("NTLM type 2 message indicates no support for Unicode. Flags are: ").append(Integer.toString(flags)).toString());
            }
            target = null;
            if (getMessageLength() >= 20)
            {
                s = readSecurityBuffer(12);
                if (s.length != 0)
                {
                    try
                    {
                        target = new String(s, "UnicodeLittleUnmarked");
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        throw new NTLMEngineException(s.getMessage(), s);
                    }
                }
            }
            targetInfo = null;
            if (getMessageLength() >= 48)
            {
                s = readSecurityBuffer(40);
                if (s.length != 0)
                {
                    targetInfo = s;
                }
            }
        }
    }

    static class Type3Message extends NTLMMessage
    {

        protected byte domainBytes[];
        protected byte hostBytes[];
        protected byte lmResp[];
        protected byte ntResp[];
        protected byte sessionKey[];
        protected int type2Flags;
        protected byte userBytes[];

        String getResponse()
        {
            int l = ntResp.length;
            int i1 = lmResp.length;
            int i;
            int j;
            int k;
            int j1;
            int k1;
            int l1;
            int i2;
            int j2;
            int k2;
            if (domainBytes != null)
            {
                i = domainBytes.length;
            } else
            {
                i = 0;
            }
            if (hostBytes != null)
            {
                j = hostBytes.length;
            } else
            {
                j = 0;
            }
            j1 = userBytes.length;
            if (sessionKey != null)
            {
                k = sessionKey.length;
            } else
            {
                k = 0;
            }
            k1 = i1 + 72;
            l1 = k1 + l;
            i2 = l1 + i;
            j2 = i2 + j1;
            k2 = j2 + j;
            prepareResponse(k2 + k, 3);
            addUShort(i1);
            addUShort(i1);
            addULong(72);
            addUShort(l);
            addUShort(l);
            addULong(k1);
            addUShort(i);
            addUShort(i);
            addULong(l1);
            addUShort(j1);
            addUShort(j1);
            addULong(i2);
            addUShort(j);
            addUShort(j);
            addULong(j2);
            addUShort(k);
            addUShort(k);
            addULong(k2);
            addULong(type2Flags & 0x80 | type2Flags & 0x200 | type2Flags & 0x80000 | 0x2000000 | type2Flags & 0x8000 | type2Flags & 0x20 | type2Flags & 0x10 | type2Flags & 0x20000000 | type2Flags & 0x80000000 | type2Flags & 0x40000000 | type2Flags & 0x800000 | type2Flags & 1 | type2Flags & 4);
            addUShort(261);
            addULong(2600);
            addUShort(3840);
            addBytes(lmResp);
            addBytes(ntResp);
            addBytes(domainBytes);
            addBytes(userBytes);
            addBytes(hostBytes);
            if (sessionKey != null)
            {
                addBytes(sessionKey);
            }
            return super.getResponse();
        }

        Type3Message(String s, String s1, String s2, String s3, byte abyte0[], int i, String s4, 
                byte abyte1[])
            throws NTLMEngineException
        {
            String s5;
            type2Flags = i;
            s5 = NTLMEngineImpl.convertHost(s1);
            s1 = NTLMEngineImpl.convertDomain(s);
            s3 = new CipherGen(s1, s2, s3, abyte0, s4, abyte1);
            if ((0x800000 & i) == 0 || abyte1 == null || s4 == null) goto _L2; else goto _L1
_L1:
            ntResp = s3.getNTLMv2Response();
            lmResp = s3.getLMv2Response();
            if ((i & 0x80) == 0) goto _L4; else goto _L3
_L3:
            try
            {
                s = s3.getLanManagerSessionKey();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                ntResp = new byte[0];
                lmResp = s3.getLMResponse();
                if ((i & 0x80) != 0)
                {
                    s = s3.getLanManagerSessionKey();
                } else
                {
                    s = s3.getLMUserSessionKey();
                }
            }
            if ((i & 0x10) != 0)
            {
                if ((0x40000000 & i) != 0)
                {
                    sessionKey = NTLMEngineImpl.RC4(s3.getSecondaryKey(), s);
                } else
                {
                    sessionKey = s;
                }
            } else
            {
                sessionKey = null;
            }
            if (s5 == null) goto _L6; else goto _L5
_L5:
            s = s5.getBytes("UnicodeLittleUnmarked");
_L9:
            hostBytes = s;
            if (s1 == null) goto _L8; else goto _L7
_L7:
            s = s1.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked");
_L10:
            domainBytes = s;
            userBytes = s2.getBytes("UnicodeLittleUnmarked");
            return;
_L4:
            s = s3.getNTLMv2UserSessionKey();
            break MISSING_BLOCK_LABEL_91;
_L2:
            if ((0x80000 & i) == 0)
            {
                break MISSING_BLOCK_LABEL_233;
            }
            ntResp = s3.getNTLM2SessionResponse();
            lmResp = s3.getLM2SessionResponse();
            if ((i & 0x80) == 0)
            {
                break MISSING_BLOCK_LABEL_224;
            }
            s = s3.getLanManagerSessionKey();
            break MISSING_BLOCK_LABEL_91;
            s = s3.getNTLM2SessionResponseUserSessionKey();
            break MISSING_BLOCK_LABEL_91;
            ntResp = s3.getNTLMResponse();
            lmResp = s3.getLMResponse();
            if ((i & 0x80) == 0)
            {
                break MISSING_BLOCK_LABEL_269;
            }
            s = s3.getLanManagerSessionKey();
            break MISSING_BLOCK_LABEL_91;
            s = s3.getNTLMUserSessionKey();
            break MISSING_BLOCK_LABEL_91;
_L6:
            s = null;
              goto _L9
_L8:
            s = null;
              goto _L10
            s;
            throw new NTLMEngineException((new StringBuilder()).append("Unicode not supported: ").append(s.getMessage()).toString(), s);
              goto _L9
        }
    }


    static final String DEFAULT_CHARSET = "ASCII";
    protected static final int FLAG_DOMAIN_PRESENT = 4096;
    protected static final int FLAG_REQUEST_128BIT_KEY_EXCH = 0x20000000;
    protected static final int FLAG_REQUEST_56BIT_ENCRYPTION = 0x80000000;
    protected static final int FLAG_REQUEST_ALWAYS_SIGN = 32768;
    protected static final int FLAG_REQUEST_EXPLICIT_KEY_EXCH = 0x40000000;
    protected static final int FLAG_REQUEST_LAN_MANAGER_KEY = 128;
    protected static final int FLAG_REQUEST_NTLM2_SESSION = 0x80000;
    protected static final int FLAG_REQUEST_NTLMv1 = 512;
    protected static final int FLAG_REQUEST_SEAL = 32;
    protected static final int FLAG_REQUEST_SIGN = 16;
    protected static final int FLAG_REQUEST_TARGET = 4;
    protected static final int FLAG_REQUEST_UNICODE_ENCODING = 1;
    protected static final int FLAG_REQUEST_VERSION = 0x2000000;
    protected static final int FLAG_TARGETINFO_PRESENT = 0x800000;
    protected static final int FLAG_WORKSTATION_PRESENT = 8192;
    private static final SecureRandom RND_GEN;
    private static final byte SIGNATURE[];
    private String credentialCharset;

    NTLMEngineImpl()
    {
        credentialCharset = "ASCII";
    }

    static int F(int i, int j, int k)
    {
        return i & j | ~i & k;
    }

    static int G(int i, int j, int k)
    {
        return i & j | i & k | j & k;
    }

    static int H(int i, int j, int k)
    {
        return i ^ j ^ k;
    }

    static byte[] RC4(byte abyte0[], byte abyte1[])
        throws NTLMEngineException
    {
        try
        {
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(abyte1, "RC4"));
            abyte0 = cipher.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new NTLMEngineException(abyte0.getMessage(), abyte0);
        }
        return abyte0;
    }

    private static String convertDomain(String s)
    {
        return stripDotSuffix(s);
    }

    private static String convertHost(String s)
    {
        return stripDotSuffix(s);
    }

    private static byte[] createBlob(byte abyte0[], byte abyte1[], byte abyte2[])
    {
        byte abyte3[] = new byte[4];
        byte[] _tmp = abyte3;
        abyte3[0] = 1;
        abyte3[1] = 1;
        abyte3[2] = 0;
        abyte3[3] = 0;
        byte abyte4[] = new byte[4];
        byte[] _tmp1 = abyte4;
        abyte4[0] = 0;
        abyte4[1] = 0;
        abyte4[2] = 0;
        abyte4[3] = 0;
        byte abyte5[] = new byte[4];
        byte[] _tmp2 = abyte5;
        abyte5[0] = 0;
        abyte5[1] = 0;
        abyte5[2] = 0;
        abyte5[3] = 0;
        byte abyte6[] = new byte[4];
        byte[] _tmp3 = abyte6;
        abyte6[0] = 0;
        abyte6[1] = 0;
        abyte6[2] = 0;
        abyte6[3] = 0;
        byte abyte7[] = new byte[abyte3.length + abyte4.length + abyte2.length + 8 + abyte5.length + abyte1.length + abyte6.length];
        System.arraycopy(abyte3, 0, abyte7, 0, abyte3.length);
        int i = 0 + abyte3.length;
        System.arraycopy(abyte4, 0, abyte7, i, abyte4.length);
        i += abyte4.length;
        System.arraycopy(abyte2, 0, abyte7, i, abyte2.length);
        i += abyte2.length;
        System.arraycopy(abyte0, 0, abyte7, i, 8);
        i += 8;
        System.arraycopy(abyte5, 0, abyte7, i, abyte5.length);
        i += abyte5.length;
        System.arraycopy(abyte1, 0, abyte7, i, abyte1.length);
        i += abyte1.length;
        System.arraycopy(abyte6, 0, abyte7, i, abyte6.length);
        i = abyte6.length;
        return abyte7;
    }

    private static Key createDESKey(byte abyte0[], int i)
    {
        byte abyte1[] = new byte[7];
        System.arraycopy(abyte0, i, abyte1, 0, 7);
        abyte0 = new byte[8];
        abyte0[0] = abyte1[0];
        abyte0[1] = (byte)(abyte1[0] << 7 | (abyte1[1] & 0xff) >>> 1);
        abyte0[2] = (byte)(abyte1[1] << 6 | (abyte1[2] & 0xff) >>> 2);
        abyte0[3] = (byte)(abyte1[2] << 5 | (abyte1[3] & 0xff) >>> 3);
        abyte0[4] = (byte)(abyte1[3] << 4 | (abyte1[4] & 0xff) >>> 4);
        abyte0[5] = (byte)(abyte1[4] << 3 | (abyte1[5] & 0xff) >>> 5);
        abyte0[6] = (byte)(abyte1[5] << 2 | (abyte1[6] & 0xff) >>> 6);
        abyte0[7] = (byte)(abyte1[6] << 1);
        oddParity(abyte0);
        return new SecretKeySpec(abyte0, "DES");
    }

    static byte[] hmacMD5(byte abyte0[], byte abyte1[])
        throws NTLMEngineException
    {
        abyte1 = new HMACMD5(abyte1);
        abyte1.update(abyte0);
        return abyte1.getOutput();
    }

    private static byte[] lmHash(String s)
        throws NTLMEngineException
    {
        byte abyte1[];
        try
        {
            s = s.toUpperCase(Locale.ENGLISH).getBytes("US-ASCII");
            int i = Math.min(s.length, 14);
            byte abyte0[] = new byte[14];
            System.arraycopy(s, 0, abyte0, 0, i);
            s = createDESKey(abyte0, 0);
            Key key = createDESKey(abyte0, 7);
            abyte1 = "KGS!@#$%".getBytes("US-ASCII");
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(1, s);
            s = cipher.doFinal(abyte1);
            cipher.init(1, key);
            key = cipher.doFinal(abyte1);
            abyte1 = new byte[16];
            System.arraycopy(s, 0, abyte1, 0, 8);
            System.arraycopy(key, 0, abyte1, 8, 8);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NTLMEngineException(s.getMessage(), s);
        }
        return abyte1;
    }

    private static byte[] lmResponse(byte abyte0[], byte abyte1[])
        throws NTLMEngineException
    {
        byte abyte3[];
        try
        {
            abyte3 = new byte[21];
            System.arraycopy(abyte0, 0, abyte3, 0, 16);
            abyte0 = createDESKey(abyte3, 0);
            Key key = createDESKey(abyte3, 7);
            Key key1 = createDESKey(abyte3, 14);
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(1, abyte0);
            abyte0 = cipher.doFinal(abyte1);
            cipher.init(1, key);
            byte abyte2[] = cipher.doFinal(abyte1);
            cipher.init(1, key1);
            abyte1 = cipher.doFinal(abyte1);
            key1 = new byte[24];
            System.arraycopy(abyte0, 0, key1, 0, 8);
            System.arraycopy(abyte2, 0, key1, 8, 8);
            System.arraycopy(abyte1, 0, key1, 16, 8);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new NTLMEngineException(abyte0.getMessage(), abyte0);
        }
        return key1;
    }

    private static byte[] lmv2Hash(String s, String s1, byte abyte0[])
        throws NTLMEngineException
    {
        try
        {
            abyte0 = new HMACMD5(abyte0);
            abyte0.update(s1.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NTLMEngineException((new StringBuilder()).append("Unicode not supported! ").append(s.getMessage()).toString(), s);
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        abyte0.update(s.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked"));
        s = abyte0.getOutput();
        return s;
    }

    private static byte[] lmv2Response(byte abyte0[], byte abyte1[], byte abyte2[])
        throws NTLMEngineException
    {
        abyte0 = new HMACMD5(abyte0);
        abyte0.update(abyte1);
        abyte0.update(abyte2);
        abyte0 = abyte0.getOutput();
        abyte1 = new byte[abyte0.length + abyte2.length];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
        System.arraycopy(abyte2, 0, abyte1, abyte0.length, abyte2.length);
        return abyte1;
    }

    private static byte[] makeRandomChallenge()
        throws NTLMEngineException
    {
        if (RND_GEN == null)
        {
            throw new NTLMEngineException("Random generator not available");
        }
        byte abyte0[] = new byte[8];
        synchronized (RND_GEN)
        {
            RND_GEN.nextBytes(abyte0);
        }
        return abyte0;
        exception;
        securerandom;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static byte[] makeSecondaryKey()
        throws NTLMEngineException
    {
        if (RND_GEN == null)
        {
            throw new NTLMEngineException("Random generator not available");
        }
        byte abyte0[] = new byte[16];
        synchronized (RND_GEN)
        {
            RND_GEN.nextBytes(abyte0);
        }
        return abyte0;
        exception;
        securerandom;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static byte[] ntlm2SessionResponse(byte abyte0[], byte abyte1[], byte abyte2[])
        throws NTLMEngineException
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(abyte1);
            messagedigest.update(abyte2);
            abyte1 = messagedigest.digest();
            abyte2 = new byte[8];
            System.arraycopy(abyte1, 0, abyte2, 0, 8);
            abyte0 = lmResponse(abyte0, abyte2);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            if (abyte0 instanceof NTLMEngineException)
            {
                throw (NTLMEngineException)abyte0;
            } else
            {
                throw new NTLMEngineException(abyte0.getMessage(), abyte0);
            }
        }
        return abyte0;
    }

    private static byte[] ntlmHash(String s)
        throws NTLMEngineException
    {
        try
        {
            s = s.getBytes("UnicodeLittleUnmarked");
            MD4 md4 = new MD4();
            md4.update(s);
            s = md4.getOutput();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NTLMEngineException((new StringBuilder()).append("Unicode not supported: ").append(s.getMessage()).toString(), s);
        }
        return s;
    }

    private static byte[] ntlmv2Hash(String s, String s1, byte abyte0[])
        throws NTLMEngineException
    {
        try
        {
            abyte0 = new HMACMD5(abyte0);
            abyte0.update(s1.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NTLMEngineException((new StringBuilder()).append("Unicode not supported! ").append(s.getMessage()).toString(), s);
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        abyte0.update(s.getBytes("UnicodeLittleUnmarked"));
        s = abyte0.getOutput();
        return s;
    }

    private static void oddParity(byte abyte0[])
    {
        int i = 0;
        while (i < abyte0.length) 
        {
            byte byte0 = abyte0[i];
            boolean flag;
            if (((byte0 >>> 7 ^ byte0 >>> 6 ^ byte0 >>> 5 ^ byte0 >>> 4 ^ byte0 >>> 3 ^ byte0 >>> 2 ^ byte0 >>> 1) & 1) == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                abyte0[i] = (byte)(abyte0[i] | 1);
            } else
            {
                abyte0[i] = (byte)(abyte0[i] & -2);
            }
            i++;
        }
    }

    private static byte[] readSecurityBuffer(byte abyte0[], int i)
        throws NTLMEngineException
    {
        int j = readUShort(abyte0, i);
        i = readULong(abyte0, i + 4);
        if (abyte0.length < i + j)
        {
            throw new NTLMEngineException("NTLM authentication - buffer too small for data item");
        } else
        {
            byte abyte1[] = new byte[j];
            System.arraycopy(abyte0, i, abyte1, 0, j);
            return abyte1;
        }
    }

    private static int readULong(byte abyte0[], int i)
        throws NTLMEngineException
    {
        if (abyte0.length < i + 4)
        {
            throw new NTLMEngineException("NTLM authentication - buffer too small for DWORD");
        } else
        {
            return abyte0[i] & 0xff | (abyte0[i + 1] & 0xff) << 8 | (abyte0[i + 2] & 0xff) << 16 | (abyte0[i + 3] & 0xff) << 24;
        }
    }

    private static int readUShort(byte abyte0[], int i)
        throws NTLMEngineException
    {
        if (abyte0.length < i + 2)
        {
            throw new NTLMEngineException("NTLM authentication - buffer too small for WORD");
        } else
        {
            return abyte0[i] & 0xff | (abyte0[i + 1] & 0xff) << 8;
        }
    }

    static int rotintlft(int i, int j)
    {
        return i << j | i >>> 32 - j;
    }

    private static String stripDotSuffix(String s)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            int i = s.indexOf(".");
            s1 = s;
            if (i != -1)
            {
                return s.substring(0, i);
            }
        }
        return s1;
    }

    static void writeULong(byte abyte0[], int i, int j)
    {
        abyte0[j] = (byte)(i & 0xff);
        abyte0[j + 1] = (byte)(i >> 8 & 0xff);
        abyte0[j + 2] = (byte)(i >> 16 & 0xff);
        abyte0[j + 3] = (byte)(i >> 24 & 0xff);
    }

    public String generateType1Msg(String s, String s1)
        throws NTLMEngineException
    {
        return getType1Message(s1, s);
    }

    public String generateType3Msg(String s, String s1, String s2, String s3, String s4)
        throws NTLMEngineException
    {
        s4 = new Type2Message(s4);
        return getType3Message(s, s1, s3, s2, s4.getChallenge(), s4.getFlags(), s4.getTarget(), s4.getTargetInfo());
    }

    String getCredentialCharset()
    {
        return credentialCharset;
    }

    final String getResponseFor(String s, String s1, String s2, String s3, String s4)
        throws NTLMEngineException
    {
        if (s == null || s.trim().equals(""))
        {
            return getType1Message(s3, s4);
        } else
        {
            s = new Type2Message(s);
            return getType3Message(s1, s2, s3, s4, s.getChallenge(), s.getFlags(), s.getTarget(), s.getTargetInfo());
        }
    }

    String getType1Message(String s, String s1)
        throws NTLMEngineException
    {
        return (new Type1Message(s1, s)).getResponse();
    }

    String getType3Message(String s, String s1, String s2, String s3, byte abyte0[], int i, String s4, 
            byte abyte1[])
        throws NTLMEngineException
    {
        return (new Type3Message(s3, s2, s, s1, abyte0, i, s4, abyte1)).getResponse();
    }

    void setCredentialCharset(String s)
    {
        credentialCharset = s;
    }

    static 
    {
        SecureRandom securerandom = null;
        SecureRandom securerandom1 = SecureRandom.getInstance("SHA1PRNG");
        securerandom = securerandom1;
_L2:
        RND_GEN = securerandom;
        byte abyte0[] = EncodingUtils.getBytes("NTLMSSP", "ASCII");
        SIGNATURE = new byte[abyte0.length + 1];
        System.arraycopy(abyte0, 0, SIGNATURE, 0, abyte0.length);
        SIGNATURE[abyte0.length] = 0;
        return;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }
















}
