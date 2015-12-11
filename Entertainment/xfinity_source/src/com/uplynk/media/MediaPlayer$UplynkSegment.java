// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;


// Referenced classes of package com.uplynk.media:
//            MediaPlayer

public class _assetId
{

    protected String _assetId;
    protected double _duration;
    protected double _offset;
    protected char _type;
    final MediaPlayer this$0;

    public String getAssetId()
    {
        return _assetId;
    }

    public double getDuration()
    {
        return _duration;
    }

    public double getOffset()
    {
        return _offset;
    }

    public char getType()
    {
        return _type;
    }

    public String toString()
    {
        return (new StringBuilder("[")).append(_type).append("] ").append(_assetId).toString();
    }

    protected ()
    {
        this$0 = MediaPlayer.this;
        super();
    }

    protected this._cls0(char c, double d, double d1, String s)
    {
        this$0 = MediaPlayer.this;
        super();
        _type = c;
        _duration = d;
        _offset = d1;
        _assetId = s;
    }
}
