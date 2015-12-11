// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

// Referenced classes of package android.support.v7:
//            afe, agp, afl, afa, 
//            afc, afi, afb

public final class agb
{
    private static final class a extends Writer
    {

        private final Appendable a;
        private final a b;

        public void close()
        {
        }

        public void flush()
        {
        }

        public void write(int i)
            throws IOException
        {
            a.append((char)i);
        }

        public void write(char ac[], int i, int j)
            throws IOException
        {
            b.a = ac;
            a.append(b, i, i + j);
        }

        private a(Appendable appendable)
        {
            b = new a();
            a = appendable;
        }

    }

    static class a.a
        implements CharSequence
    {

        char a[];

        public char charAt(int i)
        {
            return a[i];
        }

        public int length()
        {
            return a.length;
        }

        public CharSequence subSequence(int i, int j)
        {
            return new String(a, i, j - i);
        }

        a.a()
        {
        }
    }


    public static afa a(JsonReader jsonreader)
        throws afe
    {
        boolean flag = true;
        try
        {
            jsonreader.peek();
        }
        // Misplaced declaration of an exception variable
        catch (JsonReader jsonreader)
        {
            if (flag)
            {
                return afc.a;
            } else
            {
                throw new afi(jsonreader);
            }
        }
        // Misplaced declaration of an exception variable
        catch (JsonReader jsonreader)
        {
            throw new afi(jsonreader);
        }
        // Misplaced declaration of an exception variable
        catch (JsonReader jsonreader)
        {
            throw new afb(jsonreader);
        }
        // Misplaced declaration of an exception variable
        catch (JsonReader jsonreader)
        {
            throw new afi(jsonreader);
        }
        flag = false;
        jsonreader = (afa)agp.P.b(jsonreader);
        return jsonreader;
    }

    public static Writer a(Appendable appendable)
    {
        if (appendable instanceof Writer)
        {
            return (Writer)appendable;
        } else
        {
            return new a(appendable);
        }
    }

    public static void a(afa afa1, JsonWriter jsonwriter)
        throws IOException
    {
        agp.P.a(jsonwriter, afa1);
    }
}
