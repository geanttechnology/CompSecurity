// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.util;


public interface AndroidCallableI
{

    public abstract Object doInBackground()
        throws Exception;

    public abstract void onException(Exception exception);

    public abstract void onFinally();

    public abstract void onPreCall()
        throws Exception;

    public abstract void onSuccess(Object obj);
}
