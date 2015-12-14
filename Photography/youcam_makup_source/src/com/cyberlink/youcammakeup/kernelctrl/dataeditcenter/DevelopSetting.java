// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import com.cyberlink.youcammakeup.jniproxy.g;
import com.cyberlink.youcammakeup.jniproxy.j;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.a.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter:
//            CmdSetting

public final class DevelopSetting extends HashMap
{

    public static String a = "global";
    public static String b = "local";
    public static String c = "RESULT_INDEX";
    public static String d = "RESULT_LENGTH";
    private static final long serialVersionUID = 1L;
    public EffectMode mEffectMode;
    public Map mGPUImageFilterParams;
    private Boolean mGPUImageIsBeautyFilter;
    private float mGPUImageVersion;

    public DevelopSetting()
    {
        mEffectMode = null;
        mGPUImageFilterParams = new HashMap();
    }

    public static j a(Integer integer)
    {
        b((new StringBuilder()).append("[funcID2ParamClass] funcID = ").append(integer.toString()).toString());
        if (integer.intValue() == 7)
        {
            return new g();
        } else
        {
            return null;
        }
    }

    public static DevelopSetting a()
    {
        DevelopSetting developsetting = new DevelopSetting();
        developsetting.put(a, new CmdSetting());
        developsetting.put(b, new CmdSetting());
        return developsetting;
    }

    public static DevelopSetting a(String s)
    {
        DevelopSetting developsetting;
        Iterator iterator;
        developsetting = new DevelopSetting();
        s = new JSONObject(s);
        b((new StringBuilder()).append("[decodeDevelopSettingString] jsonObj: ").append(s.toString()).toString());
        iterator = s.keys();
_L1:
        String s1;
        CmdSetting cmdsetting;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_278;
        }
        s1 = (String)iterator.next();
        b((new StringBuilder()).append("[decodeDevelopSettingString] typeID: ").append(s1).toString());
        JSONObject jsonobject = new JSONObject(s.getString(s1));
        b((new StringBuilder()).append("[decodeDevelopSettingString] jsonObjValue: ").append(jsonobject.toString()).toString());
        Iterator iterator1 = jsonobject.keys();
        cmdsetting = new CmdSetting();
        String s2;
        j j1;
        for (; iterator1.hasNext(); cmdsetting.put(Integer.valueOf(Integer.parseInt(s2)), j1))
        {
            s2 = (String)iterator1.next();
            b((new StringBuilder()).append("[decodeDevelopSettingString] funcID: ").append(s2).toString());
            String s3 = jsonobject.optString(s2);
            b((new StringBuilder()).append("[decodeDevelopSettingString] paramString: ").append(s3).toString());
            j1 = a(Integer.valueOf(Integer.parseInt(s2)));
            j1.a(s3);
        }

        try
        {
            developsetting.put(s1, cmdsetting);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
          goto _L1
        b((new StringBuilder()).append("[decodeDevelopSettingString] devSetting: ").append(developsetting.toString()).toString());
        return developsetting;
    }

    private static void b(String s)
    {
    }

    public void a(float f1)
    {
        mGPUImageVersion = f1;
    }

    public void a(Boolean boolean1)
    {
        mGPUImageIsBeautyFilter = boolean1;
    }

    public boolean a(DevelopSetting developsetting)
    {
        if (this == null || developsetting == null)
        {
            return false;
        }
        if (isEmpty() || developsetting.isEmpty())
        {
            return false;
        }
        if (this == developsetting)
        {
            return true;
        }
        Iterator iterator = entrySet().iterator();
label0:
        do
        {
            if (iterator.hasNext())
            {
                Object obj = (String)((java.util.Map.Entry)iterator.next()).getKey();
                Object obj1 = (CmdSetting)get(obj);
                obj = (CmdSetting)developsetting.get(obj);
                if (((CmdSetting) (obj1)).size() != ((CmdSetting) (obj)).size())
                {
                    return false;
                }
                obj1 = ((CmdSetting) (obj1)).entrySet().iterator();
                java.util.Map.Entry entry;
                Integer integer;
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        continue label0;
                    }
                    entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
                    integer = (Integer)entry.getKey();
                    if (!((CmdSetting) (obj)).containsKey(integer))
                    {
                        return false;
                    }
                } while (((j)entry.getValue()).a((j)((CmdSetting) (obj)).get(integer)));
                break;
            } else
            {
                return true;
            }
        } while (true);
        return false;
    }

    public void b()
    {
        if (this == null)
        {
            return;
        } else
        {
            clear();
            return;
        }
    }

    public String c()
    {
        if (this == null)
        {
            return "";
        }
        Object obj = new HashMap();
        String s;
        Object obj1;
        for (Iterator iterator = entrySet().iterator(); iterator.hasNext(); ((HashMap) (obj)).put(s, ((JSONObject) (obj1)).toString()))
        {
            obj1 = (java.util.Map.Entry)iterator.next();
            s = (String)((java.util.Map.Entry) (obj1)).getKey();
            Object obj2 = (CmdSetting)((java.util.Map.Entry) (obj1)).getValue();
            obj1 = new HashMap();
            Integer integer;
            Object obj3;
            for (obj2 = ((CmdSetting) (obj2)).entrySet().iterator(); ((Iterator) (obj2)).hasNext(); ((HashMap) (obj1)).put(integer.toString(), obj3))
            {
                obj3 = (java.util.Map.Entry)((Iterator) (obj2)).next();
                integer = (Integer)((java.util.Map.Entry) (obj3)).getKey();
                obj3 = ((j)((java.util.Map.Entry) (obj3)).getValue()).c();
            }

            b((new StringBuilder()).append("[encodeDevelopSettingString] tempTypeDic: ").append(((HashMap) (obj1)).toString()).toString());
            obj1 = new JSONObject(((Map) (obj1)));
            b((new StringBuilder()).append("[encodeDevelopSettingString] typeDicJsonObj: ").append(((JSONObject) (obj1)).toString()).toString());
        }

        b((new StringBuilder()).append("[encodeDevelopSettingString] tempSetting: ").append(((HashMap) (obj)).toString()).toString());
        obj = new JSONObject(((Map) (obj)));
        b((new StringBuilder()).append("[encodeDevelopSettingString] jsonObj: ").append(((JSONObject) (obj)).toString()).toString());
        return ((JSONObject) (obj)).toString();
    }

    public boolean d()
    {
        if (this == null)
        {
            b("[isEmptyDevelopSetting] developSetting is null.");
            return true;
        }
        if (isEmpty())
        {
            return true;
        }
        return !containsKey(a) || !containsKey(b) || ((CmdSetting)get(a)).isEmpty() && ((CmdSetting)get(b)).isEmpty();
    }

    public boolean e()
    {
        return false;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (obj.getClass() == getClass())
                {
                    flag = flag1;
                    if (obj instanceof DevelopSetting)
                    {
                        return a((DevelopSetting)obj);
                    }
                }
            }
        }
        return flag;
    }

    public DevelopSetting f()
    {
        if (this == null)
        {
            return null;
        }
        DevelopSetting developsetting = a();
        for (Iterator iterator = entrySet().iterator(); iterator.hasNext();)
        {
            Object obj1 = (java.util.Map.Entry)iterator.next();
            Object obj = (String)((java.util.Map.Entry) (obj1)).getKey();
            obj1 = (CmdSetting)((java.util.Map.Entry) (obj1)).getValue();
            obj = (CmdSetting)developsetting.get(obj);
            obj1 = ((CmdSetting) (obj1)).entrySet().iterator();
            while (((Iterator) (obj1)).hasNext()) 
            {
                Object obj3 = (java.util.Map.Entry)((Iterator) (obj1)).next();
                Integer integer = (Integer)((java.util.Map.Entry) (obj3)).getKey();
                obj3 = (j)((java.util.Map.Entry) (obj3)).getValue();
                j j1 = a(integer);
                j1.b(((j) (obj3)));
                ((CmdSetting) (obj)).put(integer, j1);
            }
        }

        developsetting.mEffectMode = mEffectMode;
        Iterator iterator1 = mGPUImageFilterParams.entrySet().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Object obj2 = (java.util.Map.Entry)iterator1.next();
            GPUImageFilterParamType gpuimagefilterparamtype = (GPUImageFilterParamType)((java.util.Map.Entry) (obj2)).getKey();
            obj2 = (a)((java.util.Map.Entry) (obj2)).getValue();
            if (obj2 != null)
            {
                obj2 = ((a) (obj2)).a();
                developsetting.mGPUImageFilterParams.put(gpuimagefilterparamtype, obj2);
            }
        } while (true);
        developsetting.a(mGPUImageVersion);
        developsetting.a(mGPUImageIsBeautyFilter);
        b((new StringBuilder()).append("[copyDevelopSetting] newDevSetting: ").append(developsetting.toString()).toString());
        return developsetting;
    }

    public boolean g()
    {
        Iterator iterator1;
        if (this == null || isEmpty())
        {
            return false;
        }
        for (Iterator iterator = mGPUImageFilterParams.entrySet().iterator(); iterator.hasNext();)
        {
            if ((a)((java.util.Map.Entry)iterator.next()).getValue() != null)
            {
                return false;
            }
        }

        if (equals(a()))
        {
            b("[isDefaultDevelopSetting] it equals to default develop setting!");
            return true;
        }
        iterator1 = entrySet().iterator();
_L2:
        Iterator iterator2;
        if (!iterator1.hasNext())
        {
            break MISSING_BLOCK_LABEL_155;
        }
        iterator2 = ((CmdSetting)((java.util.Map.Entry)iterator1.next()).getValue()).entrySet().iterator();
_L4:
        if (!iterator2.hasNext()) goto _L2; else goto _L1
_L1:
        if (((j)((java.util.Map.Entry)iterator2.next()).getValue()).b()) goto _L4; else goto _L3
_L3:
        return false;
        b("[isDefaultDevelopSetting] it contains develop setting, but the values are default!");
        return true;
    }


    private class GPUImageFilterParamType extends Enum
    {

        public static final GPUImageFilterParamType A;
        public static final GPUImageFilterParamType B;
        public static final GPUImageFilterParamType C;
        public static final GPUImageFilterParamType D;
        public static final GPUImageFilterParamType E;
        public static final GPUImageFilterParamType F;
        public static final GPUImageFilterParamType G;
        public static final GPUImageFilterParamType H;
        public static final GPUImageFilterParamType I;
        public static final GPUImageFilterParamType J;
        public static final GPUImageFilterParamType K;
        public static final GPUImageFilterParamType L;
        public static final GPUImageFilterParamType M;
        public static final GPUImageFilterParamType N;
        public static final GPUImageFilterParamType O;
        public static final GPUImageFilterParamType P;
        public static final GPUImageFilterParamType Q;
        public static final GPUImageFilterParamType R;
        public static final GPUImageFilterParamType S;
        public static final GPUImageFilterParamType T;
        public static final GPUImageFilterParamType U;
        public static final GPUImageFilterParamType V;
        public static final GPUImageFilterParamType W;
        public static final GPUImageFilterParamType X;
        public static final GPUImageFilterParamType Y;
        public static final GPUImageFilterParamType Z;
        public static final GPUImageFilterParamType a;
        public static final GPUImageFilterParamType aa;
        public static final GPUImageFilterParamType ab;
        public static final GPUImageFilterParamType ac;
        public static final GPUImageFilterParamType ad;
        public static final GPUImageFilterParamType ae;
        public static final GPUImageFilterParamType af;
        public static final GPUImageFilterParamType ag;
        public static final GPUImageFilterParamType ah;
        public static final GPUImageFilterParamType ai;
        public static final GPUImageFilterParamType aj;
        public static final GPUImageFilterParamType ak;
        public static final GPUImageFilterParamType al;
        private static final GPUImageFilterParamType am[];
        public static final GPUImageFilterParamType b;
        public static final GPUImageFilterParamType c;
        public static final GPUImageFilterParamType d;
        public static final GPUImageFilterParamType e;
        public static final GPUImageFilterParamType f;
        public static final GPUImageFilterParamType g;
        public static final GPUImageFilterParamType h;
        public static final GPUImageFilterParamType i;
        public static final GPUImageFilterParamType j;
        public static final GPUImageFilterParamType k;
        public static final GPUImageFilterParamType l;
        public static final GPUImageFilterParamType m;
        public static final GPUImageFilterParamType n;
        public static final GPUImageFilterParamType o;
        public static final GPUImageFilterParamType p;
        public static final GPUImageFilterParamType q;
        public static final GPUImageFilterParamType r;
        public static final GPUImageFilterParamType s;
        public static final GPUImageFilterParamType t;
        public static final GPUImageFilterParamType u;
        public static final GPUImageFilterParamType v;
        public static final GPUImageFilterParamType w;
        public static final GPUImageFilterParamType x;
        public static final GPUImageFilterParamType y;
        public static final GPUImageFilterParamType z;

        public static GPUImageFilterParamType valueOf(String s1)
        {
            return (GPUImageFilterParamType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/dataeditcenter/DevelopSetting$GPUImageFilterParamType, s1);
        }

        public static GPUImageFilterParamType[] values()
        {
            return (GPUImageFilterParamType[])am.clone();
        }

        static 
        {
            a = new GPUImageFilterParamType("WhiteBalance", 0);
            b = new GPUImageFilterParamType("Exposure", 1);
            c = new GPUImageFilterParamType("HighlightShadow", 2);
            d = new GPUImageFilterParamType("Brightness", 3);
            e = new GPUImageFilterParamType("Contrast", 4);
            f = new GPUImageFilterParamType("Clarity", 5);
            g = new GPUImageFilterParamType("Saturation", 6);
            h = new GPUImageFilterParamType("SplitTone", 7);
            i = new GPUImageFilterParamType("Sepia", 8);
            j = new GPUImageFilterParamType("Monochrome", 9);
            k = new GPUImageFilterParamType("RGB", 10);
            l = new GPUImageFilterParamType("Vignette", 11);
            m = new GPUImageFilterParamType("HSVEx", 12);
            n = new GPUImageFilterParamType("ToneCurveRGB", 13);
            o = new GPUImageFilterParamType("WhiteBalanceMatrix", 14);
            p = new GPUImageFilterParamType("HSL", 15);
            q = new GPUImageFilterParamType("Vibrance", 16);
            r = new GPUImageFilterParamType("LiveSmooth", 17);
            s = new GPUImageFilterParamType("LiveSmoothFreshColor", 18);
            t = new GPUImageFilterParamType("LiveSmoothRetroColor", 19);
            u = new GPUImageFilterParamType("LiveSmoothElegantColor", 20);
            v = new GPUImageFilterParamType("LiveSmoothWarmColor", 21);
            w = new GPUImageFilterParamType("LiveSmoothBlackWhite", 22);
            x = new GPUImageFilterParamType("LiveSmoothSoftlight", 23);
            y = new GPUImageFilterParamType("LiveSmoothNature", 24);
            z = new GPUImageFilterParamType("LiveSmoothWithTexture", 25);
            A = new GPUImageFilterParamType("CaptureSmooth", 26);
            B = new GPUImageFilterParamType("CaptureSmoothFreshColor", 27);
            C = new GPUImageFilterParamType("CaptureSmoothRetroColor", 28);
            D = new GPUImageFilterParamType("CaptureSmoothElegantColor", 29);
            E = new GPUImageFilterParamType("CaptureSmoothWarmColor", 30);
            F = new GPUImageFilterParamType("CaptureSmoothBlackWhite", 31);
            G = new GPUImageFilterParamType("CaptureSmoothSoftlight", 32);
            H = new GPUImageFilterParamType("CaptureSmoothNature", 33);
            I = new GPUImageFilterParamType("CaptureSmoothWithTexture", 34);
            J = new GPUImageFilterParamType("RetroColorFilter", 35);
            K = new GPUImageFilterParamType("BlackWhiteFilter", 36);
            L = new GPUImageFilterParamType("ElegantColorFilter", 37);
            M = new GPUImageFilterParamType("NatureFilter", 38);
            N = new GPUImageFilterParamType("SoftlightFilter", 39);
            O = new GPUImageFilterParamType("FreshColorFilter", 40);
            P = new GPUImageFilterParamType("WarmColorFilter", 41);
            Q = new GPUImageFilterParamType("LiveWithTexture", 42);
            R = new GPUImageFilterParamType("CaptureWithTexture", 43);
            S = new GPUImageFilterParamType("LensFlare", 44);
            T = new GPUImageFilterParamType("Overlays", 45);
            U = new GPUImageFilterParamType("AutoTone", 46);
            V = new GPUImageFilterParamType("Blur", 47);
            W = new GPUImageFilterParamType("Bokeh", 48);
            X = new GPUImageFilterParamType("CLCandyColor", 49);
            Y = new GPUImageFilterParamType("CLAestheticColor", 50);
            Z = new GPUImageFilterParamType("CLGentleColor", 51);
            aa = new GPUImageFilterParamType("CLForestColor", 52);
            ab = new GPUImageFilterParamType("CLCoolColor", 53);
            ac = new GPUImageFilterParamType("CLVintageColor", 54);
            ad = new GPUImageFilterParamType("CLRedColor", 55);
            ae = new GPUImageFilterParamType("CLSmooth", 56);
            af = new GPUImageFilterParamType("CLFreshColor", 57);
            ag = new GPUImageFilterParamType("CLWarmColor", 58);
            ah = new GPUImageFilterParamType("CLSoftlightColor", 59);
            ai = new GPUImageFilterParamType("CLElegantColor", 60);
            aj = new GPUImageFilterParamType("CLRetroColor", 61);
            ak = new GPUImageFilterParamType("CLLightColor", 62);
            al = new GPUImageFilterParamType("CLBlackWhiteColor", 63);
            am = (new GPUImageFilterParamType[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q, r, s, t, 
                u, v, w, x, y, z, A, B, C, D, 
                E, F, G, H, I, J, K, L, M, N, 
                O, P, Q, R, S, T, U, V, W, X, 
                Y, Z, aa, ab, ac, ad, ae, af, ag, ah, 
                ai, aj, ak, al
            });
        }

        private GPUImageFilterParamType(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
