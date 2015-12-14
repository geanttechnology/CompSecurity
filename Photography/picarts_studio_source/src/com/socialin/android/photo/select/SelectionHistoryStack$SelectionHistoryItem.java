// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import java.io.File;
import java.util.ArrayList;

public final class SelectionHistoryType.Mask
{

    public File a;
    public ArrayList b;
    public SelectionHistoryType c;

    public SelectionHistoryType(File file)
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

    public SelectionHistoryType.File(ArrayList arraylist)
    {
        a = null;
        b = arraylist;
        c = SelectionHistoryType.Mask;
    }
}
