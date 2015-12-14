// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;

import aeh;
import aei;
import aej;
import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import aro;
import java.io.PrintStream;

public class PinQueryFragment extends DialogFragment
    implements android.view.View.OnClickListener
{

    String a;
    String b;
    String c;
    String d;
    TextView e;
    TextView f;
    Button g;
    private aro h;
    private PinStatus i;

    public PinQueryFragment()
    {
        a = "1234";
        b = "";
        c = "";
        d = "";
        g = null;
        i = PinStatus.Status_Query;
    }

    private String a()
    {
        return getActivity().getSharedPreferences("PinQueryFragmentSetting", 0).getString("PinCode", "");
    }

    private void a(View view)
    {
        e = (TextView)view.findViewById(aeh.pwdinput);
        f = (TextView)view.findViewById(aeh.passwrodNote);
        view.findViewById(aeh.Button00).setOnClickListener(this);
        view.findViewById(aeh.button01).setOnClickListener(this);
        view.findViewById(aeh.button02).setOnClickListener(this);
        view.findViewById(aeh.button03).setOnClickListener(this);
        view.findViewById(aeh.Button04).setOnClickListener(this);
        view.findViewById(aeh.Button05).setOnClickListener(this);
        view.findViewById(aeh.Button06).setOnClickListener(this);
        view.findViewById(aeh.Button07).setOnClickListener(this);
        view.findViewById(aeh.Button08).setOnClickListener(this);
        view.findViewById(aeh.Button09).setOnClickListener(this);
        g = (Button)view.findViewById(aeh.ButtonBackSpace);
        g.setOnClickListener(this);
        a = a();
        if (a != null && a.length() > 0)
        {
            i = PinStatus.Status_Query;
            a = a();
        } else
        {
            i = PinStatus.Status_Create_First;
        }
        a(i);
    }

    private void a(PinStatus pinstatus)
    {
        i = pinstatus;
        if (PinStatus.Status_Query != i) goto _L2; else goto _L1
_L1:
        b = "";
        e.setText(b);
        f.setText(aej.enter_your_passcode);
_L4:
        return;
_L2:
        if (PinStatus.Status_Create_Second != i)
        {
            continue; /* Loop/switch isn't completed */
        }
        b = "";
        e.setText(b);
        f.setText(aej.reenter_your_passcode);
        if (c != null && c.length() == 5) goto _L4; else goto _L3
_L3:
        Log.e("PinQueryFragment", "null first input");
        return;
        if (PinStatus.Status_Create_First != i) goto _L4; else goto _L5
_L5:
        b = "";
        e.setText(b);
        f.setText(aej.enter_your_passcode);
        return;
    }

    private void a(String s)
    {
        getActivity().getSharedPreferences("PinQueryFragmentSetting", 0).edit().putString("PinCode", s).apply();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        System.out.println("Fragment-->onAttach");
        try
        {
            h = (aro)activity;
        }
        catch (ClassCastException classcastexception)
        {
            Log.e("PinQueryFragment", (new StringBuilder()).append("must implement PinQueryCallback").append(activity.getClass()).toString());
            throw new ClassCastException("activity must implement PinQueryCallback");
        }
        setCancelable(false);
    }

    public void onClick(View view)
    {
        view = (String)view.getTag();
        if (view.length() != 1) goto _L2; else goto _L1
_L1:
        if (b.length() <= 5) goto _L4; else goto _L3
_L3:
        return;
_L4:
        b = (new StringBuilder()).append(b).append(view).toString();
_L6:
        e.setText(b);
        if (PinStatus.Status_Query == i)
        {
            if (a.compareTo(b) == 0)
            {
                h.a();
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (PinStatus.Status_Create_Second != i)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (b.length() >= 5 && c.compareTo(b) == 0)
        {
            h.a();
            a(b);
            a(PinStatus.Status_Invalid);
            Toast.makeText(getActivity(), getActivity().getResources().getString(aej.passcode_set), 0).show();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (view.compareTo("backspace") != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (b.length() == 0) goto _L3; else goto _L5
_L5:
        b = b.substring(0, b.length() - 1);
          goto _L6
        if (view.compareTo("cancel") != 0) goto _L6; else goto _L7
_L7:
        if (h == null) goto _L3; else goto _L8
_L8:
        h.b();
        return;
        if (b.length() != 5 || a.compareTo(b) == 0) goto _L3; else goto _L9
_L9:
        Toast.makeText(getActivity(), getActivity().getResources().getString(aej.wrong_passcode), 0).show();
        b = "";
        e.setText(b);
        return;
        if (b.length() < 5 || c.compareTo(b) == 0) goto _L3; else goto _L10
_L10:
        Toast.makeText(getActivity(), getActivity().getResources().getString(aej.passcode_try_again), 0).show();
        a(PinStatus.Status_Create_First);
        return;
        if (PinStatus.Status_Create_First != i || b.length() < 5) goto _L3; else goto _L11
_L11:
        c = b;
        a(PinStatus.Status_Create_Second);
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(aei.view_fullscreenpinquery, viewgroup, false);
        a(layoutinflater);
        getDialog().setTitle(getActivity().getResources().getString(aej.passcode_title));
        return layoutinflater;
    }

    private class PinStatus extends Enum
    {

        private static final PinStatus $VALUES[];
        public static final PinStatus Status_Create_First;
        public static final PinStatus Status_Create_Second;
        public static final PinStatus Status_Invalid;
        public static final PinStatus Status_Query;

        public static PinStatus valueOf(String s)
        {
            return (PinStatus)Enum.valueOf(com/fotoable/photoselector/PinQueryFragment$PinStatus, s);
        }

        public static PinStatus[] values()
        {
            return (PinStatus[])$VALUES.clone();
        }

        static 
        {
            Status_Create_First = new PinStatus("Status_Create_First", 0);
            Status_Create_Second = new PinStatus("Status_Create_Second", 1);
            Status_Query = new PinStatus("Status_Query", 2);
            Status_Invalid = new PinStatus("Status_Invalid", 3);
            $VALUES = (new PinStatus[] {
                Status_Create_First, Status_Create_Second, Status_Query, Status_Invalid
            });
        }

        private PinStatus(String s, int j)
        {
            super(s, j);
        }
    }

}
