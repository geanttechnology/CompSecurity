// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.grafika;


// Referenced classes of package jp.co.cyberagent.android.gpuimage.grafika:
//            GPUImageBeautyFilterFactory

class AUTYCAM_FILTER_TYPE
{

    static final int a[];

    static 
    {
        a = new int[AUTYCAM_FILTER_TYPE.values().length];
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_TEMPLATE1.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror184) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_TEMPLATE2.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror183) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_TEMPLATE3.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror182) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SOFTEN.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror181) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LOOKUPTABLE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror180) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PIP1.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror179) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PIP2.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror178) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PIP3.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror177) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PIP4.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror176) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PIP5.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror175) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PIP6.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror174) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PIP7.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror173) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PIP8.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror172) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PIP9.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror171) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PIP10.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror170) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF1.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror169) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF2.ordinal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror168) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF3.ordinal()] = 18;
        }
        catch (NoSuchFieldError nosuchfielderror167) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF4.ordinal()] = 19;
        }
        catch (NoSuchFieldError nosuchfielderror166) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF5.ordinal()] = 20;
        }
        catch (NoSuchFieldError nosuchfielderror165) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF6.ordinal()] = 21;
        }
        catch (NoSuchFieldError nosuchfielderror164) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF7.ordinal()] = 22;
        }
        catch (NoSuchFieldError nosuchfielderror163) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF8.ordinal()] = 23;
        }
        catch (NoSuchFieldError nosuchfielderror162) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_MF9.ordinal()] = 24;
        }
        catch (NoSuchFieldError nosuchfielderror161) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_BLEND.ordinal()] = 25;
        }
        catch (NoSuchFieldError nosuchfielderror160) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LOMO.ordinal()] = 26;
        }
        catch (NoSuchFieldError nosuchfielderror159) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_OLDTIME.ordinal()] = 27;
        }
        catch (NoSuchFieldError nosuchfielderror158) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_OLDFILM_BW.ordinal()] = 28;
        }
        catch (NoSuchFieldError nosuchfielderror157) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_OLDFILM.ordinal()] = 29;
        }
        catch (NoSuchFieldError nosuchfielderror156) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LIGHT_1.ordinal()] = 30;
        }
        catch (NoSuchFieldError nosuchfielderror155) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LIGHT_2.ordinal()] = 31;
        }
        catch (NoSuchFieldError nosuchfielderror154) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LIGHT_3.ordinal()] = 32;
        }
        catch (NoSuchFieldError nosuchfielderror153) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LIGHT_4.ordinal()] = 33;
        }
        catch (NoSuchFieldError nosuchfielderror152) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LIGHT_5.ordinal()] = 34;
        }
        catch (NoSuchFieldError nosuchfielderror151) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LIGHT_6.ordinal()] = 35;
        }
        catch (NoSuchFieldError nosuchfielderror150) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LIGHT_7.ordinal()] = 36;
        }
        catch (NoSuchFieldError nosuchfielderror149) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LIGHT_8.ordinal()] = 37;
        }
        catch (NoSuchFieldError nosuchfielderror148) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LIGHT_9.ordinal()] = 38;
        }
        catch (NoSuchFieldError nosuchfielderror147) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LIGHT_10.ordinal()] = 39;
        }
        catch (NoSuchFieldError nosuchfielderror146) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LIGHT_11.ordinal()] = 40;
        }
        catch (NoSuchFieldError nosuchfielderror145) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LIGHT_12.ordinal()] = 41;
        }
        catch (NoSuchFieldError nosuchfielderror144) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LIGHT_13.ordinal()] = 42;
        }
        catch (NoSuchFieldError nosuchfielderror143) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PIPCAMERA_TEST.ordinal()] = 43;
        }
        catch (NoSuchFieldError nosuchfielderror142) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_LIANGBAI.ordinal()] = 44;
        }
        catch (NoSuchFieldError nosuchfielderror141) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_MENGLONG.ordinal()] = 45;
        }
        catch (NoSuchFieldError nosuchfielderror140) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_TIANMI.ordinal()] = 46;
        }
        catch (NoSuchFieldError nosuchfielderror139) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_ABAO.ordinal()] = 47;
        }
        catch (NoSuchFieldError nosuchfielderror138) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_ABAO_EARTH.ordinal()] = 48;
        }
        catch (NoSuchFieldError nosuchfielderror137) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_ABAO_FAIR.ordinal()] = 49;
        }
        catch (NoSuchFieldError nosuchfielderror136) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_ABAO_LIBRA.ordinal()] = 50;
        }
        catch (NoSuchFieldError nosuchfielderror135) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_XIARI.ordinal()] = 51;
        }
        catch (NoSuchFieldError nosuchfielderror134) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_QINGXIN.ordinal()] = 52;
        }
        catch (NoSuchFieldError nosuchfielderror133) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_QINGSHUANG.ordinal()] = 53;
        }
        catch (NoSuchFieldError nosuchfielderror132) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_LIANGLI.ordinal()] = 54;
        }
        catch (NoSuchFieldError nosuchfielderror131) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_XIAOQINGXIN.ordinal()] = 55;
        }
        catch (NoSuchFieldError nosuchfielderror130) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_LUANFENG.ordinal()] = 56;
        }
        catch (NoSuchFieldError nosuchfielderror129) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_JINGMI.ordinal()] = 57;
        }
        catch (NoSuchFieldError nosuchfielderror128) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_HEIBAI.ordinal()] = 58;
        }
        catch (NoSuchFieldError nosuchfielderror127) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BBEAUTYCAM_FILTER_LUT_UNA.ordinal()] = 59;
        }
        catch (NoSuchFieldError nosuchfielderror126) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_TEST_01.ordinal()] = 60;
        }
        catch (NoSuchFieldError nosuchfielderror125) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_TEST_02.ordinal()] = 61;
        }
        catch (NoSuchFieldError nosuchfielderror124) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_TEST_03.ordinal()] = 62;
        }
        catch (NoSuchFieldError nosuchfielderror123) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_TEST_04.ordinal()] = 63;
        }
        catch (NoSuchFieldError nosuchfielderror122) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_TEST_05.ordinal()] = 64;
        }
        catch (NoSuchFieldError nosuchfielderror121) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_LUT_TEST_06.ordinal()] = 65;
        }
        catch (NoSuchFieldError nosuchfielderror120) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_ZZZ_SHENGHUO.ordinal()] = 66;
        }
        catch (NoSuchFieldError nosuchfielderror119) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_ZZZ_SHOUZI.ordinal()] = 67;
        }
        catch (NoSuchFieldError nosuchfielderror118) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_ZZZ_ZHESHIWO.ordinal()] = 68;
        }
        catch (NoSuchFieldError nosuchfielderror117) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_ZZZ_LVXING.ordinal()] = 69;
        }
        catch (NoSuchFieldError nosuchfielderror116) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_ZZZ_XIAOQUEXING.ordinal()] = 70;
        }
        catch (NoSuchFieldError nosuchfielderror115) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_ZZZ_CHUNVZUO.ordinal()] = 71;
        }
        catch (NoSuchFieldError nosuchfielderror114) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_ZZZ_WOMEN.ordinal()] = 72;
        }
        catch (NoSuchFieldError nosuchfielderror113) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_ZZZ_GUIMI.ordinal()] = 73;
        }
        catch (NoSuchFieldError nosuchfielderror112) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_ZZZ_BIYE.ordinal()] = 74;
        }
        catch (NoSuchFieldError nosuchfielderror111) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_GAUSSIANBLUR.ordinal()] = 75;
        }
        catch (NoSuchFieldError nosuchfielderror110) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_COLORLEAK_1.ordinal()] = 76;
        }
        catch (NoSuchFieldError nosuchfielderror109) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_COLORLEAK_2.ordinal()] = 77;
        }
        catch (NoSuchFieldError nosuchfielderror108) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_COLORLEAK_3.ordinal()] = 78;
        }
        catch (NoSuchFieldError nosuchfielderror107) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_COLORLEAK_4.ordinal()] = 79;
        }
        catch (NoSuchFieldError nosuchfielderror106) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_COLORLEAK_5.ordinal()] = 80;
        }
        catch (NoSuchFieldError nosuchfielderror105) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_COLORLEAK_6.ordinal()] = 81;
        }
        catch (NoSuchFieldError nosuchfielderror104) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_COLORLEAK_7.ordinal()] = 82;
        }
        catch (NoSuchFieldError nosuchfielderror103) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_COLORLEAK_8.ordinal()] = 83;
        }
        catch (NoSuchFieldError nosuchfielderror102) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_1977.ordinal()] = 84;
        }
        catch (NoSuchFieldError nosuchfielderror101) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Brannan.ordinal()] = 85;
        }
        catch (NoSuchFieldError nosuchfielderror100) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_LordKelvin.ordinal()] = 86;
        }
        catch (NoSuchFieldError nosuchfielderror99) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Walden.ordinal()] = 87;
        }
        catch (NoSuchFieldError nosuchfielderror98) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_XProII.ordinal()] = 88;
        }
        catch (NoSuchFieldError nosuchfielderror97) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Valencia.ordinal()] = 89;
        }
        catch (NoSuchFieldError nosuchfielderror96) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Toaster.ordinal()] = 90;
        }
        catch (NoSuchFieldError nosuchfielderror95) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Sutro.ordinal()] = 91;
        }
        catch (NoSuchFieldError nosuchfielderror94) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_SOOC.ordinal()] = 92;
        }
        catch (NoSuchFieldError nosuchfielderror93) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Sierra.ordinal()] = 93;
        }
        catch (NoSuchFieldError nosuchfielderror92) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Rise.ordinal()] = 94;
        }
        catch (NoSuchFieldError nosuchfielderror91) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Retro.ordinal()] = 95;
        }
        catch (NoSuchFieldError nosuchfielderror90) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Nashville.ordinal()] = 96;
        }
        catch (NoSuchFieldError nosuchfielderror89) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Lomofi.ordinal()] = 97;
        }
        catch (NoSuchFieldError nosuchfielderror88) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Inkwell.ordinal()] = 98;
        }
        catch (NoSuchFieldError nosuchfielderror87) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Mayfair.ordinal()] = 99;
        }
        catch (NoSuchFieldError nosuchfielderror86) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Hudson.ordinal()] = 100;
        }
        catch (NoSuchFieldError nosuchfielderror85) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Classic.ordinal()] = 101;
        }
        catch (NoSuchFieldError nosuchfielderror84) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Apollo.ordinal()] = 102;
        }
        catch (NoSuchFieldError nosuchfielderror83) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Amaro.ordinal()] = 103;
        }
        catch (NoSuchFieldError nosuchfielderror82) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Earlybird.ordinal()] = 104;
        }
        catch (NoSuchFieldError nosuchfielderror81) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Hefe.ordinal()] = 105;
        }
        catch (NoSuchFieldError nosuchfielderror80) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_INSTAGRAM_Willow.ordinal()] = 106;
        }
        catch (NoSuchFieldError nosuchfielderror79) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SATURNRINGS_1.ordinal()] = 107;
        }
        catch (NoSuchFieldError nosuchfielderror78) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SATURNRINGS_2.ordinal()] = 108;
        }
        catch (NoSuchFieldError nosuchfielderror77) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SATURNRINGS_3.ordinal()] = 109;
        }
        catch (NoSuchFieldError nosuchfielderror76) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SATURNRINGS_4.ordinal()] = 110;
        }
        catch (NoSuchFieldError nosuchfielderror75) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SATURNRINGS_5.ordinal()] = 111;
        }
        catch (NoSuchFieldError nosuchfielderror74) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SATURNRINGS_6.ordinal()] = 112;
        }
        catch (NoSuchFieldError nosuchfielderror73) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SATURNRINGS_7.ordinal()] = 113;
        }
        catch (NoSuchFieldError nosuchfielderror72) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SATURNRINGS_8.ordinal()] = 114;
        }
        catch (NoSuchFieldError nosuchfielderror71) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SATURNRINGS_9.ordinal()] = 115;
        }
        catch (NoSuchFieldError nosuchfielderror70) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SATURNRINGS_10.ordinal()] = 116;
        }
        catch (NoSuchFieldError nosuchfielderror69) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_BXXX_3.ordinal()] = 117;
        }
        catch (NoSuchFieldError nosuchfielderror68) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_BXXX_4.ordinal()] = 118;
        }
        catch (NoSuchFieldError nosuchfielderror67) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_BXXX_5.ordinal()] = 119;
        }
        catch (NoSuchFieldError nosuchfielderror66) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_BXXX_6.ordinal()] = 120;
        }
        catch (NoSuchFieldError nosuchfielderror65) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_BXXX_7.ordinal()] = 121;
        }
        catch (NoSuchFieldError nosuchfielderror64) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_BXXX_8.ordinal()] = 122;
        }
        catch (NoSuchFieldError nosuchfielderror63) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_BXXX_9.ordinal()] = 123;
        }
        catch (NoSuchFieldError nosuchfielderror62) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_BXXX_10.ordinal()] = 124;
        }
        catch (NoSuchFieldError nosuchfielderror61) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_BXXX_11.ordinal()] = 125;
        }
        catch (NoSuchFieldError nosuchfielderror60) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_GROUPSET1_1.ordinal()] = 126;
        }
        catch (NoSuchFieldError nosuchfielderror59) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_GROUPSET1_2.ordinal()] = 127;
        }
        catch (NoSuchFieldError nosuchfielderror58) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_GROUPSET1_3.ordinal()] = 128;
        }
        catch (NoSuchFieldError nosuchfielderror57) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_GROUPSET2_1.ordinal()] = 129;
        }
        catch (NoSuchFieldError nosuchfielderror56) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_GROUPSET2_2.ordinal()] = 130;
        }
        catch (NoSuchFieldError nosuchfielderror55) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_GROUPSET2_3.ordinal()] = 131;
        }
        catch (NoSuchFieldError nosuchfielderror54) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_GROUPSET3_1.ordinal()] = 132;
        }
        catch (NoSuchFieldError nosuchfielderror53) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_GROUPSET3_2.ordinal()] = 133;
        }
        catch (NoSuchFieldError nosuchfielderror52) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_GROUPSET3_3.ordinal()] = 134;
        }
        catch (NoSuchFieldError nosuchfielderror51) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_GROUPSET4_1.ordinal()] = 135;
        }
        catch (NoSuchFieldError nosuchfielderror50) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_GROUPSET4_2.ordinal()] = 136;
        }
        catch (NoSuchFieldError nosuchfielderror49) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_GROUPSET4_4.ordinal()] = 137;
        }
        catch (NoSuchFieldError nosuchfielderror48) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_ASSORTED_Lavender.ordinal()] = 138;
        }
        catch (NoSuchFieldError nosuchfielderror47) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_ASSORTED_Lomo.ordinal()] = 139;
        }
        catch (NoSuchFieldError nosuchfielderror46) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_ASSORTED_Softpink.ordinal()] = 140;
        }
        catch (NoSuchFieldError nosuchfielderror45) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_ASSORTED_Exposed.ordinal()] = 141;
        }
        catch (NoSuchFieldError nosuchfielderror44) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_ASSORTED_BeachBlue_dusk.ordinal()] = 142;
        }
        catch (NoSuchFieldError nosuchfielderror43) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_VINTANGE_1.ordinal()] = 143;
        }
        catch (NoSuchFieldError nosuchfielderror42) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_VINTANGE_2.ordinal()] = 144;
        }
        catch (NoSuchFieldError nosuchfielderror41) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_VINTANGE_3.ordinal()] = 145;
        }
        catch (NoSuchFieldError nosuchfielderror40) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_VINTANGE_4.ordinal()] = 146;
        }
        catch (NoSuchFieldError nosuchfielderror39) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_1.ordinal()] = 147;
        }
        catch (NoSuchFieldError nosuchfielderror38) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_2.ordinal()] = 148;
        }
        catch (NoSuchFieldError nosuchfielderror37) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_3.ordinal()] = 149;
        }
        catch (NoSuchFieldError nosuchfielderror36) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_5.ordinal()] = 150;
        }
        catch (NoSuchFieldError nosuchfielderror35) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_6.ordinal()] = 151;
        }
        catch (NoSuchFieldError nosuchfielderror34) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_7.ordinal()] = 152;
        }
        catch (NoSuchFieldError nosuchfielderror33) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_8.ordinal()] = 153;
        }
        catch (NoSuchFieldError nosuchfielderror32) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_10.ordinal()] = 154;
        }
        catch (NoSuchFieldError nosuchfielderror31) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_11.ordinal()] = 155;
        }
        catch (NoSuchFieldError nosuchfielderror30) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_12.ordinal()] = 156;
        }
        catch (NoSuchFieldError nosuchfielderror29) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_13.ordinal()] = 157;
        }
        catch (NoSuchFieldError nosuchfielderror28) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_14.ordinal()] = 158;
        }
        catch (NoSuchFieldError nosuchfielderror27) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_15.ordinal()] = 159;
        }
        catch (NoSuchFieldError nosuchfielderror26) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_16.ordinal()] = 160;
        }
        catch (NoSuchFieldError nosuchfielderror25) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_18.ordinal()] = 161;
        }
        catch (NoSuchFieldError nosuchfielderror24) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_19.ordinal()] = 162;
        }
        catch (NoSuchFieldError nosuchfielderror23) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SELECTIVECOLOR_20.ordinal()] = 163;
        }
        catch (NoSuchFieldError nosuchfielderror22) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Red.ordinal()] = 164;
        }
        catch (NoSuchFieldError nosuchfielderror21) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_DeepRed.ordinal()] = 165;
        }
        catch (NoSuchFieldError nosuchfielderror20) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Green.ordinal()] = 166;
        }
        catch (NoSuchFieldError nosuchfielderror19) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Blue.ordinal()] = 167;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_DeepBlue.ordinal()] = 168;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Yellow.ordinal()] = 169;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_DeepYellow.ordinal()] = 170;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Violet.ordinal()] = 171;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Magenta.ordinal()] = 172;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Sepia.ordinal()] = 173;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Cyan.ordinal()] = 174;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Orange.ordinal()] = 175;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Coolingfilter1.ordinal()] = 176;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Coolingfilter2.ordinal()] = 177;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Coolingfilter3.ordinal()] = 178;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Warmingfilter1.ordinal()] = 179;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Warmingfilter2.ordinal()] = 180;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_Warmingfilter3.ordinal()] = 181;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_DeepEmerald.ordinal()] = 182;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_PHOTOFILTER_UnderWater.ordinal()] = 183;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_BLACKWHITE_1.ordinal()] = 184;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[AUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_BLACKWHITE_2.ordinal()] = 185;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
