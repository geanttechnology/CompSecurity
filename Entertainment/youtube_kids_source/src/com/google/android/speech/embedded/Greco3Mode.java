// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import ejr;
import java.io.File;
import java.util.Map;

public final class Greco3Mode extends Enum
{

    private static final Greco3Mode $VALUES[];
    private static final String ASCII_SUFFIX = ".ascii_proto";
    public static final Greco3Mode COMPILER;
    public static final Greco3Mode DICTATION;
    public static final Greco3Mode ENDPOINTER_DICTATION;
    public static final Greco3Mode ENDPOINTER_VOICESEARCH;
    public static final Greco3Mode GRAMMAR;
    public static final Greco3Mode HOTWORD;
    private static final Map MODE_MAP;

    private Greco3Mode(String s, int i)
    {
        super(s, i);
    }

    private static String getFileName(File file)
    {
        String s = file.getName();
        int i = s.indexOf(".");
        file = s;
        if (i > 0)
        {
            file = s.substring(0, i);
        }
        return file;
    }

    public static boolean isAsciiConfiguration(File file)
    {
        return file.getName().endsWith(".ascii_proto");
    }

    public static Greco3Mode valueOf(File file)
    {
        file = getFileName(file);
        return (Greco3Mode)MODE_MAP.get(file);
    }

    public static Greco3Mode valueOf(String s)
    {
        return (Greco3Mode)Enum.valueOf(com/google/android/speech/embedded/Greco3Mode, s);
    }

    public static Greco3Mode[] values()
    {
        return (Greco3Mode[])$VALUES.clone();
    }

    public final boolean isEndpointerMode()
    {
        return this == ENDPOINTER_DICTATION || this == ENDPOINTER_VOICESEARCH;
    }

    static 
    {
        DICTATION = new Greco3Mode("DICTATION", 0);
        ENDPOINTER_VOICESEARCH = new Greco3Mode("ENDPOINTER_VOICESEARCH", 1);
        ENDPOINTER_DICTATION = new Greco3Mode("ENDPOINTER_DICTATION", 2);
        HOTWORD = new Greco3Mode("HOTWORD", 3);
        COMPILER = new Greco3Mode("COMPILER", 4);
        GRAMMAR = new Greco3Mode("GRAMMAR", 5);
        $VALUES = (new Greco3Mode[] {
            DICTATION, ENDPOINTER_VOICESEARCH, ENDPOINTER_DICTATION, HOTWORD, COMPILER, GRAMMAR
        });
        java.util.HashMap hashmap = ejr.a();
        hashmap.put("dictation", DICTATION);
        hashmap.put("endpointer_voicesearch", ENDPOINTER_VOICESEARCH);
        hashmap.put("endpointer_dictation", ENDPOINTER_DICTATION);
        hashmap.put("google_hotword", HOTWORD);
        hashmap.put("hotword", HOTWORD);
        hashmap.put("compile_grammar", COMPILER);
        hashmap.put("grammar", GRAMMAR);
        MODE_MAP = hashmap;
    }
}
