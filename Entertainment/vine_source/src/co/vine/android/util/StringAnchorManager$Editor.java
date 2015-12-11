// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;


// Referenced classes of package co.vine.android.util:
//            StringAnchorManager

public static class mType
{

    private final android.content.itor.mType mEditor;
    private final String mType;

    public void commit()
    {
        mEditor.mmit();
    }

    public void setAnchor(String s)
    {
        mEditor.tString((new StringBuilder()).append("anchor_").append(mType).toString(), s);
    }

    public void setIndex(long l)
    {
        mEditor.tLong((new StringBuilder()).append("index_").append(mType).toString(), l);
    }

    public void setLastId(long l)
    {
        mEditor.tLong((new StringBuilder()).append("lastId_").append(mType).toString(), l);
    }

    public void setRefreshTime(long l)
    {
        mEditor.tLong((new StringBuilder()).append("refresh_time_").append(mType).toString(), l);
    }

    public (android.content.itor itor, String s)
    {
        mEditor = itor;
        mType = s;
    }
}
