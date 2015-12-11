// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            BaseFragment

public class BaseListFragment extends BaseFragment
{

    ListAdapter _adapter;
    CharSequence _emptyText;
    View _emptyView;
    private final Handler _handler = new Handler();
    ListView _list;
    View _listContainer;
    boolean _listShown;
    private final android.widget.AdapterView.OnItemClickListener _onClickListener = new android.widget.AdapterView.OnItemClickListener() {

        final BaseListFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            onListItemClick((ListView)adapterview, view, i, l);
        }

            
            {
                this$0 = BaseListFragment.this;
                super();
            }
    };
    View _progressContainer;
    private final Runnable _requestFocus = new Runnable() {

        final BaseListFragment this$0;

        public void run()
        {
            _list.focusableViewAvailable(_list);
        }

            
            {
                this$0 = BaseListFragment.this;
                super();
            }
    };
    TextView _standardEmptyView;

    public BaseListFragment()
    {
    }

    private void ensureList()
    {
        if (_list != null)
        {
            return;
        }
        Object obj = getView();
        if (obj == null)
        {
            throw new IllegalStateException("Content view not yet created");
        }
        if (obj instanceof ListView)
        {
            _list = (ListView)obj;
        } else
        {
            _standardEmptyView = (TextView)((View) (obj)).findViewById(com.ebay.nautilus.shell.R.id.internalEmpty);
            if (_standardEmptyView == null)
            {
                _emptyView = ((View) (obj)).findViewById(0x1020004);
            } else
            {
                _standardEmptyView.setVisibility(8);
            }
            _progressContainer = ((View) (obj)).findViewById(com.ebay.nautilus.shell.R.id.progressContainer);
            _listContainer = ((View) (obj)).findViewById(com.ebay.nautilus.shell.R.id.listContainer);
            obj = ((View) (obj)).findViewById(0x102000a);
            if (!(obj instanceof ListView))
            {
                if (obj == null)
                {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                } else
                {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
            }
            _list = (ListView)obj;
            if (_emptyView != null)
            {
                _list.setEmptyView(_emptyView);
            } else
            if (_emptyText != null)
            {
                _standardEmptyView.setText(_emptyText);
                _list.setEmptyView(_standardEmptyView);
            }
        }
        _listShown = true;
        _list.setOnItemClickListener(_onClickListener);
        if (_adapter != null)
        {
            obj = _adapter;
            _adapter = null;
            setListAdapter(((ListAdapter) (obj)));
        } else
        if (_progressContainer != null)
        {
            setListShown(false, false);
        }
        _handler.post(_requestFocus);
    }

    private void setListShown(boolean flag, boolean flag1)
    {
        ensureList();
        if (_progressContainer == null)
        {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (_listShown == flag)
        {
            return;
        }
        _listShown = flag;
        if (flag)
        {
            if (flag1)
            {
                _progressContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0001));
                _listContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0000));
            } else
            {
                _progressContainer.clearAnimation();
                _listContainer.clearAnimation();
            }
            _progressContainer.setVisibility(8);
            _listContainer.setVisibility(0);
            return;
        }
        if (flag1)
        {
            _progressContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0000));
            _listContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0001));
        } else
        {
            _progressContainer.clearAnimation();
            _listContainer.clearAnimation();
        }
        _progressContainer.setVisibility(0);
        _listContainer.setVisibility(8);
    }

    public ListAdapter getListAdapter()
    {
        return _adapter;
    }

    public ListView getListView()
    {
        ensureList();
        return _list;
    }

    public long getSelectedItemId()
    {
        ensureList();
        return _list.getSelectedItemId();
    }

    public int getSelectedItemPosition()
    {
        ensureList();
        return _list.getSelectedItemPosition();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(com.ebay.nautilus.shell.R.layout.list_content, viewgroup, false);
    }

    public void onDestroyView()
    {
        _handler.removeCallbacks(_requestFocus);
        _list = null;
        _listShown = false;
        _listContainer = null;
        _progressContainer = null;
        _emptyView = null;
        _standardEmptyView = null;
        super.onDestroyView();
    }

    public void onListItemClick(ListView listview, View view, int i, long l)
    {
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ensureList();
    }

    public void setEmptyText(CharSequence charsequence)
    {
        ensureList();
        if (_standardEmptyView == null)
        {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        _standardEmptyView.setText(charsequence);
        if (_emptyText == null)
        {
            _list.setEmptyView(_standardEmptyView);
        }
        _emptyText = charsequence;
    }

    public void setListAdapter(ListAdapter listadapter)
    {
        boolean flag1 = false;
        boolean flag;
        if (_adapter != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _adapter = listadapter;
        if (_list != null)
        {
            _list.setAdapter(listadapter);
            if (!_listShown && !flag)
            {
                if (getView().getWindowToken() != null)
                {
                    flag1 = true;
                }
                setListShown(true, flag1);
            }
        }
    }

    public void setListShown(boolean flag)
    {
        setListShown(flag, true);
    }

    public void setListShownNoAnimation(boolean flag)
    {
        setListShown(flag, false);
    }

    public void setSelection(int i)
    {
        ensureList();
        _list.setSelection(i);
    }
}
