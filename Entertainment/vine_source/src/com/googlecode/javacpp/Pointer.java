// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

// Referenced classes of package com.googlecode.javacpp:
//            Loader, BytePointer

public class Pointer
{
    protected static class CustomDeallocator extends DeallocatorReference
        implements Deallocator
    {

        Method method;
        Pointer pointer;

        public void deallocate()
        {
            try
            {
                method.invoke(null, new Object[] {
                    pointer
                });
                pointer.setNull();
                return;
            }
            catch (Exception exception)
            {
                throw new RuntimeException(exception);
            }
        }

        public CustomDeallocator(Pointer pointer1)
        {
            super(pointer1, null);
            pointer = null;
            method = null;
            deallocator = this;
            Object obj = pointer1.getClass();
            Method amethod[] = ((Class) (obj)).getDeclaredMethods();
            int j = amethod.length;
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (i < j)
                    {
                        Method method1 = amethod[i];
                        Class aclass[] = method1.getParameterTypes();
                        if (!Modifier.isStatic(method1.getModifiers()) || !method1.getReturnType().equals(Void.TYPE) || !method1.getName().equals("deallocate") || aclass.length != 1 || !com/googlecode/javacpp/Pointer.isAssignableFrom(aclass[0]))
                        {
                            break label1;
                        }
                        method1.setAccessible(true);
                        method = method1;
                    }
                    if (method == null)
                    {
                        throw new RuntimeException(new NoSuchMethodException((new StringBuilder()).append("static void ").append(((Class) (obj)).getCanonicalName()).append(".deallocate(").append(com/googlecode/javacpp/Pointer.getCanonicalName()).append(")").toString()));
                    }
                    break label0;
                }
                i++;
            } while (true);
            try
            {
                obj = ((Class) (obj)).getConstructor(new Class[] {
                    com/googlecode/javacpp/Pointer
                });
                ((Constructor) (obj)).setAccessible(true);
                pointer = (Pointer)((Constructor) (obj)).newInstance(new Object[] {
                    pointer1
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Pointer pointer1)
            {
                throw new RuntimeException(pointer1);
            }
        }
    }

    protected static interface Deallocator
    {

        public abstract void deallocate();
    }

    private static class DeallocatorReference extends PhantomReference
    {

        static DeallocatorReference head = null;
        Deallocator deallocator;
        DeallocatorReference next;
        DeallocatorReference prev;

        final void add()
        {
            com/googlecode/javacpp/Pointer$DeallocatorReference;
            JVM INSTR monitorenter ;
            if (head != null)
            {
                break MISSING_BLOCK_LABEL_17;
            }
            head = this;
_L2:
            com/googlecode/javacpp/Pointer$DeallocatorReference;
            JVM INSTR monitorexit ;
            return;
            next = head;
            DeallocatorReference deallocatorreference = next;
            head = this;
            deallocatorreference.prev = this;
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            com/googlecode/javacpp/Pointer$DeallocatorReference;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void clear()
        {
            super.clear();
            deallocator.deallocate();
        }

        final void remove()
        {
            com/googlecode/javacpp/Pointer$DeallocatorReference;
            JVM INSTR monitorenter ;
            if (prev != this || next != this)
            {
                break MISSING_BLOCK_LABEL_23;
            }
            com/googlecode/javacpp/Pointer$DeallocatorReference;
            JVM INSTR monitorexit ;
            return;
            if (prev != null)
            {
                break MISSING_BLOCK_LABEL_75;
            }
            head = next;
_L1:
            if (next != null)
            {
                next.prev = prev;
            }
            next = this;
            prev = this;
            com/googlecode/javacpp/Pointer$DeallocatorReference;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            com/googlecode/javacpp/Pointer$DeallocatorReference;
            JVM INSTR monitorexit ;
            throw exception;
            prev.next = next;
              goto _L1
        }


        DeallocatorReference(Pointer pointer, Deallocator deallocator1)
        {
            super(pointer, Pointer.referenceQueue);
            prev = null;
            next = null;
            deallocator = deallocator1;
        }
    }

    protected static class NativeDeallocator extends DeallocatorReference
        implements Deallocator
    {

        private long allocatedAddress;
        private long deallocatorAddress;

        private native void deallocate(long l, long l1);

        public void deallocate()
        {
            if (allocatedAddress != 0L && deallocatorAddress != 0L)
            {
                deallocate(allocatedAddress, deallocatorAddress);
                deallocatorAddress = 0L;
                allocatedAddress = 0L;
            }
        }

        NativeDeallocator(Pointer pointer, long l)
        {
            super(pointer, null);
            deallocator = this;
            allocatedAddress = pointer.address;
            deallocatorAddress = l;
        }
    }


    private static final ReferenceQueue referenceQueue = new ReferenceQueue();
    protected long address;
    protected int capacity;
    private Deallocator deallocator;
    protected int limit;
    protected int position;

    public Pointer()
    {
        address = 0L;
        position = 0;
        limit = 0;
        capacity = 0;
        deallocator = null;
    }

    public Pointer(final Pointer p)
    {
        address = 0L;
        position = 0;
        limit = 0;
        capacity = 0;
        deallocator = null;
        if (p != null)
        {
            address = p.address;
            position = p.position;
            limit = p.limit;
            capacity = p.capacity;
            if (p.deallocator != null)
            {
                deallocator = new Deallocator() {

                    final Pointer this$0;
                    final Pointer val$p;

                    public void deallocate()
                    {
                        p.deallocate();
                    }

            
            {
                this$0 = Pointer.this;
                p = pointer1;
                super();
            }
                };
            }
        }
    }

    public Pointer(final Buffer b)
    {
        address = 0L;
        position = 0;
        limit = 0;
        capacity = 0;
        deallocator = null;
        if (b != null)
        {
            allocate(b);
        }
        if (!isNull())
        {
            position = b.position();
            limit = b.limit();
            capacity = b.capacity();
            deallocator = new Deallocator() {

                Buffer bb;
                final Pointer this$0;
                final Buffer val$b;

                public void deallocate()
                {
                    bb = null;
                }

            
            {
                this$0 = Pointer.this;
                b = buffer;
                super();
                bb = b;
            }
            };
        }
    }

    private native void allocate(Buffer buffer);

    private native ByteBuffer asDirectBuffer();

    public static void deallocateReferences()
    {
        do
        {
            DeallocatorReference deallocatorreference = (DeallocatorReference)referenceQueue.poll();
            if (deallocatorreference != null)
            {
                deallocatorreference.clear();
                deallocatorreference.remove();
            } else
            {
                return;
            }
        } while (true);
    }

    public static native Pointer memchr(Pointer pointer, int i, long l);

    public static native int memcmp(Pointer pointer, Pointer pointer1, long l);

    public static native Pointer memcpy(Pointer pointer, Pointer pointer1, long l);

    public static native Pointer memmove(Pointer pointer, Pointer pointer1, long l);

    public static native Pointer memset(Pointer pointer, int i, long l);

    protected static Pointer withDeallocator(Pointer pointer)
    {
        return pointer.deallocator(new CustomDeallocator(pointer));
    }

    public Buffer asBuffer()
    {
        return asByteBuffer();
    }

    public ByteBuffer asByteBuffer()
    {
        if (isNull())
        {
            return null;
        }
        if (limit > 0 && limit < position)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("limit < position: (").append(limit).append(" < ").append(position).append(")").toString());
        }
        int k = sizeof();
        int l = position;
        int j = limit;
        position = k * l;
        ByteBuffer bytebuffer;
        int i;
        if (j <= 0)
        {
            i = l + 1;
        } else
        {
            i = j;
        }
        limit = i * k;
        bytebuffer = asDirectBuffer().order(ByteOrder.nativeOrder());
        position = l;
        limit = j;
        return bytebuffer;
    }

    public int capacity()
    {
        return capacity;
    }

    public Pointer capacity(int i)
    {
        limit = i;
        capacity = i;
        return this;
    }

    public void deallocate()
    {
        deallocator.deallocate();
        address = 0L;
    }

    protected Deallocator deallocator()
    {
        return deallocator;
    }

    protected Pointer deallocator(Deallocator deallocator1)
    {
        if (deallocator != null)
        {
            deallocator.deallocate();
            deallocator = null;
        }
        deallocateReferences();
        if (deallocator1 != null && !deallocator1.equals(null))
        {
            deallocator = deallocator1;
            if (deallocator1 instanceof DeallocatorReference)
            {
                deallocator1 = (DeallocatorReference)deallocator1;
            } else
            {
                deallocator1 = new DeallocatorReference(this, deallocator1);
            }
            deallocator1.add();
        }
        return this;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj == null)
            {
                return isNull();
            }
            if (obj.getClass() != getClass())
            {
                return false;
            }
            obj = (Pointer)obj;
            if (address != ((Pointer) (obj)).address || position != ((Pointer) (obj)).position)
            {
                return false;
            }
        }
        return true;
    }

    public Pointer fill(int i)
    {
        if (limit > 0 && limit < position)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("limit < position: (").append(limit).append(" < ").append(position).append(")").toString());
        }
        int k = sizeof();
        int j;
        if (limit <= 0)
        {
            j = 1;
        } else
        {
            j = limit - position;
        }
        position = position * k;
        memset(this, i, k * j);
        position = position / k;
        return this;
    }

    public int hashCode()
    {
        return (int)address;
    }

    void init(long l, int i, long l1)
    {
        address = l;
        position = 0;
        limit = i;
        capacity = i;
        deallocator(new NativeDeallocator(this, l1));
    }

    public boolean isNull()
    {
        return address == 0L;
    }

    public int limit()
    {
        return limit;
    }

    public Pointer limit(int i)
    {
        limit = i;
        return this;
    }

    public int offsetof(String s)
    {
        int i = -1;
        Class class1;
        try
        {
            class1 = getClass();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1;
        }
        if (class1 == com/googlecode/javacpp/Pointer)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        i = Loader.offsetof(class1, s);
        return i;
    }

    public int position()
    {
        return position;
    }

    public Pointer position(int i)
    {
        position = i;
        return this;
    }

    public Pointer put(Pointer pointer)
    {
        if (pointer.limit > 0 && pointer.limit < pointer.position)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("limit < position: (").append(pointer.limit).append(" < ").append(pointer.position).append(")").toString());
        }
        int j = sizeof();
        int k = pointer.sizeof();
        int i;
        if (pointer.limit <= 0)
        {
            i = 1;
        } else
        {
            i = pointer.limit - pointer.position;
        }
        position = position * j;
        pointer.position = pointer.position * k;
        memcpy(this, pointer, k * i);
        position = position / j;
        pointer.position = pointer.position / k;
        return this;
    }

    public void setNull()
    {
        address = 0L;
    }

    public int sizeof()
    {
        Class class1 = getClass();
        if (class1 == com/googlecode/javacpp/Pointer || class1 == com/googlecode/javacpp/BytePointer)
        {
            return 1;
        } else
        {
            return offsetof("sizeof");
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getName()).append("[address=0x").append(Long.toHexString(address)).append(",position=").append(position).append(",limit=").append(limit).append(",capacity=").append(capacity).append(",deallocator=").append(deallocator).append("]").toString();
    }

    public Pointer zero()
    {
        return fill(0);
    }


}
