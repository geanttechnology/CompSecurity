// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;


// Referenced classes of package com.groupon.view:
//            PlaceholderUrlImageView

private class imageUrl
    implements Runnable
{

    private final String imageUrl;
    final PlaceholderUrlImageView this$0;

    public void run()
    {
        PlaceholderUrlImageView.access$002(PlaceholderUrlImageView.this, getMeasuredWidth());
        PlaceholderUrlImageView.access$102(PlaceholderUrlImageView.this, getMeasuredHeight());
        PlaceholderUrlImageView.access$200(PlaceholderUrlImageView.this, imageUrl);
    }

    public Q(String s)
    {
        this$0 = PlaceholderUrlImageView.this;
        super();
        imageUrl = s;
    }
}
