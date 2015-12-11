// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


// Referenced classes of package org.jsoup.parser:
//            Token

static final class  extends Enum
{

    private static final EOF $VALUES[];
    public static final EOF Character;
    public static final EOF Comment;
    public static final EOF Doctype;
    public static final EOF EOF;
    public static final EOF EndTag;
    public static final EOF StartTag;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/jsoup/parser/Token$TokenType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Doctype = new <init>("Doctype", 0);
        StartTag = new <init>("StartTag", 1);
        EndTag = new <init>("EndTag", 2);
        Comment = new <init>("Comment", 3);
        Character = new <init>("Character", 4);
        EOF = new <init>("EOF", 5);
        $VALUES = (new .VALUES[] {
            Doctype, StartTag, EndTag, Comment, Character, EOF
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
