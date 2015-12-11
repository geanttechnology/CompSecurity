// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            cy, am, fl

class gr
{

    private static final String p = com/flurry/android/gr.getSimpleName();
    private boolean iZ;
    private List ja;
    private long jb;

    gr()
    {
        jb = -1L;
    }

    private static String M(String s)
    {
        Object obj = s;
        if (s != null)
        {
            obj = s;
            if (s.length() > 4)
            {
                obj = new StringBuilder();
                for (int j = 0; j < s.length() - 4; j++)
                {
                    ((StringBuilder) (obj)).append('*');
                }

                ((StringBuilder) (obj)).append(s.substring(s.length() - 4));
                obj = ((StringBuilder) (obj)).toString();
            }
        }
        return ((String) (obj));
    }

    private boolean a(String s, DataInputStream datainputstream)
        throws IOException
    {
        int j = datainputstream.readUnsignedShort();
        cy.c(p, (new StringBuilder()).append("File version: ").append(j).toString());
        if (j > 2)
        {
            cy.d(p, (new StringBuilder()).append("Unknown agent file version: ").append(j).toString());
            throw new IOException((new StringBuilder()).append("Unknown agent file version: ").append(j).toString());
        }
        if (j >= 2)
        {
            Object obj = datainputstream.readUTF();
            cy.c(p, (new StringBuilder()).append("Loading API key: ").append(M(s)).toString());
            if (((String) (obj)).equals(s))
            {
                s = new ArrayList();
                datainputstream.readUTF();
                boolean flag = datainputstream.readBoolean();
                long l1 = datainputstream.readLong();
                cy.c(p, "Loading session reports");
                j = 0;
                do
                {
                    int l = datainputstream.readUnsignedShort();
                    if (l != 0)
                    {
                        obj = new byte[l];
                        datainputstream.readFully(((byte []) (obj)));
                        s.add(0, new am(((byte []) (obj))));
                        obj = p;
                        StringBuilder stringbuilder = (new StringBuilder()).append("Session report added: ");
                        j++;
                        cy.c(((String) (obj)), stringbuilder.append(j).toString());
                    } else
                    {
                        cy.c(p, "Persistent file loaded");
                        iZ = flag;
                        jb = l1;
                        ja = s;
                        return true;
                    }
                } while (true);
            } else
            {
                cy.c(p, (new StringBuilder()).append("Api keys do not match, old: ").append(M(s)).append(", new: ").append(M(((String) (obj)))).toString());
                return false;
            }
        } else
        {
            cy.g(p, (new StringBuilder()).append("Deleting old file version: ").append(j).toString());
            return false;
        }
    }

    public final void a(DataOutputStream dataoutputstream, String s, String s1)
        throws IOException
    {
        int j;
        dataoutputstream.writeShort(46586);
        dataoutputstream.writeShort(2);
        dataoutputstream.writeUTF(s);
        dataoutputstream.writeUTF(s1);
        dataoutputstream.writeBoolean(iZ);
        dataoutputstream.writeLong(jb);
        j = ja.size() - 1;
_L2:
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        int l;
        s = ((am)ja.get(j)).N();
        l = s.length;
        if (l + 2 + dataoutputstream.size() <= 50000)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        cy.d(p, (new StringBuilder()).append("discarded sessions: ").append(j).toString());
        dataoutputstream.writeShort(0);
        fl.a(dataoutputstream);
        return;
        dataoutputstream.writeShort(l);
        dataoutputstream.write(s);
        j--;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        cy.b(p, "", s);
        throw new IOException(s.getMessage());
        s;
        fl.a(dataoutputstream);
        throw s;
    }

    public final boolean a(DataInputStream datainputstream, String s)
        throws IOException
    {
        boolean flag = false;
        int j;
        j = datainputstream.readUnsignedShort();
        cy.e(p, (new StringBuilder()).append("Magic: ").append(j).toString());
        if (j != 46586) goto _L2; else goto _L1
_L1:
        flag = a(s, datainputstream);
_L4:
        fl.a(datainputstream);
        return flag;
_L2:
        cy.c(p, "Unexpected file type");
        if (true) goto _L4; else goto _L3
_L3:
        s;
        cy.b(p, "Error when loading persistent file", s);
        throw new IOException(s.getMessage());
        s;
        fl.a(datainputstream);
        throw s;
    }

    public final void b(boolean flag)
    {
        iZ = flag;
    }

    public final boolean bP()
    {
        return iZ;
    }

    public final List bQ()
    {
        return ja;
    }

    public final long bR()
    {
        return jb;
    }

    public final void i(long l)
    {
        jb = l;
    }

    public final void k(List list)
    {
        ja = list;
    }

}
