// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.util.ArraysCompat;
import java.io.Serializable;

// Referenced classes of package com.fasterxml.jackson.core.io:
//            CharTypes

public abstract class CharacterEscapes
    implements Serializable
{

    public static final int ESCAPE_CUSTOM = -2;
    public static final int ESCAPE_NONE = 0;
    public static final int ESCAPE_STANDARD = -1;
    private static final long serialVersionUID = 1L;

    public CharacterEscapes()
    {
    }

    public static int[] standardAsciiEscapesForJSON()
    {
        int ai[] = CharTypes.get7BitOutputEscapes();
        return ArraysCompat.copyOf(ai, ai.length);
    }

    public abstract int[] getEscapeCodesForAscii();

    public abstract SerializableString getEscapeSequence(int i);
}
