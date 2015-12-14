// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Point;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.database.r;
import com.cyberlink.youcammakeup.jniproxy.aa;
import com.cyberlink.youcammakeup.jniproxy.ab;
import com.cyberlink.youcammakeup.jniproxy.ac;
import com.cyberlink.youcammakeup.jniproxy.ad;
import com.cyberlink.youcammakeup.jniproxy.af;
import com.cyberlink.youcammakeup.jniproxy.ag;
import com.cyberlink.youcammakeup.jniproxy.ah;
import com.cyberlink.youcammakeup.jniproxy.ai;
import com.cyberlink.youcammakeup.jniproxy.ak;
import com.cyberlink.youcammakeup.jniproxy.av;
import com.cyberlink.youcammakeup.jniproxy.ax;
import com.cyberlink.youcammakeup.jniproxy.bn;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.at;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.pf.common.utility.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class be
{

    public static String a[];
    private static Map b;

    public static String a(Context context, String s)
    {
        String s1;
        int i;
        s1 = null;
        i = 0;
        context = context.getAssets().open(s);
        s = context;
        byte abyte0[] = new byte[1024];
        s = context;
        MessageDigest messagedigest = MessageDigest.getInstance("MD5");
_L4:
        if (i == -1) goto _L2; else goto _L1
_L1:
        s = context;
        int j = context.read(abyte0);
        i = j;
        if (j <= 0) goto _L4; else goto _L3
_L3:
        s = context;
        messagedigest.update(abyte0, 0, j);
        i = j;
          goto _L4
        s;
_L8:
        s = context;
        m.e("SampleImageHelper", "md5 checking fail");
        s = s1;
        if (context != null)
        {
            String s2;
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                m.e("SampleImageHelper", "inputStream close fail");
                return null;
            }
            s = s1;
        }
        return s;
_L2:
        s = context;
        s2 = a(messagedigest.digest());
        s1 = s2;
        s = s1;
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                m.e("SampleImageHelper", "inputStream close fail");
                return s1;
            }
            return s1;
        } else
        {
            break MISSING_BLOCK_LABEL_96;
        }
        context;
        s = null;
_L6:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                m.e("SampleImageHelper", "inputStream close fail");
            }
        }
        throw context;
        context;
        if (true) goto _L6; else goto _L5
_L5:
        context;
        context = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static String a(r r1)
    {
        if (r1 == null)
        {
            return null;
        } else
        {
            return a(com.cyberlink.youcammakeup.c.f().b(r1));
        }
    }

    public static String a(String s)
    {
        String s1;
        int i;
        s1 = null;
        i = 0;
        Object obj = new FileInputStream(s);
        s = ((String) (obj));
        byte abyte0[] = new byte[1024];
        s = ((String) (obj));
        MessageDigest messagedigest = MessageDigest.getInstance("MD5");
_L4:
        if (i == -1) goto _L2; else goto _L1
_L1:
        s = ((String) (obj));
        int j = ((InputStream) (obj)).read(abyte0);
        i = j;
        if (j <= 0) goto _L4; else goto _L3
_L3:
        s = ((String) (obj));
        messagedigest.update(abyte0, 0, j);
        i = j;
          goto _L4
        s;
_L8:
        s = ((String) (obj));
        m.e("SampleImageHelper", "md5 checking fail");
        s = s1;
        if (obj != null)
        {
            String s2;
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                m.e("SampleImageHelper", "inputStream close fail");
                return null;
            }
            s = s1;
        }
        return s;
_L2:
        s = ((String) (obj));
        s2 = a(messagedigest.digest());
        s1 = s2;
        s = s1;
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                m.e("SampleImageHelper", "inputStream close fail");
                return s1;
            }
            return s1;
        } else
        {
            break MISSING_BLOCK_LABEL_96;
        }
        obj;
        s = null;
_L6:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                m.e("SampleImageHelper", "inputStream close fail");
            }
        }
        throw obj;
        obj;
        if (true) goto _L6; else goto _L5
_L5:
        s;
        obj = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static String a(byte abyte0[])
    {
        String s = "";
        String s1 = s;
        if (abyte0 != null)
        {
            int i = 0;
            do
            {
                s1 = s;
                if (i >= abyte0.length)
                {
                    break;
                }
                s = (new StringBuilder()).append(s).append(Integer.toString((abyte0[i] & 0xff) + 256, 16).substring(1)).toString();
                i++;
            } while (true);
        }
        return s1;
    }

    public static void a(String s, String s1)
    {
        if (b != null && b.containsKey(s))
        {
            b.put(s, s1);
        }
    }

    public static ar b(r r1)
    {
        float f;
        Object obj;
        av av1;
        y y1;
        ai ai1;
        Point point = null;
        av1 = null;
        y1 = new y();
        ai1 = new ai();
        if (r1 == null)
        {
            return null;
        }
        String s = com.cyberlink.youcammakeup.c.f().b(r1);
        obj = point;
        if (s != null)
        {
            String as2[] = s.split("/");
            obj = point;
            if (as2 != null)
            {
                obj = as2[as2.length - 1];
            }
        }
        point = r1.l();
        f = (float)r1.k().x / (float)point.x;
        if (obj == null) goto _L2; else goto _L1
_L1:
        String as[] = ((String) (obj)).split("\\.");
        if (as.length > 1)
        {
            r1 = as[as.length - 1];
        } else
        {
            r1 = null;
        }
        if (r1 == null || !r1.equals("jpg") && !r1.equals("JPG")) goto _L2; else goto _L3
_L3:
        r1 = as[0];
_L250:
        Object obj1;
        if (r1 == null)
        {
            m.e("SampleImageHelper", "getFeaturePointFromFile: no file");
            return null;
        }
        obj1 = Globals.d().getAssets();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        m.e("SampleImageHelper", "getFeaturePointFromFile: Null Assets.");
        String as1[] = ((AssetManager) (obj1)).list("sample");
        if (as1 == null) goto _L5; else goto _L4
_L4:
        int i = 0;
_L248:
        if (i >= as1.length) goto _L7; else goto _L6
_L6:
        String as3[] = as1[i].split("\\.");
        if (as3.length <= 1) goto _L9; else goto _L8
_L8:
        obj = as3[as3.length - 1];
_L251:
        if (obj == null) goto _L11; else goto _L10
_L10:
        if (!((String) (obj)).equals("ini") && !((String) (obj)).equals("INI") || !r1.equals(as3[0])) goto _L11; else goto _L12
_L12:
        obj = new BufferedReader(new InputStreamReader(((AssetManager) (obj1)).open((new StringBuilder()).append("sample").append(File.separator).append(as1[i]).toString())));
        r1 = av1;
        if (obj == null) goto _L14; else goto _L13
_L13:
        i = 0;
        bn bn1;
        ac ac1;
        ab ab1;
        ab ab2;
        ak ak1;
        ak ak2;
        ag ag1;
        aa aa1;
        af af1;
        com.cyberlink.youcammakeup.jniproxy.z z1;
        com.cyberlink.youcammakeup.jniproxy.z z2;
        ad ad1;
        ah ah1;
        r1 = new ac();
        ac1 = new ac();
        ab1 = new ab();
        ab2 = new ab();
        ak1 = new ak();
        ak2 = new ak();
        ag1 = new ag();
        aa1 = new aa();
        af1 = new af();
        z1 = new com.cyberlink.youcammakeup.jniproxy.z();
        z2 = new com.cyberlink.youcammakeup.jniproxy.z();
        ad1 = new ad();
        ah1 = new ah();
        av1 = new av();
        obj1 = new ax();
        bn1 = new bn();
        boolean flag1 = false;
        at at1 = new at();
_L18:
        String s1 = ((BufferedReader) (obj)).readLine();
        if (s1 == null) goto _L16; else goto _L15
_L15:
        String as4[] = s1.split("=");
        if (as4.length <= 1) goto _L18; else goto _L17
_L17:
        float f1 = Float.parseFloat(as4[1]) * f;
        if (i != 0) goto _L20; else goto _L19
_L19:
        ah1.a(f1);
        boolean flag = flag1;
          goto _L21
_L20:
        if (i != 1) goto _L23; else goto _L22
_L22:
        ah1.b(f1);
        z1.a(ah1);
        flag = flag1;
          goto _L21
        obj;
        r1 = null;
_L247:
        ((IOException) (obj)).printStackTrace();
        m.e("SampleImageHelper", "getFeaturePointFromFile: get feature point fail.");
        obj = r1;
_L246:
        return ((ar) (obj));
_L23:
        if (i != 2) goto _L25; else goto _L24
_L24:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L25:
        if (i != 3) goto _L27; else goto _L26
_L26:
        ah1.b(f1);
        z1.b(ah1);
        flag = flag1;
          goto _L21
_L27:
        if (i != 4) goto _L29; else goto _L28
_L28:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L29:
        if (i != 5) goto _L31; else goto _L30
_L30:
        ah1.b(f1);
        z1.c(ah1);
        flag = flag1;
          goto _L21
_L31:
        if (i != 6) goto _L33; else goto _L32
_L32:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L33:
        if (i != 7) goto _L35; else goto _L34
_L34:
        ah1.b(f1);
        z1.d(ah1);
        flag = flag1;
          goto _L21
_L35:
        if (i != 8) goto _L37; else goto _L36
_L36:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L37:
        if (i != 9) goto _L39; else goto _L38
_L38:
        ah1.b(f1);
        r1.a(ah1);
        flag = flag1;
          goto _L21
_L39:
        if (i != 10) goto _L41; else goto _L40
_L40:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L41:
        if (i != 11) goto _L43; else goto _L42
_L42:
        ah1.b(f1);
        r1.b(ah1);
        flag = flag1;
          goto _L21
_L43:
        if (i != 12) goto _L45; else goto _L44
_L44:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L45:
        if (i != 13) goto _L47; else goto _L46
_L46:
        ah1.b(f1);
        r1.c(ah1);
        flag = flag1;
          goto _L21
_L47:
        if (i != 14) goto _L49; else goto _L48
_L48:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L49:
        if (i != 15) goto _L51; else goto _L50
_L50:
        ah1.b(f1);
        r1.d(ah1);
        flag = flag1;
          goto _L21
_L51:
        if (i != 16) goto _L53; else goto _L52
_L52:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L53:
        if (i != 17) goto _L55; else goto _L54
_L54:
        ah1.b(f1);
        r1.e(ah1);
        flag = flag1;
          goto _L21
_L55:
        if (i != 18) goto _L57; else goto _L56
_L56:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L57:
        if (i != 19) goto _L59; else goto _L58
_L58:
        ah1.b(f1);
        z2.a(ah1);
        flag = flag1;
          goto _L21
_L59:
        if (i != 20) goto _L61; else goto _L60
_L60:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L61:
        if (i != 21) goto _L63; else goto _L62
_L62:
        ah1.b(f1);
        z2.b(ah1);
        flag = flag1;
          goto _L21
_L63:
        if (i != 22) goto _L65; else goto _L64
_L64:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L65:
        if (i != 23) goto _L67; else goto _L66
_L66:
        ah1.b(f1);
        z2.c(ah1);
        flag = flag1;
          goto _L21
_L67:
        if (i != 24) goto _L69; else goto _L68
_L68:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L69:
        if (i != 25) goto _L71; else goto _L70
_L70:
        ah1.b(f1);
        z2.d(ah1);
        flag = flag1;
          goto _L21
_L71:
        if (i != 26) goto _L73; else goto _L72
_L72:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L73:
        if (i != 27) goto _L75; else goto _L74
_L74:
        ah1.b(f1);
        ac1.a(ah1);
        flag = flag1;
          goto _L21
_L75:
        if (i != 28) goto _L77; else goto _L76
_L76:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L77:
        if (i != 29) goto _L79; else goto _L78
_L78:
        ah1.b(f1);
        ac1.b(ah1);
        flag = flag1;
          goto _L21
_L79:
        if (i != 30) goto _L81; else goto _L80
_L80:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L81:
        if (i != 31) goto _L83; else goto _L82
_L82:
        ah1.b(f1);
        ac1.c(ah1);
        flag = flag1;
          goto _L21
_L83:
        if (i != 32) goto _L85; else goto _L84
_L84:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L85:
        if (i != 33) goto _L87; else goto _L86
_L86:
        ah1.b(f1);
        ac1.d(ah1);
        flag = flag1;
          goto _L21
_L87:
        if (i != 34) goto _L89; else goto _L88
_L88:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L89:
        if (i != 35) goto _L91; else goto _L90
_L90:
        ah1.b(f1);
        ac1.e(ah1);
        flag = flag1;
          goto _L21
_L91:
        if (i != 36) goto _L93; else goto _L92
_L92:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L93:
        if (i != 37) goto _L95; else goto _L94
_L94:
        ah1.b(f1);
        ag1.a(ah1);
        flag = flag1;
          goto _L21
_L95:
        if (i != 38) goto _L97; else goto _L96
_L96:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L97:
        if (i != 39) goto _L99; else goto _L98
_L98:
        ah1.b(f1);
        ag1.b(ah1);
        flag = flag1;
          goto _L21
_L99:
        if (i != 40) goto _L101; else goto _L100
_L100:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L101:
        if (i != 41) goto _L103; else goto _L102
_L102:
        ah1.b(f1);
        ag1.c(ah1);
        flag = flag1;
          goto _L21
_L103:
        if (i != 42) goto _L105; else goto _L104
_L104:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L105:
        if (i != 43) goto _L107; else goto _L106
_L106:
        ah1.b(f1);
        ag1.d(ah1);
        flag = flag1;
          goto _L21
_L107:
        if (i != 44) goto _L109; else goto _L108
_L108:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L109:
        if (i != 45) goto _L111; else goto _L110
_L110:
        ah1.b(f1);
        af1.a(ah1);
        flag = flag1;
          goto _L21
_L111:
        if (i != 46) goto _L113; else goto _L112
_L112:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L113:
        if (i != 47) goto _L115; else goto _L114
_L114:
        ah1.b(f1);
        af1.b(ah1);
        flag = flag1;
          goto _L21
_L115:
        if (i != 48) goto _L117; else goto _L116
_L116:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L117:
        if (i != 49) goto _L119; else goto _L118
_L118:
        ah1.b(f1);
        af1.c(ah1);
        flag = flag1;
          goto _L21
_L119:
        if (i != 50) goto _L121; else goto _L120
_L120:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L121:
        if (i != 51) goto _L123; else goto _L122
_L122:
        ah1.b(f1);
        af1.d(ah1);
        flag = flag1;
          goto _L21
_L123:
        if (i != 52) goto _L125; else goto _L124
_L124:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L125:
        if (i != 53) goto _L127; else goto _L126
_L126:
        ah1.b(f1);
        af1.e(ah1);
        flag = flag1;
          goto _L21
_L127:
        if (i != 54) goto _L129; else goto _L128
_L128:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L129:
        if (i != 55) goto _L131; else goto _L130
_L130:
        ah1.b(f1);
        af1.f(ah1);
        flag = flag1;
          goto _L21
_L131:
        if (i != 56) goto _L133; else goto _L132
_L132:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L133:
        if (i != 57) goto _L135; else goto _L134
_L134:
        ah1.b(f1);
        aa1.a(ah1);
        flag = flag1;
          goto _L21
_L135:
        if (i != 58) goto _L137; else goto _L136
_L136:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L137:
        if (i != 59) goto _L139; else goto _L138
_L138:
        ah1.b(f1);
        ab1.a(ah1);
        flag = flag1;
          goto _L21
_L139:
        if (i != 60) goto _L141; else goto _L140
_L140:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L141:
        if (i != 61) goto _L143; else goto _L142
_L142:
        ah1.b(f1);
        ab1.b(ah1);
        flag = flag1;
          goto _L21
_L143:
        if (i != 62) goto _L145; else goto _L144
_L144:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L145:
        if (i != 63) goto _L147; else goto _L146
_L146:
        ah1.b(f1);
        ak1.a(ah1);
        flag = flag1;
          goto _L21
_L147:
        if (i != 64) goto _L149; else goto _L148
_L148:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L149:
        if (i != 65) goto _L151; else goto _L150
_L150:
        ah1.b(f1);
        ak1.b(ah1);
        flag = flag1;
          goto _L21
_L151:
        if (i != 66) goto _L153; else goto _L152
_L152:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L153:
        if (i != 67) goto _L155; else goto _L154
_L154:
        ah1.b(f1);
        ab2.a(ah1);
        flag = flag1;
          goto _L21
_L155:
        if (i != 68) goto _L157; else goto _L156
_L156:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L157:
        if (i != 69) goto _L159; else goto _L158
_L158:
        ah1.b(f1);
        ab2.b(ah1);
        flag = flag1;
          goto _L21
_L159:
        if (i != 70) goto _L161; else goto _L160
_L160:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L161:
        if (i != 71) goto _L163; else goto _L162
_L162:
        ah1.b(f1);
        ak2.a(ah1);
        flag = flag1;
          goto _L21
_L163:
        if (i != 72) goto _L165; else goto _L164
_L164:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L165:
        if (i != 73) goto _L167; else goto _L166
_L166:
        ah1.b(f1);
        ak2.b(ah1);
        flag = flag1;
          goto _L21
_L167:
        if (i != 74) goto _L169; else goto _L168
_L168:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L169:
        if (i != 75) goto _L171; else goto _L170
_L170:
        ah1.b(f1);
        af1.h(ah1);
        flag = flag1;
          goto _L21
_L171:
        if (i != 76) goto _L173; else goto _L172
_L172:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L173:
        if (i != 77) goto _L175; else goto _L174
_L174:
        ah1.b(f1);
        af1.g(ah1);
        flag = flag1;
          goto _L21
_L175:
        if (i != 78) goto _L177; else goto _L176
_L176:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L177:
        if (i != 79) goto _L179; else goto _L178
_L178:
        ah1.b(f1);
        af1.j(ah1);
        flag = flag1;
          goto _L21
_L179:
        if (i != 80) goto _L181; else goto _L180
_L180:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L181:
        if (i != 81) goto _L183; else goto _L182
_L182:
        ah1.b(f1);
        af1.i(ah1);
        flag = flag1;
          goto _L21
_L183:
        if (i != 82) goto _L185; else goto _L184
_L184:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L185:
        if (i != 83) goto _L187; else goto _L186
_L186:
        ah1.b(f1);
        af1.l(ah1);
        flag = flag1;
          goto _L21
_L187:
        if (i != 84) goto _L189; else goto _L188
_L188:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L189:
        if (i != 85) goto _L191; else goto _L190
_L190:
        ah1.b(f1);
        af1.k(ah1);
        flag = flag1;
          goto _L21
_L191:
        if (i != 86) goto _L193; else goto _L192
_L192:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L193:
        if (i != 87) goto _L195; else goto _L194
_L194:
        ah1.b(f1);
        af1.m(ah1);
        flag = flag1;
          goto _L21
_L195:
        if (i != 88) goto _L197; else goto _L196
_L196:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L197:
        if (i != 89) goto _L199; else goto _L198
_L198:
        ah1.b(f1);
        af1.n(ah1);
        flag = flag1;
          goto _L21
_L199:
        if (i != 90) goto _L201; else goto _L200
_L200:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L201:
        if (i != 91) goto _L203; else goto _L202
_L202:
        ah1.b(f1);
        af1.o(ah1);
        flag = flag1;
          goto _L21
_L203:
        if (i != 92) goto _L205; else goto _L204
_L204:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L205:
        if (i != 93) goto _L207; else goto _L206
_L206:
        ah1.b(f1);
        af1.p(ah1);
        flag = flag1;
          goto _L21
_L207:
        if (i != 94) goto _L209; else goto _L208
_L208:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L209:
        if (i != 95) goto _L211; else goto _L210
_L210:
        ah1.b(f1);
        ag1.e(ah1);
        flag = flag1;
          goto _L21
_L211:
        if (i != 96) goto _L213; else goto _L212
_L212:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L213:
        if (i != 97) goto _L215; else goto _L214
_L214:
        ah1.b(f1);
        ad1.a(ah1);
        flag = flag1;
          goto _L21
_L215:
        if (i != 98) goto _L217; else goto _L216
_L216:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L217:
        if (i != 99) goto _L219; else goto _L218
_L218:
        ah1.b(f1);
        ad1.b(ah1);
        flag = flag1;
          goto _L21
_L219:
        if (i != 100) goto _L221; else goto _L220
_L220:
        ah1.a(f1);
        flag = flag1;
          goto _L21
_L221:
        if (i != 101) goto _L223; else goto _L222
_L222:
        ah1.b(f1);
        ad1.c(ah1);
        flag = flag1;
          goto _L21
_L223:
        if (i != 102) goto _L225; else goto _L224
_L224:
        ai1.a((int)f1);
        flag = flag1;
          goto _L21
_L225:
        if (i != 103) goto _L227; else goto _L226
_L226:
        ai1.b((int)f1);
        flag = flag1;
          goto _L21
_L227:
        if (i != 104) goto _L229; else goto _L228
_L228:
        ai1.c((int)f1);
        flag = flag1;
          goto _L21
_L229:
        if (i != 105) goto _L231; else goto _L230
_L230:
        ai1.d((int)f1);
        flag = flag1;
          goto _L21
_L231:
        if (i != 106) goto _L233; else goto _L232
_L232:
        av1.a((int)f1);
        flag = flag1;
          goto _L21
_L233:
        if (i != 107) goto _L235; else goto _L234
_L234:
        av1.a((int)f1);
        flag = flag1;
          goto _L21
_L235:
        if (i != 108) goto _L237; else goto _L236
_L236:
        av1.a((int)f1);
        flag = flag1;
          goto _L21
_L237:
        if (i != 109) goto _L239; else goto _L238
_L238:
        ((ax) (obj1)).a((int)f1);
        flag = flag1;
          goto _L21
_L239:
        if (i != 110) goto _L241; else goto _L240
_L240:
        bn1.a((int)f1);
        flag = flag1;
          goto _L21
_L253:
        if (i != 112) goto _L243; else goto _L242
_L242:
        at1.a((int)f1);
        flag = flag1;
          goto _L21
_L243:
        flag = flag1;
        if (i != 113) goto _L21; else goto _L244
_L244:
        at1.b((int)f1);
        flag = flag1;
          goto _L21
_L16:
        y1.a(z1);
        y1.b(z2);
        y1.a(r1);
        y1.b(ac1);
        y1.a(ab1);
        y1.b(ab2);
        y1.a(ak1);
        y1.b(ak2);
        y1.a(aa1);
        y1.a(af1);
        y1.a(ag1);
        y1.a(ad1);
        r1 = new ar(0);
        r1.a(ai1, y1);
        r1.a(((ax) (obj1)));
        r1.a(bn1);
        r1.a(flag1);
        r1.a(at1);
        MotionControlHelper.e().a(av1);
_L14:
        ((BufferedReader) (obj)).close();
_L249:
        obj = r1;
        if (as1.length != 0) goto _L246; else goto _L245
_L245:
        m.c("SampleImageHelper", "getFeaturePointFromFile: No default image.");
        obj = r1;
          goto _L246
        obj;
          goto _L247
_L11:
        i++;
          goto _L248
_L5:
        m.c("SampleImageHelper", "getFeaturePointFromFile: No default image.");
        obj = null;
          goto _L246
        obj;
          goto _L247
        obj;
          goto _L247
_L7:
        r1 = null;
          goto _L249
_L2:
        r1 = ((r) (obj));
          goto _L250
_L21:
        i++;
        flag1 = flag;
          goto _L18
_L9:
        obj = null;
          goto _L251
_L241:
        if (i != 111) goto _L253; else goto _L252
_L252:
        if (f1 != 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L21
    }

    public static String b(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return a(s);
        }
    }

    public static String c(r r1)
    {
        if (r1 != null)
        {
            if ((r1 = com.cyberlink.youcammakeup.c.f().b(r1)) != null && (r1 = r1.split("/")) != null)
            {
                return r1[r1.length - 1];
            }
        }
        return null;
    }

    public static boolean d(r r1)
    {
        if (r1 != null)
        {
            String s = a(r1);
            r1 = c(r1);
            if (s != null && r1 != null && b.containsKey(r1) && ((String)b.get(r1)).toUpperCase(Locale.ENGLISH).equals(s.toUpperCase(Locale.ENGLISH)))
            {
                return true;
            }
        }
        return false;
    }

    static 
    {
        b = new HashMap();
        b.put("YouCamMakeup Sample-1.jpg", z.b("YouCamMakeup Sample-1.jpg", "", Globals.d().getApplicationContext()));
        b.put("YouCamMakeup Sample-2.jpg", z.b("YouCamMakeup Sample-2.jpg", "", Globals.d().getApplicationContext()));
        b.put("YouCamMakeup Sample-3.jpg", z.b("YouCamMakeup Sample-3.jpg", "", Globals.d().getApplicationContext()));
        b.put("YouCamMakeup Sample-4.jpg", z.b("YouCamMakeup Sample-4.jpg", "", Globals.d().getApplicationContext()));
        b.put("YouCamMakeup Sample-5.jpg", z.b("YouCamMakeup Sample-5.jpg", "", Globals.d().getApplicationContext()));
        b.put("YouCamMakeup Sample-8.jpg", z.b("YouCamMakeup Sample-8.jpg", "", Globals.d().getApplicationContext()));
        a = new String[6];
        a[0] = "YouCamMakeup Sample-8.jpg";
        a[1] = "YouCamMakeup Sample-5.jpg";
        a[2] = "YouCamMakeup Sample-1.jpg";
        a[3] = "YouCamMakeup Sample-2.jpg";
        a[4] = "YouCamMakeup Sample-3.jpg";
        a[5] = "YouCamMakeup Sample-4.jpg";
    }
}
