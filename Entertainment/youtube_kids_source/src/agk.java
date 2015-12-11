// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.util.Log;
import com.google.android.speech.embedded.EndpointerModelCopier;
import com.google.android.speech.embedded.Greco3DataManager;
import com.google.android.speech.embedded.Greco3Mode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class agk
    implements EndpointerModelCopier
{

    private static final String a = agk.getSimpleName();
    private static final int b[] = {
        0x7f080003, 0x7f080001, 0x7f080002, 0x7f080006
    };
    private static final String c[] = {
        "ep_acoustic_model", "endpointer_dictation.config", "endpointer_voicesearch.config", "metadata"
    };
    private final Resources d;

    public agk(Resources resources)
    {
        d = resources;
    }

    private boolean a(egf egf1)
    {
        int i;
        egf1 = new File((File)egf1.get(), "en-US");
        if (!egf1.exists() && !egf1.mkdir())
        {
            String s = a;
            egf1 = String.valueOf(egf1.getAbsolutePath());
            if (egf1.length() != 0)
            {
                egf1 = "Unable to create model dir: ".concat(egf1);
            } else
            {
                egf1 = new String("Unable to create model dir: ");
            }
            Log.e(s, egf1);
            return false;
        }
        i = 0;
_L2:
        int ai[];
        try
        {
            ai = b;
        }
        catch (IOException ioexception)
        {
            egf1 = a;
            String s1 = String.valueOf(ioexception);
            Log.e(egf1, (new StringBuilder(String.valueOf(s1).length() + 25)).append("Error copying EP models: ").append(s1).toString());
            return false;
        }
        if (i >= 4)
        {
            break; /* Loop/switch isn't completed */
        }
        emm.a(d.openRawResource(b[i]), new FileOutputStream(new File(egf1, c[i])));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return true;
    }

    public boolean copyEndpointerModels(egf egf1, Greco3DataManager greco3datamanager)
    {
        boolean flag;
        if (greco3datamanager.hasResources("en-US", Greco3Mode.ENDPOINTER_VOICESEARCH) && greco3datamanager.hasResources("en-US", Greco3Mode.ENDPOINTER_DICTATION))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return false;
        } else
        {
            return a(egf1);
        }
    }

}
