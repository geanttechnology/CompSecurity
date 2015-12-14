// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            CreateAlbumDialog

private final class <init>
{

    private final String INVALID_CHARS;
    private final String INVALID_START_CHAR;
    private final int MAX_CHAR_LIMIT;
    final CreateAlbumDialog this$0;

    public boolean isValid(CharSequence charsequence)
    {
        while (StringUtils.isEmpty(charsequence) || charsequence.length() > 280 || StringUtils.startsWith(charsequence, ".") || StringUtils.contains(charsequence, "/")) 
        {
            return false;
        }
        return true;
    }

    private ()
    {
        this$0 = CreateAlbumDialog.this;
        super();
        MAX_CHAR_LIMIT = 280;
        INVALID_START_CHAR = ".";
        INVALID_CHARS = "/";
    }

    INVALID_CHARS(INVALID_CHARS invalid_chars)
    {
        this();
    }
}
