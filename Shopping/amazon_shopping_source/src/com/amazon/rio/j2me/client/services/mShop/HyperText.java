// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            TextAttributes

public class HyperText
{

    private TextAttributes attributes;
    private boolean lineBreak;
    private String text;

    public HyperText()
    {
    }

    public TextAttributes getAttributes()
    {
        return attributes;
    }

    public boolean getLineBreak()
    {
        return lineBreak;
    }

    public String getText()
    {
        return text;
    }

    public void setAttributes(TextAttributes textattributes)
    {
        attributes = textattributes;
    }

    public void setLineBreak(boolean flag)
    {
        lineBreak = flag;
    }

    public void setText(String s)
    {
        text = s;
    }
}
