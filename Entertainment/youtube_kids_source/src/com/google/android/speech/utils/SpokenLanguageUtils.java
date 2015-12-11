// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.utils;

import a;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.speech.SpeechSettings;
import eyc;
import eyf;
import eym;
import eyn;
import f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class SpokenLanguageUtils
{

    private static final boolean DEBUG = false;
    private static final String DEFAULT_BCP47_LOCALE = "en-001";
    private static final Locale DEFAULT_LOCALE;
    private static final String TAG = "SpokenLanguageUtils";

    public SpokenLanguageUtils()
    {
    }

    public static String getDefaultMainSpokenLanguageBcp47(String s, eyc eyc1)
    {
        do
        {
label0:
            {
                Iterator iterator = eyc1.a.iterator();
                eyf eyf1;
label1:
                do
                {
                    if (iterator.hasNext())
                    {
                        Iterator iterator1 = ((eym)iterator.next()).b.iterator();
                        do
                        {
                            if (!iterator1.hasNext())
                            {
                                continue label1;
                            }
                            eyf1 = (eyf)iterator1.next();
                        } while (!eyf1.c.contains(s));
                        break;
                    }
                    break label0;
                } while (true);
                return eyf1.b;
            }
            if (s.contains("_"))
            {
                s = s.substring(0, s.lastIndexOf('_'));
            } else
            {
                return "en-001";
            }
        } while (true);
    }

    public static eyf getDialectByDisplayName(eyc eyc1, String s)
    {
        for (eyc1 = eyc1.a.iterator(); eyc1.hasNext();)
        {
            eyf eyf1 = getDialectByDisplayName((eym)eyc1.next(), s);
            if (eyf1 != null)
            {
                return eyf1;
            }
        }

        return null;
    }

    private static eyf getDialectByDisplayName(eym eym1, String s)
    {
        for (eym1 = eym1.b.iterator(); eym1.hasNext();)
        {
            eyf eyf1 = (eyf)eym1.next();
            if (eyf1.a.equals(s))
            {
                return eyf1;
            }
        }

        return null;
    }

    public static String[] getDialectDisplayName(eyc eyc1, String s)
    {
        eyc1 = getLanguageByDisplayName(eyc1, s);
        if (eyc1 == null)
        {
            Log.w("SpokenLanguageUtils", (new StringBuilder("#getDialectDisplayName - language not found ")).append(s).toString());
            return null;
        }
        s = new String[eyc1.d()];
        for (int i = 0; i < s.length; i++)
        {
            s[i] = eyc1.a(i).a;
        }

        return s;
    }

    public static String getDisplayName(eyc eyc1, String s)
    {
        eyc1 = eyc1.a.iterator();
        eyf eyf1;
label0:
        do
        {
            if (eyc1.hasNext())
            {
                Iterator iterator = ((eym)eyc1.next()).b.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    eyf1 = (eyf)iterator.next();
                } while (!eyf1.b.equals(s));
                break;
            } else
            {
                Log.e("SpokenLanguageUtils", (new StringBuilder("No display name for: ")).append(s).toString());
                return "";
            }
        } while (true);
        return eyf1.a;
    }

    public static CharSequence[] getDisplayNames(eyf aeyf[])
    {
        CharSequence acharsequence[] = new CharSequence[aeyf.length];
        for (int i = 0; i < aeyf.length; i++)
        {
            acharsequence[i] = aeyf[i].a;
        }

        return acharsequence;
    }

    public static ArrayList getEmbeddedBcp47(eyc eyc1)
    {
        ArrayList arraylist = new ArrayList();
        for (eyc1 = eyc1.b.iterator(); eyc1.hasNext(); arraylist.add(((eyn)eyc1.next()).a)) { }
        return arraylist;
    }

    public static eym getLanguageByBcp47Locale(eyc eyc1, String s)
    {
        eyc1 = eyc1.a.iterator();
_L2:
        eym eym1;
        Iterator iterator;
        if (!eyc1.hasNext())
        {
            break MISSING_BLOCK_LABEL_69;
        }
        eym1 = (eym)eyc1.next();
        iterator = eym1.b.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (!((eyf)iterator.next()).b.equals(s)) goto _L4; else goto _L3
_L3:
        return eym1;
        return null;
    }

    public static eym getLanguageByDisplayName(eyc eyc1, String s)
    {
        for (eyc1 = eyc1.a.iterator(); eyc1.hasNext();)
        {
            eym eym1 = (eym)eyc1.next();
            if (eym1.a.equals(s))
            {
                return eym1;
            }
        }

        return null;
    }

    public static eyf getLanguageDialect(eyc eyc1, String s)
    {
        eyc1 = eyc1.a.iterator();
        eyf eyf1;
label0:
        do
        {
            if (eyc1.hasNext())
            {
                Iterator iterator = ((eym)eyc1.next()).b.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    eyf1 = (eyf)iterator.next();
                } while (!eyf1.b.equals(s));
                break;
            } else
            {
                return null;
            }
        } while (true);
        return eyf1;
    }

    public static String[] getLanguageDisplayNames(eyc eyc1, String s)
    {
        f.b(eyc1);
        String as[] = new String[eyc1.a.size()];
        int i = 0;
        while (i < as.length) 
        {
            if (eyc1.a(i).d() == 1)
            {
                as[i] = eyc1.a(i).a(0).a;
            } else
            if (s != null)
            {
                as[i] = (new StringBuilder()).append(eyc1.a(i).a).append(s).toString();
            } else
            {
                as[i] = eyc1.a(i).a;
            }
            i++;
        }
        return as;
    }

    public static Locale getMainJavaLocaleForBcp47(eyc eyc1, String s)
    {
        eyc1 = getLanguageDialect(eyc1, s);
        if (eyc1 == null || !((eyf) (eyc1)).d)
        {
            return DEFAULT_LOCALE;
        } else
        {
            return a.a(((eyf) (eyc1)).e, DEFAULT_LOCALE);
        }
    }

    public static String getSpokenBcp47Locale(SpeechSettings speechsettings, String s)
    {
        if (s != null)
        {
            if (getLanguageDialect(speechsettings.getConfiguration(), s) != null)
            {
                return s;
            }
            s = getSpokenLanguageByJavaLocale(speechsettings.getConfiguration(), s);
            if (s != null)
            {
                return ((eyf) (s)).b;
            }
        }
        return speechsettings.getSpokenLocaleBcp47();
    }

    public static String getSpokenBcp47Locale(eyc eyc1, String s)
    {
        eyc1 = eyc1.a.iterator();
        eyf eyf1;
label0:
        do
        {
            if (eyc1.hasNext())
            {
                Iterator iterator = ((eym)eyc1.next()).b.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    eyf1 = (eyf)iterator.next();
                } while (!eyf1.c.contains(s));
                break;
            } else
            {
                return null;
            }
        } while (true);
        return eyf1.b;
    }

    public static transient String getSpokenBcp47Locale(eyc eyc1, String as[])
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = getSpokenBcp47Locale(eyc1, as[i]);
            if (s != null)
            {
                return s;
            }
        }

        return null;
    }

    public static eyf getSpokenLanguageByBcp47Locale(eyc eyc1, String s)
    {
        eyc1 = eyc1.a.iterator();
        eyf eyf1;
label0:
        do
        {
            if (eyc1.hasNext())
            {
                Iterator iterator = ((eym)eyc1.next()).b.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    eyf1 = (eyf)iterator.next();
                } while (!eyf1.b.equals(s));
                break;
            } else
            {
                return null;
            }
        } while (true);
        return eyf1;
    }

    public static eyf getSpokenLanguageByJavaLocale(eyc eyc1, String s)
    {
        eyc1 = eyc1.a.iterator();
        eyf eyf1;
label0:
        do
        {
            if (eyc1.hasNext())
            {
                Iterator iterator = ((eym)eyc1.next()).b.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    eyf1 = (eyf)iterator.next();
                } while (!eyf1.c.contains(s));
                break;
            } else
            {
                return null;
            }
        } while (true);
        return eyf1;
    }

    public static ArrayList getSupportedBcp47Locales(eyc eyc1)
    {
        ArrayList arraylist = new ArrayList();
        for (eyc1 = eyc1.a.iterator(); eyc1.hasNext();)
        {
            Iterator iterator = ((eym)eyc1.next()).b.iterator();
            while (iterator.hasNext()) 
            {
                arraylist.add(((eyf)iterator.next()).b);
            }
        }

        return arraylist;
    }

    public static ArrayList getSupportedDisplayNames(eyc eyc1)
    {
        ArrayList arraylist = new ArrayList();
        for (eyc1 = eyc1.a.iterator(); eyc1.hasNext();)
        {
            Iterator iterator = ((eym)eyc1.next()).b.iterator();
            while (iterator.hasNext()) 
            {
                arraylist.add(((eyf)iterator.next()).a);
            }
        }

        return arraylist;
    }

    public static ArrayList getVoiceImeDialects(eyc eyc1)
    {
        ArrayList arraylist = new ArrayList();
        for (eyc1 = eyc1.a.iterator(); eyc1.hasNext();)
        {
            Iterator iterator = ((eym)eyc1.next()).b.iterator();
            while (iterator.hasNext()) 
            {
                eyf eyf1 = (eyf)iterator.next();
                if (eyf1.f)
                {
                    arraylist.add(eyf1);
                }
            }
        }

        return arraylist;
    }

    public static eyf getVoiceImeMainLanguage(eyc eyc1, String s)
    {
        eyc1 = eyc1.a.iterator();
        eyf eyf1;
label0:
        do
        {
            if (eyc1.hasNext())
            {
                Iterator iterator = ((eym)eyc1.next()).b.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    eyf1 = (eyf)iterator.next();
                } while (!eyf1.f || !eyf1.b.equals(s));
                break;
            } else
            {
                return null;
            }
        } while (true);
        return eyf1;
    }

    public static boolean isSupportedBcp47Locale(eyc eyc1, String s)
    {
        return !TextUtils.isEmpty(getDisplayName(eyc1, s));
    }

    public static boolean updateSpokenLanguage(SpeechSettings speechsettings, String s)
    {
        boolean flag = false;
        if (isSupportedBcp47Locale(speechsettings.getConfiguration(), s))
        {
            speechsettings.setSpokenLanguageBcp47(s, s.equals(getDefaultMainSpokenLanguageBcp47(Locale.getDefault().toString(), speechsettings.getConfiguration())));
            flag = true;
        }
        return flag;
    }

    static 
    {
        DEFAULT_LOCALE = Locale.US;
    }
}
