// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.ebay.mobile.activities.BaseDialogFragment;

public class SubjectDialogFragment extends BaseDialogFragment
    implements android.content.DialogInterface.OnClickListener, android.widget.AdapterView.OnItemClickListener
{
    public static interface OnSubjectSelectedObserver
    {

        public abstract void onSubjectSelected(int i);
    }


    private ListView subjectList;

    public SubjectDialogFragment()
    {
    }

    public static SubjectDialogFragment createInstance(Fragment fragment, int i)
    {
        SubjectDialogFragment subjectdialogfragment = new SubjectDialogFragment();
        subjectdialogfragment.setTargetFragment(fragment, i);
        return subjectdialogfragment;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(0, 0);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = LayoutInflater.from(getActivity()).inflate(0x7f030160, null);
        subjectList = (ListView)bundle.findViewById(0x7f100398);
        ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x7f030217, 0x1020014, getActivity().getResources().getStringArray(0x7f0e000b));
        subjectList.setAdapter(arrayadapter);
        subjectList.setOnItemClickListener(this);
        return (new android.support.v7.app.AlertDialog.Builder(getActivity())).setTitle(0x7f070619).setView(bundle).setCancelable(true).setNegativeButton(0x7f0701cc, this).create();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        try
        {
            if (!(getTargetFragment() instanceof OnSubjectSelectedObserver))
            {
                throw new RuntimeException("Calling Fragment Should Implement  OnSubjectSelectedObserver");
            }
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            adapterview.printStackTrace();
        }
        dismiss();
        ((OnSubjectSelectedObserver)getTargetFragment()).onSubjectSelected(i);
    }
}
