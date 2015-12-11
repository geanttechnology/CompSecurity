// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net;

import android.text.TextUtils;
import android.util.Log;
import com.sessionm.b.a;
import com.sessionm.core.Config;
import com.sessionm.core.StatsCollector;
import com.sessionm.core.f;
import com.sessionm.core.i;
import com.sessionm.net.http.c;
import com.sessionm.net.http.d;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.sessionm.net:
//            b, c, a

public class Request extends b
    implements Serializable
{
    public static final class Header extends Enum
    {

        public static final Header eM;
        public static final Header eN;
        public static final Header eO;
        public static final Header eP;
        public static final Header eQ;
        public static final Header eR;
        private static final Header eT[];
        private final String eS;

        public static Header valueOf(String s)
        {
            return (Header)Enum.valueOf(com/sessionm/net/Request$Header, s);
        }

        public static Header[] values()
        {
            return (Header[])eT.clone();
        }

        public String getKey()
        {
            return eS;
        }

        static 
        {
            eM = new Header("CACHE_CONTROL", 0, "Cache-Control");
            eN = new Header("USER_AGENT", 1, "User-Agent");
            eO = new Header("CONTENT_TYPE", 2, "Content-Type");
            eP = new Header("SET_COOKIE", 3, "Set-Cookie");
            eQ = new Header("LOCATION", 4, "Location");
            eR = new Header("CONTENT_LENGTH", 5, "Content-Length");
            eT = (new Header[] {
                eM, eN, eO, eP, eQ, eR
            });
        }

        private Header(String s, int j, String s1)
        {
            super(s, j);
            eS = s1;
        }
    }

    public static final class Method extends Enum
    {

        public static final Method eU;
        public static final Method eV;
        public static final Method eW;
        public static final Method eX;
        public static final Method eY;
        private static final Method eZ[];

        public static Method valueOf(String s)
        {
            return (Method)Enum.valueOf(com/sessionm/net/Request$Method, s);
        }

        public static Method[] values()
        {
            return (Method[])eZ.clone();
        }

        static 
        {
            eU = new Method("POST", 0);
            eV = new Method("GET", 1);
            eW = new Method("DELETE", 2);
            eX = new Method("PUT", 3);
            eY = new Method("GENERIC", 4);
            eZ = (new Method[] {
                eU, eV, eW, eX, eY
            });
        }

        private Method(String s, int j)
        {
            super(s, j);
        }
    }

    public static final class Priority extends Enum
    {

        public static final Priority fa;
        public static final Priority fb;
        public static final Priority fc;
        private static final Priority fd[];

        public static Priority valueOf(String s)
        {
            return (Priority)Enum.valueOf(com/sessionm/net/Request$Priority, s);
        }

        public static Priority[] values()
        {
            return (Priority[])fd.clone();
        }

        static 
        {
            fa = new Priority("LOW", 0);
            fb = new Priority("NORMAL", 1);
            fc = new Priority("HIGH", 2);
            fd = (new Priority[] {
                fa, fb, fc
            });
        }

        private Priority(String s, int j)
        {
            super(s, j);
        }
    }

    public static final class State extends Enum
    {

        public static final State fe;
        public static final State ff;
        public static final State fg;
        public static final State fh;
        private static final State fi[];

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/sessionm/net/Request$State, s);
        }

        public static State[] values()
        {
            return (State[])fi.clone();
        }

        public boolean be()
        {
            return this == fg || this == fh;
        }

        static 
        {
            fe = new State("UNSENT", 0);
            ff = new State("SENDING", 1);
            fg = new State("COMPLETED", 2);
            fh = new State("FAILED", 3);
            fi = (new State[] {
                fe, ff, fg, fh
            });
        }

        private State(String s, int j)
        {
            super(s, j);
        }
    }

    public static final class Type extends Enum
    {

        public static final Type fj;
        public static final Type fk;
        public static final Type fl;
        public static final Type fm;
        public static final Type fn;
        public static final Type fo;
        public static final Type fp;
        public static final Type fq;
        public static final Type fr;
        public static final Type fs;
        private static final Type fv[];
        private final Method em;
        private final String ft;
        private final int fu;

        static Method a(Type type)
        {
            return type.em;
        }

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/sessionm/net/Request$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])fv.clone();
        }

        Method aN()
        {
            return em;
        }

        String getPath()
        {
            return ft;
        }

        int getTimeout()
        {
            return fu;
        }

        static 
        {
            fj = new Type("SESSION_START", 0, "/v%s/apps/%s/session.json", Method.eU, 30000);
            fk = new Type("ACTION", 1, "/v%s/events.json", Method.eU);
            fl = new Type("SESSION_END", 2, "/v%s/session.json", Method.eU, 5000);
            fm = new Type("CONTENT", 3, "", Method.eV);
            fn = new Type("ERROR", 4, "/v%s/apps/%s/errors.json", Method.eU);
            fo = new Type("DELIVERED", 5, "/v%s/apps/%s/bugs/delivered.json", Method.eV);
            fp = new Type("CLAIM", 6, "/v%s/apps/%s/awards/%s/ads", Method.eV);
            fq = new Type("GENERIC", 7, "", Method.eY);
            fr = new Type("OPT_IN_OUT", 8, "/optout.json", Method.eX);
            fs = new Type("CPI", 9, "/transactions", Method.eU);
            fv = (new Type[] {
                fj, fk, fl, fm, fn, fo, fp, fq, fr, fs
            });
        }

        private Type(String s, int j, String s1, Method method)
        {
            super(s, j);
            ft = s1;
            em = method;
            fu = -1;
        }

        private Type(String s, int j, String s1, Method method, int k)
        {
            super(s, j);
            ft = s1;
            em = method;
            fu = k;
        }
    }


    private static final String TAG = "SessionM.Request";
    private static final char ei[] = {
        'g', 'R', '\235', 'l', '\264', 'w', '\374', '\357', '\032', ')', 
        '\013', '\252', '\317', '\304', '\336', '\301', ']', '\231', '\206', 'z', 
        '\254', 'Q', '\316', '\237', '\302', '\254', '\033', '\035', 'E', 'G', 
        '\301', '\360', '=', '6', '\271', '\315', 'N', 'm', '\026', '8', 
        '\243', '\005', '\001', '\320', '2', '\225', '=', '!', '\222', '\263', 
        '\200', '\303', '\261', '\366', 's', '\362', '[', '\247', '\023', ',', 
        '#', 'k', 'n', '\246', 'D', '\332', '\356', '\231', '\020', '\025', 
        'k', 'O', '\020', '\351', '\264', '\356', '\271', '\346', '\232', '\207', 
        '\232', '\\', 'e', '\031', 'D', '\311', '\343', '\314', '\351', 'j', 
        '\362', '\177', '\376', '[', 'u', 'd', '8', '{', 'V', '\246', 
        'u', '\013', '\242', '*', '\006', '6', 'o', '\243', '4', '\326', 
        '\330', 'B', '\036', '\t', ')', 'z', '\r', '5', 'W', '+', 
        '=', '\316', '\354', '\331', '\357', 'R', '\212', '\262', 'K', '\020', 
        '\335', '\346', '\205', '\243', '\326', 'a', '5', '\'', '\223', '-', 
        '\252', '\335', '\321', '\370', '\242', '\024', '\335', '\313', '\200', ';', 
        '\340', 'O', '\305', '\300', '\313', '=', '\257', '\206', '\375', 'l', 
        '%', 'R', '\025', '~', 'x', '\277', '\305', '\025', '\304', '\300', 
        '\272', '\315', 'T', '(', '\337', 'Z', '\272', 'L', '}', '|', 
        '?', 'c', '\352', '\030', '\021', 'v', '\227', '\233', '\004', '\213', 
        '\260', '\306', '\033', '\326', '\223', '\261', '\316', ']', '\270', '\277', 
        '\323', '\236', '\231', '\373', '\367', '\r', 'n', '6', '-', '\243', 
        'g', 'F', '\245', ')', 'F', '3', '\215', '\023', '\270', '\0', 
        '\215', '\272', 'g', '\346', '-', '\340', '\t', '\357', '\235', 'O', 
        '\337', '\217', '\037', '\236', 'w', ')', '\232', ':', 't', 'N', 
        '\202', '\325', '\341', '7', '_', '\324', 'v', '?', '\204', '<', 
        '\226', '\002', '\263', '%', '\327', '\322', '\322', 'g', 'Y', '\021', 
        '\315', '\201', 'X', '\312', '\311', 'g', '9', '\220', '\035', 'P', 
        '\b', ')', '}', '\266', '\247', '\223', '\376', '\374', '!', '\246', 
        '\202', '!', '\031', '\222', '\360', 'Z', '\031', '\215', 'j', '\217', 
        '\222', '\313', 't', '\315', '\347', '\313', '\305', 'X', '\301', 'm', 
        '\236', '\274', '\330', '%', '\323', '\f', '\307', '\357', 'B', 'E', 
        'I', '\320', 'e', '\r', '\004', '\0', '\027', '\204', '\336', '\n', 
        '\\', '\212', '\254', '\013', '&', 'h', '\326', '\342', 'E', '2', 
        '\270', 'k', '\240', '\273', '\345', '\261', '\270', '\306', '\177', '\252', 
        '\212', 'Y', '\301', '\204', '\b', '\256', 'F', '\326', 'U', 'v', 
        '@', '\342', '\223', '7', '>', '\214', 'r', '\354', '\021', '\324', 
        'L', '\026', 'L', 'g', '\314', '\314', '\246', '\314', '\177', '\334', 
        '\b', 'A', '\013', 'd', '\301', '\233', '<', '\202', '\316', 'K', 
        '\244', 'm', '\215', '\317', '+', '\201', '3', '\336', '\357', '\377', 
        '\005', 'X', '\335', '\204', '\341', '\370', '\364', '\253', 'H', '\321', 
        'm', 'w', '\266', '\232', '\213', 'Z', 'g', '\227', '\347', '\207', 
        '\347', '\034', '3', '\354', '\303', '\303', '\213', '\276', '$', '\371', 
        ':', '{', '\244', '*', 'F', '\244', '\224', '\007', '\020', '\335', 
        '/', '\364', '\371', '\t', '\007', '\013', '<', '_', '\255', '\341', 
        '\267', '\225', '\022', '\230', '\236', '\265', 'L', '\256', 'x', '\364', 
        'b', 'R', '\331', '\273', '\276', '\325', '\364', 'u', 'e', 'u', 
        '|', '8', '\241', '\021', '`', '#', '\345', 'S', '\205', '\242', 
        '\374', '\005', '\037', 'l', 'G', '<', '\376', 'V', '\250', '\002', 
        '\177', '\003', '\212', '1', '\325', 'K', '\324', 'x', '\210', '\220', 
        '\262', '\240', '\'', '{', '-', '\266', '\333', '<', '\354', ',', 
        'f', '\246', '\023', 'k', '\345', '`', '\021', 'G', '\027', '.', 
        '\024', '\022'
    };
    private static final List eo = Collections.synchronizedList(new ArrayList());
    private static byte key[];
    private static final long serialVersionUID = 0x4f733511c180f109L;
    private String b;
    a eA;
    private com.sessionm.c.c eB;
    private List eC;
    private String eD;
    private int eE;
    private int eF;
    private State eG;
    private boolean eH;
    private Request eI;
    private File eJ;
    private boolean eK;
    private Type ej;
    private a ek;
    private String el;
    private Method em;
    private com.sessionm.net.c en;
    private d ep;
    private Map eq;
    private Throwable er;
    private int es;
    private com.sessionm.net.a et;
    private boolean eu;
    private long ev;
    private long ew;
    private long ex;
    private Priority ey;
    private Map ez;
    private String url;

    public Request(Type type)
    {
        this(type, (Object[])null);
    }

    public transient Request(Type type, Object aobj[])
    {
        ex = System.currentTimeMillis();
        ey = Priority.fb;
        ez = new HashMap();
        eG = State.fe;
        eK = true;
        if (type == null)
        {
            throw new NullPointerException("Request type is null");
        }
        ej = type;
        em = com.sessionm.net.Type.a(type);
        if (!ej.equals(Type.fj) && !ej.equals(Type.fo) && !ej.equals(Type.fn) && !ej.equals(Type.fp)) goto _L2; else goto _L1
_L1:
        eD = (String)aobj[0];
        if (ej.equals(Type.fp))
        {
            b = (String)aobj[1];
        }
_L4:
        el = UUID.randomUUID().toString();
        return;
_L2:
        if (ej.equals(Type.fm))
        {
            if (aobj.length != 1)
            {
                throw new NullPointerException("url not provied for content request!");
            }
            url = (String)aobj[0];
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Request(String s, String s1)
    {
        this(Type.fq);
        url = s;
        if (s1.equalsIgnoreCase("GET"))
        {
            em = Method.eV;
        } else
        {
            if (s1.equalsIgnoreCase("POST"))
            {
                em = Method.eU;
                return;
            }
            if (s1.equalsIgnoreCase("PUT"))
            {
                em = Method.eX;
                return;
            }
            if (s1.equalsIgnoreCase("DELETE"))
            {
                em = Method.eW;
                return;
            }
        }
    }

    private String A(String s)
    {
        String s1;
label0:
        {
            s1 = s;
            if (eI != null)
            {
                s1 = eI.bc();
                String s2 = eI.aN().toString();
                long l = eI.aU();
                s1 = String.format(Locale.US, "lu=%s&lm=%s&lt=%d&retry=%d&rc=%d", new Object[] {
                    s1, s2, Long.valueOf(l), Integer.valueOf(eE), Integer.valueOf(eF)
                });
                if (s != null && !s.equals(""))
                {
                    break label0;
                }
            }
            return s1;
        }
        return String.format("%s&%s", new Object[] {
            s, s1
        });
    }

    public static String a(String s, String s1, String s2)
    {
        Object obj = f.E();
        String s4 = ((f) (obj)).F();
        String s3 = ((f) (obj)).G();
        obj = s3;
        if (s3 == null)
        {
            obj = "";
        }
        s = String.format(Locale.US, "%s%s%s%s%s", new Object[] {
            s1.toUpperCase(Locale.US), s, i.r(s2), s4, obj
        });
        if (Log.isLoggable("SessionM.Signing", 3))
        {
            Log.d("SessionM.Signing", String.format("Plaintext: %s", new Object[] {
                s
            }));
        }
        try
        {
            s = i.a(s, getKey());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("SessionM.Request", "Exception generating request parameters", s);
            return null;
        }
        return s;
    }

    private void a(State state)
    {
        if (Log.isLoggable("SessionM.Request", 3))
        {
            Log.d("SessionM.Request", String.format("transitioning request from state: %s to %s", new Object[] {
                eG, state
            }));
        }
        if (eG == state && Log.isLoggable("SessionM.Request", 6))
        {
            Log.e("SessionM.Request", String.format(Locale.US, "Same state transition for state %s", new Object[] {
                state
            }));
        }
        static class _cls1
        {

            static final int eL[];

            static 
            {
                eL = new int[State.values().length];
                try
                {
                    eL[State.ff.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    eL[State.fg.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    eL[State.fh.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    eL[State.fe.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.eL[state.ordinal()];
        JVM INSTR tableswitch 1 4: default 116
    //                   1 122
    //                   2 178
    //                   3 224
    //                   4 270;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        eG = state;
        return;
_L2:
        if (eG != State.fe && eG != State.fh && Log.isLoggable("SessionM.Request", 6))
        {
            Log.e("SessionM.Request", String.format(Locale.US, "Incorrect state transition, state %s", new Object[] {
                state
            }));
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (eG != State.ff && Log.isLoggable("SessionM.Request", 6))
        {
            Log.e("SessionM.Request", String.format(Locale.US, "Incorrect state transition, state %s", new Object[] {
                state
            }));
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (eG != State.ff && Log.isLoggable("SessionM.Request", 6))
        {
            Log.e("SessionM.Request", String.format(Locale.US, "Incorrect state transition, state %s", new Object[] {
                state
            }));
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (!eG.be() && Log.isLoggable("SessionM.Request", 6))
        {
            Log.e("SessionM.Request", String.format(Locale.US, "Incorrect state transition, state %s", new Object[] {
                state
            }));
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    private static void a(StringBuilder stringbuilder, Object obj, String s)
        throws Exception
    {
        if (!(obj instanceof a)) goto _L2; else goto _L1
_L1:
        a(stringbuilder, ((a)obj).aI(), s);
_L4:
        return;
_L2:
        if (!(obj instanceof JSONObject))
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = (JSONObject)obj;
        Iterator iterator = jsonobject.keys();
        while (iterator.hasNext()) 
        {
            String s1 = iterator.next().toString();
            Object obj1;
            if (s != null)
            {
                obj = String.format(Locale.US, "%s[%s]", new Object[] {
                    s, URLEncoder.encode(s1, "UTF-8")
                });
            } else
            {
                obj = URLEncoder.encode(s1, "UTF-8");
            }
            obj1 = jsonobject.get(s1);
            if (jsonobject.isNull(s1))
            {
                obj1 = null;
            }
            a(stringbuilder, obj1, ((String) (obj)));
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!(obj instanceof JSONArray))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (JSONArray)obj;
        int j = 0;
        while (j < ((JSONArray) (obj)).length()) 
        {
            a(stringbuilder, ((JSONArray) (obj)).get(j), String.format(Locale.US, "%s[]", new Object[] {
                s
            }));
            j++;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (!(obj instanceof Object[]))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((Object) ((Object[])(Object[])obj));
        int k = 0;
        while (k < obj.length) 
        {
            a(stringbuilder, obj[k], String.format(Locale.US, "%s[]", new Object[] {
                s
            }));
            k++;
        }
        if (true) goto _L4; else goto _L6
_L6:
        if (s == null) goto _L4; else goto _L7
_L7:
        if (obj != null)
        {
            stringbuilder.append(String.format(Locale.US, "&%s=%s", new Object[] {
                s, URLEncoder.encode(obj.toString(), "UTF-8")
            }));
            return;
        } else
        {
            stringbuilder.append(String.format(Locale.US, "&%s=", new Object[] {
                s
            }));
            return;
        }
    }

    private static byte[] a(char ac[])
    {
        byte abyte0[] = new byte[ac.length];
        for (int j = 0; j < abyte0.length; j++)
        {
            abyte0[j] = (byte)ac[j];
        }

        return abyte0;
    }

    private String aL()
    {
        f f1 = f.E();
        String s = Config.h().getValue("api.server.url");
        if (ej.equals(Type.fs) || ej.equals(Type.fp) || ej.equals(Type.fo))
        {
            s = f1.ac();
        } else
        {
            if (ej.equals(Type.fk))
            {
                return f1.ad();
            }
            if (ej.equals(Type.fr))
            {
                return f1.ae();
            }
            if (ej.equals(Type.fj) || ej.equals(Type.fl))
            {
                return f1.ag();
            }
        }
        return s;
    }

    public static void b(com.sessionm.net.c c1)
    {
        eo.add(c1);
    }

    private String bc()
    {
        String s;
        Object obj;
        obj = Config.h();
        s = null;
        obj = ((Config) (obj)).getValue("api.version");
        if (ej != Type.fj) goto _L2; else goto _L1
_L1:
        s = String.format(ej.getPath(), new Object[] {
            obj, eD
        });
_L4:
        obj = s;
        if (s == null)
        {
            try
            {
                obj = (new URI(url)).getPath();
            }
            catch (URISyntaxException urisyntaxexception)
            {
                if (Log.isLoggable("SessionM.Request", 6))
                {
                    Log.e("SessionM.Request", (new StringBuilder()).append("invalid uri: ").append(url).toString(), urisyntaxexception);
                }
                eH = true;
                return s;
            }
        }
        return ((String) (obj));
_L2:
        if (ej == Type.fo)
        {
            s = String.format(ej.getPath(), new Object[] {
                obj, eD
            });
        } else
        if (ej == Type.fp)
        {
            s = String.format(ej.getPath(), new Object[] {
                obj, eD, b
            });
        } else
        if (ej == Type.fl)
        {
            s = String.format(ej.getPath(), new Object[] {
                obj
            });
        } else
        if (ej == Type.fk)
        {
            s = String.format(ej.getPath(), new Object[] {
                obj
            });
        } else
        if (ej == Type.fn)
        {
            s = String.format(ej.getPath(), new Object[] {
                obj, eD
            });
        } else
        if (ej == Type.fr)
        {
            s = ej.getPath();
        } else
        if (ej == Type.fs)
        {
            s = String.format(ej.getPath(), new Object[0]);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void c(com.sessionm.net.c c1)
    {
        eo.remove(c1);
    }

    public static String e(a a1)
        throws Exception
    {
        StringBuilder stringbuilder = new StringBuilder();
        a(stringbuilder, a1, null);
        return stringbuilder.toString().replaceFirst("&", "");
    }

    private void e(String s, String s1)
    {
        ez.put(s, new ArrayList());
        ((List)ez.get(s)).add(s1);
    }

    private static byte[] getKey()
    {
        if (key == null)
        {
            key = a(ei);
        }
        return key;
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws ClassNotFoundException, IOException
    {
        eG = State.fe;
        em = (Method)objectinputstream.readObject();
        el = (String)objectinputstream.readObject();
        ek = com.sessionm.b.a.w((String)objectinputstream.readObject());
        ex = objectinputstream.readLong();
        ey = (Priority)objectinputstream.readObject();
        url = (String)objectinputstream.readObject();
        ej = (Type)objectinputstream.readObject();
        ez = (Map)objectinputstream.readObject();
        eE = objectinputstream.readInt();
        eK = objectinputstream.readBoolean();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeObject(em);
        objectoutputstream.writeObject(el);
        objectoutputstream.writeObject(aS());
        objectoutputstream.writeLong(ex);
        objectoutputstream.writeObject(ey);
        objectoutputstream.writeObject(getURL());
        objectoutputstream.writeObject(ej);
        objectoutputstream.writeObject(ez);
        objectoutputstream.writeInt(eE);
        objectoutputstream.writeBoolean(eK);
    }

    private String z(String s)
    {
        long l = System.currentTimeMillis();
        String s1;
        if (s.equals(""))
        {
            s1 = (new StringBuilder()).append("z=").append(l).toString();
        } else
        {
            s1 = s;
            if (s.indexOf("&z=") < 0)
            {
                s1 = s;
                if (!s.startsWith("z="))
                {
                    return (new StringBuilder()).append(s).append("&z=").append(l).toString();
                }
            }
        }
        return s1;
    }

    public List a(Header header)
    {
        List list = null;
        if (eq != null)
        {
            list = com.sessionm.net.http.c.a(eq, header.getKey());
        }
        return list;
    }

    public void a(Priority priority)
    {
        ey = priority;
    }

    public void a(com.sessionm.net.a a1)
    {
        et = a1;
    }

    public void a(com.sessionm.net.c c1)
    {
        if (c1 != null)
        {
            en = c1;
        }
    }

    public void a(d d1, Throwable throwable, int j, Map map)
    {
        this;
        JVM INSTR monitorenter ;
        ep = d1;
        er = throwable;
        es = j;
        eq = map;
        ew = System.currentTimeMillis();
        if (es == 0)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        a(State.fg);
_L1:
        if (en != null)
        {
            en.onReplyReceived(this);
        }
        d1 = eo;
        d1;
        JVM INSTR monitorenter ;
        for (throwable = eo.iterator(); throwable.hasNext(); ((com.sessionm.net.c)throwable.next()).onReplyReceived(this)) { }
        break MISSING_BLOCK_LABEL_119;
        throwable;
        d1;
        JVM INSTR monitorexit ;
        throw throwable;
        d1;
        this;
        JVM INSTR monitorexit ;
        throw d1;
        a(State.fh);
          goto _L1
        d1;
        JVM INSTR monitorexit ;
        StatsCollector.b(this);
        this;
        JVM INSTR monitorexit ;
    }

    public void aJ()
    {
        eE = eE + 1;
        a(State.ff);
        if (en != null)
        {
            en.onRequestSent(this);
        }
        StatsCollector.a(com.sessionm.core.StatsCollector.Stat._flddo, 0L);
        List list = eo;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = eo.iterator(); iterator.hasNext(); ((com.sessionm.net.c)iterator.next()).onRequestSent(this)) { }
        break MISSING_BLOCK_LABEL_84;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    public File aK()
    {
        File file = null;
        if (en != null)
        {
            file = en.outputFileForRequest(this);
        }
        return file;
    }

    public int aM()
    {
        return eE;
    }

    public Method aN()
    {
        return em;
    }

    public boolean aO()
    {
        return eu;
    }

    public Type aP()
    {
        return ej;
    }

    public Throwable aQ()
    {
        return er;
    }

    public d aR()
    {
        this;
        JVM INSTR monitorenter ;
        d d1 = ep;
        this;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    public String aS()
    {
        if (ek != null)
        {
            return ek.toString();
        } else
        {
            return null;
        }
    }

    public a aT()
    {
        return ek;
    }

    public long aU()
    {
        long l1 = -1L;
        long l = l1;
        if (ev > 0L)
        {
            l = l1;
            if (ew > 0L)
            {
                l = ew - ev;
            }
        }
        return l;
    }

    public long aV()
    {
        return ex;
    }

    public a aW()
    {
        Object obj1 = null;
        this;
        JVM INSTR monitorenter ;
        if (eA != null) goto _L2; else goto _L1
_L1:
        Object obj;
        if (aR() == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        obj = aR().bA();
_L7:
        boolean flag = TextUtils.isEmpty(((CharSequence) (obj)));
        if (!flag) goto _L4; else goto _L3
_L3:
        obj = obj1;
_L6:
        this;
        JVM INSTR monitorexit ;
        return ((a) (obj));
_L4:
        eA = com.sessionm.b.a.w(((String) (obj)));
        if (eA == null && er == null && !ej.equals(Type.fl) && !ej.equals(Type.fq) && Log.isLoggable("SessionM.Request", 5))
        {
            Log.w("SessionM.Request", (new StringBuilder()).append("Unable to parse JSON response: ").append(aR()).toString());
        }
_L2:
        obj = eA;
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        throw obj;
        obj = null;
          goto _L7
    }

    public com.sessionm.c.c aX()
    {
        return eB;
    }

    public List aY()
    {
        if (eC == null)
        {
            eC = new ArrayList();
            eC.add(this);
        }
        return eC;
    }

    public int aZ()
    {
        if (eC == null)
        {
            return 1;
        } else
        {
            return eC.size();
        }
    }

    public void b(File file)
    {
        eJ = file;
    }

    void b(List list)
    {
        eC = new ArrayList();
        eC.add(this);
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Request request = (Request)list.next();
            if (!equals(request))
            {
                eC.add(request);
            }
        } while (true);
    }

    public void b(Map map)
    {
        eq = map;
        map = a(Header.eQ);
        if (map != null)
        {
            map = (String)map.get(0);
            if (map != null)
            {
                url = map;
            }
        }
    }

    public State ba()
    {
        return eG;
    }

    boolean bb()
    {
        return eH;
    }

    boolean bd()
    {
        return es >= 200 && es < 300;
    }

    public void c(com.sessionm.c.c c1)
    {
        eB = c1;
    }

    void c(Request request)
    {
        eI = request;
    }

    public void d(a a1)
    {
        ek = a1;
    }

    public void d(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (ez.get(s) != null) goto _L2; else goto _L1
_L1:
        e(s, s1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        ((List)ez.get(s)).add(s1);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public void g(boolean flag)
    {
        eK = flag;
    }

    public String getID()
    {
        return el;
    }

    public int getStatusCode()
    {
        return es;
    }

    public String getURL()
    {
        this;
        JVM INSTR monitorenter ;
        if (url == null) goto _L2; else goto _L1
_L1:
        String s = url;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        url = String.format(Locale.US, "%s%s", new Object[] {
            aL(), bc()
        });
        s = url;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void h(boolean flag)
    {
        eu = flag;
    }

    void o(int j)
    {
        eF = j;
    }

    public void reset()
    {
        this;
        JVM INSTR monitorenter ;
        a(State.fe);
        ep = null;
        eq = null;
        er = null;
        es = 0;
        ew = 0L;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void send()
    {
        Object obj;
        Object obj1;
        Method method = aN();
        if (ek == null)
        {
            obj1 = "";
        } else
        {
            try
            {
                obj1 = e(ek);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                if (Log.isLoggable("SessionM.Request", 6))
                {
                    Log.e("SessionM.Request", "Error parsing request parameters. Bailing out of request.");
                }
                eH = true;
                a((d)null, ((Throwable) (obj)), 0, null);
                return;
            }
        }
        e(Header.eN.getKey(), String.format("%s SessionM Android SDK", new Object[] {
            System.getProperties().getProperty("http.agent")
        }));
        if (ej == Type.fm)
        {
            break MISSING_BLOCK_LABEL_405;
        }
        if (method == Method.eV) goto _L2; else goto _L1
_L1:
        obj = obj1;
        if (method != Method.eW) goto _L3; else goto _L2
_L2:
        Object obj2;
        try
        {
            obj2 = new URI(getURL());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("SessionM.Request", "Invalid URL", ((Throwable) (obj)));
            a((d)null, ((Throwable) (obj)), 0, null);
            return;
        }
        obj = obj1;
        if (((URI) (obj2)).getQuery() == null) goto _L3; else goto _L4
_L4:
        if (!((String) (obj1)).equals("")) goto _L6; else goto _L5
_L5:
        obj = ((URI) (obj2)).getQuery();
_L3:
        obj1 = obj;
        if (!ej.equals(Type.fs))
        {
            obj1 = A(((String) (obj)));
        }
        obj1 = z(((String) (obj1)));
        obj2 = a(getURL(), method.toString(), ((String) (obj1)));
        obj = obj1;
        if (obj2 != null)
        {
            obj = (new StringBuilder()).append(((String) (obj1))).append("&sig=").append(((String) (obj2))).toString();
        }
_L7:
label0:
        {
            obj2 = url;
            obj1 = obj2;
            if (ej == Type.fm)
            {
                break label0;
            }
            if (method != Method.eV)
            {
                obj1 = obj2;
                if (method != Method.eW)
                {
                    break label0;
                }
            }
            obj1 = String.format("%s?%s", new Object[] {
                obj2, obj
            });
        }
        if (et == null)
        {
            et = f.E().V();
        }
        ev = System.currentTimeMillis();
        et.a(((String) (obj1)), method.toString(), ((String) (obj)), this, ey.ordinal(), ez, ej.getTimeout(), eJ);
        return;
_L6:
        obj = (new StringBuilder()).append(((String) (obj1))).append("&").append(((URI) (obj2)).getQuery()).toString();
          goto _L3
        obj = obj1;
          goto _L7
    }

    public String toString()
    {
        String s;
        String s1;
        if (ek != null)
        {
            s = (new StringBuilder()).append(" ").append(ek).toString();
        } else
        {
            s = "";
        }
        if (url != null)
        {
            s1 = (new StringBuilder()).append(" ").append(url).toString();
        } else
        {
            s1 = "";
        }
        return String.format(Locale.US, "<Request id: %s state: %s url: %s params: %s>", new Object[] {
            getID(), eG, s1, s
        });
    }

}
