// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.widget.CursorAdapter;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import co.vine.android.api.VineEntity;
import co.vine.android.api.VineTypeAhead;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.Util;
import co.vine.android.views.SdkEditText;
import co.vine.android.views.SdkListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.TreeMap;

// Referenced classes of package co.vine.android.widget:
//            Typefaces

public class PopupEditText extends SdkEditText
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener, android.widget.Filter.FilterListener
{
    private class AdapterObserver extends DataSetObserver
    {

        final PopupEditText this$0;

        public void onChanged()
        {
            super.onChanged();
            if (mShowRequested)
            {
                showDropDown();
                mShowRequested = false;
            }
        }

        public void onInvalidated()
        {
            super.onInvalidated();
            dismissDropDown();
        }

        public AdapterObserver()
        {
            this$0 = PopupEditText.this;
            super();
        }
    }

    private static class DropDownListView extends SdkListView
    {

        public boolean hasFocus()
        {
            return true;
        }

        public boolean hasWindowFocus()
        {
            return true;
        }

        public boolean isFocused()
        {
            return true;
        }

        public DropDownListView(Context context, AttributeSet attributeset, int i)
        {
            super(context, attributeset, i);
        }
    }

    private static class FilterHandler extends Handler
    {

        private Filterable mFilterable;
        private final WeakReference mListenerRef;
        private PopupEditTextListener mOnFilterListener;

        public void handleMessage(Message message)
        {
            android.widget.Filter.FilterListener filterlistener = (android.widget.Filter.FilterListener)mListenerRef.get();
            if (mFilterable != null && filterlistener != null)
            {
                CharSequence charsequence = (CharSequence)message.obj;
                mFilterable.getFilter().filter(charsequence, filterlistener);
                if (message.arg1 == 1 && mOnFilterListener != null)
                {
                    mOnFilterListener.onFiltering(charsequence);
                }
            }
        }

        public void setFilterable(Filterable filterable)
        {
            mFilterable = filterable;
        }

        public void setOnFilterListener(PopupEditTextListener popupedittextlistener)
        {
            mOnFilterListener = popupedittextlistener;
        }

        public FilterHandler(Looper looper, android.widget.Filter.FilterListener filterlistener)
        {
            super(looper);
            mListenerRef = new WeakReference(filterlistener);
        }
    }

    public static interface PopupEditTextListener
    {

        public abstract CursorAdapter getPopupAdapter();

        public abstract void onFiltering(CharSequence charsequence);

        public abstract void onPopupItemSelected(int i, int j, CharSequence charsequence, long l);

        public abstract void onPopupShown();

        public abstract void setPopupAdapter(String s);
    }

    private class PopupInputConnection extends InputConnectionWrapper
    {

        final PopupEditText this$0;

        public boolean deleteSurroundingText(int i, int j)
        {
            if (mSelectedEntity != null && i > 0 && j == 0)
            {
                return sendKeyEvent(new KeyEvent(0, 67));
            } else
            {
                return super.deleteSurroundingText(i, j);
            }
        }

        public boolean sendKeyEvent(KeyEvent keyevent)
        {
            if (mSelectedEntity != null && keyevent.getAction() == 0 && keyevent.getKeyCode() == 67)
            {
                clearSelectedEntity(mSelectedEntity.start, true);
                return true;
            } else
            {
                return super.sendKeyEvent(keyevent);
            }
        }

        public PopupInputConnection(InputConnection inputconnection, boolean flag)
        {
            this$0 = PopupEditText.this;
            super(inputconnection, flag);
        }
    }


    private static final int MSG_FILTER = 0;
    private static final int NO_CALLBACK = 0;
    private static final int TRIGGER_CALLBACK = 1;
    private ListAdapter mAdapter;
    private android.view.View.OnClickListener mClick;
    private DataSetObserver mDataSetObserver;
    private final int mDropDownHorizontalOffset;
    private final DropDownListView mDropDownList;
    private final int mDropDownVerticalOffset;
    private TreeMap mEntityRanges;
    private Filterable mFilterable;
    private final FilterHandler mHandler;
    private PopupEditTextListener mListener;
    private final PopupWindow mPopup;
    private VineEntity mSelectedEntity;
    private boolean mShowRequested;
    private final int mThreshold;
    private long mThrottleDelay;
    private android.widget.MultiAutoCompleteTextView.Tokenizer mTokenizer;

    public PopupEditText(Context context)
    {
        this(context, null);
    }

    public PopupEditText(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f01002d);
    }

    public PopupEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mShowRequested = false;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, co.vine.android.R.styleable.PopupEditText, i, 0);
        mDropDownVerticalOffset = typedarray.getDimensionPixelOffset(0, 0);
        mDropDownHorizontalOffset = typedarray.getDimensionPixelOffset(1, 0);
        mThreshold = typedarray.getInteger(2, 0);
        DropDownListView dropdownlistview = new DropDownListView(context, null, 0x7f01002c);
        dropdownlistview.setDividerHeight(getResources().getDimensionPixelSize(0x7f0b002e));
        dropdownlistview.setOnItemClickListener(this);
        mDropDownList = dropdownlistview;
        context = new PopupWindow(context, attributeset, 0x7f01002d);
        context.setSoftInputMode(16);
        context.setOutsideTouchable(false);
        context.setContentView(dropdownlistview);
        context.setHeight(-1);
        context.setWindowLayoutMode(-1, -1);
        context.setInputMethodMode(1);
        mPopup = context;
        super.setOnClickListener(this);
        mHandler = new FilterHandler(Looper.getMainLooper(), this);
        typedarray.recycle();
        mEntityRanges = new TreeMap();
    }

    private void atomizeEntity(int i, int j)
    {
        co.vine.android.api.VineEntity.Range range = lookupRange(i, j);
        if (range != null && range.entity != null)
        {
            mSelectedEntity = range.entity;
            Editable editable = getText();
            setSelection(editable.getSpanStart(range.span), editable.getSpanEnd(range.span));
            return;
        } else
        {
            mSelectedEntity = null;
            return;
        }
    }

    private boolean isPopupShowing()
    {
        return mPopup.isShowing();
    }

    private co.vine.android.api.VineEntity.Range lookupRange(int i, int j)
    {
        TreeMap treemap = mEntityRanges;
        if (treemap != null && !treemap.isEmpty())
        {
            java.util.Map.Entry entry1 = treemap.floorEntry(Integer.valueOf(i));
            java.util.Map.Entry entry = entry1;
            if (entry1 == null)
            {
                entry = treemap.floorEntry(Integer.valueOf(j));
            }
            if (entry != null && (i <= ((co.vine.android.api.VineEntity.Range)entry.getValue()).upper || j <= ((co.vine.android.api.VineEntity.Range)entry.getValue()).upper))
            {
                return (co.vine.android.api.VineEntity.Range)entry.getValue();
            }
        }
        return null;
    }

    public boolean clearSelectedEntity(int i, boolean flag)
    {
        if (mSelectedEntity != null)
        {
            mSelectedEntity = null;
            Editable editable = getText();
            if (!TextUtils.isEmpty(editable))
            {
                co.vine.android.api.VineEntity.Range range = (co.vine.android.api.VineEntity.Range)mEntityRanges.remove(Integer.valueOf(i));
                i = editable.getSpanStart(range.span);
                int j = editable.getSpanEnd(range.span);
                editable.removeSpan(range.span);
                if (flag)
                {
                    editable.delete(i, j);
                    setSelection(i);
                } else
                {
                    setSelection(i + 1);
                }
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void dismissDropDown()
    {
        mPopup.dismiss();
        mShowRequested = false;
        mHandler.removeMessages(0);
    }

    public ArrayList getEntities()
    {
        Editable editable = getText();
        if (editable != null && editable.length() > 0)
        {
            try
            {
                for (; Character.isWhitespace(editable.charAt(0)); editable.replace(0, 1, "")) { }
            }
            catch (IndexOutOfBoundsException indexoutofboundsexception) { }
        }
        ArrayList arraylist = new ArrayList();
        TreeMap treemap = mEntityRanges;
        if (editable != null)
        {
            int j = 1;
            for (int i = 0; i < editable.length();)
            {
                int k = j;
                if (Character.isHighSurrogate(editable.charAt(i)))
                {
                    co.vine.android.api.VineEntity.Range range;
                    for (java.util.Map.Entry entry = treemap.ceilingEntry(Integer.valueOf(i)); entry != null; entry = treemap.ceilingEntry(Integer.valueOf(range.entity.end)))
                    {
                        range = (co.vine.android.api.VineEntity.Range)entry.getValue();
                        k = editable.getSpanStart(range.span) - j;
                        int l = editable.getSpanEnd(range.span) - j;
                        range.entity.start = k;
                        range.entity.end = l;
                        co.vine.android.api.VineEntity.Range range1 = new co.vine.android.api.VineEntity.Range(l, range.entity, range.span);
                        treemap.remove(entry.getKey());
                        treemap.put(Integer.valueOf(k), range1);
                    }

                    k = j + 1;
                }
                i++;
                j = k;
            }

        }
        for (Iterator iterator = treemap.values().iterator(); iterator.hasNext(); arraylist.add(((co.vine.android.api.VineEntity.Range)iterator.next()).entity)) { }
        treemap.clear();
        return arraylist;
    }

    public void onClick(View view)
    {
        if (isPopupShowing())
        {
            mPopup.setInputMethodMode(1);
            showDropDown();
        }
        if (mClick != null)
        {
            mClick.onClick(view);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo)
    {
        return new PopupInputConnection(super.onCreateInputConnection(editorinfo), true);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        dismissDropDown();
    }

    public void onFilterComplete(int i)
    {
        i = getSelectionEnd();
        if (i - mTokenizer.findTokenStart(getText(), i) >= mThreshold)
        {
            showDropDown();
            return;
        } else
        {
            dismissDropDown();
            return;
        }
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect)
    {
        super.onFocusChanged(flag, i, rect);
        if (!flag)
        {
            dismissDropDown();
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        clearComposingText();
        if (!(adapterview.getItemAtPosition(i) instanceof VineTypeAhead)) goto _L2; else goto _L1
_L1:
        adapterview = (VineTypeAhead)adapterview.getItemAtPosition(i);
        if (mFilterable != null) goto _L4; else goto _L3
_L3:
        CrashUtil.log("Invalid state: mFilterable=null, type={}, token={}", new Object[] {
            ((VineTypeAhead) (adapterview)).type, ((VineTypeAhead) (adapterview)).token
        });
_L6:
        dismissDropDown();
_L2:
        return;
_L4:
        view = getText();
        i = getSelectionEnd();
        int j = mTokenizer.findTokenStart(view, i);
        CharSequence charsequence = mTokenizer.terminateToken(mFilterable.getFilter().convertResultToString(((VineTypeAhead) (adapterview)).token));
        int k = j + ((VineTypeAhead) (adapterview)).token.length();
        VineEntity vineentity = new VineEntity(((VineTypeAhead) (adapterview)).type, ((VineTypeAhead) (adapterview)).token, null, j, k, l);
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(charsequence);
        ForegroundColorSpan foregroundcolorspan = new ForegroundColorSpan(getResources().getColor(0x7f090096));
        Util.safeSetSpan(spannablestringbuilder, foregroundcolorspan, 0, ((VineTypeAhead) (adapterview)).token.length(), 0);
        view.replace(j, i, spannablestringbuilder);
        mEntityRanges.put(Integer.valueOf(j), new co.vine.android.api.VineEntity.Range(k, vineentity, foregroundcolorspan));
        if (mListener != null)
        {
            mListener.onPopupItemSelected(j, i, charsequence, l);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (mSelectedEntity != null && keyevent.getAction() == 0 && keyevent.getKeyCode() == 67)
        {
            clearSelectedEntity(mSelectedEntity.start, true);
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent)
    {
        if (i == 4 && isPopupShowing())
        {
            if (keyevent.getAction() == 0 && keyevent.getRepeatCount() == 0)
            {
                getKeyDispatcherState().startTracking(keyevent, this);
                return true;
            }
            if (keyevent.getAction() == 1)
            {
                getKeyDispatcherState().handleUpEvent(keyevent);
                if (keyevent.isTracking() && !keyevent.isCanceled())
                {
                    dismissDropDown();
                    return true;
                }
            }
        }
        return super.onKeyPreIme(i, keyevent);
    }

    protected void onSelectionChanged(int i, int j)
    {
        super.onSelectionChanged(i, j);
        atomizeEntity(i, j);
    }

    protected void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        super.onTextChanged(charsequence, i, j, k);
        TreeMap treemap = mEntityRanges;
        if (treemap != null && !treemap.isEmpty())
        {
            co.vine.android.api.VineEntity.Range range;
            for (charsequence = treemap.ceilingEntry(Integer.valueOf(i)); charsequence != null; charsequence = treemap.ceilingEntry(Integer.valueOf(range.entity.end)))
            {
                range = (co.vine.android.api.VineEntity.Range)charsequence.getValue();
                Object obj = getText();
                i = ((Editable) (obj)).getSpanStart(range.span);
                j = ((Editable) (obj)).getSpanEnd(range.span);
                range.entity.start = i;
                range.entity.end = j;
                obj = new co.vine.android.api.VineEntity.Range(j, range.entity, range.span);
                treemap.remove(charsequence.getKey());
                treemap.put(Integer.valueOf(i), obj);
            }

        }
        if (mSelectedEntity != null)
        {
            clearSelectedEntity(mSelectedEntity.start, false);
        } else
        {
            performFilter(true);
        }
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            atomizeEntity(getSelectionStart(), getSelectionEnd());
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (!flag)
        {
            dismissDropDown();
        }
    }

    public void performFilter(boolean flag)
    {
        int j;
        if (mTokenizer != null && mFilterable != null)
        {
            if ((j = getSelectionEnd()) >= 0)
            {
                Editable editable = getText();
                int k = mTokenizer.findTokenStart(editable, j);
                FilterHandler filterhandler = mHandler;
                filterhandler.removeMessages(0);
                int i;
                if (flag)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                filterhandler.sendMessageDelayed(filterhandler.obtainMessage(0, i, 0, editable.subSequence(k, j)), mThrottleDelay);
                return;
            }
        }
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        } else
        {
            mDataSetObserver = new AdapterObserver();
        }
        mDropDownList.setAdapter(listadapter);
        listadapter.registerDataSetObserver(mDataSetObserver);
        mAdapter = listadapter;
    }

    protected boolean setFrame(int i, int j, int k, int l)
    {
        boolean flag = super.setFrame(i, j, k, l);
        if (isPopupShowing())
        {
            showDropDown();
        }
        return flag;
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        mClick = onclicklistener;
    }

    public void setPopupEditTextListener(PopupEditTextListener popupedittextlistener)
    {
        mListener = popupedittextlistener;
        mHandler.setOnFilterListener(popupedittextlistener);
    }

    public void setTokenizer(android.widget.MultiAutoCompleteTextView.Tokenizer tokenizer, Filterable filterable, long l)
    {
        if (tokenizer == null)
        {
            throw new IllegalArgumentException("tokenizer cannot be null.");
        }
        if (mAdapter == null)
        {
            throw new IllegalStateException("setAdapter must be called first with a non-null adapter");
        } else
        {
            mFilterable = filterable;
            mTokenizer = tokenizer;
            mThrottleDelay = l;
            mHandler.setFilterable(filterable);
            return;
        }
    }

    public void setTypeface(Typeface typeface, int i)
    {
        super.setTypeface(Typefaces.get(getContext()).getContentTypeface(i, 0));
    }

    public void showDropDown()
    {
        if (getWindowVisibility() == 8)
        {
            return;
        }
        if (mAdapter.getCount() == 0)
        {
            dismissDropDown();
            mShowRequested = true;
            return;
        }
        int i = ((View)getParent()).getWidth();
        PopupWindow popupwindow = mPopup;
        if (!popupwindow.isShowing())
        {
            popupwindow.setWidth(i);
            popupwindow.showAsDropDown(this, mDropDownHorizontalOffset, mDropDownVerticalOffset);
            if (mListener != null)
            {
                mListener.onPopupShown();
            }
        }
        mDropDownList.setSelectionAfterHeaderView();
    }



/*
    static boolean access$002(PopupEditText popupedittext, boolean flag)
    {
        popupedittext.mShowRequested = flag;
        return flag;
    }

*/

}
