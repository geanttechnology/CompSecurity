// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.drm;


// Referenced classes of package shared_presage.com.google.android.exoplayer.drm:
//            StreamingDrmSessionManager

final class a
    implements Runnable
{

    final Exception a;
    final StreamingDrmSessionManager b;

    a(StreamingDrmSessionManager streamingdrmsessionmanager, Exception exception)
    {
        b = streamingdrmsessionmanager;
        a = exception;
        super();
    }

    public final void run()
    {
        StreamingDrmSessionManager.access$100(b).onDrmSessionManagerError(a);
    }
}
