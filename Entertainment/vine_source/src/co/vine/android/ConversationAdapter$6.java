// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;


// Referenced classes of package co.vine.android:
//            ConversationAdapter

class this._cls0
    implements Runnable
{

    final ConversationAdapter this$0;

    public void run()
    {
        if (ConversationAdapter.access$900(ConversationAdapter.this) != null && ConversationAdapter.access$1000(ConversationAdapter.this) != null)
        {
            (new urRunnable(ConversationAdapter.this, ConversationAdapter.access$1000(ConversationAdapter.this), ConversationAdapter.access$900(ConversationAdapter.this))).run();
        }
    }

    urRunnable()
    {
        this$0 = ConversationAdapter.this;
        super();
    }
}
