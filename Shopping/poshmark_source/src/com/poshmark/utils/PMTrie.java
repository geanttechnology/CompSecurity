// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PMTrie
{
    class TrieNode
    {

        String label;
        TrieNode list[];
        final PMTrie this$0;

        TrieNode()
        {
            this$0 = PMTrie.this;
            super();
            list = new TrieNode[26];
        }
    }


    int ascii_start;
    TrieNode root;

    public PMTrie()
    {
        ascii_start = 97;
        root = new TrieNode();
    }

    private List findAll(TrieNode trienode)
    {
        Object obj = new ArrayList();
        for (int i = 0; i < 26;)
        {
            Object obj1 = obj;
            if (trienode.list[i] != null)
            {
                ((List) (obj)).add(Character.toString((char)(ascii_start + i)));
                obj1 = mergeToMaster(((List) (obj)), findAll(trienode.list[i]));
            }
            i++;
            obj = obj1;
        }

        return ((List) (obj));
    }

    private List mergeToMaster(List list, List list1)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        list1 = list1.iterator();
        while (iterator.hasNext()) 
        {
            String s = (String)iterator.next();
            while (list1.hasNext()) 
            {
                String s1 = (String)list1.next();
                arraylist.add((new StringBuilder()).append(s).append(s1).toString());
            }
        }
        if (arraylist.size() == 0)
        {
            arraylist.addAll(list);
        }
        return arraylist;
    }

    private void recursiveAdd(TrieNode trienode, String s, int i)
    {
        if (s.length() <= i)
        {
            return;
        }
        int j = s.charAt(i) - ascii_start;
        if (trienode.list[j] == null)
        {
            trienode.list[j] = new TrieNode();
        }
        recursiveAdd(trienode.list[j], s, i + 1);
    }

    public void add(String s)
    {
        recursiveAdd(root, s, 0);
    }

    public void getMatchList(String s)
    {
        ArrayList arraylist = new ArrayList();
        char c = s.charAt(0);
        int i = c - ascii_start;
        if (root.list[i] == null)
        {
            return;
        } else
        {
            arraylist.add(Character.toString(c));
            mergeToMaster(arraylist, findAll(root.list[i]));
            return;
        }
    }
}
