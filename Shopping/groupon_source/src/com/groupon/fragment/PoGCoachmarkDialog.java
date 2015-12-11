// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.Channel;
import com.groupon.foundations.dialog.BaseDialogFragment;
import com.groupon.util.LoggingUtils;

public class PoGCoachmarkDialog extends BaseDialogFragment
{
    public static final class DialogType extends Enum
    {

        private static final DialogType $VALUES[];
        public static final DialogType CAMERA;
        public static final DialogType DOLLAR;

        public static DialogType valueOf(String s)
        {
            return (DialogType)Enum.valueOf(com/groupon/fragment/PoGCoachmarkDialog$DialogType, s);
        }

        public static DialogType[] values()
        {
            return (DialogType[])$VALUES.clone();
        }

        static 
        {
            CAMERA = new DialogType("CAMERA", 0);
            DOLLAR = new DialogType("DOLLAR", 1);
            $VALUES = (new DialogType[] {
                CAMERA, DOLLAR
            });
        }

        private DialogType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String TYPE = "type";
    Button actionButton;
    ImageView cancelButton;
    ImageView coachmarkImage;
    TextView coachmarkMessage;
    private DialogType dialogType;
    LoggingUtils loggingUtils;

    public PoGCoachmarkDialog()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        dialogType = (DialogType)getArguments().getSerializable("type");
        LoggingUtils loggingutils = loggingUtils;
        if (dialogType == DialogType.CAMERA)
        {
            bundle = "pog_modal_one";
        } else
        {
            bundle = "pog_modal_two";
        }
        loggingutils.logImpression("", bundle, Channel.GLOBAL_SEARCH.name().toLowerCase(), "", null);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = super.onCreateDialog(bundle);
        bundle.getWindow().requestFeature(1);
        return bundle;
    }

    public View onCreateView(LayoutInflater layoutinflater, final ViewGroup resources, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03018e, resources, false);
        ButterKnife.bind(this, layoutinflater);
        resources = getActivity().getResources();
        if (dialogType == DialogType.CAMERA)
        {
            coachmarkImage.setImageDrawable(resources.getDrawable(0x7f020096));
            bundle = new SpannableString(resources.getString(0x7f080503));
            bundle.setSpan(new ForegroundColorSpan(resources.getColor(0x7f0e00ee)), 0, bundle.length(), 33);
            coachmarkMessage.setText(bundle);
            bundle = new SpannableString(resources.getString(0x7f080504));
            bundle.setSpan(new ClickableSpan() {

                final PoGCoachmarkDialog this$0;
                final Resources val$resources;

                public void onClick(View view)
                {
                    view = new PoGCoachmarkDialog();
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("type", DialogType.DOLLAR);
                    view.setArguments(bundle1);
                    view.setCancelable(false);
                    view.show(getFragmentManager(), DialogType.DOLLAR.toString());
                    dismiss();
                }

                public void updateDrawState(TextPaint textpaint)
                {
                    textpaint.setColor(resources.getColor(0x7f0e00b9));
                    textpaint.setUnderlineText(false);
                }

            
            {
                this$0 = PoGCoachmarkDialog.this;
                resources = resources1;
                super();
            }
            }, 0, bundle.length(), 33);
            coachmarkMessage.append(bundle);
            coachmarkMessage.setMovementMethod(LinkMovementMethod.getInstance());
            actionButton.setText(resources.getString(0x7f080506));
        } else
        {
            coachmarkImage.setImageDrawable(resources.getDrawable(0x7f020158));
            coachmarkMessage.setText(resources.getString(0x7f080505));
            actionButton.setText(resources.getString(0x7f080502));
        }
        actionButton.setOnClickListener(new android.view.View.OnClickListener() {

            final PoGCoachmarkDialog this$0;

            public void onClick(View view)
            {
                LoggingUtils loggingutils = loggingUtils;
                if (dialogType == DialogType.CAMERA)
                {
                    view = "pog_modal_one_ok";
                } else
                {
                    view = "pog_modal_two_ok";
                }
                loggingutils.logClickWithMetadata("", view, Channel.GLOBAL_SEARCH.name().toLowerCase(), null);
                dismiss();
            }

            
            {
                this$0 = PoGCoachmarkDialog.this;
                super();
            }
        });
        cancelButton.setOnClickListener(new android.view.View.OnClickListener() {

            final PoGCoachmarkDialog this$0;

            public void onClick(View view)
            {
                LoggingUtils loggingutils = loggingUtils;
                if (dialogType == DialogType.CAMERA)
                {
                    view = "pog_modal_one_close";
                } else
                {
                    view = "pog_modal_two_close";
                }
                loggingutils.logClickWithMetadata("", view, Channel.GLOBAL_SEARCH.name().toLowerCase(), null);
                dismiss();
            }

            
            {
                this$0 = PoGCoachmarkDialog.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDestroyView()
    {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

}
