// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MultipartInputStream extends InputStream
{

    private InputStream mCurrStream;
    private final ArrayList mEntities;
    private int mNextEntity;

    public MultipartInputStream(ArrayList arraylist)
    {
        mEntities = arraylist;
        mNextEntity = 0;
    }

    public void close()
        throws IOException
    {
        if (mCurrStream != null)
        {
            mCurrStream.close();
            mCurrStream = null;
        }
    }

    public int read()
        throws IOException
    {
        byte abyte0[] = new byte[1];
        if (read(abyte0, 0, 1) == 1)
        {
            return abyte0[0];
        } else
        {
            return -1;
        }
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        int l = 0;
        int i1 = mNextEntity;
        InputStream inputstream = mCurrStream;
        do
        {
            InputStream inputstream1;
            int k;
label0:
            {
                int j1 = l;
                if (l < j)
                {
                    k = l;
                    inputstream1 = inputstream;
                    if (inputstream == null)
                    {
                        inputstream1 = ((MultipartEntity.Entity)mEntities.get(i1)).getInputStream();
                        mCurrStream = inputstream1;
                        k = l;
                    }
                    do
                    {
                        l = inputstream1.read(abyte0, i + k, j - k);
                        if (l == -1)
                        {
                            break;
                        }
                        k += l;
                    } while (true);
                    j1 = k;
                    if (k != j)
                    {
                        if (i1 != mEntities.size() - 1)
                        {
                            break label0;
                        }
                        j1 = k;
                    }
                }
                return j1;
            }
            i1++;
            mNextEntity = i1;
            inputstream1.close();
            inputstream = null;
            mCurrStream = null;
            l = k;
        } while (true);
    }
}
