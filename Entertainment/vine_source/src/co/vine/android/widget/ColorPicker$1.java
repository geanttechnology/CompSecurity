// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;


// Referenced classes of package co.vine.android.widget:
//            ColorPicker, ColorPickerCircle

class val.index
    implements Runnable
{

    final ColorPicker this$0;
    final ColorPickerCircle val$circle;
    final int val$index;

    public void run()
    {
        val$circle.setIndex(val$index);
    }

    cle()
    {
        this$0 = final_colorpicker;
        val$circle = colorpickercircle;
        val$index = I.this;
        super();
    }
}
