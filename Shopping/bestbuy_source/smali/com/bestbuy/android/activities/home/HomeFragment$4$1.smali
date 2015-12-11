.class Lcom/bestbuy/android/activities/home/HomeFragment$4$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/HomeFragment$4;->run()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/HomeFragment$4;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/HomeFragment$4;)V
    .locals 0

    .prologue
    .line 338
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$4$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 341
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$4$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment$4;

    iget-object v1, v1, Lcom/bestbuy/android/activities/home/HomeFragment$4;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/home/WebViewActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 342
    const-string v1, "com.bestbuy.android.URL_TOBE_LOADED"

    const-string v2, "https://secure.opinionlab.com/ccc01/o.asp?id=UdgWGjJa"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 343
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$4$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment$4;

    iget-object v1, v1, Lcom/bestbuy/android/activities/home/HomeFragment$4;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->startActivity(Landroid/content/Intent;)V

    .line 344
    return-void
.end method
