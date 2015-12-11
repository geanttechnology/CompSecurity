// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            SettingsFragment

class this._cls0 extends BaseAdapter
    implements SpinnerAdapter
{

    private Cursor mCursor;
    final SettingsFragment this$0;

    public void changeCursor(Cursor cursor)
    {
        mCursor = cursor;
        notifyDataSetChanged();
    }

    public int getCount()
    {
        if (mCursor != null)
        {
            return mCursor.getCount();
        } else
        {
            return 0;
        }
    }

    public Object getCursor()
    {
        return mCursor;
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        if (mCursor != null && i < mCursor.getCount())
        {
            if (view == null)
            {
                view = LayoutInflater.from(getActivity()).inflate(0x7f030092, null);
            }
            viewgroup = (TextView)view.findViewById(0x7f0a004a);
            viewgroup.setText(getEditionName(i));
            viewgroup.setSingleLine(false);
            view.invalidate();
            return view;
        } else
        {
            return view;
        }
    }

    public String getEditionCode(int i)
    {
        if (mCursor != null && i < mCursor.getCount())
        {
            mCursor.moveToPosition(i);
            return mCursor.getString(1);
        } else
        {
            return "";
        }
    }

    public String getEditionName(int i)
    {
        if (mCursor != null && i < mCursor.getCount())
        {
            mCursor.moveToPosition(i);
            return mCursor.getString(2);
        } else
        {
            return "";
        }
    }

    public Object getItem(int i)
    {
        return null;
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (mCursor != null && i < mCursor.getCount())
        {
            if (view == null)
            {
                view = LayoutInflater.from(getActivity()).inflate(0x7f030092, null);
            }
            viewgroup = (TextView)view.findViewById(0x7f0a004a);
            viewgroup.setText(getEditionName(i));
            viewgroup.setSingleLine(true);
            viewgroup.setEllipsize(android.text.er.getEditionName);
            return view;
        } else
        {
            return view;
        }
    }

    public void setSelectionToUserEdition()
    {
label0:
        {
            if (mCursor == null)
            {
                break label0;
            }
            mCursor.moveToPosition(-1);
            do
            {
                if (!mCursor.moveToNext())
                {
                    break label0;
                }
            } while (!mCursor.getString(1).equals(SettingsFragment.access$1200(SettingsFragment.this)));
            SettingsFragment.access$2700(SettingsFragment.this).setSelection(mCursor.getPosition());
        }
    }

    ()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
