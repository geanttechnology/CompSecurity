// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;


// Referenced classes of package com.uplynk.media:
//            CaptionManager

public static final class  extends Enum
{

    public static final START_NEW_ROW BACKSPACE;
    public static final START_NEW_ROW CLEAR_ALL;
    public static final START_NEW_ROW CLEAR_EOR;
    public static final START_NEW_ROW COLOR;
    public static final START_NEW_ROW COLUMN;
    private static final START_NEW_ROW ENUM$VALUES[];
    public static final START_NEW_ROW ERASE_DISPLAY_MEM;
    public static final START_NEW_ROW FLUSH;
    public static final START_NEW_ROW INDENT;
    public static final START_NEW_ROW ITALIC;
    public static final START_NEW_ROW LINEBREAK;
    public static final START_NEW_ROW START_NEW_ROW;
    public static final START_NEW_ROW TEXT;
    public static final START_NEW_ROW UNDERLINED;
    public static final START_NEW_ROW UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/uplynk/media/CaptionManager$CaptionAction, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        TEXT = new <init>("TEXT", 1);
        BACKSPACE = new <init>("BACKSPACE", 2);
        CLEAR_ALL = new <init>("CLEAR_ALL", 3);
        CLEAR_EOR = new <init>("CLEAR_EOR", 4);
        COLOR = new <init>("COLOR", 5);
        COLUMN = new <init>("COLUMN", 6);
        ERASE_DISPLAY_MEM = new <init>("ERASE_DISPLAY_MEM", 7);
        FLUSH = new <init>("FLUSH", 8);
        INDENT = new <init>("INDENT", 9);
        ITALIC = new <init>("ITALIC", 10);
        LINEBREAK = new <init>("LINEBREAK", 11);
        UNDERLINED = new <init>("UNDERLINED", 12);
        START_NEW_ROW = new <init>("START_NEW_ROW", 13);
        ENUM$VALUES = (new ENUM.VALUES[] {
            UNKNOWN, TEXT, BACKSPACE, CLEAR_ALL, CLEAR_EOR, COLOR, COLUMN, ERASE_DISPLAY_MEM, FLUSH, INDENT, 
            ITALIC, LINEBREAK, UNDERLINED, START_NEW_ROW
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
