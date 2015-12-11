.class Lcom/bestbuy/android/activities/home/HomeActivity$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/HomeActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/HomeActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/HomeActivity;)V
    .locals 0

    .prologue
    .line 234
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity$1;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 237
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$1;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 238
    return-void
.end method
