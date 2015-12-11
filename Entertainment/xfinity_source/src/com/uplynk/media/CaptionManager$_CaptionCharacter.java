// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;


// Referenced classes of package com.uplynk.media:
//            CaptionManager, CaptionEvent

private class _isTransparent
{

    private short _char;
    private int _color;
    private boolean _isItalic;
    private boolean _isTransparent;
    private boolean _isUnderlined;
    final CaptionManager this$0;

    short character()
    {
        return _char;
    }

    int color()
    {
        return _color;
    }

    boolean isItalic()
    {
        return _isItalic;
    }

    boolean isTransparent()
    {
        return _isTransparent;
    }

    boolean isUnderlined()
    {
        return _isUnderlined;
    }

    void reset()
    {
        _char = 32;
        _color = 0xffffff;
        _isItalic = false;
        _isUnderlined = false;
        _isTransparent = true;
    }

    void setTransparent()
    {
        _isTransparent = true;
    }

    void setValue(short word0, int i, boolean flag, boolean flag1)
    {
        _char = word0;
        _color = i;
        _isItalic = flag;
        _isUnderlined = flag1;
        _isTransparent = false;
    }

    _isTransparent toCaptionCharacter(CaptionEvent captionevent)
    {
        captionevent.getClass();
        return new it>(captionevent, _char, _color, _isItalic, _isUnderlined, _isTransparent);
    }

    ()
    {
        this$0 = CaptionManager.this;
        super();
        _char = 32;
        _color = 0xffffff;
        _isItalic = false;
        _isUnderlined = false;
        _isTransparent = true;
    }
}
