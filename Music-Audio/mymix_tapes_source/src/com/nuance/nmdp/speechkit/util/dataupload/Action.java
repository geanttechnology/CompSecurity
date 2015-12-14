// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.dataupload;

import java.util.Vector;

// Referenced classes of package com.nuance.nmdp.speechkit.util.dataupload:
//            Contact

public class Action
{
    public static final class ActionType extends Enum
    {

        public static final ActionType ADD;
        public static final ActionType CLEARALL;
        public static final ActionType REMOVE;
        private static final ActionType a[];

        public static ActionType valueOf(String s)
        {
            return (ActionType)Enum.valueOf(com/nuance/nmdp/speechkit/util/dataupload/Action$ActionType, s);
        }

        public static ActionType[] values()
        {
            return (ActionType[])a.clone();
        }

        static 
        {
            ADD = new ActionType("ADD", 0);
            REMOVE = new ActionType("REMOVE", 1);
            CLEARALL = new ActionType("CLEARALL", 2);
            a = (new ActionType[] {
                ADD, REMOVE, CLEARALL
            });
        }

        private ActionType(String s, int i)
        {
            super(s, i);
        }
    }


    private ActionType a;
    private Vector b;
    private Vector c;

    public Action(ActionType actiontype)
    {
        if (actiontype == ActionType.ADD || actiontype == ActionType.REMOVE || actiontype == ActionType.CLEARALL)
        {
            a = actiontype;
        } else
        {
            a = ActionType.ADD;
        }
        b = new Vector();
        c = new Vector();
    }

    final com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary a()
    {
        com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary;
        com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary1;
        dictionary = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary();
        dictionary1 = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary();
        if (a != null) goto _L2; else goto _L1
_L1:
        dictionary.put("action", "add");
_L8:
        if (b.isEmpty()) goto _L4; else goto _L3
_L2:
        _cls1.a[a.ordinal()];
        JVM INSTR tableswitch 1 3: default 148
    //                   1 151
    //                   2 162
    //                   3 173;
           goto _L1 _L5 _L6 _L7
_L5:
        dictionary.put("action", "add");
          goto _L8
_L6:
        dictionary.put("action", "remove");
          goto _L8
_L7:
        dictionary.put("action", "clear_all");
          goto _L8
_L3:
        com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence sequence = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence();
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[ActionType.values().length];
                try
                {
                    a[ActionType.ADD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[ActionType.REMOVE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[ActionType.CLEARALL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        for (int i = 0; i < b.size(); i++)
        {
            Object obj = (Contact)b.elementAt(i);
            if (obj != null)
            {
                obj = ((Contact) (obj)).a();
                if (obj != null)
                {
                    sequence.add(((com.nuance.nmdp.speechkit.util.pdx.PdxValue) (obj)));
                }
            }
        }

        dictionary1.put("list", sequence);
_L10:
        dictionary.put("content", dictionary1);
        return dictionary;
_L4:
        if (!c.isEmpty())
        {
            com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence sequence1 = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence();
            for (int j = 0; j < c.size(); j++)
            {
                String s = (String)c.elementAt(j);
                if (s != null)
                {
                    sequence1.add(s);
                }
            }

            dictionary1.put("list", sequence1);
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void addContact(Contact contact)
    {
        b.add(contact);
    }

    public void addWord(String s)
    {
        c.add(s);
    }

    public void cleanData()
    {
        a = null;
        b.removeAllElements();
        c.removeAllElements();
    }

    public void clearContacts()
    {
        b.removeAllElements();
    }

    public void clearWords()
    {
        c.removeAllElements();
    }

    public int getChecksum()
    {
        boolean flag = false;
        int l = 0;
        int i = 0;
        int k;
        int i1;
        do
        {
            k = i;
            i1 = ((flag) ? 1 : 0);
            if (l >= b.size())
            {
                break;
            }
            Contact contact = (Contact)b.elementAt(l);
            if (contact != null)
            {
                i = contact.getCheckSum() + i;
            }
            l++;
        } while (true);
        while (i1 < c.size()) 
        {
            String s = (String)c.elementAt(i1);
            int j;
            if (s != null)
            {
                j = s.hashCode() + k;
            } else
            {
                j = k;
            }
            i1++;
            k = j;
        }
        return k;
    }

    public void removeContact(Contact contact)
    {
        b.remove(contact);
    }

    public void removeWord(String s)
    {
        c.remove(s);
    }

    public void setType(ActionType actiontype)
    {
        if (actiontype == ActionType.ADD || actiontype == ActionType.REMOVE || actiontype == ActionType.CLEARALL)
        {
            a = actiontype;
            return;
        } else
        {
            a = ActionType.ADD;
            return;
        }
    }

    public String toString()
    {
        boolean flag = false;
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append((new StringBuilder()).append("action:").append(a).append("\n").toString());
        if (!b.isEmpty())
        {
            int k = b.size();
            stringbuffer.append((new StringBuilder()).append("contact list: ").append(k).append("\n").toString());
            for (int i = 0; i < k; i++)
            {
                Contact contact = (Contact)b.elementAt(i);
                if (contact != null)
                {
                    stringbuffer.append((new StringBuilder()).append("contact: ").append(i).append("\n").toString());
                    stringbuffer.append(contact.toString());
                }
            }

        }
        if (!c.isEmpty())
        {
            int l = c.size();
            stringbuffer.append((new StringBuilder()).append("word list: ").append(l).append("\n").toString());
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                String s = (String)c.elementAt(j);
                if (s != null)
                {
                    stringbuffer.append((new StringBuilder()).append("word: ").append(j).append(" ").append(s).append("\n").toString());
                }
            }

        }
        return stringbuffer.toString();
    }
}
