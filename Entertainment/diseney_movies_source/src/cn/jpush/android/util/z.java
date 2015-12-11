// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import cn.jpush.android.api.d;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package cn.jpush.android.util:
//            ai

public final class z
{

    public static final Pattern a;
    public static final Pattern b;
    public static final Pattern c;
    public static final Pattern d;
    public static final Pattern e;
    public static final Pattern f;
    private static final String z[];

    public static int a(Set set)
    {
        if (set == null || set.isEmpty())
        {
            return 0;
        }
        if (set.size() > 100)
        {
            return d.g;
        }
        for (set = set.iterator(); set.hasNext();)
        {
            String s = (String)set.next();
            if (s == null)
            {
                return d.e;
            }
            if (s.getBytes().length > 40)
            {
                return d.f;
            }
            if (!Pattern.compile(z[0]).matcher(s).matches())
            {
                return d.e;
            }
        }

        return 0;
    }

    public static boolean a(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return Pattern.compile(z[1]).matcher(s).matches();
        }
    }

    public static int b(String s)
    {
        if (s != null && !ai.a(s))
        {
            if (s.getBytes().length > 40)
            {
                return d.d;
            }
            if (!Pattern.compile(z[0]).matcher(s).matches())
            {
                return d.c;
            }
        }
        return 0;
    }

    static 
    {
        Object obj;
        Object aobj[];
        Object obj1;
        int i;
        int j;
        aobj = new String[3];
        j = 0;
        obj1 = "K\001\u4E6Bi\u9F8A%wR%\002o\033F\036pHqO";
        i = -1;
        obj = ((Object) (aobj));
_L14:
        String as[];
        char ac[];
        int k;
        int l;
        int i1;
        int j1;
        int l1;
        int i2;
        ac = ((String) (obj1)).toCharArray();
        k = ac.length;
        j1 = 0;
        l = 0;
        l1 = i;
        obj1 = ac;
        i2 = j;
        as = ((String []) (obj));
        i1 = k;
        if (k > 1) goto _L2; else goto _L1
_L1:
        String as1[];
        int k1;
        as1 = ((String []) (obj));
        obj = ac;
        k1 = i;
_L10:
        i1 = l;
_L8:
        obj1 = obj;
        j1 = obj1[l];
        i1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 396
    //                   1 403
    //                   2 410
    //                   3 417;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        i = 47;
_L25:
label0:
        {
            obj1[l] = (char)(i ^ j1);
            i1++;
            if (k != 0)
            {
                break label0;
            }
            l = k;
        }
          goto _L8
        j1 = i1;
        i1 = k;
        as = as1;
        i2 = j;
        obj1 = obj;
        l1 = k1;
_L2:
        k1 = l1;
        obj = obj1;
        j = i2;
        as1 = as;
        k = i1;
        l = j1;
        if (i1 > j1) goto _L10; else goto _L9
_L9:
        obj = (new String(((char []) (obj1)))).intern();
        l1;
        JVM INSTR tableswitch 0 1: default 228
    //                   0 247
    //                   1 266;
           goto _L11 _L12 _L13
_L11:
        as[i2] = ((String) (obj));
        j = 1;
        obj1 = "K\001\u4E6Bi\u9F8A%wR%\002o\033F\036pH![h\033%'O";
        i = 0;
        obj = ((Object) (aobj));
          goto _L14
_L12:
        as[i2] = ((String) (obj));
        j = 2;
        obj1 = "=rClttw\021\005\002OjF}\2178\uD7A5\uF96Bi\uFDE0\uFDE5w\uFF84\031ttw\021\005\002OjF}\2178\uD7A5\uF96Bi\uFDE0\uFDE5w\uFF84\030\002HpBnttw\021\005\002OjF}\2178\uD7A5\uF96Bi\uFDE0\uFDE5w\uFF84\031s;s@";
        i = 1;
        obj = ((Object) (aobj));
          goto _L14
_L13:
        as[i2] = ((String) (obj));
        z = ((String []) (aobj));
        obj = "=r\n!]z&\n6_t&\n7Ft&\n\037Lq?\r#Fy7\005+^g)\0371Xm 6mS=8\002>Sw\001\n&Kp<\f,F\1777\005+]f.\0353Vo\007B8\007v;\0378Lz7\027'@z*\027'tt9\017\"H}3\000(B{5\0311Ym#\021\031\006i>0!E~7\004>rir\016 Zi?0'Jr(\0300ZHs\027\"t|0\000)@g\007\027lHz,\027#tt8\017!Ir2\002(B{*\0326\\a/\034=r<&\003\037Dx4\0310ZH&C-As5\027-Aa&\002\037Kp6\006*@d(\0300r<&C.@w)\027.tp7\0044r<&\000\037Jr2\002)Ae(\034=UH&\007\037Nw9\002/]f.\0362VH&C)Fy&\006+M|&\0061\\p/\0068BN;\b Jr2\000(B{5\0335]f.\0362Xm#\021\031\006ir\005%Bp&\005![i40%Lp<\f-Cz*\0311UHs\027l@g=\027+B<&C4]z&\033\037Np<\f,Dy7\0056\\a-\022\031\006i+\n8]N?\0047Zb\007\0277tt8\b Jr2\002.Dy7\005+]a/\035=UH&C0Jy&\0376Nc?\0078[N9\017\"H}0\000(B{5\0336[c-\021\031\006i/0%H~)\022>ri,0%Lp=\002*ZH&\034\037If\007\027lW{\006F\030\002% \034)\032#>\027<AIw7i\036$8^&\\&;R%E#=\027<AIw7i\027%;\000,Ml1\005.\033s&\023*s8\006F}[!8ZuV|o\n8W{\006F\030\002q?\t%\037t>\027<AIw7iH#-Yq\036q&\023*s8\006F,Hw1]%E\"<^wMw;\027<AIw7iGy9\001rNl;R!\\vm\n8W{\006F\030\002\177\"\n(_q6\0338W{\006F\030\002~=\t!L}.\0358W{\006F\030\002o9\000>N}s\027=tp.\036\031So\001\n)XHs";
        i = -1;
_L38:
        obj = ((String) (obj)).toCharArray();
        j = obj.length;
        i1 = 0;
        k = 0;
        k1 = i;
        aobj = ((Object []) (obj));
        l = j;
        if (j > 1) goto _L16; else goto _L15
_L15:
        j1 = i;
_L41:
        l = k;
_L24:
        aobj = ((Object []) (obj));
        i1 = aobj[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 364
    //                   0 655
    //                   1 662
    //                   2 669
    //                   3 676;
           goto _L17 _L18 _L19 _L20 _L21
_L17:
        i = 47;
_L39:
        aobj[k] = (char)(i ^ i1);
        l++;
        if (j != 0) goto _L23; else goto _L22
_L22:
        k = j;
          goto _L24
_L4:
        i = 21;
          goto _L25
_L5:
        i = 90;
          goto _L25
_L6:
        i = 107;
          goto _L25
_L7:
        i = 68;
          goto _L25
_L44:
        c = Pattern.compile(((String) (obj)));
        obj1 = (new StringBuilder(z[2])).append(a);
        obj = "<&".toCharArray();
        j = obj.length;
        l = 0;
        i = 0;
        aobj = ((Object []) (obj));
        k = j;
        if (j > 1) goto _L27; else goto _L26
_L26:
        l = i;
        k = i;
_L35:
        aobj = ((Object []) (obj));
        i1 = aobj[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 528
    //                   0 560
    //                   1 567
    //                   2 574
    //                   3 581;
           goto _L28 _L29 _L30 _L31 _L32
_L28:
        i = 47;
_L36:
        aobj[k] = (char)(i ^ i1);
        l++;
        if (j != 0) goto _L34; else goto _L33
_L33:
        k = j;
          goto _L35
_L29:
        i = 21;
          goto _L36
_L30:
        i = 90;
          goto _L36
_L31:
        i = 107;
          goto _L36
_L32:
        i = 68;
          goto _L36
_L34:
        k = j;
        aobj = ((Object []) (obj));
_L27:
        obj = ((Object) (aobj));
        j = k;
        i = l;
        if (k > l) goto _L26; else goto _L37
_L37:
        d = Pattern.compile(((StringBuilder) (obj1)).append((new String(((char []) (aobj)))).intern()).append(c).append(")").toString());
        obj = "N;F>n8\000[i\026Iq7jsJ\006N\030\002Iq6?\0369h^rRI\0320%\002o\033F\036\0378c6\037N8 *iu%wR\030\002H![h\031!'C\030\001N;F>n8\000[i\026H\001\niUTw1t\002,\006F\031T%vYqR<q";
        i = 2;
          goto _L38
_L18:
        i = 21;
          goto _L39
_L19:
        i = 90;
          goto _L39
_L20:
        i = 107;
          goto _L39
_L21:
        i = 68;
          goto _L39
_L23:
        i1 = l;
        l = j;
        aobj = ((Object []) (obj));
        k1 = j1;
_L16:
        j1 = k1;
        obj = ((Object) (aobj));
        j = l;
        k = i1;
        if (l > i1) goto _L41; else goto _L40
_L40:
        obj = (new String(((char []) (aobj)))).intern();
        k1;
        JVM INSTR tableswitch 0 3: default 764
    //                   0 780
    //                   1 424
    //                   2 796
    //                   3 812;
           goto _L42 _L43 _L44 _L45 _L46
_L42:
        a = Pattern.compile(((String) (obj)));
        obj = "=rT~\007}.\0374S}.\0374\\i\022\0370_i\022\0370_f&\0310\\e&90\\esQ\030\000IuC{\025=eQ\037N8 *iu%wR\030\013Iw7\033s;\006@\030\016Ip7cs=\006B\030\003Ia7{s3\006V\031S=eQ\030\nN;F\"n8\034[i\026H!Y9\006<!Zh\031!'C{\025I`C{\025N;F>n8\000[i\026I~7isJ\006E\030\004I{7ns2\006C\030\006Iv7\177s*\006M\030\022H&C{\025I\1770%\002s\033F\002\0378c6?\035hsB?\0369h^9\006*\006+m\020<eCl\020/rT~ttw\021\005\002OjF}\2178\uD7A5\uF96Bi\uFDE0\uFDE5w\uFF84\031ttw\021\005\002OjF}\2178\uD7A5\uF96Bi\uFDE0\uFDE5w\uFF84\030\002H![h\031!'7j\006>rT~\007*`\n!]z&\n6_t&\n7Ft&\n\037Lq?\r#Fy7\005+^g)\0371Xm 6mS=eQ&Fo&\t\037Nw>\016\"H}3\001)Az(\0300Yb#\021\031\006irT~Lt.\027'@x&\b+@e&\b\037Nv>\r#G|1\007)Az(\0362Wl 6mSq\001\016.Dx5\021\031S=eQ!K`&\016\037Lp=\0317[`\007B8IN3\001/Bz(68\007*`\f+Yi=0%Mq?\r#G|6\006*_d(\0300Zb#6mS}\001\000)Ag.\036\031S=eQ-As5\027-Aa&\002\037Kp6\006*@d(\0300r<&C{\025\1775\t7S\177\001\016)@e\007B8DN?\f,Fx4\0336Xl 68CN;\t'F~(\0300Zc#68\007*`\006-Ci7\004&Fi7\0367J`7\027)tt9\017!H}1\007)Az*\0326\\a/\0353Wl 6mS=eQ*Nx?\027*Ja&\005\037Nv?\r#Fy5\0336Zo\007B8\007*`\0046Hi5\006mS=eQ4]z&\033\037Np<\f,Dy7\0056\\a-\022\031\006i+\n8]N?\0047Zb\007\0277tt8\b Jr2\002.Dy7\005+]a/\035=UH&C{\025a?\0078[g;\035!Ci.0'Ks=\003.Dy7\005+_g.\0353UHs\0271tt=\0007Vo\007\0272tt9\016#F{/68XN<\030\031S=eQ<AIw7i\037o-\006q\031q&\023*s8\006Fu\036wo\t7\034tc\n.\031r&\023*s8\006F|\037t1\003&V~4\001pIi\"\005\030\002IwR0\033wkZ=F ;\027<AIw7iKp8\ntNq&\023*s8\006F#\031bh^uKi\"\005\030\002Iw\003#M~l\n.\030soX&Mt&\023*s8\006F,Cv0]%Vtc\0167L\";\027<AIw7iEm;\0074Ky*\027<AIw7iDr8\016'Ga,\027<AIw7iUv1\021%G<&\022\037Ja/68UN;\0063r<s\027l\020/rT~\035 \001[i\032H&Y\037\0378n6\037\0378c68t%wZ\031t%wR\031T''\027\037\0368c6\037\0378c68t$wR\031\006ItC{\025'o0t\002 \007\027vt%w_\031t%wR\031SNjFurNjF}rnh\0268t$wR\031t%wR\031SNkF}rijB\030\001=eQv\032NjFqrih0t\002!\0070t\002,\007\027\037\0378k6\037\0378c6?\035h&0u\002,\0070t\002,\007\027\037\0368c68\037<\006El\020/h^\037\0378o68\035NjFprNjF}ri\001[i\036H\001[i\026H!Y9SNkF}rNjF}ri\001[i\026HsBm\007*`7~sq!Zh\032hsTm\007IuC{\025=eQ\037N8 *iu%wR\344\002\uD7EA\uF95AF\uFD8B\uFDDF8\uFFB57\177s:\006T\030\025I\0327bs(\006H\030QIw7js>\006J\030\005I}7ls<\006G\030pHs\027l\020/\006N\037N8<*ii%wR\031T''Bm\005<eC{\025I8\027`\006";
        i = 0;
        continue; /* Loop/switch isn't completed */
_L43:
        b = Pattern.compile(((String) (obj)));
        obj = "=rYqt%w^\031S'\001[i\033H\001[i\026H&0t\002$\0070t\002,\007\020vRi\001Zi\026H\001[i\026H&0u\002,\007B\030\001=h^\037\0378o68\035NjFprNjF}ri\001[i\036H\001[i\026H!Y9SNkF}rNjF}ri\001Zi\026H&[ms;rYqt%w^\031S'\001[i\033H\001[i\026H&0t\002$\0070t\002,\007\020vRi\001Zi\026H\001[i\026H&0u\002,\007\027t\006ItCv\032NjFqrih0t\002!\0070t\002,\007\027\037\0378k6\037\0378c6?\035h&0u\002,\0070t\002,\007\027\037\0378c6m\006";
        i = 1;
        continue; /* Loop/switch isn't completed */
_L45:
        e = Pattern.compile(((String) (obj)));
        obj = "=\006@\037\0378c6otIwK\030\001HpB{\007Ir0t\002,\007@\030\006N\006Fds;\007Am\020=\001[i\026H\001[i\026IwK\030\001H\001[i\026IwK\030\001Hq0t\002,\007B";
        i = 3;
        if (true) goto _L38; else goto _L47
_L47:
_L46:
        f = Pattern.compile(((String) (obj)));
          goto _L8
    }
}
