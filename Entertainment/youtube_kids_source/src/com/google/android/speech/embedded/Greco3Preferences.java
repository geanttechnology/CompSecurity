// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import efy;
import egc;
import ejr;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.speech.embedded:
//            Greco3Grammar

public class Greco3Preferences
{

    private static final egc ACTIVE_DOWNLOADS_JOINER = (new efy(",")).c(":");
    public static final String COMPILED_APK_GRAMMAR_REVISION_PREFIX = "g3_apk_grammar_revision_id_v1:";
    public static final String PREF_ACTIVE_DOWNLOADS = "g3_active_downloads";
    private static final String TAG = "VS.G3Preferences";
    private final SharedPreferences mSharedPreferences;

    public Greco3Preferences(SharedPreferences sharedpreferences)
    {
        mSharedPreferences = sharedpreferences;
    }

    public static HashMap buildHashMapFromDelimitedKeyValuePairs(String s)
    {
        HashMap hashmap;
        int i;
        int j;
        hashmap = ejr.a();
        s = s.split(",");
        j = s.length;
        i = 0;
_L2:
        String s1;
        String as[];
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        s1 = s[i].trim();
        if (!TextUtils.isEmpty(s1))
        {
            as = s1.split(":");
            if (as.length == 2 && !TextUtils.isEmpty(as[0]))
            {
                break; /* Loop/switch isn't completed */
            }
            Log.e("VS.G3Preferences", (new StringBuilder("Skipping bad value in active downloads setting pref :")).append(s1).toString());
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        long l = Long.parseLong(as[1]);
        hashmap.put(as[0], Long.valueOf(l));
          goto _L3
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.e("VS.G3Preferences", (new StringBuilder("Skipping bad value in active downloads pref: ")).append(s1).toString());
          goto _L3
        return hashmap;
    }

    static String serializeHashMapToDelimitedKeyValuePairs(Map map)
    {
        egc egc1 = ACTIVE_DOWNLOADS_JOINER;
        map = map.entrySet().iterator();
        return egc1.a(new StringBuilder(), map).toString();
    }

    private void writeToSharedPrefs(String s, String s1)
    {
        mSharedPreferences.edit().putString(s, s1).apply();
    }

    public void addActiveDownload(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        HashMap hashmap;
        hashmap = getActiveDownloads();
        if (hashmap.containsKey(s))
        {
            throw new IllegalStateException((new StringBuilder("Attempt to add download :")).append(s).append(", was already active.").toString());
        }
        break MISSING_BLOCK_LABEL_51;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        hashmap.put(s, Long.valueOf(l));
        writeToSharedPrefs("g3_active_downloads", serializeHashMapToDelimitedKeyValuePairs(hashmap));
        this;
        JVM INSTR monitorexit ;
    }

    public HashMap getActiveDownloads()
    {
        this;
        JVM INSTR monitorenter ;
        HashMap hashmap = buildHashMapFromDelimitedKeyValuePairs(mSharedPreferences.getString("g3_active_downloads", ""));
        this;
        JVM INSTR monitorexit ;
        return hashmap;
        Exception exception;
        exception;
        throw exception;
    }

    public String getCompiledGrammarRevisionId(Greco3Grammar greco3grammar)
    {
        greco3grammar = (new StringBuilder("g3_apk_grammar_revision_id_v1:")).append(greco3grammar.getDirectoryName()).toString();
        return mSharedPreferences.getString(greco3grammar, null);
    }

    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
        mSharedPreferences.registerOnSharedPreferenceChangeListener(onsharedpreferencechangelistener);
    }

    public void removeActiveDownload(String s)
    {
        this;
        JVM INSTR monitorenter ;
        HashMap hashmap = getActiveDownloads();
        if (hashmap.containsKey(s)) goto _L2; else goto _L1
_L1:
        Log.w("VS.G3Preferences", (new StringBuilder("Attempt to remove non-existent download")).append(s).toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        hashmap.remove(s);
        writeToSharedPrefs("g3_active_downloads", serializeHashMapToDelimitedKeyValuePairs(hashmap));
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public void setCompiledGrammarRevisionId(Greco3Grammar greco3grammar, String s)
    {
        greco3grammar = (new StringBuilder("g3_apk_grammar_revision_id_v1:")).append(greco3grammar.getDirectoryName()).toString();
        mSharedPreferences.edit().putString(greco3grammar, s).apply();
    }

    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
        mSharedPreferences.unregisterOnSharedPreferenceChangeListener(onsharedpreferencechangelistener);
    }

}
