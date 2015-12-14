// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rockerhieu.emojicon;

import android.content.Context;
import android.text.Spannable;
import android.util.SparseIntArray;

// Referenced classes of package com.rockerhieu.emojicon:
//            EmojiconSpan

public final class EmojiconHandler
{

    private static final SparseIntArray sEmojisMap;
    private static final SparseIntArray sSoftbanksMap;

    private EmojiconHandler()
    {
    }

    public static void addEmojis(Context context, Spannable spannable, int i, float f)
    {
        int j1;
        int l1;
        l1 = spannable.length();
        EmojiconSpan aemojiconspan[] = (EmojiconSpan[])spannable.getSpans(0, l1, com/rockerhieu/emojicon/EmojiconSpan);
        for (int j = 0; j < aemojiconspan.length; j++)
        {
            spannable.removeSpan(aemojiconspan[j]);
        }

        j1 = 0;
_L19:
        if (j1 >= l1) goto _L2; else goto _L1
_L1:
        char c = spannable.charAt(j1);
        int k;
        int l;
        int i1;
        int k1;
        int i2;
        if (isSoftBankEmoji(c))
        {
            l = getSoftbankEmojiResource(c);
            if (l == 0)
            {
                i1 = 0;
            } else
            {
                i1 = 1;
            }
        } else
        {
            l = 0;
            i1 = 0;
        }
        k = l;
        if (l != 0) goto _L4; else goto _L3
_L3:
        i1 = Character.codePointAt(spannable, j1);
        k1 = Character.charCount(i1);
        if (i1 > 255)
        {
            l = getEmojiResource(context, i1);
        }
        if (l != 0 || j1 + k1 >= l1)
        {
            break MISSING_BLOCK_LABEL_990;
        }
        i2 = Character.codePointAt(spannable, j1 + k1);
        if (i2 != 8419) goto _L6; else goto _L5
_L5:
        k = Character.charCount(i2);
        i1;
        JVM INSTR tableswitch 35 57: default 288
    //                   35 514
    //                   36 288
    //                   37 288
    //                   38 288
    //                   39 288
    //                   40 288
    //                   41 288
    //                   42 288
    //                   43 288
    //                   44 288
    //                   45 288
    //                   46 288
    //                   47 288
    //                   48 498
    //                   49 354
    //                   50 370
    //                   51 386
    //                   52 402
    //                   53 418
    //                   54 434
    //                   55 450
    //                   56 466
    //                   57 482;
           goto _L7 _L8 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L7:
        i1 = 0;
        k = l;
        l = i1;
_L20:
        i1 = l + k1;
_L4:
        if (k > 0)
        {
            spannable.setSpan(new EmojiconSpan(context, k, i, f), j1, j1 + i1, 33);
        }
        j1 = i1 + j1;
          goto _L19
_L10:
        i1 = R.drawable.emoji_0031;
        l = k;
        k = i1;
          goto _L20
_L11:
        i1 = R.drawable.emoji_0032;
        l = k;
        k = i1;
          goto _L20
_L12:
        i1 = R.drawable.emoji_0033;
        l = k;
        k = i1;
          goto _L20
_L13:
        i1 = R.drawable.emoji_0034;
        l = k;
        k = i1;
          goto _L20
_L14:
        i1 = R.drawable.emoji_0035;
        l = k;
        k = i1;
          goto _L20
_L15:
        i1 = R.drawable.emoji_0036;
        l = k;
        k = i1;
          goto _L20
_L16:
        i1 = R.drawable.emoji_0037;
        l = k;
        k = i1;
          goto _L20
_L17:
        i1 = R.drawable.emoji_0038;
        l = k;
        k = i1;
          goto _L20
_L18:
        i1 = R.drawable.emoji_0039;
        l = k;
        k = i1;
          goto _L20
_L9:
        i1 = R.drawable.emoji_0030;
        l = k;
        k = i1;
          goto _L20
_L8:
        i1 = R.drawable.emoji_0023;
        l = k;
        k = i1;
          goto _L20
_L6:
        k = Character.charCount(i2);
        i1;
        JVM INSTR tableswitch 127464 127482: default 628
    //                   127464 921
    //                   127465 751
    //                   127466 853
    //                   127467 717
    //                   127468 819
    //                   127469 628
    //                   127470 785
    //                   127471 649
    //                   127472 955
    //                   127473 628
    //                   127474 628
    //                   127475 628
    //                   127476 628
    //                   127477 628
    //                   127478 628
    //                   127479 887
    //                   127480 628
    //                   127481 628
    //                   127482 683;
           goto _L21 _L22 _L23 _L24 _L25 _L26 _L21 _L27 _L28 _L29 _L21 _L21 _L21 _L21 _L21 _L21 _L30 _L21 _L21 _L31
_L29:
        break MISSING_BLOCK_LABEL_955;
_L21:
        i1 = 0;
        k = l;
        l = i1;
_L32:
        i1 = l + k1;
          goto _L4
_L28:
        if (i2 == 0x1f1f5)
        {
            l = R.drawable.emoji_1f1ef_1f1f5;
        } else
        {
            l = 0;
        }
        i1 = l;
        l = k;
        k = i1;
          goto _L32
_L31:
        if (i2 == 0x1f1f8)
        {
            l = R.drawable.emoji_1f1fa_1f1f8;
        } else
        {
            l = 0;
        }
        i1 = l;
        l = k;
        k = i1;
          goto _L32
_L25:
        if (i2 == 0x1f1f7)
        {
            l = R.drawable.emoji_1f1eb_1f1f7;
        } else
        {
            l = 0;
        }
        i1 = l;
        l = k;
        k = i1;
          goto _L32
_L23:
        if (i2 == 0x1f1ea)
        {
            l = R.drawable.emoji_1f1e9_1f1ea;
        } else
        {
            l = 0;
        }
        i1 = l;
        l = k;
        k = i1;
          goto _L32
_L27:
        if (i2 == 0x1f1f9)
        {
            l = R.drawable.emoji_1f1ee_1f1f9;
        } else
        {
            l = 0;
        }
        i1 = l;
        l = k;
        k = i1;
          goto _L32
_L26:
        if (i2 == 0x1f1e7)
        {
            l = R.drawable.emoji_1f1ec_1f1e7;
        } else
        {
            l = 0;
        }
        i1 = l;
        l = k;
        k = i1;
          goto _L32
_L24:
        if (i2 == 0x1f1f8)
        {
            l = R.drawable.emoji_1f1ea_1f1f8;
        } else
        {
            l = 0;
        }
        i1 = l;
        l = k;
        k = i1;
          goto _L32
_L30:
        if (i2 == 0x1f1fa)
        {
            l = R.drawable.emoji_1f1f7_1f1fa;
        } else
        {
            l = 0;
        }
        i1 = l;
        l = k;
        k = i1;
          goto _L32
_L22:
        if (i2 == 0x1f1f3)
        {
            l = R.drawable.emoji_1f1e8_1f1f3;
        } else
        {
            l = 0;
        }
        i1 = l;
        l = k;
        k = i1;
          goto _L32
        if (i2 == 0x1f1f7)
        {
            l = R.drawable.emoji_1f1f0_1f1f7;
        } else
        {
            l = 0;
        }
        i1 = l;
        l = k;
        k = i1;
          goto _L32
_L2:
        return;
        i1 = k1;
        k = l;
          goto _L4
    }

    private static int getEmojiResource(Context context, int i)
    {
        return sEmojisMap.get(i);
    }

    public static int getOtherEmojiResource(Context context, String s)
    {
        if (!s.isEmpty()) goto _L2; else goto _L1
_L1:
        return 0;
_L2:
        char c = s.charAt(0);
        int i;
        int j;
        int k;
        int l;
        if (isSoftBankEmoji(c))
        {
            i = getSoftbankEmojiResource(c);
        } else
        {
            i = 0;
        }
        k = Character.codePointAt(s, 0);
        j = i;
        if (i == 0)
        {
            j = i;
            if (k > 255)
            {
                j = getEmojiResource(context, k);
            }
        }
        i = s.length();
        l = Character.charCount(k);
        if (j != 0 || l >= i) goto _L4; else goto _L3
_L3:
        i = Character.codePointAt(s, l);
        if (i == 8419)
        {
            switch (k)
            {
            case 36: // '$'
            case 37: // '%'
            case 38: // '&'
            case 39: // '\''
            case 40: // '('
            case 41: // ')'
            case 42: // '*'
            case 43: // '+'
            case 44: // ','
            case 45: // '-'
            case 46: // '.'
            case 47: // '/'
            default:
                return j;

            case 49: // '1'
                return R.drawable.emoji_0031;

            case 50: // '2'
                return R.drawable.emoji_0032;

            case 51: // '3'
                return R.drawable.emoji_0033;

            case 52: // '4'
                return R.drawable.emoji_0034;

            case 53: // '5'
                return R.drawable.emoji_0035;

            case 54: // '6'
                return R.drawable.emoji_0036;

            case 55: // '7'
                return R.drawable.emoji_0037;

            case 56: // '8'
                return R.drawable.emoji_0038;

            case 57: // '9'
                return R.drawable.emoji_0039;

            case 48: // '0'
                return R.drawable.emoji_0030;

            case 35: // '#'
                return R.drawable.emoji_0023;
            }
        }
        k;
        JVM INSTR tableswitch 127464 127482: default 344
    //                   127464 435
    //                   127465 380
    //                   127466 413
    //                   127467 369
    //                   127468 402
    //                   127469 344
    //                   127470 391
    //                   127471 347
    //                   127472 446
    //                   127473 344
    //                   127474 344
    //                   127475 344
    //                   127476 344
    //                   127477 344
    //                   127478 344
    //                   127479 424
    //                   127480 344
    //                   127481 344
    //                   127482 358;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L4 _L10 _L11 _L12 _L4 _L4 _L4 _L4 _L4 _L4 _L13 _L4 _L4 _L14
_L12:
        continue; /* Loop/switch isn't completed */
_L4:
        return j;
_L11:
        if (i != 0x1f1f5) goto _L1; else goto _L15
_L15:
        return R.drawable.emoji_1f1ef_1f1f5;
_L14:
        if (i != 0x1f1f8) goto _L1; else goto _L16
_L16:
        return R.drawable.emoji_1f1fa_1f1f8;
_L8:
        if (i != 0x1f1f7) goto _L1; else goto _L17
_L17:
        return R.drawable.emoji_1f1eb_1f1f7;
_L6:
        if (i != 0x1f1ea) goto _L1; else goto _L18
_L18:
        return R.drawable.emoji_1f1e9_1f1ea;
_L10:
        if (i != 0x1f1f9) goto _L1; else goto _L19
_L19:
        return R.drawable.emoji_1f1ee_1f1f9;
_L9:
        if (i != 0x1f1e7) goto _L1; else goto _L20
_L20:
        return R.drawable.emoji_1f1ec_1f1e7;
_L7:
        if (i != 0x1f1f8) goto _L1; else goto _L21
_L21:
        return R.drawable.emoji_1f1ea_1f1f8;
_L13:
        if (i != 0x1f1fa) goto _L1; else goto _L22
_L22:
        return R.drawable.emoji_1f1f7_1f1fa;
_L5:
        if (i != 0x1f1f3) goto _L1; else goto _L23
_L23:
        return R.drawable.emoji_1f1e8_1f1f3;
        if (i != 0x1f1f7) goto _L1; else goto _L24
_L24:
        return R.drawable.emoji_1f1f0_1f1f7;
    }

    private static int getSoftbankEmojiResource(char c)
    {
        return sSoftbanksMap.get(c);
    }

    private static boolean isSoftBankEmoji(char c)
    {
        return c >> 12 == 14;
    }

    static 
    {
        sEmojisMap = new SparseIntArray(846);
        sSoftbanksMap = new SparseIntArray(471);
        sEmojisMap.put(0x1f604, R.drawable.emoji_1f604);
        sEmojisMap.put(0x1f603, R.drawable.emoji_1f603);
        sEmojisMap.put(0x1f600, R.drawable.emoji_1f600);
        sEmojisMap.put(0x1f60a, R.drawable.emoji_1f60a);
        sEmojisMap.put(9786, R.drawable.emoji_263a);
        sEmojisMap.put(0x1f609, R.drawable.emoji_1f609);
        sEmojisMap.put(0x1f60d, R.drawable.emoji_1f60d);
        sEmojisMap.put(0x1f618, R.drawable.emoji_1f618);
        sEmojisMap.put(0x1f61a, R.drawable.emoji_1f61a);
        sEmojisMap.put(0x1f617, R.drawable.emoji_1f617);
        sEmojisMap.put(0x1f619, R.drawable.emoji_1f619);
        sEmojisMap.put(0x1f61c, R.drawable.emoji_1f61c);
        sEmojisMap.put(0x1f61d, R.drawable.emoji_1f61d);
        sEmojisMap.put(0x1f61b, R.drawable.emoji_1f61b);
        sEmojisMap.put(0x1f633, R.drawable.emoji_1f633);
        sEmojisMap.put(0x1f601, R.drawable.emoji_1f601);
        sEmojisMap.put(0x1f614, R.drawable.emoji_1f614);
        sEmojisMap.put(0x1f60c, R.drawable.emoji_1f60c);
        sEmojisMap.put(0x1f612, R.drawable.emoji_1f612);
        sEmojisMap.put(0x1f61e, R.drawable.emoji_1f61e);
        sEmojisMap.put(0x1f623, R.drawable.emoji_1f623);
        sEmojisMap.put(0x1f622, R.drawable.emoji_1f622);
        sEmojisMap.put(0x1f602, R.drawable.emoji_1f602);
        sEmojisMap.put(0x1f62d, R.drawable.emoji_1f62d);
        sEmojisMap.put(0x1f62a, R.drawable.emoji_1f62a);
        sEmojisMap.put(0x1f625, R.drawable.emoji_1f625);
        sEmojisMap.put(0x1f630, R.drawable.emoji_1f630);
        sEmojisMap.put(0x1f605, R.drawable.emoji_1f605);
        sEmojisMap.put(0x1f613, R.drawable.emoji_1f613);
        sEmojisMap.put(0x1f629, R.drawable.emoji_1f629);
        sEmojisMap.put(0x1f62b, R.drawable.emoji_1f62b);
        sEmojisMap.put(0x1f628, R.drawable.emoji_1f628);
        sEmojisMap.put(0x1f631, R.drawable.emoji_1f631);
        sEmojisMap.put(0x1f620, R.drawable.emoji_1f620);
        sEmojisMap.put(0x1f621, R.drawable.emoji_1f621);
        sEmojisMap.put(0x1f624, R.drawable.emoji_1f624);
        sEmojisMap.put(0x1f616, R.drawable.emoji_1f616);
        sEmojisMap.put(0x1f606, R.drawable.emoji_1f606);
        sEmojisMap.put(0x1f60b, R.drawable.emoji_1f60b);
        sEmojisMap.put(0x1f637, R.drawable.emoji_1f637);
        sEmojisMap.put(0x1f60e, R.drawable.emoji_1f60e);
        sEmojisMap.put(0x1f634, R.drawable.emoji_1f634);
        sEmojisMap.put(0x1f635, R.drawable.emoji_1f635);
        sEmojisMap.put(0x1f632, R.drawable.emoji_1f632);
        sEmojisMap.put(0x1f61f, R.drawable.emoji_1f61f);
        sEmojisMap.put(0x1f626, R.drawable.emoji_1f626);
        sEmojisMap.put(0x1f627, R.drawable.emoji_1f627);
        sEmojisMap.put(0x1f608, R.drawable.emoji_1f608);
        sEmojisMap.put(0x1f47f, R.drawable.emoji_1f47f);
        sEmojisMap.put(0x1f62e, R.drawable.emoji_1f62e);
        sEmojisMap.put(0x1f62c, R.drawable.emoji_1f62c);
        sEmojisMap.put(0x1f610, R.drawable.emoji_1f610);
        sEmojisMap.put(0x1f615, R.drawable.emoji_1f615);
        sEmojisMap.put(0x1f62f, R.drawable.emoji_1f62f);
        sEmojisMap.put(0x1f636, R.drawable.emoji_1f636);
        sEmojisMap.put(0x1f607, R.drawable.emoji_1f607);
        sEmojisMap.put(0x1f60f, R.drawable.emoji_1f60f);
        sEmojisMap.put(0x1f611, R.drawable.emoji_1f611);
        sEmojisMap.put(0x1f472, R.drawable.emoji_1f472);
        sEmojisMap.put(0x1f473, R.drawable.emoji_1f473);
        sEmojisMap.put(0x1f46e, R.drawable.emoji_1f46e);
        sEmojisMap.put(0x1f477, R.drawable.emoji_1f477);
        sEmojisMap.put(0x1f482, R.drawable.emoji_1f482);
        sEmojisMap.put(0x1f476, R.drawable.emoji_1f476);
        sEmojisMap.put(0x1f466, R.drawable.emoji_1f466);
        sEmojisMap.put(0x1f467, R.drawable.emoji_1f467);
        sEmojisMap.put(0x1f468, R.drawable.emoji_1f468);
        sEmojisMap.put(0x1f469, R.drawable.emoji_1f469);
        sEmojisMap.put(0x1f474, R.drawable.emoji_1f474);
        sEmojisMap.put(0x1f475, R.drawable.emoji_1f475);
        sEmojisMap.put(0x1f471, R.drawable.emoji_1f471);
        sEmojisMap.put(0x1f47c, R.drawable.emoji_1f47c);
        sEmojisMap.put(0x1f478, R.drawable.emoji_1f478);
        sEmojisMap.put(0x1f63a, R.drawable.emoji_1f63a);
        sEmojisMap.put(0x1f638, R.drawable.emoji_1f638);
        sEmojisMap.put(0x1f63b, R.drawable.emoji_1f63b);
        sEmojisMap.put(0x1f63d, R.drawable.emoji_1f63d);
        sEmojisMap.put(0x1f63c, R.drawable.emoji_1f63c);
        sEmojisMap.put(0x1f640, R.drawable.emoji_1f640);
        sEmojisMap.put(0x1f63f, R.drawable.emoji_1f63f);
        sEmojisMap.put(0x1f639, R.drawable.emoji_1f639);
        sEmojisMap.put(0x1f63e, R.drawable.emoji_1f63e);
        sEmojisMap.put(0x1f479, R.drawable.emoji_1f479);
        sEmojisMap.put(0x1f47a, R.drawable.emoji_1f47a);
        sEmojisMap.put(0x1f648, R.drawable.emoji_1f648);
        sEmojisMap.put(0x1f649, R.drawable.emoji_1f649);
        sEmojisMap.put(0x1f64a, R.drawable.emoji_1f64a);
        sEmojisMap.put(0x1f480, R.drawable.emoji_1f480);
        sEmojisMap.put(0x1f47d, R.drawable.emoji_1f47d);
        sEmojisMap.put(0x1f4a9, R.drawable.emoji_1f4a9);
        sEmojisMap.put(0x1f525, R.drawable.emoji_1f525);
        sEmojisMap.put(10024, R.drawable.emoji_2728);
        sEmojisMap.put(0x1f31f, R.drawable.emoji_1f31f);
        sEmojisMap.put(0x1f4ab, R.drawable.emoji_1f4ab);
        sEmojisMap.put(0x1f4a5, R.drawable.emoji_1f4a5);
        sEmojisMap.put(0x1f4a2, R.drawable.emoji_1f4a2);
        sEmojisMap.put(0x1f4a6, R.drawable.emoji_1f4a6);
        sEmojisMap.put(0x1f4a7, R.drawable.emoji_1f4a7);
        sEmojisMap.put(0x1f4a4, R.drawable.emoji_1f4a4);
        sEmojisMap.put(0x1f4a8, R.drawable.emoji_1f4a8);
        sEmojisMap.put(0x1f442, R.drawable.emoji_1f442);
        sEmojisMap.put(0x1f440, R.drawable.emoji_1f440);
        sEmojisMap.put(0x1f443, R.drawable.emoji_1f443);
        sEmojisMap.put(0x1f445, R.drawable.emoji_1f445);
        sEmojisMap.put(0x1f444, R.drawable.emoji_1f444);
        sEmojisMap.put(0x1f44d, R.drawable.emoji_1f44d);
        sEmojisMap.put(0x1f44e, R.drawable.emoji_1f44e);
        sEmojisMap.put(0x1f44c, R.drawable.emoji_1f44c);
        sEmojisMap.put(0x1f44a, R.drawable.emoji_1f44a);
        sEmojisMap.put(9994, R.drawable.emoji_270a);
        sEmojisMap.put(9996, R.drawable.emoji_270c);
        sEmojisMap.put(0x1f44b, R.drawable.emoji_1f44b);
        sEmojisMap.put(9995, R.drawable.emoji_270b);
        sEmojisMap.put(0x1f450, R.drawable.emoji_1f450);
        sEmojisMap.put(0x1f446, R.drawable.emoji_1f446);
        sEmojisMap.put(0x1f447, R.drawable.emoji_1f447);
        sEmojisMap.put(0x1f449, R.drawable.emoji_1f449);
        sEmojisMap.put(0x1f448, R.drawable.emoji_1f448);
        sEmojisMap.put(0x1f64c, R.drawable.emoji_1f64c);
        sEmojisMap.put(0x1f64f, R.drawable.emoji_1f64f);
        sEmojisMap.put(9757, R.drawable.emoji_261d);
        sEmojisMap.put(0x1f44f, R.drawable.emoji_1f44f);
        sEmojisMap.put(0x1f4aa, R.drawable.emoji_1f4aa);
        sEmojisMap.put(0x1f6b6, R.drawable.emoji_1f6b6);
        sEmojisMap.put(0x1f3c3, R.drawable.emoji_1f3c3);
        sEmojisMap.put(0x1f483, R.drawable.emoji_1f483);
        sEmojisMap.put(0x1f46b, R.drawable.emoji_1f46b);
        sEmojisMap.put(0x1f46a, R.drawable.emoji_1f46a);
        sEmojisMap.put(0x1f46c, R.drawable.emoji_1f46c);
        sEmojisMap.put(0x1f46d, R.drawable.emoji_1f46d);
        sEmojisMap.put(0x1f48f, R.drawable.emoji_1f48f);
        sEmojisMap.put(0x1f491, R.drawable.emoji_1f491);
        sEmojisMap.put(0x1f46f, R.drawable.emoji_1f46f);
        sEmojisMap.put(0x1f646, R.drawable.emoji_1f646);
        sEmojisMap.put(0x1f645, R.drawable.emoji_1f645);
        sEmojisMap.put(0x1f481, R.drawable.emoji_1f481);
        sEmojisMap.put(0x1f64b, R.drawable.emoji_1f64b);
        sEmojisMap.put(0x1f486, R.drawable.emoji_1f486);
        sEmojisMap.put(0x1f487, R.drawable.emoji_1f487);
        sEmojisMap.put(0x1f485, R.drawable.emoji_1f485);
        sEmojisMap.put(0x1f470, R.drawable.emoji_1f470);
        sEmojisMap.put(0x1f64e, R.drawable.emoji_1f64e);
        sEmojisMap.put(0x1f64d, R.drawable.emoji_1f64d);
        sEmojisMap.put(0x1f647, R.drawable.emoji_1f647);
        sEmojisMap.put(0x1f3a9, R.drawable.emoji_1f3a9);
        sEmojisMap.put(0x1f451, R.drawable.emoji_1f451);
        sEmojisMap.put(0x1f452, R.drawable.emoji_1f452);
        sEmojisMap.put(0x1f45f, R.drawable.emoji_1f45f);
        sEmojisMap.put(0x1f45e, R.drawable.emoji_1f45e);
        sEmojisMap.put(0x1f461, R.drawable.emoji_1f461);
        sEmojisMap.put(0x1f460, R.drawable.emoji_1f460);
        sEmojisMap.put(0x1f462, R.drawable.emoji_1f462);
        sEmojisMap.put(0x1f455, R.drawable.emoji_1f455);
        sEmojisMap.put(0x1f454, R.drawable.emoji_1f454);
        sEmojisMap.put(0x1f45a, R.drawable.emoji_1f45a);
        sEmojisMap.put(0x1f457, R.drawable.emoji_1f457);
        sEmojisMap.put(0x1f3bd, R.drawable.emoji_1f3bd);
        sEmojisMap.put(0x1f456, R.drawable.emoji_1f456);
        sEmojisMap.put(0x1f458, R.drawable.emoji_1f458);
        sEmojisMap.put(0x1f459, R.drawable.emoji_1f459);
        sEmojisMap.put(0x1f4bc, R.drawable.emoji_1f4bc);
        sEmojisMap.put(0x1f45c, R.drawable.emoji_1f45c);
        sEmojisMap.put(0x1f45d, R.drawable.emoji_1f45d);
        sEmojisMap.put(0x1f45b, R.drawable.emoji_1f45b);
        sEmojisMap.put(0x1f453, R.drawable.emoji_1f453);
        sEmojisMap.put(0x1f380, R.drawable.emoji_1f380);
        sEmojisMap.put(0x1f302, R.drawable.emoji_1f302);
        sEmojisMap.put(0x1f484, R.drawable.emoji_1f484);
        sEmojisMap.put(0x1f49b, R.drawable.emoji_1f49b);
        sEmojisMap.put(0x1f499, R.drawable.emoji_1f499);
        sEmojisMap.put(0x1f49c, R.drawable.emoji_1f49c);
        sEmojisMap.put(0x1f49a, R.drawable.emoji_1f49a);
        sEmojisMap.put(10084, R.drawable.emoji_2764);
        sEmojisMap.put(0x1f494, R.drawable.emoji_1f494);
        sEmojisMap.put(0x1f497, R.drawable.emoji_1f497);
        sEmojisMap.put(0x1f493, R.drawable.emoji_1f493);
        sEmojisMap.put(0x1f495, R.drawable.emoji_1f495);
        sEmojisMap.put(0x1f496, R.drawable.emoji_1f496);
        sEmojisMap.put(0x1f49e, R.drawable.emoji_1f49e);
        sEmojisMap.put(0x1f498, R.drawable.emoji_1f498);
        sEmojisMap.put(0x1f48c, R.drawable.emoji_1f48c);
        sEmojisMap.put(0x1f48b, R.drawable.emoji_1f48b);
        sEmojisMap.put(0x1f48d, R.drawable.emoji_1f48d);
        sEmojisMap.put(0x1f48e, R.drawable.emoji_1f48e);
        sEmojisMap.put(0x1f464, R.drawable.emoji_1f464);
        sEmojisMap.put(0x1f465, R.drawable.emoji_1f465);
        sEmojisMap.put(0x1f4ac, R.drawable.emoji_1f4ac);
        sEmojisMap.put(0x1f463, R.drawable.emoji_1f463);
        sEmojisMap.put(0x1f4ad, R.drawable.emoji_1f4ad);
        sEmojisMap.put(0x1f436, R.drawable.emoji_1f436);
        sEmojisMap.put(0x1f43a, R.drawable.emoji_1f43a);
        sEmojisMap.put(0x1f431, R.drawable.emoji_1f431);
        sEmojisMap.put(0x1f42d, R.drawable.emoji_1f42d);
        sEmojisMap.put(0x1f439, R.drawable.emoji_1f439);
        sEmojisMap.put(0x1f430, R.drawable.emoji_1f430);
        sEmojisMap.put(0x1f438, R.drawable.emoji_1f438);
        sEmojisMap.put(0x1f42f, R.drawable.emoji_1f42f);
        sEmojisMap.put(0x1f428, R.drawable.emoji_1f428);
        sEmojisMap.put(0x1f43b, R.drawable.emoji_1f43b);
        sEmojisMap.put(0x1f437, R.drawable.emoji_1f437);
        sEmojisMap.put(0x1f43d, R.drawable.emoji_1f43d);
        sEmojisMap.put(0x1f42e, R.drawable.emoji_1f42e);
        sEmojisMap.put(0x1f417, R.drawable.emoji_1f417);
        sEmojisMap.put(0x1f435, R.drawable.emoji_1f435);
        sEmojisMap.put(0x1f412, R.drawable.emoji_1f412);
        sEmojisMap.put(0x1f434, R.drawable.emoji_1f434);
        sEmojisMap.put(0x1f411, R.drawable.emoji_1f411);
        sEmojisMap.put(0x1f418, R.drawable.emoji_1f418);
        sEmojisMap.put(0x1f43c, R.drawable.emoji_1f43c);
        sEmojisMap.put(0x1f427, R.drawable.emoji_1f427);
        sEmojisMap.put(0x1f426, R.drawable.emoji_1f426);
        sEmojisMap.put(0x1f424, R.drawable.emoji_1f424);
        sEmojisMap.put(0x1f425, R.drawable.emoji_1f425);
        sEmojisMap.put(0x1f423, R.drawable.emoji_1f423);
        sEmojisMap.put(0x1f414, R.drawable.emoji_1f414);
        sEmojisMap.put(0x1f40d, R.drawable.emoji_1f40d);
        sEmojisMap.put(0x1f422, R.drawable.emoji_1f422);
        sEmojisMap.put(0x1f41b, R.drawable.emoji_1f41b);
        sEmojisMap.put(0x1f41d, R.drawable.emoji_1f41d);
        sEmojisMap.put(0x1f41c, R.drawable.emoji_1f41c);
        sEmojisMap.put(0x1f41e, R.drawable.emoji_1f41e);
        sEmojisMap.put(0x1f40c, R.drawable.emoji_1f40c);
        sEmojisMap.put(0x1f419, R.drawable.emoji_1f419);
        sEmojisMap.put(0x1f41a, R.drawable.emoji_1f41a);
        sEmojisMap.put(0x1f420, R.drawable.emoji_1f420);
        sEmojisMap.put(0x1f41f, R.drawable.emoji_1f41f);
        sEmojisMap.put(0x1f42c, R.drawable.emoji_1f42c);
        sEmojisMap.put(0x1f433, R.drawable.emoji_1f433);
        sEmojisMap.put(0x1f40b, R.drawable.emoji_1f40b);
        sEmojisMap.put(0x1f404, R.drawable.emoji_1f404);
        sEmojisMap.put(0x1f40f, R.drawable.emoji_1f40f);
        sEmojisMap.put(0x1f400, R.drawable.emoji_1f400);
        sEmojisMap.put(0x1f403, R.drawable.emoji_1f403);
        sEmojisMap.put(0x1f405, R.drawable.emoji_1f405);
        sEmojisMap.put(0x1f407, R.drawable.emoji_1f407);
        sEmojisMap.put(0x1f409, R.drawable.emoji_1f409);
        sEmojisMap.put(0x1f40e, R.drawable.emoji_1f40e);
        sEmojisMap.put(0x1f410, R.drawable.emoji_1f410);
        sEmojisMap.put(0x1f413, R.drawable.emoji_1f413);
        sEmojisMap.put(0x1f415, R.drawable.emoji_1f415);
        sEmojisMap.put(0x1f416, R.drawable.emoji_1f416);
        sEmojisMap.put(0x1f401, R.drawable.emoji_1f401);
        sEmojisMap.put(0x1f402, R.drawable.emoji_1f402);
        sEmojisMap.put(0x1f432, R.drawable.emoji_1f432);
        sEmojisMap.put(0x1f421, R.drawable.emoji_1f421);
        sEmojisMap.put(0x1f40a, R.drawable.emoji_1f40a);
        sEmojisMap.put(0x1f42b, R.drawable.emoji_1f42b);
        sEmojisMap.put(0x1f42a, R.drawable.emoji_1f42a);
        sEmojisMap.put(0x1f406, R.drawable.emoji_1f406);
        sEmojisMap.put(0x1f408, R.drawable.emoji_1f408);
        sEmojisMap.put(0x1f429, R.drawable.emoji_1f429);
        sEmojisMap.put(0x1f43e, R.drawable.emoji_1f43e);
        sEmojisMap.put(0x1f490, R.drawable.emoji_1f490);
        sEmojisMap.put(0x1f338, R.drawable.emoji_1f338);
        sEmojisMap.put(0x1f337, R.drawable.emoji_1f337);
        sEmojisMap.put(0x1f340, R.drawable.emoji_1f340);
        sEmojisMap.put(0x1f339, R.drawable.emoji_1f339);
        sEmojisMap.put(0x1f33b, R.drawable.emoji_1f33b);
        sEmojisMap.put(0x1f33a, R.drawable.emoji_1f33a);
        sEmojisMap.put(0x1f341, R.drawable.emoji_1f341);
        sEmojisMap.put(0x1f343, R.drawable.emoji_1f343);
        sEmojisMap.put(0x1f342, R.drawable.emoji_1f342);
        sEmojisMap.put(0x1f33f, R.drawable.emoji_1f33f);
        sEmojisMap.put(0x1f33e, R.drawable.emoji_1f33e);
        sEmojisMap.put(0x1f344, R.drawable.emoji_1f344);
        sEmojisMap.put(0x1f335, R.drawable.emoji_1f335);
        sEmojisMap.put(0x1f334, R.drawable.emoji_1f334);
        sEmojisMap.put(0x1f332, R.drawable.emoji_1f332);
        sEmojisMap.put(0x1f333, R.drawable.emoji_1f333);
        sEmojisMap.put(0x1f330, R.drawable.emoji_1f330);
        sEmojisMap.put(0x1f331, R.drawable.emoji_1f331);
        sEmojisMap.put(0x1f33c, R.drawable.emoji_1f33c);
        sEmojisMap.put(0x1f310, R.drawable.emoji_1f310);
        sEmojisMap.put(0x1f31e, R.drawable.emoji_1f31e);
        sEmojisMap.put(0x1f31d, R.drawable.emoji_1f31d);
        sEmojisMap.put(0x1f31a, R.drawable.emoji_1f31a);
        sEmojisMap.put(0x1f311, R.drawable.emoji_1f311);
        sEmojisMap.put(0x1f312, R.drawable.emoji_1f312);
        sEmojisMap.put(0x1f313, R.drawable.emoji_1f313);
        sEmojisMap.put(0x1f314, R.drawable.emoji_1f314);
        sEmojisMap.put(0x1f315, R.drawable.emoji_1f315);
        sEmojisMap.put(0x1f316, R.drawable.emoji_1f316);
        sEmojisMap.put(0x1f317, R.drawable.emoji_1f317);
        sEmojisMap.put(0x1f318, R.drawable.emoji_1f318);
        sEmojisMap.put(0x1f31c, R.drawable.emoji_1f31c);
        sEmojisMap.put(0x1f31b, R.drawable.emoji_1f31b);
        sEmojisMap.put(0x1f319, R.drawable.emoji_1f319);
        sEmojisMap.put(0x1f30d, R.drawable.emoji_1f30d);
        sEmojisMap.put(0x1f30e, R.drawable.emoji_1f30e);
        sEmojisMap.put(0x1f30f, R.drawable.emoji_1f30f);
        sEmojisMap.put(0x1f30b, R.drawable.emoji_1f30b);
        sEmojisMap.put(0x1f30c, R.drawable.emoji_1f30c);
        sEmojisMap.put(0x1f320, R.drawable.emoji_1f303);
        sEmojisMap.put(11088, R.drawable.emoji_2b50);
        sEmojisMap.put(9728, R.drawable.emoji_2600);
        sEmojisMap.put(9925, R.drawable.emoji_26c5);
        sEmojisMap.put(9729, R.drawable.emoji_2601);
        sEmojisMap.put(9889, R.drawable.emoji_26a1);
        sEmojisMap.put(9748, R.drawable.emoji_2614);
        sEmojisMap.put(10052, R.drawable.emoji_2744);
        sEmojisMap.put(9924, R.drawable.emoji_26c4);
        sEmojisMap.put(0x1f300, R.drawable.emoji_1f300);
        sEmojisMap.put(0x1f301, R.drawable.emoji_1f301);
        sEmojisMap.put(0x1f308, R.drawable.emoji_1f308);
        sEmojisMap.put(0x1f30a, R.drawable.emoji_1f30a);
        sEmojisMap.put(0x1f38d, R.drawable.emoji_1f38d);
        sEmojisMap.put(0x1f49d, R.drawable.emoji_1f49d);
        sEmojisMap.put(0x1f38e, R.drawable.emoji_1f38e);
        sEmojisMap.put(0x1f392, R.drawable.emoji_1f392);
        sEmojisMap.put(0x1f393, R.drawable.emoji_1f393);
        sEmojisMap.put(0x1f38f, R.drawable.emoji_1f38f);
        sEmojisMap.put(0x1f386, R.drawable.emoji_1f386);
        sEmojisMap.put(0x1f387, R.drawable.emoji_1f387);
        sEmojisMap.put(0x1f390, R.drawable.emoji_1f390);
        sEmojisMap.put(0x1f391, R.drawable.emoji_1f391);
        sEmojisMap.put(0x1f383, R.drawable.emoji_1f383);
        sEmojisMap.put(0x1f47b, R.drawable.emoji_1f47b);
        sEmojisMap.put(0x1f385, R.drawable.emoji_1f385);
        sEmojisMap.put(0x1f384, R.drawable.emoji_1f384);
        sEmojisMap.put(0x1f381, R.drawable.emoji_1f381);
        sEmojisMap.put(0x1f38b, R.drawable.emoji_1f38b);
        sEmojisMap.put(0x1f389, R.drawable.emoji_1f389);
        sEmojisMap.put(0x1f38a, R.drawable.emoji_1f38a);
        sEmojisMap.put(0x1f388, R.drawable.emoji_1f388);
        sEmojisMap.put(0x1f38c, R.drawable.emoji_1f38c);
        sEmojisMap.put(0x1f52e, R.drawable.emoji_1f52e);
        sEmojisMap.put(0x1f3a5, R.drawable.emoji_1f3a5);
        sEmojisMap.put(0x1f4f7, R.drawable.emoji_1f4f7);
        sEmojisMap.put(0x1f4f9, R.drawable.emoji_1f4f9);
        sEmojisMap.put(0x1f4fc, R.drawable.emoji_1f4fc);
        sEmojisMap.put(0x1f4bf, R.drawable.emoji_1f4bf);
        sEmojisMap.put(0x1f4c0, R.drawable.emoji_1f4c0);
        sEmojisMap.put(0x1f4bd, R.drawable.emoji_1f4bd);
        sEmojisMap.put(0x1f4be, R.drawable.emoji_1f4be);
        sEmojisMap.put(0x1f4bb, R.drawable.emoji_1f4bb);
        sEmojisMap.put(0x1f4f1, R.drawable.emoji_1f4f1);
        sEmojisMap.put(9742, R.drawable.emoji_260e);
        sEmojisMap.put(0x1f4de, R.drawable.emoji_1f4de);
        sEmojisMap.put(0x1f4df, R.drawable.emoji_1f4df);
        sEmojisMap.put(0x1f4e0, R.drawable.emoji_1f4e0);
        sEmojisMap.put(0x1f4e1, R.drawable.emoji_1f4e1);
        sEmojisMap.put(0x1f4fa, R.drawable.emoji_1f4fa);
        sEmojisMap.put(0x1f4fb, R.drawable.emoji_1f4fb);
        sEmojisMap.put(0x1f50a, R.drawable.emoji_1f50a);
        sEmojisMap.put(0x1f509, R.drawable.emoji_1f509);
        sEmojisMap.put(0x1f508, R.drawable.emoji_1f508);
        sEmojisMap.put(0x1f507, R.drawable.emoji_1f507);
        sEmojisMap.put(0x1f514, R.drawable.emoji_1f514);
        sEmojisMap.put(0x1f515, R.drawable.emoji_1f515);
        sEmojisMap.put(0x1f4e2, R.drawable.emoji_1f4e2);
        sEmojisMap.put(0x1f4e3, R.drawable.emoji_1f4e3);
        sEmojisMap.put(9203, R.drawable.emoji_23f3);
        sEmojisMap.put(8987, R.drawable.emoji_231b);
        sEmojisMap.put(9200, R.drawable.emoji_23f0);
        sEmojisMap.put(8986, R.drawable.emoji_231a);
        sEmojisMap.put(0x1f513, R.drawable.emoji_1f513);
        sEmojisMap.put(0x1f512, R.drawable.emoji_1f512);
        sEmojisMap.put(0x1f50f, R.drawable.emoji_1f50f);
        sEmojisMap.put(0x1f510, R.drawable.emoji_1f510);
        sEmojisMap.put(0x1f511, R.drawable.emoji_1f511);
        sEmojisMap.put(0x1f50e, R.drawable.emoji_1f50e);
        sEmojisMap.put(0x1f4a1, R.drawable.emoji_1f4a1);
        sEmojisMap.put(0x1f526, R.drawable.emoji_1f526);
        sEmojisMap.put(0x1f506, R.drawable.emoji_1f506);
        sEmojisMap.put(0x1f505, R.drawable.emoji_1f505);
        sEmojisMap.put(0x1f50c, R.drawable.emoji_1f50c);
        sEmojisMap.put(0x1f50b, R.drawable.emoji_1f50b);
        sEmojisMap.put(0x1f50d, R.drawable.emoji_1f50d);
        sEmojisMap.put(0x1f6c1, R.drawable.emoji_1f6c1);
        sEmojisMap.put(0x1f6c0, R.drawable.emoji_1f6c0);
        sEmojisMap.put(0x1f6bf, R.drawable.emoji_1f6bf);
        sEmojisMap.put(0x1f6bd, R.drawable.emoji_1f6bd);
        sEmojisMap.put(0x1f527, R.drawable.emoji_1f527);
        sEmojisMap.put(0x1f529, R.drawable.emoji_1f529);
        sEmojisMap.put(0x1f528, R.drawable.emoji_1f528);
        sEmojisMap.put(0x1f6aa, R.drawable.emoji_1f6aa);
        sEmojisMap.put(0x1f6ac, R.drawable.emoji_1f6ac);
        sEmojisMap.put(0x1f4a3, R.drawable.emoji_1f4a3);
        sEmojisMap.put(0x1f52b, R.drawable.emoji_1f52b);
        sEmojisMap.put(0x1f52a, R.drawable.emoji_1f52a);
        sEmojisMap.put(0x1f48a, R.drawable.emoji_1f48a);
        sEmojisMap.put(0x1f489, R.drawable.emoji_1f489);
        sEmojisMap.put(0x1f4b0, R.drawable.emoji_1f4b0);
        sEmojisMap.put(0x1f4b4, R.drawable.emoji_1f4b4);
        sEmojisMap.put(0x1f4b5, R.drawable.emoji_1f4b5);
        sEmojisMap.put(0x1f4b7, R.drawable.emoji_1f4b7);
        sEmojisMap.put(0x1f4b6, R.drawable.emoji_1f4b6);
        sEmojisMap.put(0x1f4b3, R.drawable.emoji_1f4b3);
        sEmojisMap.put(0x1f4b8, R.drawable.emoji_1f4b8);
        sEmojisMap.put(0x1f4f2, R.drawable.emoji_1f4f2);
        sEmojisMap.put(0x1f4e7, R.drawable.emoji_1f4e7);
        sEmojisMap.put(0x1f4e5, R.drawable.emoji_1f4e5);
        sEmojisMap.put(0x1f4e4, R.drawable.emoji_1f4e4);
        sEmojisMap.put(9993, R.drawable.emoji_2709);
        sEmojisMap.put(0x1f4e9, R.drawable.emoji_1f4e9);
        sEmojisMap.put(0x1f4e8, R.drawable.emoji_1f4e8);
        sEmojisMap.put(0x1f4ef, R.drawable.emoji_1f4ef);
        sEmojisMap.put(0x1f4eb, R.drawable.emoji_1f4eb);
        sEmojisMap.put(0x1f4ea, R.drawable.emoji_1f4ea);
        sEmojisMap.put(0x1f4ec, R.drawable.emoji_1f4ec);
        sEmojisMap.put(0x1f4ed, R.drawable.emoji_1f4ed);
        sEmojisMap.put(0x1f4ee, R.drawable.emoji_1f4ee);
        sEmojisMap.put(0x1f4e6, R.drawable.emoji_1f4e6);
        sEmojisMap.put(0x1f4dd, R.drawable.emoji_1f4dd);
        sEmojisMap.put(0x1f4c4, R.drawable.emoji_1f4c4);
        sEmojisMap.put(0x1f4c3, R.drawable.emoji_1f4c3);
        sEmojisMap.put(0x1f4d1, R.drawable.emoji_1f4d1);
        sEmojisMap.put(0x1f4ca, R.drawable.emoji_1f4ca);
        sEmojisMap.put(0x1f4c8, R.drawable.emoji_1f4c8);
        sEmojisMap.put(0x1f4c9, R.drawable.emoji_1f4c9);
        sEmojisMap.put(0x1f4dc, R.drawable.emoji_1f4dc);
        sEmojisMap.put(0x1f4cb, R.drawable.emoji_1f4cb);
        sEmojisMap.put(0x1f4c5, R.drawable.emoji_1f4c5);
        sEmojisMap.put(0x1f4c6, R.drawable.emoji_1f4c6);
        sEmojisMap.put(0x1f4c7, R.drawable.emoji_1f4c7);
        sEmojisMap.put(0x1f4c1, R.drawable.emoji_1f4c1);
        sEmojisMap.put(0x1f4c2, R.drawable.emoji_1f4c2);
        sEmojisMap.put(9986, R.drawable.emoji_2702);
        sEmojisMap.put(0x1f4cc, R.drawable.emoji_1f4cc);
        sEmojisMap.put(0x1f4ce, R.drawable.emoji_1f4ce);
        sEmojisMap.put(10002, R.drawable.emoji_2712);
        sEmojisMap.put(9999, R.drawable.emoji_270f);
        sEmojisMap.put(0x1f4cf, R.drawable.emoji_1f4cf);
        sEmojisMap.put(0x1f4d0, R.drawable.emoji_1f4d0);
        sEmojisMap.put(0x1f4d5, R.drawable.emoji_1f4d5);
        sEmojisMap.put(0x1f4d7, R.drawable.emoji_1f4d7);
        sEmojisMap.put(0x1f4d8, R.drawable.emoji_1f4d8);
        sEmojisMap.put(0x1f4d9, R.drawable.emoji_1f4d9);
        sEmojisMap.put(0x1f4d3, R.drawable.emoji_1f4d3);
        sEmojisMap.put(0x1f4d4, R.drawable.emoji_1f4d4);
        sEmojisMap.put(0x1f4d2, R.drawable.emoji_1f4d2);
        sEmojisMap.put(0x1f4da, R.drawable.emoji_1f4da);
        sEmojisMap.put(0x1f4d6, R.drawable.emoji_1f4d6);
        sEmojisMap.put(0x1f516, R.drawable.emoji_1f516);
        sEmojisMap.put(0x1f4db, R.drawable.emoji_1f4db);
        sEmojisMap.put(0x1f52c, R.drawable.emoji_1f52c);
        sEmojisMap.put(0x1f52d, R.drawable.emoji_1f52d);
        sEmojisMap.put(0x1f4f0, R.drawable.emoji_1f4f0);
        sEmojisMap.put(0x1f3a8, R.drawable.emoji_1f3a8);
        sEmojisMap.put(0x1f3ac, R.drawable.emoji_1f3ac);
        sEmojisMap.put(0x1f3a4, R.drawable.emoji_1f3a4);
        sEmojisMap.put(0x1f3a7, R.drawable.emoji_1f3a7);
        sEmojisMap.put(0x1f3bc, R.drawable.emoji_1f3bc);
        sEmojisMap.put(0x1f3b5, R.drawable.emoji_1f3b5);
        sEmojisMap.put(0x1f3b6, R.drawable.emoji_1f3b6);
        sEmojisMap.put(0x1f3b9, R.drawable.emoji_1f3b9);
        sEmojisMap.put(0x1f3bb, R.drawable.emoji_1f3bb);
        sEmojisMap.put(0x1f3ba, R.drawable.emoji_1f3ba);
        sEmojisMap.put(0x1f3b7, R.drawable.emoji_1f3b7);
        sEmojisMap.put(0x1f3b8, R.drawable.emoji_1f3b8);
        sEmojisMap.put(0x1f47e, R.drawable.emoji_1f47e);
        sEmojisMap.put(0x1f3ae, R.drawable.emoji_1f3ae);
        sEmojisMap.put(0x1f0cf, R.drawable.emoji_1f0cf);
        sEmojisMap.put(0x1f3b4, R.drawable.emoji_1f3b4);
        sEmojisMap.put(0x1f004, R.drawable.emoji_1f004);
        sEmojisMap.put(0x1f3b2, R.drawable.emoji_1f3b2);
        sEmojisMap.put(0x1f3af, R.drawable.emoji_1f3af);
        sEmojisMap.put(0x1f3c8, R.drawable.emoji_1f3c8);
        sEmojisMap.put(0x1f3c0, R.drawable.emoji_1f3c0);
        sEmojisMap.put(9917, R.drawable.emoji_26bd);
        sEmojisMap.put(9918, R.drawable.emoji_26be);
        sEmojisMap.put(0x1f3be, R.drawable.emoji_1f3be);
        sEmojisMap.put(0x1f3b1, R.drawable.emoji_1f3b1);
        sEmojisMap.put(0x1f3c9, R.drawable.emoji_1f3c9);
        sEmojisMap.put(0x1f3b3, R.drawable.emoji_1f3b3);
        sEmojisMap.put(9971, R.drawable.emoji_26f3);
        sEmojisMap.put(0x1f6b5, R.drawable.emoji_1f6b5);
        sEmojisMap.put(0x1f6b4, R.drawable.emoji_1f6b4);
        sEmojisMap.put(0x1f3c1, R.drawable.emoji_1f3c1);
        sEmojisMap.put(0x1f3c7, R.drawable.emoji_1f3c7);
        sEmojisMap.put(0x1f3c6, R.drawable.emoji_1f3c6);
        sEmojisMap.put(0x1f3bf, R.drawable.emoji_1f3bf);
        sEmojisMap.put(0x1f3c2, R.drawable.emoji_1f3c2);
        sEmojisMap.put(0x1f3ca, R.drawable.emoji_1f3ca);
        sEmojisMap.put(0x1f3c4, R.drawable.emoji_1f3c4);
        sEmojisMap.put(0x1f3a3, R.drawable.emoji_1f3a3);
        sEmojisMap.put(9749, R.drawable.emoji_2615);
        sEmojisMap.put(0x1f375, R.drawable.emoji_1f375);
        sEmojisMap.put(0x1f376, R.drawable.emoji_1f376);
        sEmojisMap.put(0x1f37c, R.drawable.emoji_1f37c);
        sEmojisMap.put(0x1f37a, R.drawable.emoji_1f37a);
        sEmojisMap.put(0x1f37b, R.drawable.emoji_1f37b);
        sEmojisMap.put(0x1f378, R.drawable.emoji_1f378);
        sEmojisMap.put(0x1f379, R.drawable.emoji_1f379);
        sEmojisMap.put(0x1f377, R.drawable.emoji_1f377);
        sEmojisMap.put(0x1f374, R.drawable.emoji_1f374);
        sEmojisMap.put(0x1f355, R.drawable.emoji_1f355);
        sEmojisMap.put(0x1f354, R.drawable.emoji_1f354);
        sEmojisMap.put(0x1f35f, R.drawable.emoji_1f35f);
        sEmojisMap.put(0x1f357, R.drawable.emoji_1f357);
        sEmojisMap.put(0x1f356, R.drawable.emoji_1f356);
        sEmojisMap.put(0x1f35d, R.drawable.emoji_1f35d);
        sEmojisMap.put(0x1f35b, R.drawable.emoji_1f35b);
        sEmojisMap.put(0x1f364, R.drawable.emoji_1f364);
        sEmojisMap.put(0x1f371, R.drawable.emoji_1f371);
        sEmojisMap.put(0x1f363, R.drawable.emoji_1f363);
        sEmojisMap.put(0x1f365, R.drawable.emoji_1f365);
        sEmojisMap.put(0x1f359, R.drawable.emoji_1f359);
        sEmojisMap.put(0x1f358, R.drawable.emoji_1f358);
        sEmojisMap.put(0x1f35a, R.drawable.emoji_1f35a);
        sEmojisMap.put(0x1f35c, R.drawable.emoji_1f35c);
        sEmojisMap.put(0x1f372, R.drawable.emoji_1f372);
        sEmojisMap.put(0x1f362, R.drawable.emoji_1f362);
        sEmojisMap.put(0x1f361, R.drawable.emoji_1f361);
        sEmojisMap.put(0x1f373, R.drawable.emoji_1f373);
        sEmojisMap.put(0x1f35e, R.drawable.emoji_1f35e);
        sEmojisMap.put(0x1f369, R.drawable.emoji_1f369);
        sEmojisMap.put(0x1f36e, R.drawable.emoji_1f36e);
        sEmojisMap.put(0x1f366, R.drawable.emoji_1f366);
        sEmojisMap.put(0x1f368, R.drawable.emoji_1f368);
        sEmojisMap.put(0x1f367, R.drawable.emoji_1f367);
        sEmojisMap.put(0x1f382, R.drawable.emoji_1f382);
        sEmojisMap.put(0x1f370, R.drawable.emoji_1f370);
        sEmojisMap.put(0x1f36a, R.drawable.emoji_1f36a);
        sEmojisMap.put(0x1f36b, R.drawable.emoji_1f36b);
        sEmojisMap.put(0x1f36c, R.drawable.emoji_1f36c);
        sEmojisMap.put(0x1f36d, R.drawable.emoji_1f36d);
        sEmojisMap.put(0x1f36f, R.drawable.emoji_1f36f);
        sEmojisMap.put(0x1f34e, R.drawable.emoji_1f34e);
        sEmojisMap.put(0x1f34f, R.drawable.emoji_1f34f);
        sEmojisMap.put(0x1f34a, R.drawable.emoji_1f34a);
        sEmojisMap.put(0x1f34b, R.drawable.emoji_1f34b);
        sEmojisMap.put(0x1f352, R.drawable.emoji_1f352);
        sEmojisMap.put(0x1f347, R.drawable.emoji_1f347);
        sEmojisMap.put(0x1f349, R.drawable.emoji_1f349);
        sEmojisMap.put(0x1f353, R.drawable.emoji_1f353);
        sEmojisMap.put(0x1f351, R.drawable.emoji_1f351);
        sEmojisMap.put(0x1f348, R.drawable.emoji_1f348);
        sEmojisMap.put(0x1f34c, R.drawable.emoji_1f34c);
        sEmojisMap.put(0x1f350, R.drawable.emoji_1f350);
        sEmojisMap.put(0x1f34d, R.drawable.emoji_1f34d);
        sEmojisMap.put(0x1f360, R.drawable.emoji_1f360);
        sEmojisMap.put(0x1f346, R.drawable.emoji_1f346);
        sEmojisMap.put(0x1f345, R.drawable.emoji_1f345);
        sEmojisMap.put(0x1f33d, R.drawable.emoji_1f33d);
        sEmojisMap.put(0x1f3e0, R.drawable.emoji_1f3e0);
        sEmojisMap.put(0x1f3e1, R.drawable.emoji_1f3e1);
        sEmojisMap.put(0x1f3eb, R.drawable.emoji_1f3eb);
        sEmojisMap.put(0x1f3e2, R.drawable.emoji_1f3e2);
        sEmojisMap.put(0x1f3e3, R.drawable.emoji_1f3e3);
        sEmojisMap.put(0x1f3e5, R.drawable.emoji_1f3e5);
        sEmojisMap.put(0x1f3e6, R.drawable.emoji_1f3e6);
        sEmojisMap.put(0x1f3ea, R.drawable.emoji_1f3ea);
        sEmojisMap.put(0x1f3e9, R.drawable.emoji_1f3e9);
        sEmojisMap.put(0x1f3e8, R.drawable.emoji_1f3e8);
        sEmojisMap.put(0x1f492, R.drawable.emoji_1f492);
        sEmojisMap.put(9962, R.drawable.emoji_26ea);
        sEmojisMap.put(0x1f3ec, R.drawable.emoji_1f3ec);
        sEmojisMap.put(0x1f3e4, R.drawable.emoji_1f3e4);
        sEmojisMap.put(0x1f307, R.drawable.emoji_1f307);
        sEmojisMap.put(0x1f306, R.drawable.emoji_1f306);
        sEmojisMap.put(0x1f3ef, R.drawable.emoji_1f3ef);
        sEmojisMap.put(0x1f3f0, R.drawable.emoji_1f3f0);
        sEmojisMap.put(9978, R.drawable.emoji_26fa);
        sEmojisMap.put(0x1f3ed, R.drawable.emoji_1f3ed);
        sEmojisMap.put(0x1f5fc, R.drawable.emoji_1f5fc);
        sEmojisMap.put(0x1f5fe, R.drawable.emoji_1f5fe);
        sEmojisMap.put(0x1f5fb, R.drawable.emoji_1f5fb);
        sEmojisMap.put(0x1f304, R.drawable.emoji_1f304);
        sEmojisMap.put(0x1f305, R.drawable.emoji_1f305);
        sEmojisMap.put(0x1f303, R.drawable.emoji_1f303);
        sEmojisMap.put(0x1f5fd, R.drawable.emoji_1f5fd);
        sEmojisMap.put(0x1f309, R.drawable.emoji_1f309);
        sEmojisMap.put(0x1f3a0, R.drawable.emoji_1f3a0);
        sEmojisMap.put(0x1f3a1, R.drawable.emoji_1f3a1);
        sEmojisMap.put(9970, R.drawable.emoji_26f2);
        sEmojisMap.put(0x1f3a2, R.drawable.emoji_1f3a2);
        sEmojisMap.put(0x1f6a2, R.drawable.emoji_1f6a2);
        sEmojisMap.put(9973, R.drawable.emoji_26f5);
        sEmojisMap.put(0x1f6a4, R.drawable.emoji_1f6a4);
        sEmojisMap.put(0x1f6a3, R.drawable.emoji_1f6a3);
        sEmojisMap.put(9875, R.drawable.emoji_2693);
        sEmojisMap.put(0x1f680, R.drawable.emoji_1f680);
        sEmojisMap.put(9992, R.drawable.emoji_2708);
        sEmojisMap.put(0x1f4ba, R.drawable.emoji_1f4ba);
        sEmojisMap.put(0x1f681, R.drawable.emoji_1f681);
        sEmojisMap.put(0x1f682, R.drawable.emoji_1f682);
        sEmojisMap.put(0x1f68a, R.drawable.emoji_1f68a);
        sEmojisMap.put(0x1f689, R.drawable.emoji_1f689);
        sEmojisMap.put(0x1f69e, R.drawable.emoji_1f69e);
        sEmojisMap.put(0x1f686, R.drawable.emoji_1f686);
        sEmojisMap.put(0x1f684, R.drawable.emoji_1f684);
        sEmojisMap.put(0x1f685, R.drawable.emoji_1f685);
        sEmojisMap.put(0x1f688, R.drawable.emoji_1f688);
        sEmojisMap.put(0x1f687, R.drawable.emoji_1f687);
        sEmojisMap.put(0x1f69d, R.drawable.emoji_1f69d);
        sEmojisMap.put(0x1f68b, R.drawable.emoji_1f68b);
        sEmojisMap.put(0x1f683, R.drawable.emoji_1f683);
        sEmojisMap.put(0x1f68e, R.drawable.emoji_1f68e);
        sEmojisMap.put(0x1f68c, R.drawable.emoji_1f68c);
        sEmojisMap.put(0x1f68d, R.drawable.emoji_1f68d);
        sEmojisMap.put(0x1f699, R.drawable.emoji_1f699);
        sEmojisMap.put(0x1f698, R.drawable.emoji_1f698);
        sEmojisMap.put(0x1f697, R.drawable.emoji_1f697);
        sEmojisMap.put(0x1f695, R.drawable.emoji_1f695);
        sEmojisMap.put(0x1f696, R.drawable.emoji_1f696);
        sEmojisMap.put(0x1f69b, R.drawable.emoji_1f69b);
        sEmojisMap.put(0x1f69a, R.drawable.emoji_1f69a);
        sEmojisMap.put(0x1f6a8, R.drawable.emoji_1f6a8);
        sEmojisMap.put(0x1f693, R.drawable.emoji_1f693);
        sEmojisMap.put(0x1f694, R.drawable.emoji_1f694);
        sEmojisMap.put(0x1f692, R.drawable.emoji_1f692);
        sEmojisMap.put(0x1f691, R.drawable.emoji_1f691);
        sEmojisMap.put(0x1f690, R.drawable.emoji_1f690);
        sEmojisMap.put(0x1f6b2, R.drawable.emoji_1f6b2);
        sEmojisMap.put(0x1f6a1, R.drawable.emoji_1f6a1);
        sEmojisMap.put(0x1f69f, R.drawable.emoji_1f69f);
        sEmojisMap.put(0x1f6a0, R.drawable.emoji_1f6a0);
        sEmojisMap.put(0x1f69c, R.drawable.emoji_1f69c);
        sEmojisMap.put(0x1f488, R.drawable.emoji_1f488);
        sEmojisMap.put(0x1f68f, R.drawable.emoji_1f68f);
        sEmojisMap.put(0x1f3ab, R.drawable.emoji_1f3ab);
        sEmojisMap.put(0x1f6a6, R.drawable.emoji_1f6a6);
        sEmojisMap.put(0x1f6a5, R.drawable.emoji_1f6a5);
        sEmojisMap.put(9888, R.drawable.emoji_26a0);
        sEmojisMap.put(0x1f6a7, R.drawable.emoji_1f6a7);
        sEmojisMap.put(0x1f530, R.drawable.emoji_1f530);
        sEmojisMap.put(9981, R.drawable.emoji_26fd);
        sEmojisMap.put(0x1f3ee, R.drawable.emoji_1f3ee);
        sEmojisMap.put(0x1f3b0, R.drawable.emoji_1f3b0);
        sEmojisMap.put(9832, R.drawable.emoji_2668);
        sEmojisMap.put(0x1f5ff, R.drawable.emoji_1f5ff);
        sEmojisMap.put(0x1f3aa, R.drawable.emoji_1f3aa);
        sEmojisMap.put(0x1f3ad, R.drawable.emoji_1f3ad);
        sEmojisMap.put(0x1f4cd, R.drawable.emoji_1f4cd);
        sEmojisMap.put(0x1f6a9, R.drawable.emoji_1f6a9);
        sEmojisMap.put(0x1f51f, R.drawable.emoji_1f51f);
        sEmojisMap.put(0x1f522, R.drawable.emoji_1f522);
        sEmojisMap.put(0x1f523, R.drawable.emoji_1f523);
        sEmojisMap.put(11014, R.drawable.emoji_2b06);
        sEmojisMap.put(11015, R.drawable.emoji_2b07);
        sEmojisMap.put(11013, R.drawable.emoji_2b05);
        sEmojisMap.put(10145, R.drawable.emoji_27a1);
        sEmojisMap.put(0x1f520, R.drawable.emoji_1f520);
        sEmojisMap.put(0x1f521, R.drawable.emoji_1f521);
        sEmojisMap.put(0x1f524, R.drawable.emoji_1f524);
        sEmojisMap.put(8599, R.drawable.emoji_2197);
        sEmojisMap.put(8598, R.drawable.emoji_2196);
        sEmojisMap.put(8600, R.drawable.emoji_2198);
        sEmojisMap.put(8601, R.drawable.emoji_2199);
        sEmojisMap.put(8596, R.drawable.emoji_2194);
        sEmojisMap.put(8597, R.drawable.emoji_2195);
        sEmojisMap.put(0x1f504, R.drawable.emoji_1f504);
        sEmojisMap.put(9664, R.drawable.emoji_25c0);
        sEmojisMap.put(9654, R.drawable.emoji_25b6);
        sEmojisMap.put(0x1f53c, R.drawable.emoji_1f53c);
        sEmojisMap.put(0x1f53d, R.drawable.emoji_1f53d);
        sEmojisMap.put(8617, R.drawable.emoji_21a9);
        sEmojisMap.put(8618, R.drawable.emoji_21aa);
        sEmojisMap.put(8505, R.drawable.emoji_2139);
        sEmojisMap.put(9194, R.drawable.emoji_23ea);
        sEmojisMap.put(9193, R.drawable.emoji_23e9);
        sEmojisMap.put(9195, R.drawable.emoji_23eb);
        sEmojisMap.put(9196, R.drawable.emoji_23ec);
        sEmojisMap.put(10549, R.drawable.emoji_2935);
        sEmojisMap.put(10548, R.drawable.emoji_2934);
        sEmojisMap.put(0x1f197, R.drawable.emoji_1f197);
        sEmojisMap.put(0x1f500, R.drawable.emoji_1f500);
        sEmojisMap.put(0x1f501, R.drawable.emoji_1f501);
        sEmojisMap.put(0x1f502, R.drawable.emoji_1f502);
        sEmojisMap.put(0x1f195, R.drawable.emoji_1f195);
        sEmojisMap.put(0x1f199, R.drawable.emoji_1f199);
        sEmojisMap.put(0x1f192, R.drawable.emoji_1f192);
        sEmojisMap.put(0x1f193, R.drawable.emoji_1f193);
        sEmojisMap.put(0x1f196, R.drawable.emoji_1f196);
        sEmojisMap.put(0x1f4f6, R.drawable.emoji_1f4f6);
        sEmojisMap.put(0x1f3a6, R.drawable.emoji_1f3a6);
        sEmojisMap.put(0x1f201, R.drawable.emoji_1f201);
        sEmojisMap.put(0x1f22f, R.drawable.emoji_1f22f);
        sEmojisMap.put(0x1f233, R.drawable.emoji_1f233);
        sEmojisMap.put(0x1f235, R.drawable.emoji_1f235);
        sEmojisMap.put(0x1f234, R.drawable.emoji_1f234);
        sEmojisMap.put(0x1f232, R.drawable.emoji_1f232);
        sEmojisMap.put(0x1f250, R.drawable.emoji_1f250);
        sEmojisMap.put(0x1f239, R.drawable.emoji_1f239);
        sEmojisMap.put(0x1f23a, R.drawable.emoji_1f23a);
        sEmojisMap.put(0x1f236, R.drawable.emoji_1f236);
        sEmojisMap.put(0x1f21a, R.drawable.emoji_1f21a);
        sEmojisMap.put(0x1f6bb, R.drawable.emoji_1f6bb);
        sEmojisMap.put(0x1f6b9, R.drawable.emoji_1f6b9);
        sEmojisMap.put(0x1f6ba, R.drawable.emoji_1f6ba);
        sEmojisMap.put(0x1f6bc, R.drawable.emoji_1f6bc);
        sEmojisMap.put(0x1f6be, R.drawable.emoji_1f6be);
        sEmojisMap.put(0x1f6b0, R.drawable.emoji_1f6b0);
        sEmojisMap.put(0x1f6ae, R.drawable.emoji_1f6ae);
        sEmojisMap.put(0x1f17f, R.drawable.emoji_1f17f);
        sEmojisMap.put(9855, R.drawable.emoji_267f);
        sEmojisMap.put(0x1f6ad, R.drawable.emoji_1f6ad);
        sEmojisMap.put(0x1f237, R.drawable.emoji_1f237);
        sEmojisMap.put(0x1f238, R.drawable.emoji_1f238);
        sEmojisMap.put(0x1f202, R.drawable.emoji_1f202);
        sEmojisMap.put(9410, R.drawable.emoji_24c2);
        sEmojisMap.put(0x1f6c2, R.drawable.emoji_1f6c2);
        sEmojisMap.put(0x1f6c4, R.drawable.emoji_1f6c4);
        sEmojisMap.put(0x1f6c5, R.drawable.emoji_1f6c5);
        sEmojisMap.put(0x1f6c3, R.drawable.emoji_1f6c3);
        sEmojisMap.put(0x1f251, R.drawable.emoji_1f251);
        sEmojisMap.put(12953, R.drawable.emoji_3299);
        sEmojisMap.put(12951, R.drawable.emoji_3297);
        sEmojisMap.put(0x1f191, R.drawable.emoji_1f191);
        sEmojisMap.put(0x1f198, R.drawable.emoji_1f198);
        sEmojisMap.put(0x1f194, R.drawable.emoji_1f194);
        sEmojisMap.put(0x1f6ab, R.drawable.emoji_1f6ab);
        sEmojisMap.put(0x1f51e, R.drawable.emoji_1f51e);
        sEmojisMap.put(0x1f4f5, R.drawable.emoji_1f4f5);
        sEmojisMap.put(0x1f6af, R.drawable.emoji_1f6af);
        sEmojisMap.put(0x1f6b1, R.drawable.emoji_1f6b1);
        sEmojisMap.put(0x1f6b3, R.drawable.emoji_1f6b3);
        sEmojisMap.put(0x1f6b7, R.drawable.emoji_1f6b7);
        sEmojisMap.put(0x1f6b8, R.drawable.emoji_1f6b8);
        sEmojisMap.put(9940, R.drawable.emoji_26d4);
        sEmojisMap.put(10035, R.drawable.emoji_2733);
        sEmojisMap.put(10055, R.drawable.emoji_2747);
        sEmojisMap.put(10062, R.drawable.emoji_274e);
        sEmojisMap.put(9989, R.drawable.emoji_2705);
        sEmojisMap.put(10036, R.drawable.emoji_2734);
        sEmojisMap.put(0x1f49f, R.drawable.emoji_1f49f);
        sEmojisMap.put(0x1f19a, R.drawable.emoji_1f19a);
        sEmojisMap.put(0x1f4f3, R.drawable.emoji_1f4f3);
        sEmojisMap.put(0x1f4f4, R.drawable.emoji_1f4f4);
        sEmojisMap.put(0x1f170, R.drawable.emoji_1f170);
        sEmojisMap.put(0x1f171, R.drawable.emoji_1f171);
        sEmojisMap.put(0x1f18e, R.drawable.emoji_1f18e);
        sEmojisMap.put(0x1f17e, R.drawable.emoji_1f17e);
        sEmojisMap.put(0x1f4a0, R.drawable.emoji_1f4a0);
        sEmojisMap.put(10175, R.drawable.emoji_27bf);
        sEmojisMap.put(9851, R.drawable.emoji_267b);
        sEmojisMap.put(9800, R.drawable.emoji_2648);
        sEmojisMap.put(9801, R.drawable.emoji_2649);
        sEmojisMap.put(9802, R.drawable.emoji_264a);
        sEmojisMap.put(9803, R.drawable.emoji_264b);
        sEmojisMap.put(9804, R.drawable.emoji_264c);
        sEmojisMap.put(9805, R.drawable.emoji_264d);
        sEmojisMap.put(9806, R.drawable.emoji_264e);
        sEmojisMap.put(9807, R.drawable.emoji_264f);
        sEmojisMap.put(9808, R.drawable.emoji_2650);
        sEmojisMap.put(9809, R.drawable.emoji_2651);
        sEmojisMap.put(9810, R.drawable.emoji_2652);
        sEmojisMap.put(9811, R.drawable.emoji_2653);
        sEmojisMap.put(9934, R.drawable.emoji_26ce);
        sEmojisMap.put(0x1f52f, R.drawable.emoji_1f52f);
        sEmojisMap.put(0x1f3e7, R.drawable.emoji_1f3e7);
        sEmojisMap.put(0x1f4b9, R.drawable.emoji_1f4b9);
        sEmojisMap.put(0x1f4b2, R.drawable.emoji_1f4b2);
        sEmojisMap.put(0x1f4b1, R.drawable.emoji_1f4b1);
        sEmojisMap.put(169, R.drawable.emoji_00a9);
        sEmojisMap.put(174, R.drawable.emoji_00ae);
        sEmojisMap.put(8482, R.drawable.emoji_2122);
        sEmojisMap.put(10060, R.drawable.emoji_274c);
        sEmojisMap.put(8252, R.drawable.emoji_203c);
        sEmojisMap.put(8265, R.drawable.emoji_2049);
        sEmojisMap.put(10071, R.drawable.emoji_2757);
        sEmojisMap.put(10067, R.drawable.emoji_2753);
        sEmojisMap.put(10069, R.drawable.emoji_2755);
        sEmojisMap.put(10068, R.drawable.emoji_2754);
        sEmojisMap.put(11093, R.drawable.emoji_2b55);
        sEmojisMap.put(0x1f51d, R.drawable.emoji_1f51d);
        sEmojisMap.put(0x1f51a, R.drawable.emoji_1f51a);
        sEmojisMap.put(0x1f519, R.drawable.emoji_1f519);
        sEmojisMap.put(0x1f51b, R.drawable.emoji_1f51b);
        sEmojisMap.put(0x1f51c, R.drawable.emoji_1f51c);
        sEmojisMap.put(0x1f503, R.drawable.emoji_1f503);
        sEmojisMap.put(0x1f55b, R.drawable.emoji_1f55b);
        sEmojisMap.put(0x1f567, R.drawable.emoji_1f567);
        sEmojisMap.put(0x1f550, R.drawable.emoji_1f550);
        sEmojisMap.put(0x1f55c, R.drawable.emoji_1f55c);
        sEmojisMap.put(0x1f551, R.drawable.emoji_1f551);
        sEmojisMap.put(0x1f55d, R.drawable.emoji_1f55d);
        sEmojisMap.put(0x1f552, R.drawable.emoji_1f552);
        sEmojisMap.put(0x1f55e, R.drawable.emoji_1f55e);
        sEmojisMap.put(0x1f553, R.drawable.emoji_1f553);
        sEmojisMap.put(0x1f55f, R.drawable.emoji_1f55f);
        sEmojisMap.put(0x1f554, R.drawable.emoji_1f554);
        sEmojisMap.put(0x1f560, R.drawable.emoji_1f560);
        sEmojisMap.put(0x1f555, R.drawable.emoji_1f555);
        sEmojisMap.put(0x1f556, R.drawable.emoji_1f556);
        sEmojisMap.put(0x1f557, R.drawable.emoji_1f557);
        sEmojisMap.put(0x1f558, R.drawable.emoji_1f558);
        sEmojisMap.put(0x1f559, R.drawable.emoji_1f559);
        sEmojisMap.put(0x1f55a, R.drawable.emoji_1f55a);
        sEmojisMap.put(0x1f561, R.drawable.emoji_1f561);
        sEmojisMap.put(0x1f562, R.drawable.emoji_1f562);
        sEmojisMap.put(0x1f563, R.drawable.emoji_1f563);
        sEmojisMap.put(0x1f564, R.drawable.emoji_1f564);
        sEmojisMap.put(0x1f565, R.drawable.emoji_1f565);
        sEmojisMap.put(0x1f566, R.drawable.emoji_1f566);
        sEmojisMap.put(10006, R.drawable.emoji_2716);
        sEmojisMap.put(10133, R.drawable.emoji_2795);
        sEmojisMap.put(10134, R.drawable.emoji_2796);
        sEmojisMap.put(10135, R.drawable.emoji_2797);
        sEmojisMap.put(9824, R.drawable.emoji_2660);
        sEmojisMap.put(9829, R.drawable.emoji_2665);
        sEmojisMap.put(9827, R.drawable.emoji_2663);
        sEmojisMap.put(9830, R.drawable.emoji_2666);
        sEmojisMap.put(0x1f4ae, R.drawable.emoji_1f4ae);
        sEmojisMap.put(0x1f4af, R.drawable.emoji_1f4af);
        sEmojisMap.put(10004, R.drawable.emoji_2714);
        sEmojisMap.put(9745, R.drawable.emoji_2611);
        sEmojisMap.put(0x1f518, R.drawable.emoji_1f518);
        sEmojisMap.put(0x1f517, R.drawable.emoji_1f517);
        sEmojisMap.put(10160, R.drawable.emoji_27b0);
        sEmojisMap.put(12336, R.drawable.emoji_3030);
        sEmojisMap.put(12349, R.drawable.emoji_303d);
        sEmojisMap.put(0x1f531, R.drawable.emoji_1f531);
        sEmojisMap.put(9724, R.drawable.emoji_25fc);
        sEmojisMap.put(9723, R.drawable.emoji_25fb);
        sEmojisMap.put(9726, R.drawable.emoji_25fe);
        sEmojisMap.put(9725, R.drawable.emoji_25fd);
        sEmojisMap.put(9642, R.drawable.emoji_25aa);
        sEmojisMap.put(9643, R.drawable.emoji_25ab);
        sEmojisMap.put(0x1f53a, R.drawable.emoji_1f53a);
        sEmojisMap.put(0x1f532, R.drawable.emoji_1f532);
        sEmojisMap.put(0x1f533, R.drawable.emoji_1f533);
        sEmojisMap.put(9899, R.drawable.emoji_26ab);
        sEmojisMap.put(9898, R.drawable.emoji_26aa);
        sEmojisMap.put(0x1f534, R.drawable.emoji_1f534);
        sEmojisMap.put(0x1f535, R.drawable.emoji_1f535);
        sEmojisMap.put(0x1f53b, R.drawable.emoji_1f53b);
        sEmojisMap.put(11036, R.drawable.emoji_2b1c);
        sEmojisMap.put(11035, R.drawable.emoji_2b1b);
        sEmojisMap.put(0x1f536, R.drawable.emoji_1f536);
        sEmojisMap.put(0x1f537, R.drawable.emoji_1f537);
        sEmojisMap.put(0x1f538, R.drawable.emoji_1f538);
        sEmojisMap.put(0x1f539, R.drawable.emoji_1f539);
        sSoftbanksMap.put(57345, R.drawable.emoji_1f466);
        sSoftbanksMap.put(57346, R.drawable.emoji_1f467);
        sSoftbanksMap.put(57347, R.drawable.emoji_1f48b);
        sSoftbanksMap.put(57348, R.drawable.emoji_1f468);
        sSoftbanksMap.put(57349, R.drawable.emoji_1f469);
        sSoftbanksMap.put(57350, R.drawable.emoji_1f455);
        sSoftbanksMap.put(57351, R.drawable.emoji_1f45e);
        sSoftbanksMap.put(57352, R.drawable.emoji_1f4f7);
        sSoftbanksMap.put(57353, R.drawable.emoji_1f4de);
        sSoftbanksMap.put(57354, R.drawable.emoji_1f4f1);
        sSoftbanksMap.put(57355, R.drawable.emoji_1f4e0);
        sSoftbanksMap.put(57356, R.drawable.emoji_1f4bb);
        sSoftbanksMap.put(57357, R.drawable.emoji_1f44a);
        sSoftbanksMap.put(57358, R.drawable.emoji_1f44d);
        sSoftbanksMap.put(57359, R.drawable.emoji_261d);
        sSoftbanksMap.put(57360, R.drawable.emoji_270a);
        sSoftbanksMap.put(57361, R.drawable.emoji_270c);
        sSoftbanksMap.put(57362, R.drawable.emoji_1f64b);
        sSoftbanksMap.put(57363, R.drawable.emoji_1f3bf);
        sSoftbanksMap.put(57364, R.drawable.emoji_26f3);
        sSoftbanksMap.put(57365, R.drawable.emoji_1f3be);
        sSoftbanksMap.put(57366, R.drawable.emoji_26be);
        sSoftbanksMap.put(57367, R.drawable.emoji_1f3c4);
        sSoftbanksMap.put(57368, R.drawable.emoji_26bd);
        sSoftbanksMap.put(57369, R.drawable.emoji_1f3a3);
        sSoftbanksMap.put(57370, R.drawable.emoji_1f434);
        sSoftbanksMap.put(57371, R.drawable.emoji_1f697);
        sSoftbanksMap.put(57372, R.drawable.emoji_26f5);
        sSoftbanksMap.put(57373, R.drawable.emoji_2708);
        sSoftbanksMap.put(57374, R.drawable.emoji_1f683);
        sSoftbanksMap.put(57375, R.drawable.emoji_1f685);
        sSoftbanksMap.put(57376, R.drawable.emoji_2753);
        sSoftbanksMap.put(57377, R.drawable.emoji_2757);
        sSoftbanksMap.put(57378, R.drawable.emoji_2764);
        sSoftbanksMap.put(57379, R.drawable.emoji_1f494);
        sSoftbanksMap.put(57380, R.drawable.emoji_1f550);
        sSoftbanksMap.put(57381, R.drawable.emoji_1f551);
        sSoftbanksMap.put(57382, R.drawable.emoji_1f552);
        sSoftbanksMap.put(57383, R.drawable.emoji_1f553);
        sSoftbanksMap.put(57384, R.drawable.emoji_1f554);
        sSoftbanksMap.put(57385, R.drawable.emoji_1f555);
        sSoftbanksMap.put(57386, R.drawable.emoji_1f556);
        sSoftbanksMap.put(57387, R.drawable.emoji_1f557);
        sSoftbanksMap.put(57388, R.drawable.emoji_1f558);
        sSoftbanksMap.put(57389, R.drawable.emoji_1f559);
        sSoftbanksMap.put(57390, R.drawable.emoji_1f55a);
        sSoftbanksMap.put(57391, R.drawable.emoji_1f55b);
        sSoftbanksMap.put(57392, R.drawable.emoji_1f338);
        sSoftbanksMap.put(57393, R.drawable.emoji_1f531);
        sSoftbanksMap.put(57394, R.drawable.emoji_1f339);
        sSoftbanksMap.put(57395, R.drawable.emoji_1f384);
        sSoftbanksMap.put(57396, R.drawable.emoji_1f48d);
        sSoftbanksMap.put(57397, R.drawable.emoji_1f48e);
        sSoftbanksMap.put(57398, R.drawable.emoji_1f3e0);
        sSoftbanksMap.put(57399, R.drawable.emoji_26ea);
        sSoftbanksMap.put(57400, R.drawable.emoji_1f3e2);
        sSoftbanksMap.put(57401, R.drawable.emoji_1f689);
        sSoftbanksMap.put(57402, R.drawable.emoji_26fd);
        sSoftbanksMap.put(57403, R.drawable.emoji_1f5fb);
        sSoftbanksMap.put(57404, R.drawable.emoji_1f3a4);
        sSoftbanksMap.put(57405, R.drawable.emoji_1f3a5);
        sSoftbanksMap.put(57406, R.drawable.emoji_1f3b5);
        sSoftbanksMap.put(57407, R.drawable.emoji_1f511);
        sSoftbanksMap.put(57408, R.drawable.emoji_1f3b7);
        sSoftbanksMap.put(57409, R.drawable.emoji_1f3b8);
        sSoftbanksMap.put(57410, R.drawable.emoji_1f3ba);
        sSoftbanksMap.put(57411, R.drawable.emoji_1f374);
        sSoftbanksMap.put(57412, R.drawable.emoji_1f377);
        sSoftbanksMap.put(57413, R.drawable.emoji_2615);
        sSoftbanksMap.put(57414, R.drawable.emoji_1f370);
        sSoftbanksMap.put(57415, R.drawable.emoji_1f37a);
        sSoftbanksMap.put(57416, R.drawable.emoji_26c4);
        sSoftbanksMap.put(57417, R.drawable.emoji_2601);
        sSoftbanksMap.put(57418, R.drawable.emoji_2600);
        sSoftbanksMap.put(57419, R.drawable.emoji_2614);
        sSoftbanksMap.put(57420, R.drawable.emoji_1f313);
        sSoftbanksMap.put(57421, R.drawable.emoji_1f304);
        sSoftbanksMap.put(57422, R.drawable.emoji_1f47c);
        sSoftbanksMap.put(57423, R.drawable.emoji_1f431);
        sSoftbanksMap.put(57424, R.drawable.emoji_1f42f);
        sSoftbanksMap.put(57425, R.drawable.emoji_1f43b);
        sSoftbanksMap.put(57426, R.drawable.emoji_1f429);
        sSoftbanksMap.put(57427, R.drawable.emoji_1f42d);
        sSoftbanksMap.put(57428, R.drawable.emoji_1f433);
        sSoftbanksMap.put(57429, R.drawable.emoji_1f427);
        sSoftbanksMap.put(57430, R.drawable.emoji_1f60a);
        sSoftbanksMap.put(57431, R.drawable.emoji_1f603);
        sSoftbanksMap.put(57432, R.drawable.emoji_1f61e);
        sSoftbanksMap.put(57433, R.drawable.emoji_1f620);
        sSoftbanksMap.put(57434, R.drawable.emoji_1f4a9);
        sSoftbanksMap.put(57601, R.drawable.emoji_1f4ea);
        sSoftbanksMap.put(57602, R.drawable.emoji_1f4ee);
        sSoftbanksMap.put(57603, R.drawable.emoji_1f4e7);
        sSoftbanksMap.put(57604, R.drawable.emoji_1f4f2);
        sSoftbanksMap.put(57605, R.drawable.emoji_1f61c);
        sSoftbanksMap.put(57606, R.drawable.emoji_1f60d);
        sSoftbanksMap.put(57607, R.drawable.emoji_1f631);
        sSoftbanksMap.put(57608, R.drawable.emoji_1f613);
        sSoftbanksMap.put(57609, R.drawable.emoji_1f435);
        sSoftbanksMap.put(57610, R.drawable.emoji_1f419);
        sSoftbanksMap.put(57611, R.drawable.emoji_1f437);
        sSoftbanksMap.put(57612, R.drawable.emoji_1f47d);
        sSoftbanksMap.put(57613, R.drawable.emoji_1f680);
        sSoftbanksMap.put(57614, R.drawable.emoji_1f451);
        sSoftbanksMap.put(57615, R.drawable.emoji_1f4a1);
        sSoftbanksMap.put(57616, R.drawable.emoji_1f331);
        sSoftbanksMap.put(57617, R.drawable.emoji_1f48f);
        sSoftbanksMap.put(57618, R.drawable.emoji_1f381);
        sSoftbanksMap.put(57619, R.drawable.emoji_1f52b);
        sSoftbanksMap.put(57620, R.drawable.emoji_1f50d);
        sSoftbanksMap.put(57621, R.drawable.emoji_1f3c3);
        sSoftbanksMap.put(57622, R.drawable.emoji_1f528);
        sSoftbanksMap.put(57623, R.drawable.emoji_1f386);
        sSoftbanksMap.put(57624, R.drawable.emoji_1f341);
        sSoftbanksMap.put(57625, R.drawable.emoji_1f342);
        sSoftbanksMap.put(57626, R.drawable.emoji_1f47f);
        sSoftbanksMap.put(57627, R.drawable.emoji_1f47b);
        sSoftbanksMap.put(57628, R.drawable.emoji_1f480);
        sSoftbanksMap.put(57629, R.drawable.emoji_1f525);
        sSoftbanksMap.put(57630, R.drawable.emoji_1f4bc);
        sSoftbanksMap.put(57631, R.drawable.emoji_1f4ba);
        sSoftbanksMap.put(57632, R.drawable.emoji_1f354);
        sSoftbanksMap.put(57633, R.drawable.emoji_26f2);
        sSoftbanksMap.put(57634, R.drawable.emoji_26fa);
        sSoftbanksMap.put(57635, R.drawable.emoji_2668);
        sSoftbanksMap.put(57636, R.drawable.emoji_1f3a1);
        sSoftbanksMap.put(57637, R.drawable.emoji_1f3ab);
        sSoftbanksMap.put(57638, R.drawable.emoji_1f4bf);
        sSoftbanksMap.put(57639, R.drawable.emoji_1f4c0);
        sSoftbanksMap.put(57640, R.drawable.emoji_1f4fb);
        sSoftbanksMap.put(57641, R.drawable.emoji_1f4fc);
        sSoftbanksMap.put(57642, R.drawable.emoji_1f4fa);
        sSoftbanksMap.put(57643, R.drawable.emoji_1f47e);
        sSoftbanksMap.put(57644, R.drawable.emoji_303d);
        sSoftbanksMap.put(57645, R.drawable.emoji_1f004);
        sSoftbanksMap.put(57646, R.drawable.emoji_1f19a);
        sSoftbanksMap.put(57647, R.drawable.emoji_1f4b0);
        sSoftbanksMap.put(57648, R.drawable.emoji_1f3af);
        sSoftbanksMap.put(57649, R.drawable.emoji_1f3c6);
        sSoftbanksMap.put(57650, R.drawable.emoji_1f3c1);
        sSoftbanksMap.put(57651, R.drawable.emoji_1f3b0);
        sSoftbanksMap.put(57652, R.drawable.emoji_1f40e);
        sSoftbanksMap.put(57653, R.drawable.emoji_1f6a4);
        sSoftbanksMap.put(57654, R.drawable.emoji_1f6b2);
        sSoftbanksMap.put(57655, R.drawable.emoji_1f6a7);
        sSoftbanksMap.put(57656, R.drawable.emoji_1f6b9);
        sSoftbanksMap.put(57657, R.drawable.emoji_1f6ba);
        sSoftbanksMap.put(57658, R.drawable.emoji_1f6bc);
        sSoftbanksMap.put(57659, R.drawable.emoji_1f489);
        sSoftbanksMap.put(57660, R.drawable.emoji_1f4a4);
        sSoftbanksMap.put(57661, R.drawable.emoji_26a1);
        sSoftbanksMap.put(57662, R.drawable.emoji_1f460);
        sSoftbanksMap.put(57663, R.drawable.emoji_1f6c0);
        sSoftbanksMap.put(57664, R.drawable.emoji_1f6bd);
        sSoftbanksMap.put(57665, R.drawable.emoji_1f50a);
        sSoftbanksMap.put(57666, R.drawable.emoji_1f4e2);
        sSoftbanksMap.put(57667, R.drawable.emoji_1f38c);
        sSoftbanksMap.put(57668, R.drawable.emoji_1f50f);
        sSoftbanksMap.put(57669, R.drawable.emoji_1f513);
        sSoftbanksMap.put(57670, R.drawable.emoji_1f306);
        sSoftbanksMap.put(57671, R.drawable.emoji_1f373);
        sSoftbanksMap.put(57672, R.drawable.emoji_1f4c7);
        sSoftbanksMap.put(57673, R.drawable.emoji_1f4b1);
        sSoftbanksMap.put(57674, R.drawable.emoji_1f4b9);
        sSoftbanksMap.put(57675, R.drawable.emoji_1f4e1);
        sSoftbanksMap.put(57676, R.drawable.emoji_1f4aa);
        sSoftbanksMap.put(57677, R.drawable.emoji_1f3e6);
        sSoftbanksMap.put(57678, R.drawable.emoji_1f6a5);
        sSoftbanksMap.put(57679, R.drawable.emoji_1f17f);
        sSoftbanksMap.put(57680, R.drawable.emoji_1f68f);
        sSoftbanksMap.put(57681, R.drawable.emoji_1f6bb);
        sSoftbanksMap.put(57682, R.drawable.emoji_1f46e);
        sSoftbanksMap.put(57683, R.drawable.emoji_1f3e3);
        sSoftbanksMap.put(57684, R.drawable.emoji_1f3e7);
        sSoftbanksMap.put(57685, R.drawable.emoji_1f3e5);
        sSoftbanksMap.put(57686, R.drawable.emoji_1f3ea);
        sSoftbanksMap.put(57687, R.drawable.emoji_1f3eb);
        sSoftbanksMap.put(57688, R.drawable.emoji_1f3e8);
        sSoftbanksMap.put(57689, R.drawable.emoji_1f68c);
        sSoftbanksMap.put(57690, R.drawable.emoji_1f695);
        sSoftbanksMap.put(57857, R.drawable.emoji_1f6b6);
        sSoftbanksMap.put(57858, R.drawable.emoji_1f6a2);
        sSoftbanksMap.put(57859, R.drawable.emoji_1f201);
        sSoftbanksMap.put(57860, R.drawable.emoji_1f49f);
        sSoftbanksMap.put(57861, R.drawable.emoji_2734);
        sSoftbanksMap.put(57862, R.drawable.emoji_2733);
        sSoftbanksMap.put(57863, R.drawable.emoji_1f51e);
        sSoftbanksMap.put(57864, R.drawable.emoji_1f6ad);
        sSoftbanksMap.put(57865, R.drawable.emoji_1f530);
        sSoftbanksMap.put(57866, R.drawable.emoji_267f);
        sSoftbanksMap.put(57867, R.drawable.emoji_1f4f6);
        sSoftbanksMap.put(57868, R.drawable.emoji_2665);
        sSoftbanksMap.put(57869, R.drawable.emoji_2666);
        sSoftbanksMap.put(57870, R.drawable.emoji_2660);
        sSoftbanksMap.put(57871, R.drawable.emoji_2663);
        sSoftbanksMap.put(57872, R.drawable.emoji_0023);
        sSoftbanksMap.put(57873, R.drawable.emoji_27bf);
        sSoftbanksMap.put(57874, R.drawable.emoji_1f195);
        sSoftbanksMap.put(57875, R.drawable.emoji_1f199);
        sSoftbanksMap.put(57876, R.drawable.emoji_1f192);
        sSoftbanksMap.put(57877, R.drawable.emoji_1f236);
        sSoftbanksMap.put(57878, R.drawable.emoji_1f21a);
        sSoftbanksMap.put(57879, R.drawable.emoji_1f237);
        sSoftbanksMap.put(57880, R.drawable.emoji_1f238);
        sSoftbanksMap.put(57881, R.drawable.emoji_1f534);
        sSoftbanksMap.put(57882, R.drawable.emoji_1f532);
        sSoftbanksMap.put(57883, R.drawable.emoji_1f533);
        sSoftbanksMap.put(57884, R.drawable.emoji_0031);
        sSoftbanksMap.put(57885, R.drawable.emoji_0032);
        sSoftbanksMap.put(57886, R.drawable.emoji_0033);
        sSoftbanksMap.put(57887, R.drawable.emoji_0034);
        sSoftbanksMap.put(57888, R.drawable.emoji_0035);
        sSoftbanksMap.put(57889, R.drawable.emoji_0036);
        sSoftbanksMap.put(57890, R.drawable.emoji_0037);
        sSoftbanksMap.put(57891, R.drawable.emoji_0038);
        sSoftbanksMap.put(57892, R.drawable.emoji_0039);
        sSoftbanksMap.put(57893, R.drawable.emoji_0030);
        sSoftbanksMap.put(57894, R.drawable.emoji_1f250);
        sSoftbanksMap.put(57895, R.drawable.emoji_1f239);
        sSoftbanksMap.put(57896, R.drawable.emoji_1f202);
        sSoftbanksMap.put(57897, R.drawable.emoji_1f194);
        sSoftbanksMap.put(57898, R.drawable.emoji_1f235);
        sSoftbanksMap.put(57899, R.drawable.emoji_1f233);
        sSoftbanksMap.put(57900, R.drawable.emoji_1f22f);
        sSoftbanksMap.put(57901, R.drawable.emoji_1f23a);
        sSoftbanksMap.put(57902, R.drawable.emoji_1f446);
        sSoftbanksMap.put(57903, R.drawable.emoji_1f447);
        sSoftbanksMap.put(57904, R.drawable.emoji_1f448);
        sSoftbanksMap.put(57905, R.drawable.emoji_1f449);
        sSoftbanksMap.put(57906, R.drawable.emoji_2b06);
        sSoftbanksMap.put(57907, R.drawable.emoji_2b07);
        sSoftbanksMap.put(57908, R.drawable.emoji_27a1);
        sSoftbanksMap.put(57909, R.drawable.emoji_1f519);
        sSoftbanksMap.put(57910, R.drawable.emoji_2197);
        sSoftbanksMap.put(57911, R.drawable.emoji_2196);
        sSoftbanksMap.put(57912, R.drawable.emoji_2198);
        sSoftbanksMap.put(57913, R.drawable.emoji_2199);
        sSoftbanksMap.put(57914, R.drawable.emoji_25b6);
        sSoftbanksMap.put(57915, R.drawable.emoji_25c0);
        sSoftbanksMap.put(57916, R.drawable.emoji_23e9);
        sSoftbanksMap.put(57917, R.drawable.emoji_23ea);
        sSoftbanksMap.put(57918, R.drawable.emoji_1f52e);
        sSoftbanksMap.put(57919, R.drawable.emoji_2648);
        sSoftbanksMap.put(57920, R.drawable.emoji_2649);
        sSoftbanksMap.put(57921, R.drawable.emoji_264a);
        sSoftbanksMap.put(57922, R.drawable.emoji_264b);
        sSoftbanksMap.put(57923, R.drawable.emoji_264c);
        sSoftbanksMap.put(57924, R.drawable.emoji_264d);
        sSoftbanksMap.put(57925, R.drawable.emoji_264e);
        sSoftbanksMap.put(57926, R.drawable.emoji_264f);
        sSoftbanksMap.put(57927, R.drawable.emoji_2650);
        sSoftbanksMap.put(57928, R.drawable.emoji_2651);
        sSoftbanksMap.put(57929, R.drawable.emoji_2652);
        sSoftbanksMap.put(57930, R.drawable.emoji_2653);
        sSoftbanksMap.put(57931, R.drawable.emoji_26ce);
        sSoftbanksMap.put(57932, R.drawable.emoji_1f51d);
        sSoftbanksMap.put(57933, R.drawable.emoji_1f197);
        sSoftbanksMap.put(57934, R.drawable.emoji_00a9);
        sSoftbanksMap.put(57935, R.drawable.emoji_00ae);
        sSoftbanksMap.put(57936, R.drawable.emoji_1f4f3);
        sSoftbanksMap.put(57937, R.drawable.emoji_1f4f4);
        sSoftbanksMap.put(57938, R.drawable.emoji_26a0);
        sSoftbanksMap.put(57939, R.drawable.emoji_1f481);
        sSoftbanksMap.put(58113, R.drawable.emoji_1f4c3);
        sSoftbanksMap.put(58114, R.drawable.emoji_1f454);
        sSoftbanksMap.put(58115, R.drawable.emoji_1f33a);
        sSoftbanksMap.put(58116, R.drawable.emoji_1f337);
        sSoftbanksMap.put(58117, R.drawable.emoji_1f33b);
        sSoftbanksMap.put(58118, R.drawable.emoji_1f490);
        sSoftbanksMap.put(58119, R.drawable.emoji_1f334);
        sSoftbanksMap.put(58120, R.drawable.emoji_1f335);
        sSoftbanksMap.put(58121, R.drawable.emoji_1f6be);
        sSoftbanksMap.put(58122, R.drawable.emoji_1f3a7);
        sSoftbanksMap.put(58123, R.drawable.emoji_1f376);
        sSoftbanksMap.put(58124, R.drawable.emoji_1f37b);
        sSoftbanksMap.put(58125, R.drawable.emoji_3297);
        sSoftbanksMap.put(58126, R.drawable.emoji_1f6ac);
        sSoftbanksMap.put(58127, R.drawable.emoji_1f48a);
        sSoftbanksMap.put(58128, R.drawable.emoji_1f388);
        sSoftbanksMap.put(58129, R.drawable.emoji_1f4a3);
        sSoftbanksMap.put(58130, R.drawable.emoji_1f389);
        sSoftbanksMap.put(58131, R.drawable.emoji_2702);
        sSoftbanksMap.put(58132, R.drawable.emoji_1f380);
        sSoftbanksMap.put(58133, R.drawable.emoji_3299);
        sSoftbanksMap.put(58134, R.drawable.emoji_1f4bd);
        sSoftbanksMap.put(58135, R.drawable.emoji_1f4e3);
        sSoftbanksMap.put(58136, R.drawable.emoji_1f452);
        sSoftbanksMap.put(58137, R.drawable.emoji_1f457);
        sSoftbanksMap.put(58138, R.drawable.emoji_1f461);
        sSoftbanksMap.put(58139, R.drawable.emoji_1f462);
        sSoftbanksMap.put(58140, R.drawable.emoji_1f484);
        sSoftbanksMap.put(58141, R.drawable.emoji_1f485);
        sSoftbanksMap.put(58142, R.drawable.emoji_1f486);
        sSoftbanksMap.put(58143, R.drawable.emoji_1f487);
        sSoftbanksMap.put(58144, R.drawable.emoji_1f488);
        sSoftbanksMap.put(58145, R.drawable.emoji_1f458);
        sSoftbanksMap.put(58146, R.drawable.emoji_1f459);
        sSoftbanksMap.put(58147, R.drawable.emoji_1f45c);
        sSoftbanksMap.put(58148, R.drawable.emoji_1f3ac);
        sSoftbanksMap.put(58149, R.drawable.emoji_1f514);
        sSoftbanksMap.put(58150, R.drawable.emoji_1f3b6);
        sSoftbanksMap.put(58151, R.drawable.emoji_1f493);
        sSoftbanksMap.put(58152, R.drawable.emoji_1f48c);
        sSoftbanksMap.put(58153, R.drawable.emoji_1f498);
        sSoftbanksMap.put(58154, R.drawable.emoji_1f499);
        sSoftbanksMap.put(58155, R.drawable.emoji_1f49a);
        sSoftbanksMap.put(58156, R.drawable.emoji_1f49b);
        sSoftbanksMap.put(58157, R.drawable.emoji_1f49c);
        sSoftbanksMap.put(58158, R.drawable.emoji_2728);
        sSoftbanksMap.put(58159, R.drawable.emoji_2b50);
        sSoftbanksMap.put(58160, R.drawable.emoji_1f4a8);
        sSoftbanksMap.put(58161, R.drawable.emoji_1f4a6);
        sSoftbanksMap.put(58162, R.drawable.emoji_2b55);
        sSoftbanksMap.put(58163, R.drawable.emoji_2716);
        sSoftbanksMap.put(58164, R.drawable.emoji_1f4a2);
        sSoftbanksMap.put(58165, R.drawable.emoji_1f31f);
        sSoftbanksMap.put(58166, R.drawable.emoji_2754);
        sSoftbanksMap.put(58167, R.drawable.emoji_2755);
        sSoftbanksMap.put(58168, R.drawable.emoji_1f375);
        sSoftbanksMap.put(58169, R.drawable.emoji_1f35e);
        sSoftbanksMap.put(58170, R.drawable.emoji_1f366);
        sSoftbanksMap.put(58171, R.drawable.emoji_1f35f);
        sSoftbanksMap.put(58172, R.drawable.emoji_1f361);
        sSoftbanksMap.put(58173, R.drawable.emoji_1f358);
        sSoftbanksMap.put(58174, R.drawable.emoji_1f35a);
        sSoftbanksMap.put(58175, R.drawable.emoji_1f35d);
        sSoftbanksMap.put(58176, R.drawable.emoji_1f35c);
        sSoftbanksMap.put(58177, R.drawable.emoji_1f35b);
        sSoftbanksMap.put(58178, R.drawable.emoji_1f359);
        sSoftbanksMap.put(58179, R.drawable.emoji_1f362);
        sSoftbanksMap.put(58180, R.drawable.emoji_1f363);
        sSoftbanksMap.put(58181, R.drawable.emoji_1f34e);
        sSoftbanksMap.put(58182, R.drawable.emoji_1f34a);
        sSoftbanksMap.put(58183, R.drawable.emoji_1f353);
        sSoftbanksMap.put(58184, R.drawable.emoji_1f349);
        sSoftbanksMap.put(58185, R.drawable.emoji_1f345);
        sSoftbanksMap.put(58186, R.drawable.emoji_1f346);
        sSoftbanksMap.put(58187, R.drawable.emoji_1f382);
        sSoftbanksMap.put(58188, R.drawable.emoji_1f371);
        sSoftbanksMap.put(58189, R.drawable.emoji_1f372);
        sSoftbanksMap.put(58369, R.drawable.emoji_1f625);
        sSoftbanksMap.put(58370, R.drawable.emoji_1f60f);
        sSoftbanksMap.put(58371, R.drawable.emoji_1f614);
        sSoftbanksMap.put(58372, R.drawable.emoji_1f601);
        sSoftbanksMap.put(58373, R.drawable.emoji_1f609);
        sSoftbanksMap.put(58374, R.drawable.emoji_1f623);
        sSoftbanksMap.put(58375, R.drawable.emoji_1f616);
        sSoftbanksMap.put(58376, R.drawable.emoji_1f62a);
        sSoftbanksMap.put(58377, R.drawable.emoji_1f445);
        sSoftbanksMap.put(58378, R.drawable.emoji_1f606);
        sSoftbanksMap.put(58379, R.drawable.emoji_1f628);
        sSoftbanksMap.put(58380, R.drawable.emoji_1f637);
        sSoftbanksMap.put(58381, R.drawable.emoji_1f633);
        sSoftbanksMap.put(58382, R.drawable.emoji_1f612);
        sSoftbanksMap.put(58383, R.drawable.emoji_1f630);
        sSoftbanksMap.put(58384, R.drawable.emoji_1f632);
        sSoftbanksMap.put(58385, R.drawable.emoji_1f62d);
        sSoftbanksMap.put(58386, R.drawable.emoji_1f602);
        sSoftbanksMap.put(58387, R.drawable.emoji_1f622);
        sSoftbanksMap.put(58388, R.drawable.emoji_263a);
        sSoftbanksMap.put(58389, R.drawable.emoji_1f605);
        sSoftbanksMap.put(58390, R.drawable.emoji_1f621);
        sSoftbanksMap.put(58391, R.drawable.emoji_1f61a);
        sSoftbanksMap.put(58392, R.drawable.emoji_1f618);
        sSoftbanksMap.put(58393, R.drawable.emoji_1f440);
        sSoftbanksMap.put(58394, R.drawable.emoji_1f443);
        sSoftbanksMap.put(58395, R.drawable.emoji_1f442);
        sSoftbanksMap.put(58396, R.drawable.emoji_1f444);
        sSoftbanksMap.put(58397, R.drawable.emoji_1f64f);
        sSoftbanksMap.put(58398, R.drawable.emoji_1f44b);
        sSoftbanksMap.put(58399, R.drawable.emoji_1f44f);
        sSoftbanksMap.put(58400, R.drawable.emoji_1f44c);
        sSoftbanksMap.put(58401, R.drawable.emoji_1f44e);
        sSoftbanksMap.put(58402, R.drawable.emoji_1f450);
        sSoftbanksMap.put(58403, R.drawable.emoji_1f645);
        sSoftbanksMap.put(58404, R.drawable.emoji_1f646);
        sSoftbanksMap.put(58405, R.drawable.emoji_1f491);
        sSoftbanksMap.put(58406, R.drawable.emoji_1f647);
        sSoftbanksMap.put(58407, R.drawable.emoji_1f64c);
        sSoftbanksMap.put(58408, R.drawable.emoji_1f46b);
        sSoftbanksMap.put(58409, R.drawable.emoji_1f46f);
        sSoftbanksMap.put(58410, R.drawable.emoji_1f3c0);
        sSoftbanksMap.put(58411, R.drawable.emoji_1f3c8);
        sSoftbanksMap.put(58412, R.drawable.emoji_1f3b1);
        sSoftbanksMap.put(58413, R.drawable.emoji_1f3ca);
        sSoftbanksMap.put(58414, R.drawable.emoji_1f699);
        sSoftbanksMap.put(58415, R.drawable.emoji_1f69a);
        sSoftbanksMap.put(58416, R.drawable.emoji_1f692);
        sSoftbanksMap.put(58417, R.drawable.emoji_1f691);
        sSoftbanksMap.put(58418, R.drawable.emoji_1f693);
        sSoftbanksMap.put(58419, R.drawable.emoji_1f3a2);
        sSoftbanksMap.put(58420, R.drawable.emoji_1f687);
        sSoftbanksMap.put(58421, R.drawable.emoji_1f684);
        sSoftbanksMap.put(58422, R.drawable.emoji_1f38d);
        sSoftbanksMap.put(58423, R.drawable.emoji_1f49d);
        sSoftbanksMap.put(58424, R.drawable.emoji_1f38e);
        sSoftbanksMap.put(58425, R.drawable.emoji_1f393);
        sSoftbanksMap.put(58426, R.drawable.emoji_1f392);
        sSoftbanksMap.put(58427, R.drawable.emoji_1f38f);
        sSoftbanksMap.put(58428, R.drawable.emoji_1f302);
        sSoftbanksMap.put(58429, R.drawable.emoji_1f492);
        sSoftbanksMap.put(58430, R.drawable.emoji_1f30a);
        sSoftbanksMap.put(58431, R.drawable.emoji_1f367);
        sSoftbanksMap.put(58432, R.drawable.emoji_1f387);
        sSoftbanksMap.put(58433, R.drawable.emoji_1f41a);
        sSoftbanksMap.put(58434, R.drawable.emoji_1f390);
        sSoftbanksMap.put(58435, R.drawable.emoji_1f300);
        sSoftbanksMap.put(58436, R.drawable.emoji_1f33e);
        sSoftbanksMap.put(58437, R.drawable.emoji_1f383);
        sSoftbanksMap.put(58438, R.drawable.emoji_1f391);
        sSoftbanksMap.put(58439, R.drawable.emoji_1f343);
        sSoftbanksMap.put(58440, R.drawable.emoji_1f385);
        sSoftbanksMap.put(58441, R.drawable.emoji_1f305);
        sSoftbanksMap.put(58442, R.drawable.emoji_1f307);
        sSoftbanksMap.put(58443, R.drawable.emoji_1f303);
        sSoftbanksMap.put(58443, R.drawable.emoji_1f30c);
        sSoftbanksMap.put(58444, R.drawable.emoji_1f308);
        sSoftbanksMap.put(58625, R.drawable.emoji_1f3e9);
        sSoftbanksMap.put(58626, R.drawable.emoji_1f3a8);
        sSoftbanksMap.put(58627, R.drawable.emoji_1f3a9);
        sSoftbanksMap.put(58628, R.drawable.emoji_1f3ec);
        sSoftbanksMap.put(58629, R.drawable.emoji_1f3ef);
        sSoftbanksMap.put(58630, R.drawable.emoji_1f3f0);
        sSoftbanksMap.put(58631, R.drawable.emoji_1f3a6);
        sSoftbanksMap.put(58632, R.drawable.emoji_1f3ed);
        sSoftbanksMap.put(58633, R.drawable.emoji_1f5fc);
        sSoftbanksMap.put(58635, R.drawable.emoji_1f1ef_1f1f5);
        sSoftbanksMap.put(58636, R.drawable.emoji_1f1fa_1f1f8);
        sSoftbanksMap.put(58637, R.drawable.emoji_1f1eb_1f1f7);
        sSoftbanksMap.put(58638, R.drawable.emoji_1f1e9_1f1ea);
        sSoftbanksMap.put(58639, R.drawable.emoji_1f1ee_1f1f9);
        sSoftbanksMap.put(58640, R.drawable.emoji_1f1ec_1f1e7);
        sSoftbanksMap.put(58641, R.drawable.emoji_1f1ea_1f1f8);
        sSoftbanksMap.put(58642, R.drawable.emoji_1f1f7_1f1fa);
        sSoftbanksMap.put(58643, R.drawable.emoji_1f1e8_1f1f3);
        sSoftbanksMap.put(58644, R.drawable.emoji_1f1f0_1f1f7);
        sSoftbanksMap.put(58645, R.drawable.emoji_1f471);
        sSoftbanksMap.put(58646, R.drawable.emoji_1f472);
        sSoftbanksMap.put(58647, R.drawable.emoji_1f473);
        sSoftbanksMap.put(58648, R.drawable.emoji_1f474);
        sSoftbanksMap.put(58649, R.drawable.emoji_1f475);
        sSoftbanksMap.put(58650, R.drawable.emoji_1f476);
        sSoftbanksMap.put(58651, R.drawable.emoji_1f477);
        sSoftbanksMap.put(58652, R.drawable.emoji_1f478);
        sSoftbanksMap.put(58653, R.drawable.emoji_1f5fd);
        sSoftbanksMap.put(58654, R.drawable.emoji_1f482);
        sSoftbanksMap.put(58655, R.drawable.emoji_1f483);
        sSoftbanksMap.put(58656, R.drawable.emoji_1f42c);
        sSoftbanksMap.put(58657, R.drawable.emoji_1f426);
        sSoftbanksMap.put(58658, R.drawable.emoji_1f420);
        sSoftbanksMap.put(58659, R.drawable.emoji_1f423);
        sSoftbanksMap.put(58660, R.drawable.emoji_1f439);
        sSoftbanksMap.put(58661, R.drawable.emoji_1f41b);
        sSoftbanksMap.put(58662, R.drawable.emoji_1f418);
        sSoftbanksMap.put(58663, R.drawable.emoji_1f428);
        sSoftbanksMap.put(58664, R.drawable.emoji_1f412);
        sSoftbanksMap.put(58665, R.drawable.emoji_1f411);
        sSoftbanksMap.put(58666, R.drawable.emoji_1f43a);
        sSoftbanksMap.put(58667, R.drawable.emoji_1f42e);
        sSoftbanksMap.put(58668, R.drawable.emoji_1f430);
        sSoftbanksMap.put(58669, R.drawable.emoji_1f40d);
        sSoftbanksMap.put(58670, R.drawable.emoji_1f414);
        sSoftbanksMap.put(58671, R.drawable.emoji_1f417);
        sSoftbanksMap.put(58672, R.drawable.emoji_1f42b);
        sSoftbanksMap.put(58673, R.drawable.emoji_1f438);
        sSoftbanksMap.put(58674, R.drawable.emoji_1f170);
        sSoftbanksMap.put(58675, R.drawable.emoji_1f171);
        sSoftbanksMap.put(58676, R.drawable.emoji_1f18e);
        sSoftbanksMap.put(58677, R.drawable.emoji_1f17e);
        sSoftbanksMap.put(58678, R.drawable.emoji_1f43e);
        sSoftbanksMap.put(58679, R.drawable.emoji_2122);
    }
}
