// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.dataupload;

import java.util.Vector;

// Referenced classes of package com.nuance.nmdp.speechkit.util.dataupload:
//            Data

public class DataBlock
{

    private int a;
    private String b;
    private Vector c;

    public DataBlock()
    {
        a = 0;
        b = null;
        c = new Vector();
    }

    public void addData(Data data)
    {
        if (data != null)
        {
            c.add(data);
        }
    }

    public void clearDataBlock()
    {
        c.removeAllElements();
    }

    public int getChecksum()
    {
        int j = 0;
        int i = 0;
        for (; j < c.size(); j++)
        {
            Data data = (Data)c.elementAt(j);
            if (data != null)
            {
                i = data.getChecksum() + i;
            }
        }

        return i;
    }

    public com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary getDataBlockDictionary()
    {
        com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary();
        dictionary.put("delete_all", a);
        if (b != null)
        {
            dictionary.put("common_user_id", b);
        }
        if (!c.isEmpty())
        {
            com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence sequence = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence();
            for (int i = 0; i < c.size(); i++)
            {
                Object obj = (Data)c.elementAt(i);
                if (obj == null)
                {
                    continue;
                }
                obj = ((Data) (obj)).a();
                if (obj != null)
                {
                    sequence.add(((com.nuance.nmdp.speechkit.util.pdx.PdxValue) (obj)));
                }
            }

            dictionary.put("data_list", sequence);
        }
        return dictionary;
    }

    public Vector getDataList()
    {
        return c;
    }

    public void removeData(Data data)
    {
        if (data != null)
        {
            c.remove(data);
        }
    }

    public void setDeleteAll(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        a = i;
    }

    public void setUserId(String s)
    {
        b = s;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append((new StringBuilder()).append("delete_all:").append(a).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("checksum:").append(getChecksum()).append("\n").toString());
        if (!c.isEmpty())
        {
            int j = c.size();
            stringbuffer.append((new StringBuilder()).append("data_list: elements ").append(j).append("\n").toString());
            for (int i = 0; i < j; i++)
            {
                Data data = (Data)c.elementAt(i);
                if (data != null)
                {
                    stringbuffer.append((new StringBuilder()).append("data: ").append(i).append("\n").toString());
                    stringbuffer.append(data.toString());
                }
            }

        }
        return stringbuffer.toString();
    }
}
