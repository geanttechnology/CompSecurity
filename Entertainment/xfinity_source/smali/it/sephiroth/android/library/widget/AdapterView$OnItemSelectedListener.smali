.class public interface abstract Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;
.super Ljava/lang/Object;
.source "AdapterView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lit/sephiroth/android/library/widget/AdapterView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "OnItemSelectedListener"
.end annotation


# virtual methods
.method public abstract onItemSelected(Lit/sephiroth/android/library/widget/AdapterView;Landroid/view/View;IJ)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lit/sephiroth/android/library/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation
.end method

.method public abstract onNothingSelected(Lit/sephiroth/android/library/widget/AdapterView;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lit/sephiroth/android/library/widget/AdapterView",
            "<*>;)V"
        }
    .end annotation
.end method
