// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.tape;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.squareup.tape:
//            ObjectQueue, QueueFile, FileException

public class FileObjectQueue
    implements ObjectQueue
{
    public static interface Converter
    {

        public abstract Object from(byte abyte0[])
            throws IOException;

        public abstract void toStream(Object obj, OutputStream outputstream)
            throws IOException;
    }

    private static class DirectByteArrayOutputStream extends ByteArrayOutputStream
    {

        public byte[] getArray()
        {
            return buf;
        }

        public DirectByteArrayOutputStream()
        {
        }
    }


    private final DirectByteArrayOutputStream bytes = new DirectByteArrayOutputStream();
    private final Converter converter;
    private final File file;
    private ObjectQueue.Listener listener;
    private final QueueFile queueFile;

    public FileObjectQueue(File file1, Converter converter1)
        throws IOException
    {
        file = file1;
        converter = converter1;
        queueFile = new QueueFile(file1);
    }

    public final void add(Object obj)
    {
        try
        {
            bytes.reset();
            converter.toStream(obj, bytes);
            queueFile.add(bytes.getArray(), 0, bytes.size());
            if (listener != null)
            {
                listener.onAdd(this, obj);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new FileException("Failed to add entry.", ((IOException) (obj)), file);
        }
    }

    public Object peek()
    {
        byte abyte0[];
        Object obj;
        try
        {
            abyte0 = queueFile.peek();
        }
        catch (IOException ioexception)
        {
            throw new FileException("Failed to peek.", ioexception, file);
        }
        if (abyte0 == null)
        {
            return null;
        }
        obj = converter.from(abyte0);
        return obj;
    }

    public final void remove()
    {
        try
        {
            queueFile.remove();
            if (listener != null)
            {
                listener.onRemove(this);
            }
            return;
        }
        catch (IOException ioexception)
        {
            throw new FileException("Failed to remove.", ioexception, file);
        }
    }

    public void setListener(final ObjectQueue.Listener listener)
    {
        if (listener != null)
        {
            try
            {
                queueFile.forEach(new QueueFile.ElementReader() {

                    final FileObjectQueue this$0;
                    final ObjectQueue.Listener val$listener;

                    public void read(InputStream inputstream, int i)
                        throws IOException
                    {
                        byte abyte0[] = new byte[i];
                        inputstream.read(abyte0, 0, i);
                        listener.onAdd(FileObjectQueue.this, converter.from(abyte0));
                    }

            
            {
                this$0 = FileObjectQueue.this;
                listener = listener1;
                super();
            }
                });
            }
            // Misplaced declaration of an exception variable
            catch (final ObjectQueue.Listener listener)
            {
                throw new FileException("Unable to iterate over QueueFile contents.", listener, file);
            }
        }
        this.listener = listener;
    }

    public int size()
    {
        return queueFile.size();
    }

}
