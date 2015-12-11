// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.data.ShippingLabelDetails;
import com.ebay.nautilus.domain.data.ShippingLabelDraft;
import com.ebay.nautilus.domain.data.ShippingLabelOrder;
import com.ebay.nautilus.domain.data.ShippingLabelPackage;
import com.ebay.nautilus.domain.data.ShippingOption;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelBaseFragment, ShippingLabelActivity, VoidLabelFragment

public class ShippingLabelPreviewFragment extends ShippingLabelBaseFragment
    implements android.view.View.OnClickListener
{

    private PrintJob currentPrintJob;

    public ShippingLabelPreviewFragment()
    {
    }

    private void printPdf()
    {
        final ShippingLabelActivity activity = (ShippingLabelActivity)getActivity();
        PrintDocumentAdapter printdocumentadapter = new PrintDocumentAdapter() {

            InputStream input;
            FileOutputStream output;
            final ShippingLabelPreviewFragment this$0;
            final ShippingLabelActivity val$activity;

            public void onLayout(PrintAttributes printattributes, PrintAttributes printattributes1, CancellationSignal cancellationsignal, android.print.PrintDocumentAdapter.LayoutResultCallback layoutresultcallback, Bundle bundle)
            {
                if (cancellationsignal.isCanceled())
                {
                    layoutresultcallback.onLayoutCancelled();
                    return;
                }
                cancellationsignal = (new android.print.PrintDocumentInfo.Builder(activity.getLabelFileName())).setContentType(0).setPageCount(1).build();
                if (!printattributes.equals(printattributes1))
                {
                    layoutresultcallback.onLayoutFinished(cancellationsignal, true);
                    return;
                } else
                {
                    layoutresultcallback.onLayoutFinished(cancellationsignal, false);
                    return;
                }
            }

            public void onWrite(PageRange apagerange[], ParcelFileDescriptor parcelfiledescriptor, CancellationSignal cancellationsignal, android.print.PrintDocumentAdapter.WriteResultCallback writeresultcallback)
            {
                input = new FileInputStream(activity.pdfFile);
                output = new FileOutputStream(parcelfiledescriptor.getFileDescriptor());
                apagerange = new byte[1024];
_L1:
                int i = input.read(apagerange);
                if (i <= 0)
                {
                    break MISSING_BLOCK_LABEL_113;
                }
                output.write(apagerange, 0, i);
                  goto _L1
                apagerange;
                writeresultcallback.onWriteFailed(getString(0x7f070255));
                StreamUtil.closeQuietly(input);
                StreamUtil.closeQuietly(output);
                writeresultcallback.onWriteFinished(new PageRange[] {
                    PageRange.ALL_PAGES
                });
                return;
                StreamUtil.closeQuietly(input);
                StreamUtil.closeQuietly(output);
                writeresultcallback.onWriteFinished(new PageRange[] {
                    PageRange.ALL_PAGES
                });
                return;
                apagerange;
                StreamUtil.closeQuietly(input);
                StreamUtil.closeQuietly(output);
                writeresultcallback.onWriteFinished(new PageRange[] {
                    PageRange.ALL_PAGES
                });
                throw apagerange;
            }

            
            {
                this$0 = ShippingLabelPreviewFragment.this;
                activity = shippinglabelactivity;
                super();
                input = null;
                output = null;
            }
        };
        currentPrintJob = ((PrintManager)activity.getSystemService("print")).print(activity.getLabelFileName(), printdocumentadapter, null);
    }

    private void resumePrinting()
    {
        Object obj = (ShippingLabelActivity)getActivity();
        if (currentPrintJob != null && currentPrintJob.isCompleted())
        {
            ((ShippingLabelActivity) (obj)).showSuccess(true, false);
        } else
        {
            obj = (PrintManager)((ShippingLabelActivity) (obj)).getSystemService("print");
            if (((PrintManager) (obj)).getPrintJobs().size() > 0)
            {
                obj = ((PrintManager) (obj)).getPrintJobs().iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    PrintJob printjob = (PrintJob)((Iterator) (obj)).next();
                    if (!printjob.isCompleted() && !printjob.isCancelled() && !printjob.isFailed())
                    {
                        printjob.cancel();
                    }
                }
            }
        }
    }

    public boolean isHomeUp()
    {
        return true;
    }

    public boolean onBackPressed()
    {
        return false;
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131756910 2131756912: default 32
    //                   2131756910 250
    //                   2131756911 33
    //                   2131756912 211;
           goto _L1 _L2 _L3 _L4
_L1:
        Object obj;
        return;
_L3:
        if ((obj = ((ShippingLabelActivity)getActivity()).pdfFile) != null && ((ShippingLabelActivity) (view = (ShippingLabelActivity)getActivity())).shippingLabelDraft != null)
        {
            view = (com.ebay.nautilus.domain.data.ShippingLabelOrder.OrderLineItem)((ShippingLabelOrder)((ShippingLabelActivity) (view)).shippingLabelDraft.labelDetails.pkg.manifest.orderInfo.get(0)).lineItems.get(0);
            obj = Uri.parse((new StringBuilder()).append("file://").append(((File) (obj)).getAbsolutePath()).toString());
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("message/rfc822");
            intent.putExtra("android.intent.extra.STREAM", ((android.os.Parcelable) (obj)));
            intent.putExtra("android.intent.extra.SUBJECT", getString(0x7f070837, new Object[] {
                ((com.ebay.nautilus.domain.data.ShippingLabelOrder.OrderLineItem) (view)).itemRefId, ((com.ebay.nautilus.domain.data.ShippingLabelOrder.OrderLineItem) (view)).title
            }));
            intent.putExtra("android.intent.extra.TEXT", getString(0x7f070834));
            getActivity().startActivityForResult(Intent.createChooser(intent, getString(0x7f070835)), 1);
            return;
        }
          goto _L1
_L4:
        view = new VoidLabelFragment();
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.addToBackStack("voidFragment");
        fragmenttransaction.replace(0x7f100761, view, "label_void_fragment");
        fragmenttransaction.commit();
        return;
_L2:
        printPdf();
        return;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return (ViewGroup)layoutinflater.inflate(0x7f030238, viewgroup, false);
    }

    public void onResume()
    {
        super.onResume();
        if (android.os.Build.VERSION.SDK_INT >= 19 && DeviceConfiguration.getAsync().get(DcsBoolean.PslPrinting))
        {
            resumePrinting();
        }
    }

    public void setActionBarState()
    {
        hideDoneButton();
        setToolbarTitle(0x7f070872);
    }

    public void updateUI()
    {
        ShippingLabelActivity shippinglabelactivity = (ShippingLabelActivity)getActivity();
        if (shippinglabelactivity.shippingLabelDraft != null)
        {
            View view = getView();
            Object obj = shippinglabelactivity.shippingLabelDraft;
            view.setVisibility(0);
            ShippingOption shippingoption = shippinglabelactivity.selectedShippingService;
            Object obj1 = shippingoption.getEstimatedDeliveryDateString(shippinglabelactivity);
            boolean flag;
            if (obj1 != null)
            {
                ((TextView)view.findViewById(0x7f100768)).setText((new StringBuilder()).append(shippingoption.attributes.serviceName).append("\n").append(shippingoption.attributes.packageName).append("\n").append(((String) (obj1))).toString());
            } else
            {
                ((TextView)view.findViewById(0x7f100768)).setText((new StringBuilder()).append(shippingoption.attributes.serviceName).append("\n").append(shippingoption.attributes.packageName).toString());
            }
            obj1 = ((ShippingLabelDraft) (obj)).labelDetails.pkg.spec;
            obj1 = String.format("%s%s, %s%s x %s%s x %s%s", new Object[] {
                Double.toString(((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).weight.value), ((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).weight.unit.toLowerCase(Locale.getDefault()), Double.toString(((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).dimensionMeasure.length), ((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).dimensionMeasure.unit.toLowerCase(Locale.getDefault()), Double.toString(((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).dimensionMeasure.width), ((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).dimensionMeasure.unit.toLowerCase(Locale.getDefault()), Double.toString(((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).dimensionMeasure.height), ((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).dimensionMeasure.unit.toLowerCase(Locale.getDefault())
            });
            ((TextView)getView().findViewById(0x7f100769)).setText(((CharSequence) (obj1)));
            obj1 = ((ShippingLabelDraft) (obj)).labelDetails.from;
            flag = com.ebay.nautilus.domain.data.ShippingOption.ShippingCarrierType.FEDEX.name().equals(shippingoption.shippingKey.carrier.name());
            if (obj1 != null)
            {
                ((TextView)view.findViewById(0x7f10076d)).setText(ShippingLabelActivity.buildAddressString(((com.ebay.nautilus.domain.data.ShippingLabelContact) (obj1)), flag));
            }
            obj1 = ((ShippingLabelDraft) (obj)).labelDetails.to;
            if (obj1 != null)
            {
                ((TextView)view.findViewById(0x7f10076c)).setText(ShippingLabelActivity.buildAddressString(((com.ebay.nautilus.domain.data.ShippingLabelContact) (obj1)), flag));
            }
            obj1 = new StringBuilder();
            obj = ((ShippingLabelDraft) (obj)).labelDetails.sigConSelected;
            if (obj != null)
            {
                if (((String) (obj)).equals("true"))
                {
                    ((StringBuilder) (obj1)).append((new StringBuilder()).append(getString(0x7f070876)).append("\n").toString());
                } else
                {
                    Iterator iterator = shippingoption.attributes.sigConOptionsSupported.iterator();
                    while (iterator.hasNext()) 
                    {
                        com.ebay.nautilus.domain.data.ShippingOption.ShippingAttributes.ShippingConfirmationOptions shippingconfirmationoptions = (com.ebay.nautilus.domain.data.ShippingOption.ShippingAttributes.ShippingConfirmationOptions)iterator.next();
                        if (shippingconfirmationoptions.optionToken.equals(obj))
                        {
                            ((StringBuilder) (obj1)).append((new StringBuilder()).append(shippingconfirmationoptions.optionDisplayValue).append("\n").toString());
                        }
                    }
                }
            }
            if (shippinglabelactivity.selectedInsuranceCoverage != null)
            {
                ((StringBuilder) (obj1)).append((new StringBuilder()).append(getString(0x7f070847)).append("\n").toString());
            }
            if (shippinglabelactivity.showCustomMessage)
            {
                ((StringBuilder) (obj1)).append((new StringBuilder()).append(getString(0x7f070862)).append("\n").toString());
            }
            if (((StringBuilder) (obj1)).length() == 0)
            {
                view.findViewById(0x7f10076b).setVisibility(8);
                view.findViewById(0x7f10076a).setVisibility(8);
            } else
            {
                ((TextView)view.findViewById(0x7f10076b)).setText(((StringBuilder) (obj1)).toString());
            }
            if (shippingoption.shippingKey.carrier.name().equals(com.ebay.nautilus.domain.data.ShippingOption.ShippingCarrierType.FEDEX.name()))
            {
                ((Button)view.findViewById(0x7f10076f)).setText(0x7f07082c);
                view.findViewById(0x7f100770).setVisibility(8);
            } else
            {
                view.findViewById(0x7f100770).setVisibility(0);
            }
        }
        getView().findViewById(0x7f10076f).setOnClickListener(this);
        getView().findViewById(0x7f100770).setOnClickListener(this);
        if (android.os.Build.VERSION.SDK_INT >= 19 && DeviceConfiguration.getAsync().get(DcsBoolean.PslPrinting))
        {
            getView().findViewById(0x7f10076e).setOnClickListener(this);
            return;
        } else
        {
            getView().findViewById(0x7f10076e).setVisibility(8);
            return;
        }
    }
}
