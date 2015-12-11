// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.internal;

import a;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.speech.callback.Callback;
import com.google.android.speech.embedded.Greco3Mode;
import com.google.android.speech.grammar.GrammarBuilder;
import dao;
import enl;
import enn;
import enz;
import epg;
import etg;
import ett;
import euf;
import ewh;
import ewk;
import ewl;
import ewm;
import exf;
import exy;
import ezl;
import ezm;
import f;
import java.util.List;

// Referenced classes of package com.google.android.speech.internal:
//            CombinedResultGenerator

public class RecognizerEventProcessor
{

    private static final boolean DEBUG = false;
    private static int INVALID_PHONE_TYPE = 0;
    private static final String TAG = "VS.RecognizerEventProcessor";
    private final Callback mCallback;
    private final CombinedResultGenerator mCombinedResultGenerator = new CombinedResultGenerator();
    private final Greco3Mode mMode;

    RecognizerEventProcessor(Greco3Mode greco3mode, Callback callback)
    {
        mMode = greco3mode;
        mCallback = (Callback)f.b(callback);
    }

    private static ewk addCombinedResultsTo(ewk ewk1)
    {
        ewk ewk2 = new ewk();
        try
        {
            ewk2.a(ewk1.c());
        }
        catch (euf euf1) { }
        ewk2.a(ewk1.e);
        return ewk2;
    }

    private static epg buildPhoneAction(String s, int i, double d)
    {
        enl enl1 = new enl();
        enl1.a(s);
        enl1.b(s);
        exy exy1 = new exy();
        exy1.a(d);
        enl1.a(exy1);
        (new StringBuilder("n=")).append(elideContactName(s)).append(", t=").append(i);
        if (i != INVALID_PHONE_TYPE)
        {
            s = new enz();
            String s1 = getServerTypeStringFromAndroidType(i);
            if (s1 != null)
            {
                s.b(s1);
            }
            enl1.a(s);
        }
        s = new epg();
        s.a(enl1);
        return s;
    }

    private exf dressActionV2InMajelResponseAndThenDressThatInAnS3Response(enn enn1)
    {
        ett ett1 = new ett();
        ett1.a(6);
        ett1.a(enn1);
        ett1.a(true);
        enn1 = new etg();
        enn1.a(ett1);
        return a.a(enn1);
    }

    private static String elideContactName(String s)
    {
        if (s.length() > 2)
        {
            return (new StringBuilder()).append(s.substring(0, 2)).append("+").append(s.length() - 2).toString();
        } else
        {
            return (new StringBuilder("+")).append(s.length()).toString();
        }
    }

    private static final String getServerTypeStringFromAndroidType(int i)
    {
        if (i == 1)
        {
            return "home";
        }
        if (i == 3)
        {
            return "work";
        }
        if (i == 2)
        {
            return "cell";
        } else
        {
            return null;
        }
    }

    private exf handleCallCommand(String as[], int i)
    {
        Object obj = null;
        StringBuilder stringbuilder = new StringBuilder(15);
        double d = 0.0D;
        int j = INVALID_PHONE_TYPE;
        String s = null;
        do
        {
            if (i >= as.length)
            {
                break;
            }
            String s1 = as[i];
            if (s1.startsWith("XX_"))
            {
                s = GrammarBuilder.decodeName(s1);
                d = GrammarBuilder.decodeWeight(s1);
            }
            int k = j;
            if (s1.startsWith("_p"))
            {
                try
                {
                    k = Integer.parseInt(s1.substring(2));
                }
                catch (NumberFormatException numberformatexception)
                {
                    Log.e("VS.RecognizerEventProcessor", (new StringBuilder("Invalid semantic tag: ")).append(s1).toString());
                    k = j;
                }
            }
            if (s1.startsWith("_d"))
            {
                stringbuilder.append(s1.substring(2));
            }
            i++;
            j = k;
        } while (true);
        if (s != null)
        {
            as = handleContactName(s, d, j);
        } else
        {
            as = obj;
            if (stringbuilder.length() > 0)
            {
                return handleSpokenPhoneNumber(stringbuilder.toString());
            }
        }
        return as;
    }

    private exf handleContactName(String s, double d, int i)
    {
        s = buildPhoneAction(s, i, d);
        enn enn1 = new enn();
        enn1.a(s).a(true);
        return dressActionV2InMajelResponseAndThenDressThatInAnS3Response(enn1);
    }

    private exf handleSpokenPhoneNumber(String s)
    {
        enz enz1 = new enz();
        enz1.a(s);
        return dressActionV2InMajelResponseAndThenDressThatInAnS3Response((new enn()).a((new epg()).a((new enl()).a(enz1))));
    }

    private void processEventInDictationAndHotwordMode(ewk ewk1)
    {
        mCombinedResultGenerator.update(ewk1);
        if (ewk1.b == 1)
        {
            ewk1 = mCombinedResultGenerator.getCombinedResultEvent();
            if (ewk1 != null)
            {
                mCallback.onResult(a.a(ewk1));
            }
            mCallback.onResult(a.F());
            return;
        } else
        {
            mCallback.onResult(a.a(ewk1));
            return;
        }
    }

    private void processEventInGrammarMode(ewk ewk1)
    {
label0:
        {
            if (ewk1.b == 1)
            {
                exf exf = processSemanticInterpretations(ewk1);
                if (exf == null)
                {
                    break label0;
                }
                mCallback.onResult(a.a(addCombinedResultsTo(ewk1)));
                mCallback.onResult(exf);
                mCallback.onResult(a.F());
            }
            return;
        }
        mCallback.onError(new dao());
    }

    private exf processSemanticInterpretations(ewk ewk1)
    {
        if (ewk1.d) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        ewl ewl1 = ewk1.e;
        int j = ewl1.d();
        if (j > 0)
        {
            int i = 0;
            while (i < j) 
            {
                ewh ewh1 = ewl1.a(i);
                if (ewh1.c)
                {
                    return processSemanticInterpretations(ewh1.d.a, ewk1);
                }
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private exf processSemanticInterpretations(List list, ewk ewk1)
    {
        if (list.isEmpty() || ((ezl)list.get(0)).a.size() == 0)
        {
            return null;
        }
        list = (ezm)((ezl)list.get(0)).a.get(0);
        if (!((ezm) (list)).a || TextUtils.isEmpty(((ezm) (list)).b.trim()))
        {
            return null;
        }
        list = ((ezm) (list)).b.trim().split(" ");
        for (int i = 0; i < list.length; i++)
        {
            String s = list[i];
            if (s == null)
            {
                continue;
            }
            if ("_call".equals(s))
            {
                return handleCallCommand(list, i + 1);
            }
            if ("_cancel".equals(s) | "_okay".equals(s) | "_call_back".equals(s) | "_respond".equals(s) | "_hotword".equals(s) | "_next".equals(s) | s.startsWith("_select"))
            {
                return a.b(ewk1);
            }
            if ("_other".equals(s))
            {
                return null;
            }
        }

        return null;
    }

    void process(ewk ewk1)
    {
        boolean flag;
        if (mMode == Greco3Mode.DICTATION || mMode == Greco3Mode.HOTWORD || mMode == Greco3Mode.GRAMMAR)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        if (!ewk1.a)
        {
            Log.w("VS.RecognizerEventProcessor", "Received recognition event without type.");
            return;
        }
        if (ewk1.c != 0)
        {
            Log.w("VS.RecognizerEventProcessor", "Error from embedded recognizer.");
            return;
        }
        if (mMode == Greco3Mode.GRAMMAR)
        {
            processEventInGrammarMode(ewk1);
            return;
        } else
        {
            processEventInDictationAndHotwordMode(ewk1);
            return;
        }
    }

    static 
    {
        INVALID_PHONE_TYPE = -1;
    }
}
