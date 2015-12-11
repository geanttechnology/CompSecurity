// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;


// Referenced classes of package com.uplynk.media:
//            MediaPlayer

public class _desc
{

    protected String _desc;
    protected String _key;
    protected String _value;
    final MediaPlayer this$0;

    public String getDescription()
    {
        return _desc;
    }

    public String getKey()
    {
        return _key;
    }

    public String getValue()
    {
        return _value;
    }

    protected ()
    {
        this$0 = MediaPlayer.this;
        super();
    }

    protected this._cls0(String s, String s1, String s2)
    {
        this$0 = MediaPlayer.this;
        super();
        _key = s;
        _value = s1;
        _desc = s2;
    }
}
