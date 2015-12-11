// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.ib;
import com.google.android.gms.internal.id;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.model.moments:
//            ItemScope

public interface Moment
    extends Freezable
{
    public static class Builder
    {

        private String AI;
        private final Set Eq = new HashSet();
        private String Fe;
        private ib Fm;
        private ib Fn;
        private String uS;

        public Moment build()
        {
            return new id(Eq, uS, Fm, Fe, Fn, AI);
        }

        public Builder setId(String s)
        {
            uS = s;
            Eq.add(Integer.valueOf(2));
            return this;
        }

        public Builder setResult(ItemScope itemscope)
        {
            Fm = (ib)itemscope;
            Eq.add(Integer.valueOf(4));
            return this;
        }

        public Builder setStartDate(String s)
        {
            Fe = s;
            Eq.add(Integer.valueOf(5));
            return this;
        }

        public Builder setTarget(ItemScope itemscope)
        {
            Fn = (ib)itemscope;
            Eq.add(Integer.valueOf(6));
            return this;
        }

        public Builder setType(String s)
        {
            AI = s;
            Eq.add(Integer.valueOf(7));
            return this;
        }

        public Builder()
        {
        }
    }


    public abstract String getId();

    public abstract ItemScope getResult();

    public abstract String getStartDate();

    public abstract ItemScope getTarget();

    public abstract String getType();

    public abstract boolean hasId();

    public abstract boolean hasResult();

    public abstract boolean hasStartDate();

    public abstract boolean hasTarget();

    public abstract boolean hasType();
}
