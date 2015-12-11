// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.data;


// Referenced classes of package com.supersonicads.sdk.data:
//            SSAObj

public class SSAFile extends SSAObj
{

    private String FILE;
    private String LAST_UPDATE_TIME;
    private String PATH;
    private String mErrMsg;
    private String mFile;
    private String mLastUpdateTime;
    private String mPath;

    public SSAFile(String s)
    {
        super(s);
        FILE = "file";
        PATH = "path";
        LAST_UPDATE_TIME = "lastUpdateTime";
        if (containsKey(FILE))
        {
            setFile(getString(FILE));
        }
        if (containsKey(PATH))
        {
            setPath(getString(PATH));
        }
        if (containsKey(LAST_UPDATE_TIME))
        {
            setLastUpdateTime(getString(LAST_UPDATE_TIME));
        }
    }

    public SSAFile(String s, String s1)
    {
        FILE = "file";
        PATH = "path";
        LAST_UPDATE_TIME = "lastUpdateTime";
        setFile(s);
        setPath(s1);
    }

    private void setFile(String s)
    {
        mFile = s;
    }

    private void setPath(String s)
    {
        mPath = s;
    }

    public String getErrMsg()
    {
        return mErrMsg;
    }

    public String getFile()
    {
        return mFile;
    }

    public String getLastUpdateTime()
    {
        return mLastUpdateTime;
    }

    public String getPath()
    {
        return mPath;
    }

    public void setErrMsg(String s)
    {
        mErrMsg = s;
    }

    public void setLastUpdateTime(String s)
    {
        mLastUpdateTime = s;
    }
}
