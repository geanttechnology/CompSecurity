// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.dataupload;

import java.util.Vector;

// Referenced classes of package com.nuance.nmdp.speechkit.util.dataupload:
//            Action

public class Data
{
    public static final class DataType extends Enum
    {

        public static final DataType CONTACTS;
        public static final DataType CUSTOMWORDS;
        public static final DataType HISTORY;
        private static final DataType a[];

        public static DataType valueOf(String s)
        {
            return (DataType)Enum.valueOf(com/nuance/nmdp/speechkit/util/dataupload/Data$DataType, s);
        }

        public static DataType[] values()
        {
            return (DataType[])a.clone();
        }

        static 
        {
            CONTACTS = new DataType("CONTACTS", 0);
            CUSTOMWORDS = new DataType("CUSTOMWORDS", 1);
            HISTORY = new DataType("HISTORY", 2);
            a = (new DataType[] {
                CONTACTS, CUSTOMWORDS, HISTORY
            });
        }

        private DataType(String s, int i)
        {
            super(s, i);
        }
    }


    private String a;
    private int b;
    private DataType c;
    private Vector d;

    public Data(String s, DataType datatype)
    {
        a = s;
        b = 0;
        if (datatype == DataType.CONTACTS || datatype == DataType.CUSTOMWORDS || datatype == DataType.HISTORY)
        {
            c = datatype;
        } else
        {
            c = DataType.CONTACTS;
        }
        d = new Vector();
    }

    final com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary a()
    {
        com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary;
        dictionary = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary();
        dictionary.put("id", a);
        if (c != null) goto _L2; else goto _L1
_L1:
        dictionary.put("type", "contacts");
          goto _L3
_L2:
        _cls1.a[c.ordinal()];
        JVM INSTR tableswitch 1 3: default 144
    //                   1 147
    //                   2 158
    //                   3 169;
           goto _L1 _L4 _L5 _L6
_L4:
        dictionary.put("type", "contacts");
          goto _L3
_L5:
        dictionary.put("type", "custom_words");
          goto _L3
_L6:
        dictionary.put("type", "history");
_L3:
        if (!d.isEmpty())
        {
            com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence sequence = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence();
            static final class _cls1
            {

                static final int a[];

                static 
                {
                    a = new int[DataType.values().length];
                    try
                    {
                        a[DataType.CONTACTS.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[DataType.CUSTOMWORDS.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[DataType.HISTORY.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            for (int i = 0; i < d.size(); i++)
            {
                Object obj = (Action)d.elementAt(i);
                if (obj != null)
                {
                    obj = ((Action) (obj)).a();
                    if (obj != null)
                    {
                        sequence.add(((com.nuance.nmdp.speechkit.util.pdx.PdxValue) (obj)));
                    }
                }
            }

            dictionary.put("actions", sequence);
        }
        return dictionary;
    }

    public void addAction(Action action)
    {
        if (action != null)
        {
            d.add(action);
        }
    }

    public void clearActions()
    {
        d.removeAllElements();
    }

    public void clearData()
    {
        a = null;
        b = 0;
        c = null;
        d.removeAllElements();
    }

    public int getChecksum()
    {
        int j = 0;
        int i = 0;
        for (; j < d.size(); j++)
        {
            Action action = (Action)d.elementAt(j);
            if (action != null)
            {
                i = action.getChecksum() + i;
            }
        }

        b = i;
        return i;
    }

    public String getId()
    {
        return a;
    }

    public String getTypeStr()
    {
        if (c == null)
        {
            return "contacts";
        }
        switch (_cls1.a[c.ordinal()])
        {
        default:
            return "contacts";

        case 1: // '\001'
            return "contacts";

        case 2: // '\002'
            return "custom_words";

        case 3: // '\003'
            return "history";
        }
    }

    public void removeAction(Action action)
    {
        if (action != null)
        {
            d.remove(action);
        }
    }

    public void setType(DataType datatype)
    {
        if (datatype == DataType.CONTACTS || datatype == DataType.CUSTOMWORDS || datatype == DataType.HISTORY)
        {
            c = datatype;
            return;
        } else
        {
            c = DataType.CONTACTS;
            return;
        }
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append((new StringBuilder()).append("id:").append(a).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("checksum:").append(b).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("type:").append(c).append("\n").toString());
        if (!d.isEmpty())
        {
            int j = d.size();
            stringbuffer.append((new StringBuilder()).append("action list: ").append(j).append("\n").toString());
            for (int i = 0; i < j; i++)
            {
                Action action = (Action)d.elementAt(i);
                if (action != null)
                {
                    stringbuffer.append((new StringBuilder()).append("action: ").append(i).append("\n").toString());
                    stringbuffer.append(action.toString());
                }
            }

        }
        return stringbuffer.toString();
    }
}
