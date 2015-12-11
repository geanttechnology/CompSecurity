// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.speech.listeners.RecognitionEventListener;

final class ahn
    implements RecognitionEventListener
{

    private ahf a;

    ahn(ahf ahf1)
    {
        a = ahf1;
        super();
    }

    public final void onBeginningOfSpeech(long l)
    {
        if (ahf.e(a) != null)
        {
            ahf.e(a).b();
        }
    }

    public final void onDone()
    {
    }

    public final void onEndOfSpeech()
    {
    }

    public final void onError(dap dap)
    {
        if (ahf.e(a) != null)
        {
            ahf.e(a).a(dap);
        }
    }

    public final void onMajelResult(etg etg)
    {
    }

    public final void onMediaDataResult(byte abyte0[])
    {
    }

    public final void onMusicDetected()
    {
    }

    public final void onNoSpeechDetected()
    {
    }

    public final void onPinholeResult(ewv ewv)
    {
    }

    public final void onReadyForSpeech()
    {
        if (ahf.e(a) != null)
        {
            ahf.e(a).a();
        }
    }

    public final void onRecognitionCancelled()
    {
    }

    public final void onRecognitionResult(ewk ewk1)
    {
        ahf.a(a, "");
        ahf.b(a, "");
        if (ewk1.b == 0)
        {
            ewj ewj1 = ewk1.g;
            int i = 0;
            while (ewj1 != null && i < ewj1.d()) 
            {
                Object obj = ewj1.a(i);
                if (((ewi) (obj)).d >= 0.80000000000000004D)
                {
                    ahf ahf1 = a;
                    String s1 = String.valueOf(ahf.b(a));
                    obj = String.valueOf(((ewi) (obj)).b);
                    if (((String) (obj)).length() != 0)
                    {
                        obj = s1.concat(((String) (obj)));
                    } else
                    {
                        obj = new String(s1);
                    }
                    ahf.a(ahf1, ((String) (obj)));
                } else
                {
                    ahf ahf2 = a;
                    String s2 = String.valueOf(ahf.c(a));
                    obj = String.valueOf(((ewi) (obj)).b);
                    if (((String) (obj)).length() != 0)
                    {
                        obj = s2.concat(((String) (obj)));
                    } else
                    {
                        obj = new String(s2);
                    }
                    ahf.b(ahf2, ((String) (obj)));
                }
                i++;
            }
            String s;
            boolean flag;
            if (ahf.b(a).length() + ahf.c(a).length() == 0)
            {
                ahf.a(a, ahf.a(a, ewk1));
                flag = true;
            } else
            {
                flag = false;
            }
            ewk1 = a;
            ahf.b(a);
            ahf.c(a);
            if (((ahf) (ewk1)).a != null)
            {
                ((ahf) (ewk1)).a.a(flag);
            }
        } else
        {
            ahf.c(a, ahf.b(a, ewk1));
            ewk1 = a;
            s = ahf.d(a);
            if (((ahf) (ewk1)).a != null)
            {
                ((ahf) (ewk1)).a.a(s);
                return;
            }
        }
    }

    public final void onSoundSearchResult(eee eee)
    {
    }
}
