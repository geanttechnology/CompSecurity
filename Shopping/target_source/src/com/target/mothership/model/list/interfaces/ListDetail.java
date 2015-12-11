// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list.interfaces;

import android.os.Parcelable;
import java.util.List;

// Referenced classes of package com.target.mothership.model.list.interfaces:
//            ListSummary

public interface ListDetail
    extends Parcelable, ListSummary
{

    public abstract List getListItems();
}
