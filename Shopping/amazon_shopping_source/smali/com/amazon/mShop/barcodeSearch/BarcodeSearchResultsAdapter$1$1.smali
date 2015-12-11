.class Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1$1;
.super Ljava/lang/Object;
.source "BarcodeSearchResultsAdapter.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1;)V
    .locals 0

    .prologue
    .line 116
    iput-object p1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1$1;->this$1:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 119
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 120
    return-void
.end method
