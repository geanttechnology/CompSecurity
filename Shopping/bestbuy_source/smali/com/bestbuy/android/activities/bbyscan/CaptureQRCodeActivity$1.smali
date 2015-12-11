.class Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$1;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$1;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    sget v1, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->MANUAL_ENTER:I

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->setResult(I)V

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$1;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->finish()V

    .line 139
    return-void
.end method
