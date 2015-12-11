// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public abstract class vy extends DialogFragment
{

    public TextView a;
    public TextView b;
    public FrameLayout c;
    public TextView d;
    public TextView e;
    private android.view.View.OnTouchListener f;

    public vy()
    {
        f = new vz(this);
    }

    protected abstract void a();

    protected boolean b()
    {
        return true;
    }

    protected boolean c()
    {
        return true;
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new android.app.AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(0x7f04001e, null);
        bundle.setView(view);
        a = (TextView)view.findViewById(0x7f100072);
        b = (TextView)view.findViewById(0x7f1000ac);
        c = (FrameLayout)view.findViewById(0x7f1000ad);
        d = (TextView)view.findViewById(0x7f1000b0);
        e = (TextView)view.findViewById(0x7f1000af);
        d.setOnClickListener(new wa(this));
        d.setOnTouchListener(f);
        e.setOnClickListener(new wb(this));
        e.setOnTouchListener(f);
        a();
        return bundle.create();
    }
}
