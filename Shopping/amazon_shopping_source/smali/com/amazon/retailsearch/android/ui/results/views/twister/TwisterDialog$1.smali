.class Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog$1;
.super Ljava/lang/Object;
.source "TwisterDialog.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->init(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->dismiss()V

    .line 57
    return-void
.end method
