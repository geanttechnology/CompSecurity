// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


// Referenced classes of package com.poshmark.data_model.models:
//            UserStateSummary

public class this._cls0
{

    public size_available ab_segment;
    public String size_available;
    final UserStateSummary this$0;

    public String getAbSegment()
    {
        if (ab_segment != null)
        {
            return ab_segment.ign_up;
        } else
        {
            return null;
        }
    }

    public boolean isMySizeAvailable()
    {
        return size_available != null && !size_available.equals("none");
    }

    public ()
    {
        this$0 = UserStateSummary.this;
        super();
    }
}
