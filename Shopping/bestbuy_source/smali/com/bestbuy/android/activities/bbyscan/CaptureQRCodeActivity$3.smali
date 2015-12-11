.class Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$3;
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
    .line 164
    iput-object p1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$3;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$3;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$3;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;Z)Z

    .line 170
    invoke-static {}, Lmj;->a()Lmj;

    move-result-object v0

    invoke-virtual {v0}, Lmj;->d()V

    .line 174
    :goto_0
    return-void

    .line 172
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$3;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-static {}, Lmj;->a()Lmj;

    move-result-object v1

    invoke-virtual {v1}, Lmj;->c()Z

    move-result v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;Z)Z

    goto :goto_0
.end method
