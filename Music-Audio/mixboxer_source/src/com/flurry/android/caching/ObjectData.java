// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.caching;

import java.util.Vector;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.flurry.android.caching:
//            ObjectOperationData

public class ObjectData
{

    ExecutorType iW;
    private int iX;
    protected String mCollectionName;
    protected String mId;
    protected Vector mKeyValueList;

    public ObjectData(String s)
    {
        mId = "";
        mCollectionName = "";
        mKeyValueList = new Vector();
        iW = ExecutorType.NONE;
        iX = 31;
        mId = s;
        iW = ExecutorType.USER;
    }

    public ObjectData(String s, String s1)
    {
        mId = "";
        mCollectionName = "";
        mKeyValueList = new Vector();
        iW = ExecutorType.NONE;
        iX = 31;
        mId = s;
        mCollectionName = s1;
        iW = ExecutorType.OBJECT;
    }

    public void addKeyValue(String s, String s1)
    {
        mKeyValueList.add(new BasicNameValuePair(s, s1));
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (ObjectOperationData)obj;
            if (!((ObjectOperationData) (obj)).mId.equals(mId) || !((ObjectOperationData) (obj)).mCollectionName.equals(mCollectionName) || !((ObjectOperationData) (obj)).mKeyValueList.equals(mKeyValueList))
            {
                return false;
            }
        }
        return true;
    }

    public String getCollectionName()
    {
        return mCollectionName;
    }

    public String getId()
    {
        return mId;
    }

    public Vector getKeyValues()
    {
        return mKeyValueList;
    }

    public int getKeyValuesListSize()
    {
        return mKeyValueList.size();
    }

    public int hashCode()
    {
        return ((iX * iX + mId.hashCode()) * iX + mCollectionName.hashCode()) * iX + mKeyValueList.hashCode();
    }

    public boolean isObject()
    {
        boolean flag = false;
        if (iW == ExecutorType.OBJECT)
        {
            flag = true;
        } else
        if (iW == ExecutorType.USER)
        {
            return false;
        }
        return flag;
    }

    public boolean isUser()
    {
        while (iW == ExecutorType.OBJECT || iW != ExecutorType.USER) 
        {
            return false;
        }
        return true;
    }

    public void setCollectionName(String s)
    {
        mCollectionName = s;
    }

    public void setId(String s)
    {
        mId = s;
    }

    public void setKeyValues(Vector vector)
    {
        mKeyValueList = vector;
    }

    private class ExecutorType extends Enum
    {

        public static final ExecutorType NONE;
        public static final ExecutorType OBJECT;
        public static final ExecutorType USER;
        private static final ExecutorType eN[];

        public static ExecutorType valueOf(String s)
        {
            return (ExecutorType)Enum.valueOf(com/flurry/android/caching/ObjectData$ExecutorType, s);
        }

        public static ExecutorType[] values()
        {
            return (ExecutorType[])eN.clone();
        }

        static 
        {
            OBJECT = new ExecutorType("OBJECT", 0);
            USER = new ExecutorType("USER", 1);
            NONE = new ExecutorType("NONE", 2);
            eN = (new ExecutorType[] {
                OBJECT, USER, NONE
            });
        }

        private ExecutorType(String s, int i)
        {
            super(s, i);
        }
    }

}
