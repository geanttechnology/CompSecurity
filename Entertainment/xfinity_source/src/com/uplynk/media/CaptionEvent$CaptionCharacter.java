// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;


// Referenced classes of package com.uplynk.media:
//            CaptionEvent

public class _isTransparent
{

    private short _char;
    private int _color;
    private boolean _isItalic;
    private boolean _isTransparent;
    private boolean _isUnderlined;
    final CaptionEvent this$0;

    public char character()
    {
        return (char)_char;
    }

    public int color()
    {
        return _color;
    }

    public boolean isItalic()
    {
        return _isItalic;
    }

    public boolean isUnderlined()
    {
        return _isUnderlined;
    }

    private ()
    {
        this$0 = CaptionEvent.this;
        super();
    }

    protected this._cls0(short word0, int i, boolean flag, boolean flag1, boolean flag2)
    {
        this$0 = CaptionEvent.this;
        super();
        _char = word0;
        _color = i;
        _isItalic = flag;
        _isUnderlined = flag1;
        _isTransparent = flag2;
    }
}
