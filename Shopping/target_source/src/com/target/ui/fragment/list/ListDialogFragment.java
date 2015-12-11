// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.f;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.util.o;
import com.target.ui.fragment.common.BaseDialogFragment;
import com.target.ui.helper.j.a;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.util.ai;
import com.target.ui.view.CustomErrorViewWrapper;
import java.util.Iterator;
import java.util.List;
import org.ocpsoft.prettytime.c;

public class ListDialogFragment extends BaseDialogFragment
    implements com.target.ui.helper.j.a.b, com.target.ui.helper.j.a.g
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a CREATE;
        public static final a EDIT;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/fragment/list/ListDialogFragment$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            EDIT = new a("EDIT", 0);
            CREATE = new a("CREATE", 1);
            $VALUES = (new a[] {
                EDIT, CREATE
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface b
    {

        public abstract void b();

        public abstract void c(ListCollectionItem listcollectionitem);

        public abstract void d(ListCollectionItem listcollectionitem);
    }

    private static class c
    {

        final Button cancelButton;
        private final TextView dialogTitleView;
        final CustomErrorViewWrapper errorEditTextWrapper;
        final View rootView;
        final Button saveButton;
        final EditText titleEditText;

        static TextView a(c c1)
        {
            return c1.dialogTitleView;
        }

        public c(View view)
        {
            rootView = view;
            dialogTitleView = (TextView)view.findViewById(0x7f1000e6);
            titleEditText = (EditText)view.findViewById(0x7f1000e8);
            errorEditTextWrapper = (CustomErrorViewWrapper)view.findViewById(0x7f1000e7);
            cancelButton = (Button)view.findViewById(0x7f1000e9);
            saveButton = (Button)view.findViewById(0x7f1000ea);
        }
    }


    private static final String ACTION = "action";
    public static final String LIST_COLLECTION_ITEM_KEY = "LIST_COLLECTION_ITEM_KEY";
    private a mAction;
    private ListCollectionItem mListCollectionItem;
    private b mListener;
    private c mViews;

    public ListDialogFragment()
    {
    }

    public static ListDialogFragment a(a a1, ListCollectionItem listcollectionitem, b b1)
    {
        ListDialogFragment listdialogfragment = new ListDialogFragment();
        if (b1 == null)
        {
            throw new IllegalStateException("Cannot set the listener parameter to null");
        }
        if (!(b1 instanceof Fragment))
        {
            throw new IllegalArgumentException("DeliveryActionListener must be an instance of Fragment");
        } else
        {
            listdialogfragment.setTargetFragment((Fragment)b1, 0);
            b1 = new Bundle();
            b1.putString("action", a1.toString());
            b1.putParcelable("LIST_COLLECTION_ITEM_KEY", listcollectionitem);
            listdialogfragment.setArguments(b1);
            return listdialogfragment;
        }
    }

    private void a()
    {
        Bundle bundle = getArguments();
        if (bundle != null)
        {
            mAction = a.valueOf(bundle.getString("action"));
            mListCollectionItem = (ListCollectionItem)bundle.getParcelable("LIST_COLLECTION_ITEM_KEY");
        }
    }

    private void a(final View rootView)
    {
        if (mListCollectionItem != null)
        {
            mViews.titleEditText.setText(mListCollectionItem.b());
        }
        mViews.titleEditText.requestFocus();
        mViews.titleEditText.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final ListDialogFragment this$0;
            final View val$rootView;

            public void onFocusChange(View view, boolean flag)
            {
                if (!flag)
                {
                    com.target.ui.fragment.list.ListDialogFragment.a(ListDialogFragment.this, rootView);
                    return;
                } else
                {
                    com.target.ui.fragment.list.ListDialogFragment.a(ListDialogFragment.this);
                    return;
                }
            }

            
            {
                this$0 = ListDialogFragment.this;
                rootView = view;
                super();
            }
        });
        mViews.titleEditText.addTextChangedListener(new TextWatcher() {

            final ListDialogFragment this$0;

            public void afterTextChanged(Editable editable)
            {
                com.target.ui.fragment.list.ListDialogFragment.a(ListDialogFragment.this);
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = ListDialogFragment.this;
                super();
            }
        });
    }

    static void a(ListDialogFragment listdialogfragment)
    {
        listdialogfragment.e();
    }

    static void a(ListDialogFragment listdialogfragment, com.target.ui.helper.j.a a1)
    {
        listdialogfragment.a(a1);
    }

    private void a(com.target.ui.helper.j.a a1)
    {
        ListSummary listsummary;
        if (mListCollectionItem != null)
        {
            if ((listsummary = mListCollectionItem.d()) != null)
            {
                a1.a(listsummary, mViews.titleEditText.getText().toString(), this);
                return;
            }
        }
    }

    private void a(String s)
    {
        s = String.format(getResources().getString(0x7f09038f), new Object[] {
            s
        });
        com.target.ui.util.a.a(getActivity().getApplicationContext(), getView(), s);
    }

    static boolean a(ListDialogFragment listdialogfragment, View view)
    {
        return listdialogfragment.b(view);
    }

    static b b(ListDialogFragment listdialogfragment)
    {
        return listdialogfragment.mListener;
    }

    private String b(com.target.mothership.model.list.interfaces.a.a a1)
    {
        Iterator iterator = a1.f().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if ((com.target.mothership.model.list.interfaces.a.a.a)iterator.next() == com.target.mothership.model.list.interfaces.a.a.a.ERROR_LIST_MAX_LIST_COUNT_EXCEEDED)
            {
                getString(0x7f0903a8);
            }
        } while (true);
        return a1.g();
    }

    private void b()
    {
        if (mAction == a.EDIT)
        {
            com.target.ui.fragment.list.c.a(mViews).setText(getActivity().getApplicationContext().getString(0x7f0902f1));
        }
    }

    static void b(ListDialogFragment listdialogfragment, com.target.ui.helper.j.a a1)
    {
        listdialogfragment.b(a1);
    }

    private void b(com.target.ui.helper.j.a a1)
    {
        String s = mViews.titleEditText.getText().toString();
        a(s);
        a1.a(s, null, null, null, this);
    }

    private boolean b(View view)
    {
        String s = mViews.titleEditText.getText().toString();
        if (o.c(s))
        {
            mViews.errorEditTextWrapper.setErrorState(view.getContext().getString(0x7f0903aa));
            return false;
        }
        if (s.trim().length() == 0)
        {
            mViews.errorEditTextWrapper.setErrorState(view.getContext().getString(0x7f0903ab));
            return false;
        } else
        {
            return true;
        }
    }

    static a c(ListDialogFragment listdialogfragment)
    {
        return listdialogfragment.mAction;
    }

    private void c()
    {
        mViews.cancelButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ListDialogFragment this$0;

            public void onClick(View view)
            {
                dismiss();
                ListDialogFragment.b(ListDialogFragment.this).b();
            }

            
            {
                this$0 = ListDialogFragment.this;
                super();
            }
        });
    }

    private void d()
    {
        mViews.saveButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ListDialogFragment this$0;

            public void onClick(View view)
            {
                if (!com.target.ui.fragment.list.ListDialogFragment.a(ListDialogFragment.this, view))
                {
                    return;
                }
                view = new com.target.ui.helper.j.a();
                static class _cls5
                {

                    static final int $SwitchMap$com$target$ui$fragment$list$ListDialogFragment$Action[];

                    static 
                    {
                        $SwitchMap$com$target$ui$fragment$list$ListDialogFragment$Action = new int[a.values().length];
                        try
                        {
                            $SwitchMap$com$target$ui$fragment$list$ListDialogFragment$Action[a.EDIT.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$target$ui$fragment$list$ListDialogFragment$Action[a.CREATE.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls5..SwitchMap.com.target.ui.fragment.list.ListDialogFragment.Action[com.target.ui.fragment.list.ListDialogFragment.c(ListDialogFragment.this).ordinal()])
                {
                default:
                    return;

                case 1: // '\001'
                    com.target.ui.fragment.list.ListDialogFragment.a(ListDialogFragment.this, view);
                    return;

                case 2: // '\002'
                    ListDialogFragment.b(ListDialogFragment.this, view);
                    break;
                }
            }

            
            {
                this$0 = ListDialogFragment.this;
                super();
            }
        });
    }

    private void e()
    {
        mViews.errorEditTextWrapper.b();
    }

    public void a(ListSummary listsummary)
    {
        listsummary = new ListCollectionItem(listsummary, getActivity());
        mListener.c(listsummary);
        dismiss();
    }

    public void a(com.target.mothership.model.list.interfaces.a.a a1)
    {
        ai.b(this, b(a1));
        dismiss();
    }

    public void b(ListSummary listsummary)
    {
        if (mListCollectionItem != null)
        {
            mListCollectionItem.a(listsummary.getTitle());
            mListCollectionItem.b(listsummary.getDescription());
            mListCollectionItem.c(listsummary.getLocation());
            mListCollectionItem.d(listsummary.getOrganization());
            mListCollectionItem.e((new org.ocpsoft.prettytime.c()).b(listsummary.getLastModifiedDate()));
            mListCollectionItem.a(listsummary);
            mListener.d(mListCollectionItem);
        }
        dismiss();
    }

    public void onAttach(Activity activity)
    {
        try
        {
            mListener = (b)getTargetFragment();
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new ClassCastException("Parent fragment must implement AddListListener");
        }
        if (mListener == null)
        {
            throw new IllegalStateException("Cannot set AddListListener's target fragment to null");
        } else
        {
            super.onAttach(activity);
            return;
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = super.onCreateDialog(bundle);
        bundle.getWindow().setSoftInputMode(4);
        a();
        return bundle;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03003c, viewgroup, false);
        mViews = new c(layoutinflater);
        a();
        b();
        a(layoutinflater);
        c();
        d();
        return layoutinflater;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }
}
