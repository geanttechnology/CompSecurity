// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;


public interface SwitchInterface
{

    public abstract boolean isChecked();

    public abstract void setChecked(boolean flag);

    public abstract void setEnabled(boolean flag);

    public abstract void setOnCheckedChangeListener(android.widget.CompoundButton.OnCheckedChangeListener oncheckedchangelistener);
}
