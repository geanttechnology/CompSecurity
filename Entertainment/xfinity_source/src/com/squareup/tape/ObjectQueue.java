// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.tape;


public interface ObjectQueue
{
    public static interface Listener
    {

        public abstract void onAdd(ObjectQueue objectqueue, Object obj);

        public abstract void onRemove(ObjectQueue objectqueue);
    }


    public abstract void add(Object obj);

    public abstract Object peek();

    public abstract void remove();

    public abstract void setListener(Listener listener);

    public abstract int size();
}
