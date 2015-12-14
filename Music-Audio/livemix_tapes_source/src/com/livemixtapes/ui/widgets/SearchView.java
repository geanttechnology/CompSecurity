// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui.widgets;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.livemixtapes.utils.Utility;

public class SearchView extends RelativeLayout
{
    public static interface ExpandListener
    {

        public abstract void onAfterExpand(boolean flag);

        public abstract void onBeforeExpand(boolean flag);
    }

    public static interface QueryTextListener
    {

        public abstract boolean onQueryTextChange(String s);

        public abstract boolean onQueryTextSubmit(String s);
    }


    public static final long ANIMATION_DURATION = 300L;
    private Button buttonCancel;
    private Context context;
    private EditText editTextQuery;
    private ExpandListener expandListener;
    private boolean isExpanded;
    private RelativeLayout layoutContainer;
    private LinearLayout layoutHint;
    private RelativeLayout layoutPanel;
    private QueryTextListener queryTextListener;
    private LinearLayout searchBox;
    private ImageButton searchClear;
    private TextView textViewHint;
    int widthHint;
    int widthPanel;

    public SearchView(Context context1)
    {
        super(context1);
        queryTextListener = null;
        expandListener = null;
        init(context1);
    }

    public SearchView(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        queryTextListener = null;
        expandListener = null;
        init(context1);
    }

    public SearchView(Context context1, AttributeSet attributeset, int i)
    {
        super(context1, attributeset, i);
        queryTextListener = null;
        expandListener = null;
        init(context1);
    }

    private void attachEvents()
    {
        layoutContainer.setOnTouchListener(new android.view.View.OnTouchListener() {

            final SearchView this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (!isExpanded)
                {
                    isExpanded = true;
                    startAnimation(isExpanded);
                }
                return false;
            }

            
            {
                this$0 = SearchView.this;
                super();
            }
        });
        buttonCancel.setOnClickListener(new android.view.View.OnClickListener() {

            final SearchView this$0;

            public void onClick(View view)
            {
                editTextQuery.setText("");
                if (isExpanded)
                {
                    isExpanded = false;
                    startAnimation(isExpanded);
                }
            }

            
            {
                this$0 = SearchView.this;
                super();
            }
        });
        editTextQuery.addTextChangedListener(new TextWatcher() {

            final SearchView this$0;

            public void afterTextChanged(Editable editable)
            {
                if (editTextQuery.length() > 0)
                {
                    searchClear.setVisibility(0);
                } else
                {
                    searchClear.setVisibility(8);
                }
                if (queryTextListener != null)
                {
                    queryTextListener.onQueryTextChange(editable.toString());
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (queryTextListener != null)
                {
                    queryTextListener.onQueryTextChange(charsequence.toString());
                }
            }

            
            {
                this$0 = SearchView.this;
                super();
            }
        });
        searchClear.setOnClickListener(new android.view.View.OnClickListener() {

            final SearchView this$0;

            public void onClick(View view)
            {
                editTextQuery.setText("");
                editTextQuery.requestFocus();
            }

            
            {
                this$0 = SearchView.this;
                super();
            }
        });
        editTextQuery.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final SearchView this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i == 3 && queryTextListener != null)
                {
                    queryTextListener.onQueryTextChange(editTextQuery.getText().toString());
                    setExpand(false);
                }
                return false;
            }

            
            {
                this$0 = SearchView.this;
                super();
            }
        });
    }

    private void init(Context context1)
    {
        context = context1;
        ((LayoutInflater)context1.getSystemService("layout_inflater")).inflate(0x7f03003b, this, true);
        isExpanded = false;
        synthesize();
        attachEvents();
        updateHintLabel();
    }

    private void startAnimation(final boolean expand)
    {
        if (expand)
        {
            Animation animation = new Animation() {

                final SearchView this$0;

                protected void applyTransformation(float f, Transformation transformation)
                {
                    transformation = (android.widget.RelativeLayout.LayoutParams)layoutPanel.getLayoutParams();
                    float f1 = Utility.dpToPixel(context, 50F * f);
                    transformation.rightMargin = (int)f1;
                    layoutPanel.setLayoutParams(transformation);
                    int i = (int)((float)(widthPanel - widthHint) - f1 - 20F);
                    transformation = (android.widget.RelativeLayout.LayoutParams)layoutHint.getLayoutParams();
                    transformation.width = (int)((float)widthHint + (float)i * f);
                    layoutHint.setLayoutParams(transformation);
                }

            
            {
                this$0 = SearchView.this;
                super();
            }
            };
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final SearchView this$0;
                private final boolean val$expand;

                public void onAnimationEnd(Animation animation2)
                {
                    buttonCancel.setVisibility(0);
                    textViewHint.setVisibility(4);
                    editTextQuery.setVisibility(0);
                    editTextQuery.requestFocus();
                    ((InputMethodManager)context.getSystemService("input_method")).showSoftInput(editTextQuery, 1);
                    if (expandListener != null)
                    {
                        expandListener.onAfterExpand(expand);
                    }
                }

                public void onAnimationRepeat(Animation animation2)
                {
                }

                public void onAnimationStart(Animation animation2)
                {
                    animation2 = (android.widget.RelativeLayout.LayoutParams)layoutPanel.getLayoutParams();
                    animation2.rightMargin = -(int)0.0F;
                    layoutPanel.setLayoutParams(animation2);
                    buttonCancel.setVisibility(8);
                    if (expandListener != null)
                    {
                        expandListener.onBeforeExpand(expand);
                    }
                }

            
            {
                this$0 = SearchView.this;
                expand = flag;
                super();
            }
            });
            animation.setDuration(300L);
            layoutContainer.startAnimation(animation);
            return;
        } else
        {
            Animation animation1 = new Animation() {

                final SearchView this$0;

                protected void applyTransformation(float f, Transformation transformation)
                {
                    transformation = (android.widget.RelativeLayout.LayoutParams)layoutPanel.getLayoutParams();
                    float f1 = Utility.dpToPixel(context, 50F - 50F * f);
                    transformation.rightMargin = (int)f1;
                    layoutPanel.setLayoutParams(transformation);
                    int i = (int)((float)(widthPanel - widthHint) - f1 - 20F);
                    transformation = (android.widget.RelativeLayout.LayoutParams)layoutHint.getLayoutParams();
                    transformation.width = (int)((float)widthHint + ((float)i - (float)i * f));
                    layoutHint.setLayoutParams(transformation);
                }

            
            {
                this$0 = SearchView.this;
                super();
            }
            };
            animation1.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final SearchView this$0;
                private final boolean val$expand;

                public void onAnimationEnd(Animation animation2)
                {
                    animation2 = (android.widget.RelativeLayout.LayoutParams)layoutPanel.getLayoutParams();
                    animation2.rightMargin = -(int)0.0F;
                    layoutPanel.setLayoutParams(animation2);
                    if (expandListener != null)
                    {
                        expandListener.onAfterExpand(expand);
                    }
                }

                public void onAnimationRepeat(Animation animation2)
                {
                }

                public void onAnimationStart(Animation animation2)
                {
                    buttonCancel.setVisibility(8);
                    updateHintLabel();
                    textViewHint.setVisibility(0);
                    editTextQuery.setVisibility(8);
                    ((InputMethodManager)context.getSystemService("input_method")).hideSoftInputFromWindow(editTextQuery.getWindowToken(), 0);
                    if (expandListener != null)
                    {
                        expandListener.onBeforeExpand(expand);
                    }
                }

            
            {
                this$0 = SearchView.this;
                expand = flag;
                super();
            }
            });
            animation1.setDuration(300L);
            layoutContainer.startAnimation(animation1);
            return;
        }
    }

    private void synthesize()
    {
        layoutContainer = (RelativeLayout)findViewById(0x7f0800fd);
        layoutPanel = (RelativeLayout)findViewById(0x7f080106);
        buttonCancel = (Button)findViewById(0x7f08010c);
        textViewHint = (TextView)findViewById(0x7f080108);
        editTextQuery = (EditText)findViewById(0x7f08010a);
        layoutHint = (LinearLayout)findViewById(0x7f080107);
        searchBox = (LinearLayout)findViewById(0x7f080086);
        searchClear = (ImageButton)findViewById(0x7f08010b);
        layoutPanel.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final SearchView this$0;

            public void onGlobalLayout()
            {
                widthPanel = layoutPanel.getWidth();
                layoutPanel.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }

            
            {
                this$0 = SearchView.this;
                super();
            }
        });
        layoutHint.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final SearchView this$0;

            public void onGlobalLayout()
            {
                widthHint = layoutHint.getWidth();
                layoutHint.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }

            
            {
                this$0 = SearchView.this;
                super();
            }
        });
    }

    private void updateHintLabel()
    {
        if (getQuery().isEmpty())
        {
            textViewHint.setText("Search");
            return;
        } else
        {
            textViewHint.setText(getQuery());
            return;
        }
    }

    public String getQuery()
    {
        return editTextQuery.getText().toString();
    }

    public void setExpand(boolean flag)
    {
        if (isExpanded != flag)
        {
            isExpanded = flag;
            startAnimation(flag);
        }
    }

    public void setOnExpandListener(ExpandListener expandlistener)
    {
        expandListener = expandlistener;
    }

    public void setOnQueryTextListener(QueryTextListener querytextlistener)
    {
        queryTextListener = querytextlistener;
    }

    public void setQuery(String s)
    {
        editTextQuery.setText(s);
        updateHintLabel();
    }













}
