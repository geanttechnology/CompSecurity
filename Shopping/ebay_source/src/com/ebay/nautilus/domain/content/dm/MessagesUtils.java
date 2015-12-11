// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.data.MessageFolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MessagesUtils
{

    private MessagesUtils()
    {
    }

    public static Object find(Object obj, List list)
    {
        return find(obj, list, false);
    }

    public static Object find(Object obj, List list, boolean flag)
    {
        int i = list.indexOf(obj);
        if (i < 0)
        {
            obj = null;
        } else
        {
            Object obj1 = list.get(i);
            obj = obj1;
            if (flag)
            {
                list.remove(i);
                return obj1;
            }
        }
        return obj;
    }

    public static Object findAndRemove(Object obj, List list)
    {
        return find(obj, list, true);
    }

    public static EbayMessage findById(String s, List list)
    {
        return findById(s, list, false);
    }

    public static EbayMessage findById(String s, List list, boolean flag)
    {
        Object obj1 = null;
        int j = list.size();
        int i = 0;
        do
        {
label0:
            {
                Object obj = obj1;
                if (i < j)
                {
                    obj = (EbayMessage)list.get(i);
                    if (!((EbayMessage) (obj)).messageId.equals(s))
                    {
                        break label0;
                    }
                    s = ((String) (obj));
                    obj = s;
                    if (flag)
                    {
                        list.remove(i);
                        obj = s;
                    }
                }
                return ((EbayMessage) (obj));
            }
            i++;
        } while (true);
    }

    public static MessageFolder findById(long l, List list)
    {
        return findById(l, list, false);
    }

    public static MessageFolder findById(long l, List list, boolean flag)
    {
        Object obj = null;
        int j = list.size();
        int i = 0;
        do
        {
label0:
            {
                MessageFolder messagefolder = obj;
                if (i < j)
                {
                    messagefolder = (MessageFolder)list.get(i);
                    if (messagefolder.folderId != l)
                    {
                        break label0;
                    }
                    MessageFolder messagefolder1 = messagefolder;
                    messagefolder = messagefolder1;
                    if (flag)
                    {
                        list.remove(i);
                        messagefolder = messagefolder1;
                    }
                }
                return messagefolder;
            }
            i++;
        } while (true);
    }

    public static EbayMessage findByIdAndRemove(String s, List list)
    {
        return findById(s, list, true);
    }

    public static MessageFolder findByIdAndRemove(long l, List list)
    {
        return findById(l, list, true);
    }

    public static List makeList(Object obj)
    {
        ArrayList arraylist = new ArrayList(1);
        if (obj != null)
        {
            arraylist.add(obj);
        }
        return arraylist;
    }

    public static boolean update(Object obj, List list)
    {
        ListIterator listiterator = list.listIterator();
        boolean flag1 = false;
        boolean flag;
        do
        {
            flag = flag1;
            if (!listiterator.hasNext())
            {
                break;
            }
            if (!obj.equals(listiterator.next()))
            {
                continue;
            }
            listiterator.set(obj);
            flag = true;
            break;
        } while (true);
        if (!flag)
        {
            list.add(obj);
        }
        return flag;
    }

    public static boolean updateAll(List list, List list1)
    {
        boolean flag = true;
        for (list = list.iterator(); list.hasNext();)
        {
            flag &= update(list.next(), list1);
        }

        return flag;
    }
}
