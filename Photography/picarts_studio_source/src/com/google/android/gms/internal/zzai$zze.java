// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzai

final class <init>
    implements <init>
{

    final zzai zzmT;

    public final void zzc(byte abyte0[], byte abyte1[])
    {
        zzmT.zzko = zzmT.zzlP & ~zzmT.zzkU;
        zzmT.zzmn = zzmT.zzlP & ~zzmT.zzko;
        zzmT.zzjr = zzmT.zzlx | zzmT.zzmn;
        zzmT.zzjr = zzmT.zzjr & ~zzmT.zzlj;
        zzmT.zzlZ = zzmT.zzko ^ zzmT.zzlZ;
        zzmT.zzjr = zzmT.zzlZ ^ zzmT.zzjr;
        zzmT.zzmu = zzmT.zzjr ^ zzmT.zzmu;
        zzmT.zzmF = zzmT.zzlZ ^ zzmT.zzmF;
        zzmT.zzmF = zzmT.zzlH & zzmT.zzmF;
        zzmT.zzmF = zzmT.zzkW ^ zzmT.zzmF;
        zzmT.zzkW = zzmT.zzko ^ zzmT.zzlx;
        zzmT.zzkW = zzmT.zzlj & zzmT.zzkW;
        zzmT.zzkW = zzmT.zzkH ^ zzmT.zzkW;
        zzmT.zzkH = zzmT.zzlH & zzmT.zzkW;
        zzmT.zzkH = zzmT.zzkW ^ zzmT.zzkH;
        zzmT.zzkH = zzmT.zzkr | zzmT.zzkH;
        zzmT.zzkH = zzmT.zzmF ^ zzmT.zzkH;
        zzmT.zzjC = zzmT.zzkH ^ zzmT.zzjC;
        zzmT.zzkH = zzmT.zzlx | zzmT.zzko;
        zzmT.zzkH = zzmT.zzlP ^ zzmT.zzkH;
        zzmT.zzky = zzmT.zzkH ^ zzmT.zzky;
        zzmT.zzky = zzmT.zzlH & ~zzmT.zzky;
        zzmT.zzky = zzmT.zzkS ^ zzmT.zzky;
        zzmT.zzky = zzmT.zzky & ~zzmT.zzkr;
        zzmT.zzkS = zzmT.zzko & ~zzmT.zzlx;
        zzmT.zzkS = zzmT.zzkU ^ zzmT.zzkS;
        zzmT.zzkS = zzmT.zzlj & ~zzmT.zzkS;
        zzmT.zzkH = zzmT.zzlx | zzmT.zzko;
        zzmT.zzkH = zzmT.zzjK ^ zzmT.zzkH;
        zzmT.zzkH = zzmT.zzlj & ~zzmT.zzkH;
        zzmT.zzjH = zzmT.zzjH & ~zzmT.zzlP;
        zzmT.zzjH = zzmT.zzkw ^ zzmT.zzjH;
        zzmT.zzjO = zzmT.zzjH ^ zzmT.zzjO;
        zzmT.zzlL = zzmT.zzjO ^ zzmT.zzlL;
        zzmT.zzjO = zzmT.zzlz | zzmT.zzlL;
        zzmT.zzjO = zzmT.zzma ^ zzmT.zzjO;
        zzmT.zzkq = zzmT.zzjO ^ zzmT.zzkq;
        zzmT.zzlL = zzmT.zzlz & zzmT.zzlL;
        zzmT.zzlL = zzmT.zzma ^ zzmT.zzlL;
        zzmT.zzkg = zzmT.zzlL ^ zzmT.zzkg;
        zzmT.zzlP = zzmT.zzkU ^ zzmT.zzlP;
        zzmT.zzlL = zzmT.zzlP & ~zzmT.zzlx;
        zzmT.zzlL = zzmT.zzko ^ zzmT.zzlL;
        zzmT.zzkS = zzmT.zzlL ^ zzmT.zzkS;
        zzmT.zzkS = zzmT.zzlH & ~zzmT.zzkS;
        zzmT.zzlL = zzmT.zzlx | zzmT.zzlP;
        zzmT.zzlL = zzmT.zzlP ^ zzmT.zzlL;
        zzmT.zzkH = zzmT.zzlL ^ zzmT.zzkH;
        zzmT.zzkH = zzmT.zzlH & zzmT.zzkH;
        zzmT.zzmh = zzmT.zzlP ^ zzmT.zzmh;
        zzmT.zzmh = zzmT.zzlj & zzmT.zzmh;
        zzmT.zzmh = zzmT.zzlH & zzmT.zzmh;
        zzmT.zzmh = zzmT.zzmn ^ zzmT.zzmh;
        zzmT.zzmh = zzmT.zzkr | zzmT.zzmh;
        zzmT.zzmh = zzmT.zzmu ^ zzmT.zzmh;
        zzmT.zzjk = zzmT.zzmh ^ zzmT.zzjk;
        zzmT.zzlx = zzmT.zzlP ^ zzmT.zzlx;
        zzmT.zzju = zzmT.zzlx ^ zzmT.zzju;
        zzmT.zzkS = zzmT.zzju ^ zzmT.zzkS;
        zzmT.zzmH = zzmT.zzkS ^ zzmT.zzmH;
        zzmT.zzls = zzmT.zzmH ^ zzmT.zzls;
        zzmT.zzls = ~zzmT.zzls;
        zzmT.zzks = zzmT.zzlP ^ zzmT.zzks;
        zzmT.zzks = zzmT.zzlj & zzmT.zzks;
        zzmT.zzks = zzmT.zzlx ^ zzmT.zzks;
        zzmT.zzkH = zzmT.zzks ^ zzmT.zzkH;
        zzmT.zzky = zzmT.zzkH ^ zzmT.zzky;
        zzmT.zzlq = zzmT.zzky ^ zzmT.zzlq;
        abyte1[0] = (byte)(zzmT.zzkQ & 0xff);
        abyte1[1] = (byte)((zzmT.zzkQ & 0xff00) >>> 8);
        abyte1[2] = (byte)((zzmT.zzkQ & 0xff0000) >>> 16);
        abyte1[3] = (byte)((zzmT.zzkQ & 0xff000000) >>> 24);
        abyte1[4] = (byte)(zzmT.zzmj & 0xff);
        abyte1[5] = (byte)((zzmT.zzmj & 0xff00) >>> 8);
        abyte1[6] = (byte)((zzmT.zzmj & 0xff0000) >>> 16);
        abyte1[7] = (byte)((zzmT.zzmj & 0xff000000) >>> 24);
        abyte1[8] = (byte)(zzmT.zzls & 0xff);
        abyte1[9] = (byte)((zzmT.zzls & 0xff00) >>> 8);
        abyte1[10] = (byte)((zzmT.zzls & 0xff0000) >>> 16);
        abyte1[11] = (byte)((zzmT.zzls & 0xff000000) >>> 24);
        abyte1[12] = (byte)(zzmT.zzli & 0xff);
        abyte1[13] = (byte)((zzmT.zzli & 0xff00) >>> 8);
        abyte1[14] = (byte)((zzmT.zzli & 0xff0000) >>> 16);
        abyte1[15] = (byte)((zzmT.zzli & 0xff000000) >>> 24);
        abyte1[16] = (byte)(zzmT.zzjk & 0xff);
        abyte1[17] = (byte)((zzmT.zzjk & 0xff00) >>> 8);
        abyte1[18] = (byte)((zzmT.zzjk & 0xff0000) >>> 16);
        abyte1[19] = (byte)((zzmT.zzjk & 0xff000000) >>> 24);
        abyte1[20] = (byte)(zzmT.zzjj & 0xff);
        abyte1[21] = (byte)((zzmT.zzjj & 0xff00) >>> 8);
        abyte1[22] = (byte)((zzmT.zzjj & 0xff0000) >>> 16);
        abyte1[23] = (byte)((zzmT.zzjj & 0xff000000) >>> 24);
        abyte1[24] = (byte)(zzmT.zzjm & 0xff);
        abyte1[25] = (byte)((zzmT.zzjm & 0xff00) >>> 8);
        abyte1[26] = (byte)((zzmT.zzjm & 0xff0000) >>> 16);
        abyte1[27] = (byte)((zzmT.zzjm & 0xff000000) >>> 24);
        abyte1[28] = (byte)(zzmT.zzlH & 0xff);
        abyte1[29] = (byte)((zzmT.zzlH & 0xff00) >>> 8);
        abyte1[30] = (byte)((zzmT.zzlH & 0xff0000) >>> 16);
        abyte1[31] = (byte)((zzmT.zzlH & 0xff000000) >>> 24);
        abyte1[32] = (byte)(zzmT.zzjo & 0xff);
        abyte1[33] = (byte)((zzmT.zzjo & 0xff00) >>> 8);
        abyte1[34] = (byte)((zzmT.zzjo & 0xff0000) >>> 16);
        abyte1[35] = (byte)((zzmT.zzjo & 0xff000000) >>> 24);
        abyte1[36] = (byte)(zzmT.zzmB & 0xff);
        abyte1[37] = (byte)((zzmT.zzmB & 0xff00) >>> 8);
        abyte1[38] = (byte)((zzmT.zzmB & 0xff0000) >>> 16);
        abyte1[39] = (byte)((zzmT.zzmB & 0xff000000) >>> 24);
        abyte1[40] = (byte)(zzmT.zzlE & 0xff);
        abyte1[41] = (byte)((zzmT.zzlE & 0xff00) >>> 8);
        abyte1[42] = (byte)((zzmT.zzlE & 0xff0000) >>> 16);
        abyte1[43] = (byte)((zzmT.zzlE & 0xff000000) >>> 24);
        abyte1[44] = (byte)(zzmT.zzjp & 0xff);
        abyte1[45] = (byte)((zzmT.zzjp & 0xff00) >>> 8);
        abyte1[46] = (byte)((zzmT.zzjp & 0xff0000) >>> 16);
        abyte1[47] = (byte)((zzmT.zzjp & 0xff000000) >>> 24);
        abyte1[48] = (byte)(zzmT.zzkL & 0xff);
        abyte1[49] = (byte)((zzmT.zzkL & 0xff00) >>> 8);
        abyte1[50] = (byte)((zzmT.zzkL & 0xff0000) >>> 16);
        abyte1[51] = (byte)((zzmT.zzkL & 0xff000000) >>> 24);
        abyte1[52] = (byte)(zzmT.zzlI & 0xff);
        abyte1[53] = (byte)((zzmT.zzlI & 0xff00) >>> 8);
        abyte1[54] = (byte)((zzmT.zzlI & 0xff0000) >>> 16);
        abyte1[55] = (byte)((zzmT.zzlI & 0xff000000) >>> 24);
        abyte1[56] = (byte)(zzmT.zzlc & 0xff);
        abyte1[57] = (byte)((zzmT.zzlc & 0xff00) >>> 8);
        abyte1[58] = (byte)((zzmT.zzlc & 0xff0000) >>> 16);
        abyte1[59] = (byte)((zzmT.zzlc & 0xff000000) >>> 24);
        abyte1[60] = (byte)(zzmT.zzjt & 0xff);
        abyte1[61] = (byte)((zzmT.zzjt & 0xff00) >>> 8);
        abyte1[62] = (byte)((zzmT.zzjt & 0xff0000) >>> 16);
        abyte1[63] = (byte)((zzmT.zzjt & 0xff000000) >>> 24);
        abyte1[64] = (byte)(zzmT.zzlq & 0xff);
        abyte1[65] = (byte)((zzmT.zzlq & 0xff00) >>> 8);
        abyte1[66] = (byte)((zzmT.zzlq & 0xff0000) >>> 16);
        abyte1[67] = (byte)((zzmT.zzlq & 0xff000000) >>> 24);
        abyte1[68] = (byte)(zzmT.zzlh & 0xff);
        abyte1[69] = (byte)((zzmT.zzlh & 0xff00) >>> 8);
        abyte1[70] = (byte)((zzmT.zzlh & 0xff0000) >>> 16);
        abyte1[71] = (byte)((zzmT.zzlh & 0xff000000) >>> 24);
        abyte1[72] = (byte)(zzmT.zzku & 0xff);
        abyte1[73] = (byte)((zzmT.zzku & 0xff00) >>> 8);
        abyte1[74] = (byte)((zzmT.zzku & 0xff0000) >>> 16);
        abyte1[75] = (byte)((zzmT.zzku & 0xff000000) >>> 24);
        abyte1[76] = (byte)(zzmT.zzlg & 0xff);
        abyte1[77] = (byte)((zzmT.zzlg & 0xff00) >>> 8);
        abyte1[78] = (byte)((zzmT.zzlg & 0xff0000) >>> 16);
        abyte1[79] = (byte)((zzmT.zzlg & 0xff000000) >>> 24);
        abyte1[80] = (byte)(zzmT.zzjA & 0xff);
        abyte1[81] = (byte)((zzmT.zzjA & 0xff00) >>> 8);
        abyte1[82] = (byte)((zzmT.zzjA & 0xff0000) >>> 16);
        abyte1[83] = (byte)((zzmT.zzjA & 0xff000000) >>> 24);
        abyte1[84] = (byte)(zzmT.zzjz & 0xff);
        abyte1[85] = (byte)((zzmT.zzjz & 0xff00) >>> 8);
        abyte1[86] = (byte)((zzmT.zzjz & 0xff0000) >>> 16);
        abyte1[87] = (byte)((zzmT.zzjz & 0xff000000) >>> 24);
        abyte1[88] = (byte)(zzmT.zzjC & 0xff);
        abyte1[89] = (byte)((zzmT.zzjC & 0xff00) >>> 8);
        abyte1[90] = (byte)((zzmT.zzjC & 0xff0000) >>> 16);
        abyte1[91] = (byte)((zzmT.zzjC & 0xff000000) >>> 24);
        abyte1[92] = (byte)(zzmT.zzjB & 0xff);
        abyte1[93] = (byte)((zzmT.zzjB & 0xff00) >>> 8);
        abyte1[94] = (byte)((zzmT.zzjB & 0xff0000) >>> 16);
        abyte1[95] = (byte)((zzmT.zzjB & 0xff000000) >>> 24);
        abyte1[96] = (byte)(zzmT.zzlJ & 0xff);
        abyte1[97] = (byte)((zzmT.zzlJ & 0xff00) >>> 8);
        abyte1[98] = (byte)((zzmT.zzlJ & 0xff0000) >>> 16);
        abyte1[99] = (byte)((zzmT.zzlJ & 0xff000000) >>> 24);
        abyte1[100] = (byte)(zzmT.zzlS & 0xff);
        abyte1[101] = (byte)((zzmT.zzlS & 0xff00) >>> 8);
        abyte1[102] = (byte)((zzmT.zzlS & 0xff0000) >>> 16);
        abyte1[103] = (byte)((zzmT.zzlS & 0xff000000) >>> 24);
        abyte1[104] = (byte)(zzmT.zzkK & 0xff);
        abyte1[105] = (byte)((zzmT.zzkK & 0xff00) >>> 8);
        abyte1[106] = (byte)((zzmT.zzkK & 0xff0000) >>> 16);
        abyte1[107] = (byte)((zzmT.zzkK & 0xff000000) >>> 24);
        abyte1[108] = (byte)(zzmT.zzjF & 0xff);
        abyte1[109] = (byte)((zzmT.zzjF & 0xff00) >>> 8);
        abyte1[110] = (byte)((zzmT.zzjF & 0xff0000) >>> 16);
        abyte1[111] = (byte)((zzmT.zzjF & 0xff000000) >>> 24);
        abyte1[112] = (byte)(zzmT.zzjI & 0xff);
        abyte1[113] = (byte)((zzmT.zzjI & 0xff00) >>> 8);
        abyte1[114] = (byte)((zzmT.zzjI & 0xff0000) >>> 16);
        abyte1[115] = (byte)((zzmT.zzjI & 0xff000000) >>> 24);
        abyte1[116] = (byte)(zzmT.zzjZ & 0xff);
        abyte1[117] = (byte)((zzmT.zzjZ & 0xff00) >>> 8);
        abyte1[118] = (byte)((zzmT.zzjZ & 0xff0000) >>> 16);
        abyte1[119] = (byte)((zzmT.zzjZ & 0xff000000) >>> 24);
        abyte1[120] = (byte)(zzmT.zzlM & 0xff);
        abyte1[121] = (byte)((zzmT.zzlM & 0xff00) >>> 8);
        abyte1[122] = (byte)((zzmT.zzlM & 0xff0000) >>> 16);
        abyte1[123] = (byte)((zzmT.zzlM & 0xff000000) >>> 24);
        abyte1[124] = (byte)(zzmT.zzlm & 0xff);
        abyte1[125] = (byte)((zzmT.zzlm & 0xff00) >>> 8);
        abyte1[126] = (byte)((zzmT.zzlm & 0xff0000) >>> 16);
        abyte1[127] = (byte)((zzmT.zzlm & 0xff000000) >>> 24);
        abyte1[128] = (byte)(zzmT.zzln & 0xff);
        abyte1[129] = (byte)((zzmT.zzln & 0xff00) >>> 8);
        abyte1[130] = (byte)((zzmT.zzln & 0xff0000) >>> 16);
        abyte1[131] = (byte)((zzmT.zzln & 0xff000000) >>> 24);
        abyte1[132] = (byte)(zzmT.zzjL & 0xff);
        abyte1[133] = (byte)((zzmT.zzjL & 0xff00) >>> 8);
        abyte1[134] = (byte)((zzmT.zzjL & 0xff0000) >>> 16);
        abyte1[135] = (byte)((zzmT.zzjL & 0xff000000) >>> 24);
        abyte1[136] = (byte)(zzmT.zzkY & 0xff);
        abyte1[137] = (byte)((zzmT.zzkY & 0xff00) >>> 8);
        abyte1[138] = (byte)((zzmT.zzkY & 0xff0000) >>> 16);
        abyte1[139] = (byte)((zzmT.zzkY & 0xff000000) >>> 24);
        abyte1[140] = (byte)(zzmT.zzmr & 0xff);
        abyte1[141] = (byte)((zzmT.zzmr & 0xff00) >>> 8);
        abyte1[142] = (byte)((zzmT.zzmr & 0xff0000) >>> 16);
        abyte1[143] = (byte)((zzmT.zzmr & 0xff000000) >>> 24);
        abyte1[144] = (byte)(zzmT.zzjQ & 0xff);
        abyte1[145] = (byte)((zzmT.zzjQ & 0xff00) >>> 8);
        abyte1[146] = (byte)((zzmT.zzjQ & 0xff0000) >>> 16);
        abyte1[147] = (byte)((zzmT.zzjQ & 0xff000000) >>> 24);
        abyte1[148] = (byte)(zzmT.zzmq & 0xff);
        abyte1[149] = (byte)((zzmT.zzmq & 0xff00) >>> 8);
        abyte1[150] = (byte)((zzmT.zzmq & 0xff0000) >>> 16);
        abyte1[151] = (byte)((zzmT.zzmq & 0xff000000) >>> 24);
        abyte1[152] = (byte)(zzmT.zzlW & 0xff);
        abyte1[153] = (byte)((zzmT.zzlW & 0xff00) >>> 8);
        abyte1[154] = (byte)((zzmT.zzlW & 0xff0000) >>> 16);
        abyte1[155] = (byte)((zzmT.zzlW & 0xff000000) >>> 24);
        abyte1[156] = (byte)(zzmT.zzkc & 0xff);
        abyte1[157] = (byte)((zzmT.zzkc & 0xff00) >>> 8);
        abyte1[158] = (byte)((zzmT.zzkc & 0xff0000) >>> 16);
        abyte1[159] = (byte)((zzmT.zzkc & 0xff000000) >>> 24);
        abyte1[160] = (byte)(zzmT.zzjU & 0xff);
        abyte1[161] = (byte)((zzmT.zzjU & 0xff00) >>> 8);
        abyte1[162] = (byte)((zzmT.zzjU & 0xff0000) >>> 16);
        abyte1[163] = (byte)((zzmT.zzjU & 0xff000000) >>> 24);
        abyte1[164] = (byte)(zzmT.zzjn & 0xff);
        abyte1[165] = (byte)((zzmT.zzjn & 0xff00) >>> 8);
        abyte1[166] = (byte)((zzmT.zzjn & 0xff0000) >>> 16);
        abyte1[167] = (byte)((zzmT.zzjn & 0xff000000) >>> 24);
        abyte1[168] = (byte)(zzmT.zzkj & 0xff);
        abyte1[169] = (byte)((zzmT.zzkj & 0xff00) >>> 8);
        abyte1[170] = (byte)((zzmT.zzkj & 0xff0000) >>> 16);
        abyte1[171] = (byte)((zzmT.zzkj & 0xff000000) >>> 24);
        abyte1[172] = (byte)(zzmT.zzkf & 0xff);
        abyte1[173] = (byte)((zzmT.zzkf & 0xff00) >>> 8);
        abyte1[174] = (byte)((zzmT.zzkf & 0xff0000) >>> 16);
        abyte1[175] = (byte)((zzmT.zzkf & 0xff000000) >>> 24);
        abyte1[176] = (byte)(zzmT.zzjY & 0xff);
        abyte1[177] = (byte)((zzmT.zzjY & 0xff00) >>> 8);
        abyte1[178] = (byte)((zzmT.zzjY & 0xff0000) >>> 16);
        abyte1[179] = (byte)((zzmT.zzjY & 0xff000000) >>> 24);
        abyte1[180] = (byte)(zzmT.zzkU & 0xff);
        abyte1[181] = (byte)((zzmT.zzkU & 0xff00) >>> 8);
        abyte1[182] = (byte)((zzmT.zzkU & 0xff0000) >>> 16);
        abyte1[183] = (byte)((zzmT.zzkU & 0xff000000) >>> 24);
        abyte1[184] = (byte)(zzmT.zzka & 0xff);
        abyte1[185] = (byte)((zzmT.zzka & 0xff00) >>> 8);
        abyte1[186] = (byte)((zzmT.zzka & 0xff0000) >>> 16);
        abyte1[187] = (byte)((zzmT.zzka & 0xff000000) >>> 24);
        abyte1[188] = (byte)(zzmT.zzkx & 0xff);
        abyte1[189] = (byte)((zzmT.zzkx & 0xff00) >>> 8);
        abyte1[190] = (byte)((zzmT.zzkx & 0xff0000) >>> 16);
        abyte1[191] = (byte)((zzmT.zzkx & 0xff000000) >>> 24);
        abyte1[192] = (byte)(zzmT.zzjq & 0xff);
        abyte1[193] = (byte)((zzmT.zzjq & 0xff00) >>> 8);
        abyte1[194] = (byte)((zzmT.zzjq & 0xff0000) >>> 16);
        abyte1[195] = (byte)((zzmT.zzjq & 0xff000000) >>> 24);
        abyte1[196] = (byte)(zzmT.zzkO & 0xff);
        abyte1[197] = (byte)((zzmT.zzkO & 0xff00) >>> 8);
        abyte1[198] = (byte)((zzmT.zzkO & 0xff0000) >>> 16);
        abyte1[199] = (byte)((zzmT.zzkO & 0xff000000) >>> 24);
        abyte1[200] = (byte)(zzmT.zzke & 0xff);
        abyte1[201] = (byte)((zzmT.zzke & 0xff00) >>> 8);
        abyte1[202] = (byte)((zzmT.zzke & 0xff0000) >>> 16);
        abyte1[203] = (byte)((zzmT.zzke & 0xff000000) >>> 24);
        abyte1[204] = (byte)(zzmT.zzkI & 0xff);
        abyte1[205] = (byte)((zzmT.zzkI & 0xff00) >>> 8);
        abyte1[206] = (byte)((zzmT.zzkI & 0xff0000) >>> 16);
        abyte1[207] = (byte)((zzmT.zzkI & 0xff000000) >>> 24);
        abyte1[208] = (byte)(zzmT.zzkg & 0xff);
        abyte1[209] = (byte)((zzmT.zzkg & 0xff00) >>> 8);
        abyte1[210] = (byte)((zzmT.zzkg & 0xff0000) >>> 16);
        abyte1[211] = (byte)((zzmT.zzkg & 0xff000000) >>> 24);
        abyte1[212] = (byte)(zzmT.zzlj & 0xff);
        abyte1[213] = (byte)((zzmT.zzlj & 0xff00) >>> 8);
        abyte1[214] = (byte)((zzmT.zzlj & 0xff0000) >>> 16);
        abyte1[215] = (byte)((zzmT.zzlj & 0xff000000) >>> 24);
        abyte1[216] = (byte)(zzmT.zzki & 0xff);
        abyte1[217] = (byte)((zzmT.zzki & 0xff00) >>> 8);
        abyte1[218] = (byte)((zzmT.zzki & 0xff0000) >>> 16);
        abyte1[219] = (byte)((zzmT.zzki & 0xff000000) >>> 24);
        abyte1[220] = (byte)(zzmT.zzjX & 0xff);
        abyte1[221] = (byte)((zzmT.zzjX & 0xff00) >>> 8);
        abyte1[222] = (byte)((zzmT.zzjX & 0xff0000) >>> 16);
        abyte1[223] = (byte)((zzmT.zzjX & 0xff000000) >>> 24);
        abyte1[224] = (byte)(zzmT.zzmk & 0xff);
        abyte1[225] = (byte)((zzmT.zzmk & 0xff00) >>> 8);
        abyte1[226] = (byte)((zzmT.zzmk & 0xff0000) >>> 16);
        abyte1[227] = (byte)((zzmT.zzmk & 0xff000000) >>> 24);
        abyte1[228] = (byte)(zzmT.zzlK & 0xff);
        abyte1[229] = (byte)((zzmT.zzlK & 0xff00) >>> 8);
        abyte1[230] = (byte)((zzmT.zzlK & 0xff0000) >>> 16);
        abyte1[231] = (byte)((zzmT.zzlK & 0xff000000) >>> 24);
        abyte1[232] = (byte)(zzmT.zzlw & 0xff);
        abyte1[233] = (byte)((zzmT.zzlw & 0xff00) >>> 8);
        abyte1[234] = (byte)((zzmT.zzlw & 0xff0000) >>> 16);
        abyte1[235] = (byte)((zzmT.zzlw & 0xff000000) >>> 24);
        abyte1[236] = (byte)(zzmT.zzmx & 0xff);
        abyte1[237] = (byte)((zzmT.zzmx & 0xff00) >>> 8);
        abyte1[238] = (byte)((zzmT.zzmx & 0xff0000) >>> 16);
        abyte1[239] = (byte)((zzmT.zzmx & 0xff000000) >>> 24);
        abyte1[240] = (byte)(zzmT.zzmg & 0xff);
        abyte1[241] = (byte)((zzmT.zzmg & 0xff00) >>> 8);
        abyte1[242] = (byte)((zzmT.zzmg & 0xff0000) >>> 16);
        abyte1[243] = (byte)((zzmT.zzmg & 0xff000000) >>> 24);
        abyte1[244] = (byte)(zzmT.zzkJ & 0xff);
        abyte1[245] = (byte)((zzmT.zzkJ & 0xff00) >>> 8);
        abyte1[246] = (byte)((zzmT.zzkJ & 0xff0000) >>> 16);
        abyte1[247] = (byte)((zzmT.zzkJ & 0xff000000) >>> 24);
        abyte1[248] = (byte)(zzmT.zzkq & 0xff);
        abyte1[249] = (byte)((zzmT.zzkq & 0xff00) >>> 8);
        abyte1[250] = (byte)((zzmT.zzkq & 0xff0000) >>> 16);
        abyte1[251] = (byte)((zzmT.zzkq & 0xff000000) >>> 24);
        abyte1[252] = (byte)(zzmT.zzkP & 0xff);
        abyte1[253] = (byte)((zzmT.zzkP & 0xff00) >>> 8);
        abyte1[254] = (byte)((zzmT.zzkP & 0xff0000) >>> 16);
        abyte1[255] = (byte)((zzmT.zzkP & 0xff000000) >>> 24);
    }

    private (zzai zzai1)
    {
        zzmT = zzai1;
        super();
    }

    zzmT(zzai zzai1, zzmT zzmt)
    {
        this(zzai1);
    }
}
