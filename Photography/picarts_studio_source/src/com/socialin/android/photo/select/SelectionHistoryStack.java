// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import java.io.File;
import java.util.ArrayList;

public final class SelectionHistoryStack
{

    public ArrayList a;
    public int b;

    public SelectionHistoryStack()
    {
        b = 0;
        a = new ArrayList();
        b = 20;
    }

    private SelectionHistoryStack(ArrayList arraylist, int i)
    {
        b = 0;
        ArrayList arraylist1 = new ArrayList(20);
        for (i = 0; i < arraylist.size(); i++)
        {
            arraylist1.add(new SelectionHistoryItem((File)arraylist.get(i)));
        }

        a = arraylist1;
        b = 20;
    }

    public static SelectionHistoryStack a(ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList(20);
        for (int i = 0; i < arraylist.size(); i++)
        {
            arraylist1.add(new File((String)arraylist.get(i)));
        }

        return new SelectionHistoryStack(arraylist1, 20);
    }

    public final SelectionHistoryItem a()
    {
        if (a.size() > 0)
        {
            SelectionHistoryItem selectionhistoryitem = (SelectionHistoryItem)a.remove(a.size() - 1);
            if (selectionhistoryitem != null && selectionhistoryitem.c == com.socialin.android.photo.select.SelectionHistoryItem.SelectionHistoryType.File)
            {
                File file = selectionhistoryitem.a;
                if (file != null)
                {
                    file.delete();
                }
            }
            return selectionhistoryitem;
        } else
        {
            return null;
        }
    }

    public final SelectionHistoryItem a(int i)
    {
        i = a.size() - 1 - i;
        if (i >= 0)
        {
            return (SelectionHistoryItem)a.get(i);
        } else
        {
            return null;
        }
    }

    public final SelectionHistoryItem a(SelectionHistoryItem selectionhistoryitem)
    {
        SelectionHistoryItem selectionhistoryitem1 = null;
        if (a.size() == b)
        {
            selectionhistoryitem1 = (SelectionHistoryItem)a.remove(0);
        }
        a.add(selectionhistoryitem);
        return selectionhistoryitem1;
    }

    public final SelectionHistoryItem b(ArrayList arraylist)
    {
        arraylist = a(new SelectionHistoryItem(arraylist));
        if (arraylist != null && ((SelectionHistoryItem) (arraylist)).c == com.socialin.android.photo.select.SelectionHistoryItem.SelectionHistoryType.File)
        {
            File file = ((SelectionHistoryItem) (arraylist)).a;
            if (file != null)
            {
                file.delete();
            }
        }
        return arraylist;
    }

    private class SelectionHistoryItem
    {

        public File a;
        public ArrayList b;
        public SelectionHistoryType c;

        public SelectionHistoryItem(File file)
        {
            a = null;
            a = file;
            class SelectionHistoryType extends Enum
            {

                private static final SelectionHistoryType $VALUES[];
                public static final SelectionHistoryType File;
                public static final SelectionHistoryType Mask;

                public static SelectionHistoryType valueOf(String s)
                {
                    return (SelectionHistoryType)Enum.valueOf(com/socialin/android/photo/select/SelectionHistoryStack$SelectionHistoryItem$SelectionHistoryType, s);
                }

                public static SelectionHistoryType[] values()
                {
                    return (SelectionHistoryType[])$VALUES.clone();
                }

                static 
                {
                    File = new SelectionHistoryType("File", 0);
                    Mask = new SelectionHistoryType("Mask", 1);
                    $VALUES = (new SelectionHistoryType[] {
                        File, Mask
                    });
                }

                private SelectionHistoryType(String s, int i)
                {
                    super(s, i);
                }
            }

            c = com.socialin.android.photo.select.SelectionHistoryType.File;
        }

        public SelectionHistoryItem(ArrayList arraylist)
        {
            a = null;
            b = arraylist;
            c = SelectionHistoryType.Mask;
        }
    }

}
