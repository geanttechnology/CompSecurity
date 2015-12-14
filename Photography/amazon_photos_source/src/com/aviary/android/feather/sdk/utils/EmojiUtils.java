// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.utils;


public final class EmojiUtils
{

    public static final int BASE_EMOJI_BYTE = 55357;
    public static final int LOWER_EMOJI_CHAR = 56384;
    public static final int UPPER_EMOJI_CHAR = 56911;

    private EmojiUtils()
    {
    }

    public static boolean isSingleByteEmoji(char c)
    {
        return c >= '\u2600' && c <= '\u26FF' || c >= '\u2702' && c <= '\u27B0' || c >= '\0' && c <= '\0' || c >= '\u24C2' && c <= '\0' || c >= '\0' && c <= '\0' || c >= '\0' && c <= '\0';
    }
}
