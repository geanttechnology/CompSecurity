.class Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment$1;->a:Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 42
    const-string v0, "http://www.bestbuy.com"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 43
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment$1;->a:Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment;->startActivity(Landroid/content/Intent;)V

    .line 45
    return-void
.end method
