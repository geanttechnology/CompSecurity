// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import f;
import java.io.File;

public final class Greco3Grammar extends Enum
{

    private static final Greco3Grammar $VALUES[];
    public static final Greco3Grammar CONTACT_DIALING;
    public static final Greco3Grammar HANDS_FREE_COMMANDS;
    public static int SIZE = 2;
    private final boolean mAddContacts;
    private final boolean mCompiledOnDevice;
    private final String mDirectoryName;

    private Greco3Grammar(String s, int i, String s1, boolean flag, boolean flag1)
    {
        super(s, i);
        mDirectoryName = s1;
        mCompiledOnDevice = flag;
        mAddContacts = flag1;
    }

    public static Greco3Grammar fromDirectoryName(String s)
    {
        if (CONTACT_DIALING.getDirectoryName().equals(s))
        {
            return CONTACT_DIALING;
        }
        if (HANDS_FREE_COMMANDS.getDirectoryName().equals(s))
        {
            return HANDS_FREE_COMMANDS;
        } else
        {
            return null;
        }
    }

    public static Greco3Grammar valueOf(File file)
    {
        return fromDirectoryName(file.getName());
    }

    public static Greco3Grammar valueOf(String s)
    {
        return (Greco3Grammar)Enum.valueOf(com/google/android/speech/embedded/Greco3Grammar, s);
    }

    public static Greco3Grammar[] values()
    {
        return (Greco3Grammar[])$VALUES.clone();
    }

    public final String getApkFullName(String s)
    {
        return (new StringBuilder()).append(((String)f.b(s)).replace("-", "_").toLowerCase()).append("_").append(mDirectoryName).toString();
    }

    public final String getDirectoryName()
    {
        return mDirectoryName;
    }

    public final boolean isAddContacts()
    {
        return mAddContacts;
    }

    public final boolean isCompiledOnDevice()
    {
        return mCompiledOnDevice;
    }

    static 
    {
        CONTACT_DIALING = new Greco3Grammar("CONTACT_DIALING", 0, "contacts", true, true);
        HANDS_FREE_COMMANDS = new Greco3Grammar("HANDS_FREE_COMMANDS", 1, "hands_free_commands", true, false);
        $VALUES = (new Greco3Grammar[] {
            CONTACT_DIALING, HANDS_FREE_COMMANDS
        });
    }
}
