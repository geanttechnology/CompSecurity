// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list.interfaces;

import android.os.Parcelable;
import com.target.mothership.common.c.b;
import java.util.Date;

// Referenced classes of package com.target.mothership.model.list.interfaces:
//            a

public interface ListSummary
    extends Parcelable, a
{

    public abstract b getChannel();

    public abstract String getDescription();

    public abstract String getGuestId();

    public abstract int getItemCount();

    public abstract Date getLastModifiedDate();

    public abstract String getLastModifiedUserId();

    public abstract long getListPosition();

    public abstract String getListToken();

    public abstract String getLocation();

    public abstract String getOrganization();

    public abstract Date getServerLastModifiedDate();

    public abstract String getTitle();

    public abstract String getTitleResourceId();

    public abstract boolean isDeleting();

    public abstract boolean isDirty();
}
