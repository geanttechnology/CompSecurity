// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PinyinUtils
{

    private static final int DISTINGUISH_LEN = 10;
    private static final char FIRST_CHINA = 19968;
    private static final char LAST_CHINA = 40869;
    private static final String PINYIN[] = {
        "a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", 
        "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", 
        "bu", "ca", "cai", "can", "cang", "cao", "ce", "cen", "ceng", "cha", 
        "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", 
        "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", 
        "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", 
        "de", "deng", "di", "dia", "dian", "diao", "die", "ding", "diu", "dong", 
        "dou", "du", "duan", "dui", "dun", "duo", "e", "ei", "en", "er", 
        "fa", "fan", "fang", "fei", "fen", "feng", "fo", "fou", "fu", "ga", 
        "gai", "gan", "gang", "gao", "ge", "gei", "gen", "geng", "gong", "gou", 
        "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", 
        "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", 
        "hua", "huai", "huan", "huang", "hui", "hun", "huo", "ji", "jia", "jian", 
        "jiang", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", 
        "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", 
        "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", 
        "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", 
        "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "luan", 
        "lun", "luo", "lv", "lve", "m", "ma", "mai", "man", "mang", "mao", 
        "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", 
        "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", 
        "nei", "nen", "neng", "ng", "ni", "nian", "niang", "niao", "nie", "nin", 
        "ning", "niu", "none", "nong", "nou", "nu", "nuan", "nuo", "nv", "nve", 
        "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", 
        "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", "pu", "qi", 
        "qia", "qian", "qiang", "qiao", "qie", "qin", "qing", "qiong", "qiu", "qu", 
        "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", 
        "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", 
        "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", 
        "she", "shei", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", 
        "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", 
        "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", 
        "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", 
        "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", 
        "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", 
        "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "yao", "ye", "yi", 
        "yiao", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", 
        "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", 
        "zhai", "zhan", "zhang", "zhao", "zhe", "zhei", "zhen", "zheng", "zhi", "zhong", 
        "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", 
        "zong", "zou", "zu", "zuan", "zui", "zun", "zuo"
    };
    private static final char SPECIAL_HANZI = 12295;
    private static final String SPECIAL_HANZI_PINYIN = "LING";
    private static volatile boolean isLoad = false;
    private static PinyinUtils sInstance;
    private static short sPinyinIndex[];

    private PinyinUtils()
    {
    }

    private boolean distinguish(char ac[], char ac1[], String as[], int i)
    {
        int j;
        int k;
        boolean flag1;
        flag1 = false;
        ac = new String(ac);
        j = 0;
        k = 0;
_L6:
        if (j < i) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        int l = ac.indexOf(as[j].charAt(0), k);
        k = l;
        if (l == -1)
        {
            k = ac.indexOf(ac1[j], l);
        }
        flag = flag1;
        if (k == -1) goto _L4; else goto _L3
_L3:
        j++;
        k++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static PinyinUtils getInstance(Context context)
    {
        com/sina/weibo/sdk/register/mobile/PinyinUtils;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            sInstance = new PinyinUtils();
        }
        loadData(context);
        context = sInstance;
        com/sina/weibo/sdk/register/mobile/PinyinUtils;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static PinyinUtils getObject()
    {
        return sInstance;
    }

    private String getPinyin(char c)
    {
        String s;
        if (!isLoad)
        {
            s = "";
        } else
        {
            if (c == '\u3007')
            {
                return "LING";
            }
            if (c < '\u4E00' || c > '\u9FA5')
            {
                return String.valueOf(c);
            }
            String s1 = PINYIN[sPinyinIndex[c - 19968]];
            s = s1;
            if (s1 == null)
            {
                return "";
            }
        }
        return s;
    }

    private static void loadData(Context context)
    {
        Object obj;
        Object obj3;
        obj3 = null;
        obj = null;
        boolean flag = isLoad;
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        Exception exception;
        int i;
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        throw new NullPointerException();
_L4:
        return;
_L2:
        context = context.getAssets().open("pinyinindex");
        obj = new DataInputStream(context);
        obj3 = obj;
        obj1 = context;
        sPinyinIndex = new short[(int)(long)(((DataInputStream) (obj)).available() >> 1)];
        i = 0;
_L5:
        obj3 = obj;
        obj1 = context;
        if (i < sPinyinIndex.length)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        obj3 = obj;
        obj1 = context;
        isLoad = true;
        if (obj != null)
        {
            try
            {
                ((DataInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        }
        if (context == null) goto _L4; else goto _L3
_L3:
        context.close();
        return;
        obj3 = obj;
        obj1 = context;
        sPinyinIndex[i] = ((DataInputStream) (obj)).readShort();
        i++;
          goto _L5
        context;
        context = null;
_L11:
        isLoad = false;
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        }
        if (obj == null) goto _L4; else goto _L6
_L6:
        ((InputStream) (obj)).close();
        return;
        context;
        obj = null;
        context = null;
_L10:
        obj3 = obj;
        obj1 = context;
        isLoad = false;
        if (obj != null)
        {
            try
            {
                ((DataInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        }
        if (context == null) goto _L4; else goto _L7
_L7:
        context.close();
        return;
        obj;
        context = null;
_L9:
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_211;
        }
        ((DataInputStream) (obj3)).close();
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        throw obj;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        context = ((Context) (obj1));
        continue; /* Loop/switch isn't completed */
        exception;
        obj1 = obj;
        obj = exception;
        exception = context;
        context = ((Context) (obj1));
        if (true) goto _L9; else goto _L8
_L8:
        obj;
        obj = null;
          goto _L10
        obj2;
          goto _L10
        obj;
        obj2 = null;
        obj = context;
        context = ((Context) (obj2));
          goto _L11
        obj2;
        obj2 = context;
        context = ((Context) (obj));
        obj = obj2;
          goto _L11
    }

    private char[] subCharRangeArray(char ac[], int i, int j)
    {
        char ac1[] = new char[(j - i) + 1];
        boolean flag = false;
        int k = i;
        i = ((flag) ? 1 : 0);
        do
        {
            if (k > j)
            {
                return ac1;
            }
            ac1[i] = ac[k];
            k++;
            i++;
        } while (true);
    }

    private String[] subStringRangeArray(String as[], int i, int j)
    {
        String as1[] = new String[(j - i) + 1];
        boolean flag = false;
        int k = i;
        i = ((flag) ? 1 : 0);
        do
        {
            if (k > j)
            {
                return as1;
            }
            as1[i] = as[k];
            k++;
            i++;
        } while (true);
    }

    public int distinguish(char ac[], int i, char ac1[], String as[], int j, int k)
    {
        if (i != 0 || ac[0] != ac1[0] && ac[0] != as[0].charAt(0)) goto _L2; else goto _L1
_L1:
        if (ac.length == 1) goto _L4; else goto _L3
_L3:
        i = distinguish(ac, 1, ac1, as, 0, 1);
_L6:
        return i;
_L4:
        return 0;
_L2:
        if (as[j].length() <= k || i >= ac.length || ac[i] != ac1[j] && ac[i] != as[j].charAt(k))
        {
            break; /* Loop/switch isn't completed */
        }
        if (i == ac.length - 1)
        {
            i = j;
            if (!distinguish(ac, ac1, as, j))
            {
                return -1;
            }
        } else
        {
            return distinguish(ac, i + 1, ac1, as, j, k + 1);
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (as.length > j + 1 && i < ac.length && (ac[i] == ac1[j + 1] || ac[i] == as[j + 1].charAt(0)))
        {
            if (i == ac.length - 1)
            {
                if (distinguish(ac, ac1, as, j))
                {
                    return j + 1;
                } else
                {
                    return -1;
                }
            } else
            {
                return distinguish(ac, i + 1, ac1, as, j + 1, 1);
            }
        }
        if (as.length <= j + 1) goto _L8; else goto _L7
_L7:
        k = 1;
_L11:
        if (k < i) goto _L9; else goto _L8
_L8:
        return -1;
_L9:
        if (distinguish(ac, i - k, ac1, as, j + 1, 0) != -1)
        {
            return j + 1;
        }
        k++;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public MatchedResult getMatchedResult(String s, String s1)
    {
        MatchedResult matchedresult;
        char ac[];
        int i;
        matchedresult = new MatchedResult();
        matchedresult.start = -1;
        matchedresult.end = -1;
        if (!isLoad)
        {
            return matchedresult;
        }
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1))
        {
            return matchedresult;
        }
        s = s.toUpperCase();
        s1 = s1.toUpperCase();
        if (Math.min(s.length(), s1.length()) > 10)
        {
            s = s.substring(0, 10);
            s1 = s1.substring(0, 10);
        }
        i = s.indexOf(s1);
        if (i >= 0)
        {
            matchedresult.start = i;
            matchedresult.end = (i + s1.length()) - 1;
        }
        ac = new char[s1.length()];
        i = 0;
_L5:
        if (i < s1.length()) goto _L2; else goto _L1
_L1:
        String as[];
        int j;
        s1 = new char[s.length()];
        as = new String[s.length()];
        j = s.length();
        i = 0;
_L6:
        if (i < j) goto _L4; else goto _L3
_L3:
        j = ac[0];
        i = 0;
_L7:
        if (i >= as.length)
        {
            return matchedresult;
        }
        break MISSING_BLOCK_LABEL_282;
_L2:
        ac[i] = s1.charAt(i);
        i++;
          goto _L5
_L4:
        char c = s.charAt(i);
        s1[i] = c;
        String s2 = getPinyin(c);
        if (!TextUtils.isEmpty(s2))
        {
            as[i] = s2.toUpperCase();
        } else
        {
            as[i] = (new StringBuilder(String.valueOf(c))).toString();
        }
        i++;
          goto _L6
        char c1 = as[i].charAt(0);
        char c2 = s1[i];
        if (c1 == j || c2 == j)
        {
            int k = distinguish(ac, 0, subCharRangeArray(s1, i, s1.length - 1), subStringRangeArray(as, i, as.length - 1), 0, 0);
            if (k != -1)
            {
                matchedresult.start = i;
                matchedresult.end = k + i;
                return matchedresult;
            }
        }
        i++;
          goto _L7
    }

    public String getPinyin(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return "";
        }
        if (!isLoad)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        int j = s.length();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return stringbuilder.toString();
            }
            stringbuilder.append(getPinyin(s.charAt(i)));
            i++;
        } while (true);
    }


    private class MatchedResult
    {

        public int end;
        public int start;

        public MatchedResult()
        {
            start = -1;
            end = -1;
        }
    }

}
