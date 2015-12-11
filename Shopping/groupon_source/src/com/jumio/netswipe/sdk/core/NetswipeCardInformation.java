// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netswipe.sdk.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.jumio.netswipe.sdk.enums.CreditCardType;
import java.util.Arrays;
import java.util.HashMap;
import netswipe.cw;
import netswipe.j;

public class NetswipeCardInformation
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new j();
    boolean a;
    private char b[];
    private char c[];
    private char d[];
    private char e[];
    private char f[];
    private char g[];
    private char h[];
    private char i[];
    private char j[];
    private char k[];
    private CreditCardType l;
    private HashMap m;

    public NetswipeCardInformation()
    {
        a = false;
        l = CreditCardType.UNKNOWN;
        m = new HashMap();
    }

    public NetswipeCardInformation(Parcel parcel)
    {
        a = false;
        l = CreditCardType.UNKNOWN;
        m = new HashMap();
        b = new char[parcel.readInt()];
        parcel.readCharArray(b);
        c = new char[parcel.readInt()];
        parcel.readCharArray(c);
        h = new char[parcel.readInt()];
        parcel.readCharArray(h);
        i = new char[parcel.readInt()];
        parcel.readCharArray(i);
        j = new char[parcel.readInt()];
        parcel.readCharArray(j);
        k = new char[parcel.readInt()];
        parcel.readCharArray(k);
        l = (CreditCardType)parcel.readSerializable();
        d = new char[parcel.readInt()];
        parcel.readCharArray(d);
        e = new char[parcel.readInt()];
        parcel.readCharArray(e);
        g = new char[parcel.readInt()];
        parcel.readCharArray(g);
        m = (HashMap)parcel.readSerializable();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }

    public void clear()
    {
        if (b != null)
        {
            Arrays.fill(b, '\0');
            b = null;
        }
        if (c != null)
        {
            Arrays.fill(c, '\0');
            c = null;
        }
        if (h != null)
        {
            Arrays.fill(h, '\0');
            h = null;
        }
        if (i != null)
        {
            Arrays.fill(i, '\0');
            i = null;
        }
        if (j != null)
        {
            Arrays.fill(j, '\0');
            j = null;
        }
        if (k != null)
        {
            Arrays.fill(k, '\0');
            k = null;
        }
        if (d != null)
        {
            Arrays.fill(d, '\0');
            d = null;
        }
        if (e != null)
        {
            Arrays.fill(e, '\0');
            e = null;
        }
        if (f != null)
        {
            Arrays.fill(f, '\0');
            f = null;
        }
        if (g != null)
        {
            Arrays.fill(g, '\0');
            g = null;
        }
        l = CreditCardType.UNKNOWN;
    }

    public int describeContents()
    {
        return 0;
    }

    public char[] getAccountNumber()
    {
        if (k == null)
        {
            return new char[0];
        } else
        {
            return k;
        }
    }

    public char[] getCardHolderName()
    {
        if (h == null)
        {
            return new char[0];
        } else
        {
            return h;
        }
    }

    public char[] getCardNumber()
    {
        if (b == null)
        {
            return new char[0];
        } else
        {
            return b;
        }
    }

    public char[] getCardNumberGrouped()
    {
        if (c == null)
        {
            return new char[0];
        } else
        {
            return c;
        }
    }

    public CreditCardType getCardType()
    {
        return l;
    }

    public String getCustomField(String s)
    {
        return (String)m.get(s);
    }

    public char[] getCvvCode()
    {
        if (g == null)
        {
            return new char[0];
        } else
        {
            return g;
        }
    }

    public char[] getExpiryDate()
    {
        if (getExpiryDateMonth().length == 0 || getExpiryDateYear().length == 0)
        {
            return new char[0];
        }
        if (f == null)
        {
            f = new char[5];
        }
        System.arraycopy(getExpiryDateMonth(), 0, f, 0, getExpiryDateMonth().length);
        f[2] = '/';
        System.arraycopy(getExpiryDateYear(), 0, f, 3, getExpiryDateYear().length);
        return f;
    }

    public char[] getExpiryDateMonth()
    {
        if (d == null)
        {
            return new char[0];
        } else
        {
            return d;
        }
    }

    public char[] getExpiryDateYear()
    {
        if (e == null)
        {
            return new char[0];
        } else
        {
            return e;
        }
    }

    public char[] getSortCode()
    {
        if (j == null)
        {
            return new char[0];
        } else
        {
            return j;
        }
    }

    public boolean isCardNumberManuallyEntered()
    {
        return a;
    }

    public boolean isCleared()
    {
        return b == null || b.length == 0;
    }

    public void setAccountNumber(StringBuilder stringbuilder)
    {
        if (k != null)
        {
            Arrays.fill(k, '\0');
        }
        k = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), k, 0);
    }

    public void setAccoutNumber(char ac[])
    {
        if (k != null)
        {
            Arrays.fill(k, '\0');
        }
        k = Arrays.copyOf(ac, ac.length);
    }

    public void setCardHolderName(StringBuilder stringbuilder)
    {
        if (h != null)
        {
            Arrays.fill(h, '\0');
        }
        h = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), h, 0);
    }

    public void setCardHolderName(char ac[])
    {
        if (h != null)
        {
            Arrays.fill(h, '\0');
        }
        h = Arrays.copyOf(ac, ac.length);
    }

    public void setCardNumber(StringBuilder stringbuilder)
    {
        if (b != null)
        {
            Arrays.fill(b, '\0');
        }
        b = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), b, 0);
        l = cw.b(stringbuilder);
        stringbuilder = cw.a(stringbuilder, l);
        c = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), c, 0);
    }

    public void setCardNumberManuallyEntered(boolean flag)
    {
        a = flag;
    }

    public void setCustomField(String s, String s1)
    {
        m.put(s, s1);
    }

    public void setCvvCode(char ac[])
    {
        if (g != null)
        {
            Arrays.fill(g, '\0');
        }
        g = ac;
    }

    public void setExpiryDateMonth(StringBuilder stringbuilder)
    {
        if (d != null)
        {
            Arrays.fill(d, '\0');
        }
        d = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), d, 0);
    }

    public void setExpiryDateMonth(char ac[])
    {
        if (d != null)
        {
            Arrays.fill(d, '\0');
        }
        d = Arrays.copyOf(ac, ac.length);
    }

    public void setExpiryDateYear(StringBuilder stringbuilder)
    {
        if (e != null)
        {
            Arrays.fill(e, '\0');
        }
        e = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), e, 0);
    }

    public void setExpiryDateYear(char ac[])
    {
        if (e != null)
        {
            Arrays.fill(e, '\0');
        }
        e = Arrays.copyOf(ac, ac.length);
    }

    public void setSortCode(StringBuilder stringbuilder)
    {
        if (j != null)
        {
            Arrays.fill(j, '\0');
        }
        j = new char[stringbuilder.length()];
        stringbuilder.getChars(0, stringbuilder.length(), j, 0);
    }

    public void setSortCode(char ac[])
    {
        if (j != null)
        {
            Arrays.fill(j, '\0');
        }
        j = Arrays.copyOf(ac, ac.length);
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        boolean flag = false;
        char ac[];
        if (b != null)
        {
            i1 = b.length;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (b != null)
        {
            ac = b;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        if (c != null)
        {
            i1 = c.length;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (c != null)
        {
            ac = c;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        if (h != null)
        {
            i1 = h.length;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (h != null)
        {
            ac = h;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        if (i != null)
        {
            i1 = i.length;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (i != null)
        {
            ac = i;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        if (j != null)
        {
            i1 = j.length;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (j != null)
        {
            ac = j;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        if (k != null)
        {
            i1 = k.length;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (k != null)
        {
            ac = k;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        parcel.writeSerializable(l);
        if (d != null)
        {
            i1 = d.length;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (d != null)
        {
            ac = d;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        if (e != null)
        {
            i1 = e.length;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (e != null)
        {
            ac = e;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        if (g != null)
        {
            i1 = g.length;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (g != null)
        {
            ac = g;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        parcel.writeSerializable(m);
        i1 = ((flag) ? 1 : 0);
        if (a)
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
    }

}
