// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.os.Handler;
import ax;
import com.nuance.nmdp.speechkit.util.dataupload.DataBlock;
import d;
import java.io.IOException;
import java.util.Vector;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            w, Prompt, x, Recognizer, 
//            DataUploadCommand, GenericCommand, NluRecognizer, TextRecognizer, 
//            Vocalizer

public final class SpeechKit extends w
{
    public static final class CmdSetType extends Enum
    {

        public static final CmdSetType DRAGON_NLU;
        public static final CmdSetType NVC;
        private static final CmdSetType b[];
        private int a;

        public static CmdSetType valueOf(String s)
        {
            return (CmdSetType)Enum.valueOf(com/nuance/nmdp/speechkit/SpeechKit$CmdSetType, s);
        }

        public static CmdSetType[] values()
        {
            return (CmdSetType[])b.clone();
        }

        public final int getIndex()
        {
            return a;
        }

        static 
        {
            NVC = new CmdSetType("NVC", 0, 0);
            DRAGON_NLU = new CmdSetType("DRAGON_NLU", 1, 1);
            b = (new CmdSetType[] {
                NVC, DRAGON_NLU
            });
        }

        private CmdSetType(String s, int i, int j)
        {
            super(s, i);
            a = j;
        }
    }


    private final x a;
    private final Context b;

    private SpeechKit(x x1, Context context)
    {
        a = x1;
        b = context;
    }

    private Prompt a(AssetFileDescriptor assetfiledescriptor)
    {
        d d1;
        Prompt prompt;
        if (assetfiledescriptor == null)
        {
            return null;
        }
        d1 = new d();
        prompt = new Prompt(d1, a);
        Object obj = x.b();
        obj;
        JVM INSTR monitorenter ;
        boolean flag = a.a();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        try
        {
            assetfiledescriptor.close();
        }
        catch (IOException ioexception) { }
        x.f();
        a.b(prompt);
        obj;
        JVM INSTR monitorexit ;
        ax.a(new Runnable(d1, assetfiledescriptor) {

            private d a;
            private AssetFileDescriptor b;

            public final void run()
            {
                a.a(b);
            }

            
            {
                a = d1;
                b = assetfiledescriptor;
                super();
            }
        });
        return prompt;
        assetfiledescriptor;
        throw assetfiledescriptor;
    }

    public static SpeechKit initialize(Context context, String s, String s1, int i, boolean flag, byte abyte0[])
    {
        return initialize(context, "", s, s1, i, null, flag, abyte0, CmdSetType.NVC);
    }

    public static SpeechKit initialize(Context context, String s, String s1, String s2, int i, String s3, boolean flag, byte abyte0[], 
            CmdSetType cmdsettype)
    {
        s3 = x.a(context, s, s1, s2, i, s3, flag, abyte0, cmdsettype);
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        s2 = ((String) (x.b()));
        s2;
        JVM INSTR monitorenter ;
        s1 = (SpeechKit)s3.d();
        s = s1;
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        s = new SpeechKit(s3, context);
        s3.a(s);
        s2;
        JVM INSTR monitorexit ;
        return s;
        context;
        throw context;
        return null;
    }

    public static SpeechKit initialize(Context context, String s, String s1, String s2, int i, boolean flag, byte abyte0[], CmdSetType cmdsettype)
    {
        return initialize(context, s, s1, s2, i, null, flag, abyte0, cmdsettype);
    }

    public final void cancelCurrent()
    {
        a.j();
    }

    public final void connect()
    {
        a.h();
    }

    public final Recognizer createConstraintRecognizer(String s, int i, String s1, Vector vector, Recognizer.Listener listener, Object obj)
    {
        return a.a(s, i, s1, vector, listener, obj);
    }

    public final DataUploadCommand createDataUploadCmd(DataBlock datablock, int i, int j, DataUploadCommand.Listener listener, Handler handler)
    {
        return a.a(datablock, i, j, listener, handler);
    }

    public final GenericCommand createLogRevisionCmd(String s, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary, String s1, GenericCommand.Listener listener, Handler handler)
    {
        return a.a(s, dictionary, s1, listener, handler);
    }

    public final NluRecognizer createNluRecognizer(String s, int i, String s1, String s2, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary, NluRecognizer.Listener listener, Handler handler)
    {
        return a.a(s, i, s1, s2, dictionary, listener, handler);
    }

    public final Recognizer createRecognizer(String s, int i, String s1, Recognizer.Listener listener, Handler handler)
    {
        return a.a(s, i, s1, listener, handler);
    }

    public final GenericCommand createResetUserProfileCmd(GenericCommand.Listener listener, Handler handler)
    {
        return a.a(listener, handler);
    }

    public final TextRecognizer createTextRecognizer(String s, String s1, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary, TextRecognizer.Listener listener, Handler handler)
    {
        return a.a(s, s1, dictionary, listener, handler);
    }

    public final Vocalizer createVocalizerWithLanguage(String s, Vocalizer.Listener listener, Handler handler)
    {
        return a.a(s, listener, handler);
    }

    public final Vocalizer createVocalizerWithVoice(String s, Vocalizer.Listener listener, Handler handler)
    {
        return a.b(s, listener, handler);
    }

    public final Prompt defineAudioPrompt(int i)
    {
        AssetFileDescriptor assetfiledescriptor = b.getResources().openRawResourceFd(i);
        if (assetfiledescriptor == null)
        {
            throw new IllegalArgumentException("resourceId must refer to an uncompressed resource");
        } else
        {
            return a(assetfiledescriptor);
        }
    }

    public final CmdSetType getCmdSetType()
    {
        return a.n();
    }

    public final String getSessionId()
    {
        return a.i();
    }

    public final void logToServer(String s, String s1)
    {
        a.b(s, s1);
    }

    public final void release()
    {
        a.g();
    }

    public final void setCmdSetType(CmdSetType cmdsettype)
    {
        a.a(cmdsettype);
    }

    public final void setDefaultRecognizerPrompts(Prompt prompt, Prompt prompt1, Prompt prompt2, Prompt prompt3)
    {
        a.a(prompt, prompt1, prompt2, prompt3);
    }
}
