// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;


// Referenced classes of package com.uplynk.media:
//            MediaPlayer

public class _isForced
{

    protected boolean _autoSelect;
    protected String _group;
    protected boolean _isDefault;
    protected boolean _isEmbedded;
    protected boolean _isForced;
    protected String _lang;
    protected String _name;
    protected char _type;
    final MediaPlayer this$0;

    public String getGroup()
    {
        return _group;
    }

    public String getLang()
    {
        return _lang;
    }

    public String getName()
    {
        return _name;
    }

    public char getType()
    {
        return _type;
    }

    public String toString()
    {
        return String.format("[%s] %s", new Object[] {
            _lang, _name
        });
    }

    protected ()
    {
        this$0 = MediaPlayer.this;
        super();
    }

    protected this._cls0(char c, String s, String s1, String s2, boolean flag, boolean flag1, 
            boolean flag2)
    {
        this$0 = MediaPlayer.this;
        super();
        _type = c;
        _name = s;
        _group = s1;
        _lang = s2;
        _isEmbedded = flag;
        _isDefault = flag1;
        _isForced = flag2;
    }
}
