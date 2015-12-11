// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.speech.SpeechSettings;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

final class ahq
    implements SpeechSettings
{

    private final Context a;
    private final eyc b;

    public ahq(Context context, eyc eyc)
    {
        a = context;
        b = eyc;
    }

    private SharedPreferences a()
    {
        return a.getSharedPreferences("search_prefs", 0);
    }

    private String b()
    {
        this;
        JVM INSTR monitorenter ;
        String s;
        s = UUID.randomUUID().toString();
        a().edit().putString("install-id", s).apply();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public final eyc getConfiguration()
    {
        return b;
    }

    public final List getExperimentIds()
    {
        return new ArrayList();
    }

    public final String getInstallId()
    {
        String s1 = a().getString("install-id", null);
        String s = s1;
        if (s1 == null)
        {
            s = b();
        }
        return s;
    }

    public final int getServerEndpointingActivityTimeoutMs()
    {
        return 0;
    }

    public final String getSpokenLocaleBcp47()
    {
        Object obj = Locale.ENGLISH;
        Locale locale = Locale.getDefault();
        String s = String.valueOf(locale.getLanguage().toLowerCase(((Locale) (obj))));
        obj = String.valueOf(locale.getCountry().toUpperCase(((Locale) (obj))));
        return (new StringBuilder(String.valueOf(s).length() + 1 + String.valueOf(obj).length())).append(s).append("-").append(((String) (obj))).toString();
    }

    public final String getVoiceSearchTokenType()
    {
        return "https://www.googleapis.com/auth/speech/personalization";
    }

    public final boolean isDebugAudioLoggingEnabled()
    {
        return false;
    }

    public final boolean isEmbeddedEndpointingEnabled()
    {
        return true;
    }

    public final boolean isEmbeddedRecognitionOnlyForDebug()
    {
        return false;
    }

    public final boolean isNetworkRecognitionOnlyForDebug()
    {
        return false;
    }

    public final boolean isPersonalizationEnabled()
    {
        return false;
    }

    public final boolean isProfanityFilterEnabled()
    {
        return true;
    }

    public final boolean isS3DebugLoggingEnabled()
    {
        return false;
    }

    public final boolean isServerEndpointingEnabled()
    {
        return false;
    }

    public final boolean isSoundSearchEnabled()
    {
        return false;
    }

    public final void setSpokenLanguageBcp47(String s, boolean flag)
    {
    }
}
