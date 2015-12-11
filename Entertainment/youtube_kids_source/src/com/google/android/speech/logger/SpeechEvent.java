// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.logger;


public interface SpeechEvent
{

    public static final int CONTACT_INFO = 13;
    public static final int CREATE_VOICE_RECOGNIZE_REQUEST_END = 7;
    public static final int CREATE_VOICE_RECOGNIZE_REQUEST_START = 6;
    public static final int FETCH_CONTACTS_BEGIN = 1;
    public static final int FETCH_CONTACTS_END = 2;
    public static final int FIRST_PACKET = 5;
    public static final int GRAMMAR_COMPILATION_CONTACTS_COUNT = 14;
    public static final int NETWORK_SEND_AUDIO_DATA = 4;
    public static final int NEW_RECOGNITION_ID = 3;
    public static final int START_COMMAND_RECOGNITION = 12;
    public static final int START_CONTACT_RECOGNITION = 11;
    public static final int START_SOUND_SEARCH_RECOGNITION = 10;
    public static final int START_TEXT_SEARCH = 9;
    public static final int START_TV_CONTENT_RECOGNITION = 15;
    public static final int START_VOICE_RECOGNITION = 8;
}
