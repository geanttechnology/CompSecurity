// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface BitArray
{
    public static final class FixedCapacity
        implements BitArray
    {

        long data;

        private static int checkInput(int i)
        {
            if (i < 0 || i > 63)
            {
                throw new IllegalArgumentException(String.format("input must be between 0 and 63: %s", new Object[] {
                    Integer.valueOf(i)
                }));
            } else
            {
                return i;
            }
        }

        public void clear()
        {
            data = 0L;
        }

        public boolean get(int i)
        {
            return (data >> checkInput(i) & 1L) == 1L;
        }

        public void set(int i)
        {
            data = data | 1L << checkInput(i);
        }

        public void shiftLeft(int i)
        {
            data = data << checkInput(i);
        }

        public String toString()
        {
            return Long.toBinaryString(data);
        }

        public BitArray toVariableCapacity()
        {
            return new VariableCapacity(this);
        }

        public void toggle(int i)
        {
            data = data ^ 1L << checkInput(i);
        }

        public FixedCapacity()
        {
            data = 0L;
        }
    }

    public static final class VariableCapacity
        implements BitArray
    {

        long data[];
        private int start;

        private static int checkInput(int i)
        {
            if (i < 0)
            {
                throw new IllegalArgumentException(String.format("input must be a positive number: %s", new Object[] {
                    Integer.valueOf(i)
                }));
            } else
            {
                return i;
            }
        }

        private void growToSize(int i)
        {
            long al[] = new long[i];
            if (data != null)
            {
                System.arraycopy(data, 0, al, 0, data.length);
            }
            data = al;
        }

        private int offsetOf(int i)
        {
            i = (i + start) / 64;
            if (i > data.length - 1)
            {
                growToSize(i + 1);
            }
            return i;
        }

        private int shiftOf(int i)
        {
            return (start + i) % 64;
        }

        public void clear()
        {
            Arrays.fill(data, 0L);
        }

        public boolean get(int i)
        {
            checkInput(i);
            int j = offsetOf(i);
            return (data[j] & 1L << shiftOf(i)) != 0L;
        }

        public void set(int i)
        {
            checkInput(i);
            int j = offsetOf(i);
            long al[] = data;
            al[j] = al[j] | 1L << shiftOf(i);
        }

        public void shiftLeft(int i)
        {
            start = start - checkInput(i);
            if (start < 0)
            {
                i = start / -64 + 1;
                long al[] = new long[data.length + i];
                System.arraycopy(data, 0, al, i, data.length);
                data = al;
                start = start % 64 + 64;
            }
        }

        List toIntegerList()
        {
            ArrayList arraylist = new ArrayList();
            int i = 0;
            int j = data.length;
            for (int k = start; i < j * 64 - k; i++)
            {
                if (get(i))
                {
                    arraylist.add(Integer.valueOf(i));
                }
            }

            return arraylist;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder("{");
            List list = toIntegerList();
            int i = 0;
            for (int j = list.size(); i < j; i++)
            {
                if (i > 0)
                {
                    stringbuilder.append(',');
                }
                stringbuilder.append(list.get(i));
            }

            return stringbuilder.append('}').toString();
        }

        public void toggle(int i)
        {
            checkInput(i);
            int j = offsetOf(i);
            long al[] = data;
            al[j] = al[j] ^ 1L << shiftOf(i);
        }

        public VariableCapacity()
        {
            data = new long[1];
        }

        private VariableCapacity(FixedCapacity fixedcapacity)
        {
            data = (new long[] {
                fixedcapacity.data, 0L
            });
        }

    }


    public abstract void clear();

    public abstract boolean get(int i);

    public abstract void set(int i);

    public abstract void shiftLeft(int i);

    public abstract void toggle(int i);
}
