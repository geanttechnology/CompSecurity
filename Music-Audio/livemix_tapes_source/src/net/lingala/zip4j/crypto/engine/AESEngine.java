// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.crypto.engine;

import java.lang.reflect.Array;
import net.lingala.zip4j.exception.ZipException;

public class AESEngine
{

    private static final byte S[];
    private static final int T0[];
    private static final int rcon[] = {
        1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 
        108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 
        151, 53, 106, 212, 179, 125, 250, 239, 197, 145
    };
    private int C0;
    private int C1;
    private int C2;
    private int C3;
    private int rounds;
    private int workingKey[][];

    public AESEngine(byte abyte0[])
        throws ZipException
    {
        workingKey = null;
        init(abyte0);
    }

    private final void encryptBlock(int ai[][])
    {
        C0 = C0 ^ ai[0][0];
        C1 = C1 ^ ai[0][1];
        C2 = C2 ^ ai[0][2];
        C3 = C3 ^ ai[0][3];
        int i = 1;
        do
        {
            if (i >= rounds - 1)
            {
                int j = T0[C0 & 0xff] ^ shift(T0[C1 >> 8 & 0xff], 24) ^ shift(T0[C2 >> 16 & 0xff], 16) ^ shift(T0[C3 >> 24 & 0xff], 8) ^ ai[i][0];
                int l = T0[C1 & 0xff] ^ shift(T0[C2 >> 8 & 0xff], 24) ^ shift(T0[C3 >> 16 & 0xff], 16) ^ shift(T0[C0 >> 24 & 0xff], 8) ^ ai[i][1];
                int j1 = T0[C2 & 0xff] ^ shift(T0[C3 >> 8 & 0xff], 24) ^ shift(T0[C0 >> 16 & 0xff], 16) ^ shift(T0[C1 >> 24 & 0xff], 8) ^ ai[i][2];
                int j2 = T0[C3 & 0xff];
                int l2 = shift(T0[C0 >> 8 & 0xff], 24);
                int j3 = shift(T0[C1 >> 16 & 0xff], 16);
                int l3 = shift(T0[C2 >> 24 & 0xff], 8);
                int l1 = i + 1;
                i = j2 ^ l2 ^ j3 ^ l3 ^ ai[i][3];
                C0 = S[j & 0xff] & 0xff ^ (S[l >> 8 & 0xff] & 0xff) << 8 ^ (S[j1 >> 16 & 0xff] & 0xff) << 16 ^ S[i >> 24 & 0xff] << 24 ^ ai[l1][0];
                C1 = S[l & 0xff] & 0xff ^ (S[j1 >> 8 & 0xff] & 0xff) << 8 ^ (S[i >> 16 & 0xff] & 0xff) << 16 ^ S[j >> 24 & 0xff] << 24 ^ ai[l1][1];
                C2 = S[j1 & 0xff] & 0xff ^ (S[i >> 8 & 0xff] & 0xff) << 8 ^ (S[j >> 16 & 0xff] & 0xff) << 16 ^ S[l >> 24 & 0xff] << 24 ^ ai[l1][2];
                C3 = S[i & 0xff] & 0xff ^ (S[j >> 8 & 0xff] & 0xff) << 8 ^ (S[l >> 16 & 0xff] & 0xff) << 16 ^ S[j1 >> 24 & 0xff] << 24 ^ ai[l1][3];
                return;
            }
            int i2 = T0[C0 & 0xff] ^ shift(T0[C1 >> 8 & 0xff], 24) ^ shift(T0[C2 >> 16 & 0xff], 16) ^ shift(T0[C3 >> 24 & 0xff], 8) ^ ai[i][0];
            int k1 = T0[C1 & 0xff] ^ shift(T0[C2 >> 8 & 0xff], 24) ^ shift(T0[C3 >> 16 & 0xff], 16) ^ shift(T0[C0 >> 24 & 0xff], 8) ^ ai[i][1];
            int i1 = T0[C2 & 0xff] ^ shift(T0[C3 >> 8 & 0xff], 24) ^ shift(T0[C0 >> 16 & 0xff], 16) ^ shift(T0[C1 >> 24 & 0xff], 8) ^ ai[i][2];
            int k2 = T0[C3 & 0xff];
            int i3 = shift(T0[C0 >> 8 & 0xff], 24);
            int k3 = shift(T0[C1 >> 16 & 0xff], 16);
            int i4 = shift(T0[C2 >> 24 & 0xff], 8);
            int k = i + 1;
            i = k2 ^ i3 ^ k3 ^ i4 ^ ai[i][3];
            C0 = T0[i2 & 0xff] ^ shift(T0[k1 >> 8 & 0xff], 24) ^ shift(T0[i1 >> 16 & 0xff], 16) ^ shift(T0[i >> 24 & 0xff], 8) ^ ai[k][0];
            C1 = T0[k1 & 0xff] ^ shift(T0[i1 >> 8 & 0xff], 24) ^ shift(T0[i >> 16 & 0xff], 16) ^ shift(T0[i2 >> 24 & 0xff], 8) ^ ai[k][1];
            C2 = T0[i1 & 0xff] ^ shift(T0[i >> 8 & 0xff], 24) ^ shift(T0[i2 >> 16 & 0xff], 16) ^ shift(T0[k1 >> 24 & 0xff], 8) ^ ai[k][2];
            k2 = T0[i & 0xff];
            i2 = shift(T0[i2 >> 8 & 0xff], 24);
            k1 = shift(T0[k1 >> 16 & 0xff], 16);
            i1 = shift(T0[i1 >> 24 & 0xff], 8);
            i = k + 1;
            C3 = k2 ^ i2 ^ k1 ^ i1 ^ ai[k][3];
        } while (true);
    }

    private int[][] generateWorkingKey(byte abyte0[])
        throws ZipException
    {
        int ai[][];
        int i;
        int k;
        int l;
        l = abyte0.length / 4;
        if (l != 4 && l != 6 && l != 8 || l * 4 != abyte0.length)
        {
            throw new ZipException("invalid key length (not 128/192/256)");
        }
        rounds = l + 6;
        i = rounds;
        ai = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            i + 1, 4
        });
        i = 0;
        k = 0;
_L3:
        if (k < abyte0.length) goto _L2; else goto _L1
_L1:
        int j1;
        j1 = rounds;
        k = l;
_L4:
        if (k >= j1 + 1 << 2)
        {
            return ai;
        }
        break MISSING_BLOCK_LABEL_186;
_L2:
        ai[i >> 2][i & 3] = abyte0[k] & 0xff | (abyte0[k + 1] & 0xff) << 8 | (abyte0[k + 2] & 0xff) << 16 | abyte0[k + 3] << 24;
        k += 4;
        i++;
          goto _L3
        int i1 = ai[k - 1 >> 2][k - 1 & 3];
        int j;
        if (k % l == 0)
        {
            j = subWord(shift(i1, 8)) ^ rcon[k / l - 1];
        } else
        {
            j = i1;
            if (l > 6)
            {
                j = i1;
                if (k % l == 4)
                {
                    j = subWord(i1);
                }
            }
        }
        ai[k >> 2][k & 3] = ai[k - l >> 2][k - l & 3] ^ j;
        k++;
          goto _L4
    }

    private int shift(int i, int j)
    {
        return i >>> j | i << -j;
    }

    private final void stateIn(byte abyte0[], int i)
    {
        int j = i + 1;
        C0 = abyte0[i] & 0xff;
        int k = C0;
        i = j + 1;
        C0 = k | (abyte0[j] & 0xff) << 8;
        k = C0;
        j = i + 1;
        C0 = k | (abyte0[i] & 0xff) << 16;
        k = C0;
        i = j + 1;
        C0 = k | abyte0[j] << 24;
        j = i + 1;
        C1 = abyte0[i] & 0xff;
        k = C1;
        i = j + 1;
        C1 = k | (abyte0[j] & 0xff) << 8;
        k = C1;
        j = i + 1;
        C1 = k | (abyte0[i] & 0xff) << 16;
        k = C1;
        i = j + 1;
        C1 = k | abyte0[j] << 24;
        j = i + 1;
        C2 = abyte0[i] & 0xff;
        k = C2;
        i = j + 1;
        C2 = k | (abyte0[j] & 0xff) << 8;
        k = C2;
        j = i + 1;
        C2 = k | (abyte0[i] & 0xff) << 16;
        k = C2;
        i = j + 1;
        C2 = k | abyte0[j] << 24;
        j = i + 1;
        C3 = abyte0[i] & 0xff;
        k = C3;
        i = j + 1;
        C3 = k | (abyte0[j] & 0xff) << 8;
        j = C3;
        k = i + 1;
        C3 = j | (abyte0[i] & 0xff) << 16;
        C3 = C3 | abyte0[k] << 24;
    }

    private final void stateOut(byte abyte0[], int i)
    {
        int j = i + 1;
        abyte0[i] = (byte)C0;
        i = j + 1;
        abyte0[j] = (byte)(C0 >> 8);
        j = i + 1;
        abyte0[i] = (byte)(C0 >> 16);
        i = j + 1;
        abyte0[j] = (byte)(C0 >> 24);
        j = i + 1;
        abyte0[i] = (byte)C1;
        i = j + 1;
        abyte0[j] = (byte)(C1 >> 8);
        j = i + 1;
        abyte0[i] = (byte)(C1 >> 16);
        i = j + 1;
        abyte0[j] = (byte)(C1 >> 24);
        j = i + 1;
        abyte0[i] = (byte)C2;
        i = j + 1;
        abyte0[j] = (byte)(C2 >> 8);
        j = i + 1;
        abyte0[i] = (byte)(C2 >> 16);
        i = j + 1;
        abyte0[j] = (byte)(C2 >> 24);
        j = i + 1;
        abyte0[i] = (byte)C3;
        i = j + 1;
        abyte0[j] = (byte)(C3 >> 8);
        j = i + 1;
        abyte0[i] = (byte)(C3 >> 16);
        abyte0[j] = (byte)(C3 >> 24);
    }

    private int subWord(int i)
    {
        return S[i & 0xff] & 0xff | (S[i >> 8 & 0xff] & 0xff) << 8 | (S[i >> 16 & 0xff] & 0xff) << 16 | S[i >> 24 & 0xff] << 24;
    }

    public void init(byte abyte0[])
        throws ZipException
    {
        workingKey = generateWorkingKey(abyte0);
    }

    public int processBlock(byte abyte0[], int i, byte abyte1[], int j)
        throws ZipException
    {
        if (workingKey == null)
        {
            throw new ZipException("AES engine not initialised");
        }
        if (i + 16 > abyte0.length)
        {
            throw new ZipException("input buffer too short");
        }
        if (j + 16 > abyte1.length)
        {
            throw new ZipException("output buffer too short");
        } else
        {
            stateIn(abyte0, i);
            encryptBlock(workingKey);
            stateOut(abyte1, j);
            return 16;
        }
    }

    public int processBlock(byte abyte0[], byte abyte1[])
        throws ZipException
    {
        return processBlock(abyte0, 0, abyte1, 0);
    }

    static 
    {
        int ai[] = new byte[256];
        ai[0] = 99;
        ai[1] = 124;
        ai[2] = 119;
        ai[3] = 123;
        ai[4] = -14;
        ai[5] = 107;
        ai[6] = 111;
        ai[7] = -59;
        ai[8] = 48;
        ai[9] = 1;
        ai[10] = 103;
        ai[11] = 43;
        ai[12] = -2;
        ai[13] = -41;
        ai[14] = -85;
        ai[15] = 118;
        ai[16] = -54;
        ai[17] = -126;
        ai[18] = -55;
        ai[19] = 125;
        ai[20] = -6;
        ai[21] = 89;
        ai[22] = 71;
        ai[23] = -16;
        ai[24] = -83;
        ai[25] = -44;
        ai[26] = -94;
        ai[27] = -81;
        ai[28] = -100;
        ai[29] = -92;
        ai[30] = 114;
        ai[31] = -64;
        ai[32] = -73;
        ai[33] = -3;
        ai[34] = -109;
        ai[35] = 38;
        ai[36] = 54;
        ai[37] = 63;
        ai[38] = -9;
        ai[39] = -52;
        ai[40] = 52;
        ai[41] = -91;
        ai[42] = -27;
        ai[43] = -15;
        ai[44] = 113;
        ai[45] = -40;
        ai[46] = 49;
        ai[47] = 21;
        ai[48] = 4;
        ai[49] = -57;
        ai[50] = 35;
        ai[51] = -61;
        ai[52] = 24;
        ai[53] = -106;
        ai[54] = 5;
        ai[55] = -102;
        ai[56] = 7;
        ai[57] = 18;
        ai[58] = -128;
        ai[59] = -30;
        ai[60] = -21;
        ai[61] = 39;
        ai[62] = -78;
        ai[63] = 117;
        ai[64] = 9;
        ai[65] = -125;
        ai[66] = 44;
        ai[67] = 26;
        ai[68] = 27;
        ai[69] = 110;
        ai[70] = 90;
        ai[71] = -96;
        ai[72] = 82;
        ai[73] = 59;
        ai[74] = -42;
        ai[75] = -77;
        ai[76] = 41;
        ai[77] = -29;
        ai[78] = 47;
        ai[79] = -124;
        ai[80] = 83;
        ai[81] = -47;
        ai[83] = -19;
        ai[84] = 32;
        ai[85] = -4;
        ai[86] = -79;
        ai[87] = 91;
        ai[88] = 106;
        ai[89] = -53;
        ai[90] = -66;
        ai[91] = 57;
        ai[92] = 74;
        ai[93] = 76;
        ai[94] = 88;
        ai[95] = -49;
        ai[96] = -48;
        ai[97] = -17;
        ai[98] = -86;
        ai[99] = -5;
        ai[100] = 67;
        ai[101] = 77;
        ai[102] = 51;
        ai[103] = -123;
        ai[104] = 69;
        ai[105] = -7;
        ai[106] = 2;
        ai[107] = 127;
        ai[108] = 80;
        ai[109] = 60;
        ai[110] = -97;
        ai[111] = -88;
        ai[112] = 81;
        ai[113] = -93;
        ai[114] = 64;
        ai[115] = -113;
        ai[116] = -110;
        ai[117] = -99;
        ai[118] = 56;
        ai[119] = -11;
        ai[120] = -68;
        ai[121] = -74;
        ai[122] = -38;
        ai[123] = 33;
        ai[124] = 16;
        ai[125] = -1;
        ai[126] = -13;
        ai[127] = -46;
        ai[128] = -51;
        ai[129] = 12;
        ai[130] = 19;
        ai[131] = -20;
        ai[132] = 95;
        ai[133] = -105;
        ai[134] = 68;
        ai[135] = 23;
        ai[136] = -60;
        ai[137] = -89;
        ai[138] = 126;
        ai[139] = 61;
        ai[140] = 100;
        ai[141] = 93;
        ai[142] = 25;
        ai[143] = 115;
        ai[144] = 96;
        ai[145] = -127;
        ai[146] = 79;
        ai[147] = -36;
        ai[148] = 34;
        ai[149] = 42;
        ai[150] = -112;
        ai[151] = -120;
        ai[152] = 70;
        ai[153] = -18;
        ai[154] = -72;
        ai[155] = 20;
        ai[156] = -34;
        ai[157] = 94;
        ai[158] = 11;
        ai[159] = -37;
        ai[160] = -32;
        ai[161] = 50;
        ai[162] = 58;
        ai[163] = 10;
        ai[164] = 73;
        ai[165] = 6;
        ai[166] = 36;
        ai[167] = 92;
        ai[168] = -62;
        ai[169] = -45;
        ai[170] = -84;
        ai[171] = 98;
        ai[172] = -111;
        ai[173] = -107;
        ai[174] = -28;
        ai[175] = 121;
        ai[176] = -25;
        ai[177] = -56;
        ai[178] = 55;
        ai[179] = 109;
        ai[180] = -115;
        ai[181] = -43;
        ai[182] = 78;
        ai[183] = -87;
        ai[184] = 108;
        ai[185] = 86;
        ai[186] = -12;
        ai[187] = -22;
        ai[188] = 101;
        ai[189] = 122;
        ai[190] = -82;
        ai[191] = 8;
        ai[192] = -70;
        ai[193] = 120;
        ai[194] = 37;
        ai[195] = 46;
        ai[196] = 28;
        ai[197] = -90;
        ai[198] = -76;
        ai[199] = -58;
        ai[200] = -24;
        ai[201] = -35;
        ai[202] = 116;
        ai[203] = 31;
        ai[204] = 75;
        ai[205] = -67;
        ai[206] = -117;
        ai[207] = -118;
        ai[208] = 112;
        ai[209] = 62;
        ai[210] = -75;
        ai[211] = 102;
        ai[212] = 72;
        ai[213] = 3;
        ai[214] = -10;
        ai[215] = 14;
        ai[216] = 97;
        ai[217] = 53;
        ai[218] = 87;
        ai[219] = -71;
        ai[220] = -122;
        ai[221] = -63;
        ai[222] = 29;
        ai[223] = -98;
        ai[224] = -31;
        ai[225] = -8;
        ai[226] = -104;
        ai[227] = 17;
        ai[228] = 105;
        ai[229] = -39;
        ai[230] = -114;
        ai[231] = -108;
        ai[232] = -101;
        ai[233] = 30;
        ai[234] = -121;
        ai[235] = -23;
        ai[236] = -50;
        ai[237] = 85;
        ai[238] = 40;
        ai[239] = -33;
        ai[240] = -116;
        ai[241] = -95;
        ai[242] = -119;
        ai[243] = 13;
        ai[244] = -65;
        ai[245] = -26;
        ai[246] = 66;
        ai[247] = 104;
        ai[248] = 65;
        ai[249] = -103;
        ai[250] = 45;
        ai[251] = 15;
        ai[252] = -80;
        ai[253] = 84;
        ai[254] = -69;
        ai[255] = 22;
        S = ai;
        ai = new int[256];
        ai[0] = 0xa56363c6;
        ai[1] = 0x847c7cf8;
        ai[2] = 0x997777ee;
        ai[3] = 0x8d7b7bf6;
        ai[4] = 0xdf2f2ff;
        ai[5] = 0xbd6b6bd6;
        ai[6] = 0xb16f6fde;
        ai[7] = 0x54c5c591;
        ai[8] = 0x50303060;
        ai[9] = 0x3010102;
        ai[10] = 0xa96767ce;
        ai[11] = 0x7d2b2b56;
        ai[12] = 0x19fefee7;
        ai[13] = 0x62d7d7b5;
        ai[14] = 0xe6abab4d;
        ai[15] = 0x9a7676ec;
        ai[16] = 0x45caca8f;
        ai[17] = 0x9d82821f;
        ai[18] = 0x40c9c989;
        ai[19] = 0x877d7dfa;
        ai[20] = 0x15fafaef;
        ai[21] = 0xeb5959b2;
        ai[22] = 0xc947478e;
        ai[23] = 0xbf0f0fb;
        ai[24] = 0xecadad41;
        ai[25] = 0x67d4d4b3;
        ai[26] = 0xfda2a25f;
        ai[27] = 0xeaafaf45;
        ai[28] = 0xbf9c9c23;
        ai[29] = 0xf7a4a453;
        ai[30] = 0x967272e4;
        ai[31] = 0x5bc0c09b;
        ai[32] = 0xc2b7b775;
        ai[33] = 0x1cfdfde1;
        ai[34] = 0xae93933d;
        ai[35] = 0x6a26264c;
        ai[36] = 0x5a36366c;
        ai[37] = 0x413f3f7e;
        ai[38] = 0x2f7f7f5;
        ai[39] = 0x4fcccc83;
        ai[40] = 0x5c343468;
        ai[41] = 0xf4a5a551;
        ai[42] = 0x34e5e5d1;
        ai[43] = 0x8f1f1f9;
        ai[44] = 0x937171e2;
        ai[45] = 0x73d8d8ab;
        ai[46] = 0x53313162;
        ai[47] = 0x3f15152a;
        ai[48] = 0xc040408;
        ai[49] = 0x52c7c795;
        ai[50] = 0x65232346;
        ai[51] = 0x5ec3c39d;
        ai[52] = 0x28181830;
        ai[53] = 0xa1969637;
        ai[54] = 0xf05050a;
        ai[55] = 0xb59a9a2f;
        ai[56] = 0x907070e;
        ai[57] = 0x36121224;
        ai[58] = 0x9b80801b;
        ai[59] = 0x3de2e2df;
        ai[60] = 0x26ebebcd;
        ai[61] = 0x6927274e;
        ai[62] = 0xcdb2b27f;
        ai[63] = 0x9f7575ea;
        ai[64] = 0x1b090912;
        ai[65] = 0x9e83831d;
        ai[66] = 0x742c2c58;
        ai[67] = 0x2e1a1a34;
        ai[68] = 0x2d1b1b36;
        ai[69] = 0xb26e6edc;
        ai[70] = 0xee5a5ab4;
        ai[71] = 0xfba0a05b;
        ai[72] = 0xf65252a4;
        ai[73] = 0x4d3b3b76;
        ai[74] = 0x61d6d6b7;
        ai[75] = 0xceb3b37d;
        ai[76] = 0x7b292952;
        ai[77] = 0x3ee3e3dd;
        ai[78] = 0x712f2f5e;
        ai[79] = 0x97848413;
        ai[80] = 0xf55353a6;
        ai[81] = 0x68d1d1b9;
        ai[83] = 0x2cededc1;
        ai[84] = 0x60202040;
        ai[85] = 0x1ffcfce3;
        ai[86] = 0xc8b1b179;
        ai[87] = 0xed5b5bb6;
        ai[88] = 0xbe6a6ad4;
        ai[89] = 0x46cbcb8d;
        ai[90] = 0xd9bebe67;
        ai[91] = 0x4b393972;
        ai[92] = 0xde4a4a94;
        ai[93] = 0xd44c4c98;
        ai[94] = 0xe85858b0;
        ai[95] = 0x4acfcf85;
        ai[96] = 0x6bd0d0bb;
        ai[97] = 0x2aefefc5;
        ai[98] = 0xe5aaaa4f;
        ai[99] = 0x16fbfbed;
        ai[100] = 0xc5434386;
        ai[101] = 0xd74d4d9a;
        ai[102] = 0x55333366;
        ai[103] = 0x94858511;
        ai[104] = 0xcf45458a;
        ai[105] = 0x10f9f9e9;
        ai[106] = 0x6020204;
        ai[107] = 0x817f7ffe;
        ai[108] = 0xf05050a0;
        ai[109] = 0x443c3c78;
        ai[110] = 0xba9f9f25;
        ai[111] = 0xe3a8a84b;
        ai[112] = 0xf35151a2;
        ai[113] = 0xfea3a35d;
        ai[114] = 0xc0404080;
        ai[115] = 0x8a8f8f05;
        ai[116] = 0xad92923f;
        ai[117] = 0xbc9d9d21;
        ai[118] = 0x48383870;
        ai[119] = 0x4f5f5f1;
        ai[120] = 0xdfbcbc63;
        ai[121] = 0xc1b6b677;
        ai[122] = 0x75dadaaf;
        ai[123] = 0x63212142;
        ai[124] = 0x30101020;
        ai[125] = 0x1affffe5;
        ai[126] = 0xef3f3fd;
        ai[127] = 0x6dd2d2bf;
        ai[128] = 0x4ccdcd81;
        ai[129] = 0x140c0c18;
        ai[130] = 0x35131326;
        ai[131] = 0x2fececc3;
        ai[132] = 0xe15f5fbe;
        ai[133] = 0xa2979735;
        ai[134] = 0xcc444488;
        ai[135] = 0x3917172e;
        ai[136] = 0x57c4c493;
        ai[137] = 0xf2a7a755;
        ai[138] = 0x827e7efc;
        ai[139] = 0x473d3d7a;
        ai[140] = 0xac6464c8;
        ai[141] = 0xe75d5dba;
        ai[142] = 0x2b191932;
        ai[143] = 0x957373e6;
        ai[144] = 0xa06060c0;
        ai[145] = 0x98818119;
        ai[146] = 0xd14f4f9e;
        ai[147] = 0x7fdcdca3;
        ai[148] = 0x66222244;
        ai[149] = 0x7e2a2a54;
        ai[150] = 0xab90903b;
        ai[151] = 0x8388880b;
        ai[152] = 0xca46468c;
        ai[153] = 0x29eeeec7;
        ai[154] = 0xd3b8b86b;
        ai[155] = 0x3c141428;
        ai[156] = 0x79dedea7;
        ai[157] = 0xe25e5ebc;
        ai[158] = 0x1d0b0b16;
        ai[159] = 0x76dbdbad;
        ai[160] = 0x3be0e0db;
        ai[161] = 0x56323264;
        ai[162] = 0x4e3a3a74;
        ai[163] = 0x1e0a0a14;
        ai[164] = 0xdb494992;
        ai[165] = 0xa06060c;
        ai[166] = 0x6c242448;
        ai[167] = 0xe45c5cb8;
        ai[168] = 0x5dc2c29f;
        ai[169] = 0x6ed3d3bd;
        ai[170] = 0xefacac43;
        ai[171] = 0xa66262c4;
        ai[172] = 0xa8919139;
        ai[173] = 0xa4959531;
        ai[174] = 0x37e4e4d3;
        ai[175] = 0x8b7979f2;
        ai[176] = 0x32e7e7d5;
        ai[177] = 0x43c8c88b;
        ai[178] = 0x5937376e;
        ai[179] = 0xb76d6dda;
        ai[180] = 0x8c8d8d01;
        ai[181] = 0x64d5d5b1;
        ai[182] = 0xd24e4e9c;
        ai[183] = 0xe0a9a949;
        ai[184] = 0xb46c6cd8;
        ai[185] = 0xfa5656ac;
        ai[186] = 0x7f4f4f3;
        ai[187] = 0x25eaeacf;
        ai[188] = 0xaf6565ca;
        ai[189] = 0x8e7a7af4;
        ai[190] = 0xe9aeae47;
        ai[191] = 0x18080810;
        ai[192] = 0xd5baba6f;
        ai[193] = 0x887878f0;
        ai[194] = 0x6f25254a;
        ai[195] = 0x722e2e5c;
        ai[196] = 0x241c1c38;
        ai[197] = 0xf1a6a657;
        ai[198] = 0xc7b4b473;
        ai[199] = 0x51c6c697;
        ai[200] = 0x23e8e8cb;
        ai[201] = 0x7cdddda1;
        ai[202] = 0x9c7474e8;
        ai[203] = 0x211f1f3e;
        ai[204] = 0xdd4b4b96;
        ai[205] = 0xdcbdbd61;
        ai[206] = 0x868b8b0d;
        ai[207] = 0x858a8a0f;
        ai[208] = 0x907070e0;
        ai[209] = 0x423e3e7c;
        ai[210] = 0xc4b5b571;
        ai[211] = 0xaa6666cc;
        ai[212] = 0xd8484890;
        ai[213] = 0x5030306;
        ai[214] = 0x1f6f6f7;
        ai[215] = 0x120e0e1c;
        ai[216] = 0xa36161c2;
        ai[217] = 0x5f35356a;
        ai[218] = 0xf95757ae;
        ai[219] = 0xd0b9b969;
        ai[220] = 0x91868617;
        ai[221] = 0x58c1c199;
        ai[222] = 0x271d1d3a;
        ai[223] = 0xb99e9e27;
        ai[224] = 0x38e1e1d9;
        ai[225] = 0x13f8f8eb;
        ai[226] = 0xb398982b;
        ai[227] = 0x33111122;
        ai[228] = 0xbb6969d2;
        ai[229] = 0x70d9d9a9;
        ai[230] = 0x898e8e07;
        ai[231] = 0xa7949433;
        ai[232] = 0xb69b9b2d;
        ai[233] = 0x221e1e3c;
        ai[234] = 0x92878715;
        ai[235] = 0x20e9e9c9;
        ai[236] = 0x49cece87;
        ai[237] = 0xff5555aa;
        ai[238] = 0x78282850;
        ai[239] = 0x7adfdfa5;
        ai[240] = 0x8f8c8c03;
        ai[241] = 0xf8a1a159;
        ai[242] = 0x80898909;
        ai[243] = 0x170d0d1a;
        ai[244] = 0xdabfbf65;
        ai[245] = 0x31e6e6d7;
        ai[246] = 0xc6424284;
        ai[247] = 0xb86868d0;
        ai[248] = 0xc3414182;
        ai[249] = 0xb0999929;
        ai[250] = 0x772d2d5a;
        ai[251] = 0x110f0f1e;
        ai[252] = 0xcbb0b07b;
        ai[253] = 0xfc5454a8;
        ai[254] = 0xd6bbbb6d;
        ai[255] = 0x3a16162c;
        T0 = ai;
    }
}
