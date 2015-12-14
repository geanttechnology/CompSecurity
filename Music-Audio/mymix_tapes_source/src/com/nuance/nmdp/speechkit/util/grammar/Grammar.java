// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.grammar;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Grammar
{
    public static final class GrammarType extends Enum
    {

        public static final GrammarType CONTACTS;
        public static final GrammarType CUSTOMWORDS;
        public static final GrammarType HISTORY;
        public static final GrammarType INSTANT_ITEM_LIST;
        public static final GrammarType PREDEFINED_STATIC_GRAMMARS;
        public static final GrammarType URI;
        private static final GrammarType a[];

        public static GrammarType valueOf(String s)
        {
            return (GrammarType)Enum.valueOf(com/nuance/nmdp/speechkit/util/grammar/Grammar$GrammarType, s);
        }

        public static GrammarType[] values()
        {
            return (GrammarType[])a.clone();
        }

        static 
        {
            CONTACTS = new GrammarType("CONTACTS", 0);
            CUSTOMWORDS = new GrammarType("CUSTOMWORDS", 1);
            HISTORY = new GrammarType("HISTORY", 2);
            URI = new GrammarType("URI", 3);
            PREDEFINED_STATIC_GRAMMARS = new GrammarType("PREDEFINED_STATIC_GRAMMARS", 4);
            INSTANT_ITEM_LIST = new GrammarType("INSTANT_ITEM_LIST", 5);
            a = (new GrammarType[] {
                CONTACTS, CUSTOMWORDS, HISTORY, URI, PREDEFINED_STATIC_GRAMMARS, INSTANT_ITEM_LIST
            });
        }

        private GrammarType(String s, int i1)
        {
            super(s, i1);
        }
    }


    private GrammarType a;
    private String b;
    private int c;
    private boolean d;
    private boolean e;
    private int f;
    private boolean g;
    private String h;
    private String i;
    private String j;
    private String k;
    private Vector l;

    public Grammar(GrammarType grammartype, String s)
    {
        e = false;
        g = false;
        b = s;
        if (grammartype == GrammarType.CONTACTS || grammartype == GrammarType.CUSTOMWORDS || grammartype == GrammarType.HISTORY || grammartype == GrammarType.URI || grammartype == GrammarType.PREDEFINED_STATIC_GRAMMARS || grammartype == GrammarType.INSTANT_ITEM_LIST)
        {
            a = grammartype;
        } else
        {
            a = GrammarType.CONTACTS;
        }
        if (a == GrammarType.INSTANT_ITEM_LIST)
        {
            l = new Vector();
        }
    }

    public Grammar(GrammarType grammartype, String s, int i1)
    {
        e = false;
        g = false;
        b = s;
        if (grammartype == GrammarType.CONTACTS || grammartype == GrammarType.CUSTOMWORDS || grammartype == GrammarType.HISTORY)
        {
            a = grammartype;
        } else
        {
            a = GrammarType.CONTACTS;
        }
        c = i1;
    }

    public Grammar(String s, String s1)
    {
        e = false;
        g = false;
        a = GrammarType.URI;
        b = s;
        k = s1;
        c = 0;
    }

    public Grammar(String s, List list)
    {
        e = false;
        g = false;
        a = GrammarType.INSTANT_ITEM_LIST;
        b = s;
        l = new Vector();
        s = list.iterator();
        do
        {
            if (!s.hasNext())
            {
                break;
            }
            list = (String)s.next();
            if (list != null)
            {
                l.add(list);
            }
        } while (true);
    }

    public com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary getGrammarDictionary()
    {
        com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary;
        boolean flag;
        flag = false;
        dictionary = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary();
        dictionary.put("id", b);
        dictionary.put("type", getTypeStr());
        if (a == GrammarType.PREDEFINED_STATIC_GRAMMARS)
        {
            return dictionary;
        }
        if (a != GrammarType.CONTACTS && a != GrammarType.CUSTOMWORDS && a != GrammarType.HISTORY) goto _L2; else goto _L1
_L1:
        dictionary.put("checksum", Integer.toString(c));
        if (j != null)
        {
            dictionary.put("common_user_id", j);
        }
_L4:
        if (e)
        {
            int i1 = ((flag) ? 1 : 0);
            if (d)
            {
                i1 = 1;
            }
            dictionary.put("load_as_lmh", i1);
        }
        if (g)
        {
            dictionary.put("topic_weight", f);
        }
        if (h != null)
        {
            dictionary.put("slot_tag", h);
        }
        if (i != null)
        {
            dictionary.put("interpretation_uri", i);
        }
        return dictionary;
_L2:
        if (a == GrammarType.URI)
        {
            dictionary.put("uri", k);
        } else
        if (a == GrammarType.INSTANT_ITEM_LIST)
        {
            com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence sequence = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence();
            if (!l.isEmpty())
            {
                for (int j1 = 0; j1 < l.size(); j1++)
                {
                    String s = (String)l.elementAt(j1);
                    if (s != null)
                    {
                        sequence.add(s);
                    }
                }

            }
            dictionary.put("item_list", sequence);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getTypeStr()
    {
        if (a == null)
        {
            return "contacts";
        }
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[GrammarType.values().length];
                try
                {
                    a[GrammarType.CONTACTS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[GrammarType.CUSTOMWORDS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[GrammarType.HISTORY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[GrammarType.URI.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[GrammarType.PREDEFINED_STATIC_GRAMMARS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[GrammarType.INSTANT_ITEM_LIST.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[a.ordinal()])
        {
        default:
            return "contacts";

        case 1: // '\001'
            return "contacts";

        case 2: // '\002'
            return "custom_words";

        case 3: // '\003'
            return "history";

        case 4: // '\004'
            return "uri";

        case 5: // '\005'
            return "predefined_static_grammars";

        case 6: // '\006'
            return "instant_item_list";
        }
    }

    public void setInterUri(String s)
    {
        i = s;
    }

    public void setLoadAsLmh(boolean flag)
    {
        e = true;
        d = flag;
    }

    public void setSlotTag(String s)
    {
        h = s;
    }

    public void setTopicWeight(int i1)
    {
        g = true;
        f = i1;
    }

    public void setUri(String s)
    {
        k = s;
    }

    public void setUserId(String s)
    {
        j = s;
    }
}
