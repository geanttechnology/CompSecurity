// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;


// Referenced classes of package com.uplynk.media:
//            MediaPlayer

public class _sliceIndex
{

    protected String _assetID;
    protected  _assetInfo;
    protected String _ray;
    protected String _sliceIndex;
    final MediaPlayer this$0;

    public String getAssetID()
    {
        return _assetID;
    }

    public  getAssetInfo()
    {
        return _assetInfo;
    }

    public String getRay()
    {
        return _ray;
    }

    public String getSliceIndex()
    {
        return _sliceIndex;
    }

    public int getSliceNumber()
    {
        if (_sliceIndex != null)
        {
            int i;
            try
            {
                i = Integer.parseInt(_sliceIndex, 16);
            }
            catch (NumberFormatException numberformatexception)
            {
                return 0;
            }
            return i;
        } else
        {
            return 0;
        }
    }

    public String toString()
    {
        return (new StringBuilder(String.valueOf(_assetID))).append(" ").append(_ray).append(" ").append(_sliceIndex).append(" (").append(getSliceNumber()).append(")").toString();
    }

    protected ()
    {
        this$0 = MediaPlayer.this;
        super();
        _assetID = null;
        _ray = null;
        _sliceIndex = null;
        _assetInfo = null;
    }

    protected _assetInfo(String as[])
    {
        this$0 = MediaPlayer.this;
        super();
        _assetID = null;
        _ray = null;
        _sliceIndex = null;
        _assetInfo = null;
        if (as.length < 3)
        {
            return;
        } else
        {
            _assetID = as[0];
            _ray = as[1];
            _sliceIndex = as[2];
            return;
        }
    }
}
