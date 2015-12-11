.class Lcom/bestbuy/android/activities/stores/DialogSpinner$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/stores/DialogSpinner;->performClick()Z
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/stores/DialogSpinner;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/stores/DialogSpinner;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/DialogSpinner$1;->a:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/DialogSpinner$1;->a:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0, p2}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setSelection(I)V

    .line 29
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 30
    return-void
.end method
