.class public Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;
.super Ljava/lang/Object;
.source "CALDialogFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/view/common/CALDialogFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CDFButton"
.end annotation


# instance fields
.field onClickListener:Landroid/content/DialogInterface$OnClickListener;

.field text:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    .locals 0
    .param p1, "text"    # Ljava/lang/String;
    .param p2, "onClickListener"    # Landroid/content/DialogInterface$OnClickListener;

    .prologue
    .line 72
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;->text:Ljava/lang/String;

    .line 74
    iput-object p2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;->onClickListener:Landroid/content/DialogInterface$OnClickListener;

    .line 75
    return-void
.end method
